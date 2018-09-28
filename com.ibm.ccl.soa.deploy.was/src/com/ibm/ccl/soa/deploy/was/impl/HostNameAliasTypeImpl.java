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

import com.ibm.ccl.soa.deploy.was.HostNameAliasType;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Host Name Alias Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.HostNameAliasTypeImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.HostNameAliasTypeImpl#getHostnameAlias <em>Hostname Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HostNameAliasTypeImpl extends EObjectImpl implements HostNameAliasType {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHostnameAlias() <em>Hostname Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHostnameAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostnameAlias() <em>Hostname Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHostnameAlias()
	 * @generated
	 * @ordered
	 */
	protected String hostnameAlias = HOSTNAME_ALIAS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HostNameAliasTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.HOST_NAME_ALIAS_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostnameAlias() {
		return hostnameAlias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostnameAlias(String newHostnameAlias) {
		String oldHostnameAlias = hostnameAlias;
		hostnameAlias = newHostnameAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME_ALIAS, oldHostnameAlias, hostnameAlias));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME:
				return getHostname();
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME_ALIAS:
				return getHostnameAlias();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME:
				setHostname((String)newValue);
				return;
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME_ALIAS:
				setHostnameAlias((String)newValue);
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
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME_ALIAS:
				setHostnameAlias(HOSTNAME_ALIAS_EDEFAULT);
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
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case WasPackage.HOST_NAME_ALIAS_TYPE__HOSTNAME_ALIAS:
				return HOSTNAME_ALIAS_EDEFAULT == null ? hostnameAlias != null : !HOSTNAME_ALIAS_EDEFAULT.equals(hostnameAlias);
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
		result.append(" (hostname: "); //$NON-NLS-1$
		result.append(hostname);
		result.append(", hostnameAlias: "); //$NON-NLS-1$
		result.append(hostnameAlias);
		result.append(')');
		return result.toString();
	}

} //HostNameAliasTypeImpl
