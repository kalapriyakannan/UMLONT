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
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualServerSnapshotUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * Validates {@link VMwareVirtualServerSnapshotUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class VMwareVirtualServerSnapshotUnitValidator extends VirtualServerSnapshotUnitValidator {

	/**
	 * Construct a {@link VMwareVirtualServerSnapshotUnit} instance validator.
	 */
	public VMwareVirtualServerSnapshotUnitValidator() {
		this(VirtualizationPackage.eINSTANCE.getVMwareVirtualServerSnapshotUnit());

	}

	/**
	 * Construct a {@link VMwareVirtualServerSnapshotUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link VMwareVirtualServerSnapshotUnit}.
	 */
	protected VMwareVirtualServerSnapshotUnitValidator(EClass unitType) {
		super(unitType);
		assert VirtualizationPackage.eINSTANCE.getVMwareVirtualServerSnapshotUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(VirtualizationPackage.eINSTANCE.getVMwareVirtualServerSnapshot(),
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
