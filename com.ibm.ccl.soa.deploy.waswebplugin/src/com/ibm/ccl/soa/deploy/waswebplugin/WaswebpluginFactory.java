/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage
 * @generated
 */
public interface WaswebpluginFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	WaswebpluginFactory eINSTANCE = com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ihs Was Plugin</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ihs Was Plugin</em>'.
	 * @generated
	 */
	IhsWasPlugin createIhsWasPlugin();

	/**
	 * Returns a new object of class '<em>Ihs Was Plugin Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ihs Was Plugin Unit</em>'.
	 * @generated
	 */
	IhsWasPluginUnit createIhsWasPluginUnit();

	/**
	 * Returns a new object of class '<em>Was Web Plugin Deploy Root</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Was Web Plugin Deploy Root</em>'.
	 * @generated
	 */
	WasWebPluginDeployRoot createWasWebPluginDeployRoot();

	/**
	 * Returns a new object of class '<em>Was Web Server To Ihs Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Was Web Server To Ihs Constraint</em>'.
	 * @generated
	 */
	WasWebServerToIhsConstraint createWasWebServerToIhsConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WaswebpluginPackage getWaswebpluginPackage();

} //WaswebpluginFactory
