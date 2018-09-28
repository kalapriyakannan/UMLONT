/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.scheme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.SimpleTopologyCreationScheme;
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;
import com.ibm.ccl.soa.deploy.tests.util.ProjectUnzipUtil;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

public class SimpleTopologyCreationSchemeTest extends TestCase {

	private static final String PROJECT_NAME = "SimpleTopologyCreationSchemeTest"; //$NON-NLS-1$
	private static final String FOOWEB_PROJECT_NAME = "FooWeb"; // TC 5 - 1
																// //$NON-NLS-1$
	private static final String BARWEB_PROJECT_NAME = "BarWeb"; // TC 5 - 1
																// //$NON-NLS-1$
	private static final String FOOBARWEB_PROJECT_NAME = "FooBarWeb"; // TC 5
																		// - 2
																		// //$NON-NLS-1$
	private static final String TESTWEB_PROJECT_NAME = "TestWeb"; // NONE
																	// //$NON-NLS-1$
	private static final String TESTWEB2_PROJECT_NAME = "TestWeb2"; // NONE
																	// //$NON-NLS-1$
	private static final String TESTEJB_PROJECT_NAME = "TestEJB"; // NONE
																	// //$NON-NLS-1$

	private static Path testDiscovererProjectZipPath = new Path(
			"/testData/discovererWorkspace.zip"); //$NON-NLS-1$

	private IProject fooWebProject;
	private IProject barWebProject;
	private IProject fooBarWebProject;
	private IProject testWebProject;
	private IProject testWeb2Project;
	private IProject testEjbProject;

	private IProject project;

	private Unit fooWebUnit;
	private Unit barWebUnit;
	private Unit fooBarWebUnit;
	private Unit testWebUnit;
	private Unit testWeb2Unit;
	private Unit testEjbUnit;

	protected void setUp() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	public void testSimpleTopologyCreationScheme() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI
				.createPlatformResourceURI(PROJECT_NAME
						+ "/SimpleTopologyCreationSchemeTest/SimpleTopologyCreationSchemeTest.topology"); //$NON-NLS-1$
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Test SimpleTopologyCreationSchemeTest Topology"); //$NON-NLS-1$

		root.setTopology(top);

		try {
			// Unzip/create projects from zip file
			if (!TomcatTestWorkspace.getProject(FOOWEB_PROJECT_NAME).exists())
				createProject(FOOWEB_PROJECT_NAME);
			fooWebProject = TomcatTestWorkspace.getProject(FOOWEB_PROJECT_NAME);
			fooWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);

			if (!TomcatTestWorkspace.getProject(BARWEB_PROJECT_NAME).exists())
				createProject(BARWEB_PROJECT_NAME);
			barWebProject = TomcatTestWorkspace.getProject(BARWEB_PROJECT_NAME);
			barWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);

			if (!TomcatTestWorkspace.getProject(FOOBARWEB_PROJECT_NAME)
					.exists())
				createProject(FOOBARWEB_PROJECT_NAME);
			fooBarWebProject = TomcatTestWorkspace
					.getProject(FOOBARWEB_PROJECT_NAME);
			fooBarWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);

			if (!TomcatTestWorkspace.getProject(TESTWEB_PROJECT_NAME).exists())
				createProject(TESTWEB_PROJECT_NAME);
			testWebProject = TomcatTestWorkspace
					.getProject(TESTWEB_PROJECT_NAME);
			testWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);

			if (!TomcatTestWorkspace.getProject(TESTWEB2_PROJECT_NAME).exists())
				createProject(TESTWEB2_PROJECT_NAME);
			testWeb2Project = TomcatTestWorkspace
					.getProject(TESTWEB2_PROJECT_NAME);
			testWeb2Project.refreshLocal(IResource.DEPTH_INFINITE, null);

			if (!TomcatTestWorkspace.getProject(TESTEJB_PROJECT_NAME).exists())
				createProject(TESTEJB_PROJECT_NAME);
			testEjbProject = TomcatTestWorkspace
					.getProject(TESTEJB_PROJECT_NAME);
			testEjbProject.refreshLocal(IResource.DEPTH_INFINITE, null);

			// Create server runtimes
			createTomcat50Runtimes();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List hosteeUnitList = new ArrayList();

		// Load units and add to topology and hostee list
		// FooWeb - has a server target to Tomcat 5.0 (1)
		fooWebUnit = getUnitFromUnitProvider(fooWebProject, top);
		fooWebUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(fooWebUnit);
		hosteeUnitList.add(fooWebUnit);

		// BarWeb - has a server target to Tomcat 5.0 (1)
		barWebUnit = getUnitFromUnitProvider(barWebProject, top);
		barWebUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(barWebUnit);
		hosteeUnitList.add(barWebUnit);

		// FooBarWeb - has a server target to Tomcat 5.0 (2)
		fooBarWebUnit = getUnitFromUnitProvider(fooBarWebProject, top);
		fooBarWebUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(fooBarWebUnit);
		hosteeUnitList.add(fooBarWebUnit);

		// TestWeb - has no server target
		testWebUnit = getUnitFromUnitProvider(testWebProject, top);
		testWebUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(testWebUnit);
		hosteeUnitList.add(testWebUnit);

		// TestWeb2 - has no server target, but is already hosted!!
		testWeb2Unit = getUnitFromUnitProvider(testWeb2Project, top);
		testWeb2Unit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(testWeb2Unit);
		hosteeUnitList.add(testWeb2Unit);
		// host TestWeb2 on a was server
		WebsphereAppServerUnit wasunit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		wasunit.setName("was server"); //$NON-NLS-1$
		top.getUnits().add(wasunit);
		ValidatorTestUtils.hosts(wasunit, testWeb2Unit);

		// TestEJB - has no server target, should not find matching host
		testEjbUnit = getUnitFromUnitProvider(testEjbProject, top);
		testEjbUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(testEjbUnit);
		hosteeUnitList.add(testEjbUnit);

		// TODO more scenarios for discover framework
		// - possible host unit exists in topology (This is TestWeb, don't need
		// it)
		// - unit is already hosted TestWeb2 (no target)
		// - unit has no target, and no matching server in topology TestEJB

		List addedUnits = runDiscoveryOperation(hosteeUnitList);

		runSimpleTopologyCreationSchemeOperation(addedUnits, hosteeUnitList);

		// Should now be nine units
		assert top.getUnits().size() == 11;

		verifyHostingStack(top);

		// TODO Chad - verify annotations on units are correct

		// Load resource, check contents
		res.save(null);
		res.unload();
	}

	private void runSimpleTopologyCreationSchemeOperation(List addedUnits,
			List hosteeUnitList) {
		List allAdded = new ArrayList();
		allAdded.addAll(addedUnits);
		allAdded.addAll(hosteeUnitList);
		new SimpleTopologyCreationScheme().applyScheme(allAdded);
	}

	private Unit getUnitFromUnitProvider(IProject project, Topology topology) {
		IUnitProviderService unitProviderService = ExtensionsCore
				.createProviderService();
		UnitProvider[] providers = unitProviderService
				.findEnabledProvidersByInputOnly(project);
		assert providers.length == 1;
		TopologyUnitStub[] stubs = providers[0].resolveStubs(project);
		assert stubs.length == 1;
		stubs[0].setTopology(topology);
		Object[] objects = providers[0].resolveUnit(stubs[0], true,
				new NullProgressMonitor());
		assert objects.length == 1;
		return (Unit) objects[0];

	}

	private List runDiscoveryOperation(List hosteeUnitList) {
		List addedUnits = DiscoverAndAddService.INSTANCE
				.discoverAndAddHostUnits(hosteeUnitList);
		return addedUnits;
	}

	private boolean createProject(String name) {
		return new ProjectUnzipUtil(TomcatTestWorkspace
				.getPath(testDiscovererProjectZipPath), new String[] { name })
				.createProjects();
	}

	public static void createTomcat50Runtimes() throws IOException,
			CoreException {
		NullProgressMonitor nullMonitor = new NullProgressMonitor();
		IRuntimeType[] runtimes = ServerCore.getRuntimeTypes();
		IRuntimeType tomcatRuntimeType = null;
		for (int i = 0; i < runtimes.length; i++) {
			IRuntimeType type = runtimes[i];
			if (type.getId().equals(TomcatTestWorkspace.tomcat50RuntimeType))
				tomcatRuntimeType = type;
		}
		if (tomcatRuntimeType == null)
			throw new IOException("runtime type not found"); //$NON-NLS-1$

		// Instance 1
		IRuntimeWorkingCopy copy = tomcatRuntimeType.createRuntime(
				TomcatTestWorkspace.tomcat50RuntimeInstanceId, nullMonitor);
		copy.setLocation(TomcatTestWorkspace.getTomcat50Path());
		copy.save(true, nullMonitor);

		// Instance 2
		IRuntimeWorkingCopy copy2 = tomcatRuntimeType.createRuntime(
				TomcatTestWorkspace.tomcat50RuntimeInstanceId2, nullMonitor);
		copy2.setLocation(TomcatTestWorkspace.getTomcat50Path());
		copy2.save(true, nullMonitor);
	}

	private void verifyHostingStack(Topology topology) {
		// FooWeb should be hosted on Tomcat Server (1)
		Unit[] fooWebHosts = topology.findHosts(fooWebUnit);
		assert fooWebHosts.length == 1;
		assert fooWebHosts[0] instanceof TomcatWebServerUnit;
		Annotation annotation = fooWebHosts[0]
				.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeId = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_ID);
			assert runtimeId
					.equals(TomcatTestWorkspace.tomcat50RuntimeInstanceId);
		} else
			assert false;

		// BarWeb should be hosted on Tomcat Server (1)
		Unit[] barWebHosts = topology.findHosts(barWebUnit);
		assert barWebHosts.length == 1;
		assert barWebHosts[0] instanceof TomcatWebServerUnit;
		annotation = barWebHosts[0]
				.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeId = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_ID);
			assert runtimeId
					.equals(TomcatTestWorkspace.tomcat50RuntimeInstanceId);
		} else
			assert false;

		// FooBarWeb should be hosted on Tomcat Server (2)
		Unit[] fooBarWebHosts = topology.findHosts(fooBarWebUnit);
		assert fooBarWebHosts.length == 1;
		assert fooBarWebHosts[0] instanceof TomcatWebServerUnit;
		annotation = fooBarWebHosts[0]
				.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeId = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_ID);
			assert runtimeId
					.equals(TomcatTestWorkspace.tomcat50RuntimeInstanceId2);
		} else
			assert false;

		// TestWeb should be hosted on Tomcat Server (1)
		Unit[] testWebHosts = topology.findHosts(testWebUnit);
		assert testWebHosts.length == 1;
		assert testWebHosts[0] instanceof TomcatWebServerUnit;
		annotation = testWebHosts[0]
				.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeId = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_ID);
			assert runtimeId
					.equals(TomcatTestWorkspace.tomcat50RuntimeInstanceId);
		} else
			assert false;

		// TestEJB should not be hosted
		Unit[] testEjbHosts = topology.findHosts(testEjbUnit);
		assert testEjbHosts.length == 0;
	}

}
