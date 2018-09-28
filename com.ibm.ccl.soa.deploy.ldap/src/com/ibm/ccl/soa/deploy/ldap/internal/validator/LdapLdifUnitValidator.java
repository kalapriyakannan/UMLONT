/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.internal.LdapDomainMessages;

/**
 * Validates a {@link LdapLdifUnit}.
 * 
 * @deprecated until we have an actual use for this class
 */
public class LdapLdifUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return LdapPackage.eINSTANCE.getLdapLdifUnit();
	}

	/**
	 * add constraints on capability and requirements cardinalities
	 * 
	 * @param unitType
	 */
	public LdapLdifUnitValidator() {
		super(LdapPackage.eINSTANCE.getLdapLdifUnit());
		this.addCapabilityTypeConstraint(LdapPackage.eINSTANCE.getLdapLdif(),
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
		// Core Unit validation
		super.validateUnit(unit, context, reporter);
		LdapLdifUnit llu = (LdapLdifUnit) unit;
		if (llu.getArtifacts().size() != 1) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createObjectStatus();
			status.setProblemType(ICoreProblemType.APPLICATION_MODULE_ARTIFACT_UNDEFINED);
			status
					.setUnboundMessage(LdapDomainMessages.Validator_Ldap_ldiff_module_0_missing_file_artifact);
			status.setBindings(new String[] { unit.getName() });
			reporter.addStatus(status);
		}
		// Syntax check for subtree DN
		LdapValidatorUtils.validateDNSyntax(llu, LdapPackage.Literals.LDAP_LDIF,
				LdapPackage.Literals.LDAP_LDIF__SUBTREE_DN, context, reporter);
	}

}
