/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.SessionService;

/**
 * NOTE THIS TEST IS NOT PART OF THE WEBSPHERE SUITE (YET).
 * 
 * @author snible@us.ibm.com
 */
public class J2eeServiceTest extends TopologyTestCase {

	/**
	 * 
	 */
	public J2eeServiceTest() {
		super("J2eeServiceTest");
	}

	/**
	 * @throws Exception
	 */
	public void testAddingServices() throws Exception {
		Topology top = createTopology("testHostingLink", true);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		EntityService es = J2eeFactory.eINSTANCE.createEntityService();
		es.setName("es");
		unit.getCapabilities().add(es);

		SessionService ss = J2eeFactory.eINSTANCE.createSessionService();
		ss.setName("ss");
		unit.getCapabilities().add(ss);

		EnterpriseBeanService ebs = J2eeFactory.eINSTANCE
				.createEnterpriseBeanService();
		ebs.setName("ebs");

		// This line causes an NPE in FeatureMapUtil.isFeatureMap(); why?
		unit.getCapabilities().add(ebs);
	}
}
