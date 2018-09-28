/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypeFactory;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DynamictypePackageImpl extends EPackageImpl implements DynamictypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicPaletteEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicPaletteStackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicTypeRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicTypesEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DynamictypePackageImpl() {
		super(eNS_URI, DynamictypeFactory.eINSTANCE);
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
	public static DynamictypePackage init() {
		if (isInited) return (DynamictypePackage)EPackage.Registry.INSTANCE.getEPackage(DynamictypePackage.eNS_URI);

		// Obtain or create and register package
		DynamictypePackageImpl theDynamictypePackage = (DynamictypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DynamictypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DynamictypePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDynamictypePackage.createPackageContents();

		// Initialize created meta-data
		theDynamictypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDynamictypePackage.freeze();

		return theDynamictypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicPaletteEntry() {
		return dynamicPaletteEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_Description() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_DiagramPath() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_Id() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_Kind() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_Label() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_LargeIcon() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_Path() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_SmallIcon() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteEntry_TemplateURI() {
		return (EAttribute)dynamicPaletteEntryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicPaletteStack() {
		return dynamicPaletteStackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteStack_Description() {
		return (EAttribute)dynamicPaletteStackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteStack_Icon() {
		return (EAttribute)dynamicPaletteStackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteStack_Id() {
		return (EAttribute)dynamicPaletteStackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicPaletteStack_Label() {
		return (EAttribute)dynamicPaletteStackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicTypeRoot() {
		return dynamicTypeRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicTypeRoot_Mixed() {
		return (EAttribute)dynamicTypeRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicTypeRoot_XMLNSPrefixMap() {
		return (EReference)dynamicTypeRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicTypeRoot_XSISchemaLocation() {
		return (EReference)dynamicTypeRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicTypeRoot_DynamicPaletteEntry() {
		return (EReference)dynamicTypeRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicTypeRoot_DynamicPaletteStack() {
		return (EReference)dynamicTypeRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicTypeRoot_DynamicTypes() {
		return (EReference)dynamicTypeRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicTypes() {
		return dynamicTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicTypes_PaletteEntries() {
		return (EReference)dynamicTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamictypeFactory getDynamictypeFactory() {
		return (DynamictypeFactory)getEFactoryInstance();
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
		dynamicPaletteEntryEClass = createEClass(DYNAMIC_PALETTE_ENTRY);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__DESCRIPTION);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__ID);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__KIND);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__LABEL);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__LARGE_ICON);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__PATH);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__SMALL_ICON);
		createEAttribute(dynamicPaletteEntryEClass, DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI);

		dynamicPaletteStackEClass = createEClass(DYNAMIC_PALETTE_STACK);
		createEAttribute(dynamicPaletteStackEClass, DYNAMIC_PALETTE_STACK__DESCRIPTION);
		createEAttribute(dynamicPaletteStackEClass, DYNAMIC_PALETTE_STACK__ICON);
		createEAttribute(dynamicPaletteStackEClass, DYNAMIC_PALETTE_STACK__ID);
		createEAttribute(dynamicPaletteStackEClass, DYNAMIC_PALETTE_STACK__LABEL);

		dynamicTypeRootEClass = createEClass(DYNAMIC_TYPE_ROOT);
		createEAttribute(dynamicTypeRootEClass, DYNAMIC_TYPE_ROOT__MIXED);
		createEReference(dynamicTypeRootEClass, DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP);
		createEReference(dynamicTypeRootEClass, DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(dynamicTypeRootEClass, DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY);
		createEReference(dynamicTypeRootEClass, DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK);
		createEReference(dynamicTypeRootEClass, DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES);

		dynamicTypesEClass = createEClass(DYNAMIC_TYPES);
		createEReference(dynamicTypesEClass, DYNAMIC_TYPES__PALETTE_ENTRIES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(dynamicPaletteEntryEClass, DynamicPaletteEntry.class, "DynamicPaletteEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_DiagramPath(), theXMLTypePackage.getString(), "diagramPath", null, 0, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_Kind(), theXMLTypePackage.getString(), "kind", null, 0, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_Label(), theXMLTypePackage.getString(), "label", null, 1, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_LargeIcon(), theXMLTypePackage.getString(), "largeIcon", null, 0, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_Path(), theXMLTypePackage.getString(), "path", null, 1, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_SmallIcon(), theXMLTypePackage.getString(), "smallIcon", null, 1, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteEntry_TemplateURI(), theXMLTypePackage.getString(), "templateURI", null, 0, 1, DynamicPaletteEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dynamicPaletteStackEClass, DynamicPaletteStack.class, "DynamicPaletteStack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteStack_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, DynamicPaletteStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteStack_Icon(), theXMLTypePackage.getString(), "icon", null, 1, 1, DynamicPaletteStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteStack_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, DynamicPaletteStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDynamicPaletteStack_Label(), theXMLTypePackage.getString(), "label", null, 1, 1, DynamicPaletteStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dynamicTypeRootEClass, DynamicTypeRoot.class, "DynamicTypeRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDynamicTypeRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDynamicTypeRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDynamicTypeRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDynamicTypeRoot_DynamicPaletteEntry(), this.getDynamicPaletteEntry(), null, "dynamicPaletteEntry", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDynamicTypeRoot_DynamicPaletteStack(), this.getDynamicPaletteStack(), null, "dynamicPaletteStack", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDynamicTypeRoot_DynamicTypes(), this.getDynamicTypes(), null, "dynamicTypes", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dynamicTypesEClass, DynamicTypes.class, "DynamicTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDynamicTypes_PaletteEntries(), this.getDynamicPaletteEntry(), null, "paletteEntries", null, 0, -1, DynamicTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

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
		  (dynamicPaletteEntryEClass, 
		   source, 
		   new String[] {
			 "name", "DynamicPaletteEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_DiagramPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "diagramPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_Kind(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "kind" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_Label(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "label" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_LargeIcon(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "largeIcon" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "path" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_SmallIcon(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "smallIcon" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteEntry_TemplateURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "templateURI" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (dynamicPaletteStackEClass, 
		   source, 
		   new String[] {
			 "name", "DynamicPaletteStack", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteStack_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteStack_Icon(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "icon" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteStack_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicPaletteStack_Label(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "label" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (dynamicTypeRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypeRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypeRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypeRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypeRoot_DynamicPaletteEntry(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dynamicPaletteEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypeRoot_DynamicPaletteStack(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dynamicPaletteStack", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypeRoot_DynamicTypes(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dynamicTypes", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (dynamicTypesEClass, 
		   source, 
		   new String[] {
			 "name", "DynamicTypes", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDynamicTypes_PaletteEntries(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dynamicPaletteEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //DynamictypePackageImpl
