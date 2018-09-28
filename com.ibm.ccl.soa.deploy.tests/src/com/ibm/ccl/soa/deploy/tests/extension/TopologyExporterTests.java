/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyExporterDescriptor;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyExporterService;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonTopologyExporter;

/**
 * 
 */
public class TopologyExporterTests extends TestCase {

	private static final String EXPECTED_TEST_NAME = "Test Topology Exporter";

	private static final String EXPECTED_TEST_DESCRIPTION = "A test topology exporter.";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public TopologyExporterTests(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testExtensionManager_validExtension() throws Exception {

		ITopologyExporterService exporterServie = ExtensionsCore.createTopologyExporterService();
		
		ITopologyExporterDescriptor[] exporters = exporterServie.findAvailableTopologyExporters();

		assertTrue("There should be at least one test extension",
				exporters.length > 0);

		ITopologyExporterDescriptor testDesc = null;
		for (int i = 0; i < exporters.length; i++) {
			if (exporters[i].getName().equals(EXPECTED_TEST_NAME)) {
				testDesc = exporters[i];
				break;
			}
		}
		assertEquals(EXPECTED_TEST_NAME, testDesc.getName());
		assertEquals(EXPECTED_TEST_DESCRIPTION, testDesc.getDescription());

		TopologyExporter exporter = testDesc.createTopologyExporter();

		assertNotNull(
				"The element should create the test TopologyExporter defined by the extension",
				exporter);

		assertTrue(
				"The element should create the test TopologyExporter defined by the extension",
				exporter != SkeletonTopologyExporter.INSTANCE);

	}

}
