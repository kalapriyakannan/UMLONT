/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapServer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>LdapServer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapServerImpl#getAdministratorDN <em>Administrator DN</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapServerImpl#getAdministratorPassword <em>Administrator Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LdapServerImpl extends CapabilityImpl implements LdapServer {
	/**
	 * The default value of the '{@link #getAdministratorDN() <em>Administrator DN</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdministratorDN()
	 * @generated
	 * @ordered
	 */
	protected static final String ADMINISTRATOR_DN_EDEFAULT = "cn=root"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getAdministratorDN() <em>Administrator DN</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdministratorDN()
	 * @generated
	 * @ordered
	 */
	protected String administratorDN = ADMINISTRATOR_DN_EDEFAULT;

	/**
	 * This is true if the Administrator DN attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean administratorDNESet;

	/**
	 * The default value of the '{@link #getAdministratorPassword() <em>Administrator Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdministratorPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String ADMINISTRATOR_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdministratorPassword() <em>Administrator Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdministratorPassword()
	 * @generated
	 * @ordered
	 */
	protected String administratorPassword = ADMINISTRATOR_PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdministratorDN() {
		return administratorDN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdministratorDN(String newAdministratorDN) {
		String oldAdministratorDN = administratorDN;
		administratorDN = newAdministratorDN;
		boolean oldAdministratorDNESet = administratorDNESet;
		administratorDNESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_SERVER__ADMINISTRATOR_DN, oldAdministratorDN, administratorDN, !oldAdministratorDNESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAdministratorDN() {
		String oldAdministratorDN = administratorDN;
		boolean oldAdministratorDNESet = administratorDNESet;
		administratorDN = ADMINISTRATOR_DN_EDEFAULT;
		administratorDNESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LdapPackage.LDAP_SERVER__ADMINISTRATOR_DN, oldAdministratorDN, ADMINISTRATOR_DN_EDEFAULT, oldAdministratorDNESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAdministratorDN() {
		return administratorDNESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdministratorPassword() {
		return administratorPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdministratorPassword(String newAdministratorPassword) {
		String oldAdministratorPassword = administratorPassword;
		administratorPassword = newAdministratorPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_SERVER__ADMINISTRATOR_PASSWORD, oldAdministratorPassword, administratorPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_DN:
				return getAdministratorDN();
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_PASSWORD:
				return getAdministratorPassword();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_DN:
				setAdministratorDN((String)newValue);
				return;
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_PASSWORD:
				setAdministratorPassword((String)newValue);
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
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_DN:
				unsetAdministratorDN();
				return;
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_PASSWORD:
				setAdministratorPassword(ADMINISTRATOR_PASSWORD_EDEFAULT);
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
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_DN:
				return isSetAdministratorDN();
			case LdapPackage.LDAP_SERVER__ADMINISTRATOR_PASSWORD:
				return ADMINISTRATOR_PASSWORD_EDEFAULT == null ? administratorPassword != null : !ADMINISTRATOR_PASSWORD_EDEFAULT.equals(administratorPassword);
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
		result.append(" (administratorDN: "); //$NON-NLS-1$
		if (administratorDNESet) result.append(administratorDN); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", administratorPassword: "); //$NON-NLS-1$
		result.append(administratorPassword);
		result.append(')');
		return result.toString();
	}

} //LdapServerImpl
