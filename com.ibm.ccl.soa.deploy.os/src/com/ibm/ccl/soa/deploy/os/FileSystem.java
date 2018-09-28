/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: FileSystem.java,v 1.1 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystem#getAvailableSpace <em>Available Space</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystem#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystem#getMountPoint <em>Mount Point</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.FileSystem#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystem()
 * @model extendedMetaData="name='FileSystem' kind='elementOnly'"
 * @generated
 */
public interface FileSystem extends Capability {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Space</em>' attribute.
	 * @see #isSetAvailableSpace()
	 * @see #unsetAvailableSpace()
	 * @see #setAvailableSpace(long)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystem_AvailableSpace()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='AvailableSpace'"
	 * @generated
	 */
	long getAvailableSpace();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getAvailableSpace <em>Available Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Space</em>' attribute.
	 * @see #isSetAvailableSpace()
	 * @see #unsetAvailableSpace()
	 * @see #getAvailableSpace()
	 * @generated
	 */
	void setAvailableSpace(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getAvailableSpace <em>Available Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAvailableSpace()
	 * @see #getAvailableSpace()
	 * @see #setAvailableSpace(long)
	 * @generated
	 */
	void unsetAvailableSpace();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getAvailableSpace <em>Available Space</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Available Space</em>' attribute is set.
	 * @see #unsetAvailableSpace()
	 * @see #getAvailableSpace()
	 * @see #setAvailableSpace(long)
	 * @generated
	 */
	boolean isSetAvailableSpace();

	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #isSetCapacity()
	 * @see #unsetCapacity()
	 * @see #setCapacity(long)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystem_Capacity()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='Capacity'"
	 * @generated
	 */
	long getCapacity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #isSetCapacity()
	 * @see #unsetCapacity()
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCapacity()
	 * @see #getCapacity()
	 * @see #setCapacity(long)
	 * @generated
	 */
	void unsetCapacity();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getCapacity <em>Capacity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Capacity</em>' attribute is set.
	 * @see #unsetCapacity()
	 * @see #getCapacity()
	 * @see #setCapacity(long)
	 * @generated
	 */
	boolean isSetCapacity();

	/**
	 * Returns the value of the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mount Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mount Point</em>' attribute.
	 * @see #setMountPoint(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystem_MountPoint()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MountPoint'"
	 * @generated
	 */
	String getMountPoint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getMountPoint <em>Mount Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mount Point</em>' attribute.
	 * @see #getMountPoint()
	 * @generated
	 */
	void setMountPoint(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getFileSystem_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // FileSystem
