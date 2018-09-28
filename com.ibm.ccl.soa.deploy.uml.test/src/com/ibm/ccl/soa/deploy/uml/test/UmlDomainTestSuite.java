/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.uml.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class UmlDomainTestSuite extends TestSuite {

	public UmlDomainTestSuite(String name) {
		super(name);
	}
	
	public static Test suite() {
		TestSuite suite = new UmlDomainTestSuite( "UML Domain Tests" );
		suite.addTestSuite( UMLDomainTest.class );		
		suite.addTestSuite( UMLProviderTest.class );
		suite.addTestSuite( UMLCapProviderTest.class );
		suite.addTestSuite( UmlInteractionConstraintTest.class );
		suite.addTestSuite( UmlWorkspaceTest.class );
		suite.addTestSuite(UMLDomainUnitFilterTest.class);
		return suite;
	}
}
