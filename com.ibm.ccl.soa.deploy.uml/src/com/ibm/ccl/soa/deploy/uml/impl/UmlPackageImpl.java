/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmlPackageImpl.java,v 1.13 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

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
import com.ibm.ccl.soa.deploy.uml.UMLActor;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UMLComponent;
import com.ibm.ccl.soa.deploy.uml.UMLDeployRoot;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UMLElementCapability;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UMLInterface;
import com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit;
import com.ibm.ccl.soa.deploy.uml.UMLPackageCap;
import com.ibm.ccl.soa.deploy.uml.UMLPackageUnit;
import com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlPackageImpl extends EPackageImpl implements UmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlActorUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlElementArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlElementCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInteractionConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInterfaceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlPackageCapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlPackageUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum umlVisibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType umlVisibilityKindObjectEDataType = null;

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
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlPackageImpl() {
		super(eNS_URI, UmlFactory.eINSTANCE);
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
	public static UmlPackage init() {
		if (isInited) return (UmlPackage)EPackage.Registry.INSTANCE.getEPackage(UmlPackage.eNS_URI);

		// Obtain or create and register package
		UmlPackageImpl theUmlPackage = (UmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlPackage.createPackageContents();

		// Initialize created meta-data
		theUmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlPackage.freeze();

		return theUmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLActor() {
		return umlActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLActor_Abstract() {
		return (EAttribute)umlActorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLActor_Leaf() {
		return (EAttribute)umlActorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLActorUnit() {
		return umlActorUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLComponent() {
		return umlComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLComponent_Abstract() {
		return (EAttribute)umlComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLComponent_Leaf() {
		return (EAttribute)umlComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLDeployRoot() {
		return umlDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLDeployRoot_Mixed() {
		return (EAttribute)umlDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_XMLNSPrefixMap() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_XSISchemaLocation() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_ArtifactUmlElement() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_CapabilityUmlActor() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_CapabilityUmlComponent() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_CapabilityUmlInterface() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_CapabilityUmlPackageCap() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_ConstraintUmlInteraction() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_UnitUmlActorUnit() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_UnitUmlInterfaceUnit() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUMLDeployRoot_UnitUmlPackageUnit() {
		return (EReference)umlDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLElementArtifact() {
		return umlElementArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLElementArtifact_QualifiedName() {
		return (EAttribute)umlElementArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLElementArtifact_ResourceURI() {
		return (EAttribute)umlElementArtifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLElementCapability() {
		return umlElementCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLElementCapability_UmlVisibilityKind() {
		return (EAttribute)umlElementCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInteractionConstraint() {
		return umlInteractionConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLInteractionConstraint_InteractionQName() {
		return (EAttribute)umlInteractionConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLInteractionConstraint_ResourceURI() {
		return (EAttribute)umlInteractionConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInterface() {
		return umlInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLInterface_Abstract() {
		return (EAttribute)umlInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLInterface_Leaf() {
		return (EAttribute)umlInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInterfaceUnit() {
		return umlInterfaceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLPackageCap() {
		return umlPackageCapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLPackageCap_Canonical() {
		return (EAttribute)umlPackageCapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLPackageUnit() {
		return umlPackageUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUMLVisibilityKind() {
		return umlVisibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUMLVisibilityKindObject() {
		return umlVisibilityKindObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlFactory getUmlFactory() {
		return (UmlFactory)getEFactoryInstance();
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
		umlActorEClass = createEClass(UML_ACTOR);
		createEAttribute(umlActorEClass, UML_ACTOR__ABSTRACT);
		createEAttribute(umlActorEClass, UML_ACTOR__LEAF);

		umlActorUnitEClass = createEClass(UML_ACTOR_UNIT);

		umlComponentEClass = createEClass(UML_COMPONENT);
		createEAttribute(umlComponentEClass, UML_COMPONENT__ABSTRACT);
		createEAttribute(umlComponentEClass, UML_COMPONENT__LEAF);

		umlDeployRootEClass = createEClass(UML_DEPLOY_ROOT);
		createEAttribute(umlDeployRootEClass, UML_DEPLOY_ROOT__MIXED);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT);
		createEReference(umlDeployRootEClass, UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT);

		umlElementArtifactEClass = createEClass(UML_ELEMENT_ARTIFACT);
		createEAttribute(umlElementArtifactEClass, UML_ELEMENT_ARTIFACT__QUALIFIED_NAME);
		createEAttribute(umlElementArtifactEClass, UML_ELEMENT_ARTIFACT__RESOURCE_URI);

		umlElementCapabilityEClass = createEClass(UML_ELEMENT_CAPABILITY);
		createEAttribute(umlElementCapabilityEClass, UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND);

		umlInteractionConstraintEClass = createEClass(UML_INTERACTION_CONSTRAINT);
		createEAttribute(umlInteractionConstraintEClass, UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME);
		createEAttribute(umlInteractionConstraintEClass, UML_INTERACTION_CONSTRAINT__RESOURCE_URI);

		umlInterfaceEClass = createEClass(UML_INTERFACE);
		createEAttribute(umlInterfaceEClass, UML_INTERFACE__ABSTRACT);
		createEAttribute(umlInterfaceEClass, UML_INTERFACE__LEAF);

		umlInterfaceUnitEClass = createEClass(UML_INTERFACE_UNIT);

		umlPackageCapEClass = createEClass(UML_PACKAGE_CAP);
		createEAttribute(umlPackageCapEClass, UML_PACKAGE_CAP__CANONICAL);

		umlPackageUnitEClass = createEClass(UML_PACKAGE_UNIT);

		// Create enums
		umlVisibilityKindEEnum = createEEnum(UML_VISIBILITY_KIND);

		// Create data types
		umlVisibilityKindObjectEDataType = createEDataType(UML_VISIBILITY_KIND_OBJECT);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Add supertypes to classes
		umlActorEClass.getESuperTypes().add(this.getUMLElementCapability());
		umlActorUnitEClass.getESuperTypes().add(theCorePackage.getBaseComponentUnit());
		umlComponentEClass.getESuperTypes().add(this.getUMLElementCapability());
		umlElementArtifactEClass.getESuperTypes().add(theCorePackage.getArtifact());
		umlElementCapabilityEClass.getESuperTypes().add(theCorePackage.getBundleCapability());
		umlInteractionConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		umlInterfaceEClass.getESuperTypes().add(this.getUMLElementCapability());
		umlInterfaceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		umlPackageCapEClass.getESuperTypes().add(this.getUMLElementCapability());
		umlPackageUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(umlActorEClass, UMLActor.class, "UMLActor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLActor_Abstract(), theXMLTypePackage.getBoolean(), "abstract", "false", 0, 1, UMLActor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUMLActor_Leaf(), theXMLTypePackage.getBoolean(), "leaf", "false", 0, 1, UMLActor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(umlActorUnitEClass, UMLActorUnit.class, "UMLActorUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(umlComponentEClass, UMLComponent.class, "UMLComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLComponent_Abstract(), theXMLTypePackage.getBoolean(), "abstract", "false", 0, 1, UMLComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUMLComponent_Leaf(), theXMLTypePackage.getBoolean(), "leaf", "false", 0, 1, UMLComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(umlDeployRootEClass, UMLDeployRoot.class, "UMLDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_ArtifactUmlElement(), this.getUMLElementArtifact(), null, "artifactUmlElement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_CapabilityUmlActor(), this.getUMLActor(), null, "capabilityUmlActor", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_CapabilityUmlComponent(), this.getUMLComponent(), null, "capabilityUmlComponent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_CapabilityUmlInterface(), this.getUMLInterface(), null, "capabilityUmlInterface", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_CapabilityUmlPackageCap(), this.getUMLPackageCap(), null, "capabilityUmlPackageCap", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_ConstraintUmlInteraction(), this.getUMLInteractionConstraint(), null, "constraintUmlInteraction", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_UnitUmlActorUnit(), this.getUMLActorUnit(), null, "unitUmlActorUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_UnitUmlInterfaceUnit(), this.getUMLInterfaceUnit(), null, "unitUmlInterfaceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUMLDeployRoot_UnitUmlPackageUnit(), this.getUMLPackageUnit(), null, "unitUmlPackageUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(umlElementArtifactEClass, UMLElementArtifact.class, "UMLElementArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLElementArtifact_QualifiedName(), theXMLTypePackage.getString(), "qualifiedName", null, 0, 1, UMLElementArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUMLElementArtifact_ResourceURI(), theXMLTypePackage.getString(), "resourceURI", null, 0, 1, UMLElementArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(umlElementCapabilityEClass, UMLElementCapability.class, "UMLElementCapability", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLElementCapability_UmlVisibilityKind(), this.getUMLVisibilityKind(), "umlVisibilityKind", "public", 0, 1, UMLElementCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(umlInteractionConstraintEClass, UMLInteractionConstraint.class, "UMLInteractionConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLInteractionConstraint_InteractionQName(), theXMLTypePackage.getString(), "interactionQName", null, 0, 1, UMLInteractionConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUMLInteractionConstraint_ResourceURI(), theXMLTypePackage.getString(), "resourceURI", null, 0, 1, UMLInteractionConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(umlInterfaceEClass, UMLInterface.class, "UMLInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLInterface_Abstract(), theXMLTypePackage.getBoolean(), "abstract", "false", 0, 1, UMLInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUMLInterface_Leaf(), theXMLTypePackage.getBoolean(), "leaf", "false", 0, 1, UMLInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(umlInterfaceUnitEClass, UMLInterfaceUnit.class, "UMLInterfaceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(umlPackageCapEClass, UMLPackageCap.class, "UMLPackageCap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUMLPackageCap_Canonical(), theXMLTypePackage.getBoolean(), "canonical", "false", 0, 1, UMLPackageCap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(umlPackageUnitEClass, UMLPackageUnit.class, "UMLPackageUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(umlVisibilityKindEEnum, UMLVisibilityKind.class, "UMLVisibilityKind"); //$NON-NLS-1$
		addEEnumLiteral(umlVisibilityKindEEnum, UMLVisibilityKind.PUBLIC_LITERAL);
		addEEnumLiteral(umlVisibilityKindEEnum, UMLVisibilityKind.PROTECTED_LITERAL);
		addEEnumLiteral(umlVisibilityKindEEnum, UMLVisibilityKind.PRIVATE_LITERAL);
		addEEnumLiteral(umlVisibilityKindEEnum, UMLVisibilityKind.PACKAGE_LITERAL);
		addEEnumLiteral(umlVisibilityKindEEnum, UMLVisibilityKind.UNDEFINED_LITERAL);

		// Initialize data types
		initEDataType(umlVisibilityKindObjectEDataType, UMLVisibilityKind.class, "UMLVisibilityKindObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		  (umlActorEClass, 
		   source, 
		   new String[] {
			 "name", "UMLActor", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLActor_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "abstract" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLActor_Leaf(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "leaf" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (umlActorUnitEClass, 
		   source, 
		   new String[] {
			 "name", "UMLActorUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlComponentEClass, 
		   source, 
		   new String[] {
			 "name", "UMLComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLComponent_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "abstract" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLComponent_Leaf(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "leaf" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (umlDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_ArtifactUmlElement(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "artifact.umlElement", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_CapabilityUmlActor(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.umlActor", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_CapabilityUmlComponent(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.umlComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_CapabilityUmlInterface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.umlInterface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_CapabilityUmlPackageCap(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.umlPackageCap", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLDeployRoot_ConstraintUmlInteraction(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.umlInteraction", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUMLDeployRoot_UnitUmlActorUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.umlActorUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#baseComponent" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUMLDeployRoot_UnitUmlInterfaceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.umlInterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUMLDeployRoot_UnitUmlPackageUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.umlPackageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlElementArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "UMLElementArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLElementArtifact_QualifiedName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "qualifiedName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLElementArtifact_ResourceURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "resourceURI" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlElementCapabilityEClass, 
		   source, 
		   new String[] {
			 "name", "UMLElementCapability", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLElementCapability_UmlVisibilityKind(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "umlVisibilityKind" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlInteractionConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "UMLInteractionConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLInteractionConstraint_InteractionQName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interactionQName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLInteractionConstraint_ResourceURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "resourceURI" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "UMLInterface", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLInterface_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "abstract" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLInterface_Leaf(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "leaf" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (umlInterfaceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "UMLInterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlPackageCapEClass, 
		   source, 
		   new String[] {
			 "name", "UMLPackageCap", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUMLPackageCap_Canonical(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "canonical" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (umlPackageUnitEClass, 
		   source, 
		   new String[] {
			 "name", "UMLPackageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (umlVisibilityKindEEnum, 
		   source, 
		   new String[] {
			 "name", "UMLVisibilityKind" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (umlVisibilityKindObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "UMLVisibilityKind:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "UMLVisibilityKind" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //UmlPackageImpl
