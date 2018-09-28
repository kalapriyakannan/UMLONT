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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class WasNodeWindowsServiceUnitValidator extends ConfigurationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.Literals.WAS_NODE_WINDOWS_SERVICE_UNIT;
	}

	public WasNodeWindowsServiceUnitValidator() {
		super();
		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getWindowsLocalService(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNode(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(OsPackage.eINSTANCE.getUser(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);
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
		Topology top = unit.getTopology();
		if (top == null) {
			return;
		}

		checkStartType((WindowsLocalService) ValidatorUtils.getCapability(unit, OsPackage.eINSTANCE
				.getWindowsLocalService()), reporter);

		//Validate that the hosting operating system (ie, that hosts the WasSystemUnit that hosts the WasNodeUnit) is a Windows operating system.
		//add relevent resolution
		WasNodeUnit nodeUnit = (WasNodeUnit) TopologyDiscovererService.INSTANCE.findHost(unit, top);
		if (nodeUnit == null) {
			return;
		}
		List reqL = ValidatorUtils.getRequirements(unit, WasPackage.eINSTANCE.getWasNode());
		if (reqL == null || reqL.size() <= 0) {
			return;
		}

		Requirement req = (Requirement) reqL.get(0);
		WasSystemUnit wasSystemUnit = (WasSystemUnit) TopologyDiscovererService.INSTANCE.findHost(
				nodeUnit, top);
		if (wasSystemUnit == null) {
			return;
		}

		OperatingSystemUnit osUnit = (OperatingSystemUnit) TopologyDiscovererService.INSTANCE
				.findHost(wasSystemUnit, top);
		if (osUnit == null) {
			return;
		}

		OperatingSystem oscap = (OperatingSystem) ValidatorUtils.getCapability(osUnit,
				OsPackage.eINSTANCE.getOperatingSystem());
		if (oscap == null) {
			return;
		}
		if (!(oscap instanceof WindowsOperatingSystem)) {
			IDeployStatus message = DeployWasMessageFactory.createHostingTargetOSInvalidStatus(unit,
					req);
			reporter.addStatus(message);
		}
	}

	private void checkStartType(WindowsLocalService winLocalServiceCap, IDeployReporter reporter) {
		if (winLocalServiceCap == null) {
			return;
		}
		//Validate that WindowsService.startType is one of: Automatic, Manual or Disabled (ie, Boot and System are not valid for Was)
		WindowsServiceStartupType startType = winLocalServiceCap.getStartupType();
		if (startType.equals(WindowsServiceStartupType.BOOT_LITERAL)
				|| startType.equals(WindowsServiceStartupType.SYSTEM_LITERAL)) {
			IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
					IWasValidatorID.WAS_NODE_WINDOWSSERVICE_STARTTYPE_001, winLocalServiceCap,
					OsPackage.eINSTANCE.getWindowsLocalService_StartupType(),
					WindowsServiceStartupType.MANUAL_LITERAL);
			reporter.addStatus(message);
		}
	}
}
