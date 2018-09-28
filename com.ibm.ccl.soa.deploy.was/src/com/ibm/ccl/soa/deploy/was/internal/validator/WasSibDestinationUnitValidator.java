/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasSibDestinationUnitValidator extends ConfigurationUnitValidator {
	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasSibDestinationUnit();
	}

	public WasSibDestinationUnitValidator() {
		super(WasPackage.eINSTANCE.getWasSibDestinationUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSibDestination(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSIBus(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSibMediation(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasJ2EEServer(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.VALIDAT_WAS_SIB_DESTINATION_DESTINATIONNAME_001,
				WasPackage.Literals.WAS_SIB_DESTINATION__DESTINATION_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.VALIDAT_WAS_SIB_DESTINATION_DESTINATIONNAME_002,
				WasPackage.Literals.WAS_SIB_DESTINATION__DESTINATION_NAME));

	}
}
