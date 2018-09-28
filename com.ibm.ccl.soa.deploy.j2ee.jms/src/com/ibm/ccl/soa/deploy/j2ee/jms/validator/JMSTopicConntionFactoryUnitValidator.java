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

public class JMSTopicConntionFactoryUnitValidator extends UnitValidator {

	public JMSTopicConntionFactoryUnitValidator() {
		this(JmsPackage.eINSTANCE.getJMSQueueConnectionFactoryUnit());
	}

	protected JMSTopicConntionFactoryUnitValidator(EClass unitType) {
		super(unitType);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IJMSValidatorID.JMS_TOPIC_CONNECTIONFACTORY_NAME_NOT_EMPTY_001,
				JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IJMSValidatorID.JMS_TOPIC_CONNECTIONFACTORY_NAME_UNIQUENESS_001,
				JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IJMSValidatorID.JMS_TOPIC_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001,
				JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IJMSValidatorID.JMS_TOPIC_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001,
				JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME));

	}

}
