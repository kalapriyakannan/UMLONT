/**
 * <copyright>
 * </copyright>
 *
 * $Id: AIXOperatingSystemValidator.java,v 1.5 2008/02/02 05:54:52 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.validation;

import com.ibm.ccl.soa.deploy.os.AIXDesktopType;
import com.ibm.ccl.soa.deploy.os.KernelWidthType;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AIXOperatingSystemValidator {
	boolean validate();

	boolean validateDesktop(AIXDesktopType value);

	boolean validateInstallDate(String value);

	boolean validateKernel(KernelWidthType value);

	boolean validateLastBootUpTime(String value);

	boolean validateOwner(String value);

	boolean validateTCB(boolean value);

	boolean validateTimeZone(String value);
}
