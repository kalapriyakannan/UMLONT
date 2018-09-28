package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * Provides a common base interface for constraints to extend if they can legally contain children
 * and for other constraints to declare if they can be evaluated as children of another constraint.
 * 
 * @see BooleanOperator
 * @see TypeConstraint
 * 
 */
public interface Parentable {

}
