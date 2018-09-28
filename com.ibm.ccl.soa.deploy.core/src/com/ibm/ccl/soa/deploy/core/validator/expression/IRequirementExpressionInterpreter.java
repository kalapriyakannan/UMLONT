/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.expression;

import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Implemented by interpreters declared using the
 * {@link com.ibm.ccl.soa.deploy.core.DeployCorePlugin#PLUGIN_ID}.{@link com.ibm.ccl.soa.deploy.internal.core.extension.ICommonDeployExtensionConstants#TAG_INTERPRETER}
 * extension point.
 * 
 * @see com.ibm.ccl.soa.deploy.core.RequirementExpression#getInterpreter()
 */
public interface IRequirementExpressionInterpreter {

	/**
	 * Validates the requirement expression against the capability.
	 * 
	 * @param expression
	 *           the expression to be validated.
	 * @param context
	 *           the EvaluationContext in whose context the validation will be performed.
	 * @return the validation status (OK, WARNING, ERROR).
	 */
	public IDeployStatus validate(RequirementExpression expression, ReqEvaluationContext context);

	/**
	 * Return a human-readable representation of a RequirementExpression, suitable for displaying in
	 * the UI. The title may change with i18n thus developers should not use the return value for
	 * further calculations.
	 * 
	 * @param re
	 * @return human-readable title.
	 */
	public String computeTitle(RequirementExpression re);
}
