/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the SOA DB2 domain.
 */
public class OsDomainInternalMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.os.internal.messages"; //$NON-NLS-1$

	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	public static String Validator_port_0_attribute_1_value_2_conflicts_with_another_port;

	/**
	 * 
	 */
	public static String Validator_osType_0_invalid_for_Windows_Operating_System;

	// /////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, OsDomainInternalMessages.class);
	}

}
