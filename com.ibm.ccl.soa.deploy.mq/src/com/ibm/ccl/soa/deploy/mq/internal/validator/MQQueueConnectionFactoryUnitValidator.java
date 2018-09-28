/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.mq.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * Validates {@link MQQueueConnectionFactoryUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class MQQueueConnectionFactoryUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link MQQueueConnectionFactoryUnit} instance validator.
	 */
	public MQQueueConnectionFactoryUnitValidator() {
		this(MqPackage.eINSTANCE.getMQQueueConnectionFactoryUnit());

	}

	/**
	 * Construct a {@link MQQueueConnectionFactoryUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link MQQueueConnectionFactoryUnit}.
	 */
	protected MQQueueConnectionFactoryUnitValidator(EClass unitType) {
		super(unitType);
		assert MqPackage.eINSTANCE.getMQQueueConnectionFactoryUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(MqPackage.eINSTANCE.getMQQueueConnectionFactory(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		
		addAttributeValidator(
				new CapabilityAttributeToAttributePropagationValidator(
						"MQ_Destination_001",
						MqPackage.Literals.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME,
						MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER));
		
		addAttributeValidator(
				new CapabilityAttributeToAttributePropagationValidator(
						"MQ_Destination_002",
						MqPackage.Literals.MQ_QUEUE_MANAGER__TCP_PORT,
						MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__PORT)
		
		);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
	}
}
