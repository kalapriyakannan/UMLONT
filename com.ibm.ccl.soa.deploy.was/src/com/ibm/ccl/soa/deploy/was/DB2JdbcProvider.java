/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getJdbcType <em>Jdbc Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDB2JdbcProvider()
 * @model extendedMetaData="name='DB2JdbcProvider' kind='elementOnly'"
 * @generated
 */
public interface DB2JdbcProvider extends ExtendedJdbcProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Jdbc Type</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.java.JdbcTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
	 * @see #isSetJdbcType()
	 * @see #unsetJdbcType()
	 * @see #setJdbcType(JdbcTypeType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDB2JdbcProvider_JdbcType()
	 * @model default="1" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='jdbcType'"
	 * @generated
	 */
	JdbcTypeType getJdbcType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getJdbcType <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
	 * @see #isSetJdbcType()
	 * @see #unsetJdbcType()
	 * @see #getJdbcType()
	 * @generated
	 */
	void setJdbcType(JdbcTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getJdbcType <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetJdbcType()
	 * @see #getJdbcType()
	 * @see #setJdbcType(JdbcTypeType)
	 * @generated
	 */
	void unsetJdbcType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getJdbcType <em>Jdbc Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jdbc Type</em>' attribute is set.
	 * @see #unsetJdbcType()
	 * @see #getJdbcType()
	 * @see #setJdbcType(JdbcTypeType)
	 * @generated
	 */
	boolean isSetJdbcType();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' attribute.
	 * The default value is <code>"none"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType
	 * @see #isSetTemplate()
	 * @see #unsetTemplate()
	 * @see #setTemplate(DB2JdbcProviderType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDB2JdbcProvider_Template()
	 * @model default="none" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='template'"
	 * @generated
	 */
	DB2JdbcProviderType getTemplate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType
	 * @see #isSetTemplate()
	 * @see #unsetTemplate()
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(DB2JdbcProviderType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTemplate()
	 * @see #getTemplate()
	 * @see #setTemplate(DB2JdbcProviderType)
	 * @generated
	 */
	void unsetTemplate();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider#getTemplate <em>Template</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template</em>' attribute is set.
	 * @see #unsetTemplate()
	 * @see #getTemplate()
	 * @see #setTemplate(DB2JdbcProviderType)
	 * @generated
	 */
	boolean isSetTemplate();

} // DB2JdbcProvider
