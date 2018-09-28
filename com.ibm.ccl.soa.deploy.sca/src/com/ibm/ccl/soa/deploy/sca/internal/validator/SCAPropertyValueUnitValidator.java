/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.sca.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * Validates {@link SCAPropertyValueUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class SCAPropertyValueUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link SCAPropertyValueUnit} instance validator.
	 */
	public SCAPropertyValueUnitValidator() {
		this(ScaPackage.eINSTANCE.getSCAPropertyValueUnit());

	}

	/**
	 * Construct a {@link SCAPropertyValueUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link SCAPropertyValueUnit}.
	 */
	protected SCAPropertyValueUnitValidator(EClass unitType) {
		super(unitType);
		assert ScaPackage.eINSTANCE.getSCAPropertyValueUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		//addCapabilityTypeConstraint(ScaPackage.eINSTANCE.getSCAPropertyValue(),
				//CapabilityLinkTypes.ANY_LITERAL, 1, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
	}
}
