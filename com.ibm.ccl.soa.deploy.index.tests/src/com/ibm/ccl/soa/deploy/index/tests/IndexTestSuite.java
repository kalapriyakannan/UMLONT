package com.ibm.ccl.soa.deploy.index.tests;


import com.ibm.ccl.soa.deploy.index.tests.emf.index.xml.providers.ZDMEModelIndexTests;
import com.ibm.ccl.soa.deploy.index.tests.search.QueryTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class IndexTestSuite extends TestSuite {

	public IndexTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new IndexTestSuite("Deploy Indexing Test Suite"); //$NON-NLS-1$
		

		// Indexing tests
		suite.addTestSuite(ZDMEModelIndexTests.class);
		suite.addTestSuite(QueryTest.class);
		return suite;
	}
}
