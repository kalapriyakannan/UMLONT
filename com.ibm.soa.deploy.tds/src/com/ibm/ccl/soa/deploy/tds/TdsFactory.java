/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.tds.TdsPackage
 * @generated
 */
public interface TdsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TdsFactory eINSTANCE = com.ibm.ccl.soa.deploy.tds.impl.TdsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Base System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base System</em>'.
	 * @generated
	 */
	TdsBaseSystem createTdsBaseSystem();

	/**
	 * Returns a new object of class '<em>Base System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base System Unit</em>'.
	 * @generated
	 */
	TdsBaseSystemUnit createTdsBaseSystemUnit();

	/**
	 * Returns a new object of class '<em>TDS Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TDS Root</em>'.
	 * @generated
	 */
	TDSRoot createTDSRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TdsPackage getTdsPackage();

} //TdsFactory
