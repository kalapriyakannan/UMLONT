/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.discoverer;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;

/**
 * Interface defnition for a filter defined on the results of a call to a
 * {@link TopologyDiscovererService#findAll(com.ibm.ccl.soa.deploy.core.DiscoveryFilter)}.
 */
public interface IDiscoveryResultFilter {

	/**
	 * Method that selects a subset of {@link UnitDescriptor}.
	 * 
	 * @param unitDescriptors
	 *           list of unit descriptors
	 * @return subset of list of unit descriptors
	 */
	public List select(List unitDescriptors);

}
