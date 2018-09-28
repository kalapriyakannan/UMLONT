/**
 * <copyright>
 * </copyright>
 *
 * $Id: IpInterfaceImpl.java,v 1.4 2008/05/19 14:50:09 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType;
import com.ibm.ccl.soa.deploy.net.IpInterface;
import com.ibm.ccl.soa.deploy.net.NetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ip Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getGateway <em>Gateway</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getIpV4Address <em>Ip V4 Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getIpV6Address <em>Ip V6 Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getIpv6NotationType <em>Ipv6 Notation Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getL2InterfaceName <em>L2 Interface Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getNetmask <em>Netmask</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl#getSubnetAddress <em>Subnet Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpInterfaceImpl extends CapabilityImpl implements IpInterface {
	/**
	 * The default value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected static final String GATEWAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected String gateway = GATEWAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpV4Address() <em>Ip V4 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpV4Address()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_V4_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIpV4Address() <em>Ip V4 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpV4Address()
	 * @generated
	 * @ordered
	 */
	protected String ipV4Address = IP_V4_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpV6Address() <em>Ip V6 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpV6Address()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_V6_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIpV6Address() <em>Ip V6 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpV6Address()
	 * @generated
	 * @ordered
	 */
	protected String ipV6Address = IP_V6_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpv6NotationType() <em>Ipv6 Notation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpv6NotationType()
	 * @generated
	 * @ordered
	 */
	protected static final IPv6AddressNotationType IPV6_NOTATION_TYPE_EDEFAULT = IPv6AddressNotationType.IPV6_COLON_NOTATION_LITERAL;

	/**
	 * The cached value of the '{@link #getIpv6NotationType() <em>Ipv6 Notation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpv6NotationType()
	 * @generated
	 * @ordered
	 */
	protected IPv6AddressNotationType ipv6NotationType = IPV6_NOTATION_TYPE_EDEFAULT;

	/**
	 * This is true if the Ipv6 Notation Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ipv6NotationTypeESet;

	/**
	 * The default value of the '{@link #getL2InterfaceName() <em>L2 Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2InterfaceName()
	 * @generated
	 * @ordered
	 */
	protected static final String L2_INTERFACE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getL2InterfaceName() <em>L2 Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2InterfaceName()
	 * @generated
	 * @ordered
	 */
	protected String l2InterfaceName = L2_INTERFACE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetmask() <em>Netmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetmask()
	 * @generated
	 * @ordered
	 */
	protected static final String NETMASK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetmask() <em>Netmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetmask()
	 * @generated
	 * @ordered
	 */
	protected String netmask = NETMASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubnetAddress() <em>Subnet Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnetAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBNET_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubnetAddress() <em>Subnet Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnetAddress()
	 * @generated
	 * @ordered
	 */
	protected String subnetAddress = SUBNET_ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NetPackage.Literals.IP_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGateway(String newGateway) {
		String oldGateway = gateway;
		gateway = newGateway;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__GATEWAY, oldGateway, gateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIpV4Address() {
		return ipV4Address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpV4Address(String newIpV4Address) {
		String oldIpV4Address = ipV4Address;
		ipV4Address = newIpV4Address;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__IP_V4_ADDRESS, oldIpV4Address, ipV4Address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIpV6Address() {
		return ipV6Address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpV6Address(String newIpV6Address) {
		String oldIpV6Address = ipV6Address;
		ipV6Address = newIpV6Address;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__IP_V6_ADDRESS, oldIpV6Address, ipV6Address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPv6AddressNotationType getIpv6NotationType() {
		return ipv6NotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpv6NotationType(IPv6AddressNotationType newIpv6NotationType) {
		IPv6AddressNotationType oldIpv6NotationType = ipv6NotationType;
		ipv6NotationType = newIpv6NotationType == null ? IPV6_NOTATION_TYPE_EDEFAULT : newIpv6NotationType;
		boolean oldIpv6NotationTypeESet = ipv6NotationTypeESet;
		ipv6NotationTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__IPV6_NOTATION_TYPE, oldIpv6NotationType, ipv6NotationType, !oldIpv6NotationTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIpv6NotationType() {
		IPv6AddressNotationType oldIpv6NotationType = ipv6NotationType;
		boolean oldIpv6NotationTypeESet = ipv6NotationTypeESet;
		ipv6NotationType = IPV6_NOTATION_TYPE_EDEFAULT;
		ipv6NotationTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.IP_INTERFACE__IPV6_NOTATION_TYPE, oldIpv6NotationType, IPV6_NOTATION_TYPE_EDEFAULT, oldIpv6NotationTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIpv6NotationType() {
		return ipv6NotationTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getL2InterfaceName() {
		return l2InterfaceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2InterfaceName(String newL2InterfaceName) {
		String oldL2InterfaceName = l2InterfaceName;
		l2InterfaceName = newL2InterfaceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__L2_INTERFACE_NAME, oldL2InterfaceName, l2InterfaceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetmask() {
		return netmask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetmask(String newNetmask) {
		String oldNetmask = netmask;
		netmask = newNetmask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__NETMASK, oldNetmask, netmask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubnetAddress() {
		return subnetAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubnetAddress(String newSubnetAddress) {
		String oldSubnetAddress = subnetAddress;
		subnetAddress = newSubnetAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.IP_INTERFACE__SUBNET_ADDRESS, oldSubnetAddress, subnetAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetPackage.IP_INTERFACE__GATEWAY:
				return getGateway();
			case NetPackage.IP_INTERFACE__IP_V4_ADDRESS:
				return getIpV4Address();
			case NetPackage.IP_INTERFACE__IP_V6_ADDRESS:
				return getIpV6Address();
			case NetPackage.IP_INTERFACE__IPV6_NOTATION_TYPE:
				return getIpv6NotationType();
			case NetPackage.IP_INTERFACE__L2_INTERFACE_NAME:
				return getL2InterfaceName();
			case NetPackage.IP_INTERFACE__NETMASK:
				return getNetmask();
			case NetPackage.IP_INTERFACE__SUBNET_ADDRESS:
				return getSubnetAddress();
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
			case NetPackage.IP_INTERFACE__GATEWAY:
				setGateway((String)newValue);
				return;
			case NetPackage.IP_INTERFACE__IP_V4_ADDRESS:
				setIpV4Address((String)newValue);
				return;
			case NetPackage.IP_INTERFACE__IP_V6_ADDRESS:
				setIpV6Address((String)newValue);
				return;
			case NetPackage.IP_INTERFACE__IPV6_NOTATION_TYPE:
				setIpv6NotationType((IPv6AddressNotationType)newValue);
				return;
			case NetPackage.IP_INTERFACE__L2_INTERFACE_NAME:
				setL2InterfaceName((String)newValue);
				return;
			case NetPackage.IP_INTERFACE__NETMASK:
				setNetmask((String)newValue);
				return;
			case NetPackage.IP_INTERFACE__SUBNET_ADDRESS:
				setSubnetAddress((String)newValue);
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
			case NetPackage.IP_INTERFACE__GATEWAY:
				setGateway(GATEWAY_EDEFAULT);
				return;
			case NetPackage.IP_INTERFACE__IP_V4_ADDRESS:
				setIpV4Address(IP_V4_ADDRESS_EDEFAULT);
				return;
			case NetPackage.IP_INTERFACE__IP_V6_ADDRESS:
				setIpV6Address(IP_V6_ADDRESS_EDEFAULT);
				return;
			case NetPackage.IP_INTERFACE__IPV6_NOTATION_TYPE:
				unsetIpv6NotationType();
				return;
			case NetPackage.IP_INTERFACE__L2_INTERFACE_NAME:
				setL2InterfaceName(L2_INTERFACE_NAME_EDEFAULT);
				return;
			case NetPackage.IP_INTERFACE__NETMASK:
				setNetmask(NETMASK_EDEFAULT);
				return;
			case NetPackage.IP_INTERFACE__SUBNET_ADDRESS:
				setSubnetAddress(SUBNET_ADDRESS_EDEFAULT);
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
			case NetPackage.IP_INTERFACE__GATEWAY:
				return GATEWAY_EDEFAULT == null ? gateway != null : !GATEWAY_EDEFAULT.equals(gateway);
			case NetPackage.IP_INTERFACE__IP_V4_ADDRESS:
				return IP_V4_ADDRESS_EDEFAULT == null ? ipV4Address != null : !IP_V4_ADDRESS_EDEFAULT.equals(ipV4Address);
			case NetPackage.IP_INTERFACE__IP_V6_ADDRESS:
				return IP_V6_ADDRESS_EDEFAULT == null ? ipV6Address != null : !IP_V6_ADDRESS_EDEFAULT.equals(ipV6Address);
			case NetPackage.IP_INTERFACE__IPV6_NOTATION_TYPE:
				return isSetIpv6NotationType();
			case NetPackage.IP_INTERFACE__L2_INTERFACE_NAME:
				return L2_INTERFACE_NAME_EDEFAULT == null ? l2InterfaceName != null : !L2_INTERFACE_NAME_EDEFAULT.equals(l2InterfaceName);
			case NetPackage.IP_INTERFACE__NETMASK:
				return NETMASK_EDEFAULT == null ? netmask != null : !NETMASK_EDEFAULT.equals(netmask);
			case NetPackage.IP_INTERFACE__SUBNET_ADDRESS:
				return SUBNET_ADDRESS_EDEFAULT == null ? subnetAddress != null : !SUBNET_ADDRESS_EDEFAULT.equals(subnetAddress);
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
		result.append(" (gateway: "); //$NON-NLS-1$
		result.append(gateway);
		result.append(", ipV4Address: "); //$NON-NLS-1$
		result.append(ipV4Address);
		result.append(", ipV6Address: "); //$NON-NLS-1$
		result.append(ipV6Address);
		result.append(", ipv6NotationType: "); //$NON-NLS-1$
		if (ipv6NotationTypeESet) result.append(ipv6NotationType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", l2InterfaceName: "); //$NON-NLS-1$
		result.append(l2InterfaceName);
		result.append(", netmask: "); //$NON-NLS-1$
		result.append(netmask);
		result.append(", subnetAddress: "); //$NON-NLS-1$
		result.append(subnetAddress);
		result.append(')');
		return result.toString();
	}

} //IpInterfaceImpl
