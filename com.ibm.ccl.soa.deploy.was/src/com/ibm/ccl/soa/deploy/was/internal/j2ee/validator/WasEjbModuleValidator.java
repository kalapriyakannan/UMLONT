/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.AdditiveUnitValidator;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validate instances of {@link EjbModule} hosted on WAS.
 */
public class WasEjbModuleValidator extends AdditiveUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return J2eePackage.Literals.EJB_MODULE;
	}

	/**
	 * Constructor
	 */
	public WasEjbModuleValidator() {
		super(J2eePackage.Literals.EJB_MODULE);

	}

	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// find WAS specific requirements and validate them

		// if not hosted on WAS then quit
		if (!WasJ2eeValidatorUtils.isJ2eeHostedOnWas(unit)) {
			return;
		}

		validateExpectedConstraints(unit, context, reporter);
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
	 * Validate that any expected constraints are present on the {@link EjbModule} and its contained
	 * elements (requirements, capabilities, etc.)
	 * 
	 * @param module
	 *           the ejb module
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
		//    (b) on any enterprise bean service: WasJNDIBindingConstraint
		//    (c) on any reference to an EnterpriseBeanService: WasJNDIBindingConstraint
		//    (d) on any requirement for a J2EEDatasource: WasJNDIBindingConstraint

		WasJ2eeValidatorUtils.validateSingleConstraintInstance(module,
				WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT, null, false,
				IWasValidatorID.WAS_J2EE_MODULE_START_WEIGHT_CONSTRAINT_MISSING_001, context, reporter);

		List<Capability> services = ValidatorUtils.getCapabilities(module,
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
		for (int i = 0; i < services.size(); i++) {
			Capability service = services.get(i);
			WasJ2eeValidatorUtils.validateSingleConstraintInstance(service,
					WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT, wasHost, false,
					IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_MISSING_001, context, reporter);
		}

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
