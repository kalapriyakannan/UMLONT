/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension.discoverer;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.core.extension.IUnitDiscovererService;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonUnitDiscoverer;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitDiscovererDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;

/**
 * Tests the {@link IUnitDiscovererService} implementation available from
 * <b>com.ibm.ccl.soa.deploy.core</b>.
 * 
 */
public class UnitDiscovererTests extends TestCase {

	private static final String EXPECTED_TEST_NAME = "Test Unit Discoverer";
	private static final String EXPECTED_TEST_DESCRIPTION = "A test unit discoverer.";

	private static final String EXPECTED_DISCOVERED_UNIT_NAME = "testUnit";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public UnitDiscovererTests(String name) {
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

		File aRandomFile = new File("random.txt");

		UnitDiscovererDescriptor[] enabledDiscoverers = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitDiscoverersByInputOnly(
						aRandomFile);

		assertEquals(
				"There should be exactly one test extension for java.io.File",
				1, enabledDiscoverers.length);

		assertEquals(EXPECTED_TEST_NAME, enabledDiscoverers[0].getName());
		assertEquals(EXPECTED_TEST_DESCRIPTION, enabledDiscoverers[0]
				.getDescription());

		UnitDiscoverer discoverer = enabledDiscoverers[0]
				.createUnitDiscoverer();

		assertNotNull(
				"The element should create the test UnitDiscoverer defined by the extension",
				discoverer);
		DiscoveryFilter filter = new DiscoveryFilter();
		filter.setUnit(J2eeFactory.eINSTANCE.createEarModule());
		assert (discoverer.canDiscover(filter) == true);
		List discoveredUnits = discoverer.findAll(filter);
		for (Iterator iter = discoveredUnits.iterator(); iter.hasNext();) {
			UnitDescriptor element = (UnitDescriptor) iter.next();
			assert (element.getDescriporName().equals("myEARId1"));
			assert (element.getUnitValue().getName().equals("TestEAR"));
		}
	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testInputOutputProvider() throws Exception {

		StringBuffer anInput = new StringBuffer("random1.txt");
		StringBuffer anOutput = new StringBuffer("random2.txt");

		UnitDiscovererDescriptor[] enabledProviders = UnitLifeCycleManager
				.getInstance()
				.findEnabledTopologyUnitDiscoverersByInputAndOutput(anInput,
						anOutput);

		assertEquals(
				"There should be exactly one test extension for java.io.File as input and output as String",
				1, enabledProviders.length);

		assertEquals(EXPECTED_TEST_NAME, enabledProviders[0].getName());

		UnitDiscoverer provider = enabledProviders[0].createUnitDiscoverer();

		assertNotNull(
				"The element should create the test TopologyUnitDiscoverer defined by the extension",
				provider);

	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testExtensionManager_invalidExtension() throws Exception {
		Runnable aRandomRunnable = new Runnable() {
			public void run() {
			}
		};

		UnitDiscovererDescriptor[] enabledDiscoverers = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitDiscoverersByInputOnly(
						aRandomRunnable);

		assertEquals("There should be exactly one test extension for Runnable",
				1, enabledDiscoverers.length);

		try {
			System.out.println("----------BEGIN Expected Error Message in "
					+ UnitDiscovererTests.class.getName() + "---------------");
			UnitDiscoverer discoverer = enabledDiscoverers[0]
					.createUnitDiscoverer();
			System.out.println("----------END Expected Error Message in "
					+ UnitDiscovererTests.class.getName() + "---------------");
			assertTrue("The descriptor should create a SkeletonUnitDiscoverer",
					SkeletonUnitDiscoverer.INSTANCE == discoverer);
		} catch (Throwable e) {
			fail("Invalid class definitions should be handled gracefully.");
		}

	}

}
