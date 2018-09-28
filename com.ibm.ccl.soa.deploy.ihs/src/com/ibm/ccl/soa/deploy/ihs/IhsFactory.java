/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage
 * @generated
 */
public interface IhsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IhsFactory eINSTANCE = com.ibm.ccl.soa.deploy.ihs.impl.IhsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>IHS Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>IHS Deploy Root</em>'.
	 * @generated
	 */
	IHSDeployRoot createIHSDeployRoot();

	/**
	 * Returns a new object of class '<em>Module</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	IhsModule createIhsModule();

	/**
	 * Returns a new object of class '<em>Server</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	IhsServer createIhsServer();

	/**
	 * Returns a new object of class '<em>Server Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Server Unit</em>'.
	 * @generated
	 */
	IhsServerUnit createIhsServerUnit();

	/**
	 * Returns a new object of class '<em>System</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	IhsSystem createIhsSystem();

	/**
	 * Returns a new object of class '<em>System Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>System Unit</em>'.
	 * @generated
	 */
	IhsSystemUnit createIhsSystemUnit();

	/**
	 * Returns a new object of class '<em>User</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	IhsUser createIhsUser();

	/**
	 * Returns a new object of class '<em>User Repository</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>User Repository</em>'.
	 * @generated
	 */
	IhsUserRepository createIhsUserRepository();

	/**
	 * Returns a new object of class '<em>User Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>User Unit</em>'.
	 * @generated
	 */
	IhsUserUnit createIhsUserUnit();

	/**
	 * Returns a new object of class '<em>Was Admin Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Was Admin Module</em>'.
	 * @generated
	 */
	IhsWasAdminModule createIhsWasAdminModule();

	/**
	 * Returns a new object of class '<em>Was Admin Module Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Was Admin Module Unit</em>'.
	 * @generated
	 */
	IhsWasAdminModuleUnit createIhsWasAdminModuleUnit();

	/**
	 * Returns a new object of class '<em>Was Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Was Module</em>'.
	 * @generated
	 */
	IhsWasModule createIhsWasModule();

	/**
	 * Returns a new object of class '<em>Was Module Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Was Module Unit</em>'.
	 * @generated
	 */
	IhsWasModuleUnit createIhsWasModuleUnit();

	/**
	 * Returns a new object of class '<em>Linux Ihs System</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Linux Ihs System</em>'.
	 * @generated
	 */
	LinuxIhsSystem createLinuxIhsSystem();

	/**
	 * Returns a new object of class '<em>Windows Ihs System</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Windows Ihs System</em>'.
	 * @generated
	 */
	WindowsIhsSystem createWindowsIhsSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IhsPackage getIhsPackage();

} //IhsFactory
