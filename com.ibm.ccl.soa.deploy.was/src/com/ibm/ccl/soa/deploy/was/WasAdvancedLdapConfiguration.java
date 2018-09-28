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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Advanced Ldap Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getCertificateFilter <em>Certificate Filter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getCertificateMapMode <em>Certificate Map Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getGroupFilter <em>Group Filter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getGroupIdMap <em>Group Id Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getGroupMemberIdMap <em>Group Member Id Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getUserFilter <em>User Filter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getUserIdMap <em>User Id Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration()
 * @model extendedMetaData="name='WasAdvancedLdapConfiguration' kind='elementOnly'"
 * @generated
 */
public interface WasAdvancedLdapConfiguration extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Certificate Filter</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Certificate Filter</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Certificate Filter</em>' attribute.
	 * @see #setCertificateFilter(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_CertificateFilter()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='certificateFilter'"
	 * @generated
	 */
	String getCertificateFilter();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getCertificateFilter <em>Certificate Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Certificate Filter</em>' attribute.
	 * @see #getCertificateFilter()
	 * @generated
	 */
	void setCertificateFilter(String value);

	/**
	 * Returns the value of the '<em><b>Certificate Map Mode</b></em>' attribute.
	 * The default value is <code>"EXACT_DN"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.CertificateMapMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Certificate Map Mode</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Certificate Map Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.CertificateMapMode
	 * @see #isSetCertificateMapMode()
	 * @see #unsetCertificateMapMode()
	 * @see #setCertificateMapMode(CertificateMapMode)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_CertificateMapMode()
	 * @model default="EXACT_DN" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='certificateMapMode'"
	 * @generated
	 */
	CertificateMapMode getCertificateMapMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getCertificateMapMode <em>Certificate Map Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Certificate Map Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.CertificateMapMode
	 * @see #isSetCertificateMapMode()
	 * @see #unsetCertificateMapMode()
	 * @see #getCertificateMapMode()
	 * @generated
	 */
	void setCertificateMapMode(CertificateMapMode value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getCertificateMapMode <em>Certificate Map Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetCertificateMapMode()
	 * @see #getCertificateMapMode()
	 * @see #setCertificateMapMode(CertificateMapMode)
	 * @generated
	 */
	void unsetCertificateMapMode();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getCertificateMapMode <em>Certificate Map Mode</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Certificate Map Mode</em>' attribute is set.
	 * @see #unsetCertificateMapMode()
	 * @see #getCertificateMapMode()
	 * @see #setCertificateMapMode(CertificateMapMode)
	 * @generated
	 */
	boolean isSetCertificateMapMode();

	/**
	 * Returns the value of the '<em><b>Group Filter</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Group Filter</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Filter</em>' attribute.
	 * @see #setGroupFilter(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_GroupFilter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='groupFilter'"
	 * @generated
	 */
	String getGroupFilter();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getGroupFilter <em>Group Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Filter</em>' attribute.
	 * @see #getGroupFilter()
	 * @generated
	 */
	void setGroupFilter(String value);

	/**
	 * Returns the value of the '<em><b>Group Id Map</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Group Id Map</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id Map</em>' attribute.
	 * @see #setGroupIdMap(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_GroupIdMap()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='groupIdMap'"
	 * @generated
	 */
	String getGroupIdMap();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getGroupIdMap <em>Group Id Map</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id Map</em>' attribute.
	 * @see #getGroupIdMap()
	 * @generated
	 */
	void setGroupIdMap(String value);

	/**
	 * Returns the value of the '<em><b>Group Member Id Map</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Member Id Map</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Group Member Id Map</em>' attribute.
	 * @see #setGroupMemberIdMap(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_GroupMemberIdMap()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='groupMemberIdMap'"
	 * @generated
	 */
	String getGroupMemberIdMap();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getGroupMemberIdMap <em>Group Member Id Map</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Member Id Map</em>' attribute.
	 * @see #getGroupMemberIdMap()
	 * @generated
	 */
	void setGroupMemberIdMap(String value);

	/**
	 * Returns the value of the '<em><b>User Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Filter</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Filter</em>' attribute.
	 * @see #setUserFilter(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_UserFilter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userFilter'"
	 * @generated
	 */
	String getUserFilter();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getUserFilter <em>User Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Filter</em>' attribute.
	 * @see #getUserFilter()
	 * @generated
	 */
	void setUserFilter(String value);

	/**
	 * Returns the value of the '<em><b>User Id Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id Map</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id Map</em>' attribute.
	 * @see #setUserIdMap(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAdvancedLdapConfiguration_UserIdMap()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userIdMap'"
	 * @generated
	 */
	String getUserIdMap();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration#getUserIdMap <em>User Id Map</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id Map</em>' attribute.
	 * @see #getUserIdMap()
	 * @generated
	 */
	void setUserIdMap(String value);

} // WasAdvancedLdapConfiguration
