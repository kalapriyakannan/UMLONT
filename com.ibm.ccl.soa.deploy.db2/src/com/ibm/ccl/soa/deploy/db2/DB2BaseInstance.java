/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import com.ibm.ccl.soa.deploy.database.DatabaseInstance;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Base Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2InstanceName <em>Db2 Instance Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2Version <em>Db2 Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2BaseInstance()
 * @model extendedMetaData="name='DB2BaseInstance' kind='elementOnly'"
 * @generated
 */
public interface DB2BaseInstance extends DatabaseInstance {
	/**
	 * Returns the value of the '<em><b>Db2 Instance Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db2 Instance Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Db2 Instance Name</em>' attribute.
	 * @see #setDb2InstanceName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2BaseInstance_Db2InstanceName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='db2InstanceName'"
	 * @generated
	 */
	String getDb2InstanceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2InstanceName <em>Db2 Instance Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Instance Name</em>' attribute.
	 * @see #getDb2InstanceName()
	 * @generated
	 */
	void setDb2InstanceName(String value);

	/**
	 * Returns the value of the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db2 Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The version of the DB2 instance. Must be a dotted numeric version string, up to 4 parts,
	 * 							e.g. "8.2"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Db2 Version</em>' attribute.
	 * @see #setDb2Version(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2BaseInstance_Db2Version()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='db2Version'"
	 * @generated
	 */
	String getDb2Version();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2Version <em>Db2 Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Version</em>' attribute.
	 * @see #getDb2Version()
	 * @generated
	 */
	void setDb2Version(String value);

} // DB2BaseInstance
