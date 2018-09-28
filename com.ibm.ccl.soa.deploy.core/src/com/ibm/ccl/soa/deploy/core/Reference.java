/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A Reference declares an interface that is required by
 * 				the implementation that backs the {@link
 * 				ApplicationComponent} in order to function properly.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Reference#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getReference()
 * @model features="interfaceGroup interface" 
 *        interfaceGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" interfaceGroupRequired="true" interfaceGroupMany="false" interfaceGroupSuppressedGetVisibility="true" interfaceGroupSuppressedSetVisibility="true"
 *        interfaceGroupExtendedMetaData="kind='group' name='interface:group' namespace='##targetNamespace'"
 *        interfaceType="com.ibm.ccl.soa.deploy.core.Interface" interfaceContainment="true" interfaceRequired="true" interfaceTransient="true" interfaceVolatile="true" interfaceDerived="true" interfaceSuppressedGetVisibility="true" interfaceSuppressedSetVisibility="true"
 *        interfaceExtendedMetaData="kind='element' name='interface' namespace='##targetNamespace' group='interface:group'"
 *        extendedMetaData="name='Reference' kind='elementOnly'"
 * @generated
 */
public interface Reference extends Requirement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(Interface)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getReference_Interface()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface' namespace='##targetNamespace'
	 *        group='interface:group'"
	 * 
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Reference#getInterface <em>Interface</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * 
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' attribute.
	 * @see #setRange(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getReference_Range()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.ServiceRange"
	 *        extendedMetaData="kind='attribute' name='range'"
	 * @generated
	 */
	String getRange();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Reference#getRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(String value);

} // Reference
