/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Root</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getCapabilityServer <em>Capability Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getUnitServerUnit <em>Unit Server Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServerRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface ServerRoot {
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
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServerRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServerRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

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
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServerRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Server</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Server</em>' containment reference.
	 * @see #setCapabilityServer(Server)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServerRoot_CapabilityServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.server' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Server getCapabilityServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getCapabilityServer <em>Capability Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Server</em>' containment reference.
	 * @see #getCapabilityServer()
	 * @generated
	 */
	void setCapabilityServer(Server value);

	/**
	 * Returns the value of the '<em><b>Unit Server Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Server Unit</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Server Unit</em>' containment reference.
	 * @see #setUnitServerUnit(ServerUnit)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServerRoot_UnitServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.serverUnit' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	ServerUnit getUnitServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getUnitServerUnit <em>Unit Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Server Unit</em>' containment reference.
	 * @see #getUnitServerUnit()
	 * @generated
	 */
	void setUnitServerUnit(ServerUnit value);

} // ServerRoot
