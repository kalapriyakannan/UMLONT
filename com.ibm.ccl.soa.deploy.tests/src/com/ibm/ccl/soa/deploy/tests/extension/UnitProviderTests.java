/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.io.File;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonUnitProvider;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;

/**
 * Tests the {@link IUnitProviderService} implementation available from
 * <b>com.ibm.ccl.soa.deploy.core</b>.
 * 
 */
public class UnitProviderTests extends TestCase {

	private static final String EXPECTED_TEST_NAME = "Test Topology Unit Provider";

	private static final String EXPECTED_TEST_DESCRIPTION = "A test topology unit provider.";

	private static final String EXPECTED_INPUT_OUTPUT_TEST_NAME = "Test Input Output Provider";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public UnitProviderTests(String name) {
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

		UnitProviderDescriptor[] enabledProviders = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitProvidersByInputOnly(
						aRandomFile);

		assertEquals(
				"There should be exactly one test extension for java.io.File",
				1, enabledProviders.length);

		assertEquals(EXPECTED_TEST_NAME, enabledProviders[0].getName());
		assertEquals(EXPECTED_TEST_DESCRIPTION, enabledProviders[0]
				.getDescription());

		UnitProvider provider = enabledProviders[0].createUnitProvider();

		assertNotNull(
				"The element should create the test TopologyUnitProvider defined by the extension",
				provider);

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

		UnitProviderDescriptor[] enabledProviders = UnitLifeCycleManager
				.getInstance()
				.findEnabledTopologyUnitProvidersByInputAndOutput(anInput,
						anOutput);

		assertEquals(
				"There should be exactly one test extension for java.io.File as input and output as String",
				1, enabledProviders.length);

		assertEquals(EXPECTED_INPUT_OUTPUT_TEST_NAME, enabledProviders[0]
				.getName());

		UnitProvider provider = enabledProviders[0].createUnitProvider();

		assertNotNull(
				"The element should create the test TopologyUnitProvider defined by the extension",
				provider);

	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testExtensionManager_invalidExtension() throws Exception {
// API undergoing modification from meetings; test to be updated shortly.
		Runnable aRandomRunnable = new Runnable() {
			public void run() {
			}
		};

		UnitProviderDescriptor[] enabledProviders = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitProvidersByInputOnly(
						aRandomRunnable);

		assertEquals("There should be exactly one test extension for Runnable",
				1, enabledProviders.length);

		try {
			System.out.println("----------BEGIN Expected Error Message in "
					+ UnitProviderTests.class.getName() + "---------------");
			UnitProvider provider = enabledProviders[0].createUnitProvider();
			System.out.println("----------END Expected Error Message in "
					+ UnitProviderTests.class.getName() + "---------------");
			assertTrue("The descriptor should create a SkeletonUnitProvider",
					SkeletonUnitProvider.INSTANCE == provider);
		} catch (Throwable e) {
			fail("Invalid class definitions should be handled gracefully.");
		}

	}
	
	public void testUnitProviderAPI() throws Exception {
		UnitProvider prov = 
			UnitLifeCycleManager.getInstance().getUnitProviderByName("Test Topology Unit Provider");
		
		assert prov != null;
	}

}
