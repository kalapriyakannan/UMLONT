/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server.internal.validator.matcher;

import org.eclipse.osgi.util.NLS;

/**
 * @since 3.2
 * 
 */
public class ServerMatcherMessages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.server.internal.validator.matcher.messages"; //$NON-NLS-1$

	public static String AnotherOperatingSystemAlreadyHostedOnServer;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ServerMatcherMessages.class);
	}

	private ServerMatcherMessages() {
	}
}
