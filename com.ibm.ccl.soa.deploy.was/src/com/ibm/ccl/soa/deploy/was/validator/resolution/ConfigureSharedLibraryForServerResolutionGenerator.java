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
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Configure a shared library refernced by an application and refering to a target utility.
 */
public class ConfigureSharedLibraryForServerResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		Unit sourceApp = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_APP);
		Unit wasHost = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_HOST);
		Unit jarModule = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_TARGET_JAR);

		String serverMessage = DeployNLS.bind(
				WasDomainMessages.Resolution_configure_new_shared_library_from_server_for_access_to_0,
				new Object[] { jarModule.getCaptionProvider().title(jarModule) });

		return new IDeployResolution[] { new ConfigureSharedLibraryForServerResolution(context, this,
				serverMessage, sourceApp, wasHost, jarModule), };
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

		// if no class loader policy hosted on server, then can't offer resolution
		List<Unit> clPolicies = ValidatorUtils.getHosted(wasHost,
				WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT);
		if (clPolicies.size() < 1) {
			return false;
		}

		// check that the resolution will have permission to do what it needs to do:
		// (a) create shared library
		// (b) host shared library on the wasServer/Cluster
		// (c) link to jar
		// (d) target from class loader policy

		// (a) create shared library
		// can always create a new shared library in the edit topology

		// (b) host shared library on the wasServer/Cluster
		// wasHost must be public
		if (!wasHost.isPublic()) {
			return false;
		}

		// (c) link to jar
		// source is new shared library so can create link
		// target jar capability must be public
		Capability bundleCap = ValidatorUtils.getCapability(jarModule,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (!bundleCap.isPublic()) {
			return false;
		}

		// (d) create dependency link from class loader policy to new shared library
		// new shared library is in edit topology; 
		// must check that can find existing public requirement on class loader policy or it is public and can add one
		// we know there is at least 1 class loader policy; there should be only 1
		Unit clPolicy = clPolicies.get(0);
		Requirement slReq = WasJ2eeValidatorUtils.getAvailableRequirement(clPolicy,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (slReq == null) {
			if (!clPolicy.isPublic()) {
				return false;
			}
		}

		return true;
	}
}
