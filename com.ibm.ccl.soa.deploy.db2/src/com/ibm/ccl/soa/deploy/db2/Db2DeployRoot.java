/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

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
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminClient <em>Capability Db2 Admin Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminServer <em>Capability Db2 Admin Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AppDevelClient <em>Capability Db2 App Devel Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2BaseInstance <em>Capability Db2 Base Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2CatalogedNode <em>Capability Db2 Cataloged Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Client <em>Capability Db2 Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2ClientInstance <em>Capability Db2 Client Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Database <em>Capability Db2 Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Instance <em>Capability Db2 Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2JdbcDriver <em>Capability Db2 Jdbc Driver</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2System <em>Capability Db2 System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2AdminServer <em>Capability Unix Db2 Admin Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2ClientInstance <em>Capability Unix Db2 Client Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2Instance <em>Capability Unix Db2 Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2System <em>Capability Unix Db2 System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2AdminServer <em>Capability Windows Db2 Admin Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2ClientInstance <em>Capability Windows Db2 Client Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2Instance <em>Capability Windows Db2 Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2System <em>Capability Windows Db2 System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminClientUnit <em>Unit Db2 Admin Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminServerUnit <em>Unit Db2 Admin Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AppDevelClientUnit <em>Unit Db2 App Devel Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2BaseClientUnit <em>Unit Db2 Base Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2CatalogUnit <em>Unit Db2 Catalog Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ClientInstanceUnit <em>Unit Db2 Client Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2DatabaseUnit <em>Unit Db2 Database Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ddl <em>Unit Db2ddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2InstanceUnit <em>Unit Db2 Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2NodeCatalogUnit <em>Unit Db2 Node Catalog Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2RuntimeClientUnit <em>Unit Db2 Runtime Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2SystemUnit <em>Unit Db2 System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface Db2DeployRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Db2 Admin Client</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Admin Client</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Admin Client</em>' containment reference.
	 * @see #setCapabilityDb2AdminClient(DB2AdminClient)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2AdminClient()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2AdminClient' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2AdminClient getCapabilityDb2AdminClient();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminClient <em>Capability Db2 Admin Client</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Admin Client</em>' containment reference.
	 * @see #getCapabilityDb2AdminClient()
	 * @generated
	 */
	void setCapabilityDb2AdminClient(DB2AdminClient value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Admin Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Admin Server</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Admin Server</em>' containment reference.
	 * @see #setCapabilityDb2AdminServer(DB2AdminServer)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2AdminServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2AdminServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2AdminServer getCapabilityDb2AdminServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminServer <em>Capability Db2 Admin Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Admin Server</em>' containment reference.
	 * @see #getCapabilityDb2AdminServer()
	 * @generated
	 */
	void setCapabilityDb2AdminServer(DB2AdminServer value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 App Devel Client</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 App Devel Client</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 App Devel Client</em>' containment reference.
	 * @see #setCapabilityDb2AppDevelClient(DB2AppDevelClient)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2AppDevelClient()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2AppDevelClient' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2AppDevelClient getCapabilityDb2AppDevelClient();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AppDevelClient <em>Capability Db2 App Devel Client</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 App Devel Client</em>' containment reference.
	 * @see #getCapabilityDb2AppDevelClient()
	 * @generated
	 */
	void setCapabilityDb2AppDevelClient(DB2AppDevelClient value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Base Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Base Instance</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Base Instance</em>' containment reference.
	 * @see #setCapabilityDb2BaseInstance(DB2BaseInstance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2BaseInstance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2BaseInstance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2BaseInstance getCapabilityDb2BaseInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2BaseInstance <em>Capability Db2 Base Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Base Instance</em>' containment reference.
	 * @see #getCapabilityDb2BaseInstance()
	 * @generated
	 */
	void setCapabilityDb2BaseInstance(DB2BaseInstance value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Cataloged Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Cataloged Node</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Cataloged Node</em>' containment reference.
	 * @see #setCapabilityDb2CatalogedNode(DB2CatalogedNode)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2CatalogedNode()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2CatalogedNode' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2CatalogedNode getCapabilityDb2CatalogedNode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2CatalogedNode <em>Capability Db2 Cataloged Node</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Cataloged Node</em>' containment reference.
	 * @see #getCapabilityDb2CatalogedNode()
	 * @generated
	 */
	void setCapabilityDb2CatalogedNode(DB2CatalogedNode value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Client</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Client</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Client</em>' containment reference.
	 * @see #setCapabilityDb2Client(DB2Client)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2Client()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2Client' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Client getCapabilityDb2Client();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Client <em>Capability Db2 Client</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Client</em>' containment reference.
	 * @see #getCapabilityDb2Client()
	 * @generated
	 */
	void setCapabilityDb2Client(DB2Client value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Client Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Client Instance</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Client Instance</em>' containment reference.
	 * @see #setCapabilityDb2ClientInstance(DB2ClientInstance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2ClientInstance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2ClientInstance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2ClientInstance getCapabilityDb2ClientInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2ClientInstance <em>Capability Db2 Client Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Client Instance</em>' containment reference.
	 * @see #getCapabilityDb2ClientInstance()
	 * @generated
	 */
	void setCapabilityDb2ClientInstance(DB2ClientInstance value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Database</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Database</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Database</em>' containment reference.
	 * @see #setCapabilityDb2Database(DB2Database)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2Database()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2Database' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Database getCapabilityDb2Database();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Database <em>Capability Db2 Database</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Database</em>' containment reference.
	 * @see #getCapabilityDb2Database()
	 * @generated
	 */
	void setCapabilityDb2Database(DB2Database value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Instance</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Instance</em>' containment reference.
	 * @see #setCapabilityDb2Instance(DB2Instance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2Instance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2Instance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Instance getCapabilityDb2Instance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Instance <em>Capability Db2 Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Instance</em>' containment reference.
	 * @see #getCapabilityDb2Instance()
	 * @generated
	 */
	void setCapabilityDb2Instance(DB2Instance value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 Jdbc Driver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Jdbc Driver</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Jdbc Driver</em>' containment reference.
	 * @see #setCapabilityDb2JdbcDriver(DB2JdbcDriver)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2JdbcDriver()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2JdbcDriver' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2JdbcDriver getCapabilityDb2JdbcDriver();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2JdbcDriver <em>Capability Db2 Jdbc Driver</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Jdbc Driver</em>' containment reference.
	 * @see #getCapabilityDb2JdbcDriver()
	 * @generated
	 */
	void setCapabilityDb2JdbcDriver(DB2JdbcDriver value);

	/**
	 * Returns the value of the '<em><b>Capability Db2 System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 System</em>' containment reference.
	 * @see #setCapabilityDb2System(DB2System)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityDb2System()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2System' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2System getCapabilityDb2System();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2System <em>Capability Db2 System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 System</em>' containment reference.
	 * @see #getCapabilityDb2System()
	 * @generated
	 */
	void setCapabilityDb2System(DB2System value);

	/**
	 * Returns the value of the '<em><b>Capability Unix Db2 Admin Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Unix Db2 Admin Server</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Unix Db2 Admin Server</em>' containment reference.
	 * @see #setCapabilityUnixDb2AdminServer(UnixDB2AdminServer)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityUnixDb2AdminServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.unixDb2AdminServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UnixDB2AdminServer getCapabilityUnixDb2AdminServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2AdminServer <em>Capability Unix Db2 Admin Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Unix Db2 Admin Server</em>' containment reference.
	 * @see #getCapabilityUnixDb2AdminServer()
	 * @generated
	 */
	void setCapabilityUnixDb2AdminServer(UnixDB2AdminServer value);

	/**
	 * Returns the value of the '<em><b>Capability Unix Db2 Client Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Unix Db2 Client Instance</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Unix Db2 Client Instance</em>' containment reference.
	 * @see #setCapabilityUnixDb2ClientInstance(UnixDB2ClientInstance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityUnixDb2ClientInstance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.unixDb2ClientInstance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UnixDB2ClientInstance getCapabilityUnixDb2ClientInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2ClientInstance <em>Capability Unix Db2 Client Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Unix Db2 Client Instance</em>' containment reference.
	 * @see #getCapabilityUnixDb2ClientInstance()
	 * @generated
	 */
	void setCapabilityUnixDb2ClientInstance(UnixDB2ClientInstance value);

	/**
	 * Returns the value of the '<em><b>Capability Unix Db2 Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Unix Db2 Instance</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Unix Db2 Instance</em>' containment reference.
	 * @see #setCapabilityUnixDb2Instance(UnixDB2Instance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityUnixDb2Instance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.unixDb2Instance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UnixDB2Instance getCapabilityUnixDb2Instance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2Instance <em>Capability Unix Db2 Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Unix Db2 Instance</em>' containment reference.
	 * @see #getCapabilityUnixDb2Instance()
	 * @generated
	 */
	void setCapabilityUnixDb2Instance(UnixDB2Instance value);

	/**
	 * Returns the value of the '<em><b>Capability Unix Db2 System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Unix Db2 System</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Unix Db2 System</em>' containment reference.
	 * @see #setCapabilityUnixDb2System(UnixDB2System)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityUnixDb2System()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.unixDb2System' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UnixDB2System getCapabilityUnixDb2System();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2System <em>Capability Unix Db2 System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Unix Db2 System</em>' containment reference.
	 * @see #getCapabilityUnixDb2System()
	 * @generated
	 */
	void setCapabilityUnixDb2System(UnixDB2System value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Db2 Admin Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Db2 Admin Server</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Db2 Admin Server</em>' containment reference.
	 * @see #setCapabilityWindowsDb2AdminServer(WindowsDB2AdminServer)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityWindowsDb2AdminServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsDb2AdminServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsDB2AdminServer getCapabilityWindowsDb2AdminServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2AdminServer <em>Capability Windows Db2 Admin Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Db2 Admin Server</em>' containment reference.
	 * @see #getCapabilityWindowsDb2AdminServer()
	 * @generated
	 */
	void setCapabilityWindowsDb2AdminServer(WindowsDB2AdminServer value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Db2 Client Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Db2 Client Instance</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Db2 Client Instance</em>' containment reference.
	 * @see #setCapabilityWindowsDb2ClientInstance(WindowsDB2ClientInstance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityWindowsDb2ClientInstance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsDb2ClientInstance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsDB2ClientInstance getCapabilityWindowsDb2ClientInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2ClientInstance <em>Capability Windows Db2 Client Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Db2 Client Instance</em>' containment reference.
	 * @see #getCapabilityWindowsDb2ClientInstance()
	 * @generated
	 */
	void setCapabilityWindowsDb2ClientInstance(WindowsDB2ClientInstance value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Db2 Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Db2 Instance</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Db2 Instance</em>' containment reference.
	 * @see #setCapabilityWindowsDb2Instance(WindowsDB2Instance)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityWindowsDb2Instance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsDb2Instance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsDB2Instance getCapabilityWindowsDb2Instance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2Instance <em>Capability Windows Db2 Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Db2 Instance</em>' containment reference.
	 * @see #getCapabilityWindowsDb2Instance()
	 * @generated
	 */
	void setCapabilityWindowsDb2Instance(WindowsDB2Instance value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Db2 System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Db2 System</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Db2 System</em>' containment reference.
	 * @see #setCapabilityWindowsDb2System(WindowsDB2System)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_CapabilityWindowsDb2System()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsDb2System' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsDB2System getCapabilityWindowsDb2System();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2System <em>Capability Windows Db2 System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Db2 System</em>' containment reference.
	 * @see #getCapabilityWindowsDb2System()
	 * @generated
	 */
	void setCapabilityWindowsDb2System(WindowsDB2System value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Admin Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Admin Client Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Admin Client Unit</em>' containment reference.
	 * @see #setUnitDb2AdminClientUnit(DB2AdminClientUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2AdminClientUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2AdminClientUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2AdminClientUnit getUnitDb2AdminClientUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminClientUnit <em>Unit Db2 Admin Client Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Admin Client Unit</em>' containment reference.
	 * @see #getUnitDb2AdminClientUnit()
	 * @generated
	 */
	void setUnitDb2AdminClientUnit(DB2AdminClientUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Admin Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Admin Server Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Admin Server Unit</em>' containment reference.
	 * @see #setUnitDb2AdminServerUnit(DB2AdminServerUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2AdminServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2AdminServerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2AdminServerUnit getUnitDb2AdminServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminServerUnit <em>Unit Db2 Admin Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Admin Server Unit</em>' containment reference.
	 * @see #getUnitDb2AdminServerUnit()
	 * @generated
	 */
	void setUnitDb2AdminServerUnit(DB2AdminServerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 App Devel Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 App Devel Client Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 App Devel Client Unit</em>' containment reference.
	 * @see #setUnitDb2AppDevelClientUnit(DB2AppDevelClientUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2AppDevelClientUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2AppDevelClientUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2AppDevelClientUnit getUnitDb2AppDevelClientUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AppDevelClientUnit <em>Unit Db2 App Devel Client Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 App Devel Client Unit</em>' containment reference.
	 * @see #getUnitDb2AppDevelClientUnit()
	 * @generated
	 */
	void setUnitDb2AppDevelClientUnit(DB2AppDevelClientUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Base Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Base Client Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Base Client Unit</em>' containment reference.
	 * @see #setUnitDb2BaseClientUnit(DB2BaseClientUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2BaseClientUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2BaseClientUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2BaseClientUnit getUnitDb2BaseClientUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2BaseClientUnit <em>Unit Db2 Base Client Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Base Client Unit</em>' containment reference.
	 * @see #getUnitDb2BaseClientUnit()
	 * @generated
	 */
	void setUnitDb2BaseClientUnit(DB2BaseClientUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Catalog Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Catalog Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Catalog Unit</em>' containment reference.
	 * @see #setUnitDb2CatalogUnit(DB2CatalogUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2CatalogUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2CatalogUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2CatalogUnit getUnitDb2CatalogUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2CatalogUnit <em>Unit Db2 Catalog Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Catalog Unit</em>' containment reference.
	 * @see #getUnitDb2CatalogUnit()
	 * @generated
	 */
	void setUnitDb2CatalogUnit(DB2CatalogUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Client Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Client Instance Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Client Instance Unit</em>' containment reference.
	 * @see #setUnitDb2ClientInstanceUnit(DB2ClientInstanceUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2ClientInstanceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2ClientInstanceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2ClientInstanceUnit getUnitDb2ClientInstanceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ClientInstanceUnit <em>Unit Db2 Client Instance Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Client Instance Unit</em>' containment reference.
	 * @see #getUnitDb2ClientInstanceUnit()
	 * @generated
	 */
	void setUnitDb2ClientInstanceUnit(DB2ClientInstanceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Database Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Database Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Database Unit</em>' containment reference.
	 * @see #setUnitDb2DatabaseUnit(DB2DatabaseUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2DatabaseUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2DatabaseUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2DatabaseUnit getUnitDb2DatabaseUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2DatabaseUnit <em>Unit Db2 Database Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Database Unit</em>' containment reference.
	 * @see #getUnitDb2DatabaseUnit()
	 * @generated
	 */
	void setUnitDb2DatabaseUnit(DB2DatabaseUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2ddl</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2ddl</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Db2ddl</em>' containment reference.
	 * @see #setUnitDb2ddl(DB2DDLArtifact)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2ddl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2ddl' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	DB2DDLArtifact getUnitDb2ddl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ddl <em>Unit Db2ddl</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2ddl</em>' containment reference.
	 * @see #getUnitDb2ddl()
	 * @generated
	 */
	void setUnitDb2ddl(DB2DDLArtifact value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Instance Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Instance Unit</em>' containment reference.
	 * @see #setUnitDb2InstanceUnit(DB2InstanceUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2InstanceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2InstanceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2InstanceUnit getUnitDb2InstanceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2InstanceUnit <em>Unit Db2 Instance Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Instance Unit</em>' containment reference.
	 * @see #getUnitDb2InstanceUnit()
	 * @generated
	 */
	void setUnitDb2InstanceUnit(DB2InstanceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Node Catalog Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Node Catalog Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Node Catalog Unit</em>' containment reference.
	 * @see #setUnitDb2NodeCatalogUnit(DB2NodeCatalogUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2NodeCatalogUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2NodeCatalogUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2NodeCatalogUnit getUnitDb2NodeCatalogUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2NodeCatalogUnit <em>Unit Db2 Node Catalog Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Node Catalog Unit</em>' containment reference.
	 * @see #getUnitDb2NodeCatalogUnit()
	 * @generated
	 */
	void setUnitDb2NodeCatalogUnit(DB2NodeCatalogUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Runtime Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Runtime Client Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Runtime Client Unit</em>' containment reference.
	 * @see #setUnitDb2RuntimeClientUnit(DB2RuntimeClientUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2RuntimeClientUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2RuntimeClientUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2RuntimeClientUnit getUnitDb2RuntimeClientUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2RuntimeClientUnit <em>Unit Db2 Runtime Client Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Runtime Client Unit</em>' containment reference.
	 * @see #getUnitDb2RuntimeClientUnit()
	 * @generated
	 */
	void setUnitDb2RuntimeClientUnit(DB2RuntimeClientUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 System Unit</em>' containment reference.
	 * @see #setUnitDb2SystemUnit(DB2SystemUnit)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDb2DeployRoot_UnitDb2SystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2SystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2SystemUnit getUnitDb2SystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2SystemUnit <em>Unit Db2 System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 System Unit</em>' containment reference.
	 * @see #getUnitDb2SystemUnit()
	 * @generated
	 */
	void setUnitDb2SystemUnit(DB2SystemUnit value);

} // Db2DeployRoot
