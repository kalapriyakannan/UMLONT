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

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator for a {@link CommunicationCostConstraint} constraint.
 */
public class CommunicationCostConstraintValidator extends CommunicationConstraintChildValidator {

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return null != constraint
				&& ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT.isSuperTypeOf(constraint
						.getEObject().eClass());
	}

	@Override
	public IStatus validateWithContext(Constraint constraint, CVC context, IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return Status.CANCEL_STATUS;
		}

		if (null == context) {
			return Status.CANCEL_STATUS;
		}

		int requiredCost = ((CommunicationCostConstraint) constraint).getCost();

		NetworkCommunicationConstraint ncc = ((AccNccContext) context).getNcc();

		if (ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT.isSuperTypeOf(context
				.getContext().getEObject().eClass())) {
			if (!(context instanceof AccNccContext)) {
				return Status.CANCEL_STATUS;
			}

			// look at each cost constraint's among children of ncc
			// if there is more than one, we assume that the strictest will be applied (ie, the largest)
			for (Constraint c : (List<Constraint>) ncc.getConstraints()) {
				if (ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT.isSuperTypeOf(c
						.getEObject().eClass())) {
					if (requiredCost <= ((CommunicationCostConstraint) c).getCost()) {
						return Status.OK_STATUS;
					}
				}
			}

			// error: cannot find matching communication cont constraint
			return new ApplicationCommunicationConstraintChildDeplyStatus(IStatus.ERROR,
					IDeployCoreValidators.CCC_CHECK_001, ICoreProblemType.EXPECTED_COST_INSUFFICIENT,
					DeployCoreMessages.Validator_ccc_expected_cost_insufficient, new Object[] {},
					constraint, ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT, (new Integer(
							requiredCost)).toString(), getExpectedAttributeData(constraint), ncc);
		} else {
			// context is NetworkCommunicationConstraint; currently no validation
			return Status.OK_STATUS;
		}
	}

	@Override
	public String title(Constraint constraint) {
		if (constraint == null) {
			return DeployCoreMessages.null_value;
		}
		String typeName = computeTypeName(constraint);
		String caption = constraint.getDisplayName();
		if (caption == null) {
			caption = constraint.eGet(ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT__COST)
					.toString();
		}
		if (caption != null && !caption.trim().equals("")) { //$NON-NLS-1$
			//Type(caption)
			StringBuffer buf = new StringBuffer(typeName);
			buf.append(' ').append('(').append(caption.trim()).append(')');
			return buf.toString();
		}
		return typeName;
	}

	@Override
	public List<AttributeValuePair> getExpectedAttributeData(Constraint constraint) {
		int requiredCost = ((CommunicationCostConstraint) constraint).getCost();
		return Arrays.asList(new AttributeValuePair[] { new AttributeValuePair(
				ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT__COST, requiredCost) });
	}

}
