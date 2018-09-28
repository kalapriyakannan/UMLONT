/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http.validator.capability;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.HttpUser;

/**
 * Validates the {@link HttpUser} capability.
 */
public class HttpUserValidator extends UnitCapabilityValidator {

	public HttpUserValidator() {
		super(HttpPackage.eINSTANCE.getHttpUser());

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IHttpDomainValidators.HTTP_USER_USER_ID_001,
				HttpPackage.eINSTANCE.getHttpUser_UserId(), IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IHttpDomainValidators.HTTP_USER_USER_PASSWORD_001, HttpPackage.eINSTANCE
						.getHttpUser_UserPassword(), IStatus.ERROR));
	}
}
