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
public interface ICreateDeploymentVisualizationProperties extends
		IAbstractScribblerDataModelProperties {

	/**
	 * The name of the topology file.
	 */
	String DEPLOYMENT_TOPOLOGY_FILENAME = "ICreateDeploymentVisualizationProperties.FILE_NAME"; //$NON-NLS-1$
	/**
	 * The name of the topology plan
	 */
	String DEPLOYMENT_PLAN_NAME = "ICreateDeploymentVisualizationProperties.DEPLOYMENT_PLAN_NAME"; //$NON-NLS-1$;
	/**
	 * The name of the topology folder
	 */
	String DEPLOYMENT_FOLDER = "ICreateDeploymentVisualizationProperties.DEPLOYMENT_FOLDER"; //$NON-NLS-1$;
	/**
	 * Contains the created topology model passed from semantic operation to this operation.
	 */
	String DEPLOYMENT_PLAN_MODEL = "ICreateDeploymentVisualizationProperties.DEPLOYMENT_PLAN_MODEL"; //$NON-NLS-1$;
}
