/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.location.LocationPackage
 * @generated
 */
public interface LocationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	LocationFactory eINSTANCE = com.ibm.ccl.soa.deploy.location.impl.LocationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Binding Entry</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Binding Entry</em>'.
	 * @generated
	 */
	BindingEntry createBindingEntry();

	/**
	 * Returns a new object of class '<em>Binding</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Binding</em>'.
	 * @generated
	 */
	LocationBinding createLocationBinding();

	/**
	 * Returns a new object of class '<em>Binding Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Binding Root</em>'.
	 * @generated
	 */
	LocationBindingRoot createLocationBindingRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LocationPackage getLocationPackage();

} //LocationFactory
