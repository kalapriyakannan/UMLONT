/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Was Web Plugin Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getCapabilityIhsWasPlugin <em>Capability Ihs Was Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getConstraintWasWebServerToIhsConstraint <em>Constraint Was Web Server To Ihs Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getUnitIhsWasPluginUnit <em>Unit Ihs Was Plugin Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface WasWebPluginDeployRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Ihs Was Plugin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs Was Plugin</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs Was Plugin</em>' containment reference.
	 * @see #setCapabilityIhsWasPlugin(IhsWasPlugin)
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot_CapabilityIhsWasPlugin()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsWasPlugin' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsWasPlugin getCapabilityIhsWasPlugin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getCapabilityIhsWasPlugin <em>Capability Ihs Was Plugin</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs Was Plugin</em>' containment reference.
	 * @see #getCapabilityIhsWasPlugin()
	 * @generated
	 */
	void setCapabilityIhsWasPlugin(IhsWasPlugin value);

	/**
	 * Returns the value of the '<em><b>Constraint Was Web Server To Ihs Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was Web Server To Ihs Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was Web Server To Ihs Constraint</em>' containment reference.
	 * @see #setConstraintWasWebServerToIhsConstraint(WasWebServerToIhsConstraint)
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot_ConstraintWasWebServerToIhsConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.WasWebServerToIhsConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasWebServerToIhsConstraint getConstraintWasWebServerToIhsConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getConstraintWasWebServerToIhsConstraint <em>Constraint Was Web Server To Ihs Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was Web Server To Ihs Constraint</em>' containment reference.
	 * @see #getConstraintWasWebServerToIhsConstraint()
	 * @generated
	 */
	void setConstraintWasWebServerToIhsConstraint(WasWebServerToIhsConstraint value);

	/**
	 * Returns the value of the '<em><b>Unit Ihs Was Plugin Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ihs Was Plugin Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ihs Was Plugin Unit</em>' containment reference.
	 * @see #setUnitIhsWasPluginUnit(IhsWasPluginUnit)
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getWasWebPluginDeployRoot_UnitIhsWasPluginUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ihsWasPluginUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IhsWasPluginUnit getUnitIhsWasPluginUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getUnitIhsWasPluginUnit <em>Unit Ihs Was Plugin Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ihs Was Plugin Unit</em>' containment reference.
	 * @see #getUnitIhsWasPluginUnit()
	 * @generated
	 */
	void setUnitIhsWasPluginUnit(IhsWasPluginUnit value);

} // WasWebPluginDeployRoot
