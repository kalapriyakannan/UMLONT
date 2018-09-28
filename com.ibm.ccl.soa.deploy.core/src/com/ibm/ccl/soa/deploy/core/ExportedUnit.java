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

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Exported Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedCapabilities <em>Exported Capabilities</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedRequirements <em>Exported Requirements</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedProperties <em>Exported Properties</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getConstraintGroup <em>Constraint Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getAugmentedConstraints <em>Augmented Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExportedUnit()
 * @model extendedMetaData="name='ExportedUnit' kind='elementOnly'"
 * @generated
 */
public interface ExportedUnit extends Exported {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Exported Capabilities</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Exported}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported Capabilities</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exported Capabilities</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExportedUnit_ExportedCapabilities()
	 * @model type="com.ibm.ccl.soa.deploy.core.Exported" containment="true"
	 *        extendedMetaData="kind='element' name='exported.capability'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	List getExportedCapabilities();

	/**
	 * Returns the value of the '<em><b>Exported Requirements</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Exported}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported Requirements</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exported Requirements</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExportedUnit_ExportedRequirements()
	 * @model type="com.ibm.ccl.soa.deploy.core.Exported" containment="true"
	 *        extendedMetaData="kind='element' name='exported.requirement'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	List getExportedRequirements();

	/**
	 * Returns the value of the '<em><b>Exported Properties</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Property}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported Properties</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exported Properties</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExportedUnit_ExportedProperties()
	 * @model type="com.ibm.ccl.soa.deploy.core.Property" containment="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	List getExportedProperties();

	/**
	 * Returns the value of the '<em><b>Constraint Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Constraint Group</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Group</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExportedUnit_ConstraintGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='constraint:group' namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getConstraintGroup();

	/**
	 * Returns the value of the '<em><b>Augmented Constraints</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Constraint}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Augmented Constraints</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Augmented Constraints</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExportedUnit_AugmentedConstraints()
	 * @model type="com.ibm.ccl.soa.deploy.core.Constraint" containment="true" transient="true"
	 *        changeable="false" volatile="true" derived="true" extendedMetaData="kind='element'
	 *        name='constraint' namespace='##targetNamespace' group='constraint:group'"
	 * @generated
	 */
	List getAugmentedConstraints();

} // ExportedUnit
