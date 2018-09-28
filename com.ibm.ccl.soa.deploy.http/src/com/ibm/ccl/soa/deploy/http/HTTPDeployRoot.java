/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>HTTP Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getCapabilityHttpServer <em>Capability Http Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getCapabilityHttpUser <em>Capability Http User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getCapabilityStaticWebComponent <em>Capability Static Web Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getComponentStaticWeb <em>Component Static Web</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getUnitHttpServerUnit <em>Unit Http Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getUnitHttpUserUnit <em>Unit Http User Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface HTTPDeployRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Http Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Http Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Http Server</em>' containment reference.
	 * @see #setCapabilityHttpServer(HttpServer)
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_CapabilityHttpServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.httpServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	HttpServer getCapabilityHttpServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getCapabilityHttpServer <em>Capability Http Server</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Http Server</em>' containment reference.
	 * @see #getCapabilityHttpServer()
	 * @generated
	 */
	void setCapabilityHttpServer(HttpServer value);

	/**
	 * Returns the value of the '<em><b>Capability Http User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Http User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Http User</em>' containment reference.
	 * @see #setCapabilityHttpUser(HttpUser)
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_CapabilityHttpUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.httpUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	HttpUser getCapabilityHttpUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getCapabilityHttpUser <em>Capability Http User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Http User</em>' containment reference.
	 * @see #getCapabilityHttpUser()
	 * @generated
	 */
	void setCapabilityHttpUser(HttpUser value);

	/**
	 * Returns the value of the '<em><b>Capability Static Web Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Static Web Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Static Web Component</em>' containment reference.
	 * @see #setCapabilityStaticWebComponent(StaticWebComponent)
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_CapabilityStaticWebComponent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.staticWebComponent' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	StaticWebComponent getCapabilityStaticWebComponent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getCapabilityStaticWebComponent <em>Capability Static Web Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Static Web Component</em>' containment reference.
	 * @see #getCapabilityStaticWebComponent()
	 * @generated
	 */
	void setCapabilityStaticWebComponent(StaticWebComponent value);

	/**
	 * Returns the value of the '<em><b>Component Static Web</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Static Web</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Static Web</em>' containment reference.
	 * @see #setComponentStaticWeb(StaticWebComponentUnit)
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_ComponentStaticWeb()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.staticWeb' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	StaticWebComponentUnit getComponentStaticWeb();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getComponentStaticWeb <em>Component Static Web</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Static Web</em>' containment reference.
	 * @see #getComponentStaticWeb()
	 * @generated
	 */
	void setComponentStaticWeb(StaticWebComponentUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Http Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Http Server Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Http Server Unit</em>' containment reference.
	 * @see #setUnitHttpServerUnit(HttpServerUnit)
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_UnitHttpServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.httpServerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	HttpServerUnit getUnitHttpServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.http.HTTPDeployRoot#getUnitHttpServerUnit <em>Unit Http Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Http Server Unit</em>' containment reference.
	 * @see #getUnitHttpServerUnit()
	 * @generated
	 */
	void setUnitHttpServerUnit(HttpServerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Http User Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Http User Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Http User Unit</em>' containment reference.
	 * @see com.ibm.ccl.soa.deploy.http.HttpPackage#getHTTPDeployRoot_UnitHttpUserUnit()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.httpUserUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	HttpUserUnit getUnitHttpUserUnit();

} // HTTPDeployRoot
