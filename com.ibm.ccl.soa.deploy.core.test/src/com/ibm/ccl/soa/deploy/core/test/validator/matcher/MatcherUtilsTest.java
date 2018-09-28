/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.matcher;

import java.io.IOException;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.MatcherUtils;

public class MatcherUtilsTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "MatcherUtilsTest";

	public MatcherUtilsTest() {
		super(PROJECT_NAME);
	}

	public MatcherUtilsTest(String name) {
		super(name);
	}

	public void testMatcherUtils() throws IOException {
		Topology top = createTopology("testMatcherUtils");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		System.out.println(MatcherUtils.getHostedConfigurationUnits(unit1)
				.size());
		assert MatcherUtils.getHostedConfigurationUnits(unit1).size() == 0;

		Unit cu1 = createConfigurationUnit();
		cu1.setConfigurationUnit(true);
		cu1.setName("cu1");
		top.getUnits().add(cu1);

// LinkDescriptor d = new LinkDescriptor(LinkDescriptor.HOSTING, unit1, cu1);
// d.create();
		LinkFactory.createHostingLink(unit1, cu1);

		assert MatcherUtils.getHostedConfigurationUnits(unit1).size() == 1;
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu1);

		Unit cu2 = createConfigurationUnit();
		cu2.setConfigurationUnit(true);
		cu2.setName("cu2");
		top.getUnits().add(cu2);

// d = new LinkDescriptor(LinkDescriptor.HOSTING, unit1, cu2);
// d.create();
		LinkFactory.createHostingLink(unit1, cu2);

		assert MatcherUtils.getHostedConfigurationUnits(unit1).size() == 2;
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu1);
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu2);

		assert MatcherUtils.getHostedConfigurationUnits(cu1).size() == 0;

		Unit cu1_1 = createConfigurationUnit();
		cu1_1.setConfigurationUnit(true);
		cu1.setName("cu1_1");
		top.getUnits().add(cu1_1);

// d = new LinkDescriptor(LinkDescriptor.HOSTING, cu1, cu1_1);
// d.create();
		LinkFactory.createHostingLink(cu1, cu1_1);

		assert MatcherUtils.getHostedConfigurationUnits(unit1).size() == 3;
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu1);
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu2);
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu1_1);

		assert MatcherUtils.getHostedConfigurationUnits(cu1).size() == 1;
		assert MatcherUtils.getHostedConfigurationUnits(cu1).contains(cu1_1);

		assert MatcherUtils.getHostedConfigurationUnits(cu1_1).size() == 0;

		Unit cu1_1_1 = createConfigurationUnit();
		cu1_1_1.setConfigurationUnit(true);
		cu1.setName("cu1_1_1");
		top.getUnits().add(cu1_1_1);

// d = new LinkDescriptor(LinkDescriptor.HOSTING, cu1_1, cu1_1_1);
// d.create();
		LinkFactory.createHostingLink(cu1_1, cu1_1_1);

		assert MatcherUtils.getHostedConfigurationUnits(unit1).size() == 4;
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu1);
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu2);
		assert MatcherUtils.getHostedConfigurationUnits(unit1).contains(cu1_1);
		assert MatcherUtils.getHostedConfigurationUnits(unit1)
				.contains(cu1_1_1);

		assert MatcherUtils.getHostedConfigurationUnits(cu1).size() == 2;
		assert MatcherUtils.getHostedConfigurationUnits(cu1).contains(cu1_1);
		assert MatcherUtils.getHostedConfigurationUnits(cu1).contains(cu1_1_1);

		assert MatcherUtils.getHostedConfigurationUnits(cu1_1).size() == 1;
		assert MatcherUtils.getHostedConfigurationUnits(cu1_1)
				.contains(cu1_1_1);
	}

	private static Unit createConfigurationUnit() {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setConfigurationUnit(true);
		return unit;
	}

}
