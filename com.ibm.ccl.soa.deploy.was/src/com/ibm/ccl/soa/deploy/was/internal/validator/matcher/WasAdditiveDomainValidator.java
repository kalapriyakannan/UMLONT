/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.AdditiveUnitDomainValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * Validates WAS specific extensions to J2EE domain (typically requirements).
 */
public class WasAdditiveDomainValidator extends AdditiveUnitDomainValidator {

	/**
	 * Construct a WAS specific JEEE domain validator.
	 */
	public WasAdditiveDomainValidator() {
		super(WasPackage.eINSTANCE);
	}	
	
	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected DomainMatcher createDomainMatcher() {
		return new WasAdditiveDomainMatcher();
	}

}
