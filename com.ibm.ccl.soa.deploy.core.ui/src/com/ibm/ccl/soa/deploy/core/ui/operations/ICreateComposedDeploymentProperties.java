/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * A generic property set for operations that create deployment model files.
 * <p>
 * This class has not been published as API so long as this comment is present.
 * </p>
 */
public interface ICreateComposedDeploymentProperties extends IAbstractScribblerDataModelProperties {
	/**
	 * Combined operation properties
	 */
	String CREATE_COMPOSED_DEPLOYMENT_DATAMODEL_PROVIDER = "CreateComposedDeploymentTopologyProvider"; //$NON-NLS-1$	
	/**
	 * properties to create the topology model
	 */
	String CREATE_DEPLOYMENT_DATAMODEL_PROVIDER = "CreateDeploymentTopology"; //$NON-NLS-1$
	/**
	 * properties to create the diagram
	 */
	String CREATE_DEPLOYMENT_VIZUALIZATION_PROVIDER = "CreateDeploymentVisualization"; //$NON-NLS-1$	

}
