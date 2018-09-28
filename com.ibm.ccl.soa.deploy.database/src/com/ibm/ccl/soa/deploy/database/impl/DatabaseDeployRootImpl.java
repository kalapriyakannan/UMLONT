/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.impl;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getArtifactDdl <em>Artifact Ddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getArtifactDml <em>Artifact Dml</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getCapabilityDatabase <em>Capability Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getCapabilityDatabaseInstance <em>Capability Database Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getCapabilitySqlUser <em>Capability Sql User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getComponentDatabase <em>Component Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getInterfaceDdl <em>Interface Ddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getServiceDatabaseDefinition <em>Service Database Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getUnitDatabaseInstanceUnit <em>Unit Database Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getUnitDatabaseUnit <em>Unit Database Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl#getUnitSQLModule <em>Unit SQL Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatabaseDeployRootImpl extends EObjectImpl implements DatabaseDeployRoot {
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
	protected DatabaseDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.DATABASE_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DatabasePackage.DATABASE_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DatabasePackage.DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DatabasePackage.DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DDLArtifact getArtifactDdl() {
		return (DDLArtifact)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifactDdl(DDLArtifact newArtifactDdl, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL, newArtifactDdl, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactDdl(DDLArtifact newArtifactDdl) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL, newArtifactDdl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DMLArtifact getArtifactDml() {
		return (DMLArtifact)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__ARTIFACT_DML, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifactDml(DMLArtifact newArtifactDml, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__ARTIFACT_DML, newArtifactDml, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactDml(DMLArtifact newArtifactDml) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__ARTIFACT_DML, newArtifactDml);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Database getCapabilityDatabase() {
		return (Database)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDatabase(Database newCapabilityDatabase,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE, newCapabilityDatabase, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDatabase(Database newCapabilityDatabase) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE, newCapabilityDatabase);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInstance getCapabilityDatabaseInstance() {
		return (DatabaseInstance)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDatabaseInstance(
			DatabaseInstance newCapabilityDatabaseInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE, newCapabilityDatabaseInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDatabaseInstance(DatabaseInstance newCapabilityDatabaseInstance) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE, newCapabilityDatabaseInstance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseComponent getComponentDatabase() {
		return (DatabaseComponent)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentDatabase(DatabaseComponent newComponentDatabase,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE, newComponentDatabase, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentDatabase(DatabaseComponent newComponentDatabase) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE, newComponentDatabase);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DDLInterface getInterfaceDdl() {
		return (DDLInterface)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__INTERFACE_DDL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceDdl(DDLInterface newInterfaceDdl,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__INTERFACE_DDL, newInterfaceDdl, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceDdl(DDLInterface newInterfaceDdl) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__INTERFACE_DDL, newInterfaceDdl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseDefinition getServiceDatabaseDefinition() {
		return (DatabaseDefinition)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceDatabaseDefinition(
			DatabaseDefinition newServiceDatabaseDefinition, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION, newServiceDatabaseDefinition, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDatabaseDefinition(DatabaseDefinition newServiceDatabaseDefinition) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION, newServiceDatabaseDefinition);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SQLUser getCapabilitySqlUser() {
		return (SQLUser)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySqlUser(SQLUser newCapabilitySqlUser,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER, newCapabilitySqlUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySqlUser(SQLUser newCapabilitySqlUser) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER, newCapabilitySqlUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInstanceUnit getUnitDatabaseInstanceUnit() {
		return (DatabaseInstanceUnit)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDatabaseInstanceUnit(
			DatabaseInstanceUnit newUnitDatabaseInstanceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT, newUnitDatabaseInstanceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDatabaseInstanceUnit(DatabaseInstanceUnit newUnitDatabaseInstanceUnit) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT, newUnitDatabaseInstanceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseUnit getUnitDatabaseUnit() {
		return (DatabaseUnit)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDatabaseUnit(DatabaseUnit newUnitDatabaseUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT, newUnitDatabaseUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDatabaseUnit(DatabaseUnit newUnitDatabaseUnit) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT, newUnitDatabaseUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SQLModule getUnitSQLModule() {
		return (SQLModule)getMixed().get(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSQLModule(SQLModule newUnitSQLModule, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE, newUnitSQLModule, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSQLModule(SQLModule newUnitSQLModule) {
		((FeatureMap.Internal)getMixed()).set(DatabasePackage.Literals.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE, newUnitSQLModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.DATABASE_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL:
				return basicSetArtifactDdl(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DML:
				return basicSetArtifactDml(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE:
				return basicSetCapabilityDatabase(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE:
				return basicSetCapabilityDatabaseInstance(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER:
				return basicSetCapabilitySqlUser(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE:
				return basicSetComponentDatabase(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__INTERFACE_DDL:
				return basicSetInterfaceDdl(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION:
				return basicSetServiceDatabaseDefinition(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT:
				return basicSetUnitDatabaseInstanceUnit(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT:
				return basicSetUnitDatabaseUnit(null, msgs);
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE:
				return basicSetUnitSQLModule(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatabasePackage.DATABASE_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL:
				return getArtifactDdl();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DML:
				return getArtifactDml();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE:
				return getCapabilityDatabase();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE:
				return getCapabilityDatabaseInstance();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER:
				return getCapabilitySqlUser();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE:
				return getComponentDatabase();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__INTERFACE_DDL:
				return getInterfaceDdl();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION:
				return getServiceDatabaseDefinition();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT:
				return getUnitDatabaseInstanceUnit();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT:
				return getUnitDatabaseUnit();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE:
				return getUnitSQLModule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatabasePackage.DATABASE_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL:
				setArtifactDdl((DDLArtifact)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DML:
				setArtifactDml((DMLArtifact)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE:
				setCapabilityDatabase((Database)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE:
				setCapabilityDatabaseInstance((DatabaseInstance)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER:
				setCapabilitySqlUser((SQLUser)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE:
				setComponentDatabase((DatabaseComponent)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__INTERFACE_DDL:
				setInterfaceDdl((DDLInterface)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION:
				setServiceDatabaseDefinition((DatabaseDefinition)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT:
				setUnitDatabaseInstanceUnit((DatabaseInstanceUnit)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT:
				setUnitDatabaseUnit((DatabaseUnit)newValue);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE:
				setUnitSQLModule((SQLModule)newValue);
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
			case DatabasePackage.DATABASE_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL:
				setArtifactDdl((DDLArtifact)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DML:
				setArtifactDml((DMLArtifact)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE:
				setCapabilityDatabase((Database)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE:
				setCapabilityDatabaseInstance((DatabaseInstance)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER:
				setCapabilitySqlUser((SQLUser)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE:
				setComponentDatabase((DatabaseComponent)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__INTERFACE_DDL:
				setInterfaceDdl((DDLInterface)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION:
				setServiceDatabaseDefinition((DatabaseDefinition)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT:
				setUnitDatabaseInstanceUnit((DatabaseInstanceUnit)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT:
				setUnitDatabaseUnit((DatabaseUnit)null);
				return;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE:
				setUnitSQLModule((SQLModule)null);
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
			case DatabasePackage.DATABASE_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DDL:
				return getArtifactDdl() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__ARTIFACT_DML:
				return getArtifactDml() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE:
				return getCapabilityDatabase() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE:
				return getCapabilityDatabaseInstance() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER:
				return getCapabilitySqlUser() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE:
				return getComponentDatabase() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__INTERFACE_DDL:
				return getInterfaceDdl() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION:
				return getServiceDatabaseDefinition() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT:
				return getUnitDatabaseInstanceUnit() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT:
				return getUnitDatabaseUnit() != null;
			case DatabasePackage.DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE:
				return getUnitSQLModule() != null;
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

} //DatabaseDeployRootImpl
