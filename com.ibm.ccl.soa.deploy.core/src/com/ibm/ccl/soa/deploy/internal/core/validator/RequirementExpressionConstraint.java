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
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Constraint on a {@link RequirementExpression}.
 * 
 * @see UnitValidator#addCapabilityTypeConstraint(EClass,
 *      com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes, int, int)
 * @see UnitValidator#addRequirementTypeConstraint(EClass,
 *      com.ibm.ccl.soa.deploy.core.RequirementLinkTypes, int, int)
 */
public class RequirementExpressionConstraint {

	private final EClass type;

	private final String attributeName;

	private final Boolean isNull;

	private final Object value;

	public RequirementExpressionConstraint(EClass type, String attributeName, boolean isNull) {
		assert type != null;
		assert attributeName != null;
		this.type = type;
		this.attributeName = attributeName;
		this.isNull = Boolean.valueOf(isNull);
		this.value = null;
	}

	public RequirementExpressionConstraint(EClass type, String attributeName, Object value) {
		assert type != null;
		assert attributeName != null;
		this.type = type;
		this.attributeName = attributeName;
		this.isNull = null;
		this.value = value;
	}

	/**
	 * @return the type being constrained.
	 */
	public EClass getType() {
		return type;
	}

	/**
	 * Checks if the requirement expression matches the type and attribute, and violates the value
	 * requirement.
	 * 
	 * @param cap
	 *           the capability to be tested.
	 * @return true if the capability is accepted.
	 */
	public boolean isFail(RequirementExpression expr) {
		if (!(expr.getParent() instanceof Requirement)) {
			return false;
		}
		Requirement req = (Requirement) expr.getParent();
		if ((req.getDmoEType() == null) || (!type.isSuperTypeOf(req.getDmoEType()))) {
			return false;
		}
		if ((expr.getAttributeName() == null) || (!expr.getAttributeName().equals(attributeName))) {
			return false;
		}

		// TODO implement

		return true;
	}
}
