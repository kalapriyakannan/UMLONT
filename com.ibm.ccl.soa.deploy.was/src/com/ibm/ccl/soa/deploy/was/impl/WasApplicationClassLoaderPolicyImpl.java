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

import com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Application Class Loader Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasApplicationClassLoaderPolicyImpl#isReloadClasses <em>Reload Classes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasApplicationClassLoaderPolicyImpl#getReloadInterval <em>Reload Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasApplicationClassLoaderPolicyImpl extends WasClassLoaderPolicyImpl implements
		WasApplicationClassLoaderPolicy {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isReloadClasses() <em>Reload Classes</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReloadClasses()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RELOAD_CLASSES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReloadClasses() <em>Reload Classes</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReloadClasses()
	 * @generated
	 * @ordered
	 */
	protected boolean reloadClasses = RELOAD_CLASSES_EDEFAULT;

	/**
	 * This is true if the Reload Classes attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reloadClassesESet;

	/**
	 * The default value of the '{@link #getReloadInterval() <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReloadInterval()
	 * @generated
	 * @ordered
	 */
	protected static final int RELOAD_INTERVAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReloadInterval() <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReloadInterval()
	 * @generated
	 * @ordered
	 */
	protected int reloadInterval = RELOAD_INTERVAL_EDEFAULT;

	/**
	 * This is true if the Reload Interval attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reloadIntervalESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasApplicationClassLoaderPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_APPLICATION_CLASS_LOADER_POLICY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReloadClasses() {
		return reloadClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReloadClasses(boolean newReloadClasses) {
		boolean oldReloadClasses = reloadClasses;
		reloadClasses = newReloadClasses;
		boolean oldReloadClassesESet = reloadClassesESet;
		reloadClassesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES, oldReloadClasses, reloadClasses, !oldReloadClassesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReloadClasses() {
		boolean oldReloadClasses = reloadClasses;
		boolean oldReloadClassesESet = reloadClassesESet;
		reloadClasses = RELOAD_CLASSES_EDEFAULT;
		reloadClassesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES, oldReloadClasses, RELOAD_CLASSES_EDEFAULT, oldReloadClassesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReloadClasses() {
		return reloadClassesESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getReloadInterval() {
		return reloadInterval;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReloadInterval(int newReloadInterval) {
		int oldReloadInterval = reloadInterval;
		reloadInterval = newReloadInterval;
		boolean oldReloadIntervalESet = reloadIntervalESet;
		reloadIntervalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL, oldReloadInterval, reloadInterval, !oldReloadIntervalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReloadInterval() {
		int oldReloadInterval = reloadInterval;
		boolean oldReloadIntervalESet = reloadIntervalESet;
		reloadInterval = RELOAD_INTERVAL_EDEFAULT;
		reloadIntervalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL, oldReloadInterval, RELOAD_INTERVAL_EDEFAULT, oldReloadIntervalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReloadInterval() {
		return reloadIntervalESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES:
				return isReloadClasses() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL:
				return new Integer(getReloadInterval());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES:
				setReloadClasses(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL:
				setReloadInterval(((Integer)newValue).intValue());
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
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES:
				unsetReloadClasses();
				return;
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL:
				unsetReloadInterval();
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
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES:
				return isSetReloadClasses();
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL:
				return isSetReloadInterval();
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
		result.append(" (reloadClasses: "); //$NON-NLS-1$
		if (reloadClassesESet) result.append(reloadClasses); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", reloadInterval: "); //$NON-NLS-1$
		if (reloadIntervalESet) result.append(reloadInterval); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasApplicationClassLoaderPolicyImpl
