/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: AttributeCapacityConstraintImpl.java,v 1.1 2008/06/18 22:19:10 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Capacity Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeCapacityConstraintImpl#isExclusive <em>Exclusive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeCapacityConstraintImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeCapacityConstraintImpl extends AttributeValueConstraintImpl implements AttributeCapacityConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCLUSIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean exclusive = EXCLUSIVE_EDEFAULT;

	/**
	 * This is true if the Exclusive attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean exclusiveESet;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeCapacityConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.ATTRIBUTE_CAPACITY_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExclusive() {
		return exclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExclusive(boolean newExclusive) {
		boolean oldExclusive = exclusive;
		exclusive = newExclusive;
		boolean oldExclusiveESet = exclusiveESet;
		exclusiveESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE, oldExclusive, exclusive, !oldExclusiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExclusive() {
		boolean oldExclusive = exclusive;
		boolean oldExclusiveESet = exclusiveESet;
		exclusive = EXCLUSIVE_EDEFAULT;
		exclusiveESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE, oldExclusive, EXCLUSIVE_EDEFAULT, oldExclusiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExclusive() {
		return exclusiveESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE:
				return isExclusive() ? Boolean.TRUE : Boolean.FALSE;
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE:
				setExclusive(((Boolean)newValue).booleanValue());
				return;
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE:
				setValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE:
				unsetExclusive();
				return;
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE:
				return isSetExclusive();
			case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exclusive: "); //$NON-NLS-1$
		if (exclusiveESet) result.append(exclusive); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //AttributeCapacityConstraintImpl
