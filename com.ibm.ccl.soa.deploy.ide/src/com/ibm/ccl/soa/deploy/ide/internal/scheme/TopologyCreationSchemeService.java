/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.scheme;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nmakin
 * 
 */
public class TopologyCreationSchemeService {
	public static TopologyCreationSchemeService INSTANCE = new TopologyCreationSchemeService();
	private Map topologyCreationSchemesMap = null;

	public Collection getTopologyCreationSchemesList() {
		return getTopologyCreationSchemesMap().values();
	}

	/**
	 * The map of all the schemes by name
	 * 
	 * @return the name to scheme map
	 */
	public Map getTopologyCreationSchemesMap() {
		if (topologyCreationSchemesMap == null) {
			topologyCreationSchemesMap = new HashMap();
			TopologyCreationScheme scheme = new NoTopologyCreationScheme();
			topologyCreationSchemesMap.put(scheme.getName(), scheme);
			scheme = new SimpleTopologyCreationScheme();
			topologyCreationSchemesMap.put(scheme.getName(), scheme);
		}
		return topologyCreationSchemesMap;
	}

	/**
	 * find the scheme by name
	 * 
	 * @param name
	 *           a String name of the scheme
	 * @return the scheme object
	 */
	public TopologyCreationScheme findScheme(String name) {
		return (TopologyCreationScheme) getTopologyCreationSchemesMap().get(name);
	}

}
