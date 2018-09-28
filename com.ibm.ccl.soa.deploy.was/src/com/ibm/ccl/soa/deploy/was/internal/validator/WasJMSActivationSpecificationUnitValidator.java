/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.j2ee.jms.validator.JMSActivationSpecificationUnitValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasJMSActivationSpecificationUnitValidator extends
		JMSActivationSpecificationUnitValidator {

	public WasJMSActivationSpecificationUnitValidator() {
		this(WasPackage.eINSTANCE.getWasJMSActivationSpecificationUnit());
	}

	protected WasJMSActivationSpecificationUnitValidator(EClass unitType) {
		super(unitType);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasJMSActivationSpecification(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		// now in supertype
//		this.addRequirementTypeConstraint(WasPackage.eINSTANCE
//				.getWasDefaultMessagingTopicDestination(), RequirementLinkTypes.DEPENDENCY_LITERAL, 0,
//				1);
//		this.addRequirementTypeConstraint(WasPackage.eINSTANCE
//				.getWasDefaultMessagingQueueDestination(), RequirementLinkTypes.DEPENDENCY_LITERAL, 0,
//				1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

//		//At least has one dependency link.
//		boolean hasDependency = false;
//		Requirement require = (Requirement) ValidatorUtils.getRequirements(unit,
//				WasPackage.eINSTANCE.getWasDefaultMessagingTopicDestination()).get(0);
//		if (require.getLink() != null)
//			hasDependency = true;
//
//		if (!hasDependency) {
//			require = (Requirement) ValidatorUtils.getRequirements(unit,
//					WasPackage.eINSTANCE.getWasDefaultMessagingQueueDestination()).get(0);
//			if (require.getLink() != null)
//				hasDependency = true;
//		}
//
//		if (!hasDependency) {
//			IDeployStatus message = DeployWasMessageFactory
//					.createWasJMSActiSpecDependencyOnDefaultMessagingDestinationUndefined(unit);
//			reporter.addStatus(message);
//		}

	}

}
