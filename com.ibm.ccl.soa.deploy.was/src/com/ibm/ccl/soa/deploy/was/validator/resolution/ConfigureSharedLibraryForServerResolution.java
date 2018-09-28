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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.matcher.WasLinkDescriptor;

public class ConfigureSharedLibraryForServerResolution extends DeployResolution {
	private final Unit _appModule;
	private final Unit _wasHost;
	private final Unit _jarModule;

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
	 */
	public ConfigureSharedLibraryForServerResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Unit appModule, Unit wasHost,
			Unit jarModule) {
		super(context, generator, message);
//				DeployNLS
//						.bind(
//								WasDomainMessages.Resolution_configure_new_shared_library_for_access_to_0,
//								new Object[] { jarModule.title() }));
		_appModule = appModule;
		_wasHost = wasHost;
		_jarModule = jarModule;
	}

	/*
	 * Create {@link WasSharedLibraryEntryUnit}; host it on the wasServer; host it to app and jar
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		// create shared library
		String templateId = _wasHost.isConceptual() ? IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT_CONCEPTUAL
				: IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT;
		Unit sharedLib = (Unit) ResolutionUtils.addFromTemplate(templateId, _appModule
				.getEditTopology());
		SharedLibraryEntry sharedLibEntry = (SharedLibraryEntry) ValidatorUtils.getFirstCapability(
				sharedLib, WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (null == sharedLibEntry) {
			return Status.CANCEL_STATUS;
		}
		String rdmNum = Double.toString(Math.random());
		rdmNum = rdmNum.substring(rdmNum.length() - 5);
		sharedLibEntry.setSharedLibraryEntryName("sharedLibrary" + rdmNum); //$NON-NLS-1$

		// host shared library on the wasServer/Cluster
		if (null != _wasHost) {
			LinkDescriptor hostingDescriptor = new WasLinkDescriptor(LinkType.HOSTING, _wasHost,
					sharedLib);
			hostingDescriptor.create();
		}

		// link to jar
		// find available requirement
		Requirement bundleReq = WasJ2eeValidatorUtils.getAvailableRequirement(sharedLib,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (bundleReq == null) {
			// none; create new requirement
			bundleReq = WasJ2eeValidatorUtils.addBundleCapabilityRequirement(sharedLib);
		}

		Capability bundleCap = ValidatorUtils.getCapability(_jarModule,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		LinkDescriptor slToJar = new WasLinkDescriptor(LinkType.DEPENDENCY, sharedLib, bundleReq,
				_jarModule, bundleCap);
		slToJar.create();

		// target from class loader policy
		// find class loader policy
		List<Unit> clPolicies = ValidatorUtils.getHosted(_wasHost,
				WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT);
		// we know there is at least one class loader policy (checked in resolution generator)
		// take the first one
		Unit clPolicy = clPolicies.get(0);

		// find available requirement
		Requirement slReq = WasJ2eeValidatorUtils.getAvailableRequirement(clPolicy,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (slReq == null) {
			// none; create new requirement
			slReq = WasJ2eeValidatorUtils.addSharedLibraryEntryRequirement(clPolicy);
		}
		Capability slCap = ValidatorUtils.getCapability(sharedLib,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		LinkDescriptor clToSL = new WasLinkDescriptor(LinkType.DEPENDENCY, clPolicy, slReq,
				sharedLib, slCap);
		clToSL.create();

		// TODO update classpath to include jar
//		List classpath = sharedLibEntry.getClassPath();
//		List<Artifact> artifacts = _jarModule.getArtifacts();
//		for (int i = 0; i < artifacts.size(); i++) {
//			Artifact a = artifacts.get(i);
//			if (a instanceof FileArtifact) {
//				FileArtifact fArtifact = (FileArtifact) a;
//				List uris = fArtifact.getFileURIs();
//				for (int j = 0; j < uris.size(); j++) {
//					String uri = uris.get(j).toString();
//					classpath.add(uri);
//				}
//			}
//		}

		return Status.OK_STATUS;
	}

}
