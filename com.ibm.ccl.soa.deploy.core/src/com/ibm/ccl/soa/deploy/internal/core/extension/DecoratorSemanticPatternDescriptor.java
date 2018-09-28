/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.regex.Pattern;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * Provides a layer around an IConfigurationElement from <b>com.ibm.ccl.soa.deploy.core.topology/<include></b>
 * 
 * @since 1.0
 * 
 */
public class DecoratorSemanticPatternDescriptor extends CommonDescriptor {

	private Pattern pattern;
	private Expression enablementExpression;
	private boolean isInclude = true;

	/**
	 * Create a descriptor for elements with the name "include" that are defined as part of a
	 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
	 * 
	 * @param anElement
	 *           An element with the name "include" that conforms to the schema of
	 *           <b>com.ibm.ccl.soa.deploy.core.topology/decoratorSemanticPatternBinding</b>.
	 */
	public DecoratorSemanticPatternDescriptor(IConfigurationElement anElement) {
		super(anElement);
		if (TAG_EXCLUDE.equals(anElement.getName()))
			isInclude = false;
		else
			assert TAG_INCLUDE.equals(anElement.getName());
		init();
	}

	private void init() {
		String patternString = getElement().getAttribute(ATT_PATTERN);
		if (patternString != null)
			pattern = Pattern.compile(patternString);

		IConfigurationElement[] enablement = getElement().getChildren(TAG_ENABLEMENT);
		if (enablement.length == 1) {
			enablementExpression = new CustomCoreExpression(enablement[0]);
		}

	}

	/**
	 * 
	 * @return The enablement expression for this descriptor
	 */
	public Expression getEnablementExpression() {
		return enablementExpression;
	}

	/**
	 * @return The Pattern for this descriptor
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * 
	 * @param anObject
	 *           An input object
	 * @return True if and only if the given argument is described by the enablement clause of the
	 *         extension
	 */
	public boolean isEnabled(Object anObject) {
		if (enablementExpression == null)
			return true; // Enablement is optional, so return true if there is none 
		EvaluationContext context = new EvaluationContext(null, anObject);
		context.setAllowPluginActivation(true);
		try {
			return enablementExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	/**
	 * 
	 * @return true if this descriptor is for an include pattern false if for an exclude pattern
	 */
	public boolean isInclude() {
		return isInclude;
	}

}
