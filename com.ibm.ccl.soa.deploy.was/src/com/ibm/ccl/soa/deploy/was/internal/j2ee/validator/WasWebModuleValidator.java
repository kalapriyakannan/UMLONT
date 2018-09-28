/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.AdditiveUnitValidator;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validate instances of {@link WebModule} hosted on WAS.
 */
public class WasWebModuleValidator extends AdditiveUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return J2eePackage.Literals.WEB_MODULE;
	}

	/**
	 * Constructor
	 */
	public WasWebModuleValidator() {
		super(J2eePackage.Literals.WEB_MODULE);

		this.addRequirementTypeConstraint(WasPackage.Literals.SHARED_LIBRARY_ENTRY,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(WasPackage.Literals.WAS_WEB_APP_EXT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);

	}

	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// find WAS specific requirements and validate them

		// if not hosted on WAS then quit
		if (!WasJ2eeValidatorUtils.isJ2eeHostedOnWas(unit)) {
			return;
		}

		validateExpectedConstraints(unit, context, reporter);

		validateSharedLibraryReferences(unit, context, reporter);
	}

	protected void validateSharedLibraryReferences(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		List<Requirement> reqs = ValidatorUtils.getRequirements(unit,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		for (int i = 0; i < reqs.size(); i++) {
			Requirement r = reqs.get(i);
			UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findTarget(unit, r, unit
					.getEditTopology(), new NullProgressMonitor());
			if (null == ud) {
				// no link
				continue;
			}
			Unit target = ud.getUnitValue();
			if (!J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(target.getEObject().eClass())) {
				// target not a JAR module
				continue;
			}

			// we have found a BUNDLE_CAPABILITY that refers to a JAR
			JarModule targetJar = (JarModule) target;

			boolean jarInSameApp = false;
			// jar may be contained in the same web module
			List<Unit> webMods = getContainingWebApplications(targetJar);
			if (0 < webMods.size()) {
				for (Unit webMod : webMods) {
					if (webMod == unit) {
						jarInSameApp = true;
						break;
					}
				}
			} else {
				// or the jar may be in the ear
				for (Unit jarApp : getContainingApplications(targetJar)) {
					List<Unit> webModules = ValidatorUtils.discoverMembers(jarApp,
							J2eePackage.Literals.WEB_MODULE, context.getProgressMonitor());
					for (int k = 0; k < webModules.size(); k++) {
						Unit webModule = webModules.get(k);
						if (webModule == unit) {
							jarInSameApp = true;
							break;
						}
					}
				}
			}

			if (jarInSameApp) {
				// access is available if the jar is in the same app as the module
				continue;
			}

			// at this point, we found a jar that the module depends on
			// this jar is NOT in the same app as the module
			// now we need to do some checking to ensure that shared libraries are defined

			// There are three acceptable alternatives:
			// (a) shared library is associated with the application module;
			//     ie, webModule has a valid dependency link to a shared library 
			//     which, in turn, has a valid dependency link to the jarModule
			// (b) shared library is associated with the application;
			//     ie, the application containing the webModule has a valid dependency
			//     link to a shared library which, in turn, has a valid dependency
			//     link to the jarModule
			// (c) shared library is associated with the application server;
			//     ie, the container hosting the webModule (or application containing
			//     the webModule hosts a class loader policy that has a valid
			//     dependency link to a shared library which, in turn, has a valid
			//     dependency link to the jarModule

			// However, (c) should not hold if either (a) or (b) holds.			
			EarModule sourceApp = getApplication(unit);
			if (sourceApp != null) {
				Unit a = getSharedLibraryAssociatedWithModule(unit, targetJar);
				Unit b = getSharedLibraryAssociatedWithApplication(sourceApp, targetJar);
				Unit c = getSharedLibraryAssociatedWithServer(sourceApp, targetJar);

				Unit appHost = ValidatorUtils.discoverHost(unit, context.getProgressMonitor());
				if (null == appHost) {
					appHost = ValidatorUtils.discoverHost(sourceApp, context.getProgressMonitor());
				}

				if (a == null && b == null && c == null) {
					// shared library not configured
					reporter.addStatus(WasValidationUtil.createMissingSharedLibraryReference(
							IStatus.ERROR, IWasValidatorID.WAS_WEB_MISSING_SHARED_LIBARY_001, unit,
							sourceApp, appHost, targetJar));

				} else if (a != null && c != null || b != null && c != null) {
					// conflicting shared libraries defined
					reporter.addStatus(WasValidationUtil.createConflictingSharedLibraryReferences(
							IStatus.ERROR, IWasValidatorID.WAS_WEB_CONFLICTING_SHARED_LIBRARIES_001, unit,
							a, b));

				}

				// validate that the discovered shared libraries are hosted on the same
				// server as the application is hosted on
				if (null != appHost) {
					validateSharedLibraryHost(unit, a, appHost, context, reporter);
					validateSharedLibraryHost(unit, b, appHost, context, reporter);
				}
			}

			// done
		}
	}

	/**
	 * Retrieve the EAR application containing a given module.
	 * 
	 * @param module
	 *           the module
	 * @return the EAR application
	 * @deprecated
	 */
	public EarModule getApplication(Unit module) {
		List<Unit> apps = ValidatorUtils.discoverGroupsByUnitType(module,
				J2eePackage.Literals.EAR_MODULE, module.getEditTopology(), null);

		// we expect a module to be in exactly one application
		if (apps.size() != 1) {
			return null;
		}

		return (EarModule) apps.get(0);
	}

	/**
	 * Retrieve a list of EAR applications containing a given module.
	 * 
	 * @param module
	 *           the module
	 * @return list of EAR applications
	 */
	public List<Unit> getContainingApplications(Unit module) {
		List<Unit> apps = ValidatorUtils.discoverGroupsByUnitType(module,
				J2eePackage.Literals.EAR_MODULE, module.getEditTopology(), null);

		return apps;
	}

	/**
	 * Retrieve a list of WEB applications containing a given module.
	 * 
	 * @param module
	 *           the module
	 * @return list of WEB applications
	 */
	public List<Unit> getContainingWebApplications(Unit module) {
		List<Unit> apps = ValidatorUtils.discoverGroupsByUnitType(module,
				J2eePackage.Literals.WEB_MODULE, module.getEditTopology(), null);

		return apps;
	}

	public Unit getSharedLibraryAssociatedWithModule(Unit module, JarModule targetJar) {
		List<Requirement> slReqs = ValidatorUtils.getRequirements(module,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		for (int i = 0; i < slReqs.size(); i++) {
			Requirement slReq = slReqs.get(i);
			Unit sharedLib = ValidatorUtils.discoverDependencyLinkTargetUnit(slReq, null);
			if (null == sharedLib) {
				// no shared library; requirement not satisfied
				continue;
			}

			List<Requirement> jarReqs = ValidatorUtils.getRequirements(sharedLib,
					CorePackage.Literals.BUNDLE_CAPABILITY);
			for (int j = 0; j < jarReqs.size(); j++) {
				Requirement jarReq = jarReqs.get(j);
				Unit jar = ValidatorUtils.discoverDependencyLinkTargetUnit(jarReq, null);
				if (null == jar) {
					// there is no jar (requirement is not satisfied)
					continue;
				}
				if (!J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(jar.getEObject().eClass())) {
					// we are only interested in JAR modules; is that right?
					// TODO should we create an error here?
					continue;
				}

				if (targetJar != jar) {
					continue;
				}

				// we found a match; we are good
				return sharedLib;
			}
		}
		return null;
	}

	public Unit getSharedLibraryAssociatedWithApplication(EarModule app, JarModule targetJar) {
		return getSharedLibraryAssociatedWithModule(app, targetJar);
	}

	public Unit getSharedLibraryAssociatedWithServer(EarModule app, JarModule targetJar) {
		// get class loader policy
		// for each sh lib 
		//    for each jar test if is targetJar; if so return true
		// otherwise return false

		Unit wasHost = ValidatorUtils.discoverHost(app, null);
		if (null == wasHost) {
			// not hosted
			return null;
		}

		List<Unit> list = ValidatorUtils.discoverHosted(wasHost,
				WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT, null);
		if (list.size() < 1) {
			// no server class loader policy
			return null;
		}

		// return just the first if there is more than one; there should be just one
		Unit clPolicy = list.get(0);

		List<Requirement> slReqs = ValidatorUtils.getRequirements(clPolicy,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		for (int i = 0; i < slReqs.size(); i++) {
			Requirement slReq = slReqs.get(i);
			Unit sharedLib = ValidatorUtils.discoverDependencyLinkTargetUnit(slReq, null);
			if (null == sharedLib) {
				// no shared library; requirement is not satisfied
				continue;
			}
			List<Requirement> jarReqs = ValidatorUtils.getRequirements(sharedLib,
					CorePackage.Literals.BUNDLE_CAPABILITY);
			for (int j = 0; j < jarReqs.size(); j++) {
				Requirement jarReq = jarReqs.get(j);
				Unit jar = ValidatorUtils.discoverDependencyLinkTargetUnit(jarReq, null);
				if (null == jar) {
					// no jar; requirement is not satisfied
					continue;
				}
				if (!J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(jar.getEObject().eClass())) {
					// not a jar so ignore
					continue;
				}
				if (jar == targetJar) {
					return sharedLib;
				}
			}
		}

		return null;
	}

	protected void validateSharedLibraryHost(Unit module, Unit sharedLib, Unit appHost,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (sharedLib != null) {
			Unit sharedLibHost = ValidatorUtils.discoverHost(sharedLib, context.getProgressMonitor());
			if (null == sharedLibHost) {
				// problem: sharedLib not hosted
				// handled by unsatisfied hosting requirement checks
			} else if (sharedLibHost != appHost) {
				// problem: need common host
				reporter.addStatus(WasValidationUtil.createSharedLibraryHostingConflict(IStatus.ERROR,
						IWasValidatorID.WAS_WEB_CONFLICTING_SHARED_LIBRARIES_001, sharedLib, module,
						appHost));
			}
		}

	}

	/**
	 * Validate that any expected constraints are present on the {@link WebModule} and its contained
	 * elements (requirements, capabilities, etc.)
	 * 
	 * @param module
	 *           the web module
	 * @param context
	 *           validation context
	 * @param reporter
	 *           validation reporter
	 */
	protected void validateExpectedConstraints(Unit module, IDeployValidationContext context,
			IDeployReporter reporter) {

		Unit wasHost = ValidatorUtils.discoverHost(module, new NullProgressMonitor());

		// we expect to find some constraints on the modules:
		//    (a) on each contained EJB and WEB module: WasModuleStartWeightConstraint
		//    (b) on each contained WEB module: WasWarClassloaderPolicyConstraint
		//    (c) on any J2EESecurityRole capabilities on the modules: WasSecuritySubjectConstraint
		//    (d) on any enterprise bean service: WasJNDIBindingConstraint
		//    (e) on any reference to an EnterpriseBeanService: WasJNDIBindingConstraint
		//    (f) on any requirement for a J2EEDatasource: WasJNDIBindingConstraint

		WasJ2eeValidatorUtils.validateSingleConstraintInstance(module,
				WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT, null, false,
				IWasValidatorID.WAS_J2EE_MODULE_START_WEIGHT_CONSTRAINT_MISSING_001, context, reporter);
		WasJ2eeValidatorUtils.validateSingleConstraintInstance(module,
				WasPackage.Literals.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT, null, false,
				IWasValidatorID.WAS_J2EE_WAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001, context,
				reporter);

		WasJ2eeValidatorUtils.validateSecurityConstraints(module, wasHost, context, reporter);

		List<Requirement> references = ValidatorUtils.getRequirements(module,
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
		for (int i = 0; i < references.size(); i++) {
			Requirement ref = references.get(i);
			WasJ2eeValidatorUtils.validateSingleConstraintInstance(ref,
					WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT, wasHost, false,
					IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_MISSING_001, context, reporter);
		}

		List<Requirement> requirements = ValidatorUtils.getRequirements(module,
				J2eePackage.Literals.J2EE_DATASOURCE);
		for (int i = 0; i < requirements.size(); i++) {
			Requirement req = requirements.get(i);
			WasJ2eeValidatorUtils.validateSingleConstraintInstance(req,
					WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT, wasHost, false,
					IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_MISSING_001, context, reporter);
		}

	}

}
