/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windows Local User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getAccountDescription <em>Account Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountDisabled <em>Account Disabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountLocked <em>Account Locked</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isEnableRemoteControl <em>Enable Remote Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getFullName <em>Full Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getHomeFolder <em>Home Folder</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getLogonScript <em>Logon Script</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getProfilePath <em>Profile Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserAccountType <em>User Account Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSid <em>User Sid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSidType <em>User Sid Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser()
 * @model extendedMetaData="name='WindowsLocalUser' kind='elementOnly'"
 * @generated
 */
public interface WindowsLocalUser extends User {
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_AccountDescription()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountDescription'"
	 * @generated
	 */
	String getAccountDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getAccountDescription <em>Account Description</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_AccountDisabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='AccountDisabled'"
	 * @generated
	 */
	boolean isAccountDisabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Disabled</em>' attribute.
	 * @see #isSetAccountDisabled()
	 * @see #unsetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @generated
	 */
	void setAccountDisabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @generated
	 */
	void unsetAccountDisabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Account Disabled</em>' attribute is set.
	 * @see #unsetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @generated
	 */
	boolean isSetAccountDisabled();

	/**
	 * Returns the value of the '<em><b>Account Locked</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Account Locked</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account Locked</em>' attribute.
	 * @see #isSetAccountLocked()
	 * @see #unsetAccountLocked()
	 * @see #setAccountLocked(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_AccountLocked()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='AccountLocked'"
	 * @generated
	 */
	boolean isAccountLocked();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountLocked <em>Account Locked</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Locked</em>' attribute.
	 * @see #isSetAccountLocked()
	 * @see #unsetAccountLocked()
	 * @see #isAccountLocked()
	 * @generated
	 */
	void setAccountLocked(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountLocked <em>Account Locked</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAccountLocked()
	 * @see #isAccountLocked()
	 * @see #setAccountLocked(boolean)
	 * @generated
	 */
	void unsetAccountLocked();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountLocked <em>Account Locked</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Account Locked</em>' attribute is set.
	 * @see #unsetAccountLocked()
	 * @see #isAccountLocked()
	 * @see #setAccountLocked(boolean)
	 * @generated
	 */
	boolean isSetAccountLocked();

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_ChangePasswordNextLogon()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='ChangePasswordNextLogon'"
	 * @generated
	 */
	boolean isChangePasswordNextLogon();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Password Next Logon</em>' attribute.
	 * @see #isSetChangePasswordNextLogon()
	 * @see #unsetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @generated
	 */
	void setChangePasswordNextLogon(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @see #setChangePasswordNextLogon(boolean)
	 * @generated
	 */
	void unsetChangePasswordNextLogon();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Change Password Next Logon</em>' attribute is set.
	 * @see #unsetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @see #setChangePasswordNextLogon(boolean)
	 * @generated
	 */
	boolean isSetChangePasswordNextLogon();

	/**
	 * Returns the value of the '<em><b>Enable Remote Control</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Remote Control</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enable Remote Control</em>' attribute.
	 * @see #isSetEnableRemoteControl()
	 * @see #unsetEnableRemoteControl()
	 * @see #setEnableRemoteControl(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_EnableRemoteControl()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='EnableRemoteControl'"
	 * @generated
	 */
	boolean isEnableRemoteControl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isEnableRemoteControl <em>Enable Remote Control</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Remote Control</em>' attribute.
	 * @see #isSetEnableRemoteControl()
	 * @see #unsetEnableRemoteControl()
	 * @see #isEnableRemoteControl()
	 * @generated
	 */
	void setEnableRemoteControl(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isEnableRemoteControl <em>Enable Remote Control</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEnableRemoteControl()
	 * @see #isEnableRemoteControl()
	 * @see #setEnableRemoteControl(boolean)
	 * @generated
	 */
	void unsetEnableRemoteControl();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isEnableRemoteControl <em>Enable Remote Control</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enable Remote Control</em>' attribute is set.
	 * @see #unsetEnableRemoteControl()
	 * @see #isEnableRemoteControl()
	 * @see #setEnableRemoteControl(boolean)
	 * @generated
	 */
	boolean isSetEnableRemoteControl();

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_FullName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FullName'"
	 * @generated
	 */
	String getFullName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getFullName <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Name</em>' attribute.
	 * @see #getFullName()
	 * @generated
	 */
	void setFullName(String value);

	/**
	 * Returns the value of the '<em><b>Home Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home Folder</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Folder</em>' attribute.
	 * @see #setHomeFolder(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_HomeFolder()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='HomeFolder'"
	 * @generated
	 */
	String getHomeFolder();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getHomeFolder <em>Home Folder</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Folder</em>' attribute.
	 * @see #getHomeFolder()
	 * @generated
	 */
	void setHomeFolder(String value);

	/**
	 * Returns the value of the '<em><b>Logon Script</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Logon Script</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logon Script</em>' attribute.
	 * @see #setLogonScript(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_LogonScript()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogonScript'"
	 * @generated
	 */
	String getLogonScript();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getLogonScript <em>Logon Script</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logon Script</em>' attribute.
	 * @see #getLogonScript()
	 * @generated
	 */
	void setLogonScript(String value);

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_PasswordNeverExpires()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='PasswordNeverExpires'"
	 * @generated
	 */
	boolean isPasswordNeverExpires();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Never Expires</em>' attribute.
	 * @see #isSetPasswordNeverExpires()
	 * @see #unsetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @generated
	 */
	void setPasswordNeverExpires(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @generated
	 */
	void unsetPasswordNeverExpires();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Password Never Expires</em>' attribute is set.
	 * @see #unsetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @generated
	 */
	boolean isSetPasswordNeverExpires();

	/**
	 * Returns the value of the '<em><b>Profile Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Profile Path</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Path</em>' attribute.
	 * @see #setProfilePath(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_ProfilePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProfilePath'"
	 * @generated
	 */
	String getProfilePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getProfilePath <em>Profile Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Path</em>' attribute.
	 * @see #getProfilePath()
	 * @generated
	 */
	void setProfilePath(String value);

	/**
	 * Returns the value of the '<em><b>User Account Type</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Account Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>User Account Type</em>' attribute.
	 * @see #setUserAccountType(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_UserAccountType()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserAccountType'"
	 * @generated
	 */
	String getUserAccountType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserAccountType <em>User Account Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Account Type</em>' attribute.
	 * @see #getUserAccountType()
	 * @generated
	 */
	void setUserAccountType(String value);

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_UserCannotChangePassword()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='UserCannotChangePassword'"
	 * @generated
	 */
	boolean isUserCannotChangePassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Cannot Change Password</em>' attribute.
	 * @see #isSetUserCannotChangePassword()
	 * @see #unsetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @generated
	 */
	void setUserCannotChangePassword(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @see #setUserCannotChangePassword(boolean)
	 * @generated
	 */
	void unsetUserCannotChangePassword();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Cannot Change Password</em>' attribute is set.
	 * @see #unsetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @see #setUserCannotChangePassword(boolean)
	 * @generated
	 */
	boolean isSetUserCannotChangePassword();

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_UserSid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserSid'"
	 * @generated
	 */
	String getUserSid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSid <em>User Sid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Sid</em>' attribute.
	 * @see #getUserSid()
	 * @generated
	 */
	void setUserSid(String value);

	/**
	 * Returns the value of the '<em><b>User Sid Type</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>User Sid Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Sid Type</em>' attribute.
	 * @see #setUserSidType(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalUser_UserSidType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserSidType'"
	 * @generated
	 */
	String getUserSidType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSidType <em>User Sid Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Sid Type</em>' attribute.
	 * @see #getUserSidType()
	 * @generated
	 */
	void setUserSidType(String value);

} // WindowsLocalUser
