/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ldap.ui.Messages";//$NON-NLS-1$

	/**
	 * LDAP Server
	 */
	public static String LDAP_Server;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
