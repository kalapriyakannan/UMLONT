/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JRE</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JRE#getJreEdition <em>Jre Edition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JRE#getJreVersion <em>Jre Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JRE#getOtherValue <em>Other Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJRE()
 * @model extendedMetaData="name='JRE' kind='elementOnly'"
 * @generated
 */
public interface JRE extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Jre Edition</b></em>' attribute.
	 * The default value is <code>"standard"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.java.JREEdition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jre Edition</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jre Edition</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JREEdition
	 * @see #isSetJreEdition()
	 * @see #unsetJreEdition()
	 * @see #setJreEdition(JREEdition)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJRE_JreEdition()
	 * @model default="standard" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='jreEdition'"
	 * @generated
	 */
	JREEdition getJreEdition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreEdition <em>Jre Edition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jre Edition</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JREEdition
	 * @see #isSetJreEdition()
	 * @see #unsetJreEdition()
	 * @see #getJreEdition()
	 * @generated
	 */
	void setJreEdition(JREEdition value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreEdition <em>Jre Edition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetJreEdition()
	 * @see #getJreEdition()
	 * @see #setJreEdition(JREEdition)
	 * @generated
	 */
	void unsetJreEdition();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreEdition <em>Jre Edition</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jre Edition</em>' attribute is set.
	 * @see #unsetJreEdition()
	 * @see #getJreEdition()
	 * @see #setJreEdition(JREEdition)
	 * @generated
	 */
	boolean isSetJreEdition();

	/**
	 * Returns the value of the '<em><b>Jre Version</b></em>' attribute.
	 * The default value is <code>"1.2"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.java.JREVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jre Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jre Version</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @see #isSetJreVersion()
	 * @see #unsetJreVersion()
	 * @see #setJreVersion(JREVersion)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJRE_JreVersion()
	 * @model default="1.2" unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='jreVersion'"
	 * @generated
	 */
	JREVersion getJreVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreVersion <em>Jre Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jre Version</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @see #isSetJreVersion()
	 * @see #unsetJreVersion()
	 * @see #getJreVersion()
	 * @generated
	 */
	void setJreVersion(JREVersion value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreVersion <em>Jre Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetJreVersion()
	 * @see #getJreVersion()
	 * @see #setJreVersion(JREVersion)
	 * @generated
	 */
	void unsetJreVersion();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreVersion <em>Jre Version</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jre Version</em>' attribute is set.
	 * @see #unsetJreVersion()
	 * @see #getJreVersion()
	 * @see #setJreVersion(JREVersion)
	 * @generated
	 */
	boolean isSetJreVersion();

	/**
	 * Returns the value of the '<em><b>Other Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Value</em>' attribute.
	 * @see #setOtherValue(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJRE_OtherValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='otherValue'"
	 * @generated
	 */
	String getOtherValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JRE#getOtherValue <em>Other Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Value</em>' attribute.
	 * @see #getOtherValue()
	 * @generated
	 */
	void setOtherValue(String value);

} // JRE
