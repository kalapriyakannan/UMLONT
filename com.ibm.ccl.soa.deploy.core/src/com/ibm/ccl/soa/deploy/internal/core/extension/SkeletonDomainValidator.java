/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;

/**
 * Provides a default implementation of {@link DomainValidator} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.domains</b>.
 * 
 * @since 1.0
 * @see DomainValidator
 * 
 */
public class SkeletonDomainValidator extends DomainValidator {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonDomainValidator INSTANCE = new SkeletonDomainValidator();

	private SkeletonDomainValidator() {
		setDomainID(SkeletonDomainValidator.class.getName());
	}

	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		// If a CoreDomainMatcher is returned, it can't be overridden. 
//		return SkeletonDomainMatcher.INSTANCE;
		return new CoreDomainMatcher(); 
	}

}
