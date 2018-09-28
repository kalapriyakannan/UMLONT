/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>AIX Local User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountDescription <em>Account Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isAccountDisabled <em>Account Disabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountExpirationTime <em>Account Expiration Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getFullName <em>Full Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getHomeDir <em>Home Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isIsAdmin <em>Is Admin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isLoginPermitted <em>Login Permitted</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginRetries <em>Login Retries</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginTimes <em>Login Times</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxCharRepeats <em>Max Char Repeats</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordAgeInWeeks <em>Max Password Age In Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordValidWeeks <em>Max Password Valid Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinAlphaCharsInPassword <em>Min Alpha Chars In Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinDiffChars <em>Min Diff Chars</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinOtherCharsInPassword <em>Min Other Chars In Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordAgeInWeeks <em>Min Password Age In Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordLength <em>Min Password Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getNotReusableNumberOfPasswords <em>Not Reusable Number Of Passwords</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPassReuseNotAllowedInWeeks <em>Pass Reuse Not Allowed In Weeks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPasswordChangeWarnTime <em>Password Change Warn Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPrimaryAuthMethod <em>Primary Auth Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isRemoteLoginIsAllowed <em>Remote Login Is Allowed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSecondaryAuthMethod <em>Secondary Auth Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getShell <em>Shell</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSuGroupsAllowed <em>Su Groups Allowed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isSuIsAllowed <em>Su Is Allowed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getTimeLastLogin <em>Time Last Login</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserName <em>User Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserRegisteringMethod <em>User Registering Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserSid <em>User Sid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUsuccessfulLoginCount <em>Usuccessful Login Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser()
 * @model extendedMetaData="name='AIXLocalUser' kind='elementOnly'"
 * @generated
 */
public interface AIXLocalUser extends User {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Account Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Description</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Account Description</em>' attribute.
	 * @see #setAccountDescription(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_AccountDescription()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountDescription'"
	 * @generated
	 */
	String getAccountDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountDescription <em>Account Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Description</em>' attribute.
	 * @see #getAccountDescription()
	 * @generated
	 */
	void setAccountDescription(String value);

	/**
	 * Returns the value of the '<em><b>Account Disabled</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Disabled</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Account Disabled</em>' attribute.
	 * @see #isSetAccountDisabled()
	 * @see #unsetAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_AccountDisabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='AccountDisabled'"
	 * @generated
	 */
	boolean isAccountDisabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Disabled</em>' attribute.
	 * @see #isSetAccountDisabled()
	 * @see #unsetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @generated
	 */
	void setAccountDisabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @generated
	 */
	void unsetAccountDisabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Account Disabled</em>' attribute is set.
	 * @see #unsetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @generated
	 */
	boolean isSetAccountDisabled();

	/**
	 * Returns the value of the '<em><b>Account Expiration Time</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Expiration Time</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Account Expiration Time</em>' attribute.
	 * @see #setAccountExpirationTime(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_AccountExpirationTime()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountExpirationTime'"
	 * @generated
	 */
	String getAccountExpirationTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountExpirationTime <em>Account Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Expiration Time</em>' attribute.
	 * @see #getAccountExpirationTime()
	 * @generated
	 */
	void setAccountExpirationTime(String value);

	/**
	 * Returns the value of the '<em><b>Change Password Next Logon</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Password Next Logon</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Change Password Next Logon</em>' attribute.
	 * @see #isSetChangePasswordNextLogon()
	 * @see #unsetChangePasswordNextLogon()
	 * @see #setChangePasswordNextLogon(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_ChangePasswordNextLogon()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='ChangePasswordNextLogon'"
	 * @generated
	 */
	boolean isChangePasswordNextLogon();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Password Next Logon</em>' attribute.
	 * @see #isSetChangePasswordNextLogon()
	 * @see #unsetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @generated
	 */
	void setChangePasswordNextLogon(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @see #setChangePasswordNextLogon(boolean)
	 * @generated
	 */
	void unsetChangePasswordNextLogon();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Change Password Next Logon</em>' attribute is set.
	 * @see #unsetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @see #setChangePasswordNextLogon(boolean)
	 * @generated
	 */
	boolean isSetChangePasswordNextLogon();

	/**
	 * Returns the value of the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Name</em>' attribute.
	 * @see #setFullName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_FullName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FullName'"
	 * @generated
	 */
	String getFullName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getFullName <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Name</em>' attribute.
	 * @see #getFullName()
	 * @generated
	 */
	void setFullName(String value);

	/**
	 * Returns the value of the '<em><b>Home Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home Dir</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Dir</em>' attribute.
	 * @see #setHomeDir(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_HomeDir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='HomeDir'"
	 * @generated
	 */
	String getHomeDir();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getHomeDir <em>Home Dir</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Dir</em>' attribute.
	 * @see #getHomeDir()
	 * @generated
	 */
	void setHomeDir(String value);

	/**
	 * Returns the value of the '<em><b>Is Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Admin</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Admin</em>' attribute.
	 * @see #isSetIsAdmin()
	 * @see #unsetIsAdmin()
	 * @see #setIsAdmin(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_IsAdmin()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='IsAdmin'"
	 * @generated
	 */
	boolean isIsAdmin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isIsAdmin <em>Is Admin</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Admin</em>' attribute.
	 * @see #isSetIsAdmin()
	 * @see #unsetIsAdmin()
	 * @see #isIsAdmin()
	 * @generated
	 */
	void setIsAdmin(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isIsAdmin <em>Is Admin</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIsAdmin()
	 * @see #isIsAdmin()
	 * @see #setIsAdmin(boolean)
	 * @generated
	 */
	void unsetIsAdmin();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isIsAdmin <em>Is Admin</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Admin</em>' attribute is set.
	 * @see #unsetIsAdmin()
	 * @see #isIsAdmin()
	 * @see #setIsAdmin(boolean)
	 * @generated
	 */
	boolean isSetIsAdmin();

	/**
	 * Returns the value of the '<em><b>Login Permitted</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Login Permitted</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login Permitted</em>' attribute.
	 * @see #isSetLoginPermitted()
	 * @see #unsetLoginPermitted()
	 * @see #setLoginPermitted(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_LoginPermitted()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='LoginPermitted'"
	 * @generated
	 */
	boolean isLoginPermitted();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isLoginPermitted <em>Login Permitted</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login Permitted</em>' attribute.
	 * @see #isSetLoginPermitted()
	 * @see #unsetLoginPermitted()
	 * @see #isLoginPermitted()
	 * @generated
	 */
	void setLoginPermitted(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isLoginPermitted <em>Login Permitted</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetLoginPermitted()
	 * @see #isLoginPermitted()
	 * @see #setLoginPermitted(boolean)
	 * @generated
	 */
	void unsetLoginPermitted();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isLoginPermitted <em>Login Permitted</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Login Permitted</em>' attribute is set.
	 * @see #unsetLoginPermitted()
	 * @see #isLoginPermitted()
	 * @see #setLoginPermitted(boolean)
	 * @generated
	 */
	boolean isSetLoginPermitted();

	/**
	 * Returns the value of the '<em><b>Login Retries</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Login Retries</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login Retries</em>' attribute.
	 * @see #setLoginRetries(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_LoginRetries()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='LoginRetries'"
	 * @generated
	 */
	BigInteger getLoginRetries();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginRetries <em>Login Retries</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login Retries</em>' attribute.
	 * @see #getLoginRetries()
	 * @generated
	 */
	void setLoginRetries(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Login Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login Times</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login Times</em>' attribute.
	 * @see #setLoginTimes(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_LoginTimes()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='LoginTimes'"
	 * @generated
	 */
	BigInteger getLoginTimes();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginTimes <em>Login Times</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login Times</em>' attribute.
	 * @see #getLoginTimes()
	 * @generated
	 */
	void setLoginTimes(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Char Repeats</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Char Repeats</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Char Repeats</em>' attribute.
	 * @see #setMaxCharRepeats(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MaxCharRepeats()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MaxCharRepeats'"
	 * @generated
	 */
	BigInteger getMaxCharRepeats();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxCharRepeats <em>Max Char Repeats</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Char Repeats</em>' attribute.
	 * @see #getMaxCharRepeats()
	 * @generated
	 */
	void setMaxCharRepeats(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Password Age In Weeks</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Password Age In Weeks</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Password Age In Weeks</em>' attribute.
	 * @see #setMaxPasswordAgeInWeeks(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MaxPasswordAgeInWeeks()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MaxPasswordAgeInWeeks'"
	 * @generated
	 */
	BigInteger getMaxPasswordAgeInWeeks();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordAgeInWeeks <em>Max Password Age In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Password Age In Weeks</em>' attribute.
	 * @see #getMaxPasswordAgeInWeeks()
	 * @generated
	 */
	void setMaxPasswordAgeInWeeks(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Password Valid Weeks</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Password Valid Weeks</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Password Valid Weeks</em>' attribute.
	 * @see #setMaxPasswordValidWeeks(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MaxPasswordValidWeeks()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MaxPasswordValidWeeks'"
	 * @generated
	 */
	BigInteger getMaxPasswordValidWeeks();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordValidWeeks <em>Max Password Valid Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Password Valid Weeks</em>' attribute.
	 * @see #getMaxPasswordValidWeeks()
	 * @generated
	 */
	void setMaxPasswordValidWeeks(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Alpha Chars In Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Alpha Chars In Password</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Alpha Chars In Password</em>' attribute.
	 * @see #setMinAlphaCharsInPassword(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MinAlphaCharsInPassword()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MinAlphaCharsInPassword'"
	 * @generated
	 */
	BigInteger getMinAlphaCharsInPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinAlphaCharsInPassword <em>Min Alpha Chars In Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Alpha Chars In Password</em>' attribute.
	 * @see #getMinAlphaCharsInPassword()
	 * @generated
	 */
	void setMinAlphaCharsInPassword(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Diff Chars</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Min Diff Chars</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Diff Chars</em>' attribute.
	 * @see #setMinDiffChars(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MinDiffChars()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MinDiffChars'"
	 * @generated
	 */
	BigInteger getMinDiffChars();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinDiffChars <em>Min Diff Chars</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Diff Chars</em>' attribute.
	 * @see #getMinDiffChars()
	 * @generated
	 */
	void setMinDiffChars(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Other Chars In Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Other Chars In Password</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Other Chars In Password</em>' attribute.
	 * @see #setMinOtherCharsInPassword(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MinOtherCharsInPassword()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MinOtherCharsInPassword'"
	 * @generated
	 */
	BigInteger getMinOtherCharsInPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinOtherCharsInPassword <em>Min Other Chars In Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Other Chars In Password</em>' attribute.
	 * @see #getMinOtherCharsInPassword()
	 * @generated
	 */
	void setMinOtherCharsInPassword(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Password Age In Weeks</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Password Age In Weeks</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Password Age In Weeks</em>' attribute.
	 * @see #setMinPasswordAgeInWeeks(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MinPasswordAgeInWeeks()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MinPasswordAgeInWeeks'"
	 * @generated
	 */
	BigInteger getMinPasswordAgeInWeeks();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordAgeInWeeks <em>Min Password Age In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Password Age In Weeks</em>' attribute.
	 * @see #getMinPasswordAgeInWeeks()
	 * @generated
	 */
	void setMinPasswordAgeInWeeks(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Password Length</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Password Length</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Password Length</em>' attribute.
	 * @see #setMinPasswordLength(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_MinPasswordLength()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='MinPasswordLength'"
	 * @generated
	 */
	BigInteger getMinPasswordLength();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordLength <em>Min Password Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Password Length</em>' attribute.
	 * @see #getMinPasswordLength()
	 * @generated
	 */
	void setMinPasswordLength(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Not Reusable Number Of Passwords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Reusable Number Of Passwords</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Reusable Number Of Passwords</em>' attribute.
	 * @see #setNotReusableNumberOfPasswords(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_NotReusableNumberOfPasswords()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='NotReusableNumberOfPasswords'"
	 * @generated
	 */
	BigInteger getNotReusableNumberOfPasswords();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getNotReusableNumberOfPasswords <em>Not Reusable Number Of Passwords</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Reusable Number Of Passwords</em>' attribute.
	 * @see #getNotReusableNumberOfPasswords()
	 * @generated
	 */
	void setNotReusableNumberOfPasswords(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Pass Reuse Not Allowed In Weeks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pass Reuse Not Allowed In Weeks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass Reuse Not Allowed In Weeks</em>' attribute.
	 * @see #setPassReuseNotAllowedInWeeks(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_PassReuseNotAllowedInWeeks()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='PassReuseNotAllowedInWeeks'"
	 * @generated
	 */
	BigInteger getPassReuseNotAllowedInWeeks();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPassReuseNotAllowedInWeeks <em>Pass Reuse Not Allowed In Weeks</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass Reuse Not Allowed In Weeks</em>' attribute.
	 * @see #getPassReuseNotAllowedInWeeks()
	 * @generated
	 */
	void setPassReuseNotAllowedInWeeks(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Password Change Warn Time</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Change Warn Time</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Password Change Warn Time</em>' attribute.
	 * @see #setPasswordChangeWarnTime(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_PasswordChangeWarnTime()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='PasswordChangeWarnTime'"
	 * @generated
	 */
	BigInteger getPasswordChangeWarnTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPasswordChangeWarnTime <em>Password Change Warn Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Change Warn Time</em>' attribute.
	 * @see #getPasswordChangeWarnTime()
	 * @generated
	 */
	void setPasswordChangeWarnTime(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Password Never Expires</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Never Expires</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Password Never Expires</em>' attribute.
	 * @see #isSetPasswordNeverExpires()
	 * @see #unsetPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_PasswordNeverExpires()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='PasswordNeverExpires'"
	 * @generated
	 */
	boolean isPasswordNeverExpires();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Never Expires</em>' attribute.
	 * @see #isSetPasswordNeverExpires()
	 * @see #unsetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @generated
	 */
	void setPasswordNeverExpires(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @generated
	 */
	void unsetPasswordNeverExpires();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Password Never Expires</em>' attribute is set.
	 * @see #unsetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @generated
	 */
	boolean isSetPasswordNeverExpires();

	/**
	 * Returns the value of the '<em><b>Primary Auth Method</b></em>' attribute.
	 * The default value is <code>"SYSTEM"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.AIXAuthMethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Auth Method</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Auth Method</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @see #isSetPrimaryAuthMethod()
	 * @see #unsetPrimaryAuthMethod()
	 * @see #setPrimaryAuthMethod(AIXAuthMethodType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_PrimaryAuthMethod()
	 * @model default="SYSTEM" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='PrimaryAuthMethod'"
	 * @generated
	 */
	AIXAuthMethodType getPrimaryAuthMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPrimaryAuthMethod <em>Primary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Auth Method</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @see #isSetPrimaryAuthMethod()
	 * @see #unsetPrimaryAuthMethod()
	 * @see #getPrimaryAuthMethod()
	 * @generated
	 */
	void setPrimaryAuthMethod(AIXAuthMethodType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPrimaryAuthMethod <em>Primary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPrimaryAuthMethod()
	 * @see #getPrimaryAuthMethod()
	 * @see #setPrimaryAuthMethod(AIXAuthMethodType)
	 * @generated
	 */
	void unsetPrimaryAuthMethod();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPrimaryAuthMethod <em>Primary Auth Method</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Primary Auth Method</em>' attribute is set.
	 * @see #unsetPrimaryAuthMethod()
	 * @see #getPrimaryAuthMethod()
	 * @see #setPrimaryAuthMethod(AIXAuthMethodType)
	 * @generated
	 */
	boolean isSetPrimaryAuthMethod();

	/**
	 * Returns the value of the '<em><b>Remote Login Is Allowed</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Login Is Allowed</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Remote Login Is Allowed</em>' attribute.
	 * @see #isSetRemoteLoginIsAllowed()
	 * @see #unsetRemoteLoginIsAllowed()
	 * @see #setRemoteLoginIsAllowed(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_RemoteLoginIsAllowed()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='RemoteLoginIsAllowed'"
	 * @generated
	 */
	boolean isRemoteLoginIsAllowed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isRemoteLoginIsAllowed <em>Remote Login Is Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Login Is Allowed</em>' attribute.
	 * @see #isSetRemoteLoginIsAllowed()
	 * @see #unsetRemoteLoginIsAllowed()
	 * @see #isRemoteLoginIsAllowed()
	 * @generated
	 */
	void setRemoteLoginIsAllowed(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isRemoteLoginIsAllowed <em>Remote Login Is Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetRemoteLoginIsAllowed()
	 * @see #isRemoteLoginIsAllowed()
	 * @see #setRemoteLoginIsAllowed(boolean)
	 * @generated
	 */
	void unsetRemoteLoginIsAllowed();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isRemoteLoginIsAllowed <em>Remote Login Is Allowed</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remote Login Is Allowed</em>' attribute is set.
	 * @see #unsetRemoteLoginIsAllowed()
	 * @see #isRemoteLoginIsAllowed()
	 * @see #setRemoteLoginIsAllowed(boolean)
	 * @generated
	 */
	boolean isSetRemoteLoginIsAllowed();

	/**
	 * Returns the value of the '<em><b>Secondary Auth Method</b></em>' attribute.
	 * The default value is <code>"SYSTEM"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.AIXAuthMethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Auth Method</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Auth Method</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @see #isSetSecondaryAuthMethod()
	 * @see #unsetSecondaryAuthMethod()
	 * @see #setSecondaryAuthMethod(AIXAuthMethodType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_SecondaryAuthMethod()
	 * @model default="SYSTEM" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='SecondaryAuthMethod'"
	 * @generated
	 */
	AIXAuthMethodType getSecondaryAuthMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSecondaryAuthMethod <em>Secondary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary Auth Method</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @see #isSetSecondaryAuthMethod()
	 * @see #unsetSecondaryAuthMethod()
	 * @see #getSecondaryAuthMethod()
	 * @generated
	 */
	void setSecondaryAuthMethod(AIXAuthMethodType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSecondaryAuthMethod <em>Secondary Auth Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetSecondaryAuthMethod()
	 * @see #getSecondaryAuthMethod()
	 * @see #setSecondaryAuthMethod(AIXAuthMethodType)
	 * @generated
	 */
	void unsetSecondaryAuthMethod();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSecondaryAuthMethod <em>Secondary Auth Method</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Secondary Auth Method</em>' attribute is set.
	 * @see #unsetSecondaryAuthMethod()
	 * @see #getSecondaryAuthMethod()
	 * @see #setSecondaryAuthMethod(AIXAuthMethodType)
	 * @generated
	 */
	boolean isSetSecondaryAuthMethod();

	/**
	 * Returns the value of the '<em><b>Shell</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shell</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shell</em>' attribute.
	 * @see #setShell(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_Shell()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Shell'"
	 * @generated
	 */
	String getShell();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getShell <em>Shell</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shell</em>' attribute.
	 * @see #getShell()
	 * @generated
	 */
	void setShell(String value);

	/**
	 * Returns the value of the '<em><b>Su Groups Allowed</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Su Groups Allowed</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Su Groups Allowed</em>' attribute.
	 * @see #setSuGroupsAllowed(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_SuGroupsAllowed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SuGroupsAllowed'"
	 * @generated
	 */
	String getSuGroupsAllowed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSuGroupsAllowed <em>Su Groups Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Su Groups Allowed</em>' attribute.
	 * @see #getSuGroupsAllowed()
	 * @generated
	 */
	void setSuGroupsAllowed(String value);

	/**
	 * Returns the value of the '<em><b>Su Is Allowed</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Su Is Allowed</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Su Is Allowed</em>' attribute.
	 * @see #isSetSuIsAllowed()
	 * @see #unsetSuIsAllowed()
	 * @see #setSuIsAllowed(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_SuIsAllowed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='SuIsAllowed'"
	 * @generated
	 */
	boolean isSuIsAllowed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isSuIsAllowed <em>Su Is Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Su Is Allowed</em>' attribute.
	 * @see #isSetSuIsAllowed()
	 * @see #unsetSuIsAllowed()
	 * @see #isSuIsAllowed()
	 * @generated
	 */
	void setSuIsAllowed(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isSuIsAllowed <em>Su Is Allowed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetSuIsAllowed()
	 * @see #isSuIsAllowed()
	 * @see #setSuIsAllowed(boolean)
	 * @generated
	 */
	void unsetSuIsAllowed();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isSuIsAllowed <em>Su Is Allowed</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Su Is Allowed</em>' attribute is set.
	 * @see #unsetSuIsAllowed()
	 * @see #isSuIsAllowed()
	 * @see #setSuIsAllowed(boolean)
	 * @generated
	 */
	boolean isSetSuIsAllowed();

	/**
	 * Returns the value of the '<em><b>Time Last Login</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Time Last Login</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Last Login</em>' attribute.
	 * @see #setTimeLastLogin(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_TimeLastLogin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TimeLastLogin'"
	 * @generated
	 */
	String getTimeLastLogin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getTimeLastLogin <em>Time Last Login</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Last Login</em>' attribute.
	 * @see #getTimeLastLogin()
	 * @generated
	 */
	void setTimeLastLogin(String value);

	/**
	 * Returns the value of the '<em><b>User Cannot Change Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Cannot Change Password</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>User Cannot Change Password</em>' attribute.
	 * @see #isSetUserCannotChangePassword()
	 * @see #unsetUserCannotChangePassword()
	 * @see #setUserCannotChangePassword(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_UserCannotChangePassword()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='UserCannotChangePassword'"
	 * @generated
	 */
	boolean isUserCannotChangePassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Cannot Change Password</em>' attribute.
	 * @see #isSetUserCannotChangePassword()
	 * @see #unsetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @generated
	 */
	void setUserCannotChangePassword(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @see #setUserCannotChangePassword(boolean)
	 * @generated
	 */
	void unsetUserCannotChangePassword();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Cannot Change Password</em>' attribute is set.
	 * @see #unsetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @see #setUserCannotChangePassword(boolean)
	 * @generated
	 */
	boolean isSetUserCannotChangePassword();

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_UserName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserName'"
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>User Registering Method</b></em>' attribute.
	 * The default value is <code>"files"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Registering Method</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Registering Method</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
	 * @see #isSetUserRegisteringMethod()
	 * @see #unsetUserRegisteringMethod()
	 * @see #setUserRegisteringMethod(AIXUserRegisteringMethodType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_UserRegisteringMethod()
	 * @model default="files" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='UserRegisteringMethod'"
	 * @generated
	 */
	AIXUserRegisteringMethodType getUserRegisteringMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserRegisteringMethod <em>User Registering Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Registering Method</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
	 * @see #isSetUserRegisteringMethod()
	 * @see #unsetUserRegisteringMethod()
	 * @see #getUserRegisteringMethod()
	 * @generated
	 */
	void setUserRegisteringMethod(AIXUserRegisteringMethodType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserRegisteringMethod <em>User Registering Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUserRegisteringMethod()
	 * @see #getUserRegisteringMethod()
	 * @see #setUserRegisteringMethod(AIXUserRegisteringMethodType)
	 * @generated
	 */
	void unsetUserRegisteringMethod();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserRegisteringMethod <em>User Registering Method</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Registering Method</em>' attribute is set.
	 * @see #unsetUserRegisteringMethod()
	 * @see #getUserRegisteringMethod()
	 * @see #setUserRegisteringMethod(AIXUserRegisteringMethodType)
	 * @generated
	 */
	boolean isSetUserRegisteringMethod();

	/**
	 * Returns the value of the '<em><b>User Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Sid</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Sid</em>' attribute.
	 * @see #setUserSid(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_UserSid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserSid'"
	 * @generated
	 */
	String getUserSid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserSid <em>User Sid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Sid</em>' attribute.
	 * @see #getUserSid()
	 * @generated
	 */
	void setUserSid(String value);

	/**
	 * Returns the value of the '<em><b>Usuccessful Login Count</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usuccessful Login Count</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Usuccessful Login Count</em>' attribute.
	 * @see #setUsuccessfulLoginCount(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalUser_UsuccessfulLoginCount()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='UsuccessfulLoginCount'"
	 * @generated
	 */
	BigInteger getUsuccessfulLoginCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUsuccessfulLoginCount <em>Usuccessful Login Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usuccessful Login Count</em>' attribute.
	 * @see #getUsuccessfulLoginCount()
	 * @generated
	 */
	void setUsuccessfulLoginCount(BigInteger value);

} // AIXLocalUser
