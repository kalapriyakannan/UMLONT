/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.expression;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Interpreter for equality constraints on Requirement expressions.
 * 
 * @see RequirementExpression#getIntepreter()
 */
public class Equals extends RequirementExpressionInterpreter2 {

	/**
	 * Globally unique intepreter ID.
	 * <p>
	 * Value={@value}
	 */
	public static final String INTERPRETER_ID = "Equals"; //$NON-NLS-1$

	private static final Equals SINGLETON = new Equals();

	/**
	 * @return the shared instance of the interpreter.
	 */
	public static Equals getInstance() {
		return SINGLETON;
	}

	/**
	 * Creates an equality requirement expression.
	 * 
	 * @param attr
	 *           the attribute on the capability that must be equal.
	 * @param value
	 *           the required value of the attribute.
	 * @return the created requirement expression (invokers must add it to a {@link Requirement}).
	 */
	public static RequirementExpression createExpression(EAttribute attr, Object value) {
		RequirementExpression expr = CoreFactory.eINSTANCE.createRequirementExpression();
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(Equals.INTERPRETER_ID);
		setAttribute(expr, attr, value);
		return expr;
	}

	/**
	 * Sets the name and value attributes of an equality expression.
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

		expr.setName(Equals.class.getName().substring(Equals.class.getName().lastIndexOf('.') + 1)
				+ ' ' + attr.getName());
		//		expr.setName(attr.getName());
		expr.setAttributeName(attr.getName());

		if (value == null) {
			expr.setValue(null);
		} else {
			expr.setValue(EcoreUtil.convertToString(attr.getEAttributeType(), value));
		}
	}

	/**
	 * Unlike the other relation interpreters, <code>Equals<code> generates resolutions
	 * so it needs a customized 'failed' status.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.expression.RequirementExpressionInterpreter2#generateInterpFailedStatus(com.ibm.ccl.soa.deploy.core.RequirementExpression, com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext, java.lang.Object, java.lang.Object)
	 */
	protected IDeployStatus generateInterpFailedStatus(RequirementExpression expression,
			ReqEvaluationContext context, Object lvalue, Object rvalue) {
		// Look up lvalue again (just to get the type, so we can correctly get the rvalue)
		IDeployStatus[] astat = new IDeployStatus[1];
		EDataType aedt[] = new EDataType[1];
		/* Object lvalue = */getLValue(expression, context, astat, aedt);

		Object expectedValue = getRValue(expression, aedt[0]);

		// Look up the expected value again (we don't want to pass it around as not every interpreter gets it
		// the same way).  NOTE: Because we can use this interpreter on an ExtendedAttribute,
		// 'attribute' might be null.  AttributeValueStatus can't handle ExtendedAttributes; what should
		// we do?
		EAttribute attribute = getAttribute(expression, context);

		return DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(IStatus.ERROR,
				IDeployCoreValidators.EQUALS_001, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid, new Object[] {
						context.getCapability(),
						attribute == null ? expression.getAttributeName() : attribute }, context
						.getValue(), attribute, expectedValue);
	}

	public boolean interp(Object lvalue, Object rvalue) {
		// == succeeds if both sides are null
		if (lvalue == null) {
			return rvalue == null;
		}

		if (rvalue == null) {
			return false;
		}

		// The check object equality
		return lvalue.equals(rvalue);
	}

	public String getInterpreterName() {
		return "=="; //$NON-NLS-1$
	}

	public String computeTitle(RequirementExpression re) {
		return re.getAttributeName() + " = " + re.getValue(); //$NON-NLS-1$
	}

} // end class Equals
