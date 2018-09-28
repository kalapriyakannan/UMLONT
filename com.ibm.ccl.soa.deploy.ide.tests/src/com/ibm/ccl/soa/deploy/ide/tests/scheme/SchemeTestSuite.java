/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.scheme;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SchemeTestSuite extends TestSuite {

	// This test suite should be run/passed for:
	// model changes
	// smoke test validation
	// refactoring...

	public SchemeTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new SchemeTestSuite("Topology CreationScheme  suite"); //$NON-NLS-1$
		suite.addTestSuite(SimpleTopologyCreationSchemeTest.class);
		suite.addTestSuite(SimpleTopologyCreationSchemeTest1.class);

		return suite;
	}

}
