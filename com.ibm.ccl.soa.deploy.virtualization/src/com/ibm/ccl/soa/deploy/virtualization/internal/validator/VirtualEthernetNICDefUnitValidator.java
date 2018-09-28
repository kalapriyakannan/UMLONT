/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.net.validator.pattern.attribute.MACAddressSyntacticAttributeValidator;
import com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.validator.IVirtualizationDomainValidators;

/**
 * Validates {@link VirtualEthernetNICDefUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class VirtualEthernetNICDefUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link VirtualEthernetNICDefUnit} instance validator.
	 */
	public VirtualEthernetNICDefUnitValidator() {
		this(VirtualizationPackage.eINSTANCE.getVirtualEthernetNICDefUnit());

	}

	/**
	 * Construct a {@link VirtualEthernetNICDefUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link VirtualEthernetNICDefUnit}.
	 */
	protected VirtualEthernetNICDefUnitValidator(EClass unitType) {
		super(unitType);
		assert VirtualizationPackage.eINSTANCE.getVirtualEthernetNICDefUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
//		addCapabilityTypeConstraint(VirtualizationPackage.eINSTANCE.getVirtualEthernetNICDef(),
//				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		
		addAttributeValidator(new MACAddressSyntacticAttributeValidator(IVirtualizationDomainValidators.MAC_ADDRESS_INVALID_SYNTAX, 
				VirtualizationPackage.eINSTANCE.getVirtualEthernetNICDef_MacAddress()));
		
		// This may not be a safe validation. 
//		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(IVirtualizationDomainValidators.MAC_ADDRESS_NOT_UNIQUE_ON_MACHINE, 
//				VirtualizationPackage.eINSTANCE.getVirtualEthernetNICDef_MacAddress()));
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
