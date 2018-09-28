/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.ClassloaderMode;
import com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType;
import com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Class Loader Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasClassLoaderPolicyImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasClassLoaderPolicyImpl#getPolicy <em>Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasClassLoaderPolicyImpl extends CapabilityImpl implements WasClassLoaderPolicy {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final ClassloaderMode ORDER_EDEFAULT = ClassloaderMode.PARENTFIRST_LITERAL;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected ClassloaderMode order = ORDER_EDEFAULT;

	/**
	 * This is true if the Order attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean orderESet;

	/**
	 * The default value of the '{@link #getPolicy() <em>Policy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final ClassloaderPolicyType POLICY_EDEFAULT = ClassloaderPolicyType.SINGLE_LITERAL;

	/**
	 * The cached value of the '{@link #getPolicy() <em>Policy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected ClassloaderPolicyType policy = POLICY_EDEFAULT;

	/**
	 * This is true if the Policy attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean policyESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasClassLoaderPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_CLASS_LOADER_POLICY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderMode getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(ClassloaderMode newOrder) {
		ClassloaderMode oldOrder = order;
		order = newOrder == null ? ORDER_EDEFAULT : newOrder;
		boolean oldOrderESet = orderESet;
		orderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CLASS_LOADER_POLICY__ORDER, oldOrder, order, !oldOrderESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrder() {
		ClassloaderMode oldOrder = order;
		boolean oldOrderESet = orderESet;
		order = ORDER_EDEFAULT;
		orderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_CLASS_LOADER_POLICY__ORDER, oldOrder, ORDER_EDEFAULT, oldOrderESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrder() {
		return orderESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderPolicyType getPolicy() {
		return policy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicy(ClassloaderPolicyType newPolicy) {
		ClassloaderPolicyType oldPolicy = policy;
		policy = newPolicy == null ? POLICY_EDEFAULT : newPolicy;
		boolean oldPolicyESet = policyESet;
		policyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CLASS_LOADER_POLICY__POLICY, oldPolicy, policy, !oldPolicyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPolicy() {
		ClassloaderPolicyType oldPolicy = policy;
		boolean oldPolicyESet = policyESet;
		policy = POLICY_EDEFAULT;
		policyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_CLASS_LOADER_POLICY__POLICY, oldPolicy, POLICY_EDEFAULT, oldPolicyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPolicy() {
		return policyESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_CLASS_LOADER_POLICY__ORDER:
				return getOrder();
			case WasPackage.WAS_CLASS_LOADER_POLICY__POLICY:
				return getPolicy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_CLASS_LOADER_POLICY__ORDER:
				setOrder((ClassloaderMode)newValue);
				return;
			case WasPackage.WAS_CLASS_LOADER_POLICY__POLICY:
				setPolicy((ClassloaderPolicyType)newValue);
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
			case WasPackage.WAS_CLASS_LOADER_POLICY__ORDER:
				unsetOrder();
				return;
			case WasPackage.WAS_CLASS_LOADER_POLICY__POLICY:
				unsetPolicy();
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
			case WasPackage.WAS_CLASS_LOADER_POLICY__ORDER:
				return isSetOrder();
			case WasPackage.WAS_CLASS_LOADER_POLICY__POLICY:
				return isSetPolicy();
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
		result.append(" (order: "); //$NON-NLS-1$
		if (orderESet) result.append(order); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", policy: "); //$NON-NLS-1$
		if (policyESet) result.append(policy); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasClassLoaderPolicyImpl
