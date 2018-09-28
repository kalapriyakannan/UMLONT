/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import com.ibm.ccl.soa.deploy.core.Interface;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>WSDL Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.WSDLInterface#getTypeUri <em>Type Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getWSDLInterface()
 * @model extendedMetaData="name='WSDLInterface' kind='empty'"
 * @generated
 */
public interface WSDLInterface extends Interface {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Type Uri</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Indicates the WSDL 1.1 Port Type or WSDL 2.0
	 * interface. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type Uri</em>' attribute.
	 * @see #setTypeUri(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getWSDLInterface_TypeUri()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='typeUri'"
	 * @generated
	 */
	String getTypeUri();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.WSDLInterface#getTypeUri <em>Type Uri</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Uri</em>' attribute.
	 * @see #getTypeUri()
	 * @generated
	 */
	void setTypeUri(String value);

} // WSDLInterface
