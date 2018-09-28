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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Host Name Alias Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.HostNameAliasType#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.HostNameAliasType#getHostnameAlias <em>Hostname Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getHostNameAliasType()
 * @model extendedMetaData="name='HostNameAliasType' kind='empty'"
 * @generated
 */
public interface HostNameAliasType {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getHostNameAliasType_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.HostNameAliasType#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Hostname Alias</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Hostname Alias</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hostname Alias</em>' attribute.
	 * @see #setHostnameAlias(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getHostNameAliasType_HostnameAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostnameAlias'"
	 * @generated
	 */
	String getHostnameAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.HostNameAliasType#getHostnameAlias <em>Hostname Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname Alias</em>' attribute.
	 * @see #getHostnameAlias()
	 * @generated
	 */
	void setHostnameAlias(String value);

} // HostNameAliasType
