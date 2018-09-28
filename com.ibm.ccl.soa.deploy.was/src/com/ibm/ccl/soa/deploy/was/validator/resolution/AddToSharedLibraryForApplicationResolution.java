/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.matcher.WasLinkDescriptor;

public class AddToSharedLibraryForApplicationResolution extends DeployResolution {

	private Unit _appModule;
	private Unit _wasHost;
	private Unit _jarModule;
	private Unit _sharedLib;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param appModule
	 *           the application (or module) accessing the shared library
	 * @param wasHost
	 *           where the shared library should be hosted
	 * @param jarModule
	 *           the target utility jar
	 * @param sharedLib
	 *           the shared library that should be modified
	 */
	public AddToSharedLibraryForApplicationResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Unit appModule, Unit wasHost,
			Unit jarModule, Unit sharedLib) {
		super(context, generator, message);
		_appModule = appModule;
		_wasHost = wasHost;
		_jarModule = jarModule;
		_sharedLib = sharedLib;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		// link _appModule to sharedLib
		// find available requirement
		Requirement slReq = WasJ2eeValidatorUtils.getAvailableRequirement(_appModule,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (slReq == null) {
			// none; create new requirement
			slReq = WasJ2eeValidatorUtils.addSharedLibraryEntryRequirement(_appModule);
		}
		Capability slCap = ValidatorUtils.getCapability(_sharedLib,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		LinkDescriptor appToSL = new WasLinkDescriptor(LinkType.DEPENDENCY, _appModule, slReq,
				_sharedLib, slCap);
		appToSL.create();

		// link to jar
		// find available requirement
		Requirement bundleReq = WasJ2eeValidatorUtils.getAvailableRequirement(_sharedLib,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (bundleReq == null) {
			// none; create new requirement
			bundleReq = WasJ2eeValidatorUtils.addBundleCapabilityRequirement(_sharedLib);
		}

		Capability bundleCap = ValidatorUtils.getCapability(_jarModule,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		LinkDescriptor slToJar = new WasLinkDescriptor(LinkType.DEPENDENCY, _sharedLib, bundleReq,
				_jarModule, bundleCap);
		slToJar.create();

		// remove utility jar from appModule 
		WasJ2eeValidatorUtils.removeJarFromModule(_jarModule, _appModule);

		// update utility jar hosting requirement (type os:directory) to be "required"
		List<Requirement> reqs = _jarModule.getHostingOrAnyRequirements();
		for (int i = 0; i < reqs.size(); i++) {
			Requirement req = reqs.get(i);
			if (req.getDmoEType().equals(OsPackage.Literals.DIRECTORY)
					&& req.getUse().equals(RequirementUsage.OPTIONAL_LITERAL)) {
				req.setUse(RequirementUsage.REQUIRED_LITERAL);

			}
		}

		// TODO update classpath to include jar

		return Status.OK_STATUS;
	}

}
