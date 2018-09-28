/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

/**
 * Creates implementations of {@link TopologyCache}.
 * 
 * @since 1.0
 * 
 */
public class TopologyCacheFactory {

	/**
	 * 
	 * @return An implementation of {@link TopologyCache} that can be used to contain model
	 *         constructs for publishing
	 */
	public static TopologyCache createTopologyCache() {
		return new TopologyCache();
	}
}
