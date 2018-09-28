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

import com.ibm.ccl.soa.deploy.core.TopologyPublisher;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherService;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonTopologyPublisher;

/**
 * 
 */
public class TopologyPublisherTests extends TestCase {

	private static final String EXPECTED_TEST_NAME = "Test Topology Publisher";

	private static final String EXPECTED_TEST_DESCRIPTION = "A test topology publisher.";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public TopologyPublisherTests(String name) {
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
		
		ITopologyPublisherService publisherServie = ExtensionsCore.createTopologyPublisherService();
				
		ITopologyPublisherDescriptor[] publishers = publisherServie.findAvailableTopologyPublishers();

		ITopologyPublisherDescriptor testPublisherDesc = null;

		assertTrue("There should be at least one test extension",
				publishers.length > 0);

		for (int i = 0; i < publishers.length; i++) {
			ITopologyPublisherDescriptor descriptor = publishers[i];
			if (descriptor.getName().equals(EXPECTED_TEST_NAME))
				testPublisherDesc = descriptor;

		}
		assertNotNull(testPublisherDesc);

		assertEquals(EXPECTED_TEST_NAME, testPublisherDesc.getName());
		assertEquals(EXPECTED_TEST_DESCRIPTION, testPublisherDesc
				.getDescription());

		TopologyPublisher publisher = testPublisherDesc
				.createTopologyPublisher();

		assertNotNull(
				"The element should create the test TopologyPublisher defined by the extension",
				publisher);

		assertTrue(
				"The element should create the test TopologyPublisher defined by the extension",
				publisher != SkeletonTopologyPublisher.INSTANCE);

	}

}
