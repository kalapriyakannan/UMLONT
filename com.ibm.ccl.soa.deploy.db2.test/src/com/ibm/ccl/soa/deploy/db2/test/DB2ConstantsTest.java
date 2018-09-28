/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.test.NLSTestUtils;
import com.ibm.ccl.soa.deploy.core.test.validator.StatusConstantsTestUtils;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.Db2DomainMessages;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ProblemType;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;

/**
 * Tests the constants associated with the {@link Db2Package} deploy domain.
 */
public class DB2ConstantsTest extends TestCase {

	/**
	 * Tests the consistency between {@link Db2DomainMessages} and the
	 * messages.properties file.
	 */
	public void testMessages() {
		NLSTestUtils.checkNLS(Db2DomainMessages.class,
				"com.ibm.ccl.soa.deploy.db2.internal.messages"); //$NON-NLS-1$
	}

	/**
	 * Tests the problem type definitions.
	 */
	public void testProblemTypes() {
		StatusConstantsTestUtils.checkProblemTypes(IDB2ProblemType.class,
				DB2DeployPlugin.PLUGIN_ID, true);
	}

	/**
	 * Tests that the validator IDs are unique and consistent with their Java
	 * constant names.
	 */
	public void testValidatorIDs() {
		StatusConstantsTestUtils.checkValidatorIDs(IDB2ValidatorID.class,
				DB2DeployPlugin.PLUGIN_ID, true);
	}
}
