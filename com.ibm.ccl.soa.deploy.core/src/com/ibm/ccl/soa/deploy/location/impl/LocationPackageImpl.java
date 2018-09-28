/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationBindingRoot;
import com.ibm.ccl.soa.deploy.location.LocationFactory;
import com.ibm.ccl.soa.deploy.location.LocationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class LocationPackageImpl extends EPackageImpl implements LocationPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationBindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationBindingRootEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LocationPackageImpl() {
		super(eNS_URI, LocationFactory.eINSTANCE);
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
	public static LocationPackage init() {
		if (isInited) return (LocationPackage)EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI);

		// Obtain or create and register package
		LocationPackageImpl theLocationPackage = (LocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof LocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new LocationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLocationPackage.createPackageContents();

		// Initialize created meta-data
		theLocationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLocationPackage.freeze();

		return theLocationPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingEntry() {
		return bindingEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingEntry_DmoPath() {
		return (EAttribute)bindingEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingEntry_Location() {
		return (EAttribute)bindingEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocationBinding() {
		return locationBindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocationBinding_BindingEntry() {
		return (EReference)locationBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocationBinding_Context() {
		return (EAttribute)locationBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocationBinding_Name() {
		return (EAttribute)locationBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocationBinding_Topology() {
		return (EAttribute)locationBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocationBindingRoot() {
		return locationBindingRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocationBindingRoot_Mixed() {
		return (EAttribute)locationBindingRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocationBindingRoot_XMLNSPrefixMap() {
		return (EReference)locationBindingRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocationBindingRoot_XSISchemaLocation() {
		return (EReference)locationBindingRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocationBindingRoot_BindingEntry() {
		return (EReference)locationBindingRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocationBindingRoot_LocationBinding() {
		return (EReference)locationBindingRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocationFactory getLocationFactory() {
		return (LocationFactory)getEFactoryInstance();
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
		bindingEntryEClass = createEClass(BINDING_ENTRY);
		createEAttribute(bindingEntryEClass, BINDING_ENTRY__DMO_PATH);
		createEAttribute(bindingEntryEClass, BINDING_ENTRY__LOCATION);

		locationBindingEClass = createEClass(LOCATION_BINDING);
		createEReference(locationBindingEClass, LOCATION_BINDING__BINDING_ENTRY);
		createEAttribute(locationBindingEClass, LOCATION_BINDING__CONTEXT);
		createEAttribute(locationBindingEClass, LOCATION_BINDING__NAME);
		createEAttribute(locationBindingEClass, LOCATION_BINDING__TOPOLOGY);

		locationBindingRootEClass = createEClass(LOCATION_BINDING_ROOT);
		createEAttribute(locationBindingRootEClass, LOCATION_BINDING_ROOT__MIXED);
		createEReference(locationBindingRootEClass, LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP);
		createEReference(locationBindingRootEClass, LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(locationBindingRootEClass, LOCATION_BINDING_ROOT__BINDING_ENTRY);
		createEReference(locationBindingRootEClass, LOCATION_BINDING_ROOT__LOCATION_BINDING);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(bindingEntryEClass, BindingEntry.class, "BindingEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBindingEntry_DmoPath(), theXMLTypePackage.getString(), "dmoPath", null, 1, 1, BindingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBindingEntry_Location(), theXMLTypePackage.getString(), "location", null, 1, 1, BindingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(locationBindingEClass, LocationBinding.class, "LocationBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLocationBinding_BindingEntry(), this.getBindingEntry(), null, "bindingEntry", null, 0, -1, LocationBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLocationBinding_Context(), theXMLTypePackage.getString(), "context", null, 0, 1, LocationBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLocationBinding_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, LocationBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLocationBinding_Topology(), theXMLTypePackage.getString(), "topology", null, 1, 1, LocationBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(locationBindingRootEClass, LocationBindingRoot.class, "LocationBindingRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLocationBindingRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLocationBindingRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLocationBindingRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLocationBindingRoot_BindingEntry(), this.getBindingEntry(), null, "bindingEntry", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLocationBindingRoot_LocationBinding(), this.getLocationBinding(), null, "locationBinding", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

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
		  (bindingEntryEClass, 
		   source, 
		   new String[] {
			 "name", "BindingEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBindingEntry_DmoPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dmoPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBindingEntry_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "location" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (locationBindingEClass, 
		   source, 
		   new String[] {
			 "name", "LocationBinding", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBinding_BindingEntry(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bindingEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBinding_Context(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "context" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBinding_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBinding_Topology(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "topology" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (locationBindingRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBindingRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBindingRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBindingRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBindingRoot_BindingEntry(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bindingEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLocationBindingRoot_LocationBinding(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "locationBinding", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //LocationPackageImpl
