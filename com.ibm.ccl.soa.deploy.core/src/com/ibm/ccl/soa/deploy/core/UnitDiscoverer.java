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
 * Provide information about elements that may be hosted by this unit.
 * <p>
 * Any element is potentially deployable. Clients must describe to the SOA Topology Modeler
 * framework which elements may be deployed using the
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitDiscoverer</b> extension point. That extension
 * point requires clients to supply a subclass of this object. The client implementation will only
 * be invoked when an element matching the expression defined by the client's extension is
 * encountered.
 * </p>
 * <p>
 * Please refer to the extension point documentation for
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitDiscoverer</b> for more information.
 * </p>
 * 
 * 
 * @since 1.0
 * 
 */
public abstract class UnitDiscoverer {

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
	public abstract List findAll(DiscoveryFilter filter);
}
