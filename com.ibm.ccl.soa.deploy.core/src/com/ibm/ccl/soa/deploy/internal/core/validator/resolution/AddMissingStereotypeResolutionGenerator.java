/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Resolves {@link ICoreProblemType#REALIZATION_LINK_SOURCE_TARGET_STEREOTYPE_MISMATCH}
 */
public class AddMissingStereotypeResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		return new IDeployResolution[] { new AddMissingStereotypeResolution(context, this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status.getDeployObject() instanceof RealizationLink)) { // TODO fix with proper object
			return false;
		}

		if (!ICoreProblemType.REALIZATION_LINK_UNIT_SOURCE_TARGET_STEREOTYPE_MISMATCH.equals(status
				.getProblemType())
				&& !ICoreProblemType.REALIZATION_LINK_CAP_SOURCE_TARGET_STEREOTYPE_MISMATCH
						.equals(status.getProblemType())) {
			return false;
		}

		return true;
	}
}
