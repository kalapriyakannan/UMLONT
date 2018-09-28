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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.validator.J2CAuthenticationUnitValidator;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * 
 */
public class WasJ2CAuthenticationUnitValidator extends J2CAuthenticationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWASJ2CAuthenticationUnit();
	}

	/**
	 */
	public WasJ2CAuthenticationUnitValidator() {
		super();
		this.addCapabilityTypeConstraint(WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
//		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_SERVER, RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.Literals.WAS_CELL,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(OsPackage.Literals.USER,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IWasValidatorID.WAS_J2C_AUTH_UNIT_UNIT_USER_ID_FROM_USER_001,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID,
				OsPackage.Literals.USER__USER_ID));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IWasValidatorID.WAS_J2C_AUTH_UNIT_UNIT_USER_PASSWORD_FROM_USER_001,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD,
				OsPackage.Literals.USER__USER_PASSWORD));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.WAS_J2C_AUTH_UNIT_UNIT_ALIAS_UNIQUE_001,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS));

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		// Propagate userid to alias iff alias is null
		WASJ2CAuthenticationDataEntry wasJ2CAuthenticationDataEntry = (WASJ2CAuthenticationDataEntry) ValidatorUtils
				.getCapability(unit, WasPackage.eINSTANCE.getWASJ2CAuthenticationDataEntry());

		if (wasJ2CAuthenticationDataEntry != null && wasJ2CAuthenticationDataEntry.getAlias() == null
				&& wasJ2CAuthenticationDataEntry.getUserId() != null) {
			reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidSourceValueStatus(
					wasJ2CAuthenticationDataEntry, J2eePackage.eINSTANCE
							.getJ2CAuthenticationDataEntry_Alias(), wasJ2CAuthenticationDataEntry,
					J2eePackage.eINSTANCE.getJ2CAuthenticationDataEntry_UserId()));
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateNonHostingCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);

		if (capability instanceof J2CAuthenticationDataEntry) {
			J2CAuthenticationDataEntry j2cAuthDataEntry = (J2CAuthenticationDataEntry) capability;
			if (j2cAuthDataEntry.getUserId() == null || j2cAuthDataEntry.getUserId().length() == 0) {
				IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
						j2cAuthDataEntry, J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID);
				reporter.addStatus(message);
			}
		}
	}
}
