/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.AdditiveUnitDomainValidator;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates WAS specific extensions to J2EE domain (typically requirements).
 */
public class WasJ2eeDomainValidator extends AdditiveUnitDomainValidator {

	/**
	 * Construct a {@link OsPackage} domain validator.
	 */
	public WasJ2eeDomainValidator() {
		super(J2eePackage.eINSTANCE);

		addValidator(new WasEarModuleValidator());
		addValidator(new WasWebModuleValidator());
		addValidator(new WasEjbModuleValidator());
		addValidator(new WasJarModuleValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		super.validate(context, reporter);
	}

}
