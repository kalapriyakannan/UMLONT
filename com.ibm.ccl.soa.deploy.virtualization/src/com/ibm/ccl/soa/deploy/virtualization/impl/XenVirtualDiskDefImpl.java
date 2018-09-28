/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualDiskDefImpl.java,v 1.2 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xen Virtual Disk Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl#getBackendDev <em>Backend Dev</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl#getFrontendDev <em>Frontend Dev</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XenVirtualDiskDefImpl extends VirtualDiskDefImpl implements XenVirtualDiskDef {
	/**
	 * The default value of the '{@link #getBackendDev() <em>Backend Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackendDev()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKEND_DEV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackendDev() <em>Backend Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackendDev()
	 * @generated
	 * @ordered
	 */
	protected String backendDev = BACKEND_DEV_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrontendDev() <em>Frontend Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontendDev()
	 * @generated
	 * @ordered
	 */
	protected static final String FRONTEND_DEV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrontendDev() <em>Frontend Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontendDev()
	 * @generated
	 * @ordered
	 */
	protected String frontendDev = FRONTEND_DEV_EDEFAULT;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected String mode = MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualDiskDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.XEN_VIRTUAL_DISK_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackendDev() {
		return backendDev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackendDev(String newBackendDev) {
		String oldBackendDev = backendDev;
		backendDev = newBackendDev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__BACKEND_DEV, oldBackendDev, backendDev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrontendDev() {
		return frontendDev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrontendDev(String newFrontendDev) {
		String oldFrontendDev = frontendDev;
		frontendDev = newFrontendDev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV, oldFrontendDev, frontendDev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__BACKEND_DEV:
				return getBackendDev();
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV:
				return getFrontendDev();
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__MODE:
				return getMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__BACKEND_DEV:
				setBackendDev((String)newValue);
				return;
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV:
				setFrontendDev((String)newValue);
				return;
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__MODE:
				setMode((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__BACKEND_DEV:
				setBackendDev(BACKEND_DEV_EDEFAULT);
				return;
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV:
				setFrontendDev(FRONTEND_DEV_EDEFAULT);
				return;
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__MODE:
				setMode(MODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__BACKEND_DEV:
				return BACKEND_DEV_EDEFAULT == null ? backendDev != null : !BACKEND_DEV_EDEFAULT.equals(backendDev);
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV:
				return FRONTEND_DEV_EDEFAULT == null ? frontendDev != null : !FRONTEND_DEV_EDEFAULT.equals(frontendDev);
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (backendDev: "); //$NON-NLS-1$
		result.append(backendDev);
		result.append(", frontendDev: "); //$NON-NLS-1$
		result.append(frontendDev);
		result.append(", mode: "); //$NON-NLS-1$
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //XenVirtualDiskDefImpl
