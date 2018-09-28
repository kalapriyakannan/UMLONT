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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Module Class Loader Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy#getStartWeight <em>Start Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasModuleClassLoaderPolicy()
 * @model extendedMetaData="name='WasModuleClassLoaderPolicy' kind='elementOnly'"
 * @generated
 */
public interface WasModuleClassLoaderPolicy extends WasClassLoaderPolicy {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Start Weight</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Start Weight</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Weight</em>' attribute.
	 * @see #isSetStartWeight()
	 * @see #unsetStartWeight()
	 * @see #setStartWeight(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasModuleClassLoaderPolicy_StartWeight()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='startWeight'"
	 * @generated
	 */
	int getStartWeight();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy#getStartWeight <em>Start Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Weight</em>' attribute.
	 * @see #isSetStartWeight()
	 * @see #unsetStartWeight()
	 * @see #getStartWeight()
	 * @generated
	 */
	void setStartWeight(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy#getStartWeight <em>Start Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartWeight()
	 * @see #getStartWeight()
	 * @see #setStartWeight(int)
	 * @generated
	 */
	void unsetStartWeight();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy#getStartWeight <em>Start Weight</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Weight</em>' attribute is set.
	 * @see #unsetStartWeight()
	 * @see #getStartWeight()
	 * @see #setStartWeight(int)
	 * @generated
	 */
	boolean isSetStartWeight();

} // WasModuleClassLoaderPolicy
