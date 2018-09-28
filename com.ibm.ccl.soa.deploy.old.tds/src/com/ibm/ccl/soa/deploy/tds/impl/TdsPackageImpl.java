/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.tds.TDSRoot;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystem;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.tds.TdsFactory;
import com.ibm.ccl.soa.deploy.tds.TdsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TdsPackageImpl extends EPackageImpl implements TdsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tdsBaseSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tdsBaseSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tdsRootEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.tds.TdsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TdsPackageImpl() {
		super(eNS_URI, TdsFactory.eINSTANCE);
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
	public static TdsPackage init() {
		if (isInited) return (TdsPackage)EPackage.Registry.INSTANCE.getEPackage(TdsPackage.eNS_URI);

		// Obtain or create and register package
		TdsPackageImpl theTdsPackage = (TdsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TdsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TdsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTdsPackage.createPackageContents();

		// Initialize created meta-data
		theTdsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTdsPackage.freeze();

		return theTdsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTdsBaseSystem() {
		return tdsBaseSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTdsBaseSystem_InstallLocation() {
		return (EAttribute)tdsBaseSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTdsBaseSystem_Version() {
		return (EAttribute)tdsBaseSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTdsBaseSystem_Wonderful() {
		return (EAttribute)tdsBaseSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTdsBaseSystemUnit() {
		return tdsBaseSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDSRoot() {
		return tdsRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDSRoot_Mixed() {
		return (EAttribute)tdsRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDSRoot_XMLNSPrefixMap() {
		return (EReference)tdsRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDSRoot_XSISchemaLocation() {
		return (EReference)tdsRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDSRoot_CapabilityTdsBaseSystem() {
		return (EReference)tdsRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDSRoot_UnitTdsBaseSystemUnit() {
		return (EReference)tdsRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsFactory getTdsFactory() {
		return (TdsFactory)getEFactoryInstance();
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
		tdsBaseSystemEClass = createEClass(TDS_BASE_SYSTEM);
		createEAttribute(tdsBaseSystemEClass, TDS_BASE_SYSTEM__INSTALL_LOCATION);
		createEAttribute(tdsBaseSystemEClass, TDS_BASE_SYSTEM__VERSION);
		createEAttribute(tdsBaseSystemEClass, TDS_BASE_SYSTEM__WONDERFUL);

		tdsBaseSystemUnitEClass = createEClass(TDS_BASE_SYSTEM_UNIT);

		tdsRootEClass = createEClass(TDS_ROOT);
		createEAttribute(tdsRootEClass, TDS_ROOT__MIXED);
		createEReference(tdsRootEClass, TDS_ROOT__XMLNS_PREFIX_MAP);
		createEReference(tdsRootEClass, TDS_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(tdsRootEClass, TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM);
		createEReference(tdsRootEClass, TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tdsBaseSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		tdsBaseSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(tdsBaseSystemEClass, TdsBaseSystem.class, "TdsBaseSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTdsBaseSystem_InstallLocation(), theXMLTypePackage.getString(), "installLocation", null, 0, 1, TdsBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTdsBaseSystem_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, TdsBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTdsBaseSystem_Wonderful(), theXMLTypePackage.getString(), "wonderful", null, 0, 1, TdsBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tdsBaseSystemUnitEClass, TdsBaseSystemUnit.class, "TdsBaseSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tdsRootEClass, TDSRoot.class, "TDSRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDSRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDSRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDSRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDSRoot_CapabilityTdsBaseSystem(), this.getTdsBaseSystem(), null, "capabilityTdsBaseSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDSRoot_UnitTdsBaseSystemUnit(), this.getTdsBaseSystemUnit(), null, "unitTdsBaseSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (tdsBaseSystemEClass, 
		   source, 
		   new String[] {
			 "name", "TdsBaseSystem",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTdsBaseSystem_InstallLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "installLocation"
		   });		
		addAnnotation
		  (getTdsBaseSystem_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "version"
		   });		
		addAnnotation
		  (getTdsBaseSystem_Wonderful(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "wonderful"
		   });			
		addAnnotation
		  (tdsBaseSystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "TdsBaseSystemUnit",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (tdsRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTDSRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTDSRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getTDSRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getTDSRoot_CapabilityTdsBaseSystem(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "capability.tdsBaseSystem",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability"
		   });		
		addAnnotation
		  (getTDSRoot_UnitTdsBaseSystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "unit.tdsBaseSystemUnit",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit"
		   });
	}

} //TdsPackageImpl
