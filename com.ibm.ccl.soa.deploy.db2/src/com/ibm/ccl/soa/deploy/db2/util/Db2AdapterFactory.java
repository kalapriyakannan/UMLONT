/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package
 * @generated
 */
public class Db2AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static Db2Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Db2AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Db2Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or
	 * is an instance object of the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Db2Switch modelSwitch = new Db2Switch() {
			public Object caseDB2AdminClient(DB2AdminClient object) {
				return createDB2AdminClientAdapter();
			}
			public Object caseDB2AdminClientUnit(DB2AdminClientUnit object) {
				return createDB2AdminClientUnitAdapter();
			}
			public Object caseDB2AdminServer(DB2AdminServer object) {
				return createDB2AdminServerAdapter();
			}
			public Object caseDB2AdminServerUnit(DB2AdminServerUnit object) {
				return createDB2AdminServerUnitAdapter();
			}
			public Object caseDB2AppDevelClient(DB2AppDevelClient object) {
				return createDB2AppDevelClientAdapter();
			}
			public Object caseDB2AppDevelClientUnit(DB2AppDevelClientUnit object) {
				return createDB2AppDevelClientUnitAdapter();
			}
			public Object caseDB2BaseClientUnit(DB2BaseClientUnit object) {
				return createDB2BaseClientUnitAdapter();
			}
			public Object caseDB2BaseInstance(DB2BaseInstance object) {
				return createDB2BaseInstanceAdapter();
			}
			public Object caseDB2CatalogedNode(DB2CatalogedNode object) {
				return createDB2CatalogedNodeAdapter();
			}
			public Object caseDB2CatalogUnit(DB2CatalogUnit object) {
				return createDB2CatalogUnitAdapter();
			}
			public Object caseDB2Client(DB2Client object) {
				return createDB2ClientAdapter();
			}
			public Object caseDB2ClientInstance(DB2ClientInstance object) {
				return createDB2ClientInstanceAdapter();
			}
			public Object caseDB2ClientInstanceUnit(DB2ClientInstanceUnit object) {
				return createDB2ClientInstanceUnitAdapter();
			}
			public Object caseDB2Database(DB2Database object) {
				return createDB2DatabaseAdapter();
			}
			public Object caseDB2DatabaseUnit(DB2DatabaseUnit object) {
				return createDB2DatabaseUnitAdapter();
			}
			public Object caseDB2DDLArtifact(DB2DDLArtifact object) {
				return createDB2DDLArtifactAdapter();
			}
			public Object caseDb2DeployRoot(Db2DeployRoot object) {
				return createDb2DeployRootAdapter();
			}
			public Object caseDB2Instance(DB2Instance object) {
				return createDB2InstanceAdapter();
			}
			public Object caseDB2InstanceUnit(DB2InstanceUnit object) {
				return createDB2InstanceUnitAdapter();
			}
			public Object caseDB2JdbcDriver(DB2JdbcDriver object) {
				return createDB2JdbcDriverAdapter();
			}
			public Object caseDB2NodeCatalogUnit(DB2NodeCatalogUnit object) {
				return createDB2NodeCatalogUnitAdapter();
			}
			public Object caseDB2RuntimeClientUnit(DB2RuntimeClientUnit object) {
				return createDB2RuntimeClientUnitAdapter();
			}
			public Object caseDB2System(DB2System object) {
				return createDB2SystemAdapter();
			}
			public Object caseDB2SystemUnit(DB2SystemUnit object) {
				return createDB2SystemUnitAdapter();
			}
			public Object caseUnixDB2AdminServer(UnixDB2AdminServer object) {
				return createUnixDB2AdminServerAdapter();
			}
			public Object caseUnixDB2ClientInstance(UnixDB2ClientInstance object) {
				return createUnixDB2ClientInstanceAdapter();
			}
			public Object caseUnixDB2Instance(UnixDB2Instance object) {
				return createUnixDB2InstanceAdapter();
			}
			public Object caseUnixDB2System(UnixDB2System object) {
				return createUnixDB2SystemAdapter();
			}
			public Object caseWindowsDB2AdminServer(WindowsDB2AdminServer object) {
				return createWindowsDB2AdminServerAdapter();
			}
			public Object caseWindowsDB2ClientInstance(WindowsDB2ClientInstance object) {
				return createWindowsDB2ClientInstanceAdapter();
			}
			public Object caseWindowsDB2Instance(WindowsDB2Instance object) {
				return createWindowsDB2InstanceAdapter();
			}
			public Object caseWindowsDB2System(WindowsDB2System object) {
				return createWindowsDB2SystemAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseDatabaseInstance(DatabaseInstance object) {
				return createDatabaseInstanceAdapter();
			}
			public Object caseDatabase(Database object) {
				return createDatabaseAdapter();
			}
			public Object caseDatabaseUnit(DatabaseUnit object) {
				return createDatabaseUnitAdapter();
			}
			public Object caseArtifact(Artifact object) {
				return createArtifactAdapter();
			}
			public Object caseFileArtifact(FileArtifact object) {
				return createFileArtifactAdapter();
			}
			public Object caseDDLArtifact(DDLArtifact object) {
				return createDDLArtifactAdapter();
			}
			public Object caseDatabaseInstanceUnit(DatabaseInstanceUnit object) {
				return createDatabaseInstanceUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminClient <em>DB2 Admin Client</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminClient
	 * @generated
	 */
	public Adapter createDB2AdminClientAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit <em>DB2 Admin Client Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit
	 * @generated
	 */
	public Adapter createDB2AdminClientUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminServer <em>DB2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminServer
	 * @generated
	 */
	public Adapter createDB2AdminServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit <em>DB2 Admin Server Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit
	 * @generated
	 */
	public Adapter createDB2AdminServerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient <em>DB2 App Devel Client</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient
	 * @generated
	 */
	public Adapter createDB2AppDevelClientAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit <em>DB2 App Devel Client Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit
	 * @generated
	 */
	public Adapter createDB2AppDevelClientUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit <em>DB2 Base Client Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit
	 * @generated
	 */
	public Adapter createDB2BaseClientUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance <em>DB2 Base Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2BaseInstance
	 * @generated
	 */
	public Adapter createDB2BaseInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode <em>DB2 Cataloged Node</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode
	 * @generated
	 */
	public Adapter createDB2CatalogedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit <em>DB2 Catalog Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit
	 * @generated
	 */
	public Adapter createDB2CatalogUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2Client <em>DB2 Client</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Client
	 * @generated
	 */
	public Adapter createDB2ClientAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2ClientInstance <em>DB2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2ClientInstance
	 * @generated
	 */
	public Adapter createDB2ClientInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit <em>DB2 Client Instance Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit
	 * @generated
	 */
	public Adapter createDB2ClientInstanceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2Database <em>DB2 Database</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database
	 * @generated
	 */
	public Adapter createDB2DatabaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit <em>DB2 Database Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit
	 * @generated
	 */
	public Adapter createDB2DatabaseUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact <em>DB2DDL Artifact</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact
	 * @generated
	 */
	public Adapter createDB2DDLArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot
	 * @generated
	 */
	public Adapter createDb2DeployRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance <em>DB2 Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance
	 * @generated
	 */
	public Adapter createDB2InstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit <em>DB2 Instance Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit
	 * @generated
	 */
	public Adapter createDB2InstanceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver <em>DB2 Jdbc Driver</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver
	 * @generated
	 */
	public Adapter createDB2JdbcDriverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit <em>DB2 Node Catalog Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit
	 * @generated
	 */
	public Adapter createDB2NodeCatalogUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit <em>DB2 Runtime Client Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit
	 * @generated
	 */
	public Adapter createDB2RuntimeClientUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2System <em>DB2 System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2System
	 * @generated
	 */
	public Adapter createDB2SystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.DB2SystemUnit <em>DB2 System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2SystemUnit
	 * @generated
	 */
	public Adapter createDB2SystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer <em>Unix DB2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer
	 * @generated
	 */
	public Adapter createUnixDB2AdminServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance <em>Unix DB2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance
	 * @generated
	 */
	public Adapter createUnixDB2ClientInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance <em>Unix DB2 Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance
	 * @generated
	 */
	public Adapter createUnixDB2InstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2System <em>Unix DB2 System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2System
	 * @generated
	 */
	public Adapter createUnixDB2SystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer <em>Windows DB2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer
	 * @generated
	 */
	public Adapter createWindowsDB2AdminServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance <em>Windows DB2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance
	 * @generated
	 */
	public Adapter createWindowsDB2ClientInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance <em>Windows DB2 Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance
	 * @generated
	 */
	public Adapter createWindowsDB2InstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System <em>Windows DB2 System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2System
	 * @generated
	 */
	public Adapter createWindowsDB2SystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.database.Database <em>Database</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.database.Database
	 * @generated
	 */
	public Adapter createDatabaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.database.DatabaseUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseUnit
	 * @generated
	 */
	public Adapter createDatabaseUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Artifact
	 * @generated
	 */
	public Adapter createArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.FileArtifact <em>File Artifact</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.FileArtifact
	 * @generated
	 */
	public Adapter createFileArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.database.DDLArtifact <em>DDL Artifact</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.database.DDLArtifact
	 * @generated
	 */
	public Adapter createDDLArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.database.DatabaseInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseInstance
	 * @generated
	 */
	public Adapter createDatabaseInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit <em>Instance Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit
	 * @generated
	 */
	public Adapter createDatabaseInstanceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Db2AdapterFactory
