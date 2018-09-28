/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDdl <em>Artifact Ddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDml <em>Artifact Dml</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabase <em>Capability Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabaseInstance <em>Capability Database Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilitySqlUser <em>Capability Sql User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getComponentDatabase <em>Component Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getInterfaceDdl <em>Interface Ddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getServiceDatabaseDefinition <em>Service Database Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseInstanceUnit <em>Unit Database Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseUnit <em>Unit Database Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitSQLModule <em>Unit SQL Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DatabaseDeployRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Artifact Ddl</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact Ddl</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artifact Ddl</em>' containment reference.
	 * @see #setArtifactDdl(DDLArtifact)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_ArtifactDdl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='artifact.ddl' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	DDLArtifact getArtifactDdl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDdl <em>Artifact Ddl</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Ddl</em>' containment reference.
	 * @see #getArtifactDdl()
	 * @generated
	 */
	void setArtifactDdl(DDLArtifact value);

	/**
	 * Returns the value of the '<em><b>Artifact Dml</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact Dml</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artifact Dml</em>' containment reference.
	 * @see #setArtifactDml(DMLArtifact)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_ArtifactDml()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='artifact.dml' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	DMLArtifact getArtifactDml();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDml <em>Artifact Dml</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Dml</em>' containment reference.
	 * @see #getArtifactDml()
	 * @generated
	 */
	void setArtifactDml(DMLArtifact value);

	/**
	 * Returns the value of the '<em><b>Capability Database</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Database</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							This is the capability definition for a database.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capability Database</em>' containment reference.
	 * @see #setCapabilityDatabase(Database)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_CapabilityDatabase()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.database' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Database getCapabilityDatabase();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabase <em>Capability Database</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Database</em>' containment reference.
	 * @see #getCapabilityDatabase()
	 * @generated
	 */
	void setCapabilityDatabase(Database value);

	/**
	 * Returns the value of the '<em><b>Capability Database Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Database Instance</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							This is the capability definition for a database instance.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capability Database Instance</em>' containment reference.
	 * @see #setCapabilityDatabaseInstance(DatabaseInstance)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_CapabilityDatabaseInstance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.databaseInstance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DatabaseInstance getCapabilityDatabaseInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabaseInstance <em>Capability Database Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Database Instance</em>' containment reference.
	 * @see #getCapabilityDatabaseInstance()
	 * @generated
	 */
	void setCapabilityDatabaseInstance(DatabaseInstance value);

	/**
	 * Returns the value of the '<em><b>Component Database</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Database</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Component Database</em>' containment reference.
	 * @see #setComponentDatabase(DatabaseComponent)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_ComponentDatabase()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.database'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#component'"
	 * @generated
	 */
	DatabaseComponent getComponentDatabase();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getComponentDatabase <em>Component Database</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Database</em>' containment reference.
	 * @see #getComponentDatabase()
	 * @generated
	 */
	void setComponentDatabase(DatabaseComponent value);

	/**
	 * Returns the value of the '<em><b>Interface Ddl</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Ddl</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface Ddl</em>' containment reference.
	 * @see #setInterfaceDdl(DDLInterface)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_InterfaceDdl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface.ddl' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface'"
	 * @generated
	 */
	DDLInterface getInterfaceDdl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getInterfaceDdl <em>Interface Ddl</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Ddl</em>' containment reference.
	 * @see #getInterfaceDdl()
	 * @generated
	 */
	void setInterfaceDdl(DDLInterface value);

	/**
	 * Returns the value of the '<em><b>Service Database Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Database Definition</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							This is the service definition for a database definition.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Database Definition</em>' containment reference.
	 * @see #setServiceDatabaseDefinition(DatabaseDefinition)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_ServiceDatabaseDefinition()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service.databaseDefinition' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#service'"
	 * @generated
	 */
	DatabaseDefinition getServiceDatabaseDefinition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getServiceDatabaseDefinition <em>Service Database Definition</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Database Definition</em>' containment reference.
	 * @see #getServiceDatabaseDefinition()
	 * @generated
	 */
	void setServiceDatabaseDefinition(DatabaseDefinition value);

	/**
	 * Returns the value of the '<em><b>Capability Sql User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Sql User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							This is the capability definition for a sql user.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capability Sql User</em>' containment reference.
	 * @see #setCapabilitySqlUser(SQLUser)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_CapabilitySqlUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.sqlUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SQLUser getCapabilitySqlUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilitySqlUser <em>Capability Sql User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Sql User</em>' containment reference.
	 * @see #getCapabilitySqlUser()
	 * @generated
	 */
	void setCapabilitySqlUser(SQLUser value);

	/**
	 * Returns the value of the '<em><b>Unit Database Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Database Instance Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							This is the unit definition for a database instance.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Database Instance Unit</em>' containment reference.
	 * @see #setUnitDatabaseInstanceUnit(DatabaseInstanceUnit)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_UnitDatabaseInstanceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.databaseInstanceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DatabaseInstanceUnit getUnitDatabaseInstanceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseInstanceUnit <em>Unit Database Instance Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Database Instance Unit</em>' containment reference.
	 * @see #getUnitDatabaseInstanceUnit()
	 * @generated
	 */
	void setUnitDatabaseInstanceUnit(DatabaseInstanceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Database Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Database Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Database Unit</em>' containment reference.
	 * @see #setUnitDatabaseUnit(DatabaseUnit)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_UnitDatabaseUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.databaseUnit' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DatabaseUnit getUnitDatabaseUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseUnit <em>Unit Database Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Database Unit</em>' containment reference.
	 * @see #getUnitDatabaseUnit()
	 * @generated
	 */
	void setUnitDatabaseUnit(DatabaseUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SQL Module</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SQL Module</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit SQL Module</em>' containment reference.
	 * @see #setUnitSQLModule(SQLModule)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDatabaseDeployRoot_UnitSQLModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SQLModule' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SQLModule getUnitSQLModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitSQLModule <em>Unit SQL Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SQL Module</em>' containment reference.
	 * @see #getUnitSQLModule()
	 * @generated
	 */
	void setUnitSQLModule(SQLModule value);

} // DatabaseDeployRoot
