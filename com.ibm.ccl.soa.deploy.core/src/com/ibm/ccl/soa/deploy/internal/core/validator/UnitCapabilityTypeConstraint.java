/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Constraint on the type, cardinality, and link type attribute of a {@link Capability}.
 * 
 * @see UnitValidator#addCapabilityTypeConstraint(EClass, CapabilityLinkTypes, int, int)
 */
public class UnitCapabilityTypeConstraint {

	private final EClass type;

	private final int min;

	private final int max;

	private final CapabilityLinkTypes linkType;

	private final CapabilityLinkTypes[] linkTypes;

	/**
	 * Construct a constraint on a capability type.
	 * 
	 * @param type
	 *           the
	 * @param min
	 * @param max
	 * @param linkType
	 */
	public UnitCapabilityTypeConstraint(EClass type, int min, int max, CapabilityLinkTypes linkType) {
		assert type != null;
		assert min <= max;
		this.type = type;
		this.min = min;
		this.max = max;
		this.linkType = linkType;
		this.linkTypes = null;
	}

	/**
	 * Construct a constraint on a capability type.
	 * 
	 * @param type
	 *           the
	 * @param min
	 * @param max
	 * @param linkType
	 */
	public UnitCapabilityTypeConstraint(EClass type, int min, int max,
			CapabilityLinkTypes[] linkTypes) {
		assert type != null;
		assert min <= max;
		this.type = type;
		this.min = min;
		this.max = max;
		this.linkType = null;
		this.linkTypes = linkTypes;
	}

	/**
	 * @return the type being constrained.
	 */
	public EClass getType() {
		return type;
	}

	/**
	 * @return the minimum number of type instances.
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @return the maximum number of type instances in the unit.
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the link type of the capability.
	 */
	public CapabilityLinkTypes getLinkType() {
		return linkType;
	}

	/**
	 * Checks if the capability matches the constraint.
	 * 
	 * @param cap
	 *           the capability to be tested.
	 * @return true if the capability is accepted.
	 */
	public boolean matches(Capability cap) {
		if ((getType() != null) && (!getType().isSuperTypeOf(cap.getEObject().eClass()))) {
			return false;
		}

		if (linkType != null) {
			return linkType.equals(cap.getLinkType());
		} else if (linkTypes != null) {
			for (int i = 0; i < linkTypes.length; i++) {
				if (linkTypes[i].equals(cap.getLinkType())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
