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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windows Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getCompany <em>Company</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainAdmin <em>Domain Admin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainName <em>Domain Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainPassword <em>Domain Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getEncryptionLevel <em>Encryption Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguage <em>Language</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguageGroup <em>Language Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getMachineObjectOU <em>Machine Object OU</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getNumberOfLicensedUsers <em>Number Of Licensed Users</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductKey <em>Product Key</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductType <em>Product Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getSystemDrive <em>System Drive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWindowsDirectory <em>Windows Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWorkgroupName <em>Workgroup Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem()
 * @model extendedMetaData="name='WindowsOperatingSystem' kind='elementOnly'"
 * @generated
 */
public interface WindowsOperatingSystem extends OperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Company</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company</em>' attribute.
	 * @see #setCompany(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_Company()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Company'"
	 * @generated
	 */
	String getCompany();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getCompany <em>Company</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company</em>' attribute.
	 * @see #getCompany()
	 * @generated
	 */
	void setCompany(String value);

	/**
	 * Returns the value of the '<em><b>Domain Admin</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Domain Admin</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Admin</em>' attribute.
	 * @see #setDomainAdmin(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_DomainAdmin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DomainAdmin'"
	 * @generated
	 */
	String getDomainAdmin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainAdmin <em>Domain Admin</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Admin</em>' attribute.
	 * @see #getDomainAdmin()
	 * @generated
	 */
	void setDomainAdmin(String value);

	/**
	 * Returns the value of the '<em><b>Domain Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Name</em>' attribute.
	 * @see #setDomainName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_DomainName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DomainName'"
	 * @generated
	 */
	String getDomainName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainName <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Name</em>' attribute.
	 * @see #getDomainName()
	 * @generated
	 */
	void setDomainName(String value);

	/**
	 * Returns the value of the '<em><b>Domain Password</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Domain Password</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Password</em>' attribute.
	 * @see #setDomainPassword(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_DomainPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DomainPassword'"
	 * @generated
	 */
	String getDomainPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainPassword <em>Domain Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Password</em>' attribute.
	 * @see #getDomainPassword()
	 * @generated
	 */
	void setDomainPassword(String value);

	/**
	 * Returns the value of the '<em><b>Encryption Level</b></em>' attribute.
	 * The default value is <code>"40"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.EncryptionLevelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encryption Level</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encryption Level</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
	 * @see #isSetEncryptionLevel()
	 * @see #unsetEncryptionLevel()
	 * @see #setEncryptionLevel(EncryptionLevelType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_EncryptionLevel()
	 * @model default="40" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='EncryptionLevel'"
	 * @generated
	 */
	EncryptionLevelType getEncryptionLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getEncryptionLevel <em>Encryption Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encryption Level</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
	 * @see #isSetEncryptionLevel()
	 * @see #unsetEncryptionLevel()
	 * @see #getEncryptionLevel()
	 * @generated
	 */
	void setEncryptionLevel(EncryptionLevelType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getEncryptionLevel <em>Encryption Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEncryptionLevel()
	 * @see #getEncryptionLevel()
	 * @see #setEncryptionLevel(EncryptionLevelType)
	 * @generated
	 */
	void unsetEncryptionLevel();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getEncryptionLevel <em>Encryption Level</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Encryption Level</em>' attribute is set.
	 * @see #unsetEncryptionLevel()
	 * @see #getEncryptionLevel()
	 * @see #setEncryptionLevel(EncryptionLevelType)
	 * @generated
	 */
	boolean isSetEncryptionLevel();

	/**
	 * Returns the value of the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Install Date</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install Date</em>' attribute.
	 * @see #setInstallDate(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_InstallDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstallDate'"
	 * @generated
	 */
	String getInstallDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getInstallDate <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Date</em>' attribute.
	 * @see #getInstallDate()
	 * @generated
	 */
	void setInstallDate(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_Language()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Language'"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Language Group</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Language Group</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Group</em>' attribute.
	 * @see #setLanguageGroup(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_LanguageGroup()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LanguageGroup'"
	 * @generated
	 */
	String getLanguageGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguageGroup <em>Language Group</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Group</em>' attribute.
	 * @see #getLanguageGroup()
	 * @generated
	 */
	void setLanguageGroup(String value);

	/**
	 * Returns the value of the '<em><b>Last Boot Up Time</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Boot Up Time</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Boot Up Time</em>' attribute.
	 * @see #setLastBootUpTime(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_LastBootUpTime()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LastBootUpTime'"
	 * @generated
	 */
	String getLastBootUpTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Boot Up Time</em>' attribute.
	 * @see #getLastBootUpTime()
	 * @generated
	 */
	void setLastBootUpTime(String value);

	/**
	 * Returns the value of the '<em><b>Machine Object OU</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Object OU</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Machine Object OU</em>' attribute.
	 * @see #setMachineObjectOU(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_MachineObjectOU()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MachineObjectOU'"
	 * @generated
	 */
	String getMachineObjectOU();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getMachineObjectOU <em>Machine Object OU</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Object OU</em>' attribute.
	 * @see #getMachineObjectOU()
	 * @generated
	 */
	void setMachineObjectOU(String value);

	/**
	 * Returns the value of the '<em><b>Number Of Licensed Users</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Licensed Users</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Number Of Licensed Users</em>' attribute.
	 * @see #setNumberOfLicensedUsers(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_NumberOfLicensedUsers()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NumberOfLicensedUsers'"
	 * @generated
	 */
	String getNumberOfLicensedUsers();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getNumberOfLicensedUsers <em>Number Of Licensed Users</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Licensed Users</em>' attribute.
	 * @see #getNumberOfLicensedUsers()
	 * @generated
	 */
	void setNumberOfLicensedUsers(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_Owner()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Owner'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Product Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Key</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Key</em>' attribute.
	 * @see #setProductKey(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_ProductKey()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProductKey'"
	 * @generated
	 */
	String getProductKey();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductKey <em>Product Key</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Key</em>' attribute.
	 * @see #getProductKey()
	 * @generated
	 */
	void setProductKey(String value);

	/**
	 * Returns the value of the '<em><b>Product Type</b></em>' attribute.
	 * The default value is <code>"Work Station"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.WindowsProductTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
	 * @see #isSetProductType()
	 * @see #unsetProductType()
	 * @see #setProductType(WindowsProductTypeType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_ProductType()
	 * @model default="Work Station" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ProductType'"
	 * @generated
	 */
	WindowsProductTypeType getProductType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductType <em>Product Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
	 * @see #isSetProductType()
	 * @see #unsetProductType()
	 * @see #getProductType()
	 * @generated
	 */
	void setProductType(WindowsProductTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductType <em>Product Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetProductType()
	 * @see #getProductType()
	 * @see #setProductType(WindowsProductTypeType)
	 * @generated
	 */
	void unsetProductType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductType <em>Product Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Product Type</em>' attribute is set.
	 * @see #unsetProductType()
	 * @see #getProductType()
	 * @see #setProductType(WindowsProductTypeType)
	 * @generated
	 */
	boolean isSetProductType();

	/**
	 * Returns the value of the '<em><b>System Drive</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>System Drive</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Drive</em>' attribute.
	 * @see #setSystemDrive(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_SystemDrive()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SystemDrive'"
	 * @generated
	 */
	String getSystemDrive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getSystemDrive <em>System Drive</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Drive</em>' attribute.
	 * @see #getSystemDrive()
	 * @generated
	 */
	void setSystemDrive(String value);

	/**
	 * Returns the value of the '<em><b>Windows Directory</b></em>' attribute.
	 * The default value is <code>"WINDOWS"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.WindowsDirectoryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Windows Directory</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Windows Directory</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
	 * @see #isSetWindowsDirectory()
	 * @see #unsetWindowsDirectory()
	 * @see #setWindowsDirectory(WindowsDirectoryType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_WindowsDirectory()
	 * @model default="WINDOWS" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='WindowsDirectory'"
	 * @generated
	 */
	WindowsDirectoryType getWindowsDirectory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWindowsDirectory <em>Windows Directory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Windows Directory</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
	 * @see #isSetWindowsDirectory()
	 * @see #unsetWindowsDirectory()
	 * @see #getWindowsDirectory()
	 * @generated
	 */
	void setWindowsDirectory(WindowsDirectoryType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWindowsDirectory <em>Windows Directory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetWindowsDirectory()
	 * @see #getWindowsDirectory()
	 * @see #setWindowsDirectory(WindowsDirectoryType)
	 * @generated
	 */
	void unsetWindowsDirectory();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWindowsDirectory <em>Windows Directory</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Windows Directory</em>' attribute is set.
	 * @see #unsetWindowsDirectory()
	 * @see #getWindowsDirectory()
	 * @see #setWindowsDirectory(WindowsDirectoryType)
	 * @generated
	 */
	boolean isSetWindowsDirectory();

	/**
	 * Returns the value of the '<em><b>Workgroup Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Workgroup Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Name</em>' attribute.
	 * @see #setWorkgroupName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsOperatingSystem_WorkgroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='WorkgroupName'"
	 * @generated
	 */
	String getWorkgroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWorkgroupName <em>Workgroup Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Name</em>' attribute.
	 * @see #getWorkgroupName()
	 * @generated
	 */
	void setWorkgroupName(String value);

} // WindowsOperatingSystem
