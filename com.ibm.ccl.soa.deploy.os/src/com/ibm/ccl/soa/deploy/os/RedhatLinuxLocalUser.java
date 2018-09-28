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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Redhat Linux Local User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableAfterDays <em>Account Disable After Days</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableDate <em>Account Disable Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getDaysBeforePasswordMayChange <em>Days Before Password May Change</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getLastPasswordChange <em>Last Password Change</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireAfterDays <em>Password Expire After Days</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireWarningDays <em>Password Expire Warning Days</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getUserSid <em>User Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser()
 * @model extendedMetaData="name='RedhatLinuxLocalUser' kind='elementOnly'"
 * @generated
 */
public interface RedhatLinuxLocalUser extends LinuxLocalUser {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Account Disable After Days</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Disable After Days</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Account Disable After Days</em>' attribute.
	 * @see #setAccountDisableAfterDays(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_AccountDisableAfterDays()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountDisableAfterDays'"
	 * @generated
	 */
	String getAccountDisableAfterDays();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableAfterDays <em>Account Disable After Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Disable After Days</em>' attribute.
	 * @see #getAccountDisableAfterDays()
	 * @generated
	 */
	void setAccountDisableAfterDays(String value);

	/**
	 * Returns the value of the '<em><b>Account Disable Date</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Disable Date</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Account Disable Date</em>' attribute.
	 * @see #setAccountDisableDate(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_AccountDisableDate()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountDisableDate'"
	 * @generated
	 */
	String getAccountDisableDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableDate <em>Account Disable Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Disable Date</em>' attribute.
	 * @see #getAccountDisableDate()
	 * @generated
	 */
	void setAccountDisableDate(String value);

	/**
	 * Returns the value of the '<em><b>Days Before Password May Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days Before Password May Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days Before Password May Change</em>' attribute.
	 * @see #setDaysBeforePasswordMayChange(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_DaysBeforePasswordMayChange()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DaysBeforePasswordMayChange'"
	 * @generated
	 */
	String getDaysBeforePasswordMayChange();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getDaysBeforePasswordMayChange <em>Days Before Password May Change</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Days Before Password May Change</em>' attribute.
	 * @see #getDaysBeforePasswordMayChange()
	 * @generated
	 */
	void setDaysBeforePasswordMayChange(String value);

	/**
	 * Returns the value of the '<em><b>Last Password Change</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Password Change</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Password Change</em>' attribute.
	 * @see #setLastPasswordChange(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_LastPasswordChange()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LastPasswordChange'"
	 * @generated
	 */
	String getLastPasswordChange();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getLastPasswordChange <em>Last Password Change</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Password Change</em>' attribute.
	 * @see #getLastPasswordChange()
	 * @generated
	 */
	void setLastPasswordChange(String value);

	/**
	 * Returns the value of the '<em><b>Password Expire After Days</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Expire After Days</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Password Expire After Days</em>' attribute.
	 * @see #setPasswordExpireAfterDays(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_PasswordExpireAfterDays()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PasswordExpireAfterDays'"
	 * @generated
	 */
	String getPasswordExpireAfterDays();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireAfterDays <em>Password Expire After Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Expire After Days</em>' attribute.
	 * @see #getPasswordExpireAfterDays()
	 * @generated
	 */
	void setPasswordExpireAfterDays(String value);

	/**
	 * Returns the value of the '<em><b>Password Expire Warning Days</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Expire Warning Days</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Password Expire Warning Days</em>' attribute.
	 * @see #setPasswordExpireWarningDays(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_PasswordExpireWarningDays()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PasswordExpireWarningDays'"
	 * @generated
	 */
	String getPasswordExpireWarningDays();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireWarningDays <em>Password Expire Warning Days</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Expire Warning Days</em>' attribute.
	 * @see #getPasswordExpireWarningDays()
	 * @generated
	 */
	void setPasswordExpireWarningDays(String value);

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
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxLocalUser_UserSid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserSid'"
	 * @generated
	 */
	String getUserSid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getUserSid <em>User Sid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Sid</em>' attribute.
	 * @see #getUserSid()
	 * @generated
	 */
	void setUserSid(String value);

} // RedhatLinuxLocalUser
