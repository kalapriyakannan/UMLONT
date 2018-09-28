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
import com.ibm.ccl.soa.deploy.os.SUSEDesktopType;
import com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType;
import com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SUSE Linux Operating System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl#getBootLoader <em>Boot Loader</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl#getDesktop <em>Desktop</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl#getLastBootUpDate <em>Last Boot Up Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SUSELinuxOperatingSystemImpl extends LinuxOperatingSystemImpl implements
		SUSELinuxOperatingSystem {
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
	protected static final SUSELinuxBootLoaderType BOOT_LOADER_EDEFAULT = SUSELinuxBootLoaderType.GRUB_LITERAL;

	/**
	 * The cached value of the '{@link #getBootLoader() <em>Boot Loader</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBootLoader()
	 * @generated
	 * @ordered
	 */
	protected SUSELinuxBootLoaderType bootLoader = BOOT_LOADER_EDEFAULT;

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
	protected static final SUSEDesktopType DESKTOP_EDEFAULT = SUSEDesktopType.GNOME_LITERAL;

	/**
	 * The cached value of the '{@link #getDesktop() <em>Desktop</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDesktop()
	 * @generated
	 * @ordered
	 */
	protected SUSEDesktopType desktop = DESKTOP_EDEFAULT;

	/**
	 * This is true if the Desktop attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean desktopESet;

	/**
	 * The default value of the '{@link #getLastBootUpDate() <em>Last Boot Up Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastBootUpDate()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_BOOT_UP_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastBootUpDate() <em>Last Boot Up Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastBootUpDate()
	 * @generated
	 * @ordered
	 */
	protected String lastBootUpDate = LAST_BOOT_UP_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SUSELinuxOperatingSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.SUSE_LINUX_OPERATING_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxBootLoaderType getBootLoader() {
		return bootLoader;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBootLoader(SUSELinuxBootLoaderType newBootLoader) {
		SUSELinuxBootLoaderType oldBootLoader = bootLoader;
		bootLoader = newBootLoader == null ? BOOT_LOADER_EDEFAULT : newBootLoader;
		boolean oldBootLoaderESet = bootLoaderESet;
		bootLoaderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER, oldBootLoader, bootLoader,
					!oldBootLoaderESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBootLoader() {
		SUSELinuxBootLoaderType oldBootLoader = bootLoader;
		boolean oldBootLoaderESet = bootLoaderESet;
		bootLoader = BOOT_LOADER_EDEFAULT;
		bootLoaderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER, oldBootLoader,
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
	public SUSEDesktopType getDesktop() {
		return desktop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesktop(SUSEDesktopType newDesktop) {
		SUSEDesktopType oldDesktop = desktop;
		desktop = newDesktop == null ? DESKTOP_EDEFAULT : newDesktop;
		boolean oldDesktopESet = desktopESet;
		desktopESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.SUSE_LINUX_OPERATING_SYSTEM__DESKTOP, oldDesktop, desktop, !oldDesktopESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDesktop() {
		SUSEDesktopType oldDesktop = desktop;
		boolean oldDesktopESet = desktopESet;
		desktop = DESKTOP_EDEFAULT;
		desktopESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.SUSE_LINUX_OPERATING_SYSTEM__DESKTOP, oldDesktop, DESKTOP_EDEFAULT,
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
	public String getLastBootUpDate() {
		return lastBootUpDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastBootUpDate(String newLastBootUpDate) {
		String oldLastBootUpDate = lastBootUpDate;
		lastBootUpDate = newLastBootUpDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE, oldLastBootUpDate,
					lastBootUpDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			return getBootLoader();
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__DESKTOP:
			return getDesktop();
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE:
			return getLastBootUpDate();
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
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			setBootLoader((SUSELinuxBootLoaderType) newValue);
			return;
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__DESKTOP:
			setDesktop((SUSEDesktopType) newValue);
			return;
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE:
			setLastBootUpDate((String) newValue);
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
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			unsetBootLoader();
			return;
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__DESKTOP:
			unsetDesktop();
			return;
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE:
			setLastBootUpDate(LAST_BOOT_UP_DATE_EDEFAULT);
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
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER:
			return isSetBootLoader();
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__DESKTOP:
			return isSetDesktop();
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE:
			return LAST_BOOT_UP_DATE_EDEFAULT == null ? lastBootUpDate != null
					: !LAST_BOOT_UP_DATE_EDEFAULT.equals(lastBootUpDate);
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
		result.append(", lastBootUpDate: "); //$NON-NLS-1$
		result.append(lastBootUpDate);
		result.append(')');
		return result.toString();
	}

} //SUSELinuxOperatingSystemImpl
