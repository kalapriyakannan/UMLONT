/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.discoverer;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * A test to determine whether or not to keep the result of a discovery.
 */
public interface IDiscoveryResultFilterTest {

	/**
	 * Check if a particular unit satisfies the filter test.
	 * 
	 * @param unit
	 *           the unit to test
	 * @return true if the unit passes the test; false otherwise
	 */
	public boolean isUnitOK(Unit unit);
}
