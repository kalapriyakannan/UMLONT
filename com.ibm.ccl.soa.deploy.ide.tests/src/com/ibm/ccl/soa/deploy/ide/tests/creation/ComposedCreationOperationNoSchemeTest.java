/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.creation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.operations.ICreateComposedDeploymentProperties;
import com.ibm.ccl.soa.deploy.core.ui.operations.ICreateDeploymentTopologyProperties;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.ITopologyCreationSchemeConstants;
import com.ibm.ccl.soa.deploy.ide.ui.operation.RCTCreateTopologyExtensionProperties;
import com.ibm.ccl.soa.deploy.tests.util.ProjectUnzipUtil;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

public class ComposedCreationOperationNoSchemeTest extends TestCase {

	private static final String PROJECT_NAME = "ComposedCreationOperationNoSchemeTest"; //$NON-NLS-1$
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

	public void testCreateTopology() throws IOException {

		List deployables = new ArrayList();
		try {
			// Unzip/create projects from zip file
			if (!TomcatTestWorkspace.getProject(FOOWEB_PROJECT_NAME).exists())
				createProject(FOOWEB_PROJECT_NAME);
			fooWebProject = TomcatTestWorkspace.getProject(FOOWEB_PROJECT_NAME);
			fooWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			deployables.add(fooWebProject);

			if (!TomcatTestWorkspace.getProject(BARWEB_PROJECT_NAME).exists())
				createProject(BARWEB_PROJECT_NAME);
			barWebProject = TomcatTestWorkspace.getProject(BARWEB_PROJECT_NAME);
			barWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			deployables.add(barWebProject);

			if (!TomcatTestWorkspace.getProject(FOOBARWEB_PROJECT_NAME)
					.exists())
				createProject(FOOBARWEB_PROJECT_NAME);
			fooBarWebProject = TomcatTestWorkspace
					.getProject(FOOBARWEB_PROJECT_NAME);
			fooBarWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			deployables.add(fooBarWebProject);

			if (!TomcatTestWorkspace.getProject(TESTWEB_PROJECT_NAME).exists())
				createProject(TESTWEB_PROJECT_NAME);
			testWebProject = TomcatTestWorkspace
					.getProject(TESTWEB_PROJECT_NAME);
			testWebProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			deployables.add(testWebProject);

			if (!TomcatTestWorkspace.getProject(TESTWEB2_PROJECT_NAME).exists())
				createProject(TESTWEB2_PROJECT_NAME);
			testWeb2Project = TomcatTestWorkspace
					.getProject(TESTWEB2_PROJECT_NAME);
			testWeb2Project.refreshLocal(IResource.DEPTH_INFINITE, null);
			deployables.add(testWeb2Project);

			if (!TomcatTestWorkspace.getProject(TESTEJB_PROJECT_NAME).exists())
				createProject(TESTEJB_PROJECT_NAME);
			testEjbProject = TomcatTestWorkspace
					.getProject(TESTEJB_PROJECT_NAME);
			testEjbProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			deployables.add(testEjbProject);
			// Create server runtimes
			createTomcat50Runtimes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Setup
		 */
		// URI uri = URI.createPlatformResourceURI(PROJECT_NAME +
		// "/testCreateTopology/testCreateTopology.topology");
		IDataModel model = DataModelFactory
				.createDataModel("CreateComposedDeploymentTopologyProvider"); //$NON-NLS-1$;
		IFolder folder = project.getFolder(new Path("testCreateTopology"));
		try {
			folder.create(true, true, new NullProgressMonitor());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		model.setProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME,
				project.getName());
		DeploymentTopologyDomain domain = new DeploymentTopologyDomain(folder, "testCreateTopology");
		model.setProperty(
				IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL,
				domain.getEditModelLabel());
		model.setProperty(
				IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
				new IScribblerDomain[] { domain });
		IDataModel nestedDataModel = model
				.getNestedModel(ICreateComposedDeploymentProperties.CREATE_DEPLOYMENT_DATAMODEL_PROVIDER);
		nestedDataModel.setProperty(
				ICreateDeploymentTopologyProperties.DEPLOYMENT_FOLDER, folder);
		nestedDataModel.setProperty(
				ICreateDeploymentTopologyProperties.DEPLOYABLE_SELECTIONS,
				deployables.toArray(new Object[deployables.size()]));
		IDataModel deployableModel = DataModelFactory
				.createDataModel(RCTCreateTopologyExtensionProperties.CREATE_RCT_CREATE_TOPOLOGY_EXTENSION_PROVIDER);
		deployableModel
				.setProperty(
						RCTCreateTopologyExtensionProperties.DEPLOYABLE_SELECTED_ITEMS,
						nestedDataModel
								.getProperty(ICreateDeploymentTopologyProperties.DEPLOYABLE_SELECTIONS));
		deployableModel.setProperty(
				RCTCreateTopologyExtensionProperties.TOPOLOGY_CREATION_SCHEME,
				ITopologyCreationSchemeConstants.NO_TOPOLOGY_CREATION_SCHEME);
		nestedDataModel
				.addNestedModel(
						RCTCreateTopologyExtensionProperties.CREATE_RCT_CREATE_TOPOLOGY_EXTENSION_PROVIDER,
						deployableModel);

		IDataModelOperation operation = model.getDefaultOperation();// new
																	// CreateComposedDeploymentTopologyOperation(model);
		try {
			assertTrue(operation.canExecute());
			IProgressMonitor monitor = new NullProgressMonitor();
			IStatus status = operation.execute(monitor, null);
			if (!status.isOK()) {
				Throwable ex = status.getException();
				if (ex != null) {
					ex.printStackTrace();
				}
				System.out.println(status.getMessage());
			}
			assertTrue(status.isOK());
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Topology top = (Topology) nestedDataModel
				.getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_RESULT);

		assert (top != null);

		// Should now be nine units
		assert top.getUnits().size() == deployables.size() + 2;

		// verifyHostingStack( top );
		// Load resource, check contents
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
