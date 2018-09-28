/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: FileSystemContent.java,v 1.1 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File System Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getFixedPath <em>Fixed Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getGroup <em>Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getRealFile <em>Real File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getSize <em>Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getURI <em>URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent()
 * @model extendedMetaData="name='FileSystemContent' kind='elementOnly'"
 * @generated
 */
public interface FileSystemContent extends Capability {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Fixed Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Path</em>' attribute.
	 * @see #setFixedPath(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_FixedPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FixedPath'"
	 * @generated
	 */
	String getFixedPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getFixedPath <em>Fixed Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Path</em>' attribute.
	 * @see #getFixedPath()
	 * @generated
	 */
	void setFixedPath(String value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_Group()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Group'"
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modified</em>' attribute.
	 * @see #isSetLastModified()
	 * @see #unsetLastModified()
	 * @see #setLastModified(long)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_LastModified()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='LastModified'"
	 * @generated
	 */
	long getLastModified();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified</em>' attribute.
	 * @see #isSetLastModified()
	 * @see #unsetLastModified()
	 * @see #getLastModified()
	 * @generated
	 */
	void setLastModified(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastModified()
	 * @see #getLastModified()
	 * @see #setLastModified(long)
	 * @generated
	 */
	void unsetLastModified();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getLastModified <em>Last Modified</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Modified</em>' attribute is set.
	 * @see #unsetLastModified()
	 * @see #getLastModified()
	 * @see #setLastModified(long)
	 * @generated
	 */
	boolean isSetLastModified();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_Owner()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Owner'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permissions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permissions</em>' attribute.
	 * @see #setPermissions(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_Permissions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Permissions'"
	 * @generated
	 */
	String getPermissions();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getPermissions <em>Permissions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Permissions</em>' attribute.
	 * @see #getPermissions()
	 * @generated
	 */
	void setPermissions(String value);

	/**
	 * Returns the value of the '<em><b>Real File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Real File</em>' attribute.
	 * @see #setRealFile(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_RealFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RealFile'"
	 * @generated
	 */
	String getRealFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getRealFile <em>Real File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real File</em>' attribute.
	 * @see #getRealFile()
	 * @generated
	 */
	void setRealFile(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #setSize(long)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_Size()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='Size'"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSize()
	 * @see #getSize()
	 * @see #setSize(long)
	 * @generated
	 */
	void unsetSize();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getSize <em>Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Size</em>' attribute is set.
	 * @see #unsetSize()
	 * @see #getSize()
	 * @see #setSize(long)
	 * @generated
	 */
	boolean isSetSize();

	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystemContent_URI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='URI'"
	 * @generated
	 */
	String getURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

} // FileSystemContent
