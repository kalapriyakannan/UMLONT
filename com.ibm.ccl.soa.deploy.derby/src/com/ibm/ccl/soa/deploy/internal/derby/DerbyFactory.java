/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage
 * @generated
 */
public interface DerbyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DerbyFactory eINSTANCE = com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Database</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Database</em>'.
	 * @generated
	 */
	DerbyDatabase createDerbyDatabase();

	/**
	 * Returns a new object of class '<em>Database Instance Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Instance Unit</em>'.
	 * @generated
	 */
	DerbyDatabaseInstanceUnit createDerbyDatabaseInstanceUnit();

	/**
	 * Returns a new object of class '<em>Database Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Database Unit</em>'.
	 * @generated
	 */
	DerbyDatabaseUnit createDerbyDatabaseUnit();

	/**
	 * Returns a new object of class '<em>DDL Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DDL Artifact</em>'.
	 * @generated
	 */
	DerbyDDLArtifact createDerbyDDLArtifact();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	DerbyDeployRoot createDerbyDeployRoot();

	/**
	 * Returns a new object of class '<em>Instance</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Instance</em>'.
	 * @generated
	 */
	DerbyInstance createDerbyInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DerbyPackage getDerbyPackage();

} //DerbyFactory
