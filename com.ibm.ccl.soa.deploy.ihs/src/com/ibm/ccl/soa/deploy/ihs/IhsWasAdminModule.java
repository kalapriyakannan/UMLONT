/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Was Admin Module</b></em>'.
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
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule#getUserFile <em>User File</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsWasAdminModule()
 * @model extendedMetaData="name='IhsWasAdminModule' kind='elementOnly'"
 * @generated
 */
public interface IhsWasAdminModule extends IhsModule {
	/**
	 * Returns the value of the '<em><b>User File</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>User File</em>' attribute.
	 * @see #setUserFile(String)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsWasAdminModule_UserFile()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userFile'"
	 * @generated
	 */
	String getUserFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule#getUserFile <em>User File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User File</em>' attribute.
	 * @see #getUserFile()
	 * @generated
	 */
	void setUserFile(String value);

} // IhsWasAdminModule
