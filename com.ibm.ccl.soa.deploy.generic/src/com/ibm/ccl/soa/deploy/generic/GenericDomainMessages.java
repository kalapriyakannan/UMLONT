/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.generic;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the SOA DB2 domain.
 */
public class GenericDomainMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.generic.messages"; //$NON-NLS-1$

	// /////////////////////////////////////////////////////////////////////////////////////

	// Note: script validator messages moved to the deploy operation domain.

	static {
		NLS.initializeMessages(BUNDLE_NAME, GenericDomainMessages.class);
	}

}
