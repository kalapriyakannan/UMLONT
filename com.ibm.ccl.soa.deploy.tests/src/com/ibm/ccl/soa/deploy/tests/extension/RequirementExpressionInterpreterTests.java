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

import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.validator.expression.IRequirementExpressionInterpreter;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementExpressionService;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonRequirementExpressionInterpreter;

/**
 * Tests the {@link IUnitProviderService} implementation available from
 * <b>com.ibm.ccl.soa.deploy.core</b>.
 * 
 */
public class RequirementExpressionInterpreterTests extends TestCase {

	private static final String EXPECTED_TEST_NAME = "TestRequirementExpressionInterpreter";

	private static final String EXPECTED_TEST_DESCRIPTION = "A test Interpreter";

	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public RequirementExpressionInterpreterTests(String name) {
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
	public void testGetIntepreter() throws Exception {

		IRequirementExpressionInterpreter interp = RequirementExpressionService.INSTANCE.getExpressionInterpreter(
						EXPECTED_TEST_NAME);

		assertTrue(interp instanceof SkeletonRequirementExpressionInterpreter);
	}
}
