/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the IBM HTTP Server domain.
 */
public class IhsDomainMessages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ihs.messages"; //$NON-NLS-1$

	public static String Validator_IHS_not_configured_for_WAS_plugin;

	public static String Resolution_configure_ihs_server_for_was_plugin;

	static {
		NLS.initializeMessages(BUNDLE_NAME, IhsDomainMessages.class);
	}

	/**
	 * Prevent instantiation.
	 */
	private IhsDomainMessages() {
	}
}
