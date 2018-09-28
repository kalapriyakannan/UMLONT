/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasServer#getServerName <em>Server Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasServer#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasServer()
 * @model extendedMetaData="name='WasServer' kind='elementOnly'"
 * @generated
 */
public interface WasServer extends WasJ2EEServer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Name</em>' attribute.
	 * @see #setServerName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasServer_ServerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serverName'"
	 * @generated
	 */
	String getServerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasServer#getServerName <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Name</em>' attribute.
	 * @see #getServerName()
	 * @generated
	 */
	void setServerName(String value);

	/**
	 * Returns the value of the '<em><b>Was Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Version</em>' attribute.
	 * @see #setWasVersion(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasServer_WasVersion()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='wasVersion'"
	 * @generated
	 */
	String getWasVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasServer#getWasVersion <em>Was Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Version</em>' attribute.
	 * @see #getWasVersion()
	 * @generated
	 */
	void setWasVersion(String value);

} // WasServer
