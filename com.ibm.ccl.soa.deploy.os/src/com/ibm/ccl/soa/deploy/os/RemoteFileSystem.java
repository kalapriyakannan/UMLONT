/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: RemoteFileSystem.java,v 1.1 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote File System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getExportName <em>Export Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getServerName <em>Server Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRemoteFileSystem()
 * @model extendedMetaData="name='RemoteFileSystem' kind='elementOnly'"
 * @generated
 */
public interface RemoteFileSystem extends FileSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Export Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Name</em>' attribute.
	 * @see #setExportName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRemoteFileSystem_ExportName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExportName'"
	 * @generated
	 */
	String getExportName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getExportName <em>Export Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Name</em>' attribute.
	 * @see #getExportName()
	 * @generated
	 */
	void setExportName(String value);

	/**
	 * Returns the value of the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Name</em>' attribute.
	 * @see #setServerName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRemoteFileSystem_ServerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServerName'"
	 * @generated
	 */
	String getServerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getServerName <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Name</em>' attribute.
	 * @see #getServerName()
	 * @generated
	 */
	void setServerName(String value);

} // RemoteFileSystem
