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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'EqualsConstraint' constrait type.
 */
public class EqualsConstraintValidator extends AttributeValueConstraintValidator implements
		IAttributeConstraintSolver {

	/**
	 * Validates attribute value against the constraint.
	 * 
	 * @param attributeValue
	 *           the value of the attribute
	 * @param edt
	 *           EDataType of the attribute
	 * @return Istatus of the validation
	 */
	protected IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		assert edt != null;

		EqualsConstraint theConstraint = (EqualsConstraint) constraint;
		Object value = null;

		if (theConstraint.getValue() != null && theConstraint.getValue().trim().length() > 0) {
			try {
				value = getValueFromString(theConstraint.getValue().trim(), edt);
			} catch (Exception e) {
				return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
			}
		}

		if (checkEquality(attributeValue, value)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		} else {
			// return the mismatch status
			Unit unit = ValidatorUtils.getUnit(context);
			int intStatus;
			if (unit.isConceptual()) {
				intStatus = IStatus.WARNING;
			} else {
				intStatus = IStatus.ERROR;
			}

			return DeployCoreStatusFactory.INSTANCE
					.createAttributeValueStatus(intStatus, theConstraint.eClass().getName(),
							ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
							DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid,
							new Object[] { context, theConstraint.getAttributeName() }, context,
							theConstraint.getAttributeName(), value, Collections
									.singletonList((Constraint) constraint));
		}
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof EqualsConstraint) {
			return true;
		}
		return false;
	}

	public String title(Constraint constraint) {
		EqualsConstraint ec = (EqualsConstraint) constraint;
		StringBuffer sb = new StringBuffer();

		sb.append(getAttributeName(ec));
		sb.append(' ');
		sb.append('=');
		sb.append(' ');
		sb.append(ec.getValue());
		return sb.toString();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.IDeployConstraintAttributeValueSolver#getAttributeValues(com.ibm.ccl.soa.deploy.core.Constraint,
	 *      java.lang.Object, org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeValues getAttributeValues(Constraint constraint, Object context,
			EAttribute attribute) {
		if (!(constraint instanceof EqualsConstraint)) {
			return new AttributeValues();
		}
		EqualsConstraint ec = (EqualsConstraint) constraint;
		if (attribute != null
				&& (ec.getAttributeName() == null || !attribute.getName().equals(ec.getAttributeName()))) {
			return new AttributeValues();
		}
		AttributeValues result = new AttributeValues();
		result.getValidValues().add(ec.getValueObject());
		result.setValidValuesExclusive(true);
		return result;
	}
}
