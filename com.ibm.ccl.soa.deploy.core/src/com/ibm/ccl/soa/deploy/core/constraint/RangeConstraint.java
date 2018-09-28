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

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Range Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Constraint that specifies valid attribute value range. Not necessarily numbers, any comparable types.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMaxValueInclusive <em>Max Value Inclusive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMinValueInclusive <em>Min Value Inclusive</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getRangeConstraint()
 * @model extendedMetaData="name='RangeConstraint' kind='elementOnly'"
 * @generated
 */
public interface RangeConstraint extends AttributeValueConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The maximum value of the range. No maximum value is specified, if ommited.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getRangeConstraint_MaxValue()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='maxValue'"
	 * @generated
	 */
	String getMaxValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(String value);

	/**
	 * Returns the value of the '<em><b>Max Value Inclusive</b></em>' attribute. The default
	 * value is <code>"true"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc -->
	 * 
	 * Is maximum value is included in the range.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Max Value Inclusive</em>' attribute.
	 * @see #isSetMaxValueInclusive()
	 * @see #unsetMaxValueInclusive()
	 * @see #setMaxValueInclusive(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getRangeConstraint_MaxValueInclusive()
	 * @model default="true" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='maxValueInclusive'"
	 * @generated
	 */
	boolean isMaxValueInclusive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMaxValueInclusive <em>Max Value Inclusive</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value Inclusive</em>' attribute.
	 * @see #isSetMaxValueInclusive()
	 * @see #unsetMaxValueInclusive()
	 * @see #isMaxValueInclusive()
	 * @generated
	 */
	void setMaxValueInclusive(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMaxValueInclusive <em>Max Value Inclusive</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMaxValueInclusive()
	 * @see #isMaxValueInclusive()
	 * @see #setMaxValueInclusive(boolean)
	 * @generated
	 */
	void unsetMaxValueInclusive();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMaxValueInclusive <em>Max Value Inclusive</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Value Inclusive</em>' attribute is set.
	 * @see #unsetMaxValueInclusive()
	 * @see #isMaxValueInclusive()
	 * @see #setMaxValueInclusive(boolean)
	 * @generated
	 */
	boolean isSetMaxValueInclusive();

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The minimum value of the range. No minimum value is specified, if ommited.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getRangeConstraint_MinValue()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='minValue'"
	 * @generated
	 */
	String getMinValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(String value);

	/**
	 * Returns the value of the '<em><b>Min Value Inclusive</b></em>' attribute. The default
	 * value is <code>"true"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc -->
	 * 
	 * Is minimum value is included in the range.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Min Value Inclusive</em>' attribute.
	 * @see #isSetMinValueInclusive()
	 * @see #unsetMinValueInclusive()
	 * @see #setMinValueInclusive(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getRangeConstraint_MinValueInclusive()
	 * @model default="true" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='minValueInclusive'"
	 * @generated
	 */
	boolean isMinValueInclusive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMinValueInclusive <em>Min Value Inclusive</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value Inclusive</em>' attribute.
	 * @see #isSetMinValueInclusive()
	 * @see #unsetMinValueInclusive()
	 * @see #isMinValueInclusive()
	 * @generated
	 */
	void setMinValueInclusive(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMinValueInclusive <em>Min Value Inclusive</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMinValueInclusive()
	 * @see #isMinValueInclusive()
	 * @see #setMinValueInclusive(boolean)
	 * @generated
	 */
	void unsetMinValueInclusive();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMinValueInclusive <em>Min Value Inclusive</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Value Inclusive</em>' attribute is set.
	 * @see #unsetMinValueInclusive()
	 * @see #isMinValueInclusive()
	 * @see #setMinValueInclusive(boolean)
	 * @generated
	 */
	boolean isSetMinValueInclusive();

	/**
	 * Returns MIN value of the attribute as Object. Returns NULL if the actual EDataType of the
	 * attribute can not be figured out, and therefore String value can not be converted into Object
	 * (e.g., if the 'attributeName' is not set, or if the constraint refers to an extended attribute
	 * and the actual validation context is known known).
	 * 
	 * @return MIN value of the attribute as Object
	 * 
	 * @generated NOT
	 */
	public Object getMinValueObject();

	/**
	 * Sets MIN value of the attribute, using value as Object. The implementation tries to figure out
	 * EDataType of the attribute, in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object value to its String representation. If EDataType can not be figured out (e.g., if the
	 * 'attributeName' is not set, or if the constraint refers to an extended attribute and the
	 * actual validation context is known known), standard Java Object serialization
	 * {@link Object#toString()} is used.
	 * 
	 * @param newValue
	 *           MIN value as Object
	 * 
	 * @return true if EDataType was used to serialize the value (the correct way of Object
	 *         serialization); false otherwise (the value may not have serialized properly)
	 * 
	 * @generated NOT
	 */
	public boolean setMinValueObject(Object newValue);

	/**
	 * Returns MAX value of the attribute as Object. Returns NULL if the actual EDataType of the
	 * attribute can not be figured out, and therefore String value can not be converted into Object
	 * (e.g., if the 'attributeName' is not set, or if the constraint refers to an extended attribute
	 * and the actual validation context is known known).
	 * 
	 * @return MAX value of the attribute as Object
	 * 
	 * @generated NOT
	 */
	public Object getMaxValueObject();

	/**
	 * Sets MAX value of the attribute, using value as Object. The implementation tries to figure out
	 * EDataType of the attribute, in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object value to its String representation. If EDataType can not be figured out (e.g., if the
	 * 'attributeName' is not set, or if the constraint refers to an extended attribute and the
	 * actual validation context is known known), standard Java Object serialization
	 * {@link Object#toString()} is used.
	 * 
	 * @param newValue
	 *           MAX value as Object
	 * 
	 * @return true if EDataType was used to serialize the value (the correct way of Object
	 *         serialization); false otherwise (the value may not have serialized properly)
	 * 
	 * @generated NOT
	 */
	public boolean setMaxValueObject(Object newValue);

} // RangeConstraint
