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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Suffix Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     Configuration unit defining a suffix DN which is serviced by this LDAP
 *                     server. Note that an LDAP server may support many suffixes. Our
 *                     characteristic capability is {@link LdapSuffix}.
 *                 </p>
 *                 <p>
 *                     This unit must have a mandatory hosting requirement on an LDAP Server.
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapSuffixUnit()
 * @model extendedMetaData="name='LdapSuffixUnit' kind='elementOnly'"
 * @generated
 */
public interface LdapSuffixUnit extends Unit {
} // LdapSuffixUnit
