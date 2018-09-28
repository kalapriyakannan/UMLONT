/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Configure a shared library refernced by an application and refering to a target utility.
 */
public class ConfigureSharedLibraryForApplicationResolutionGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		Unit appModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_REFERER);
		Unit sourceApp = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_APP);
		Unit wasHost = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_HOST);
		Unit jarModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_TARGET_JAR);

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		if (WasResolutionUtils.canBeDependencyLinkSource(sourceApp,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY, true)) {
			String appMessage = DeployNLS.bind(
					WasDomainMessages.Resolution_configure_new_shared_library_from_app_for_access_to_0,
					new Object[] { jarModule.getCaptionProvider().title(jarModule) });
			new ConfigureSharedLibraryForApplicationResolution(context, this, appMessage, sourceApp,
					wasHost, jarModule);
		}

		if (WasResolutionUtils.canBeDependencyLinkSource(appModule,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY, true)) {
			String moduleMessage = DeployNLS
					.bind(
							WasDomainMessages.Resolution_configure_new_shared_library_from_module_for_access_to_0,
							new Object[] { jarModule.getCaptionProvider().title(jarModule) });
			resolutions.add(new ConfigureSharedLibraryForApplicationResolution(context, this,
					moduleMessage, appModule, wasHost, jarModule));
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		if (!IWASProblemType.MISSING_SHARED_LIBARY.equals(status.getProblemType())) {
			return false;
		}

		// verify expected inputs are not null and are of the expected types
		Unit appModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_REFERER);
		if (null == appModule) {
			return false;
		}
		if (!J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(appModule.getEObject().eClass())
				&& !J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(appModule.getEObject().eClass())) {
			return false;
		}
		Unit sourceApp = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_APP);
		if (null == sourceApp
				|| !J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceApp.getEObject().eClass())) {
			return false;
		}
		Unit wasHost = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_HOST);
		if (null == wasHost) {
			return false;
		}
		if (!WasPackage.Literals.WAS_CLUSTER_UNIT.isSuperTypeOf(wasHost.getEObject().eClass())
				&& !WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(wasHost.getEObject()
						.eClass())) {
			return false;
		}
		Unit jarModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_TARGET_JAR);
		if (null == jarModule
				|| !J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(jarModule.getEObject().eClass())) {
			return false;
		}

		// check that the resolution will have permission to do what it needs to do:
		// (a) create shared library
		// (b) host shared library on the wasServer/Cluster
		// (c) link _appModule to sharedLib
		// (d) link to jar
		// (e) TODO update classpath to include jar

		// (a) create shared library
		// can always create a new shared library in the edit topology

		// (b) host shared library on the wasServer/Cluster
		// shared library can be hosted (it is in the edit topology)
		// wasHost must be public
		if (!wasHost.isPublic()) {
			return false;
		}

		// (c) link (dependency) _appModule to sharedLib
		// _appModule must have available dependency requirement or must be able to create one
		// _appModule here may be 'sourceApp' or 'appModule'; if either holds; return true
		if (!WasResolutionUtils.canBeDependencyLinkSource(appModule,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY, true)
				&& !WasResolutionUtils.canBeDependencyLinkSource(sourceApp,
						WasPackage.Literals.SHARED_LIBRARY_ENTRY, true)) {
			return false;
		}

		// (d) link (dependency) sharedLib to jar
		// jar bundle capability must be public
		Capability bundleCap = ValidatorUtils.getCapability(jarModule,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (!bundleCap.isPublic()) {
			return false;
		}

		// (e) TODO update classpath to include jar

		return true;
	}

}
