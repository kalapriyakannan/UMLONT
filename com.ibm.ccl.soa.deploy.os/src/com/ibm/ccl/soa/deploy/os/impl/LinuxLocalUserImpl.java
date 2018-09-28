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

import com.ibm.ccl.soa.deploy.os.LinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Linux Local User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#getAccountDescription <em>Account Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#isAccountDisabled <em>Account Disabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#isChangePasswordNextLogon <em>Change Password Next Logon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#getFullName <em>Full Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#getHomeDir <em>Home Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#isPasswordNeverExpires <em>Password Never Expires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#getShell <em>Shell</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#isUserCannotChangePassword <em>User Cannot Change Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl#getUserName <em>User Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinuxLocalUserImpl extends UserImpl implements LinuxLocalUser {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAccountDescription() <em>Account Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccountDescription() <em>Account Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountDescription()
	 * @generated
	 * @ordered
	 */
	protected String accountDescription = ACCOUNT_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isAccountDisabled() <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAccountDisabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACCOUNT_DISABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAccountDisabled() <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAccountDisabled()
	 * @generated
	 * @ordered
	 */
	protected boolean accountDisabled = ACCOUNT_DISABLED_EDEFAULT;

	/**
	 * This is true if the Account Disabled attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean accountDisabledESet;

	/**
	 * The default value of the '{@link #isChangePasswordNextLogon() <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isChangePasswordNextLogon()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGE_PASSWORD_NEXT_LOGON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChangePasswordNextLogon() <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isChangePasswordNextLogon()
	 * @generated
	 * @ordered
	 */
	protected boolean changePasswordNextLogon = CHANGE_PASSWORD_NEXT_LOGON_EDEFAULT;

	/**
	 * This is true if the Change Password Next Logon attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean changePasswordNextLogonESet;

	/**
	 * The default value of the '{@link #getFullName() <em>Full Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFullName()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullName() <em>Full Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFullName()
	 * @generated
	 * @ordered
	 */
	protected String fullName = FULL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHomeDir() <em>Home Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHomeDir()
	 * @generated
	 * @ordered
	 */
	protected static final String HOME_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHomeDir() <em>Home Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHomeDir()
	 * @generated
	 * @ordered
	 */
	protected String homeDir = HOME_DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #isPasswordNeverExpires() <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isPasswordNeverExpires()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PASSWORD_NEVER_EXPIRES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPasswordNeverExpires() <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isPasswordNeverExpires()
	 * @generated
	 * @ordered
	 */
	protected boolean passwordNeverExpires = PASSWORD_NEVER_EXPIRES_EDEFAULT;

	/**
	 * This is true if the Password Never Expires attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean passwordNeverExpiresESet;

	/**
	 * The default value of the '{@link #getShell() <em>Shell</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getShell()
	 * @generated
	 * @ordered
	 */
	protected static final String SHELL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShell() <em>Shell</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getShell()
	 * @generated
	 * @ordered
	 */
	protected String shell = SHELL_EDEFAULT;

	/**
	 * The default value of the '{@link #isUserCannotChangePassword() <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUserCannotChangePassword()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_CANNOT_CHANGE_PASSWORD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUserCannotChangePassword() <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUserCannotChangePassword()
	 * @generated
	 * @ordered
	 */
	protected boolean userCannotChangePassword = USER_CANNOT_CHANGE_PASSWORD_EDEFAULT;

	/**
	 * This is true if the User Cannot Change Password attribute has been set.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean userCannotChangePasswordESet;

	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LinuxLocalUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.LINUX_LOCAL_USER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccountDescription() {
		return accountDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountDescription(String newAccountDescription) {
		String oldAccountDescription = accountDescription;
		accountDescription = newAccountDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION, oldAccountDescription,
					accountDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAccountDisabled() {
		return accountDisabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountDisabled(boolean newAccountDisabled) {
		boolean oldAccountDisabled = accountDisabled;
		accountDisabled = newAccountDisabled;
		boolean oldAccountDisabledESet = accountDisabledESet;
		accountDisabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__ACCOUNT_DISABLED, oldAccountDisabled, accountDisabled,
					!oldAccountDisabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAccountDisabled() {
		boolean oldAccountDisabled = accountDisabled;
		boolean oldAccountDisabledESet = accountDisabledESet;
		accountDisabled = ACCOUNT_DISABLED_EDEFAULT;
		accountDisabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_USER__ACCOUNT_DISABLED, oldAccountDisabled,
					ACCOUNT_DISABLED_EDEFAULT, oldAccountDisabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAccountDisabled() {
		return accountDisabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChangePasswordNextLogon() {
		return changePasswordNextLogon;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangePasswordNextLogon(boolean newChangePasswordNextLogon) {
		boolean oldChangePasswordNextLogon = changePasswordNextLogon;
		changePasswordNextLogon = newChangePasswordNextLogon;
		boolean oldChangePasswordNextLogonESet = changePasswordNextLogonESet;
		changePasswordNextLogonESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON, oldChangePasswordNextLogon,
					changePasswordNextLogon, !oldChangePasswordNextLogonESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetChangePasswordNextLogon() {
		boolean oldChangePasswordNextLogon = changePasswordNextLogon;
		boolean oldChangePasswordNextLogonESet = changePasswordNextLogonESet;
		changePasswordNextLogon = CHANGE_PASSWORD_NEXT_LOGON_EDEFAULT;
		changePasswordNextLogonESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON, oldChangePasswordNextLogon,
					CHANGE_PASSWORD_NEXT_LOGON_EDEFAULT, oldChangePasswordNextLogonESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetChangePasswordNextLogon() {
		return changePasswordNextLogonESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullName(String newFullName) {
		String oldFullName = fullName;
		fullName = newFullName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__FULL_NAME, oldFullName, fullName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHomeDir() {
		return homeDir;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomeDir(String newHomeDir) {
		String oldHomeDir = homeDir;
		homeDir = newHomeDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__HOME_DIR, oldHomeDir, homeDir));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPasswordNeverExpires() {
		return passwordNeverExpires;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordNeverExpires(boolean newPasswordNeverExpires) {
		boolean oldPasswordNeverExpires = passwordNeverExpires;
		passwordNeverExpires = newPasswordNeverExpires;
		boolean oldPasswordNeverExpiresESet = passwordNeverExpiresESet;
		passwordNeverExpiresESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES, oldPasswordNeverExpires,
					passwordNeverExpires, !oldPasswordNeverExpiresESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPasswordNeverExpires() {
		boolean oldPasswordNeverExpires = passwordNeverExpires;
		boolean oldPasswordNeverExpiresESet = passwordNeverExpiresESet;
		passwordNeverExpires = PASSWORD_NEVER_EXPIRES_EDEFAULT;
		passwordNeverExpiresESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES, oldPasswordNeverExpires,
					PASSWORD_NEVER_EXPIRES_EDEFAULT, oldPasswordNeverExpiresESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPasswordNeverExpires() {
		return passwordNeverExpiresESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getShell() {
		return shell;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShell(String newShell) {
		String oldShell = shell;
		shell = newShell;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.LINUX_LOCAL_USER__SHELL,
					oldShell, shell));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUserCannotChangePassword() {
		return userCannotChangePassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserCannotChangePassword(boolean newUserCannotChangePassword) {
		boolean oldUserCannotChangePassword = userCannotChangePassword;
		userCannotChangePassword = newUserCannotChangePassword;
		boolean oldUserCannotChangePasswordESet = userCannotChangePasswordESet;
		userCannotChangePasswordESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD,
					oldUserCannotChangePassword, userCannotChangePassword,
					!oldUserCannotChangePasswordESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserCannotChangePassword() {
		boolean oldUserCannotChangePassword = userCannotChangePassword;
		boolean oldUserCannotChangePasswordESet = userCannotChangePasswordESet;
		userCannotChangePassword = USER_CANNOT_CHANGE_PASSWORD_EDEFAULT;
		userCannotChangePasswordESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD,
					oldUserCannotChangePassword, USER_CANNOT_CHANGE_PASSWORD_EDEFAULT,
					oldUserCannotChangePasswordESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserCannotChangePassword() {
		return userCannotChangePasswordESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_USER__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			return getAccountDescription();
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DISABLED:
			return isAccountDisabled() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			return isChangePasswordNextLogon() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_USER__FULL_NAME:
			return getFullName();
		case OsPackage.LINUX_LOCAL_USER__HOME_DIR:
			return getHomeDir();
		case OsPackage.LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			return isPasswordNeverExpires() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_USER__SHELL:
			return getShell();
		case OsPackage.LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			return isUserCannotChangePassword() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_USER__USER_NAME:
			return getUserName();
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
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			setAccountDescription((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DISABLED:
			setAccountDisabled(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			setChangePasswordNextLogon(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_USER__FULL_NAME:
			setFullName((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_USER__HOME_DIR:
			setHomeDir((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			setPasswordNeverExpires(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_USER__SHELL:
			setShell((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			setUserCannotChangePassword(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_USER__USER_NAME:
			setUserName((String) newValue);
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
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			setAccountDescription(ACCOUNT_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DISABLED:
			unsetAccountDisabled();
			return;
		case OsPackage.LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			unsetChangePasswordNextLogon();
			return;
		case OsPackage.LINUX_LOCAL_USER__FULL_NAME:
			setFullName(FULL_NAME_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_USER__HOME_DIR:
			setHomeDir(HOME_DIR_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			unsetPasswordNeverExpires();
			return;
		case OsPackage.LINUX_LOCAL_USER__SHELL:
			setShell(SHELL_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			unsetUserCannotChangePassword();
			return;
		case OsPackage.LINUX_LOCAL_USER__USER_NAME:
			setUserName(USER_NAME_EDEFAULT);
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
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			return ACCOUNT_DESCRIPTION_EDEFAULT == null ? accountDescription != null
					: !ACCOUNT_DESCRIPTION_EDEFAULT.equals(accountDescription);
		case OsPackage.LINUX_LOCAL_USER__ACCOUNT_DISABLED:
			return isSetAccountDisabled();
		case OsPackage.LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			return isSetChangePasswordNextLogon();
		case OsPackage.LINUX_LOCAL_USER__FULL_NAME:
			return FULL_NAME_EDEFAULT == null ? fullName != null : !FULL_NAME_EDEFAULT
					.equals(fullName);
		case OsPackage.LINUX_LOCAL_USER__HOME_DIR:
			return HOME_DIR_EDEFAULT == null ? homeDir != null : !HOME_DIR_EDEFAULT.equals(homeDir);
		case OsPackage.LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			return isSetPasswordNeverExpires();
		case OsPackage.LINUX_LOCAL_USER__SHELL:
			return SHELL_EDEFAULT == null ? shell != null : !SHELL_EDEFAULT.equals(shell);
		case OsPackage.LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			return isSetUserCannotChangePassword();
		case OsPackage.LINUX_LOCAL_USER__USER_NAME:
			return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT
					.equals(userName);
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
		result.append(" (accountDescription: "); //$NON-NLS-1$
		result.append(accountDescription);
		result.append(", accountDisabled: "); //$NON-NLS-1$
		if (accountDisabledESet)
			result.append(accountDisabled);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", changePasswordNextLogon: "); //$NON-NLS-1$
		if (changePasswordNextLogonESet)
			result.append(changePasswordNextLogon);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", fullName: "); //$NON-NLS-1$
		result.append(fullName);
		result.append(", homeDir: "); //$NON-NLS-1$
		result.append(homeDir);
		result.append(", passwordNeverExpires: "); //$NON-NLS-1$
		if (passwordNeverExpiresESet)
			result.append(passwordNeverExpires);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", shell: "); //$NON-NLS-1$
		result.append(shell);
		result.append(", userCannotChangePassword: "); //$NON-NLS-1$
		if (userCannotChangePasswordESet)
			result.append(userCannotChangePassword);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", userName: "); //$NON-NLS-1$
		result.append(userName);
		result.append(')');
		return result.toString();
	}

} //LinuxLocalUserImpl
