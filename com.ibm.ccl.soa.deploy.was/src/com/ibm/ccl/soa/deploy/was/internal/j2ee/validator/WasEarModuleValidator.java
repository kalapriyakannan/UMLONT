/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.AdditiveUnitValidator;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validate instances of {@link EarModule} hosted on WAS.
 */
public class WasEarModuleValidator extends AdditiveUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return J2eePackage.Literals.EAR_MODULE;
	}

	/**
	 * 
	 */
	public WasEarModuleValidator() {
		super(J2eePackage.Literals.EAR_MODULE);

		this.addRequirementTypeConstraint(WasPackage.Literals.SHARED_LIBRARY_ENTRY,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(WasPackage.Literals.WAS_APPLICATION_EXT,
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
	}

	/**
	 * Validate that any expected constraints are present on the {@link EarModule} and its contained
	 * elements (requirements, capabilities, etc.)
	 * 
	 * @param module
	 *           the EAR module
	 * @param context
	 *           validation context
	 * @param reporter
	 *           validation reporter
	 */
	protected void validateExpectedConstraints(Unit module, IDeployValidationContext context,
			IDeployReporter reporter) {

		// we expect to find some constraints on the modules:
		//    (a) on the EAR module: WasEarClassloaderPolicyConstraint

		WasJ2eeValidatorUtils.validateSingleConstraintInstance(module,
				WasPackage.Literals.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT, null, false,
				IWasValidatorID.WAS_J2EE_EAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001, context,
				reporter);

	}

}
