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
import com.ibm.ccl.soa.deploy.was.WasWebServerPlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Web Server Plugin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerPluginImpl#getInstallLocation <em>Install Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasWebServerPluginImpl extends CapabilityImpl implements WasWebServerPlugin {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected String installLocation = INSTALL_LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasWebServerPluginImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_WEB_SERVER_PLUGIN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallLocation() {
		return installLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallLocation(String newInstallLocation) {
		String oldInstallLocation = installLocation;
		installLocation = newInstallLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_PLUGIN__INSTALL_LOCATION, oldInstallLocation, installLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER_PLUGIN__INSTALL_LOCATION:
				return getInstallLocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER_PLUGIN__INSTALL_LOCATION:
				setInstallLocation((String)newValue);
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
			case WasPackage.WAS_WEB_SERVER_PLUGIN__INSTALL_LOCATION:
				setInstallLocation(INSTALL_LOCATION_EDEFAULT);
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
			case WasPackage.WAS_WEB_SERVER_PLUGIN__INSTALL_LOCATION:
				return INSTALL_LOCATION_EDEFAULT == null ? installLocation != null : !INSTALL_LOCATION_EDEFAULT.equals(installLocation);
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
		result.append(" (installLocation: "); //$NON-NLS-1$
		result.append(installLocation);
		result.append(')');
		return result.toString();
	}

} //WasWebServerPluginImpl
