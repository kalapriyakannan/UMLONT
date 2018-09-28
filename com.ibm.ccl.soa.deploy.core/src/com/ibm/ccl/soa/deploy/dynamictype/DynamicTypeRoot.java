/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Type Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteEntry <em>Dynamic Palette Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteStack <em>Dynamic Palette Stack</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicTypes <em>Dynamic Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DynamicTypeRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Dynamic Palette Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Palette Entry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Palette Entry</em>' containment reference.
	 * @see #setDynamicPaletteEntry(DynamicPaletteEntry)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot_DynamicPaletteEntry()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='dynamicPaletteEntry' namespace='##targetNamespace'"
	 * @generated
	 */
	DynamicPaletteEntry getDynamicPaletteEntry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteEntry <em>Dynamic Palette Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Palette Entry</em>' containment reference.
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	void setDynamicPaletteEntry(DynamicPaletteEntry value);

	/**
	 * Returns the value of the '<em><b>Dynamic Palette Stack</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Palette Stack</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Palette Stack</em>' containment reference.
	 * @see #setDynamicPaletteStack(DynamicPaletteStack)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot_DynamicPaletteStack()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='dynamicPaletteStack' namespace='##targetNamespace'"
	 * @generated
	 */
	DynamicPaletteStack getDynamicPaletteStack();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteStack <em>Dynamic Palette Stack</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Palette Stack</em>' containment reference.
	 * @see #getDynamicPaletteStack()
	 * @generated
	 */
	void setDynamicPaletteStack(DynamicPaletteStack value);

	/**
	 * Returns the value of the '<em><b>Dynamic Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Types</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Types</em>' containment reference.
	 * @see #setDynamicTypes(DynamicTypes)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypeRoot_DynamicTypes()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='dynamicTypes' namespace='##targetNamespace'"
	 * @generated
	 */
	DynamicTypes getDynamicTypes();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicTypes <em>Dynamic Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Types</em>' containment reference.
	 * @see #getDynamicTypes()
	 * @generated
	 */
	void setDynamicTypes(DynamicTypes value);

} // DynamicTypeRoot
