/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage
 * @generated
 */
public interface JavaFactory extends EFactory {
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
	JavaFactory eINSTANCE = com.ibm.ccl.soa.deploy.java.impl.JavaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	JavaDeployRoot createJavaDeployRoot();

	/**
	 * Returns a new object of class '<em>Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Jdbc Provider</em>'.
	 * @generated
	 */
	JdbcProvider createJdbcProvider();

	/**
	 * Returns a new object of class '<em>Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Jdbc Provider Unit</em>'.
	 * @generated
	 */
	JdbcProviderUnit createJdbcProviderUnit();

	/**
	 * Returns a new object of class '<em>JDK</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>JDK</em>'.
	 * @generated
	 */
	JDK createJDK();

	/**
	 * Returns a new object of class '<em>JDK Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JDK Unit</em>'.
	 * @generated
	 */
	JDKUnit createJDKUnit();

	/**
	 * Returns a new object of class '<em>JRE</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>JRE</em>'.
	 * @generated
	 */
	JRE createJRE();

	/**
	 * Returns a new object of class '<em>JRE Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JRE Unit</em>'.
	 * @generated
	 */
	JREUnit createJREUnit();

	/**
	 * Returns a new object of class '<em>JVM Config</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JVM Config</em>'.
	 * @generated
	 */
	JVMConfig createJVMConfig();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavaPackage getJavaPackage();

} //JavaFactory
