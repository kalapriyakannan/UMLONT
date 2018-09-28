/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enumeration Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			The value of the attribute should be any one from the given set.
 * 			The set of valid values is represented as a sequence of child elements of type 'SingleValue'.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getEnumerationConstraint()
 * @model extendedMetaData="name='EnumerationConstraint' kind='elementOnly'"
 * @generated
 */
public interface EnumerationConstraint extends AttributeValueConstraint {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The set of valid values is represented as a sequence of child elements of type 'SingleValue'.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getEnumerationConstraint_Values()
	 * @model type="com.ibm.ccl.soa.deploy.core.constraint.SingleValue" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	EList getValues();

} // EnumerationConstraint
