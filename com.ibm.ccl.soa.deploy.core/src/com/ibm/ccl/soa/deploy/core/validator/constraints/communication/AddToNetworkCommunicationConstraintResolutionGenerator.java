/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Generates resolutions on an object attribute with an expected value.
 */
public class AddToNetworkCommunicationConstraintResolutionGenerator extends
		DeployResolutionGenerator {

	private static final DeployValidatorService _dvs = DeployValidatorService
			.getDefaultValidatorService();

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (null == status) {
			return false;
		}

		DeployModelObject obj = status.getDeployObject();
		if (null == obj) {
			return false;
		}

		if (!ConstraintPackage.Literals.COMMUNICATION_CHILD_CONSTRAINT.isSuperTypeOf(obj.getEObject()
				.eClass())) {
			return false;
		}

		if (!ICoreProblemType.CANNOT_MATCH_ACC_CHILD_TO_NCC_CHILD.equals(status.getProblemType())) {
			return false;
		}

		// check that resolution will be able to do what it needs to do:
		// (a) various things

		return true;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		IDeployCommunicationConstraintStatus status = (IDeployCommunicationConstraintStatus) context
				.getDeployStatus();
		CommunicationChildConstraint constraint = (CommunicationChildConstraint) status
				.getDeployObject();
		DeployModelObject parentLink = ConstraintUtil.getExpectedContext(constraint);
		if (!CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(parentLink.getEObject().eClass())) {
			parentLink = null;
		}

		StatusMap statusMap = status.getStatusMap();

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		for (Iterator<Constraint> it = statusMap.keySet().iterator(); it.hasNext();) {
			Constraint childConstraint = it.next();
			IStatus childStatus = statusMap.get(childConstraint);
			resolutions.addAll(_dvs.getResolutions(childStatus));
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}
}
