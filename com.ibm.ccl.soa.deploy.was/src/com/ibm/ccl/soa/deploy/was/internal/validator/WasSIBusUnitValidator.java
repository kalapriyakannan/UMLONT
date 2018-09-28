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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInGroupValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasSIBusUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {

		return WasPackage.eINSTANCE.getWasSIBusUnit();

	}

	public WasSIBusUnitValidator() {

		super(WasPackage.eINSTANCE.getWasSIBusUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSIBus(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasCellUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWebsphereAppServerUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasClusterUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(WasPackage.Literals.WAS_MESSAGING_ENGINE_UNIT,
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_SIBUS_CAPBILITY_BUS_NAME_EMPTY_001,
				WasPackage.Literals.WAS_SI_BUS__BUS_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInGroupValidator(
				IWasValidatorID.WAS_SIBUS_BUS_NAME_UNIQUENESS_001, WasPackage.eINSTANCE
						.getWasSIBusUnit(), WasPackage.Literals.WAS_SI_BUS__BUS_NAME,
				WasPackage.eINSTANCE.getWasCellUnit()));

		//TODO: WasSIBus's WebsphereAppserverUnit member should not be a wasClusterUnit member at the same time
		//TODO: Each Bus member should have a corresponding Messaging Engine as a member of the Bus and hosted on the member.
	}
}
