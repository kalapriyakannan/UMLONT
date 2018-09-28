/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.all.master;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.core.test.DeployCoreModelSuite;
import com.ibm.ccl.soa.deploy.db2.test.DB2ModelSuite;
import com.ibm.ccl.soa.deploy.generic.test.GenericModelSuite;
import com.ibm.ccl.soa.deploy.ide.tests.refactoring.RefactoringTestSuite;
import com.ibm.ccl.soa.deploy.index.tests.IndexTestSuite;
import com.ibm.ccl.soa.deploy.ldap.test.LdapModelSuite;
import com.ibm.ccl.soa.deploy.os.test.OsModelSuite;
import com.ibm.ccl.soa.deploy.tests.CrossDomainTestSuite;
import com.ibm.ccl.soa.deploy.tests.TopologyTestSuite;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestSuite;
import com.ibm.ccl.soa.deploy.tests.extension.ExtensionTestSuite;
import com.ibm.ccl.soa.deploy.tests.location.LocationTestSuite;
import com.ibm.ccl.soa.deploy.tests.scenarios.ScenarioTestSuite;
import com.ibm.ccl.soa.deploy.was.test.WebsphereTestSuite;

public class SwamiTestSuite extends TestSuite {

	// This test suite should be run/passed for:
	// model changes
	// smoke test validation
	// refactoring...

	public SwamiTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new SwamiTestSuite("Deploy tooling master suite"); //$NON-NLS-1$
		suite.addTest(LocationTestSuite.suite());
		// com.ibm.ccl.soa.deploy.core.test
		suite.addTest(DeployCoreModelSuite.suite());
		
		// com.ibm.ccl.soa.deploy.index.tests
		suite.addTest(IndexTestSuite.suite());
		
		// com.ibm.ccl.soa.deploy.generic.test
		// TODO determine if this is in the build
        suite.addTest(GenericModelSuite.suite());
		// com.ibm.ccl.soa.deploy.was.test
		suite.addTest(WebsphereTestSuite.suite());
		suite.addTest(DB2ModelSuite.suite());
		suite.addTest(LdapModelSuite.suite());
		suite.addTest(OsModelSuite.suite());

		//
		suite.addTest(ScenarioTestSuite.suite());

		// com.ibm.ccl.soa.deploy.tests.extension
		suite.addTest(ExtensionTestSuite.suite());
		suite.addTest(TopologyTestSuite.suite());

		// Test domain extensions
		suite.addTest(DomainTestSuite.suite());

		// Cross Domain Tests of Various Kinds
		// com.ibm.ccl.soa.deploy.tests
		suite.addTest(CrossDomainTestSuite.suite());

		// com.ibm.ccl.soa.deploy.tests
		//suite.addTest(AnalysisTestSuite.suite());
		
		// com.ibm.ccl.soa.deploy.ide.tests.refactoring
		// commenting out b/c the MoveResourcesOperation is used by the refactorings
		// and will causes errors sense it relies on code from org.eclipse.ui.undo
		// Refactoring tests are included in the IdeTestSuite anyway
//		suite.addTest(RefactoringTestSuite.suite());

		
		return suite;
	}

}

