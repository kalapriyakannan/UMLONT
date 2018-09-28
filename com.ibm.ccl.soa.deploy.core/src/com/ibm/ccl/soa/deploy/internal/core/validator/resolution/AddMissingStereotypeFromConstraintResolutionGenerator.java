/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Resolves {@link ICoreProblemType#STEREOTYPE_INCLUSION_FAILURE}
 */
public class AddMissingStereotypeFromConstraintResolutionGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		return new IDeployResolution[] { new AddMissingStereotypeFromConstraintResolution(context,
				this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (ICoreProblemType.STEREOTYPE_INCLUSION_FAILURE.equals(status.getProblemType())
				&& hasStereotypeConstraint(status)) {
			return true;
		}
		return false;
	}

	private boolean hasStereotypeConstraint(IDeployStatus status) {
		List<Constraint> constraints = status.getConstraints();
		if (constraints == null || constraints.isEmpty()) {
			return false;
		}
		for (Constraint constraint : constraints) {
			if (constraint instanceof StereotypeConstraint) {
				return true;
			}
		}
		return false;
	}
}
