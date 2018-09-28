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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IStatus;

/**
 * Represents a set of valid values for an attribute.
 */
public class AttributeValues {

	private final Set<Object> validValues = new LinkedHashSet<Object>();
	private boolean validValuesExclusive = false;
	private final Set<AttributeValuesRange> validRanges = new TreeSet<AttributeValuesRange>();
	private final List<IStatus> statusList = new ArrayList<IStatus>();

	/**
	 * Constructs a constraint satisfaction result.
	 * <p>
	 * The default constructor creates an empty set of valid values and sets
	 * {@link #isValidValuesExclusive()} to false.
	 */
	public AttributeValues() {
	}

	/**
	 * Construct a new satisfaction result.
	 * 
	 * @param validValues
	 *           a set of valid values (may be null).
	 * @param validValuesExclusive
	 *           true if the set of valid values contains all values, false if there are valid values
	 *           not contained in the set.
	 * @param validRanges
	 *           a set of valid ranges (may be null).
	 * @param statuses
	 *           a list of statuses (may be null).
	 */
	public AttributeValues(Set<Object> validValues, boolean validValuesExclusive,
			Set<AttributeValuesRange> validRanges, List<IStatus> statuses) {
		if (validValues != null) {
			this.validValues.addAll(validValues);
		}
		this.validValuesExclusive = validValuesExclusive;
		if (validRanges != null) {
			validRanges.addAll(validRanges);
		}
		if (statuses != null) {
			statusList.addAll(statuses);
		}
	}

	/**
	 * @return a mutable set of valid values for the attribute (never null).
	 */
	public Set<Object> getValidValues() {
		return validValues;
	}

	/**
	 * @return true if the set of values returned by {@link #getValidValues()} contains all the
	 *         possible values, false if there can be other valid values.
	 */
	public boolean isValidValuesExclusive() {
		return validValuesExclusive;
	}

	/**
	 * Sets the exclusivity of the valid values set.
	 * 
	 * @param exclusive
	 *           true if the valid values set contains all valid values, false otherwise.
	 */
	public void setValidValuesExclusive(boolean exclusive) {
		validValuesExclusive = exclusive;
	}

	/**
	 * Returns a set of valid value ranges.
	 * <p>
	 * When all valid values cannot be effectively enumerated, they can be represented by ranges. If
	 * ranges are specified, then {@link #isValidValuesExclusive()} will return false.
	 * 
	 * @return a mutable set of ranges of valid values (never null).
	 */
	public Set<AttributeValuesRange> getValidRanges() {
		return validRanges;
	}

	/**
	 * Compacts the set of ranges where overlaps occur.
	 * 
	 * @return true if the valid ranges have been changed.
	 */
	public boolean compactValidRanges() {
		boolean changed = false;

		// Clean up null and empty ranges
		for (Iterator<AttributeValuesRange> iter = validRanges.iterator(); iter.hasNext();) {
			AttributeValuesRange curr = iter.next();
			if (curr == null || curr.isEmpty()) {
				iter.remove();
				changed = true;
			}
		}

		if (validRanges.size() <= 1) {
			return false;
		}

		// Consolidate overlaps
		List<AttributeValuesRange> list = new ArrayList<AttributeValuesRange>(validRanges);
		Collections.sort(list);
		AttributeValuesRange prev = null;
		for (AttributeValuesRange curr : list) {
			if (prev != null) {
				if (prev.overlaps(curr)) {
					prev.add(curr);
					validRanges.remove(curr);
					changed = true;
				}
			} else {
				prev = curr;
			}
		}
		return changed;
	}

	/**
	 * Adds a status to the result.
	 * 
	 * @param status
	 *           a result status.
	 */
	public void addStatus(IStatus status) {
		statusList.add(status);
	}

	/**
	 * @return a mutable list of status reported (never null).
	 */
	public List<IStatus> getStatusList() {
		return statusList;
	}

	/**
	 * @return true if a status with severity {@link IStatus#ERROR} has been reported.
	 */
	public boolean hasErrors() {
		for (IStatus status : statusList) {
			if (status.getSeverity() == IStatus.ERROR) {
				return true;
			}
		}
		return false;
	}
}