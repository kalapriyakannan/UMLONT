/**
 * <copyright>
 * </copyright>
 *
 * $Id: PersonImpl.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.Person;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl#getCn <em>Cn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl#getSeeAlso <em>See Also</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl#getSn <em>Sn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl#getTelephoneNumber <em>Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl#getUserPassword <em>User Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends TopImpl implements Person {
	/**
	 * The default value of the '{@link #getCn() <em>Cn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCn()
	 * @generated
	 * @ordered
	 */
	protected static final String CN_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCn() <em>Cn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCn()
	 * @generated
	 * @ordered
	 */
	protected String cn = CN_EDEFAULT;
	/**
	 * The default value of the '{@link #getSeeAlso() <em>See Also</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeeAlso()
	 * @generated
	 * @ordered
	 */
	protected static final String SEE_ALSO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSeeAlso() <em>See Also</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeeAlso()
	 * @generated
	 * @ordered
	 */
	protected String seeAlso = SEE_ALSO_EDEFAULT;
	/**
	 * The default value of the '{@link #getSn() <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSn()
	 * @generated
	 * @ordered
	 */
	protected static final String SN_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSn() <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSn()
	 * @generated
	 * @ordered
	 */
	protected String sn = SN_EDEFAULT;
	/**
	 * The default value of the '{@link #getTelephoneNumber() <em>Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String TELEPHONE_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTelephoneNumber() <em>Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephoneNumber()
	 * @generated
	 * @ordered
	 */
	protected String telephoneNumber = TELEPHONE_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getUserPassword() <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_PASSWORD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUserPassword() <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPassword()
	 * @generated
	 * @ordered
	 */
	protected String userPassword = USER_PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCn() {
		return cn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCn(String newCn) {
		String oldCn = cn;
		cn = newCn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.PERSON__CN, oldCn, cn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeeAlso() {
		return seeAlso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeeAlso(String newSeeAlso) {
		String oldSeeAlso = seeAlso;
		seeAlso = newSeeAlso;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.PERSON__SEE_ALSO, oldSeeAlso, seeAlso));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSn(String newSn) {
		String oldSn = sn;
		sn = newSn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.PERSON__SN, oldSn, sn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTelephoneNumber(String newTelephoneNumber) {
		String oldTelephoneNumber = telephoneNumber;
		telephoneNumber = newTelephoneNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.PERSON__TELEPHONE_NUMBER, oldTelephoneNumber, telephoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserPassword(String newUserPassword) {
		String oldUserPassword = userPassword;
		userPassword = newUserPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.PERSON__USER_PASSWORD, oldUserPassword, userPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.PERSON__CN:
				return getCn();
			case LdapPackage.PERSON__SEE_ALSO:
				return getSeeAlso();
			case LdapPackage.PERSON__SN:
				return getSn();
			case LdapPackage.PERSON__TELEPHONE_NUMBER:
				return getTelephoneNumber();
			case LdapPackage.PERSON__USER_PASSWORD:
				return getUserPassword();
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
			case LdapPackage.PERSON__CN:
				setCn((String)newValue);
				return;
			case LdapPackage.PERSON__SEE_ALSO:
				setSeeAlso((String)newValue);
				return;
			case LdapPackage.PERSON__SN:
				setSn((String)newValue);
				return;
			case LdapPackage.PERSON__TELEPHONE_NUMBER:
				setTelephoneNumber((String)newValue);
				return;
			case LdapPackage.PERSON__USER_PASSWORD:
				setUserPassword((String)newValue);
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
			case LdapPackage.PERSON__CN:
				setCn(CN_EDEFAULT);
				return;
			case LdapPackage.PERSON__SEE_ALSO:
				setSeeAlso(SEE_ALSO_EDEFAULT);
				return;
			case LdapPackage.PERSON__SN:
				setSn(SN_EDEFAULT);
				return;
			case LdapPackage.PERSON__TELEPHONE_NUMBER:
				setTelephoneNumber(TELEPHONE_NUMBER_EDEFAULT);
				return;
			case LdapPackage.PERSON__USER_PASSWORD:
				setUserPassword(USER_PASSWORD_EDEFAULT);
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
			case LdapPackage.PERSON__CN:
				return CN_EDEFAULT == null ? cn != null : !CN_EDEFAULT.equals(cn);
			case LdapPackage.PERSON__SEE_ALSO:
				return SEE_ALSO_EDEFAULT == null ? seeAlso != null : !SEE_ALSO_EDEFAULT.equals(seeAlso);
			case LdapPackage.PERSON__SN:
				return SN_EDEFAULT == null ? sn != null : !SN_EDEFAULT.equals(sn);
			case LdapPackage.PERSON__TELEPHONE_NUMBER:
				return TELEPHONE_NUMBER_EDEFAULT == null ? telephoneNumber != null : !TELEPHONE_NUMBER_EDEFAULT.equals(telephoneNumber);
			case LdapPackage.PERSON__USER_PASSWORD:
				return USER_PASSWORD_EDEFAULT == null ? userPassword != null : !USER_PASSWORD_EDEFAULT.equals(userPassword);
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
		result.append(" (cn: "); //$NON-NLS-1$
		result.append(cn);
		result.append(", seeAlso: "); //$NON-NLS-1$
		result.append(seeAlso);
		result.append(", sn: "); //$NON-NLS-1$
		result.append(sn);
		result.append(", telephoneNumber: "); //$NON-NLS-1$
		result.append(telephoneNumber);
		result.append(", userPassword: "); //$NON-NLS-1$
		result.append(userPassword);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
