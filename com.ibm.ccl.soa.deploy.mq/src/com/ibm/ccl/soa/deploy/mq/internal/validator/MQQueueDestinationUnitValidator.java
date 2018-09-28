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

import sun.text.CompactShortArray.Iterator;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.mq.MQQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.mq.MqPackage;
import com.ibm.ccl.soa.deploy.core.validation.*;
import com.ibm.ccl.soa.deploy.core.validator.*;
import com.ibm.ccl.soa.deploy.core.validator.constraints.*;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.*;

/**
 * Validates {@link MQQueueDestinationUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class MQQueueDestinationUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link MQQueueDestinationUnit} instance validator.
	 */
	public MQQueueDestinationUnitValidator() {
		this(MqPackage.eINSTANCE.getMQQueueDestinationUnit());
		//init();

	}

	/**
	 * Construct a {@link MQQueueDestinationUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link MQQueueDestinationUnit}.
	 */
	protected MQQueueDestinationUnitValidator(EClass unitType) {
		super(unitType);
		assert MqPackage.eINSTANCE.getMQQueueDestinationUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(MqPackage.eINSTANCE.getMQQueueDestination(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

//CapabilityAttributeToAttributePropagationValidator(001,
		//MqPackage.Literals.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME,
		//MqPackage.Literals.MQ_DESTINATION__QUEUE_MANAGER_HOST);

		//addAttributeValidator(
				//new CapabilityAttributeToAttributePropagationValidator(
					//	"001",
						//MqPackage.Literals.MQ_QUEUE__QUEUE_NAME,
						//MqPackage.Literals.MQ_DESTINATION__BASE_QUEUE_NAME));
	   
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
		/*for((Iterator iter = (Iterator) context.findAllCapabilities(MqPackage.eINSTANCE.getMQDestination()));iter.hasNext();)
		{
			
		}*/

	}
	
}
