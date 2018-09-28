/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetFactoryImpl.java,v 1.5 2008/02/06 17:29:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.impl;

import com.ibm.ccl.soa.deploy.net.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.net.DuplexType;
import com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType;
import com.ibm.ccl.soa.deploy.net.IpInterface;
import com.ibm.ccl.soa.deploy.net.IpInterfaceUnit;
import com.ibm.ccl.soa.deploy.net.L2Interface;
import com.ibm.ccl.soa.deploy.net.L2InterfaceUnit;
import com.ibm.ccl.soa.deploy.net.NetFactory;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.net.NetRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetFactoryImpl extends EFactoryImpl implements NetFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NetFactory init() {
		try {
			NetFactory theNetFactory = (NetFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/net/1.0.0/"); //$NON-NLS-1$ 
			if (theNetFactory != null) {
				return theNetFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NetFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NetPackage.IP_INTERFACE: return createIpInterface();
			case NetPackage.IP_INTERFACE_UNIT: return createIpInterfaceUnit();
			case NetPackage.L2_INTERFACE: return createL2Interface();
			case NetPackage.L2_INTERFACE_UNIT: return createL2InterfaceUnit();
			case NetPackage.NET_ROOT: return createNetRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case NetPackage.DUPLEX_TYPE:
				return createDuplexTypeFromString(eDataType, initialValue);
			case NetPackage.IPV6_ADDRESS_NOTATION_TYPE:
				return createIPv6AddressNotationTypeFromString(eDataType, initialValue);
			case NetPackage.DUPLEX_TYPE_OBJECT:
				return createDuplexTypeObjectFromString(eDataType, initialValue);
			case NetPackage.IPV6_ADDRESS_NOTATION_TYPE_OBJECT:
				return createIPv6AddressNotationTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case NetPackage.DUPLEX_TYPE:
				return convertDuplexTypeToString(eDataType, instanceValue);
			case NetPackage.IPV6_ADDRESS_NOTATION_TYPE:
				return convertIPv6AddressNotationTypeToString(eDataType, instanceValue);
			case NetPackage.DUPLEX_TYPE_OBJECT:
				return convertDuplexTypeObjectToString(eDataType, instanceValue);
			case NetPackage.IPV6_ADDRESS_NOTATION_TYPE_OBJECT:
				return convertIPv6AddressNotationTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpInterface createIpInterface() {
		IpInterfaceImpl ipInterface = new IpInterfaceImpl();
		return ipInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpInterfaceUnit createIpInterfaceUnit() {
		IpInterfaceUnitImpl ipInterfaceUnit = new IpInterfaceUnitImpl();
		return ipInterfaceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2Interface createL2Interface() {
		L2InterfaceImpl l2Interface = new L2InterfaceImpl();
		return l2Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2InterfaceUnit createL2InterfaceUnit() {
		L2InterfaceUnitImpl l2InterfaceUnit = new L2InterfaceUnitImpl();
		return l2InterfaceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetRoot createNetRoot() {
		NetRootImpl netRoot = new NetRootImpl();
		return netRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DuplexType createDuplexTypeFromString(EDataType eDataType, String initialValue) {
		DuplexType result = DuplexType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDuplexTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPv6AddressNotationType createIPv6AddressNotationTypeFromString(EDataType eDataType, String initialValue) {
		IPv6AddressNotationType result = IPv6AddressNotationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIPv6AddressNotationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DuplexType createDuplexTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDuplexTypeFromString(NetPackage.Literals.DUPLEX_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDuplexTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDuplexTypeToString(NetPackage.Literals.DUPLEX_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPv6AddressNotationType createIPv6AddressNotationTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createIPv6AddressNotationTypeFromString(NetPackage.Literals.IPV6_ADDRESS_NOTATION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIPv6AddressNotationTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertIPv6AddressNotationTypeToString(NetPackage.Literals.IPV6_ADDRESS_NOTATION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetPackage getNetPackage() {
		return (NetPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static NetPackage getPackage() {
		return NetPackage.eINSTANCE;
	}

} //NetFactoryImpl
