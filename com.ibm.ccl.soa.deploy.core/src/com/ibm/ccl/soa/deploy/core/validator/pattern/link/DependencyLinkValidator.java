/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Implements the {@link IDependencyLinkValidator} interface.
 * 
 * @see UnitValidator#addDependencyLinkValidator(IDependencyLinkValidator)
 */
public abstract class DependencyLinkValidator implements IDependencyLinkValidator {

	protected String validatorID;

	/**
	 * Construct a dependency link validator.
	 * 
	 * @param validatorID
	 *           the identifier of the validator (should be unique per plug-in).
	 */
	public DependencyLinkValidator(String validatorID) {
		this.validatorID = validatorID;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDependencyLinkValidator#getValidatorID()
	 */
	public String getValidatorID() {
		return validatorID;
	}
}
