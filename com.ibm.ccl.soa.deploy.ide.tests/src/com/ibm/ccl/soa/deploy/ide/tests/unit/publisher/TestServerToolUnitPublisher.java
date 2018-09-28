/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.unit.publisher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jst.server.tomcat.core.internal.TomcatConfiguration;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServer;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServerBehaviour;
import org.eclipse.wst.server.core.IServer;
import org.xml.sax.SAXException;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.ide.extension.IUnitPublisherService;
import com.ibm.ccl.soa.deploy.ide.publisher.servertool.ServerToolUnitPublisher;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;
import com.ibm.ccl.soa.deploy.tomcat.config.TomcatDataSource50Xml;

/**
 * This class is meant for test purposes only
 * 
 */
public class TestServerToolUnitPublisher extends ServerToolUnitPublisher {

	private IServer testServer;

	private Job publishJob;

	private TomcatServerBehaviour tomcatServerBehaviour;

	protected String getModuleURI(List annotations) {
		return TomcatTestWorkspace.BANK_PROJECT_NAME;
	}

	protected String getModuleType(List annotations) {
		return TomcatTestWorkspace.moduleType;
	}

	protected IStatus configureServer(IServer server, Unit[] units, Unit host) {
		// super.configureServer(server, units);
		TomcatServerBehaviour tomcatServerBehaviour = getTomcatServer(server);
		TomcatServer tomcatServer = (TomcatServer) tomcatServerBehaviour
				.getServer().loadAdapter(TomcatServer.class, null);
		TomcatConfiguration config = null;
		try {
			config = tomcatServerBehaviour.getTomcatConfiguration();
		} catch (CoreException e) { // TODO throw error
			e.printStackTrace();
		}

		createTomcatConfigUnits(tomcatServer, config, units);

		return null;

	}

	private void createTomcatConfigUnits(TomcatServer tomcatServer,
			TomcatConfiguration config, Unit[] units) {
		for (int i = 0; i < units.length; i++) {
			Unit unit = units[i];
			if (unit instanceof TomcatDatasourceUnit) {
				TomcatDatasourceUnit dataSource = (TomcatDatasourceUnit) unit;
				List services = dataSource.getOnlyDependencyCapabilities();
				for (Iterator iter = services.iterator(); iter.hasNext();) {
					Object element = iter.next();
					if (element instanceof Tomcat50Datasource) {
						Tomcat50Datasource tomcatDataSource = (Tomcat50Datasource) element;

						try {
							new TomcatDataSource50Xml(tomcatServer,
									tomcatDataSource);
						} catch (IOException e) {
							e.printStackTrace();
						} catch (SAXException e) {

							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public boolean canPublish(Unit hostUnit) {
		return true;
	}

	protected IStatus publish(Unit host, List modules, List configurationModules) {
		return super.publish(host, modules, configurationModules);
	}

	public IStatus publish(Topology topology, IUnitPublisherService unitService) {
		publish(getTestHost(), getTestWebModules(), getConfigUnits());
		return Status.OK_STATUS;
	}

	/**
	 * @return
	 */
	public List getTestWebModules() {

		// //Create test bank web module
		WebModule bankWebMod = J2eeFactory.eINSTANCE.createWebModule();
		bankWebMod.setName("BankWar");

		// Add annotation
		Annotation webModuleURI = CoreFactory.eINSTANCE.createAnnotation();
		webModuleURI.setContext("wtp");
		IProject bankProject = TomcatTestWorkspace
				.getProject(TomcatTestWorkspace.BANK_PROJECT_NAME);
		webModuleURI.getDetails().put(IAnnotationConstants.PROJECT_NAME,
				bankProject.getName());
		webModuleURI.getDetails().put(IAnnotationConstants.MODULE_TYPE,
				"jst.web");
		bankWebMod.getAnnotations().add(webModuleURI);
		webModuleURI.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		// Add a war to the web module
		FileArtifact warArt = CoreFactory.eINSTANCE.createFileArtifact();
		warArt.setName("TestWar1");
		warArt.setDisplayName("Test War");
		warArt.getFileURIs().add("testpublish.war");
		bankWebMod.getArtifacts().add(warArt);
		ArrayList testList = new ArrayList(1);
		testList.add(bankWebMod);
		return testList;

	}

	/**
	 * @return
	 */
	public TomcatWebServerUnit getTestHost() {
		TomcatWebServerUnit tomcatServer = TomcatFactory.eINSTANCE
				.createTomcatWebServerUnit();
		tomcatServer.setDisplayName("TestTomcat50Server");
		tomcatServer.setName("tomcat50");

		// add runtime annotation
		Annotation tomcatRuntime = CoreFactory.eINSTANCE.createAnnotation();
		tomcatRuntime.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		tomcatRuntime.getDetails().put(IAnnotationConstants.RUNTIME_TYPE,
				TomcatTestWorkspace.tomcat50RuntimeType); // type
		// id
		tomcatRuntime.getDetails().put(IAnnotationConstants.RUNTIME_ID,
				TomcatTestWorkspace.tomcat50RuntimeInstanceId); // instance
		// id
		tomcatServer.getAnnotations().add(tomcatRuntime);

		com.ibm.ccl.soa.deploy.tomcat.TomcatServer tcService = TomcatFactory.eINSTANCE
				.createTomcatServer();
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

		return tomcatServer;
	}

	/**
	 * @return
	 */
	public List getConfigUnits() {
		TomcatDatasourceUnit tcDataSource = TomcatFactory.eINSTANCE
				.createTomcatDatasourceUnit();
		tcDataSource.setName("tcDataSourceUnit");
		Requirement reqServer = CoreFactory.eINSTANCE.createRequirement();
		reqServer.setName("consTomcatServerService");
		reqServer.setDmoEType(TomcatPackage.Literals.TOMCAT_SERVER);
		reqServer.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		reqServer.getConstraints().add(
				createEqualsConstraint(
						TomcatPackage.eINSTANCE.getTomcatServer_TomcatVersion().getName(),
						"1.4"));
		tcDataSource.getRequirements().add(reqServer);

		// Provide a tomcat 5 data source service on tomcat data source unit
		Tomcat50Datasource provTC5DSService = TomcatFactory.eINSTANCE
				.createTomcat50Datasource();
		provTC5DSService.setName("provDataSourceService");
		// provTC5DSService.setUrl(TomcatTestWorkspace.DERBY_URL);
		provTC5DSService.setJndiName("jdbc/cigar");
		provTC5DSService.setUsername(TomcatTestWorkspace.DERBY_USER_NAME);
		provTC5DSService.setPassword(TomcatTestWorkspace.DERBY_PW_NAME);
		provTC5DSService
				.setDriverClassName(TomcatTestWorkspace.DERBY_CLASS_NAME);
		provTC5DSService.setClientJarLocation(TomcatTestWorkspace
				.getDerby10_1JarPath().toOSString());
		tcDataSource.getOnlyDependencyCapabilities().add(provTC5DSService);
		ArrayList testList = new ArrayList(1);
		testList.add(tcDataSource);
		return testList;

	}

	protected IServer getServer(String runtimeId, String serverTypeId) {
		testServer = super.getServer(runtimeId, serverTypeId);
		return testServer;
	}

	public IServer getTestServer() {
		return testServer;
	}

	public String getEnvironment() {
		// TODO Auto-generated method stub
		return IAnnotationConstants.ENVIRONMENT_WTP;
	}

	public TomcatServerBehaviour getTomcatServer(IServer server) {
		if (server == null)
			return null;
		if (tomcatServerBehaviour == null)
			tomcatServerBehaviour = (TomcatServerBehaviour) server.loadAdapter(
					TomcatServerBehaviour.class, null);
		return tomcatServerBehaviour;
	}
	private EqualsConstraint createEqualsConstraint(String attribute,
			String value) {
		EqualsConstraint constraint = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		constraint.setAttributeName(attribute);
		constraint.setValue(value);
		return constraint;
	}
}
