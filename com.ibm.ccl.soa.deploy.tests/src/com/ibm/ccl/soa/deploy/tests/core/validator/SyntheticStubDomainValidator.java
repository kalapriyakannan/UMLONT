/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.core.validator;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;

/**
 * Stub validator for the test domain (prevents errors).
 */
public class SyntheticStubDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a stub domain validator.
	 */
	public SyntheticStubDomainValidator() {
		super(CorePackage.eINSTANCE);
	}
}
