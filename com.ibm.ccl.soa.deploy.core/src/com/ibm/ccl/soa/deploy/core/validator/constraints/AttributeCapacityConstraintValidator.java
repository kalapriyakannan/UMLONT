/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class AttributeCapacityConstraintValidator extends AttributeValueConstraintValidator {

	@Override
	protected IStatus validateConceptualAttributeValue(Object attributeValue, EDataType dataType,
			AttributeValueConstraint theConstraint, DeployModelObject context) {

		return validateAttributeValue(attributeValue, dataType, theConstraint, context);
	}

	@Override
	protected IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context) {
		IStatus result = null;
		if (canValidateConstraint(constraint)) {

			AttributeCapacityConstraint capacityConstraint = (AttributeCapacityConstraint) constraint;

//			Object valueObj = null;
//			if (capacityConstraint.getValue() != null
//					&& capacityConstraint.getValue().trim().length() > 0) {
//				try {
//					valueObj = getValueFromString(capacityConstraint.getValue().trim(), edt);
//				} catch (Exception e) {
//					return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
//				}
//			}

			EStructuralFeature esf = context.eClass().getEStructuralFeature(
					constraint.getAttributeName());
			if (esf instanceof EAttribute) {
				EAttribute attribute = (EAttribute) esf;

				Unit source = ValidatorUtils.getUnit(capacityConstraint);
				result = CapacityConstraintValidator.createRestrictionStatus(source, context,
						capacityConstraint, attribute);

			}

		}
		return result != null ? result : Status.OK_STATUS;
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		// we test for strict instance rather than instanceof 
		return ConstraintPackage.Literals.ATTRIBUTE_CAPACITY_CONSTRAINT == constraint.getEObject()
				.eClass();
	}

	@Override
	public String title(Constraint constraint) {
		AttributeCapacityConstraint acc = (AttributeCapacityConstraint) constraint;
		StringBuffer sb = new StringBuffer();
		sb.append(NLS.bind(DeployCoreMessages.AttributeCapacityConstraintValidator_0_1_,
				new Object[] { acc.getAttributeName(), acc.getValue() }));
		return sb.toString();
	}

}
