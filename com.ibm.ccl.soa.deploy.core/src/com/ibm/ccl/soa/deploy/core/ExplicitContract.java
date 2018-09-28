/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Explicit Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 						A configuration contract that exposes user-chosen content as visible and configurable.
 * 					
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getExportedUnits <em>Exported Units</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultConceptualPolicy <em>Default Conceptual Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultPolicy <em>Default Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExplicitContract()
 * @model extendedMetaData="name='ExplicitContract' kind='elementOnly'"
 * @generated
 */
public interface ExplicitContract extends ConfigurationContract {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Exported Units</b></em>' containment reference list. The
	 * list contents are of type {@link com.ibm.ccl.soa.deploy.core.ExportedUnit}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exported Units</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExplicitContract_ExportedUnits()
	 * @model type="com.ibm.ccl.soa.deploy.core.ExportedUnit" containment="true"
	 *        extendedMetaData="kind='element' name='exported.unit' namespace='##targetNamespace'"
	 * @generated
	 */
	List getExportedUnits();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Property}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExplicitContract_Properties()
	 * @model type="com.ibm.ccl.soa.deploy.core.Property" containment="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	List getProperties();

	/**
	 * Returns the value of the '<em><b>Default Conceptual Policy</b></em>' attribute.
	 * The default value is <code>"private"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.core.Visibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Conceptual Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Conceptual Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see #isSetDefaultConceptualPolicy()
	 * @see #unsetDefaultConceptualPolicy()
	 * @see #setDefaultConceptualPolicy(Visibility)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExplicitContract_DefaultConceptualPolicy()
	 * @model default="private" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='defaultConceptualPolicy'"
	 * @generated
	 */
	Visibility getDefaultConceptualPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultConceptualPolicy <em>Default Conceptual Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Conceptual Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see #isSetDefaultConceptualPolicy()
	 * @see #unsetDefaultConceptualPolicy()
	 * @see #getDefaultConceptualPolicy()
	 * @generated
	 */
	void setDefaultConceptualPolicy(Visibility value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultConceptualPolicy <em>Default Conceptual Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefaultConceptualPolicy()
	 * @see #getDefaultConceptualPolicy()
	 * @see #setDefaultConceptualPolicy(Visibility)
	 * @generated
	 */
	void unsetDefaultConceptualPolicy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultConceptualPolicy <em>Default Conceptual Policy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Default Conceptual Policy</em>' attribute is set.
	 * @see #unsetDefaultConceptualPolicy()
	 * @see #getDefaultConceptualPolicy()
	 * @see #setDefaultConceptualPolicy(Visibility)
	 * @generated
	 */
	boolean isSetDefaultConceptualPolicy();

	/**
	 * Returns the value of the '<em><b>Default Policy</b></em>' attribute.
	 * The default value is <code>"private"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.core.Visibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see #isSetDefaultPolicy()
	 * @see #unsetDefaultPolicy()
	 * @see #setDefaultPolicy(Visibility)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExplicitContract_DefaultPolicy()
	 * @model default="private" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='defaultPolicy'"
	 * @generated
	 */
	Visibility getDefaultPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultPolicy <em>Default Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see #isSetDefaultPolicy()
	 * @see #unsetDefaultPolicy()
	 * @see #getDefaultPolicy()
	 * @generated
	 */
	void setDefaultPolicy(Visibility value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultPolicy <em>Default Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefaultPolicy()
	 * @see #getDefaultPolicy()
	 * @see #setDefaultPolicy(Visibility)
	 * @generated
	 */
	void unsetDefaultPolicy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultPolicy <em>Default Policy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Default Policy</em>' attribute is set.
	 * @see #unsetDefaultPolicy()
	 * @see #getDefaultPolicy()
	 * @see #setDefaultPolicy(Visibility)
	 * @generated
	 */
	boolean isSetDefaultPolicy();

} // ExplicitContract
