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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Cell</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCell#getCellName <em>Cell Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCell#isIsDistributed <em>Is Distributed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCell#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCell()
 * @model extendedMetaData="name='WasCell' kind='elementOnly'"
 * @generated
 */
public interface WasCell extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Cell Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell Name</em>' attribute.
	 * @see #setCellName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCell_CellName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cellName'"
	 * @generated
	 */
	String getCellName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCell#getCellName <em>Cell Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cell Name</em>' attribute.
	 * @see #getCellName()
	 * @generated
	 */
	void setCellName(String value);

	/**
	 * Returns the value of the '<em><b>Is Distributed</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Is Distributed</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Distributed</em>' attribute.
	 * @see #isSetIsDistributed()
	 * @see #unsetIsDistributed()
	 * @see #setIsDistributed(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCell_IsDistributed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isDistributed'"
	 * @generated
	 */
	boolean isIsDistributed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCell#isIsDistributed <em>Is Distributed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Distributed</em>' attribute.
	 * @see #isSetIsDistributed()
	 * @see #unsetIsDistributed()
	 * @see #isIsDistributed()
	 * @generated
	 */
	void setIsDistributed(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCell#isIsDistributed <em>Is Distributed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIsDistributed()
	 * @see #isIsDistributed()
	 * @see #setIsDistributed(boolean)
	 * @generated
	 */
	void unsetIsDistributed();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCell#isIsDistributed <em>Is Distributed</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Distributed</em>' attribute is set.
	 * @see #unsetIsDistributed()
	 * @see #isIsDistributed()
	 * @see #setIsDistributed(boolean)
	 * @generated
	 */
	boolean isSetIsDistributed();

	/**
	 * Returns the value of the '<em><b>Was Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Version</em>' attribute.
	 * @see #setWasVersion(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCell_WasVersion()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='wasVersion'"
	 * @generated
	 */
	String getWasVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCell#getWasVersion <em>Was Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Version</em>' attribute.
	 * @see #getWasVersion()
	 * @generated
	 */
	void setWasVersion(String value);

} // WasCell
