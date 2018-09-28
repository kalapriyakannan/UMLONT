/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution;

/**
 * Abstract implementation of the {@link IDeployResolutionGenerator} interface.
 */
public abstract class DeployResolutionGenerator implements IDeployResolutionGenerator {
	/** An empty array of resolutions. */
	public static final IDeployResolution[] EMPTY_RESOLUTION_ARRAY = new IDeployResolution[0];
}
