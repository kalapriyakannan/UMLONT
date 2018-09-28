/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Jdbc Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClassname <em>Classname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getDriverPath <em>Driver Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getJdbcType <em>Jdbc Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2JdbcDriver()
 * @model extendedMetaData="name='DB2JdbcDriver' kind='elementOnly'"
 * @generated
 */
public interface DB2JdbcDriver extends Capability {
	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "COM.ibm.db2.jdbc.DB2XADataSource"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2JdbcDriver_Classname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='classname'"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classpath</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "C:/IBM/SQLLIB/db2java.zip"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classpath</em>' attribute.
	 * @see #setClasspath(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2JdbcDriver_Classpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='classpath'"
	 * @generated
	 */
	String getClasspath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClasspath <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' attribute.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(String value);

	/**
	 * Returns the value of the '<em><b>Driver Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver Path</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Driver Path</em>' attribute.
	 * @see #setDriverPath(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2JdbcDriver_DriverPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='driverPath'"
	 * @generated
	 */
	String getDriverPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getDriverPath <em>Driver Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Path</em>' attribute.
	 * @see #getDriverPath()
	 * @generated
	 */
	void setDriverPath(String value);

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
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2JdbcDriver_JdbcType()
	 * @model default="1" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='jdbcType'"
	 * @generated
	 */
	JdbcTypeType getJdbcType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getJdbcType <em>Jdbc Type</em>}' attribute.
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
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getJdbcType <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetJdbcType()
	 * @see #getJdbcType()
	 * @see #setJdbcType(JdbcTypeType)
	 * @generated
	 */
	void unsetJdbcType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getJdbcType <em>Jdbc Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jdbc Type</em>' attribute is set.
	 * @see #unsetJdbcType()
	 * @see #getJdbcType()
	 * @see #setJdbcType(JdbcTypeType)
	 * @generated
	 */
	boolean isSetJdbcType();

} // DB2JdbcDriver
