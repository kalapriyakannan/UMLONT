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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerFactory;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.was.Classloader;
import com.ibm.ccl.soa.deploy.was.ClassloaderMode;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSharedLibContainer;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * JUnit test case for Plants-by.
 * 
 * <p>
 * As part of working this test case produces a file, PlantsByWebSphere
 * Topology.topology, (yes the space is part of the filename) which is useful
 * for GUI tests. Unfortunately, this test deletes the file -- the only way to
 * capture it is to interrupt this test after it has produced the file.
 * 
 * @author Ed Snible (updates)
 * @author ??? (original)
 * 
 * @see PlantsByWebsphereTest_LDAPOnly
 * @see PlantsByWebsphereTest_DBClientOnly
 * @see PlantsByWebsphereTest_DB2Only
 */
public class PlantsByWebsphereTest_SequenceHosting extends TopologyTestCase {

// private static final String PROJECT_NAME = "PlantsByWASTest";

// private static final String PLANTS_TOPOLOGY_NAME = "plants.topology";

	// Use instance variables for now
	private Topology top;

	private EarModule earMod;

	private WebModule webMod;

	private WebsphereAppServerUnit was51Server;

	private EJBContainer providedEJBContainerService;

	private ServletContainer providedServletService;

	private JSPContainer providedJSPService;

	private Requirement j2eeDS;

	private Requirement servletContReq;

	private Requirement jspContReq;

	private Requirement ejbContServ;

	private Requirement requiredEjb;

// private EJB providedEjbService;

	private Requirement requiredJ2eeSecurityRole;

	private J2EESecurityRole providedJ2eeSecurityRole;

	private SecurityRoleReferenceUnit securityRoleReferenceUnit;

	private WasV5DB2Datasource wasDS;

	private WasDatasourceUnit dsUnit;

	private Requirement requiredDSJdbcProvider;

	private Requirement dsRequiredAuth;

	private Requirement dsRequiredDatabase;

	private WASJ2CAuthenticationUnit j2cAuthUnit;

	private J2CAuthenticationDataEntry j2cAuthService;

	private Requirement dsRequiredWasServerService;

	private Requirement j2cAuthRequiredJ2eeServer;

	private WasServer wasProvided51ServerService;

	private Requirement requiredJ2eeServerSecRole;

	private Requirement requiredLdapSuffixSecRole;

	// Windows/Server stack
	Requirement requiredWasOperatingSystem;

	OperatingSystem providedOperatingSystem1;

	OperatingSystemUnit operatingSystemUnit1;

	Requirement requiredServer1;

	Server providedServer1;

	ServerUnit serverUnit1;

	Requirement requiredAuthUser;

	private Requirement j2eeContServ;

// private EJB providedJ2eeService;

	private J2EEContainer providedJ2eeContainer;

	private Requirement j2eeContReq;

	private WasNodeUnit wasNodeUnit;

	private WasSystemUnit was51SystemUnit;

	/** Test case ctor */
	public PlantsByWebsphereTest_SequenceHosting() {
		super("PlantsByWebsphereTest");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Populates the topology with the Plants by WebSphere objects.
	 * 
	 * @param top
	 *            the topology to be populated.
	 */
	public void addPlantsByWebSphereObjects(/* Topology top */) {
		// Create deployable modules
		createDeployableModules();

		// Create config units
		createConfigUnits();

		// Create server units
		createServers();

		// Add db2 elements
		PlantsByWebsphereTest_DB2Only db2Test = new PlantsByWebsphereTest_DB2Only();
		db2Test.populateDb2Topology(top);

		// Add db2 client elements
		PlantsByWebsphereTest_DBClientOnly dbClientTest = new PlantsByWebsphereTest_DBClientOnly();
		dbClientTest.populateDBClientTopology(top);

		// Add ldap security elements
		PlantsByWebsphereTest_LDAPOnly ldapTest = new PlantsByWebsphereTest_LDAPOnly();
		ldapTest.populateLdapTopology(top);

		// Create security role
		createRole();

		// Create Windows/XServer stack used by WAS
		createWindowsSystemStack();

		// Create unit links
		createServiceLinks(db2Test, dbClientTest, ldapTest);

		// Create service links between WAS and DB2
		createWAStoDB2Links(db2Test, dbClientTest);
	}

	/**
	 * @return a full two-server PlantsBy example topology
	 * @throws Exception
	 */
	public Topology createPlantsByTopology() throws Exception {
		top = createTopology("PlantsByWebSphere");
		top.setDescription("Plants by WebSphere two system topology");
		addPlantsByWebSphereObjects();
		return top;
	}

	/**
	 * Test creating, saving, and validating.
	 * 
	 * @throws Exception
	 */
	public void testPlantsLogicalTopologySequenceHostingStack()
			throws Exception {

		createPlantsByTopology();

		Resource res = top.getEObject().eResource();
		res.save(null);

		DeployValidatorService service = new DeployValidatorService();
		long prevTime = System.currentTimeMillis();
		service.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName()
				+ " : Elapsed milliseconds for validation = "
				+ (time - prevTime));
		dumpMarkers(top);
		// assertNoValidationErrors(top);

		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		// assertNoValidationErrors(topology);

		sequenceHostingStack(topology);

		// TODO NM/CHAD validate the results set for sequencing

		// Load as if UI were loading it.
		// Fails, so this is commented out.
		// String resourcePath = "platform:/resource/" + PROJECT_NAME + "/" +
		// PLANTS_TOPOLOGY_NAME;
		// Resource modelResource = ResourceUtil.create(resourcePath,
		// MResourceOption.URI);
		// ResourceUtil.load(modelResource);

	}

	private void sequenceHostingStack(Topology top) {
		Map map = TopologyUtil.sequenceTopologyHostingStack(top);
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Unit unit = (Unit) it.next();
			System.out.println("Key unit = " + unit.getName()); //$NON-NLS-1$
			ArrayList list = (ArrayList) map.get(unit);
			Iterator it1 = list.iterator();
			while (it1.hasNext()) {
				Unit vUnit = (Unit) it1.next();
				System.out.println("--- value unit = " + vUnit.getName()); //$NON-NLS-1$
			}
		}
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

	private void createWAStoDB2Links(PlantsByWebsphereTest_DB2Only db2Test,
			PlantsByWebsphereTest_DBClientOnly db2ClientTest) {

		// Link between jdbc provider and WAS
		LinkFactory.createDependencyLink(db2Test.requiredDb2JdbcDriver,
				db2ClientTest.providedDb2JdbcDriver);

		// //////////////////////////////////
		// hosting link between jdbc provider and WAS
		ValidatorTestUtils.hosts(was51Server, db2Test.db2JdbcProviderUnit);

	}

	/**
	 * Create the deployable modules
	 */
	private void createDeployableModules() {
		// Create ear module
		earMod = J2eeFactory.eINSTANCE.createEarModule();
		// earMod.setName("EarMod1");
		earMod.setName("PlantsByWebSphereEAR");
		top.getUnits().add(earMod);

		FileArtifact earArt = CoreFactory.eINSTANCE.createFileArtifact();
		earArt.getFileURIs().add("plants.ear");
		earArt.setName("plantsEAR");
		earMod.getArtifacts().add(earArt);

		// Define required services for EAR.

		// Define required datasource
		j2eeDS = ValidatorTestUtils.createDependencyRequirement(
				J2eePackage.Literals.J2EE_DATASOURCE, "plantsDS",
				"plants data source");
		j2eeDS.getExpressions().add(
				Equals.createExpression(
						J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME,
						"jdbc/PlantsBy"));
		earMod.getRequirements().add(j2eeDS);

		// Define required EJB container
		ejbContServ = ValidatorTestUtils.createHostingRequirement(
				J2eePackage.Literals.EJB_CONTAINER, "ejbV20", "EJB v2.0");
		ejbContServ.getExpressions().add(
				Equals.createExpression(
						J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
						EJBContainerVersion._20_LITERAL));
		earMod.getRequirements().add(ejbContServ);

		// Define required J2EE container
		j2eeContServ = ValidatorTestUtils.createHostingRequirement(
				J2eePackage.Literals.J2EE_CONTAINER, "j2ee 13", "J2EE v 1.3");
		j2eeContServ.getExpressions().add(
				Equals.createExpression(
						J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
						J2EEContainerVersion._13_LITERAL));
		earMod.getRequirements().add(j2eeContServ);

		// Define required Security Role
		requiredJ2eeSecurityRole = ValidatorTestUtils
				.createDependencyRequirement(
						J2eePackage.Literals.J2EE_SECURITY_ROLE,
						"requiredJ2eeSecurityRole", "j2eeSecurityRole");
		requiredJ2eeSecurityRole.getExpressions().add(
				Equals.createExpression(
						J2eePackage.Literals.J2EE_SECURITY_ROLE__ROLE,
						"SampAdmin"));
		earMod.getRequirements().add(requiredJ2eeSecurityRole);

		// Define provided services for the ear

		// Ear module ejb service. Why would this be provided?
// providedEjbService = J2eeFactory.eINSTANCE.createEJB();
// providedEjbService.setName("PlantsEJBService");
// providedEjbService
// .setDescription("EJB service used to communicate to clients.");
// providedEjbService.setInterface("com.ibm.plants.PlantsEJBService");
// earMod.getOnlyDependencyCapabilities().add(providedEjbService);

		// Ear module j2ee container. Why would this be provided?
// providedJ2eeContainer = J2eeFactory.eINSTANCE.createJ2EEContainer();
// providedJ2eeContainer.setName("PlantsJ2EECapability");
// providedJ2eeContainer.setContainerVersion(J2EEContainerVersion._13_LITERAL);
// providedJ2eeContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
// earMod.getOnlyDependencyCapabilities().add(providedJ2eeContainer);

		// Create Web module
		webMod = J2eeFactory.eINSTANCE.createWebModule();
		// webMod.setName("WebMod1");
		webMod.setName("PlantsByWebSphereWEB");
		top.getUnits().add(webMod);

		FileArtifact warArt = CoreFactory.eINSTANCE.createFileArtifact();
		warArt.getFileURIs().add("plants.war");
		warArt.setName("plantsWAR");
		webMod.getArtifacts().add(warArt);

		// Define services required by web module
		// Define Servlet container service.
		// servletContServ = J2eeFactory.eINSTANCE.createServletContainer();
		servletContReq = ValidatorTestUtils.createHostingRequirement(
				J2eePackage.Literals.SERVLET_CONTAINER, "servV23",
				"Servlet v2.3");
		// TODO This should be an EEnum.
		ValidatorTestUtils.addEqualsExpression(servletContReq,
				J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
				ServletContainerVersion._23_LITERAL);
		webMod.getRequirements().add(servletContReq);

		// Define JSP container service
		jspContReq = ValidatorTestUtils.createHostingRequirement(
				J2eePackage.Literals.JSP_CONTAINER, "jspV12", "JSP v1.2");
		ValidatorTestUtils.addEqualsExpression(jspContReq,
				J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
				JSPContainerVersion._12_LITERAL);
		webMod.getRequirements().add(jspContReq);

		// Define J2EE container service
		j2eeContReq = ValidatorTestUtils.createHostingRequirement(
				J2eePackage.Literals.J2EE_CONTAINER, "j2ee V13", "J2EE v1.3");
		ValidatorTestUtils.addEqualsExpression(j2eeContReq,
				J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
				J2EEContainerVersion._13_LITERAL);
		webMod.getRequirements().add(j2eeContReq);

		// Required EJB required by the Web module
		requiredEjb = ValidatorTestUtils.createDependencyRequirement(
				J2eePackage.Literals.EJB, "PlantsEJBService",
				"Web Module required EJB service");
		ValidatorTestUtils.addEqualsExpression(requiredEjb,
				J2eePackage.Literals.EJB__INTERFACE,
				"com.ibm.plants.PlantsEJBService");
// webMod.getRequirements().add(requiredEjb);
	}

	/**
	 * Create configuration units
	 */
	private void createConfigUnits() {
		// Define WAS datasource to be provided.
		dsUnit = WasFactory.eINSTANCE.createWasDatasourceUnit();
		dsUnit.setName("WasPlantsDSUnit");
		dsUnit.setDisplayName("WAS_Datasource_Unit");
		top.getUnits().add(dsUnit);

		wasDS = WasFactory.eINSTANCE.createWasV5DB2Datasource();
		wasDS.setName("WASPlantsDS");
		wasDS.setDisplayName("WebSphere Plants Datasource");
		wasDS.setJndiName("jdbc/PlantsBy");
		wasDS.setAgedTimeout("55");
		wasDS.setPassword("db2admin");
		wasDS.setUsername("db2admin");
		wasDS.setDbName("PLANTSBY");
		wasDS.setHostname("plantsdbserver");
		wasDS.setDatasourceName("SomeName");
		wasDS.setPort(BigInteger.valueOf(8888));
		wasDS.setJ2cAuthAlias("PbwAuth");
		dsUnit.getOnlyDependencyCapabilities().add(wasDS);

		// Create jdbc type requirement
		requiredDSJdbcProvider = ValidatorTestUtils.createHostingRequirement(
				WasPackage.Literals.DB2_JDBC_PROVIDER, "PlantsDB2JdbcService",
				"JDBC Provider service reference");
		dsUnit.getRequirements().add(requiredDSJdbcProvider);

		// Create j2c auth type requirement
		dsRequiredAuth = ValidatorTestUtils.createDependencyRequirement(
				WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY,
				"PlantsJ2CConsumedAuthService",
				"WebSphere plants J2C consumed authentication service");
		ValidatorTestUtils.addEqualsExpression(dsRequiredAuth,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS,
				"PbwAuth");
		dsUnit.getRequirements().add(dsRequiredAuth);

		// Create was server requirement
// dsRequiredWasServerService =
// ValidatorTestUtils.createHostingRequirement(WasPackage.Literals.WAS_SERVER,
// "DSConsumedWasServerService", "Consumed Was server service for Was data
// source");
// ValidatorTestUtils.addEqualsExpression(dsRequiredWasServerService,
// WasPackage.Literals.WAS_SERVER__WAS_VERSION, "5.1");
// dsUnit.getRequirements().add(dsRequiredWasServerService);

		// Create database server requirement
		dsRequiredDatabase = ValidatorTestUtils.createDependencyRequirement(
				Db2Package.Literals.DB2_DATABASE, "dsRequiredDatabase",
				"Requirement for database for Was data source");
		ValidatorTestUtils.addEqualsExpression(dsRequiredDatabase,
				Db2Package.Literals.DB2_DATABASE__DB_NAME, "PLANTSBY");
		dsUnit.getRequirements().add(dsRequiredDatabase);

		// Create J2CAuth unit
		j2cAuthUnit = WasFactory.eINSTANCE.createWASJ2CAuthenticationUnit();
		j2cAuthUnit.setName("PlantsJ2CAuthUnit");
		j2cAuthUnit.setDisplayName("Websphere Plants J2C authentication unit");

		// provide a j2cauth service
		j2cAuthService = WasFactory.eINSTANCE
				.createWASJ2CAuthenticationDataEntry();
		j2cAuthService.setName("PlantsJ2CProvidedAuthService");
		j2cAuthService
				.setDisplayName("WebSphere plants J2C provided authentication service");
		j2cAuthService.setAlias("PbwAuth");
		j2cAuthService.setUserId("db2admin");
		j2cAuthService.setPassword("db2admin");
		j2cAuthUnit.getOnlyDependencyCapabilities().add(j2cAuthService);

		// Require a j2ee server
		j2cAuthRequiredJ2eeServer = ValidatorTestUtils
				.createHostingRequirement(J2eePackage.Literals.J2EE_SERVER,
						"AuthRequiredJ2eeServer");
		j2cAuthUnit.getRequirements().add(j2cAuthRequiredJ2eeServer);

		// Require a user
		requiredAuthUser = ValidatorTestUtils.createDependencyRequirement(
				OsPackage.Literals.USER, "authUser",
				"Required user J2c auth unit");
		j2cAuthUnit.getRequirements().add(requiredAuthUser);

		top.getUnits().add(j2cAuthUnit);

		// Create JDBCProvider unit

		// Creeate Db2Client unit? not now
	}

	/**
	 * Create the server units
	 */
	private void createServers() {
		// Was v5.1 server unit
		was51Server = WasFactory.eINSTANCE.createWebsphereAppServerUnit();
		was51Server.setDisplayName("WebSphere51AppServer");
		was51Server.setName("Was51Server");
		top.getUnits().add(was51Server);

		// Define EJB container service for the server
		providedEJBContainerService = J2eeFactory.eINSTANCE
				.createEJBContainer();
		providedEJBContainerService.setName("ejbV20_provided");
		// TODO This should be an EEnum.
		providedEJBContainerService.setDisplayName("EJB v2.0");
		providedEJBContainerService
				.setContainerVersion(EJBContainerVersion._20_LITERAL);
		was51Server.getHostingOrAnyCapabilities().add(
				providedEJBContainerService);

		// Define Servlet container service.
		providedServletService = J2eeFactory.eINSTANCE.createServletContainer();
		providedServletService.setName("servV23_provided");
		// TODO This should be an EEnum.
		providedServletService.setDisplayName("Servlet v2.3");
		providedServletService
				.setContainerVersion(ServletContainerVersion._23_LITERAL);
		was51Server.getHostingOrAnyCapabilities().add(providedServletService);

		// Define JSP container service
		providedJSPService = J2eeFactory.eINSTANCE.createJSPContainer();
		providedJSPService.setName("jspV12_provided");
		// TODO This should be an EEnum.
		providedJSPService.setDisplayName("JSP v1.2");
		providedJSPService.setContainerVersion(JSPContainerVersion._12_LITERAL);
		was51Server.getHostingOrAnyCapabilities().add(providedJSPService);

		// Ear module j2ee container
		providedJ2eeContainer = J2eeFactory.eINSTANCE.createJ2EEContainer();
		providedJ2eeContainer.setName("providedJ2eeContainer");
		providedJ2eeContainer
				.setContainerVersion(J2EEContainerVersion._13_LITERAL);
		providedJ2eeContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		was51Server.getCapabilities().add(providedJ2eeContainer);

		// Provide was 51 server capability
		wasProvided51ServerService = WasFactory.eINSTANCE.createWasServer();
		wasProvided51ServerService.setName("ProvidedWas51ServerService");
		wasProvided51ServerService
				.setDisplayName("Provided Was51 Server Capability");
		wasProvided51ServerService.setWasVersion("5.1");
		wasProvided51ServerService.setServerName("server1");
		wasProvided51ServerService.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		was51Server.getCapabilities().add(wasProvided51ServerService);

		// Provide a PortConsumer capability
		PortConsumer portConsumer = OsFactory.eINSTANCE.createPortConsumer();
		portConsumer.setName("portConsumer");
		portConsumer.setDisplayName("portConsumer");
		portConsumer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		was51Server.getCapabilities().add(portConsumer);

		// Provide a WasConfigurationContainer capability
		WasConfigurationContainer wasConfigurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		wasConfigurationContainer.setName("wasConfigurationContainer");
		wasConfigurationContainer.setDisplayName("wasConfigurationContainer");
		wasConfigurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		was51Server.getCapabilities().add(wasConfigurationContainer);

		// Provided a WasSharedLibContainer capability
		WasSharedLibContainer wasSharedLibContainer = WasFactory.eINSTANCE
				.createWasSharedLibContainer();
		wasSharedLibContainer.setName("wasSharedLibContainer");
		wasSharedLibContainer.setDisplayName("wasSharedLibContainer");
		wasSharedLibContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		was51Server.getCapabilities().add(wasSharedLibContainer);

		Requirement wasNodeReq = ValidatorTestUtils.createMemberRequirement(
				WasPackage.Literals.WAS_NODE_UNIT, "wasNodeReq");
		was51Server.getRequirements().add(wasNodeReq);

		Requirement wasOsHostingReq = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"wasOsHostingReq");
		was51Server.getRequirements().add(wasOsHostingReq);

		// WasNodeUnit
		wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit.setName("wasNodeUnit");
		wasNodeUnit.setDisplayName("wasNodeUnit");
		top.getUnits().add(wasNodeUnit);

		// WasNode
		WasNode wasNode = WasFactory.eINSTANCE.createWasNode();
		wasNode.setName("wasNode");
		wasNode.setDisplayName("wasNode");
		wasNode.setProfileName("default");
		wasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		wasNode
				.setProfileLocation("c:\\program files\\ibm\\websphere\\appserver\\default");
		wasNode.setWasVersion("5.1");
		wasNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit.getCapabilities().add(wasNode);

		// WasConfigurationContainer for node
		WasConfigurationContainer wasConfigurationContainerNode = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		wasConfigurationContainerNode.setName("wasConfigurationContainerNode");
		wasConfigurationContainerNode
				.setDisplayName("wasConfigurationContainerNode");
		wasConfigurationContainerNode
				.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit.getCapabilities().add(wasConfigurationContainerNode);

		// Shared lib container for node
		WasSharedLibContainer wasSharedLibContainerNode = WasFactory.eINSTANCE
				.createWasSharedLibContainer();
		wasSharedLibContainerNode.setName("wasSharedLibContainerNode");
		wasSharedLibContainerNode.setDisplayName("wasSharedLibContainerNode");
		wasSharedLibContainerNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit.getCapabilities().add(wasSharedLibContainerNode);

		// Provide a PortConsumer capability for node
		PortConsumer portConsumerNode = OsFactory.eINSTANCE
				.createPortConsumer();
		portConsumerNode.setName("portConsumerNode");
		portConsumerNode.setDisplayName("portConsumerNode");
		portConsumerNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit.getCapabilities().add(portConsumerNode);

		Requirement wasSystemReq = ValidatorTestUtils.createHostingRequirement(
				WasPackage.eINSTANCE.getWasSystem(), "wasSystemReq");
		wasNodeUnit.getRequirements().add(wasSystemReq);

		Requirement wasCellUnitReq = ValidatorTestUtils
				.createMemberRequirement(WasPackage.eINSTANCE.getWasCellUnit(),
						"wasCellUnitReq");
		wasCellUnitReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		wasNodeUnit.getRequirements().add(wasCellUnitReq);

		Requirement wasNodeGroupUnitReq = ValidatorTestUtils
				.createMemberRequirement(WasPackage.eINSTANCE
						.getWasNodeGroupUnit(), "wasNodeGroupUnitReq");
		wasNodeGroupUnitReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		wasNodeUnit.getRequirements().add(wasNodeGroupUnitReq);

		Requirement wasAppServerUnitReq = ValidatorTestUtils
				.createMemberRequirement(WasPackage.eINSTANCE
						.getWebsphereAppServerUnit(), "wasAppServerUnitReq");
		wasAppServerUnitReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		wasNodeUnit.getRequirements().add(wasAppServerUnitReq);

		Requirement wasDeploymentManagerUnitReq = ValidatorTestUtils
				.createMemberRequirement(WasPackage.eINSTANCE
						.getWasDeploymentManagerUnit(),
						"wasDeploymentManagerUnitReq");
		wasDeploymentManagerUnitReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		wasNodeUnit.getRequirements().add(wasDeploymentManagerUnitReq);

		// 
		was51SystemUnit = WasFactory.eINSTANCE.createWasSystemUnit();
		was51SystemUnit.setName("was51SystemUnit");
		was51SystemUnit.setDisplayName("was51SystemUnit");
		top.getUnits().add(was51SystemUnit);

		WasSystem was51System = WasFactory.eINSTANCE.createWasSystem();
		was51System.setName("was51System");
		was51System.setDisplayName("was51System");
		was51System.setWasVersion("5.1");
		was51System.setWasHome("C:\\Program Files\\IBM\\WebSphere");
		was51System.setInstallerDir("C:\\");
		was51System.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		was51SystemUnit.getCapabilities().add(was51System);
	}

	/**
	 * Create the security role
	 */
	private void createRole() {

		// security role reference unit
		securityRoleReferenceUnit = LdapFactory.eINSTANCE
				.createSecurityRoleReferenceUnit();
		securityRoleReferenceUnit.setDisplayName("securityRoleReference");
		securityRoleReferenceUnit.setName("securityRoleReferenceUnit");

		// provided j2ee security role
		// Define Security Role service to be provided.
		providedJ2eeSecurityRole = J2eeFactory.eINSTANCE
				.createJ2EESecurityRole();
		providedJ2eeSecurityRole.setName("providedJ2eeSecurityRole");
		providedJ2eeSecurityRole.setDisplayName("J2eeSecurityRole");
		providedJ2eeSecurityRole.setRole("SampAdmin");
		securityRoleReferenceUnit.getOnlyDependencyCapabilities().add(
				providedJ2eeSecurityRole);

		// required j2ee server
		requiredJ2eeServerSecRole = ValidatorTestUtils
				.createHostingRequirement(J2eePackage.Literals.J2EE_SERVER,
						"requiredJ2eeServerSecRole");
		securityRoleReferenceUnit.getRequirements().add(
				requiredJ2eeServerSecRole);

		// ldap suffix requirement
		requiredLdapSuffixSecRole = ValidatorTestUtils
				.createDependencyRequirement(LdapPackage.Literals.LDAP_SUFFIX,
						"LdapSuffix", "consumedLdapSuffix_SecRole");
		securityRoleReferenceUnit.getRequirements().add(
				requiredLdapSuffixSecRole);

		top.getUnits().add(securityRoleReferenceUnit);
	}

	/**
	 * Operating system, system unit. This is stack 1 (stack 2 is for db2/ldap)
	 */
	private void createWindowsSystemStack() {
		requiredWasOperatingSystem = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredWasOperatingSystem");
		requiredWasOperatingSystem.getExpressions().add(
				Equals.createExpression(
						OsPackage.Literals.OPERATING_SYSTEM__OS_TYPE,
						OperatingSystemType.WINDOWS_LITERAL.getLiteral()));
		requiredWasOperatingSystem.getExpressions().add(
				Equals.createExpression(
						OsPackage.Literals.OPERATING_SYSTEM__OS_VERSION,
						"Win2K"));
		was51SystemUnit.getRequirements().add(requiredWasOperatingSystem);

		providedOperatingSystem1 = OsFactory.eINSTANCE.createOperatingSystem();
		providedOperatingSystem1.setName("providedOperatingSystem1");
		providedOperatingSystem1.setOsType(OperatingSystemType.WINDOWS_LITERAL
				.getLiteral());
		providedOperatingSystem1.setOsVersion("Win2K");
		providedOperatingSystem1.setHostname("rf11.watson.ibm.com");

		operatingSystemUnit1 = OsFactory.eINSTANCE.createOperatingSystemUnit();
		operatingSystemUnit1.setName("operatingSystemUnit1");
		operatingSystemUnit1.getHostingOrAnyCapabilities().add(
				providedOperatingSystem1);
		top.getUnits().add(operatingSystemUnit1);

		requiredServer1 = ValidatorTestUtils.createHostingRequirement(
				ServerPackage.Literals.SERVER, "requiredServer1");
		requiredServer1.getExpressions().add(
				Equals.createExpression(ServerPackage.eINSTANCE
						.getServer_CpuArchitecture(), "intel"));
		requiredServer1.getExpressions().add(
				Equals.createExpression(ServerPackage.eINSTANCE
						.getServer_CpuCount(), BigInteger.valueOf(1)));
		operatingSystemUnit1.getRequirements().add(requiredServer1);

		providedServer1 = ServerFactory.eINSTANCE.createServer();
		providedServer1.setName("providedServer1");
		providedServer1.setCpuArchitecture("intel");
		providedServer1.setCpuCount(BigInteger.valueOf(1));
		providedServer1.setMemorySize(BigInteger.valueOf(2500000)); // megabytes

		serverUnit1 = ServerFactory.eINSTANCE.createServerUnit();
		serverUnit1.setName("serverUnit1");
		serverUnit1.getHostingOrAnyCapabilities().add(providedServer1);
		top.getUnits().add(serverUnit1);
	}

	/**
	 * Create the unit links
	 */
	private void createServiceLinks(PlantsByWebsphereTest_DB2Only db2Test,
			PlantsByWebsphereTest_DBClientOnly dbClientTest,
			PlantsByWebsphereTest_LDAPOnly ldapTest) {

		// //////////////////
		// dependency link connecting ear module to data source
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setTarget(wasDS);
		link.setSource(j2eeDS);
		j2eeDS.setLink(link);
		ValidatorTestUtils.createLinkName(link);

		// //////////////////
		// dependency link connecting ear module to j2ee security role
		DependencyLink securityRoleLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		securityRoleLink.setTarget(providedJ2eeSecurityRole);
		securityRoleLink.setSource(requiredJ2eeSecurityRole);
		requiredJ2eeSecurityRole.setLink(securityRoleLink);
		ValidatorTestUtils.createLinkName(securityRoleLink);

		// //////////////////
		// hosting link connecting ear module to was51 server node
		HostingLink ejbServLink = ValidatorTestUtils.hosts(was51Server, earMod);
		// Add annotation
		Annotation earAnnotation = CoreFactory.eINSTANCE.createAnnotation();
		earAnnotation.setContext("WAS");
		ejbServLink.getAnnotations().add(earAnnotation);
		Classloader loaderPolicy = WasFactory.eINSTANCE.createClassloader();
		loaderPolicy.setMode(ClassloaderMode.PARENTFIRST_LITERAL);
		loaderPolicy.setStartWeight(10);
		earAnnotation.getAny().add(
				WasPackage.eINSTANCE.getWasDeployRoot_Classloader(),
				loaderPolicy);

		// //////////////////////////
		// hosting link connecting war module to was51 server node
		ValidatorTestUtils.hosts(was51Server, webMod); // JSP container

		// //////////////////////////////////
		// hosting link between J2C authentication and WAS
		ValidatorTestUtils.hosts(was51Server, j2cAuthUnit);

		// //////////////////////////////////
		// hosting link between data source and WAS
		ValidatorTestUtils.hosts(db2Test.db2JdbcProviderUnit, dsUnit);

		// //////////////////////////////////
		// hosting link between j2ee security role and WAS
		ValidatorTestUtils.hosts(was51Server, securityRoleReferenceUnit);

		// //////////////////////////////////
		// service link between j2ee security role and ldap
		DependencyLink ldapSuffixSecurityRoleServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		ldapSuffixSecurityRoleServiceLink
		.setTarget(ldapTest.providedLdapSuffix);
		ldapSuffixSecurityRoleServiceLink
		.setSource(requiredLdapSuffixSecRole);
		requiredLdapSuffixSecRole.setLink(ldapSuffixSecurityRoleServiceLink);
		ValidatorTestUtils.createLinkName(ldapSuffixSecurityRoleServiceLink);

		// ////////////////////
		// dependency link between datasource and J2C authentication service
		DependencyLink authServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		authServiceLink.setTarget(j2cAuthService);
		dsRequiredAuth.setLink(authServiceLink);
		ValidatorTestUtils.createLinkName(authServiceLink);

		// dependency link between j2c authentication unit user requirement and
		// user on remote system
		DependencyLink remoteUserLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		remoteUserLink.setTarget(db2Test.providedDb2AdminUser);
		remoteUserLink.setSource(requiredAuthUser);
		requiredAuthUser.setLink(remoteUserLink);
		ValidatorTestUtils.createLinkName(remoteUserLink);

		// member link between WASServer and WasNodeUnit
		MemberLink serverNodeMemberLink = CoreFactory.eINSTANCE
				.createMemberLink();
		serverNodeMemberLink.setTarget(was51Server);
		serverNodeMemberLink.setSource(wasNodeUnit);
		ValidatorTestUtils.createLinkName(serverNodeMemberLink);
		wasNodeUnit.getMemberLinks().add(serverNodeMemberLink);

		// Host wasNodeUnit
		ValidatorTestUtils.hosts(was51SystemUnit, wasNodeUnit);

		// Host was51SystemUnit
		ValidatorTestUtils.hosts(operatingSystemUnit1, was51SystemUnit);

		// Host was51SystemUnit
		ValidatorTestUtils.hosts(operatingSystemUnit1, this.was51Server);

		// Host operatingSystemUnit1
		ValidatorTestUtils.hosts(serverUnit1, operatingSystemUnit1);

		//
		// dependency link LDAP server to database
		//
		DependencyLink ldapDatabaseLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		ldapDatabaseLink.setTarget(db2Test.providedDb2DatabaseLdap);
		ldapDatabaseLink.setSource(ldapTest.requiredLdapDb2Database);
		ldapTest.requiredLdapDb2Database.setLink(ldapDatabaseLink);
		ValidatorTestUtils.createLinkName(ldapDatabaseLink);

		//
		// hosting link LDAP to OS
		//
		ValidatorTestUtils.hosts(db2Test.operatingSystemUnit2,
				ldapTest.ldapServerUnit);

		//
		// dependency link datasource to DB2 database catalog
		//
		DependencyLink plantsDsServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		plantsDsServiceLink.setTarget(dbClientTest.providedDb2CDatabase);
		plantsDsServiceLink.setSource(dsRequiredDatabase);
		dsRequiredDatabase.setLink(plantsDsServiceLink);
		ValidatorTestUtils.createLinkName(plantsDsServiceLink);

		//
		// dependency link of the catalaged database to the remote database
		//
		DependencyLink plantsDatabaseServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		plantsDatabaseServiceLink
		.setTarget(db2Test.providedDb2DatabasePlantsBy);
		plantsDatabaseServiceLink
		.setSource(dbClientTest.requiredDb2DatabasePlantsBy);
		dbClientTest.requiredDb2DatabasePlantsBy
				.setLink(plantsDatabaseServiceLink);
		ValidatorTestUtils.createLinkName(plantsDatabaseServiceLink);

		//
		// dependency link between local node catalog to the remote database
		// instance
		DependencyLink plantsDbInstanceServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		plantsDbInstanceServiceLink
		.setTarget(db2Test.providedDb2InstancePlantsBy);
		plantsDbInstanceServiceLink
		.setSource(dbClientTest.requiredDb2InstancePlants);
		dbClientTest.requiredDb2InstancePlants
				.setLink(plantsDbInstanceServiceLink);
		ValidatorTestUtils.createLinkName(plantsDbInstanceServiceLink);

		//
		// hosting link DB2 client required OS on WAS system
		//
		ValidatorTestUtils.hosts(operatingSystemUnit1,
				dbClientTest.db2RuntimeClientUnit);

		//
		// Contain WAS security service on WAS unit
		// Removed as an allowed capability
		was51Server.getOnlyDependencyCapabilities().add(
				ldapTest.providedWasSecurity);
	}
}
