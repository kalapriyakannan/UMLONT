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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;

/**
 * Interpreter for < constraints on Requirement expressions.
 * 
 * @see RequirementExpression#getIntepreter()
 * 
 * @author Ed Snible
 */
public class LessThan extends RequirementExpressionInterpreter2 {

	/**
	 * Globally unique intepreter ID.
	 */
	public static final String INTERPRETER_ID = "LessThan"; //$NON-NLS-1$

	private static final LessThan SINGLETON = new LessThan();

	/**
	 * @return the shared instance of the interpreter.
	 */
	public static LessThan getInstance() {
		return SINGLETON;
	}

	/**
	 * Constructor
	 */
	public LessThan() {
		// public, so IConfigurationElement.createExecutableExtension() can construct
	}

	public boolean interp(Object lvalue, Object rvalue) {
		// < fails on null
		if (lvalue == null || rvalue == null) {
			return false;
		}

		if (lvalue instanceof Comparable) {
			Comparable lc = (Comparable) lvalue;
			int comp = lc.compareTo(rvalue);
			return comp < 0;
		}

		if (lvalue instanceof AbstractEnumerator) {
			AbstractEnumerator lae = (AbstractEnumerator) lvalue;
			AbstractEnumerator rae = (AbstractEnumerator) rvalue;
			return lae.getValue() < rae.getValue();
		}

		// The objects don't implement comparable, so fail
		return false;
	}

	public String getInterpreterName() {
		return "<"; //$NON-NLS-1$
	}

	public String computeTitle(RequirementExpression re) {
		return re.getAttributeName() + " < " + re.getValue(); //$NON-NLS-1$
	}

	/**
	 * Creates an less-than requirement expression.
	 * 
	 * @param attr
	 *           the attribute on the capability that must be less than the tested attribute.
	 * @param value
	 *           the required value of the attribute.
	 * @return the created requirement expression (invokers must add it to a {@link Requirement}).
	 */
	public static RequirementExpression createExpression(EAttribute attr, Object value) {
		RequirementExpression expr = CoreFactory.eINSTANCE.createRequirementExpression();
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(LessThan.INTERPRETER_ID);
		setAttribute(expr, attr, value);
		return expr;
	}

	/**
	 * Sets the name and value attributes of a lessThan expression.
	 * 
	 * @see RequirementExpression#getName()
	 * @see RequirementExpression#getValue()
	 * 
	 * @param expr
	 *           a requirement expression with an {@link #INTERPRETER_ID} interpreter.
	 * @param attr
	 *           the capability attribute matched.
	 * @param value
	 *           the value to be set.
	 */
	public static void setAttribute(RequirementExpression expr, EAttribute attr, Object value) {
		assert expr != null;
		assert attr != null;
		assert CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(attr.getEContainingClass()) : attr
				.getEContainingClass();
		assert value == null || attr.getEAttributeType().isInstance(value) : attr.getName() + ' '
				+ value + " instance of " + value.getClass() + " not instance of " //$NON-NLS-1$ //$NON-NLS-2$ 
				+ attr.getEAttributeType();
		if (!INTERPRETER_ID.equals(expr.getInterpreter())) {
			expr.setInterpreter(INTERPRETER_ID);
		}

		expr.setName(LessThan.class.getName()
				.substring(LessThan.class.getName().lastIndexOf('.') + 1)
				+ ' ' + attr.getName());
		//		expr.setName(attr.getName());
		expr.setAttributeName(attr.getName());

		if (value == null) {
			expr.setValue(null);
		} else {
			expr.setValue(EcoreUtil.convertToString(attr.getEAttributeType(), value));
		}
	}

} // end class GreaterThanEquals
