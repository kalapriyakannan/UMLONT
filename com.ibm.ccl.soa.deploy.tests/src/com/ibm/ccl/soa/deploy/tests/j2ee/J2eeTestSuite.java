/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.j2ee;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.tests.j2ee.ui.marker.resolution.JndiNameDependencyLinkResolutionTest;
import com.ibm.ccl.soa.deploy.tests.j2ee.validator.J2EEDataSourceLinkValidatorTest;

public class J2eeTestSuite extends TestSuite {

	public J2eeTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new J2eeTestSuite("SOA deploy J2EE tests");
		suite.addTestSuite(CrossDomainRequirementTest.class);
		suite.addTestSuite(J2EEDataSourceLinkValidatorTest.class);
		suite.addTestSuite(JndiNameDependencyLinkResolutionTest.class);
		return suite;
	}
}
