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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validate that an attribute value belongs to a set of valid values.
 * <p>
 * Creates a {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID} if the value of the attribute is not
 * one of the valid values supplied in the constructor.
 */
public class DeployAttributeRestrictedValueValidator extends DeployAttributeValidator {

	/** Array of valid values. */
	protected Object[] validValues;

	/** The enumeration constraint for the valid values used in status reporting. */
	protected EnumerationConstraint enumConstraint;

	/** The status constraint list. */
	protected List<Constraint> statusConstraintList;

	/**
	 * Construct a validator for an restricted set of attribute values.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the attribute to be validated.
	 * @param validValues
	 *           an array of valid values.
	 */
	public DeployAttributeRestrictedValueValidator(String validatorID, EAttribute attribute,
			Object[] validValues) {
		super(validatorID, attribute);
		if (attribute == null || validValues == null) {
			validValues = new Object[0];
			statusConstraintList = Collections.emptyList();
		} else {
			statusConstraintList = new ArrayList<Constraint>(1);
			enumConstraint = ConstraintFactory.eINSTANCE.createEnumerationConstraint();
			enumConstraint.setName(attribute.getName());
			for (int i = 0; i < validValues.length; i++) {
				assert validValues[i] == null
						|| attribute.getEAttributeType().isInstance(validValues[i]);
				SingleValue singleValue = ConstraintFactory.eINSTANCE.createSingleValue();
				singleValue.setValueObject(validValues[i]);
				enumConstraint.getValues().add(singleValue);
			}
		}
		if (enumConstraint.getValues().size() > 0) {
			statusConstraintList.add(enumConstraint);
		}
		this.validValues = validValues;

	}

	/**
	 * @return the valid attribute values.
	 */
	public Object[] getValidValues() {
		return validValues;
	}

	/**
	 * Creates a {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID} if the value of the attribute is
	 * not one of the valid values supplied in the constructor.
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Object value = getAttributeValue(object);
		for (int i = 0; i < validValues.length; i++) {
			if (value == null) {
				if (validValues[i] == null) {
					return;
				}
			} else if (value.equals(validValues[i])) {
				return;
			}
		}
		String valueName;
		if (value instanceof String) {
			valueName = (String) value;
		} else if (value == null) {
			valueName = "null";//$NON-NLS-1$
		} else {
			valueName = value.toString();
		}
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				IStatus.ERROR, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid,
				new Object[] { object, attribute.getName(), valueName }, object, attribute,
				statusConstraintList);
		reporter.addStatus(status);
	}
}
