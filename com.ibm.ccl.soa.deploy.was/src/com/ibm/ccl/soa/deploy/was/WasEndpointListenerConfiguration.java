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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Endpoint Listener Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getEndpointListenerName <em>Endpoint Listener Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getUrlRoot <em>Url Root</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getWsdlUrlRoot <em>Wsdl Url Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEndpointListenerConfiguration()
 * @model extendedMetaData="name='WasEndpointListenerConfiguration' kind='elementOnly'"
 * @generated
 */
public interface WasEndpointListenerConfiguration extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Endpoint Listener Name</b></em>' attribute.
	 * The default value is <code>"SOAPHTTPChannel1"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.EndPointListenerNameEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Listener Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Listener Name</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.EndPointListenerNameEnum
	 * @see #isSetEndpointListenerName()
	 * @see #unsetEndpointListenerName()
	 * @see #setEndpointListenerName(EndPointListenerNameEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEndpointListenerConfiguration_EndpointListenerName()
	 * @model default="SOAPHTTPChannel1" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='endpointListenerName'"
	 * @generated
	 */
	EndPointListenerNameEnum getEndpointListenerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getEndpointListenerName <em>Endpoint Listener Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Listener Name</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.EndPointListenerNameEnum
	 * @see #isSetEndpointListenerName()
	 * @see #unsetEndpointListenerName()
	 * @see #getEndpointListenerName()
	 * @generated
	 */
	void setEndpointListenerName(EndPointListenerNameEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getEndpointListenerName <em>Endpoint Listener Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEndpointListenerName()
	 * @see #getEndpointListenerName()
	 * @see #setEndpointListenerName(EndPointListenerNameEnum)
	 * @generated
	 */
	void unsetEndpointListenerName();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getEndpointListenerName <em>Endpoint Listener Name</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Endpoint Listener Name</em>' attribute is set.
	 * @see #unsetEndpointListenerName()
	 * @see #getEndpointListenerName()
	 * @see #setEndpointListenerName(EndPointListenerNameEnum)
	 * @generated
	 */
	boolean isSetEndpointListenerName();

	/**
	 * Returns the value of the '<em><b>Url Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Root</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Root</em>' attribute.
	 * @see #setUrlRoot(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEndpointListenerConfiguration_UrlRoot()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='urlRoot'"
	 * @generated
	 */
	String getUrlRoot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getUrlRoot <em>Url Root</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Root</em>' attribute.
	 * @see #getUrlRoot()
	 * @generated
	 */
	void setUrlRoot(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl Url Root</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Url Root</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Url Root</em>' attribute.
	 * @see #setWsdlUrlRoot(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEndpointListenerConfiguration_WsdlUrlRoot()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='wsdlUrlRoot'"
	 * @generated
	 */
	String getWsdlUrlRoot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration#getWsdlUrlRoot <em>Wsdl Url Root</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Url Root</em>' attribute.
	 * @see #getWsdlUrlRoot()
	 * @generated
	 */
	void setWsdlUrlRoot(String value);

} // WasEndpointListenerConfiguration
