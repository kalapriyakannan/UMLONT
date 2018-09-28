/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds.validation;


/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TdsBaseSystemValidator {
	boolean validate();

	boolean validateInstallLocation(String value);
	boolean validateVersion(String value);
	boolean validateWonderful(String value);
}