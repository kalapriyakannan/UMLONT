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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Derby Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDerbyJdbcProvider()
 * @model extendedMetaData="name='DerbyJdbcProvider' kind='elementOnly'"
 * @generated
 */
public interface DerbyJdbcProvider extends ExtendedJdbcProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Template</b></em>' attribute.
	 * The default value is <code>"Cloudscape JDBC Provider"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderTypeType
	 * @see #isSetTemplate()
	 * @see #unsetTemplate()
	 * @see #setTemplate(DerbyJdbcProviderTypeType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDerbyJdbcProvider_Template()
	 * @model default="Cloudscape JDBC Provider" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='template'"
	 * @generated
	 */
	DerbyJdbcProviderTypeType getTemplate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider#getTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderTypeType
	 * @see #isSetTemplate()
	 * @see #unsetTemplate()
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(DerbyJdbcProviderTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider#getTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTemplate()
	 * @see #getTemplate()
	 * @see #setTemplate(DerbyJdbcProviderTypeType)
	 * @generated
	 */
	void unsetTemplate();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider#getTemplate <em>Template</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template</em>' attribute is set.
	 * @see #unsetTemplate()
	 * @see #getTemplate()
	 * @see #setTemplate(DerbyJdbcProviderTypeType)
	 * @generated
	 */
	boolean isSetTemplate();

} // DerbyJdbcProvider
