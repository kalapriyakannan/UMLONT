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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Unix DB2 Admin Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGID <em>Das GID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGroupName <em>Das Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUID <em>Das UID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserName <em>Das User Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserPassword <em>Das User Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2AdminServer()
 * @model extendedMetaData="name='UnixDB2AdminServer' kind='elementOnly'"
 * @generated
 */
public interface UnixDB2AdminServer extends DB2AdminServer {
	/**
	 * Returns the value of the '<em><b>Das GID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Das GID</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							DB2 Administration Server group identifier. A number in range 0 - 65535. Recommendation is
	 * 							to leave this attribute unset.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Das GID</em>' attribute.
	 * @see #setDasGID(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2AdminServer_DasGID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasGID'"
	 * @generated
	 */
	String getDasGID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGID <em>Das GID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das GID</em>' attribute.
	 * @see #getDasGID()
	 * @generated
	 */
	void setDasGID(String value);

	/**
	 * Returns the value of the '<em><b>Das Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Das Group Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DB2 Administration Server user group name, e.g. "dasadm1"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Das Group Name</em>' attribute.
	 * @see #setDasGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2AdminServer_DasGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasGroupName'"
	 * @generated
	 */
	String getDasGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGroupName <em>Das Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das Group Name</em>' attribute.
	 * @see #getDasGroupName()
	 * @generated
	 */
	void setDasGroupName(String value);

	/**
	 * Returns the value of the '<em><b>Das UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Das UID</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							DB2 Administration Server user identifier. A number in range 0 - 65535. Recommendation is to
	 * 							leave this attribute unset.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Das UID</em>' attribute.
	 * @see #setDasUID(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2AdminServer_DasUID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasUID'"
	 * @generated
	 */
	String getDasUID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUID <em>Das UID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das UID</em>' attribute.
	 * @see #getDasUID()
	 * @generated
	 */
	void setDasUID(String value);

	/**
	 * Returns the value of the '<em><b>Das User Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Das User Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DB2 Administration Server user name, e.g. "dasusr1"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Das User Name</em>' attribute.
	 * @see #setDasUserName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2AdminServer_DasUserName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasUserName'"
	 * @generated
	 */
	String getDasUserName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserName <em>Das User Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das User Name</em>' attribute.
	 * @see #getDasUserName()
	 * @generated
	 */
	void setDasUserName(String value);

	/**
	 * Returns the value of the '<em><b>Das User Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Das User Password</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Das User Password</em>' attribute.
	 * @see #setDasUserPassword(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2AdminServer_DasUserPassword()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dasUserPassword'"
	 * @generated
	 */
	String getDasUserPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserPassword <em>Das User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Das User Password</em>' attribute.
	 * @see #getDasUserPassword()
	 * @generated
	 */
	void setDasUserPassword(String value);

} // UnixDB2AdminServer
