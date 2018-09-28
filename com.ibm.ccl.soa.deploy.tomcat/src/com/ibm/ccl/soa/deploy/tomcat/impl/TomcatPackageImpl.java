/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class TomcatPackageImpl extends EPackageImpl implements TomcatPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tomcat50DatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tomcatDatasourceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tomcatDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tomcatServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tomcatWebServerUnitEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TomcatPackageImpl() {
		super(eNS_URI, TomcatFactory.eINSTANCE);
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
	public static TomcatPackage init() {
		if (isInited) return (TomcatPackage)EPackage.Registry.INSTANCE.getEPackage(TomcatPackage.eNS_URI);

		// Obtain or create and register package
		TomcatPackageImpl theTomcatPackage = (TomcatPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TomcatPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TomcatPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		J2eePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTomcatPackage.createPackageContents();

		// Initialize created meta-data
		theTomcatPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTomcatPackage.freeze();

		return theTomcatPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTomcat50Datasource() {
		return tomcat50DatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTomcat50Datasource_ClientJarLocation() {
		return (EAttribute)tomcat50DatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTomcat50Datasource_DriverClassName() {
		return (EAttribute)tomcat50DatasourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTomcat50Datasource_Factory() {
		return (EAttribute)tomcat50DatasourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTomcat50Datasource_Url() {
		return (EAttribute)tomcat50DatasourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTomcatDatasourceUnit() {
		return tomcatDatasourceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTomcatDeployRoot() {
		return tomcatDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTomcatDeployRoot_Mixed() {
		return (EAttribute)tomcatDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTomcatDeployRoot_XMLNSPrefixMap() {
		return (EReference)tomcatDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTomcatDeployRoot_XSISchemaLocation() {
		return (EReference)tomcatDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTomcatDeployRoot_CapabilityTomcat50datasource() {
		return (EReference)tomcatDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTomcatDeployRoot_CapabilityTomcatServer() {
		return (EReference)tomcatDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTomcatDeployRoot_UnitTomcatdatasource() {
		return (EReference)tomcatDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTomcatDeployRoot_UnitTomcatWebServer() {
		return (EReference)tomcatDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTomcatServer() {
		return tomcatServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTomcatServer_TomcatVersion() {
		return (EAttribute)tomcatServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTomcatWebServerUnit() {
		return tomcatWebServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatFactory getTomcatFactory() {
		return (TomcatFactory)getEFactoryInstance();
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
		tomcat50DatasourceEClass = createEClass(TOMCAT50_DATASOURCE);
		createEAttribute(tomcat50DatasourceEClass, TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION);
		createEAttribute(tomcat50DatasourceEClass, TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME);
		createEAttribute(tomcat50DatasourceEClass, TOMCAT50_DATASOURCE__FACTORY);
		createEAttribute(tomcat50DatasourceEClass, TOMCAT50_DATASOURCE__URL);

		tomcatDatasourceUnitEClass = createEClass(TOMCAT_DATASOURCE_UNIT);

		tomcatDeployRootEClass = createEClass(TOMCAT_DEPLOY_ROOT);
		createEAttribute(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__MIXED);
		createEReference(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE);
		createEReference(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER);
		createEReference(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE);
		createEReference(tomcatDeployRootEClass, TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER);

		tomcatServerEClass = createEClass(TOMCAT_SERVER);
		createEAttribute(tomcatServerEClass, TOMCAT_SERVER__TOMCAT_VERSION);

		tomcatWebServerUnitEClass = createEClass(TOMCAT_WEB_SERVER_UNIT);
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
		J2eePackage theJ2eePackage = (J2eePackage)EPackage.Registry.INSTANCE.getEPackage(J2eePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Add supertypes to classes
		tomcat50DatasourceEClass.getESuperTypes().add(theJ2eePackage.getJ2EEDatasource());
		tomcatDatasourceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		tomcatServerEClass.getESuperTypes().add(theJ2eePackage.getJ2EEServer());
		tomcatWebServerUnitEClass.getESuperTypes().add(theJ2eePackage.getJ2EEServerUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(tomcat50DatasourceEClass, Tomcat50Datasource.class, "Tomcat50Datasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTomcat50Datasource_ClientJarLocation(), theXMLTypePackage.getString(), "clientJarLocation", null, 0, 1, Tomcat50Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTomcat50Datasource_DriverClassName(), theXMLTypePackage.getString(), "driverClassName", null, 0, 1, Tomcat50Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTomcat50Datasource_Factory(), theXMLTypePackage.getString(), "factory", "org.apache.commons.dbcp.BasicDataSourceFactory", 0, 1, Tomcat50Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getTomcat50Datasource_Url(), theXMLTypePackage.getString(), "url", null, 0, 1, Tomcat50Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tomcatDatasourceUnitEClass, TomcatDatasourceUnit.class, "TomcatDatasourceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(tomcatDeployRootEClass, TomcatDeployRoot.class, "TomcatDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTomcatDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTomcatDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTomcatDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTomcatDeployRoot_CapabilityTomcat50datasource(), this.getTomcat50Datasource(), null, "capabilityTomcat50datasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTomcatDeployRoot_CapabilityTomcatServer(), this.getTomcatServer(), null, "capabilityTomcatServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTomcatDeployRoot_UnitTomcatdatasource(), this.getTomcatDatasourceUnit(), null, "unitTomcatdatasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTomcatDeployRoot_UnitTomcatWebServer(), this.getTomcatWebServerUnit(), null, "unitTomcatWebServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tomcatServerEClass, TomcatServer.class, "TomcatServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTomcatServer_TomcatVersion(), theXMLTypePackage.getString(), "tomcatVersion", null, 0, 1, TomcatServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tomcatWebServerUnitEClass, TomcatWebServerUnit.class, "TomcatWebServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		  (tomcat50DatasourceEClass, 
		   source, 
		   new String[] {
			 "name", "Tomcat50Datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcat50Datasource_ClientJarLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clientJarLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcat50Datasource_DriverClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "driverClassName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcat50Datasource_Factory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "factory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcat50Datasource_Url(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "url" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (tomcatDatasourceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "TomcatDatasourceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (tomcatDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_CapabilityTomcat50datasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.tomcat50datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_CapabilityTomcatServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.tomcatServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_UnitTomcatdatasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.tomcatdatasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatDeployRoot_UnitTomcatWebServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.tomcatWebServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (tomcatServerEClass, 
		   source, 
		   new String[] {
			 "name", "TomcatServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTomcatServer_TomcatVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "tomcatVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (tomcatWebServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "TomcatWebServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //TomcatPackageImpl
