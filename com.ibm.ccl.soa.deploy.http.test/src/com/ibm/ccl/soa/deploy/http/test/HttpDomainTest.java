package com.ibm.ccl.soa.deploy.http.test;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.http.StaticWebComponentUnit;

/**
 * Tests that exercise the contents of the Http domain definition.
 * @since 1.0
 */
public class HttpDomainTest extends TestCase {

	private static final String PROJECT_NAME = "HttpDomainTest";
	private static final String STATIC_WEB_COMPONENT_RESOURCE_ID = "http.staticWebComponent";
	private static final String HTTP_SERVER_RESOURCE_ID = "http.httpServer";
	

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
	public void testHttpDomain() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/http.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("HTTP Topology");

		root.setTopology(top);
		
		// Test StaticWebComponent resource type definition (loads template)
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		DeployModelObject dmo = rts.createFromTemplate(STATIC_WEB_COMPONENT_RESOURCE_ID);
		assert dmo instanceof StaticWebComponentUnit;
		StaticWebComponentUnit comp = (StaticWebComponentUnit)dmo;
		top.getUnits().add(comp);

		// Create Http Server 
		dmo = rts.createFromTemplate( HTTP_SERVER_RESOURCE_ID );
		assert dmo instanceof Unit;
		Unit server = (Unit)dmo;
		top.getUnits().add( server );
		
		// Host component on server
		ValidatorTestUtils.hosts( server, comp );

		// Load resource, check contents

		res.save(null);
		
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		assert topology.getUnits().size() > 0;

		res.unload();

	}


}
