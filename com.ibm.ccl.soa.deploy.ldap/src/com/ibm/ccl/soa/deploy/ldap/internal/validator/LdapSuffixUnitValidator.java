/***************************************************************************************************
 * LdapSuffixUnitValidator.java -- Validator for {@link LdapSuffixUnit} Objects.
 * 
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ldap.internal.validator;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;

/**
 * Validates a {@link LdapSuffixUnit}.
 */
public class LdapSuffixUnitValidator extends UnitValidator {

	/**
	 * Constructor -- Add constraints on capability and requirements cardinalities.
	 */
	public LdapSuffixUnitValidator() {
		super(LdapPackage.eINSTANCE.getLdapSuffixUnit());

		this.addCapabilityTypeConstraint(LdapPackage.eINSTANCE.getLdapSuffix(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(LdapPackage.eINSTANCE.getLdapServer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {

		super.validateUnit(unit, context, reporter);

		LdapSuffixUnit lsu = (LdapSuffixUnit) unit;

//		if (lsu.getArtifacts().size() != 1) {
//			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
//					IDeployCoreValidators.CORE_UNASSIGNED,
//					ICoreProblemType.APPLICATION_MODULE_ARTIFACT_UNDEFINED,
//					LdapDomainMessages.Validator_Ldap_suffix_module_0_missing_file_artifact,
//					new String[] { unit.getName() }, lsu);
//			reporter.addStatus(status);
//		}

		LdapValidatorUtils.validateDNSyntax(lsu, LdapPackage.Literals.LDAP_SUFFIX,
				LdapPackage.Literals.LDAP_SUFFIX__SUFFIX_DN, context, reporter);
	}
}
