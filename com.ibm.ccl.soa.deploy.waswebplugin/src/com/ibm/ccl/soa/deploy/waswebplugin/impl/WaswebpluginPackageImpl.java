/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginFactory;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class WaswebpluginPackageImpl extends EPackageImpl implements WaswebpluginPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsWasPluginEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ihsWasPluginUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebPluginDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebServerToIhsConstraintEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WaswebpluginPackageImpl() {
		super(eNS_URI, WaswebpluginFactory.eINSTANCE);
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
	public static WaswebpluginPackage init() {
		if (isInited) return (WaswebpluginPackage)EPackage.Registry.INSTANCE.getEPackage(WaswebpluginPackage.eNS_URI);

		// Obtain or create and register package
		WaswebpluginPackageImpl theWaswebpluginPackage = (WaswebpluginPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WaswebpluginPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WaswebpluginPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConstraintPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWaswebpluginPackage.createPackageContents();

		// Initialize created meta-data
		theWaswebpluginPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWaswebpluginPackage.freeze();

		return theWaswebpluginPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsWasPlugin() {
		return ihsWasPluginEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIhsWasPlugin_InstallLocation() {
		return (EAttribute)ihsWasPluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIhsWasPluginUnit() {
		return ihsWasPluginUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebPluginDeployRoot() {
		return wasWebPluginDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebPluginDeployRoot_Mixed() {
		return (EAttribute)wasWebPluginDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasWebPluginDeployRoot_XMLNSPrefixMap() {
		return (EReference)wasWebPluginDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasWebPluginDeployRoot_XSISchemaLocation() {
		return (EReference)wasWebPluginDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasWebPluginDeployRoot_CapabilityIhsWasPlugin() {
		return (EReference)wasWebPluginDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasWebPluginDeployRoot_ConstraintWasWebServerToIhsConstraint() {
		return (EReference)wasWebPluginDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasWebPluginDeployRoot_UnitIhsWasPluginUnit() {
		return (EReference)wasWebPluginDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebServerToIhsConstraint() {
		return wasWebServerToIhsConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WaswebpluginFactory getWaswebpluginFactory() {
		return (WaswebpluginFactory)getEFactoryInstance();
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
		ihsWasPluginEClass = createEClass(IHS_WAS_PLUGIN);
		createEAttribute(ihsWasPluginEClass, IHS_WAS_PLUGIN__INSTALL_LOCATION);

		ihsWasPluginUnitEClass = createEClass(IHS_WAS_PLUGIN_UNIT);

		wasWebPluginDeployRootEClass = createEClass(WAS_WEB_PLUGIN_DEPLOY_ROOT);
		createEAttribute(wasWebPluginDeployRootEClass, WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED);
		createEReference(wasWebPluginDeployRootEClass, WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(wasWebPluginDeployRootEClass, WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(wasWebPluginDeployRootEClass, WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN);
		createEReference(wasWebPluginDeployRootEClass, WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT);
		createEReference(wasWebPluginDeployRootEClass, WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT);

		wasWebServerToIhsConstraintEClass = createEClass(WAS_WEB_SERVER_TO_IHS_CONSTRAINT);
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

		// Add supertypes to classes
		ihsWasPluginEClass.getESuperTypes().add(theCorePackage.getCapability());
		ihsWasPluginUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasWebServerToIhsConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());

		// Initialize classes and features; add operations and parameters
		initEClass(ihsWasPluginEClass, IhsWasPlugin.class, "IhsWasPlugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIhsWasPlugin_InstallLocation(), theXMLTypePackage.getString(), "installLocation", null, 0, 1, IhsWasPlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ihsWasPluginUnitEClass, IhsWasPluginUnit.class, "IhsWasPluginUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasWebPluginDeployRootEClass, WasWebPluginDeployRoot.class, "WasWebPluginDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasWebPluginDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasWebPluginDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasWebPluginDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasWebPluginDeployRoot_CapabilityIhsWasPlugin(), this.getIhsWasPlugin(), null, "capabilityIhsWasPlugin", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasWebPluginDeployRoot_ConstraintWasWebServerToIhsConstraint(), this.getWasWebServerToIhsConstraint(), null, "constraintWasWebServerToIhsConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasWebPluginDeployRoot_UnitIhsWasPluginUnit(), this.getIhsWasPluginUnit(), null, "unitIhsWasPluginUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasWebServerToIhsConstraintEClass, WasWebServerToIhsConstraint.class, "WasWebServerToIhsConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		  (ihsWasPluginEClass, 
		   source, 
		   new String[] {
			 "name", "IhsWasPlugin", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getIhsWasPlugin_InstallLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ihsWasPluginUnitEClass, 
		   source, 
		   new String[] {
			 "name", "IhsWasPluginUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasWebPluginDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebPluginDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebPluginDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebPluginDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebPluginDeployRoot_CapabilityIhsWasPlugin(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ihsWasPlugin", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebPluginDeployRoot_ConstraintWasWebServerToIhsConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.WasWebServerToIhsConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebPluginDeployRoot_UnitIhsWasPluginUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ihsWasPluginUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerToIhsConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasWebServerToIhsConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //WaswebpluginPackageImpl
