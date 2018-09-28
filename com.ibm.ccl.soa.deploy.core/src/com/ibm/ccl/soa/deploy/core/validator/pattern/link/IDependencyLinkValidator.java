/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Implemented by validators of {@link DependencyLink}
 * <p>
 * Not intended to be directly implemented. Use {@link DependencyLinkValidator}.
 * 
 * @see UnitValidator#addDependencyLinkValidator(IDependencyLinkValidator)
 */
public interface IDependencyLinkValidator {

	/**
	 * Returns true if the validator applies to the dependency link.
	 * 
	 * @param req
	 *           the link source requirement.
	 * @param cap
	 *           the link target capability.
	 * @param link
	 *           a dependency link (may be null if discovered).
	 * @param context
	 *           the deploy validation context.
	 * @return true if the
	 *         {@link #validate(DependencyLink, IDeployValidationContext, IDeployReporter)} method
	 *         can be invoked.
	 */
	public boolean appliesTo(Requirement req, Capability cap, DependencyLink link,
			IDeployValidationContext context);

	/**
	 * Returns the identity of the validator.
	 * 
	 * @return the validator identity.
	 */
	public String getValidatorID();

	/**
	 * Validates the dependency link.
	 * <p>
	 * Discovered dependency links that not instantiated. The link argument may be null!
	 * 
	 * @param source
	 *           the dependency link source.
	 * @param target
	 *           the dependency link target.
	 * @param link
	 *           the dependency link to be validated (may be null if discovered).
	 * @param context
	 *           the topology-level validation context (used or indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	public void validate(Requirement source, Capability target, DependencyLink link,
			IDeployValidationContext context, IDeployReporter reporter);
}
