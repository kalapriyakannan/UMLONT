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
import java.util.List;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.extension.IUnitFilterService;
import com.ibm.ccl.soa.deploy.core.ui.internal.DeployableUnitElementUIService;
import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonUnitFilter;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitFilterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.was.WasFactory;

/**
 * Tests the {@link IUnitFilterService} implementation available from
 * <b>com.ibm.ccl.soa.deploy.core</b>.
 * 
 */
public class UnitFilterTests extends TestCase {

	private static final String EXPECTED_TEST_NAME = "Test Topology Unit Filter";
	private static final String EXPECTED_ELEMENT_ID = "was.WebsphereAppServerUnit.6";
	private static final String EXPECTED_CONFIG_ELEMENT_ID = "was.WasDatasourceUnit.50";

	private static final String EXPECTED_TEST_DESCRIPTION = "A test topology unit filter.";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public UnitFilterTests(String name) {
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

		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitFiltersByInputOnly(
						aRandomFile);

		assertEquals(
				"There should be exactly one test extension for java.io.File",
				1, enabledFilters.length);

		assertEquals(EXPECTED_TEST_NAME, enabledFilters[0].getName());
		assertEquals(EXPECTED_TEST_DESCRIPTION, enabledFilters[0]
				.getDescription());

		UnitFilter filter = enabledFilters[0].createUnitFilter();

		assertNotNull(
				"The element should create the test UnitFilter defined by the extension",
				filter);
		List list = filter.getAllowableHostingUnitTypes(null);
		assertEquals(EXPECTED_CONFIG_ELEMENT_ID, list.get(0));
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

		UnitFilterDescriptor[] enabledProviders = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitFiltersByInputAndOutput(
						anInput, anOutput);

		assertEquals(
				"There should be exactly one test extension for java.io.File as input and output as String",
				1, enabledProviders.length);

		assertEquals(EXPECTED_TEST_NAME, enabledProviders[0].getName());

		UnitFilter provider = enabledProviders[0].createUnitFilter();

		assertNotNull(
				"The element should create the test TopologyUnitFilter defined by the extension",
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

		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager
				.getInstance().findEnabledTopologyUnitFiltersByInputOnly(
						aRandomRunnable);

		assertEquals("There should be exactly one test extension for Runnable",
				1, enabledFilters.length);

		try {
			System.out.println("----------BEGIN Expected Error Message in "
					+ UnitFilterTests.class.getName() + "---------------");
			UnitFilter filter = enabledFilters[0].createUnitFilter();
			System.out.println("----------END Expected Error Message in "
					+ UnitFilterTests.class.getName() + "---------------");
			assertTrue("The descriptor should create a SkeletonUnitFilter",
					SkeletonUnitFilter.INSTANCE == filter);
		} catch (Throwable e) {
			fail("Invalid class definitions should be handled gracefully.");
		}

	}

	/**
	 * Usage of the DeployableUnitElementUIService service API
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testDeployableUnitElementUIService() throws Exception {
		List unitElements = DeployableUnitElementUIService.getInstance()
				.getAllowableHostingUnitElements(
						WasFactory.eINSTANCE.createWebsphereAppServerUnit());
		assert (unitElements != null);
		for (int i = 0; i < unitElements.size(); i++) {
			System.out.println(((IUnitElementType) unitElements.get(i))
					.getDisplayName());
			System.out.println(((IUnitElementType) unitElements.get(i))
					.getTemplateURI());
		}
	}
}
