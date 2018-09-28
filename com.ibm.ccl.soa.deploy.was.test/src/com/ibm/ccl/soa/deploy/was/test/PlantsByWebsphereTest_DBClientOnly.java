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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * @since 3.2
 * @see PlantsByWebsphereTest
 */
public class PlantsByWebsphereTest_DBClientOnly extends PlantsByWebsphereTest {

	private static final String PROJECT_NAME = "PlantsByWASTest";

	private IProject project;

	protected DB2Database providedDb2CDatabase;

	protected Requirement requiredDb2InstancePlants;

	protected Requirement requiredDb2CatalogedNode;

	protected Requirement requiredDb2DatabasePlantsBy;

	protected DB2RuntimeClientUnit db2RuntimeClientUnit;

	protected DB2JdbcDriver providedDb2JdbcDriver;

	protected DB2NodeCatalogUnit db2NodeCatalogUnit;

	protected void setUp() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	/**
	 * @param top
	 */
	public void populateDBClientTopology(Topology top) {

		// ////////////////////////////////////////////////////////////////////////////
		//
		// DB2 database catalog
		//
		// ////////////////////////////////////////////////////////////////////////////

		//
		// DB2 database service (cataloged)
		//
		providedDb2CDatabase = Db2Factory.eINSTANCE.createDB2Database();
		providedDb2CDatabase.setName("providedDb2CDatabase");
		providedDb2CDatabase.setDbName("PLANTSBY");
		providedDb2CDatabase.setDbAlias("PLANTSBY");
		providedDb2CDatabase.setDbDrive("C:/DB2");

		//
		// Requires DB2 cataloged node
		//
		requiredDb2CatalogedNode = ValidatorTestUtils.createHostingRequirement(
				Db2Package.Literals.DB2_CATALOGED_NODE,
				"requiredDb2CatalogedNode");

		//
		// Requires DB2 database service (remote one that is aliased)
		//
		requiredDb2DatabasePlantsBy = ValidatorTestUtils
				.createDependencyRequirement(Db2Package.Literals.DB2_DATABASE,
						"requiredDb2DatabasePlantsBy");
		ValidatorTestUtils.addEqualsExpression(requiredDb2DatabasePlantsBy,
				Db2Package.Literals.DB2_DATABASE__DB_NAME, "PLANTSBY");

		//
		// DB2 catalog unit
		// - provides DB2 database (local)
		// - requires node catalog, DB2 database (remote)
		//
		DB2CatalogUnit db2CatalogUnit = Db2Factory.eINSTANCE
				.createDB2CatalogUnit();
		db2CatalogUnit.setName("db2CatalogUnit");
		top.getUnits().add(db2CatalogUnit);

		db2CatalogUnit.getOnlyDependencyCapabilities()
				.add(providedDb2CDatabase);
		db2CatalogUnit.getRequirements().add(requiredDb2CatalogedNode);
		db2CatalogUnit.getRequirements().add(requiredDb2DatabasePlantsBy);

		// ////////////////////////////////////////////////////////////////////////////
		//
		// DB2 node catalog
		//
		// ////////////////////////////////////////////////////////////////////////////

		//
		// Provided DB2 node catalog service
		//
		DB2CatalogedNode providedDb2CatalogedNode = Db2Factory.eINSTANCE
				.createDB2CatalogedNode();
		providedDb2CatalogedNode.setName("providedDb2CatalogedNode");
		providedDb2CatalogedNode.setDasLevel("8.1.0.36");
		providedDb2CatalogedNode.setNodeName("DB2PB");
		providedDb2CatalogedNode.setNodeType("TCPIP");
		providedDb2CatalogedNode.setPort(BigInteger.valueOf(50000));
		providedDb2CatalogedNode.setHostname("rf12.watson.ibm.com");
		providedDb2CatalogedNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		//
		// Requires DB2 instance service (remote)
		//
		requiredDb2InstancePlants = ValidatorTestUtils
				.createDependencyRequirement(Db2Package.Literals.DB2_INSTANCE,
						"requiredDb2InstancePlants");
		ValidatorTestUtils.addEqualsExpression(requiredDb2InstancePlants,
				Db2Package.Literals.DB2_INSTANCE__HOSTNAME,
				"rf12.watson.ibm.com");
		ValidatorTestUtils.addEqualsExpression(requiredDb2InstancePlants,
				Db2Package.Literals.DB2_INSTANCE__PORT, BigInteger
						.valueOf(50000));

		//
		// DB2 node unit
		// - provides DB2 catalog node service
		// - requires DB2 client service, DB2 instance service
		//
		db2NodeCatalogUnit = Db2Factory.eINSTANCE.createDB2NodeCatalogUnit();
		db2NodeCatalogUnit.setName("db2NodeCatalogUnit");
		top.getUnits().add(db2NodeCatalogUnit);

		db2NodeCatalogUnit.getCapabilities().add(providedDb2CatalogedNode);
		db2NodeCatalogUnit.getRequirements().add(requiredDb2InstancePlants);

		Requirement requiredDB2ClientInst = ValidatorTestUtils
				.createHostingRequirement(Db2Package.eINSTANCE
						.getDB2ClientInstance(), "requiredDB2ClientInst");
		db2NodeCatalogUnit.getRequirements().add(requiredDB2ClientInst);

		// Db2 client instance
		DB2ClientInstanceUnit db2ClientInstanceUnit = Db2Factory.eINSTANCE
				.createDB2ClientInstanceUnit();
		db2ClientInstanceUnit.setName("db2InstanceUnitClient");
		db2ClientInstanceUnit.setDisplayName("db2InstanceUnitClient");
		top.getUnits().add(db2ClientInstanceUnit);

		DB2ClientInstance providedDb2ClientInstance = Db2Factory.eINSTANCE
				.createDB2ClientInstance();
		providedDb2ClientInstance.setName("providedDb2ClientInstance");
		providedDb2ClientInstance.setDisplayName("providedDb2ClientInstance");
		providedDb2ClientInstance.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedDb2ClientInstance.setDb2InstanceName("db2");
		providedDb2ClientInstance.setDb2Version("8.2");
		db2ClientInstanceUnit.getCapabilities().add(providedDb2ClientInstance);

		Requirement requiredDB2Client = ValidatorTestUtils
				.createHostingRequirement(Db2Package.eINSTANCE.getDB2Client(),
						"requiredDB2Client");
		db2ClientInstanceUnit.getRequirements().add(requiredDB2Client);

		ValidatorTestUtils.hosts(db2ClientInstanceUnit, db2NodeCatalogUnit);

		//
		// Provided DB2 client service
		//
		DB2Client providedDb2Client = Db2Factory.eINSTANCE.createDB2Client();
		providedDb2Client.setName("providedDb2Client");
		providedDb2Client.setDb2ClientVersion("8.1.0.36");
		providedDb2Client.setInstallDir("C:\\IBM\\SQLLIB");

		//
		// Provided DB2 JDBC driver service
		//
		providedDb2JdbcDriver = Db2Factory.eINSTANCE.createDB2JdbcDriver();
		providedDb2JdbcDriver.setName("providedDb2JdbcDriver");
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcDriver.setClasspath("C:/IBM/SQLLIB/java/db2java.zip");
		providedDb2JdbcDriver.setClassname("DB2CPoolDS");

		//
		// Requirement for OperatingSystem service
		//
		Requirement requiredDb2Cos = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredDb2Cos");

		//
		// DB2 client unit
		// - provides DB2 JDBC driver service, DB2 client service
		// - requires OperatingSystem service
		//
		db2RuntimeClientUnit = Db2Factory.eINSTANCE
				.createDB2RuntimeClientUnit();
		db2RuntimeClientUnit.setName("db2ClientUnit");
		top.getUnits().add(db2RuntimeClientUnit);

		db2RuntimeClientUnit.getHostingOrAnyCapabilities().add(
				providedDb2Client);
		db2RuntimeClientUnit.getOnlyDependencyCapabilities().add(
				providedDb2JdbcDriver);
		db2RuntimeClientUnit.getRequirements().add(requiredDb2Cos);

		ValidatorTestUtils.hosts(db2RuntimeClientUnit, db2ClientInstanceUnit);
		ValidatorTestUtils.hosts(db2NodeCatalogUnit, db2CatalogUnit);
	}

	/**
	 * @return a dbclient topology
	 */
	public Topology createDBClientTopology() {
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("PlantsByWebsphere Topology");

		return top;
	}
}
