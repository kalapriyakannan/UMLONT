/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Communication Capability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability#getApplicationLayerProtocol <em>Application Layer Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCommunicationCapability()
 * @model extendedMetaData="name='CommunicationCapability' kind='elementOnly'"
 * @generated
 */
public interface CommunicationCapability extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Application Layer Protocol</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Layer Protocol</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Application Layer Protocol</em>' attribute.
	 * @see #setApplicationLayerProtocol(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCommunicationCapability_ApplicationLayerProtocol()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='applicationLayerProtocol'"
	 * @generated
	 */
	String getApplicationLayerProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability#getApplicationLayerProtocol <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Layer Protocol</em>' attribute.
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 */
	void setApplicationLayerProtocol(String value);

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
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCommunicationCapability_Port()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.PortType" required="true"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

} // CommunicationCapability
