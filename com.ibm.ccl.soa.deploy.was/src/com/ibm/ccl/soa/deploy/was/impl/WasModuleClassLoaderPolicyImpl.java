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

import com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Module Class Loader Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasModuleClassLoaderPolicyImpl#getStartWeight <em>Start Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasModuleClassLoaderPolicyImpl extends WasClassLoaderPolicyImpl implements
		WasModuleClassLoaderPolicy {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getStartWeight() <em>Start Weight</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int START_WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartWeight() <em>Start Weight</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartWeight()
	 * @generated
	 * @ordered
	 */
	protected int startWeight = START_WEIGHT_EDEFAULT;

	/**
	 * This is true if the Start Weight attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startWeightESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasModuleClassLoaderPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_MODULE_CLASS_LOADER_POLICY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartWeight() {
		return startWeight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartWeight(int newStartWeight) {
		int oldStartWeight = startWeight;
		startWeight = newStartWeight;
		boolean oldStartWeightESet = startWeightESet;
		startWeightESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT, oldStartWeight, startWeight, !oldStartWeightESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartWeight() {
		int oldStartWeight = startWeight;
		boolean oldStartWeightESet = startWeightESet;
		startWeight = START_WEIGHT_EDEFAULT;
		startWeightESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT, oldStartWeight, START_WEIGHT_EDEFAULT, oldStartWeightESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartWeight() {
		return startWeightESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT:
				return new Integer(getStartWeight());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT:
				setStartWeight(((Integer)newValue).intValue());
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
			case WasPackage.WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT:
				unsetStartWeight();
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
			case WasPackage.WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT:
				return isSetStartWeight();
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
		result.append(" (startWeight: "); //$NON-NLS-1$
		if (startWeightESet) result.append(startWeight); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasModuleClassLoaderPolicyImpl
