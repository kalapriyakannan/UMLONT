/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension.discoverer;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;

/**
 * 
 * @since 1.0
 * 
 */
public class UnitDescriptorImpl extends UnitDescriptor {

	private String myUnitId = "testEarUnitId";

	protected String createDescriptorName() {

		return "myEARId1";
	}

	protected Unit getUnit() {
		// discover the unit from underlying resources
		// and create an instance of topology unit from that
		// Create test ear module
		EarModule earMod = J2eeFactory.eINSTANCE.createEarModule();
		earMod.setName("TestEAR");
		return earMod;
	}

	/**
	 * 
	 * @return String
	 */
	public String getMyUnitId() {
		return myUnitId;
	}

	/**
	 * 
	 * @param myUnitId
	 */
	public void setMyUnitId(String myUnitId) {
		this.myUnitId = myUnitId;
	}

	protected String createDisplayName() {
		return "testEarUnitDisplayName";
	}

	protected Unit getUnitAndAddToTopology(Topology topology) {
		Unit unit = getUnit();
		topology.getUnits().add(getUnit());
		return unit;
	}

	public boolean referencesUnit(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean referencesUnit(UnitDescriptor descriptor) {
		// TODO Auto-generated method stub
		return false;
	}

}
