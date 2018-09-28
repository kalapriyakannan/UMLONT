/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.db2.test.DB2ModelSuite;
import com.ibm.ccl.soa.deploy.ide.tests.domains.IdeDomainTestSuite;
import com.ibm.ccl.soa.deploy.ide.tests.refactoring.MoveTopologyRefactoringTests;
import com.ibm.ccl.soa.deploy.ide.tests.refactoring.MoveUnitsRefactoringTests;
import com.ibm.ccl.soa.deploy.ide.tests.refactoring.RenameTopologyRefactoringTests;
import com.ibm.ccl.soa.deploy.ldap.test.LdapModelSuite;
import com.ibm.ccl.soa.deploy.tests.CrossDomainTestSuite;
import com.ibm.ccl.soa.deploy.tests.TopologyTestSuite;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestSuite;
import com.ibm.ccl.soa.deploy.tests.extension.ExtensionTestSuite;
import com.ibm.ccl.soa.deploy.tests.location.LocationTestSuite;
import com.ibm.ccl.soa.deploy.tests.scenarios.ScenarioTestSuite;
import com.ibm.ccl.soa.deploy.was.test.WebsphereTestSuite;

public class IdeTestSuite extends TestSuite {

	// This test suite should be run/passed for:
	// model changes
	// smoke test validation
	// refactoring...

	public IdeTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new IdeTestSuite("Deploy tooling IDE suite"); //$NON-NLS-1$

		// IDE domains test
		// XXXX ;
		// IDE publisher test
		// TODO OPen Up: suite.addTest( ProviderTestSuite.suite() );

		suite.addTest(IdeDomainTestSuite.suite());
		
		
		//core test:
		
		suite.addTest(LocationTestSuite.suite());
		// com.ibm.ccl.soa.deploy.core.test
		//suite.addTest(DeployCoreModelSuite.suite());
		// com.ibm.ccl.soa.deploy.generic.test
		// TODO determine if this is in the build
        // suite.addTest(GenericModelSuite.suite());
		// com.ibm.ccl.soa.deploy.was.test
		suite.addTest(WebsphereTestSuite.suite());
		suite.addTest(DB2ModelSuite.suite());
		suite.addTest(LdapModelSuite.suite());
	//	suite.addTest(OsModelSuite.suite());

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
		
		
		
		// Commenting out all other domains until junits are working again in the build
		 /*
		suite.addTest(ProviderTestSuite.suite());
		suite.addTest(DiscovererTestSuite.suite());
		suite.addTest(ExporterTestSuite.suite());
		suite.addTest(IdeDomainTestSuite.suite());
		suite.addTest(IdeBatDsTestSuite.suite());
		suite.addTest(IdeDatabaseTestSuite.suite());
		suite.addTest(J2EEIDETestSuite.suite());
		*/
		
		// These 3 were already commented out
		// suite.addTest(SchemeTestSuite.suite());
		// suite.addTest(CreationTestSuite.suite());
		// suite.addTest(DeletionTestSuite.suite());
		

		// Refactoring tests
		suite.addTestSuite(MoveTopologyRefactoringTests.class);
		suite.addTestSuite(RenameTopologyRefactoringTests.class);
		suite.addTestSuite(MoveUnitsRefactoringTests.class);
		return suite;
	}

}
