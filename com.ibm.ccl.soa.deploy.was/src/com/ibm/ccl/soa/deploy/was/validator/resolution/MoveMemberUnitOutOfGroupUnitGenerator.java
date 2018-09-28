/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class MoveMemberUnitOutOfGroupUnitGenerator extends DeployResolutionGenerator {

	// TODO this is too complex; simplify by breaking into several generators

	private static EClass nodeType = WasPackage.Literals.WAS_NODE;
	private static EClass nodeUnitType = WasPackage.Literals.WAS_NODE_UNIT;
	private static EClass serverUnitType = WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT;
	private static EClass clusterUnitType = WasPackage.Literals.WAS_CLUSTER_UNIT;
	private static EClass cellUnitType = WasPackage.Literals.WAS_CELL_UNIT;
	private static EClass nodeGroupUnitType = WasPackage.Literals.WAS_NODE_GROUP_UNIT;

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();
		String _validatorID = status.getValidatorID();

		Topology top = dmo.getEditTopology();
		if (top == null) {
			return new IDeployResolution[0];
		}
		IProgressMonitor monitor = context.getProgressMonitor();

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();

		if (IWasValidatorID.WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER
				.equals(_validatorID)) {
			if (!(dmo instanceof WasNodeUnit)) {
				return new IDeployResolution[0];
			}

			WasNodeUnit wasNodeUnit = (WasNodeUnit) dmo;
			List<Unit> servers = ValidatorUtils.discoverHosted(wasNodeUnit, serverUnitType, monitor);
			if (servers.size() <= 1) {
				return new IDeployResolution[0];
			}

			for (Unit server : servers) {
				if (canDeleteAllServers(wasNodeUnit, server, servers)) {
					resolutions.add(new CreateMoveRedundantServersOutofDefaultNodeResolution(context,
							this, (WebsphereAppServerUnit) server, wasNodeUnit, top));
				}
			}
			return resolutions.toArray(new IDeployResolution[resolutions.size()]);
		} else if (IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_MEMEBER_S_NODECONTAINER_IN_SAME_CELL
				.equals(_validatorID)) {
			if (!(dmo instanceof WebsphereAppServerUnit)) {
				return new IDeployResolution[0];
			}

			Object[] clusterU = context.getDeployStatus().getBindings();
			if (clusterU[0] == null) {
				return new IDeployResolution[0];
			}
			if (!(clusterU[0] instanceof WasClusterUnit)) {
				return new IDeployResolution[0];
			}

			WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) dmo;
			WasClusterUnit clusterUnit = (WasClusterUnit) clusterU[0];
			return new IDeployResolution[] { new CreateMoveInvalidMemberOutOfGroupResolution(context,
					this, serverUnit, clusterUnit) };
		} else if (IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_VERSION_WITH_WASCELL_VERSION
				.equals(_validatorID)) {
			if (!(dmo instanceof WasClusterUnit)) {
				return new IDeployResolution[0];
			}

			Object[] statusBindings = context.getDeployStatus().getBindings();
			if (statusBindings[0] == null) {
				return new IDeployResolution[0];
			}
			if (!(statusBindings[0] instanceof WasCellUnit)) {
				return new IDeployResolution[0];
			}

			WasClusterUnit clusterUnit = (WasClusterUnit) dmo;
			WasCellUnit cellUnit = (WasCellUnit) statusBindings[0];
			return new IDeployResolution[] { new UnhostUnitResolution(context, this, clusterUnit,
					cellUnit) };
		} else if (IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODEGROUP_MEMBER_CARDINALITY_001
				.equals(_validatorID)
				&& dmo instanceof WasCellUnit) {
			WasCellUnit cellUnit = (WasCellUnit) dmo;
			List<Unit> nodegroups = ValidatorUtils.discoverMembers(cellUnit, nodeGroupUnitType,
					monitor);
			if (nodegroups.size() < 2) {
				return new IDeployResolution[0];
			}

			for (Unit ng : nodegroups) {
				if (WasResolutionUtils.canRemoveMemberLink(cellUnit, ng)) {
					resolutions.add(new CreateMoveInvalidMemberOutOfGroupResolution(context, this, ng,
							cellUnit));
				}
			}
			return resolutions.toArray(new IDeployResolution[resolutions.size()]);
		} else if (IWasValidatorID.WAS_VALIDAT_NODE_NODEGROUP_IN_SAME_CELL.equals(_validatorID)) {
			Object[] bindings = context.getDeployStatus().getBindings();
			if (bindings == null || bindings.length < 2) {
				return new IDeployResolution[0];
			}
			if (!(bindings[0] instanceof WasNodeUnit) || !(bindings[1] instanceof WasNodeGroupUnit)) {
				return new IDeployResolution[0];
			}
			return new IDeployResolution[] { new CreateMoveInvalidMemberOutOfGroupResolution(context,
					this, (WasNodeUnit) bindings[0], (WasNodeGroupUnit) bindings[1]) };
		}

		if (IWasValidatorID.WAS_NODE_UNIT_WAS_VERSION_INVALID_001.equals(_validatorID)
				|| IWasValidatorID.VALIDAT_WAS_5_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION
						.equals(_validatorID)
				|| IWasValidatorID.VALIDAT_WAS_6_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION
						.equals(_validatorID)) {
			WasNodeUnit nodeUnit;
			if (dmo instanceof WasNode) {
				WasNode nodeCap = (WasNode) dmo;
				nodeUnit = (WasNodeUnit) nodeCap.getParent();
			} else if (dmo instanceof WasNodeUnit) {
				nodeUnit = (WasNodeUnit) dmo;
			} else {
				return new IDeployResolution[0];
			}

			return new IDeployResolution[] { new MoveWasNodeUnitOutOfWasCellUnitResolution(context,
					this, nodeUnit) };
		}

		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (status == null) {
			return false;
		}

		// check problem type
		if (!IWASProblemType.WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT.equals(status.getProblemType())) {
			return false;
		}

		DeployModelObject dmo = status.getDeployObject();
		if (null == dmo) {
			return false;
		}
		EClass dmoType = dmo.getEObject().eClass();

		// different validators produce this problem type.... and the expected parameters depends on this
		String validatorID = status.getValidatorID();
		if (validatorID == null) {
			return false;
		}

		if (IWasValidatorID.WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER
				.equals(validatorID)) {
			// dmo expected to be WasNodeUnit
			if (!nodeUnitType.isSuperTypeOf(dmoType)) {
				return false;
			}
			List<Unit> servers = ValidatorUtils.discoverHosted((Unit) dmo, serverUnitType, context
					.getProgressMonitor());
			if (servers.size() <= 1) {
				return false;
			}

			// check that at least one resolution (CreateMoveRedundantServersOutofDefaultNodeResolution) 
			// generated has the necessary permissions to complete: 
			// (a) remove all servers but one from on node (for at least one server)
			for (Unit keepServer : servers) {
				if (canDeleteAllServers((Unit) dmo, keepServer, servers)) {
					return true;
				}
			}
			return false;
		} else if (IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_MEMEBER_S_NODECONTAINER_IN_SAME_CELL
				.equals(validatorID)) {
			// dmo expected to be a WebsphereAppServerUnit
			if (!serverUnitType.isSuperTypeOf(dmoType)) {
				return false;
			}

			// TODO remove use of bindings to pass parameters; use attributes on DeployStatus
			// bindings expected to contain a single cluster
			Object[] bindings = status.getBindings();
			if (bindings == null || bindings[0] == null || !(bindings[0] instanceof WasClusterUnit)) {
				return false;
			}

			// check that generated resolution (CreateMoveInvalidMemberOutOfGroupResolution) will have
			// necessary permissions to complete:
			// (a) remove server from cluster
			if (!WasResolutionUtils.canRemoveMemberLink((Unit) bindings[0], (Unit) dmo)) {
				return false;
			}

			return true;
		} else if (IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_VERSION_WITH_WASCELL_VERSION
				.equals(validatorID)) {
			// dmo expected to be a WasClusterUnit
			if (!clusterUnitType.isSuperTypeOf(dmoType)) {
				return false;
			}

			// TODO remove use of bindings to pass parameters; use attributes on DeployStatus
			// bindings expected to contain a single cell unit
			Object[] bindings = status.getBindings();
			if (bindings == null || bindings[0] == null || !(bindings[0] instanceof WasCellUnit)) {
				return false;
			}

			// check that generated resolution (CreateMoveInvalidMemberOutOfGroupResolution) will have
			// necessary permissions to complete:
			// (a) unhost cluster from cell
			if (!WasResolutionUtils.canRemoveHostingLink((Unit) bindings[0], (Unit) dmo)) {
				return false;
			}

			return true;
		} else if (IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODEGROUP_MEMBER_CARDINALITY_001
				.equals(validatorID)) {
			// dmo expected to be a WasCellUnit
			if (!cellUnitType.isSuperTypeOf(dmoType)) {
				return false;
			}

			List<Unit> nodegroups = ValidatorUtils.discoverMembers((Unit) dmo, nodeGroupUnitType,
					context.getProgressMonitor());
			if (nodegroups.size() < 2) {
				return false;
			}

			// check that at least one of the created resolutions (CreateMoveInvalidMemberOutOfGroupResolution) 
			// will have the permissions needed to complete:
			// (a) remove node group from cell
			for (Unit ng : nodegroups) {
				if (WasResolutionUtils.canRemoveMemberLink((Unit) dmo, ng)) {
					return true;
				}
			}

			return false;
		} else if (IWasValidatorID.WAS_VALIDAT_NODE_NODEGROUP_IN_SAME_CELL.equals(validatorID)) {
			// dmo expected to be a node; though it doesn't appear to matter much
			if (!nodeUnitType.isSuperTypeOf(dmoType)) {
				return false;
			}

			// TODO remove use of bindings to pass parameters; use attributes on DeployStatus
			// bindings expected to contain a single cell unit
			Object[] bindings = status.getBindings();
			if (bindings == null || bindings.length < 2 || bindings[0] == null
					|| !(bindings[0] instanceof WasNodeUnit) || bindings[1] == null
					|| !(bindings[1] instanceof WasNodeGroupUnit)) {
				return false;
			}

			// check that the generated resolution (CreateMoveInvalidMemberOutOfGroupResolution) will
			// have sufficient permission to complete:
			if (!WasResolutionUtils.canRemoveMemberLink((Unit) bindings[1], (Unit) bindings[2])) {
				return false;
			}

			return true;
		} else if (IWasValidatorID.WAS_NODE_UNIT_WAS_VERSION_INVALID_001.equals(validatorID)
				|| IWasValidatorID.VALIDAT_WAS_5_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION
						.equals(validatorID)
				|| IWasValidatorID.VALIDAT_WAS_6_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION
						.equals(validatorID)) {
			// dmo expected to be either a WasNode or a WasNodeUnit
			if (!nodeUnitType.isSuperTypeOf(dmoType) && !nodeType.isSuperTypeOf(dmoType)) {
				return false;
			}
			Unit nodeUnit = nodeUnitType.isSuperTypeOf(dmoType) ? (Unit) dmo : (Unit) dmo.getParent();

			// check that resolution generated (MoveWasNodeUnitOutOfWasCellUnitResolution) will 
			// have the necessary permissions needed to complete:
			// (a) remove node from cell
			// (b) remove node from node group in cell if present

			// (a) remove node from cell
			Unit cellUnit = ValidatorUtils.discoverGroupByUnitType(nodeUnit, cellUnitType, context
					.getProgressMonitor());
			if (null == cellUnit) {
				return false;
			}

			if (!WasResolutionUtils.canRemoveMemberLink(cellUnit, nodeUnit)) {
				return false;
			}

			// (b) remove node from any node group in cell if present
			List<Unit> nodegroups = ValidatorUtils.discoverGroupsByUnitType(nodeUnit,
					nodeGroupUnitType, context.getTopology(), context.getProgressMonitor());
			for (Unit ng : nodegroups) {
				Unit ngCell = ValidatorUtils.discoverGroupByUnitType(ng, cellUnitType, context
						.getProgressMonitor());
				if (ngCell == cellUnit) {
					if (!WasResolutionUtils.canRemoveMemberLink(ng, nodeUnit)) {
						return false;
					}
				}
			}

			return true;
		}

		// didn't recognize the validator
		return false;
	}

	private boolean canDeleteAllServers(Unit node, Unit keepServer, List<Unit> servers) {
		for (Unit unhostServer : servers) {
			if (unhostServer == keepServer) {
				continue;
			}
			if (!WasResolutionUtils.canRemoveHostingLink(node, unhostServer)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * move serverUnits other than 'server1' Unit out of NodeUnit
	 */
	private static class CreateMoveRedundantServersOutofDefaultNodeResolution extends
			DeployResolution {
		private final WebsphereAppServerUnit _remainServerUnit;
//		private final WasServer _remainServerCap;
		private final WasNodeUnit _wasNodeUnit;
		private final Topology _top;

		public CreateMoveRedundantServersOutofDefaultNodeResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WebsphereAppServerUnit serverUnit,
				WasNodeUnit nodeUnit, Topology top) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_move_Redundant_Servers_Other_Than_ServerUnit_0_Out_of_DefaultNodeUnit_1,
									serverUnit, nodeUnit));
			_remainServerUnit = serverUnit;
			_wasNodeUnit = nodeUnit;
			_top = top;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			List<Unit> servers = ValidatorUtils.discoverHosted(_wasNodeUnit,
					WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, monitor);
			for (Unit server : servers) {
				if (_remainServerUnit.equals(server)) {
					continue;
				}
				ResolutionUtils.unhost(server);
			}
			return Status.OK_STATUS;
		}

	}

}
