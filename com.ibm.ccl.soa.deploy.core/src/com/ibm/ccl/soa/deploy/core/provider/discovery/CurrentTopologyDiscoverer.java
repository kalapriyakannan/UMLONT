/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider.discovery;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * Discoverer for a topology.
 */
public class CurrentTopologyDiscoverer extends TopologyTopologyDiscoverer {

	public Topology getTopology() {
		return topology;
	}

	public boolean canDiscover(DiscoveryFilter filter) {
		if (null == filter)
			return false;
		if (null == filter.getTopology())
			return false;

		// set the topology to the current topology
		setTopology(filter.getTopology());

		return super.canDiscover(filter);
	}

	public List findAll(DiscoveryFilter filter) {
		if (null == filter) {
			return new ArrayList();
		}
		// set topology to current topology
		setTopology(filter.getTopology());

		// do the search
		return super.findAll(filter);
	}

}
