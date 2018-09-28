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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Linux Local User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getAccountDescription <em>Account Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isAccountDisabled <em>Account Disabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getFullName <em>Full Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getHomeDir <em>Home Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getShell <em>Shell</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getUserName <em>User Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser()
 * @model extendedMetaData="name='LinuxLocalUser' kind='elementOnly'"
 * @generated
 */
public interface LinuxLocalUser extends User {
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_AccountDescription()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountDescription'"
	 * @generated
	 */
	String getAccountDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getAccountDescription <em>Account Description</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_AccountDisabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='AccountDisabled'"
	 * @generated
	 */
	boolean isAccountDisabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Disabled</em>' attribute.
	 * @see #isSetAccountDisabled()
	 * @see #unsetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @generated
	 */
	void setAccountDisabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @generated
	 */
	void unsetAccountDisabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isAccountDisabled <em>Account Disabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Account Disabled</em>' attribute is set.
	 * @see #unsetAccountDisabled()
	 * @see #isAccountDisabled()
	 * @see #setAccountDisabled(boolean)
	 * @generated
	 */
	boolean isSetAccountDisabled();

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_ChangePasswordNextLogon()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='ChangePasswordNextLogon'"
	 * @generated
	 */
	boolean isChangePasswordNextLogon();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Password Next Logon</em>' attribute.
	 * @see #isSetChangePasswordNextLogon()
	 * @see #unsetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @generated
	 */
	void setChangePasswordNextLogon(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetChangePasswordNextLogon()
	 * @see #isChangePasswordNextLogon()
	 * @see #setChangePasswordNextLogon(boolean)
	 * @generated
	 */
	void unsetChangePasswordNextLogon();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}' attribute is set.
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_FullName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FullName'"
	 * @generated
	 */
	String getFullName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getFullName <em>Full Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_HomeDir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='HomeDir'"
	 * @generated
	 */
	String getHomeDir();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getHomeDir <em>Home Dir</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Dir</em>' attribute.
	 * @see #getHomeDir()
	 * @generated
	 */
	void setHomeDir(String value);

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_PasswordNeverExpires()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='PasswordNeverExpires'"
	 * @generated
	 */
	boolean isPasswordNeverExpires();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Never Expires</em>' attribute.
	 * @see #isSetPasswordNeverExpires()
	 * @see #unsetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @generated
	 */
	void setPasswordNeverExpires(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @generated
	 */
	void unsetPasswordNeverExpires();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Password Never Expires</em>' attribute is set.
	 * @see #unsetPasswordNeverExpires()
	 * @see #isPasswordNeverExpires()
	 * @see #setPasswordNeverExpires(boolean)
	 * @generated
	 */
	boolean isSetPasswordNeverExpires();

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_Shell()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Shell'"
	 * @generated
	 */
	String getShell();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getShell <em>Shell</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shell</em>' attribute.
	 * @see #getShell()
	 * @generated
	 */
	void setShell(String value);

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_UserCannotChangePassword()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='UserCannotChangePassword'"
	 * @generated
	 */
	boolean isUserCannotChangePassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Cannot Change Password</em>' attribute.
	 * @see #isSetUserCannotChangePassword()
	 * @see #unsetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @generated
	 */
	void setUserCannotChangePassword(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUserCannotChangePassword()
	 * @see #isUserCannotChangePassword()
	 * @see #setUserCannotChangePassword(boolean)
	 * @generated
	 */
	void unsetUserCannotChangePassword();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}' attribute is set.
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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxLocalUser_UserName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserName'"
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

} // LinuxLocalUser
