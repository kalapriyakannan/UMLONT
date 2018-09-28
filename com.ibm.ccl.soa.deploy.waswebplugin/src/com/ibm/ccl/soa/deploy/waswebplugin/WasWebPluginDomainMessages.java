/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the IBM HTTP Server domain.
 */
public class WasWebPluginDomainMessages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.waswebplugin.messages"; //$NON-NLS-1$

	public static String WAS_plugin_module_0_redirects_to_multiple_web_servers;

	public static String Validator_IHS_not_configured_for_WAS_plugin;

	public static String Validator_IHS_admin_plugin_0_requires_user_for_remote_access;

	public static String Resolution_configure_ihs_server_for_was_plugin;

	public static String Validator_Implement_WasWebServerToIhsPluginConstraint;

	public static String Validator_Expected_IHS_Was_Plugin_Not_Found;

	static {
		NLS.initializeMessages(BUNDLE_NAME, WasWebPluginDomainMessages.class);
	}

	/**
	 * Prevent instantiation.
	 */
	private WasWebPluginDomainMessages() {
	}
}
