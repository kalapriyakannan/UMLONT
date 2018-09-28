/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.j2ee.jms.validator.JMSTopicConntionFactoryUnitValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasDefaultMessagingTopicConnetionFactoryValidator extends
		JMSTopicConntionFactoryUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.Literals.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT;
	}

	public WasDefaultMessagingTopicConnetionFactoryValidator() {
		this(WasPackage.Literals.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT);
	}

	public WasDefaultMessagingTopicConnetionFactoryValidator(EClass unitType) {
		super(unitType);

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE
				.getWasDefaultMessagingTopicConnectionFactoryConfiguration(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSIBus(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

	}
}
