/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.matcher.WasLinkDescriptor;
import com.ibm.ccl.soa.deploy.was.validator.resolution.CreateSharedLibraryForApplicationResolution;

/**
 * Action (resolution) to refactor an EAR by moving a JAR outside the ear.
 */
public class CreateSharedLibraryForApplicationAction extends DeployResolution {

	private final List<DeployModelObject> _parameters;
	private final WebsphereAppServerUnit _wasHost;
	private final JarModule _jarModule;
	private final EarModule _appModule;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 */
	public CreateSharedLibraryForApplicationAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_parameters = parameters;
		_jarModule = (JarModule) _parameters.get(0);
		_appModule = (EarModule) _parameters.get(1);
		_wasHost = (WebsphereAppServerUnit) _parameters.get(2);
	}

	/**
	 * Code copied from {@link CreateSharedLibraryForApplicationResolution}
	 */
	public IStatus resolve(IProgressMonitor monitor) {

		// create new shared library
		String templateId = _wasHost.isConceptual() ? IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT_CONCEPTUAL
				: IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT;
		Unit sharedLib = (Unit) ResolutionUtils.addFromTemplate(templateId, _jarModule
				.getEditTopology());
		SharedLibraryEntry sharedLibEntry = (SharedLibraryEntry) ValidatorUtils.getFirstCapability(
				sharedLib, WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (null == sharedLibEntry) {
			return Status.CANCEL_STATUS;
		}
		String rdmNum = Double.toString(Math.random());
		rdmNum = rdmNum.substring(rdmNum.length() - 5);
		sharedLibEntry.setSharedLibraryEntryName("sharedLibrary" + rdmNum); //$NON-NLS-1$

		// host shared library on the wasServer
		if (null != _wasHost) {
			LinkDescriptor hostingDescriptor = new WasLinkDescriptor(LinkType.HOSTING, _wasHost,
					sharedLib);
			hostingDescriptor.create();
		}

		// link _appModule to sharedLib
		// find available requirement
		Requirement slReq = WasJ2eeValidatorUtils.getAvailableRequirement(_appModule,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (slReq == null) {
			// none; create new requirement
			slReq = WasJ2eeValidatorUtils.addSharedLibraryEntryRequirement(_appModule);
		}
		Capability slCap = ValidatorUtils.getCapability(sharedLib,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		LinkDescriptor appToSL = new WasLinkDescriptor(LinkType.DEPENDENCY, _appModule, slReq,
				sharedLib, slCap);
		appToSL.create();

		// link to jar with shared lib
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

		// remove utility jar from appModule 
		WasJ2eeValidatorUtils.removeJarFromModule(_jarModule, _appModule);

		// TODO update classpath to include jar

		return Status.OK_STATUS;
	}

}
