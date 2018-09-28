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

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link UnitValidator} for units of type {@link WasNodeUnit} where the was (major) version is 5
 * and where the node is not a deployment manager node.
 */
public class Was5NonDmgrNodeUnitValidator extends WasGenericNodeUnitValidator {

	/**
	 * Constructor.
	 */
	public Was5NonDmgrNodeUnitValidator() {
		super();

		// this covers only the version 5 not dmgr Node case!
		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getPortConsumer(),
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);

//		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWebsphereAppServerUnit(), RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		WasNode wasNodeCap = (WasNode) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNodeCap == null) {
			return;
		}
		if (wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
			return;
		}

		String wasNodeVersion = wasNodeCap.getWasVersion();
		if (wasNodeVersion == null || wasNodeVersion.length() <= 0) {
			return;
		}
		if (!wasNodeVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			return;
		}

		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		assert unit instanceof WasNodeUnit;
		WasNodeUnit wasNodeUnit = (WasNodeUnit) unit;
		Topology top = unit.getEditTopology();
		if (top == null) {
			return;
		}

		WasCell wasCellCap = WasUtil.getWasCellCap(wasNodeUnit, top);
		if (wasCellCap == null) {
			return;
		}

		if (wasCellCap.isIsDistributed()) { // distributed Cell
			// wasNode.wasVersion less than wasCell.wasVersion, if not, marker the Node
			WasGenericNodeUnitValidator.wasNonDmgrNodeVersionLessThanWasCellVersion(wasNodeUnit,
					reporter);
			if (wasNodeCap.isIsManaged()
					|| wasNodeCap.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
				return;
			}

			IDeployAttributeValueStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
					IStatus.ERROR, IWasValidatorID.WAS_NON_DMGR_NODE_IS_MANAGED_001, wasNodeCap,
					WasPackage.eINSTANCE.getWasNode_IsManaged(), Boolean.TRUE);
			reporter.addStatus(message);
			return;
		}

		// standalone Cell, valid: isManaged == false, otherwise, equals true; wasNode.wasVersion equals to wasCell.wasVersion, if not, let it be (Cell will do the check)
		if (wasNodeCap.isIsManaged()) {
			IDeployAttributeValueStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
					IStatus.ERROR, IWasValidatorID.WAS_NON_DMGR_NODE_IS_MANAGED_002, wasNodeCap,
					WasPackage.eINSTANCE.getWasNode_IsManaged(), Boolean.FALSE);
			reporter.addStatus(message);
		}

		if (wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DEFAULT_LITERAL)) {
			//If the profileType == default and it is inside a standalone Cell, it should own one and only one application server named "server1"
			List<Unit> appServerList = ValidatorUtils.discoverHosted(wasNodeUnit,
					WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, context.getProgressMonitor());
			int numServers = ValidatorUtils.ncFilteredSize(appServerList);
			if (numServers == 0) {
				//add an EmptyStandAloneDefaultNode problems status
				IDeployStatus message = DeployWasMessageFactory
						.createEmptyStandAloneDefaultNodeStatus(wasNodeUnit);
				reporter.addStatus(message);
			} else if (numServers > 1) {
				IDeployStatus message = DeployWasMessageFactory
						.createWasListOFInvalidMemberUnitInGroupUnitStatus(
								appServerList,
								wasNodeUnit,
								IWasValidatorID.WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER,
								DeployNLS
										.bind(
												WasDomainMessages.Validator_Was_Node_Unit_0_With_More_Than_One_Server_In_standalone_Cell,
												wasNodeUnit));
				reporter.addStatus(message);
			} else {
				//check serverName equals to 'server1'
				WasServer server1Cap = (WasServer) ValidatorUtils.getFirstCapability(appServerList
						.get(0), WasPackage.Literals.WAS_SERVER);
				String serverName = server1Cap.getServerName();
				if (serverName != null) {
					if (!serverName.equals(WasValidationUtil.WAS_DEFAULT_SERVER_NAME)) {
						IDeployAttributeValueStatus message = DeployCoreStatusUtil
								.createAttributeInvalidStatus(IStatus.ERROR,
										IWasValidatorID.WAS_NODE_UNIT_DEFAULT_WASSERVER_SERVERNAME_001,
										server1Cap, WasPackage.eINSTANCE.getWasServer_ServerName(),
										WasValidationUtil.WAS_DEFAULT_SERVER_NAME);
						message
								.setUnboundMessage(DeployNLS
										.bind(
												WasDomainMessages.Validator_Was_Node_Unit_0_With_One_Server_Whose_Name_Is_Invalid,
												wasNodeUnit, server1Cap.getServerName()));
						reporter.addStatus(message);
					}
				}
			}
		}
	}
}
