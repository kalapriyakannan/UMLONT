/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the SOA DB2 domain.
 */
public class OsDomainMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.os.messages"; //$NON-NLS-1$

	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	public static String Validator_pathname_0_not_valid_on_hosting_operating_system_1;

	/**
	 * 
	 */
	public static String Slashes_to_backslashes_resolution_exception;

	/**
	 * 
	 */
	public static String Slashes_to_backslashes_resolution_attribute_0_from_1_to_2;

	public static String Validator_port_consumer_missing_hosted_port;

	public static String Validator_port_consumer_too_many_ports;

	public static String Resolution_add_port_configuration;

	public static String Validator_user_attribute_0_value_1_not_defined_on_local_system;

	public static String Validator_operating_system_0_not_single_hosted_by_host;

	public static String ncc_context_operating_systems;

	// /////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, OsDomainMessages.class);
	}

}
