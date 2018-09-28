/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>J2C Authentication Data Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getUserId <em>User Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2CAuthenticationDataEntry()
 * @model extendedMetaData="name='J2CAuthenticationDataEntry' kind='elementOnly'"
 * @generated
 */
public interface J2CAuthenticationDataEntry extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2CAuthenticationDataEntry_Alias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='alias'"
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2CAuthenticationDataEntry_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

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
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2CAuthenticationDataEntry_UserId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userId'"
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

} // J2CAuthenticationDataEntry
