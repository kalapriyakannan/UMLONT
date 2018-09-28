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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Single Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SingleValueImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SingleValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleValueImpl extends EObjectImpl implements SingleValue {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	protected SingleValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.SINGLE_VALUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.SINGLE_VALUE__DESCRIPTION, oldDescription, description));
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
					ConstraintPackage.SINGLE_VALUE__VALUE, oldValue, value));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.SINGLE_VALUE__DESCRIPTION:
				return getDescription();
			case ConstraintPackage.SINGLE_VALUE__VALUE:
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
			case ConstraintPackage.SINGLE_VALUE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ConstraintPackage.SINGLE_VALUE__VALUE:
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
			case ConstraintPackage.SINGLE_VALUE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ConstraintPackage.SINGLE_VALUE__VALUE:
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
			case ConstraintPackage.SINGLE_VALUE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ConstraintPackage.SINGLE_VALUE__VALUE:
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
		result.append(" (description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns 'value' as Object. Returns NULL if the actual EDataType of 'value' can not be figured
	 * out, and therefore string can not be converted into an Object (e.g., if this SingleValue
	 * object is not contained in an AttributeValueConstraint, or if the 'attributeName' on the AVC
	 * is not set, or if the constraint refers to an extended attribute and the actual validation
	 * context is known known).
	 * 
	 * @return 'value' as Object
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
		EObject parent = eContainer();
		if (parent instanceof AttributeValueConstraintImpl) {
			EDataType edt = ((AttributeValueConstraintImpl) parent).getEDataType();
			if (edt != null) {
				objectValue = EcoreUtil.createFromString(edt, getValue());
				return objectValue;
			}
		}
		return null;
	}

	/**
	 * Sets 'value', using its Object representation. The implementation tries to figure out
	 * EDataType of 'value' (by looking at the parent AttributeValue Constraint and the type of the
	 * constrained attribute), in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object to a correct string representation. If EDataType can not be figured out (e.g., if this
	 * SingleValue object is not contained in an AttributeValueConstraint, or if the 'attributeName'
	 * on the AVC is not set, or if the constraint refers to an extended attribute and the actual
	 * validation context is known known), standard Java Object serialization
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
		EObject parent = eContainer();
		if (parent instanceof AttributeValueConstraintImpl) {
			EDataType edt = ((AttributeValueConstraintImpl) parent).getEDataType();
			if (edt != null) {
				setValue(EcoreUtil.convertToString(edt, newValue));
				objectValue = newValue;
				return true;
			}
		}
		// newValue is not NULL
		setValue(newValue.toString());
		objectValue = newValue;
		return false;
	}

} //SingleValueImpl
