/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.domains;

import java.math.BigInteger;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDDLArtifact;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyFactory;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;

/**
 * @since 1.0
 * 
 */
public class DerbyDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "DerbyDomainTest"; //$NON-NLS-1$

	private static final String DERBY_100_DATABASE_RESOURCE_ID = "derby.database.10.0";
	private static final String DERBY_101_DATABASE_RESOURCE_ID = "derby.database.10.1";
	private static final String DERBY_100_INSTANCE_RESOURCE_ID = "derby.database.instance.10.0";
	private static final String DERBY_101_INSTANCE_RESOURCE_ID = "derby.database.instance.10.1";
	private IResourceTypeService rts = ExtensionsCore.createResourceTypeService();

	/**
	 * 
	 */
	public DerbyDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testDerbyDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/derby.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Derby Topology");

		root.setTopology(top);

		// Special tests - add template elements to topology
		top.getUnits().add(
				getTemplateUnit(rts
						.getTemplateURI(DERBY_100_DATABASE_RESOURCE_ID)));
		top.getUnits().add(
				getTemplateUnit(rts
						.getTemplateURI(DERBY_101_DATABASE_RESOURCE_ID)));
		top.getUnits().add(
				getTemplateUnit(rts
						.getTemplateURI(DERBY_100_INSTANCE_RESOURCE_ID)));
		top.getUnits().add(
				getTemplateUnit(rts
						.getTemplateURI(DERBY_101_INSTANCE_RESOURCE_ID)));

		// Create DB Module with a Derby DDL artifact
		SQLModule dbModule = DatabaseFactory.eINSTANCE.createSQLModule();
		dbModule.setName("TestDBModule");
		DerbyDDLArtifact derbyDDLArtifact = DerbyFactory.eINSTANCE
				.createDerbyDDLArtifact();
		derbyDDLArtifact.setName("TestDerbyDDLArtifact");
		derbyDDLArtifact.getFileURIs().add("somewhere/derby.ddl");
		dbModule.getArtifacts().add(derbyDDLArtifact);
		top.getUnits().add(dbModule);

		// Add consumed database hosting service to DBModule
		Requirement dbHosting = ValidatorTestUtils.createHostingRequirement(
				DatabasePackage.Literals.DATABASE, "requiredDBHostingService");
		dbModule.getRequirements().add(dbHosting);

		// Create DatabaseUnit, with provided DB Hosting, DB services
		DerbyDatabaseUnit derbyUnit = DerbyFactory.eINSTANCE
				.createDerbyDatabaseUnit();
		derbyUnit.setName("TestDerbyDatabaseUnit");
		DerbyDatabase derbyDbHosting = DerbyFactory.eINSTANCE
				.createDerbyDatabase();
		derbyDbHosting.setName("Provided DerbyHosting service");
		derbyDbHosting.setDerbyVersion("10.1");
		derbyUnit.getHostingOrAnyCapabilities().add(derbyDbHosting);
		DerbyDatabase derbyDBService = DerbyFactory.eINSTANCE
				.createDerbyDatabase();
		derbyDBService.setName("Provided Derby Database service");
		derbyDBService.setDbName("testDatabase");
		derbyDBService.setDbAlias("DERBYTEST");
		derbyDBService.setDbDrive("D:");
		derbyUnit.getOnlyDependencyCapabilities().add(derbyDBService);
		top.getUnits().add(derbyUnit);

		// Host ddl on database unit
		ValidatorTestUtils.hosts(derbyUnit, dbModule);

		// Create Database Instance unit, with provided instance service
		DerbyDatabaseInstanceUnit derbyInstanceUnit = DerbyFactory.eINSTANCE
				.createDerbyDatabaseInstanceUnit();
		derbyInstanceUnit.setName("TestDerbyInstanceUnit");
		DerbyInstance derbyInstanceService = DerbyFactory.eINSTANCE
				.createDerbyInstance();
		derbyInstanceService.setName("TestDerbyInstanceService");
		derbyInstanceService.setPort(BigInteger.valueOf(8888));
		derbyInstanceService.setHostname("some.host.name");
		derbyInstanceService.setInstanceName("ADerbyInstance");
		derbyInstanceUnit.getOnlyDependencyCapabilities().add(
				derbyInstanceService);
		top.getUnits().add(derbyInstanceUnit);

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

		// Load all templates. Loader tests for validity against schema

		doTemplateLoad(rts
				.getTemplateURI(DERBY_100_DATABASE_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(DERBY_101_DATABASE_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(DERBY_100_INSTANCE_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(DERBY_101_INSTANCE_RESOURCE_ID));

	}

}
