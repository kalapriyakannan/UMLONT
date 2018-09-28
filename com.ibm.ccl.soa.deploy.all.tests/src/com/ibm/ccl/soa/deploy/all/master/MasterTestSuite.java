/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.all.master;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.core.test.DeployCoreModelSuite;
import com.ibm.ccl.soa.deploy.generic.test.GenericModelSuite;
import com.ibm.ccl.soa.deploy.os.test.OsModelSuite;

public class MasterTestSuite extends TestSuite {

	// This test suite should be run/passed for:
	// model changes
	// smoke test validation
	// refactoring...

	public MasterTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new MasterTestSuite("Deploy tooling master suite"); //$NON-NLS-1$
		suite.addTest(DeployCoreModelSuite.suite());
        suite.addTest(GenericModelSuite.suite());
        suite.addTest(OsModelSuite.suite());
		return suite;
	}

}
