/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2AdminClient <em>Capability Db2 Admin Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2AdminServer <em>Capability Db2 Admin Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2AppDevelClient <em>Capability Db2 App Devel Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2BaseInstance <em>Capability Db2 Base Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2CatalogedNode <em>Capability Db2 Cataloged Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2Client <em>Capability Db2 Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2ClientInstance <em>Capability Db2 Client Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2Database <em>Capability Db2 Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2Instance <em>Capability Db2 Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2JdbcDriver <em>Capability Db2 Jdbc Driver</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityDb2System <em>Capability Db2 System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityUnixDb2AdminServer <em>Capability Unix Db2 Admin Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityUnixDb2ClientInstance <em>Capability Unix Db2 Client Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityUnixDb2Instance <em>Capability Unix Db2 Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityUnixDb2System <em>Capability Unix Db2 System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityWindowsDb2AdminServer <em>Capability Windows Db2 Admin Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityWindowsDb2ClientInstance <em>Capability Windows Db2 Client Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityWindowsDb2Instance <em>Capability Windows Db2 Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getCapabilityWindowsDb2System <em>Capability Windows Db2 System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2AdminClientUnit <em>Unit Db2 Admin Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2AdminServerUnit <em>Unit Db2 Admin Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2AppDevelClientUnit <em>Unit Db2 App Devel Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2BaseClientUnit <em>Unit Db2 Base Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2CatalogUnit <em>Unit Db2 Catalog Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2ClientInstanceUnit <em>Unit Db2 Client Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2DatabaseUnit <em>Unit Db2 Database Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2ddl <em>Unit Db2ddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2InstanceUnit <em>Unit Db2 Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2NodeCatalogUnit <em>Unit Db2 Node Catalog Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2RuntimeClientUnit <em>Unit Db2 Runtime Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl#getUnitDb2SystemUnit <em>Unit Db2 System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Db2DeployRootImpl extends EObjectImpl implements Db2DeployRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Db2DeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, Db2Package.DB2_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Db2Package.DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Db2Package.DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminClient getCapabilityDb2AdminClient() {
		return (DB2AdminClient)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2AdminClient(
			DB2AdminClient newCapabilityDb2AdminClient, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT, newCapabilityDb2AdminClient, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2AdminClient(DB2AdminClient newCapabilityDb2AdminClient) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT, newCapabilityDb2AdminClient);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminServer getCapabilityDb2AdminServer() {
		return (DB2AdminServer)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2AdminServer(
			DB2AdminServer newCapabilityDb2AdminServer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER, newCapabilityDb2AdminServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2AdminServer(DB2AdminServer newCapabilityDb2AdminServer) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER, newCapabilityDb2AdminServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AppDevelClient getCapabilityDb2AppDevelClient() {
		return (DB2AppDevelClient)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2AppDevelClient(
			DB2AppDevelClient newCapabilityDb2AppDevelClient, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT, newCapabilityDb2AppDevelClient, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2AppDevelClient(DB2AppDevelClient newCapabilityDb2AppDevelClient) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT, newCapabilityDb2AppDevelClient);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BaseInstance getCapabilityDb2BaseInstance() {
		return (DB2BaseInstance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2BaseInstance(
			DB2BaseInstance newCapabilityDb2BaseInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE, newCapabilityDb2BaseInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2BaseInstance(DB2BaseInstance newCapabilityDb2BaseInstance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE, newCapabilityDb2BaseInstance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2CatalogedNode getCapabilityDb2CatalogedNode() {
		return (DB2CatalogedNode)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2CatalogedNode(
			DB2CatalogedNode newCapabilityDb2CatalogedNode, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE, newCapabilityDb2CatalogedNode, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2CatalogedNode(DB2CatalogedNode newCapabilityDb2CatalogedNode) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE, newCapabilityDb2CatalogedNode);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Client getCapabilityDb2Client() {
		return (DB2Client)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2Client(DB2Client newCapabilityDb2Client,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT, newCapabilityDb2Client, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2Client(DB2Client newCapabilityDb2Client) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT, newCapabilityDb2Client);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ClientInstance getCapabilityDb2ClientInstance() {
		return (DB2ClientInstance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2ClientInstance(
			DB2ClientInstance newCapabilityDb2ClientInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE, newCapabilityDb2ClientInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2ClientInstance(DB2ClientInstance newCapabilityDb2ClientInstance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE, newCapabilityDb2ClientInstance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Database getCapabilityDb2Database() {
		return (DB2Database)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2Database(DB2Database newCapabilityDb2Database,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE, newCapabilityDb2Database, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2Database(DB2Database newCapabilityDb2Database) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE, newCapabilityDb2Database);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Instance getCapabilityDb2Instance() {
		return (DB2Instance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2Instance(DB2Instance newCapabilityDb2Instance,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE, newCapabilityDb2Instance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2Instance(DB2Instance newCapabilityDb2Instance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE, newCapabilityDb2Instance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcDriver getCapabilityDb2JdbcDriver() {
		return (DB2JdbcDriver)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2JdbcDriver(
			DB2JdbcDriver newCapabilityDb2JdbcDriver, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER, newCapabilityDb2JdbcDriver, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2JdbcDriver(DB2JdbcDriver newCapabilityDb2JdbcDriver) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER, newCapabilityDb2JdbcDriver);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2System getCapabilityDb2System() {
		return (DB2System)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2System(DB2System newCapabilityDb2System,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM, newCapabilityDb2System, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2System(DB2System newCapabilityDb2System) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM, newCapabilityDb2System);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2AdminServer getCapabilityUnixDb2AdminServer() {
		return (UnixDB2AdminServer)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUnixDb2AdminServer(
			UnixDB2AdminServer newCapabilityUnixDb2AdminServer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER, newCapabilityUnixDb2AdminServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUnixDb2AdminServer(UnixDB2AdminServer newCapabilityUnixDb2AdminServer) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER, newCapabilityUnixDb2AdminServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2ClientInstance getCapabilityUnixDb2ClientInstance() {
		return (UnixDB2ClientInstance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUnixDb2ClientInstance(
			UnixDB2ClientInstance newCapabilityUnixDb2ClientInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE, newCapabilityUnixDb2ClientInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUnixDb2ClientInstance(
			UnixDB2ClientInstance newCapabilityUnixDb2ClientInstance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE, newCapabilityUnixDb2ClientInstance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2Instance getCapabilityUnixDb2Instance() {
		return (UnixDB2Instance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUnixDb2Instance(
			UnixDB2Instance newCapabilityUnixDb2Instance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE, newCapabilityUnixDb2Instance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUnixDb2Instance(UnixDB2Instance newCapabilityUnixDb2Instance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE, newCapabilityUnixDb2Instance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2System getCapabilityUnixDb2System() {
		return (UnixDB2System)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUnixDb2System(
			UnixDB2System newCapabilityUnixDb2System, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM, newCapabilityUnixDb2System, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUnixDb2System(UnixDB2System newCapabilityUnixDb2System) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM, newCapabilityUnixDb2System);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2AdminServer getCapabilityWindowsDb2AdminServer() {
		return (WindowsDB2AdminServer)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsDb2AdminServer(
			WindowsDB2AdminServer newCapabilityWindowsDb2AdminServer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER, newCapabilityWindowsDb2AdminServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsDb2AdminServer(
			WindowsDB2AdminServer newCapabilityWindowsDb2AdminServer) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER, newCapabilityWindowsDb2AdminServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2ClientInstance getCapabilityWindowsDb2ClientInstance() {
		return (WindowsDB2ClientInstance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsDb2ClientInstance(
			WindowsDB2ClientInstance newCapabilityWindowsDb2ClientInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE, newCapabilityWindowsDb2ClientInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsDb2ClientInstance(
			WindowsDB2ClientInstance newCapabilityWindowsDb2ClientInstance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE, newCapabilityWindowsDb2ClientInstance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2Instance getCapabilityWindowsDb2Instance() {
		return (WindowsDB2Instance)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsDb2Instance(
			WindowsDB2Instance newCapabilityWindowsDb2Instance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE, newCapabilityWindowsDb2Instance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsDb2Instance(WindowsDB2Instance newCapabilityWindowsDb2Instance) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE, newCapabilityWindowsDb2Instance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2System getCapabilityWindowsDb2System() {
		return (WindowsDB2System)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsDb2System(
			WindowsDB2System newCapabilityWindowsDb2System, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM, newCapabilityWindowsDb2System, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsDb2System(WindowsDB2System newCapabilityWindowsDb2System) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM, newCapabilityWindowsDb2System);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminClientUnit getUnitDb2AdminClientUnit() {
		return (DB2AdminClientUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2AdminClientUnit(
			DB2AdminClientUnit newUnitDb2AdminClientUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT, newUnitDb2AdminClientUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2AdminClientUnit(DB2AdminClientUnit newUnitDb2AdminClientUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT, newUnitDb2AdminClientUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminServerUnit getUnitDb2AdminServerUnit() {
		return (DB2AdminServerUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2AdminServerUnit(
			DB2AdminServerUnit newUnitDb2AdminServerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT, newUnitDb2AdminServerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2AdminServerUnit(DB2AdminServerUnit newUnitDb2AdminServerUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT, newUnitDb2AdminServerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AppDevelClientUnit getUnitDb2AppDevelClientUnit() {
		return (DB2AppDevelClientUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2AppDevelClientUnit(
			DB2AppDevelClientUnit newUnitDb2AppDevelClientUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT, newUnitDb2AppDevelClientUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2AppDevelClientUnit(DB2AppDevelClientUnit newUnitDb2AppDevelClientUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT, newUnitDb2AppDevelClientUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BaseClientUnit getUnitDb2BaseClientUnit() {
		return (DB2BaseClientUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2BaseClientUnit(
			DB2BaseClientUnit newUnitDb2BaseClientUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT, newUnitDb2BaseClientUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2BaseClientUnit(DB2BaseClientUnit newUnitDb2BaseClientUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT, newUnitDb2BaseClientUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2CatalogUnit getUnitDb2CatalogUnit() {
		return (DB2CatalogUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2CatalogUnit(DB2CatalogUnit newUnitDb2CatalogUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT, newUnitDb2CatalogUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2CatalogUnit(DB2CatalogUnit newUnitDb2CatalogUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT, newUnitDb2CatalogUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ClientInstanceUnit getUnitDb2ClientInstanceUnit() {
		return (DB2ClientInstanceUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2ClientInstanceUnit(
			DB2ClientInstanceUnit newUnitDb2ClientInstanceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT, newUnitDb2ClientInstanceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2ClientInstanceUnit(DB2ClientInstanceUnit newUnitDb2ClientInstanceUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT, newUnitDb2ClientInstanceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2DatabaseUnit getUnitDb2DatabaseUnit() {
		return (DB2DatabaseUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2DatabaseUnit(DB2DatabaseUnit newUnitDb2DatabaseUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT, newUnitDb2DatabaseUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2DatabaseUnit(DB2DatabaseUnit newUnitDb2DatabaseUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT, newUnitDb2DatabaseUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2DDLArtifact getUnitDb2ddl() {
		return (DB2DDLArtifact)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2DDL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2ddl(DB2DDLArtifact newUnitDb2ddl, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2DDL, newUnitDb2ddl, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2ddl(DB2DDLArtifact newUnitDb2ddl) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2DDL, newUnitDb2ddl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2InstanceUnit getUnitDb2InstanceUnit() {
		return (DB2InstanceUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2InstanceUnit(DB2InstanceUnit newUnitDb2InstanceUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT, newUnitDb2InstanceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2InstanceUnit(DB2InstanceUnit newUnitDb2InstanceUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT, newUnitDb2InstanceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2NodeCatalogUnit getUnitDb2NodeCatalogUnit() {
		return (DB2NodeCatalogUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2NodeCatalogUnit(
			DB2NodeCatalogUnit newUnitDb2NodeCatalogUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT, newUnitDb2NodeCatalogUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2NodeCatalogUnit(DB2NodeCatalogUnit newUnitDb2NodeCatalogUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT, newUnitDb2NodeCatalogUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2RuntimeClientUnit getUnitDb2RuntimeClientUnit() {
		return (DB2RuntimeClientUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2RuntimeClientUnit(
			DB2RuntimeClientUnit newUnitDb2RuntimeClientUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT, newUnitDb2RuntimeClientUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2RuntimeClientUnit(DB2RuntimeClientUnit newUnitDb2RuntimeClientUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT, newUnitDb2RuntimeClientUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2SystemUnit getUnitDb2SystemUnit() {
		return (DB2SystemUnit)getMixed().get(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2SystemUnit(DB2SystemUnit newUnitDb2SystemUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT, newUnitDb2SystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2SystemUnit(DB2SystemUnit newUnitDb2SystemUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT, newUnitDb2SystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case Db2Package.DB2_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT:
				return basicSetCapabilityDb2AdminClient(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER:
				return basicSetCapabilityDb2AdminServer(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT:
				return basicSetCapabilityDb2AppDevelClient(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE:
				return basicSetCapabilityDb2BaseInstance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE:
				return basicSetCapabilityDb2CatalogedNode(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT:
				return basicSetCapabilityDb2Client(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE:
				return basicSetCapabilityDb2ClientInstance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE:
				return basicSetCapabilityDb2Database(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE:
				return basicSetCapabilityDb2Instance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER:
				return basicSetCapabilityDb2JdbcDriver(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM:
				return basicSetCapabilityDb2System(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER:
				return basicSetCapabilityUnixDb2AdminServer(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE:
				return basicSetCapabilityUnixDb2ClientInstance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE:
				return basicSetCapabilityUnixDb2Instance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM:
				return basicSetCapabilityUnixDb2System(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER:
				return basicSetCapabilityWindowsDb2AdminServer(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE:
				return basicSetCapabilityWindowsDb2ClientInstance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE:
				return basicSetCapabilityWindowsDb2Instance(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM:
				return basicSetCapabilityWindowsDb2System(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT:
				return basicSetUnitDb2AdminClientUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT:
				return basicSetUnitDb2AdminServerUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT:
				return basicSetUnitDb2AppDevelClientUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT:
				return basicSetUnitDb2BaseClientUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT:
				return basicSetUnitDb2CatalogUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT:
				return basicSetUnitDb2ClientInstanceUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT:
				return basicSetUnitDb2DatabaseUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2DDL:
				return basicSetUnitDb2ddl(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT:
				return basicSetUnitDb2InstanceUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT:
				return basicSetUnitDb2NodeCatalogUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT:
				return basicSetUnitDb2RuntimeClientUnit(null, msgs);
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT:
				return basicSetUnitDb2SystemUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case Db2Package.DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case Db2Package.DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT:
				return getCapabilityDb2AdminClient();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER:
				return getCapabilityDb2AdminServer();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT:
				return getCapabilityDb2AppDevelClient();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE:
				return getCapabilityDb2BaseInstance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE:
				return getCapabilityDb2CatalogedNode();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT:
				return getCapabilityDb2Client();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE:
				return getCapabilityDb2ClientInstance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE:
				return getCapabilityDb2Database();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE:
				return getCapabilityDb2Instance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER:
				return getCapabilityDb2JdbcDriver();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM:
				return getCapabilityDb2System();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER:
				return getCapabilityUnixDb2AdminServer();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE:
				return getCapabilityUnixDb2ClientInstance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE:
				return getCapabilityUnixDb2Instance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM:
				return getCapabilityUnixDb2System();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER:
				return getCapabilityWindowsDb2AdminServer();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE:
				return getCapabilityWindowsDb2ClientInstance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE:
				return getCapabilityWindowsDb2Instance();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM:
				return getCapabilityWindowsDb2System();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT:
				return getUnitDb2AdminClientUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT:
				return getUnitDb2AdminServerUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT:
				return getUnitDb2AppDevelClientUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT:
				return getUnitDb2BaseClientUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT:
				return getUnitDb2CatalogUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT:
				return getUnitDb2ClientInstanceUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT:
				return getUnitDb2DatabaseUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2DDL:
				return getUnitDb2ddl();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT:
				return getUnitDb2InstanceUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT:
				return getUnitDb2NodeCatalogUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT:
				return getUnitDb2RuntimeClientUnit();
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT:
				return getUnitDb2SystemUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT:
				setCapabilityDb2AdminClient((DB2AdminClient)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER:
				setCapabilityDb2AdminServer((DB2AdminServer)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT:
				setCapabilityDb2AppDevelClient((DB2AppDevelClient)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE:
				setCapabilityDb2BaseInstance((DB2BaseInstance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE:
				setCapabilityDb2CatalogedNode((DB2CatalogedNode)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT:
				setCapabilityDb2Client((DB2Client)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE:
				setCapabilityDb2ClientInstance((DB2ClientInstance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE:
				setCapabilityDb2Database((DB2Database)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE:
				setCapabilityDb2Instance((DB2Instance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER:
				setCapabilityDb2JdbcDriver((DB2JdbcDriver)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM:
				setCapabilityDb2System((DB2System)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER:
				setCapabilityUnixDb2AdminServer((UnixDB2AdminServer)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE:
				setCapabilityUnixDb2ClientInstance((UnixDB2ClientInstance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE:
				setCapabilityUnixDb2Instance((UnixDB2Instance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM:
				setCapabilityUnixDb2System((UnixDB2System)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER:
				setCapabilityWindowsDb2AdminServer((WindowsDB2AdminServer)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE:
				setCapabilityWindowsDb2ClientInstance((WindowsDB2ClientInstance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE:
				setCapabilityWindowsDb2Instance((WindowsDB2Instance)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM:
				setCapabilityWindowsDb2System((WindowsDB2System)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT:
				setUnitDb2AdminClientUnit((DB2AdminClientUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT:
				setUnitDb2AdminServerUnit((DB2AdminServerUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT:
				setUnitDb2AppDevelClientUnit((DB2AppDevelClientUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT:
				setUnitDb2BaseClientUnit((DB2BaseClientUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT:
				setUnitDb2CatalogUnit((DB2CatalogUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT:
				setUnitDb2ClientInstanceUnit((DB2ClientInstanceUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT:
				setUnitDb2DatabaseUnit((DB2DatabaseUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2DDL:
				setUnitDb2ddl((DB2DDLArtifact)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT:
				setUnitDb2InstanceUnit((DB2InstanceUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT:
				setUnitDb2NodeCatalogUnit((DB2NodeCatalogUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT:
				setUnitDb2RuntimeClientUnit((DB2RuntimeClientUnit)newValue);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT:
				setUnitDb2SystemUnit((DB2SystemUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case Db2Package.DB2_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case Db2Package.DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case Db2Package.DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT:
				setCapabilityDb2AdminClient((DB2AdminClient)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER:
				setCapabilityDb2AdminServer((DB2AdminServer)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT:
				setCapabilityDb2AppDevelClient((DB2AppDevelClient)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE:
				setCapabilityDb2BaseInstance((DB2BaseInstance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE:
				setCapabilityDb2CatalogedNode((DB2CatalogedNode)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT:
				setCapabilityDb2Client((DB2Client)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE:
				setCapabilityDb2ClientInstance((DB2ClientInstance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE:
				setCapabilityDb2Database((DB2Database)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE:
				setCapabilityDb2Instance((DB2Instance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER:
				setCapabilityDb2JdbcDriver((DB2JdbcDriver)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM:
				setCapabilityDb2System((DB2System)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER:
				setCapabilityUnixDb2AdminServer((UnixDB2AdminServer)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE:
				setCapabilityUnixDb2ClientInstance((UnixDB2ClientInstance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE:
				setCapabilityUnixDb2Instance((UnixDB2Instance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM:
				setCapabilityUnixDb2System((UnixDB2System)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER:
				setCapabilityWindowsDb2AdminServer((WindowsDB2AdminServer)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE:
				setCapabilityWindowsDb2ClientInstance((WindowsDB2ClientInstance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE:
				setCapabilityWindowsDb2Instance((WindowsDB2Instance)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM:
				setCapabilityWindowsDb2System((WindowsDB2System)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT:
				setUnitDb2AdminClientUnit((DB2AdminClientUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT:
				setUnitDb2AdminServerUnit((DB2AdminServerUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT:
				setUnitDb2AppDevelClientUnit((DB2AppDevelClientUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT:
				setUnitDb2BaseClientUnit((DB2BaseClientUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT:
				setUnitDb2CatalogUnit((DB2CatalogUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT:
				setUnitDb2ClientInstanceUnit((DB2ClientInstanceUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT:
				setUnitDb2DatabaseUnit((DB2DatabaseUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2DDL:
				setUnitDb2ddl((DB2DDLArtifact)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT:
				setUnitDb2InstanceUnit((DB2InstanceUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT:
				setUnitDb2NodeCatalogUnit((DB2NodeCatalogUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT:
				setUnitDb2RuntimeClientUnit((DB2RuntimeClientUnit)null);
				return;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT:
				setUnitDb2SystemUnit((DB2SystemUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Db2Package.DB2_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case Db2Package.DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case Db2Package.DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT:
				return getCapabilityDb2AdminClient() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER:
				return getCapabilityDb2AdminServer() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT:
				return getCapabilityDb2AppDevelClient() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE:
				return getCapabilityDb2BaseInstance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE:
				return getCapabilityDb2CatalogedNode() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT:
				return getCapabilityDb2Client() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE:
				return getCapabilityDb2ClientInstance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE:
				return getCapabilityDb2Database() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE:
				return getCapabilityDb2Instance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER:
				return getCapabilityDb2JdbcDriver() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM:
				return getCapabilityDb2System() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER:
				return getCapabilityUnixDb2AdminServer() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE:
				return getCapabilityUnixDb2ClientInstance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE:
				return getCapabilityUnixDb2Instance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM:
				return getCapabilityUnixDb2System() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER:
				return getCapabilityWindowsDb2AdminServer() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE:
				return getCapabilityWindowsDb2ClientInstance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE:
				return getCapabilityWindowsDb2Instance() != null;
			case Db2Package.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM:
				return getCapabilityWindowsDb2System() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT:
				return getUnitDb2AdminClientUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT:
				return getUnitDb2AdminServerUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT:
				return getUnitDb2AppDevelClientUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT:
				return getUnitDb2BaseClientUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT:
				return getUnitDb2CatalogUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT:
				return getUnitDb2ClientInstanceUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT:
				return getUnitDb2DatabaseUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2DDL:
				return getUnitDb2ddl() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT:
				return getUnitDb2InstanceUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT:
				return getUnitDb2NodeCatalogUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT:
				return getUnitDb2RuntimeClientUnit() != null;
			case Db2Package.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT:
				return getUnitDb2SystemUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //Db2DeployRootImpl
