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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Class to validate a {@link WasCellUnit} when the unit is configured with was (major) version 6
 * and as a standalone cell (ie, not distributed).
 */
public class Was6StandaloneCellUnitValidator extends WasGenericCellUnitValidator {

	/**
	 * Constructor.
	 */
	public Was6StandaloneCellUnitValidator() {
		super();

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNodeGroupUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);
		// BA 2006/09/28 - uncommented this to allow requirement in was6StandaloneCell.template
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSIBusUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 0, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		if (null == unit) {
			return;
		}

		if (!WasPackage.Literals.WAS_CELL_UNIT.isSuperTypeOf(unit.getEObject().eClass())) {
			return;
		}
//		assert unit instanceof WasCellUnit;
		WasCellUnit wasCellUnit = (WasCellUnit) unit;

		WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(unit,
				WasPackage.Literals.WAS_CELL);
		if (wasCellCap == null) {
			return;
		}

		if (wasCellCap.isIsDistributed()) {
			return;
		}

		String wasCellVersion = wasCellCap.getWasVersion();
		if (wasCellVersion == null || wasCellVersion.length() <= 0) {
			return;
		}

		if (!wasCellVersion.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			return;
		}

		//Core Unit validation
		super.validateUnit(unit, context, reporter);
		checkNodeMember(wasCellUnit, wasCellCap, context, reporter);
		checkNodeGroupMembers(wasCellUnit, context, reporter);
	}

	/**
	 * check relationship with nodegroup Unit members
	 * 
	 * @param wasCellUnit
	 * @param top
	 * @param reporter
	 */
	private void checkNodeGroupMembers(WasCellUnit wasCellUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		List<Unit> nodeGroupL = ValidatorUtils.discoverMembers(wasCellUnit,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());

		int size = ValidatorUtils.ncFilteredSize(nodeGroupL);

		if (size == 1) {
			WasNodeGroup wasNGCap = (WasNodeGroup) ValidatorUtils.getFirstCapability(
					nodeGroupL.get(0), WasPackage.Literals.WAS_NODE_GROUP);
			if (wasNGCap == null || wasNGCap.isIsDefaultType()) {
				return;
			}

			IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
					IWasValidatorID.WAS_NODEGROUP_ISDEFAULTTYPE_001, wasNGCap, WasPackage.eINSTANCE
							.getWasNodeGroup_IsDefaultType(), Boolean.TRUE);
			reporter.addStatus(message);
			return;
		}

		if (size < 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createMissingDefaultNodeGroupINVersion6CellUnitStatus(wasCellUnit);
			reporter.addStatus(message);
			return;
		}

		// size is greater than 1
		IDeployStatus message = DeployWasMessageFactory
				.createWasListOFInvalidMemberUnitInGroupUnitStatus(
						Collections.emptyList(), // this parameter does not seem to be used in a meaningful way
						wasCellUnit,
						IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODEGROUP_MEMBER_CARDINALITY_001,
						DeployNLS
								.bind(
										WasDomainMessages.Validator_Was_6_StandAloneCellUnit_0_With_Invalid_NodeGroup_Member_Cardinality,
										wasCellUnit));
		reporter.addStatus(message);
	}

	/**
	 * check the relationship between cell and its nodeUnit
	 * 
	 * @param wasCellUnit
	 * @param wasCellCap
	 * @param top
	 * @param reporter
	 */
	private void checkNodeMember(WasCellUnit wasCellUnit, WasCell wasCellCap,
			IDeployValidationContext context, IDeployReporter reporter) {
		List<Unit> nodeL = ValidatorUtils.discoverMembers(wasCellUnit,
				WasPackage.Literals.WAS_NODE_UNIT, context.getProgressMonitor());
		int numNodes = ValidatorUtils.ncFilteredSize(nodeL);

		if (numNodes == 0) {
			IDeployStatus message = DeployWasMessageFactory
					.createMissingNodeInStandAloneCellStatus(wasCellUnit);
			reporter.addStatus(message);
			return;
		}

		if (numNodes > 2) {
			IDeployStatus message = DeployWasMessageFactory
					.createWasListOFInvalidMemberUnitInGroupUnitStatus(
							null, // does not appear to get used
							wasCellUnit,
							IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_002,
							DeployNLS
									.bind(
											WasDomainMessages.Validator_Was_StandAloneCellUnit_0_With_Invalid_Node_Member_Cardinality,
											wasCellUnit));
			reporter.addStatus(message);
			return;
		}

		// One or two WasNode capabilities found
		WasNode wasNodeCap = null;
		if (numNodes == 1) {
			wasNodeCap = (WasNode) ValidatorUtils.getFirstCapability(nodeL.get(0),
					WasPackage.Literals.WAS_NODE);
		} else if (numNodes == 2) {
			WasNode wasNodeCap0 = (WasNode) ValidatorUtils.getFirstCapability(nodeL.get(0),
					WasPackage.Literals.WAS_NODE);
			if (wasNodeCap0.getProfileType() != WasProfileTypeEnum.NONE_LITERAL) {
				wasNodeCap = wasNodeCap0;
			}
			WasNode wasNodeCap1 = (WasNode) ValidatorUtils.getFirstCapability(nodeL.get(1),
					WasPackage.Literals.WAS_NODE);
			if (wasNodeCap1.getProfileType() != WasProfileTypeEnum.NONE_LITERAL) {
				if (wasNodeCap != null) {
					// Two profiles cancel out
					wasNodeCap = null;
				} else {
					wasNodeCap = wasNodeCap1;
				}
			}
		}

		if (wasNodeCap == null) {
			IDeployStatus message = DeployWasMessageFactory
					.createWasListOFInvalidMemberUnitInGroupUnitStatus(
							null, // does not appear to get used
							wasCellUnit,
							IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_002,
							DeployNLS
									.bind(
											WasDomainMessages.Validator_Was_StandAloneCellUnit_0_With_Invalid_Node_Member_Cardinality,
											wasCellUnit));
			reporter.addStatus(message);
			return;
		}

		if (!wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DEFAULT_LITERAL)) {
			IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
					IWasValidatorID.WAS_NODE_PROFILETYPE_001, wasNodeCap, WasPackage.eINSTANCE
							.getWasNode_ProfileType(), WasProfileTypeEnum.DEFAULT_LITERAL);
			reporter.addStatus(message);
		}

		//wasCell.wasVersion should equals wasNode.wasVersion,if not,mark Cell(change cell's version info)
		if (!wasCellCap.getWasVersion().equals(wasNodeCap.getWasVersion())) {
			IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidSourceValueStatus(
					IStatus.ERROR, IWasValidatorID.VALIDAT_WAS_CELL_WASVERSION_001, wasCellCap,
					WasPackage.eINSTANCE.getWasCell_WasVersion(), wasNodeCap, WasPackage.eINSTANCE
							.getWasNode_WasVersion());
			reporter.addStatus(message);
		}
	}
}
