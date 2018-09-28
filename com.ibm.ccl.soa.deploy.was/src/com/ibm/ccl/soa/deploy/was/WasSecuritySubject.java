/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Security Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubject#getAccessId <em>Access Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubject#getSubjectName <em>Subject Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecuritySubject()
 * @model extendedMetaData="name='WasSecuritySubject' kind='elementOnly'"
 * @generated
 */
public interface WasSecuritySubject extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Access Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Id</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Id</em>' attribute.
	 * @see #setAccessId(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecuritySubject_AccessId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='accessId'"
	 * @generated
	 */
	String getAccessId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubject#getAccessId <em>Access Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Id</em>' attribute.
	 * @see #getAccessId()
	 * @generated
	 */
	void setAccessId(String value);

	/**
	 * Returns the value of the '<em><b>Subject Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Subject Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject Name</em>' attribute.
	 * @see #setSubjectName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecuritySubject_SubjectName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subjectName'"
	 * @generated
	 */
	String getSubjectName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubject#getSubjectName <em>Subject Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject Name</em>' attribute.
	 * @see #getSubjectName()
	 * @generated
	 */
	void setSubjectName(String value);

} // WasSecuritySubject
