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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Was Module</b></em>'.
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
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule#getConfigFile <em>Config File</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsWasModule()
 * @model extendedMetaData="name='IhsWasModule' kind='elementOnly'"
 * @generated
 */
public interface IhsWasModule extends IhsModule {
	/**
	 * Returns the value of the '<em><b>Config File</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Config File</em>' attribute.
	 * @see #setConfigFile(String)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsWasModule_ConfigFile()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='configFile'"
	 * @generated
	 */
	String getConfigFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule#getConfigFile <em>Config File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config File</em>' attribute.
	 * @see #getConfigFile()
	 * @generated
	 */
	void setConfigFile(String value);

} // IhsWasModule
