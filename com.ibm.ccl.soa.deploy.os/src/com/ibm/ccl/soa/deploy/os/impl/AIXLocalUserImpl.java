/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.os.AIXAuthMethodType;
import com.ibm.ccl.soa.deploy.os.AIXLocalUser;
import com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>AIX Local User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getAccountDescription <em>Account Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isAccountDisabled <em>Account Disabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getAccountExpirationTime <em>Account Expiration Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isChangePasswordNextLogon <em>Change Password Next Logon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getFullName <em>Full Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getHomeDir <em>Home Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isIsAdmin <em>Is Admin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isLoginPermitted <em>Login Permitted</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getLoginRetries <em>Login Retries</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getLoginTimes <em>Login Times</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMaxCharRepeats <em>Max Char Repeats</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMaxPasswordAgeInWeeks <em>Max Password Age In Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMaxPasswordValidWeeks <em>Max Password Valid Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMinAlphaCharsInPassword <em>Min Alpha Chars In Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMinDiffChars <em>Min Diff Chars</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMinOtherCharsInPassword <em>Min Other Chars In Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMinPasswordAgeInWeeks <em>Min Password Age In Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getMinPasswordLength <em>Min Password Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getNotReusableNumberOfPasswords <em>Not Reusable Number Of Passwords</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getPassReuseNotAllowedInWeeks <em>Pass Reuse Not Allowed In Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getPasswordChangeWarnTime <em>Password Change Warn Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isPasswordNeverExpires <em>Password Never Expires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getPrimaryAuthMethod <em>Primary Auth Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isRemoteLoginIsAllowed <em>Remote Login Is Allowed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getSecondaryAuthMethod <em>Secondary Auth Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getShell <em>Shell</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getSuGroupsAllowed <em>Su Groups Allowed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isSuIsAllowed <em>Su Is Allowed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getTimeLastLogin <em>Time Last Login</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#isUserCannotChangePassword <em>User Cannot Change Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getUserRegisteringMethod <em>User Registering Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getUserSid <em>User Sid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl#getUsuccessfulLoginCount <em>Usuccessful Login Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIXLocalUserImpl extends UserImpl implements AIXLocalUser {
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
	 * The default value of the '{@link #getAccountExpirationTime() <em>Account Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountExpirationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNT_EXPIRATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccountExpirationTime() <em>Account Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccountExpirationTime()
	 * @generated
	 * @ordered
	 */
	protected String accountExpirationTime = ACCOUNT_EXPIRATION_TIME_EDEFAULT;

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
	 * The default value of the '{@link #isIsAdmin() <em>Is Admin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsAdmin()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ADMIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAdmin() <em>Is Admin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsAdmin()
	 * @generated
	 * @ordered
	 */
	protected boolean isAdmin = IS_ADMIN_EDEFAULT;

	/**
	 * This is true if the Is Admin attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean isAdminESet;

	/**
	 * The default value of the '{@link #isLoginPermitted() <em>Login Permitted</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isLoginPermitted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOGIN_PERMITTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoginPermitted() <em>Login Permitted</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isLoginPermitted()
	 * @generated
	 * @ordered
	 */
	protected boolean loginPermitted = LOGIN_PERMITTED_EDEFAULT;

	/**
	 * This is true if the Login Permitted attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean loginPermittedESet;

	/**
	 * The default value of the '{@link #getLoginRetries() <em>Login Retries</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLoginRetries()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger LOGIN_RETRIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoginRetries() <em>Login Retries</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLoginRetries()
	 * @generated
	 * @ordered
	 */
	protected BigInteger loginRetries = LOGIN_RETRIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoginTimes() <em>Login Times</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLoginTimes()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger LOGIN_TIMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoginTimes() <em>Login Times</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLoginTimes()
	 * @generated
	 * @ordered
	 */
	protected BigInteger loginTimes = LOGIN_TIMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxCharRepeats() <em>Max Char Repeats</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxCharRepeats()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_CHAR_REPEATS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxCharRepeats() <em>Max Char Repeats</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxCharRepeats()
	 * @generated
	 * @ordered
	 */
	protected BigInteger maxCharRepeats = MAX_CHAR_REPEATS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxPasswordAgeInWeeks() <em>Max Password Age In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxPasswordAgeInWeeks()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_PASSWORD_AGE_IN_WEEKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxPasswordAgeInWeeks() <em>Max Password Age In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxPasswordAgeInWeeks()
	 * @generated
	 * @ordered
	 */
	protected BigInteger maxPasswordAgeInWeeks = MAX_PASSWORD_AGE_IN_WEEKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxPasswordValidWeeks() <em>Max Password Valid Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxPasswordValidWeeks()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_PASSWORD_VALID_WEEKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxPasswordValidWeeks() <em>Max Password Valid Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxPasswordValidWeeks()
	 * @generated
	 * @ordered
	 */
	protected BigInteger maxPasswordValidWeeks = MAX_PASSWORD_VALID_WEEKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinAlphaCharsInPassword() <em>Min Alpha Chars In Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinAlphaCharsInPassword()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_ALPHA_CHARS_IN_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinAlphaCharsInPassword() <em>Min Alpha Chars In Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinAlphaCharsInPassword()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minAlphaCharsInPassword = MIN_ALPHA_CHARS_IN_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinDiffChars() <em>Min Diff Chars</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinDiffChars()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_DIFF_CHARS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinDiffChars() <em>Min Diff Chars</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinDiffChars()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minDiffChars = MIN_DIFF_CHARS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinOtherCharsInPassword() <em>Min Other Chars In Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinOtherCharsInPassword()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_OTHER_CHARS_IN_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinOtherCharsInPassword() <em>Min Other Chars In Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinOtherCharsInPassword()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minOtherCharsInPassword = MIN_OTHER_CHARS_IN_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinPasswordAgeInWeeks() <em>Min Password Age In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinPasswordAgeInWeeks()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_PASSWORD_AGE_IN_WEEKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinPasswordAgeInWeeks() <em>Min Password Age In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinPasswordAgeInWeeks()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minPasswordAgeInWeeks = MIN_PASSWORD_AGE_IN_WEEKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinPasswordLength() <em>Min Password Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinPasswordLength()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_PASSWORD_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinPasswordLength() <em>Min Password Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinPasswordLength()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minPasswordLength = MIN_PASSWORD_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotReusableNumberOfPasswords() <em>Not Reusable Number Of Passwords</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNotReusableNumberOfPasswords()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger NOT_REUSABLE_NUMBER_OF_PASSWORDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotReusableNumberOfPasswords() <em>Not Reusable Number Of Passwords</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNotReusableNumberOfPasswords()
	 * @generated
	 * @ordered
	 */
	protected BigInteger notReusableNumberOfPasswords = NOT_REUSABLE_NUMBER_OF_PASSWORDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassReuseNotAllowedInWeeks() <em>Pass Reuse Not Allowed In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPassReuseNotAllowedInWeeks()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PASS_REUSE_NOT_ALLOWED_IN_WEEKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassReuseNotAllowedInWeeks() <em>Pass Reuse Not Allowed In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPassReuseNotAllowedInWeeks()
	 * @generated
	 * @ordered
	 */
	protected BigInteger passReuseNotAllowedInWeeks = PASS_REUSE_NOT_ALLOWED_IN_WEEKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordChangeWarnTime() <em>Password Change Warn Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPasswordChangeWarnTime()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PASSWORD_CHANGE_WARN_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswordChangeWarnTime() <em>Password Change Warn Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPasswordChangeWarnTime()
	 * @generated
	 * @ordered
	 */
	protected BigInteger passwordChangeWarnTime = PASSWORD_CHANGE_WARN_TIME_EDEFAULT;

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
	 * The default value of the '{@link #getPrimaryAuthMethod() <em>Primary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPrimaryAuthMethod()
	 * @generated
	 * @ordered
	 */
	protected static final AIXAuthMethodType PRIMARY_AUTH_METHOD_EDEFAULT = AIXAuthMethodType.SYSTEM_LITERAL;

	/**
	 * The cached value of the '{@link #getPrimaryAuthMethod() <em>Primary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPrimaryAuthMethod()
	 * @generated
	 * @ordered
	 */
	protected AIXAuthMethodType primaryAuthMethod = PRIMARY_AUTH_METHOD_EDEFAULT;

	/**
	 * This is true if the Primary Auth Method attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean primaryAuthMethodESet;

	/**
	 * The default value of the '{@link #isRemoteLoginIsAllowed() <em>Remote Login Is Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRemoteLoginIsAllowed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOTE_LOGIN_IS_ALLOWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoteLoginIsAllowed() <em>Remote Login Is Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRemoteLoginIsAllowed()
	 * @generated
	 * @ordered
	 */
	protected boolean remoteLoginIsAllowed = REMOTE_LOGIN_IS_ALLOWED_EDEFAULT;

	/**
	 * This is true if the Remote Login Is Allowed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean remoteLoginIsAllowedESet;

	/**
	 * The default value of the '{@link #getSecondaryAuthMethod() <em>Secondary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSecondaryAuthMethod()
	 * @generated
	 * @ordered
	 */
	protected static final AIXAuthMethodType SECONDARY_AUTH_METHOD_EDEFAULT = AIXAuthMethodType.SYSTEM_LITERAL;

	/**
	 * The cached value of the '{@link #getSecondaryAuthMethod() <em>Secondary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSecondaryAuthMethod()
	 * @generated
	 * @ordered
	 */
	protected AIXAuthMethodType secondaryAuthMethod = SECONDARY_AUTH_METHOD_EDEFAULT;

	/**
	 * This is true if the Secondary Auth Method attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean secondaryAuthMethodESet;

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
	 * The default value of the '{@link #getSuGroupsAllowed() <em>Su Groups Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSuGroupsAllowed()
	 * @generated
	 * @ordered
	 */
	protected static final String SU_GROUPS_ALLOWED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuGroupsAllowed() <em>Su Groups Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSuGroupsAllowed()
	 * @generated
	 * @ordered
	 */
	protected String suGroupsAllowed = SU_GROUPS_ALLOWED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuIsAllowed() <em>Su Is Allowed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSuIsAllowed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SU_IS_ALLOWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuIsAllowed() <em>Su Is Allowed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSuIsAllowed()
	 * @generated
	 * @ordered
	 */
	protected boolean suIsAllowed = SU_IS_ALLOWED_EDEFAULT;

	/**
	 * This is true if the Su Is Allowed attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean suIsAllowedESet;

	/**
	 * The default value of the '{@link #getTimeLastLogin() <em>Time Last Login</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimeLastLogin()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_LAST_LOGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeLastLogin() <em>Time Last Login</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimeLastLogin()
	 * @generated
	 * @ordered
	 */
	protected String timeLastLogin = TIME_LAST_LOGIN_EDEFAULT;

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
	 * The default value of the '{@link #getUserRegisteringMethod() <em>User Registering Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserRegisteringMethod()
	 * @generated
	 * @ordered
	 */
	protected static final AIXUserRegisteringMethodType USER_REGISTERING_METHOD_EDEFAULT = AIXUserRegisteringMethodType.FILES_LITERAL;

	/**
	 * The cached value of the '{@link #getUserRegisteringMethod() <em>User Registering Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserRegisteringMethod()
	 * @generated
	 * @ordered
	 */
	protected AIXUserRegisteringMethodType userRegisteringMethod = USER_REGISTERING_METHOD_EDEFAULT;

	/**
	 * This is true if the User Registering Method attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean userRegisteringMethodESet;

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
	 * The default value of the '{@link #getUsuccessfulLoginCount() <em>Usuccessful Login Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUsuccessfulLoginCount()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger USUCCESSFUL_LOGIN_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsuccessfulLoginCount() <em>Usuccessful Login Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUsuccessfulLoginCount()
	 * @generated
	 * @ordered
	 */
	protected BigInteger usuccessfulLoginCount = USUCCESSFUL_LOGIN_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AIXLocalUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.AIX_LOCAL_USER;
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
					OsPackage.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION, oldAccountDescription,
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
					OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED, oldAccountDisabled, accountDisabled,
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
					OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED, oldAccountDisabled,
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
	public String getAccountExpirationTime() {
		return accountExpirationTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountExpirationTime(String newAccountExpirationTime) {
		String oldAccountExpirationTime = accountExpirationTime;
		accountExpirationTime = newAccountExpirationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME, oldAccountExpirationTime,
					accountExpirationTime));
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
					OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON, oldChangePasswordNextLogon,
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
					OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON, oldChangePasswordNextLogon,
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
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_LOCAL_USER__FULL_NAME,
					oldFullName, fullName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_LOCAL_USER__HOME_DIR,
					oldHomeDir, homeDir));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAdmin() {
		return isAdmin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAdmin(boolean newIsAdmin) {
		boolean oldIsAdmin = isAdmin;
		isAdmin = newIsAdmin;
		boolean oldIsAdminESet = isAdminESet;
		isAdminESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_LOCAL_USER__IS_ADMIN,
					oldIsAdmin, isAdmin, !oldIsAdminESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsAdmin() {
		boolean oldIsAdmin = isAdmin;
		boolean oldIsAdminESet = isAdminESet;
		isAdmin = IS_ADMIN_EDEFAULT;
		isAdminESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__IS_ADMIN, oldIsAdmin, IS_ADMIN_EDEFAULT, oldIsAdminESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsAdmin() {
		return isAdminESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoginPermitted() {
		return loginPermitted;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoginPermitted(boolean newLoginPermitted) {
		boolean oldLoginPermitted = loginPermitted;
		loginPermitted = newLoginPermitted;
		boolean oldLoginPermittedESet = loginPermittedESet;
		loginPermittedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED, oldLoginPermitted, loginPermitted,
					!oldLoginPermittedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLoginPermitted() {
		boolean oldLoginPermitted = loginPermitted;
		boolean oldLoginPermittedESet = loginPermittedESet;
		loginPermitted = LOGIN_PERMITTED_EDEFAULT;
		loginPermittedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED, oldLoginPermitted,
					LOGIN_PERMITTED_EDEFAULT, oldLoginPermittedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLoginPermitted() {
		return loginPermittedESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLoginRetries() {
		return loginRetries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoginRetries(BigInteger newLoginRetries) {
		BigInteger oldLoginRetries = loginRetries;
		loginRetries = newLoginRetries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__LOGIN_RETRIES, oldLoginRetries, loginRetries));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLoginTimes() {
		return loginTimes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoginTimes(BigInteger newLoginTimes) {
		BigInteger oldLoginTimes = loginTimes;
		loginTimes = newLoginTimes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__LOGIN_TIMES, oldLoginTimes, loginTimes));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxCharRepeats() {
		return maxCharRepeats;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCharRepeats(BigInteger newMaxCharRepeats) {
		BigInteger oldMaxCharRepeats = maxCharRepeats;
		maxCharRepeats = newMaxCharRepeats;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MAX_CHAR_REPEATS, oldMaxCharRepeats, maxCharRepeats));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxPasswordAgeInWeeks() {
		return maxPasswordAgeInWeeks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxPasswordAgeInWeeks(BigInteger newMaxPasswordAgeInWeeks) {
		BigInteger oldMaxPasswordAgeInWeeks = maxPasswordAgeInWeeks;
		maxPasswordAgeInWeeks = newMaxPasswordAgeInWeeks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS, oldMaxPasswordAgeInWeeks,
					maxPasswordAgeInWeeks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxPasswordValidWeeks() {
		return maxPasswordValidWeeks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxPasswordValidWeeks(BigInteger newMaxPasswordValidWeeks) {
		BigInteger oldMaxPasswordValidWeeks = maxPasswordValidWeeks;
		maxPasswordValidWeeks = newMaxPasswordValidWeeks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS, oldMaxPasswordValidWeeks,
					maxPasswordValidWeeks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinAlphaCharsInPassword() {
		return minAlphaCharsInPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinAlphaCharsInPassword(BigInteger newMinAlphaCharsInPassword) {
		BigInteger oldMinAlphaCharsInPassword = minAlphaCharsInPassword;
		minAlphaCharsInPassword = newMinAlphaCharsInPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD, oldMinAlphaCharsInPassword,
					minAlphaCharsInPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinDiffChars() {
		return minDiffChars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinDiffChars(BigInteger newMinDiffChars) {
		BigInteger oldMinDiffChars = minDiffChars;
		minDiffChars = newMinDiffChars;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MIN_DIFF_CHARS, oldMinDiffChars, minDiffChars));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinOtherCharsInPassword() {
		return minOtherCharsInPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinOtherCharsInPassword(BigInteger newMinOtherCharsInPassword) {
		BigInteger oldMinOtherCharsInPassword = minOtherCharsInPassword;
		minOtherCharsInPassword = newMinOtherCharsInPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD, oldMinOtherCharsInPassword,
					minOtherCharsInPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinPasswordAgeInWeeks() {
		return minPasswordAgeInWeeks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinPasswordAgeInWeeks(BigInteger newMinPasswordAgeInWeeks) {
		BigInteger oldMinPasswordAgeInWeeks = minPasswordAgeInWeeks;
		minPasswordAgeInWeeks = newMinPasswordAgeInWeeks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS, oldMinPasswordAgeInWeeks,
					minPasswordAgeInWeeks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinPasswordLength() {
		return minPasswordLength;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinPasswordLength(BigInteger newMinPasswordLength) {
		BigInteger oldMinPasswordLength = minPasswordLength;
		minPasswordLength = newMinPasswordLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH, oldMinPasswordLength,
					minPasswordLength));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getNotReusableNumberOfPasswords() {
		return notReusableNumberOfPasswords;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotReusableNumberOfPasswords(BigInteger newNotReusableNumberOfPasswords) {
		BigInteger oldNotReusableNumberOfPasswords = notReusableNumberOfPasswords;
		notReusableNumberOfPasswords = newNotReusableNumberOfPasswords;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS,
					oldNotReusableNumberOfPasswords, notReusableNumberOfPasswords));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPassReuseNotAllowedInWeeks() {
		return passReuseNotAllowedInWeeks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassReuseNotAllowedInWeeks(BigInteger newPassReuseNotAllowedInWeeks) {
		BigInteger oldPassReuseNotAllowedInWeeks = passReuseNotAllowedInWeeks;
		passReuseNotAllowedInWeeks = newPassReuseNotAllowedInWeeks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS,
					oldPassReuseNotAllowedInWeeks, passReuseNotAllowedInWeeks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPasswordChangeWarnTime() {
		return passwordChangeWarnTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordChangeWarnTime(BigInteger newPasswordChangeWarnTime) {
		BigInteger oldPasswordChangeWarnTime = passwordChangeWarnTime;
		passwordChangeWarnTime = newPasswordChangeWarnTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME, oldPasswordChangeWarnTime,
					passwordChangeWarnTime));
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
					OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES, oldPasswordNeverExpires,
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
					OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES, oldPasswordNeverExpires,
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
	public AIXAuthMethodType getPrimaryAuthMethod() {
		return primaryAuthMethod;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryAuthMethod(AIXAuthMethodType newPrimaryAuthMethod) {
		AIXAuthMethodType oldPrimaryAuthMethod = primaryAuthMethod;
		primaryAuthMethod = newPrimaryAuthMethod == null ? PRIMARY_AUTH_METHOD_EDEFAULT
				: newPrimaryAuthMethod;
		boolean oldPrimaryAuthMethodESet = primaryAuthMethodESet;
		primaryAuthMethodESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD, oldPrimaryAuthMethod,
					primaryAuthMethod, !oldPrimaryAuthMethodESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPrimaryAuthMethod() {
		AIXAuthMethodType oldPrimaryAuthMethod = primaryAuthMethod;
		boolean oldPrimaryAuthMethodESet = primaryAuthMethodESet;
		primaryAuthMethod = PRIMARY_AUTH_METHOD_EDEFAULT;
		primaryAuthMethodESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD, oldPrimaryAuthMethod,
					PRIMARY_AUTH_METHOD_EDEFAULT, oldPrimaryAuthMethodESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrimaryAuthMethod() {
		return primaryAuthMethodESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoteLoginIsAllowed() {
		return remoteLoginIsAllowed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteLoginIsAllowed(boolean newRemoteLoginIsAllowed) {
		boolean oldRemoteLoginIsAllowed = remoteLoginIsAllowed;
		remoteLoginIsAllowed = newRemoteLoginIsAllowed;
		boolean oldRemoteLoginIsAllowedESet = remoteLoginIsAllowedESet;
		remoteLoginIsAllowedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED, oldRemoteLoginIsAllowed,
					remoteLoginIsAllowed, !oldRemoteLoginIsAllowedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRemoteLoginIsAllowed() {
		boolean oldRemoteLoginIsAllowed = remoteLoginIsAllowed;
		boolean oldRemoteLoginIsAllowedESet = remoteLoginIsAllowedESet;
		remoteLoginIsAllowed = REMOTE_LOGIN_IS_ALLOWED_EDEFAULT;
		remoteLoginIsAllowedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED, oldRemoteLoginIsAllowed,
					REMOTE_LOGIN_IS_ALLOWED_EDEFAULT, oldRemoteLoginIsAllowedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRemoteLoginIsAllowed() {
		return remoteLoginIsAllowedESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXAuthMethodType getSecondaryAuthMethod() {
		return secondaryAuthMethod;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondaryAuthMethod(AIXAuthMethodType newSecondaryAuthMethod) {
		AIXAuthMethodType oldSecondaryAuthMethod = secondaryAuthMethod;
		secondaryAuthMethod = newSecondaryAuthMethod == null ? SECONDARY_AUTH_METHOD_EDEFAULT
				: newSecondaryAuthMethod;
		boolean oldSecondaryAuthMethodESet = secondaryAuthMethodESet;
		secondaryAuthMethodESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD, oldSecondaryAuthMethod,
					secondaryAuthMethod, !oldSecondaryAuthMethodESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecondaryAuthMethod() {
		AIXAuthMethodType oldSecondaryAuthMethod = secondaryAuthMethod;
		boolean oldSecondaryAuthMethodESet = secondaryAuthMethodESet;
		secondaryAuthMethod = SECONDARY_AUTH_METHOD_EDEFAULT;
		secondaryAuthMethodESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD, oldSecondaryAuthMethod,
					SECONDARY_AUTH_METHOD_EDEFAULT, oldSecondaryAuthMethodESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecondaryAuthMethod() {
		return secondaryAuthMethodESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_LOCAL_USER__SHELL,
					oldShell, shell));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuGroupsAllowed() {
		return suGroupsAllowed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuGroupsAllowed(String newSuGroupsAllowed) {
		String oldSuGroupsAllowed = suGroupsAllowed;
		suGroupsAllowed = newSuGroupsAllowed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__SU_GROUPS_ALLOWED, oldSuGroupsAllowed, suGroupsAllowed));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuIsAllowed() {
		return suIsAllowed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuIsAllowed(boolean newSuIsAllowed) {
		boolean oldSuIsAllowed = suIsAllowed;
		suIsAllowed = newSuIsAllowed;
		boolean oldSuIsAllowedESet = suIsAllowedESet;
		suIsAllowedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED, oldSuIsAllowed, suIsAllowed,
					!oldSuIsAllowedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuIsAllowed() {
		boolean oldSuIsAllowed = suIsAllowed;
		boolean oldSuIsAllowedESet = suIsAllowedESet;
		suIsAllowed = SU_IS_ALLOWED_EDEFAULT;
		suIsAllowedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED, oldSuIsAllowed, SU_IS_ALLOWED_EDEFAULT,
					oldSuIsAllowedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuIsAllowed() {
		return suIsAllowedESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeLastLogin() {
		return timeLastLogin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeLastLogin(String newTimeLastLogin) {
		String oldTimeLastLogin = timeLastLogin;
		timeLastLogin = newTimeLastLogin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__TIME_LAST_LOGIN, oldTimeLastLogin, timeLastLogin));
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
					OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD, oldUserCannotChangePassword,
					userCannotChangePassword, !oldUserCannotChangePasswordESet));
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
					OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD, oldUserCannotChangePassword,
					USER_CANNOT_CHANGE_PASSWORD_EDEFAULT, oldUserCannotChangePasswordESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_LOCAL_USER__USER_NAME,
					oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXUserRegisteringMethodType getUserRegisteringMethod() {
		return userRegisteringMethod;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserRegisteringMethod(AIXUserRegisteringMethodType newUserRegisteringMethod) {
		AIXUserRegisteringMethodType oldUserRegisteringMethod = userRegisteringMethod;
		userRegisteringMethod = newUserRegisteringMethod == null ? USER_REGISTERING_METHOD_EDEFAULT
				: newUserRegisteringMethod;
		boolean oldUserRegisteringMethodESet = userRegisteringMethodESet;
		userRegisteringMethodESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD, oldUserRegisteringMethod,
					userRegisteringMethod, !oldUserRegisteringMethodESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserRegisteringMethod() {
		AIXUserRegisteringMethodType oldUserRegisteringMethod = userRegisteringMethod;
		boolean oldUserRegisteringMethodESet = userRegisteringMethodESet;
		userRegisteringMethod = USER_REGISTERING_METHOD_EDEFAULT;
		userRegisteringMethodESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD, oldUserRegisteringMethod,
					USER_REGISTERING_METHOD_EDEFAULT, oldUserRegisteringMethodESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserRegisteringMethod() {
		return userRegisteringMethodESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_LOCAL_USER__USER_SID,
					oldUserSid, userSid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getUsuccessfulLoginCount() {
		return usuccessfulLoginCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsuccessfulLoginCount(BigInteger newUsuccessfulLoginCount) {
		BigInteger oldUsuccessfulLoginCount = usuccessfulLoginCount;
		usuccessfulLoginCount = newUsuccessfulLoginCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT, oldUsuccessfulLoginCount,
					usuccessfulLoginCount));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			return getAccountDescription();
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED:
			return isAccountDisabled() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME:
			return getAccountExpirationTime();
		case OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			return isChangePasswordNextLogon() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__FULL_NAME:
			return getFullName();
		case OsPackage.AIX_LOCAL_USER__HOME_DIR:
			return getHomeDir();
		case OsPackage.AIX_LOCAL_USER__IS_ADMIN:
			return isIsAdmin() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED:
			return isLoginPermitted() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__LOGIN_RETRIES:
			return getLoginRetries();
		case OsPackage.AIX_LOCAL_USER__LOGIN_TIMES:
			return getLoginTimes();
		case OsPackage.AIX_LOCAL_USER__MAX_CHAR_REPEATS:
			return getMaxCharRepeats();
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS:
			return getMaxPasswordAgeInWeeks();
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS:
			return getMaxPasswordValidWeeks();
		case OsPackage.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD:
			return getMinAlphaCharsInPassword();
		case OsPackage.AIX_LOCAL_USER__MIN_DIFF_CHARS:
			return getMinDiffChars();
		case OsPackage.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD:
			return getMinOtherCharsInPassword();
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS:
			return getMinPasswordAgeInWeeks();
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH:
			return getMinPasswordLength();
		case OsPackage.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS:
			return getNotReusableNumberOfPasswords();
		case OsPackage.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS:
			return getPassReuseNotAllowedInWeeks();
		case OsPackage.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME:
			return getPasswordChangeWarnTime();
		case OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			return isPasswordNeverExpires() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD:
			return getPrimaryAuthMethod();
		case OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED:
			return isRemoteLoginIsAllowed() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD:
			return getSecondaryAuthMethod();
		case OsPackage.AIX_LOCAL_USER__SHELL:
			return getShell();
		case OsPackage.AIX_LOCAL_USER__SU_GROUPS_ALLOWED:
			return getSuGroupsAllowed();
		case OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED:
			return isSuIsAllowed() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__TIME_LAST_LOGIN:
			return getTimeLastLogin();
		case OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			return isUserCannotChangePassword() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_USER__USER_NAME:
			return getUserName();
		case OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD:
			return getUserRegisteringMethod();
		case OsPackage.AIX_LOCAL_USER__USER_SID:
			return getUserSid();
		case OsPackage.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT:
			return getUsuccessfulLoginCount();
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
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			setAccountDescription((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED:
			setAccountDisabled(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME:
			setAccountExpirationTime((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			setChangePasswordNextLogon(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__FULL_NAME:
			setFullName((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__HOME_DIR:
			setHomeDir((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__IS_ADMIN:
			setIsAdmin(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED:
			setLoginPermitted(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__LOGIN_RETRIES:
			setLoginRetries((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__LOGIN_TIMES:
			setLoginTimes((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MAX_CHAR_REPEATS:
			setMaxCharRepeats((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS:
			setMaxPasswordAgeInWeeks((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS:
			setMaxPasswordValidWeeks((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD:
			setMinAlphaCharsInPassword((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_DIFF_CHARS:
			setMinDiffChars((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD:
			setMinOtherCharsInPassword((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS:
			setMinPasswordAgeInWeeks((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH:
			setMinPasswordLength((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS:
			setNotReusableNumberOfPasswords((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS:
			setPassReuseNotAllowedInWeeks((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME:
			setPasswordChangeWarnTime((BigInteger) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			setPasswordNeverExpires(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD:
			setPrimaryAuthMethod((AIXAuthMethodType) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED:
			setRemoteLoginIsAllowed(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD:
			setSecondaryAuthMethod((AIXAuthMethodType) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__SHELL:
			setShell((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__SU_GROUPS_ALLOWED:
			setSuGroupsAllowed((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED:
			setSuIsAllowed(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__TIME_LAST_LOGIN:
			setTimeLastLogin((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			setUserCannotChangePassword(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_USER__USER_NAME:
			setUserName((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD:
			setUserRegisteringMethod((AIXUserRegisteringMethodType) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__USER_SID:
			setUserSid((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT:
			setUsuccessfulLoginCount((BigInteger) newValue);
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
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			setAccountDescription(ACCOUNT_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED:
			unsetAccountDisabled();
			return;
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME:
			setAccountExpirationTime(ACCOUNT_EXPIRATION_TIME_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			unsetChangePasswordNextLogon();
			return;
		case OsPackage.AIX_LOCAL_USER__FULL_NAME:
			setFullName(FULL_NAME_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__HOME_DIR:
			setHomeDir(HOME_DIR_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__IS_ADMIN:
			unsetIsAdmin();
			return;
		case OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED:
			unsetLoginPermitted();
			return;
		case OsPackage.AIX_LOCAL_USER__LOGIN_RETRIES:
			setLoginRetries(LOGIN_RETRIES_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__LOGIN_TIMES:
			setLoginTimes(LOGIN_TIMES_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MAX_CHAR_REPEATS:
			setMaxCharRepeats(MAX_CHAR_REPEATS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS:
			setMaxPasswordAgeInWeeks(MAX_PASSWORD_AGE_IN_WEEKS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS:
			setMaxPasswordValidWeeks(MAX_PASSWORD_VALID_WEEKS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD:
			setMinAlphaCharsInPassword(MIN_ALPHA_CHARS_IN_PASSWORD_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_DIFF_CHARS:
			setMinDiffChars(MIN_DIFF_CHARS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD:
			setMinOtherCharsInPassword(MIN_OTHER_CHARS_IN_PASSWORD_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS:
			setMinPasswordAgeInWeeks(MIN_PASSWORD_AGE_IN_WEEKS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH:
			setMinPasswordLength(MIN_PASSWORD_LENGTH_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS:
			setNotReusableNumberOfPasswords(NOT_REUSABLE_NUMBER_OF_PASSWORDS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS:
			setPassReuseNotAllowedInWeeks(PASS_REUSE_NOT_ALLOWED_IN_WEEKS_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME:
			setPasswordChangeWarnTime(PASSWORD_CHANGE_WARN_TIME_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			unsetPasswordNeverExpires();
			return;
		case OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD:
			unsetPrimaryAuthMethod();
			return;
		case OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED:
			unsetRemoteLoginIsAllowed();
			return;
		case OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD:
			unsetSecondaryAuthMethod();
			return;
		case OsPackage.AIX_LOCAL_USER__SHELL:
			setShell(SHELL_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__SU_GROUPS_ALLOWED:
			setSuGroupsAllowed(SU_GROUPS_ALLOWED_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED:
			unsetSuIsAllowed();
			return;
		case OsPackage.AIX_LOCAL_USER__TIME_LAST_LOGIN:
			setTimeLastLogin(TIME_LAST_LOGIN_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			unsetUserCannotChangePassword();
			return;
		case OsPackage.AIX_LOCAL_USER__USER_NAME:
			setUserName(USER_NAME_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD:
			unsetUserRegisteringMethod();
			return;
		case OsPackage.AIX_LOCAL_USER__USER_SID:
			setUserSid(USER_SID_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT:
			setUsuccessfulLoginCount(USUCCESSFUL_LOGIN_COUNT_EDEFAULT);
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
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION:
			return ACCOUNT_DESCRIPTION_EDEFAULT == null ? accountDescription != null
					: !ACCOUNT_DESCRIPTION_EDEFAULT.equals(accountDescription);
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED:
			return isSetAccountDisabled();
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME:
			return ACCOUNT_EXPIRATION_TIME_EDEFAULT == null ? accountExpirationTime != null
					: !ACCOUNT_EXPIRATION_TIME_EDEFAULT.equals(accountExpirationTime);
		case OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
			return isSetChangePasswordNextLogon();
		case OsPackage.AIX_LOCAL_USER__FULL_NAME:
			return FULL_NAME_EDEFAULT == null ? fullName != null : !FULL_NAME_EDEFAULT
					.equals(fullName);
		case OsPackage.AIX_LOCAL_USER__HOME_DIR:
			return HOME_DIR_EDEFAULT == null ? homeDir != null : !HOME_DIR_EDEFAULT.equals(homeDir);
		case OsPackage.AIX_LOCAL_USER__IS_ADMIN:
			return isSetIsAdmin();
		case OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED:
			return isSetLoginPermitted();
		case OsPackage.AIX_LOCAL_USER__LOGIN_RETRIES:
			return LOGIN_RETRIES_EDEFAULT == null ? loginRetries != null : !LOGIN_RETRIES_EDEFAULT
					.equals(loginRetries);
		case OsPackage.AIX_LOCAL_USER__LOGIN_TIMES:
			return LOGIN_TIMES_EDEFAULT == null ? loginTimes != null : !LOGIN_TIMES_EDEFAULT
					.equals(loginTimes);
		case OsPackage.AIX_LOCAL_USER__MAX_CHAR_REPEATS:
			return MAX_CHAR_REPEATS_EDEFAULT == null ? maxCharRepeats != null
					: !MAX_CHAR_REPEATS_EDEFAULT.equals(maxCharRepeats);
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS:
			return MAX_PASSWORD_AGE_IN_WEEKS_EDEFAULT == null ? maxPasswordAgeInWeeks != null
					: !MAX_PASSWORD_AGE_IN_WEEKS_EDEFAULT.equals(maxPasswordAgeInWeeks);
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS:
			return MAX_PASSWORD_VALID_WEEKS_EDEFAULT == null ? maxPasswordValidWeeks != null
					: !MAX_PASSWORD_VALID_WEEKS_EDEFAULT.equals(maxPasswordValidWeeks);
		case OsPackage.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD:
			return MIN_ALPHA_CHARS_IN_PASSWORD_EDEFAULT == null ? minAlphaCharsInPassword != null
					: !MIN_ALPHA_CHARS_IN_PASSWORD_EDEFAULT.equals(minAlphaCharsInPassword);
		case OsPackage.AIX_LOCAL_USER__MIN_DIFF_CHARS:
			return MIN_DIFF_CHARS_EDEFAULT == null ? minDiffChars != null : !MIN_DIFF_CHARS_EDEFAULT
					.equals(minDiffChars);
		case OsPackage.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD:
			return MIN_OTHER_CHARS_IN_PASSWORD_EDEFAULT == null ? minOtherCharsInPassword != null
					: !MIN_OTHER_CHARS_IN_PASSWORD_EDEFAULT.equals(minOtherCharsInPassword);
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS:
			return MIN_PASSWORD_AGE_IN_WEEKS_EDEFAULT == null ? minPasswordAgeInWeeks != null
					: !MIN_PASSWORD_AGE_IN_WEEKS_EDEFAULT.equals(minPasswordAgeInWeeks);
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH:
			return MIN_PASSWORD_LENGTH_EDEFAULT == null ? minPasswordLength != null
					: !MIN_PASSWORD_LENGTH_EDEFAULT.equals(minPasswordLength);
		case OsPackage.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS:
			return NOT_REUSABLE_NUMBER_OF_PASSWORDS_EDEFAULT == null ? notReusableNumberOfPasswords != null
					: !NOT_REUSABLE_NUMBER_OF_PASSWORDS_EDEFAULT.equals(notReusableNumberOfPasswords);
		case OsPackage.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS:
			return PASS_REUSE_NOT_ALLOWED_IN_WEEKS_EDEFAULT == null ? passReuseNotAllowedInWeeks != null
					: !PASS_REUSE_NOT_ALLOWED_IN_WEEKS_EDEFAULT.equals(passReuseNotAllowedInWeeks);
		case OsPackage.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME:
			return PASSWORD_CHANGE_WARN_TIME_EDEFAULT == null ? passwordChangeWarnTime != null
					: !PASSWORD_CHANGE_WARN_TIME_EDEFAULT.equals(passwordChangeWarnTime);
		case OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
			return isSetPasswordNeverExpires();
		case OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD:
			return isSetPrimaryAuthMethod();
		case OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED:
			return isSetRemoteLoginIsAllowed();
		case OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD:
			return isSetSecondaryAuthMethod();
		case OsPackage.AIX_LOCAL_USER__SHELL:
			return SHELL_EDEFAULT == null ? shell != null : !SHELL_EDEFAULT.equals(shell);
		case OsPackage.AIX_LOCAL_USER__SU_GROUPS_ALLOWED:
			return SU_GROUPS_ALLOWED_EDEFAULT == null ? suGroupsAllowed != null
					: !SU_GROUPS_ALLOWED_EDEFAULT.equals(suGroupsAllowed);
		case OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED:
			return isSetSuIsAllowed();
		case OsPackage.AIX_LOCAL_USER__TIME_LAST_LOGIN:
			return TIME_LAST_LOGIN_EDEFAULT == null ? timeLastLogin != null
					: !TIME_LAST_LOGIN_EDEFAULT.equals(timeLastLogin);
		case OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
			return isSetUserCannotChangePassword();
		case OsPackage.AIX_LOCAL_USER__USER_NAME:
			return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT
					.equals(userName);
		case OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD:
			return isSetUserRegisteringMethod();
		case OsPackage.AIX_LOCAL_USER__USER_SID:
			return USER_SID_EDEFAULT == null ? userSid != null : !USER_SID_EDEFAULT.equals(userSid);
		case OsPackage.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT:
			return USUCCESSFUL_LOGIN_COUNT_EDEFAULT == null ? usuccessfulLoginCount != null
					: !USUCCESSFUL_LOGIN_COUNT_EDEFAULT.equals(usuccessfulLoginCount);
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
		result.append(", accountExpirationTime: "); //$NON-NLS-1$
		result.append(accountExpirationTime);
		result.append(", changePasswordNextLogon: "); //$NON-NLS-1$
		if (changePasswordNextLogonESet)
			result.append(changePasswordNextLogon);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", fullName: "); //$NON-NLS-1$
		result.append(fullName);
		result.append(", homeDir: "); //$NON-NLS-1$
		result.append(homeDir);
		result.append(", isAdmin: "); //$NON-NLS-1$
		if (isAdminESet)
			result.append(isAdmin);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", loginPermitted: "); //$NON-NLS-1$
		if (loginPermittedESet)
			result.append(loginPermitted);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", loginRetries: "); //$NON-NLS-1$
		result.append(loginRetries);
		result.append(", loginTimes: "); //$NON-NLS-1$
		result.append(loginTimes);
		result.append(", maxCharRepeats: "); //$NON-NLS-1$
		result.append(maxCharRepeats);
		result.append(", maxPasswordAgeInWeeks: "); //$NON-NLS-1$
		result.append(maxPasswordAgeInWeeks);
		result.append(", maxPasswordValidWeeks: "); //$NON-NLS-1$
		result.append(maxPasswordValidWeeks);
		result.append(", minAlphaCharsInPassword: "); //$NON-NLS-1$
		result.append(minAlphaCharsInPassword);
		result.append(", minDiffChars: "); //$NON-NLS-1$
		result.append(minDiffChars);
		result.append(", minOtherCharsInPassword: "); //$NON-NLS-1$
		result.append(minOtherCharsInPassword);
		result.append(", minPasswordAgeInWeeks: "); //$NON-NLS-1$
		result.append(minPasswordAgeInWeeks);
		result.append(", minPasswordLength: "); //$NON-NLS-1$
		result.append(minPasswordLength);
		result.append(", notReusableNumberOfPasswords: "); //$NON-NLS-1$
		result.append(notReusableNumberOfPasswords);
		result.append(", passReuseNotAllowedInWeeks: "); //$NON-NLS-1$
		result.append(passReuseNotAllowedInWeeks);
		result.append(", passwordChangeWarnTime: "); //$NON-NLS-1$
		result.append(passwordChangeWarnTime);
		result.append(", passwordNeverExpires: "); //$NON-NLS-1$
		if (passwordNeverExpiresESet)
			result.append(passwordNeverExpires);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", primaryAuthMethod: "); //$NON-NLS-1$
		if (primaryAuthMethodESet)
			result.append(primaryAuthMethod);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", remoteLoginIsAllowed: "); //$NON-NLS-1$
		if (remoteLoginIsAllowedESet)
			result.append(remoteLoginIsAllowed);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", secondaryAuthMethod: "); //$NON-NLS-1$
		if (secondaryAuthMethodESet)
			result.append(secondaryAuthMethod);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", shell: "); //$NON-NLS-1$
		result.append(shell);
		result.append(", suGroupsAllowed: "); //$NON-NLS-1$
		result.append(suGroupsAllowed);
		result.append(", suIsAllowed: "); //$NON-NLS-1$
		if (suIsAllowedESet)
			result.append(suIsAllowed);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", timeLastLogin: "); //$NON-NLS-1$
		result.append(timeLastLogin);
		result.append(", userCannotChangePassword: "); //$NON-NLS-1$
		if (userCannotChangePasswordESet)
			result.append(userCannotChangePassword);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", userName: "); //$NON-NLS-1$
		result.append(userName);
		result.append(", userRegisteringMethod: "); //$NON-NLS-1$
		if (userRegisteringMethodESet)
			result.append(userRegisteringMethod);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", userSid: "); //$NON-NLS-1$
		result.append(userSid);
		result.append(", usuccessfulLoginCount: "); //$NON-NLS-1$
		result.append(usuccessfulLoginCount);
		result.append(')');
		return result.toString();
	}

} //AIXLocalUserImpl
