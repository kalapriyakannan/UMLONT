/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>AIX Local Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupDescription <em>Group Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupSid <em>Group Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalGroup()
 * @model extendedMetaData="name='AIXLocalGroup' kind='elementOnly'"
 * @generated
 */
public interface AIXLocalGroup extends UserGroup {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Group Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Description</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Group Description</em>' attribute.
	 * @see #setGroupDescription(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalGroup_GroupDescription()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='GroupDescription'"
	 * @generated
	 */
	String getGroupDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupDescription <em>Group Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Description</em>' attribute.
	 * @see #getGroupDescription()
	 * @generated
	 */
	void setGroupDescription(String value);

	/**
	 * Returns the value of the '<em><b>Group Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Sid</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Sid</em>' attribute.
	 * @see #setGroupSid(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalGroup_GroupSid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='GroupSid'"
	 * @generated
	 */
	String getGroupSid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupSid <em>Group Sid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Sid</em>' attribute.
	 * @see #getGroupSid()
	 * @generated
	 */
	void setGroupSid(String value);

} // AIXLocalGroup
