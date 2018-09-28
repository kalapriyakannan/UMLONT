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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windows DB2 Admin Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer#getDasDomain <em>Das Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2AdminServer()
 * @model extendedMetaData="name='WindowsDB2AdminServer' kind='elementOnly'"
 * @generated
 */
public interface WindowsDB2AdminServer extends DB2AdminServer {
	/**
	 * Returns the value of the '<em><b>Das Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Das Domain</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DB2 Administration Server domain. (?)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Das Domain</em>' attribute.
	 * @see #setDasDomain(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2AdminServer_DasDomain()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasDomain'"
	 * @generated
	 */
	String getDasDomain();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer#getDasDomain <em>Das Domain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das Domain</em>' attribute.
	 * @see #getDasDomain()
	 * @generated
	 */
	void setDasDomain(String value);

} // WindowsDB2AdminServer
