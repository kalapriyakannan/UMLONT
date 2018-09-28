/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.ldap.test.validator.LdapDomainValidatorTest;
import com.ibm.ccl.soa.deploy.ldap.test.validator.LdapSecurityRoleReferenceValidatorTest;
import com.ibm.ccl.soa.deploy.ldap.test.validator.LdapSuffixUnitValidatorTest;
import com.ibm.ccl.soa.deploy.ldap.test.validator.LdapServerUnitValidatorTest;

public class LdapModelSuite extends TestSuite {

	public LdapModelSuite() {
		super();
	}

	public LdapModelSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new LdapModelSuite(
				"SOA Deploy LdapServer Model test suite."); //$NON-NLS-1$

		suite.addTestSuite(LdapDomainValidatorTest.class);
		suite.addTestSuite(LdapServerUnitValidatorTest.class);
		suite.addTestSuite(LdapSecurityRoleReferenceValidatorTest.class);
		suite.addTestSuite(LdapSuffixUnitValidatorTest.class);

		return suite;
	}

}
