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
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
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
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link UnitValidator} for units of type {@link WasNodeUnit} where the was (major) version is 6
 * and where the node is not a deployment manager node.
 */
public class Was6NonDmgrNodeUnitValidator extends WasGenericNodeUnitValidator {

	/**
	 * Constructor.
	 */
	public Was6NonDmgrNodeUnitValidator() {
		super();

		//this covers only the version 6 not dmgr Node case!
		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getPortConsumer(),
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		// Membership in NodeGroup is optional for WebServer nodes (profileType == NONE).
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNodeGroupUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 0, 1); //InCardinality (1..*)		

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
		if (WasProfileTypeEnum.DMGR_LITERAL.equals(wasNodeCap.getProfileType())) {
			return;
		}

		String wasNodeVersion = wasNodeCap.getWasVersion();
		if (wasNodeVersion == null || wasNodeVersion.length() <= 0) {
			return;
		}

		if (!wasNodeVersion.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			return;
		}

		//Core Unit validation
		super.validateUnit(unit, context, reporter);

		assert unit instanceof WasNodeUnit;
		WasNodeUnit wasNodeUnit = (WasNodeUnit) unit;
		Topology top = unit.getEditTopology();
		// Unit deleted from edit topology?
		if (top == null) {
			return;
		}

		WasCell wasCellCap = WasUtil.getWasCellCap(wasNodeUnit, top);
		if (wasCellCap == null) {
			return;
		}

		//node && nodeGroup
		List reqL = unit.getRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (!((Requirement) reqL.get(i)).getDmoEType().equals(
					WasPackage.eINSTANCE.getWasNodeGroupUnit())) {
				continue;
			}

			List groupList = TopologyDiscovererService.INSTANCE.getGroups(unit, (Requirement) reqL
					.get(i), unit.getTopology());
			if (groupList == null || !(groupList.size() > 0)) {
				IDeployStatus message = DeployWasMessageFactory.createMissingGroupingNodeGroupStatus(
						wasNodeUnit, (WasCellUnit) wasCellCap.getParent());
				reporter.addStatus(message);
				break;
			}
		}

		if (wasCellCap.isIsDistributed()) {
			//wasNode.wasVersion equals to wasCell.wasVersion, if not, marker the Node
			WasGenericNodeUnitValidator.wasNonDmgrNodeVersionLessThanWasCellVersion(wasNodeUnit,
					reporter);

			//currently, we only support managed node in distributed cell
			if (!wasNodeCap.isIsManaged()
					&& wasNodeCap.getProfileType() != WasProfileTypeEnum.NONE_LITERAL) {
				IDeployAttributeValueStatus message = DeployCoreStatusUtil
						.createAttributeInvalidStatus(IStatus.ERROR,
								IWasValidatorID.WAS_NON_DMGR_NODE_IS_MANAGED_001, wasNodeCap,
								WasPackage.eINSTANCE.getWasNode_IsManaged(), Boolean.TRUE);
				reporter.addStatus(message);
				return;
			}
		} else {
			//in standalone Cell isManaged == false, otherwise, equals true; wasNode.wasVersion equals to wasCell.wasVersion, if not, let it be (Cell will do the check)
			if (wasNodeCap.isIsManaged()) {
				IDeployAttributeValueStatus message = DeployCoreStatusUtil
						.createAttributeInvalidStatus(IStatus.ERROR,
								IWasValidatorID.WAS_NON_DMGR_NODE_IS_MANAGED_002, wasNodeCap,
								WasPackage.eINSTANCE.getWasNode_IsManaged(), Boolean.FALSE);
				reporter.addStatus(message);
			}

			if (wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DEFAULT_LITERAL)) {
				//If the profileType == default and it is inside a standalone Cell, it should own one and only one application server named �1�7server1�1�7.
				List<Unit> appServerList = ValidatorUtils.discoverHosted(wasNodeUnit,
						WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, context.getProgressMonitor());
				int numServers = ValidatorUtils.ncFilteredSize(appServerList);
				if (numServers == 0) {
					IDeployStatus message = DeployWasMessageFactory
							.createEmptyStandAloneDefaultNodeStatus(wasNodeUnit);
					reporter.addStatus(message);
					return;
				} else if (numServers > 1) {
					IDeployStatus message = DeployWasMessageFactory
							.createWasListOFInvalidMemberUnitInGroupUnitStatus(
									appServerList,
									wasNodeUnit,
									IWasValidatorID.WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER,
									NLS
											.bind(
													WasDomainMessages.Validator_Was_Node_Unit_0_With_More_Than_One_Server_In_standalone_Cell,
													wasNodeUnit.getName()));
					reporter.addStatus(message);
					return;
				}
				//check serverName equals to 'server1'
				WasServer server1Cap = (WasServer) ValidatorUtils.getFirstCapability(appServerList
						.get(0), WasPackage.Literals.WAS_SERVER);
				if (null != server1Cap) {
					String serverName = server1Cap.getServerName();
					if (serverName != null
							&& !serverName.equals(WasValidationUtil.WAS_DEFAULT_SERVER_NAME)) {
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
					// TODO no WebServers!
				} else {
					// no WasServer capability; this is an error that will be discovered elsewhere
				}
			}
		}

		//
		// No-profile nodes must be unmanaged
		//
		if (wasNodeCap.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
			ValidatorUtils.validateEquals(wasNodeCap, WasPackage.Literals.WAS_NODE__IS_MANAGED,
					Boolean.FALSE, IWasValidatorID.WAS_NODE_NOT_MANAGED_IF_NOT_A_PROFILE, context,
					reporter);
		}
	}
}
