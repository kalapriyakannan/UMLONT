/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Shared Library Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				This describes a library that can be shared among applications.
 * 				The inherited name is required.  When used as a consumed service
 * 				only the name should be set.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.SharedLibraryEntry#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.SharedLibraryEntry#getNativePath <em>Native Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.SharedLibraryEntry#getSharedLibraryEntryName <em>Shared Library Entry Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getSharedLibraryEntry()
 * @model extendedMetaData="name='SharedLibraryEntry' kind='elementOnly'"
 * @generated
 */
public interface SharedLibraryEntry extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Class Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Path</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Path</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getSharedLibraryEntry_ClassPath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='classPath' namespace='##targetNamespace'"
	 * @generated
	 */
	List getClassPath();

	/**
	 * Returns the value of the '<em><b>Native Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Path</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Path</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getSharedLibraryEntry_NativePath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='nativePath' namespace='##targetNamespace'"
	 * @generated
	 */
	List getNativePath();

	/**
	 * Returns the value of the '<em><b>Shared Library Entry Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Library Entry Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shared Library Entry Name</em>' attribute.
	 * @see #setSharedLibraryEntryName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getSharedLibraryEntry_SharedLibraryEntryName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sharedLibraryEntryName'"
	 * @generated
	 */
	String getSharedLibraryEntryName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.SharedLibraryEntry#getSharedLibraryEntryName <em>Shared Library Entry Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Library Entry Name</em>' attribute.
	 * @see #getSharedLibraryEntryName()
	 * @generated
	 */
	void setSharedLibraryEntryName(String value);

} // SharedLibraryEntry
