/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Group Cardinality Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMinValue <em>Min Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getGroupCardinalityConstraint()
 * @model extendedMetaData="name='GroupCardinalityConstraint' kind='elementOnly'"
 * @generated
 */
public interface GroupCardinalityConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute. The default value is
	 * <code>"unbounded"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc -->
	 * 
	 * The maximum number of groups.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #isSetMaxValue()
	 * @see #unsetMaxValue()
	 * @see #setMaxValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getGroupCardinalityConstraint_MaxValue()
	 * @model default="unbounded" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.String" extendedMetaData="kind='attribute'
	 *        name='maxValue'"
	 * @generated
	 */
	String getMaxValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #isSetMaxValue()
	 * @see #unsetMaxValue()
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(String value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMaxValue()
	 * @see #getMaxValue()
	 * @see #setMaxValue(String)
	 * @generated
	 */
	void unsetMaxValue();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMaxValue <em>Max Value</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Value</em>' attribute is set.
	 * @see #unsetMaxValue()
	 * @see #getMaxValue()
	 * @see #setMaxValue(String)
	 * @generated
	 */
	boolean isSetMaxValue();

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute. The default value is
	 * <code>"0"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The minimum number of groups.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #isSetMinValue()
	 * @see #unsetMinValue()
	 * @see #setMinValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getGroupCardinalityConstraint_MinValue()
	 * @model default="0" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.String" extendedMetaData="kind='attribute'
	 *        name='minValue'"
	 * @generated
	 */
	String getMinValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #isSetMinValue()
	 * @see #unsetMinValue()
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(String value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMinValue()
	 * @see #getMinValue()
	 * @see #setMinValue(String)
	 * @generated
	 */
	void unsetMinValue();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMinValue <em>Min Value</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Value</em>' attribute is set.
	 * @see #unsetMinValue()
	 * @see #getMinValue()
	 * @see #setMinValue(String)
	 * @generated
	 */
	boolean isSetMinValue();

} // GroupCardinalityConstraint
