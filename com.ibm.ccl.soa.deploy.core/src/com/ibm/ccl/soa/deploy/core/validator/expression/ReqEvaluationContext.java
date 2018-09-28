/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.expression;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * The 'scope' for evaluating an {@link IRequirementExpressionInterpreter}.
 * 
 * <p>
 * If an IRequirementExpressionInterpreter is attached to a Requirement with a Capability etype,
 * then getCapability() will make an instance of that capability available. If the etype is a Unit,
 * getUnit() will make an instance of that unit available.
 * 
 * <p>
 * EvaluationContext is something of a 'union' of context instances, typically one or both fields
 * will be <code>null</code>.
 */
public class ReqEvaluationContext {

	private final Capability cap;
	private final Unit unit;

	/**
	 * Constructor if context is to operation on a Unit (the interpreter RE is attached to a
	 * requirement with Unit etype)
	 * 
	 * @param unit
	 */
	public ReqEvaluationContext(Unit unit) {
		this.unit = unit;
		this.cap = null;
	}

	/**
	 * Constructor if context is to operation on a Capability (the interpreter RE is attached to a
	 * requirement with Capability etype)
	 * 
	 * @param cap
	 */
	public ReqEvaluationContext(Capability cap) {
		this.unit = null;
		this.cap = cap;
	}

	/**
	 * @return instance of Capability type the owning {@link Requirement} must match against
	 */
	public Capability getCapability() {
		return cap;
	}

	/**
	 * @return instance of Unit type the owning {@link Unit} must match against
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @return the {@link Unit} or {@link Capability} that is the target context.
	 */
	public DeployModelObject getValue() {
		if (unit == null) {
			return cap;
		}
		return unit;
	}

	/**
	 * @param ec
	 * @return <code>true</code> if at least one context offered is an instance of 'ec'
	 */
	public boolean isCompatible(EClass ec) {
		if (cap != null) {
			return ec.isInstance(cap);
		} else if (unit != null) {
			return ec.isInstance(unit);
		} else {
			// should never reach here
			throw new InternalError();
		}
	}

	/**
	 * @return EClass of the object representing this context.
	 */
	public EClass getDmoEType() {
		if (cap != null) {
			return cap.eClass();
		} else if (unit != null) {
			return unit.eClass();
		} else {
			// should never reach here
			throw new InternalError();
		}
	}

	/**
	 * @return true of context belongs to a conceptual Unit, and therefore itself is conceptual.
	 */
	public boolean isConceptual() {
		if (cap != null) {
			return ValidatorUtils.getUnit(cap).isConceptual();
		} else if (unit != null) {
			return unit.isConceptual();
		} else {
			// should never reach here
			throw new InternalError();
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + (cap == null ? "null" : cap.getName()) + ',' + (unit == null ? "null" : unit.getName()) + ']';//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}
