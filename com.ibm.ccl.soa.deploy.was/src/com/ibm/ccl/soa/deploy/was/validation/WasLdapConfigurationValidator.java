/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validation;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.was.LDAPDirectoryType;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WasLdapConfigurationValidator {
	boolean validate();

	boolean validateBaseDN(String value);

	boolean validateBindDN(String value);

	boolean validateBindPassword(String value);

	boolean validateIgnoreCase(boolean value);

	boolean validateLdapHostname(String value);

	boolean validateLdapPort(BigInteger value);

	boolean validateLimit(String value);

	boolean validateMonitorInterval(String value);

	boolean validateRealm(String value);

	boolean validateReuseConnection(boolean value);

	boolean validateSearchTimeout(String value);

	boolean validateServerId(String value);

	boolean validateServerPassword(String value);

	boolean validateSslConfig(String value);

	boolean validateSslEnabled(boolean value);

	boolean validateType(LDAPDirectoryType value);
}
