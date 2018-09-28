/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.unit.publisher;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class PublisherTestSuite extends TestSuite {

	public static Test suite() {
		TestSuite suite = new PublisherTestSuite();
		suite.addTest(new ThreadSpawnableTest(
				new ServerToolUnitPublisherTests()));
		return suite;
	}

	public void run(TestResult result) {
		super.run(result);
	}
}
