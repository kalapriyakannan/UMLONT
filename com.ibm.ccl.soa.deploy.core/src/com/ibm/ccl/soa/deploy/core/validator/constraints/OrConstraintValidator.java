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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'OrConstraint' constrait type.
 */
public class OrConstraintValidator extends ConstraintValidator implements
		IAttributeConstraintSolver {

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (constraint.getConstraints().size() == 0) {
			//IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
			//		IStatus.WARNING, getClass().getName(), ICoreProblemType.OBJECT_CONSTRAINTS_EMPTY,
			//		DeployCoreMessages.Constraint_0_type_1_empty, new Object[] { constraint,
			//				constraint.eClass() }, constraint);
			// return status;
			// alternative semantics: if there are no children - validate to TRUE
			return Status.OK_STATUS;
		}
		List<IStatus> statusList = new ArrayList<IStatus>(constraint.getConstraints().size());
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			IStatus status = ConstraintService.INSTANCE.validate(c, context, monitor);
			if (status.isOK()) {
				return status;
			}
			statusList.add(status);
		}
		String message = DeployNLS.bind(
				DeployCoreMessages.Constraint_0_no_child_constraint_satisfied, constraint);
		MultiStatus result = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, statusList
				.toArray(new IStatus[statusList.size()]), message, null);
		return result;
	}

	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (constraint.getConstraints().size() == 0) {
			// IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
			//		IStatus.WARNING, getClass().getName(), ICoreProblemType.OBJECT_CONSTRAINTS_EMPTY,
			//		DeployCoreMessages.Constraint_0_type_1_empty, new Object[] { constraint,
			//				constraint.eClass() }, constraint);
			//return status;
			// alternative semantics: if there are no children - validate to TRUE
			return Status.OK_STATUS;
		}
		List<IStatus> statusList = new ArrayList<IStatus>(constraint.getConstraints().size());
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			IStatus status = ConstraintService.INSTANCE.validateForPotentialMatch(c, context);
			if (status.isOK()) {
				return status;
			}
			statusList.add(status);
		}
		String message = DeployNLS.bind(
				DeployCoreMessages.Constraint_0_no_child_constraint_satisfied, constraint);
		MultiStatus result = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, statusList
				.toArray(new IStatus[statusList.size()]), message, null);
		return result;
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return potentialConstraints;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof OrConstraint) {
			return true;
		}
		return false;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// call default implementation
		return getContextForChildConstraints_DefaultImpl(constraint);
	}

	public List<List<Constraint>> getSatisfyingChildConstraintsForMatch(Constraint constraint,
			DeployModelObject context) {
		Iterator<Constraint> childCnstr = constraint.getConstraints().iterator();
		List<List<Constraint>> result;
		if (childCnstr.hasNext()) {
			result = ConstraintService.INSTANCE.getSatisfyingChildConstraintsForMatch(childCnstr
					.next(), context);
		} else {
			return Collections.emptyList();
		}
		while (childCnstr.hasNext()) {
			result = ConstraintUtil.createOrSetMerge(result, ConstraintService.INSTANCE
					.getSatisfyingChildConstraintsForMatch(childCnstr.next(), context));
		}
		return result;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.IDeployConstraintAttributeValueSolver#getAttributeValues(com.ibm.ccl.soa.deploy.core.Constraint,
	 *      java.lang.Object, org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeValues getAttributeValues(Constraint constraint, Object context,
			EAttribute attribute) {
		if (!(constraint instanceof OrConstraint)) {
			return new AttributeValues();
		}
		OrConstraint orC = (OrConstraint) constraint;

		if (orC.getConstraints().isEmpty()) {
			return new AttributeValues();
		}
		if (orC.getConstraints().size() == 1) {
			return AttributeConstraintSolverService.getInstance().getValidValues(context, attribute,
					(Constraint) orC.getConstraints().get(0));
		}
		AttributeValues result = new AttributeValues();
		result.setValidValuesExclusive(true);
		List<IStatus> statusList = new ArrayList<IStatus>();
		boolean hasNonErrorChild = false;
		for (Constraint c : (List<Constraint>) orC.getConstraints()) {
			AttributeValues cResult = AttributeConstraintSolverService.getInstance().getValidValues(
					context, attribute, c);
			result.getValidValues().addAll(cResult.getValidValues());
			result.getValidRanges().addAll(cResult.getValidRanges());
			if (cResult.hasErrors()) {
				statusList.addAll(cResult.getStatusList());
			} else {
				hasNonErrorChild = true;
			}
			if (!cResult.isValidValuesExclusive()) {
				result.setValidValuesExclusive(false);
			}
		}
		if (!hasNonErrorChild) {
			result.getStatusList().addAll(statusList);
		}
		result.compactValidRanges();
		return result;
	}
}
