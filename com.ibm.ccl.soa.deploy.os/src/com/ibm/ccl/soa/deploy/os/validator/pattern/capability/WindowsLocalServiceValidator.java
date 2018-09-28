/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.pattern.capability;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.WindowsLocalUserPasswordAttributeValidator;

/**
 * Validates instances of the {@link WindowsLocalService} capability.
 */
public class WindowsLocalServiceValidator extends UnitCapabilityValidator {

	/**
	 * Construct a validator for the {@link WindowsLocalService} capability.
	 */
	public WindowsLocalServiceValidator() {
		this(OsPackage.eINSTANCE.getWindowsLocalService());
	}

	/**
	 * Construct a validator for a subtype of the {@link WindowsLocalService} capability.
	 * 
	 * @param capType
	 *           a subtype of the {@link WindowsLocalService} capability.
	 */
	protected WindowsLocalServiceValidator(EClass capType) {
		super(capType);
		assert OsPackage.eINSTANCE.getWindowsLocalService().isSuperTypeOf(capType);

		addAttributeValidator(new DeployAttributeInvalidPathnameValidator(
				IOsDomainValidators.WINDOWS_LOCAL_SERVICE_NAME_001, OsPackage.eINSTANCE
						.getWindowsLocalService_ServiceName(), true));

		addAttributeValidator(new WindowsLocalUserPasswordAttributeValidator(
				IOsDomainValidators.WINDOWS_LOCAL_SERVICE_USER_AND_PASSWORD_LOCAL_001,
				OsPackage.eINSTANCE.getWindowsLocalService_ServiceAccount(), OsPackage.eINSTANCE
						.getWindowsLocalService_ServiceAccountPassword(), true) {

			/*
			 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator#appliesTo(com.ibm.ccl.soa.deploy.core.DeployModelObject,
			 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext)
			 */
			@Override
			public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
				if (object instanceof WindowsLocalService) {
					WindowsLocalService service = (WindowsLocalService) object;
					if (service.isLogOnAsSystem()) {
						// no need to validate
						return false;
					}
				}
				return super.appliesTo(object, context);
			}
		});
	}
}
