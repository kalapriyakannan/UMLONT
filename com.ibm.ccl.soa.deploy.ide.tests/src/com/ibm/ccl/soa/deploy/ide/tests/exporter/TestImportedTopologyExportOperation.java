/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.exporter;

import java.io.FileInputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyExporterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * Unit tests for
 * {@link  com.ibm.ccl.soa.deploy.ide.datamodels.DeployTopologyExportDataModel }
 * 
 * <p>
 * Clients should use
 * {@link DeployTopologyExportDataModel#createConfiguredOperation()} to create
 * an instance of this operation, configured with the necessary model
 * properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.descriptor.DeployTopologyExportDataModelOperation
 * @see com.ibm.ccl.soa.deploy.ide.datamodels.DeployTopologyExportDataModel
 */
public class TestImportedTopologyExportOperation extends TopologyTestCase {

	private static final String IDE_TOPOLOGY_EXPORTER = "Ide Topology Exporter";
	private IProject project;

	public TestImportedTopologyExportOperation(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		TomcatTestWorkspace.init();
	}

	public void testBasicTopologyExport() throws Exception {
		//LocationBindingService.INSTANCE.setLocationBindingUsage(false);
		Topology impTop = createTopology("ImportedTopologyA",
				"TestImportedTopologyExportOperation", false);

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

		impTop.getUnits().add(bankWebMod);

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

		/*
		 * Requirement requiredDSCapability1 =
		 * ValidatorTestUtils.createDependencyRequirement(J2eePackage.eINSTANCE.getJ2EEDatasource(),
		 * "requiredDSCapability1");
		 * requiredDSCapability1.setName("requiredDSCapability1");
		 * requiredDSCapability1.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		 *EqualsConstraint DSReqExpression1 = ConstraintFactory.eINSTANCE
		.createEqualsConstraint();
		 * DSReqExpression1.setAttributeName(J2eePackage.eINSTANCE.getJ2EEDatasource_JndiName().getName());
		 * DSReqExpression1.setValue(TomcatTestWorkspace.DERBY_JNDI_NAME);
		 * DSReqExpression1.setName("DS1");
		 * requiredDSCapability1.getConstraints().add(DSReqExpression1);
		 * userWebMod.getCapabilities().add( requiredDSCapability1);
		 */

		impTop.getUnits().add(userWebMod);

		// Add a 3rd web module
		WebModule thirdWebMod = J2eeFactory.eINSTANCE.createWebModule();
		thirdWebMod.setName("ThirdWar");
		impTop.getUnits().add(thirdWebMod);

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

		/*
		 * Requirement requiredDSCapability =
		 * ValidatorTestUtils.createDependencyRequirement(J2eePackage.eINSTANCE.getJ2EEDatasource(),
		 * "requiredDSCapability");
		 * requiredDSCapability.setName("requiredDSCapability");
		 * requiredDSCapability.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		 * EqualsConstraint DSReqExpression = ConstraintFactory.eINSTANCE
		.createEqualsConstraint();
		 * DSReqExpression.setAttributeName(J2eePackage.eINSTANCE.getJ2EEDatasource_JndiName().getName());
		 * DSReqExpression.setValue("jdbc/whatever");
		 * DSReqExpression.setName("DS");
		 * requiredDSCapability.getConstraints().add(DSReqExpression);
		 * thirdWebMod.getCapabilities().add( requiredDSCapability);
		 */

		// Add a tomcat data source unit
		TomcatDatasourceUnit tcDataSource = TomcatFactory.eINSTANCE
				.createTomcatDatasourceUnit();
		tcDataSource.setName("tcDataSourceUnit");
		impTop.getUnits().add(tcDataSource);

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
		impTop.getUnits().add(tcDataSource2);

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

		impTop.getUnits().add(tomcatServer);

		// // Add 2nd tomcat server unit
		TomcatWebServerUnit tomcatServer2 = TomcatFactory.eINSTANCE
				.createTomcatWebServerUnit();
		tomcatServer2.setName("tomcat55");
		impTop.getUnits().add(tomcatServer2);

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

		/*
		 * // Capability link - DependencyLink servLink =
		 * CoreFactory.eINSTANCE.createDependencyLink();
		 * servLink.setName("dsServLink"); servLink.setTarget(provTC5DSService);
		 * requiredDSCapability.setLink(servLink );
		 *  // Capability link - DependencyLink servLink1 =
		 * CoreFactory.eINSTANCE.createDependencyLink();
		 * servLink1.setName("dsServLink");
		 * servLink1.setTarget(provTC5DSService2);
		 * requiredDSCapability1.setLink(servLink1 );
		 */
		save(impTop);

		// main topology to export
/*
 * URI exportTopuri = URI.createPlatformResourceURI(PROJECT_NAME + "/" +
 * NAMESPACE + "/TestMainTopologyForExport/TestMainTopologyForExport.topology");
 * Resource exportTopRes =
 * WorkbenchResourceHelperBase.createResource(exportTopuri); DeployCoreRoot
 * exportTopRoot = CoreFactory.eINSTANCE.createDeployCoreRoot();
 * exportTopRes.getContents().add(exportTopRoot); Topology exportTop =
 * CoreFactory.eINSTANCE.createTopology(); exportTop.setName("Main Topology For
 * Export"); exportTopRoot.setTopology(exportTop);
 */

		Topology exportTop = createTopology("TopToExport",
				"TestImportedTopologyExportOperation", false);

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
		String resourcePath = resource.getLocation().toString();
		fileURIs.add(resourcePath);
		fileArtifacts.add(fileArtifact);
		exportTop.getUnits().add(databaseModule);

		Import importDef = CoreFactory.eINSTANCE.createImport();
		importDef.setName("ImportedTopologyA.Import");
		importDef.setNamespace("TestImportedTopologyExportOperation");
		importDef.setPattern("ImportedTopologyA");
		exportTop.getImports().add(importDef);

		save(exportTop);

		// export topology
		IFile deployFile = WorkbenchResourceHelperBase.getIFile(exportTop
				.eResource().getURI());
		TopologyExporter exporter = getBasicTopologyExporter();
		assert exporter != null;
		String archive = "ExportedDP_C.zip";
		DeployTopologyExportDataModel typesafeModel = DeployTopologyExportDataModel
				.createModel();

		typesafeModel.setArchiveDestination(archive);
		typesafeModel.setOverwriteExisting(Boolean.TRUE);
		// typesafeModel.setExportSourceFiles(null);
		typesafeModel.setExportWithError(Boolean.TRUE);
		// typesafeModel.setTopologyHasError(null);
		typesafeModel.setTopologyFile(deployFile);
		typesafeModel.setExporter(getBasicTopologyExporter());
		// typesafeModel.setExportLogger(null);
		IDataModelOperation op = typesafeModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		// test the archive
		FileInputStream inputStream = new FileInputStream(archive);
		assert (inputStream.available() > 0);
		inputStream.close();
		// Load resource, check contents
		Topology topology = reload(exportTop, false);
		assertNotNull(topology);

		// TODO Verify the proper execution of the operation.

	}

	private TopologyExporter getBasicTopologyExporter() {
		TopologyExporterDescriptor[] exporters = TopologyManager.getInstance()
				.findAvailableExporters(null);
		for (int i = 0; i < exporters.length; i++) {
			String exportTypeName = exporters[i].getName();
			if (exportTypeName.equalsIgnoreCase(IDE_TOPOLOGY_EXPORTER)) {
				return exporters[i].createTopologyExporter();
			}
		}

		return null;
	}

	public IProgressMonitor createProgressMonitor() {
		// TODO Consider using a smarter progress monitor that can enforce a
		// minimum number of messages.
		return new NullProgressMonitor();
	}
}
