/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>LdapServer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     This is the characteristic capability of the {@link LdapServerUnit}.
 *                 </p>
 *                 <p>TODO: Need to define the 'securePort', defaulting to 636.</p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorDN <em>Administrator DN</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorPassword <em>Administrator Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapServer()
 * @model extendedMetaData="name='LdapServer' kind='elementOnly'"
 * @generated
 */
public interface LdapServer extends Capability {
	/**
	 * Returns the value of the '<em><b>Administrator DN</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Administrator DN</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Administrator DN</em>' attribute.
	 * @see #setAdministratorDN(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdap_AdministratorDN()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='administratorDN'"
	 * @generated
	 */
	String getAdministratorDN();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorDN <em>Administrator DN</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Administrator DN</em>' attribute.
	 * @see #isSetAdministratorDN()
	 * @see #unsetAdministratorDN()
	 * @see #getAdministratorDN()
	 * @generated
	 */
	void setAdministratorDN(String value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorDN <em>Administrator DN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAdministratorDN()
	 * @see #getAdministratorDN()
	 * @see #setAdministratorDN(String)
	 * @generated
	 */
	void unsetAdministratorDN();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorDN <em>Administrator DN</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Administrator DN</em>' attribute is set.
	 * @see #unsetAdministratorDN()
	 * @see #getAdministratorDN()
	 * @see #setAdministratorDN(String)
	 * @generated
	 */
	boolean isSetAdministratorDN();

	/**
	 * Returns the value of the '<em><b>Administrator Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             <p>The password for the administrator.</p>
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Administrator Password</em>' attribute.
	 * @see #setAdministratorPassword(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapServer_AdministratorPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='administratorPassword'"
	 * @generated
	 */
	String getAdministratorPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorPassword <em>Administrator Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Administrator Password</em>' attribute.
	 * @see #getAdministratorPassword()
	 * @generated
	 */
	void setAdministratorPassword(String value);

} // LdapServer
