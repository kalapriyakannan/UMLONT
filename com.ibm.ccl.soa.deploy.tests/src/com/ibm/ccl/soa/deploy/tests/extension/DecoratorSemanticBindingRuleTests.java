/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;

/**
 * @since 1.0
 * 
 */
public class DecoratorSemanticBindingRuleTests extends DomainTestCase {

	private static final String PROJECT_NAME = "DecoratorSemanticTest";
	private static final String TEST_SEMANTIC_ID = "test.testDecoratorSemantic";
	private static final String TEST_PLUGIN_ID = "com.ibm.ccl.soa.deploy.tests";

	/**
	 * 
	 */
	public DecoratorSemanticBindingRuleTests() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testDecoratorSemanticBindingRules() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/decoratorSemantic.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Decorator Semantic Binding Rule Topology");
		
		root.setTopology(top);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		res.unload();

	}

}
