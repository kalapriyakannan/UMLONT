/**
 * <copyright>
 * </copyright>
 *
 * $Id: LdapEntry.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapEntry#getRelativeDN <em>Relative DN</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapEntry()
 * @model extendedMetaData="name='LdapEntry' kind='elementOnly'"
 * @generated
 */
public interface LdapEntry extends Capability {
	/**
	 * Returns the value of the '<em><b>Relative DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             <p>The relative distinguished name of this entry.</p>
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relative DN</em>' attribute.
	 * @see #setRelativeDN(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapEntry_RelativeDN()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='relativeDN'"
	 * @generated
	 */
	String getRelativeDN();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapEntry#getRelativeDN <em>Relative DN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative DN</em>' attribute.
	 * @see #getRelativeDN()
	 * @generated
	 */
	void setRelativeDN(String value);

} // LdapEntry
