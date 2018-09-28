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

import com.ibm.ccl.soa.deploy.os.EncryptionLevelType;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsDirectoryType;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.WindowsProductTypeType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows Operating System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getDomainAdmin <em>Domain Admin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getDomainName <em>Domain Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getDomainPassword <em>Domain Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getEncryptionLevel <em>Encryption Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getLanguageGroup <em>Language Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getLastBootUpTime <em>Last Boot Up Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getMachineObjectOU <em>Machine Object OU</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getNumberOfLicensedUsers <em>Number Of Licensed Users</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getProductKey <em>Product Key</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getProductType <em>Product Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getSystemDrive <em>System Drive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getWindowsDirectory <em>Windows Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl#getWorkgroupName <em>Workgroup Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsOperatingSystemImpl extends OperatingSystemImpl implements
		WindowsOperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCompany() <em>Company</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPANY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompany() <em>Company</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected String company = COMPANY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainAdmin() <em>Domain Admin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDomainAdmin()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_ADMIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainAdmin() <em>Domain Admin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDomainAdmin()
	 * @generated
	 * @ordered
	 */
	protected String domainAdmin = DOMAIN_ADMIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainName() <em>Domain Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDomainName()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainName() <em>Domain Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDomainName()
	 * @generated
	 * @ordered
	 */
	protected String domainName = DOMAIN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainPassword() <em>Domain Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDomainPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainPassword() <em>Domain Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDomainPassword()
	 * @generated
	 * @ordered
	 */
	protected String domainPassword = DOMAIN_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEncryptionLevel() <em>Encryption Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEncryptionLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EncryptionLevelType ENCRYPTION_LEVEL_EDEFAULT = EncryptionLevelType._40_LITERAL;

	/**
	 * The cached value of the '{@link #getEncryptionLevel() <em>Encryption Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEncryptionLevel()
	 * @generated
	 * @ordered
	 */
	protected EncryptionLevelType encryptionLevel = ENCRYPTION_LEVEL_EDEFAULT;

	/**
	 * This is true if the Encryption Level attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean encryptionLevelESet;

	/**
	 * The default value of the '{@link #getInstallDate() <em>Install Date</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstallDate()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallDate() <em>Install Date</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstallDate()
	 * @generated
	 * @ordered
	 */
	protected String installDate = INSTALL_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguageGroup() <em>Language Group</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguageGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguageGroup() <em>Language Group</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguageGroup()
	 * @generated
	 * @ordered
	 */
	protected String languageGroup = LANGUAGE_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastBootUpTime() <em>Last Boot Up Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastBootUpTime()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_BOOT_UP_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastBootUpTime() <em>Last Boot Up Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastBootUpTime()
	 * @generated
	 * @ordered
	 */
	protected String lastBootUpTime = LAST_BOOT_UP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMachineObjectOU() <em>Machine Object OU</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMachineObjectOU()
	 * @generated
	 * @ordered
	 */
	protected static final String MACHINE_OBJECT_OU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMachineObjectOU() <em>Machine Object OU</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMachineObjectOU()
	 * @generated
	 * @ordered
	 */
	protected String machineObjectOU = MACHINE_OBJECT_OU_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfLicensedUsers() <em>Number Of Licensed Users</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNumberOfLicensedUsers()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_OF_LICENSED_USERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberOfLicensedUsers() <em>Number Of Licensed Users</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNumberOfLicensedUsers()
	 * @generated
	 * @ordered
	 */
	protected String numberOfLicensedUsers = NUMBER_OF_LICENSED_USERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductKey() <em>Product Key</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductKey()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductKey() <em>Product Key</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductKey()
	 * @generated
	 * @ordered
	 */
	protected String productKey = PRODUCT_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductType() <em>Product Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductType()
	 * @generated
	 * @ordered
	 */
	protected static final WindowsProductTypeType PRODUCT_TYPE_EDEFAULT = WindowsProductTypeType.WORK_STATION_LITERAL;

	/**
	 * The cached value of the '{@link #getProductType() <em>Product Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductType()
	 * @generated
	 * @ordered
	 */
	protected WindowsProductTypeType productType = PRODUCT_TYPE_EDEFAULT;

	/**
	 * This is true if the Product Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean productTypeESet;

	/**
	 * The default value of the '{@link #getSystemDrive() <em>System Drive</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSystemDrive()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_DRIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemDrive() <em>System Drive</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSystemDrive()
	 * @generated
	 * @ordered
	 */
	protected String systemDrive = SYSTEM_DRIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWindowsDirectory() <em>Windows Directory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWindowsDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final WindowsDirectoryType WINDOWS_DIRECTORY_EDEFAULT = WindowsDirectoryType.WINDOWS_LITERAL;

	/**
	 * The cached value of the '{@link #getWindowsDirectory() <em>Windows Directory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWindowsDirectory()
	 * @generated
	 * @ordered
	 */
	protected WindowsDirectoryType windowsDirectory = WINDOWS_DIRECTORY_EDEFAULT;

	/**
	 * This is true if the Windows Directory attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean windowsDirectoryESet;

	/**
	 * The default value of the '{@link #getWorkgroupName() <em>Workgroup Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWorkgroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKGROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkgroupName() <em>Workgroup Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWorkgroupName()
	 * @generated
	 * @ordered
	 */
	protected String workgroupName = WORKGROUP_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsOperatingSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.WINDOWS_OPERATING_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompany(String newCompany) {
		String oldCompany = company;
		company = newCompany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__COMPANY, oldCompany, company));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainAdmin() {
		return domainAdmin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainAdmin(String newDomainAdmin) {
		String oldDomainAdmin = domainAdmin;
		domainAdmin = newDomainAdmin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN, oldDomainAdmin, domainAdmin));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainName(String newDomainName) {
		String oldDomainName = domainName;
		domainName = newDomainName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME, oldDomainName, domainName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainPassword() {
		return domainPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainPassword(String newDomainPassword) {
		String oldDomainPassword = domainPassword;
		domainPassword = newDomainPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD, oldDomainPassword,
					domainPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EncryptionLevelType getEncryptionLevel() {
		return encryptionLevel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncryptionLevel(EncryptionLevelType newEncryptionLevel) {
		EncryptionLevelType oldEncryptionLevel = encryptionLevel;
		encryptionLevel = newEncryptionLevel == null ? ENCRYPTION_LEVEL_EDEFAULT : newEncryptionLevel;
		boolean oldEncryptionLevelESet = encryptionLevelESet;
		encryptionLevelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL, oldEncryptionLevel,
					encryptionLevel, !oldEncryptionLevelESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEncryptionLevel() {
		EncryptionLevelType oldEncryptionLevel = encryptionLevel;
		boolean oldEncryptionLevelESet = encryptionLevelESet;
		encryptionLevel = ENCRYPTION_LEVEL_EDEFAULT;
		encryptionLevelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL, oldEncryptionLevel,
					ENCRYPTION_LEVEL_EDEFAULT, oldEncryptionLevelESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEncryptionLevel() {
		return encryptionLevelESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallDate() {
		return installDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallDate(String newInstallDate) {
		String oldInstallDate = installDate;
		installDate = newInstallDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE, oldInstallDate, installDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguageGroup() {
		return languageGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageGroup(String newLanguageGroup) {
		String oldLanguageGroup = languageGroup;
		languageGroup = newLanguageGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP, oldLanguageGroup, languageGroup));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastBootUpTime() {
		return lastBootUpTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastBootUpTime(String newLastBootUpTime) {
		String oldLastBootUpTime = lastBootUpTime;
		lastBootUpTime = newLastBootUpTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME, oldLastBootUpTime,
					lastBootUpTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMachineObjectOU() {
		return machineObjectOU;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachineObjectOU(String newMachineObjectOU) {
		String oldMachineObjectOU = machineObjectOU;
		machineObjectOU = newMachineObjectOU;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU, oldMachineObjectOU,
					machineObjectOU));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberOfLicensedUsers() {
		return numberOfLicensedUsers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfLicensedUsers(String newNumberOfLicensedUsers) {
		String oldNumberOfLicensedUsers = numberOfLicensedUsers;
		numberOfLicensedUsers = newNumberOfLicensedUsers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS,
					oldNumberOfLicensedUsers, numberOfLicensedUsers));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductKey() {
		return productKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductKey(String newProductKey) {
		String oldProductKey = productKey;
		productKey = newProductKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY, oldProductKey, productKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsProductTypeType getProductType() {
		return productType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductType(WindowsProductTypeType newProductType) {
		WindowsProductTypeType oldProductType = productType;
		productType = newProductType == null ? PRODUCT_TYPE_EDEFAULT : newProductType;
		boolean oldProductTypeESet = productTypeESet;
		productTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE, oldProductType, productType,
					!oldProductTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProductType() {
		WindowsProductTypeType oldProductType = productType;
		boolean oldProductTypeESet = productTypeESet;
		productType = PRODUCT_TYPE_EDEFAULT;
		productTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE, oldProductType,
					PRODUCT_TYPE_EDEFAULT, oldProductTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProductType() {
		return productTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemDrive() {
		return systemDrive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemDrive(String newSystemDrive) {
		String oldSystemDrive = systemDrive;
		systemDrive = newSystemDrive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE, oldSystemDrive, systemDrive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDirectoryType getWindowsDirectory() {
		return windowsDirectory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWindowsDirectory(WindowsDirectoryType newWindowsDirectory) {
		WindowsDirectoryType oldWindowsDirectory = windowsDirectory;
		windowsDirectory = newWindowsDirectory == null ? WINDOWS_DIRECTORY_EDEFAULT
				: newWindowsDirectory;
		boolean oldWindowsDirectoryESet = windowsDirectoryESet;
		windowsDirectoryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY, oldWindowsDirectory,
					windowsDirectory, !oldWindowsDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWindowsDirectory() {
		WindowsDirectoryType oldWindowsDirectory = windowsDirectory;
		boolean oldWindowsDirectoryESet = windowsDirectoryESet;
		windowsDirectory = WINDOWS_DIRECTORY_EDEFAULT;
		windowsDirectoryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY, oldWindowsDirectory,
					WINDOWS_DIRECTORY_EDEFAULT, oldWindowsDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWindowsDirectory() {
		return windowsDirectoryESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkgroupName() {
		return workgroupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkgroupName(String newWorkgroupName) {
		String oldWorkgroupName = workgroupName;
		workgroupName = newWorkgroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME, oldWorkgroupName, workgroupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_OPERATING_SYSTEM__COMPANY:
			return getCompany();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN:
			return getDomainAdmin();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME:
			return getDomainName();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD:
			return getDomainPassword();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL:
			return getEncryptionLevel();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE:
			return getInstallDate();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE:
			return getLanguage();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP:
			return getLanguageGroup();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			return getLastBootUpTime();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU:
			return getMachineObjectOU();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS:
			return getNumberOfLicensedUsers();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__OWNER:
			return getOwner();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY:
			return getProductKey();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE:
			return getProductType();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE:
			return getSystemDrive();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY:
			return getWindowsDirectory();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME:
			return getWorkgroupName();
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
		case OsPackage.WINDOWS_OPERATING_SYSTEM__COMPANY:
			setCompany((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN:
			setDomainAdmin((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME:
			setDomainName((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD:
			setDomainPassword((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL:
			setEncryptionLevel((EncryptionLevelType) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE:
			setInstallDate((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE:
			setLanguage((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP:
			setLanguageGroup((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			setLastBootUpTime((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU:
			setMachineObjectOU((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS:
			setNumberOfLicensedUsers((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__OWNER:
			setOwner((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY:
			setProductKey((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE:
			setProductType((WindowsProductTypeType) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE:
			setSystemDrive((String) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY:
			setWindowsDirectory((WindowsDirectoryType) newValue);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME:
			setWorkgroupName((String) newValue);
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
		case OsPackage.WINDOWS_OPERATING_SYSTEM__COMPANY:
			setCompany(COMPANY_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN:
			setDomainAdmin(DOMAIN_ADMIN_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME:
			setDomainName(DOMAIN_NAME_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD:
			setDomainPassword(DOMAIN_PASSWORD_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL:
			unsetEncryptionLevel();
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE:
			setInstallDate(INSTALL_DATE_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE:
			setLanguage(LANGUAGE_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP:
			setLanguageGroup(LANGUAGE_GROUP_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			setLastBootUpTime(LAST_BOOT_UP_TIME_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU:
			setMachineObjectOU(MACHINE_OBJECT_OU_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS:
			setNumberOfLicensedUsers(NUMBER_OF_LICENSED_USERS_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__OWNER:
			setOwner(OWNER_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY:
			setProductKey(PRODUCT_KEY_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE:
			unsetProductType();
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE:
			setSystemDrive(SYSTEM_DRIVE_EDEFAULT);
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY:
			unsetWindowsDirectory();
			return;
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME:
			setWorkgroupName(WORKGROUP_NAME_EDEFAULT);
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
		case OsPackage.WINDOWS_OPERATING_SYSTEM__COMPANY:
			return COMPANY_EDEFAULT == null ? company != null : !COMPANY_EDEFAULT.equals(company);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN:
			return DOMAIN_ADMIN_EDEFAULT == null ? domainAdmin != null : !DOMAIN_ADMIN_EDEFAULT
					.equals(domainAdmin);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME:
			return DOMAIN_NAME_EDEFAULT == null ? domainName != null : !DOMAIN_NAME_EDEFAULT
					.equals(domainName);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD:
			return DOMAIN_PASSWORD_EDEFAULT == null ? domainPassword != null
					: !DOMAIN_PASSWORD_EDEFAULT.equals(domainPassword);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL:
			return isSetEncryptionLevel();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE:
			return INSTALL_DATE_EDEFAULT == null ? installDate != null : !INSTALL_DATE_EDEFAULT
					.equals(installDate);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE:
			return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP:
			return LANGUAGE_GROUP_EDEFAULT == null ? languageGroup != null : !LANGUAGE_GROUP_EDEFAULT
					.equals(languageGroup);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			return LAST_BOOT_UP_TIME_EDEFAULT == null ? lastBootUpTime != null
					: !LAST_BOOT_UP_TIME_EDEFAULT.equals(lastBootUpTime);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU:
			return MACHINE_OBJECT_OU_EDEFAULT == null ? machineObjectOU != null
					: !MACHINE_OBJECT_OU_EDEFAULT.equals(machineObjectOU);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS:
			return NUMBER_OF_LICENSED_USERS_EDEFAULT == null ? numberOfLicensedUsers != null
					: !NUMBER_OF_LICENSED_USERS_EDEFAULT.equals(numberOfLicensedUsers);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__OWNER:
			return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY:
			return PRODUCT_KEY_EDEFAULT == null ? productKey != null : !PRODUCT_KEY_EDEFAULT
					.equals(productKey);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE:
			return isSetProductType();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE:
			return SYSTEM_DRIVE_EDEFAULT == null ? systemDrive != null : !SYSTEM_DRIVE_EDEFAULT
					.equals(systemDrive);
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY:
			return isSetWindowsDirectory();
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME:
			return WORKGROUP_NAME_EDEFAULT == null ? workgroupName != null : !WORKGROUP_NAME_EDEFAULT
					.equals(workgroupName);
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
		result.append(" (company: "); //$NON-NLS-1$
		result.append(company);
		result.append(", domainAdmin: "); //$NON-NLS-1$
		result.append(domainAdmin);
		result.append(", domainName: "); //$NON-NLS-1$
		result.append(domainName);
		result.append(", domainPassword: "); //$NON-NLS-1$
		result.append(domainPassword);
		result.append(", encryptionLevel: "); //$NON-NLS-1$
		if (encryptionLevelESet)
			result.append(encryptionLevel);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", installDate: "); //$NON-NLS-1$
		result.append(installDate);
		result.append(", language: "); //$NON-NLS-1$
		result.append(language);
		result.append(", languageGroup: "); //$NON-NLS-1$
		result.append(languageGroup);
		result.append(", lastBootUpTime: "); //$NON-NLS-1$
		result.append(lastBootUpTime);
		result.append(", machineObjectOU: "); //$NON-NLS-1$
		result.append(machineObjectOU);
		result.append(", numberOfLicensedUsers: "); //$NON-NLS-1$
		result.append(numberOfLicensedUsers);
		result.append(", owner: "); //$NON-NLS-1$
		result.append(owner);
		result.append(", productKey: "); //$NON-NLS-1$
		result.append(productKey);
		result.append(", productType: "); //$NON-NLS-1$
		if (productTypeESet)
			result.append(productType);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", systemDrive: "); //$NON-NLS-1$
		result.append(systemDrive);
		result.append(", windowsDirectory: "); //$NON-NLS-1$
		if (windowsDirectoryESet)
			result.append(windowsDirectory);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", workgroupName: "); //$NON-NLS-1$
		result.append(workgroupName);
		result.append(')');
		return result.toString();
	}

} //WindowsOperatingSystemImpl
