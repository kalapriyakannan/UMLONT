/**
 * <copyright>
 * </copyright>
 *
 * $Id: SoftwareInstallValidator.java,v 1.2 2008/02/08 21:22:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.validation;


/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SoftwareInstallValidator {
	boolean validate();

	boolean validateExecutableName(String value);
	boolean validateInstallDate(String value);

	boolean validateInstalledDate(String value);
	boolean validateInstalledLocation(String value);
	boolean validateProductId(String value);
	boolean validateProductName(String value);
	boolean validatePublisher(String value);
}