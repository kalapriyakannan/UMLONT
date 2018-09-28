/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: AttributeCapacityConstraint.java,v 1.1 2008/06/18 22:19:10 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Capacity Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *     			Describes requirements on a target down the hosting
 *     			stack to ensure that certain capacities can be met when
 *     			many hostees compete for resources.
 *     		
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#isExclusive <em>Exclusive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributeCapacityConstraint()
 * @model extendedMetaData="name='AttributeCapacityConstraint' kind='elementOnly'"
 * @generated
 */
public interface AttributeCapacityConstraint extends AttributeValueConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						Determines whether the value given for the
	 *     						scoped attribute value must be exclusively
	 *     						allocated to this constraint or may be
	 *     						shared among others. For example, if
	 *     						"exclusive=true" is specified on
	 *     						"memorySize=256M", then 256M must be
	 *     						allocated only for the owner of the
	 *     						CapacityConstraint. A second
	 *     						CapacityConstraint with the same settings
	 *     						would mean that the final scoped target
	 *     						(e.g. a Server) must have at least 512M
	 *     						specified for memorySize in order to be
	 *     						valid.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exclusive</em>' attribute.
	 * @see #isSetExclusive()
	 * @see #unsetExclusive()
	 * @see #setExclusive(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributeCapacityConstraint_Exclusive()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='exclusive'"
	 * @generated
	 */
	boolean isExclusive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#isExclusive <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclusive</em>' attribute.
	 * @see #isSetExclusive()
	 * @see #unsetExclusive()
	 * @see #isExclusive()
	 * @generated
	 */
	void setExclusive(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#isExclusive <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExclusive()
	 * @see #isExclusive()
	 * @see #setExclusive(boolean)
	 * @generated
	 */
	void unsetExclusive();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#isExclusive <em>Exclusive</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exclusive</em>' attribute is set.
	 * @see #unsetExclusive()
	 * @see #isExclusive()
	 * @see #setExclusive(boolean)
	 * @generated
	 */
	boolean isSetExclusive();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *     						The expected value of the scoped attribute.
	 *     					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributeCapacityConstraint_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // AttributeCapacityConstraint
