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

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Generates resolutions or markers on an object attribute with an expected value.
 */
public class DeployAttributeValueResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (status instanceof IDeployAttributeValueStatus
				&& !(status.getSeverity() == IStatus.INFO && ((IDeployAttributeValueStatus) status)
						.getAttributeExpectedValue() == null)) {
			return new IDeployResolution[] { new DeploySetAttributeResolution(
					(IDeployAttributeValueStatus) status, context, this) };
		}
		return new IDeployResolution[0];
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof IDeployAttributeValueStatus)) {
			return false;
		}
		IDeployAttributeValueStatus status = (IDeployAttributeValueStatus) context.getDeployStatus();
		return status.getAttributeType() != null && ResolutionUtils.isSettable(status);
	}
}
