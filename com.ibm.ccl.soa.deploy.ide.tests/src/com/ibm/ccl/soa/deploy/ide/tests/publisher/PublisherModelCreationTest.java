/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.publisher;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.ide.publisher.IdeTopologyPublisher;
import com.ibm.ccl.soa.deploy.internal.core.DeployPublishContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployTransactionReporter;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyFactory;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

public class PublisherModelCreationTest extends TestCase {

	private static final String PROJECT_NAME = "IdePublisherTest";

	private IProject project;

	protected void setUp() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		TomcatTestWorkspace.init();
	}

	public void testCreateModelForPublish() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/testidepublisher.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Test Publish Topology");

		root.setTopology(top);

		// /Create ddl module and FileArtifact
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		annotation.getDetails().put(IAnnotationConstants.MODULE_TYPE, "ddl"); //$NON-NLS-1$
		SQLModule databaseModule = DatabaseFactory.eINSTANCE.createSQLModule();
		databaseModule.getAnnotations().add(annotation);
		DDLArtifact fileArtifact = DatabaseFactory.eINSTANCE
				.createDDLArtifact();
		List fileArtifacts = databaseModule.getArtifacts();
		List fileURIs = fileArtifact.getFileURIs();
		IProject project = TomcatTestWorkspace
				.getProject(TomcatTestWorkspace.BANK_SQLS_PROJECT_NAME);
		IResource resource = project
				.findMember(TomcatTestWorkspace.ACCOUNT_DDL);
		databaseModule.setDisplayName(resource.getName());
		databaseModule.setName(resource.getName());
		String resourcePath = resource.getFullPath().toString();
		fileURIs.add(resourcePath);
		fileArtifacts.add(fileArtifact);
		top.getUnits().add(databaseModule);

		// create Derby server
		Annotation derbyRuntimeAnnotation = CoreFactory.eINSTANCE
				.createAnnotation();
		derbyRuntimeAnnotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		derbyRuntimeAnnotation.getDetails()
				.put(IAnnotationConstants.RUNTIME_TYPE,
						TomcatTestWorkspace.DERBY_ID);
		derbyRuntimeAnnotation.getDetails().put(
				IAnnotationConstants.RUNTIME_ID,
				TomcatTestWorkspace.DERBY_CONNECTION_NAME);

		DerbyDatabaseUnit derbyUnit = DerbyFactory.eINSTANCE
				.createDerbyDatabaseUnit();
		derbyUnit.getAnnotations().add(derbyRuntimeAnnotation);
		top.getUnits().add(derbyUnit);

		// TODO add Derby instance if wee need to get/set hostname and/or port

		// create requirement for derby database
		Requirement requiredDerbyServer = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDerbyServer.setName("required derby");
		requiredDerbyServer.setDmoEType(DerbyPackage.Literals.DERBY_DATABASE);
		requiredDerbyServer.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		databaseModule.getRequirements().add(requiredDerbyServer);

		DerbyDatabase provideDerbyServerService = DerbyFactory.eINSTANCE
				.createDerbyDatabase();
		provideDerbyServerService.setName("provTomcatServerService");
		provideDerbyServerService.setDerbyVersion("10.1");
		derbyUnit.getHostingOrAnyCapabilities().add(provideDerbyServerService);

		// hosting link
		HostingLink ddlServiceLink = CoreFactory.eINSTANCE.createHostingLink();
		ddlServiceLink.setName("jreHostLink1");
		ddlServiceLink.setHosted(databaseModule);
		derbyUnit.getHostingLinks().add(ddlServiceLink);

		// //Create test bank web module
		WebModule bankWebMod = J2eeFactory.eINSTANCE.createWebModule();
		bankWebMod.setName("BankWar");

		// Add annotation
		Annotation webModuleURI = CoreFactory.eINSTANCE.createAnnotation();
		webModuleURI.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		IProject bankProject = TomcatTestWorkspace
				.getProject(TomcatTestWorkspace.BANK_PROJECT_NAME);
		webModuleURI.getDetails().put(IAnnotationConstants.PROJECT_NAME,
				bankProject.getName());
		webModuleURI.getDetails().put(IAnnotationConstants.MODULE_TYPE,
				"jst.web");
		bankWebMod.getAnnotations().add(webModuleURI);

		// Add a war to the web module
		FileArtifact warArt = CoreFactory.eINSTANCE.createFileArtifact();
		warArt.setName("TestWar1");
		warArt.setDisplayName("Test War");
		warArt.getFileURIs().add("testpublish.war");
		bankWebMod.getArtifacts().add(warArt);

		top.getUnits().add(bankWebMod);

		// //Create 2nd test user web module
		WebModule userWebMod = J2eeFactory.eINSTANCE.createWebModule();
		userWebMod.setName("UserWar");

		// Add annotation
		Annotation userModuleURI = CoreFactory.eINSTANCE.createAnnotation();
		userModuleURI.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		IProject userProject = TomcatTestWorkspace
				.getProject(TomcatTestWorkspace.USER_PROJECT_NAME);
		userModuleURI.getDetails().put(IAnnotationConstants.PROJECT_NAME,
				userProject.getName());
		userModuleURI.getDetails().put(IAnnotationConstants.MODULE_TYPE,
				"jst.web");
		userWebMod.getAnnotations().add(userModuleURI);

		// Add a war to the web module
		FileArtifact userWarArt = CoreFactory.eINSTANCE.createFileArtifact();
		userWarArt.setName("TestWar2");
		userWarArt.setDisplayName("Test War 2");
		userWarArt.getFileURIs().add("testpublish2.war");
		userWebMod.getArtifacts().add(userWarArt);

		// Consume a data source service on the user war
// J2EEDatasource consDataSourceService1 =
// J2eeFactory.eINSTANCE.createJ2EEDatasource();
// consDataSourceService1.setName("cons DS service 1");
// consDataSourceService1.setJndiName(TomcatTestWorkspace.DERBY_JNDI_NAME);
// consDataSourceService1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
// userWebMod.getCapabilities().add( consDataSourceService1);

		Requirement requiredDSCapability1 = ValidatorTestUtils
				.createDependencyRequirement(J2eePackage.eINSTANCE
						.getJ2EEDatasource(), "requiredDSCapability");
		requiredDSCapability1.setName("requiredDSCapability1");
		requiredDSCapability1
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		EqualsConstraint DSReqExpression1 = ConstraintFactory.eINSTANCE
		.createEqualsConstraint();
		DSReqExpression1.setAttributeName(J2eePackage.eINSTANCE
				.getJ2EEDatasource_JndiName().getName());
		DSReqExpression1.setValue(TomcatTestWorkspace.DERBY_JNDI_NAME);
		DSReqExpression1.setName("DS1");
		requiredDSCapability1.getConstraints().add(DSReqExpression1);
		userWebMod.getRequirements().add(requiredDSCapability1);

		top.getUnits().add(userWebMod);

		// Add a 3rd web module
		WebModule thirdWebMod = J2eeFactory.eINSTANCE.createWebModule();
		thirdWebMod.setName("ThirdWar");
		top.getUnits().add(thirdWebMod);

		// Consume a JSP service on the web module
		JSPContainer consumedJSPService = J2eeFactory.eINSTANCE
				.createJSPContainer();
		consumedJSPService.setName("consJspServ");
		consumedJSPService.setDisplayName("consumed JSP Capability");
		consumedJSPService.setContainerVersion(JSPContainerVersion._12_LITERAL);
		consumedJSPService.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		bankWebMod.getCapabilities().add(consumedJSPService);

		// Consume a JSP service on the 2nd web module
		JSPContainer consumedJSPService1 = J2eeFactory.eINSTANCE
				.createJSPContainer();
		consumedJSPService1.setName("consJspServ1");
		consumedJSPService1.setDisplayName("consumed JSP Capability 1");
		consumedJSPService1
				.setContainerVersion(JSPContainerVersion._12_LITERAL);
		consumedJSPService1.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		userWebMod.getCapabilities().add(consumedJSPService1);

		// Consume a JSP service on the 3rd web module
		JSPContainer consumedJSPService3 = J2eeFactory.eINSTANCE
				.createJSPContainer();
		consumedJSPService3.setName("consJspServ3");
		consumedJSPService3.setDisplayName("consumed JSP Capability 3");
		consumedJSPService3
				.setContainerVersion(JSPContainerVersion._12_LITERAL);
		consumedJSPService3.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		thirdWebMod.getCapabilities().add(consumedJSPService3);

		// Consume a data source service on the 3rd war
// J2EEDatasource consDataSourceService =
// J2eeFactory.eINSTANCE.createJ2EEDatasource();
// consDataSourceService.setName("cons DS service");
// consDataSourceService.setJndiName("jdbc/whatever");
// consDataSourceService.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
// thirdWebMod.getCapabilities().add( consDataSourceService);

		Requirement requiredDSCapability = ValidatorTestUtils
				.createDependencyRequirement(J2eePackage.eINSTANCE
						.getJ2EEDatasource(), "requiredDSCapability");
		requiredDSCapability.setName("requiredDSCapability");
		requiredDSCapability
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		EqualsConstraint DSReqExpression = ConstraintFactory.eINSTANCE
		.createEqualsConstraint();
		DSReqExpression.setAttributeName(J2eePackage.eINSTANCE
				.getJ2EEDatasource_JndiName().getName());
		DSReqExpression.setValue("jdbc/whatever");
		DSReqExpression.setName("DS");
		requiredDSCapability.getConstraints().add(DSReqExpression);
		thirdWebMod.getRequirements().add(requiredDSCapability);

		// Add a tomcat data source unit
		TomcatDatasourceUnit tcDataSource = TomcatFactory.eINSTANCE
				.createTomcatDatasourceUnit();
		tcDataSource.setName("tcDataSourceUnit");
		top.getUnits().add(tcDataSource);

		// Consume tomcat service on data source unit
		TomcatServer consServerService = TomcatFactory.eINSTANCE
				.createTomcatServer();
		consServerService.setName("consTomcatServerService");
		consServerService.setTomcatVersion("5.5");
		consServerService.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		tcDataSource.getCapabilities().add(consServerService);

		// Provide a tomcat 5 data source service on tomcat data source unit
		Tomcat50Datasource provTC5DSService = TomcatFactory.eINSTANCE
				.createTomcat50Datasource();
		provTC5DSService.setName("provDataSourceService");
		// provTC5DSService.setUrl(TomcatTestWorkspace.DERBY_URL);
		provTC5DSService.setJndiName(TomcatTestWorkspace.DERBY_JNDI_NAME);
		provTC5DSService.setUsername(TomcatTestWorkspace.DERBY_USER_NAME);
		provTC5DSService.setPassword(TomcatTestWorkspace.DERBY_PW_NAME);
		provTC5DSService
				.setDriverClassName(TomcatTestWorkspace.DERBY_CLASS_NAME);
		provTC5DSService.setClientJarLocation(TomcatTestWorkspace
				.getDerby10_1JarPath().toOSString());
		tcDataSource.getOnlyDependencyCapabilities().add(provTC5DSService);

		// Add a 2nd tomcat data source unit
		TomcatDatasourceUnit tcDataSource2 = TomcatFactory.eINSTANCE
				.createTomcatDatasourceUnit();
		tcDataSource2.setName("tcDataSourceUnit2");
		top.getUnits().add(tcDataSource2);

		// Consume tomcat service on data source unit
		TomcatServer consServerService2 = TomcatFactory.eINSTANCE
				.createTomcatServer();
		consServerService2.setName("consTomcatServerService2");
		consServerService2.setTomcatVersion("5.0");
		consServerService2.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		tcDataSource2.getCapabilities().add(consServerService2);

		// Provide a tomcat 5 data source service on tomcat data source unit
		Tomcat50Datasource provTC5DSService2 = TomcatFactory.eINSTANCE
				.createTomcat50Datasource();
		provTC5DSService2.setName("provDataSourceService2");
		// provTC5DSService2.setUrl(TomcatTestWorkspace.DERBY_URL);
		provTC5DSService2.setJndiName(TomcatTestWorkspace.DERBY_JNDI_NAME);
		provTC5DSService2.setUsername(TomcatTestWorkspace.DERBY_USER_NAME);
		provTC5DSService2.setPassword(TomcatTestWorkspace.DERBY_PW_NAME);
		provTC5DSService2
				.setDriverClassName(TomcatTestWorkspace.DERBY_CLASS_NAME);
		provTC5DSService2.setClientJarLocation(TomcatTestWorkspace
				.getDerby10_1JarPath().toOSString());
		tcDataSource2.getOnlyDependencyCapabilities().add(provTC5DSService2);

		// /////////

		// // Add tomcat server unit
		TomcatWebServerUnit tomcatServer = TomcatFactory.eINSTANCE
				.createTomcatWebServerUnit();
		tomcatServer.setDisplayName("TestTomcat50Server");
		tomcatServer.setName("tomcat50");

		// add runtime annotation
		Annotation tomcatRuntime = CoreFactory.eINSTANCE.createAnnotation();
		tomcatRuntime.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		tomcatRuntime.getDetails().put(IAnnotationConstants.RUNTIME_TYPE,
				TomcatTestWorkspace.tomcat50RuntimeType); // type id
		tomcatRuntime.getDetails().put(IAnnotationConstants.RUNTIME_ID,
				TomcatTestWorkspace.tomcat50RuntimeInstanceId); // instance id
		tomcatServer.getAnnotations().add(tomcatRuntime);

		// provide tomcat server service on tomcat server
		TomcatServer tcService = TomcatFactory.eINSTANCE.createTomcatServer();
		tcService.setName("tomcatServerService");
		tcService.setTomcatVersion("5.0");
		tomcatServer.getHostingOrAnyCapabilities().add(tcService);

		// Provide a JSP service on the tomcat server
		JSPContainer providededJSPService = J2eeFactory.eINSTANCE
				.createJSPContainer();
		providededJSPService.setName("provJspServ");
		providededJSPService.setDisplayName("provided JSP Capability");
		providededJSPService
				.setContainerVersion(JSPContainerVersion._12_LITERAL);
		tomcatServer.getHostingOrAnyCapabilities().add(providededJSPService);

		top.getUnits().add(tomcatServer);

		// // Add 2nd tomcat server unit
		TomcatWebServerUnit tomcatServer2 = TomcatFactory.eINSTANCE
				.createTomcatWebServerUnit();
		tomcatServer2.setDisplayName("TestTomcat55Server2");
		tomcatServer2.setName("tomcat55");
		top.getUnits().add(tomcatServer2);

		// Provide a JSP service on the 2nd tomcat server
		JSPContainer providededJSPService2 = J2eeFactory.eINSTANCE
				.createJSPContainer();
		providededJSPService2.setName("provJspServ2");
		providededJSPService2.setDisplayName("provided JSP Service2");
		providededJSPService2
				.setContainerVersion(JSPContainerVersion._12_LITERAL);
		tomcatServer2.getHostingOrAnyCapabilities().add(providededJSPService2);

		// provide tomcat service on tomcat server
		TomcatServer provServerService = TomcatFactory.eINSTANCE
				.createTomcatServer();
		provServerService.setName("provTomcatServerService");
		provServerService.setTomcatVersion("5.5");
		tomcatServer2.getHostingOrAnyCapabilities().add(provServerService);

		// hosting link
		HostingLink jspServLink = CoreFactory.eINSTANCE.createHostingLink();
		jspServLink.setName("jreHostLink1");
		jspServLink.setHosted(bankWebMod);
		tomcatServer.getHostingLinks().add(jspServLink);

		// hosting link
		HostingLink jspServLink2 = CoreFactory.eINSTANCE.createHostingLink();
		jspServLink2.setName("jreHostLink2");
		jspServLink2.setHosted(userWebMod);
		tomcatServer.getHostingLinks().add(jspServLink2);

		// hosting link
		HostingLink jspServLink3 = CoreFactory.eINSTANCE.createHostingLink();
		jspServLink3.setName("jreHostLink3");
		jspServLink3.setHosted(thirdWebMod);
		tomcatServer2.getHostingLinks().add(jspServLink3);

		// hosting link
		HostingLink tcServLink = CoreFactory.eINSTANCE.createHostingLink();
		tcServLink.setName("tc host link");
		tcServLink.setHosted(tcDataSource);
		tomcatServer2.getHostingLinks().add(tcServLink);

		// hosting link
		HostingLink tcServLink2 = CoreFactory.eINSTANCE.createHostingLink();
		tcServLink2.setName("tc host link 2");
		tcServLink2.setHosted(tcDataSource2);
		tomcatServer.getHostingLinks().add(tcServLink2);

		// Capability link -
		DependencyLink servLink = CoreFactory.eINSTANCE.createDependencyLink();
		servLink.setName("dsServLink");
		servLink.setTarget(provTC5DSService);
		requiredDSCapability.setLink(servLink);

		// Capability link -
		DependencyLink servLink1 = CoreFactory.eINSTANCE.createDependencyLink();
		servLink1.setName("dsServLink");
		servLink1.setTarget(provTC5DSService2);
		requiredDSCapability1.setLink(servLink1);

		// Simple publish stuff
		IdeTopologyPublisher ideTopPub = new IdeTopologyPublisher();
		DeployPublishContext context = new DeployPublishContext(top, true, new DeployTransactionReporter(), new NullProgressMonitor());
		ideTopPub.publish(context);
		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
	}

}
