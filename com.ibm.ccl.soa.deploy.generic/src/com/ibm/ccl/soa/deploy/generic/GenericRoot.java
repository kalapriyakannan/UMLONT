/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.generic;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Root</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.generic.GenericRoot#getMixed <em>Mixed</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.generic.GenericRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.generic.GenericRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.generic.GenericRoot#getCapabilityGeneric <em>Capability Generic</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.generic.GenericRoot#getUnitGenericUnit <em>Unit Generic Unit</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.generic.GenericPackage#getGenericRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface GenericRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list. The list contents are of
	 * type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericPackage#getGenericRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.generic.GenericPackage#getGenericRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.generic.GenericPackage#getGenericRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Generic</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Generic</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Generic</em>' containment reference.
	 * @see #setCapabilityGeneric(Generic)
	 * @see com.ibm.ccl.soa.deploy.generic.GenericPackage#getGenericRoot_CapabilityGeneric()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.generic'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Generic getCapabilityGeneric();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.generic.GenericRoot#getCapabilityGeneric <em>Capability Generic</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Capability Generic</em>' containment reference.
	 * @see #getCapabilityGeneric()
	 * @generated
	 */
	void setCapabilityGeneric(Generic value);

} // GenericRoot
