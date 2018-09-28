/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import org.eclipse.core.runtime.IStatus;

/**
 * Implemented by extensions that can parameterize a resolution.
 * <p>
 * Used by the resolutionParameterizer core extension point.
 * 
 * @see IDeployParameterizedResolution
 */
public interface IDeployResolutionParameterizer {

	/**
	 * Sets the parameters of a resolution.
	 * 
	 * @param resolution
	 *            a parameterized resolution.
	 * @return the status of setting the parameters.
	 */
	public IStatus setParameters(IDeployParameterizedResolution resolution);
}
