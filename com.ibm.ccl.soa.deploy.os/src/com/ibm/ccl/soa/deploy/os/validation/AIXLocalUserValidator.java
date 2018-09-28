/**
 * <copyright>
 * </copyright>
 *
 * $Id: AIXLocalUserValidator.java,v 1.4 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.validation;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.os.AIXAuthMethodType;
import com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.os.AIXLocalUser}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AIXLocalUserValidator {
	boolean validate();

	boolean validateAccountDescription(String value);

	boolean validateAccountDisabled(boolean value);

	boolean validateAccountExpirationTime(String value);

	boolean validateChangePasswordNextLogon(boolean value);

	boolean validateFullName(String value);

	boolean validateHomeDir(String value);

	boolean validateIsAdmin(boolean value);

	boolean validateLoginPermitted(boolean value);

	boolean validateLoginRetries(BigInteger value);

	boolean validateLoginTimes(BigInteger value);

	boolean validateMaxCharRepeats(BigInteger value);

	boolean validateMaxPasswordAgeInWeeks(BigInteger value);

	boolean validateMaxPasswordValidWeeks(BigInteger value);

	boolean validateMinAlphaCharsInPassword(BigInteger value);

	boolean validateMinDiffChars(BigInteger value);

	boolean validateMinOtherCharsInPassword(BigInteger value);

	boolean validateMinPasswordAgeInWeeks(BigInteger value);

	boolean validateMinPasswordLength(BigInteger value);

	boolean validateNotReusableNumberOfPasswords(BigInteger value);

	boolean validatePassReuseNotAllowedInWeeks(BigInteger value);

	boolean validatePasswordChangeWarnTime(BigInteger value);

	boolean validatePasswordNeverExpires(boolean value);

	boolean validatePrimaryAuthMethod(AIXAuthMethodType value);

	boolean validateRemoteLoginIsAllowed(boolean value);

	boolean validateSecondaryAuthMethod(AIXAuthMethodType value);

	boolean validateShell(String value);

	boolean validateSuGroupsAllowed(String value);

	boolean validateSuIsAllowed(boolean value);

	boolean validateTimeLastLogin(String value);

	boolean validateUserCannotChangePassword(boolean value);

	boolean validateUserName(String value);

	boolean validateUserRegisteringMethod(AIXUserRegisteringMethodType value);

	boolean validateUserSid(String value);

	boolean validateUsuccessfulLoginCount(BigInteger value);
}