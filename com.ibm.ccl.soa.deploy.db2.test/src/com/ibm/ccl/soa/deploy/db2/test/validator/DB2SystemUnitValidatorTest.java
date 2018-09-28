/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test.validator;

import java.io.IOException;
import java.math.BigInteger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
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
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2SystemUnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Tests {@link DB2SystemUnit}.
 * 
 * @author barnold
 * 
 */
public class DB2SystemUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2SystemUnitValidatorTest";

	public DB2SystemUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testDB2SystemUnitValidator() throws IOException, CoreException {

		// Asserts for version string syntax.
		assert (ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "8.1")); //$NON-NLS-1$
		assert (!ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "8.a")); //$NON-NLS-1$
		assert (!ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "xyz")); //$NON-NLS-1$
// assert
// (!ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(),
// "8")); //$NON-NLS-1$
		assert (ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "8.1.19")); //$NON-NLS-1$				
		assert (ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "7.2")); //$NON-NLS-1$						
		assert (ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "7.2.22.1")); //$NON-NLS-1$								
		assert (ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "8.2.22222.1111111")); //$NON-NLS-1$
		assert (!ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(), "8.a.3")); //$NON-NLS-1$						

		Topology top = createTopology("DB2DatabaseUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2SystemUnitValidator validator = new DB2SystemUnitValidator();

		//
		// Database unit
		//
		DB2Database providedDatabase = Db2Factory.eINSTANCE.createDB2Database();
		providedDatabase.setName("providedDatabase");
		providedDatabase.setDbAlias("DATABASE");
		providedDatabase.setDbDrive("C:/DB2");
		providedDatabase.setDbName("DATABASE");

		DB2DatabaseUnit databaseUnit = Db2Factory.eINSTANCE.createDB2DatabaseUnit();
		databaseUnit.setName("databaseUnit");
		top.getUnits().add(databaseUnit);

		Requirement requiredInstance = CoreFactory.eINSTANCE.createRequirement();
		requiredInstance.setName("requiredInstance");
		requiredInstance.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredInstance.setDmoEType(Db2Package.eINSTANCE.getDB2Instance());

		databaseUnit.getOnlyDependencyCapabilities().add(providedDatabase);
		databaseUnit.getRequirements().add(requiredInstance);

		FileArtifact ddlArtPlantsBy = CoreFactory.eINSTANCE.createFileArtifact();
		ddlArtPlantsBy.setName("demoDDL");
		ddlArtPlantsBy.getFileURIs().add("demo.ddl");
		databaseUnit.getArtifacts().add(ddlArtPlantsBy);

		DeployMarker.deleteInstances(top);

		assert databaseUnit.getStatus().getSeverity() == IStatus.OK;
		//
		// Instance unit
		//

		DB2Instance providedInstance = Db2Factory.eINSTANCE.createDB2Instance();
		providedInstance.setName("providedInstance");
		providedInstance.setDb2InstanceName("DB2INST1");
		providedInstance.setHostname("test.ibm.com");
		providedInstance.setUsername("db2admin");
		providedInstance.setPassword("db2admin");
		providedInstance.setPort(BigInteger.valueOf(50000));
		providedInstance.setDb2Version("8.1.0.36");

		DB2InstanceUnit instanceUnit = Db2Factory.eINSTANCE.createDB2InstanceUnit();
		instanceUnit.setName("instanceUnit");
		instanceUnit.getHostingOrAnyCapabilities().add(providedInstance);
		top.getUnits().add(instanceUnit);
		ValidatorTestUtils.hosts(instanceUnit, databaseUnit);

		Requirement requiredSystem = CoreFactory.eINSTANCE.createRequirement();
		requiredSystem.setName("requiredSystem");
		requiredSystem.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredSystem.setDmoEType(Db2Package.eINSTANCE.getDB2System());
// requiredSystem.getExpressions().add(Equals.createExpression(Db2Package.eINSTANCE.getDB2System_Db2Version(),
// "8.1.0.36"));

		Requirement requiredUser = CoreFactory.eINSTANCE.createRequirement();
		requiredUser.setName("requiredDb2AdminUser");
		requiredUser.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredUser.setDmoEType(OsPackage.eINSTANCE.getUser());
		EqualsConstraint ec1 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec1.setName("ec1");
		ec1.setValue("db2admin");
		ec1.setAttributeName(OsPackage.eINSTANCE.getUser_UserId().getName());
		requiredUser.getConstraints().add(ec1);

		EqualsConstraint ec2 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec2.setName("ec2");
		ec2.setValue("db2admin");
		ec2.setAttributeName(OsPackage.eINSTANCE.getUser_UserPassword().getName());
		requiredUser.getConstraints().add(ec2);

		instanceUnit.getRequirements().add(requiredUser);
		instanceUnit.getRequirements().add(requiredSystem);

		//
		// System unit
		//

		//
		// Provided DB2 JDBC driver service
		//
		DB2JdbcDriver providedDb2JdbcDriver;
		providedDb2JdbcDriver = Db2Factory.eINSTANCE.createDB2JdbcDriver();
		providedDb2JdbcDriver.setName("providedDb2JdbcDriver");
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcDriver.setClasspath("C:/IBM/SQLLIB/java/db2java.zip");
		providedDb2JdbcDriver.setClassname("DB2CPoolDS");

		DB2System providedSystem = Db2Factory.eINSTANCE.createDB2System();
		providedSystem.setName("providedSystem");
		providedSystem.setInstallDir("C:\\IBM\\SQLLIB");
		providedSystem.setDb2Version("8.1.0.36");

		DB2SystemUnit systemUnit = Db2Factory.eINSTANCE.createDB2SystemUnit();
		systemUnit.setName("systemUnit");
		providedSystem.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		systemUnit.getCapabilities().add(providedSystem);
// systemUnit.getHostingOrAnyCapabilities().add(providedSystem);
		systemUnit.getOnlyDependencyCapabilities().add(providedDb2JdbcDriver);
		top.getUnits().add(systemUnit);
		ValidatorTestUtils.hosts(systemUnit, instanceUnit);

		DB2System providedSystem2 = Db2Factory.eINSTANCE.createDB2System();
		providedSystem2.setName("providedSystem2");
		providedSystem2.setInstallDir("C:\\IBM\\SQLLIB2");
		providedSystem2.setDb2Version("8.1.0.36");
		providedSystem2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		DB2SystemUnit systemUnit2 = Db2Factory.eINSTANCE.createDB2SystemUnit();
		systemUnit2.setName("systemUnit2");
		systemUnit2.getCapabilities().add(providedSystem2);
		top.getUnits().add(systemUnit2);

		DB2Client db2Client = Db2Factory.eINSTANCE.createDB2Client();
		db2Client.setName("db2Client");
		db2Client.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		db2Client.setInstallDir("C:\\IBM\\SQLLIB");
		db2Client.setDb2ClientVersion("8.1.0.36");
		systemUnit.getCapabilities().add(db2Client);

		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE.createOperatingSystemUnit();
		operatingSystemUnit.setName("operatingSystemUnit");
		top.getUnits().add(operatingSystemUnit);

		Requirement requiredOperatingSystem = CoreFactory.eINSTANCE.createRequirement();
		requiredOperatingSystem.setName("requiredOperatingSystem");
		requiredOperatingSystem.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredOperatingSystem.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
		EqualsConstraint ec3 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec3.setName("ec3");
		ec3.setValue(OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ec3.setAttributeName(OsPackage.eINSTANCE.getOperatingSystem_OsType().getName());
		requiredOperatingSystem.getConstraints().add(ec3);
		systemUnit.getRequirements().add(requiredOperatingSystem);

		OperatingSystem providedWindowsOperatingSystem = OsFactory.eINSTANCE.createWindowsOperatingSystem();
		providedWindowsOperatingSystem.setName("providedWindowsOperatingSystem");
		providedWindowsOperatingSystem.setOsType(OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		providedWindowsOperatingSystem.setOsVersion("Win2K");
		operatingSystemUnit.getHostingOrAnyCapabilities().add(providedWindowsOperatingSystem);

		ValidatorTestUtils.hosts(operatingSystemUnit, systemUnit);
		ValidatorTestUtils.hosts(operatingSystemUnit, systemUnit2);

		// /////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////

		validator.validate(systemUnit, context, reporter);
// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		// Syntactically invalid version string
		String savedDb2Version = providedSystem.getDb2Version();
		providedSystem.setDb2Version("yyfdjkl");
		// One for invalid syntax, one for db2clientversion not equals
		ValidatorTestUtils.assertValidationErrorCount(2, top, systemUnit, context, reporter, validator);
		providedSystem.setDb2Version("");
		ValidatorTestUtils.assertValidationErrorCount(2, top, systemUnit, context, reporter, validator);
		providedSystem.setDb2Version(savedDb2Version);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		// DB2 Client/system version numbers match
		String savedDb2ClientVersion = db2Client.getDb2ClientVersion();
		db2Client.setDb2ClientVersion(savedDb2Version + "1");
		ValidatorTestUtils.assertValidationErrorCount(1, top, systemUnit, context, reporter, validator);
		db2Client.setDb2ClientVersion(savedDb2ClientVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		JdbcTypeType savedJdbcType = providedDb2JdbcDriver.getJdbcType();
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._1_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, top, systemUnit, context, reporter, validator);
		providedDb2JdbcDriver.setJdbcType(savedJdbcType);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		String savedInstallDir = providedSystem.getInstallDir();
		providedSystem.setInstallDir("/opt"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, systemUnit, context, reporter, validator);
		providedSystem.setInstallDir(savedInstallDir);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		// Uniqueness of installdir for system
		providedSystem.setInstallDir(providedSystem2.getInstallDir());
		ValidatorTestUtils.assertValidationErrorCount(1, top, systemUnit, context, reporter, validator);
		providedSystem.setInstallDir(savedInstallDir);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		// Client installdir appropriate for operating system
		String savedClientInstallDir = db2Client.getInstallDir();
		db2Client.setInstallDir("/opt"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, systemUnit, context, reporter, validator);
		db2Client.setInstallDir(savedClientInstallDir);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

		String goodClassname = providedDb2JdbcDriver.getClassname();
		providedDb2JdbcDriver.setClassname("a-b-c"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, systemUnit, context, reporter, validator);
		providedDb2JdbcDriver.setClassname(goodClassname);
		ValidatorTestUtils.assertValidationErrorCount(0, top, systemUnit, context, reporter, validator);

	}

}
