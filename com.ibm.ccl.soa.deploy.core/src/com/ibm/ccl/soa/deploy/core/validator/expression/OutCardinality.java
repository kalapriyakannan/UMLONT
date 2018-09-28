/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.expression;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

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
public class OutCardinality implements IRequirementExpressionInterpreter {

	/**
	 * The name by which this interpreter will be looked up in the <domain> plugin.
	 * <p>
	 * Value={@value}
	 */
	public static final String INTERPRETER_ID = "OutCardinality"; //$NON-NLS-1$

	/**
	 * Creates an {@link OutCardinality} requirement expression.
	 * 
	 * @param min
	 *           the minimum number of group members (&ge; 0).
	 * @param max
	 *           the maximum number of group members (-1 for unbounded).
	 * @return the created requirement expression (invokers must add it to a {@link Requirement}).
	 */
	public static RequirementExpression createExpression(int min, int max) {
		RequirementExpression expr = CoreFactory.eINSTANCE.createRequirementExpression();
		expr.setName(INTERPRETER_ID);
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(INTERPRETER_ID);
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
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
		InCardinality.setCardinality(expr, min, max);
	}

	public IDeployStatus validate(RequirementExpression re, ReqEvaluationContext context) {
		Requirement req = (Requirement) re.getParent();

		// TODO Is it legal to attach a cardinality RE to a non-MEMBER Requirement?
		// If not, check and report here...

//		Unit source = (Unit) req.getParent();
		EClass ecTarget = MultiplicityChecker.getRequirementTypeFilter(req);

		MultiplicityConstraint constraint = MultiplicityChecker.getConstraint(req, ecTarget);

		// If the target doesn't specify cardinality, it implicitly accepts being target of anyone
		if (constraint == null) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		Unit source = (Unit) req.getParent();
		int outMultiplicity = MultiplicityChecker.calculateSourceMultiplicity(source, ecTarget, null);
		if (constraint.validSourceMultiplicity(outMultiplicity)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// Oh no, multiplicity failed!
		int severity = source.isConceptual() ? IStatus.INFO : IStatus.ERROR;
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				IDeployCoreValidators.CARDINALITY_OUT_001,
				ICoreProblemType.GROUP_OUT_CARDINALITY_INVALID,
				DeployCoreMessages.Validator_group_0_requires_1_members_of_type_2_has_3, new Object[] {
						re.getParent().getParent(), re.getValue(),
						((Requirement) re.getParent()).getDmoEType(), new Integer(outMultiplicity) }, re);
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
