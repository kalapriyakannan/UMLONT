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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;

/**
 * Accepts {@link Capability} objects based on their {@link Capability#getLinkType()} value.
 */
public class CapabilityLinkTypeFilter implements IObjectFilter<Capability> {

	/** Bit-mask value for {@link CapabilityLinkTypes#ANY}. */
	public static final int ANY = 1;

	/** Bit-mask value for {@link CapabilityLinkTypes#HOSTING}. */
	public static final int HOSTING = 2;

	/** Bit-mask value for {@link CapabilityLinkTypes#DEPENDENCY}. */
	public static final int DEPENDENCY = 4;

	/** Bit-mask value for all enumerations of {@link CapabilityLinkTypes}. */
	public static final int ALL_TYPE_ENUMERATORS = ANY | HOSTING | DEPENDENCY;

	/**
	 * Filters objects that are instances of {@link Capability} whose
	 * {@link Capability#getLinkType()} is either {@link CapabilityLinkTypes#HOSTING} or
	 * {@link CapabilityLinkTypes#ANY}
	 */
	public static final CapabilityLinkTypeFilter ANY_OR_HOSTING_FILTER = new CapabilityLinkTypeFilter(
			ANY | HOSTING);

	/**
	 * Filters objects that are instances of {@link Capability} whose
	 * {@link Capability#getLinkType()} is either {@link CapabilityLinkTypes#DEPENDENCY} or
	 * {@link CapabilityLinkTypes#ANY}
	 */
	public static final CapabilityLinkTypeFilter ANY_OR_DEPENDENCY_FILTER = new CapabilityLinkTypeFilter(
			ANY | DEPENDENCY);

	/**
	 * Filters objects that are instances of {@link Capability} whose
	 * {@link Capability#getLinkType()} is {@link CapabilityLinkTypes#ANY}.
	 */
	public static final CapabilityLinkTypeFilter ANY_FILTER = new CapabilityLinkTypeFilter(ANY);

	/**
	 * Filters objects that are instances of {@link Capability} whose
	 * {@link Capability#getLinkType()} is {@link CapabilityLinkTypes#HOSTING}.
	 */
	public static final CapabilityLinkTypeFilter HOSTING_FILTER = new CapabilityLinkTypeFilter(
			HOSTING);

	/**
	 * Filters objects that are instances of {@link Capability} whose
	 * {@link Capability#getLinkType()} is {@link CapabilityLinkTypes#DEPENDENCY}.
	 */
	public static final CapabilityLinkTypeFilter DEPENDENCY_FILTER = new CapabilityLinkTypeFilter(
			DEPENDENCY);

	/**
	 * Construct a capability link type filter for the specified mask.
	 * 
	 * @param mask
	 *           a mask on the {@link Capability#getLinkType()} value (one of #ANY, #HOSTING,
	 *           #DEPENDENCY, #ALL_TYPE_ENUMERATORS).
	 */
	public CapabilityLinkTypeFilter(int mask) {
		if ((mask & ~ALL_TYPE_ENUMERATORS) != 0) {
			throw new IllegalArgumentException(Integer.toString(mask));
		}
		this.mask = mask;
	}

	/** Mask used for filtering. */
	private final int mask;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.util.ObjectFilter#accept(java.lang.Object)
	 */
	public boolean accept(Capability value) {
		if (!(value instanceof Capability)) {
			return false;
		}
		Capability cap = value;
		CapabilityLinkTypes linkType = cap.getLinkType();
		if (linkType == null) {
			return false;
		}
		if ((mask & ANY) != 0 && linkType == CapabilityLinkTypes.ANY_LITERAL) {
			return true;
		}
		if ((mask & HOSTING) != 0 && linkType == CapabilityLinkTypes.HOSTING_LITERAL) {
			return true;
		}
		if ((mask & DEPENDENCY) != 0 && linkType == CapabilityLinkTypes.DEPENDENCY_LITERAL) {
			return true;
		}

		return false;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof CapabilityLinkTypeFilter)) {
			return false;
		}

		return mask == ((CapabilityLinkTypeFilter) obj).mask;
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
		buffer.append("CapabilityLinkTypeFilter["); //$NON-NLS-1$

		boolean hasPrev = false;
		if ((mask & ANY) != 0) {
			buffer.append(CapabilityLinkTypes.ANY_LITERAL.getName());
			hasPrev = true;
		}
		if ((mask & HOSTING) != 0) {
			if (hasPrev) {
				buffer.append(", ");//$NON-NLS-1$
			}
			buffer.append(CapabilityLinkTypes.HOSTING_LITERAL.getName());
			hasPrev = true;
		}
		if ((mask & DEPENDENCY) != 0) {
			if (hasPrev) {
				buffer.append(", ");//$NON-NLS-1$
			}
			buffer.append(CapabilityLinkTypes.DEPENDENCY_LITERAL.getName());
			hasPrev = true;
		}

		buffer.append("]"); //$NON-NLS-1$

		return buffer.toString();
	}
}
