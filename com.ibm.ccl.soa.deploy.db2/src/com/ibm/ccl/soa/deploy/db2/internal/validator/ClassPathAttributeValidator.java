/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.db2.Messages;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;

/**
 * Validates an attribute whose value is a Java class name.
 */
public class ClassPathAttributeValidator extends DeployAttributeValidator {

	/**
	 * Constructs a Java class name validator.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the attribute validated (must be of type {@link String}).
	 */
	public ClassPathAttributeValidator(String validatorID, EAttribute attribute) {
		super(validatorID, attribute);
		assert attribute.getEAttributeType().getInstanceClass().equals(String.class);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployAttributeValidator#validate(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		String value = (String) getAttributeValue(object);
		if ((value != null) && (value.length() != 0)
				&& !DB2ValidatorUtils.wasClassPathValid(value, OsValidatorUtils.getOsType(object))) {
			IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
					Messages.WAS_DB2_classpath_invalid, new String[] { value }, object,
					getFullAttributeName());
			reporter.addStatus(status);
		}

	}
}
