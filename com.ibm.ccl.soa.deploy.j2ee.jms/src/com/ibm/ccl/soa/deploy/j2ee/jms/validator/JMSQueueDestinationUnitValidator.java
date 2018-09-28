/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee.jms.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;
import com.ibm.ccl.soa.deploy.j2ee.jms.internal.validator.IJMSValidatorID;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class JMSQueueDestinationUnitValidator extends UnitValidator {

	public JMSQueueDestinationUnitValidator() {
		this(JmsPackage.eINSTANCE.getJMSQueueDestinationUnit());
	}

	protected JMSQueueDestinationUnitValidator(EClass unitType) {
		super(unitType);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IJMSValidatorID.JMS_QUEUE_DESTINATION_NAME_NOT_EMPTY_001,
				JmsPackage.Literals.JMS_DESTINATION__DESTINATION_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IJMSValidatorID.JMS_QUEUE_DESTINATION_NAME_UNIQUENESS_001,
				JmsPackage.Literals.JMS_DESTINATION__DESTINATION_NAME));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IJMSValidatorID.JMS_QUEUE_DESTINATION_JNDINAME_NOT_EMPTY_001,
				JmsPackage.Literals.JMS_DESTINATION__JNDI_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IJMSValidatorID.JMS_QUEUE_DESTINATION_JNDINAME_UNIQUENESS_001,
				JmsPackage.Literals.JMS_DESTINATION__JNDI_NAME));
	}
}
