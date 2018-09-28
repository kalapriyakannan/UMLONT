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

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Constraint on the type, cardinality, and link type of a {@link Requirement}.
 * 
 * @see UnitValidator#addRequirementTypeConstraint(EClass, RequirementLinkTypes, int, int)
 */
public class UnitRequirementTypeConstraint {

	private final EClass type;

	private final int min;

	private final int max;

	private final RequirementLinkTypes linkType;

	private final RequirementLinkTypes[] linkTypes;

	/**
	 * Create a constraint on the requirement type of a unit.
	 * 
	 * @param type
	 *           the requirement capability type (@see {@link Requirement#getDmoEType()}}.
	 * @param linkType
	 *           the type of link (may be null).
	 * @param min
	 *           minimum number of such requirements.
	 * @param max
	 *           maximum number of such requirements (use {@link Integer#MAX_VALUE} for unbounded).
	 */
	public UnitRequirementTypeConstraint(EClass type, int min, int max, RequirementLinkTypes linkType) {
		assert type != null;
		assert min <= max;
		this.type = type;
		this.min = min;
		this.max = max;
		this.linkType = linkType;
		linkTypes = null;
	}

	/**
	 * Create a constraint on the requirement type of a unit.
	 * 
	 * @param type
	 *           the requirement capability type (@see {@link Requirement#getDmoEType()}}.
	 * @param linkTypes
	 *           the types of link (may be null).
	 * @param min
	 *           minimum number of such requirements.
	 * @param max
	 *           maximum number of such requirements (use {@link Integer#MAX_VALUE} for unbounded).
	 */
	public UnitRequirementTypeConstraint(EClass type, int min, int max,
			RequirementLinkTypes[] linkTypes) {
		assert type != null;
		assert min <= max;
		this.type = type;
		this.min = min;
		this.max = max;
		linkType = null;
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
	 * @return the type of the requirement link.
	 */
	public RequirementLinkTypes getLinkType() {
		return linkType;
	}

	/**
	 * Checks if the requirement matches the constraint.
	 * 
	 * @param req
	 *           the requirement to be tested.
	 * @return true if the requirement is accepted.
	 */
	public boolean matches(Requirement req) {
		if (getType() != null) {
			if (!RequirementUtil.includesConstraintOfType(req, type)) {
				return false;
			}
		}

		if (linkType != null) {
			return linkType.equals(req.getLinkType());
		} else if (linkTypes != null) {
			for (int i = 0; i < linkTypes.length; i++) {
				if (linkTypes[i].equals(req.getLinkType())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
