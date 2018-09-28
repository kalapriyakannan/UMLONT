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

import org.eclipse.core.runtime.IStatus;

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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Class to validate a {@link WasCellUnit} when the unit is configured with was (major) version 5
 * and as a standalone cell (ie, not distributed).
 */
public class Was5StandaloneCellUnitValidator extends WasGenericCellUnitValidator {

	/**
	 * Constructor.
	 */
	public Was5StandaloneCellUnitValidator() {
		super();

		//This covers only the non-distributed version 5 case
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
		if (wasCellVersion == null) {
			return;
		}
		if (wasCellVersion.length() <= 0) {
			return;
		}

		if (!wasCellVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			return;
		}

		//Core Unit Validator
		super.validateUnit(unit, context, reporter);

//		List nodeCapL = WasUtil.getWasNodeCapsFromCellUnit(wasCellUnit, context.getTopology());
//		List nodeCapL = ValidatorUtils.filteredDiscoverMemberCapabilities(wasCellUnit,
//				WasPackage.Literals.WAS_NODE_UNIT, WasPackage.Literals.WAS_NODE, context
//						.getProgressMonitor());
		List<Unit> nodeL = ValidatorUtils.discoverMembers(wasCellUnit,
				WasPackage.Literals.WAS_NODE_UNIT, context.getProgressMonitor());

		int size = ValidatorUtils.ncFilteredSize(nodeL);

		if (size == 1) {
//			assert nodeCapL.get(0) instanceof WasNode;
			WasNode wasNodeCap = (WasNode) ValidatorUtils.getFirstCapability(nodeL.get(0),
					WasPackage.Literals.WAS_NODE);
			if (!wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DEFAULT_LITERAL)) {
				IDeployStatus message = DeployCoreStatusUtil
						.createAttributeInvalidStatus(IStatus.ERROR,
								IWasValidatorID.WAS_NODE_PROFILETYPE_001, wasNodeCap, WasPackage.eINSTANCE
										.getWasNode_ProfileType(), WasProfileTypeEnum.DEFAULT_LITERAL);
				reporter.addStatus(message);
			}

			//wasCell.wasVersion should equal wasNode.wasVersion,if not,mark Cell(change cell's version info)
			if (!wasCellCap.getWasVersion().equals(wasNodeCap.getWasVersion())) {
				IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidSourceValueStatus(
						IStatus.ERROR, IWasValidatorID.VALIDAT_WAS_CELL_WASVERSION_001, wasCellCap,
						WasPackage.eINSTANCE.getWasCell_WasVersion(), wasNodeCap, WasPackage.eINSTANCE
								.getWasNode_WasVersion());
				reporter.addStatus(message);
			}
			return;
		}

		if (size < 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createMissingNodeInStandAloneCellStatus(wasCellUnit);
			reporter.addStatus(message);
			return;
		}

		//
		IDeployStatus message = DeployWasMessageFactory
				.createWasListOFInvalidMemberUnitInGroupUnitStatus(
						null, // list does not appear to be used in output
						wasCellUnit,
						IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_002,
						DeployNLS
								.bind(
										WasDomainMessages.Validator_Was_StandAloneCellUnit_0_With_Invalid_Node_Member_Cardinality,
										wasCellUnit));
		reporter.addStatus(message);

	}
}
