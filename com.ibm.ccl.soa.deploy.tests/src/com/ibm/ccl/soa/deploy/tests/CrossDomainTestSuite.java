/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests;

import com.ibm.ccl.soa.deploy.tests.core.validator.matcher.HostingLinkTest;
import com.ibm.ccl.soa.deploy.tests.core.validator.matcher.RealizationLinkTest;
import com.ibm.ccl.soa.deploy.tests.core.validator.pattern.action.SignatureIteratorTest;
import com.ibm.ccl.soa.deploy.tests.core.validator.resolution.ChangeVisibilityResolutionTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CrossDomainTestSuite extends TestSuite {

	public CrossDomainTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new CrossDomainTestSuite("SOA Cross Domain Tests");
		suite.addTestSuite(HostingLinkTest.class);
		suite.addTestSuite(RealizationLinkTest.class);
		suite.addTestSuite(ChangeVisibilityResolutionTest.class);
		suite.addTestSuite(SignatureIteratorTest.class);
		return suite;
	}
}
