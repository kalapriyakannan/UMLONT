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
import com.ibm.ccl.soa.deploy.os.RedhatDesktopType;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType;
import com.ibm.ccl.soa.deploy.os.SELinuxStateType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Redhat Linux Operating System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getBootLoader <em>Boot Loader</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getDesktop <em>Desktop</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getLastBootUpTime <em>Last Boot Up Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getProductType <em>Product Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl#getSELinuxState <em>SE Linux State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedhatLinuxOperatingSystemImpl extends LinuxOperatingSystemImpl implements
		RedhatLinuxOperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBootLoader() <em>Boot Loader</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBootLoader()
	 * @generated
	 * @ordered
	 */
	protected static final RedhatLinuxBootLoaderType BOOT_LOADER_EDEFAULT = RedhatLinuxBootLoaderType.GRUB_LITERAL;

	/**
	 * The cached value of the '{@link #getBootLoader() <em>Boot Loader</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBootLoader()
	 * @generated
	 * @ordered
	 */
	protected RedhatLinuxBootLoaderType bootLoader = BOOT_LOADER_EDEFAULT;

	/**
	 * This is true if the Boot Loader attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean bootLoaderESet;

	/**
	 * The default value of the '{@link #getDesktop() <em>Desktop</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDesktop()
	 * @generated
	 * @ordered
	 */
	protected static final RedhatDesktopType DESKTOP_EDEFAULT = RedhatDesktopType.GNOME_LITERAL;

	/**
	 * The cached value of the '{@link #getDesktop() <em>Desktop</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDesktop()
	 * @generated
	 * @ordered
	 */
	protected RedhatDesktopType desktop = DESKTOP_EDEFAULT;

	/**
	 * This is true if the Desktop attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean desktopESet;

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
	 * The default value of the '{@link #getProductType() <em>Product Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductType()
	 * @generated
	 * @ordered
	 */
	protected static final RedhatLinuxProductTypeType PRODUCT_TYPE_EDEFAULT = RedhatLinuxProductTypeType.SERVER_LITERAL;

	/**
	 * The cached value of the '{@link #getProductType() <em>Product Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductType()
	 * @generated
	 * @ordered
	 */
	protected RedhatLinuxProductTypeType productType = PRODUCT_TYPE_EDEFAULT;

	/**
	 * This is true if the Product Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean productTypeESet;

	/**
	 * The default value of the '{@link #getSELinuxState() <em>SE Linux State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSELinuxState()
	 * @generated
	 * @ordered
	 */
	protected static final SELinuxStateType SE_LINUX_STATE_EDEFAULT = SELinuxStateType.DISABLED_LITERAL;

	/**
	 * The cached value of the '{@link #getSELinuxState() <em>SE Linux State</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSELinuxState()
	 * @generated
	 * @ordered
	 */
	protected SELinuxStateType sELinuxState = SE_LINUX_STATE_EDEFAULT;

	/**
	 * This is true if the SE Linux State attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sELinuxStateESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RedhatLinuxOperatingSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.REDHAT_LINUX_OPERATING_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxBootLoaderType getBootLoader() {
		return bootLoader;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBootLoader(RedhatLinuxBootLoaderType newBootLoader) {
		RedhatLinuxBootLoaderType oldBootLoader = bootLoader;
		bootLoader = newBootLoader == null ? BOOT_LOADER_EDEFAULT : newBootLoader;
		boolean oldBootLoaderESet = bootLoaderESet;
		bootLoaderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER, oldBootLoader, bootLoader,
					!oldBootLoaderESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBootLoader() {
		RedhatLinuxBootLoaderType oldBootLoader = bootLoader;
		boolean oldBootLoaderESet = bootLoaderESet;
		bootLoader = BOOT_LOADER_EDEFAULT;
		bootLoaderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER, oldBootLoader,
					BOOT_LOADER_EDEFAULT, oldBootLoaderESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBootLoader() {
		return bootLoaderESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatDesktopType getDesktop() {
		return desktop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesktop(RedhatDesktopType newDesktop) {
		RedhatDesktopType oldDesktop = desktop;
		desktop = newDesktop == null ? DESKTOP_EDEFAULT : newDesktop;
		boolean oldDesktopESet = desktopESet;
		desktopESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP, oldDesktop, desktop,
					!oldDesktopESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDesktop() {
		RedhatDesktopType oldDesktop = desktop;
		boolean oldDesktopESet = desktopESet;
		desktop = DESKTOP_EDEFAULT;
		desktopESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP, oldDesktop, DESKTOP_EDEFAULT,
					oldDesktopESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDesktop() {
		return desktopESet;
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
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE, oldInstallDate, installDate));
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
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME, oldLastBootUpTime,
					lastBootUpTime));
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
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxProductTypeType getProductType() {
		return productType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductType(RedhatLinuxProductTypeType newProductType) {
		RedhatLinuxProductTypeType oldProductType = productType;
		productType = newProductType == null ? PRODUCT_TYPE_EDEFAULT : newProductType;
		boolean oldProductTypeESet = productTypeESet;
		productTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE, oldProductType, productType,
					!oldProductTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProductType() {
		RedhatLinuxProductTypeType oldProductType = productType;
		boolean oldProductTypeESet = productTypeESet;
		productType = PRODUCT_TYPE_EDEFAULT;
		productTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE, oldProductType,
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
	public SELinuxStateType getSELinuxState() {
		return sELinuxState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSELinuxState(SELinuxStateType newSELinuxState) {
		SELinuxStateType oldSELinuxState = sELinuxState;
		sELinuxState = newSELinuxState == null ? SE_LINUX_STATE_EDEFAULT : newSELinuxState;
		boolean oldSELinuxStateESet = sELinuxStateESet;
		sELinuxStateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE, oldSELinuxState,
					sELinuxState, !oldSELinuxStateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSELinuxState() {
		SELinuxStateType oldSELinuxState = sELinuxState;
		boolean oldSELinuxStateESet = sELinuxStateESet;
		sELinuxState = SE_LINUX_STATE_EDEFAULT;
		sELinuxStateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE, oldSELinuxState,
					SE_LINUX_STATE_EDEFAULT, oldSELinuxStateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSELinuxState() {
		return sELinuxStateESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			return getBootLoader();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP:
			return getDesktop();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE:
			return getInstallDate();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			return getLastBootUpTime();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__OWNER:
			return getOwner();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE:
			return getProductType();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE:
			return getSELinuxState();
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
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			setBootLoader((RedhatLinuxBootLoaderType) newValue);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP:
			setDesktop((RedhatDesktopType) newValue);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE:
			setInstallDate((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			setLastBootUpTime((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__OWNER:
			setOwner((String) newValue);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE:
			setProductType((RedhatLinuxProductTypeType) newValue);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE:
			setSELinuxState((SELinuxStateType) newValue);
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
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			unsetBootLoader();
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP:
			unsetDesktop();
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE:
			setInstallDate(INSTALL_DATE_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			setLastBootUpTime(LAST_BOOT_UP_TIME_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__OWNER:
			setOwner(OWNER_EDEFAULT);
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE:
			unsetProductType();
			return;
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE:
			unsetSELinuxState();
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
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			return isSetBootLoader();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP:
			return isSetDesktop();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE:
			return INSTALL_DATE_EDEFAULT == null ? installDate != null : !INSTALL_DATE_EDEFAULT
					.equals(installDate);
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			return LAST_BOOT_UP_TIME_EDEFAULT == null ? lastBootUpTime != null
					: !LAST_BOOT_UP_TIME_EDEFAULT.equals(lastBootUpTime);
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__OWNER:
			return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE:
			return isSetProductType();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE:
			return isSetSELinuxState();
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
		result.append(" (bootLoader: "); //$NON-NLS-1$
		if (bootLoaderESet)
			result.append(bootLoader);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", desktop: "); //$NON-NLS-1$
		if (desktopESet)
			result.append(desktop);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", installDate: "); //$NON-NLS-1$
		result.append(installDate);
		result.append(", lastBootUpTime: "); //$NON-NLS-1$
		result.append(lastBootUpTime);
		result.append(", owner: "); //$NON-NLS-1$
		result.append(owner);
		result.append(", productType: "); //$NON-NLS-1$
		if (productTypeESet)
			result.append(productType);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", sELinuxState: "); //$NON-NLS-1$
		if (sELinuxStateESet)
			result.append(sELinuxState);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //RedhatLinuxOperatingSystemImpl
