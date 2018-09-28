/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Implemented by validators of {@link UnitLink}
 * <p>
 * Not intended to be directly implemented. Use {@link UnitLinkValidator}.
 * 
 * @see UnitValidator#addUnitLinkValidator(IUnitLinkValidator)
 */
public interface IUnitLinkValidator {

	/**
	 * Returns true if the validator applies to the unit link.
	 * 
	 * @param link
	 *           a unit link
	 * @param context
	 *           the deploy validation context.
	 * @return true if the {@link #validate(UnitLink, IDeployValidationContext, IDeployReporter)}
	 *         method can be invoked.
	 */
	public boolean appliesTo(UnitLink link, IDeployValidationContext context);

	/**
	 * Returns the identity of the validator.
	 * 
	 * @return the validator identity.
	 */
	public String getValidatorID();

	/**
	 * Validates the unit link. x
	 * 
	 * @param link
	 *           the unit link to be validated.
	 * @param context
	 *           the topology-level validation context (used or indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	public void validate(UnitLink link, IDeployValidationContext context, IDeployReporter reporter);
}
