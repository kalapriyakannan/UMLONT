/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>V4 Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#isDisableAutoConnectionCleanup <em>Disable Auto Connection Cleanup</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#getIdleTimeout <em>Idle Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#getOrphanTimeout <em>Orphan Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV4Datasource()
 * @model extendedMetaData="name='WasV4Datasource' kind='elementOnly'"
 * @generated
 */
public interface WasV4Datasource extends WasDatasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Disable Auto Connection Cleanup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disable Auto Connection Cleanup</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disable Auto Connection Cleanup</em>' attribute.
	 * @see #isSetDisableAutoConnectionCleanup()
	 * @see #unsetDisableAutoConnectionCleanup()
	 * @see #setDisableAutoConnectionCleanup(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV4Datasource_DisableAutoConnectionCleanup()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='disableAutoConnectionCleanup'"
	 * @generated
	 */
	boolean isDisableAutoConnectionCleanup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#isDisableAutoConnectionCleanup <em>Disable Auto Connection Cleanup</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disable Auto Connection Cleanup</em>' attribute.
	 * @see #isSetDisableAutoConnectionCleanup()
	 * @see #unsetDisableAutoConnectionCleanup()
	 * @see #isDisableAutoConnectionCleanup()
	 * @generated
	 */
	void setDisableAutoConnectionCleanup(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#isDisableAutoConnectionCleanup <em>Disable Auto Connection Cleanup</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDisableAutoConnectionCleanup()
	 * @see #isDisableAutoConnectionCleanup()
	 * @see #setDisableAutoConnectionCleanup(boolean)
	 * @generated
	 */
	void unsetDisableAutoConnectionCleanup();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#isDisableAutoConnectionCleanup <em>Disable Auto Connection Cleanup</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Disable Auto Connection Cleanup</em>' attribute is set.
	 * @see #unsetDisableAutoConnectionCleanup()
	 * @see #isDisableAutoConnectionCleanup()
	 * @see #setDisableAutoConnectionCleanup(boolean)
	 * @generated
	 */
	boolean isSetDisableAutoConnectionCleanup();

	/**
	 * Returns the value of the '<em><b>Idle Timeout</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Idle Timeout</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idle Timeout</em>' attribute.
	 * @see #setIdleTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV4Datasource_IdleTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='idleTimeout'"
	 * @generated
	 */
	String getIdleTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#getIdleTimeout <em>Idle Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idle Timeout</em>' attribute.
	 * @see #getIdleTimeout()
	 * @generated
	 */
	void setIdleTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Orphan Timeout</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Orphan Timeout</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orphan Timeout</em>' attribute.
	 * @see #setOrphanTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV4Datasource_OrphanTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='orphanTimeout'"
	 * @generated
	 */
	String getOrphanTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource#getOrphanTimeout <em>Orphan Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orphan Timeout</em>' attribute.
	 * @see #getOrphanTimeout()
	 * @generated
	 */
	void setOrphanTimeout(String value);

} // WasV4Datasource
