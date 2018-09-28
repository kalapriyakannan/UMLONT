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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasPluginAdmin;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Plugin Admin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasPluginAdminImpl#getWasPluginVersion <em>Was Plugin Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasPluginAdminImpl extends CapabilityImpl implements WasPluginAdmin {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getWasPluginVersion() <em>Was Plugin Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWasPluginVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_PLUGIN_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasPluginVersion() <em>Was Plugin Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWasPluginVersion()
	 * @generated
	 * @ordered
	 */
	protected String wasPluginVersion = WAS_PLUGIN_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasPluginAdminImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_PLUGIN_ADMIN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasPluginVersion() {
		return wasPluginVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasPluginVersion(String newWasPluginVersion) {
		String oldWasPluginVersion = wasPluginVersion;
		wasPluginVersion = newWasPluginVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_PLUGIN_ADMIN__WAS_PLUGIN_VERSION, oldWasPluginVersion, wasPluginVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_PLUGIN_ADMIN__WAS_PLUGIN_VERSION:
				return getWasPluginVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_PLUGIN_ADMIN__WAS_PLUGIN_VERSION:
				setWasPluginVersion((String)newValue);
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
			case WasPackage.WAS_PLUGIN_ADMIN__WAS_PLUGIN_VERSION:
				setWasPluginVersion(WAS_PLUGIN_VERSION_EDEFAULT);
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
			case WasPackage.WAS_PLUGIN_ADMIN__WAS_PLUGIN_VERSION:
				return WAS_PLUGIN_VERSION_EDEFAULT == null ? wasPluginVersion != null : !WAS_PLUGIN_VERSION_EDEFAULT.equals(wasPluginVersion);
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
		result.append(" (wasPluginVersion: "); //$NON-NLS-1$
		result.append(wasPluginVersion);
		result.append(')');
		return result.toString();
	}

} //WasPluginAdminImpl
