/*******************************************************************************
 * Copyright (c) 2005, 2008 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.util;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.Version;

/**
 * @since 1.0
 * 
 */
public class RequirementExpressionToConstraintConversionUtils {
	public static Topology convertExpressions(Topology top) {
		for (Unit u : (List<Unit>) top.getUnits()) {
			for (Requirement r : (List<Requirement>) u.getRequirements()) {
				List<Constraint> constraintsToAdd = new ArrayList<Constraint>();
				List<RequirementExpression> resToRemove = new ArrayList<RequirementExpression>();
				for (RequirementExpression re : (List<RequirementExpression>) r.getExpressions()) {
					// Bail if there are child constraints
					if (re.getConstraints().size() > 0) {
						continue;
					}
					if (re.getInterpreter().equals(Equals.INTERPRETER_ID)) {
						resToRemove.add(re);
						EqualsConstraint ec = ConstraintFactory.eINSTANCE.createEqualsConstraint();
						copyCommonValues(ec, re);
						ec.setAttributeName(re.getAttributeName());
						ec.setValue(re.getValue());
						constraintsToAdd.add(ec);
					}
//					if (re.getInterpreter().equals(GreaterThanEquals.INTERPRETER_ID)) {
//						resToRemove.add(re);
//						RangeConstraint rc = ConstraintFactory.eINSTANCE.createRangeConstraint();
//						copyCommonValues(rc, re);
//						rc.setAttributeName(re.getAttributeName());
//						rc.setMinValue(re.getValue());
//						rc.setMinValueInclusive(true);
//						constraintsToAdd.add(rc);
//					}
//					if (re.getInterpreter().equals(GreaterThan.INTERPRETER_ID)) {
//						resToRemove.add(re);
//						RangeConstraint rc = ConstraintFactory.eINSTANCE.createRangeConstraint();
//						copyCommonValues(rc, re);
//						rc.setAttributeName(re.getAttributeName());
//						rc.setMinValue(re.getValue());
//						rc.setMinValueInclusive(false);
//						constraintsToAdd.add(rc);
//					}	
//					if (re.getInterpreter().equals(LessThanEquals.INTERPRETER_ID)) {
//						resToRemove.add(re);
//						RangeConstraint rc = ConstraintFactory.eINSTANCE.createRangeConstraint();
//						copyCommonValues(rc, re);
//						rc.setAttributeName(re.getAttributeName());
//						rc.setMaxValue(re.getValue());
//						rc.setMaxValueInclusive(true);
//						constraintsToAdd.add(rc);
//					}					
//					if (re.getInterpreter().equals(LessThan.INTERPRETER_ID)) {
//						resToRemove.add(re);
//						RangeConstraint rc = ConstraintFactory.eINSTANCE.createRangeConstraint();
//						copyCommonValues(rc, re);
//						rc.setAttributeName(re.getAttributeName());
//						rc.setMaxValue(re.getValue());
//						rc.setMaxValueInclusive(false);
//						constraintsToAdd.add(rc);
//					}
					if (re.getInterpreter().equals(OutCardinality.INTERPRETER_ID)) {
						String [] splits = re.getValue().split("\\.\\.");
						if (splits.length == 2) { 
							resToRemove.add(re);
							MemberCardinalityConstraint mcc = ConstraintFactory.eINSTANCE
									.createMemberCardinalityConstraint();
							copyCommonValues(mcc, re);
							mcc.setMinValue(splits[0]);
							if (splits[1].equals("*")) {
								mcc.setMaxValue("unbounded");
							} else {
								mcc.setMaxValue(splits[1]);
							}
							constraintsToAdd.add(mcc);
						}
					}
					if (re.getInterpreter().equals(InCardinality.INTERPRETER_ID)) {
						String [] splits = re.getValue().split("\\.\\.");
						if (splits.length == 2) { 
							resToRemove.add(re);
							GroupCardinalityConstraint gcc = ConstraintFactory.eINSTANCE
									.createGroupCardinalityConstraint();
							copyCommonValues(gcc, re);
							gcc.setMinValue(splits[0]);
							if (splits[1].equals("*")) {
								gcc.setMaxValue("unbounded");
							} else {
								gcc.setMaxValue(splits[1]);
							}
							constraintsToAdd.add(gcc);
						}
					}
					if (re.getInterpreter().equals(Version.INTERPRETER_ID)) {
						resToRemove.add(re);
						VersionConstraint vc = ConstraintFactory.eINSTANCE.createVersionConstraint();
						copyCommonValues(vc, re);
						vc.setAttributeName(re.getAttributeName());
						vc.setValue(re.getValue());
						constraintsToAdd.add(vc);
					}					
				}
				r.getExpressions().removeAll(resToRemove);
				r.getConstraints().addAll(constraintsToAdd);
			}
		}
		return top;
	}

	private static Constraint copyCommonValues(Constraint c, RequirementExpression re) {
		c.setDescription(re.getDescription());
		c.setDisplayName(re.getDisplayName());
		c.setName(re.getName());
		return c;
	}
}
