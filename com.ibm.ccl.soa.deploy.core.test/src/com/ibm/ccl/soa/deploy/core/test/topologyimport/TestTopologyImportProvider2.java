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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class TestTopologyImportProvider2 extends TopologyTestCase {

	private static final String PROJECT_NAME = "TopologyImportTest";
	private static final String TOPOLOGY_NAMESPACE = "com.ibm.test";
	private static final String IMPORTED_TOP_NAME = "testImportedTopology";
	private static final String IMPORTING_TOP_NAME = "testImportingTopology";

	public TestTopologyImportProvider2() {
		super(PROJECT_NAME);
	}

	public TestTopologyImportProvider2(String name) {
		super(name);
		setDeleteProjectOnTearDown(true);
	}

	public void testTopologyImportProviderByTopologyFile() throws IOException {

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
		Resource importedTopResource = WorkbenchResourceHelper
				.createResource(importedURI);
		UnitProviderDescriptor[] enabledProviders = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitProvidersByInputOnly(
						WorkbenchResourceHelper.getFile(importedTopResource));
		UnitProvider provider = enabledProviders[0].createUnitProvider();
		TopologyUnitStub[] topologyStubs = provider
				.resolveStubs(WorkbenchResourceHelper
						.getFile(importedTopResource));
		assert topologyStubs != null && topologyStubs.length > 0;

		DeployModelObject[] tImports = (DeployModelObject[]) provider
				.resolveUnit(topologyStubs[0], false, new NullProgressMonitor());

		assert tImports != null && tImports.length > 0;
		Import tImport = (Import) tImports[0];
		assertEquals(IMPORTED_TOP_NAME, tImport.getName());
		assertEquals(IMPORTED_TOP_NAME, tImport.getPattern());
		// assertEquals(TOPOLOGY_NAMESPACE, tImport.getNamespace());
		// assert tImport.getLocation() != null;

		importingTop.getImports().add(tImports[0]);

		assert importingTop.getImports().size() == 1;

		// reload topology
		importingTop = reload(importingTop, true);

		assert importingTop.getImports().size() == 1;
		// access the links

	}

	private URI getURI(String name) {
		return URI.createPlatformResourceURI(getName() + "/com/ibm/test/"
				+ name + ".topology");
	}

	private Topology createTopology(String name, URI uri, String namespace,
			boolean save) throws IOException {
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);

		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName(name);
		top.setNamespace(TOPOLOGY_NAMESPACE);
		root.setTopology(top);

		if (save) {
			res.save(null);
		}
		return top;
	}

}
