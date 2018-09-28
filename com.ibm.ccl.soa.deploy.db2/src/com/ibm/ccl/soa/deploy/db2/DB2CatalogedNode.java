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

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Cataloged Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getDasLevel <em>Das Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogedNode()
 * @model extendedMetaData="name='DB2CatalogedNode' kind='elementOnly'"
 * @generated
 */
public interface DB2CatalogedNode extends Capability {
	/**
	 * Returns the value of the '<em><b>Das Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Das Level</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The level of the remote DB2 administration server, e.g. "8.1.0.36"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Das Level</em>' attribute.
	 * @see #setDasLevel(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogedNode_DasLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasLevel'"
	 * @generated
	 */
	String getDasLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getDasLevel <em>Das Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das Level</em>' attribute.
	 * @see #getDasLevel()
	 * @generated
	 */
	void setDasLevel(String value);

	/**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hostname</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resolvable name of host of the DB2 instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogedNode_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Node name for the DB2 cataloged node
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Name</em>' attribute.
	 * @see #setNodeName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogedNode_NodeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nodeName'"
	 * @generated
	 */
	String getNodeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeName <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Name</em>' attribute.
	 * @see #getNodeName()
	 * @generated
	 */
	void setNodeName(String value);

	/**
	 * Returns the value of the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Typically "TCPIP"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Type</em>' attribute.
	 * @see #setNodeType(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogedNode_NodeType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nodeType'"
	 * @generated
	 */
	String getNodeType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeType <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Type</em>' attribute.
	 * @see #getNodeType()
	 * @generated
	 */
	void setNodeType(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Port number used to interact with the DB2 instance, e.g. "50000"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogedNode_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

} // DB2CatalogedNode
