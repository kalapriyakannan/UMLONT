/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.test.validator;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.j2ee.GenericJ2eeServer;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServer;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.SecurityRoleReferenceUnitValidator;

/**
 * Tests {@link SecurityRoleReferenceUnit}.
 */
public class LdapSecurityRoleReferenceValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "SecurityRoleReferenceUnitValidatorTest"; //$NON-NLS-1$

	public LdapSecurityRoleReferenceValidatorTest() {
		super(PROJECT_NAME);
	}

	public void testSecurityRoleReferenceUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology("SecurityRoleReferenceValidator", true); //$NON-NLS-1$

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		SecurityRoleReferenceUnitValidator validator = new SecurityRoleReferenceUnitValidator();

		//
		// build test topology
		//

		// Consumed ldapSuffix service
		Requirement requiredLdapSuffix = CoreFactory.eINSTANCE
				.createRequirement();
		requiredLdapSuffix.setDmoEType(LdapPackage.Literals.LDAP_SUFFIX);
		requiredLdapSuffix.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredLdapSuffix.setName("requiredLdapSuffix"); //$NON-NLS-1$
		EqualsConstraint suffixDNExpression = createEqualsConstraint(
				"suffixDN",
		"dc=root");
		/*Equals.createExpression(
				LdapPackage.eINSTANCE.getLdapSuffix_SuffixDN(), "dc=root"); //$NON-NLS-1$
		*/requiredLdapSuffix.getConstraints().add(suffixDNExpression);

		// provided J2EESecurityRole
		J2EESecurityRole providedJ2EESecurityRole = J2eeFactory.eINSTANCE
				.createJ2EESecurityRole();
		providedJ2EESecurityRole.setName("providedJ2EESecurityRole"); //$NON-NLS-1$
		providedJ2EESecurityRole
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);

		Requirement requiredJ2EEServer = CoreFactory.eINSTANCE
				.createRequirement();
		requiredJ2EEServer.setName("requiredJ2EEServer"); //$NON-NLS-1$
		requiredJ2EEServer.setDmoEType(J2eePackage.Literals.J2EE_SERVER);
		requiredJ2EEServer.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		// SecurityRoleReference unit
		// - produces J2EESecurityRole services (--added below--)
		// - consumes LdapSuffix service (consumedLdapSuffix)
		// - consumes J2EEServer service (--not added to test--)
		SecurityRoleReferenceUnit sRRUnit = LdapFactory.eINSTANCE
				.createSecurityRoleReferenceUnit();
		sRRUnit.setName("sRRUnit"); //$NON-NLS-1$
		top.getUnits().add(sRRUnit);
		sRRUnit.getCapabilities().add(providedJ2EESecurityRole);
		sRRUnit.getRequirements().add(requiredLdapSuffix);
		sRRUnit.getRequirements().add(requiredJ2EEServer);

		// Provided LDAP suffix service
		LdapSuffix providedLdapSuffix = LdapFactory.eINSTANCE
				.createLdapSuffix();
		providedLdapSuffix.setName("providedLdapSuffix"); //$NON-NLS-1$
		providedLdapSuffix.setSuffixDN("dc=root"); //$NON-NLS-1$

		// LdapSuffixUnit
		// - provides LdapSuffix (providedLdapSuffix)
		// - consumes LdapServer (-- not included in test --)
		LdapSuffixUnit lsUnit = LdapFactory.eINSTANCE.createLdapSuffixUnit();
		lsUnit.setName("lsUnit"); //$NON-NLS-1$
		top.getUnits().add(lsUnit);
		lsUnit.getCapabilities().add(providedLdapSuffix);

		J2EEServer providedJ2eeServer = J2eeFactory.eINSTANCE
				.createJ2EEServer();
		providedJ2eeServer.setName("providedJ2eeServer"); //$NON-NLS-1$
		providedJ2eeServer.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);

		GenericJ2eeServer genericJ2eeServerUnit = J2eeFactory.eINSTANCE
				.createGenericJ2eeServer();
		genericJ2eeServerUnit.setName("genericJ2eeServerUnit"); //$NON-NLS-1$
		genericJ2eeServerUnit.getCapabilities().add(providedJ2eeServer);
		top.getUnits().add(genericJ2eeServerUnit);

		ValidatorTestUtils.hosts(genericJ2eeServerUnit, sRRUnit);

		// link consumedLdapSuffix to providedLdapSuffix
		DependencyLink suffixLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		suffixLink.setTarget(providedLdapSuffix);
		requiredLdapSuffix.setLink(suffixLink);
		ValidatorTestUtils.createLinkName(suffixLink);

		// expect no markers
		validateUnit(top, validator, sRRUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, sRRUnit, context,
				reporter, validator);

		// change suffixDN to get error
		suffixDNExpression.setValue("dc=plants"); //$NON-NLS-1$
// requiredLdapSuffix.getConstraints().add(Equals.createExpression(LdapPackage.eINSTANCE.getLdapSuffix_SuffixDN(),
// "dc=plants"));

		// expect 1 or 2 markers
		validateUnit(top, validator, sRRUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCountRange(1, 3, top, sRRUnit,
				context, reporter, validator);

		// change suffixDN back to remove error
		suffixDNExpression.setValue("dc=root"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, top, sRRUnit, context,
				reporter, validator);
// requiredLdapSuffix.getConstraints().add(Equals.createExpression(LdapPackage.eINSTANCE.getLdapSuffix_SuffixDN(),
// "dc=root"));

		// Requirement/Capability attribute mismatch, and invalid suffix dn
		providedLdapSuffix.setSuffixDN("foo"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCountRange(2, 3, top, sRRUnit, context,
				reporter, validator);
		providedLdapSuffix.setSuffixDN("dc=root"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, top, sRRUnit, context,
				reporter, validator);

		// expect no markers
		validateUnit(top, validator, sRRUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, sRRUnit, context,
				reporter, validator);

		// add 2 roles with different names then a third with the same name

		J2EESecurityRole role1 = J2eeFactory.eINSTANCE.createJ2EESecurityRole();
		role1.setName("role1"); //$NON-NLS-1$
		role1.setRole("role1"); //$NON-NLS-1$
		sRRUnit.getCapabilities().add(role1);

		// expect no markers
		validateUnit(top, validator, sRRUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, sRRUnit, context,
				reporter, validator);

		J2EESecurityRole role2 = J2eeFactory.eINSTANCE.createJ2EESecurityRole();
		role2.setName("role2"); //$NON-NLS-1$
		role2.setRole("role2"); //$NON-NLS-1$
		sRRUnit.getCapabilities().add(role2);

		// expect no markers
		validateUnit(top, validator, sRRUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, sRRUnit, context,
				reporter, validator);

		J2EESecurityRole role3 = J2eeFactory.eINSTANCE.createJ2EESecurityRole();
		role3.setName("role3"); //$NON-NLS-1$
		role3.setRole("role1"); //$NON-NLS-1$
		sRRUnit.getCapabilities().add(role3);

		// expect 1 marker
		validateUnit(top, validator, sRRUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(1, top, sRRUnit, context,
				reporter, validator);
	}
	
	private EqualsConstraint createEqualsConstraint(String attribute,
			String value) {
		EqualsConstraint constraint = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		constraint.setAttributeName(attribute);
		constraint.setValue(value);
		return constraint;
	}
}
