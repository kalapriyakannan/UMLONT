/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.capability;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Implemented by validators of {@link Capability} subtypes that are independent of the unit.
 * <p>
 * Not intended to be directly implemented. Use {@link UnitCapabilityValidator}.
 * 
 * @see UnitValidator#addCapabilityValidator(IUnitCapabilityValidator)
 */
public interface IUnitCapabilityValidator {

	/**
	 * @return returns tha type of capability processed by this validator.
	 */
	public EClass getCapabilityType();

	/**
	 * Checks if the validator applies to the capability.
	 * 
	 * @param capability
	 *           the provided capability to be validated of type {@link #getCapabilityType()}.
	 * @param unit
	 *           the unit providing the capability.
	 * @param context
	 *           the validation context.
	 * 
	 * @return true if the validator applies to the capability.
	 */
	public boolean appliesTo(Capability capability, Unit unit, IDeployValidationContext context);

	/**
	 * Validates a capability provided by the unit.
	 * 
	 * @param capability
	 *           the provided capability to be validated of type {@link #getCapabilityType()}.
	 * @param unit
	 *           the unit providing the capability.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	public void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter);
}
