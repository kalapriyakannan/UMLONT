/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.net;

import org.eclipse.osgi.util.NLS;

/**
 * NLS messages for the {@link NetPackage} domain.
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = NetPlugin.PLUGIN_ID + ".messages"; //$NON-NLS-1$
	
	public static String MACAddressSyntaxInvalid; 

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
