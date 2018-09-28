/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

import com.ibm.ccl.soa.deploy.http.HttpServer;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Server</b></em>'. <!--
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
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#getConfigFile <em>Config File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#isSecure <em>Secure</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsServer()
 * @model extendedMetaData="name='IhsServer' kind='elementOnly'"
 * @generated
 */
public interface IhsServer extends HttpServer {
	/**
	 * Returns the value of the '<em><b>Config File</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Config File</em>' attribute.
	 * @see #setConfigFile(String)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsServer_ConfigFile()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='configFile'"
	 * @generated
	 */
	String getConfigFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#getConfigFile <em>Config File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config File</em>' attribute.
	 * @see #getConfigFile()
	 * @generated
	 */
	void setConfigFile(String value);

	/**
	 * Returns the value of the '<em><b>Secure</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Secure</em>' attribute.
	 * @see #isSetSecure()
	 * @see #unsetSecure()
	 * @see #setSecure(boolean)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIhsServer_Secure()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='secure'"
	 * @generated
	 */
	boolean isSecure();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#isSecure <em>Secure</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure</em>' attribute.
	 * @see #isSetSecure()
	 * @see #unsetSecure()
	 * @see #isSecure()
	 * @generated
	 */
	void setSecure(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#isSecure <em>Secure</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetSecure()
	 * @see #isSecure()
	 * @see #setSecure(boolean)
	 * @generated
	 */
	void unsetSecure();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#isSecure <em>Secure</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Secure</em>' attribute is set.
	 * @see #unsetSecure()
	 * @see #isSecure()
	 * @see #setSecure(boolean)
	 * @generated
	 */
	boolean isSetSecure();

} // IhsServer
