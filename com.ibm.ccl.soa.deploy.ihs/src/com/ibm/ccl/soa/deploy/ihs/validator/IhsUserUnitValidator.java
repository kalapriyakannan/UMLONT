/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.validator;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.validator.capability.HttpUserValidator;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsUserUnit;

/**
 * Validates {@link IhsUserUnit}.
 */
public class IhsUserUnitValidator extends UnitValidator {

	public IhsUserUnitValidator() {
		super(IhsPackage.eINSTANCE.getIhsUserUnit());

		addCapabilityValidator(new HttpUserValidator());

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IIhsDomainValidators.IHS_SYSTEM_INSTALL_LOCATION_001, HttpPackage.eINSTANCE
						.getHttpUser_UserId()));
	}
}
