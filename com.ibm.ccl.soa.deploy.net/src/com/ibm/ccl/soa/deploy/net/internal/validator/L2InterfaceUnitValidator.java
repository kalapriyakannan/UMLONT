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
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.net.L2InterfaceUnit;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.net.validator.INetDomainValidators;
import com.ibm.ccl.soa.deploy.net.validator.pattern.attribute.MACAddressSyntacticAttributeValidator;

/**
 * Validates {@link L2InterfaceUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class L2InterfaceUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link L2InterfaceUnit} instance validator.
	 */
	public L2InterfaceUnitValidator() {
		this(NetPackage.eINSTANCE.getL2InterfaceUnit());

	}

	/**
	 * Construct a {@link L2InterfaceUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link L2InterfaceUnit}.
	 */
	protected L2InterfaceUnitValidator(EClass unitType) {
		super(unitType);
		assert NetPackage.eINSTANCE.getL2InterfaceUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(NetPackage.eINSTANCE.getL2Interface(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		
		addAttributeValidator(new MACAddressSyntacticAttributeValidator(INetDomainValidators.MAC_ADDRESS_INVALID_SYNTAX, 
				NetPackage.eINSTANCE.getL2Interface_HwAddress()));		
	
		// This may not be a safe validation. 
//		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(INetDomainValidators.MAC_ADDRESS_NOT_UNIQUE_ON_MACHINE, 
//				NetPackage.eINSTANCE.getL2Interface_HwAddress()));
		
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
