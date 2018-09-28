/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Implemented by validators of a deploy model object attribute.
 * <p>
 * Not intended to be directly implemented. Use {@link DeployAttributeValidator}.
 * 
 * @see UnitValidator#addAttributeValidator(IDeployAttributeValidator)
 */
public interface IDeployAttributeValidator {

	/**
	 * Checks if the deploy model object has the attribute that is checked by this validator.
	 * 
	 * @param object
	 *           an object (non-null).
	 * @param context
	 *           the deploy validation context.
	 * @return true if the
	 *         {@link #validate(DeployModelObject, IDeployValidationContext, IDeployReporter)} can be
	 *         invoked.
	 */
	public boolean appliesTo(DeployModelObject object, IDeployValidationContext context);

	/**
	 * Returns the identity of the validator.
	 * 
	 * @return the validator identity.
	 */
	public String getValidatorID();

	/**
	 * Returns the type in which the attribute is defined.
	 * 
	 * @return the attribute type, a subtype of {@link DeployModelObject}.
	 */
	public EClass getAttributeContainer();

	/**
	 * Return the name of the attribute that is validated.
	 * 
	 * @return the name of the attribute that is validated.
	 */
	public String getAttributeName();

	/**
	 * Validates the attribute on the specified deploy model object.
	 * 
	 * @param object
	 *           an instance of {@link #getAttributeContainer()} whose attribute
	 *           {@link #getAttributeName()} will be validated.
	 * @param context
	 *           the topology-level validation context (used or indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter);
}
