package com.ibm.ccl.soa.deploy.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.ccl.soa.deploy.core.Multiplier.Converter;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Understands metric prefixes use 1024 as a base.
 * 
 */
public enum MemoryMultiplier implements Multiplier.Converter {

	/**
	 * Kilo - 10x3
	 */
	KILO('K', 1024),

	/**
	 * Mega - 10x6
	 */
	MEGA('M', 1024 * KILO.power),

	/**
	 * Giga - 10x9
	 */
	GIGA('G', 1024 * MEGA.power),

	/**
	 * Tera - 10x12
	 */
	TERA('T', 1024 * GIGA.power),

	/**
	 * Peta - 10x15
	 */
	PETA('P', 1024 * TERA.power),

	/**
	 * Exa - 10x18
	 */
	EXA('E', 1024 * PETA.power);

	private static final String TRANSLATED_BYTE = DeployCoreMessages.MemoryMultiplier_byt_;
	private static final String TRANSLATED_BYTES = DeployCoreMessages.MemoryMultiplier_byte_;

	private static final Pattern MULTIPLIER_PATTERN = Pattern
			.compile("[kKmMgGtTpPeE](\\w{2}|\\w{3})?([bB]|" + TRANSLATED_BYTE + "|" + TRANSLATED_BYTES + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	private static final Class<String> STRING_CLASS = String.class;

	/**
	 * Create converters based on the multipliers associated with memory.
	 * 
	 */
	public static class Factory implements Multiplier.Factory {
		/**
		 * Creates the associated multiplier for the given input.
		 * 
		 * @param input
		 *           A string beginning with one of the metric prefix chars in upper or lower case.
		 * @return The multiplier associated with the given input or null if none.
		 */
		public Converter create(String input) {

			Matcher matcher = MULTIPLIER_PATTERN.matcher(input);
			if (matcher.find()) {
				String pre = matcher.group();
				if (pre.length() > 1) {
					switch (pre.charAt(0))
					{
					case 'k':
					case 'K':
						return KILO;
					case 'm':
					case 'M':
						return MEGA;
					case 'g':
					case 'G':
						return GIGA;
					case 't':
					case 'T':
						return TERA;
					case 'p':
					case 'P':
						return PETA;
					case 'e':
					case 'E':
						return EXA;
					}
				}
			}
			return null;
		}

	}

	private char prefix;
	private long power;

	private MemoryMultiplier(char pre, long pow) {
		prefix = pre;
		power = pow;
	}

	/**
	 * Return the single capitalized letter prefix associated with this enum instance.
	 * 
	 * @return The single capitalized letter prefix associated with this enum instance.
	 */
	public char getPrefix() {
		return prefix;
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
		Number result = null;
		Double value = num.doubleValue();
		result = create(num.getClass(), value / power);
		return result;
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
		Number result = null;
		Double value = num.doubleValue();
		result = create(num.getClass(), value * power);
		return result;
	}

	private Number create(Class<? extends Number> clazz, double d) {
		try {

			Constructor<? extends Number> constructor = clazz.getConstructor(STRING_CLASS);
			String formatted = Multiplier.STD_FORMAT.format(d);
			return constructor.newInstance(formatted);
		} catch (RuntimeException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
//			e.printStackTrace();
		} catch (NoSuchMethodException e) {
		}
		return Double.valueOf(d);
	}
}
