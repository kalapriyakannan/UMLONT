/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwarePackageImpl.java,v 1.3 2008/02/08 21:22:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareFactory;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstallUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatchUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericsoftwarePackageImpl extends EPackageImpl implements GenericsoftwarePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericsoftwareRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareInstallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareInstallUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwarePatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwarePatchUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GenericsoftwarePackageImpl() {
		super(eNS_URI, GenericsoftwareFactory.eINSTANCE);
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
	public static GenericsoftwarePackage init() {
		if (isInited) return (GenericsoftwarePackage)EPackage.Registry.INSTANCE.getEPackage(GenericsoftwarePackage.eNS_URI);

		// Obtain or create and register package
		GenericsoftwarePackageImpl theGenericsoftwarePackage = (GenericsoftwarePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof GenericsoftwarePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new GenericsoftwarePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGenericsoftwarePackage.createPackageContents();

		// Initialize created meta-data
		theGenericsoftwarePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGenericsoftwarePackage.freeze();

		return theGenericsoftwarePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericsoftwareRoot() {
		return genericsoftwareRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericsoftwareRoot_Mixed() {
		return (EAttribute)genericsoftwareRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_XMLNSPrefixMap() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_XSISchemaLocation() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_CapabilitySoftwareInstall() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_CapabilitySoftwarePatch() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_CapabilityVersion() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_UnitSoftwareInstallUnit() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericsoftwareRoot_UnitSoftwarePatchUnit() {
		return (EReference)genericsoftwareRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareInstall() {
		return softwareInstallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInstall_ExecutableName() {
		return (EAttribute)softwareInstallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInstall_InstallDate() {
		return (EAttribute)softwareInstallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInstall_InstalledLocation() {
		return (EAttribute)softwareInstallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInstall_ProductId() {
		return (EAttribute)softwareInstallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInstall_ProductName() {
		return (EAttribute)softwareInstallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareInstall_Publisher() {
		return (EAttribute)softwareInstallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareInstallUnit() {
		return softwareInstallUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwarePatch() {
		return softwarePatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwarePatch_InstallDate() {
		return (EAttribute)softwarePatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwarePatch_PatchID() {
		return (EAttribute)softwarePatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwarePatchUnit() {
		return softwarePatchUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersion() {
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_BuildLevel() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Level() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_MajorVersion() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Modifier() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Release() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_VersionString() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwareFactory getGenericsoftwareFactory() {
		return (GenericsoftwareFactory)getEFactoryInstance();
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
		genericsoftwareRootEClass = createEClass(GENERICSOFTWARE_ROOT);
		createEAttribute(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__MIXED);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__CAPABILITY_VERSION);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT);
		createEReference(genericsoftwareRootEClass, GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT);

		softwareInstallEClass = createEClass(SOFTWARE_INSTALL);
		createEAttribute(softwareInstallEClass, SOFTWARE_INSTALL__EXECUTABLE_NAME);
		createEAttribute(softwareInstallEClass, SOFTWARE_INSTALL__INSTALL_DATE);
		createEAttribute(softwareInstallEClass, SOFTWARE_INSTALL__INSTALLED_LOCATION);
		createEAttribute(softwareInstallEClass, SOFTWARE_INSTALL__PRODUCT_ID);
		createEAttribute(softwareInstallEClass, SOFTWARE_INSTALL__PRODUCT_NAME);
		createEAttribute(softwareInstallEClass, SOFTWARE_INSTALL__PUBLISHER);

		softwareInstallUnitEClass = createEClass(SOFTWARE_INSTALL_UNIT);

		softwarePatchEClass = createEClass(SOFTWARE_PATCH);
		createEAttribute(softwarePatchEClass, SOFTWARE_PATCH__INSTALL_DATE);
		createEAttribute(softwarePatchEClass, SOFTWARE_PATCH__PATCH_ID);

		softwarePatchUnitEClass = createEClass(SOFTWARE_PATCH_UNIT);

		versionEClass = createEClass(VERSION);
		createEAttribute(versionEClass, VERSION__BUILD_LEVEL);
		createEAttribute(versionEClass, VERSION__LEVEL);
		createEAttribute(versionEClass, VERSION__MAJOR_VERSION);
		createEAttribute(versionEClass, VERSION__MODIFIER);
		createEAttribute(versionEClass, VERSION__RELEASE);
		createEAttribute(versionEClass, VERSION__VERSION_STRING);
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
		softwareInstallEClass.getESuperTypes().add(theCorePackage.getCapability());
		softwareInstallUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		softwarePatchEClass.getESuperTypes().add(theCorePackage.getCapability());
		softwarePatchUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		versionEClass.getESuperTypes().add(theCorePackage.getCapability());

		// Initialize classes and features; add operations and parameters
		initEClass(genericsoftwareRootEClass, GenericsoftwareRoot.class, "GenericsoftwareRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getGenericsoftwareRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_CapabilitySoftwareInstall(), this.getSoftwareInstall(), null, "capabilitySoftwareInstall", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_CapabilitySoftwarePatch(), this.getSoftwarePatch(), null, "capabilitySoftwarePatch", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_CapabilityVersion(), this.getVersion(), null, "capabilityVersion", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_UnitSoftwareInstallUnit(), this.getSoftwareInstallUnit(), null, "unitSoftwareInstallUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGenericsoftwareRoot_UnitSoftwarePatchUnit(), this.getSoftwarePatchUnit(), null, "unitSoftwarePatchUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(softwareInstallEClass, SoftwareInstall.class, "SoftwareInstall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSoftwareInstall_ExecutableName(), theXMLTypePackage.getString(), "executableName", null, 0, 1, SoftwareInstall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSoftwareInstall_InstallDate(), theXMLTypePackage.getString(), "installDate", null, 0, 1, SoftwareInstall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSoftwareInstall_InstalledLocation(), theXMLTypePackage.getString(), "installedLocation", null, 0, 1, SoftwareInstall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSoftwareInstall_ProductId(), theXMLTypePackage.getString(), "productId", null, 0, 1, SoftwareInstall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSoftwareInstall_ProductName(), theXMLTypePackage.getString(), "productName", null, 0, 1, SoftwareInstall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSoftwareInstall_Publisher(), theXMLTypePackage.getString(), "publisher", null, 0, 1, SoftwareInstall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(softwareInstallUnitEClass, SoftwareInstallUnit.class, "SoftwareInstallUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(softwarePatchEClass, SoftwarePatch.class, "SoftwarePatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSoftwarePatch_InstallDate(), theXMLTypePackage.getString(), "installDate", null, 0, 1, SoftwarePatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSoftwarePatch_PatchID(), theXMLTypePackage.getString(), "patchID", null, 0, 1, SoftwarePatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(softwarePatchUnitEClass, SoftwarePatchUnit.class, "SoftwarePatchUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVersion_BuildLevel(), theXMLTypePackage.getString(), "buildLevel", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVersion_Level(), theXMLTypePackage.getInt(), "level", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVersion_MajorVersion(), theXMLTypePackage.getInt(), "majorVersion", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVersion_Modifier(), theXMLTypePackage.getInt(), "modifier", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVersion_Release(), theXMLTypePackage.getInt(), "release", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVersion_VersionString(), theXMLTypePackage.getString(), "versionString", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

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
		  (genericsoftwareRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_CapabilitySoftwareInstall(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.softwareInstall", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_CapabilitySoftwarePatch(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.softwarePatch", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_CapabilityVersion(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.version", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_UnitSoftwareInstallUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.softwareInstallUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericsoftwareRoot_UnitSoftwarePatchUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.softwarePatchUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (softwareInstallEClass, 
		   source, 
		   new String[] {
			 "name", "SoftwareInstall", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwareInstall_ExecutableName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "executableName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwareInstall_InstallDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installDate" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwareInstall_InstalledLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installedLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwareInstall_ProductId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProductId" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwareInstall_ProductName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "productName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwareInstall_Publisher(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "publisher" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (softwareInstallUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SoftwareInstallUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (softwarePatchEClass, 
		   source, 
		   new String[] {
			 "name", "SoftwarePatch", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwarePatch_InstallDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installDate" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getSoftwarePatch_PatchID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "patchID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (softwarePatchUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SoftwarePatchUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (versionEClass, 
		   source, 
		   new String[] {
			 "name", "Version", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVersion_BuildLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "buildLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVersion_Level(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "level" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVersion_MajorVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "majorVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVersion_Modifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "modifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVersion_Release(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "release" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVersion_VersionString(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "versionString" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //GenericsoftwarePackageImpl
