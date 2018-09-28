/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdbcProvider <em>Capability Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdk <em>Capability Jdk</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJre <em>Capability Jre</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJvmConfig <em>Capability Jvm Config</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdbcProviderUnit <em>Unit Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdk <em>Unit Jdk</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJre <em>Unit Jre</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface JavaDeployRoot {
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
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Jdbc Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jdbc Provider</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Jdbc Provider</em>' containment reference.
	 * @see #setCapabilityJdbcProvider(JdbcProvider)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_CapabilityJdbcProvider()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jdbcProvider' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JdbcProvider getCapabilityJdbcProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdbcProvider <em>Capability Jdbc Provider</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jdbc Provider</em>' containment reference.
	 * @see #getCapabilityJdbcProvider()
	 * @generated
	 */
	void setCapabilityJdbcProvider(JdbcProvider value);

	/**
	 * Returns the value of the '<em><b>Capability Jdk</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jdk</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Jdk</em>' containment reference.
	 * @see #setCapabilityJdk(JDK)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_CapabilityJdk()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jdk' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JDK getCapabilityJdk();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdk <em>Capability Jdk</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jdk</em>' containment reference.
	 * @see #getCapabilityJdk()
	 * @generated
	 */
	void setCapabilityJdk(JDK value);

	/**
	 * Returns the value of the '<em><b>Capability Jre</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jre</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Jre</em>' containment reference.
	 * @see #setCapabilityJre(JRE)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_CapabilityJre()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jre' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JRE getCapabilityJre();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJre <em>Capability Jre</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jre</em>' containment reference.
	 * @see #getCapabilityJre()
	 * @generated
	 */
	void setCapabilityJre(JRE value);

	/**
	 * Returns the value of the '<em><b>Capability Jvm Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jvm Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Jvm Config</em>' containment reference.
	 * @see #setCapabilityJvmConfig(JVMConfig)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_CapabilityJvmConfig()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jvmConfig' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JVMConfig getCapabilityJvmConfig();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJvmConfig <em>Capability Jvm Config</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jvm Config</em>' containment reference.
	 * @see #getCapabilityJvmConfig()
	 * @generated
	 */
	void setCapabilityJvmConfig(JVMConfig value);

	/**
	 * Returns the value of the '<em><b>Unit Jdbc Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Jdbc Provider Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Jdbc Provider Unit</em>' containment reference.
	 * @see #setUnitJdbcProviderUnit(JdbcProviderUnit)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_UnitJdbcProviderUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.jdbcProviderUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JdbcProviderUnit getUnitJdbcProviderUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdbcProviderUnit <em>Unit Jdbc Provider Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Jdbc Provider Unit</em>' containment reference.
	 * @see #getUnitJdbcProviderUnit()
	 * @generated
	 */
	void setUnitJdbcProviderUnit(JdbcProviderUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Jdk</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Jdk</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Jdk</em>' containment reference.
	 * @see #setUnitJdk(JDKUnit)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_UnitJdk()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.jdk' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JDKUnit getUnitJdk();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdk <em>Unit Jdk</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Jdk</em>' containment reference.
	 * @see #getUnitJdk()
	 * @generated
	 */
	void setUnitJdk(JDKUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Jre</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Jre</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Jre</em>' containment reference.
	 * @see #setUnitJre(JREUnit)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJavaDeployRoot_UnitJre()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.jre' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JREUnit getUnitJre();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJre <em>Unit Jre</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Jre</em>' containment reference.
	 * @see #getUnitJre()
	 * @generated
	 */
	void setUnitJre(JREUnit value);

} // JavaDeployRoot
