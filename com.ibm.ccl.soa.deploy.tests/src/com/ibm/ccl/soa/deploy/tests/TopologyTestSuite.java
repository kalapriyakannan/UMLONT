/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.tests.core.imports.ExtensionDomainImportTest;
import com.ibm.ccl.soa.deploy.tests.core.validator.SyntheticGlobalDomainValidatorTest;
import com.ibm.ccl.soa.deploy.tests.core.validator.resolution.ChangeVisibilityResolutionTest;

public class TopologyTestSuite extends TestSuite {
	/**
	 * name of suite
	 */
	public TopologyTestSuite(String name) {
		super(name);
	}

	/**
	 * defined junits
	 */
	public static Test suite() {
		TestSuite suite = new TopologyTestSuite("Deploy modeling tests");

		suite.addTestSuite(SyntheticGlobalDomainValidatorTest.class);
		suite.addTestSuite(TopologyTemplateTest.class);
		suite.addTestSuite(ExtensionDomainImportTest.class);
		suite.addTestSuite(ChangeVisibilityResolutionTest.class);
		
		

		return suite;
	}
}
