/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployWrapperStatus;

/**
 * Resolves {@link IDeployWrapperStatus} by invoking the resolutions for the wrapped status.
 */
public class WrapperStatusResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployWrapperStatus status = (IDeployWrapperStatus) context.getDeployStatus();
		List<IDeployResolution> resolutions = context.getDeployValidatorService().getResolutions(
				status.getWrappedStatus());
		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof IDeployWrapperStatus)) {
			return false;
		}
		IDeployWrapperStatus status = (IDeployWrapperStatus) context.getDeployStatus();
		if (status.getWrappedStatus() == null) {
			return false;
		}
		return context.getDeployValidatorService().hasResolutions(status.getWrappedStatus());
	}
}
