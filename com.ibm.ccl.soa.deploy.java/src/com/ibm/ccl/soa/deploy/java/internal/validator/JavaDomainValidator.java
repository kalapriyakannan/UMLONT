/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.internal.validator.matcher.JavaDomainMatcher;

/**
 * Validates objects in the Java deploy domain.
 */
public class JavaDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a Java domain validator.
	 */
	public JavaDomainValidator() {
		super(JavaPackage.eINSTANCE);
		// No-Java domain specific validations performed
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new JavaDomainMatcher();
	}
}
