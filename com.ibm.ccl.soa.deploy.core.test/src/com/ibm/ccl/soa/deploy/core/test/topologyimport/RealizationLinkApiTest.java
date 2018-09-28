/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.topologyimport;

import java.io.IOException;
import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

public class RealizationLinkApiTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "RealizationLinkApiTest";

	public RealizationLinkApiTest() {
		super(PROJECT_NAME);
	}

	public RealizationLinkApiTest(String name) {
		super(name);
	}

	public void testRealizationLinkApi() throws IOException {
		Topology top = createTopology("testRealizationLinkApi");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		unit1.setConceptual(true);
		top.getUnits().add(unit1);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		assert 0 == top.getRealizationLinks().size();

		RealizationLink rLink = LinkFactory.createRealizationLink(unit1, unit2);

		assert 1 == top.getRealizationLinks().size();

		int numRL = 0;
		for (Iterator it = unit1.getEditTopology().findAllRealizationLinks(); it
				.hasNext();) {
			it.next();
			numRL++;
		}
		assert 1 == numRL;

	}
}
