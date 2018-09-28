/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Class Loader Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getOrder <em>Order</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getPolicy <em>Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasClassLoaderPolicy()
 * @model extendedMetaData="name='WasClassLoaderPolicy' kind='elementOnly'"
 * @generated
 */
public interface WasClassLoaderPolicy extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The default value is <code>"PARENT_FIRST"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ClassloaderMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderMode
	 * @see #isSetOrder()
	 * @see #unsetOrder()
	 * @see #setOrder(ClassloaderMode)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasClassLoaderPolicy_Order()
	 * @model default="PARENT_FIRST" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='order'"
	 * @generated
	 */
	ClassloaderMode getOrder();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderMode
	 * @see #isSetOrder()
	 * @see #unsetOrder()
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(ClassloaderMode value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetOrder()
	 * @see #getOrder()
	 * @see #setOrder(ClassloaderMode)
	 * @generated
	 */
	void unsetOrder();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getOrder <em>Order</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Order</em>' attribute is set.
	 * @see #unsetOrder()
	 * @see #getOrder()
	 * @see #setOrder(ClassloaderMode)
	 * @generated
	 */
	boolean isSetOrder();

	/**
	 * Returns the value of the '<em><b>Policy</b></em>' attribute.
	 * The default value is <code>"SINGLE"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType
	 * @see #isSetPolicy()
	 * @see #unsetPolicy()
	 * @see #setPolicy(ClassloaderPolicyType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasClassLoaderPolicy_Policy()
	 * @model default="SINGLE" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='policy'"
	 * @generated
	 */
	ClassloaderPolicyType getPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType
	 * @see #isSetPolicy()
	 * @see #unsetPolicy()
	 * @see #getPolicy()
	 * @generated
	 */
	void setPolicy(ClassloaderPolicyType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPolicy()
	 * @see #getPolicy()
	 * @see #setPolicy(ClassloaderPolicyType)
	 * @generated
	 */
	void unsetPolicy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy#getPolicy <em>Policy</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Policy</em>' attribute is set.
	 * @see #unsetPolicy()
	 * @see #getPolicy()
	 * @see #setPolicy(ClassloaderPolicyType)
	 * @generated
	 */
	boolean isSetPolicy();

} // WasClassLoaderPolicy
