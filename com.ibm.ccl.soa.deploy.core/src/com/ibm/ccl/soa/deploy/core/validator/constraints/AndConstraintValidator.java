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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

/**
 * Validator to validate 'AndConstraint' constrait type.
 */
public class AndConstraintValidator extends ConstraintValidator implements
		IAttributeConstraintSolver {

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
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
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			IStatus status = ConstraintService.INSTANCE.validate(c, context, monitor);
			if (!status.isOK()) {
				return status;
			}
		}
		return Status.OK_STATUS;
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
			// return status;
			// alternative semantics: if there are no children - validate to TRUE
			return Status.OK_STATUS;
		}
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			IStatus status = ConstraintService.INSTANCE.validateForPotentialMatch(c, context);
			if (!status.isOK()) {
				return status;
			}
		}
		return Status.OK_STATUS;
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// pass through potential constraints
		return potentialConstraints;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof AndConstraint) {
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
			result = ConstraintUtil.createAndSetMerge(result, ConstraintService.INSTANCE
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
		if (!(constraint instanceof AndConstraint)) {
			return new AttributeValues();
		}
		return getAttributeValues(constraint.getConstraints(), context, attribute);
	}

	/**
	 * Static method to retrieve the valid values of an {@link AndConstraint}.
	 * 
	 * @param constraints
	 *           the list of constraints that must all be true.
	 * @param context
	 *           the context of evaluation.
	 * @param attribute
	 *           the attribute whose valid values should be returned.
	 * @return the valid attribute values.
	 */
	public static AttributeValues getAttributeValues(List<Constraint> constraints, Object context,
			EAttribute attribute) {
		if (constraints == null || constraints.isEmpty()) {
			return new AttributeValues();
		}
		if (constraints.size() == 1) {
			return AttributeConstraintSolverService.getInstance().getValidValues(context, attribute,
					constraints.get(0));
		}
		AttributeValues result = null;
		for (Constraint c : constraints) {
			AttributeValues cResult = AttributeConstraintSolverService.getInstance().getValidValues(
					context, attribute, c);
			if (result == null) {
				result = cResult;
				continue;
			}
			//
			// Merge with result
			//
			// Don't remove values contributed by other constraints if this constraint does not state that it provides an exclusive listing.
			if (cResult.isValidValuesExclusive()) {
				for (Iterator<Object> iter = result.getValidValues().iterator(); iter.hasNext();) {
					Object obj = iter.next();
					if (!cResult.getValidValues().contains(obj)) {
						iter.remove();
					}
				}
				result.setValidValuesExclusive(true);
			}
			result.getStatusList().addAll(cResult.getStatusList());

			// Merge valid ranges
			result.compactValidRanges();
			cResult.compactValidRanges();
			Set<AttributeValuesRange> ranges = new TreeSet(result.getValidRanges());
			result.getValidRanges().clear();
			for (AttributeValuesRange range : ranges) {
				for (AttributeValuesRange cRange : cResult.getValidRanges()) {
					if (range.overlaps(cRange)) {
						range.subtract(cRange);
						result.getValidRanges().add(range);
					}
				}
			}
			result.compactValidRanges();
		}

		return result;

	}
}
