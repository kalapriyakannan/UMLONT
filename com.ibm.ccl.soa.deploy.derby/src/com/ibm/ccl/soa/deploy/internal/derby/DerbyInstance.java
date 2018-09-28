/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.database.DatabaseInstance;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyInstance()
 * @model extendedMetaData="name='DerbyInstance' kind='elementOnly'"
 * @generated
 */
public interface DerbyInstance extends DatabaseInstance {
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
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyInstance_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Instance Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Name</em>' attribute.
	 * @see #setInstanceName(String)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyInstance_InstanceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='instanceName'"
	 * @generated
	 */
	String getInstanceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getInstanceName <em>Instance Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Name</em>' attribute.
	 * @see #getInstanceName()
	 * @generated
	 */
	void setInstanceName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyInstance_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

} // DerbyInstance
