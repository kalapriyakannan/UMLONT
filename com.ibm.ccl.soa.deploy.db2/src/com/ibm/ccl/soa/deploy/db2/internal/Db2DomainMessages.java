/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the SOA DB2 domain.
 */
public class Db2DomainMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.db2.internal.messages"; //$NON-NLS-1$

	// /////////////////////////////////////////////////////////////////////////////////////

	public static String Validator_DB2_generic_name_0_contains_invalid_character_1;

	public static String Validator_DB2_generic_name_0_has_restricted_prefix_1;

	public static String Validator_DB2_generic_name_has_restricted_name_0;

	public static String Validator_DB2_generic_name_0_max_length_1_exceeded;

	public static String Validator_DB2_generic_name_0_first_character_is_digit;

	public static String Validator_attribute_0_value_1_not_unique_among_units_hosted_by_host_of_unit_2;

	public static String Validator_DB2_instance_unit_missing_link_to_instance_admin_user;

	public static String Validator_DB2_instance_unit_0_hosted_on_os_with_no_admin_user;

	public static String Validator_unit_0_requires_intermediate_host_1_on_2;

	public static String Validator_install_dir_0_invalid_on_operating_system_of_type_1;

	public static String Validator_0_cannot_catalog_1;

	public static String Validator_DB2_nodeName_0_conflicts_with_local_instance_name;

	public static String Resolution_Set_0_JDBC_type_to_1;

	// /////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, Db2DomainMessages.class);
	}

}
