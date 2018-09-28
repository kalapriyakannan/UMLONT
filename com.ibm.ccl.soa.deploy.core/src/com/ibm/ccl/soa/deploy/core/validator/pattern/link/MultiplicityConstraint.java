/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import org.eclipse.emf.ecore.EClass;

/**
 * Multiplicity constraint for a relationship.
 */
public class MultiplicityConstraint {

	private final EClass sourceType;
	private final int sourceMinOccurs;
	private final int sourceMaxOccurs;
	private final EClass targetType;
	private final int targetMinOccurs;
	private final int targetMaxOccurs;

	/**
	 * For the min/max, -2 means invalid or always fail
	 * 
	 * @param sourceType
	 * @param sourceMinOccurs
	 * @param sourceMaxOccurs
	 *           (-1 for unbounded)
	 * @param targetType
	 * @param targetMinOccurs
	 * @param targetMaxOccurs
	 *           (-1 for unbounded)
	 */
	public MultiplicityConstraint(EClass sourceType, int sourceMinOccurs, int sourceMaxOccurs,
			EClass targetType, int targetMinOccurs, int targetMaxOccurs) {
		if (sourceMinOccurs == -2) {
			sourceMinOccurs = Integer.MAX_VALUE;
		}
		if (targetMinOccurs == -2) {
			targetMinOccurs = Integer.MAX_VALUE;
		}

		assert sourceMinOccurs >= 0;
		assert targetMinOccurs >= 0;

		this.sourceType = sourceType;
		this.sourceMinOccurs = sourceMinOccurs;
		this.sourceMaxOccurs = sourceMaxOccurs;
		this.targetType = targetType;
		this.targetMinOccurs = targetMinOccurs;
		this.targetMaxOccurs = targetMaxOccurs;
	}

	EClass getSourceType() {
		return sourceType;
	}

	int sourceMinOccurs() {
		return sourceMinOccurs;
	}

	int sourceMaxOccurs() {
		return (sourceMaxOccurs < 0) ? Integer.MAX_VALUE : sourceMaxOccurs;
	}

	EClass getTargetType() {
		return targetType;
	}

	int targetMinOccurs() {
		return targetMinOccurs;
	}

	int targetMaxOccurs() {
		return (targetMaxOccurs < 0) ? Integer.MAX_VALUE : targetMaxOccurs;
	}

	/**
	 * @param n
	 * @return <code>true</code> if n is in range [minOccurs..maxOccurs]
	 */
	public boolean validSourceMultiplicity(int n) {
		return sourceMinOccurs() <= n && n <= sourceMaxOccurs();
	}

	/**
	 * @param n
	 * @return <code>true</code> if n is in range [minOccurs..maxOccurs]
	 */
	public boolean validTargetMultiplicity(int n) {
		return targetMinOccurs() <= n && n <= targetMaxOccurs();
	}

	/**
	 * @param ecSource
	 * @param ecTarget
	 * @return <code>true</code> if this constraint applies to this EClass pair
	 */
	public boolean constraintForPair(EClass ecSource, EClass ecTarget) {
		assert ecSource != null;
		assert ecTarget != null;
		return ecSource.isSuperTypeOf(getSourceType()) && ecTarget.isSuperTypeOf(getTargetType());
	}

//	/**
//	 * @param source
//	 * @param target
//	 * @return <code>true</code> if this constraint applies to this pair
//	 */
//	public boolean constraintForPair(Unit source, Unit target) {
//		return getSourceType().isInstance(source) &&
//			getTargetType().isInstance(target);
//	}

} // MultiplicityConstraint
