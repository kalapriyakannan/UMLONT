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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeNotEqualsValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeNotNullValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.was.WasApplicationMap;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasPluginRedirection;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerOS;
import com.ibm.ccl.soa.deploy.was.WasWebServerType;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;

/**
 * Unit validator for {@link WasWebServerUnit}.
 */
public class WasWebServerUnitValidator extends UnitValidator {

	/**
	 * Construct a validator for {@link WasWebServerUnit}.
	 */
	public WasWebServerUnitValidator() {
		super(WasPackage.eINSTANCE.getWasWebServerUnit());
		init();
	}

	/**
	 * Construct a validator for the specified subtype of {@link WasWebServerUnit}.
	 * 
	 * @param subtype
	 *           a subtype of {@link WasWebServerUnit}.
	 */
	protected WasWebServerUnitValidator(EClass subtype) {
		super(subtype);
		assert WasPackage.eINSTANCE.getWasWebServerUnit().isSuperTypeOf(subtype);
		init();
	}

	/**
	 * Initialize the declarative validators.
	 */
	protected void init() {
		// |WasWebServer| required (non-null) attributes: serverName, type,
		// port, host, installLocation, configFil, nodeName, nodeType,
		// operatingSystem, mapApplications||
		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE
						.getWasWebServer_ServerName(), IStatus.ERROR));

		addAttributeValidator(new DeployAttributeNotEqualsValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE.getWasWebServer_Type(),
				WasWebServerType.UNKNOWN_LITERAL, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE.getWasWebServer_Port(),
				IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE.getWasWebServer_Host(),
				IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE
						.getWasWebServer_InstallLocation(), IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE
						.getWasWebServer_ConfigFile(), IStatus.ERROR));

		// addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
		// IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE
		// .getWasWebServer_NodeName(), IStatus.ERROR));

		addAttributeValidator(new DeployAttributeNotEqualsValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE
						.getWasWebServer_OperatingSystem(), WasWebServerOS.UNKNOWN_LITERAL, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeNotEqualsValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.eINSTANCE
						.getWasWebServer_MapApplications(), WasApplicationMap.UNKNOWN_LITERAL,
				IStatus.ERROR));

		// |WasWebServer|serverName unique in all servers hosted in the WAS
		// system||
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDeployCoreValidators.CORE_UNASSIGNED, WasPackage.Literals.WAS_WEB_SERVER__SERVER_NAME));

		addCapabilityValidator(new UnitCapabilityValidator(WasPackage.Literals.WAS_WEB_SERVER) {

		});
		// |WasWebServer|if (type == IHS) then target of IhsWasModule dependency
		// link must be IHS unit||

		// |WasWebServer|port == IhsWasModule.getTarget().port||
		// TODO add pattern for port propagation

		// |WasWebServer|host ==
		// IhsWasModule.getTarget().getOS().getHostname()||
		/*
		 * CapabilityAttributeToAttributePropagationValidator hostnameValidator = new
		 * CapabilityAttributeToAttributePropagationValidator( IDeployCoreValidators.CORE_UNASSIGNED,
		 * WasPackage.Literals.WAS_WEB_SERVER__HOST, OsPackage.Literals.OPERATING_SYSTEM__HOSTNAME);
		 * hostnameValidator.setSearchRequirementInHostingStack(true);
		 * hostnameValidator.setRequirementDmoType(WasPackage.eINSTANCE .getWasPluginRedirection());
		 * addAttributeValidator(hostnameValidator);
		 */

		// |WasWebServer|useSecureProtocol =
		// IhsWasModule.getTarget().getWindowsIhsServer().isSecure()||
		// TODO generalize target beyond IHS?
		// |WasWebServer|nodeName ||
		// |WasWebServer|if nodeType == MANAGED check that
		// IhsWasModule.getTarget() is hosted on an OS with a WasSystem
		// configured with a WasNode of the specified nodeName||
		// new LinkTargetHostValidator(IDeployCoreValidators.CORE_UNASSIGNED,
		// IHS_TYPE,
		// |WasWebServer|operatingSystem == IhsWasModule.getTarget().getOS()||
		// ValidatorUtils.getLinkTarget(IHS_Type);
		// Need HTTP domain
		// |WasWebServer|if WAS is not Network Deployment only one WebServer
		// allowed per system||
		// +|WasWebServer|On base, web server must be on an unmanaged node||
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);
		if (!(capability instanceof WasWebServer)) {
			return;
		}
		WasWebServer webServer = (WasWebServer) capability;

		WasPluginRedirection redirect = (WasPluginRedirection) ValidatorUtils
				.discoverFirstRequirementLinkTarget(webServer, WasPackage.eINSTANCE
						.getWasPluginRedirection(), context.getProgressMonitor());
		if (redirect == null) {
			return;
		}

		// validateAttributeEquals(server,
		// WasPackage.eINSTANCE.getWasWebServer_InstallLocation(),

	}
}
