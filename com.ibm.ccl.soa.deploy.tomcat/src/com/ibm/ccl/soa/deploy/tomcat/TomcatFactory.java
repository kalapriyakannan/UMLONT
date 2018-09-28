/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage
 * @generated
 */
public interface TomcatFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	TomcatFactory eINSTANCE = com.ibm.ccl.soa.deploy.tomcat.impl.TomcatFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tomcat50 Datasource</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Tomcat50 Datasource</em>'.
	 * @generated
	 */
	Tomcat50Datasource createTomcat50Datasource();

	/**
	 * Returns a new object of class '<em>Datasource Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Datasource Unit</em>'.
	 * @generated
	 */
	TomcatDatasourceUnit createTomcatDatasourceUnit();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	TomcatDeployRoot createTomcatDeployRoot();

	/**
	 * Returns a new object of class '<em>Server</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	TomcatServer createTomcatServer();

	/**
	 * Returns a new object of class '<em>Web Server Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web Server Unit</em>'.
	 * @generated
	 */
	TomcatWebServerUnit createTomcatWebServerUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TomcatPackage getTomcatPackage();

} //TomcatFactory
