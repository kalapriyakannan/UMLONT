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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Checks the cardinality of {@link MemberLink}s with the owner of the interpreter as the
 * <code>target</code>.
 */
public class InCardinality implements IRequirementExpressionInterpreter {

	/**
	 * The name by which this interpreter will be looked up in the <domain> plugin.
	 * <p>
	 * Value={@value}
	 */
	public static final String INTERPRETER_ID = "InCardinality"; //$NON-NLS-1$

	/**
	 * Creates an {@link InCardinality} requirement expression.
	 * 
	 * @param min
	 *           the minimum number of groups (&ge; 0).
	 * @param max
	 *           the maximum number of groups (-1 for unbounded).
	 * @return the created requirement expression (invokers must add it to a {@link Requirement}).
	 */
	public static RequirementExpression createExpression(int min, int max) {
		RequirementExpression expr = CoreFactory.eINSTANCE.createRequirementExpression();
		expr.setName(INTERPRETER_ID);
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(INTERPRETER_ID);
		setCardinality(expr, min, max);
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
	 * @param min
	 *           the minimum number of groups (&ge; 0).
	 * @param max
	 *           the maximum number of groups (-1 for unbounded).
	 */
	public static void setCardinality(RequirementExpression expr, int min, int max) {
		assert expr != null;
		String maxString = max == MultiplicityChecker.RANGE_UNBOUNDED ? "*" : Integer.toString(max); //$NON-NLS-1$
		if (max >= 0 && min > max || min < 0 || max < MultiplicityChecker.RANGE_UNBOUNDED) {
			String message = NLS.bind(
					DeployCoreMessages.Validator_cardinality_interpreter_invalid_range_0_to_1,
					new Object[] { Integer.toString(min), maxString });
			throw new IllegalArgumentException(message);
		}
		expr.setValue(min + ".." + maxString); //$NON-NLS-1$
	}

	public IDeployStatus validate(RequirementExpression re, ReqEvaluationContext context) {
		Requirement req = (Requirement) re.getParent();

		// TODO Is it legal to attach a cardinality RE to a non-MEMBER Requirement?
		// If not, check and report here...

		Unit target = (Unit) req.getParent();
		EClass ecSource = MultiplicityChecker.getRequirementTypeFilter(req);

		MultiplicityConstraint constraint = MultiplicityChecker.getConstraint(ecSource, target);

		// If the target doesn't specify cardinality, it implicity accepts being target of anyone
		if (constraint == null) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		int inMultiplicity = MultiplicityChecker.calculateTargetMultiplicity(target, ecSource, null);
		if (constraint.validTargetMultiplicity(inMultiplicity)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// Oh no, multiplicity failed!
		int severity = target.isConceptual() ? IStatus.INFO : IStatus.ERROR;
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				IDeployCoreValidators.CARDINALITY_IN_001,
				ICoreProblemType.GROUP_IN_CARDINALITY_INVALID,
				DeployCoreMessages.Validator_unit_0_must_be_member_of_group_1_with_cardinality_2,
				new Object[] { re.getParent().getParent(),
						((Requirement) re.getParent()).getDmoEType(), re.getValue() }, re);
		return status;

	} // end method validate()

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
}
