/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.j2ee.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolution to add a class loader policy constraint.
 */
public class AddJ2eeWasConstraintsResolution extends DeployResolution {

	private final Unit _module; // EAR module

	private static final IDeployResolutionGenerator clGenerator = new AddWasClassloaderPolicyConstraintResolutionGenerator();
	private static final IDeployResolutionGenerator swGenerator = new AddWasModuleStartWeightConstraintResolutionGenerator();
	private static final IDeployResolutionGenerator jndiGenerator = new AddWasJNDIBindingConstraintResolutionGenerator();
	private static final IDeployResolutionGenerator ssGenerator = new AddWasSecuritySubjectConstraintResolutionGenerator();
	private static final String[] missingConstraintProblems = new String[] { IWASProblemType.OPTIONAL_CONSTRAINT_NOT_PRESENT };

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param module
	 *           the module on which the constraint should be added
	 */
	public AddJ2eeWasConstraintsResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, Unit module) {
		super(context, generator, description);
		_module = module;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		// Should we check the input again?  
		// We have an assumption that it only comes from a valid ResolutionGenerator.
		// Is this a good assumptions?

		WasResolutionUtils.runResolutions(context, _module, missingConstraintProblems, clGenerator,
				monitor);

		List<Unit> ejbModules = ValidatorUtils.discoverMembers(_module,
				J2eePackage.Literals.EJB_MODULE, monitor);
		for (int i = 0; i < ejbModules.size(); i++) {
			Unit ejbModule = ejbModules.get(i);
			addCommonModuleConstraints(ejbModule, monitor);
		}

		List<Unit> webModules = ValidatorUtils.discoverMembers(_module,
				J2eePackage.Literals.WEB_MODULE, monitor);
		for (int i = 0; i < webModules.size(); i++) {
			Unit webModule = webModules.get(i);
			WasResolutionUtils.runResolutions(context, webModule, missingConstraintProblems,
					clGenerator, monitor);
			addCommonModuleConstraints(webModule, monitor);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Sequence of resolutions to run for a {@link WebModule} and {@link EjbModule}.
	 * 
	 * @param module
	 *           the module
	 * @param monitor
	 *           progress monitor
	 * @return status of execution (returns on first failure)
	 */
	private IStatus addCommonModuleConstraints(Unit module, IProgressMonitor monitor) {
		IStatus success = WasResolutionUtils.runResolutions(context, module,
				missingConstraintProblems, swGenerator, monitor);
		if (!success.isOK()) {
			return success;
		}
		List<Capability> roles = ValidatorUtils.getCapabilities(module,
				J2eePackage.Literals.J2EE_SECURITY_ROLE);
		for (int j = 0; j < roles.size(); j++) {
			success = WasResolutionUtils.runResolutions(context, roles.get(j),
					missingConstraintProblems, ssGenerator, monitor);
			if (!success.isOK()) {
				return success;
			}
		}
		List<Capability> ejbServices = ValidatorUtils.getCapabilities(module,
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
		for (int j = 0; j < ejbServices.size(); j++) {
			success = WasResolutionUtils.runResolutions(context, ejbServices.get(j),
					missingConstraintProblems, jndiGenerator, monitor);
			if (!success.isOK()) {
				return success;
			}
		}
		List<Requirement> ejbRefs = ValidatorUtils.getRequirements(module,
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
		for (int j = 0; j < ejbRefs.size(); j++) {
			success = WasResolutionUtils.runResolutions(context, ejbRefs.get(j),
					missingConstraintProblems, jndiGenerator, monitor);
			if (!success.isOK()) {
				return success;
			}
		}
		List<Requirement> datasourceRefs = ValidatorUtils.getRequirements(module,
				J2eePackage.Literals.J2EE_DATASOURCE);
		for (int j = 0; j < datasourceRefs.size(); j++) {
			success = WasResolutionUtils.runResolutions(context, datasourceRefs.get(j),
					missingConstraintProblems, jndiGenerator, monitor);
			if (!success.isOK()) {
				return success;
			}
		}
		return Status.OK_STATUS;
	}

	// implement hashCode() and equals() so that duplicate resolutions can be 
	// filtered out

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_module == null ? 0 : _module.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AddJ2eeWasConstraintsResolution other = (AddJ2eeWasConstraintsResolution) obj;
		if (_module == null) {
			if (other._module != null) {
				return false;
			}
		} else if (!_module.equals(other._module)) {
			return false;
		}
		return true;
	}

}
