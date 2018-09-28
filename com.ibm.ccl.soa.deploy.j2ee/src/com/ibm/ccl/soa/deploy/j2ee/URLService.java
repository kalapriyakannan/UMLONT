/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import org.eclipse.emf.common.util.EList;

import com.ibm.ccl.soa.deploy.core.Service;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>URL Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			The URLService models a service accessible by a URL address with 
 * 			HTTP GET or HTTP POST commands. For J2EE, this is primarily a 
 * 			Java Servlet. The URLService has a simple interface 
 * 			(j2ee:URLInterface) which captures the list of parameters 
 * 			that the URL Service understands. The URLService provides 0..* 
 * 			urlPatterns which define relative web addresses where the URLService
 * 			may be accessed. For Java EE Servlets, these patterns translate to 
 * 			the Servlet Mapping that indicates 0..* specific addresses for a 
 * 			given Servlet.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.URLService#getUrlPattern <em>Url Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getURLService()
 * @model extendedMetaData="name='URLService' kind='elementOnly'"
 * @generated
 */
public interface URLService extends Service {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Url Pattern</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Pattern</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Pattern</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getURLService_UrlPattern()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='urlPattern' namespace='##targetNamespace'"
	 * @generated
	 */
	EList getUrlPattern();

} // URLService
