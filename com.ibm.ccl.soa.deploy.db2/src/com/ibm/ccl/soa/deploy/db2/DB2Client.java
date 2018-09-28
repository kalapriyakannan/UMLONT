/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Client#getDb2ClientVersion <em>Db2 Client Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Client#getInstallDir <em>Install Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Client()
 * @model extendedMetaData="name='DB2Client' kind='elementOnly'"
 * @generated
 */
public interface DB2Client extends Capability {
	/**
	 * Returns the value of the '<em><b>Db2 Client Version</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db2 Client Version</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Db2 Client Version</em>' attribute.
	 * @see #setDb2ClientVersion(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Client_Db2ClientVersion()
	 * @model unique="false" dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='db2ClientVersion'"
	 * @generated
	 */
	String getDb2ClientVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Client#getDb2ClientVersion <em>Db2 Client Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Client Version</em>' attribute.
	 * @see #getDb2ClientVersion()
	 * @generated
	 */
	void setDb2ClientVersion(String value);

	/**
	 * Returns the value of the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Dir</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Full install path for the DB2 client.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Install Dir</em>' attribute.
	 * @see #setInstallDir(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Client_InstallDir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installDir'"
	 * @generated
	 */
	String getInstallDir();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Client#getInstallDir <em>Install Dir</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Dir</em>' attribute.
	 * @see #getInstallDir()
	 * @generated
	 */
	void setInstallDir(String value);

} // DB2Client
