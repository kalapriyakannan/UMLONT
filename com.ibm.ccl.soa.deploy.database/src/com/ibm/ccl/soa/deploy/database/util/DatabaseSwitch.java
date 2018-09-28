/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.database.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DDLInterface;
import com.ibm.ccl.soa.deploy.database.DMLArtifact;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabaseComponent;
import com.ibm.ccl.soa.deploy.database.DatabaseDefinition;
import com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot;
import com.ibm.ccl.soa.deploy.database.DatabaseInstance;
import com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.database.SQLUser;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage
 * @generated
 */
public class DatabaseSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static DatabasePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseSwitch() {
		if (modelPackage == null) {
			modelPackage = DatabasePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DatabasePackage.DATABASE: {
				Database database = (Database)theEObject;
				Object result = caseDatabase(database);
				if (result == null) result = caseCapability(database);
				if (result == null) result = caseDeployModelObject(database);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DATABASE_COMPONENT: {
				DatabaseComponent databaseComponent = (DatabaseComponent)theEObject;
				Object result = caseDatabaseComponent(databaseComponent);
				if (result == null) result = caseSoftwareComponent(databaseComponent);
				if (result == null) result = caseBaseComponentUnit(databaseComponent);
				if (result == null) result = caseUnit(databaseComponent);
				if (result == null) result = caseDeployModelObject(databaseComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DATABASE_DEFINITION: {
				DatabaseDefinition databaseDefinition = (DatabaseDefinition)theEObject;
				Object result = caseDatabaseDefinition(databaseDefinition);
				if (result == null) result = caseService(databaseDefinition);
				if (result == null) result = caseCapability(databaseDefinition);
				if (result == null) result = caseDeployModelObject(databaseDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DATABASE_DEPLOY_ROOT: {
				DatabaseDeployRoot databaseDeployRoot = (DatabaseDeployRoot)theEObject;
				Object result = caseDatabaseDeployRoot(databaseDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DATABASE_INSTANCE: {
				DatabaseInstance databaseInstance = (DatabaseInstance)theEObject;
				Object result = caseDatabaseInstance(databaseInstance);
				if (result == null) result = caseCapability(databaseInstance);
				if (result == null) result = caseDeployModelObject(databaseInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DATABASE_INSTANCE_UNIT: {
				DatabaseInstanceUnit databaseInstanceUnit = (DatabaseInstanceUnit)theEObject;
				Object result = caseDatabaseInstanceUnit(databaseInstanceUnit);
				if (result == null) result = caseUnit(databaseInstanceUnit);
				if (result == null) result = caseDeployModelObject(databaseInstanceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DATABASE_UNIT: {
				DatabaseUnit databaseUnit = (DatabaseUnit)theEObject;
				Object result = caseDatabaseUnit(databaseUnit);
				if (result == null) result = caseUnit(databaseUnit);
				if (result == null) result = caseDeployModelObject(databaseUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DDL_ARTIFACT: {
				DDLArtifact ddlArtifact = (DDLArtifact)theEObject;
				Object result = caseDDLArtifact(ddlArtifact);
				if (result == null) result = caseFileArtifact(ddlArtifact);
				if (result == null) result = caseArtifact(ddlArtifact);
				if (result == null) result = caseDeployModelObject(ddlArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DDL_INTERFACE: {
				DDLInterface ddlInterface = (DDLInterface)theEObject;
				Object result = caseDDLInterface(ddlInterface);
				if (result == null) result = caseInterface(ddlInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.DML_ARTIFACT: {
				DMLArtifact dmlArtifact = (DMLArtifact)theEObject;
				Object result = caseDMLArtifact(dmlArtifact);
				if (result == null) result = caseFileArtifact(dmlArtifact);
				if (result == null) result = caseArtifact(dmlArtifact);
				if (result == null) result = caseDeployModelObject(dmlArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.SQL_MODULE: {
				SQLModule sqlModule = (SQLModule)theEObject;
				Object result = caseSQLModule(sqlModule);
				if (result == null) result = caseUnit(sqlModule);
				if (result == null) result = caseDeployModelObject(sqlModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatabasePackage.SQL_USER: {
				SQLUser sqlUser = (SQLUser)theEObject;
				Object result = caseSQLUser(sqlUser);
				if (result == null) result = caseCapability(sqlUser);
				if (result == null) result = caseDeployModelObject(sqlUser);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Database</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Database</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabase(Database object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabaseComponent(DatabaseComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabaseDefinition(DatabaseDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabaseDeployRoot(DatabaseDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Instance</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabaseInstance(DatabaseInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabaseInstanceUnit(DatabaseInstanceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDatabaseUnit(DatabaseUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DDL Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DDL Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDDLArtifact(DDLArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DDL Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DDL Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDDLInterface(DDLInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DML Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DML Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDMLArtifact(DMLArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SQL Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SQL Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSQLModule(SQLModule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>SQL User</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>SQL User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSQLUser(SQLUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBaseComponentUnit(BaseComponentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwareComponent(SoftwareComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Service</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Artifact</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArtifact(Artifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileArtifact(FileArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //DatabaseSwitch
