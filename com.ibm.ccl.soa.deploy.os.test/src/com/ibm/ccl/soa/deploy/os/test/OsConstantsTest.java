/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.test;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.test.NLSTestUtils;
import com.ibm.ccl.soa.deploy.core.test.validator.StatusConstantsTestUtils;
import com.ibm.ccl.soa.deploy.os.OsDeployPlugin;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsProblemType;

/**
 * Tests the constants associated with the {@link OsPackage} deploy domain.
 */
public class OsConstantsTest extends TestCase {

	/**
	 * Tests the consistency between {@link OsDomainMessages} and the
	 * messages.properties file.
	 */
	public void testMessages() {
		NLSTestUtils.checkNLS(OsDomainMessages.class,
				"com.ibm.ccl.soa.deploy.os.internal.messages");
	}

	/**
	 * Tests the problem type definitions.
	 */
	public void testProblemTypes() {
		StatusConstantsTestUtils.checkProblemTypes(IOsProblemType.class,
				OsDeployPlugin.PLUGIN_ID, true);
	}

	/**
	 * Tests that the validator IDs are unique and consistent with their Java
	 * constant names.
	 */
	public void testValidatorIDs() {
		StatusConstantsTestUtils.checkValidatorIDs(IOsDomainValidators.class,
				OsDeployPlugin.PLUGIN_ID, true);
	}
}
