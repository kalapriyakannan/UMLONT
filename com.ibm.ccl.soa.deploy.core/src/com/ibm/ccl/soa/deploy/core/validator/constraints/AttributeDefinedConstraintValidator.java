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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates {@link AttributeDefinedConstraint}
 */
public class AttributeDefinedConstraintValidator extends AttributeValueConstraintValidator {

	@Override
	protected IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context) {
		if (!(constraint instanceof AttributeDefinedConstraint)) {
			return Status.CANCEL_STATUS;
		}
		AttributeDefinedConstraint c = (AttributeDefinedConstraint) constraint;
		if (attributeValue == null) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, constraint.eClass().getName(),
					ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
					DeployCoreMessages.Required_attribute_0_of_object_1_is_null, new Object[] {
							c.getAttributeName(), context }, context, constraint.getAttributeName());
			return status;
		} else {
			if (attributeValue instanceof String) {
				if (((String) attributeValue).length() == 0) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
							IStatus.ERROR, constraint.eClass().getName(),
							ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
							DeployCoreMessages.Required_attribute_0_of_object_1_is_empty, new Object[] {
									c.getAttributeName(), context }, context, constraint.getAttributeName());
					return status;
				}
			}
		}
		return Status.OK_STATUS;
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return constraint instanceof AttributeDefinedConstraint;
	}

	@Override
	public String title(Constraint constraint) {
		if (constraint instanceof AttributeDefinedConstraint) {
			AttributeDefinedConstraint c = (AttributeDefinedConstraint) constraint;
			return DeployNLS.bind(DeployCoreMessages.Attribute_0_defined, c.getAttributeName());
		}
		return super.title(constraint);
	}
}
