/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windows DB2 Client Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#isDefaultInstance <em>Default Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2ClientInstance()
 * @model extendedMetaData="name='WindowsDB2ClientInstance' kind='elementOnly'"
 * @generated
 */
public interface WindowsDB2ClientInstance extends DB2ClientInstance {
	/**
	 * Returns the value of the '<em><b>Default Instance</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Instance</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Instance</em>' attribute.
	 * @see #isSetDefaultInstance()
	 * @see #unsetDefaultInstance()
	 * @see #setDefaultInstance(boolean)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2ClientInstance_DefaultInstance()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='defaultInstance'"
	 * @generated
	 */
	boolean isDefaultInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#isDefaultInstance <em>Default Instance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Instance</em>' attribute.
	 * @see #isSetDefaultInstance()
	 * @see #unsetDefaultInstance()
	 * @see #isDefaultInstance()
	 * @generated
	 */
	void setDefaultInstance(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#isDefaultInstance <em>Default Instance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDefaultInstance()
	 * @see #isDefaultInstance()
	 * @see #setDefaultInstance(boolean)
	 * @generated
	 */
	void unsetDefaultInstance();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#isDefaultInstance <em>Default Instance</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Default Instance</em>' attribute is set.
	 * @see #unsetDefaultInstance()
	 * @see #isDefaultInstance()
	 * @see #setDefaultInstance(boolean)
	 * @generated
	 */
	boolean isSetDefaultInstance();

	/**
	 * Returns the value of the '<em><b>Instance Type</b></em>' attribute.
	 * The default value is <code>"Client"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
	 * @see #isSetInstanceType()
	 * @see #unsetInstanceType()
	 * @see #setInstanceType(WindowsInstanceTypeType)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2ClientInstance_InstanceType()
	 * @model default="Client" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='instanceType'"
	 * @generated
	 */
	WindowsInstanceTypeType getInstanceType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#getInstanceType <em>Instance Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
	 * @see #isSetInstanceType()
	 * @see #unsetInstanceType()
	 * @see #getInstanceType()
	 * @generated
	 */
	void setInstanceType(WindowsInstanceTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#getInstanceType <em>Instance Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetInstanceType()
	 * @see #getInstanceType()
	 * @see #setInstanceType(WindowsInstanceTypeType)
	 * @generated
	 */
	void unsetInstanceType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#getInstanceType <em>Instance Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Instance Type</em>' attribute is set.
	 * @see #unsetInstanceType()
	 * @see #getInstanceType()
	 * @see #setInstanceType(WindowsInstanceTypeType)
	 * @generated
	 */
	boolean isSetInstanceType();

} // WindowsDB2ClientInstance
