/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Skeleton constraint validator that would validate any constraint and return the ERROR status.
 */
public class SkeletonConstraintValidator extends ConstraintValidator {

	public static final SkeletonConstraintValidator INSTANCE = new SkeletonConstraintValidator();

	public boolean canValidateConstraint(Constraint constraint) {
		return true;
	}

	/**
	 * Returns the ERROR status.
	 */
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING, getClass()
				.getName(), ICoreProblemType.CONSTRAINT_NO_VALIDATOR,
				DeployCoreMessages.Constraint_type_0_has_no_validator, new Object[] { constraint
						.eClass().getInstanceClassName() }, constraint);
	}

	/**
	 * Returns the ERROR status.
	 */
	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING, getClass()
				.getName(), ICoreProblemType.CONSTRAINT_NO_VALIDATOR,
				DeployCoreMessages.Constraint_type_0_has_no_validator, new Object[] { constraint
						.eClass().getInstanceClassName() }, constraint);
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return EMPTY_CONSTRAINT_LIST;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}
}
