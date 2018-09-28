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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JDK</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JDK#getJdkVersion <em>Jdk Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JDK#getOtherValue <em>Other Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJDK()
 * @model extendedMetaData="name='JDK' kind='elementOnly'"
 * @generated
 */
public interface JDK extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Jdk Version</b></em>' attribute.
	 * The default value is <code>"1.2"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.java.JREVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdk Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdk Version</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @see #isSetJdkVersion()
	 * @see #unsetJdkVersion()
	 * @see #setJdkVersion(JREVersion)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJDK_JdkVersion()
	 * @model default="1.2" unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='jdkVersion'"
	 * @generated
	 */
	JREVersion getJdkVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JDK#getJdkVersion <em>Jdk Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdk Version</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @see #isSetJdkVersion()
	 * @see #unsetJdkVersion()
	 * @see #getJdkVersion()
	 * @generated
	 */
	void setJdkVersion(JREVersion value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JDK#getJdkVersion <em>Jdk Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetJdkVersion()
	 * @see #getJdkVersion()
	 * @see #setJdkVersion(JREVersion)
	 * @generated
	 */
	void unsetJdkVersion();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JDK#getJdkVersion <em>Jdk Version</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jdk Version</em>' attribute is set.
	 * @see #unsetJdkVersion()
	 * @see #getJdkVersion()
	 * @see #setJdkVersion(JREVersion)
	 * @generated
	 */
	boolean isSetJdkVersion();

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
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJDK_OtherValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='otherValue'"
	 * @generated
	 */
	String getOtherValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JDK#getOtherValue <em>Other Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Value</em>' attribute.
	 * @see #getOtherValue()
	 * @generated
	 */
	void setOtherValue(String value);

} // JDK
