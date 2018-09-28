/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * Represents a range of valid attribute values.
 * <p>
 * The {@link Comparable} interface is used to support non-numeric value ranges.
 */
public class AttributeValuesRange implements Comparable<AttributeValuesRange> {

	Comparable min;
	boolean minInclusive;
	Comparable max;
	boolean maxInclusive;

	/**
	 * Construct an attribute value range.
	 * 
	 * @param min
	 *           the minimum value (may be null to represent the MIN value).
	 * @param minInclusive
	 *           true if the minimum value is included in the range.
	 * @param max
	 *           the maximum value (may be null to represent the MAX value).
	 * @param maxInclusive
	 *           true if the maximum value is included in the range.
	 */
	public AttributeValuesRange(Comparable min, boolean minInclusive, Comparable max,
			boolean maxInclusive) {
		this.min = min;
		this.max = max;
		this.minInclusive = minInclusive;
		this.maxInclusive = maxInclusive;
	}

	/**
	 * @return the minimum value in the range.
	 * @see #isMinInclusive()
	 */
	public Comparable getMin() {
		return min;
	}

	/**
	 * @return the maximum value in the range.
	 * @see #isMaxInclusive()
	 */
	public Comparable getMax() {
		return max;
	}

	/**
	 * @return return true if the minimum value is included in the range.
	 */
	public boolean isMinInclusive() {
		return minInclusive;
	}

	/**
	 * @return return false if the minimum value is included in the range.
	 */
	public boolean isMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * Returns true if the value is in the range.
	 * 
	 * @param value
	 *           a value which is comparable to the min and max.
	 * @return true if the value is in the range, false otherwise.
	 */
	public boolean isValueInRange(Comparable value) {
		if (value == null) {
			return min == null;
		}
		// ... min ... max ...
		if (min != null) {
			int result = value.compareTo(min);
			if (result < 0) {
				// value < min
				return false;
			} else if (result == 0) {
				if (!minInclusive) {
					// min == value but min is not in set
					return false;
				}
			}
		} // otherwise null implies lower bound met

		if (max == null) {
			return true;
		}
		int result = max.compareTo(value);
		if (result > 0) {
			// max > value
			return true;
		}
		if (result == 0) {
			return maxInclusive;
		}
		return false;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof AttributeValuesRange)) {
			return false;
		}
		AttributeValuesRange r2 = (AttributeValuesRange) object;

		Comparable min1 = minInclusive ? min : nextValue(min);
		Comparable min2 = r2.minInclusive ? r2.min : nextValue(r2.min);
		if (!ValidatorUtils.equals(min1, min2)) {
			return false;
		}
		Comparable max1 = maxInclusive ? max : prevValue(max);
		Comparable max2 = r2.maxInclusive ? r2.max : prevValue(r2.max);
		return ValidatorUtils.equals(max1, max2);
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int code = 0;
		if (min != null) {
			if (minInclusive) {
				code ^= min.hashCode();
			} else {
				code ^= nextValue(min).hashCode();
			}
		}
		if (max != null) {
			if (maxInclusive) {
				code ^= max.hashCode();
			} else {
				code ^= prevValue(max).hashCode();
			}
		}
		return code;
	}

	/**
	 * Returns true if the two ranges overlap.
	 * 
	 * @param r2
	 *           a second range.
	 * @return true if this range overlaps with the other range.
	 */
	public boolean overlaps(AttributeValuesRange r2) {
		if (r2 == null) {
			return false;
		}
		if (equals(r2)) {
			return true;
		}
		int minC = compareMinValues(r2);
		if (minC == 0) {
			return true;
		}
		if (minC < 0) {
			// this.min < r2.min: check if this.max >= r2.min
			if (max == null) {
				return true;
			}
			if (r2.min == null) {
				return false;
			}
			int c = max.compareTo(r2.min);
			if (c == 0) {
				return maxInclusive && r2.minInclusive;
			}
			return c > 0;
		} else {
			// r2.min < this.min: check if r2.max >= this.min 
			if (r2.max == null) {
				return true;
			}
			if (min == null) {
				return false;
			}
			int c = r2.max.compareTo(min);
			if (c == 0) {
				return r2.maxInclusive && minInclusive;
			}
			return c > 0;
		}
	}

	/**
	 * Adds the range to this range.
	 * 
	 * @param r2
	 *           an attribute value range.
	 * @return true if this range has changed.
	 */
	public boolean add(AttributeValuesRange r2) {
		if (r2 == null || equals(r2)) {
			return true;
		}
		boolean changed = false;
		int minC = compareMinValues(r2);
		if (minC > 0) {
			// this.min > r2.min
			min = r2.min;
			minInclusive = r2.minInclusive;
			changed = true;
		}
		int maxC = compareMaxValues(r2);
		if (maxC < 0) {
			// this.max < r2.max
			max = r2.max;
			maxInclusive = r2.maxInclusive;
			changed = true;
		}
		return changed;
	}

	/**
	 * Subtracts a range to this range.
	 * 
	 * @param r2
	 *           an attribute value range.
	 * @return true if this range has changed.
	 */
	public boolean subtract(AttributeValuesRange r2) {
		if (r2 == null) {
			return false;
		}
		if (isEmpty()) {
			return false;
		}
		if (!overlaps(r2)) {
			return false;
		}
		if (equals(r2)) {
			min = max;
			minInclusive = maxInclusive = false;
			return true;
		}
		boolean changed = false;
		int minC = compareMinValues(r2);
		if (minC < 0) {
			// this.min < r2.min
			min = r2.min;
			minInclusive = r2.minInclusive;
			changed = true;
		}
		int maxC = compareMaxValues(r2);
		if (maxC > 0) {
			// this.max > r2.max
			max = r2.max;
			maxInclusive = r2.maxInclusive;
			changed = true;
		}
		return changed;
	}

	/**
	 * Returns true if the range is empty.
	 * <p>
	 * A range is empty when the min and max values are equal and non inclusive.
	 * 
	 * @return true if the range is empty.
	 */
	public boolean isEmpty() {
		if (min == null || max == null) {
			return false;
		}
		int c = min.compareTo(max);
		if (c == 0) {
			// Empty if either endpoint is not inclusive [0, 0)
			return !minInclusive || !maxInclusive;
		}
		if (c > 0) {
			return true;
		}
		if (!minInclusive && !maxInclusive && nextValue(min).equals(max)) {
			return true;
		}
		return false;
	}

	/**
	 * Compares the minimum value of the range with that of the other range.
	 * <p>
	 * Treats null min values as the smallest value.
	 * 
	 * @param o
	 *           an attribute value range.
	 * @return -1, 0, +1 if this object is smaller than, equals, or greater than the range parameter
	 *         object.
	 */
	public int compareMinValues(AttributeValuesRange o) {
		if (o == null) {
			return 1;
		}
		return compare(minInclusive ? min : nextValue(min),
				o.minInclusive ? o.min : nextValue(o.min), true);
	}

	/**
	 * Compares the maximum value of the range with that of the other range.
	 * <p>
	 * Treats null max values as the largest value.
	 * 
	 * @param o
	 *           an attribute value range.
	 * @return -1, 0, +1 if this object is smaller than, equals, or greater than the range parameter
	 *         object.
	 */
	public int compareMaxValues(AttributeValuesRange o) {
		if (o == null) {
			return -1;
		}
		return compare(maxInclusive ? max : prevValue(max),
				o.maxInclusive ? o.max : prevValue(o.max), false);
	}

	/**
	 * Returns the previous value of a comparable if one can be determined.
	 * 
	 * @param o
	 *           a comparable object.
	 * @return the previous value if it can be determined, or the parameter object if it cannot.
	 */
	public static Comparable prevValue(Comparable o) {
		if (o == null) {
			return null;
		}
		if (o instanceof Short) {
			Short s = (Short) o;
			if (s != Short.MIN_VALUE) {
				return s - 1;
			}
		} else if (o instanceof Integer) {
			Integer i = (Integer) o;
			if (i != Integer.MIN_VALUE) {
				return i - 1;
			}
		} else if (o instanceof Long) {
			Long l = (Long) o;
			if (l != Long.MIN_VALUE) {
				return l - 1;
			}
		} else if (o instanceof BigInteger) {
			BigInteger b = (BigInteger) o;
			return b.subtract(BigInteger.ONE);
		} else if (o instanceof String) {
			String s = (String) o;
			if (s.length() != 0) {
				char[] result = new char[s.length()];
				boolean carry = true;
				for (int i = s.length() - 1; i >= 0; i--) {
					char c = s.charAt(i);
					if (carry) {
						if (c > Character.MIN_VALUE) {
							result[i] = (char) (c - 1);
							carry = false;
						} else {
							result[i] = Character.MAX_VALUE;
						}
					} else {
						result[i] = c;
					}
				}
				if (carry) {
					return s.substring(0, s.length() - 1);
				} else {
					return new String(result);
				}
			}
		}
		return o;
	}

	/**
	 * Returns the next value of a comparable if one can be determined.
	 * 
	 * @param o
	 *           a comparable object.
	 * @return the next value if it can be determined, or the parameter object if it cannot.
	 */
	public static Comparable nextValue(Comparable o) {
		if (o == null) {
			return null;
		}
		if (o instanceof Short) {
			Short s = (Short) o;
			if (s != Short.MAX_VALUE) {
				return s + 1;
			}
		} else if (o instanceof Integer) {
			Integer i = (Integer) o;
			if (i != Integer.MAX_VALUE) {
				return i + 1;
			}
		} else if (o instanceof Long) {
			Long l = (Long) o;
			if (l != Long.MAX_VALUE) {
				return l + 1;
			}
		} else if (o instanceof BigInteger) {
			BigInteger b = (BigInteger) o;
			return b.add(BigInteger.ONE);
		} else if (o instanceof String) {
			String s = (String) o;
			if (s.length() != 0) {
				char[] result = new char[s.length()];
				boolean carry = true;
				for (int i = s.length() - 1; i >= 0; i--) {
					char c = s.charAt(i);
					if (carry) {
						if (c < Character.MAX_VALUE) {
							result[i] = (char) (c + 1);
							carry = false;
						} else {
							result[i] = Character.MIN_VALUE;
						}
					} else {
						result[i] = c;
					}
				}
				if (carry) {
					return s + Character.toString(Character.MIN_VALUE);
				} else {
					return new String(result);
				}
			} else {
				return Character.toString(Character.MIN_VALUE);
			}
		}
		return o;
	}

	/**
	 * Compares the two comparable object values treating null as a valid value.
	 * <p>
	 * 
	 * @param o1
	 *           the first value (may be null)
	 * @param o2
	 *           the second value (may be null)
	 * @param nullIsMin
	 *           true if null should be treated as the smallest value, false as the largest.
	 * @return -1, 0, +1 if the first object is smaller than, equals, or greater than the second
	 *         object.
	 */
	public static int compare(Comparable o1, Comparable o2, boolean nullIsMin) {
		if (o1 == o2) {
			return 0;
		}
		if (o1 == null) {
			return nullIsMin ? -1 : 1;
		}
		if (o2 == null) {
			return nullIsMin ? 1 : -1;
		}

		return o1.compareTo(o2);
	}

	/**
	 * Compares two ranges.
	 * <p>
	 * A range is smaller than another range if its minimum is smaller, or if their minimums are
	 * equal and its maximum is smaller.
	 */
	public int compareTo(AttributeValuesRange o) {
		int minCompare = compareMinValues(o);
		if (minCompare != 0) {
			return minCompare;
		}
		return compareMaxValues(o);

	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (minInclusive) {
			buffer.append('[');
		} else {
			buffer.append('(');
		}
		if (min != null) {
			buffer.append(min);
		}
		buffer.append(',');
		if (max != null) {
			buffer.append(max);
		}
		if (maxInclusive) {
			buffer.append(']');
		} else {
			buffer.append(')');
		}

		return buffer.toString();
	}
}