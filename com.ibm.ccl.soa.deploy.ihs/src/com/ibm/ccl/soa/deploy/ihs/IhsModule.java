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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Module</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsModule#getLocation <em>Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsModule#getModuleName <em>Module Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsModule()
 * @model extendedMetaData="name='IhsModule' kind='elementOnly'"
 * @generated
 */
public interface IhsModule extends Capability {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsModule_Location()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsModule#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Module Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Module Name</em>' attribute.
	 * @see #setModuleName(String)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsModule_ModuleName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='moduleName'"
	 * @generated
	 */
	String getModuleName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsModule#getModuleName <em>Module Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Name</em>' attribute.
	 * @see #getModuleName()
	 * @generated
	 */
	void setModuleName(String value);

} // IhsModule
