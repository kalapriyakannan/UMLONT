/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualEthernetNICDefImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xen Virtual Ethernet NIC Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefImpl#getNetworkBridge <em>Network Bridge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XenVirtualEthernetNICDefImpl extends VirtualEthernetNICDefImpl implements XenVirtualEthernetNICDef {
	/**
	 * The default value of the '{@link #getNetworkBridge() <em>Network Bridge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkBridge()
	 * @generated
	 * @ordered
	 */
	protected static final String NETWORK_BRIDGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNetworkBridge() <em>Network Bridge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkBridge()
	 * @generated
	 * @ordered
	 */
	protected String networkBridge = NETWORK_BRIDGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualEthernetNICDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.XEN_VIRTUAL_ETHERNET_NIC_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetworkBridge() {
		return networkBridge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetworkBridge(String newNetworkBridge) {
		String oldNetworkBridge = networkBridge;
		networkBridge = newNetworkBridge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE, oldNetworkBridge, networkBridge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE:
				return getNetworkBridge();
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
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE:
				setNetworkBridge((String)newValue);
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
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE:
				setNetworkBridge(NETWORK_BRIDGE_EDEFAULT);
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
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE:
				return NETWORK_BRIDGE_EDEFAULT == null ? networkBridge != null : !NETWORK_BRIDGE_EDEFAULT.equals(networkBridge);
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
		result.append(" (networkBridge: "); //$NON-NLS-1$
		result.append(networkBridge);
		result.append(')');
		return result.toString();
	}

} //XenVirtualEthernetNICDefImpl
