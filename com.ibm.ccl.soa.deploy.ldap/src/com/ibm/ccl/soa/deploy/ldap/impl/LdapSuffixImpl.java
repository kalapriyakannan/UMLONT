/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Suffix</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixImpl#getSuffixDN <em>Suffix DN</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LdapSuffixImpl extends CapabilityImpl implements LdapSuffix {
	/**
	 * The default value of the '{@link #getSuffixDN() <em>Suffix DN</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSuffixDN()
	 * @generated
	 * @ordered
	 */
	protected static final String SUFFIX_DN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuffixDN() <em>Suffix DN</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSuffixDN()
	 * @generated
	 * @ordered
	 */
	protected String suffixDN = SUFFIX_DN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapSuffixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_SUFFIX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuffixDN() {
		return suffixDN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuffixDN(String newSuffixDN) {
		String oldSuffixDN = suffixDN;
		suffixDN = newSuffixDN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_SUFFIX__SUFFIX_DN, oldSuffixDN, suffixDN));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.LDAP_SUFFIX__SUFFIX_DN:
				return getSuffixDN();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.LDAP_SUFFIX__SUFFIX_DN:
				setSuffixDN((String)newValue);
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
			case LdapPackage.LDAP_SUFFIX__SUFFIX_DN:
				setSuffixDN(SUFFIX_DN_EDEFAULT);
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
			case LdapPackage.LDAP_SUFFIX__SUFFIX_DN:
				return SUFFIX_DN_EDEFAULT == null ? suffixDN != null : !SUFFIX_DN_EDEFAULT.equals(suffixDN);
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
		result.append(" (suffixDN: "); //$NON-NLS-1$
		result.append(suffixDN);
		result.append(')');
		return result.toString();
	}

} //LdapSuffixImpl
