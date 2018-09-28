/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

/**
 * Tests the use of {@link AttributeMetadata#isParameter()} to control undefined
 * attribute errors in templates.
 */
public class TopologyTemplateTest extends TopologyTestCase {

	/**
	 * Construct a topology template test project.
	 */
	public TopologyTemplateTest() {
		super("TopologyTemplateTest");
	}

	/**
	 * Tests the use of {@link AttributeMetadata#isParameter()} to control
	 * undefined attribute errors in templates.
	 * 
	 * @throws Exception
	 */
	public void testAttributeParameter() throws Exception {
		Topology top = createTopology("testAttributeParameter");

		// set deploy decorator semantic
		// os on sysem
		// set up hostname and password
		// validate no error

		// set template decorator semantic
		// unset hostname
		// assert has error

		// mark parameter
		// assert has no error

		// set hostname, unset parameter
		// add db2 system + db2 instance
		// set db2 instance hostname
		// assert db2 instance has hostname undefined
		// resolve hostname
		// assert has no errors

		// unset os hostname
		// unset db2 instace hostname
		// mark hostname as parameter
		// make sure tha there is no error marker on OS hostname or DB2 instance
		// hostname
	}
}
