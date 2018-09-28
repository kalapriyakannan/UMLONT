/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>J2EE Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDatasourceName <em>Datasource Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDbName <em>Db Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#isUsedForCmp <em>Used For Cmp</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource()
 * @model extendedMetaData="name='J2EEDatasource' kind='elementOnly'"
 * @generated
 */
public interface J2EEDatasource extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Datasource Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Datasource Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datasource Name</em>' attribute.
	 * @see #setDatasourceName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_DatasourceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='datasourceName'"
	 * @generated
	 */
	String getDatasourceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDatasourceName <em>Datasource Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datasource Name</em>' attribute.
	 * @see #getDatasourceName()
	 * @generated
	 */
	void setDatasourceName(String value);

	/**
	 * Returns the value of the '<em><b>Db Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Name</em>' attribute.
	 * @see #setDbName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_DbName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbName'"
	 * @generated
	 */
	String getDbName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDbName <em>Db Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Name</em>' attribute.
	 * @see #getDbName()
	 * @generated
	 */
	void setDbName(String value);

	/**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hostname</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jndi Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jndi Name</em>' attribute.
	 * @see #setJndiName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPassword <em>Password</em>}' attribute.
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
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Used For Cmp</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Used For Cmp</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used For Cmp</em>' attribute.
	 * @see #isSetUsedForCmp()
	 * @see #unsetUsedForCmp()
	 * @see #setUsedForCmp(boolean)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_UsedForCmp()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='usedForCmp'"
	 * @generated
	 */
	boolean isUsedForCmp();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#isUsedForCmp <em>Used For Cmp</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used For Cmp</em>' attribute.
	 * @see #isSetUsedForCmp()
	 * @see #unsetUsedForCmp()
	 * @see #isUsedForCmp()
	 * @generated
	 */
	void setUsedForCmp(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#isUsedForCmp <em>Used For Cmp</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUsedForCmp()
	 * @see #isUsedForCmp()
	 * @see #setUsedForCmp(boolean)
	 * @generated
	 */
	void unsetUsedForCmp();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#isUsedForCmp <em>Used For Cmp</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Used For Cmp</em>' attribute is set.
	 * @see #unsetUsedForCmp()
	 * @see #isUsedForCmp()
	 * @see #setUsedForCmp(boolean)
	 * @generated
	 */
	boolean isSetUsedForCmp();

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDatasource_Username()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='username'"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

} // J2EEDatasource
