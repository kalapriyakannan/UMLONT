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

import com.ibm.ccl.soa.deploy.core.validator.constraints.AttributeConstraintSolverService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.AttributeValues;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;

/**
 * Resolves attribute statuses by using the constraint and status information.
 * 
 * @see IDeployAttributeStatus#getConstraints()
 * @see IDeployAttributeValueStatus#getAttributeExpectedValue()
 * @see AttributeConstraintSolverService
 */
public class AttributeConstraintSolverResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		AttributeValues values = AttributeConstraintSolverService.getInstance()
				.getValidValues(status);
		IDeployResolution[] result = new IDeployResolution[values.getValidValues().size()];
		int i = 0;
		for (Object value : values.getValidValues()) {
			result[i++] = new DeploySetAttributeResolution(status.getDeployObject(), status
					.getAttributeType(), value, null, context, this);
		}
		return result;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof IDeployAttributeStatus)) {
			return false;
		}
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		if (status.getDeployObject() == null || status.getAttributeType() == null
				|| !ResolutionUtils.isSettable(status)) {
			return false;
		}
		if (status.getSeverity() == IStatus.INFO) {
			return false;
		}

		return AttributeConstraintSolverService.getInstance().canSolve(status);
	}
}
