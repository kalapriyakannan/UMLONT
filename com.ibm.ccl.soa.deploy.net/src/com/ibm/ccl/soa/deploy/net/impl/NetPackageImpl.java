/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetPackageImpl.java,v 1.5 2008/05/19 14:50:09 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetPackageImpl extends EPackageImpl implements NetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipInterfaceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l2InterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l2InterfaceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass netRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum duplexTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum iPv6AddressNotationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType duplexTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iPv6AddressNotationTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NetPackageImpl() {
		super(eNS_URI, NetFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NetPackage init() {
		if (isInited) return (NetPackage)EPackage.Registry.INSTANCE.getEPackage(NetPackage.eNS_URI);

		// Obtain or create and register package
		NetPackageImpl theNetPackage = (NetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof NetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new NetPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNetPackage.createPackageContents();

		// Initialize created meta-data
		theNetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNetPackage.freeze();

		return theNetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpInterface() {
		return ipInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_Gateway() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_IpV4Address() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_IpV6Address() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_Ipv6NotationType() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_L2InterfaceName() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_Netmask() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpInterface_SubnetAddress() {
		return (EAttribute)ipInterfaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpInterfaceUnit() {
		return ipInterfaceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL2Interface() {
		return l2InterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_AutoNegotiation() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Broadcast() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Duplex() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Encapsulation() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_HwAddress() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Index() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_L2InterfaceName() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Loopback() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Mtu() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Private() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Promiscuous() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2Interface_Speed() {
		return (EAttribute)l2InterfaceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL2InterfaceUnit() {
		return l2InterfaceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetRoot() {
		return netRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetRoot_Mixed() {
		return (EAttribute)netRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetRoot_XMLNSPrefixMap() {
		return (EReference)netRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetRoot_XSISchemaLocation() {
		return (EReference)netRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetRoot_CapabilityIpInterface() {
		return (EReference)netRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetRoot_CapabilityL2Interface() {
		return (EReference)netRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetRoot_UnitIpInterfaceUnit() {
		return (EReference)netRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetRoot_UnitL2InterfaceUnit() {
		return (EReference)netRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDuplexType() {
		return duplexTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIPv6AddressNotationType() {
		return iPv6AddressNotationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDuplexTypeObject() {
		return duplexTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIPv6AddressNotationTypeObject() {
		return iPv6AddressNotationTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetFactory getNetFactory() {
		return (NetFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ipInterfaceEClass = createEClass(IP_INTERFACE);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__GATEWAY);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__IP_V4_ADDRESS);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__IP_V6_ADDRESS);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__IPV6_NOTATION_TYPE);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__L2_INTERFACE_NAME);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__NETMASK);
		createEAttribute(ipInterfaceEClass, IP_INTERFACE__SUBNET_ADDRESS);

		ipInterfaceUnitEClass = createEClass(IP_INTERFACE_UNIT);

		l2InterfaceEClass = createEClass(L2_INTERFACE);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__AUTO_NEGOTIATION);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__BROADCAST);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__DUPLEX);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__ENCAPSULATION);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__HW_ADDRESS);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__INDEX);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__L2_INTERFACE_NAME);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__LOOPBACK);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__MTU);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__PRIVATE);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__PROMISCUOUS);
		createEAttribute(l2InterfaceEClass, L2_INTERFACE__SPEED);

		l2InterfaceUnitEClass = createEClass(L2_INTERFACE_UNIT);

		netRootEClass = createEClass(NET_ROOT);
		createEAttribute(netRootEClass, NET_ROOT__MIXED);
		createEReference(netRootEClass, NET_ROOT__XMLNS_PREFIX_MAP);
		createEReference(netRootEClass, NET_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(netRootEClass, NET_ROOT__CAPABILITY_IP_INTERFACE);
		createEReference(netRootEClass, NET_ROOT__CAPABILITY_L2_INTERFACE);
		createEReference(netRootEClass, NET_ROOT__UNIT_IP_INTERFACE_UNIT);
		createEReference(netRootEClass, NET_ROOT__UNIT_L2_INTERFACE_UNIT);

		// Create enums
		duplexTypeEEnum = createEEnum(DUPLEX_TYPE);
		iPv6AddressNotationTypeEEnum = createEEnum(IPV6_ADDRESS_NOTATION_TYPE);

		// Create data types
		duplexTypeObjectEDataType = createEDataType(DUPLEX_TYPE_OBJECT);
		iPv6AddressNotationTypeObjectEDataType = createEDataType(IPV6_ADDRESS_NOTATION_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		ipInterfaceEClass.getESuperTypes().add(theCorePackage.getCapability());
		ipInterfaceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		l2InterfaceEClass.getESuperTypes().add(theCorePackage.getCapability());
		l2InterfaceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(ipInterfaceEClass, IpInterface.class, "IpInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIpInterface_Gateway(), theXMLTypePackage.getString(), "gateway", null, 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIpInterface_IpV4Address(), theXMLTypePackage.getString(), "ipV4Address", null, 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIpInterface_IpV6Address(), theXMLTypePackage.getString(), "ipV6Address", null, 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIpInterface_Ipv6NotationType(), this.getIPv6AddressNotationType(), "ipv6NotationType", "IPv6ColonNotation", 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getIpInterface_L2InterfaceName(), theXMLTypePackage.getString(), "l2InterfaceName", null, 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIpInterface_Netmask(), theXMLTypePackage.getString(), "netmask", null, 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIpInterface_SubnetAddress(), theXMLTypePackage.getString(), "subnetAddress", null, 0, 1, IpInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ipInterfaceUnitEClass, IpInterfaceUnit.class, "IpInterfaceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(l2InterfaceEClass, L2Interface.class, "L2Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getL2Interface_AutoNegotiation(), theXMLTypePackage.getBoolean(), "autoNegotiation", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Broadcast(), theXMLTypePackage.getBoolean(), "broadcast", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Duplex(), this.getDuplexType(), "duplex", "HalfDuplex", 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getL2Interface_Encapsulation(), theXMLTypePackage.getString(), "encapsulation", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_HwAddress(), theXMLTypePackage.getString(), "hwAddress", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Index(), theXMLTypePackage.getInt(), "index", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_L2InterfaceName(), theXMLTypePackage.getString(), "l2InterfaceName", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Loopback(), theXMLTypePackage.getBoolean(), "loopback", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Mtu(), theXMLTypePackage.getInt(), "mtu", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Private(), theXMLTypePackage.getBoolean(), "private", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Promiscuous(), theXMLTypePackage.getBoolean(), "promiscuous", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getL2Interface_Speed(), theXMLTypePackage.getLong(), "speed", null, 0, 1, L2Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(l2InterfaceUnitEClass, L2InterfaceUnit.class, "L2InterfaceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(netRootEClass, NetRoot.class, "NetRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNetRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNetRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNetRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNetRoot_CapabilityIpInterface(), this.getIpInterface(), null, "capabilityIpInterface", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNetRoot_CapabilityL2Interface(), this.getL2Interface(), null, "capabilityL2Interface", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNetRoot_UnitIpInterfaceUnit(), this.getIpInterfaceUnit(), null, "unitIpInterfaceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNetRoot_UnitL2InterfaceUnit(), this.getL2InterfaceUnit(), null, "unitL2InterfaceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(duplexTypeEEnum, DuplexType.class, "DuplexType"); //$NON-NLS-1$
		addEEnumLiteral(duplexTypeEEnum, DuplexType.HALF_DUPLEX_LITERAL);
		addEEnumLiteral(duplexTypeEEnum, DuplexType.FULL_DUPLEX_LITERAL);

		initEEnum(iPv6AddressNotationTypeEEnum, IPv6AddressNotationType.class, "IPv6AddressNotationType"); //$NON-NLS-1$
		addEEnumLiteral(iPv6AddressNotationTypeEEnum, IPv6AddressNotationType.IPV6_COLON_NOTATION_LITERAL);
		addEEnumLiteral(iPv6AddressNotationTypeEEnum, IPv6AddressNotationType.IPV6_MIXED_NOTATION_LITERAL);

		// Initialize data types
		initEDataType(duplexTypeObjectEDataType, DuplexType.class, "DuplexTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iPv6AddressNotationTypeObjectEDataType, IPv6AddressNotationType.class, "IPv6AddressNotationTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (duplexTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DuplexType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (duplexTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DuplexType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DuplexType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ipInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "IpInterface", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIpInterface_Gateway(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "gateway" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIpInterface_IpV4Address(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ipV4Address" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIpInterface_IpV6Address(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ipV6Address" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIpInterface_Ipv6NotationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ipv6NotationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIpInterface_L2InterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "l2InterfaceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIpInterface_Netmask(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "netmask" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIpInterface_SubnetAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subnetAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ipInterfaceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IpInterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (iPv6AddressNotationTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "IPv6AddressNotationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (iPv6AddressNotationTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "IPv6AddressNotationType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "IPv6AddressNotationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (l2InterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "L2Interface", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_AutoNegotiation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autoNegotiation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Broadcast(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "broadcast" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Duplex(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "duplex" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Encapsulation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "encapsulation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_HwAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hwAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Index(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "index" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_L2InterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "l2InterfaceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Loopback(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "loopback" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Mtu(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mtu" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Private(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "private" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Promiscuous(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "promiscuous" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getL2Interface_Speed(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "speed" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (l2InterfaceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "L2InterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (netRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_CapabilityIpInterface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ipInterface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_CapabilityL2Interface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.l2Interface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_UnitIpInterfaceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ipInterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getNetRoot_UnitL2InterfaceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.l2InterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //NetPackageImpl
