package com.ibm.ccl.soa.deploy.core;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * A utility class for converting numerical values stored as metric-summarized numbers.
 */
public class ConvertedValue {

	// I think this is the pattern for numbers like 2,048MB
	//"[-+]?((\\d{1,3})[\\.|,]?)+\\d*([Ee]?[-+]?\\d+)?"; //$NON-NLS-1$
	private static final String NUMBERS_PATTERN = "[-+]?((\\d{1,3})[\\.|,]?)+\\d*([Ee]?[-+]?\\d+)?"; //$NON-NLS-1$
	private static final String WORD_PATTERN = "\\s*[A-DF-Za-df-z]?[\\s\\D]*$"; //$NON-NLS-1$ 

	private static final Pattern COMPOSITE = Pattern.compile(NUMBERS_PATTERN + WORD_PATTERN);
	private static final Pattern DIGITS_PATTERN = Pattern.compile(NUMBERS_PATTERN);
	private static final Pattern SUFFIX_PATTERN = Pattern.compile(WORD_PATTERN);

	/**
	 * Parse the given value into the {@link EDataType} components and its suffix.
	 * 
	 * @param aValue
	 *           The raw value to be set in the attribute
	 * @param anAttribute
	 *           The destined attribute for the given value
	 * @return The return {@link ConvertedValue} result with the converted value and suffix set or
	 *         null if the String can't be understood.
	 */
	public static ConvertedValue parse(String aValue, EAttribute anAttribute) {
		return parse(aValue, anAttribute.getEAttributeType());
	}

	/**
	 * Parse the given value into the {@link EDataType} components and its suffix.
	 * 
	 * @param aValue
	 *           The raw value to be set in the attribute
	 * @param expectedType
	 *           The destined attribute for the given value
	 * @return The return {@link ConvertedValue} result with the converted value and suffix set or
	 *         null if the String can't be understood.
	 */
	public static ConvertedValue parse(String aValue, EDataType expectedType) {
		ConvertedValue cValue = new ConvertedValue();
		StringBuffer value = new StringBuffer();
		value.append(aValue);

		Matcher entryMatcher = COMPOSITE.matcher(value);

		if (entryMatcher.find()) {

			String numbers = null;
			String suffix = null;

			String match = entryMatcher.group();

			Matcher digitsMatcher = DIGITS_PATTERN.matcher(match);
			if (digitsMatcher.find()) {
				numbers = digitsMatcher.group();
			}

			if (match.length() > numbers.length()) {
				Matcher suffixMatcher = SUFFIX_PATTERN.matcher(match.substring(numbers.length()));

				if (suffixMatcher.find()) {
					suffix = suffixMatcher.group();
				}
			}

			try {
				// we go through two phases to avoid strings like "1.0" generating  
				// errors when converted to integral values
				Number preconversion = NumberFormat.getNumberInstance().parse(numbers);
				String formatted = Multiplier.STD_FORMAT.format(preconversion);

				cValue.setConvertedValue((Number) EcoreUtil.createFromString(expectedType, formatted));
			} catch (Exception e) {
				cValue.setConvertedValue(0);
			}
			cValue.setUnits(suffix);
			return cValue;
		} else {
			try {
				cValue.setConvertedValue((Number) EcoreUtil.createFromString(expectedType, aValue));
			} catch (Exception e) {

				cValue.setConvertedValue(0);
			}
			cValue.setUnits(IConstants.EMPTY_STRING);
		}
		return cValue;
	}

	/**
	 * Return the converted value for the given model object and attribute or null if no Units are
	 * available.
	 * 
	 * @param dmo
	 *           The model object containing the property
	 * @param propertyName
	 *           The property that might have measureable units stored and thus require conversion of
	 *           its raw value.
	 * @return The converted value for the given model object and attribute or null if no Units are
	 *         available.
	 */
	public static ConvertedValue getConvertedValue(DeployModelObject dmo, EAttribute propertyName) {
		Object temp = dmo.eGet(propertyName);
		ConvertedValue cValue = null;
		String units = IConstants.EMPTY_STRING;
		AttributeMetaData attributeMetaData = dmo.getAttributeMetaData(propertyName.getName());
		if (attributeMetaData != null && attributeMetaData.getDescription() != null) {
			units = attributeMetaData.getDescription();
			if (temp instanceof Number) {
				cValue = new ConvertedValue();
				cValue.setRawValue((Number) temp);
				cValue.setUnits(units);

			}
		}
		return cValue;
	}

	/**
	 * Remove any metadata associated with the property to store units.
	 * 
	 * Requires an enclosing EMF Tranaction to modify the model.
	 * 
	 * @param dmo
	 *           The model unit that has associated measurement units.
	 * @param propertyName
	 *           The property of that model unit with measurement units.
	 */
	public static void clearMetadata(DeployModelObject dmo, EAttribute propertyName) {
		AttributeMetaData metadata = dmo.getAttributeMetaData(propertyName.getName());
		if (metadata != null) {
			metadata.setDescription(null);
		}
		// TODO Remove the AMD if there's no further information in the object.
	}

	/**
	 * The raw value of attribute.
	 * 
	 * At least one of {@link #convertedValue} or {{@link #rawValue} must be set.
	 */
	private Number rawValue;

	/**
	 * The converted value of the attribute.
	 * 
	 * At least one of {@link #convertedValue} or {{@link #rawValue} must be set.
	 */
	private Number convertedValue;

	/**
	 * An arbitrary string whose first valid character must match one of the prefix characters
	 * available in the {@link Multiplier} enumeration.
	 */
	private String units;

	/**
	 * Convert the value and the given units to the raw value
	 * 
	 * @return The user displayable value.
	 */
	public Number convert() {
		if (getConvertedValue() == null && getRawValue() != null) {
			if (getUnits() != null) {
				Multiplier multiplier = Multiplier.create(getUnits());
				if (multiplier != null) {
					setConvertedValue(multiplier.convert(getRawValue()));
				}
			}
		}
		return getConvertedValue() != null ? getConvertedValue() : getRawValue();
	}

	/**
	 * Deconvert the value and the given units to the raw value
	 * 
	 * @return The user displayable value.
	 */
	public Number deconvert() {
		if (getRawValue() == null && getConvertedValue() != null) {
			if (getUnits() != null) {
				Multiplier multiplier = Multiplier.create(getUnits());
				if (multiplier != null) {
					setRawValue(multiplier.deconvert(getConvertedValue()));
				}
			}
		}
		return getRawValue() != null ? getRawValue() : getConvertedValue();
	}

	/**
	 * Create and configure the {@link AttributeMetaData} for this {@link ConvertedValue}.
	 * 
	 * Requires an enclosing EMF Tranaction to modify the model.
	 * 
	 * @param dmo
	 *           The model object to configure
	 * @param propertyName
	 *           The property which has measurement units to store in the metadata.
	 * @return The configured {@link AttributeMetaData} for this {@link ConvertedValue}.
	 */
	public AttributeMetaData instantiate(DeployModelObject dmo, EAttribute propertyName) {
		AttributeMetaData metaData = DeployModelObjectUtil.getOrCreateAttributeMetaData(dmo,
				propertyName.getName());
		metaData.setDescription(getUnits());
		return metaData;
	}

	@Override
	public String toString() {
		return convert() + (getUnits() != null ? getUnits() : IConstants.EMPTY_STRING);
	}

	/**
	 * The raw value of attribute.
	 * 
	 * At least one of convertedValue or rawValue must be set.
	 * 
	 * @param newRawValue
	 * 
	 *           The raw value of attribute.
	 */
	public void setRawValue(Number newRawValue) {
		rawValue = newRawValue;
		convertedValue = null;
	}

	/**
	 * The raw value of attribute.
	 * 
	 * At least one of convertedValue or rawValue must be set.
	 * 
	 * @return The raw value of attribute.
	 */
	public Number getRawValue() {
		return rawValue;
	}

	/**
	 * The converted value of the attribute.
	 * 
	 * At least one of convertedValue or rawValue must be set.
	 * 
	 * @param newConvertedValue
	 *           The converted value of the attribute.
	 */
	public void setConvertedValue(Number newConvertedValue) {
		convertedValue = newConvertedValue;
		rawValue = null;
	}

	/**
	 * The converted value of the attribute.
	 * 
	 * At least one of convertedValue or rawValue must be set.
	 * 
	 * @return The converted value of the attribute.
	 */
	public Number getConvertedValue() {
		return convertedValue;
	}

	/**
	 * Return the measurement units of the Converted Value or the empty String
	 * 
	 * @return The measurement units of the Converted Value or the empty String
	 */
	public String getUnits() {
		return units != null ? units : IConstants.EMPTY_STRING;
	}

	/**
	 * An arbitrary string whose first valid character must match one of the prefix characters
	 * available in the {@link Multiplier} enumeration.
	 * 
	 * @param newUnits
	 *           A string representation of the unit of measurement for this Converted Value
	 */
	public void setUnits(String newUnits) {
		units = newUnits;
		if (rawValue != null && convertedValue != null) {
			// wipe out the convertedValue
			convertedValue = null;
		}
	}
}