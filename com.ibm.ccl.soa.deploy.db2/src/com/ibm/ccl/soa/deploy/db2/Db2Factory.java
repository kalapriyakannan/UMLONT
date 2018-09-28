/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package
 * @generated
 */
public interface Db2Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	Db2Factory eINSTANCE = com.ibm.ccl.soa.deploy.db2.impl.Db2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>DB2 Admin Client</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Admin Client</em>'.
	 * @generated
	 */
	DB2AdminClient createDB2AdminClient();

	/**
	 * Returns a new object of class '<em>DB2 Admin Client Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Admin Client Unit</em>'.
	 * @generated
	 */
	DB2AdminClientUnit createDB2AdminClientUnit();

	/**
	 * Returns a new object of class '<em>DB2 Admin Server</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Admin Server</em>'.
	 * @generated
	 */
	DB2AdminServer createDB2AdminServer();

	/**
	 * Returns a new object of class '<em>DB2 Admin Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Admin Server Unit</em>'.
	 * @generated
	 */
	DB2AdminServerUnit createDB2AdminServerUnit();

	/**
	 * Returns a new object of class '<em>DB2 App Devel Client</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 App Devel Client</em>'.
	 * @generated
	 */
	DB2AppDevelClient createDB2AppDevelClient();

	/**
	 * Returns a new object of class '<em>DB2 App Devel Client Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 App Devel Client Unit</em>'.
	 * @generated
	 */
	DB2AppDevelClientUnit createDB2AppDevelClientUnit();

	/**
	 * Returns a new object of class '<em>DB2 Base Client Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Base Client Unit</em>'.
	 * @generated
	 */
	DB2BaseClientUnit createDB2BaseClientUnit();

	/**
	 * Returns a new object of class '<em>DB2 Base Instance</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Base Instance</em>'.
	 * @generated
	 */
	DB2BaseInstance createDB2BaseInstance();

	/**
	 * Returns a new object of class '<em>DB2 Cataloged Node</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Cataloged Node</em>'.
	 * @generated
	 */
	DB2CatalogedNode createDB2CatalogedNode();

	/**
	 * Returns a new object of class '<em>DB2 Catalog Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Catalog Unit</em>'.
	 * @generated
	 */
	DB2CatalogUnit createDB2CatalogUnit();

	/**
	 * Returns a new object of class '<em>DB2 Client</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Client</em>'.
	 * @generated
	 */
	DB2Client createDB2Client();

	/**
	 * Returns a new object of class '<em>DB2 Client Instance</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Client Instance</em>'.
	 * @generated
	 */
	DB2ClientInstance createDB2ClientInstance();

	/**
	 * Returns a new object of class '<em>DB2 Client Instance Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Client Instance Unit</em>'.
	 * @generated
	 */
	DB2ClientInstanceUnit createDB2ClientInstanceUnit();

	/**
	 * Returns a new object of class '<em>DB2 Database</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Database</em>'.
	 * @generated
	 */
	DB2Database createDB2Database();

	/**
	 * Returns a new object of class '<em>DB2 Database Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Database Unit</em>'.
	 * @generated
	 */
	DB2DatabaseUnit createDB2DatabaseUnit();

	/**
	 * Returns a new object of class '<em>DB2DDL Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2DDL Artifact</em>'.
	 * @generated
	 */
	DB2DDLArtifact createDB2DDLArtifact();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	Db2DeployRoot createDb2DeployRoot();

	/**
	 * Returns a new object of class '<em>DB2 Instance</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Instance</em>'.
	 * @generated
	 */
	DB2Instance createDB2Instance();

	/**
	 * Returns a new object of class '<em>DB2 Instance Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Instance Unit</em>'.
	 * @generated
	 */
	DB2InstanceUnit createDB2InstanceUnit();

	/**
	 * Returns a new object of class '<em>DB2 Jdbc Driver</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Jdbc Driver</em>'.
	 * @generated
	 */
	DB2JdbcDriver createDB2JdbcDriver();

	/**
	 * Returns a new object of class '<em>DB2 Node Catalog Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Node Catalog Unit</em>'.
	 * @generated
	 */
	DB2NodeCatalogUnit createDB2NodeCatalogUnit();

	/**
	 * Returns a new object of class '<em>DB2 Runtime Client Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Runtime Client Unit</em>'.
	 * @generated
	 */
	DB2RuntimeClientUnit createDB2RuntimeClientUnit();

	/**
	 * Returns a new object of class '<em>DB2 System</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 System</em>'.
	 * @generated
	 */
	DB2System createDB2System();

	/**
	 * Returns a new object of class '<em>DB2 System Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 System Unit</em>'.
	 * @generated
	 */
	DB2SystemUnit createDB2SystemUnit();

	/**
	 * Returns a new object of class '<em>Unix DB2 Admin Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unix DB2 Admin Server</em>'.
	 * @generated
	 */
	UnixDB2AdminServer createUnixDB2AdminServer();

	/**
	 * Returns a new object of class '<em>Unix DB2 Client Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unix DB2 Client Instance</em>'.
	 * @generated
	 */
	UnixDB2ClientInstance createUnixDB2ClientInstance();

	/**
	 * Returns a new object of class '<em>Unix DB2 Instance</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Unix DB2 Instance</em>'.
	 * @generated
	 */
	UnixDB2Instance createUnixDB2Instance();

	/**
	 * Returns a new object of class '<em>Unix DB2 System</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Unix DB2 System</em>'.
	 * @generated
	 */
	UnixDB2System createUnixDB2System();

	/**
	 * Returns a new object of class '<em>Windows DB2 Admin Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows DB2 Admin Server</em>'.
	 * @generated
	 */
	WindowsDB2AdminServer createWindowsDB2AdminServer();

	/**
	 * Returns a new object of class '<em>Windows DB2 Client Instance</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows DB2 Client Instance</em>'.
	 * @generated
	 */
	WindowsDB2ClientInstance createWindowsDB2ClientInstance();

	/**
	 * Returns a new object of class '<em>Windows DB2 Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows DB2 Instance</em>'.
	 * @generated
	 */
	WindowsDB2Instance createWindowsDB2Instance();

	/**
	 * Returns a new object of class '<em>Windows DB2 System</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Windows DB2 System</em>'.
	 * @generated
	 */
	WindowsDB2System createWindowsDB2System();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Db2Package getDb2Package();

} //Db2Factory
