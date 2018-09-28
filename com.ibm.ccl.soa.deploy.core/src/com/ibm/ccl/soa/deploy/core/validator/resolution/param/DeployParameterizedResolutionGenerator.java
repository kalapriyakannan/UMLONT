/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionParameterizerDescriptor;

/**
 * @since 1.0
 * 
 */
public abstract class DeployParameterizedResolutionGenerator extends
		DeployResolutionGenerator {

	protected IDeployResolution[] allResolutions = null;

	/**
	 * Returns all deploy resolutions irrespective of the existance of
	 * parameterizers.
	 * <p>
	 * The method is invoked by
	 * {@link #getResolutions(IDeployResolutionContext)} and
	 * {@link #hasResolutions(IDeployResolutionContext)} which further filter
	 * the results based on the availability of
	 * {@link IDeployResolutionParameterizer}s for the resolutions.
	 * 
	 * @param context
	 *            the deploy resolution context.
	 * @return the deploy resolutions (never null).
	 */
	public abstract IDeployResolution[] getAllResolutions(
			IDeployResolutionContext context);

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (allResolutions == null) {
			allResolutions = getAllResolutions(context);
			if (allResolutions == null) {
				allResolutions = EMPTY_RESOLUTION_ARRAY;
			}
		}
		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>(
				allResolutions.length);
		for (int i = 0; i < allResolutions.length; i++) {
			if (allResolutions[i] instanceof IDeployParameterizedResolution) {
				IDeployParameterizedResolution resolution = (IDeployParameterizedResolution) allResolutions[i];
				ResolutionParameterizerDescriptor[] descriptors = ResolutionGeneratorManager
						.getInstance().getParameterizerDescriptors(resolution);
				if (descriptors.length > 0) {
					// TODO bind all descriptors?
					
				}
			} else {
				resolutions.add(allResolutions[i]);
			}
		}
		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (allResolutions == null) {
			allResolutions = getAllResolutions(context);
			if (allResolutions == null) {
				allResolutions = EMPTY_RESOLUTION_ARRAY;
			}
		}
		for (int i = 0; i < allResolutions.length; i++) {
			if (ResolutionGeneratorManager.getInstance().hasParameterizerDescriptors(
					allResolutions[i])) {
				return true;
			}
		}
		return false;
	}

}
