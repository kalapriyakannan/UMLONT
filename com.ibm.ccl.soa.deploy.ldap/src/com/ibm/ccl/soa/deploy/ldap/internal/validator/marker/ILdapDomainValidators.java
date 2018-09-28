/***************************************************************************************************
 * ILdapDomainValidators.java -- Definitions of validator IDs for the LDAP domain. Copyright (c)
 * 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ldap.internal.validator.marker;

import com.ibm.ccl.soa.deploy.ldap.LdapDeployPlugin;
import com.ibm.ccl.soa.deploy.ldap.LdapEntryUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.LdapEntryUnitValidator;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.LdapServerUnitValidator;

/**
 * @since 7.0
 * 
 */
public interface ILdapDomainValidators {

	/** The unit validator for {@link LdapEntryUnit} */
	public final static String LDAP_ENTRY_UNIT_VALIDATOR = LdapDeployPlugin.PLUGIN_ID
			+ "." + LdapEntryUnitValidator.class.getName(); //$NON-NLS-1$

	/** The unit validator for {@link LdapServerUnit} */
	public final static String LDAP_SERVER_UNIT_VALIDATOR = LdapDeployPlugin.PLUGIN_ID
			+ "." + LdapServerUnitValidator.class.getName(); //$NON-NLS-1$
}
