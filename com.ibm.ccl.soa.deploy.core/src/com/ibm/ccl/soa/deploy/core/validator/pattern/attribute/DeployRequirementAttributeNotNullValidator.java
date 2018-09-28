/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * Validates that a {@link Requirement} contained {@link RequirementExpression#getAttributeName()}.
 */
public class DeployRequirementAttributeNotNullValidator extends DeployRequirementAttributeValidator {

	protected int severity;

	/**
	 * Construct a validator that a {@link Capability} attribute constrained by a
	 * {@link RequirementExpression}.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attribute
	 *           {@inheritDoc}
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployRequirementAttributeNotNullValidator(String validatorID, EAttribute attribute,
			int severity) {
		super(validatorID, attribute);
		this.severity = severity;
	}

	/**
	 * Construct a validator that a {@link Capability} attribute constrained by a
	 * {@link RequirementExpression}.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attribute
	 *           {@inheritDoc}
	 * @param requirementType
	 *           a subtype of the {@link Requirement}.
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployRequirementAttributeNotNullValidator(String validatorID, EAttribute attribute,
			EClass requirementType, int severity) {
		super(validatorID, attribute, requirementType);
		this.severity = severity;
	}

	/**
	 * Construct a validator that an attribute is non-null, and if a {@link String} it has length
	 * greater than zero.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attributeContainer
	 *           {@inheritDoc}
	 * @param attributeName
	 *           {@inheritDoc}
	 * @param capabilityType
	 *           {@inheritDoc}
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployRequirementAttributeNotNullValidator(String validatorID, EClass attributeContainer,
			String attributeName, EClass capabilityType, int severity) {
		super(validatorID, attributeContainer, attributeName, capabilityType);
		this.severity = severity;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployAttributeValidator#validate(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Object value = getAttributeValue(object);
		if ((value == null) || ((value instanceof String) && ((String) value).length() == 0)) {
			super.reportAttributeUndefinedStatus(severity, object, context, reporter);
		}
	}
}
