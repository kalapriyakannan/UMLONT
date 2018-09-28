/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

public class StereotypeTest extends TopologyTestCase {

	public StereotypeTest() {
		super("StereotypeTest");
		setDeleteProjectOnTearDown(false);
	}
	
	

	public void testStereotypes() throws Exception {
		Topology top = createTopology("testStereotype");

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);
		Stereotype unitSt1 = CoreFactory.eINSTANCE.createStereotype();
		unitSt1.setKeyword("service");
		unitSt1.setProfile("serviceProfile");
		unitSt1.setRequired(true);
		u1.getStereotypes().add(unitSt1);
		
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap1");
		u1.getCapabilities().add(cap);
		Stereotype capSt1 = CoreFactory.eINSTANCE.createStereotype();
		capSt1.setKeyword("serviceCap");
		capSt1.setProfile("serviceCapProfile");
		capSt1.setRequired(true);
		cap.getStereotypes().add(capSt1);
		
		Stereotype st = CoreFactory.eINSTANCE.createStereotype();
		
		//
		// Serialization
		// 
		top = reload(top, true);
		u1 = (Unit) top.resolve("u1");
		assert u1 != null;
		assert u1.getStereotypes().size() == 1;
		unitSt1 = (Stereotype)u1.getStereotypes().get(0);
		assert unitSt1 != null;
		
		assert u1.getCapabilities().size() == 1;
		cap = (Capability) u1.getCapabilities().get(0);
		assert cap != null;
		assert cap.getStereotypes().size() == 1;
		capSt1 = (Stereotype)cap.getStereotypes().get(0);
		assert capSt1 != null;

	}


}
