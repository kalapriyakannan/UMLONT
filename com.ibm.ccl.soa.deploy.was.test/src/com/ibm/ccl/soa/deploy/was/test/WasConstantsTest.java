/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.test;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.test.NLSTestUtils;
import com.ibm.ccl.soa.deploy.core.test.validator.StatusConstantsTestUtils;
import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Test WAS domain constants.
 */
public class WasConstantsTest extends TestCase {

	/**
	 * Tests the bindings of domain messages.
	 */
	public void testMessages() {
		NLSTestUtils.checkNLS(WasDomainMessages.class,
				WasDomainMessages.BUNDLE_NAME);
	}

	/**
	 * Tests the problem type definitions.
	 */
	public void testProblemTypes() {
		// TODO make WAS problem types constants and IDs consistent
		// StatusConstantsTestUtils.checkProblemTypes(IWASProblemType.class,
		// WasDeployPlugin.pluginID, true);
	}

	/**
	 * Tests that the validator IDs are unique and consistent with their Java
	 * constant names.
	 */
	public void testValidatorIDs() {
		StatusConstantsTestUtils.checkValidatorIDs(IWasValidatorID.class,
				WasDeployPlugin.pluginID, true);
	}
}
