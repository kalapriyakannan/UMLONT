/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: EqualsConstraint.java,v 1.3 2008/04/23 19:20:00 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Equals Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Constraint that specifies the value of an attribute.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getEqualsConstraint()
 * @model extendedMetaData="name='EqualsConstraint' kind='elementOnly'"
 * @generated
 */
public interface EqualsConstraint extends AttributeValueConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The value of the attribute. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getEqualsConstraint_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns required value of the attribute as Object. Returns NULL if the actual EDataType of the
	 * attribute can not be figured out, and therefore String value can not be converted into Object
	 * (e.g., if the 'attributeName' is not set, or if the constraint refers to an extended attribute
	 * and the actual validation context is known known).
	 * 
	 * @return required value of the attribute as Object
	 * 
	 * @generated NOT
	 */
	public Object getValueObject();

	/**
	 * Sets required value of the attribute, using value as Object. The implementation tries to
	 * figure out EDataType of the attribute, in order to use
	 * {@link EcoreUtil#convertToString(org.eclipse.emf.ecore.EDataType, Object)} to convert the
	 * Object value to its String representation. If EDataType can not be figured out (e.g., if the
	 * 'attributeName' is not set, or if the constraint refers to an extended attribute and the
	 * actual validation context is known known), standard Java Object serialization
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

} // EqualsConstraint
