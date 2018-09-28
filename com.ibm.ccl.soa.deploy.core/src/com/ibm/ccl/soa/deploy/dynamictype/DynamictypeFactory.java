/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage
 * @generated
 */
public interface DynamictypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DynamictypeFactory eINSTANCE = com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dynamic Palette Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Palette Entry</em>'.
	 * @generated
	 */
	DynamicPaletteEntry createDynamicPaletteEntry();

	/**
	 * Returns a new object of class '<em>Dynamic Palette Stack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Palette Stack</em>'.
	 * @generated
	 */
	DynamicPaletteStack createDynamicPaletteStack();

	/**
	 * Returns a new object of class '<em>Dynamic Type Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Type Root</em>'.
	 * @generated
	 */
	DynamicTypeRoot createDynamicTypeRoot();

	/**
	 * Returns a new object of class '<em>Dynamic Types</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Types</em>'.
	 * @generated
	 */
	DynamicTypes createDynamicTypes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DynamictypePackage getDynamictypePackage();

} //DynamictypeFactory
