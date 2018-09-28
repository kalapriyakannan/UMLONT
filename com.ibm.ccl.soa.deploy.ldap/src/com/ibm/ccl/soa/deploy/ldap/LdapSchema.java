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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Schema</b></em>'. <!--
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
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapSchema#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapSchema()
 * @model extendedMetaData="name='LdapSchema' kind='elementOnly'"
 * @generated
 */
public interface LdapSchema extends Capability {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The default value is <code>"add"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.ldap.SchemaAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
	 * @see #isSetAction()
	 * @see #unsetAction()
	 * @see #setAction(SchemaAction)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapSchema_Action()
	 * @model default="add" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='action'"
	 * @generated
	 */
	SchemaAction getAction();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapSchema#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
	 * @see #isSetAction()
	 * @see #unsetAction()
	 * @see #getAction()
	 * @generated
	 */
	void setAction(SchemaAction value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapSchema#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAction()
	 * @see #getAction()
	 * @see #setAction(SchemaAction)
	 * @generated
	 */
	void unsetAction();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapSchema#getAction <em>Action</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Action</em>' attribute is set.
	 * @see #unsetAction()
	 * @see #getAction()
	 * @see #setAction(SchemaAction)
	 * @generated
	 */
	boolean isSetAction();

} // LdapSchema
