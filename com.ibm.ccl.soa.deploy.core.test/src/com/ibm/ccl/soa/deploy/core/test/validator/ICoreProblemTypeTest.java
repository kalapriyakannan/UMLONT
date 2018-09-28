/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Tests {@link ICoreProblemType}
 */
public class ICoreProblemTypeTest extends TestCase {

	public void testProblemTypes() {
		StatusConstantsTestUtils.checkProblemTypes(ICoreProblemType.class,
				DeployCorePlugin.PLUGIN_ID, true);
	}
}
