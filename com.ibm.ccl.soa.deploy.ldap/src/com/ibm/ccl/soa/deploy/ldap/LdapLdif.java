/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ldif</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 @deprecated until we find an actual use for this
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getAction <em>Action</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getSubtreeDn <em>Subtree Dn</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapLdif()
 * @model extendedMetaData="name='LdapLdif' kind='elementOnly'"
 * @generated
 */
public interface LdapLdif extends Capability {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The default value is <code>"import"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.ldap.LdifAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
	 * @see #isSetAction()
	 * @see #unsetAction()
	 * @see #setAction(LdifAction)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapLdif_Action()
	 * @model default="import" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='action'"
	 * @generated
	 */
	LdifAction getAction();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
	 * @see #isSetAction()
	 * @see #unsetAction()
	 * @see #getAction()
	 * @generated
	 */
	void setAction(LdifAction value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAction()
	 * @see #getAction()
	 * @see #setAction(LdifAction)
	 * @generated
	 */
	void unsetAction();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getAction <em>Action</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Action</em>' attribute is set.
	 * @see #unsetAction()
	 * @see #getAction()
	 * @see #setAction(LdifAction)
	 * @generated
	 */
	boolean isSetAction();

	/**
	 * Returns the value of the '<em><b>Subtree Dn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtree Dn</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtree Dn</em>' attribute.
	 * @see #setSubtreeDn(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapLdif_SubtreeDn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subtree_dn'"
	 * @generated
	 */
	String getSubtreeDn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getSubtreeDn <em>Subtree Dn</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subtree Dn</em>' attribute.
	 * @see #getSubtreeDn()
	 * @generated
	 */
	void setSubtreeDn(String value);

} // LdapLdif
