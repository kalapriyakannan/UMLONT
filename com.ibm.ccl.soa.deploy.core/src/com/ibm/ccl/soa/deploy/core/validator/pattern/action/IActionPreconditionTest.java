/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * Implemented by testers of action preconditions.
 * <p>
 * Not intended to be directly implemented. Use {@link ActionPreconditionTest}.
 * 
 * @see SignatureBasedActionDomainValidator#addActionPreconditonTest(IActionPreconditionTest)
 */
public interface IActionPreconditionTest {

	/**
	 * @return tester id
	 */
	public String getId();

	/**
	 * @return returns the type of units processed by this action precondition tester.
	 */
	public ISignature getSignature();

	/**
	 * Checks if the validator applies to the unit.
	 * 
	 * @param parameters
	 *           the provided parameters to be tested
	 * 
	 * @return true if the action precondition test applies to the unit.
	 */
	public boolean appliesTo(List<DeployModelObject> parameters);

	/**
	 * Checks if the validator applies to the signature.
	 * 
	 * @param signature
	 *           the provided signature to be tested
	 * 
	 * @return true if the action precondition test applies to the unit.
	 */
	public boolean appliesTo(ISignature signature);

	/**
	 * Tests the action preconditions for a unit.
	 * 
	 * @param parameters
	 *           the parameters being tested.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter);
}
