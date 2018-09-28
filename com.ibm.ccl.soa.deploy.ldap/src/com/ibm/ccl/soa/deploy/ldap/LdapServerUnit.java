/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Unit</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     This is the unit that represents an LDAP server. It should have a
 *                     hosting requirement on an operating system. Some LDAP servers may have
 *                     a dependency on a database, but this is not an inherent property of
 *                     LDAP servers, so we don't include it.
 *                 </p>
 *                 <p>
 *                     Our characteristic capability is {@link Ldap}: this capability can
 *                     host LDAPSuffix configuration units, as well as LDAPDirectoryEntry
 *                     configuration units.
 *                 </p>
 *                 <p>
 *                     This is a minimal LDAP domain: we will extend it in the future as
 *                     needed to support future use-cases. In particular, we probably need to
 *                     model the encryption salt value (and probably the encryption scheme).
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapServerUnit()
 * @model extendedMetaData="name='LdapServerUnit' kind='elementOnly'"
 * @generated
 */
public interface LdapServerUnit extends Unit {
} // LdapServerUnit
