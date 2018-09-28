/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

/**
 * Provides the interface for client extensions to provide a discoverer for topology artifacts.
 * Clients who extend <b>com.ibm.ccl.soa.deploy.core.topology/discoverer</b> must extend this
 * class.
 * 
 * @since 1.0
 * 
 */
public abstract class TopologyDiscoverer {

	/**
	 * This implementation of this method should specify whether the discovery provider is capable of
	 * serving the request based on the contents set in the filter.
	 * 
	 * @param filter
	 *           the input filter instance that has the filter crtiteria.
	 * @return true, if the provider can fulfill the criteria.
	 * 
	 */
	public abstract boolean canDiscover(DiscoveryFilter filter);

	/**
	 * The implementation of this method should return a list of the unit decriptors based on the
	 * discovery criteria.
	 * 
	 * @param filter
	 *           the input filter instance that has the filter crtiteria.
	 * @return the list of UnitDescriptor based on the matching criteria.
	 * @see UnitDescriptor
	 */
	public abstract List<UnitDescriptor> findAll(DiscoveryFilter filter);

	/**
	 * Determines if two units are the "same" unit. Two units are the same if they would be
	 * represented by the same {@link Unit} in the same {@link Topology}. The units compared need
	 * not be in the same {@link Topology}.
	 * 
	 * @param unit1
	 *           one unit
	 * @param unit2
	 *           the other unit
	 * @return true if the units are the same unit; false if not or if not determinable
	 */
	public abstract boolean isDiscoveredUnitSame(Unit unit1, Unit unit2);
}
