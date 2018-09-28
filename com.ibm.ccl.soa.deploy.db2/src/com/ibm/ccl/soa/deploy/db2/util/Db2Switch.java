/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabaseInstance;
import com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClient;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseInstance;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2DeployRoot;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.UnixDB2Instance;
import com.ibm.ccl.soa.deploy.db2.UnixDB2System;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2System;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package
 * @generated
 */
public class Db2Switch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static Db2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Db2Switch() {
		if (modelPackage == null) {
			modelPackage = Db2Package.eINSTANCE;
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
			case Db2Package.DB2_ADMIN_CLIENT: {
				DB2AdminClient db2AdminClient = (DB2AdminClient)theEObject;
				Object result = caseDB2AdminClient(db2AdminClient);
				if (result == null) result = caseDB2Client(db2AdminClient);
				if (result == null) result = caseCapability(db2AdminClient);
				if (result == null) result = caseDeployModelObject(db2AdminClient);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_ADMIN_CLIENT_UNIT: {
				DB2AdminClientUnit db2AdminClientUnit = (DB2AdminClientUnit)theEObject;
				Object result = caseDB2AdminClientUnit(db2AdminClientUnit);
				if (result == null) result = caseDB2BaseClientUnit(db2AdminClientUnit);
				if (result == null) result = caseUnit(db2AdminClientUnit);
				if (result == null) result = caseDeployModelObject(db2AdminClientUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_ADMIN_SERVER: {
				DB2AdminServer db2AdminServer = (DB2AdminServer)theEObject;
				Object result = caseDB2AdminServer(db2AdminServer);
				if (result == null) result = caseCapability(db2AdminServer);
				if (result == null) result = caseDeployModelObject(db2AdminServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_ADMIN_SERVER_UNIT: {
				DB2AdminServerUnit db2AdminServerUnit = (DB2AdminServerUnit)theEObject;
				Object result = caseDB2AdminServerUnit(db2AdminServerUnit);
				if (result == null) result = caseUnit(db2AdminServerUnit);
				if (result == null) result = caseDeployModelObject(db2AdminServerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_APP_DEVEL_CLIENT: {
				DB2AppDevelClient db2AppDevelClient = (DB2AppDevelClient)theEObject;
				Object result = caseDB2AppDevelClient(db2AppDevelClient);
				if (result == null) result = caseDB2Client(db2AppDevelClient);
				if (result == null) result = caseCapability(db2AppDevelClient);
				if (result == null) result = caseDeployModelObject(db2AppDevelClient);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_APP_DEVEL_CLIENT_UNIT: {
				DB2AppDevelClientUnit db2AppDevelClientUnit = (DB2AppDevelClientUnit)theEObject;
				Object result = caseDB2AppDevelClientUnit(db2AppDevelClientUnit);
				if (result == null) result = caseDB2BaseClientUnit(db2AppDevelClientUnit);
				if (result == null) result = caseUnit(db2AppDevelClientUnit);
				if (result == null) result = caseDeployModelObject(db2AppDevelClientUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_BASE_CLIENT_UNIT: {
				DB2BaseClientUnit db2BaseClientUnit = (DB2BaseClientUnit)theEObject;
				Object result = caseDB2BaseClientUnit(db2BaseClientUnit);
				if (result == null) result = caseUnit(db2BaseClientUnit);
				if (result == null) result = caseDeployModelObject(db2BaseClientUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_BASE_INSTANCE: {
				DB2BaseInstance db2BaseInstance = (DB2BaseInstance)theEObject;
				Object result = caseDB2BaseInstance(db2BaseInstance);
				if (result == null) result = caseDatabaseInstance(db2BaseInstance);
				if (result == null) result = caseCapability(db2BaseInstance);
				if (result == null) result = caseDeployModelObject(db2BaseInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_CATALOGED_NODE: {
				DB2CatalogedNode db2CatalogedNode = (DB2CatalogedNode)theEObject;
				Object result = caseDB2CatalogedNode(db2CatalogedNode);
				if (result == null) result = caseCapability(db2CatalogedNode);
				if (result == null) result = caseDeployModelObject(db2CatalogedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_CATALOG_UNIT: {
				DB2CatalogUnit db2CatalogUnit = (DB2CatalogUnit)theEObject;
				Object result = caseDB2CatalogUnit(db2CatalogUnit);
				if (result == null) result = caseUnit(db2CatalogUnit);
				if (result == null) result = caseDeployModelObject(db2CatalogUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_CLIENT: {
				DB2Client db2Client = (DB2Client)theEObject;
				Object result = caseDB2Client(db2Client);
				if (result == null) result = caseCapability(db2Client);
				if (result == null) result = caseDeployModelObject(db2Client);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_CLIENT_INSTANCE: {
				DB2ClientInstance db2ClientInstance = (DB2ClientInstance)theEObject;
				Object result = caseDB2ClientInstance(db2ClientInstance);
				if (result == null) result = caseDB2BaseInstance(db2ClientInstance);
				if (result == null) result = caseDatabaseInstance(db2ClientInstance);
				if (result == null) result = caseCapability(db2ClientInstance);
				if (result == null) result = caseDeployModelObject(db2ClientInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_CLIENT_INSTANCE_UNIT: {
				DB2ClientInstanceUnit db2ClientInstanceUnit = (DB2ClientInstanceUnit)theEObject;
				Object result = caseDB2ClientInstanceUnit(db2ClientInstanceUnit);
				if (result == null) result = caseUnit(db2ClientInstanceUnit);
				if (result == null) result = caseDeployModelObject(db2ClientInstanceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_DATABASE: {
				DB2Database db2Database = (DB2Database)theEObject;
				Object result = caseDB2Database(db2Database);
				if (result == null) result = caseDatabase(db2Database);
				if (result == null) result = caseCapability(db2Database);
				if (result == null) result = caseDeployModelObject(db2Database);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_DATABASE_UNIT: {
				DB2DatabaseUnit db2DatabaseUnit = (DB2DatabaseUnit)theEObject;
				Object result = caseDB2DatabaseUnit(db2DatabaseUnit);
				if (result == null) result = caseDatabaseUnit(db2DatabaseUnit);
				if (result == null) result = caseUnit(db2DatabaseUnit);
				if (result == null) result = caseDeployModelObject(db2DatabaseUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2DDL_ARTIFACT: {
				DB2DDLArtifact db2DDLArtifact = (DB2DDLArtifact)theEObject;
				Object result = caseDB2DDLArtifact(db2DDLArtifact);
				if (result == null) result = caseDDLArtifact(db2DDLArtifact);
				if (result == null) result = caseFileArtifact(db2DDLArtifact);
				if (result == null) result = caseArtifact(db2DDLArtifact);
				if (result == null) result = caseDeployModelObject(db2DDLArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_DEPLOY_ROOT: {
				Db2DeployRoot db2DeployRoot = (Db2DeployRoot)theEObject;
				Object result = caseDb2DeployRoot(db2DeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_INSTANCE: {
				DB2Instance db2Instance = (DB2Instance)theEObject;
				Object result = caseDB2Instance(db2Instance);
				if (result == null) result = caseDB2BaseInstance(db2Instance);
				if (result == null) result = caseDatabaseInstance(db2Instance);
				if (result == null) result = caseCapability(db2Instance);
				if (result == null) result = caseDeployModelObject(db2Instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_INSTANCE_UNIT: {
				DB2InstanceUnit db2InstanceUnit = (DB2InstanceUnit)theEObject;
				Object result = caseDB2InstanceUnit(db2InstanceUnit);
				if (result == null) result = caseDatabaseInstanceUnit(db2InstanceUnit);
				if (result == null) result = caseUnit(db2InstanceUnit);
				if (result == null) result = caseDeployModelObject(db2InstanceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_JDBC_DRIVER: {
				DB2JdbcDriver db2JdbcDriver = (DB2JdbcDriver)theEObject;
				Object result = caseDB2JdbcDriver(db2JdbcDriver);
				if (result == null) result = caseCapability(db2JdbcDriver);
				if (result == null) result = caseDeployModelObject(db2JdbcDriver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_NODE_CATALOG_UNIT: {
				DB2NodeCatalogUnit db2NodeCatalogUnit = (DB2NodeCatalogUnit)theEObject;
				Object result = caseDB2NodeCatalogUnit(db2NodeCatalogUnit);
				if (result == null) result = caseUnit(db2NodeCatalogUnit);
				if (result == null) result = caseDeployModelObject(db2NodeCatalogUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_RUNTIME_CLIENT_UNIT: {
				DB2RuntimeClientUnit db2RuntimeClientUnit = (DB2RuntimeClientUnit)theEObject;
				Object result = caseDB2RuntimeClientUnit(db2RuntimeClientUnit);
				if (result == null) result = caseDB2BaseClientUnit(db2RuntimeClientUnit);
				if (result == null) result = caseUnit(db2RuntimeClientUnit);
				if (result == null) result = caseDeployModelObject(db2RuntimeClientUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_SYSTEM: {
				DB2System db2System = (DB2System)theEObject;
				Object result = caseDB2System(db2System);
				if (result == null) result = caseCapability(db2System);
				if (result == null) result = caseDeployModelObject(db2System);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.DB2_SYSTEM_UNIT: {
				DB2SystemUnit db2SystemUnit = (DB2SystemUnit)theEObject;
				Object result = caseDB2SystemUnit(db2SystemUnit);
				if (result == null) result = caseUnit(db2SystemUnit);
				if (result == null) result = caseDeployModelObject(db2SystemUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.UNIX_DB2_ADMIN_SERVER: {
				UnixDB2AdminServer unixDB2AdminServer = (UnixDB2AdminServer)theEObject;
				Object result = caseUnixDB2AdminServer(unixDB2AdminServer);
				if (result == null) result = caseDB2AdminServer(unixDB2AdminServer);
				if (result == null) result = caseCapability(unixDB2AdminServer);
				if (result == null) result = caseDeployModelObject(unixDB2AdminServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE: {
				UnixDB2ClientInstance unixDB2ClientInstance = (UnixDB2ClientInstance)theEObject;
				Object result = caseUnixDB2ClientInstance(unixDB2ClientInstance);
				if (result == null) result = caseDB2ClientInstance(unixDB2ClientInstance);
				if (result == null) result = caseDB2BaseInstance(unixDB2ClientInstance);
				if (result == null) result = caseDatabaseInstance(unixDB2ClientInstance);
				if (result == null) result = caseCapability(unixDB2ClientInstance);
				if (result == null) result = caseDeployModelObject(unixDB2ClientInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.UNIX_DB2_INSTANCE: {
				UnixDB2Instance unixDB2Instance = (UnixDB2Instance)theEObject;
				Object result = caseUnixDB2Instance(unixDB2Instance);
				if (result == null) result = caseDB2Instance(unixDB2Instance);
				if (result == null) result = caseDB2BaseInstance(unixDB2Instance);
				if (result == null) result = caseDatabaseInstance(unixDB2Instance);
				if (result == null) result = caseCapability(unixDB2Instance);
				if (result == null) result = caseDeployModelObject(unixDB2Instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.UNIX_DB2_SYSTEM: {
				UnixDB2System unixDB2System = (UnixDB2System)theEObject;
				Object result = caseUnixDB2System(unixDB2System);
				if (result == null) result = caseDB2System(unixDB2System);
				if (result == null) result = caseCapability(unixDB2System);
				if (result == null) result = caseDeployModelObject(unixDB2System);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.WINDOWS_DB2_ADMIN_SERVER: {
				WindowsDB2AdminServer windowsDB2AdminServer = (WindowsDB2AdminServer)theEObject;
				Object result = caseWindowsDB2AdminServer(windowsDB2AdminServer);
				if (result == null) result = caseDB2AdminServer(windowsDB2AdminServer);
				if (result == null) result = caseCapability(windowsDB2AdminServer);
				if (result == null) result = caseDeployModelObject(windowsDB2AdminServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.WINDOWS_DB2_CLIENT_INSTANCE: {
				WindowsDB2ClientInstance windowsDB2ClientInstance = (WindowsDB2ClientInstance)theEObject;
				Object result = caseWindowsDB2ClientInstance(windowsDB2ClientInstance);
				if (result == null) result = caseDB2ClientInstance(windowsDB2ClientInstance);
				if (result == null) result = caseDB2BaseInstance(windowsDB2ClientInstance);
				if (result == null) result = caseDatabaseInstance(windowsDB2ClientInstance);
				if (result == null) result = caseCapability(windowsDB2ClientInstance);
				if (result == null) result = caseDeployModelObject(windowsDB2ClientInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.WINDOWS_DB2_INSTANCE: {
				WindowsDB2Instance windowsDB2Instance = (WindowsDB2Instance)theEObject;
				Object result = caseWindowsDB2Instance(windowsDB2Instance);
				if (result == null) result = caseDB2Instance(windowsDB2Instance);
				if (result == null) result = caseDB2BaseInstance(windowsDB2Instance);
				if (result == null) result = caseDatabaseInstance(windowsDB2Instance);
				if (result == null) result = caseCapability(windowsDB2Instance);
				if (result == null) result = caseDeployModelObject(windowsDB2Instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2Package.WINDOWS_DB2_SYSTEM: {
				WindowsDB2System windowsDB2System = (WindowsDB2System)theEObject;
				Object result = caseWindowsDB2System(windowsDB2System);
				if (result == null) result = caseDB2System(windowsDB2System);
				if (result == null) result = caseCapability(windowsDB2System);
				if (result == null) result = caseDeployModelObject(windowsDB2System);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Admin Client</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Admin Client</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2AdminClient(DB2AdminClient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Admin Client Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Admin Client Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2AdminClientUnit(DB2AdminClientUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Admin Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Admin Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2AdminServer(DB2AdminServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Admin Server Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Admin Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2AdminServerUnit(DB2AdminServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 App Devel Client</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 App Devel Client</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2AppDevelClient(DB2AppDevelClient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 App Devel Client Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 App Devel Client Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2AppDevelClientUnit(DB2AppDevelClientUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Base Client Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Base Client Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2BaseClientUnit(DB2BaseClientUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Base Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Base Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2BaseInstance(DB2BaseInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Cataloged Node</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Cataloged Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2CatalogedNode(DB2CatalogedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Catalog Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Catalog Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2CatalogUnit(DB2CatalogUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Client</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Client</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Client(DB2Client object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Client Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Client Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2ClientInstance(DB2ClientInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Client Instance Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Client Instance Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2ClientInstanceUnit(DB2ClientInstanceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Database</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Database</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Database(DB2Database object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Database Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Database Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2DatabaseUnit(DB2DatabaseUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2DDL Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2DDL Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2DDLArtifact(DB2DDLArtifact object) {
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
	public Object caseDb2DeployRoot(Db2DeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Instance(DB2Instance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Instance Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Instance Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2InstanceUnit(DB2InstanceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Jdbc Driver</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Jdbc Driver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2JdbcDriver(DB2JdbcDriver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Node Catalog Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Node Catalog Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2NodeCatalogUnit(DB2NodeCatalogUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Runtime Client Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Runtime Client Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2RuntimeClientUnit(DB2RuntimeClientUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2System(DB2System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2SystemUnit(DB2SystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix DB2 Admin Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix DB2 Admin Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixDB2AdminServer(UnixDB2AdminServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix DB2 Client Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix DB2 Client Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixDB2ClientInstance(UnixDB2ClientInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix DB2 Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix DB2 Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixDB2Instance(UnixDB2Instance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix DB2 System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix DB2 System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixDB2System(UnixDB2System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows DB2 Admin Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows DB2 Admin Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsDB2AdminServer(WindowsDB2AdminServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows DB2 Client Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows DB2 Client Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsDB2ClientInstance(WindowsDB2ClientInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows DB2 Instance</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows DB2 Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsDB2Instance(WindowsDB2Instance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows DB2 System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows DB2 System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsDB2System(WindowsDB2System object) {
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

} //Db2Switch
