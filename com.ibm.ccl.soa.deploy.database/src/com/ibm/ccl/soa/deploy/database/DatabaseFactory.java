/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage
 * @generated
 */
public interface DatabaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DatabaseFactory eINSTANCE = com.ibm.ccl.soa.deploy.database.impl.DatabaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Database</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Database</em>'.
	 * @generated
	 */
	Database createDatabase();

	/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	DatabaseComponent createDatabaseComponent();

	/**
	 * Returns a new object of class '<em>Definition</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Definition</em>'.
	 * @generated
	 */
	DatabaseDefinition createDatabaseDefinition();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	DatabaseDeployRoot createDatabaseDeployRoot();

	/**
	 * Returns a new object of class '<em>Instance</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Instance</em>'.
	 * @generated
	 */
	DatabaseInstance createDatabaseInstance();

	/**
	 * Returns a new object of class '<em>Instance Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Instance Unit</em>'.
	 * @generated
	 */
	DatabaseInstanceUnit createDatabaseInstanceUnit();

	/**
	 * Returns a new object of class '<em>Unit</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Unit</em>'.
	 * @generated
	 */
	DatabaseUnit createDatabaseUnit();

	/**
	 * Returns a new object of class '<em>DDL Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DDL Artifact</em>'.
	 * @generated
	 */
	DDLArtifact createDDLArtifact();

	/**
	 * Returns a new object of class '<em>DDL Interface</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DDL Interface</em>'.
	 * @generated
	 */
	DDLInterface createDDLInterface();

	/**
	 * Returns a new object of class '<em>DML Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DML Artifact</em>'.
	 * @generated
	 */
	DMLArtifact createDMLArtifact();

	/**
	 * Returns a new object of class '<em>SQL Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>SQL Module</em>'.
	 * @generated
	 */
	SQLModule createSQLModule();

	/**
	 * Returns a new object of class '<em>SQL User</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>SQL User</em>'.
	 * @generated
	 */
	SQLUser createSQLUser();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DatabasePackage getDatabasePackage();

} //DatabaseFactory
