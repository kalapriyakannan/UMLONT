/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension.discoverer;

import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyDiscovererDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;

/**
 * 
 */
public class TopologyDiscovererTests extends TopologyTestCase {

	private static final String EXPECTED_TEST_NAME = "Test Topology Discoverer";

	private static final String EXPECTED_TEST_DESCRIPTION = "A test topology discoverer.";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public TopologyDiscovererTests(String name) {
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

		Topology t = createTopology("testTopologyDiscovererTests", true);

		TopologyDiscovererDescriptor[] discoverers = TopologyManager
				.getInstance().findAvailableDiscoverers(t);

		// This is only true in case of IDE or DP - assertTrue("There should be
		// at least one test extension", discoverers.length > 0);
		TopologyDiscovererDescriptor testDesc = null;
		for (int i = 0; i < discoverers.length; i++) {
			if (discoverers[i].getName().equals(EXPECTED_TEST_NAME)) {
				testDesc = discoverers[i];
				break;
			}
		}
		if (testDesc != null) {
			assertEquals(EXPECTED_TEST_NAME, testDesc.getName());
			assertEquals(EXPECTED_TEST_DESCRIPTION, testDesc.getDescription());

			TopologyDiscoverer discoverer = testDesc.createTopologyDiscoverer();

			assertNotNull(
					"The element should create the test TopologyDiscoverer defined by the extension",
					discoverer);

			assertTrue(
					"The element should create the test TopologyDiscoverer defined by the extension",
					discoverer != SkeletonTopologyDiscoverer.INSTANCE);

			// TODO additional test here
			DiscoveryFilter filter = new DiscoveryFilter();
			filter.setUnit(J2eeFactory.eINSTANCE.createEarModule());
			assert (discoverer.canDiscover(filter) == true);
			List discoveredUnits = discoverer.findAll(filter);
			for (Iterator iter = discoveredUnits.iterator(); iter.hasNext();) {
				UnitDescriptor element = (UnitDescriptor) iter.next();
				assert (element.getDescriporName().equals("myEARId1"));
				assert (element.getUnitValue().getName().equals("TestEAR"));
				assert (element.getUnitValueAndAddToTopology(t).getName()
						.equals("TestEAR"));
			}
		}
	}

}
