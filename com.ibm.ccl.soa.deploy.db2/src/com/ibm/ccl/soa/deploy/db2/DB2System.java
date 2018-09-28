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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2System#getDb2ProductLang <em>Db2 Product Lang</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2System#getDb2Version <em>Db2 Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2System#getInstallDir <em>Install Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2System()
 * @model extendedMetaData="name='DB2System' kind='elementOnly'"
 * @generated
 */
public interface DB2System extends Capability {
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
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2System_Db2ProductLang()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='db2ProductLang'"
	 * @generated
	 */
	String getDb2ProductLang();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2System#getDb2ProductLang <em>Db2 Product Lang</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Product Lang</em>' attribute.
	 * @see #getDb2ProductLang()
	 * @generated
	 */
	void setDb2ProductLang(String value);

	/**
	 * Returns the value of the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db2 Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A dotted numeric version string, up to 4 parts, e.g. "8.2"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Db2 Version</em>' attribute.
	 * @see #setDb2Version(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2System_Db2Version()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='db2Version'"
	 * @generated
	 */
	String getDb2Version();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2System#getDb2Version <em>Db2 Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Version</em>' attribute.
	 * @see #getDb2Version()
	 * @generated
	 */
	void setDb2Version(String value);

	/**
	 * Returns the value of the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Dir</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Full path to the install location of DB2
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Install Dir</em>' attribute.
	 * @see #setInstallDir(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2System_InstallDir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installDir'"
	 * @generated
	 */
	String getInstallDir();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2System#getInstallDir <em>Install Dir</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Dir</em>' attribute.
	 * @see #getInstallDir()
	 * @generated
	 */
	void setInstallDir(String value);

} // DB2System
