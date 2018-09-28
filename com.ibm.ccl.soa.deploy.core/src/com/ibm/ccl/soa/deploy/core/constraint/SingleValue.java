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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Single Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			Represents a single value (of an attribute). 
 * 			Used as a child element in 'Enumeration' and 'Exclusuion' constraints.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getDescription <em>Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getSingleValue()
 * @model extendedMetaData="name='SingleValue' kind='empty'"
 * @generated
 */
public interface SingleValue extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Description of the value (optional).
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getSingleValue_Description()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The value itself.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getSingleValue_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns 'value' as Object. Returns NULL if the actual EDataType of 'value' can not be figured
	 * out, and therefore string can not be converted into an Object (e.g., if this SingleValue
	 * object is not contained in an AttributeValueConstraint, or if the 'attributeName' on the AVC
	 * is not set, or if the constraint refers to an extended attribute and the actual validation
	 * context is known known).
	 * 
	 * @return 'value' as Object
	 * 
	 * @generated NOT
	 */
	public Object getValueObject();

	/**
	 * Sets 'value', using its Object representation. The implementation tries to figure out
	 * EDataType of 'value' (by looking at the parent AttributeValue Constraint and the type of the
	 * constrained attribute), in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object to a correct string representation. If EDataType can not be figured out (e.g., if this
	 * SingleValue object is not contained in an AttributeValueConstraint, or if the 'attributeName'
	 * on the AVC is not set, or if the constraint refers to an extended attribute and the actual
	 * validation context is known known), standard Java Object serialization
	 * {@link Object#toString()} is used.
	 * 
	 * @param newValue
	 *           value as Object
	 * 
	 * @return true if EDataType was used to serialize the value (the correct way of Object
	 *         serialization); false otherwise (the value may not have serialized properly)
	 * 
	 * @generated NOT
	 */
	public boolean setValueObject(Object newValue);

} // SingleValue
