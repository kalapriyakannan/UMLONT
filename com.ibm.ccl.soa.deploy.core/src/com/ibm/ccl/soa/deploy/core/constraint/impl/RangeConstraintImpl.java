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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.ConvertedValue;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Range Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl#getMaxValue <em>Max
 * Value</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl#isMaxValueInclusive
 * <em>Max Value Inclusive</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl#getMinValue <em>Min
 * Value</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl#isMinValueInclusive
 * <em>Min Value Inclusive</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RangeConstraintImpl extends AttributeValueConstraintImpl implements RangeConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Transient MIN value as Object.
	 * 
	 * @generated NOT
	 */
	protected Object objectMinValue;

	/**
	 * Transient MAX value as Object.
	 * 
	 * @generated NOT
	 */
	protected Object objectMaxValue;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_VALUE_EDEFAULT = null;
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
	 * The default value of the '{@link #isMaxValueInclusive() <em>Max Value Inclusive</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMaxValueInclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAX_VALUE_INCLUSIVE_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isMaxValueInclusive() <em>Max Value Inclusive</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMaxValueInclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean maxValueInclusive = MAX_VALUE_INCLUSIVE_EDEFAULT;
	/**
	 * This is true if the Max Value Inclusive attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean maxValueInclusiveESet;
	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_VALUE_EDEFAULT = null;
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
	 * The default value of the '{@link #isMinValueInclusive() <em>Min Value Inclusive</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMinValueInclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MIN_VALUE_INCLUSIVE_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isMinValueInclusive() <em>Min Value Inclusive</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMinValueInclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean minValueInclusive = MIN_VALUE_INCLUSIVE_EDEFAULT;
	/**
	 * This is true if the Min Value Inclusive attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean minValueInclusiveESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RangeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.RANGE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setMaxValue(String newMaxValue) {
		// invalidate transient value
		objectMaxValue = null;

		String oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE, oldMaxValue, maxValue));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMaxValueInclusive() {
		return maxValueInclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMaxValueInclusive(boolean newMaxValueInclusive) {
		boolean oldMaxValueInclusive = maxValueInclusive;
		maxValueInclusive = newMaxValueInclusive;
		boolean oldMaxValueInclusiveESet = maxValueInclusiveESet;
		maxValueInclusiveESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE, oldMaxValueInclusive,
					maxValueInclusive, !oldMaxValueInclusiveESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetMaxValueInclusive() {
		boolean oldMaxValueInclusive = maxValueInclusive;
		boolean oldMaxValueInclusiveESet = maxValueInclusiveESet;
		maxValueInclusive = MAX_VALUE_INCLUSIVE_EDEFAULT;
		maxValueInclusiveESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE, oldMaxValueInclusive,
					MAX_VALUE_INCLUSIVE_EDEFAULT, oldMaxValueInclusiveESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMaxValueInclusive() {
		return maxValueInclusiveESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setMinValue(String newMinValue) {
		// invalidate transient value
		objectMinValue = null;

		String oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE, oldMinValue, minValue));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMinValueInclusive() {
		return minValueInclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMinValueInclusive(boolean newMinValueInclusive) {
		boolean oldMinValueInclusive = minValueInclusive;
		minValueInclusive = newMinValueInclusive;
		boolean oldMinValueInclusiveESet = minValueInclusiveESet;
		minValueInclusiveESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE, oldMinValueInclusive,
					minValueInclusive, !oldMinValueInclusiveESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetMinValueInclusive() {
		boolean oldMinValueInclusive = minValueInclusive;
		boolean oldMinValueInclusiveESet = minValueInclusiveESet;
		minValueInclusive = MIN_VALUE_INCLUSIVE_EDEFAULT;
		minValueInclusiveESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE, oldMinValueInclusive,
					MIN_VALUE_INCLUSIVE_EDEFAULT, oldMinValueInclusiveESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMinValueInclusive() {
		return minValueInclusiveESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE:
			return getMaxValue();
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE:
			return isMaxValueInclusive() ? Boolean.TRUE : Boolean.FALSE;
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE:
			return getMinValue();
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE:
			return isMinValueInclusive() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE:
			setMaxValue((String) newValue);
			return;
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE:
			setMaxValueInclusive(((Boolean) newValue).booleanValue());
			return;
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE:
			setMinValue((String) newValue);
			return;
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE:
			setMinValueInclusive(((Boolean) newValue).booleanValue());
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE:
			setMaxValue(MAX_VALUE_EDEFAULT);
			return;
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE:
			unsetMaxValueInclusive();
			return;
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE:
			setMinValue(MIN_VALUE_EDEFAULT);
			return;
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE:
			unsetMinValueInclusive();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE:
			return MAX_VALUE_EDEFAULT == null ? maxValue != null : !MAX_VALUE_EDEFAULT
					.equals(maxValue);
		case ConstraintPackage.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE:
			return isSetMaxValueInclusive();
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE:
			return MIN_VALUE_EDEFAULT == null ? minValue != null : !MIN_VALUE_EDEFAULT
					.equals(minValue);
		case ConstraintPackage.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE:
			return isSetMinValueInclusive();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maxValue: "); //$NON-NLS-1$
		result.append(maxValue);
		result.append(", maxValueInclusive: "); //$NON-NLS-1$
		if (maxValueInclusiveESet) {
			result.append(maxValueInclusive);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", minValue: "); //$NON-NLS-1$
		result.append(minValue);
		result.append(", minValueInclusive: "); //$NON-NLS-1$
		if (minValueInclusiveESet) {
			result.append(minValueInclusive);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns MIN value of the attribute as Object. Returns NULL if the actual EDataType of the
	 * attribute can not be figured out, and therefore String value can not be converted into Object
	 * (e.g., if the 'attributeName' is not set, or if the constraint refers to an extended attribute
	 * and the actual validation context is known known).
	 * 
	 * @return MIN value of the attribute as Object
	 * 
	 * @generated NOT
	 */
	public Object getMinValueObject() {
		if (objectMinValue != null) {
			return objectMinValue;
		}
		if (minValue == null || minValue.trim().length() == 0) {
			return null;
		}
		EDataType edt = getEDataType();
		if (edt != null) {
			try {
				objectMinValue = EcoreUtil.createFromString(edt, getMinValue());
			} catch (NumberFormatException e) {
				ConvertedValue cValue = ConvertedValue.parse(getMinValue(), edt);
				objectMaxValue = cValue.deconvert();
			}
			return objectMinValue;
		}
		return null;
	}

	/**
	 * Sets MIN value of the attribute, using value as Object. The implementation tries to figure out
	 * EDataType of the attribute, in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object value to its String representation. If EDataType can not be figured out (e.g., if the
	 * 'attributeName' is not set, or if the constraint refers to an extended attribute and the
	 * actual validation context is known known), standard Java Object serialization
	 * {@link Object#toString()} is used.
	 * 
	 * @param newValue
	 *           MIN value as Object
	 * 
	 * @return true if EDataType was used to serialize the value (the correct way of Object
	 *         serialization); false otherwise (the value may not have serialized properly)
	 * 
	 * @generated NOT
	 */
	public boolean setMinValueObject(Object newValue) {
		if (newValue == null) {
			setMinValue(null);
			objectMinValue = null;
			return true;
		}
		EDataType edt = getEDataType();
		if (edt != null) {
			setMinValue(EcoreUtil.convertToString(edt, newValue));
			objectMinValue = newValue;
			return true;
		} else {
			// newValue is not NULL
			setMinValue(newValue.toString());
			objectMinValue = newValue;
			return false;
		}
	}

	/**
	 * Returns MAX value of the attribute as Object. Returns NULL if the actual EDataType of the
	 * attribute can not be figured out, and therefore String value can not be converted into Object
	 * (e.g., if the 'attributeName' is not set, or if the constraint refers to an extended attribute
	 * and the actual validation context is known known).
	 * 
	 * @return MAX value of the attribute as Object
	 * 
	 * @generated NOT
	 */
	public Object getMaxValueObject() {
		if (objectMaxValue != null) {
			return objectMaxValue;
		}
		if (maxValue == null || maxValue.trim().length() == 0) {
			return null;
		}
		EDataType edt = getEDataType();
		if (edt != null) {
			try {
				objectMaxValue = EcoreUtil.createFromString(edt, getMaxValue());
			} catch (NumberFormatException e) {
				ConvertedValue cValue = ConvertedValue.parse(getMaxValue(), edt);
				objectMaxValue = cValue.deconvert();
			}
			return objectMaxValue;
		}
		return null;
	}

	/**
	 * Sets MAX value of the attribute, using value as Object. The implementation tries to figure out
	 * EDataType of the attribute, in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object value to its String representation. If EDataType can not be figured out (e.g., if the
	 * 'attributeName' is not set, or if the constraint refers to an extended attribute and the
	 * actual validation context is known known), standard Java Object serialization
	 * {@link Object#toString()} is used.
	 * 
	 * @param newValue
	 *           MAX value as Object
	 * 
	 * @return true if EDataType was used to serialize the value (the correct way of Object
	 *         serialization); false otherwise (the value may not have serialized properly)
	 * 
	 * @generated NOT
	 */
	public boolean setMaxValueObject(Object newValue) {
		if (newValue == null) {
			setMaxValue(null);
			objectMaxValue = null;
			return true;
		}
		EDataType edt = getEDataType();
		if (edt != null) {
			setMaxValue(EcoreUtil.convertToString(edt, newValue));
			objectMaxValue = newValue;
			return true;
		} else {
			// newValue is not NULL
			setMaxValue(newValue.toString());
			objectMaxValue = newValue;
			return false;
		}
	}

	/**
	 * @generated NOT
	 */
	public void setAttributeName(String newAttributeName) {
		// need to invalidate transient Object values
		objectMinValue = null;
		objectMaxValue = null;
		super.setAttributeName(newAttributeName);
	}

} //RangeConstraintImpl
