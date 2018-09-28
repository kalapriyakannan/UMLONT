/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.test;

import junit.framework.Test;
import junit.framework.TestSuite;


public class CMDBTestSuite extends TestSuite {

	public CMDBTestSuite(String name) {
		super(name);
	}
	
	public static Test suite() {
		TestSuite suite = new CMDBTestSuite( "CMDB extensions tests" );
		suite.addTestSuite( Trade6WASDB2StacksFromCMDBProviderTest.class );
		suite.addTestSuite( CMDBQueryServiceTests.class );
		suite.addTestSuite( CMDBAPITests.class );
		suite.addTestSuite( CMDBAPIFindRelationshipsTestCase.class );
		return suite;
	}
}
