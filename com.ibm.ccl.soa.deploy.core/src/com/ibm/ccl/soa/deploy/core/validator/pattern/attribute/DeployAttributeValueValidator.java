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
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Validates the value of an attribute delegating its computation to a subclass.
 */
public abstract class DeployAttributeValueValidator extends DeployAttributeValidator {

	/** The severety of inequality. */
	protected int severity = IStatus.ERROR;

	/** True if the attribute must be non-null. */
	protected boolean required = true;

	/**
	 * Construct a new attribute value validator for the specified attribute.
	 * 
	 * @param validatorID
	 *           identifies the validator.
	 * @param attribute
	 *           an attribute declared in a subtype of {@link DeployModelObject}.
	 * 
	 * @see EAttribute#getName()
	 * @see EAttribute#getEContainingClass()
	 */
	public DeployAttributeValueValidator(String validatorID, EAttribute attribute) {
		super(validatorID, attribute);
	}

	/**
	 * Construct a new attribute validator for the specified containing class and attribute name.
	 * <p>
	 * Use for attribute validators on extended attributes ({@link DeployModelObject#getEObject()}).
	 * 
	 * @param validatorID
	 *           identifies the validator.
	 * @param attributeContainer
	 *           the type of the attribute container (must be a subtype of {@link DeployModelObject}).
	 * @param attributeName
	 *           the name of the {@link EAttribute} or {@link ExtendedAttribute} defined the instance
	 *           of <code>attributeContainer</code>.
	 */
	public DeployAttributeValueValidator(String validatorID, EClass attributeContainer,
			String attributeName) {
		super(validatorID, attributeContainer, attributeName);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.IDeployAttributeValidator#validate(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Object expectedValue = getExpectedValue(object, context);
		Object currentValue = getAttributeValue(object);
		if (expectedValue == null) {
			// Don't know the expected value
			if (ValidatorUtils.isNullOrEmpty(currentValue)) {
				reportAttributeUndefinedStatus(IStatus.ERROR, object, context, reporter);
			}
		} else if (!ValidatorUtils.equals(currentValue, expectedValue)) {
			int severity = getSeverity();
			if (required && (ValidatorUtils.isNullOrEmpty(currentValue))) {
				severity = IStatus.ERROR;
			}
			IDeployStatus status;
			if (attribute == null) {
				status = DeployCoreStatusUtil.createAttributeInvalidStatus(severity, getValidatorID(),
						object, attributeName, expectedValue);
			} else {
				status = DeployCoreStatusUtil.createAttributeInvalidStatus(severity, getValidatorID(),
						object, attribute, expectedValue);
			}
			reporter.addStatus(status);
		}
	}

	/**
	 * The severity used to report invalid values.
	 * 
	 * @param severity
	 *           a status severity.
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	/**
	 * @return the severity used to report an invalid value.
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * @return true if the value must be non-null.
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * Configures the requirement of a non-null value.
	 * 
	 * @param required
	 *           if the value must be non-null, otherwise an error should be reported.
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * Computes the expected value for the object
	 * 
	 * @param object
	 *           the deploy object whose attribute is validated.
	 * @param context
	 *           the validation context.
	 * @return the expected value.
	 */
	public abstract Object getExpectedValue(DeployModelObject object,
			IDeployValidationContext context);

}
