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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Handler List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasHandlerList#getHandlerlistName <em>Handlerlist Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasHandlerList()
 * @model extendedMetaData="name='WasHandlerList' kind='elementOnly'"
 * @generated
 */
public interface WasHandlerList extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Handlerlist Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handlerlist Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Handlerlist Name</em>' attribute.
	 * @see #setHandlerlistName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasHandlerList_HandlerlistName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='handlerlistName'"
	 * @generated
	 */
	String getHandlerlistName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasHandlerList#getHandlerlistName <em>Handlerlist Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handlerlist Name</em>' attribute.
	 * @see #getHandlerlistName()
	 * @generated
	 */
	void setHandlerlistName(String value);

} // WasHandlerList
