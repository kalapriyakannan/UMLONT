/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.http.HttpPackage
 * @generated
 */
public interface HttpFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	HttpFactory eINSTANCE = com.ibm.ccl.soa.deploy.http.impl.HttpFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>HTTP Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>HTTP Deploy Root</em>'.
	 * @generated
	 */
	HTTPDeployRoot createHTTPDeployRoot();

	/**
	 * Returns a new object of class '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	HttpServer createHttpServer();

	/**
	 * Returns a new object of class '<em>Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Unit</em>'.
	 * @generated
	 */
	HttpServerUnit createHttpServerUnit();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	HttpUser createHttpUser();

	/**
	 * Returns a new object of class '<em>Static Web Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Web Component</em>'.
	 * @generated
	 */
	StaticWebComponent createStaticWebComponent();

	/**
	 * Returns a new object of class '<em>Static Web Component Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Web Component Unit</em>'.
	 * @generated
	 */
	StaticWebComponentUnit createStaticWebComponentUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HttpPackage getHttpPackage();

} //HttpFactory
