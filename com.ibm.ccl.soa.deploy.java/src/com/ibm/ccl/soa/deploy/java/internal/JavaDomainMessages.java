/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.internal;

import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.java.JavaPackage;

/**
 * Externalized strings for {@link JavaPackage}.
 */
public class JavaDomainMessages extends NLS {

	/** Points to the messages file. */
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.java.internal.messages"; //$NON-NLS-1$

	static {
		NLS.initializeMessages(BUNDLE_NAME, JavaDomainMessages.class);
	}

	/**
	 * Message used to indicate that a Java classname is not valid.
	 */
	public static String Validator_java_classname_0_invalid;

	/**
	 * Message used to indicate that a Java classname is undefined.
	 */
	public static String Validator_java_classname_undefined;
}
