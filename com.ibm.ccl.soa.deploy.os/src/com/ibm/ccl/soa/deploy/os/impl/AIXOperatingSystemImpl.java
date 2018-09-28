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

import com.ibm.ccl.soa.deploy.os.AIXDesktopType;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystem;
import com.ibm.ccl.soa.deploy.os.KernelWidthType;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>AIX Operating System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl#getDesktop <em>Desktop</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl#getKernel <em>Kernel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl#getLastBootUpTime <em>Last Boot Up Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl#isTCB <em>TCB</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIXOperatingSystemImpl extends OperatingSystemImpl implements AIXOperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDesktop() <em>Desktop</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDesktop()
	 * @generated
	 * @ordered
	 */
	protected static final AIXDesktopType DESKTOP_EDEFAULT = AIXDesktopType.CDE_LITERAL;

	/**
	 * The cached value of the '{@link #getDesktop() <em>Desktop</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDesktop()
	 * @generated
	 * @ordered
	 */
	protected AIXDesktopType desktop = DESKTOP_EDEFAULT;

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
	 * The default value of the '{@link #getKernel() <em>Kernel</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getKernel()
	 * @generated
	 * @ordered
	 */
	protected static final KernelWidthType KERNEL_EDEFAULT = KernelWidthType._32_BIT_LITERAL;

	/**
	 * The cached value of the '{@link #getKernel() <em>Kernel</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getKernel()
	 * @generated
	 * @ordered
	 */
	protected KernelWidthType kernel = KERNEL_EDEFAULT;

	/**
	 * This is true if the Kernel attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean kernelESet;

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
	 * The default value of the '{@link #isTCB() <em>TCB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTCB()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TCB_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTCB() <em>TCB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTCB()
	 * @generated
	 * @ordered
	 */
	protected boolean tCB = TCB_EDEFAULT;

	/**
	 * This is true if the TCB attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean tCBESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AIXOperatingSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.AIX_OPERATING_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXDesktopType getDesktop() {
		return desktop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesktop(AIXDesktopType newDesktop) {
		AIXDesktopType oldDesktop = desktop;
		desktop = newDesktop == null ? DESKTOP_EDEFAULT : newDesktop;
		boolean oldDesktopESet = desktopESet;
		desktopESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_OPERATING_SYSTEM__DESKTOP, oldDesktop, desktop, !oldDesktopESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDesktop() {
		AIXDesktopType oldDesktop = desktop;
		boolean oldDesktopESet = desktopESet;
		desktop = DESKTOP_EDEFAULT;
		desktopESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_OPERATING_SYSTEM__DESKTOP, oldDesktop, DESKTOP_EDEFAULT,
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
					OsPackage.AIX_OPERATING_SYSTEM__INSTALL_DATE, oldInstallDate, installDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public KernelWidthType getKernel() {
		return kernel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKernel(KernelWidthType newKernel) {
		KernelWidthType oldKernel = kernel;
		kernel = newKernel == null ? KERNEL_EDEFAULT : newKernel;
		boolean oldKernelESet = kernelESet;
		kernelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_OPERATING_SYSTEM__KERNEL, oldKernel, kernel, !oldKernelESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKernel() {
		KernelWidthType oldKernel = kernel;
		boolean oldKernelESet = kernelESet;
		kernel = KERNEL_EDEFAULT;
		kernelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_OPERATING_SYSTEM__KERNEL, oldKernel, KERNEL_EDEFAULT, oldKernelESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKernel() {
		return kernelESet;
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
					OsPackage.AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME, oldLastBootUpTime, lastBootUpTime));
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
					OsPackage.AIX_OPERATING_SYSTEM__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTCB() {
		return tCB;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCB(boolean newTCB) {
		boolean oldTCB = tCB;
		tCB = newTCB;
		boolean oldTCBESet = tCBESet;
		tCBESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.AIX_OPERATING_SYSTEM__TCB,
					oldTCB, tCB, !oldTCBESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTCB() {
		boolean oldTCB = tCB;
		boolean oldTCBESet = tCBESet;
		tCB = TCB_EDEFAULT;
		tCBESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_OPERATING_SYSTEM__TCB, oldTCB, TCB_EDEFAULT, oldTCBESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTCB() {
		return tCBESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.AIX_OPERATING_SYSTEM__DESKTOP:
			return getDesktop();
		case OsPackage.AIX_OPERATING_SYSTEM__INSTALL_DATE:
			return getInstallDate();
		case OsPackage.AIX_OPERATING_SYSTEM__KERNEL:
			return getKernel();
		case OsPackage.AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			return getLastBootUpTime();
		case OsPackage.AIX_OPERATING_SYSTEM__OWNER:
			return getOwner();
		case OsPackage.AIX_OPERATING_SYSTEM__TCB:
			return isTCB() ? Boolean.TRUE : Boolean.FALSE;
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
		case OsPackage.AIX_OPERATING_SYSTEM__DESKTOP:
			setDesktop((AIXDesktopType) newValue);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__INSTALL_DATE:
			setInstallDate((String) newValue);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__KERNEL:
			setKernel((KernelWidthType) newValue);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			setLastBootUpTime((String) newValue);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__OWNER:
			setOwner((String) newValue);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__TCB:
			setTCB(((Boolean) newValue).booleanValue());
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
		case OsPackage.AIX_OPERATING_SYSTEM__DESKTOP:
			unsetDesktop();
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__INSTALL_DATE:
			setInstallDate(INSTALL_DATE_EDEFAULT);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__KERNEL:
			unsetKernel();
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			setLastBootUpTime(LAST_BOOT_UP_TIME_EDEFAULT);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__OWNER:
			setOwner(OWNER_EDEFAULT);
			return;
		case OsPackage.AIX_OPERATING_SYSTEM__TCB:
			unsetTCB();
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
		case OsPackage.AIX_OPERATING_SYSTEM__DESKTOP:
			return isSetDesktop();
		case OsPackage.AIX_OPERATING_SYSTEM__INSTALL_DATE:
			return INSTALL_DATE_EDEFAULT == null ? installDate != null : !INSTALL_DATE_EDEFAULT
					.equals(installDate);
		case OsPackage.AIX_OPERATING_SYSTEM__KERNEL:
			return isSetKernel();
		case OsPackage.AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
			return LAST_BOOT_UP_TIME_EDEFAULT == null ? lastBootUpTime != null
					: !LAST_BOOT_UP_TIME_EDEFAULT.equals(lastBootUpTime);
		case OsPackage.AIX_OPERATING_SYSTEM__OWNER:
			return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
		case OsPackage.AIX_OPERATING_SYSTEM__TCB:
			return isSetTCB();
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
		result.append(" (desktop: "); //$NON-NLS-1$
		if (desktopESet)
			result.append(desktop);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", installDate: "); //$NON-NLS-1$
		result.append(installDate);
		result.append(", kernel: "); //$NON-NLS-1$
		if (kernelESet)
			result.append(kernel);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", lastBootUpTime: "); //$NON-NLS-1$
		result.append(lastBootUpTime);
		result.append(", owner: "); //$NON-NLS-1$
		result.append(owner);
		result.append(", tCB: "); //$NON-NLS-1$
		if (tCBESet)
			result.append(tCB);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //AIXOperatingSystemImpl
