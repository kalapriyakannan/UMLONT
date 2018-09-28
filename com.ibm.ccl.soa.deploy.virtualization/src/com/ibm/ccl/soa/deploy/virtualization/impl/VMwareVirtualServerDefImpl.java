/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualServerDefImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual Server Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerDefImpl#getGuestOS <em>Guest OS</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerDefImpl#getVirtualHWVersion <em>Virtual HW Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualServerDefImpl extends VirtualServerDefImpl implements VMwareVirtualServerDef {
	/**
	 * The default value of the '{@link #getGuestOS() <em>Guest OS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuestOS()
	 * @generated
	 * @ordered
	 */
	protected static final String GUEST_OS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuestOS() <em>Guest OS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuestOS()
	 * @generated
	 * @ordered
	 */
	protected String guestOS = GUEST_OS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVirtualHWVersion() <em>Virtual HW Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualHWVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VIRTUAL_HW_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVirtualHWVersion() <em>Virtual HW Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualHWVersion()
	 * @generated
	 * @ordered
	 */
	protected String virtualHWVersion = VIRTUAL_HW_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualServerDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_SERVER_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuestOS() {
		return guestOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuestOS(String newGuestOS) {
		String oldGuestOS = guestOS;
		guestOS = newGuestOS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS, oldGuestOS, guestOS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVirtualHWVersion() {
		return virtualHWVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualHWVersion(String newVirtualHWVersion) {
		String oldVirtualHWVersion = virtualHWVersion;
		virtualHWVersion = newVirtualHWVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION, oldVirtualHWVersion, virtualHWVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS:
				return getGuestOS();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION:
				return getVirtualHWVersion();
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
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS:
				setGuestOS((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION:
				setVirtualHWVersion((String)newValue);
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
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS:
				setGuestOS(GUEST_OS_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION:
				setVirtualHWVersion(VIRTUAL_HW_VERSION_EDEFAULT);
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
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS:
				return GUEST_OS_EDEFAULT == null ? guestOS != null : !GUEST_OS_EDEFAULT.equals(guestOS);
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION:
				return VIRTUAL_HW_VERSION_EDEFAULT == null ? virtualHWVersion != null : !VIRTUAL_HW_VERSION_EDEFAULT.equals(virtualHWVersion);
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
		result.append(" (guestOS: "); //$NON-NLS-1$
		result.append(guestOS);
		result.append(", virtualHWVersion: "); //$NON-NLS-1$
		result.append(virtualHWVersion);
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualServerDefImpl
