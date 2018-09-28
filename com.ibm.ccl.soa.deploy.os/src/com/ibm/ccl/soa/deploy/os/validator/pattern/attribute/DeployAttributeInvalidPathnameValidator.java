/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.pattern.attribute;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validate that an attribute value is a valid pathname for the hosting operating system
 * <p>
 * Creates a {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID} if the value of the attribute is not
 * type-valid
 */
public class DeployAttributeInvalidPathnameValidator extends DeployAttributeValidator {

	private boolean requireRootedPathUnix = false;
	private boolean requireDriveLetterWindows = false;
	private boolean allowLeadingDollarChar = false;
	private boolean allowForwardSlashesWindows = false;

	/** True if the attribute must not be null, false if null is permissible. */
	protected boolean required = false;

	/**
	 * Construct a validator for check for validation of an attribute against a pathname rules for
	 * hosting operating system.
	 * <p>
	 * This constructor sets the {@link #isRequired()} default to <em>false</em>.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the attribute to be validated as a pathname
	 */
	public DeployAttributeInvalidPathnameValidator(String validatorID, EAttribute attribute) {
		this(validatorID, attribute, false);
	}

	/**
	 * Construct a validator for check for validation of an attribute against a pathname rules for
	 * hosting operating system
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param attribute
	 *           the attribute to be validated as a pathname
	 * @param required
	 *           true if the attribute is not permitted to be null or empty.
	 */
	public DeployAttributeInvalidPathnameValidator(String validatorID, EAttribute attribute,
			boolean required) {
		super(validatorID, attribute);
		this.required = required;
	}

	/**
	 * @return true if the attribute is not allowed to be null or empty.
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * Sets the behavior of the validator when the attribute is null or empty.
	 * 
	 * @param required
	 *           true if the validator should issue an error for null or empty values.
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * Creates a {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID} if the value of the attribute is
	 * not a valid pathname for the hosting operating system Parameter object must be an instance of
	 * Capability
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert object instanceof Capability;
		Capability cap = (Capability) object;
		Unit unit = (Unit) cap.getParent();
		validate(unit, cap, context, reporter);
	}

	/**
	 * Validates that the value of the attribute specified in the constructor is a valid pathname for
	 * the hosting operating system.
	 * 
	 * @param unit
	 *           the unit with the provided capability
	 * @param cap
	 *           the provided capability
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	public void validate(Unit unit, Capability cap, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert unit != null;
		assert context != null;
		assert unit.getCapabilities().contains(cap);

		Object value = getAttributeValue(cap);

		String pathValue = null;
		if (value instanceof String) {
			pathValue = (String) value;
		} else if (value != null) {
			pathValue = value.toString();
		}

		if (pathValue == null || pathValue.length() == 0) {
			if (required) {
				reportAttributeUndefinedStatus(IStatus.ERROR, cap, context, reporter);
			}
			return;
		}

		Unit hostingUnit = ValidatorUtils.discoverHostInStack(unit,
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, context.getProgressMonitor());

		if (hostingUnit != null) {
			List<Capability> osCaps = ValidatorUtils.getCapabilities(hostingUnit, OsPackage.eINSTANCE
					.getOperatingSystem());
			if (osCaps.size() > 0) {
				// List l = OperatingSystemType.VALUES;
				// for (Iterator iter=l.iterator(); iter.hasNext(); ) {
				// System.out.println("inext=" + iter.next()); //$NON-NLS-1$
				// }
				String osType = ((OperatingSystem) osCaps.get(0)).getOsType();
				if (osType != null) {
					// TODO Operating system type should be from a list of
					// known valid values
					// Windows, Windows-Cygwin
					if (osType.length() >= 7 && osType.substring(0, 7).equalsIgnoreCase("Windows")) { //$NON-NLS-1$
						if (!windowsValidPath(pathValue)) {
							reporter.addStatus(createObjectAttributePathnameInvalidStatus(cap, attribute,
									hostingUnit, IOsProblemType.PATH_INVALID_ON_WINDOWS_OPERATING_SYSTEM));
							return;
						}
					} else
					// AIX, Solaris
					if (osType.equalsIgnoreCase("AIX") || //$NON-NLS-1$
							osType.equalsIgnoreCase("Solaris")) { //$NON-NLS-1$ 
						if (windowsValidPath(pathValue) || !unixValidPath(pathValue)) {
							reporter.addStatus(createObjectAttributePathnameInvalidStatus(cap, attribute,
									hostingUnit,
									IOsProblemType.PATH_INVALID_ON_AIX_OR_SOLARIS_OPERATING_SYSTEM));
							return;
						}

					} else
					// Linux
					if (osType.equalsIgnoreCase("Linux")) { //$NON-NLS-1$
						if (windowsValidPath(pathValue) || !unixValidPath(pathValue)) {
							reporter.addStatus(createObjectAttributePathnameInvalidStatus(cap, attribute,
									hostingUnit, IOsProblemType.PATH_INVALID_ON_LINUX_OPERATING_SYSTEM));
							return;
						}
					} else {
						// No error on unmatched OS type?
						return;
					}

				} else {
					// Is null osType valid?
					return;
				}
			}
		}
	}

	/**
	 * Creates status for an invalid pathname attribute.
	 * 
	 * @param object
	 *           the object which contains the invalid pathname attribute.
	 * @param attribute
	 *           the pathname attribute that is invalid.
	 * @return the status created.
	 */
	private IDeployAttributeStatus createObjectAttributePathnameInvalidStatus(
			DeployModelObject object, EAttribute attribute, Unit hostingOSUnit, String problemType) {
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, object, attribute);
		status
				.setUnboundMessage(OsDomainMessages.Validator_pathname_0_not_valid_on_hosting_operating_system_1);
		status.setBindings(new String[] { attribute.getName(), hostingOSUnit.getName() });
		status.setProblemType(problemType);
		status.setValidatorID(validatorID);
		return status;
	}

	/**
	 * @return true if the validator should check that a path starts with a drive letter
	 */
	public boolean isRequireDriveLetterWindows() {
		return requireDriveLetterWindows;
	}

	/**
	 * @param requireDriveLetterWindows
	 *           set to true if the validator should check that a path starts with a drive letter
	 */
	public void setRequireDriveLetterWindows(boolean requireDriveLetterWindows) {
		this.requireDriveLetterWindows = requireDriveLetterWindows;
	}

	/**
	 * @return true if the validator should check that a path starts with a '/'
	 */
	public boolean isRequireRootedPathUnix() {
		return requireRootedPathUnix;
	}

	/**
	 * @param requireRootedPathUnix
	 *           set to true if the validator should check that a path starts with a '/'
	 */
	public void setRequireRootedPathUnix(boolean requireRootedPathUnix) {
		this.requireRootedPathUnix = requireRootedPathUnix;
	}

	private boolean windowsValidPath(String pathValue) {
		if (requireDriveLetterWindows) {
			return OsValidatorUtils.isValidWindowsPathWithDriveLetter(pathValue,
					isAllowForwardSlashesWindows(), isAllowLeadingDollarChar());
		} else {
			return OsValidatorUtils.isValidWindowsPath(pathValue, isAllowForwardSlashesWindows());
		}
	}

	private boolean unixValidPath(String pathValue) {
		if (requireRootedPathUnix) {
			return OsValidatorUtils.isValidRootedUnixPath(pathValue, isAllowLeadingDollarChar());
		} else {
			return OsValidatorUtils.isValidUnixPath(pathValue);
		}
	}

	/**
	 * @return Returns true if slashes are allowed in windows paths.
	 */
	public boolean isAllowForwardSlashesWindows() {
		return allowForwardSlashesWindows;
	}

	/**
	 * @param allowForwardSlashesWindows
	 *           controls whether slashes are allowed in windows paths.
	 */
	public void setAllowForwardSlashesWindows(boolean allowForwardSlashesWindows) {
		this.allowForwardSlashesWindows = allowForwardSlashesWindows;
	}

	/**
	 * @return Returns true if leading $ character allows as substitute for drive letter or leading
	 *         slash
	 */
	public boolean isAllowLeadingDollarChar() {
		return allowLeadingDollarChar;
	}

	/**
	 * @param allowLeadingDollarChar
	 *           set to true to allow leading $ character as substitute for drive letter or rooted
	 *           path
	 */
	public void setAllowLeadingDollarChar(boolean allowLeadingDollarChar) {
		this.allowLeadingDollarChar = allowLeadingDollarChar;
	}
}
