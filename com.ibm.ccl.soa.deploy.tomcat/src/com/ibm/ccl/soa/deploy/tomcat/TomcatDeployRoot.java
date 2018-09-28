/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat;

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
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcat50datasource <em>Capability Tomcat50datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcatServer <em>Capability Tomcat Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatdatasource <em>Unit Tomcatdatasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatWebServer <em>Unit Tomcat Web Server</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface TomcatDeployRoot extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Tomcat50datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Tomcat50datasource</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Tomcat50datasource</em>' containment reference.
	 * @see #setCapabilityTomcat50datasource(Tomcat50Datasource)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_CapabilityTomcat50datasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.tomcat50datasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Tomcat50Datasource getCapabilityTomcat50datasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcat50datasource <em>Capability Tomcat50datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Tomcat50datasource</em>' containment reference.
	 * @see #getCapabilityTomcat50datasource()
	 * @generated
	 */
	void setCapabilityTomcat50datasource(Tomcat50Datasource value);

	/**
	 * Returns the value of the '<em><b>Capability Tomcat Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Tomcat Server</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Tomcat Server</em>' containment reference.
	 * @see #setCapabilityTomcatServer(TomcatServer)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_CapabilityTomcatServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.tomcatServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	TomcatServer getCapabilityTomcatServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcatServer <em>Capability Tomcat Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Tomcat Server</em>' containment reference.
	 * @see #getCapabilityTomcatServer()
	 * @generated
	 */
	void setCapabilityTomcatServer(TomcatServer value);

	/**
	 * Returns the value of the '<em><b>Unit Tomcatdatasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Tomcatdatasource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Tomcatdatasource</em>' containment reference.
	 * @see #setUnitTomcatdatasource(TomcatDatasourceUnit)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_UnitTomcatdatasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.tomcatdatasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	TomcatDatasourceUnit getUnitTomcatdatasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatdatasource <em>Unit Tomcatdatasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Tomcatdatasource</em>' containment reference.
	 * @see #getUnitTomcatdatasource()
	 * @generated
	 */
	void setUnitTomcatdatasource(TomcatDatasourceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Tomcat Web Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Tomcat Web Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Tomcat Web Server</em>' containment reference.
	 * @see #setUnitTomcatWebServer(TomcatWebServerUnit)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatDeployRoot_UnitTomcatWebServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.tomcatWebServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	TomcatWebServerUnit getUnitTomcatWebServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatWebServer <em>Unit Tomcat Web Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Tomcat Web Server</em>' containment reference.
	 * @see #getUnitTomcatWebServer()
	 * @generated
	 */
	void setUnitTomcatWebServer(TomcatWebServerUnit value);

} // TomcatDeployRoot
