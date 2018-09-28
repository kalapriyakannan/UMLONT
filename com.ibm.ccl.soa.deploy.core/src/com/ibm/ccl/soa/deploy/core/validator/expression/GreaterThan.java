/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.expression;

import org.eclipse.emf.common.util.AbstractEnumerator;

import com.ibm.ccl.soa.deploy.core.RequirementExpression;

/**
 * Interpreter for > constraints on Requirement expressions.
 * 
 * @see RequirementExpression#getIntepreter()
 * 
 * @author Ed Snible
 */
public class GreaterThan extends RequirementExpressionInterpreter2 {

	/**
	 * Globally unique intepreter ID.
	 */
	public static final String INTERPRETER_ID = "GreaterThan"; //$NON-NLS-1$

	private static final GreaterThan SINGLETON = new GreaterThan();

	/**
	 * @return the shared instance of the interpreter.
	 */
	public static GreaterThan getInstance() {
		return SINGLETON;
	}

	/**
	 * Constructor
	 */
	public GreaterThan() {
		// public, so IConfigurationElement.createExecutableExtension() can construct
	}

	public boolean interp(Object lvalue, Object rvalue) {
		// > fails on null
		if (lvalue == null || rvalue == null) {
			return false;
		}

		if (lvalue instanceof Comparable) {
			Comparable lc = (Comparable) lvalue;
			int comp = lc.compareTo(rvalue);
			return comp > 0;
		}

		if (lvalue instanceof AbstractEnumerator) {
			AbstractEnumerator lae = (AbstractEnumerator) lvalue;
			AbstractEnumerator rae = (AbstractEnumerator) rvalue;
			return lae.getValue() > rae.getValue();
		}

		// The objects don't implement comparable, so check equality
		return false;
	}

	public String getInterpreterName() {
		return ">"; // //$NON-NLS-1$
	}

	public String computeTitle(RequirementExpression re) {
		return re.getAttributeName() + " > " + re.getValue(); //$NON-NLS-1$
	}

} // end class GreaterThanEquals
