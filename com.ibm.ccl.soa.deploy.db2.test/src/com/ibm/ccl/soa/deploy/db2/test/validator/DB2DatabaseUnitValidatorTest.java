/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test.validator;

/**
 * Test for DB2 database unit validations.
 * 
 * @version
 * @author Bill Arnold (barnold@us.ibm.com)
 */

import java.io.IOException;
import java.math.BigInteger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.database.SQLUser;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2DatabaseUnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Tests {@link DB2DatabaseUnit}.
 * 
 * @author barnold
 * 
 */
public class DB2DatabaseUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2DatabaseUnitValidatorTest";

	private DB2SystemUnit systemUnit;

	private Requirement requiredDb2AdminUser;

	public DB2DatabaseUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testDB2DatabaseUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("DB2DatabaseUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2DatabaseUnitValidator validator = new DB2DatabaseUnitValidator();

		//
		// SQL Module 1
		// 

		SQLModule sqlModule1 = DatabaseFactory.eINSTANCE.createSQLModule();

		FileArtifact ddlArtPlantsBy1 = CoreFactory.eINSTANCE
				.createFileArtifact();
		ddlArtPlantsBy1.setName("demoDDL1");
		ddlArtPlantsBy1.getFileURIs().add("demo.ddl");
		sqlModule1.getArtifacts().add(ddlArtPlantsBy1);
		Requirement sql2dbReq1 = ValidatorTestUtils.createHostingRequirement(
				Db2Package.eINSTANCE.getDB2Database(), "sql2dbReq1");
		sqlModule1.getRequirements().add(sql2dbReq1);
		top.getUnits().add(sqlModule1);

		SQLUser sqlUser1 = DatabaseFactory.eINSTANCE.createSQLUser();
		sqlUser1.setName("sqlUser1");
		sqlUser1.setDisplayName("sqlUser1");
		sqlUser1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		sqlUser1.setUserId("db2admin");
		sqlUser1.setUserPassword("db2admin");
		sqlModule1.getCapabilities().add(sqlUser1);

		//
		// Database unit 1
		//
		DB2Database providedDatabase1 = Db2Factory.eINSTANCE
				.createDB2Database();
		providedDatabase1.setName("providedDatabase1");
		providedDatabase1.setDbAlias("DBASE1");
		providedDatabase1.setDbDrive("C:/DB2");
		providedDatabase1.setDbName("DBASE1");

		DB2DatabaseUnit databaseUnit1 = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		databaseUnit1.setName("databaseUnit1");
		top.getUnits().add(databaseUnit1);
		ValidatorTestUtils.hosts(databaseUnit1, sqlModule1);

		Requirement requiredInstance1 = CoreFactory.eINSTANCE
				.createRequirement();
		requiredInstance1.setDmoEType(Db2Package.eINSTANCE.getDB2Instance());
		requiredInstance1.setName("requiredInstance1");
		requiredInstance1.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		databaseUnit1.getHostingOrAnyCapabilities().add(providedDatabase1);
		databaseUnit1.getRequirements().add(requiredInstance1);

		DeployMarker.deleteInstances(top);

		assert databaseUnit1.getStatus().getSeverity() == IStatus.OK;

		// SQL Module 2
		// 
		SQLModule sqlModule2 = DatabaseFactory.eINSTANCE.createSQLModule();

		FileArtifact ddlArtPlantsBy2 = CoreFactory.eINSTANCE
				.createFileArtifact();
		ddlArtPlantsBy2.setName("demoDDL");
		ddlArtPlantsBy2.getFileURIs().add("demo.ddl");
		sqlModule2.getArtifacts().add(ddlArtPlantsBy1);
		Requirement sql2dbReq2 = ValidatorTestUtils.createHostingRequirement(
				Db2Package.eINSTANCE.getDB2Database(), "sql2dbReq2");
		sqlModule2.getRequirements().add(sql2dbReq2);
		top.getUnits().add(sqlModule2);

		//
		// Database unit 2
		//
		DB2Database providedDatabase2 = Db2Factory.eINSTANCE
				.createDB2Database();
		providedDatabase2.setName("providedDatabase2");
		providedDatabase2.setDbAlias("DBASE2");
		providedDatabase2.setDbDrive("C:/DB2");
		providedDatabase2.setDbName("DBASE2");

		DB2DatabaseUnit databaseUnit2 = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		databaseUnit2.setName("databaseUnit2");
		top.getUnits().add(databaseUnit2);
		ValidatorTestUtils.hosts(databaseUnit2, sqlModule2);

		Requirement requiredInstance2 = CoreFactory.eINSTANCE
				.createRequirement();
		requiredInstance2.setDmoEType(Db2Package.eINSTANCE.getDB2Instance());
		requiredInstance2.setName("requiredInstance2");
		requiredInstance2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		databaseUnit2.getHostingOrAnyCapabilities().add(providedDatabase2);
		databaseUnit2.getRequirements().add(requiredInstance2);

		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);

		assert databaseUnit2.getStatus().getSeverity() == IStatus.OK;

		//
		// Instance unit
		//

		DB2Instance providedInstance = Db2Factory.eINSTANCE.createDB2Instance();
		providedInstance.setName("providedInstance");
		providedInstance.setDb2InstanceName("DB2INST");
		providedInstance.setHostname("test.ibm.com");
		providedInstance.setUsername("db2admin");
		providedInstance.setPassword("db2admin");
		providedInstance.setPort(BigInteger.valueOf(50000));
		providedInstance.setDb2Version("8.1.0.36");

		DB2InstanceUnit instanceUnit = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		instanceUnit.setName("instanceUnit");
		instanceUnit.getHostingOrAnyCapabilities().add(providedInstance);
		top.getUnits().add(instanceUnit);
		ValidatorTestUtils.hosts(instanceUnit, databaseUnit1);
		ValidatorTestUtils.hosts(instanceUnit, databaseUnit2);
		DB2System consumedSystem = Db2Factory.eINSTANCE.createDB2System();
		consumedSystem.setName("consumedSystem");

		//
		// System unit
		//

		DB2System providedSystem = Db2Factory.eINSTANCE.createDB2System();
		providedSystem.setName("providedSystem");
		providedSystem.setInstallDir("C:\\IBM\\SQLLIB");
		providedSystem.setDb2Version("8.1.0.36");

		systemUnit = Db2Factory.eINSTANCE.createDB2SystemUnit();
		systemUnit.setName("systemUnit");
		systemUnit.getHostingOrAnyCapabilities().add(providedSystem);
		top.getUnits().add(systemUnit);
		ValidatorTestUtils.hosts(systemUnit, instanceUnit);

		Requirement requiredOs;
		requiredOs = CoreFactory.eINSTANCE.createRequirement();
		requiredOs.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
		requiredOs.setName("requiredOs");
		EqualsConstraint ec1 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec1.setName("ec1");
		ec1.setValue(OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ec1.setAttributeName(OsPackage.eINSTANCE
				.getOperatingSystem_OsType().getName());
		requiredOs.getConstraints().add(ec1);
		EqualsConstraint ec2 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec2.setName("ec2");
		ec2.setValue("Win2k");
		ec2.setAttributeName(OsPackage.eINSTANCE
				.getOperatingSystem_OsVersion().getName());
		requiredOs.getConstraints().add(ec2);

		OperatingSystem providedWinOs = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
		providedWinOs.setName("providedWinOs");
		providedWinOs.setOsType(OperatingSystemType.WINDOWS_LITERAL
				.getLiteral());
		providedWinOs.setHostname("test.ibm.com");

		OperatingSystemUnit osUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		osUnit.setName("osUnit");
		osUnit.getHostingOrAnyCapabilities().add(providedWinOs);
		top.getUnits().add(osUnit);
		ValidatorTestUtils.hosts(osUnit, systemUnit);

		User providedUser;
		providedUser = OsFactory.eINSTANCE.createUser();
		providedUser.setName("providedUser");
		providedUser.setUserId("db2admin");
		providedUser.setUserPassword("db2admin");

		UserUnit userUnit = OsFactory.eINSTANCE.createUserUnit();
		userUnit.setName("userUnit");
		userUnit.getOnlyDependencyCapabilities().add(providedUser);
		top.getUnits().add(userUnit);
		ValidatorTestUtils.hosts(osUnit, userUnit);

		// /////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////

		validator.validate(databaseUnit1, context, reporter);
// assert databaseUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		assert (DeployMarker.getInstances(top).length == 0);

		// DbName checks
		String goodDbName = providedDatabase1.getDbName();
		// Empty dbname
		providedDatabase1.setDbName("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// dbname with invalid characters
		providedDatabase1.setDbName("___");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// dbname too long
		providedDatabase1.setDbName("AAAABBBBCCCCDDDD");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// Instance name restricted prefix
		providedDatabase1.setDbName("SYSAAAA");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// Instance name restricted name
		providedDatabase1.setDbName("ADMINS");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// Clean up
		providedDatabase1.setDbName(goodDbName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, databaseUnit1,
				context, reporter, validator);

		// DbAlias checks
		String goodDbAlias = providedDatabase1.getDbAlias();
		// Empty dbAlias is allowed

		// dbAlias with invalid characters
		providedDatabase1.setDbAlias("___");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// dbAlias too long
		providedDatabase1.setDbAlias("AAAABBBBCCCCDDDD");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// Instance name restricted prefix
		providedDatabase1.setDbAlias("SYSAAAA");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// Instance name restricted name
		providedDatabase1.setDbAlias("ADMINS");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);

		// cleanup
		providedDatabase1.setDbAlias(goodDbAlias);
		ValidatorTestUtils.assertValidationErrorCount(0, top, databaseUnit1,
				context, reporter, validator);

		// Uniqueness of database name check

		providedDatabase1.setDbName(providedDatabase2.getDbName());
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);
		providedDatabase1.setDbName(goodDbName);

		String goodSqlUserID = sqlUser1.getUserId();
		sqlUser1.setUserId(goodSqlUserID + "x");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);
		sqlUser1.setUserId(goodSqlUserID);
		ValidatorTestUtils.assertValidationErrorCount(0, top, databaseUnit1,
				context, reporter, validator);

		String goodSqlUserPassword = sqlUser1.getUserPassword();
		sqlUser1.setUserPassword(goodSqlUserPassword + "x");
		ValidatorTestUtils.assertValidationErrorCount(1, top, databaseUnit1,
				context, reporter, validator);
		sqlUser1.setUserPassword(goodSqlUserPassword);
		ValidatorTestUtils.assertValidationErrorCount(0, top, databaseUnit1,
				context, reporter, validator);
	}
}
