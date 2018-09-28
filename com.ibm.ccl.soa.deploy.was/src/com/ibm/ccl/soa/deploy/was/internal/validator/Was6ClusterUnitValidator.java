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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class Was6ClusterUnitValidator extends WasGenericClusterUnitValidator {

	public Was6ClusterUnitValidator() {
		super();
		// Node group WAS 6+ only
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNodeGroup(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasV5Datasource(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		Topology top = unit.getEditTopology();
		if (top == null) {
			return;
		}
		assert unit instanceof WasClusterUnit;
		WasClusterUnit clusterUnit = (WasClusterUnit) unit;

		WasCluster wasClusterCap = (WasCluster) ValidatorUtils.getCapability(unit,
				WasPackage.eINSTANCE.getWasCluster());
		if (wasClusterCap == null) {
			return;
		}

		String wasClusterVersion = wasClusterCap.getWasVersion();
		if (wasClusterVersion == null) {
			return;
		}
		if (wasClusterVersion.length() <= 0) {
			return;
		}

		if (WasUtil.compare2VersionString(wasClusterVersion, WasUtil.WAS_6_MAIN_VERSION) < 0) {
			return;
		}
		if (WasUtil.compare2VersionString(wasClusterVersion, WasUtil.WAS_MAIN_VERSION_MAX_BOUND) > 0) {
			return;
		}

		// Common Cluster Unit validation
		super.validateUnit(unit, context, reporter);

		WasCell wasClusterCellCap = WasUtil.getWasCellCap(clusterUnit, top);
		if (wasClusterCellCap == null) {
			return;
		}

		//for version 6,wasCluster should depend on a wasNodeGroup inside the same wasCell
		WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) TopologyDiscovererService.INSTANCE
				.findTarget(unit, WasPackage.eINSTANCE.getWasNodeGroup(), top);
		List nodeGroupMemberList = checkDependingNodeGroup(clusterUnit, nodeGroupUnit,
				wasClusterCellCap, top, reporter);

		//all the members of the cluster are inside Nodes who are inside the same cell as the cluster's
		List serverMemberUnitList = WasUtil.getWasAppServerUnitMemberList(unit, top);
		if (serverMemberUnitList == null) {
			return;
		}

		Iterator serverMemberUnitIt = serverMemberUnitList.iterator();
		while (serverMemberUnitIt.hasNext()) {
			WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) serverMemberUnitIt.next();
			WasNodeUnit nodeUnit = getWasNodeUnit(serverUnit, top);
			if (nodeUnit == null) {
				continue;
			}

			WasCell nodeCellCap = WasUtil.getWasCellCap(nodeUnit, top);
			if (nodeCellCap != null && !wasClusterCellCap.equals(nodeCellCap)) {
				IDeployStatus message = DeployWasMessageFactory
						.createWasInvalidMemberUnitInGroupUnitStatus(
								serverUnit,
								clusterUnit,
								IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_MEMEBER_S_NODECONTAINER_IN_SAME_CELL,
								DeployNLS
										.bind(
												WasDomainMessages.Validator_WasClusterUnit_0_WasClusterMemberUnit_wasNodeUnit_1_Not_In_SameCell,
												clusterUnit, nodeUnit));
				reporter.addStatus(message);
			}

			//all the Nodes that are metioned above are inside the nodeGroupUnit the cluster is depending on
			if (nodeGroupUnit != null) {
				if (nodeGroupMemberList == null || nodeGroupMemberList.size() <= 0
						|| !nodeGroupMemberList.contains(nodeUnit)) {
					IDeployStatus message = DeployWasMessageFactory
							.createWasClusterNodeNotInNodeGroupStatus(nodeUnit, nodeGroupUnit,
									clusterUnit, serverUnit);
					reporter.addStatus(message);
				}
			}
		}
	}

	private List checkDependingNodeGroup(WasClusterUnit clusterUnit, WasNodeGroupUnit nodeGroupUnit,
			WasCell wasClusterCellCap, Topology top, IDeployReporter reporter) {
		ArrayList nodeGroupMemberList = new ArrayList();
		if (nodeGroupUnit == null) {
			return nodeGroupMemberList;
		}
		nodeGroupMemberList = (ArrayList) WasUtil
				.getWasNodeUnitsFromNodeGroupUnit(nodeGroupUnit, top);

		WasCell wasNGCellCap = WasUtil.getWasCellCap(nodeGroupUnit, top);
		if (wasNGCellCap == null || wasNGCellCap.equals(wasClusterCellCap)) {
			return nodeGroupMemberList;
		}

		IDeployStatus message = DeployWasMessageFactory
				.createWasClusterDependingOnNodeGroupInOtherCellStatus(clusterUnit, nodeGroupUnit);
		reporter.addStatus(message);
		return nodeGroupMemberList;
	}
}
