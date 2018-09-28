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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;

/**
 * Validates a {@link SecurityRoleReferenceUnit}.
 * 
 * @deprecated until we have an actual use for this
 */
public class SecurityRoleReferenceUnitValidator extends ConfigurationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return LdapPackage.eINSTANCE.getSecurityRoleReferenceUnit();
	}

	/**
	 * add constraints on capability and requirements cardinalities
	 * 
	 * @param unitType
	 */
	public SecurityRoleReferenceUnitValidator() {
		super();
		// TODO determine whether cardinality of J2EESecurityRole should be
		// precisely one.
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJ2EESecurityRole(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(LdapPackage.eINSTANCE.getLdapSuffix(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(J2eePackage.eINSTANCE.getJ2EEServer(),
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

		// j2eeSecurityRole.role unique among all provided by
		// SecurityRoleReferenceUnits on j2eeServer
		validateUniqueSecurityRole((SecurityRoleReferenceUnit) unit, context, reporter);

		validateDomainNameMatch((SecurityRoleReferenceUnit) unit, context, reporter);

	}

	protected void validateUniqueSecurityRole(SecurityRoleReferenceUnit roleRef,
			IDeployValidationContext context, IDeployReporter reporter) {
		// j2eeSecurityRole.role unique among all provided by
		// SecurityRoleReferenceUnits on j2eeServer

		// find security roles
		List j2eeSecurityRoles = ValidatorUtils.findCapabilities(roleRef, J2eePackage.eINSTANCE
				.getJ2EESecurityRole());

		// if no security roles then need to wait to finish evaluation
		if (0 == j2eeSecurityRoles.size()) {
			return;
		}

		// check for uniqueness; if not issue error on both services
		Set roleSet = new HashSet();
		for (Iterator roles = j2eeSecurityRoles.iterator(); roles.hasNext();) {
			J2EESecurityRole role = (J2EESecurityRole) roles.next();
			validateRoleUnique(role, roleRef, roleSet, context, reporter);
		}

		// done
		return;
	}

	/**
	 * Validates that the name of the object is unique is unique in the set of names used by its
	 * container.
	 * 
	 * @param object
	 *           the object whose name should be unique.
	 * @param container
	 *           the container of the object.
	 * @param roleSet
	 *           the set of names of other contained objects.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateRoleUnique(J2EESecurityRole object, DeployModelObject container,
			Set roleSet, IDeployValidationContext context, IDeployReporter reporter) {
		// TODO consider refactoring
		// UnitValidator.validateDeployModelObjectUnique to include this case
		String role = object.getRole();
		// null/empty roles validated on each service.
		if (role != null && role.length() > 0) {
			if (roleSet.contains(role)) {
				IDeployStatus message = DeployCoreStatusUtil
						.createDeployModelObjectNameNotUniqueStatus(IStatus.ERROR,
								IDeployCoreValidators.CORE_UNASSIGNED, object, container);
				reporter.addStatus(message);
			}
			roleSet.add(role);
		}
	}

	protected void validateDomainNameMatch(SecurityRoleReferenceUnit roleRef,
			IDeployValidationContext context, IDeployReporter reporter) {

		// find the requirement for a ldap suffix
		List ldapSuffixRequirements = ValidatorUtils.findRequirements(roleRef, LdapPackage.eINSTANCE
				.getLdapSuffix(), RequirementLinkTypes.DEPENDENCY_LITERAL);

		// if no ldap suffix services then need to wait to finish evaluation
		// if more than 1 ldap service then need to wait until reduced to 1
		if (1 != ldapSuffixRequirements.size()) {
			return;
		}

		// Get first such requirement
		Requirement sourceSuffix = (Requirement) ldapSuffixRequirements.get(0);

		UnitDescriptor targetUD = TopologyDiscovererService.INSTANCE.findTarget(roleRef,
				sourceSuffix, roleRef.getEditTopology());
		if (targetUD == null) {
			return;
		}
		Unit targetUnit = targetUD.getUnitValue();
		if (targetUnit == null) {
			return;
		}

		// Get first LdapSuffix capability. There shouldn't be more than one.
		LdapSuffix targetSuffix = (LdapSuffix) ValidatorUtils.getCapability(targetUnit,
				LdapPackage.eINSTANCE.getLdapSuffix());
//		LdapSuffix targetSuffix = (LdapSuffix) link.getTarget();
		if (null == targetSuffix) {
			// improperly linked service; caught elsewhere; stop
			return;
		}

		List expressions = sourceSuffix.getConstraints();
		String sourceDN = null;
		for (Iterator iter = expressions.iterator(); iter.hasNext();) {
			Constraint expression = (Constraint) iter.next();
			if (expression instanceof EqualsConstraint
					&& ((EqualsConstraint) expression).getAttributeName().equals(
							LdapPackage.Literals.LDAP_SUFFIX__SUFFIX_DN.getName())) {
				sourceDN = ((EqualsConstraint) expression).getValue();
				break;
			}
		}
		String targetDN = targetSuffix.getSuffixDN();

		// Are source and target confused here? 
		// check for compatibility of DN names
		// TODO decide whether to move this check for sourceDN == null to
		// validateDomainNames
		if (sourceDN != null) {
			if (!LdapValidatorUtils.validateDomainNames(sourceDN, targetDN)) {
				// TODO need to propagate from LDAP server to Requirement!
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
						sourceSuffix, LdapPackage.eINSTANCE.getLdapSuffix_SuffixDN()));
				return;
//				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
//						targetSuffix, LdapPackage.Literals.LDAP_SUFFIX__SUFFIX_DN, sourceDN));
			}
			if (sourceDN.length() == 0 && targetDN == null) {
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
						sourceSuffix, LdapPackage.eINSTANCE.getLdapSuffix_SuffixDN()));
				return;
			}
			if (!LdapValidatorUtils.isValidDN(sourceDN)) {
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
						sourceSuffix, LdapPackage.eINSTANCE.getLdapSuffix_SuffixDN()));
				return;
			}
		}

		return;
	}
}
