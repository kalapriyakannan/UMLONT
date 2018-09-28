/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee.jms.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;
import com.ibm.ccl.soa.deploy.j2ee.jms.internal.validator.IJMSValidatorID;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class JMSProviderUnitValidator extends UnitValidator {

	public JMSProviderUnitValidator() {
		this(JmsPackage.eINSTANCE.getJMSProviderUnit());
	}

	protected JMSProviderUnitValidator(EClass unitType) {
		super(unitType);
		/*
		 * NM : We have to have JDK 1.4 Compliance assert
		 * JmsPackage.eINSTANCE.getJMSProviderUnit().isSuperTypeOf( unitType);
		 */

		//TODO: make sure this validator:sequence can work
		DeployAttributeInvalidPathnameValidator jmsClassPathValidator = new DeployAttributeInvalidPathnameValidator(
				IJMSValidatorID.JMS_PROVIDER_UNIT_CLASSPATH_INVALID_001,
				JmsPackage.Literals.JMS_PROVIDER__CLASS_PATH);
		jmsClassPathValidator.setRequireDriveLetterWindows(true);
		jmsClassPathValidator.setRequireRootedPathUnix(true);
		addAttributeValidator(jmsClassPathValidator);

	}

}
