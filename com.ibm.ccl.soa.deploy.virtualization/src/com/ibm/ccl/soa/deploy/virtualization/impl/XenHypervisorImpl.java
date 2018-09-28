/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenHypervisorImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.XenHypervisor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xen Hypervisor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenHypervisorImpl#getXenVersion <em>Xen Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XenHypervisorImpl extends HypervisorImpl implements XenHypervisor {
	/**
	 * The default value of the '{@link #getXenVersion() <em>Xen Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXenVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String XEN_VERSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getXenVersion() <em>Xen Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXenVersion()
	 * @generated
	 * @ordered
	 */
	protected String xenVersion = XEN_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenHypervisorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.XEN_HYPERVISOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXenVersion() {
		return xenVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXenVersion(String newXenVersion) {
		String oldXenVersion = xenVersion;
		xenVersion = newXenVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_HYPERVISOR__XEN_VERSION, oldXenVersion, xenVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.XEN_HYPERVISOR__XEN_VERSION:
				return getXenVersion();
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
			case VirtualizationPackage.XEN_HYPERVISOR__XEN_VERSION:
				setXenVersion((String)newValue);
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
			case VirtualizationPackage.XEN_HYPERVISOR__XEN_VERSION:
				setXenVersion(XEN_VERSION_EDEFAULT);
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
			case VirtualizationPackage.XEN_HYPERVISOR__XEN_VERSION:
				return XEN_VERSION_EDEFAULT == null ? xenVersion != null : !XEN_VERSION_EDEFAULT.equals(xenVersion);
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
		result.append(" (xenVersion: "); //$NON-NLS-1$
		result.append(xenVersion);
		result.append(')');
		return result.toString();
	}

} //XenHypervisorImpl
