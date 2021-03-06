/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validation;

import com.ibm.ccl.soa.deploy.was.IIOPSecurityProtocols;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.was.WasSecurity}. This doesn't
 * really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WasSecurityValidator {
	boolean validate();

	boolean validateActiveAuthMechanism(String value);

	boolean validateActiveProtocol(IIOPSecurityProtocols value);

	boolean validateActiveUserRegistry(WasUserRegistryTypes value);

	boolean validateActiveUserRegistry(String value);

	boolean validateAllowAllPermissionForApplication(boolean value);

	boolean validateCacheTimeout(String value);

	boolean validateEnforceFineGrainedJCASecurity(boolean value);

	boolean validateEnforceJava2SecRuntimeFiletering(boolean value);

	boolean validateEnforceJava2Security(boolean value);

	boolean validateGlobalSecurityEnabled(boolean value);

	boolean validateIssuePermissionWarning(boolean value);

	boolean validateUseDomainQualifiedNames(boolean value);
}
