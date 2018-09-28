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
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

public class AddToSharedLibraryForApplicationResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		Unit sourceApp = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_APP);
		Unit wasHost = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_HOST);
		Unit jarModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_TARGET_JAR);
		List<Unit> appSLs = (List) status
				.getAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_APP_SLS);
		List<Unit> serverSLs = (List) status
				.getAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_SERVER_SLS);

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();

		for (Unit sharedLib : appSLs) {
			if (ValidatorUtils.getFirstCapability(sharedLib, WasPackage.Literals.SHARED_LIBRARY_ENTRY)
					.isPublic()) {
				if (WasResolutionUtils.canBeDependencyLinkSource(sharedLib,
						CorePackage.Literals.BUNDLE_CAPABILITY, true)) {
					String appMessage = DeployNLS
							.bind(
									WasDomainMessages.Resolution_add_to_existing_shared_library_0_from_app_for_access_to_1,
									new Object[] { sharedLib.getCaptionProvider().title(sharedLib),
											jarModule.getCaptionProvider().title(jarModule) });

					IDeployResolution resolution = new AddToSharedLibraryForApplicationResolution(
							context, this, appMessage, sourceApp, wasHost, jarModule, sharedLib);
					resolutions.add(resolution);
				}
			}
		}

		for (Unit sharedLib : serverSLs) {
			if (ValidatorUtils.getFirstCapability(sharedLib, WasPackage.Literals.SHARED_LIBRARY_ENTRY)
					.isPublic()) {
				if (WasResolutionUtils.canBeDependencyLinkSource(sharedLib,
						CorePackage.Literals.BUNDLE_CAPABILITY, true)) {
					String appMessage = DeployNLS
							.bind(
									WasDomainMessages.Resolution_add_to_existing_shared_library_0_from_app_for_access_to_1,
									new Object[] { sharedLib.getCaptionProvider().title(sharedLib),
											jarModule.getCaptionProvider().title(jarModule) });

					IDeployResolution resolution = new AddToSharedLibraryForApplicationResolution(
							context, this, appMessage, sourceApp, wasHost, jarModule, sharedLib);
					resolutions.add(resolution);
				}
			}
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		// validate problem type
		if (!IWASProblemType.ADD_TO_SHARED_LIBRARY.equals(status.getProblemType())) {
			return false;
		}

		// verify expected inputs are not null and are of the expected types
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

		List<Unit> appSLs = (List) status
				.getAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_APP_SLS);
		if (null == appSLs) {
			return false;
		}
		for (Unit sl : appSLs) {
			if (!WasPackage.Literals.SHARED_LIBRARY_ENTRY.isSuperTypeOf(sl.getEObject().eClass())) {
				return false;
			}
		}
		List<Unit> serverSLs = (List) status
				.getAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_SERVER_SLS);
		if (null == serverSLs) {
			return false;
		}
		for (Unit sl : serverSLs) {
			if (!WasPackage.Literals.SHARED_LIBRARY_ENTRY.isSuperTypeOf(sl.getEObject().eClass())) {
				return false;
			}
		}

		// check that the resolution will have permission to do what it needs to do
		// for at least one shared library in the lists
		// (a) link _appModule to sharedLib
		// (b) link to jar
		// (c) remove utility jar from appModule 
		// (d) update utility jar hosting requirement (type os:directory) to be "required"
		// (e) TODO update classpath to include jar

		// (a) link _appModule to sharedLib
		// _appModule must have available dependency requirement or must be able to create one
		// _appModule here may be 'sourceApp' or 'appModule'; if either holds; return true
		// sharedLib must be public (see loop below)
		if (!WasResolutionUtils.canBeDependencyLinkSource(sourceApp,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY, true)) {
			return false;
		}

		boolean foundOne = false;
		for (Unit sl : appSLs) {
			if (ValidatorUtils.getFirstCapability(sl, WasPackage.Literals.SHARED_LIBRARY_ENTRY)
					.isPublic()) {
				if (WasResolutionUtils.canBeDependencyLinkSource(sl,
						CorePackage.Literals.BUNDLE_CAPABILITY, true)) {
					// we found one that works
					foundOne = true;
					break;
				}
			}
		}
		if (!foundOne) {
			for (Unit sl : serverSLs) {
				if (ValidatorUtils.getFirstCapability(sl, WasPackage.Literals.SHARED_LIBRARY_ENTRY)
						.isPublic()) {
					if (WasResolutionUtils.canBeDependencyLinkSource(sl,
							CorePackage.Literals.BUNDLE_CAPABILITY, true)) {
						// we found one that works
						foundOne = true;
						break;
					}
				}
			}
		}
		if (!foundOne) {
			return false;
		}

		// (b) link to jar
		// shared library requirement must be public (see loop above)
		// jar bundle capability must be public
		Capability bundleCap = ValidatorUtils.getCapability(jarModule,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (!bundleCap.isPublic()) {
			return false;
		}

		// (c) remove utility jar from appModule 
		// to delete member link it must be in the edit topology
		if (WasResolutionUtils.canRemoveMemberLink(sourceApp, jarModule)) {
			return false;
		}

		// (d) update utility jar hosting requirement (type os:directory) to be "required"
		List<Requirement> reqs = ValidatorUtils.getRequirements(jarModule,
				OsPackage.Literals.DIRECTORY);
		for (Requirement req : reqs) {
			if (req.getUse().equals(RequirementUsage.OPTIONAL_LITERAL)) {
				if (!DeployModelObjectUtil.isSettable(req, CorePackage.Literals.REQUIREMENT__USE)) {
					return false;
				}
			}
		}

		// (e) TODO update classpath to include jar

		return true;
	}

}
