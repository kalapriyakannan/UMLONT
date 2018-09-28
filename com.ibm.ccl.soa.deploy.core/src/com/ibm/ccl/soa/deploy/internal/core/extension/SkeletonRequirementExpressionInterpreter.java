/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.expression.IRequirementExpressionInterpreter;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a default implementation of {@link CapabilityProvider} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.domains</b>.
 * 
 * @since 1.0
 * @see CapabilityProvider
 * 
 */
public class SkeletonRequirementExpressionInterpreter implements IRequirementExpressionInterpreter {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonRequirementExpressionInterpreter INSTANCE = new SkeletonRequirementExpressionInterpreter();

	private SkeletonRequirementExpressionInterpreter() {
	}

	public IDeployStatus validate(RequirementExpression expression, ReqEvaluationContext ec) {
		return DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR,
				IDeployCoreValidators.REQUIREMENT_EXPRESSION_INTERPRETER_001,
				ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				DeployCoreMessages.Validator_requirement_expression_0_unknown_interpreter_1,
				new Object[] { expression.getInterpreter() }, expression,
				CorePackage.Literals.REQUIREMENT_EXPRESSION__INTERPRETER);
	}

	public String computeTitle(RequirementExpression re) {
		if (re.getAttributeName() == null || re.getAttributeName().length() == 0) {
			return re.getInterpreter() + "(" + stringValue(re.getValue()) + ")"; //$NON-NLS-1$ //$NON-NLS-2$ 
		}

		return re.getInterpreter()
				+ "(" + re.getAttributeName() + ", " + stringValue(re.getValue()) + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private static String stringValue(String s) {
		if (s == null) {
			return ""; //$NON-NLS-1$
		}

		return s;
	}

} // end class SkeletonRequirementExpressionInterpreter
