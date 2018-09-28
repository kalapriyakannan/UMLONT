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
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides a default implementation of {@link TopologyExporter} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.topology/exporter</b>.
 * 
 * @since 1.0
 * @see TopologyExporter
 * 
 */
public class SkeletonTopologyDiscoverer extends TopologyDiscoverer {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonTopologyDiscoverer INSTANCE = new SkeletonTopologyDiscoverer();

	private SkeletonTopologyDiscoverer() {
	}

	public boolean canDiscover(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		return false;
	}

	public List findAll(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDiscoveredUnitSame(Unit unit1, Unit unit2) {
		// TODO Auto-generated method stub
		return unit1 == unit2;
	}

}
