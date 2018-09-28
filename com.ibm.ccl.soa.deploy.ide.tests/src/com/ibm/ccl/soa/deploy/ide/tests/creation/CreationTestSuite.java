/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.creation;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CreationTestSuite extends TestSuite {

	// This test suite should be run/passed for:
	// model changes
	// smoke test validation
	// refactoring...

	public CreationTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new CreationTestSuite("Topology Creation  suite"); //$NON-NLS-1$
		suite.addTestSuite(ComposedCreationOperationTest.class);
		suite
				.addTestSuite(ComposedCreationOperationNoDiscoveryNoSchemeTest.class);
		suite.addTestSuite(ComposedCreationOperationNoDiscoveryTest.class);
		suite.addTestSuite(ComposedCreationOperationNoSchemeTest.class);
		suite.addTestSuite(ComposedCreationOperationUseProjectTest.class);
		return suite;
	}

}
