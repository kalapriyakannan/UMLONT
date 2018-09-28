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

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.validator.matcher.IhsDomainMatcher;

/**
 * Validates objects in the {@link IhsPackage} deploy domain.
 */
public class IhsDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link IhsPackage} domain validator.
	 */
	public IhsDomainValidator() {
		super(IhsPackage.eINSTANCE);
		addValidator(new IhsSystemUnitValidator());
		addValidator(new IhsServerUnitValidator());
		addValidator(new IhsUserUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	@Override
	protected DomainMatcher createDomainMatcher() {
		return new IhsDomainMatcher();
	}
}
