/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: Stereotype.java,v 1.1 2008/02/05 22:20:19 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Stereotype#getKeyword <em>Keyword</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Stereotype#getProfile <em>Profile</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Stereotype#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getStereotype()
 * @model extendedMetaData="name='Stereotype' kind='empty'"
 * @generated
 */
public interface Stereotype extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyword</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyword</em>' attribute.
	 * @see #setKeyword(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getStereotype_Keyword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='keyword'"
	 * @generated
	 */
	String getKeyword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Stereotype#getKeyword <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyword</em>' attribute.
	 * @see #getKeyword()
	 * @generated
	 */
	void setKeyword(String value);

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' attribute.
	 * @see #setProfile(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getStereotype_Profile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='profile'"
	 * @generated
	 */
	String getProfile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Stereotype#getProfile <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' attribute.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #isSetRequired()
	 * @see #unsetRequired()
	 * @see #setRequired(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getStereotype_Required()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='required'"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Stereotype#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isSetRequired()
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Stereotype#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	void unsetRequired();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Stereotype#isRequired <em>Required</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Required</em>' attribute is set.
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	boolean isSetRequired();

} // Stereotype
