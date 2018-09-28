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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.ibm.ccl.soa.deploy.was.Classloader;
import com.ibm.ccl.soa.deploy.was.ClassloaderMode;
import com.ibm.ccl.soa.deploy.was.WARClassloaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Classloader</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.ClassloaderImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.ClassloaderImpl#getStartWeight <em>Start Weight</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.ClassloaderImpl#getWarClassLoaderPolicy <em>War Class Loader Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassloaderImpl extends EObjectImpl implements Classloader {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final ClassloaderMode MODE_EDEFAULT = ClassloaderMode.PARENTFIRST_LITERAL;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected ClassloaderMode mode = MODE_EDEFAULT;

	/**
	 * This is true if the Mode attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean modeESet;

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
	 * The default value of the '{@link #getWarClassLoaderPolicy() <em>War Class Loader Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWarClassLoaderPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final WARClassloaderPolicy WAR_CLASS_LOADER_POLICY_EDEFAULT = WARClassloaderPolicy.MODULE_LITERAL;

	/**
	 * The cached value of the '{@link #getWarClassLoaderPolicy() <em>War Class Loader Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWarClassLoaderPolicy()
	 * @generated
	 * @ordered
	 */
	protected WARClassloaderPolicy warClassLoaderPolicy = WAR_CLASS_LOADER_POLICY_EDEFAULT;

	/**
	 * This is true if the War Class Loader Policy attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean warClassLoaderPolicyESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassloaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.CLASSLOADER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderMode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(ClassloaderMode newMode) {
		ClassloaderMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		boolean oldModeESet = modeESet;
		modeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.CLASSLOADER__MODE, oldMode, mode, !oldModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMode() {
		ClassloaderMode oldMode = mode;
		boolean oldModeESet = modeESet;
		mode = MODE_EDEFAULT;
		modeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.CLASSLOADER__MODE, oldMode, MODE_EDEFAULT, oldModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMode() {
		return modeESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.CLASSLOADER__START_WEIGHT, oldStartWeight, startWeight, !oldStartWeightESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.CLASSLOADER__START_WEIGHT, oldStartWeight, START_WEIGHT_EDEFAULT, oldStartWeightESet));
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
	public WARClassloaderPolicy getWarClassLoaderPolicy() {
		return warClassLoaderPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarClassLoaderPolicy(WARClassloaderPolicy newWarClassLoaderPolicy) {
		WARClassloaderPolicy oldWarClassLoaderPolicy = warClassLoaderPolicy;
		warClassLoaderPolicy = newWarClassLoaderPolicy == null ? WAR_CLASS_LOADER_POLICY_EDEFAULT : newWarClassLoaderPolicy;
		boolean oldWarClassLoaderPolicyESet = warClassLoaderPolicyESet;
		warClassLoaderPolicyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.CLASSLOADER__WAR_CLASS_LOADER_POLICY, oldWarClassLoaderPolicy, warClassLoaderPolicy, !oldWarClassLoaderPolicyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarClassLoaderPolicy() {
		WARClassloaderPolicy oldWarClassLoaderPolicy = warClassLoaderPolicy;
		boolean oldWarClassLoaderPolicyESet = warClassLoaderPolicyESet;
		warClassLoaderPolicy = WAR_CLASS_LOADER_POLICY_EDEFAULT;
		warClassLoaderPolicyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.CLASSLOADER__WAR_CLASS_LOADER_POLICY, oldWarClassLoaderPolicy, WAR_CLASS_LOADER_POLICY_EDEFAULT, oldWarClassLoaderPolicyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarClassLoaderPolicy() {
		return warClassLoaderPolicyESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.CLASSLOADER__MODE:
				return getMode();
			case WasPackage.CLASSLOADER__START_WEIGHT:
				return new Integer(getStartWeight());
			case WasPackage.CLASSLOADER__WAR_CLASS_LOADER_POLICY:
				return getWarClassLoaderPolicy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.CLASSLOADER__MODE:
				setMode((ClassloaderMode)newValue);
				return;
			case WasPackage.CLASSLOADER__START_WEIGHT:
				setStartWeight(((Integer)newValue).intValue());
				return;
			case WasPackage.CLASSLOADER__WAR_CLASS_LOADER_POLICY:
				setWarClassLoaderPolicy((WARClassloaderPolicy)newValue);
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
			case WasPackage.CLASSLOADER__MODE:
				unsetMode();
				return;
			case WasPackage.CLASSLOADER__START_WEIGHT:
				unsetStartWeight();
				return;
			case WasPackage.CLASSLOADER__WAR_CLASS_LOADER_POLICY:
				unsetWarClassLoaderPolicy();
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
			case WasPackage.CLASSLOADER__MODE:
				return isSetMode();
			case WasPackage.CLASSLOADER__START_WEIGHT:
				return isSetStartWeight();
			case WasPackage.CLASSLOADER__WAR_CLASS_LOADER_POLICY:
				return isSetWarClassLoaderPolicy();
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
		result.append(" (mode: "); //$NON-NLS-1$
		if (modeESet) result.append(mode); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", startWeight: "); //$NON-NLS-1$
		if (startWeightESet) result.append(startWeight); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", warClassLoaderPolicy: "); //$NON-NLS-1$
		if (warClassLoaderPolicyESet) result.append(warClassLoaderPolicy); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ClassloaderImpl
