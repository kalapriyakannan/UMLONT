/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Web Server Management</b></em>'.
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
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isAutoConfigPropagation <em>Auto Config Propagation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getUserId <em>User Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isUseSecureProtocol <em>Use Secure Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement()
 * @model extendedMetaData="name='WasWebServerManagement' kind='elementOnly'"
 * @generated
 */
public interface WasWebServerManagement extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Auto Config Propagation</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Config Propagation</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Auto Config Propagation</em>' attribute.
	 * @see #isSetAutoConfigPropagation()
	 * @see #unsetAutoConfigPropagation()
	 * @see #setAutoConfigPropagation(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement_AutoConfigPropagation()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoConfigPropagation'"
	 * @generated
	 */
	boolean isAutoConfigPropagation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isAutoConfigPropagation <em>Auto Config Propagation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Config Propagation</em>' attribute.
	 * @see #isSetAutoConfigPropagation()
	 * @see #unsetAutoConfigPropagation()
	 * @see #isAutoConfigPropagation()
	 * @generated
	 */
	void setAutoConfigPropagation(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isAutoConfigPropagation <em>Auto Config Propagation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAutoConfigPropagation()
	 * @see #isAutoConfigPropagation()
	 * @see #setAutoConfigPropagation(boolean)
	 * @generated
	 */
	void unsetAutoConfigPropagation();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isAutoConfigPropagation <em>Auto Config Propagation</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Config Propagation</em>' attribute is set.
	 * @see #unsetAutoConfigPropagation()
	 * @see #isAutoConfigPropagation()
	 * @see #setAutoConfigPropagation(boolean)
	 * @generated
	 */
	boolean isSetAutoConfigPropagation();

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement_Host()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='host'"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement_UserId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userId'"
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Returns the value of the '<em><b>Use Secure Protocol</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Secure Protocol</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use Secure Protocol</em>' attribute.
	 * @see #isSetUseSecureProtocol()
	 * @see #unsetUseSecureProtocol()
	 * @see #setUseSecureProtocol(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerManagement_UseSecureProtocol()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='useSecureProtocol'"
	 * @generated
	 */
	boolean isUseSecureProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isUseSecureProtocol <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Secure Protocol</em>' attribute.
	 * @see #isSetUseSecureProtocol()
	 * @see #unsetUseSecureProtocol()
	 * @see #isUseSecureProtocol()
	 * @generated
	 */
	void setUseSecureProtocol(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isUseSecureProtocol <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUseSecureProtocol()
	 * @see #isUseSecureProtocol()
	 * @see #setUseSecureProtocol(boolean)
	 * @generated
	 */
	void unsetUseSecureProtocol();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement#isUseSecureProtocol <em>Use Secure Protocol</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use Secure Protocol</em>' attribute is set.
	 * @see #unsetUseSecureProtocol()
	 * @see #isUseSecureProtocol()
	 * @see #setUseSecureProtocol(boolean)
	 * @generated
	 */
	boolean isSetUseSecureProtocol();

} // WasWebServerManagement
