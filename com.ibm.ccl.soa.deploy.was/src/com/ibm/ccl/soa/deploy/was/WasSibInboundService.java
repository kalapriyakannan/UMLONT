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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sib Inbound Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService#getWsdlLocation <em>Wsdl Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService#getWsdlServiceNamespace <em>Wsdl Service Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibInboundService()
 * @model extendedMetaData="name='WasSibInboundService' kind='elementOnly'"
 * @generated
 */
public interface WasSibInboundService extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibInboundService_ServiceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serviceName'"
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl Location</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Location</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Location</em>' attribute.
	 * @see #setWsdlLocation(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibInboundService_WsdlLocation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='wsdlLocation'"
	 * @generated
	 */
	String getWsdlLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService#getWsdlLocation <em>Wsdl Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Location</em>' attribute.
	 * @see #getWsdlLocation()
	 * @generated
	 */
	void setWsdlLocation(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl Service Namespace</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Service Namespace</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Wsdl Service Namespace</em>' attribute.
	 * @see #setWsdlServiceNamespace(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibInboundService_WsdlServiceNamespace()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='wsdlServiceNamespace'"
	 * @generated
	 */
	String getWsdlServiceNamespace();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService#getWsdlServiceNamespace <em>Wsdl Service Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Service Namespace</em>' attribute.
	 * @see #getWsdlServiceNamespace()
	 * @generated
	 */
	void setWsdlServiceNamespace(String value);

} // WasSibInboundService
