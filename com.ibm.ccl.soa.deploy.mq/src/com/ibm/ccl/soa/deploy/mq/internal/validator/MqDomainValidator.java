/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.mq.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.mq.MqPackage;
import com.ibm.ccl.soa.deploy.mq.internal.validator.matcher.MqDomainMatcher;

/**
 * Validates objects in the {@link MqPackage} deploy domain.
 */
public class MqDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link MqPackage} domain validator.
	 */
	public MqDomainValidator() {
		super(MqPackage.eINSTANCE);
		
		//addValidator(new MQActivationSpecificationUnitValidator());
		//addValidator(new MQBaseSystemUnitValidator());
		//addValidator(new MQConnectionFactoriesUnitValidator());
		//addValidator(new MQListenerUnitValidator());
		//addValidator(new MQMessageListnerServicePortUnitValidator());
		//addValidator(new MQMessagingProviderUnitValidator());
		//addValidator(new MQQueueChannelUnitValidator());
		//addValidator(new MQQueueConnectionFactoryUnitValidator());
		//addValidator(new MQQueueDestinationUnitValidator());
		//addValidator(new MQQueueManagerUnitValidator());
		//addValidator(new MQQueueUnitValidator());
		//addValidator(new MQTopicConnectionFactoryUnitValidator());
		//addValidator(new MQTopicDestinationUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new MqDomainMatcher();
	}
}
