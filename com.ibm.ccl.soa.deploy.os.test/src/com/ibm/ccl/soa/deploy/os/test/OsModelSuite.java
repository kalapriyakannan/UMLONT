/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.os.test.validator.OperatingSystemUnitValidatorTest;
import com.ibm.ccl.soa.deploy.os.test.validator.OsDomainValidatorTest;
import com.ibm.ccl.soa.deploy.os.test.validator.OsGroupCardinalityTest;
import com.ibm.ccl.soa.deploy.os.test.validator.PortConfigUnitValidatorTest;
import com.ibm.ccl.soa.deploy.os.test.validator.UserGroupUnitValidatorTest;
import com.ibm.ccl.soa.deploy.os.test.validator.UserUnitValidatorTest;

public class OsModelSuite extends TestSuite {

	public OsModelSuite() {
		super();
	}

	public OsModelSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new OsModelSuite("SOA Deploy Os Model test suite."); //$NON-NLS-1$

		suite.addTestSuite(OsConstantsTest.class);

		suite.addTestSuite(OsDomainValidatorTest.class);
		suite.addTestSuite(OperatingSystemUnitValidatorTest.class);
		suite.addTestSuite(UserUnitValidatorTest.class);
		suite.addTestSuite(UserGroupUnitValidatorTest.class);
		suite.addTestSuite(PortConfigUnitValidatorTest.class);
		suite.addTestSuite(OsGroupCardinalityTest.class);

		return suite;
	}

}
