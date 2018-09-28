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
import com.ibm.ccl.soa.deploy.os.WindowsLocalUser;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows Local User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getAccountDescription <em>Account Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#isAccountDisabled <em>Account Disabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#isAccountLocked <em>Account Locked</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#isChangePasswordNextLogon <em>Change Password Next Logon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#isEnableRemoteControl <em>Enable Remote Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getFullName <em>Full Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getHomeFolder <em>Home Folder</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getLogonScript <em>Logon Script</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#isPasswordNeverExpires <em>Password Never Expires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getProfilePath <em>Profile Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getUserAccountType <em>User Account Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#isUserCannotChangePassword <em>User Cannot Change Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getUserSid <em>User Sid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl#getUserSidType <em>User Sid Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsLocalUserImpl extends UserImpl implements WindowsLocalUser {
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
	 * The default value of the '{@link #isAccountLocked() <em>Account Locked</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAccountLocked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACCOUNT_LOCKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAccountLocked() <em>Account Locked</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAccountLocked()
	 * @generated
	 * @ordered
	 */
	protected boolean accountLocked = ACCOUNT_LOCKED_EDEFAULT;

	/**
	 * This is true if the Account Locked attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean accountLockedESet;

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
	 * The default value of the '{@link #isEnableRemoteControl() <em>Enable Remote Control</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnableRemoteControl()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_REMOTE_CONTROL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnableRemoteControl() <em>Enable Remote Control</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnableRemoteControl()
	 * @generated
	 * @ordered
	 */
	protected boolean enableRemoteControl = ENABLE_REMOTE_CONTROL_EDEFAULT;

	/**
	 * This is true if the Enable Remote Control attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean enableRemoteControlESet;

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
	 * The default value of the '{@link #getHomeFolder() <em>Home Folder</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHomeFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String HOME_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHomeFolder() <em>Home Folder</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHomeFolder()
	 * @generated
	 * @ordered
	 */
	protected String homeFolder = HOME_FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogonScript() <em>Logon Script</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogonScript()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGON_SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogonScript() <em>Logon Script</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogonScript()
	 * @generated
	 * @ordered
	 */
	protected String logonScript = LOGON_SCRIPT_EDEFAULT;

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
	 * The default value of the '{@link #getProfilePath() <em>Profile Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProfilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfilePath() <em>Profile Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProfilePath()
	 * @generated
	 * @ordered
	 */
	protected String profilePath = PROFILE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserAccountType() <em>User Account Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserAccountType()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ACCOUNT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserAccountType() <em>User Account Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserAccountType()
	 * @generated
	 * @ordered
	 */
	protected String userAccountType = USER_ACCOUNT_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getUserSidType() <em>User Sid Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserSidType()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_SID_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserSidType() <em>User Sid Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserSidType()
	 * @generated
	 * @ordered
	 */
	protected String userSidType = USER_SID_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsLocalUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.WINDOWS_LOCAL_USER;
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
					OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION, oldAccountDescription,
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
					OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DISABLED, oldAccountDisabled, accountDisabled,
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
					OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DISABLED, oldAccountDisabled,
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
	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountLocked(boolean newAccountLocked) {
		boolean oldAccountLocked = accountLocked;
		accountLocked = newAccountLocked;
		boolean oldAccountLockedESet = accountLockedESet;
		accountLockedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_LOCKED, oldAccountLocked, accountLocked,
					!oldAccountLockedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAccountLocked() {
		boolean oldAccountLocked = accountLocked;
		boolean oldAccountLockedESet = accountLockedESet;
		accountLocked = ACCOUNT_LOCKED_EDEFAULT;
		accountLockedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_LOCKED, oldAccountLocked,
					ACCOUNT_LOCKED_EDEFAULT, oldAccountLockedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAccountLocked() {
		return accountLockedESet;
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
					OsPackage.WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON,
					oldChangePasswordNextLogon, changePasswordNextLogon, !oldChangePasswordNextLogonESet));
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
					OsPackage.WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON,
					oldChangePasswordNextLogon, CHANGE_PASSWORD_NEXT_LOGON_EDEFAULT,
					oldChangePasswordNextLogonESet));
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
	public boolean isEnableRemoteControl() {
		return enableRemoteControl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableRemoteControl(boolean newEnableRemoteControl) {
		boolean oldEnableRemoteControl = enableRemoteControl;
		enableRemoteControl = newEnableRemoteControl;
		boolean oldEnableRemoteControlESet = enableRemoteControlESet;
		enableRemoteControlESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL, oldEnableRemoteControl,
					enableRemoteControl, !oldEnableRemoteControlESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEnableRemoteControl() {
		boolean oldEnableRemoteControl = enableRemoteControl;
		boolean oldEnableRemoteControlESet = enableRemoteControlESet;
		enableRemoteControl = ENABLE_REMOTE_CONTROL_EDEFAULT;
		enableRemoteControlESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL, oldEnableRemoteControl,
					ENABLE_REMOTE_CONTROL_EDEFAULT, oldEnableRemoteControlESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnableRemoteControl() {
		return enableRemoteControlESet;
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
					OsPackage.WINDOWS_LOCAL_USER__FULL_NAME, oldFullName, fullName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHomeFolder() {
		return homeFolder;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomeFolder(String newHomeFolder) {
		String oldHomeFolder = homeFolder;
		homeFolder = newHomeFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__HOME_FOLDER, oldHomeFolder, homeFolder));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogonScript() {
		return logonScript;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogonScript(String newLogonScript) {
		String oldLogonScript = logonScript;
		logonScript = newLogonScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__LOGON_SCRIPT, oldLogonScript, logonScript));
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
					OsPackage.WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES, oldPasswordNeverExpires,
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
					OsPackage.WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES, oldPasswordNeverExpires,
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
	public String getProfilePath() {
		return profilePath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfilePath(String newProfilePath) {
		String oldProfilePath = profilePath;
		profilePath = newProfilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__PROFILE_PATH, oldProfilePath, profilePath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserAccountType() {
		return userAccountType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserAccountType(String newUserAccountType) {
		String oldUserAccountType = userAccountType;
		userAccountType = newUserAccountType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE, oldUserAccountType, userAccountType));
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
					OsPackage.WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD,
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
					OsPackage.WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD,
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
					OsPackage.WINDOWS_LOCAL_USER__USER_SID, oldUserSid, userSid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserSidType() {
		return userSidType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserSidType(String newUserSidType) {
		String oldUserSidType = userSidType;
		userSidType = newUserSidType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_USER__USER_SID_TYPE, oldUserSidType, userSidType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION:
			return getAccountDescription();
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DISABLED:
			return isAccountDisabled() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_LOCKED:
			return isAccountLocked() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			return isChangePasswordNextLogon() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL:
			return isEnableRemoteControl() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_USER__FULL_NAME:
			return getFullName();
		case OsPackage.WINDOWS_LOCAL_USER__HOME_FOLDER:
			return getHomeFolder();
		case OsPackage.WINDOWS_LOCAL_USER__LOGON_SCRIPT:
			return getLogonScript();
		case OsPackage.WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			return isPasswordNeverExpires() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_USER__PROFILE_PATH:
			return getProfilePath();
		case OsPackage.WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE:
			return getUserAccountType();
		case OsPackage.WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			return isUserCannotChangePassword() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID:
			return getUserSid();
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID_TYPE:
			return getUserSidType();
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
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION:
			setAccountDescription((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DISABLED:
			setAccountDisabled(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_LOCKED:
			setAccountLocked(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			setChangePasswordNextLogon(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL:
			setEnableRemoteControl(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_USER__FULL_NAME:
			setFullName((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__HOME_FOLDER:
			setHomeFolder((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__LOGON_SCRIPT:
			setLogonScript((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			setPasswordNeverExpires(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_USER__PROFILE_PATH:
			setProfilePath((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE:
			setUserAccountType((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			setUserCannotChangePassword(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID:
			setUserSid((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID_TYPE:
			setUserSidType((String) newValue);
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
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION:
			setAccountDescription(ACCOUNT_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DISABLED:
			unsetAccountDisabled();
			return;
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_LOCKED:
			unsetAccountLocked();
			return;
		case OsPackage.WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			unsetChangePasswordNextLogon();
			return;
		case OsPackage.WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL:
			unsetEnableRemoteControl();
			return;
		case OsPackage.WINDOWS_LOCAL_USER__FULL_NAME:
			setFullName(FULL_NAME_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__HOME_FOLDER:
			setHomeFolder(HOME_FOLDER_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__LOGON_SCRIPT:
			setLogonScript(LOGON_SCRIPT_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			unsetPasswordNeverExpires();
			return;
		case OsPackage.WINDOWS_LOCAL_USER__PROFILE_PATH:
			setProfilePath(PROFILE_PATH_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE:
			setUserAccountType(USER_ACCOUNT_TYPE_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			unsetUserCannotChangePassword();
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID:
			setUserSid(USER_SID_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID_TYPE:
			setUserSidType(USER_SID_TYPE_EDEFAULT);
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
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION:
			return ACCOUNT_DESCRIPTION_EDEFAULT == null ? accountDescription != null
					: !ACCOUNT_DESCRIPTION_EDEFAULT.equals(accountDescription);
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_DISABLED:
			return isSetAccountDisabled();
		case OsPackage.WINDOWS_LOCAL_USER__ACCOUNT_LOCKED:
			return isSetAccountLocked();
		case OsPackage.WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			return isSetChangePasswordNextLogon();
		case OsPackage.WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL:
			return isSetEnableRemoteControl();
		case OsPackage.WINDOWS_LOCAL_USER__FULL_NAME:
			return FULL_NAME_EDEFAULT == null ? fullName != null : !FULL_NAME_EDEFAULT
					.equals(fullName);
		case OsPackage.WINDOWS_LOCAL_USER__HOME_FOLDER:
			return HOME_FOLDER_EDEFAULT == null ? homeFolder != null : !HOME_FOLDER_EDEFAULT
					.equals(homeFolder);
		case OsPackage.WINDOWS_LOCAL_USER__LOGON_SCRIPT:
			return LOGON_SCRIPT_EDEFAULT == null ? logonScript != null : !LOGON_SCRIPT_EDEFAULT
					.equals(logonScript);
		case OsPackage.WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			return isSetPasswordNeverExpires();
		case OsPackage.WINDOWS_LOCAL_USER__PROFILE_PATH:
			return PROFILE_PATH_EDEFAULT == null ? profilePath != null : !PROFILE_PATH_EDEFAULT
					.equals(profilePath);
		case OsPackage.WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE:
			return USER_ACCOUNT_TYPE_EDEFAULT == null ? userAccountType != null
					: !USER_ACCOUNT_TYPE_EDEFAULT.equals(userAccountType);
		case OsPackage.WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			return isSetUserCannotChangePassword();
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID:
			return USER_SID_EDEFAULT == null ? userSid != null : !USER_SID_EDEFAULT.equals(userSid);
		case OsPackage.WINDOWS_LOCAL_USER__USER_SID_TYPE:
			return USER_SID_TYPE_EDEFAULT == null ? userSidType != null : !USER_SID_TYPE_EDEFAULT
					.equals(userSidType);
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
		result.append(", accountLocked: "); //$NON-NLS-1$
		if (accountLockedESet)
			result.append(accountLocked);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", changePasswordNextLogon: "); //$NON-NLS-1$
		if (changePasswordNextLogonESet)
			result.append(changePasswordNextLogon);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", enableRemoteControl: "); //$NON-NLS-1$
		if (enableRemoteControlESet)
			result.append(enableRemoteControl);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", fullName: "); //$NON-NLS-1$
		result.append(fullName);
		result.append(", homeFolder: "); //$NON-NLS-1$
		result.append(homeFolder);
		result.append(", logonScript: "); //$NON-NLS-1$
		result.append(logonScript);
		result.append(", passwordNeverExpires: "); //$NON-NLS-1$
		if (passwordNeverExpiresESet)
			result.append(passwordNeverExpires);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", profilePath: "); //$NON-NLS-1$
		result.append(profilePath);
		result.append(", userAccountType: "); //$NON-NLS-1$
		result.append(userAccountType);
		result.append(", userCannotChangePassword: "); //$NON-NLS-1$
		if (userCannotChangePasswordESet)
			result.append(userCannotChangePassword);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", userSid: "); //$NON-NLS-1$
		result.append(userSid);
		result.append(", userSidType: "); //$NON-NLS-1$
		result.append(userSidType);
		result.append(')');
		return result.toString();
	}

} //WindowsLocalUserImpl
