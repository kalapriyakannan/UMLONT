/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.net.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.net.IpInterfaceUnit;
import com.ibm.ccl.soa.deploy.net.NetPackage;

/**
 * Validates {@link IpInterfaceUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class IpInterfaceUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link IpInterfaceUnit} instance validator.
	 */
	public IpInterfaceUnitValidator() {
		this(NetPackage.eINSTANCE.getIpInterfaceUnit());

	}

	/**
	 * Construct a {@link IpInterfaceUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link IpInterfaceUnit}.
	 */
	protected IpInterfaceUnitValidator(EClass unitType) {
		super(unitType);
		assert NetPackage.eINSTANCE.getIpInterfaceUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(NetPackage.eINSTANCE.getIpInterface(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
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
