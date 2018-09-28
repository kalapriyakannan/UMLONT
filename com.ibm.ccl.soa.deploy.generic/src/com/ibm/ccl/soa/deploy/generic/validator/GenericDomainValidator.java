/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.generic.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.generic.GenericPackage;
import com.ibm.ccl.soa.deploy.generic.validator.matcher.GenericDomainMatcher;

/**
 * Validates objects in the {@link GenericPackage} deploy domain.
 */
public class GenericDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link GenericPackage} domain validator.
	 */
	public GenericDomainValidator() {
		super(GenericPackage.eINSTANCE);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new GenericDomainMatcher();
	}
}
