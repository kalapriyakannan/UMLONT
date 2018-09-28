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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.XorConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'XorConstraint' constrait type.
 */
public class XorConstraintValidator extends ConstraintValidator implements
		IAttributeConstraintSolver {

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

		List<IStatus> statusList = new ArrayList<IStatus>(constraint.getConstraints().size());
		int okCount = 0;
		IStatus okStatus = null;
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			IStatus status = ConstraintService.INSTANCE.validate(c, context, monitor);
			if (status.isOK()) {
				okStatus = status;
				okCount++;
			}
			statusList.add(status);
		}
		if (okCount == 0) {
			String message = DeployNLS.bind(
					DeployCoreMessages.Constraint_0_no_child_constraint_satisfied, constraint);
			MultiStatus result = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, statusList
					.toArray(new IStatus[statusList.size()]), message, null);
			return result;
		}
		if (okCount == 1) {
			return okStatus;
		}

		// Remove non-OK status
		for (Iterator<IStatus> iter = statusList.iterator(); iter.hasNext();) {
			IStatus status = iter.next();
			if (!status.isOK()) {
				iter.remove();
			}
		}

		// Can't return multi status with all the OK messages because it will
		// not have error severity. TODO consider alternative grouping class.
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
				DeployCoreMessages.Constraint_false);
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

		// TODO: it's interesting: imagine children are Attribute Value Constraints which perform very 
		// relaxed validation for matching, and will almost always return OK, so XOR will return ERROR. 
		// What should I do?
		// Option 1: always return OK
		// Option 2: invoke strict validation.
		// Option 3. behave like OR: return OK, if at least one was OK.
		// I have chosen option 3.

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
		if (constraint instanceof XorConstraint) {
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
		List<List<List<Constraint>>> childResults = new ArrayList<List<List<Constraint>>>();
		while (childCnstr.hasNext()) {
			childResults.add(ConstraintService.INSTANCE.getSatisfyingChildConstraintsForMatch(
					childCnstr.next(), context));
		}
		return ConstraintUtil.createSetUnion(childResults);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.IDeployConstraintAttributeValueSolver#getAttributeValues(com.ibm.ccl.soa.deploy.core.Constraint,
	 *      java.lang.Object, org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeValues getAttributeValues(Constraint constraint, Object context,
			EAttribute attribute) {
		if (!(constraint instanceof XorConstraint)) {
			return new AttributeValues();
		}
		if (constraint.getConstraints().isEmpty()) {
			return new AttributeValues();
		}
		if (constraint.getConstraints().size() == 1) {
			return AttributeConstraintSolverService.getInstance().getValidValues(context,
					attribute, (Constraint) constraint.getConstraints().get(0));
		}
		AttributeValues result = null;
		List<IStatus> statusList = new ArrayList<IStatus>();
		Set<Object> conflictValuesSet = new HashSet<Object>();
		boolean hasNonErrorChild = false;
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			AttributeValues cResult = AttributeConstraintSolverService.getInstance()
					.getValidValues(context, attribute, c);
			if (result == null) {
				result = cResult;
				continue;
			}
			//
			// Merge with result
			//
			for (Iterator<Object> iter = cResult.getValidValues().iterator(); iter.hasNext();) {
				Object obj = iter.next();
				if (conflictValuesSet.contains(obj)) {
					// known conflict value
				} else if (result.getValidValues().contains(obj)) {
					// found conflict
					result.getValidValues().remove(obj);
					conflictValuesSet.add(obj);
				} else {
					result.getValidValues().add(obj);
				}
			}
			if (!cResult.isValidValuesExclusive()) {
				result.setValidValuesExclusive(false);
			}

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
		if (!hasNonErrorChild) {
			result.getStatusList().addAll(statusList);
		}

		return result;
	}
}
