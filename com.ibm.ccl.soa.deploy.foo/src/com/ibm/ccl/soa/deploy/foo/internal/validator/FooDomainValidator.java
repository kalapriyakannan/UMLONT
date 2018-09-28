/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.foo.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.foo.FooPackage;
import com.ibm.ccl.soa.deploy.foo.internal.validator.matcher.FooDomainMatcher;

/**
 * Validates objects in the {@link FooPackage} deploy domain.
 */
public class FooDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link FooPackage} domain validator.
	 */
	public FooDomainValidator() {
		super(FooPackage.eINSTANCE);
		
		addValidator(new FooBaseSystemUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new FooDomainMatcher();
	}
}
