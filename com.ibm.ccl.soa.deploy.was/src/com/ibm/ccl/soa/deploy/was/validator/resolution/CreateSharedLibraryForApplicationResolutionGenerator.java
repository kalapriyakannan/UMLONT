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
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;

/**
 * Resolution generator for resolution to create a shared library reference hosted on WAS that is
 * used by an application.
 */
public class CreateSharedLibraryForApplicationResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		//		Unit appModule = (Unit) status.getAttribute (WasValidationUtilCREATE_SHARED_LIBRARY_REFERER);
		Unit sourceApp = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_APP);
		Unit wasHost = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_HOST);
		Unit jarModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_TARGET_JAR);

		String appMessage = DeployNLS.bind(
				WasDomainMessages.Resolution_create_new_shared_library_from_app_for_access_to_0,
				new Object[] { jarModule.getCaptionProvider().title(jarModule) });

		return new IDeployResolution[] { new CreateSharedLibraryForApplicationResolution(context,
				this, appMessage, sourceApp, wasHost, jarModule) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		Unit sourceApp = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_APP);
		Unit wasHost = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_HOST);
		Unit jarModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_TARGET_JAR);
		if (null == sourceApp || null == wasHost || null == jarModule) {
			return false;
		}

		// check that resolution will have the needed permissions
		// (a) create shared library
		// (b) host shared library on the wasServer/Cluster
		// (c) link _appModule to sharedLib
		// (d) link to jar
		// (e) remove utility jar from appModule 
		// (f) update utility jar hosting requirement (type os:directory) to be "required"

		// (a) create shared library
		// can always do create new unit

		// (b) host shared library on the wasServer/Cluster
		// wasHost must be public
		if (!wasHost.isPublic()) {
			return false;
		}

		// (c) link _appModule to sharedLib
		// need to be able to create a new shared library requirement on the app module or link to an existing one
		// target shared library is new so can always link to it
		Requirement slReq = WasJ2eeValidatorUtils.getAvailableRequirement(sourceApp,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (slReq == null) {
			// none; need to be able to create a new shared library requirement
			// sourceApp must be public
			if (!sourceApp.isPublic()) {
				return false;
			}
		}

		// (d) link to jar
		// link source is on new shared lib; can be editted
		// link target (capability on jar module) must be public
		Capability bundleCap = ValidatorUtils.getCapability(jarModule,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (!bundleCap.isPublic()) {
			return false;
		}

		// (e) remove utility jar from appModule 
		// to delete member link it must be in the edit topology
		if (WasResolutionUtils.canRemoveMemberLink(sourceApp, jarModule)) {
			return false;
		}

		// (f) update utility jar hosting requirement (type os:directory) to be "required"
		List<Requirement> reqs = ValidatorUtils.getRequirements(jarModule,
				OsPackage.Literals.DIRECTORY);
		for (Requirement req : reqs) {
			if (req.getUse().equals(RequirementUsage.OPTIONAL_LITERAL)) {
				if (!DeployModelObjectUtil.isSettable(req, CorePackage.Literals.REQUIREMENT__USE)) {
					return false;
				}
			}
		}

		return true;
	}

}
