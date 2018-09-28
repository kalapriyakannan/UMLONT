/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2Package
 * @generated
 */
public interface WasDb2Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WasDb2Factory eINSTANCE = com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Datasource Satisfaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Datasource Satisfaction Constraint</em>'.
	 * @generated
	 */
	DatasourceSatisfactionConstraint createDatasourceSatisfactionConstraint();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	WasDb2DeployRoot createWasDb2DeployRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WasDb2Package getWasDb2Package();

} //WasDb2Factory
