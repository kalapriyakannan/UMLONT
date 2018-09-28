/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.DatabaseInstance;
import com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.database.SQLModule;

/**
 * @since 1.0
 * 
 */
public class DatabaseDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "DatabaseDomainTest";

	/**
	 * 
	 */
	public DatabaseDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testDatabaseDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/database.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Database Topology");

		root.setTopology(top);

		// Create DB Module with a DDL artifact
		SQLModule dbModule = DatabaseFactory.eINSTANCE.createSQLModule();
		dbModule.setName("TestDBModule");
		DDLArtifact dDLArtifact = DatabaseFactory.eINSTANCE.createDDLArtifact();
		dDLArtifact.setName("TestDatabaseDDLArtifact");
		dDLArtifact.getFileURIs().add("somewhere/data.ddl");
		dbModule.getArtifacts().add(dDLArtifact);
		top.getUnits().add(dbModule);

		// Add consumed database hosting service to DBModule
// Database dbHosting = DatabaseFactory.eINSTANCE.createDatabase();
// dbHosting.setName("consumedDBHostingService");
		Requirement requiredDbHosting = ValidatorTestUtils
				.createHostingRequirement(DatabasePackage.Literals.DATABASE,
						"requiredDbHosting");
		dbModule.getRequirements().add(requiredDbHosting);

		// Create DatabaseUnit, with provided DB Hosting, DB services
		DatabaseUnit databaseUnit = DatabaseFactory.eINSTANCE
				.createDatabaseUnit();
		databaseUnit.setName("TestDatabaseUnit");
		Database provDbHosting = DatabaseFactory.eINSTANCE.createDatabase();
		provDbHosting.setName("Provided Db Hosting service");
		databaseUnit.getHostingOrAnyCapabilities().add(provDbHosting);
		Database dbService = DatabaseFactory.eINSTANCE.createDatabase();
		dbService.setName("Provided Database service");
		databaseUnit.getOnlyDependencyCapabilities().add(dbService);
		top.getUnits().add(databaseUnit);

		// Host ddl on database unit
		ValidatorTestUtils.hosts(databaseUnit, dbModule);

		// Create Database Instance unit, with provided instance service
		DatabaseInstanceUnit databaseInstanceUnit = DatabaseFactory.eINSTANCE
				.createDatabaseInstanceUnit();
		databaseInstanceUnit.setName("TestDatabaseInstanceUnit");
		DatabaseInstance databaseInstanceService = DatabaseFactory.eINSTANCE
				.createDatabaseInstance();
		databaseInstanceService.setName("TestDbInstanceService");
		databaseInstanceUnit.getOnlyDependencyCapabilities().add(
				databaseInstanceService);
		top.getUnits().add(databaseInstanceUnit);

		// Special test - consume non-hosting, provided hosting
		// capability.database
		DatabaseUnit consumingDatabase = DatabaseFactory.eINSTANCE
				.createDatabaseUnit();
		consumingDatabase.setName("consumingDatabase");
		Requirement requiredNonHostingDatabaseService = ValidatorTestUtils
				.createDependencyRequirement(DatabasePackage.Literals.DATABASE,
						"requiredNonHostingDatabaseService");
		consumingDatabase.getRequirements().add(
				requiredNonHostingDatabaseService);
		top.getUnits().add(consumingDatabase);

		DatabaseUnit providingDatabase = DatabaseFactory.eINSTANCE
				.createDatabaseUnit();
		providingDatabase.setName("providingDatabase");
		Database providedHostingDatabaseService = DatabaseFactory.eINSTANCE
				.createDatabase();
		providedHostingDatabaseService
				.setName("TestrovidedHostingDatabaseService");
		providedHostingDatabaseService
				.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providingDatabase.getCapabilities().add(providedHostingDatabaseService);
		top.getUnits().add(providingDatabase);

		DependencyLink testlink = CoreFactory.eINSTANCE.createDependencyLink();
		testlink.setName("testlink");
		testlink.setTarget(providedHostingDatabaseService);
		requiredNonHostingDatabaseService.setLink(testlink);
		// End special test

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		assertNoValidationErrors(topology);
		res.unload();

	}

}
