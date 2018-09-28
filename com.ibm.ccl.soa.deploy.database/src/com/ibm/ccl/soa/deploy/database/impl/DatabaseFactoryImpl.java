/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.database.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DDLInterface;
import com.ibm.ccl.soa.deploy.database.DMLArtifact;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabaseComponent;
import com.ibm.ccl.soa.deploy.database.DatabaseDefinition;
import com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.DatabaseInstance;
import com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.database.SQLUser;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class DatabaseFactoryImpl extends EFactoryImpl implements DatabaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DatabaseFactory init() {
		try {
			DatabaseFactory theDatabaseFactory = (DatabaseFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/database/1.0.0/"); //$NON-NLS-1$ 
			if (theDatabaseFactory != null) {
				return theDatabaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DatabaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DatabasePackage.DATABASE: return createDatabase();
			case DatabasePackage.DATABASE_COMPONENT: return createDatabaseComponent();
			case DatabasePackage.DATABASE_DEFINITION: return createDatabaseDefinition();
			case DatabasePackage.DATABASE_DEPLOY_ROOT: return createDatabaseDeployRoot();
			case DatabasePackage.DATABASE_INSTANCE: return createDatabaseInstance();
			case DatabasePackage.DATABASE_INSTANCE_UNIT: return createDatabaseInstanceUnit();
			case DatabasePackage.DATABASE_UNIT: return createDatabaseUnit();
			case DatabasePackage.DDL_ARTIFACT: return createDDLArtifact();
			case DatabasePackage.DDL_INTERFACE: return createDDLInterface();
			case DatabasePackage.DML_ARTIFACT: return createDMLArtifact();
			case DatabasePackage.SQL_MODULE: return createSQLModule();
			case DatabasePackage.SQL_USER: return createSQLUser();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Database createDatabase() {
		DatabaseImpl database = new DatabaseImpl();
		return database;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseComponent createDatabaseComponent() {
		DatabaseComponentImpl databaseComponent = new DatabaseComponentImpl();
		return databaseComponent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseDefinition createDatabaseDefinition() {
		DatabaseDefinitionImpl databaseDefinition = new DatabaseDefinitionImpl();
		return databaseDefinition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseDeployRoot createDatabaseDeployRoot() {
		DatabaseDeployRootImpl databaseDeployRoot = new DatabaseDeployRootImpl();
		return databaseDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInstance createDatabaseInstance() {
		DatabaseInstanceImpl databaseInstance = new DatabaseInstanceImpl();
		return databaseInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInstanceUnit createDatabaseInstanceUnit() {
		DatabaseInstanceUnitImpl databaseInstanceUnit = new DatabaseInstanceUnitImpl();
		return databaseInstanceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseUnit createDatabaseUnit() {
		DatabaseUnitImpl databaseUnit = new DatabaseUnitImpl();
		return databaseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DDLArtifact createDDLArtifact() {
		DDLArtifactImpl ddlArtifact = new DDLArtifactImpl();
		return ddlArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DDLInterface createDDLInterface() {
		DDLInterfaceImpl ddlInterface = new DDLInterfaceImpl();
		return ddlInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DMLArtifact createDMLArtifact() {
		DMLArtifactImpl dmlArtifact = new DMLArtifactImpl();
		return dmlArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SQLModule createSQLModule() {
		SQLModuleImpl sqlModule = new SQLModuleImpl();
		return sqlModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SQLUser createSQLUser() {
		SQLUserImpl sqlUser = new SQLUserImpl();
		return sqlUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabasePackage getDatabasePackage() {
		return (DatabasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static DatabasePackage getPackage() {
		return DatabasePackage.eINSTANCE;
	}

} //DatabaseFactoryImpl
