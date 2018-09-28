/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.discoverer;

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
import org.eclipse.wst.server.core.IRuntime;
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
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;
import com.ibm.ccl.soa.deploy.tests.util.ProjectUnzipUtil;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

public class IdeTopologyDiscovererTest1 extends TestCase {

	private static final String PROJECT_NAME = "IdeTopologyDiscovererTest1"; //$NON-NLS-1$
	private static final String TESTWEB_PROJECT_NAME = "TestWeb"; // NONE
																	// //$NON-NLS-1$

	private static Path testDiscovererProjectZipPath = new Path(
			"/testData/discovererWorkspace.zip"); //$NON-NLS-1$

	private IProject testWebProject;

	private IProject project;

	private Unit testWebUnit;

	protected void setUp() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	public void testIdeTopologyDiscoverer() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI
				.createPlatformResourceURI(PROJECT_NAME
						+ "/IdeTopologyDiscovererTest1/IdeTopologyDiscovererTest1.topology"); //$NON-NLS-1$
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Test Discoverer Topology"); //$NON-NLS-1$

		root.setTopology(top);

		try {
			// Unzip/create projects from zip file
			if (!TomcatTestWorkspace.getProject(TESTWEB_PROJECT_NAME).exists())
				createProject(TESTWEB_PROJECT_NAME);
			testWebProject = TomcatTestWorkspace
					.getProject(TESTWEB_PROJECT_NAME);
			testWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);

			// Create server runtimes
			createTomcat50Runtimes();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List hosteeUnitList = new ArrayList();

		// Load units and add to topology and hostee list
		// TestWeb - has no server target
		testWebUnit = getUnitFromUnitProvider(testWebProject, top);
		testWebUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(testWebUnit);
		hosteeUnitList.add(testWebUnit);

		// TODO more scenarios for discover framework
		// - possible host unit exists in topology (This is TestWeb, don't need
		// it)
		// - unit is already hosted TestWeb2 (no target)
		// - unit has no target, and no matching server in topology TestEJB

		runDiscoveryOperation(hosteeUnitList);

		// Should now be nine units
		assert top.getUnits().size() == 2;

		verifyHostingStack(top);

		// TODO Chad - verify annotations on units are correct

		// Load resource, check contents
		res.save(null);
		res.unload();
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

	private void runDiscoveryOperation(List hosteeUnitList) {
		DiscoverAndAddService.INSTANCE.discoverAndAddHostUnits(hosteeUnitList);
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
		boolean tomcat50RuntimeInstanceIdExists = false;
		boolean tomcat50RuntimeInstanceId2Exists = false;
		IRuntime[] existingRuntimes = ServerCore.getRuntimes();
		for (int i = 0; i < existingRuntimes.length; i++) {
			if (existingRuntimes[i].getId().equals(
					TomcatTestWorkspace.tomcat50RuntimeInstanceId)) {
				tomcat50RuntimeInstanceIdExists = true;
			}
			if (existingRuntimes[i].getId().equals(
					TomcatTestWorkspace.tomcat50RuntimeInstanceId2)) {
				tomcat50RuntimeInstanceId2Exists = true;
			}
		}
		if (!tomcat50RuntimeInstanceIdExists) {
			// Instance 1
			IRuntimeWorkingCopy copy = tomcatRuntimeType.createRuntime(
					TomcatTestWorkspace.tomcat50RuntimeInstanceId, nullMonitor);
			copy.setLocation(TomcatTestWorkspace.getTomcat50Path());
			copy.save(true, nullMonitor);
		}
		if (!tomcat50RuntimeInstanceId2Exists) {
			// Instance 2
			IRuntimeWorkingCopy copy2 = tomcatRuntimeType
					.createRuntime(
							TomcatTestWorkspace.tomcat50RuntimeInstanceId2,
							nullMonitor);
			copy2.setLocation(TomcatTestWorkspace.getTomcat50Path());
			copy2.save(true, nullMonitor);
		}
	}

	private void verifyHostingStack(Topology topology) {
		// TestWeb should be hosted on Tomcat Server (1)
		Unit[] testWebHosts = topology.findHosts(testWebUnit);
		assert testWebHosts.length == 1;
		assert testWebHosts[0] instanceof TomcatWebServerUnit;
		Annotation annotation = testWebHosts[0]
				.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeId = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_ID);
			assert runtimeId
					.equals(TomcatTestWorkspace.tomcat50RuntimeInstanceId);
		} else
			assert false;
	}

}
