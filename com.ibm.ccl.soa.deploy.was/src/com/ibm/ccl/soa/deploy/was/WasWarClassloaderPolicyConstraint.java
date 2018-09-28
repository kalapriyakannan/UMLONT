/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>War Classloader Policy Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Was classloader policy constraint for war modules.
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWarClassloaderPolicyConstraint()
 * @model extendedMetaData="name='WasWarClassloaderPolicyConstraint' kind='elementOnly'"
 * @generated
 */
public interface WasWarClassloaderPolicyConstraint extends WasModuleClassloaderPolicyConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The default value is <code>"PARENT_FIRST"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ClassloaderMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderMode
	 * @see #isSetOrder()
	 * @see #unsetOrder()
	 * @see #setOrder(ClassloaderMode)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWarClassloaderPolicyConstraint_Order()
	 * @model default="PARENT_FIRST" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='order'"
	 * @generated
	 */
	ClassloaderMode getOrder();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderMode
	 * @see #isSetOrder()
	 * @see #unsetOrder()
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(ClassloaderMode value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrder()
	 * @see #getOrder()
	 * @see #setOrder(ClassloaderMode)
	 * @generated
	 */
	void unsetOrder();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint#getOrder <em>Order</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Order</em>' attribute is set.
	 * @see #unsetOrder()
	 * @see #getOrder()
	 * @see #setOrder(ClassloaderMode)
	 * @generated
	 */
	boolean isSetOrder();

} // WasWarClassloaderPolicyConstraint
