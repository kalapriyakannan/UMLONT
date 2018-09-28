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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUser;

/**
 * Validates an attribute whose value should be a user in the local Windows operating system.
 * <p>
 * Optionally supports the validation of a password attribute as well.
 */
public class WindowsLocalUserPasswordAttributeValidator extends DeployAttributeValidator {

	protected boolean required;

	protected EAttribute passwordAttribute;

	/**
	 * Construct a windows user attribute validator.
	 * 
	 * @param validatorID
	 *           the validator ID.
	 * @param userAttribute
	 *           the attribute which is supposed to contain a windows user.
	 * @param passwordAttribute
	 *           optional attribute which should contain a matching password (may be null).
	 * @param required
	 *           true if the user must be defined.
	 */
	public WindowsLocalUserPasswordAttributeValidator(String validatorID, EAttribute userAttribute,
			EAttribute passwordAttribute, boolean required) {
		super(validatorID, userAttribute);
		assert userAttribute != passwordAttribute;
		this.required = required;
		this.passwordAttribute = passwordAttribute;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.IDeployAttributeValidator#validate(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Object value = getAttributeValue(object);
		if (value == null) {
			if (required) {
				reportAttributeUndefinedStatus(IStatus.ERROR, object, context, reporter);
			}
			return;
		}

		if (!(value instanceof String)) {
			reportAttributeInvalidStatus(IStatus.ERROR, object, value, context, reporter);
			return;
		}
		String userName = (String) value;

		Unit unit = ValidatorUtils.getUnit(object);
		if (unit == null) {
			return;
		}
		Unit osUnit = ValidatorUtils.discoverHostInStackWithCapability(unit, OsPackage.eINSTANCE
				.getWindowsOperatingSystem(), context.getProgressMonitor());
		if (osUnit == null) {
			return;
		}

		List<Unit> userList = ValidatorUtils.discoverHostedWithCapability(osUnit, OsPackage.eINSTANCE
				.getWindowsLocalUser(), false, context.getProgressMonitor());
		if (userList.size() == 0) {
			return;
		}
		WindowsLocalUser matchedUser = null;
		for (Iterator<Unit> iter = userList.iterator(); iter.hasNext();) {
			Unit userUnit = iter.next();
			WindowsLocalUser user = (WindowsLocalUser) ValidatorUtils.getFirstCapability(userUnit,
					OsPackage.eINSTANCE.getWindowsLocalUser());
			if (userName.equals(user.getUserId())) {
				// ok found!
				matchedUser = user;
				break;
			}
		}
		if (matchedUser == null) {
			String unboundMessage = OsDomainMessages.Validator_user_attribute_0_value_1_not_defined_on_local_system;
			Object[] bindings = new Object[] { attribute.getName(), userName };

			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
					unboundMessage, bindings, object, attribute);
			reporter.addStatus(status);
			return;
		}

		if (passwordAttribute == null) {
			return;
		}

		Object password = object.eGet(passwordAttribute);
		if (password == null || password instanceof String && ((String) password).length() == 0) {
			String problemType = ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED;
			String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined;
			Object[] bindings = new Object[] { object, passwordAttribute.getName() };
			IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, getValidatorID(), problemType, unboundMessage, bindings, object,
					passwordAttribute);
			reporter.addStatus(status);
		} else if (!ValidatorUtils.equals(password, matchedUser.getUserPassword())) {
			String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid;
			Object[] bindings = new Object[] { object, passwordAttribute.getName(), password };

			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueSourceStatus(
					IStatus.ERROR, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
					unboundMessage, bindings, object, passwordAttribute, matchedUser,
					OsPackage.eINSTANCE.getUser_UserPassword());
			reporter.addStatus(status);
		}
	}
}
