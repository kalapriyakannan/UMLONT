/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.NotConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Validator to validate 'NotConstraint' constrait type.
 */
public class NotConstraintValidator extends ConstraintValidator {

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (constraint.getConstraints().size() == 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.WARNING, getClass().getName(), ICoreProblemType.OBJECT_CONSTRAINTS_EMPTY,
					DeployCoreMessages.Constraint_0_type_1_empty, new Object[] { constraint,
							constraint.eClass() }, constraint);
			return status;
		}
		if (constraint.getConstraints().size() > 1) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					getClass().getName(), ICoreProblemType.OBJECT_CONSTRAINTS_EXTRANEOUS,
					DeployCoreMessages.Constraint_0_type_1_has_too_many_child_constraints, new Object[] {
							constraint, constraint.eClass() }, constraint);
			return status;
		}
		Constraint child = (Constraint) constraint.getConstraints().get(0);
		IStatus status = ConstraintService.INSTANCE.validate(child, context, monitor);
		if (status.isOK()) {
			return new DeployStatus(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					ICoreProblemType.CONSTRAINT_UNSATISFIED, DeployCoreMessages.Constraint_false,
					new Object[] {}, constraint);
		}
		return Status.OK_STATUS;
	}

	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (constraint.getConstraints().size() == 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.WARNING, getClass().getName(), ICoreProblemType.OBJECT_CONSTRAINTS_EMPTY,
					DeployCoreMessages.Constraint_0_type_1_empty, new Object[] { constraint,
							constraint.eClass() }, constraint);
			return status;
		}
		if (constraint.getConstraints().size() > 1) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					getClass().getName(), ICoreProblemType.OBJECT_CONSTRAINTS_EXTRANEOUS,
					DeployCoreMessages.Constraint_0_type_1_has_too_many_child_constraints, new Object[] {
							constraint, constraint.eClass() }, constraint);
			return status;
		}
		Constraint child = (Constraint) constraint.getConstraints().get(0);
		// TODO: it's interesting: imagine child is Attribute Value Constraint which performes very 
		// relaxed validation for matching, and will almost always return OK, so NOT will return ERROR. What should I do?
		// Option 1: always return OK
		// option 2: invoke strict validation.
		// I have chosen option 2.
		IStatus status = ConstraintService.INSTANCE.validate(child, context,
				new NullProgressMonitor());
		if (status.isOK()) {
			return new DeployStatus(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					ICoreProblemType.CONSTRAINT_UNSATISFIED, DeployCoreMessages.Constraint_false,
					new Object[] {}, constraint);
		}
		return Status.OK_STATUS;
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		if (parentConstraint.getConstraints().size() > 0) {
			// can't have more than 1 child constraint
			return EMPTY_CONSTRAINT_LIST;
		}
		return potentialConstraints;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof NotConstraint) {
			return true;
		}
		return false;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// call default implementation
		return getContextForChildConstraints_DefaultImpl(constraint);
	}
}
