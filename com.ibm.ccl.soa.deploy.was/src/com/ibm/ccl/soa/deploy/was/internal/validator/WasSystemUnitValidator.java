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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link WasSystemUnit}
 */
public class WasSystemUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasSystemUnit();
	}

	/**
	 * 
	 */
	public WasSystemUnitValidator() {
		super(WasPackage.eINSTANCE.getWasSystemUnit());
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSystem(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_SYSTEM_WAS_VERSION_EMPTY_001,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_SYSTEM_WAS_HOME_EMPTY_001,
				WasPackage.Literals.WAS_SYSTEM__WAS_HOME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.WAS_SYSTEM_WAS_HOME_UNIQUENESS_001,
				WasPackage.Literals.WAS_SYSTEM__WAS_HOME));

		//validator for checking whether wasHome and InstallerDir fit for the OS Dir style
		DeployAttributeInvalidPathnameValidator wasSystemInstallerPathValidator = new DeployAttributeInvalidPathnameValidator(
				IWasValidatorID.WAS_SYSTEM_UNIT_INSTALLER_DIR_INVALID_001,
				WasPackage.Literals.WAS_SYSTEM__INSTALLER_DIR);
		wasSystemInstallerPathValidator.setRequireDriveLetterWindows(true);
		wasSystemInstallerPathValidator.setRequireRootedPathUnix(true);
		addAttributeValidator(wasSystemInstallerPathValidator);

		DeployAttributeInvalidPathnameValidator wasSystemWasHomePathValidator = new DeployAttributeInvalidPathnameValidator(
				IWasValidatorID.WAS_SYSTEM_UNIT_WAS_HOME_INVALID_001,
				WasPackage.Literals.WAS_SYSTEM__WAS_HOME);
		wasSystemWasHomePathValidator.setRequireDriveLetterWindows(true);
		wasSystemWasHomePathValidator.setRequireRootedPathUnix(true);
		addAttributeValidator(wasSystemWasHomePathValidator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		validateWasNodesDefaultProfileUniqueOnWasSystem(unit, reporter, context.getProgressMonitor());

		WasSystem wasSystemCap = (WasSystem) ValidatorUtils.getCapability(unit,
				WasPackage.Literals.WAS_SYSTEM);
		if (wasSystemCap == null) {
			return;
		}
		ValidatorUtils.validateStrictVersionNumberSyntax(wasSystemCap,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION, reporter);

		//
		// Analyze profiles
		//
		List profileNodeList = new ArrayList();
		List noProfileNodeList = new ArrayList();
		List hostedNodeList = ValidatorUtils.discoverHostedCapabilities(unit, WasPackage.eINSTANCE
				.getWasNode(), false, context.getProgressMonitor());
		for (Iterator iter = hostedNodeList.iterator(); iter.hasNext();) {
			WasNode node = (WasNode) iter.next();
			if (node.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
				noProfileNodeList.add(node);
			} else {
				profileNodeList.add(node);
			}
		}
		//
		// Base: requires a default profile
		//
		if (wasSystemCap.getWasEdition() == WasEditionEnum.BASE_LITERAL) {
			if (profileNodeList.size() == 0) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(unit
						.isConceptual() ? IStatus.INFO : IStatus.ERROR,
						IWasValidatorID.WAS_SYSTEM_BASE_PROFILE_CARDINALITY_001,
						IWASProblemType.WAS_BASE_MISSING_DEFAULT_PROFILE,
						WasDomainMessages.Validator_WAS_base_system_0_missing_default_profile,
						new Object[] { unit }, unit);
				reporter.addStatus(status);
			}
		}
	}

	/**
	 * validate there is one and only one WasNodeUnit hosts on this wasSystem has the
	 * wasNode.isDefaultProfile == true
	 * 
	 * @param unit
	 */
	private void validateWasNodesDefaultProfileUniqueOnWasSystem(Unit unit,
			IDeployReporter reporter, IProgressMonitor monitor) {
		assert unit instanceof WasSystemUnit;
		List<Capability> hostedWasNodeList = ValidatorUtils.discoverHostedCapabilities(unit,
				WasPackage.Literals.WAS_NODE, false, monitor);
		if (hostedWasNodeList.isEmpty()) {
			// When no Nodes defined on System, no need for a default profile
			return;
		}
		List<WasNode> defaultProfileNodeList = new ArrayList<WasNode>();
		for (Capability nodeCap : hostedWasNodeList) {
			WasNode node = (WasNode) nodeCap;
			if (node != null && node.isIsDefaultProfile()) {
				defaultProfileNodeList.add(node);
			}
		}
		if (defaultProfileNodeList.isEmpty()) {
			IDeployStatus message = DeployWasMessageFactory.createOmitDefaultProfileNodeStatus(unit);
			reporter.addStatus(message);
		} else if (defaultProfileNodeList.size() > 1) {
			IDeployStatus message = DeployWasMessageFactory.createMoreThanOneDefaultProfileNodeStatus(
					unit, defaultProfileNodeList);
			reporter.addStatus(message);
		}
	}
}
