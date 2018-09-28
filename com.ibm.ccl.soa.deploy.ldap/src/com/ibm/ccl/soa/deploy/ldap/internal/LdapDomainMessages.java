/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.internal;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the SOA LdapServer domain.
 */
public class LdapDomainMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ldap.internal.messages"; //$NON-NLS-1$

	public static String Ldap_entry_0_must_have_a_structural_cap;

	public static String Ldap_entry_0_has_multi_structural_caps;

	public static String Ldap_entry_0_missing_required_attr_1;

	public static String Ldap_entry_0_missing_optional_attr_1;

	public static String EA_0_prohibited_by_LDAP_schema;

	public static String EA_0_must_have_a_value;

	public static String EA_0_not_part_of_schema;

	// /////////////////////////////////////////////////////////////////////////////////////

	public static String Validator_Ldap_database_0_not_uniquely_hosted_on_1;
	public static String Validator_Ldap_hostname_0_does_not_match_os_1;
	public static String Validator_Ldap_suffix_DN_0_does_not_match_provided_name_1;
	public static String Validator_Ldap_ldiff_module_0_missing_file_artifact;
	public static String Validator_Ldap_suffix_module_0_missing_file_artifact;

	// /////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, LdapDomainMessages.class);
	}

}
