/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Node Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup#isIsDefaultType <em>Is Default Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup#getNodeGroupName <em>Node Group Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNodeGroup()
 * @model extendedMetaData="name='WasNodeGroup' kind='elementOnly'"
 * @generated
 */
public interface WasNodeGroup extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Is Default Type</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Is Default Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Default Type</em>' attribute.
	 * @see #isSetIsDefaultType()
	 * @see #unsetIsDefaultType()
	 * @see #setIsDefaultType(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNodeGroup_IsDefaultType()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isDefaultType'"
	 * @generated
	 */
	boolean isIsDefaultType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup#isIsDefaultType <em>Is Default Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Default Type</em>' attribute.
	 * @see #isSetIsDefaultType()
	 * @see #unsetIsDefaultType()
	 * @see #isIsDefaultType()
	 * @generated
	 */
	void setIsDefaultType(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup#isIsDefaultType <em>Is Default Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIsDefaultType()
	 * @see #isIsDefaultType()
	 * @see #setIsDefaultType(boolean)
	 * @generated
	 */
	void unsetIsDefaultType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup#isIsDefaultType <em>Is Default Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Default Type</em>' attribute is set.
	 * @see #unsetIsDefaultType()
	 * @see #isIsDefaultType()
	 * @see #setIsDefaultType(boolean)
	 * @generated
	 */
	boolean isSetIsDefaultType();

	/**
	 * Returns the value of the '<em><b>Node Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Node Group Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Group Name</em>' attribute.
	 * @see #setNodeGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNodeGroup_NodeGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nodeGroupName'"
	 * @generated
	 */
	String getNodeGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup#getNodeGroupName <em>Node Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Group Name</em>' attribute.
	 * @see #getNodeGroupName()
	 * @generated
	 */
	void setNodeGroupName(String value);

} // WasNodeGroup
