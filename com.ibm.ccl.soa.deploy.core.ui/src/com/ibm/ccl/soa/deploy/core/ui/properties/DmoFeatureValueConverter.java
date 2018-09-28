/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.wst.common.internal.emf.utilities.DefaultFeatureValueConverter;
import org.eclipse.wst.common.internal.emf.utilities.WFTUtilsResourceHandler;

/**
 * Version of {@link DefaultFeatureValueConverter} with support for {@link BigInteger}.
 * 
 * @author Ed Snible
 */
public class DmoFeatureValueConverter extends DefaultFeatureValueConverter {

	protected Object convertValue(Object aValue, EAttribute anAttribute) {

		try {
			EClassifier meta = anAttribute.getEType();
			if (meta.eClass() == EcorePackage.eINSTANCE.getEEnum()) {
				return convertToEnum(aValue, anAttribute);
			}
			if (meta.getEPackage() instanceof EcorePackage) {
				switch (meta.getClassifierID())
				{
				case EcorePackage.EBIG_INTEGER:
					return convertToBigInteger(aValue);
				default:
					return super.convertValue(aValue, anAttribute);
				}
			}
			return super.convertValue(aValue, anAttribute);
		} catch (NumberFormatException e) {
			return parse(aValue, anAttribute);
		}
	}

	private Object convertToBigInteger(Object aValue) {
		if (aValue instanceof String) {
			try {
				return new BigInteger((String) aValue);
			} catch (NumberFormatException nfe) {
				return defaultBigInteger();
			}
		} else if (aValue instanceof BigInteger) {
			return aValue;
		}

		return failedToConvert(aValue, WFTUtilsResourceHandler.Integer_UI_); // TODO define BigInteger_UI
	}

	protected Object defaultBigInteger() {
		return null; // Defect 6369 -- allow unsetting
	}

	protected Object parse(Object aValue, EAttribute anAttribute) {
		if (aValue instanceof String) {
			StringBuffer value = new StringBuffer();
			value.append(aValue);

			Pattern composite = Pattern.compile("\\d*\\s*\\w*"); //$NON-NLS-1$
			Matcher entryMatcher = composite.matcher(value);

			if (entryMatcher.matches()) {

				Pattern digitsPattern = Pattern.compile("\\d*"); //$NON-NLS-1$
				Matcher digitsMatcher = digitsPattern.matcher(value);

				String numbers = digitsMatcher.group();

				Pattern suffixPattern = Pattern.compile("\\w*"); //$NON-NLS-1$
				Matcher suffixMatcher = suffixPattern.matcher(value);

				String suffix = suffixMatcher.group();

				System.out.println("Number: " + numbers + " Units: " + suffix); //$NON-NLS-1$ //$NON-NLS-2$

				return convertValue(numbers, anAttribute);
			}
		}
		// no love
		return null;
	}

} // end class DmoFeatureValueConverter
