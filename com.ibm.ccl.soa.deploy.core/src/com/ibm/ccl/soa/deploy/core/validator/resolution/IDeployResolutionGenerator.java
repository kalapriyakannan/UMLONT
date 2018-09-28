/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.extension.ICommonDeployExtensionConstants;

/**
 * Interface implemented by a generator for SOA deploy status resolutions.
 * <p>
 * Not intended to be directly implemented. Extend {@link DeployResolutionGenerator}.
 * <p>
 * Generators are declared using the {@link DeployCorePlugin#PLUGIN_ID}.
 * {@link ICommonDeployExtensionConstants#TAG_RESOLUTION_GENERATOR} extension point.
 */
public interface IDeployResolutionGenerator {

	/**
	 * Generates resolutions for the specified resolution context.
	 * 
	 * @param context
	 *           the context of the resolution, including the status to be resolved.
	 * @return an array of resolutions (never null, but may be of size 0).
	 */
	IDeployResolution[] getResolutions(IDeployResolutionContext context);

	/**
	 * Check if any resolutions will be generated for the resolution context.
	 * 
	 * @param context
	 *           the context of the resolution, including the status to be resolved.
	 * @return true if at least one resolution can be generated for the deploy status.
	 */
	boolean hasResolutions(IDeployResolutionContext context);
}
