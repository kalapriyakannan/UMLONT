/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClient;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;

/**
 * @since 1.0 The primary tests for the DB2 domain are still the tests done by
 *        PlantsByWebsphereTest.
 */
public class Db2DomainTest extends TestCase {

	private static final String PROJECT_NAME = "Db2DomainTest";

	private IProject project;

	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	/**
	 * @throws IOException
	 */
	public void testDb2Domain() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/db2.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Db2 Topology");

		root.setTopology(top);

		DB2AdminClient db2AdminClient = Db2Factory.eINSTANCE
				.createDB2AdminClient();
		db2AdminClient.setName("TestDB2AdminClient");

		DB2AdminClientUnit db2AdminClientUnit = Db2Factory.eINSTANCE
				.createDB2AdminClientUnit();
		db2AdminClientUnit.setName("TestDB2AdminClientUnit");
		db2AdminClientUnit.getOnlyDependencyCapabilities().add(db2AdminClient);
		top.getUnits().add(db2AdminClientUnit);

		DB2CatalogedNode db2CatalogedNode = Db2Factory.eINSTANCE
				.createDB2CatalogedNode();
		db2CatalogedNode.setName("TestDB2CatalogedNode");

		DB2CatalogUnit db2CatalogUnit = Db2Factory.eINSTANCE
				.createDB2CatalogUnit();
		db2CatalogUnit.setName("TestDB2CatalogUnit");
		top.getUnits().add(db2CatalogUnit);

		DB2Client db2Client = Db2Factory.eINSTANCE.createDB2Client();
		db2Client.setName("TestDB2Client");

		DB2RuntimeClientUnit db2ClientUnit = Db2Factory.eINSTANCE
				.createDB2RuntimeClientUnit();
		db2ClientUnit.setName("TestDB2ClientUnit");
		db2ClientUnit.getOnlyDependencyCapabilities().add(db2Client);
		top.getUnits().add(db2ClientUnit);

		DB2Database db2Database = Db2Factory.eINSTANCE.createDB2Database();
		db2Database.setName("TestDB2Database");
		db2Database.setDbName("TestDB");
		db2Database.setDbAlias("TestDB");

		DB2DatabaseUnit db2DatabaseUnit = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		db2DatabaseUnit.setName("TestDB2DatabaseUnit");
		db2DatabaseUnit.getOnlyDependencyCapabilities().add(db2Database);
		top.getUnits().add(db2DatabaseUnit);

		DB2Instance providedDb2Instance = Db2Factory.eINSTANCE
				.createDB2Instance();
		providedDb2Instance.setName("TestProvidedDB2Instance");
		Requirement requiredDb2Instance = ValidatorTestUtils
				.createHostingRequirement(Db2Package.Literals.DB2_INSTANCE,
						"TestRequiredDB2Instance");

		DB2InstanceUnit db2InstanceUnit = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		db2InstanceUnit.setName("TestProvidedDB2InstanceUnit");
		db2InstanceUnit.getHostingOrAnyCapabilities().add(providedDb2Instance);
		top.getUnits().add(db2InstanceUnit);

		DB2JdbcDriver db2JdbcDriver = Db2Factory.eINSTANCE
				.createDB2JdbcDriver();
		db2JdbcDriver.setName("TestDB2JdbcDriver");

		DB2JdbcProvider db2JdbcProvider = WasFactory.eINSTANCE
				.createDB2JdbcProvider();
		db2JdbcProvider.setName("TestDB2JdbcProvider");

		DB2JdbcProviderUnit db2JdbcProviderUnit = WasFactory.eINSTANCE
				.createDB2JdbcProviderUnit();
		db2JdbcProviderUnit.setName("TestDB2JdbcProviderUnit");
		db2JdbcProviderUnit.getOnlyDependencyCapabilities()
				.add(db2JdbcProvider);
		top.getUnits().add(db2JdbcProviderUnit);

		DB2NodeCatalogUnit db2NodeCatalogUnit = Db2Factory.eINSTANCE
				.createDB2NodeCatalogUnit();
		db2NodeCatalogUnit.setName("TestDB2NodeCatalogUnit");
		db2NodeCatalogUnit.getOnlyDependencyCapabilities()
				.add(db2CatalogedNode);
		db2NodeCatalogUnit.getRequirements().add(requiredDb2Instance);
		top.getUnits().add(db2NodeCatalogUnit);

		DB2System db2System = Db2Factory.eINSTANCE.createDB2System();
		db2System.setName("TestDB2System");

		DB2SystemUnit db2SystemUnit = Db2Factory.eINSTANCE
				.createDB2SystemUnit();
		db2SystemUnit.setName("TestDB2SystemUnit");
		db2SystemUnit.getHostingOrAnyCapabilities().add(db2System);
		top.getUnits().add(db2SystemUnit);

		// DDLArtifact ddlArtifact = Db2Factory.eINSTANCE.createDDLArtifact();
		// ddlArtifact.setName("TestDDLArtifact");

// UnixDB2Instance unixDB2Instance =
// Db2Factory.eINSTANCE.createUnixDB2Instance();
// unixDB2Instance.setName("TestUnixDB2Instance");
//		
// UnixDB2System unixDB2System = Db2Factory.eINSTANCE.createUnixDB2System();
// unixDB2System.setName("TestUnixDB2System");
//
// WindowsDB2Instance windowsDB2Instance =
// Db2Factory.eINSTANCE.createWindowsDB2Instance();
// windowsDB2Instance.setName("TestWindowsDB2Instance");
//		
// WindowsDB2System windowsDB2System =
// Db2Factory.eINSTANCE.createWindowsDB2System();
// windowsDB2System.setName("TestWindowsDB2System");

		//
		hosts(db2InstanceUnit, db2NodeCatalogUnit);

		//

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		res.unload();

		// Load all templates. Loader tests for validity against schema
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.db2/templates/db28Instance.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.db2/templates/db28System.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.db2/templates/db28RuntimeClient.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.db2/templates/db2Database.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.db2/templates/db2Catalog.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.db2/templates/db2NodeCatalog.template");

		// These aren't tested elsewhere!

//		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.ldap/templates/LDAP_TDS6.template");
//		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.server/templates/x86Server.template");
//
// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.ihs/templates/ihsSystem.template");
// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.ihs/templates/ihsServer.template");
// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.ihs/templates/ihsWasModule.template");
// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.ihs/templates/ihsWasPlugin.template");
	}

	/**
	 * @param templateURIString
	 * @throws IOException
	 */
	private void doTemplateLoad(String templateURIString) throws IOException {
		URI templateURI = URI.createURI(templateURIString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);

		resource.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) resource.getContents()
				.get(0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		resource.unload();
	}

	/**
	 * @param link
	 */
	public static void createLinkName(HostingLink link) {
		String name;
		name = "hosted" + link.getHost().getName() + "In"
				+ link.getHosted().getName();
		link.setName(name);
	}

	/**
	 * @param hoster
	 * @param hostee
	 * @return hosting link linking hoster and hostee
	 */
	protected static HostingLink hosts(Unit hoster, Unit hostee) {
		assert hoster != null;
		assert hostee != null;
		assert hoster != hostee;

		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setHosted(hostee);
		hoster.getHostingLinks().add(hl);
		createLinkName(hl);
		return hl;
	}
}
