/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server.impl;

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
import com.ibm.ccl.soa.deploy.server.ArchitectureWidthType;
import com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerFactory;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerRoot;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ServerPackageImpl extends EPackageImpl implements ServerPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum architectureWidthTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processingCapacityUnitsTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType architectureWidthTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType processingCapacityUnitsTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServerPackageImpl() {
		super(eNS_URI, ServerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServerPackage init() {
		if (isInited)
			return (ServerPackage) EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI);

		// Obtain or create and register package
		ServerPackageImpl theServerPackage = (ServerPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) : new ServerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theServerPackage.createPackageContents();

		// Initialize created meta-data
		theServerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServerPackage.freeze();

		return theServerPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServer() {
		return serverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_AutoStart() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuArchitecture() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuArchitectureWidth() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuCoresInstalled() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuCount() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuDiesInstalled() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuManufacturer() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuSpeed() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuType() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_IsVMIDanLPAR() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Manufacturer() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_MemorySize() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Model() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_PrimaryMACAddress() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_ProcessingCapacity() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_ProcessingCapacityUnits() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_RomVersion() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_SerialNumber() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_SystemBoardUUID() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_SystemId() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Virtual() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Vmid() {
		return (EAttribute) serverEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerRoot() {
		return serverRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerRoot_Mixed() {
		return (EAttribute) serverRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerRoot_XMLNSPrefixMap() {
		return (EReference) serverRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerRoot_XSISchemaLocation() {
		return (EReference) serverRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerRoot_CapabilityServer() {
		return (EReference) serverRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerRoot_UnitServerUnit() {
		return (EReference) serverRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerUnit() {
		return serverUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArchitectureWidthType() {
		return architectureWidthTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessingCapacityUnitsType() {
		return processingCapacityUnitsTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getArchitectureWidthTypeObject() {
		return architectureWidthTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProcessingCapacityUnitsTypeObject() {
		return processingCapacityUnitsTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerFactory getServerFactory() {
		return (ServerFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		serverEClass = createEClass(SERVER);
		createEAttribute(serverEClass, SERVER__AUTO_START);
		createEAttribute(serverEClass, SERVER__CPU_ARCHITECTURE);
		createEAttribute(serverEClass, SERVER__CPU_COUNT);
		createEAttribute(serverEClass, SERVER__CPU_ARCHITECTURE_WIDTH);
		createEAttribute(serverEClass, SERVER__CPU_CORES_INSTALLED);
		createEAttribute(serverEClass, SERVER__CPU_DIES_INSTALLED);
		createEAttribute(serverEClass, SERVER__CPU_MANUFACTURER);
		createEAttribute(serverEClass, SERVER__CPU_SPEED);
		createEAttribute(serverEClass, SERVER__CPU_TYPE);
		createEAttribute(serverEClass, SERVER__IS_VMI_DAN_LPAR);
		createEAttribute(serverEClass, SERVER__MANUFACTURER);
		createEAttribute(serverEClass, SERVER__MEMORY_SIZE);
		createEAttribute(serverEClass, SERVER__MODEL);
		createEAttribute(serverEClass, SERVER__PRIMARY_MAC_ADDRESS);
		createEAttribute(serverEClass, SERVER__PROCESSING_CAPACITY);
		createEAttribute(serverEClass, SERVER__PROCESSING_CAPACITY_UNITS);
		createEAttribute(serverEClass, SERVER__ROM_VERSION);
		createEAttribute(serverEClass, SERVER__SERIAL_NUMBER);
		createEAttribute(serverEClass, SERVER__SYSTEM_BOARD_UUID);
		createEAttribute(serverEClass, SERVER__SYSTEM_ID);
		createEAttribute(serverEClass, SERVER__VIRTUAL);
		createEAttribute(serverEClass, SERVER__VMID);

		serverRootEClass = createEClass(SERVER_ROOT);
		createEAttribute(serverRootEClass, SERVER_ROOT__MIXED);
		createEReference(serverRootEClass, SERVER_ROOT__XMLNS_PREFIX_MAP);
		createEReference(serverRootEClass, SERVER_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(serverRootEClass, SERVER_ROOT__CAPABILITY_SERVER);
		createEReference(serverRootEClass, SERVER_ROOT__UNIT_SERVER_UNIT);

		serverUnitEClass = createEClass(SERVER_UNIT);

		// Create enums
		architectureWidthTypeEEnum = createEEnum(ARCHITECTURE_WIDTH_TYPE);
		processingCapacityUnitsTypeEEnum = createEEnum(PROCESSING_CAPACITY_UNITS_TYPE);

		// Create data types
		architectureWidthTypeObjectEDataType = createEDataType(ARCHITECTURE_WIDTH_TYPE_OBJECT);
		processingCapacityUnitsTypeObjectEDataType = createEDataType(PROCESSING_CAPACITY_UNITS_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		serverEClass.getESuperTypes().add(theCorePackage.getCapability());
		serverUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(serverEClass, Server.class,
				"Server", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getServer_AutoStart(),
				theXMLTypePackage.getBoolean(),
				"autoStart", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuArchitecture(),
				theXMLTypePackage.getString(),
				"cpuArchitecture", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuCount(),
				theXMLTypePackage.getPositiveInteger(),
				"cpuCount", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuArchitectureWidth(),
				this.getArchitectureWidthType(),
				"cpuArchitectureWidth", "32-bit", 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getServer_CpuCoresInstalled(),
				theXMLTypePackage.getInt(),
				"cpuCoresInstalled", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuDiesInstalled(),
				theXMLTypePackage.getInt(),
				"cpuDiesInstalled", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuManufacturer(),
				theXMLTypePackage.getString(),
				"cpuManufacturer", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuSpeed(),
				theXMLTypePackage.getLong(),
				"cpuSpeed", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_CpuType(),
				theXMLTypePackage.getString(),
				"cpuType", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_IsVMIDanLPAR(),
				theXMLTypePackage.getBoolean(),
				"isVMIDanLPAR", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_Manufacturer(),
				theXMLTypePackage.getString(),
				"manufacturer", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_MemorySize(),
				theXMLTypePackage.getUnsignedLong(),
				"memorySize", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_Model(),
				theXMLTypePackage.getString(),
				"model", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_PrimaryMACAddress(),
				theXMLTypePackage.getString(),
				"primaryMACAddress", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_ProcessingCapacity(),
				theXMLTypePackage.getFloat(),
				"processingCapacity", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_ProcessingCapacityUnits(),
				this.getProcessingCapacityUnitsType(),
				"processingCapacityUnits", "Unknown", 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getServer_RomVersion(),
				theXMLTypePackage.getString(),
				"romVersion", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_SerialNumber(),
				theXMLTypePackage.getString(),
				"serialNumber", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_SystemBoardUUID(),
				theXMLTypePackage.getString(),
				"systemBoardUUID", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_SystemId(),
				theXMLTypePackage.getString(),
				"systemId", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_Virtual(),
				theXMLTypePackage.getBoolean(),
				"virtual", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServer_Vmid(),
				theXMLTypePackage.getString(),
				"vmid", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(serverRootEClass, ServerRoot.class,
				"ServerRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getServerRoot_Mixed(),
				ecorePackage.getEFeatureMapEntry(),
				"mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getServerRoot_XMLNSPrefixMap(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getServerRoot_XSISchemaLocation(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getServerRoot_CapabilityServer(),
				this.getServer(),
				null,
				"capabilityServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getServerRoot_UnitServerUnit(),
				this.getServerUnit(),
				null,
				"unitServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(serverUnitEClass, ServerUnit.class,
				"ServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(architectureWidthTypeEEnum, ArchitectureWidthType.class, "ArchitectureWidthType"); //$NON-NLS-1$
		addEEnumLiteral(architectureWidthTypeEEnum, ArchitectureWidthType._32_BIT_LITERAL);
		addEEnumLiteral(architectureWidthTypeEEnum, ArchitectureWidthType._64_BIT_LITERAL);

		initEEnum(processingCapacityUnitsTypeEEnum, ProcessingCapacityUnitsType.class,
				"ProcessingCapacityUnitsType"); //$NON-NLS-1$
		addEEnumLiteral(processingCapacityUnitsTypeEEnum, ProcessingCapacityUnitsType.UNKNOWN_LITERAL);
		addEEnumLiteral(processingCapacityUnitsTypeEEnum, ProcessingCapacityUnitsType.OTHER_LITERAL);
		addEEnumLiteral(processingCapacityUnitsTypeEEnum,
				ProcessingCapacityUnitsType.SPEC_INT_LITERAL);
		addEEnumLiteral(processingCapacityUnitsTypeEEnum, ProcessingCapacityUnitsType.MSU_LITERAL);

		// Initialize data types
		initEDataType(architectureWidthTypeObjectEDataType, ArchitectureWidthType.class,
				"ArchitectureWidthTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(processingCapacityUnitsTypeObjectEDataType, ProcessingCapacityUnitsType.class,
				"ProcessingCapacityUnitsTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation(architectureWidthTypeEEnum, source, new String[] {
				"name", "ArchitectureWidthType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(architectureWidthTypeObjectEDataType, source, new String[] {
				"name", "ArchitectureWidthType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "ArchitectureWidthType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(processingCapacityUnitsTypeEEnum, source, new String[] {
				"name", "ProcessingCapacityUnitsType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(processingCapacityUnitsTypeObjectEDataType, source, new String[] {
				"name", "ProcessingCapacityUnitsType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "ProcessingCapacityUnitsType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(serverEClass, source, new String[] { "name", "Server", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_AutoStart(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "autoStart" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuArchitecture(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpu.architecture" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuCount(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpu.count" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuArchitectureWidth(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpuArchitectureWidth" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuCoresInstalled(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpuCoresInstalled" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuDiesInstalled(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpuDiesInstalled" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuManufacturer(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpuManufacturer" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuSpeed(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpuSpeed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_CpuType(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cpuType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_IsVMIDanLPAR(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "isVMIDanLPAR" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_Manufacturer(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "manufacturer" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_MemorySize(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "memory.size" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_Model(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "model" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_PrimaryMACAddress(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "primaryMACAddress" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_ProcessingCapacity(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "processingCapacity" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_ProcessingCapacityUnits(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "processingCapacityUnits" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_RomVersion(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "romVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_SerialNumber(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "serialNumber" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_SystemBoardUUID(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "systemBoardUUID" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_SystemId(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "systemId" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_Virtual(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "virtual" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServer_Vmid(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "vmid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(serverRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServerRoot_Mixed(), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
				"name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServerRoot_XMLNSPrefixMap(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServerRoot_XSISchemaLocation(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServerRoot_CapabilityServer(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.server", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServerRoot_UnitServerUnit(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.serverUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(serverUnitEClass, source, new String[] { "name", "ServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //ServerPackageImpl
