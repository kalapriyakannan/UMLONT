/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ResolutionTestSuite extends TestSuite {

	public ResolutionTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new ResolutionTestSuite(
				"com.ibm.ccl.soa.deploy.core.ui.marker.resolution");
		suite
				.addTestSuite(DeployObjectAttributeValueMarkerResolutionTest.class);
		suite.addTestSuite(InsertNewDatabaseInstanceMarkerResolutionTest.class);
		suite.addTestSuite(NameNotUniqueMarkerResolutionTest.class);
		// TODO disabled in C4
		// suite.addTestSuite(UnitConsumedServiceUnmatchedFromTopologyMarkerResolutionTest.class);
		// TODO disabled in C4
		// suite.addTestSuite(UnitNotHostedMarkerResolutionTest.class);
		return suite;
	}
}
