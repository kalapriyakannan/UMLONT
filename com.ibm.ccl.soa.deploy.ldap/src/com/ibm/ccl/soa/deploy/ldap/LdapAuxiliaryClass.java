/**
 * <copyright>
 * </copyright>
 *
 * $Id: LdapAuxiliaryClass.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDAP Auxillary Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>Abstract superclass for all of our LDAP auxiliary classes</p>
 *                 <p>
 *                     Even though auxiliary classes can inherit from {@link Top}, we do not
 *                     permit this, due to our lack of multiple interitance.
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapAuxiliaryClass()
 * @model abstract="true"
 *        extendedMetaData="name='LdapAuxiliaryClass' kind='elementOnly'"
 * @generated
 */
public interface LdapAuxiliaryClass extends LdapObject {
} // LdapAuxiliaryClass
