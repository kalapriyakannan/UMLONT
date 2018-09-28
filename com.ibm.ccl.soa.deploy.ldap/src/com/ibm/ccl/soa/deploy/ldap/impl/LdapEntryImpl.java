/**
 * <copyright>
 * </copyright>
 *
 * $Id: LdapEntryImpl.java,v 1.1 2008/06/17 19:59:18 pershng Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;

import com.ibm.ccl.soa.deploy.ldap.LdapEntry;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryImpl#getRelativeDN <em>Relative DN</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LdapEntryImpl extends CapabilityImpl implements LdapEntry {
	/**
	 * The default value of the '{@link #getRelativeDN() <em>Relative DN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeDN()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATIVE_DN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelativeDN() <em>Relative DN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeDN()
	 * @generated
	 * @ordered
	 */
	protected String relativeDN = RELATIVE_DN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelativeDN() {
		return relativeDN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativeDN(String newRelativeDN) {
		String oldRelativeDN = relativeDN;
		relativeDN = newRelativeDN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_ENTRY__RELATIVE_DN, oldRelativeDN, relativeDN));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.LDAP_ENTRY__RELATIVE_DN:
				return getRelativeDN();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.LDAP_ENTRY__RELATIVE_DN:
				setRelativeDN((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case LdapPackage.LDAP_ENTRY__RELATIVE_DN:
				setRelativeDN(RELATIVE_DN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LdapPackage.LDAP_ENTRY__RELATIVE_DN:
				return RELATIVE_DN_EDEFAULT == null ? relativeDN != null : !RELATIVE_DN_EDEFAULT.equals(relativeDN);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (relativeDN: "); //$NON-NLS-1$
		result.append(relativeDN);
		result.append(')');
		return result.toString();
	}

} //LdapEntryImpl
