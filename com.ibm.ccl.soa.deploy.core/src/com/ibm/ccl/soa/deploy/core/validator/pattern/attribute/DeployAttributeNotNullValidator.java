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

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * Validates that an attribute of e deploy model object is not null.
 * <p>
 * To validate the existance of a non-null {@link RequirementExpression} use
 * {@link DeployRequirementAttributeNotNullValidator}.
 * <p>
 * To validate a string as non-null and of non-zero length use
 * {@link DeployAttributeStringNotEmptyValidator}.
 */
public class DeployAttributeNotNullValidator extends DeployAttributeValidator {

	protected int severity;

	/**
	 * Construct a validator that an attribute is non-null.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attribute
	 *           {@inheritDoc}
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployAttributeNotNullValidator(String validatorID, EAttribute attribute, int severity) {
		super(validatorID, attribute);
		this.severity = severity;
	}

	/**
	 * Construct a validator that an attribute is non-null.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attributeContainer
	 *           {@inheritDoc}
	 * @param attributeName
	 *           {@inheritDoc}
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployAttributeNotNullValidator(String validatorID, EClass attributeContainer,
			String attributeName, int severity) {
		super(validatorID, attributeContainer, attributeName);
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
		if (value == null) {
			super.reportAttributeUndefinedStatus(severity, object, context, reporter);
		}
	}

}
