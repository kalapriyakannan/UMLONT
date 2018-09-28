/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension.discoverer;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;

/**
 * Provides a default test implementation of UnitProvider
 * 
 * @since 1.0
 * 
 */
public class TestUnitDiscoverer extends UnitDiscoverer {

	public boolean canDiscover(DiscoveryFilter filter) {
		if (filter.getUnit() instanceof EarModule)
			return true;
		return false;
	}

	public List findAll(DiscoveryFilter filter) {
		UnitDescriptorImpl unitDesc = new UnitDescriptorImpl();
		unitDesc.setMyUnitId("myEARId1");
		List retValue = new ArrayList();
		retValue.add(unitDesc);
		return retValue;
	}

}
