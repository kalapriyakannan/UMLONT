/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.http.HTTPDeployRoot;
import com.ibm.ccl.soa.deploy.http.HttpFactory;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.HttpServer;
import com.ibm.ccl.soa.deploy.http.HttpServerUnit;
import com.ibm.ccl.soa.deploy.http.HttpUser;
import com.ibm.ccl.soa.deploy.http.StaticWebComponent;
import com.ibm.ccl.soa.deploy.http.StaticWebComponentUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class HttpFactoryImpl extends EFactoryImpl implements HttpFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static HttpFactory init() {
		try {
			HttpFactory theHttpFactory = (HttpFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/http/1.0.0/"); //$NON-NLS-1$ 
			if (theHttpFactory != null) {
				return theHttpFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HttpFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HttpFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HttpPackage.HTTP_DEPLOY_ROOT: return createHTTPDeployRoot();
			case HttpPackage.HTTP_SERVER: return createHttpServer();
			case HttpPackage.HTTP_SERVER_UNIT: return createHttpServerUnit();
			case HttpPackage.HTTP_USER: return createHttpUser();
			case HttpPackage.STATIC_WEB_COMPONENT: return createStaticWebComponent();
			case HttpPackage.STATIC_WEB_COMPONENT_UNIT: return createStaticWebComponentUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPDeployRoot createHTTPDeployRoot() {
		HTTPDeployRootImpl httpDeployRoot = new HTTPDeployRootImpl();
		return httpDeployRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpServer createHttpServer() {
		HttpServerImpl httpServer = new HttpServerImpl();
		return httpServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpServerUnit createHttpServerUnit() {
		HttpServerUnitImpl httpServerUnit = new HttpServerUnitImpl();
		return httpServerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpUser createHttpUser() {
		HttpUserImpl httpUser = new HttpUserImpl();
		return httpUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticWebComponent createStaticWebComponent() {
		StaticWebComponentImpl staticWebComponent = new StaticWebComponentImpl();
		return staticWebComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticWebComponentUnit createStaticWebComponentUnit() {
		StaticWebComponentUnitImpl staticWebComponentUnit = new StaticWebComponentUnitImpl();
		return staticWebComponentUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HttpPackage getHttpPackage() {
		return (HttpPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static HttpPackage getPackage() {
		return HttpPackage.eINSTANCE;
	}

} //HttpFactoryImpl
