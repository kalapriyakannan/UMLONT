/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.impl;

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
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot;
import com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames;
import com.ibm.ccl.soa.deploy.ihs.IhsFactory;
import com.ibm.ccl.soa.deploy.ihs.IhsModule;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServer;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;
import com.ibm.ccl.soa.deploy.ihs.IhsUserRepository;
import com.ibm.ccl.soa.deploy.ihs.IhsUserUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem;
import com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class IhsPackageImpl extends EPackageImpl implements IhsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsUserRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsUserUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsWasAdminModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsWasAdminModuleUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsWasModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsWasModuleUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxIhsSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsIhsSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ihsServerPortNamesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ihsServerPortNamesObjectEDataType = null;

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
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IhsPackageImpl() {
		super(eNS_URI, IhsFactory.eINSTANCE);
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
	public static IhsPackage init() {
		if (isInited) return (IhsPackage)EPackage.Registry.INSTANCE.getEPackage(IhsPackage.eNS_URI);

		// Obtain or create and register package
		IhsPackageImpl theIhsPackage = (IhsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof IhsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new IhsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		HttpPackage.eINSTANCE.eClass();
		OsPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theIhsPackage.createPackageContents();

		// Initialize created meta-data
		theIhsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIhsPackage.freeze();

		return theIhsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIHSDeployRoot() {
		return ihsDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHSDeployRoot_Mixed() {
		return (EAttribute)ihsDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_XMLNSPrefixMap() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_XSISchemaLocation() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsModule() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsServer() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsSystem() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsUser() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsUserRepository() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsWasAdminModule() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityIhsWasModule() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityLinuxIhsSystem() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_CapabilityWindowsIhsSystem() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_UnitIhsServerUnit() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_UnitIhsSystemUnit() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_UnitIhsUserUnit() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_UnitIhsWasAdminModuleUnit() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHSDeployRoot_UnitIhsWasModuleUnit() {
		return (EReference)ihsDeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsModule() {
		return ihsModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsModule_Location() {
		return (EAttribute)ihsModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsModule_ModuleName() {
		return (EAttribute)ihsModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsServer() {
		return ihsServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsServer_ConfigFile() {
		return (EAttribute)ihsServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsServer_Secure() {
		return (EAttribute)ihsServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsServerUnit() {
		return ihsServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsSystem() {
		return ihsSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsSystem_InstallLocation() {
		return (EAttribute)ihsSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsSystemUnit() {
		return ihsSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsUser() {
		return ihsUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsUserRepository() {
		return ihsUserRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsUserRepository_PasswordFile() {
		return (EAttribute)ihsUserRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsUserUnit() {
		return ihsUserUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsWasAdminModule() {
		return ihsWasAdminModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsWasAdminModule_UserFile() {
		return (EAttribute)ihsWasAdminModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsWasAdminModuleUnit() {
		return ihsWasAdminModuleUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsWasModule() {
		return ihsWasModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsWasModule_ConfigFile() {
		return (EAttribute)ihsWasModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsWasModuleUnit() {
		return ihsWasModuleUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxIhsSystem() {
		return linuxIhsSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsIhsSystem() {
		return windowsIhsSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIHSServerPortNames() {
		return ihsServerPortNamesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIHSServerPortNamesObject() {
		return ihsServerPortNamesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsFactory getIhsFactory() {
		return (IhsFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ihsDeployRootEClass = createEClass(IHS_DEPLOY_ROOT);
		createEAttribute(ihsDeployRootEClass, IHS_DEPLOY_ROOT__MIXED);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT);
		createEReference(ihsDeployRootEClass, IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT);

		ihsModuleEClass = createEClass(IHS_MODULE);
		createEAttribute(ihsModuleEClass, IHS_MODULE__LOCATION);
		createEAttribute(ihsModuleEClass, IHS_MODULE__MODULE_NAME);

		ihsServerEClass = createEClass(IHS_SERVER);
		createEAttribute(ihsServerEClass, IHS_SERVER__CONFIG_FILE);
		createEAttribute(ihsServerEClass, IHS_SERVER__SECURE);

		ihsServerUnitEClass = createEClass(IHS_SERVER_UNIT);

		ihsSystemEClass = createEClass(IHS_SYSTEM);
		createEAttribute(ihsSystemEClass, IHS_SYSTEM__INSTALL_LOCATION);

		ihsSystemUnitEClass = createEClass(IHS_SYSTEM_UNIT);

		ihsUserEClass = createEClass(IHS_USER);

		ihsUserRepositoryEClass = createEClass(IHS_USER_REPOSITORY);
		createEAttribute(ihsUserRepositoryEClass, IHS_USER_REPOSITORY__PASSWORD_FILE);

		ihsUserUnitEClass = createEClass(IHS_USER_UNIT);

		ihsWasAdminModuleEClass = createEClass(IHS_WAS_ADMIN_MODULE);
		createEAttribute(ihsWasAdminModuleEClass, IHS_WAS_ADMIN_MODULE__USER_FILE);

		ihsWasAdminModuleUnitEClass = createEClass(IHS_WAS_ADMIN_MODULE_UNIT);

		ihsWasModuleEClass = createEClass(IHS_WAS_MODULE);
		createEAttribute(ihsWasModuleEClass, IHS_WAS_MODULE__CONFIG_FILE);

		ihsWasModuleUnitEClass = createEClass(IHS_WAS_MODULE_UNIT);

		linuxIhsSystemEClass = createEClass(LINUX_IHS_SYSTEM);

		windowsIhsSystemEClass = createEClass(WINDOWS_IHS_SYSTEM);

		// Create enums
		ihsServerPortNamesEEnum = createEEnum(IHS_SERVER_PORT_NAMES);

		// Create data types
		ihsServerPortNamesObjectEDataType = createEDataType(IHS_SERVER_PORT_NAMES_OBJECT);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		HttpPackage theHttpPackage = (HttpPackage)EPackage.Registry.INSTANCE.getEPackage(HttpPackage.eNS_URI);

		// Add supertypes to classes
		ihsModuleEClass.getESuperTypes().add(theCorePackage.getCapability());
		ihsServerEClass.getESuperTypes().add(theHttpPackage.getHttpServer());
		ihsServerUnitEClass.getESuperTypes().add(theHttpPackage.getHttpServerUnit());
		ihsSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		ihsSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ihsUserEClass.getESuperTypes().add(theHttpPackage.getHttpUser());
		ihsUserRepositoryEClass.getESuperTypes().add(theCorePackage.getCapability());
		ihsUserUnitEClass.getESuperTypes().add(theHttpPackage.getHttpUserUnit());
		ihsWasAdminModuleEClass.getESuperTypes().add(this.getIhsModule());
		ihsWasAdminModuleUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ihsWasModuleEClass.getESuperTypes().add(this.getIhsModule());
		ihsWasModuleUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		linuxIhsSystemEClass.getESuperTypes().add(this.getIhsSystem());
		windowsIhsSystemEClass.getESuperTypes().add(this.getIhsSystem());

		// Initialize classes and features; add operations and parameters
		initEClass(ihsDeployRootEClass, IHSDeployRoot.class, "IHSDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIHSDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsModule(), this.getIhsModule(), null, "capabilityIhsModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsServer(), this.getIhsServer(), null, "capabilityIhsServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsSystem(), this.getIhsSystem(), null, "capabilityIhsSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsUser(), this.getIhsUser(), null, "capabilityIhsUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsUserRepository(), this.getIhsUserRepository(), null, "capabilityIhsUserRepository", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsWasAdminModule(), this.getIhsWasAdminModule(), null, "capabilityIhsWasAdminModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityIhsWasModule(), this.getIhsWasModule(), null, "capabilityIhsWasModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityLinuxIhsSystem(), this.getLinuxIhsSystem(), null, "capabilityLinuxIhsSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_CapabilityWindowsIhsSystem(), this.getWindowsIhsSystem(), null, "capabilityWindowsIhsSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_UnitIhsServerUnit(), this.getIhsServerUnit(), null, "unitIhsServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_UnitIhsSystemUnit(), this.getIhsSystemUnit(), null, "unitIhsSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_UnitIhsUserUnit(), this.getIhsUserUnit(), null, "unitIhsUserUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_UnitIhsWasAdminModuleUnit(), this.getIhsWasAdminModuleUnit(), null, "unitIhsWasAdminModuleUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIHSDeployRoot_UnitIhsWasModuleUnit(), this.getIhsWasModuleUnit(), null, "unitIhsWasModuleUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsModuleEClass, IhsModule.class, "IhsModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsModule_Location(), theXMLTypePackage.getString(), "location", null, 0, 1, IhsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIhsModule_ModuleName(), theXMLTypePackage.getString(), "moduleName", null, 0, 1, IhsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsServerEClass, IhsServer.class, "IhsServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsServer_ConfigFile(), theXMLTypePackage.getString(), "configFile", null, 0, 1, IhsServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIhsServer_Secure(), theXMLTypePackage.getBoolean(), "secure", null, 0, 1, IhsServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsServerUnitEClass, IhsServerUnit.class, "IhsServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ihsSystemEClass, IhsSystem.class, "IhsSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsSystem_InstallLocation(), theXMLTypePackage.getString(), "installLocation", null, 0, 1, IhsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsSystemUnitEClass, IhsSystemUnit.class, "IhsSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ihsUserEClass, IhsUser.class, "IhsUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ihsUserRepositoryEClass, IhsUserRepository.class, "IhsUserRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsUserRepository_PasswordFile(), theXMLTypePackage.getString(), "passwordFile", null, 0, 1, IhsUserRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsUserUnitEClass, IhsUserUnit.class, "IhsUserUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ihsWasAdminModuleEClass, IhsWasAdminModule.class, "IhsWasAdminModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsWasAdminModule_UserFile(), theXMLTypePackage.getString(), "userFile", null, 0, 1, IhsWasAdminModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsWasAdminModuleUnitEClass, IhsWasAdminModuleUnit.class, "IhsWasAdminModuleUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ihsWasModuleEClass, IhsWasModule.class, "IhsWasModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsWasModule_ConfigFile(), theXMLTypePackage.getString(), "configFile", null, 0, 1, IhsWasModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsWasModuleUnitEClass, IhsWasModuleUnit.class, "IhsWasModuleUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(linuxIhsSystemEClass, LinuxIhsSystem.class, "LinuxIhsSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsIhsSystemEClass, WindowsIhsSystem.class, "WindowsIhsSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(ihsServerPortNamesEEnum, IHSServerPortNames.class, "IHSServerPortNames"); //$NON-NLS-1$
		addEEnumLiteral(ihsServerPortNamesEEnum, IHSServerPortNames.HTTP_PORT_LITERAL);
		addEEnumLiteral(ihsServerPortNamesEEnum, IHSServerPortNames.ADMIN_PORT_LITERAL);

		// Initialize data types
		initEDataType(ihsServerPortNamesObjectEDataType, IHSServerPortNames.class, "IHSServerPortNamesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		addAnnotation
		  (ihsDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsModule(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsModule", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsSystem(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsUser(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsUser", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsUserRepository(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsUserRepository", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsWasAdminModule(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsWasAdminModule", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityIhsWasModule(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsWasModule", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityLinuxIhsSystem(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.linuxIhsSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_CapabilityWindowsIhsSystem(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.windowsIhsSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_UnitIhsServerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ihsServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_UnitIhsSystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ihsSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_UnitIhsUserUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ihsUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_UnitIhsWasAdminModuleUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ihsWasAdminModuleUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIHSDeployRoot_UnitIhsWasModuleUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ihsWasModuleUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsModuleEClass, 
		   source, 
		   new String[] {
			 "name", "IhsModule", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsModule_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "location" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsModule_ModuleName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "moduleName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsServerEClass, 
		   source, 
		   new String[] {
			 "name", "IhsServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsServer_ConfigFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsServer_Secure(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "secure" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsServerPortNamesEEnum, 
		   source, 
		   new String[] {
			 "name", "IHSServerPortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ihsServerPortNamesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "IHSServerPortNames:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "IHSServerPortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IhsServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsSystemEClass, 
		   source, 
		   new String[] {
			 "name", "IhsSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsSystem_InstallLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsSystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IhsSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsUserEClass, 
		   source, 
		   new String[] {
			 "name", "IhsUser", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsUserRepositoryEClass, 
		   source, 
		   new String[] {
			 "name", "IhsUserRepository", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getIhsUserRepository_PasswordFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "passwordFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsUserUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IhsUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsWasAdminModuleEClass, 
		   source, 
		   new String[] {
			 "name", "IhsWasAdminModule", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsWasAdminModule_UserFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsWasAdminModuleUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IhsWasAdminModuleUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsWasModuleEClass, 
		   source, 
		   new String[] {
			 "name", "IhsWasModule", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsWasModule_ConfigFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsWasModuleUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IhsWasModuleUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (linuxIhsSystemEClass, 
		   source, 
		   new String[] {
			 "name", "LinuxIhsSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (windowsIhsSystemEClass, 
		   source, 
		   new String[] {
			 "name", "WindowsIhsSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //IhsPackageImpl
