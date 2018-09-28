/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.expressions.ElementHandler;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * Create a Core expression for cases where the name of the top-level element is not "enablement".
 * Uses And-type semantics to evaluate the direct children of the configuration element used to
 * construct this expression.
 * 
 * @since 1.0
 * 
 */
public class CustomCoreExpression extends Expression {

	private List childExpressions;

	/**
	 * Create an AND-type core expression from an IConfigurationElement of arbitrary name. The
	 * children elements are combined using boolean AND semantics to evaluate the expression.
	 * 
	 * @param element
	 *           An IConfigurationElement of arbitrary name.
	 */
	public CustomCoreExpression(IConfigurationElement element) {
		assert element != null;

		IConfigurationElement[] children = element.getChildren();

		if (children.length > 0)
			childExpressions = new ArrayList();
		for (int i = 0; i < children.length; i++) {
			try {
				childExpressions.add(ElementHandler.getDefault().create(
						ExpressionConverter.getDefault(), children[i]));
			} catch (CoreException ce) {
				DeployCorePlugin.logError(0, ce.getMessage(), ce);
			}
		}
	}

	public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
		if (childExpressions == null)
			return EvaluationResult.TRUE;

		for (Iterator childIterator = childExpressions.iterator(); childIterator.hasNext();) {
			Expression cExpr = (Expression) childIterator.next();

			EvaluationResult childEvaluation = cExpr.evaluate(context);
			if (childEvaluation == EvaluationResult.NOT_LOADED
					|| childEvaluation == EvaluationResult.FALSE)
				return childEvaluation;

		}
		return EvaluationResult.TRUE;
	}

}
