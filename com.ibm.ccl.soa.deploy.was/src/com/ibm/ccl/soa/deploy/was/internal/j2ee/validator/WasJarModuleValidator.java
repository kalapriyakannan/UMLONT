/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.AdditiveUnitValidator;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.was.WasPackage;

public class WasJarModuleValidator extends AdditiveUnitValidator {

	public WasJarModuleValidator() {
		super(J2eePackage.Literals.JAR_MODULE);
	}

	@Override
	public EClass getUnitType() {
		return J2eePackage.Literals.JAR_MODULE;
	}

	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		validateSharedLibraryReferences(unit, context, reporter);
	}

	protected void validateSharedLibraryReferences(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {

		if (J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(unit.eClass())) {
			JarModule targetJar = (JarModule) unit;

			EarModule sourceApp = getApplication(targetJar);
			Unit appHost = ValidatorUtils.discoverHost(targetJar, context.getProgressMonitor());
			if (appHost == sourceApp || null == appHost && null != sourceApp) {
				appHost = ValidatorUtils.discoverHost(sourceApp, context.getProgressMonitor());
			}

			//MK 6/14/2007 removed this code;  this function should be fulfilled by the CreateSharedLibraryForApplicationAction
//			// want to generate a resolution to pull jar out of application module 
//			// and put it into it's own shared library
//
//			if (appHost != null && sourceApp != null) {
//
//				reporter.addStatus(WasValidationUtil.createSharedLibraryReference(IStatus.INFO,
//						IWasValidatorID.WAS_JAR_CREATE_SHARED_LIBRARY_001, unit, sourceApp, appHost,
//						targetJar));
//
//				List<Unit> appSLs = getSharedLibraryAssociatedWithApplication(sourceApp);
//				List<Unit> serverSLs = getSharedLibrariesAssociatedWithServer(sourceApp);
//
//				if (appSLs.size() > 0 || serverSLs.size() > 0) {
//					reporter.addStatus(WasValidationUtil.addToSharedLibraryReference(IStatus.INFO,
//							IWasValidatorID.WAS_JAR_ADD_TO_SHARED_LIBRARY_001, unit, sourceApp, appHost,
//							targetJar, appSLs, serverSLs));
//				}
//			}
		}
	}

	public EarModule getApplication(Unit module) {
		List<Unit> apps = ValidatorUtils.discoverGroupsByUnitType(module,
				J2eePackage.Literals.EAR_MODULE, module.getEditTopology(), null);

		// we expect a module to be in exactly one application
		if (apps.size() != 1) {
			return null;
		}

		return (EarModule) apps.get(0);
	}

	public List<Unit> getApplicationComponents(EarModule ear) {
		return ValidatorUtils.discoverMembers(ear, ear.getEditTopology(), null);
	}

	public List<Unit> getSharedLibrariesAssociatedWithModule(Unit module) {
		List<Unit> sharedLibs = new ArrayList<Unit>();
		List<Requirement> slReqs = ValidatorUtils.getRequirements(module,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		for (int i = 0; i < slReqs.size(); i++) {
			Requirement slReq = slReqs.get(i);
			Unit sharedLib = ValidatorUtils.discoverDependencyLinkTargetUnit(slReq, null);
			if (null != sharedLib) {
				sharedLibs.add(sharedLib);
			}
		}
		return sharedLibs;
	}

	public List<Unit> getSharedLibraryAssociatedWithApplication(EarModule app) {
		return getSharedLibrariesAssociatedWithModule(app);
	}

	public List<Unit> getSharedLibrariesAssociatedWithServer(EarModule app) {

		List<Unit> sharedLibs = new ArrayList<Unit>();

		Unit wasHost = ValidatorUtils.discoverHost(app, null);
		if (null == wasHost) {
			// not hosted
			return sharedLibs;
		}

		List<Unit> list = ValidatorUtils.discoverHosted(wasHost,
				WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT, null);
		if (list.size() > 0) {
			// return just the first if there is more than one; there should be just one
			Unit clPolicy = list.get(0);

			List<Requirement> slReqs = ValidatorUtils.getRequirements(clPolicy,
					WasPackage.Literals.SHARED_LIBRARY_ENTRY);
			for (int i = 0; i < slReqs.size(); i++) {
				Requirement slReq = slReqs.get(i);
				Unit sharedLib = ValidatorUtils.discoverDependencyLinkTargetUnit(slReq, null);
				if (null != sharedLib) {
					sharedLibs.add(sharedLib);
				}
			}
		}

		sharedLibs.addAll(ValidatorUtils.discoverHosted(wasHost,
				WasPackage.Literals.WAS_SHARED_LIBRARY_ENTRY_UNIT, null));

		return sharedLibs;
	}
}
