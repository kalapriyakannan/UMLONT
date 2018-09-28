/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database;

import com.ibm.ccl.soa.deploy.core.Interface;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DDL Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.DDLInterface#getSchemaUri <em>Schema Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDDLInterface()
 * @model extendedMetaData="name='DDLInterface' kind='empty'"
 * @generated
 */
public interface DDLInterface extends Interface {
	/**
	 * Returns the value of the '<em><b>Schema Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Uri</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Uri</em>' attribute.
	 * @see #setSchemaUri(String)
	 * @see com.ibm.ccl.soa.deploy.database.DatabasePackage#getDDLInterface_SchemaUri()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        extendedMetaData="kind='attribute' name='schemaUri'"
	 * @generated
	 */
	String getSchemaUri();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.database.DDLInterface#getSchemaUri <em>Schema Uri</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Uri</em>' attribute.
	 * @see #getSchemaUri()
	 * @generated
	 */
	void setSchemaUri(String value);

} // DDLInterface
