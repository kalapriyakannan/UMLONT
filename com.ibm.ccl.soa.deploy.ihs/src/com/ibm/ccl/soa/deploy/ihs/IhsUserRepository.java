/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>User Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository#getPasswordFile <em>Password File</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsUserRepository()
 * @model extendedMetaData="name='IhsUserRepository' kind='elementOnly'"
 * @generated
 */
public interface IhsUserRepository extends Capability {
	/**
	 * Returns the value of the '<em><b>Password File</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Password File</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password File</em>' attribute.
	 * @see #setPasswordFile(String)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsUserRepository_PasswordFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='passwordFile'"
	 * @generated
	 */
	String getPasswordFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository#getPasswordFile <em>Password File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password File</em>' attribute.
	 * @see #getPasswordFile()
	 * @generated
	 */
	void setPasswordFile(String value);

} // IhsUserRepository
