/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.generic.test.validator.GenericDomainMatcherTest;
import com.ibm.ccl.soa.deploy.generic.test.validator.GenericDomainValidatorTest;
import com.ibm.ccl.soa.deploy.generic.test.validator.GenericUnitValidatorTest;

public class GenericModelSuite extends TestSuite {

	public GenericModelSuite() {
		super();
	}

	/**
	 * @param name
	 */
	public GenericModelSuite(String name) {
		super(name);
	}

	/**
	 * @return Test
	 */
	public static Test suite() {
		TestSuite suite = new GenericModelSuite(
				"SOA Deploy Generic Model test suite."); //$NON-NLS-1$

		suite.addTestSuite(GenericConstantsTest.class);

		suite.addTestSuite(GenericDomainValidatorTest.class);
		suite.addTestSuite(GenericUnitValidatorTest.class);
		suite.addTestSuite(GenericDomainMatcherTest.class);

		return suite;
	}

}
