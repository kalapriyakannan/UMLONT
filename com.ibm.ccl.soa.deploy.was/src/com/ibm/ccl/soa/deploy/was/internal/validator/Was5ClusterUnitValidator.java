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

import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class Was5ClusterUnitValidator extends WasGenericClusterUnitValidator {

	public Was5ClusterUnitValidator() {
		super();

	}

	/*
	 * run this validation only when cluster version in [5.0-6.0) && in a cell validate: 1. common
	 * cluster validation 2. cluster are inside Nodes in the same Cell
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		assert unit instanceof WasClusterUnit;
		WasClusterUnit clusterUnit = (WasClusterUnit) unit;
		Topology top = unit.getEditTopology();
		if (top == null) {
			return;
		}

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
		if (WasUtil.compare2VersionString(wasClusterVersion, WasUtil.WAS_5_MAIN_VERSION) < 0) {
			return;
		}
		if (WasUtil.compare2VersionString(wasClusterVersion, WasUtil.WAS_6_MAIN_VERSION) >= 0) {
			return;
		}

		WasCell wasClusterCellCap = WasUtil.getWasCellCap(clusterUnit, top);
		if (wasClusterCellCap == null) {
			return;
		}

		// Common Cluster Unit validation
		super.validateUnit(unit, context, reporter);

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
			if (nodeCellCap == null) {
				continue;
			}
			if (wasClusterCellCap.equals(nodeCellCap)) {
				continue;
			}

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
	}
}
