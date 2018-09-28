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
 * Properties to create the topology model.
 * 
 */
public interface ICreateDeploymentTopologyProperties extends IAbstractScribblerDataModelProperties {
	/**
	 * The topology name
	 */
	String DEPLOYMENT_PLAN_NAME = "ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_NAME"; //$NON-NLS-1$;
	/**
	 * The topology project that it lives in
	 */
	String DEPLOYMENT_PROJECT_NAME = "ICreateDeploymentTopologyProperties.DEPLOYMENT_PROJECT_NAME"; //$NON-NLS-1$;
	/**
	 * The topology description
	 */
	String DEPLOYMENT_DESCRIPTION = "ICreateDeploymentTopologyProperties.DEPLOYMENT_DESCRIPTION"; //$NON-NLS-1$;
	/**
	 * the folder within the project
	 */
	String DEPLOYMENT_FOLDER = "ICreateDeploymentTopologyProperties.DEPLOYMENT_FOLDER"; //$NON-NLS-1$;	
	/**
	 * The created topology model-- to be passed to the visual operation to create diagram
	 */
	String DEPLOYMENT_PLAN_RESULT = "ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_RESULT"; //$NON-NLS-1$;

	/**
	 * The selections in the navigator
	 */
	String DEPLOYABLE_SELECTIONS = "ICreateDeploymentTopologyProperties.DEPLOYABLE_SELECTIONS"; //$NON-NLS-1$;

}
