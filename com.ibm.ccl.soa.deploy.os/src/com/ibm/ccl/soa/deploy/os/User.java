/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>User</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.User#getUserId <em>User Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.User#getUserPassword <em>User Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getUser()
 * @model extendedMetaData="name='User' kind='elementOnly'"
 * @generated
 */
public interface User extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getUser_UserId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userId'"
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Returns the value of the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>User Password</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Password</em>' attribute.
	 * @see #setUserPassword(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getUser_UserPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userPassword'"
	 * @generated
	 */
	String getUserPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.User#getUserPassword <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Password</em>' attribute.
	 * @see #getUserPassword()
	 * @generated
	 */
	void setUserPassword(String value);

} // User