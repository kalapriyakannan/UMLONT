/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServer;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;
import com.ibm.ccl.soa.deploy.ihs.validator.IhsValidatorUtil;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasPluginAdmin;
import com.ibm.ccl.soa.deploy.was.WasPluginRedirection;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerManagement;
import com.ibm.ccl.soa.deploy.was.WasWebServerOS;
import com.ibm.ccl.soa.deploy.was.WasWebServerPlugin;
import com.ibm.ccl.soa.deploy.was.WasWebServerType;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDomainMessages;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * Validates {@link IhsWasPluginUnit}.
 */
public class IhsWasPluginUnitValidator extends UnitValidator {

	public IhsWasPluginUnitValidator() {
		this(WaswebpluginPackage.eINSTANCE.getIhsWasPluginUnit());
	}

	protected IhsWasPluginUnitValidator(EClass unitType) {
		super(unitType);

		addAttributeValidator(new DeployAttributeInvalidPathnameValidator(
				IWasWebPluginDomainValidators.IHS_WAS_PLUGIN_INSTALL_LOCATION_001,
				WaswebpluginPackage.eINSTANCE.getIhsWasPlugin_InstallLocation(), true));
		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IWasWebPluginDomainValidators.UNDEFINED, IhsPackage.eINSTANCE.getIhsSystem(),
				OsPackage.eINSTANCE.getOperatingSystem(), IStatus.ERROR));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateDependencyLink(com.ibm.ccl.soa.deploy.core.DependencyLink,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	protected void validateDependencyLink(DependencyLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateDependencyLink(link, unit, context, reporter);

		IhsWasPluginUnit wasPluginUnit = (IhsWasPluginUnit) unit;
		if (!(link.getTarget() instanceof IhsSystem)) {
			return;
		}

		IhsSystem ihsSystem = (IhsSystem) link.getTarget();

		//
		// Check the linking pattern of IHS <- WAS IHS Plugin <- WasWebServer
		//
		IhsWasPluginConfigurationActivePattern pattern = new IhsWasPluginConfigurationActivePattern(
				wasPluginUnit);
		if (!pattern.find(false, context.getProgressMonitor()).isOK()) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IWasWebPluginDomainValidators.IHS_WAS_PLUGIN_CONFIGURED_002,
					IWasWebPluginProblemTypes.IHS_WAS_PLUGIN_MODULE_CONFIGURATION_ERROR,
					WasWebPluginDomainMessages.Validator_IHS_not_configured_for_WAS_plugin, null, link);
			reporter.addStatus(status);
		}

		//
		// Propagate from WAS plugin redirection module to WasWebServer
		//
		// TODO: move to pattern?
		WasPluginRedirection redirection = WaswebpluginValidatorUtil
				.discoverWasPluginRedirection(ihsSystem);
		if (redirection != null) {
			IhsServer ihsContentServer = (IhsServer) ValidatorUtils.getFirstCapability(ValidatorUtils
					.discoverHost(redirection, context.getProgressMonitor()), IhsPackage.eINSTANCE
					.getIhsServer());
			WindowsLocalService ihsContentWindowsService = null;
			if (ihsContentServer != null) {
				ihsContentWindowsService = (WindowsLocalService) ValidatorUtils
						.getFirstCapability((Unit) ihsContentServer.getParent(), OsPackage.eINSTANCE
								.getWindowsLocalService());
			}

			WasWebServer[] redirectWebServers = WaswebpluginValidatorUtil
					.discoverWasWebServers(redirection);
			if (redirectWebServers.length > 1) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IWasWebPluginDomainValidators.UNDEFINED,
						ICoreProblemType.UNIT_CAPABILITY_LINK_CARDINALITY_INVALID,
						WasWebPluginDomainMessages.WAS_plugin_module_0_redirects_to_multiple_web_servers,
						null, redirection);
				reporter.addStatus(status);
			} else if (redirectWebServers.length == 1) {
				WasWebServer redirectionWebServer = redirectWebServers[0];

				// <attribute name="installLocation" type="string"/>
				ValidatorUtils.validatePropagation(ihsSystem, IhsPackage.eINSTANCE
						.getIhsSystem_InstallLocation(), redirectionWebServer, WasPackage.eINSTANCE
						.getWasWebServer_InstallLocation(), IWasWebPluginDomainValidators.UNDEFINED,
						context, reporter);

				// <attribute name="port" type="integer"/>
				Port port = IhsValidatorUtil.getPort((IhsServer) ValidatorUtils.discoverHostCapability(
						redirection, IhsPackage.eINSTANCE.getIhsServer(), context.getProgressMonitor()));
				ValidatorUtils.validatePropagation(port, OsPackage.eINSTANCE.getPort_Port(),
						redirectionWebServer, WasPackage.eINSTANCE.getWasWebServer_Port(),
						IWasWebPluginDomainValidators.UNDEFINED, context, reporter);

				// <attribute name="host" type="string"/>
				if (port != null && port.getIpAddressOrHostname() != null) {
					ValidatorUtils.validatePropagation(port, OsPackage.eINSTANCE
							.getPort_IpAddressOrHostname(), redirectionWebServer, WasPackage.eINSTANCE
							.getWasWebServer_Host(), IWasWebPluginDomainValidators.UNDEFINED, context,
							reporter);
				} else {
					OperatingSystem os = (OperatingSystem) ValidatorUtils.discoverHostCapability(port,
							OsPackage.eINSTANCE.getOperatingSystem(), true, context.getProgressMonitor());
					ValidatorUtils.validatePropagation(os, OsPackage.eINSTANCE
							.getOperatingSystem_Hostname(), redirectionWebServer, WasPackage.eINSTANCE
							.getWasWebServer_Host(), IWasWebPluginDomainValidators.UNDEFINED, context,
							reporter);
				}

				// <attribute name="configFile" type="string"/>
				ValidatorUtils.validatePropagation(ihsContentServer, IhsPackage.eINSTANCE
						.getIhsServer_ConfigFile(), redirectionWebServer, WasPackage.eINSTANCE
						.getWasWebServer_ConfigFile(), IWasWebPluginDomainValidators.UNDEFINED, context,
						reporter);

				// <attribute name="useSecureProtocol" type="boolean"/>
				ValidatorUtils.validatePropagation(ihsContentServer, IhsPackage.eINSTANCE
						.getIhsServer_Secure(), redirectionWebServer, WasPackage.eINSTANCE
						.getWasWebServer_UseSecureProtocol(), IWasWebPluginDomainValidators.UNDEFINED,
						context, reporter);

				// <attribute name="type" type="was:WasWebServerType"/>
				ValidatorUtils.validateEquals(redirectionWebServer, WasPackage.eINSTANCE
						.getWasWebServer_Type(), WasWebServerType.IHS_LITERAL,
						IWasWebPluginDomainValidators.UNDEFINED, context, reporter);

				// <attribute name="logFileError" type="string"/>

				// <attribute name="logFileAccess" type="string"/>

				// <attribute name="serviceName" type="string"/>
				ValidatorUtils.validatePropagation(ihsContentWindowsService, OsPackage.eINSTANCE
						.getWindowsLocalService_ServiceName(), redirectionWebServer, WasPackage.eINSTANCE
						.getWasWebServer_ServiceName(), IWasWebPluginDomainValidators.UNDEFINED, context,
						reporter);

				// <attribute name="operatingSystem" type="was:WasWebServerOS"/>
				OperatingSystem os = (OperatingSystem) ValidatorUtils.discoverHostCapability(
						(Unit) ihsContentServer.getParent(), OsPackage.eINSTANCE.getOperatingSystem(),
						true, context.getProgressMonitor());
				WasWebServerOS osType = null;
				if (os instanceof WindowsOperatingSystem) {
					osType = WasWebServerOS.WINDOWS_LITERAL;
				} else if (os instanceof LinuxOperatingSystem) {
					osType = WasWebServerOS.LINUX_LITERAL;
				} else {
					// TODO add warning?
				}
				if (osType != null) {
					ValidatorUtils.validateEquals(redirectionWebServer, WasPackage.eINSTANCE
							.getWasWebServer_OperatingSystem(), osType,
							IWasWebPluginDomainValidators.UNDEFINED, context, reporter);
				}

				// <attribute name="mapApplications"
				// type="was:WasApplicationMap"/>
			}
		}

		//
		// Propagate from WAS plugin admin module to WasWebServer
		//
		WasPluginAdmin admin = WaswebpluginValidatorUtil.discoverWasPluginAdmin(ihsSystem);
		if (admin != null) {
			IhsServer ihsAdminServer = (IhsServer) ValidatorUtils.getFirstCapability(ValidatorUtils
					.discoverHost(admin, context.getProgressMonitor()), IhsPackage.eINSTANCE
					.getIhsServer());
			WasWebServerManagement[] adminWebServers = WaswebpluginValidatorUtil
					.discoverWasWebServerManagement(admin);
			if (adminWebServers.length > 1) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IWasWebPluginDomainValidators.UNDEFINED,
						ICoreProblemType.UNIT_CAPABILITY_LINK_CARDINALITY_INVALID,
						WasWebPluginDomainMessages.WAS_plugin_module_0_redirects_to_multiple_web_servers,
						null, admin);
				reporter.addStatus(status);
			} else if (adminWebServers.length == 1) {
				WasWebServerManagement webServerMgmt = adminWebServers[0];

				// <attribute name="port" type="integer"/>
				Port port = IhsValidatorUtil.getPort((IhsServer) ValidatorUtils.discoverHostCapability(
						admin, IhsPackage.eINSTANCE.getIhsServer(), context.getProgressMonitor()));
				ValidatorUtils.validatePropagation(port, OsPackage.Literals.PORT__PORT, webServerMgmt,
						WasPackage.eINSTANCE.getWasWebServerManagement_Port(),
						IWasWebPluginDomainValidators.UNDEFINED, context, reporter);

				// <attribute name="host" type="string"/>
				if (port != null && port.getIpAddressOrHostname() != null) {
					ValidatorUtils.validatePropagation(port, OsPackage.eINSTANCE
							.getPort_IpAddressOrHostname(), webServerMgmt, WasPackage.eINSTANCE
							.getWasWebServerManagement_Host(), IWasWebPluginDomainValidators.UNDEFINED,
							context, reporter);
				} else {
					OperatingSystem os = (OperatingSystem) ValidatorUtils.discoverHostCapability(port,
							OsPackage.eINSTANCE.getOperatingSystem(), true, context.getProgressMonitor());
					ValidatorUtils.validatePropagation(os, OsPackage.eINSTANCE
							.getOperatingSystem_Hostname(), webServerMgmt, WasPackage.eINSTANCE
							.getWasWebServerManagement_Host(), IWasWebPluginDomainValidators.UNDEFINED,
							context, reporter);
				}

				// <attribute name="useSecureProtocol" type="boolean"/>
				ValidatorUtils.validatePropagation(ihsAdminServer, IhsPackage.eINSTANCE
						.getIhsServer_Secure(), webServerMgmt, WasPackage.eINSTANCE
						.getWasWebServerManagement_UseSecureProtocol(),
						IWasWebPluginDomainValidators.UNDEFINED, context, reporter);

				// <attribute name="autoConfigPropagation" type="boolean"/>
				IhsWasAdminModule ihsWasAdminModule = (IhsWasAdminModule) ValidatorUtils
						.getFirstHostedCapability((Unit) ihsAdminServer.getParent(), IhsPackage.eINSTANCE
								.getIhsWasAdminModule());
				if (webServerMgmt.isAutoConfigPropagation() && ihsWasAdminModule != null) {
					// <attribute name="userId" type="string"/>
					// <attribute name="password" type="string"/>
					List users = ValidatorUtils.discoverHostedCapabilities((Unit) ihsWasAdminModule
							.getParent(), IhsPackage.eINSTANCE.getIhsUser(), false, context
							.getProgressMonitor());
					boolean userMatch = false;
					for (Iterator iter = users.iterator(); iter.hasNext();) {
						IhsUser user = (IhsUser) iter.next();
						if (user.getUserId() != null
								&& user.getUserId().equals(webServerMgmt.getUserId())) {
							ValidatorUtils.validatePropagation(user, HttpPackage.eINSTANCE
									.getHttpUser_UserPassword(), webServerMgmt, WasPackage.eINSTANCE
									.getWasWebServerManagement_Password(),
									IWasWebPluginDomainValidators.UNDEFINED, context, reporter);
							userMatch = true;
							break;
						}
					}
					if (!userMatch && users.size() == 0) {
						IDeployStatus status = DeployCoreStatusFactory.INSTANCE
								.createDeployStatus(
										IStatus.ERROR,
										IWasWebPluginDomainValidators.UNDEFINED,
										IWasWebPluginProblemTypes.IHS_WAS_PLUGIN_ADMIN_MODULE_HAS_NO_USER,
										WasWebPluginDomainMessages.Validator_IHS_admin_plugin_0_requires_user_for_remote_access,
										new Object[] { ihsWasAdminModule.getParent() }, ihsWasAdminModule);
						reporter.addStatus(status);
					} else if (!userMatch && users.size() > 0) {
						IhsUser user = (IhsUser) users.get(0);
						ValidatorUtils.validatePropagation(user, HttpPackage.eINSTANCE
								.getHttpUser_UserId(), webServerMgmt, WasPackage.eINSTANCE
								.getWasWebServerManagement_UserId(),
								IWasWebPluginDomainValidators.UNDEFINED, context, reporter);
						ValidatorUtils.validatePropagation(user, HttpPackage.eINSTANCE
								.getHttpUser_UserPassword(), webServerMgmt, WasPackage.eINSTANCE
								.getWasWebServerManagement_Password(),
								IWasWebPluginDomainValidators.UNDEFINED, context, reporter);
					}
				}

				//
				// WasWebServerPlugin capablity validation
				//
				WasWebServerPlugin wasWebServerPlugin = (WasWebServerPlugin) ValidatorUtils
						.getFirstCapability((Unit) webServerMgmt.getParent(), WasPackage.eINSTANCE
								.getWasWebServerPlugin());
				IhsWasPlugin ihsWasPlugin = (IhsWasPlugin) ValidatorUtils.getFirstCapability(unit,
						WaswebpluginPackage.eINSTANCE.getIhsWasPlugin());
				ValidatorUtils.validatePropagation(ihsWasPlugin, WaswebpluginPackage.eINSTANCE
						.getIhsWasPlugin_InstallLocation(), wasWebServerPlugin, WasPackage.eINSTANCE
						.getWasWebServerPlugin_InstallLocation(),
						IWasWebPluginDomainValidators.UNDEFINED, context, reporter);
			}
		}
	}
}
