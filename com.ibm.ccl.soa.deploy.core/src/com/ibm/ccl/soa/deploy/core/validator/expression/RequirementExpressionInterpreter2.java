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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Abstract requirement expression interpreter.
 * 
 * @author Ed Snible based on Alexander's Equals
 */
public abstract class RequirementExpressionInterpreter2 implements
		IRequirementExpressionInterpreter {

	private static final Object NO_SUCH_LVALUE = new Integer(Integer.MIN_VALUE);

	/**
	 * @param lvalue
	 * @param rvalue
	 * @return <code>true</code> if the interpreter succeeds for lvalue OP rvalue
	 */
	abstract public boolean interp(Object lvalue, Object rvalue);

	/**
	 * @return ID for UI
	 */
	abstract public String getInterpreterName();

	protected EAttribute getAttribute(RequirementExpression expr, ReqEvaluationContext context) {
		if (expr.getAttributeName() == null) {
			return null;
		}

		if (context.getCapability() != null) {
			EStructuralFeature esf = context.getCapability().eClass().getEStructuralFeature(
					expr.getAttributeName());
			if (esf != null) {
				if (esf instanceof EAttribute) {
					return (EAttribute) esf;
				} else {
					return null;
				}
			} else {
				//Look for ExtendedAttribute.
				return context.getCapability().getExtendedAttribute(
						expr.getAttributeName());
			}
		}

		if (context.getUnit() != null) {
			return (EAttribute) context.getUnit().eClass().getEStructuralFeature(
					expr.getAttributeName());
		}

		return null;
	}

	protected ExtendedAttribute getExtendedAttribute(String attributeName,
			ReqEvaluationContext context) {
		if (context.getCapability() != null) {
			ExtendedAttribute ea = context.getCapability().getExtendedAttribute(attributeName);
			return ea;
		}

		// Units don't have extended attributes
		return null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.expression.IRequirementExpressionInterpreter#validate(com.ibm.ccl.soa.deploy.core.RequirementExpression,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public IDeployStatus validate(RequirementExpression expression, ReqEvaluationContext context) {
		assert expression != null;
		assert context != null;

		IDeployStatus[] astat = new IDeployStatus[1];
		EDataType aedt[] = new EDataType[1];
		Object lvalue = getLValue(expression, context, astat, aedt);
		if (astat[0] != null) {
			return astat[0];
		}

		Object rvalue = getRValue(expression, aedt[0]);

		if (interp(lvalue, rvalue)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		return generateInterpFailedStatus(expression, context, lvalue, rvalue);
	}

	/**
	 * Generates a status reflecting a {@link #interp(Object, Object)} == false.
	 * 
	 * @param expression
	 *           the expression which was interpreter to false.
	 * @param context
	 *           the context of the evaluation.
	 * @param lvalue
	 *           the left-hand side value of the {@link #interp(Object, Object)}
	 * @param rvalue
	 *           the right-hand side value of the {@link #interp(Object, Object)}
	 * @return the created status.
	 */
	protected IDeployStatus generateInterpFailedStatus(RequirementExpression expression,
			ReqEvaluationContext context, Object lvalue, Object rvalue) {
		IDeployStatus status;
		if (expression.getAttributeName() == null) {
			status = DeployCoreStatusFactory.INSTANCE
					.createDeployStatus(
							IStatus.ERROR,
							getInterpreterName(),
							ICoreProblemType.REQUIREMENT_EXPRESSION_VALUE_MISMATCH,
							DeployCoreMessages.Validator_requirement_expression_0_interpterer_1_value_2_not_satisfied_by_target_object_3,
							new Object[] { expression, getInterpreterName(), lvalue, context.getValue() },
							context.getValue());

		} else {
			status = DeployCoreStatusFactory.INSTANCE
					.createAttributeStatus(
							IStatus.ERROR,
							getInterpreterName(),
							ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
							DeployCoreMessages.Validator_requirement_expression_0_interpterer_1_value_2_not_satisfied_by_target_attribute_3_value_4_of_object_5,
							new Object[] { expression, getInterpreterName(), lvalue,
									expression.getAttributeName(), rvalue, context.getValue() }, context
									.getValue(), expression.getAttributeName());
		}
		return status;
	}

	/** Get value of whatever is on the left side of the operatator */
	protected Object getLValue(RequirementExpression expression, ReqEvaluationContext context,
			IDeployStatus[] astat, EDataType[] aedt) {
		assert expression != null;
		assert context != null;
		EAttribute attribute = getAttribute(expression, context);
		// Is there a problem with the Requirement Expression?
		if (attribute == null) {
			ExtendedAttribute ea = getExtendedAttribute(expression.getAttributeName(), context);
			if (ea != null) {
				aedt[0] = ea.getInstanceType();
				return ea.getValue();
			}

			DeployModelObject object = context.getCapability();
			if (object == null) {
				object = context.getUnit();
			}
			astat[0] = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.ERROR, // severity
					"GTEValidator", // validatorID // TODO Figure out what this is supposed to be //$NON-NLS-1$
					ICoreProblemType.REQUIREMENT_EXPRESSION_INVALID_ATTRIBUTE, // problemType
					DeployCoreMessages.Requirement_expression_0_attribute_1_not_found_on_object_2,
					new Object[] { expression, expression.getAttributeName(), object }, expression);
			return null;
		}

		aedt[0] = attribute.getEAttributeType();

		if (context.getCapability() != null) {
			Object value = context.getCapability().eGet(attribute);
			return value;
		}

		if (context.getUnit() != null) {
			Object value = context.getUnit().eGet(attribute);
			return value;
		}

		return NO_SUCH_LVALUE;
	}

	/**
	 * Get value of whatever is on the right side of the operatator. This value corresponds to the
	 * RequirementExpression value, converted into the same data type as the lvalue.
	 */
	protected Object getRValue(RequirementExpression expression, EDataType edt) {
		String raw = expression.getValue();
		if (raw == null) {
			return null;
		}

		Object retVal = EcoreUtil.createFromString(edt, raw);
		return retVal;
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
} // end class RequirementExpressionInterpreter2
