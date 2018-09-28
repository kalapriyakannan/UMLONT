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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Subject Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *     			A security role mapping from a J2EE security role to a
 *     			Was security subject.
 *     		
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint#getWasSecuritySubject <em>Was Security Subject</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecuritySubjectConstraint()
 * @model extendedMetaData="name='WasSecuritySubjectConstraint' kind='elementOnly'"
 * @generated
 */
public interface WasSecuritySubjectConstraint extends WasJ2EEConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Was Security Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Security Subject</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Security Subject</em>' attribute.
	 * @see #setWasSecuritySubject(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecuritySubjectConstraint_WasSecuritySubject()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='wasSecuritySubject'"
	 * @generated
	 */
	String getWasSecuritySubject();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint#getWasSecuritySubject <em>Was Security Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Security Subject</em>' attribute.
	 * @see #getWasSecuritySubject()
	 * @generated
	 */
	void setWasSecuritySubject(String value);

} // WasSecuritySubjectConstraint
