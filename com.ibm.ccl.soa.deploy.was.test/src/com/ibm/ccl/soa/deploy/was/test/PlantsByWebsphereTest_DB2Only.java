/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.Directory;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerFactory;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * @since 3.2
 * @see PlantsByWebsphereTest
 */
public class PlantsByWebsphereTest_DB2Only extends PlantsByWebsphereTest {

// private static final String PROJECT_NAME = "PlantsByWASTest";

	protected DB2Database providedDb2DatabaseLdap;

	protected DB2Instance providedDb2InstancePlantsBy;

	protected DB2Database providedDb2DatabasePlantsBy;

	protected OperatingSystem providedOperatingSystem2;

	protected Directory providedDirectory2;

	protected User providedDb2AdminUser;

	protected User providedLdapAdminUser;

	protected DB2System providedDb2System;

	protected Requirement requiredDb2JdbcDriver;

	protected DB2InstanceUnit db2InstanceUnitPlantsBy;

	protected DB2JdbcProviderUnit db2JdbcProviderUnit;

	protected OperatingSystemUnit operatingSystemUnit2;

	protected DependencyLink db2AdminUserDependencyLink;

	/**
	 * @param top
	 */
	public void populateDb2Topology(Topology top) {

		// LDAP stack
		providedDb2DatabaseLdap = Db2Factory.eINSTANCE.createDB2Database();
		providedDb2DatabaseLdap.setName("providedDb2DatabaseLdap");
		providedDb2DatabaseLdap.setDbAlias("LDAP");
		providedDb2DatabaseLdap.setDbDrive("C:/DB2"); // ????
		providedDb2DatabaseLdap.setDbName("LDAP");

		DB2DatabaseUnit db2DatabaseUnitLdap = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		db2DatabaseUnitLdap.setName("db2DatabaseUnitLdap");
		db2DatabaseUnitLdap.getHostingOrAnyCapabilities().add(
				providedDb2DatabaseLdap);
		top.getUnits().add(db2DatabaseUnitLdap);

		Requirement requiredDb2InstanceLdap = ValidatorTestUtils
				.createHostingRequirement(Db2Package.Literals.DB2_INSTANCE,
						"requiredDb2InstanceLdap");

		db2DatabaseUnitLdap.getRequirements().add(requiredDb2InstanceLdap);

		DB2Instance providedDb2InstanceLdap = Db2Factory.eINSTANCE
				.createDB2Instance();
		providedDb2InstanceLdap.setName("providedDb2InstanceLdap");
		providedDb2InstanceLdap.setDb2InstanceName("LDAPINST");
		providedDb2InstanceLdap.setHostname("rf12.watson.ibm.com");
		providedDb2InstanceLdap.setUsername("ldapadmin");
		providedDb2InstanceLdap.setPassword("ldapadmin");
		providedDb2InstanceLdap.setPort(BigInteger.valueOf(50001));
		providedDb2InstanceLdap.setDb2Version("8.1.0.36");
		providedDb2InstanceLdap.setAutoStart(false);

		DB2InstanceUnit db2InstanceUnitLdap = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		db2InstanceUnitLdap.setName("db2InstanceUnitLdap");
		db2InstanceUnitLdap.getHostingOrAnyCapabilities().add(
				providedDb2InstanceLdap);
		top.getUnits().add(db2InstanceUnitLdap);

		Requirement requiredDb2SystemLdap = ValidatorTestUtils
				.createHostingRequirement(Db2Package.Literals.DB2_SYSTEM,
						"requiredDb2SystemLdap");

		Requirement requiredLdapAdminUser = ValidatorTestUtils
				.createDependencyRequirement(OsPackage.Literals.USER,
						"requiredLdapAdminUser");
		ValidatorTestUtils.addEqualsConstraint(requiredLdapAdminUser,
				OsPackage.Literals.USER__USER_ID, "ldapadmin");
		ValidatorTestUtils.addEqualsConstraint(requiredLdapAdminUser,
				OsPackage.Literals.USER__USER_PASSWORD, "ldapadmin");

		db2InstanceUnitLdap.getRequirements().add(requiredDb2SystemLdap);
		db2InstanceUnitLdap.getRequirements().add(requiredLdapAdminUser);

		// PlantsBy stack
		providedDb2DatabasePlantsBy = Db2Factory.eINSTANCE.createDB2Database();
		providedDb2DatabasePlantsBy.setName("providedDb2DatabasePlantsBy");
		providedDb2DatabasePlantsBy.setDbAlias("PLANTSBY");
		providedDb2DatabasePlantsBy.setDbDrive("C:/DB2"); // ????
		providedDb2DatabasePlantsBy.setDbName("PLANTSBY");

		DB2DatabaseUnit db2DatabaseUnitPlantsBy = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		db2DatabaseUnitPlantsBy.setName("db2DatabaseUnitPlantsBy");
		db2DatabaseUnitPlantsBy.setDisplayName("db2DatabaseUnitPlantsBy");
		db2DatabaseUnitPlantsBy.getHostingOrAnyCapabilities().add(
				providedDb2DatabasePlantsBy);
		top.getUnits().add(db2DatabaseUnitPlantsBy);

		FileArtifact ddlArtPlantsBy = CoreFactory.eINSTANCE
				.createFileArtifact();
		ddlArtPlantsBy.setName("ddlPlantsByArt");
		ddlArtPlantsBy.getFileURIs().add("plants.ddl");

		SQLModule sqlModule = DatabaseFactory.eINSTANCE.createSQLModule();
		sqlModule.setName("plantsBySQLModule");
		sqlModule.getArtifacts().add(ddlArtPlantsBy);
		Requirement requiredDBHosting = ValidatorTestUtils
				.createHostingRequirement(DatabasePackage.Literals.DATABASE,
						"requiedDBHosting");
		sqlModule.getRequirements().add(requiredDBHosting);
		top.getUnits().add(sqlModule);

		Requirement requiredDb2InstancePlantsBy = ValidatorTestUtils
				.createHostingRequirement(Db2Package.Literals.DB2_INSTANCE,
						"requiredDb2InstancePlantsBy");

		db2DatabaseUnitPlantsBy.getRequirements().add(
				requiredDb2InstancePlantsBy);

		providedDb2InstancePlantsBy = Db2Factory.eINSTANCE.createDB2Instance();
		providedDb2InstancePlantsBy.setName("providedDb2InstancePlantsBy");
		providedDb2InstancePlantsBy.setDb2InstanceName("DB2PB");
		providedDb2InstancePlantsBy.setHostname("rf12.watson.ibm.com");
		providedDb2InstancePlantsBy.setUsername("db2admin");
		providedDb2InstancePlantsBy.setPassword("db2admin");
		providedDb2InstancePlantsBy.setPort(BigInteger.valueOf(50000));
		providedDb2InstancePlantsBy.setAutoStart(false);
		providedDb2InstancePlantsBy.setDb2Version("8.1.0.36");

		db2InstanceUnitPlantsBy = Db2Factory.eINSTANCE.createDB2InstanceUnit();
		db2InstanceUnitPlantsBy.setName("db2InstanceUnitPlantsBy");
		db2InstanceUnitPlantsBy.getHostingOrAnyCapabilities().add(
				providedDb2InstancePlantsBy);
		top.getUnits().add(db2InstanceUnitPlantsBy);

		Requirement requiredDb2SystemPlantsBy = ValidatorTestUtils
				.createHostingRequirement(Db2Package.Literals.DB2_SYSTEM,
						"requiredDb2SystemPlantsBy");

		Requirement requiredDb2AdminUser = ValidatorTestUtils
				.createDependencyRequirement(OsPackage.Literals.USER,
						"requiredDb2AdminUser");
		ValidatorTestUtils.addEqualsConstraint(requiredDb2AdminUser,
				OsPackage.Literals.USER__USER_ID, "db2admin");
		ValidatorTestUtils.addEqualsConstraint(requiredDb2AdminUser,
				OsPackage.Literals.USER__USER_PASSWORD, "db2admin");

		//
		db2InstanceUnitPlantsBy.getRequirements()
				.add(requiredDb2SystemPlantsBy);
		db2InstanceUnitPlantsBy.getRequirements().add(requiredDb2AdminUser);

		// Common parts of stack

		providedDb2System = Db2Factory.eINSTANCE.createDB2System();
		providedDb2System.setName("providedDb2System");
		providedDb2System.setInstallDir("C:\\IBM\\SQLLIB");
		providedDb2System.setDb2Version("8.1.0.36");

		// hosting link up PlantsBy stack
		ValidatorTestUtils.hosts(db2InstanceUnitPlantsBy,
				db2DatabaseUnitPlantsBy);

		// Link up Ldap stack
		ValidatorTestUtils.hosts(db2InstanceUnitLdap, db2DatabaseUnitLdap);

		// Link up sql module to database unit
		ValidatorTestUtils.hosts(db2DatabaseUnitPlantsBy, sqlModule);

		//
		DB2SystemUnit db2SystemUnit = Db2Factory.eINSTANCE
				.createDB2SystemUnit();
		db2SystemUnit.setName("db2SystemUnit");
		db2SystemUnit.getHostingOrAnyCapabilities().add(providedDb2System);
		top.getUnits().add(db2SystemUnit);

		ValidatorTestUtils.hosts(db2SystemUnit, db2InstanceUnitLdap);

		ValidatorTestUtils.hosts(db2SystemUnit, db2InstanceUnitPlantsBy);

		// Jdbc provider/driver
		DB2JdbcProvider providedDb2JdbcProvider = WasFactory.eINSTANCE
				.createDB2JdbcProvider();
		providedDb2JdbcProvider.setName("providedDb2JdbcProvider");
		providedDb2JdbcProvider.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcProvider
				.setClasspath("c:/Program Files/IBM/SQLLIB/java/db2java.zip");
		providedDb2JdbcProvider
				.setProviderType(DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
						.toString());
		providedDb2JdbcProvider
				.setProviderName(DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
						.toString());
		providedDb2JdbcProvider.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		db2JdbcProviderUnit = WasFactory.eINSTANCE.createDB2JdbcProviderUnit();
		db2JdbcProviderUnit.setName("Db2JdbcProviderUnit");
		db2JdbcProviderUnit.getCapabilities().add(providedDb2JdbcProvider);
		top.getUnits().add(db2JdbcProviderUnit);

		// requiredDb2JdbcDriver = Db2Factory.eINSTANCE.createDB2JdbcDriver();
		requiredDb2JdbcDriver = ValidatorTestUtils.createDependencyRequirement(
				Db2Package.Literals.DB2_JDBC_DRIVER, "requiredDb2JdbcDriver");
		ValidatorTestUtils.addEqualsConstraint(requiredDb2JdbcDriver,
				Db2Package.Literals.DB2_JDBC_DRIVER__JDBC_TYPE,
				JdbcTypeType._2_LITERAL);
		db2JdbcProviderUnit.getRequirements().add(requiredDb2JdbcDriver);

		Requirement requiredWasConfigurationContainer = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_CONFIGURATION_CONTAINER,
						"requiredWasConfigurationContainer");
		db2JdbcProviderUnit.getRequirements().add(
				requiredWasConfigurationContainer);

		DB2JdbcDriver providedDb2JdbcDriver = Db2Factory.eINSTANCE
				.createDB2JdbcDriver();
		providedDb2JdbcDriver.setName("providedDb2JdbcDriver2");
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcDriver.setClassname("foo.bar.cat.dog");
		providedDb2JdbcDriver
				.setClasspath("C:/Program Files/IBM/SQLLIB/java/db2java.zip");
		db2SystemUnit.getOnlyDependencyCapabilities()
				.add(providedDb2JdbcDriver);

		// Operating system, system unit. This is stack 2
		Requirement requiredOperatingSystem2 = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredOperatingSystem2");
		ValidatorTestUtils.addEqualsConstraint(requiredOperatingSystem2,
				OsPackage.Literals.OPERATING_SYSTEM__OS_TYPE,
				OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ValidatorTestUtils.addEqualsConstraint(requiredOperatingSystem2,
				OsPackage.Literals.OPERATING_SYSTEM__OS_VERSION, "Win2k");

		db2SystemUnit.getRequirements().add(requiredOperatingSystem2);

		providedOperatingSystem2 = OsFactory.eINSTANCE.createOperatingSystem();
		providedOperatingSystem2.setName("providedOperatingSystem");
		providedOperatingSystem2.setOsType(OperatingSystemType.WINDOWS_LITERAL
				.getLiteral());
		providedOperatingSystem2.setOsVersion("Win2k");
		providedOperatingSystem2.setHostname("rf12.watson.ibm.com");

		providedDirectory2 = OsFactory.eINSTANCE.createDirectory();
		providedDirectory2.setName("providedDirectory2");
		providedDirectory2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		providedDb2AdminUser = OsFactory.eINSTANCE.createUser();
		providedDb2AdminUser.setName("providedDb2AdminUser");
		providedDb2AdminUser.setUserId("db2admin");
		providedDb2AdminUser.setUserPassword("db2admin");
		providedDb2AdminUser
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);

		UserUnit userUnitDb2Admin = OsFactory.eINSTANCE.createUserUnit();
		userUnitDb2Admin.setName("UserUnitDb2Admin");
		top.getUnits().add(userUnitDb2Admin);
		userUnitDb2Admin.getCapabilities().add(providedDb2AdminUser);

		db2AdminUserDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		db2AdminUserDependencyLink.setTarget(providedDb2AdminUser);
		db2AdminUserDependencyLink.setSource(requiredDb2AdminUser);
		requiredDb2AdminUser.setLink(db2AdminUserDependencyLink);
		ValidatorTestUtils.createLinkName(db2AdminUserDependencyLink);

		providedLdapAdminUser = OsFactory.eINSTANCE.createUser();
		providedLdapAdminUser.setName("providedLdapAdminUser");
		providedLdapAdminUser.setUserId("ldapadmin");
		providedLdapAdminUser.setUserPassword("ldapadmin");

		UserUnit userUnitLdapAdmin = OsFactory.eINSTANCE.createUserUnit();
		userUnitLdapAdmin.setName("userUnitLdapAdmin");
		userUnitLdapAdmin.getOnlyDependencyCapabilities().add(
				providedLdapAdminUser);
		top.getUnits().add(userUnitLdapAdmin);

		Requirement requiredOperatingSystemDb2Admin = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredOperatingSystem2");
		ValidatorTestUtils.addEqualsConstraint(requiredOperatingSystemDb2Admin,
				OsPackage.Literals.OPERATING_SYSTEM__OS_TYPE,
				OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ValidatorTestUtils.addEqualsConstraint(requiredOperatingSystemDb2Admin,
				OsPackage.Literals.OPERATING_SYSTEM__OS_VERSION, "Win2k");

		Requirement memberUserGroupReqDB2 = ValidatorTestUtils
				.createMemberRequirement(OsPackage.Literals.USER_GROUP_UNIT,
						"memberUserGroupReq");

		userUnitDb2Admin.getRequirements().add(requiredOperatingSystemDb2Admin);
		userUnitDb2Admin.getRequirements().add(memberUserGroupReqDB2);

		Requirement requiredOperatingSystemLdapAdmin = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredOperatingSystemLdapAdmin");
		ValidatorTestUtils.addEqualsConstraint(
				requiredOperatingSystemLdapAdmin,
				OsPackage.Literals.OPERATING_SYSTEM__OS_TYPE,
				OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ValidatorTestUtils.addEqualsConstraint(
				requiredOperatingSystemLdapAdmin,
				OsPackage.Literals.OPERATING_SYSTEM__OS_VERSION, "Win2k");

		Requirement memberUserGroupReqLDAP = ValidatorTestUtils
				.createMemberRequirement(OsPackage.Literals.USER_GROUP_UNIT,
						"memberUserGroupReq");

		userUnitLdapAdmin.getRequirements().add(
				requiredOperatingSystemLdapAdmin);
		userUnitLdapAdmin.getRequirements().add(memberUserGroupReqLDAP);

		//
		// service link ldap admin user DB2/LDAP system
		//
		DependencyLink LdapAdminUserDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		LdapAdminUserDependencyLink.setTarget(providedLdapAdminUser);
		LdapAdminUserDependencyLink.setSource(requiredLdapAdminUser);
		requiredLdapAdminUser.setLink(LdapAdminUserDependencyLink);
		ValidatorTestUtils.createLinkName(LdapAdminUserDependencyLink);

		operatingSystemUnit2 = OsFactory.eINSTANCE.createOperatingSystemUnit();
		operatingSystemUnit2.setName("operatingSystemUnit2");
		operatingSystemUnit2.getHostingOrAnyCapabilities().add(
				providedOperatingSystem2);
		operatingSystemUnit2.getCapabilities().add(providedDirectory2);
		top.getUnits().add(operatingSystemUnit2);

		ValidatorTestUtils.hosts(operatingSystemUnit2, db2SystemUnit);
		ValidatorTestUtils.hosts(operatingSystemUnit2, userUnitDb2Admin);
		ValidatorTestUtils.hosts(operatingSystemUnit2, userUnitLdapAdmin);

		Requirement requiredServer2 = ValidatorTestUtils
				.createHostingRequirement(ServerPackage.Literals.SERVER,
						"requiredServer");
		ValidatorTestUtils.addEqualsConstraint(requiredServer2,
				ServerPackage.Literals.SERVER__CPU_ARCHITECTURE, "intel");
		ValidatorTestUtils
				.addEqualsConstraint(requiredServer2,
						ServerPackage.Literals.SERVER__CPU_COUNT, BigInteger
								.valueOf(1));
		operatingSystemUnit2.getRequirements().add(requiredServer2);

		Server providedServer2 = ServerFactory.eINSTANCE.createServer();
		providedServer2.setName("providedServer");
		providedServer2.setCpuArchitecture("intel");
		providedServer2.setCpuCount(BigInteger.valueOf(1));
		providedServer2.setMemorySize(BigInteger.valueOf(1500000)); // megabytes

		ServerUnit serverUnit2 = ServerFactory.eINSTANCE.createServerUnit();
		serverUnit2.setName("serverUnit2");
		serverUnit2.getHostingOrAnyCapabilities().add(providedServer2);
		top.getUnits().add(serverUnit2);

		ValidatorTestUtils.hosts(serverUnit2, operatingSystemUnit2);

	}

	/**
	 * @return a db2 topology
	 */
	public Topology createDb2Topology() {
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("PlantsByWebsphere Topology");

		return top;
	}
}
