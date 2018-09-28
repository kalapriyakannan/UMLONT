/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.topologyimport;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

public class TestTopologyImport extends TopologyTestCase {

	private static final String PROJECT_NAME = "TopologyImportTest";
	private static final String TOPOLOGY_NAMESPACE = "com.ibm.test";
	private static final String IMPORTED_TOP_NAME = "testImportedTopology";
	private static final String IMPORTING_TOP_NAME = "testImportingTopology";

	public TestTopologyImport() {
		super(PROJECT_NAME);
	}

	public TestTopologyImport(String name) {
		super(name);
		setDeleteProjectOnTearDown(false);
	}

	public void testTopologyImport() throws IOException {

		// Create project
		// New up a topology to be used for import
		// Get/save location URI and/or namespace
		URI importedURI = getURI(IMPORTED_TOP_NAME);
		Topology importedTop = createTopology(IMPORTED_TOP_NAME, importedURI,
				TOPOLOGY_NAMESPACE, true);
		importedTop.setNamespace(TOPOLOGY_NAMESPACE);

		// new up another topology
		URI importingURI = getURI(IMPORTING_TOP_NAME);
		Topology importingTop = createTopology(IMPORTING_TOP_NAME,
				importingURI, TOPOLOGY_NAMESPACE, true);
		importingTop.setNamespace(TOPOLOGY_NAMESPACE);

		// Add the import
		Import topImport = createImport(IMPORTED_TOP_NAME, importedURI
				.toString(), TOPOLOGY_NAMESPACE);
		importingTop.getImports().add(topImport);

		assert importingTop.getImports().size() == 1;

		// update the manager
		// hit the manager (test APIs, etc.)

		// Create some links, etc.
		// requires the link resolutino code to deal with namespace prefix

		// reload topology
		importingTop = reload(importingTop, true);

		assert importingTop.getImports().size() == 1;
		// access the links

	}

	protected Topology createTopology(String name, boolean save)
			throws IOException {
		URI uri = URI.createPlatformResourceURI(getName() + '/' + name
				+ ".topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);

		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName(name);
		root.setTopology(top);

		if (save) {
			res.save(null);
		}
		return top;
	}

	private URI getURI(String name) {
		return URI.createPlatformResourceURI(getName() + '/' + name
				+ ".topology");
	}

	private Topology createTopology(String name, URI uri, String namespace,
			boolean save) throws IOException {
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);

		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName(name);
		root.setTopology(top);

		if (save) {
			res.save(null);
		}
		return top;
	}

	private Import createImport(String name, String location, String namespace) {
		Import topImport = CoreFactory.eINSTANCE.createImport();
		topImport.setName(name);
		// topImport.setLocation( location );
		topImport.setNamespace(namespace);
		return topImport;
	}

}
