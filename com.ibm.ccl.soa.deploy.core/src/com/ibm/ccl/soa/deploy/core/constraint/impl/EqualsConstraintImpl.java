/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: EqualsConstraintImpl.java,v 1.4 2008/04/23 19:19:59 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Equals Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.EqualsConstraintImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EqualsConstraintImpl extends AttributeValueConstraintImpl implements EqualsConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * Transient value as Object.
	 * 
	 * @generated NOT
	 */
	protected Object objectValue;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EqualsConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.EQUALS_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setValue(String newValue) {
		// invalidate transient value
		objectValue = null;

		String oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.EQUALS_CONSTRAINT__VALUE, oldValue, value));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.EQUALS_CONSTRAINT__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.EQUALS_CONSTRAINT__VALUE:
				setValue((String)newValue);
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
			case ConstraintPackage.EQUALS_CONSTRAINT__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ConstraintPackage.EQUALS_CONSTRAINT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns required value of the attribute as Object. Returns NULL if the actual EDataType of the
	 * attribute can not be figured out, and therefore String value can not be converted into Object
	 * (e.g., if the 'attributeName' is not set, or if the constraint refers to an extended attribute
	 * and the actual validation context is known known).
	 * 
	 * @return required value of the attribute as Object
	 * 
	 * @generated NOT
	 */
	public Object getValueObject() {
		if (objectValue != null) {
			return objectValue;
		}
		if (value == null || value.trim().length() == 0) {
			return null;
		}
		EDataType edt = getEDataType();
		if (edt != null) {
			objectValue = EcoreUtil.createFromString(edt, getValue());
			return objectValue;
		}
		return null;
	}

	/**
	 * Sets required value of the attribute, using value as Object. The implementation tries to
	 * figure out EDataType of the attribute, in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object value to its String representation. If EDataType can not be figured out (e.g., if the
	 * 'attributeName' is not set, or if the constraint refers to an extended attribute and the
	 * actual validation context is known known), standard Java Object serialization
	 * {@link Object#toString()} is used.
	 * 
	 * @param newValue
	 *           value as Object
	 * 
	 * @return true if EDataType was used to serialize the value (the correct way of Object
	 *         serialization); false otherwise (the value may not have serialized properly)
	 * 
	 * @generated NOT
	 */
	public boolean setValueObject(Object newValue) {
		if (newValue == null) {
			setValue(null);
			objectValue = null;
			return true;
		}
		EDataType edt = getEDataType();
		if (edt != null) {
			setValue(EcoreUtil.convertToString(edt, newValue));
			objectValue = newValue;
			return true;
		} else {
			// newValue is not NULL
			setValue(newValue.toString());
			objectValue = newValue;
			return false;
		}
	}

	/**
	 * @generated NOT
	 */
	public void setAttributeName(String newAttributeName) {
		// need to invalidate transient Object values
		objectValue = null;
		super.setAttributeName(newAttributeName);
	}

} //EqualsConstraintImpl
