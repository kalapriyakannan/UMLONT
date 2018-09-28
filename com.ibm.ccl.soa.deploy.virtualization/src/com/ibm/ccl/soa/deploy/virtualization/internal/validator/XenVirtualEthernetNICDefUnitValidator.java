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

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualEthernetNICDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * Validates {@link XenVirtualEthernetNICDefUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class XenVirtualEthernetNICDefUnitValidator extends VirtualEthernetNICDefUnitValidator {

	/**
	 * Construct a {@link XenVirtualEthernetNICDefUnit} instance validator.
	 */
	public XenVirtualEthernetNICDefUnitValidator() {
		this(VirtualizationPackage.eINSTANCE.getXenVirtualEthernetNICDefUnit());

	}

	/**
	 * Construct a {@link XenVirtualEthernetNICDefUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link XenVirtualEthernetNICDefUnit}.
	 */
	protected XenVirtualEthernetNICDefUnitValidator(EClass unitType) {
		super(unitType);
		assert VirtualizationPackage.eINSTANCE.getXenVirtualEthernetNICDefUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
//		addCapabilityTypeConstraint(VirtualizationPackage.eINSTANCE.getXenVirtualEthernetNICDef(),
//				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
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
