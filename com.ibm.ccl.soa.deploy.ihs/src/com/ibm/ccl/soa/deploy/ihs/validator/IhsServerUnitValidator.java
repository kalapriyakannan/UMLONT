/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.validator;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;
import com.ibm.ccl.soa.deploy.os.validator.pattern.capability.PortConsumerValidator;
import com.ibm.ccl.soa.deploy.os.validator.pattern.capability.WindowsLocalServiceValidator;

/**
 * 
 */
public class IhsServerUnitValidator extends UnitValidator {

	public IhsServerUnitValidator() {
		super(IhsPackage.eINSTANCE.getIhsServerUnit());
		init();
	}

	// |WindowsIhsServerUnit|Must host at least one TCP port||

	// |IhsSystemUnit|Warning if does not host two server units||

	// |IhsWasModule|configFile != null||

	// |IhsWasAdminModule|unit must host at least one configuration unit with
	// capability ApacheUser||

	// |IhsWasAdminModule|userFile != null||

	/**
	 * Initialize the declarative validators.
	 */
	protected void init() {
		addCapabilityValidator(new PortConsumerValidator(1, 1));
		addCapabilityValidator(new WindowsLocalServiceValidator());

		// IhsSystem#configFile should be defined and valid
		// 
		addAttributeValidator(new DeployAttributeInvalidPathnameValidator(
				IIhsDomainValidators.IHS_SYSTEM_INSTALL_LOCATION_001, IhsPackage.eINSTANCE
						.getIhsServer_ConfigFile(), true));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IIhsDomainValidators.IHS_SERVER_WINDOWS_SERVICE_SERVICE_ACCOUNT_FROM_USER_001,
				OsPackage.Literals.WINDOWS_LOCAL_SERVICE,
				OsPackage.Literals.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT,
				OsPackage.Literals.WINDOWS_LOCAL_USER, OsPackage.Literals.USER__USER_ID));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IIhsDomainValidators.IHS_SERVER_WINDOWS_SERVICE_SERVICE_ACCOUNT_PASSWORD_FROM_USER_001,
				OsPackage.Literals.WINDOWS_LOCAL_SERVICE,
				OsPackage.Literals.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD,
				OsPackage.Literals.WINDOWS_LOCAL_USER, OsPackage.Literals.USER__USER_PASSWORD));
	}
}
