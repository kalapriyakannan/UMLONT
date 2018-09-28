/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * @since 1.0
 * 
 */
public class CoreDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "CoreDomainTest";

	/**
	 * 
	 */
	public CoreDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testCoreDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI
				.createPlatformResourceURI(PROJECT_NAME + "/core.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Core Topology");

		// TODO add core topology elements here

		root.setTopology(top);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		assertNoValidationErrors(topology);
		res.unload();

		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.core/templates/unitGroup.template");

	}

}
