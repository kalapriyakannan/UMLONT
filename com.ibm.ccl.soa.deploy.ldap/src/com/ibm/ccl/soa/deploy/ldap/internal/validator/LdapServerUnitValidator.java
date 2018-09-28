/***************************************************************************************************
 * LdapServerUnitValidator.java -- Validator for {@link LdapServerUnit} Objects.
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.marker.ILdapDomainValidators;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates a {@link LdapServerUnit}.
 */
public class LdapServerUnitValidator extends UnitValidator implements ILdapDomainValidators {

	/**
	 * Constructor -- add constraints on capability and requirements cardinalities.
	 */
	public LdapServerUnitValidator() {
		super(LdapPackage.eINSTANCE.getLdapServerUnit());

		this.addCapabilityTypeConstraint(LdapPackage.eINSTANCE.getLdapServer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
//		this.addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2Database(),
//				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {

		super.validateUnit(unit, context, reporter);

//		// database should be the only database on the instance
//		validateUniqueDatabase((LdapServerUnit) unit, context, reporter);

		// (provided) ldap.hostname == (consumed) operatingSystem
		validateHostName((LdapServerUnit) unit, reporter);

		// suffix DNs are unqiue among all hosted suffix units
		validateLdapSuffixUniqueSuffixDN((LdapServerUnit) unit, context, reporter);

		// syntactically valid adminstratorDN
		LdapValidatorUtils.validateDNSyntax(unit, LdapPackage.Literals.LDAP_SERVER,
				LdapPackage.Literals.LDAP_SERVER__ADMINISTRATOR_DN, context, reporter);
	}

//	protected void validateUniqueDatabase(LdapServerUnit ldap, IDeployValidationContext context,
//			IDeployReporter reporter) {
//		// check that DB2Database.getHost().getHosted() == {this}
//		// return true if can't evaluate expressions
//		List<Requirement> dbRequirements = ValidatorUtils.findRequirements(ldap.getRequirements(),
//				Db2Package.Literals.DB2_DATABASE, RequirementLinkTypes.DEPENDENCY_LITERAL);
//
//		// if no db requirements then need to wait to finish evaluation
//		// if more than 1 db requirement then need to wait until reduced to 1
//		if (1 != dbRequirements.size()) {
//			return;
//		}
//
//		Unit dbDatabaseUnit = ValidatorUtils.getOwningUnit(ValidatorUtils
//				.discoverDependencyLinkTarget(dbRequirements.get(0), context.getProgressMonitor()));
//		if (null == dbDatabaseUnit) {
//			// target link error (should be caught elsewhere)
//			return;
//		}
//
//		// find its hosting dbInstanceUnit
//		Unit dbInstanceUnit = ValidatorUtils.getHost(dbDatabaseUnit);
//		if (null == dbInstanceUnit) {
//			// host not yet assigned; stop
//			return;
//		}
//
//		// verify that dbDatabaseUnit is the only hosted database
//
//		List<UnitDescriptor> hostedUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(
//				dbInstanceUnit, dbInstanceUnit.getEditTopology());
//		if (1 < hostedUnitDescriptors.size()) {
//			// report a problem
//			reporter.addStatus(DeployLdapMessageFactory.createLdapDatabaseNotUniquelyHosted(
//					dbDatabaseUnit, dbInstanceUnit));
//		}
//
//		// no problem detected
//		return;
//	}

	protected void validateHostName(LdapServerUnit ldapServerUnit, IDeployReporter reporter) {
		// check that ldap.(provided)ldap.hostName == ldap.getHosted().hostName
		// return true if can't evaluate expressions

		// find the provided ldap capability
		List<Capability> ldapCapabilities = ValidatorUtils.findCapabilities(ldapServerUnit,
				LdapPackage.eINSTANCE.getLdapServer());

		// if no ldap services then need to wait to finish evaluation
		// if more than 1 ldap service then need to wait until reduced to 1
		if (1 != ldapCapabilities.size()) {
			return;
		}

		// find our hoster (operating system)
		Unit osUnit = ValidatorUtils.getHost(ldapServerUnit);
		if (null == osUnit) {
			// host not yet assigned; stop
			return;
		}

		// get provided os from osUnit
		List<Capability> osCapabilities = ValidatorUtils.findCapabilities(osUnit, OsPackage.eINSTANCE
				.getOperatingSystem());

		// if no os services then need to wait to finish evaluation
		// if more than 1 os service then need to wait until reduced to 1
		if (1 != osCapabilities.size()) {
			return;
		}

		// no problem detected
		return;
	}

	protected void validateLdapSuffixUniqueSuffixDN(LdapServerUnit ldapServerUnit,
			IDeployValidationContext context, IDeployReporter reporter) {

		// check that ldapSuffix.suffixDN unique among all provided by all
		// hosted on same ldap server

		Set<String> suffixDNSet = new HashSet<String>();

		List<UnitDescriptor> hostedUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(
				ldapServerUnit, ldapServerUnit.getEditTopology(), context.getProgressMonitor());
		for (UnitDescriptor hostedUnitDescriptor : hostedUnitDescriptors) {
			Unit hostedUnit = hostedUnitDescriptor.getUnitValue();
			assert hostedUnit != null;
			if (hostedUnit.getEObject().eClass().isSuperTypeOf(
					LdapPackage.eINSTANCE.getLdapSuffixUnit())) {
				LdapSuffixUnit hostedSuffix = (LdapSuffixUnit) hostedUnit;
				// get LdapSuffix service
				List<Capability> suffixCapabilities = ValidatorUtils.findCapabilities(hostedSuffix,
						LdapPackage.eINSTANCE.getLdapSuffix());
				if (1 != suffixCapabilities.size()) {
					return;
				}
				validateSuffixDNUnique((LdapSuffix) suffixCapabilities.get(0), hostedSuffix,
						suffixDNSet, context, reporter);
			}
		}

		// done
		return;
	}

	/**
	 * @param object
	 *           suffix object
	 * @param container
	 *           container for suffix object
	 * @param roleSet
	 *           set to which each role is added iteratively for duplicate checking
	 * @param context
	 *           context
	 * @param reporter
	 *           reporter
	 */
	protected void validateSuffixDNUnique(LdapSuffix object, DeployModelObject container,
			Set<String> roleSet, IDeployValidationContext context, IDeployReporter reporter) {

		// TODO consider refactoring UnitValidator.validateDeployModelObjectUnique to include this case 

		String role = object.getSuffixDN();
		// null/empty roles validated on each service.
		if (role != null && role.length() > 0) {
			if (roleSet.contains(role)) {
				reporter.addStatus(DeployCoreStatusUtil.createDeployModelObjectNameNotUniqueStatus(
						IStatus.ERROR, LDAP_SERVER_UNIT_VALIDATOR, object, container));
			} else {
				roleSet.add(role);
			}
		}
	}
}
