/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl#getInterpreter <em>Interpreter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl#getUse <em>Use</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementExpressionImpl extends ConstraintImpl implements RequirementExpression {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterpreter() <em>Interpreter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInterpreter()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERPRETER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterpreter() <em>Interpreter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInterpreter()
	 * @generated
	 * @ordered
	 */
	protected String interpreter = INTERPRETER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUse() <em>Use</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected static final RequirementExpressionUsage USE_EDEFAULT = RequirementExpressionUsage.REQUIRED_LITERAL;

	/**
	 * The cached value of the '{@link #getUse() <em>Use</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected RequirementExpressionUsage use = USE_EDEFAULT;

	/**
	 * This is true if the Use attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useESet;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.REQUIREMENT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterpreter() {
		return interpreter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpreter(String newInterpreter) {
		String oldInterpreter = interpreter;
		interpreter = newInterpreter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT_EXPRESSION__INTERPRETER, oldInterpreter, interpreter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementExpressionUsage getUse() {
		return use;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUse(RequirementExpressionUsage newUse) {
		RequirementExpressionUsage oldUse = use;
		use = newUse == null ? USE_EDEFAULT : newUse;
		boolean oldUseESet = useESet;
		useESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT_EXPRESSION__USE, oldUse, use, !oldUseESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUse() {
		RequirementExpressionUsage oldUse = use;
		boolean oldUseESet = useESet;
		use = USE_EDEFAULT;
		useESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.REQUIREMENT_EXPRESSION__USE, oldUse, USE_EDEFAULT, oldUseESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUse() {
		return useESet;
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
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT_EXPRESSION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME:
				return getAttributeName();
			case CorePackage.REQUIREMENT_EXPRESSION__INTERPRETER:
				return getInterpreter();
			case CorePackage.REQUIREMENT_EXPRESSION__USE:
				return getUse();
			case CorePackage.REQUIREMENT_EXPRESSION__VALUE:
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
			case CorePackage.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case CorePackage.REQUIREMENT_EXPRESSION__INTERPRETER:
				setInterpreter((String)newValue);
				return;
			case CorePackage.REQUIREMENT_EXPRESSION__USE:
				setUse((RequirementExpressionUsage)newValue);
				return;
			case CorePackage.REQUIREMENT_EXPRESSION__VALUE:
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
			case CorePackage.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case CorePackage.REQUIREMENT_EXPRESSION__INTERPRETER:
				setInterpreter(INTERPRETER_EDEFAULT);
				return;
			case CorePackage.REQUIREMENT_EXPRESSION__USE:
				unsetUse();
				return;
			case CorePackage.REQUIREMENT_EXPRESSION__VALUE:
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
			case CorePackage.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case CorePackage.REQUIREMENT_EXPRESSION__INTERPRETER:
				return INTERPRETER_EDEFAULT == null ? interpreter != null : !INTERPRETER_EDEFAULT.equals(interpreter);
			case CorePackage.REQUIREMENT_EXPRESSION__USE:
				return isSetUse();
			case CorePackage.REQUIREMENT_EXPRESSION__VALUE:
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
		result.append(" (attributeName: "); //$NON-NLS-1$
		result.append(attributeName);
		result.append(", interpreter: "); //$NON-NLS-1$
		result.append(interpreter);
		result.append(", use: "); //$NON-NLS-1$
		if (useESet) result.append(use); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //RequirementAttributeImpl
