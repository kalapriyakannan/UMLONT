/**
 * <copyright>
 * </copyright>
 *
 * $Id: WindowsLocalUserValidator.java,v 1.4 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.validation;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WindowsLocalUserValidator {
	boolean validate();

	boolean validateAccountDescription(String value);

	boolean validateAccountDisabled(boolean value);

	boolean validateAccountLocked(boolean value);

	boolean validateChangePasswordNextLogon(boolean value);

	boolean validateEnableRemoteControl(boolean value);

	boolean validateFullName(String value);

	boolean validateHomeFolder(String value);

	boolean validateLogonScript(String value);

	boolean validatePasswordNeverExpires(boolean value);

	boolean validateProfilePath(String value);

	boolean validateUserAccountType(String value);

	boolean validateUserCannotChangePassword(boolean value);

	boolean validateUserSid(String value);

	boolean validateUserSidType(String value);
}
