/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualEthernetNICDefImpl.java,v 1.2 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Ethernet NIC Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefImpl#getMacAddress <em>Mac Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefImpl#getVirtualConnectionType <em>Virtual Connection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualEthernetNICDefImpl extends CapabilityImpl implements VirtualEthernetNICDef {
	/**
	 * The default value of the '{@link #getMacAddress() <em>Mac Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMacAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String MAC_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMacAddress() <em>Mac Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMacAddress()
	 * @generated
	 * @ordered
	 */
	protected String macAddress = MAC_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVirtualConnectionType() <em>Virtual Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualConnectionType()
	 * @generated
	 * @ordered
	 */
	protected static final VirtualNetworkConnectionType VIRTUAL_CONNECTION_TYPE_EDEFAULT = VirtualNetworkConnectionType.BRIDGED_LITERAL;

	/**
	 * The cached value of the '{@link #getVirtualConnectionType() <em>Virtual Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualConnectionType()
	 * @generated
	 * @ordered
	 */
	protected VirtualNetworkConnectionType virtualConnectionType = VIRTUAL_CONNECTION_TYPE_EDEFAULT;

	/**
	 * This is true if the Virtual Connection Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean virtualConnectionTypeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualEthernetNICDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VIRTUAL_ETHERNET_NIC_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMacAddress(String newMacAddress) {
		String oldMacAddress = macAddress;
		macAddress = newMacAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS, oldMacAddress, macAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualNetworkConnectionType getVirtualConnectionType() {
		return virtualConnectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualConnectionType(VirtualNetworkConnectionType newVirtualConnectionType) {
		VirtualNetworkConnectionType oldVirtualConnectionType = virtualConnectionType;
		virtualConnectionType = newVirtualConnectionType == null ? VIRTUAL_CONNECTION_TYPE_EDEFAULT : newVirtualConnectionType;
		boolean oldVirtualConnectionTypeESet = virtualConnectionTypeESet;
		virtualConnectionTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE, oldVirtualConnectionType, virtualConnectionType, !oldVirtualConnectionTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVirtualConnectionType() {
		VirtualNetworkConnectionType oldVirtualConnectionType = virtualConnectionType;
		boolean oldVirtualConnectionTypeESet = virtualConnectionTypeESet;
		virtualConnectionType = VIRTUAL_CONNECTION_TYPE_EDEFAULT;
		virtualConnectionTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE, oldVirtualConnectionType, VIRTUAL_CONNECTION_TYPE_EDEFAULT, oldVirtualConnectionTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVirtualConnectionType() {
		return virtualConnectionTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS:
				return getMacAddress();
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE:
				return getVirtualConnectionType();
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
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS:
				setMacAddress((String)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE:
				setVirtualConnectionType((VirtualNetworkConnectionType)newValue);
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
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS:
				setMacAddress(MAC_ADDRESS_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE:
				unsetVirtualConnectionType();
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
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS:
				return MAC_ADDRESS_EDEFAULT == null ? macAddress != null : !MAC_ADDRESS_EDEFAULT.equals(macAddress);
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE:
				return isSetVirtualConnectionType();
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
		result.append(" (macAddress: "); //$NON-NLS-1$
		result.append(macAddress);
		result.append(", virtualConnectionType: "); //$NON-NLS-1$
		if (virtualConnectionTypeESet) result.append(virtualConnectionType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //VirtualEthernetNICDefImpl
