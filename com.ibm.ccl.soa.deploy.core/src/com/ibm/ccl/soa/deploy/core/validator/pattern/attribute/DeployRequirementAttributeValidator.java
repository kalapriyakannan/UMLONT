/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * Validates {@link Requirement} attributes of type {@link Requirement#getDmoEType()}, contained as
 * {@link RequirementExpression#getAttributeName()}.
 */
public abstract class DeployRequirementAttributeValidator extends DeployAttributeValidator {

	protected final EClass capabilityType;

	/**
	 * Construct a validator for a requirement attribute.
	 * <p>
	 * Uses {@link Requirement} as the filter for object type.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the {@link Capability} attribute that is to be validatod.
	 */
	public DeployRequirementAttributeValidator(String validatorID, EAttribute attribute) {
		this(validatorID, CorePackage.eINSTANCE.getRequirement(), attribute.getName(), attribute
				.getEContainingClass());
	}

	/**
	 * Construct a validator for a requirement expression.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the {@link Capability} attribute that is to be validatod.
	 * @param requirementType
	 *           the type of requirement that will be matched, subtype of {@link Requirement}) or
	 *           {@link RequirementExpression}.
	 */
	public DeployRequirementAttributeValidator(String validatorID, EAttribute attribute,
			EClass requirementType) {
		this(validatorID, requirementType, attribute.getName(), attribute.getEContainingClass());
	}

	/**
	 * 
	 * Construct a validator for a requirement expression.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param requirementType
	 *           the type of requirement that will be matched, subtype of {@link Requirement}).
	 * @param attributeName
	 *           the {@link Capability} attribute that is to be validatod.
	 * @param capabilityType
	 *           a subtype of {@link Capability} where the attribute is contained.
	 */
	public DeployRequirementAttributeValidator(String validatorID, EClass requirementType,
			String attributeName, EClass capabilityType) {
		super(validatorID, requirementType, attributeName);
		if (!CorePackage.eINSTANCE.getRequirement().isSuperTypeOf(requirementType)) {
			throw new IllegalArgumentException(requirementType.toString());
		}
		this.capabilityType = capabilityType;
	}

	/**
	 * Returns the {@link Requirement#getDmoEType()} that is matched.
	 * 
	 * @return the requirement capability type that will be matched.
	 */
	public EClass getCapabilityType() {
		return capabilityType;
	}

	/**
	 * Check if the attribute is a requirement whose {@link Requirement#getDmoEType()} matches
	 * {@link #getCapabilityType()}.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator#appliesTo(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext)
	 */
	public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
		if (getAttributeContainer().isSuperTypeOf(object.getEObject().eClass())) {
			Requirement req = (Requirement) object;
			if (req.getDmoEType() == null) {
				return false;
			}
			return capabilityType.isSuperTypeOf(req.getDmoEType());
		} else if (getAttributeContainer().isSuperTypeOf(object.getEObject().eClass())) {
			RequirementExpression expr = (RequirementExpression) object;
			if (!(expr.getParent() instanceof Requirement)) {
				return false;
			}
			Requirement req = (Requirement) expr.getParent();
			if (req.getDmoEType() == null) {
				return false;
			}
			return capabilityType.isSuperTypeOf(req.getDmoEType());
		}
		return false;
	}

	/**
	 * Returns {@link RequirementExpression#getValue()} for the <em>first</em> requirement
	 * expression whose {@link RequirementExpression#getAttributeName()} matches the
	 * {@link #getAttributeName()}.
	 */
	protected Object getAttributeValue(DeployModelObject object) {
		if (object instanceof Requirement) {
			Requirement req = (Requirement) object;
			for (Iterator iter = req.getExpressions().iterator(); iter.hasNext();) {
				RequirementExpression expr = (RequirementExpression) iter.next();
				if (attributeName.equals(expr.getAttributeName())) {
					return expr.getValue();
				}
			}

			// MK 2/11/2008 probably should have DeployConstraintAttributeValidator with this logic
			for (Constraint c : ConstraintUtil.getConstraints(object,
					ConstraintPackage.Literals.EQUALS_CONSTRAINT)) {
				EqualsConstraint ec = (EqualsConstraint) c;
				if (attributeName.equals(ec.getAttributeName())) {
					return ec.getValue();
				}
			}

		} else if (object instanceof RequirementExpression) {
			RequirementExpression expr = (RequirementExpression) object;
			if (attributeName.equals(expr.getAttributeName())) {
				return expr.getValue();
			}
		} else if (object instanceof EqualsConstraint) {
			EqualsConstraint ec = (EqualsConstraint) object;
			if (attributeName.equals(ec.getAttributeName())) {
				return ec.getValue();
			}
		}
		return null;
	}
}
