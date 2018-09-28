/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasServerImpl#getServerName <em>Server Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasServerImpl#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasServerImpl extends WasJ2EEServerImpl implements WasServer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getServerName() <em>Server Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerName() <em>Server Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected String serverName = SERVER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected String wasVersion = WAS_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerName(String newServerName) {
		String oldServerName = serverName;
		serverName = newServerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SERVER__SERVER_NAME, oldServerName, serverName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasVersion() {
		return wasVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasVersion(String newWasVersion) {
		String oldWasVersion = wasVersion;
		wasVersion = newWasVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SERVER__WAS_VERSION, oldWasVersion, wasVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SERVER__SERVER_NAME:
				return getServerName();
			case WasPackage.WAS_SERVER__WAS_VERSION:
				return getWasVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SERVER__SERVER_NAME:
				setServerName((String)newValue);
				return;
			case WasPackage.WAS_SERVER__WAS_VERSION:
				setWasVersion((String)newValue);
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
			case WasPackage.WAS_SERVER__SERVER_NAME:
				setServerName(SERVER_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SERVER__WAS_VERSION:
				setWasVersion(WAS_VERSION_EDEFAULT);
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
			case WasPackage.WAS_SERVER__SERVER_NAME:
				return SERVER_NAME_EDEFAULT == null ? serverName != null : !SERVER_NAME_EDEFAULT.equals(serverName);
			case WasPackage.WAS_SERVER__WAS_VERSION:
				return WAS_VERSION_EDEFAULT == null ? wasVersion != null : !WAS_VERSION_EDEFAULT.equals(wasVersion);
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
		result.append(" (serverName: "); //$NON-NLS-1$
		result.append(serverName);
		result.append(", wasVersion: "); //$NON-NLS-1$
		result.append(wasVersion);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(WasPackage.eINSTANCE
			.getWasServer_ServerName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //WasServerImpl
