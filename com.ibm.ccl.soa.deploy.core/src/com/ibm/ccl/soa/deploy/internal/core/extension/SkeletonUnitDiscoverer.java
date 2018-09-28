/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.core.UnitFilter;

/**
 * Provides a default implementation of {@link UnitFilter} that can be returned when clients provide
 * unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.unitLifecycle</b>.
 * 
 * @since 1.0
 * @see UnitFilter
 * 
 */
public class SkeletonUnitDiscoverer extends UnitDiscoverer {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonUnitDiscoverer INSTANCE = new SkeletonUnitDiscoverer();

	private SkeletonUnitDiscoverer() {
	}

	public boolean canDiscover(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		return false;
	}

	public List findAll(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
