/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @since 1.0
 * 
 */
public class ScenarioTestSuite extends TestSuite {

	/**
	 * @param name
	 */
	public ScenarioTestSuite(String name) {
		super(name);
	}

	/**
	 * @return suite
	 */
	public static Test suite() {
		TestSuite suite = new ScenarioTestSuite("Scenario tests - headless");
		suite.addTestSuite(PlantsByWebsphereFromTemplatesTest.class);
		// Broken ATM
// suite.addTestSuite(TwoWebsphereApplicationServersFromTemplatesTest.class);
		suite.addTestSuite(Trade6FromTemplatesTest.class);
		suite.addTestSuite(TemplatesTest.class);
		suite.addTestSuite(TemplatesConstantsTest.class);
		suite.addTestSuite(SetRealizationsTest.class);
		suite.addTestSuite(SetRealizationsTestWithCollocationConstraints.class);
		suite.addTestSuite(ContractsValidationTests.class);
		suite.addTestSuite(ClusterRealizationsTest.class);
		suite.addTestSuite(AutoRealizationTests.class);
		suite.addTestSuite(GenericRequirementSatisfactionTests.class);
		return suite;
	}
}
