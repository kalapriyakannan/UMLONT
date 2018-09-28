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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Virtual Host Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.VirtualHostType#getHostNameAlias <em>Host Name Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.VirtualHostType#getHostName <em>Host Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getVirtualHostType()
 * @model extendedMetaData="name='VirtualHostType' kind='elementOnly'"
 * @generated
 */
public interface VirtualHostType extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Host Name Alias</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host Name Alias</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Host Name Alias</em>' containment reference.
	 * @see #setHostNameAlias(HostNameAliasType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getVirtualHostType_HostNameAlias()
	 * @model containment="true" required="true" extendedMetaData="kind='element'
	 *        name='hostNameAlias' namespace='##targetNamespace'"
	 * @generated
	 */
	HostNameAliasType getHostNameAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.VirtualHostType#getHostNameAlias <em>Host Name Alias</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host Name Alias</em>' containment reference.
	 * @see #getHostNameAlias()
	 * @generated
	 */
	void setHostNameAlias(HostNameAliasType value);

	/**
	 * Returns the value of the '<em><b>Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host Name</em>' attribute.
	 * @see #setHostName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getVirtualHostType_HostName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostName'"
	 * @generated
	 */
	String getHostName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.VirtualHostType#getHostName <em>Host Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host Name</em>' attribute.
	 * @see #getHostName()
	 * @generated
	 */
	void setHostName(String value);

} // VirtualHostType
