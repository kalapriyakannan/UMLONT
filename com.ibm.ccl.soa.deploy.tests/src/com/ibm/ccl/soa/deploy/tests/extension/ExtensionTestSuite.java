/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.tests.apps.PlantsEarToDatabaseLogicalLinkTests;
import com.ibm.ccl.soa.deploy.tests.communication.ApplicationCommunicationConstraintTest;
import com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution.ResolutionTestSuite;
import com.ibm.ccl.soa.deploy.tests.extension.discoverer.TopologyDiscovererTests;
import com.ibm.ccl.soa.deploy.tests.j2ee.J2eeTestSuite;

/**
 * A test suite for the extension point managers from
 * <b>com.ibm.ccl.soa.deploy.core</b>
 * 
 * @since 1.0
 * 
 */
public class ExtensionTestSuite extends TestSuite {

	/**
	 * A default constructor
	 * 
	 * @param name
	 */
	public ExtensionTestSuite(String name) {
		super(name);
	}

	/**
	 * 
	 * @return A suite of tests from the containing package.
	 */
	public static Test suite() {
		TestSuite suite = new ExtensionTestSuite(
				"SOA Topology Modeler ExtensionMgmt Tests");

		// J2EE & Resolution tests
		// TODO move to master project test suite
		suite.addTest(ResolutionTestSuite.suite());
		suite.addTest(J2eeTestSuite.suite());

		// Extension tests
		suite.addTestSuite(EncServiceTests.class);
		suite.addTestSuite(UnitProviderTests.class);
		suite.addTestSuite(TopologyPublisherTests.class);
		suite.addTestSuite(TopologyExporterTests.class);
		suite.addTestSuite(TopologyDiscovererTests.class);

		// Application tests
		suite.addTestSuite(PlantsEarToDatabaseLogicalLinkTests.class);

		// Decorator Semantic tests
		suite.addTestSuite(DecoratorSemanticTests.class);
		suite.addTestSuite(DecoratorSemanticBindingRuleTests.class);

		// Resource type tests
		suite.addTestSuite(ResourceTypeTests.class);
		suite.addTestSuite(DynamicResourceTypeTests.class);
		
		// Communication Constraint tests
		suite.addTestSuite(ApplicationCommunicationConstraintTest.class);

		return suite;
	}
}
