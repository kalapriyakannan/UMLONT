/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.test.validator.StatusConstantsTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class DeployCoreConstantsTest extends TestCase {

	/**
	 * Tests the consistency between {@link DeployCoreMessages} and the
	 * messages.properties file.
	 */
	public void testMessages() throws Exception {
		NLSTestUtils.checkNLS(DeployCoreMessages.class,
				DeployCoreMessages.BUNDLE_NAME);
	}

	/**
	 * Tests the problem type definitions.
	 */
	public void testProblemTypes() {
		StatusConstantsTestUtils.checkProblemTypes(ICoreProblemType.class,
				DeployCorePlugin.PLUGIN_ID, true);
	}

	/**
	 * Tests that the validator IDs are unique and consistent with their Java
	 * constant names.
	 */
	public void testValidatorIDs() {
		StatusConstantsTestUtils.checkValidatorIDs(IDeployCoreValidators.class,
				DeployCorePlugin.PLUGIN_ID, true);
	}
}
