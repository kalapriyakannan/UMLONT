/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.j2ee;

import java.io.IOException;

import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;

/**
 * Tests {@link EarModule}
 */
public class J2eeModuleCapabilityTest extends TopologyTestCase {

	public J2eeModuleCapabilityTest() {
		super("EarModuleTest");
	}

	/**
	 * Test to show that there is something special about the
	 * J2eeModuleCapability failure.
	 */
	public void testDB2Database() throws IOException {
		Topology top = createTopology("testDB2Database");

		DB2DatabaseUnit dbUnit = Db2Factory.eINSTANCE.createDB2DatabaseUnit();
		dbUnit.setName("dbUnit");
		addRequirement(dbUnit, "members", RequirementLinkTypes.MEMBER_LITERAL);
		top.getUnits().add(dbUnit);

		// Save to prevent NPE which masks the error
		top.eResource().save(null);

		DB2Database db = Db2Factory.eINSTANCE.createDB2Database();
		db.setName("db");
		dbUnit.getCapabilities().add(db);
	}

	/**
	 * Test the addition of a J2EE module capability into an EAR module.
	 */
	public void testJ2eeModuleCapability() throws IOException {
		Topology top = createTopology("testJ2eeModuleCapability");

		EarModule earUnit = J2eeFactory.eINSTANCE.createEarModule();
		earUnit.setName("earUnit");
		addRequirement(earUnit, "members", RequirementLinkTypes.MEMBER_LITERAL);
		top.getUnits().add(earUnit);

		// Save to prevent NPE which masks the error
		top.eResource().save(null);

		J2EEModuleCapability earModule = J2eeFactory.eINSTANCE
				.createJ2EEModuleCapability();
		earModule.setName("earModule");
		earUnit.getCapabilities().add(earModule);
	}
}
