/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.internal.validator.matcher.J2eeDomainMatcher;
import com.ibm.ccl.soa.deploy.j2ee.validator.J2CAuthenticationUnitValidator;

/**
 * Validates objects in the J2EE deploy domain.
 * 
 * @see J2eePackage
 * @see EjbModuleValidator
 * @see WebModuleValidator
 * @see EarModuleValidator
 * @see J2CAuthenticationUnitValidator
 * @see J2eeDomainMatcher
 */
public class J2EEDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a validator for the J2EE domain.
	 * 
	 * @see J2eePackage
	 */
	public J2EEDomainValidator() {
		super(J2eePackage.eINSTANCE);
		addValidator(new EjbModuleValidator());
		addValidator(new WebModuleValidator());
		addValidator(new EarModuleValidator());
		addValidator(new J2eeModuleValidator(J2eePackage.Literals.JAR_MODULE));
		addValidator(new J2eeModuleValidator(J2eePackage.Literals.APP_CLIENT));
		addValidator(new J2eeModuleValidator(J2eePackage.Literals.JCA_MODULE));
		addValidator(new J2CAuthenticationUnitValidator());
		// This validator is just for extending, since there is no defined J2EEDatasourceUnit
//		addValidator(new J2EEDatasourceValidator());		
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitDomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new J2eeDomainMatcher();
	}
}
