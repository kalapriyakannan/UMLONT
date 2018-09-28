/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: ProductIdentifierConstraint.java,v 1.1 2007/12/06 17:43:16 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Identifier Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Constraint that specifies a product identifier.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint#getProductIdentifier <em>Product Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getProductIdentifierConstraint()
 * @model extendedMetaData="name='ProductIdentifierConstraint' kind='elementOnly'"
 * @generated
 */
public interface ProductIdentifierConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Product Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * String representation of the product selection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Product Identifier</em>' attribute.
	 * @see #setProductIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getProductIdentifierConstraint_ProductIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='productIdentifier'"
	 * @generated
	 */
	String getProductIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint#getProductIdentifier <em>Product Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Identifier</em>' attribute.
	 * @see #getProductIdentifier()
	 * @generated
	 */
	void setProductIdentifier(String value);

} // ProductIdentifierConstraint
