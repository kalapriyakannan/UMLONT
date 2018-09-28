/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;

/**
 * Accepts {@link Requirement} objects based on their {@link Requirement#getLinkType()} value.
 */
public class RequirementLinkTypeFilter implements IObjectFilter<Requirement> {

	/** Bit-mask value for {@link RequirementLinkTypes#ANY}. */
	public static final int ANY = 1;

	/** Bit-mask value for {@link RequirementLinkTypes#HOSTING}. */
	public static final int HOSTING = 2;

	/** Bit-mask value for {@link RequirementLinkTypes#DEPENDENCY}. */
	public static final int DEPENDENCY = 4;

	/** Bit-mask value for {@link RequirementLinkTypes#MEMBER}. */
	public static final int MEMBER = 8;

	/** Bit-mask value for all enumerations of {@link RequirementLinkTypes}. */
	public static final int ALL_TYPE_ENUMERATORS = ANY | HOSTING | DEPENDENCY | MEMBER;

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#HOSTING} or
	 * {@link RequirementLinkTypes#ANY}.
	 */
	public static final RequirementLinkTypeFilter ANY_OR_HOSTING_FILTER = new RequirementLinkTypeFilter(
			ANY | HOSTING);

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#ANY}.
	 */
	public static final RequirementLinkTypeFilter ANY_FILTER = new RequirementLinkTypeFilter(ANY);

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#DEPENDENCY}.
	 */
	public static final RequirementLinkTypeFilter DEPENDENCY_FILTER = new RequirementLinkTypeFilter(
			DEPENDENCY);

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#MEMBER}.
	 */
	public static final RequirementLinkTypeFilter MEMBER_FILTER = new RequirementLinkTypeFilter(
			MEMBER);

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#ANY}. or
	 * {@link RequirementLinkTypes#DEPENDENCY}.
	 */
	public static final RequirementLinkTypeFilter ANY_OR_DEPENDENCY_FILTER = new RequirementLinkTypeFilter(
			ANY | DEPENDENCY);

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#ANY}. or
	 * {@link RequirementLinkTypes#MEMBER}.
	 */
	public static final RequirementLinkTypeFilter ANY_OR_MEMBER_FILTER = new RequirementLinkTypeFilter(
			ANY | MEMBER);

	/**
	 * Filters objects that are instances of {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#HOSTING}.
	 */
	public static final RequirementLinkTypeFilter HOSTING_FILTER = new RequirementLinkTypeFilter(
			HOSTING);

	/** Mask used for filtering. */
	private final int mask;

	/**
	 * Construct a requirement link type filter for the specified mask.
	 * 
	 * @param mask
	 *           a mask on the {@link Requirement#getLinkType()} value (one of #ANY, #HOSTING,
	 *           #DEPENDENCY, #ALL_TYPE_ENUMERATORS).
	 */
	public RequirementLinkTypeFilter(int mask) {
		if ((mask & ~ALL_TYPE_ENUMERATORS) != 0) {
			throw new IllegalArgumentException(Integer.toString(mask));
		}
		this.mask = mask;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.util.ObjectFilter#accept(java.lang.Object)
	 */
	public boolean accept(Requirement value) {
		if (!(value instanceof Requirement)) {
			return false;
		}
		Requirement req = value;
		RequirementLinkTypes linkType = req.getLinkType();
		if (linkType == null) {
			return false;
		}
		if ((mask & ANY) != 0 && linkType == RequirementLinkTypes.ANY_LITERAL) {
			return true;
		}
		if ((mask & HOSTING) != 0 && linkType == RequirementLinkTypes.HOSTING_LITERAL) {
			return true;
		}
		if ((mask & DEPENDENCY) != 0 && linkType == RequirementLinkTypes.DEPENDENCY_LITERAL) {
			return true;
		}
		if ((mask & MEMBER) != 0 && linkType == RequirementLinkTypes.MEMBER_LITERAL) {
			return true;
		}

		return false;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof RequirementLinkTypeFilter)) {
			return false;
		}

		return mask == ((RequirementLinkTypeFilter) obj).mask;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return mask;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("RequirementLinkTypeFilter["); //$NON-NLS-1$

		boolean hasPrev = false;
		if ((mask & ANY) != 0) {
			buffer.append(RequirementLinkTypes.ANY_LITERAL.getName());
			hasPrev = true;
		}
		if ((mask & HOSTING) != 0) {
			if (hasPrev) {
				buffer.append(", ");//$NON-NLS-1$
			}
			buffer.append(RequirementLinkTypes.HOSTING_LITERAL.getName());
			hasPrev = true;
		}
		if ((mask & DEPENDENCY) != 0) {
			if (hasPrev) {
				buffer.append(", ");//$NON-NLS-1$
			}
			buffer.append(RequirementLinkTypes.DEPENDENCY_LITERAL.getName());
			hasPrev = true;
		}
		if ((mask & MEMBER) != 0) {
			if (hasPrev) {
				buffer.append(", ");//$NON-NLS-1$
			}
			buffer.append(RequirementLinkTypes.MEMBER_LITERAL.getName());
			hasPrev = true;
		}

		buffer.append("]"); //$NON-NLS-1$

		return buffer.toString();
	}
}
