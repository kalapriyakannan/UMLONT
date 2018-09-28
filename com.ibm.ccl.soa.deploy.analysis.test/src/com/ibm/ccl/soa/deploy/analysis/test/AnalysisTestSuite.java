/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AnalysisTestSuite extends TestSuite {

	public AnalysisTestSuite(String name) {
		super(name);
	}
	
	public static Test suite() {
		TestSuite suite = new AnalysisTestSuite( "Analysis Domain Tests" );
		suite.addTestSuite( AnalysisDomainTest.class );
		suite.addTestSuite( AnalysisDomainUMLIntegrationTest.class );		
		suite.addTestSuite( AnalysisDomainUnitFilterTest.class );	
		suite.addTestSuite( AnalysisSemanticTest.class );	
		suite.addTestSuite( AnalysisConstraintTest.class );	
		suite.addTestSuite( AnalysisValidationTest.class );	
		return suite;
	}
}
