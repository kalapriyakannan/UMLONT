/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInGroupValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link WasNodeGroupUnit}
 */
public class WasNodeGroupUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasNodeGroupUnit();
	}

	/**
	 * 
	 */
	public WasNodeGroupUnitValidator() {
		super(WasPackage.eINSTANCE.getWasNodeGroupUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasNodeGroup(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasCellUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNodeUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_NODEGROUP_UNIT_NODEGROUP_NAME_EMPTY_001,
				WasPackage.Literals.WAS_NODE_GROUP__NODE_GROUP_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInGroupValidator(
				IWasValidatorID.WAS_NODEGROUP_NODEGROUP_NAME_UNIQUE_001,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT,
				WasPackage.Literals.WAS_NODE_GROUP__NODE_GROUP_NAME, WasPackage.Literals.WAS_CELL_UNIT));

	}

	/*
	 * validate all nodeUnits inside this NodeGroupUnit are inside the same cell with it
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		// MK 8/8/2007: made the following changes
		//  (a) replaced direct calls to TopologyDiscovererService with utilities
		//  (b) used utility methods to filter out conceptual units when concrete are present
		//  (c) removed need to find cell capability; the unit suffices

		WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) unit;
		Topology top = unit.getEditTopology();
		if (top == null) {
			return;
		}

		IProgressMonitor monitor = context.getProgressMonitor();

		//only in one cell, nodes in it are in same cell
		List<Unit> cellList = ValidatorUtils.discoverGroupsByUnitType(nodeGroupUnit,
				WasPackage.Literals.WAS_CELL_UNIT, top, monitor);

		int numCells = ValidatorUtils.ncFilteredSize(cellList);

		if (numCells > 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createWasNodeGroupUnitInMoreThanOneWasCellUnitStatus(nodeGroupUnit, cellList);
			reporter.addStatus(message);
			return;
		}

		if (numCells > 0) {
//			List<Unit> nodes = ValidatorUtils.discoverMembers(nodeGroupUnit,
//					WasPackage.Literals.WAS_NODE_UNIT, monitor);
			// MK 8/9/2007: problem that discovery no longer does _immediate_ members
			List<Unit> nodes = ValidatorUtils.getImmediateMembers(nodeGroupUnit);
			for (Unit u : nodes) {
				if (!WasPackage.Literals.WAS_NODE_UNIT.isSuperTypeOf(u.getEObject().eClass())) {
					continue;
				}
				WasNodeUnit nodeUnit = (WasNodeUnit) u;
				Unit nodeCellUnit = ValidatorUtils.discoverGroupByUnitType(nodeUnit,
						WasPackage.Literals.WAS_CELL_UNIT, monitor);
				if (!cellList.contains(nodeCellUnit)) {
					IDeployStatus message = DeployWasMessageFactory
							.createWasInvalidMemberUnitInGroupUnitStatus(
									nodeUnit,
									nodeGroupUnit,
									IWasValidatorID.WAS_VALIDAT_NODE_NODEGROUP_IN_SAME_CELL,
									DeployNLS
											.bind(
													WasDomainMessages.Validator_WasNodeUnit_0_WasNodeGroupUnit_1_Not_in_same_Cell,
													nodeUnit, nodeGroupUnit));
					reporter.addStatus(message);
				}
			}
		}
	}

}
