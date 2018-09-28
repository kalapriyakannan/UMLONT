/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.operation;

import org.eclipse.wst.common.frameworks.datamodel.IDataModelProperties;

/**
 * Properties to create the topology model.
 * 
 */
public interface RCTCreateTopologyExtensionProperties extends IDataModelProperties {

	String DEPLOYABLE_SELECTED_ITEMS = "ITopologyDiscoveryProperties.SELECTED_ITEMS"; //$NON-NLS-1$;

	String CREATED_UNITS = "ITopologyDiscoveryProperties.CREATED_UNITS"; //$NON-NLS-1$;

	String TOPOLOGY_CREATION_SCHEME = "ITopologyDiscoveryProperties.TOPOLOGY_CREATION_SCHEME"; //$NON-NLS-1$;

	String DEPLOYABLE_SELECTED_SERVERS = "ITopologyDiscoveryProperties.SELECTED_SERVERS";//$NON-NLS-1$
	/**
	 * properties to create the diagram
	 */
	String CREATE_RCT_CREATE_TOPOLOGY_EXTENSION_PROVIDER = "RCTCreateTopologyExtensionModel"; //$NON-NLS-1$	
}
