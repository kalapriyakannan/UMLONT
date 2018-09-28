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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonRequirementExpressionInterpreter;

/**
 * Constraint Service that manages the objects defined in the 'constraints' extension point.
 * Provided methods to validate a constraint and other constraint-related methods.
 * 
 * Implementation assumes that ConstraintManager loads all constraint extension declarations at
 * start-up.
 */
public class RequirementExpressionService {

	private final Map<String, IRequirementExpressionInterpreter> reInterpreters = new ConcurrentHashMap<String, IRequirementExpressionInterpreter>();

	/**
	 * Shared instance of the Constraint Service.
	 */
	public static final RequirementExpressionService INSTANCE = new RequirementExpressionService();

	/**
	 * Public constructor.
	 */
	public RequirementExpressionService() {
		reInterpreters.put(Equals.INTERPRETER_ID, new Equals());
		reInterpreters.put(GreaterThanEquals.INTERPRETER_ID, new GreaterThanEquals());
		reInterpreters.put(GreaterThan.INTERPRETER_ID, new GreaterThan());
		reInterpreters.put(LessThanEquals.INTERPRETER_ID, new LessThanEquals());
		reInterpreters.put(LessThan.INTERPRETER_ID, new LessThan());
		reInterpreters.put(Version.INTERPRETER_ID, new Version());
		reInterpreters.put(InCardinality.INTERPRETER_ID, new InCardinality());
		reInterpreters.put(OutCardinality.INTERPRETER_ID, new OutCardinality());
	}

	/**
	 * Returns the RE interpreter names.
	 * 
	 * @return an array of interpreter names (never null).
	 */
	public String[] getExpressionInterpreterNames() {
		return reInterpreters.keySet().toArray(new String[reInterpreters.size()]);
	}

	/**
	 * Returns the interpreter for a requirement expression.
	 * 
	 * @param expr
	 *           a requirement expression.
	 * 
	 * @return the interpreter descriptor, or a {@link SkeletonRequirementExpressionInterpreter}, if
	 *         none is found. Never returns null.
	 */
	public IRequirementExpressionInterpreter getExpressionInterpreter(RequirementExpression expr) {
		if (expr == null || expr.getInterpreter() == null) {
			return SkeletonRequirementExpressionInterpreter.INSTANCE;
		}
		return getExpressionInterpreter(expr.getInterpreter());
	}

	/**
	 * Returns the interpreter mapped to the interpreter's name.
	 * 
	 * @param name
	 * 
	 * @return the interpreter descriptor, or a {@link SkeletonRequirementExpressionInterpreter}, if
	 *         none is found. Never returns null.
	 */
	public IRequirementExpressionInterpreter getExpressionInterpreter(String name) {
		IRequirementExpressionInterpreter interp = reInterpreters.get(name);
		if (interp != null) {
			return interp;
		}
		return SkeletonRequirementExpressionInterpreter.INSTANCE;
	}
}
