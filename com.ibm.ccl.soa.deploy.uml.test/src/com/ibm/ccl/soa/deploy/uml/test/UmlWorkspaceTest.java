/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.uml.test;

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.uml2.uml.Component;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.uml.test.workspaces.UmlTestWorkspace;


public class UmlWorkspaceTest extends TestCase {

	private static final String PROJECT_NAME = "UMLWorkspaceTest";

	private IProject topologyProject;

	protected void setUp() throws Exception {
		super.setUp();
		topologyProject = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		topologyProject.create(new NullProgressMonitor());
		topologyProject.open(new NullProgressMonitor());

		UmlTestWorkspace.init();
	}

	/**
	 * @throws IOException
	 */
	
	public void testUMLWorkspace() throws Exception {
		
		IProject modelProject = UmlTestWorkspace.getProject("TestUMLProject"); //$NON-NLS-1$

		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/uml_test.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("UML Test Topology");

		root.setTopology(top);
		
		Object obj = UmlTestWorkspace.getComponentA();
		assertNotNull(obj);
		assert obj instanceof Component;
		
		// TODO

		res.save(null);
		
		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		//assert topology.getConstraints().size() > 0;

		res.unload();
	}

}
