/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import org.eclipse.wst.common.frameworks.datamodel.IDataModelProperties;

/**
 * Properties to create the topology model.
 * 
 */
public interface ITopologyDiscoveryProperties extends IDataModelProperties {

	/**
	 * The list of selected units on which the discovery needs to be done
	 */
	public static String SELECTED_ITEMS = "ITopologyDiscoveryProperties.SELECTED_ITEMS"; //$NON-NLS-1$;

	/**
	 * expand search out of current topology
	 */
	public static String EXPAND_SEARCH = "ITopologyDiscoveryProperties.EXPAND_SEARCH"; //$NON-NLS-1$;

	/**
	 * The list of units that are created after the discovery
	 */
	public static String CREATED_UNITS = "ITopologyDiscoveryProperties.CREATED_UNITS"; //$NON-NLS-1$;

	/**
	 * The map of unit to possible unit descriptors that are created after the discovery
	 */
	public static String POSSIBLE_UNIT_DESCRIPTORS = "ITopologyDiscoveryProperties.POSSIBLE_UNIT_DESCRIPTORS"; //$NON-NLS-1$;

	/**
	 * The map of unit to selected unit descriptor list
	 */
	public static String SELECTED_UNIT_DESCRIPTORS = "ITopologyDiscoveryProperties.SELECTED_UNIT_DESCRIPTORS"; //$NON-NLS-1$;

	/**
	 * boolean value to create the find host filter
	 */
	public static String IS_CREATE_FIND_HOST_FILTER = "ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER"; //$NON-NLS-1$;

	/**
	 * boolean value to create the find dependencies filter
	 */
	public static String IS_CREATE_FIND_DEPENDENCIES_FILTER = "ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER"; //$NON-NLS-1$;

	/**
	 * boolean value to select discovery type
	 */
	public static String HAVE_SELECT_DISCOVERY_TYPE = "ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE"; //$NON-NLS-1$;

	/**
	 * Topology resource
	 */
	public static String TOPOLOGY_FILE = "ITopologyDiscoveryProperties.TOPOLOGY_FILE"; //$NON-NLS-1$;
}
