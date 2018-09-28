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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.expression.IRequirementExpressionInterpreter;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'RequirementExpression' constrait type.
 */
public class RequirementExpressionValidator extends ConstraintValidator {

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(constraint);
		}
		ReqEvaluationContext reqContext = null;
		if (context instanceof Unit) {
			reqContext = new ReqEvaluationContext((Unit) context);
		} else if (context instanceof Capability) {
			reqContext = new ReqEvaluationContext((Capability) context);
		} else {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}
		return RequirementUtil.validateRequirementExpression((RequirementExpression) constraint,
				reqContext);
	}

	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(constraint);
		}

		RequirementExpression expression = (RequirementExpression) constraint;
		String attributeName = expression.getAttributeName();
		if (attributeName == null || attributeName.trim().equals("")) { //$NON-NLS-1$			
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.REQUIREMENT_UTIL_004,
					ICoreProblemType.REQUIREMENT_EXPRESSION_INVALID_ATTRIBUTE,
					DeployCoreMessages.Requirement_expression_0_attribute_1_not_found_on_object_2,
					new Object[] { expression, attributeName, context }, expression);
		}

		ReqEvaluationContext reqContext = null;
		if (context instanceof Unit) {
			reqContext = new ReqEvaluationContext((Unit) context);
		} else if (context instanceof Capability) {
			reqContext = new ReqEvaluationContext((Capability) context);
		} else {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		if (DeployModelObjectUtil.isSettable(context, attributeName)) {
			// if attribute is mutable, we will be able to change is later
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}
		return RequirementUtil.validateRequirementExpression(expression, reqContext);
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof RequirementExpression) {
			return true;
		}
		return false;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// don't allow child constraints
		return null;
	}

	@Override
	public String title(Constraint constraint) {
		IRequirementExpressionInterpreter i = RequirementUtil
				.getInterpreter((RequirementExpression) constraint);
		if (i != null) {
			return i.computeTitle((RequirementExpression) constraint);
		}
		return super.title(constraint);
	}

}
