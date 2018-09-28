/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;

/**
 * Validates {@link UserGroupUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class PortConfigUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link PortConfigUnit} instance validator.
	 */
	public PortConfigUnitValidator() {
		this(OsPackage.eINSTANCE.getPortConfigUnit());

	}

	/**
	 * Construct a {@link PortConfigUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link PortConfigUnit}.
	 */
	protected PortConfigUnitValidator(EClass unitType) {
		super(unitType);
		assert OsPackage.eINSTANCE.getPortConfigUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		// The second constraint is that unit must be hosted.
		//
		addCapabilityTypeConstraint(OsPackage.eINSTANCE.getPort(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, Integer.MAX_VALUE);
		addRequirementTypeConstraint(OsPackage.eINSTANCE.getPortConsumer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IOsDomainValidators.PORT_CONFIG_UNIT_PORT_NAME_NOT_EMPTY_001, OsPackage.eINSTANCE
						.getPort_PortName(), IStatus.ERROR));
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IOsDomainValidators.PORT_CONFIG_UNIT_PORT_NAME_UNIQUE_IN_HOST_001, OsPackage.eINSTANCE
						.getPort_PortName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
		OperatingSystemUnit hostingOSUnit = (OperatingSystemUnit) ValidatorUtils.discoverHostInStack(
				unit, OsPackage.Literals.OPERATING_SYSTEM_UNIT, context.getProgressMonitor());
		if (hostingOSUnit != null && hostingOSUnit.getTopology() != unit.getTopology()) {
			OperatingSystemUnitValidator.validateNoPortConflicts(hostingOSUnit, unit.getTopology(),
					(PortConfigUnit) unit, context, reporter);
		}
	}
}
