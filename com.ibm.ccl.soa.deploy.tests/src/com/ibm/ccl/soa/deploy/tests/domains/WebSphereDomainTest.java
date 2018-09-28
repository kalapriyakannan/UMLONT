/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.math.BigInteger;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.CertificateMapMode;
import com.ibm.ccl.soa.deploy.was.Classloader;
import com.ibm.ccl.soa.deploy.was.ClassloaderMode;
import com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames;
import com.ibm.ccl.soa.deploy.was.IIOPSecurityProtocols;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.LDAPDirectoryType;
import com.ibm.ccl.soa.deploy.was.Policies;
import com.ibm.ccl.soa.deploy.was.WARClassloaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;
import com.ibm.ccl.soa.deploy.was.WasV4Datasource;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * @since 1.0
 * 
 */
public class WebSphereDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "WebSphereDomainTest";

	/**
	 * 
	 */
	public WebSphereDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testWebSphereDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/websphere.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("WebSphere Topology");

		root.setTopology(top);

		// Create test ear module
		EarModule earMod = J2eeFactory.eINSTANCE.createEarModule();
		earMod.setName("TestEAR");
		top.getUnits().add(earMod);

		// Requirements for this ear
		// Was Server requirement - implying this is a was-specific ear
		Requirement requiredWasServer = CoreFactory.eINSTANCE
				.createRequirement();
		requiredWasServer.setName("Required Was Server");
		requiredWasServer.setDmoEType(WasPackage.Literals.WAS_SERVER);
		requiredWasServer.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredWasServer.getExpressions().add(
				Equals.createExpression(
						WasPackage.Literals.WAS_SERVER__WAS_VERSION, "5.1"));
		earMod.getRequirements().add(requiredWasServer);
		// J2EE Data source server

		Requirement requiredDSCapability = ValidatorTestUtils
				.createDependencyRequirement(J2eePackage.eINSTANCE
						.getJ2EEDatasource(), "requiredDSCapability");
		requiredDSCapability.setName("requiredDSCapability");
		RequirementExpression DSReqExpression = CoreFactory.eINSTANCE
				.createRequirementExpression();
		DSReqExpression.setAttributeName(J2eePackage.eINSTANCE
				.getJ2EEDatasource_JndiName().getName());
		DSReqExpression.setValue("jdbc/myDataSource");
		DSReqExpression.setName("DS1");
		requiredDSCapability.getExpressions().add(DSReqExpression);

		// J2EE Data source server
		Requirement requiredDSCapability2 = ValidatorTestUtils
				.createDependencyRequirement(J2eePackage.eINSTANCE
						.getJ2EEDatasource(), "requiredDSCapability2");
		requiredDSCapability2.setName("requiredDSCapability2");
		RequirementExpression DSReqExpression2 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		DSReqExpression2.setAttributeName(J2eePackage.eINSTANCE
				.getJ2EEDatasource_JndiName().getName());
		DSReqExpression2.setValue("jdbc/myOtherDataSource");
		DSReqExpression2.setName("DS12");
		requiredDSCapability2.getExpressions().add(DSReqExpression2);

		// Was V4 DataSource
		WasDatasourceUnit wasv4DataSourceUnit = WasFactory.eINSTANCE
				.createWasDatasourceUnit();
		wasv4DataSourceUnit.setConfigurationUnit(true);
		wasv4DataSourceUnit.setName("WasDataSourceUnit1");
		WasV4Datasource wasv4DataSource = WasFactory.eINSTANCE
				.createWasV4Datasource();
		// set properties here
		wasv4DataSource.setJndiName("jdbc/myDataSource");
		wasv4DataSource.setCategory("aCategory");
		wasv4DataSource.setConnectionTimeout("1000");
		wasv4DataSource.setDisableAutoConnectionCleanup(false);
		wasv4DataSource.setIdleTimeout("2000");
		wasv4DataSource.setJndiName("jdbc/myDataSource");
		wasv4DataSource.setName("WasV4DataSource");
		wasv4DataSource.setStatementCacheSize("10");
		wasv4DataSource.setOrphanTimeout("1500");
		wasv4DataSourceUnit.getOnlyDependencyCapabilities()
				.add(wasv4DataSource);
		top.getUnits().add(wasv4DataSourceUnit);

		// Was V5 DataSource
		WasDatasourceUnit wasv5DataSourceUnit = WasFactory.eINSTANCE
				.createWasDatasourceUnit();
		wasv5DataSourceUnit.setConfigurationUnit(true);
		wasv5DataSourceUnit.setName("WasDataSourceUnit2");
		WasV5Datasource wasv5DataSource = WasFactory.eINSTANCE
				.createWasV5Datasource();
		wasv5DataSource.setName("wasv5DataSource service");
		wasv5DataSource.setJndiName("jdbc/myOtherDataSource");
		wasv5DataSource.setAgedTimeout("1000");
		wasv5DataSource.setCategory("bCategory");
		wasv5DataSource
				.setDataSourceHelperClassName(DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_UNIVERSAL_DATA_STORE_HELPER_LITERAL);
		wasv5DataSource.setPurgePolicy(Policies.ENTIRE_POOL_LITERAL);
		wasv5DataSource.setReapTime("2000");
		wasv5DataSource.setStatementCacheSize("10");
		wasv5DataSource.setUnusedTimeout("1500");
		wasv5DataSourceUnit.getOnlyDependencyCapabilities()
				.add(wasv5DataSource);

		// Create WebSphere Application Server unit
		WebsphereAppServerUnit was51Unit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		was51Unit.setName("was51ServerUnit");
		top.getUnits().add(was51Unit);

		// Provide some services on this server unit

		// Was Server Capability - implying this is a was-specific ear
		WasServer providedWasServerService = WasFactory.eINSTANCE
				.createWasServer();
		providedWasServerService.setWasVersion("5.1");
		providedWasServerService.setName("Provided Was Server Capability");

		// new server profile properties
		providedWasServerService.setServerName("server1");
// providedWasServerService.setProfileDirectory("d:\\was\\profiles\\default");
// providedWasServerService.setCell("cell01");
// providedWasServerService.setNode("node01");

		was51Unit.getHostingOrAnyCapabilities().add(providedWasServerService);

		// WAS Security Capability
		WasSecurity securityService = WasFactory.eINSTANCE.createWasSecurity();
		securityService.setName("a was security service");
		securityService.setActiveAuthMechanism("auth.mechanism");
		securityService.setActiveProtocol(IIOPSecurityProtocols.IBM_LITERAL);
		securityService.setActiveUserRegistry(WasUserRegistryTypes.CUSTOM_LITERAL);
		securityService.setAllowAllPermissionForApplication(false);
		securityService.setCacheTimeout("1000");
		securityService.setEnforceJava2Security(true);
		securityService.setIssuePermissionWarning(true);
		securityService.setUseDomainQualifiedNames(false);
		securityService.setEnforceFineGrainedJCASecurity(true);
		securityService.setEnforceJava2SecRuntimeFiletering(false);
		securityService.setGlobalSecurityEnabled(true);
		was51Unit.getOnlyDependencyCapabilities().add(securityService);

		// LDAP Configuration
		WasLdapConfiguration wasLdapConfigService = WasFactory.eINSTANCE
				.createWasLdapConfiguration();
		wasLdapConfigService.setBaseDN("aBaseDN");
		wasLdapConfigService.setBindDN("aBindDN");
		wasLdapConfigService.setBindPassword("aBindPassowrd");
		wasLdapConfigService.setIgnoreCase(true);
		wasLdapConfigService.setLdapHostname("alpha.ibm.com");
		wasLdapConfigService.setLdapPort(BigInteger.valueOf(8888));
		wasLdapConfigService.setLimit("aLimit");
		wasLdapConfigService.setMonitorInterval("aMonitofValue");
		wasLdapConfigService.setRealm("aRealm");
		wasLdapConfigService.setReuseConnection(true);
		wasLdapConfigService.setSearchTimeout("1200");
		wasLdapConfigService.setServerId("aServerId");
		wasLdapConfigService.setServerPassword("aServerPassword");
		wasLdapConfigService.setSslConfig("aSSLConfig");
		wasLdapConfigService.setSslEnabled(false);
		wasLdapConfigService
				.setType(LDAPDirectoryType.IBMDIRECTORYSERVER_LITERAL);
		wasLdapConfigService.setName("Was LDAP Configuration Capability");
		was51Unit.getOnlyDependencyCapabilities().add(wasLdapConfigService);

		// Advanaced LDAP configuration
		WasAdvancedLdapConfiguration wasAdvnacedLdapConfigService = WasFactory.eINSTANCE
				.createWasAdvancedLdapConfiguration();
		wasAdvnacedLdapConfigService.setCertificateFilter("certFilt");
		wasAdvnacedLdapConfigService
				.setCertificateMapMode(CertificateMapMode.CERTIFICATEFILTER_LITERAL);
		wasAdvnacedLdapConfigService.setGroupFilter("groupFilter");
		wasAdvnacedLdapConfigService.setGroupIdMap("groupIdMap");
		wasAdvnacedLdapConfigService.setGroupMemberIdMap("groupMemberIdMap");
		wasAdvnacedLdapConfigService.setUserFilter("userFilter");
		wasAdvnacedLdapConfigService.setUserIdMap("userIdMap");
		wasAdvnacedLdapConfigService
				.setName("Was Advanced LDAP Configuration Capability");
		was51Unit.getOnlyDependencyCapabilities().add(
				wasAdvnacedLdapConfigService);

		// add classloader annotations
		Classloader classLoader = WasFactory.eINSTANCE.createClassloader();
		classLoader.setMode(ClassloaderMode.PARENTFIRST_LITERAL);
		classLoader.setStartWeight(1);
		classLoader
				.setWarClassLoaderPolicy(WARClassloaderPolicy.MODULE_LITERAL);

		// Add annotation
		Annotation earAnnotation = CoreFactory.eINSTANCE.createAnnotation();
		earAnnotation.setContext("WAS");
		earAnnotation.getAny().add(
				WasPackage.eINSTANCE.getWasDeployRoot_Classloader(),
				classLoader);

		// Capability links
		// Hosting Links for was server services
		HostingLink hostLink1 = CoreFactory.eINSTANCE.createHostingLink();
		// hostLink1.setSource(consumedWasServerService);
		hostLink1.setHosted(earMod);
		hostLink1.setName("host link 1");
		was51Unit.getHostingLinks().add(hostLink1);

		// Capability link between DS services on ear and DS unit
		DependencyLink servLink1 = CoreFactory.eINSTANCE.createDependencyLink();
		servLink1.setName("serv link 1");
		// servLink1.setSource(consumedDSService);
		servLink1.setTarget(wasv4DataSource);
		servLink1.setSource(requiredDSCapability);
		requiredDSCapability.setLink(servLink1);

		// Capability link between DS services on ear and DS unit
		DependencyLink servLink2 = CoreFactory.eINSTANCE.createDependencyLink();
		servLink2.setName("serv link 2");
		// servLink2.setSource(consumedDSService2);
		servLink2.setTarget(wasv5DataSource);
		requiredDSCapability2.setLink(servLink2);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		// Not a valid topology
// assertNoValidationErrors(topology);

		res.unload();

		// Load all templates. Loader tests for validity against schema
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/db2JdbcProvider.template");
		// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/defaultMessagingConnectionFactory.template");
		// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/DefaultMessagingJMSActivationSpecification.template");
		// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/defaultMessagingQueueDestination.template");
		// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/defaultMessagingTopicDestination.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/was51Server.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/was5DistributedCell.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/was5StandaloneCell.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/was6DistributedCell.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/was6Server.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/was6StandaloneCell.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasCluster5.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasCluster6.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasdeploymentManager6.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasDmgrNode.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasNode.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasNodeGroup.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasSharedLibraryEntry.template");
		// doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasSubSttVariable.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasSystem.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasV5DB2DataSource.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasDistributedBundle5.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasDistributedBundle6.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasStandaloneBundle5.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.was/templates/wasStandaloneBundle6.template");

		// Test using resource type registry
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		doTemplateLoad(rts
				.getTemplateURI(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT));
		doTemplateLoad(rts
				.getTemplateURI(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT));

	}

}
