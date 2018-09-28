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
import java.math.BigInteger;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.LdapServerUnitValidator;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;

/**
 * Tests {@link LdapServerUnitValidator}.
 */
public class LdapServerUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "LdapServerUnitValidatorTest"; //$NON-NLS-1$

// protected DB2Database consumedLdapDb2Database;

	protected DB2Database providedDb2DatabaseLdap;

// protected OperatingSystem consumedLdapOs;

	private LdapServerUnit ldapServerUnit;

	public LdapServerUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	public void testLdapUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("LdapServerUnitValidator", true); //$NON-NLS-1$

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		LdapServerUnitValidator validator = new LdapServerUnitValidator();

		//
		// build test topology
		//

		// Provided LDAP service
		LdapServer providedLdap = LdapFactory.eINSTANCE.createLdapServer();
		providedLdap.setName("providedLdap"); //$NON-NLS-1$
		providedLdap.setAdministratorDN("cn=root"); //$NON-NLS-1$
		providedLdap.setAdministratorPassword("ldap1"); //$NON-NLS-1$
//		providedLdap.setHostname("rf12.watson.ibm.com"); //$NON-NLS-1$
//		providedLdap.setPort("389"); //$NON-NLS-1$
		// TODO Should this be changed to match other ports?
		// providedLdap.setPort(BigInteger.valueOf(389));

		// Consumed LDAP database service
		Requirement requiredLdapDb2Database = CoreFactory.eINSTANCE
				.createRequirement();
		requiredLdapDb2Database.setDmoEType(Db2Package.Literals.DB2_DATABASE);
		requiredLdapDb2Database
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredLdapDb2Database.setName("requiredLdapDb2Database"); //$NON-NLS-1$
		requiredLdapDb2Database.getConstraints().add(
				createEqualsConstraint(
						Db2Package.eINSTANCE
						.getDB2Database_DbName().getName(),
						"LDAP")
				/*Equals.createExpression(Db2Package.eINSTANCE
						.getDB2Database_DbName(), "LDAP")*/); //$NON-NLS-1$

		// (LdapServer) OperatingSystem (required)
		Requirement requiredLdapOs = CoreFactory.eINSTANCE.createRequirement();
		requiredLdapOs.setDmoEType(OsPackage.Literals.OPERATING_SYSTEM);
		requiredLdapOs.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredLdapOs.setName("requiredLdapOs"); //$NON-NLS-1$

		// Provided ldapSuffix
		LdapSuffix providedSuffix1 = LdapFactory.eINSTANCE.createLdapSuffix();
		providedSuffix1.setName("providedSuffix1"); //$NON-NLS-1$
		providedSuffix1.setSuffixDN("dc=root"); //$NON-NLS-1$

		// Required ldap
		Requirement requiredLdap1 = CoreFactory.eINSTANCE.createRequirement();
		requiredLdap1.setDmoEType(LdapPackage.Literals.LDAP_SERVER);
		requiredLdap1.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredLdap1.setName("requiredLdap1"); //$NON-NLS-1$

		// LdapSuffix
		// - provides ldap suffix service (providedSuffix1)
		// - consumes ldap service (consumedLdap1)
		LdapSuffixUnit suffixUnit1 = LdapFactory.eINSTANCE
				.createLdapSuffixUnit();
		suffixUnit1.setName("suffixUnit1"); //$NON-NLS-1$
		top.getUnits().add(suffixUnit1);
		suffixUnit1.getCapabilities().add(providedSuffix1);
		suffixUnit1.getRequirements().add(requiredLdap1);

		// Provided ldapSuffix
		LdapSuffix providedSuffix2 = LdapFactory.eINSTANCE.createLdapSuffix();
		providedSuffix2.setName("providedSuffix2"); //$NON-NLS-1$
		providedSuffix2.setSuffixDN("dn=plants"); //$NON-NLS-1$

		// Consumed ldap
		Requirement requiredLdap2 = CoreFactory.eINSTANCE.createRequirement();
		requiredLdap2.setDmoEType(LdapPackage.Literals.LDAP_SERVER);
		requiredLdap2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredLdap2.setName("requiredLdap2"); //$NON-NLS-1$

		// LdapSuffix
		// - provides ldap suffix service (providedSuffix1)
		// - consumes ldap service (consumedLdap1)
		LdapSuffixUnit suffixUnit2 = LdapFactory.eINSTANCE
				.createLdapSuffixUnit();
		suffixUnit2.setName("suffixUnit2"); //$NON-NLS-1$
		top.getUnits().add(suffixUnit2);
		suffixUnit2.getCapabilities().add(providedSuffix2);
		suffixUnit2.getRequirements().add(requiredLdap2);

		// LDAP unit
		// - produces LDAP service (providedLdap)
		// - consumes DB2 database service (consumedLdapDb2Database)
		// - consumes OS service (consumedLdapOs)
		/* LdapServerUnit */ldapServerUnit = LdapFactory.eINSTANCE.createLdapServerUnit();
		ldapServerUnit.setName("ldapServerUnit");
		top.getUnits().add(ldapServerUnit);
		ldapServerUnit.getHostingOrAnyCapabilities().add(providedLdap);
		ldapServerUnit.getRequirements().add(requiredLdapDb2Database);
		ldapServerUnit.getRequirements().add(requiredLdapOs);
		ValidatorTestUtils.hosts(ldapServerUnit, suffixUnit1);
		ValidatorTestUtils.hosts(ldapServerUnit, suffixUnit2);

		// LDAP database stack

		// DB2Database (service)
		providedDb2DatabaseLdap = Db2Factory.eINSTANCE.createDB2Database();
		providedDb2DatabaseLdap.setName("providedDb2DatabaseLdap");
		providedDb2DatabaseLdap.setDbAlias("LDAP");
		providedDb2DatabaseLdap.setDbDrive("C:/DB2"); // ????
		providedDb2DatabaseLdap.setDbName("LDAP");

		// DB2Instance (consumed service)
		Requirement requiredDb2InstanceLdap = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2InstanceLdap.setDmoEType(Db2Package.eINSTANCE
				.getDB2Instance());
		requiredDb2InstanceLdap
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredDb2InstanceLdap.setName("requiredDb2InstanceLdap");

		// DB2DatabaseUnit
		// - provides DB2 database (providedDb2DatabaseLdap)
		// - consumes (hosting) DB2 instance (consumedDb2InstanceLdap)
		DB2DatabaseUnit db2DatabaseUnitLdap = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		db2DatabaseUnitLdap.setName("db2DatabaseUnitLdap");
		db2DatabaseUnitLdap.getCapabilities().add(providedDb2DatabaseLdap);
		top.getUnits().add(db2DatabaseUnitLdap);
		db2DatabaseUnitLdap.getRequirements().add(requiredDb2InstanceLdap);

		// DB2Instance (provided service)
		DB2Instance providedDb2InstanceLdap = Db2Factory.eINSTANCE
				.createDB2Instance();
		providedDb2InstanceLdap.setName("providedDb2InstanceLdap");
		providedDb2InstanceLdap.setDb2InstanceName("LDAP_INSTANCE");
		providedDb2InstanceLdap.setHostname("rf12.watson.ibm.com");
		providedDb2InstanceLdap.setUsername("ldapadmin");
		providedDb2InstanceLdap.setPassword("ldapadmin");
		providedDb2InstanceLdap.setPort(BigInteger.valueOf(50001));
		providedDb2InstanceLdap.setDb2Version("8.1.0.36");

		// DB2System (consumed service)
		Requirement requiredDb2SystemLdap = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2SystemLdap.setDmoEType(Db2Package.eINSTANCE.getDB2System());
		requiredDb2SystemLdap.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredDb2SystemLdap.setName("requiredDb2SystemLdap");

		// User (consumed service)
		// User consumedLdapAdminUser = OsFactory.eINSTANCE.createUser();
		Requirement requiredLdapAdminUser = CoreFactory.eINSTANCE
				.createRequirement();
		requiredLdapAdminUser.setName("requiredLdapAdminUser");
		requiredLdapAdminUser.setDmoEType(OsPackage.eINSTANCE.getUser());
		requiredLdapAdminUser
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredLdapAdminUser.getConstraints().add(
				createEqualsConstraint(
						"userId",
						"ldapadmin")
				);
		requiredLdapAdminUser.getConstraints().add(
				createEqualsConstraint(
						"userPassword",
						"ldapadmin"));

		// DB2InstanceUnit
		// - provides DB2 instance (providedDb2InstanceLdap)
		// - consumes (hosting) DB2 system (consumedDb2SystemLdap)
		// - consumes user (consumedLdapAdminUser)
		DB2InstanceUnit db2InstanceUnitLdap = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		db2InstanceUnitLdap.setName("db2InstanceUnitLdap");
		db2InstanceUnitLdap.getHostingOrAnyCapabilities().add(
				providedDb2InstanceLdap);
		top.getUnits().add(db2InstanceUnitLdap);
		db2InstanceUnitLdap.getRequirements().add(requiredDb2SystemLdap);
		db2InstanceUnitLdap.getRequirements().add(requiredLdapAdminUser);

		// DB2System (provided service)
		DB2System providedDb2System = Db2Factory.eINSTANCE.createDB2System();
		providedDb2System.setName("providedDb2System");
		providedDb2System.setInstallDir("C:\\IBM\\SQLLIB");
		providedDb2System.setDb2Version("8.1.0.36");

		// (DB2 system) OperatingSystem (consumed service)
		OperatingSystem consumedDbOs = OsFactory.eINSTANCE
				.createOperatingSystem();
		consumedDbOs.setName("consumedDbOs");

		// DB2SystemUnit
		// - provides DB2System (providedDb2System)
		// - consumes operating system (consumedDbOs)
		DB2SystemUnit db2SystemUnit = Db2Factory.eINSTANCE
				.createDB2SystemUnit();
		db2SystemUnit.setName("db2SystemUnit");
		db2SystemUnit.getHostingOrAnyCapabilities().add(providedDb2System);
		top.getUnits().add(db2SystemUnit);

		// operating system
		OperatingSystem providedOperatingSystem2 = OsFactory.eINSTANCE
				.createOperatingSystem();
		providedOperatingSystem2.setName("providedOperatingSystem");
		providedOperatingSystem2.setOsType(OperatingSystemType.WINDOWS_LITERAL
				.getLiteral());
		providedOperatingSystem2.setOsVersion("Win2k");
		providedOperatingSystem2.setHostname("rf12.watson.ibm.com");

		// instance admin user
		User providedLdapAdminUser = OsFactory.eINSTANCE.createUser();
		providedLdapAdminUser.setName("providedLdapAdminUser");
		providedLdapAdminUser.setUserId("ldapadmin");
		providedLdapAdminUser.setUserPassword("ldapadmin");

		// OperatingSystemUnit
		// - provides operating system (providedOperatingSystem2)
		// - provides ldap (db instance admin) user
		// - consumes nothing (no system)
		OperatingSystemUnit operatingSystemUnit2 = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		operatingSystemUnit2.setName("operatingSystemUnit2");
		operatingSystemUnit2.getHostingOrAnyCapabilities().add(
				providedOperatingSystem2);
		operatingSystemUnit2.getCapabilities().add(providedLdapAdminUser);
		top.getUnits().add(operatingSystemUnit2);

		// Link up LdapServer stack
		ValidatorTestUtils.hosts(db2InstanceUnitLdap, db2DatabaseUnitLdap);
		ValidatorTestUtils.hosts(db2SystemUnit, db2InstanceUnitLdap);
		ValidatorTestUtils.hosts(operatingSystemUnit2, db2SystemUnit);
		ValidatorTestUtils.hosts(operatingSystemUnit2, ldapServerUnit);

		// link LDAP to database stack
		// consumedLdapDb2Database
		DependencyLink ldapToDatabase = CoreFactory.eINSTANCE
				.createDependencyLink();
		ldapToDatabase.setTarget(providedDb2DatabaseLdap);
		requiredLdapDb2Database.setLink(ldapToDatabase);
		ValidatorTestUtils.createLinkName(ldapToDatabase);

		// service link ldap admin user DB2/LDAP system
		DependencyLink LdapAdminUserDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		LdapAdminUserDependencyLink.setTarget(providedLdapAdminUser);
		requiredLdapAdminUser.setLink(LdapAdminUserDependencyLink);
		ValidatorTestUtils.createLinkName(LdapAdminUserDependencyLink);

		//
		// add second database to the instance to create marker
		//
		DB2Database providedDb2DatabasePlantsBy = Db2Factory.eINSTANCE
				.createDB2Database();
		providedDb2DatabasePlantsBy.setName("providedDb2DatabasePlantsBy");
		providedDb2DatabasePlantsBy.setDbAlias("PLANTSBY");
		providedDb2DatabasePlantsBy.setDbDrive("C:/DB2"); // ????
		providedDb2DatabasePlantsBy.setDbName("PLANTSBY");

		DB2DatabaseUnit db2DatabaseUnitPlantsBy = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		db2DatabaseUnitPlantsBy.setName("db2DatabaseUnitPlantsBy");
		db2DatabaseUnitPlantsBy.setDisplayName("db2DatabaseUnitPlantsBy");
		db2DatabaseUnitPlantsBy.getCapabilities().add(
				providedDb2DatabasePlantsBy);
		top.getUnits().add(db2DatabaseUnitPlantsBy);

		Requirement requiredDb2InstancePlantsBy = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2InstancePlantsBy.setName("consumedDb2InstancePlantsBy");
		requiredDb2InstancePlantsBy.setDmoEType(Db2Package.eINSTANCE
				.getDB2Instance());
		requiredDb2InstancePlantsBy
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		db2DatabaseUnitPlantsBy.getRequirements().add(
				requiredDb2InstancePlantsBy);

		IStatus status = validateUnit(top, validator, ldapServerUnit, context,
				reporter);
		assert status.getSeverity() == IStatus.OK;
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);

		// Add plants database to the instance
		ValidatorTestUtils.hosts(db2InstanceUnitLdap, db2DatabaseUnitPlantsBy);

		status = validateUnit(top, validator, ldapServerUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);

		// break hosts between plants database and instance
		// It is OK to use getHostingLinks() in this test case.
		for (Iterator iter = db2InstanceUnitLdap.getHostingLinks().iterator(); iter
				.hasNext();) {
			HostingLink link = (HostingLink) iter.next();
			if (db2DatabaseUnitPlantsBy.equals(link.getHosted())) {
				db2InstanceUnitLdap.getHostingLinks().remove(link);
				System.out.println("removing link");
				break;
			}
		}
		status = validateUnit(top, validator, ldapServerUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);

		//
		// change name conflict between ldap and os to create marker
		providedDb2InstanceLdap.setHostname("rf12.watson.ibm.com");
		providedOperatingSystem2.setHostname("rf11.watson.ibm.com");

		status = validateUnit(top, validator, ldapServerUnit, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);
		providedOperatingSystem2.setHostname("rf12.watson.ibm.com");
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);

		String savedSuffixDN = providedSuffix2.getSuffixDN();
		providedSuffix2.setSuffixDN(providedSuffix1.getSuffixDN());
		ValidatorTestUtils.assertValidationErrorCount(1, top, ldapServerUnit,
				context, reporter, validator);
		providedSuffix2.setSuffixDN(savedSuffixDN);
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);

		String savedAdminstratorDN = providedLdap.getAdministratorDN();
		providedLdap.setAdministratorDN("8(()&&&&");
		ValidatorTestUtils.assertValidationErrorCount(1, top, ldapServerUnit,
				context, reporter, validator);
		providedLdap.setAdministratorDN(savedAdminstratorDN);
		ValidatorTestUtils.assertValidationErrorCount(0, top, ldapServerUnit,
				context, reporter, validator);
 
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
