/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.operation;

import org.eclipse.wst.common.frameworks.datamodel.IDataModelProperties;

public interface IAssetDiscoveryDataModelProperties extends IDataModelProperties {

	String ASSET_DISCOVERY_SELECTED_ITEM = "IAssetDiscoveryDataModelProperties.SELECTED_ITEM"; //$NON-NLS-1$;

	String ASSET_DISCOVERY_RUNTIME = "IAssetDiscoveryDataModelProperties.RUNTIME"; //$NON-NLS-1$;

	String ASSET_DISCOVERY_RUNTIME_LOCATION = "IAssetDiscoveryDataModelProperties.RUNTIME_LOCATION"; //$NON-NLS-1$;
}
