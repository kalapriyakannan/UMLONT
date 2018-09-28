/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution.pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;

/**
 * Resolution to remove a constraint from the model.
 */
public class RemoveConstraintResolution extends DeployResolution {

	private final Constraint _constraint;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param constraint
	 *           a constraint
	 */
	public RemoveConstraintResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Constraint constraint) {
		super(context, generator, message);
		_constraint = constraint;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		DeployModelObject object = _constraint.getParent();
		if (null != object) {
			object.getConstraints().remove(_constraint);
		}

		return Status.OK_STATUS;
	}

}
