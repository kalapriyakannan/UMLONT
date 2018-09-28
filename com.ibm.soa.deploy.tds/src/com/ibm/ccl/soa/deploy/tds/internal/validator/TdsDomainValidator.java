/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tds.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.tds.TdsPackage;
import com.ibm.ccl.soa.deploy.tds.internal.validator.matcher.TdsDomainMatcher;

/**
 * Validates objects in the {@link TdsPackage} deploy domain.
 */
public class TdsDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link TdsPackage} domain validator.
	 */
	public TdsDomainValidator() {
		super(TdsPackage.eINSTANCE);
		
		addValidator(new TdsBaseSystemUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new TdsDomainMatcher();
	}
}
