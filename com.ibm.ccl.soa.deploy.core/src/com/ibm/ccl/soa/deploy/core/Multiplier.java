package com.ibm.ccl.soa.deploy.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * An enumeration that understands basic metric conversions.
 * 
 */
public class Multiplier {

	/**
	 * Standard Numerical Format
	 */
	public static final DecimalFormat STD_FORMAT = new DecimalFormat("#.#"); //$NON-NLS-1$

	/**
	 * Create a factory that can define {@link Converter}s.
	 * 
	 */
	public static interface Factory {

		/**
		 * Create a converter for the given input or return null if the input fails to meet the
		 * necessary criteria.
		 * 
		 * @param input
		 *           The String input, e.g. "Mb", "Mhz", "Megahertz"
		 * @return A converter for the given input or return null if the input fails to meet the
		 *         necessary criteria.
		 */
		public Converter create(String input);

	}

	/**
	 * Defines a standard interface for Converteds to take a numerical input and format it
	 * appropriately based on a previously determined unit of measure.
	 * 
	 */
	public static interface Converter {
		/**
		 * Convert the numerical value using the prefix for this enumeration.
		 * 
		 * @param num
		 *           The user-displayable value
		 * @return The converted user-displayable value based on the multiplier assigned to this enum
		 *         instance.
		 */
		public Number convert(Number num);

		/**
		 * Deconvert the inflated numerical value to a user-displayable string using the prefix for
		 * this enumeration.
		 * 
		 * @param num
		 *           The raw value
		 * @return The deconverted raw value based on the multiplier assigned to this enum instance.
		 */
		public Number deconvert(Number num);

	}

	private static List<Multiplier.Factory> factories = new ArrayList<Multiplier.Factory>(3);

	static {
		factories.add(new MemoryMultiplier.Factory());
		factories.add(new MetricMultiplier.Factory());

	}

	/**
	 * Creates the associated multiplier for the given input.
	 * 
	 * @param input
	 *           A string beginning with one of the metric prefix chars in upper or lower case.
	 * @return The multiplier associated with the given input or null if none.
	 */
	public static Multiplier create(String input) {
		Converter converter = null;
		for (Multiplier.Factory factory : factories) {
			converter = factory.create(input);
			if (converter != null) {
				return new Multiplier(converter);
			}
		}
		return null;
	}

	private static final Class<String> STRING_CLASS = String.class;

	private final Multiplier.Converter converter;

	private Multiplier(Multiplier.Converter newConverter) {
		converter = newConverter;
	}

	/**
	 * Convert the numerical value using the prefix for this enumeration.
	 * 
	 * @param num
	 *           The user-displayable value
	 * @return The converted user-displayable value based on the multiplier assigned to this enum
	 *         instance.
	 */
	public Number convert(Number num) {
		return converter.convert(num);
	}

	/**
	 * Deconvert the inflated numerical value to a user-displayable string using the prefix for this
	 * enumeration.
	 * 
	 * @param num
	 *           The raw value
	 * @return The deconverted raw value based on the multiplier assigned to this enum instance.
	 */
	public Number deconvert(Number num) {
		return converter.deconvert(num);
	}

	/**
	 * Instantiate a number in the given class for the given double.
	 * 
	 * @param clazz
	 *           The expected return type
	 * @param d
	 *           The value to push into the new class.
	 * @return The instantiated number.
	 */
	public static Number create(Class<? extends Number> clazz, double d) {
		try {
			Constructor<? extends Number> constructor = clazz.getConstructor(STRING_CLASS);
			String formatted = STD_FORMAT.format(d);
			return constructor.newInstance(formatted);
		} catch (RuntimeException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}
		return Double.valueOf(d);
	}
}
