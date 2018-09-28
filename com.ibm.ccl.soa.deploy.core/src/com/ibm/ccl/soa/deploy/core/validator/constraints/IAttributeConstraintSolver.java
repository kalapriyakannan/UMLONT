package com.ibm.ccl.soa.deploy.core.validator.constraints;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * Interface implemented by {@link Constraint} solvers.
 */
public interface IAttributeConstraintSolver {

	/**
	 * Returns a list of possible attribute values to satisfy the constraint.
	 * 
	 * @param constraint
	 *           a deploy constraint.
	 * @param context
	 *           the context of resolving the constraint.
	 * @param attribute
	 *           the attribute whose valid values are requested.
	 * @return the permitted attribute values (never null).
	 */
	AttributeValues getAttributeValues(Constraint constraint, Object context, EAttribute attribute);
}
