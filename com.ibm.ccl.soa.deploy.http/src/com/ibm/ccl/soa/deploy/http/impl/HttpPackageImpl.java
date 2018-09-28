/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.http.HTTPDeployRoot;
import com.ibm.ccl.soa.deploy.http.HttpFactory;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.HttpServer;
import com.ibm.ccl.soa.deploy.http.HttpServerUnit;
import com.ibm.ccl.soa.deploy.http.HttpUser;
import com.ibm.ccl.soa.deploy.http.HttpUserUnit;
import com.ibm.ccl.soa.deploy.http.StaticWebComponent;
import com.ibm.ccl.soa.deploy.http.StaticWebComponentUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class HttpPackageImpl extends EPackageImpl implements HttpPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpUserUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticWebComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticWebComponentUnitEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HttpPackageImpl() {
		super(eNS_URI, HttpFactory.eINSTANCE);
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
	public static HttpPackage init() {
		if (isInited) return (HttpPackage)EPackage.Registry.INSTANCE.getEPackage(HttpPackage.eNS_URI);

		// Obtain or create and register package
		HttpPackageImpl theHttpPackage = (HttpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof HttpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new HttpPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theHttpPackage.createPackageContents();

		// Initialize created meta-data
		theHttpPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHttpPackage.freeze();

		return theHttpPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHTTPDeployRoot() {
		return httpDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPDeployRoot_Mixed() {
		return (EAttribute)httpDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_XMLNSPrefixMap() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_XSISchemaLocation() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_CapabilityHttpServer() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_CapabilityHttpUser() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_CapabilityStaticWebComponent() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_ComponentStaticWeb() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_UnitHttpServerUnit() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPDeployRoot_UnitHttpUserUnit() {
		return (EReference)httpDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHttpServer() {
		return httpServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHttpServerUnit() {
		return httpServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHttpUser() {
		return httpUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHttpUser_UserId() {
		return (EAttribute)httpUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHttpUser_UserPassword() {
		return (EAttribute)httpUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHttpUserUnit() {
		return httpUserUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticWebComponent() {
		return staticWebComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticWebComponentUnit() {
		return staticWebComponentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HttpFactory getHttpFactory() {
		return (HttpFactory)getEFactoryInstance();
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
		httpDeployRootEClass = createEClass(HTTP_DEPLOY_ROOT);
		createEAttribute(httpDeployRootEClass, HTTP_DEPLOY_ROOT__MIXED);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT);
		createEReference(httpDeployRootEClass, HTTP_DEPLOY_ROOT__UNIT_HTTP_USER_UNIT);

		httpServerEClass = createEClass(HTTP_SERVER);

		httpServerUnitEClass = createEClass(HTTP_SERVER_UNIT);

		httpUserEClass = createEClass(HTTP_USER);
		createEAttribute(httpUserEClass, HTTP_USER__USER_ID);
		createEAttribute(httpUserEClass, HTTP_USER__USER_PASSWORD);

		httpUserUnitEClass = createEClass(HTTP_USER_UNIT);

		staticWebComponentEClass = createEClass(STATIC_WEB_COMPONENT);

		staticWebComponentUnitEClass = createEClass(STATIC_WEB_COMPONENT_UNIT);
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
		httpServerEClass.getESuperTypes().add(theCorePackage.getCapability());
		httpServerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		httpUserEClass.getESuperTypes().add(theCorePackage.getCapability());
		httpUserUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		staticWebComponentEClass.getESuperTypes().add(theCorePackage.getBundleCapability());
		staticWebComponentUnitEClass.getESuperTypes().add(theCorePackage.getSoftwareComponent());

		// Initialize classes and features; add operations and parameters
		initEClass(httpDeployRootEClass, HTTPDeployRoot.class, "HTTPDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getHTTPDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_CapabilityHttpServer(), this.getHttpServer(), null, "capabilityHttpServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_CapabilityHttpUser(), this.getHttpUser(), null, "capabilityHttpUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_CapabilityStaticWebComponent(), this.getStaticWebComponent(), null, "capabilityStaticWebComponent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_ComponentStaticWeb(), this.getStaticWebComponentUnit(), null, "componentStaticWeb", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_UnitHttpServerUnit(), this.getHttpServerUnit(), null, "unitHttpServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getHTTPDeployRoot_UnitHttpUserUnit(), this.getHttpUserUnit(), null, "unitHttpUserUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(httpServerEClass, HttpServer.class, "HttpServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(httpServerUnitEClass, HttpServerUnit.class, "HttpServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(httpUserEClass, HttpUser.class, "HttpUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getHttpUser_UserId(), theXMLTypePackage.getString(), "userId", null, 0, 1, HttpUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getHttpUser_UserPassword(), theXMLTypePackage.getString(), "userPassword", null, 0, 1, HttpUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(httpUserUnitEClass, HttpUserUnit.class, "HttpUserUnit", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(staticWebComponentEClass, StaticWebComponent.class, "StaticWebComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(staticWebComponentUnitEClass, StaticWebComponentUnit.class, "StaticWebComponentUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		  (httpDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_CapabilityHttpServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.httpServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_CapabilityHttpUser(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.httpUser", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_CapabilityStaticWebComponent(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.staticWebComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_ComponentStaticWeb(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "component.staticWeb", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_UnitHttpServerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.httpServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHTTPDeployRoot_UnitHttpUserUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.httpUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (httpServerEClass, 
		   source, 
		   new String[] {
			 "name", "HttpServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (httpServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "HttpServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (httpUserEClass, 
		   source, 
		   new String[] {
			 "name", "HttpUser", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getHttpUser_UserId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userId" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getHttpUser_UserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (httpUserUnitEClass, 
		   source, 
		   new String[] {
			 "name", "HttpUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (staticWebComponentEClass, 
		   source, 
		   new String[] {
			 "name", "StaticWebComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (staticWebComponentUnitEClass, 
		   source, 
		   new String[] {
			 "name", "StaticWebComponentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //HttpPackageImpl
