/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#isAutoStart <em>Auto Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Instance()
 * @model extendedMetaData="name='DB2Instance' kind='elementOnly'"
 * @generated
 */
public interface DB2Instance extends DB2BaseInstance {
	/**
	 * Returns the value of the '<em><b>Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Start</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Indicates whether the instance starts automatically during at system startup
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Auto Start</em>' attribute.
	 * @see #isSetAutoStart()
	 * @see #unsetAutoStart()
	 * @see #setAutoStart(boolean)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Instance_AutoStart()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoStart'"
	 * @generated
	 */
	boolean isAutoStart();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#isAutoStart <em>Auto Start</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Start</em>' attribute.
	 * @see #isSetAutoStart()
	 * @see #unsetAutoStart()
	 * @see #isAutoStart()
	 * @generated
	 */
	void setAutoStart(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#isAutoStart <em>Auto Start</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAutoStart()
	 * @see #isAutoStart()
	 * @see #setAutoStart(boolean)
	 * @generated
	 */
	void unsetAutoStart();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#isAutoStart <em>Auto Start</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Start</em>' attribute is set.
	 * @see #unsetAutoStart()
	 * @see #isAutoStart()
	 * @see #setAutoStart(boolean)
	 * @generated
	 */
	boolean isSetAutoStart();

	/**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hostname</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * hostname of the computer with this DB2 instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Instance_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * password for DB2 instance administration user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Instance_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * port for the DB2 instance, e.g. "50000"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Instance_Port()
	 * @model dataType="com.ibm.ccl.soa.deploy.os.TCPPortType"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							username for DB2 instance administration user. e.g. db2admin (windows) or "db2inst1"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Instance_Username()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='username'"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

} // DB2Instance
