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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Suffix</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     Should we have a reference to an {@link LdapEntry} configuration unit
 *                     instead of (or in addition to) the 'suffixDN' string?
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapSuffix#getSuffixDN <em>Suffix DN</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapSuffix()
 * @model extendedMetaData="name='LdapSuffix' kind='elementOnly'"
 * @generated
 */
public interface LdapSuffix extends Capability {
	/**
	 * Returns the value of the '<em><b>Suffix DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix DN</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                             <p>The suffix, expressed as a distinguished name (DN).</p>
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Suffix DN</em>' attribute.
	 * @see #setSuffixDN(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapSuffix_SuffixDN()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='suffixDN'"
	 * @generated
	 */
	String getSuffixDN();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapSuffix#getSuffixDN <em>Suffix DN</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix DN</em>' attribute.
	 * @see #getSuffixDN()
	 * @generated
	 */
	void setSuffixDN(String value);

} // LdapSuffix
