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

import com.ibm.ccl.soa.deploy.core.Interface;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>URL Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.URLInterface#getParamName <em>Param Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getURLInterface()
 * @model extendedMetaData="name='URLInterface' kind='elementOnly'"
 * @generated
 */
public interface URLInterface extends Interface {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Param Name</b></em>' attribute list. The list contents
	 * are of type {@link java.lang.String}. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> Indicates the name of a URL Request Parameter. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Param Name</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getURLInterface_ParamName()
	 * @model type="java.lang.String" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='paramName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList getParamName();

} // URLInterface
