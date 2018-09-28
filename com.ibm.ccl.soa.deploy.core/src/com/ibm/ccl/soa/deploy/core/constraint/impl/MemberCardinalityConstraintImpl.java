/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Member Cardinality Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.MemberCardinalityConstraintImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.MemberCardinalityConstraintImpl#getMinValue <em>Min Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemberCardinalityConstraintImpl extends ConstraintImpl implements
		MemberCardinalityConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_VALUE_EDEFAULT = "unbounded"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected String maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * This is true if the Max Value attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxValueESet;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_VALUE_EDEFAULT = "0"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected String minValue = MIN_VALUE_EDEFAULT;

	/**
	 * This is true if the Min Value attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minValueESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberCardinalityConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(String newMaxValue) {
		String oldMaxValue = maxValue;
		maxValue = newMaxValue;
		boolean oldMaxValueESet = maxValueESet;
		maxValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE, oldMaxValue, maxValue, !oldMaxValueESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxValue() {
		String oldMaxValue = maxValue;
		boolean oldMaxValueESet = maxValueESet;
		maxValue = MAX_VALUE_EDEFAULT;
		maxValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE, oldMaxValue, MAX_VALUE_EDEFAULT, oldMaxValueESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxValue() {
		return maxValueESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(String newMinValue) {
		String oldMinValue = minValue;
		minValue = newMinValue;
		boolean oldMinValueESet = minValueESet;
		minValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE, oldMinValue, minValue, !oldMinValueESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinValue() {
		String oldMinValue = minValue;
		boolean oldMinValueESet = minValueESet;
		minValue = MIN_VALUE_EDEFAULT;
		minValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE, oldMinValue, MIN_VALUE_EDEFAULT, oldMinValueESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinValue() {
		return minValueESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE:
				return getMaxValue();
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE:
				return getMinValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE:
				setMaxValue((String)newValue);
				return;
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE:
				setMinValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE:
				unsetMaxValue();
				return;
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE:
				unsetMinValue();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE:
				return isSetMaxValue();
			case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE:
				return isSetMinValue();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maxValue: "); //$NON-NLS-1$
		if (maxValueESet) result.append(maxValue); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", minValue: "); //$NON-NLS-1$
		if (minValueESet) result.append(minValue); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}
} //MemberCardinalityConstraintImpl
