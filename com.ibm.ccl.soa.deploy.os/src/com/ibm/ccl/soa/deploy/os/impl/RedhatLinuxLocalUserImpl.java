/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Redhat Linux Local User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getAccountDisableAfterDays <em>Account Disable After Days</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getAccountDisableDate <em>Account Disable Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getDaysBeforePasswordMayChange <em>Days Before Password May Change</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getLastPasswordChange <em>Last Password Change</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getPasswordExpireAfterDays <em>Password Expire After Days</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getPasswordExpireWarningDays <em>Password Expire Warning Days</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl#getUserSid <em>User Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedhatLinuxLocalUserImpl extends LinuxLocalUserImpl implements RedhatLinuxLocalUser {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAccountDisableAfterDays() <em>Account Disable After Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountDisableAfterDays()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNT_DISABLE_AFTER_DAYS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccountDisableAfterDays() <em>Account Disable After Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountDisableAfterDays()
	 * @generated
	 * @ordered
	 */
	protected String accountDisableAfterDays = ACCOUNT_DISABLE_AFTER_DAYS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccountDisableDate() <em>Account Disable Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountDisableDate()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNT_DISABLE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccountDisableDate() <em>Account Disable Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountDisableDate()
	 * @generated
	 * @ordered
	 */
	protected String accountDisableDate = ACCOUNT_DISABLE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDaysBeforePasswordMayChange() <em>Days Before Password May Change</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDaysBeforePasswordMayChange()
	 * @generated
	 * @ordered
	 */
	protected static final String DAYS_BEFORE_PASSWORD_MAY_CHANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDaysBeforePasswordMayChange() <em>Days Before Password May Change</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDaysBeforePasswordMayChange()
	 * @generated
	 * @ordered
	 */
	protected String daysBeforePasswordMayChange = DAYS_BEFORE_PASSWORD_MAY_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastPasswordChange() <em>Last Password Change</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastPasswordChange()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_PASSWORD_CHANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastPasswordChange() <em>Last Password Change</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastPasswordChange()
	 * @generated
	 * @ordered
	 */
	protected String lastPasswordChange = LAST_PASSWORD_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordExpireAfterDays() <em>Password Expire After Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPasswordExpireAfterDays()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EXPIRE_AFTER_DAYS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswordExpireAfterDays() <em>Password Expire After Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPasswordExpireAfterDays()
	 * @generated
	 * @ordered
	 */
	protected String passwordExpireAfterDays = PASSWORD_EXPIRE_AFTER_DAYS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordExpireWarningDays() <em>Password Expire Warning Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPasswordExpireWarningDays()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EXPIRE_WARNING_DAYS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswordExpireWarningDays() <em>Password Expire Warning Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPasswordExpireWarningDays()
	 * @generated
	 * @ordered
	 */
	protected String passwordExpireWarningDays = PASSWORD_EXPIRE_WARNING_DAYS_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserSid() <em>User Sid</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserSid()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_SID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserSid() <em>User Sid</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserSid()
	 * @generated
	 * @ordered
	 */
	protected String userSid = USER_SID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RedhatLinuxLocalUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.REDHAT_LINUX_LOCAL_USER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccountDisableAfterDays() {
		return accountDisableAfterDays;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountDisableAfterDays(String newAccountDisableAfterDays) {
		String oldAccountDisableAfterDays = accountDisableAfterDays;
		accountDisableAfterDays = newAccountDisableAfterDays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS,
					oldAccountDisableAfterDays, accountDisableAfterDays));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccountDisableDate() {
		return accountDisableDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountDisableDate(String newAccountDisableDate) {
		String oldAccountDisableDate = accountDisableDate;
		accountDisableDate = newAccountDisableDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE, oldAccountDisableDate,
					accountDisableDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDaysBeforePasswordMayChange() {
		return daysBeforePasswordMayChange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDaysBeforePasswordMayChange(String newDaysBeforePasswordMayChange) {
		String oldDaysBeforePasswordMayChange = daysBeforePasswordMayChange;
		daysBeforePasswordMayChange = newDaysBeforePasswordMayChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE,
					oldDaysBeforePasswordMayChange, daysBeforePasswordMayChange));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastPasswordChange() {
		return lastPasswordChange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastPasswordChange(String newLastPasswordChange) {
		String oldLastPasswordChange = lastPasswordChange;
		lastPasswordChange = newLastPasswordChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE, oldLastPasswordChange,
					lastPasswordChange));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswordExpireAfterDays() {
		return passwordExpireAfterDays;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordExpireAfterDays(String newPasswordExpireAfterDays) {
		String oldPasswordExpireAfterDays = passwordExpireAfterDays;
		passwordExpireAfterDays = newPasswordExpireAfterDays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS,
					oldPasswordExpireAfterDays, passwordExpireAfterDays));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswordExpireWarningDays() {
		return passwordExpireWarningDays;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordExpireWarningDays(String newPasswordExpireWarningDays) {
		String oldPasswordExpireWarningDays = passwordExpireWarningDays;
		passwordExpireWarningDays = newPasswordExpireWarningDays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS,
					oldPasswordExpireWarningDays, passwordExpireWarningDays));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserSid() {
		return userSid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserSid(String newUserSid) {
		String oldUserSid = userSid;
		userSid = newUserSid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_LOCAL_USER__USER_SID, oldUserSid, userSid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS:
			return getAccountDisableAfterDays();
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE:
			return getAccountDisableDate();
		case OsPackage.REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE:
			return getDaysBeforePasswordMayChange();
		case OsPackage.REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE:
			return getLastPasswordChange();
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS:
			return getPasswordExpireAfterDays();
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS:
			return getPasswordExpireWarningDays();
		case OsPackage.REDHAT_LINUX_LOCAL_USER__USER_SID:
			return getUserSid();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS:
			setAccountDisableAfterDays((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE:
			setAccountDisableDate((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE:
			setDaysBeforePasswordMayChange((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE:
			setLastPasswordChange((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS:
			setPasswordExpireAfterDays((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS:
			setPasswordExpireWarningDays((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__USER_SID:
			setUserSid((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS:
			setAccountDisableAfterDays(ACCOUNT_DISABLE_AFTER_DAYS_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE:
			setAccountDisableDate(ACCOUNT_DISABLE_DATE_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE:
			setDaysBeforePasswordMayChange(DAYS_BEFORE_PASSWORD_MAY_CHANGE_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE:
			setLastPasswordChange(LAST_PASSWORD_CHANGE_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS:
			setPasswordExpireAfterDays(PASSWORD_EXPIRE_AFTER_DAYS_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS:
			setPasswordExpireWarningDays(PASSWORD_EXPIRE_WARNING_DAYS_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_LOCAL_USER__USER_SID:
			setUserSid(USER_SID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS:
			return ACCOUNT_DISABLE_AFTER_DAYS_EDEFAULT == null ? accountDisableAfterDays != null
					: !ACCOUNT_DISABLE_AFTER_DAYS_EDEFAULT.equals(accountDisableAfterDays);
		case OsPackage.REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE:
			return ACCOUNT_DISABLE_DATE_EDEFAULT == null ? accountDisableDate != null
					: !ACCOUNT_DISABLE_DATE_EDEFAULT.equals(accountDisableDate);
		case OsPackage.REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE:
			return DAYS_BEFORE_PASSWORD_MAY_CHANGE_EDEFAULT == null ? daysBeforePasswordMayChange != null
					: !DAYS_BEFORE_PASSWORD_MAY_CHANGE_EDEFAULT.equals(daysBeforePasswordMayChange);
		case OsPackage.REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE:
			return LAST_PASSWORD_CHANGE_EDEFAULT == null ? lastPasswordChange != null
					: !LAST_PASSWORD_CHANGE_EDEFAULT.equals(lastPasswordChange);
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS:
			return PASSWORD_EXPIRE_AFTER_DAYS_EDEFAULT == null ? passwordExpireAfterDays != null
					: !PASSWORD_EXPIRE_AFTER_DAYS_EDEFAULT.equals(passwordExpireAfterDays);
		case OsPackage.REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS:
			return PASSWORD_EXPIRE_WARNING_DAYS_EDEFAULT == null ? passwordExpireWarningDays != null
					: !PASSWORD_EXPIRE_WARNING_DAYS_EDEFAULT.equals(passwordExpireWarningDays);
		case OsPackage.REDHAT_LINUX_LOCAL_USER__USER_SID:
			return USER_SID_EDEFAULT == null ? userSid != null : !USER_SID_EDEFAULT.equals(userSid);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (accountDisableAfterDays: "); //$NON-NLS-1$
		result.append(accountDisableAfterDays);
		result.append(", accountDisableDate: "); //$NON-NLS-1$
		result.append(accountDisableDate);
		result.append(", daysBeforePasswordMayChange: "); //$NON-NLS-1$
		result.append(daysBeforePasswordMayChange);
		result.append(", lastPasswordChange: "); //$NON-NLS-1$
		result.append(lastPasswordChange);
		result.append(", passwordExpireAfterDays: "); //$NON-NLS-1$
		result.append(passwordExpireAfterDays);
		result.append(", passwordExpireWarningDays: "); //$NON-NLS-1$
		result.append(passwordExpireWarningDays);
		result.append(", userSid: "); //$NON-NLS-1$
		result.append(userSid);
		result.append(')');
		return result.toString();
	}

} //RedhatLinuxLocalUserImpl
