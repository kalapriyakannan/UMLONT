/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validate that an attribute value <em>does not</em> belong to a set of invalid values.
 * <p>
 * Creates a {@link ICoreProblemType.OBJECT_ATTRIBUTE_INVALID} if the value of the attribute is one
 * of the valid values supplied in the constructor.
 */
public class DeployAttributeNotEqualsValidator extends DeployAttributeValidator {

	/** Array of valid values. */
	protected Object[] invalidValues;

	/** Error severity. */
	protected int severity;

	/**
	 * Construct a validator that the attribute value is not equal to a specific value.
	 * <p>
	 * Constructs an array of size one with the invalid value and invokes
	 * {@link #DeployAttributeNotEqualsValidator(String, EAttribute, Object[], int)}
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the attribute to be validated.
	 * @param invalidValue
	 *           the value that is not permitted.
	 * @param severity
	 *           the error severity;
	 */
	public DeployAttributeNotEqualsValidator(String validatorID, EAttribute attribute,
			Object invalidValue, int severity) {
		this(validatorID, attribute, new Object[] { invalidValue }, severity);
	}

	/**
	 * Construct a validator for an restricted set of attribute values.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the attribute to be validated.
	 * @param invalidValues
	 *           an array of invalid values.
	 * @param severity
	 *           the error severity;
	 */
	public DeployAttributeNotEqualsValidator(String validatorID, EAttribute attribute,
			Object[] invalidValues, int severity) {
		super(validatorID, attribute);
		this.severity = severity;
		if (invalidValues == null) {
			invalidValues = new Object[0];
		} else {
			for (int i = 0; i < invalidValues.length; i++) {
				assert (invalidValues[i] == null)
						|| (attribute.getEAttributeType().isInstance(invalidValues[i]));
			}
		}
		this.invalidValues = invalidValues;
	}

	/**
	 * @return the invalid attribute values.
	 */
	public Object[] getInValidValues() {
		return invalidValues;
	}

	/**
	 * Creates a {@link ICoreProblemType.OBJECT_ATTRIBUTE_INVALID} if the value of the attribute is
	 * not one of the valid values supplied in the constructor.
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Object value = getAttributeValue(object);
		boolean error = false;
		for (int i = 0; i < invalidValues.length; i++) {
			if (value == null) {
				if (invalidValues[i] == null) {
					error = true;
					break;
				}
			} else if (value.equals(invalidValues[i])) {
				error = true;
			}
		}
		if (!error) {
			return;
		}
		String valueName;
		if (value instanceof String) {
			valueName = (String) value;
		} else if (value == null) {
			valueName = "null";//$NON-NLS-1$
		} else {
			valueName = value.toString();
		}
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeStatus(severity, validatorID,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid,
						new Object[] { object, attribute.getName(), valueName }, object,
						getFullAttributeName());
		reporter.addStatus(status);
	}
}
