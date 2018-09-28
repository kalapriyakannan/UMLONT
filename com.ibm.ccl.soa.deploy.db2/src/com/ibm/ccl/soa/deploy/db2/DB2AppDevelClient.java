/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 App Devel Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient#getDb2ProductLang <em>Db2 Product Lang</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2AppDevelClient()
 * @model extendedMetaData="name='DB2AppDevelClient' kind='elementOnly'"
 * @generated
 */
public interface DB2AppDevelClient extends DB2Client {
	/**
	 * Returns the value of the '<em><b>Db2 Product Lang</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db2 Product Lang</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Db2 Product Lang</em>' attribute.
	 * @see #setDb2ProductLang(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2AppDevelClient_Db2ProductLang()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='db2ProductLang'"
	 * @generated
	 */
	String getDb2ProductLang();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient#getDb2ProductLang <em>Db2 Product Lang</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Product Lang</em>' attribute.
	 * @see #getDb2ProductLang()
	 * @generated
	 */
	void setDb2ProductLang(String value);

} // DB2AppDevelClient
