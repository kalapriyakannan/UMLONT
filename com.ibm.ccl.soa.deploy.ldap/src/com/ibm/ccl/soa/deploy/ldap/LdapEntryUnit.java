/**
 * <copyright>
 * </copyright>
 *
 * $Id: LdapEntryUnit.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     Configuration unit defining an entry in an LDAP directory. Our
 *                     characteristic capability is {@link LdapEntry}. In addition, an
 *                     {@link LdapEntryUnit} MUST have exactly one structural LDAP class
 *                     capability (a specialization of {@link Top}), MAY have one or more
 *                     auxiliary LDAP class capabilities (specializations of {@link
 *                     LDAPAuxiliaryClass}), and MUST have {@link ExtendedAttribute
 *                     ExtendedAttributes}, attached to the {@link LdapEntry} capability,
 *                     which are compatible with the LDAP classes.
 *                 </p>
 *                 <p>
 *                     This unit must have a mandatory hosting requirement on either
 *                     an(other) {@link LdapEntry} or an {@link LdapServer} (for top-level
 *                     entries).
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapEntryUnit()
 * @model extendedMetaData="name='LdapEntryUnit' kind='elementOnly'"
 * @generated
 */
public interface LdapEntryUnit extends Unit {
} // LdapEntryUnit
