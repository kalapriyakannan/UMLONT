/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;

/**
 * Action to federate an unmanged node into a cell.
 */
public class FederateNodeIntoDmgrAction extends DeployResolution {

	private final List<DeployModelObject> _parameters;
	private final WasNodeUnit unmanagedNode;
	private final WasNodeUnit dmgrNode;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 */
	public FederateNodeIntoDmgrAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_parameters = parameters;
		unmanagedNode = (WasNodeUnit) _parameters.get(0);
		dmgrNode = (WasNodeUnit) _parameters.get(1);
	}

	public IStatus resolve(IProgressMonitor monitor) {

		WasCell dmgrCell = WasValidationUtil.getWasCell(dmgrNode);
		WasCell nodeCell = WasValidationUtil.getWasCell(unmanagedNode);

		if (dmgrCell == null) {
			return Status.CANCEL_STATUS;
		}

		if (dmgrCell == nodeCell) {
			return Status.OK_STATUS;
		}

		Unit nodeCellUnit = ValidatorUtils.getUnit(nodeCell);
		Unit dmgrCellUnit = ValidatorUtils.getUnit(dmgrCell);
		if (dmgrCellUnit == null) {
			return Status.CANCEL_STATUS;
		}
		// Remove node from its cell
		if (nodeCellUnit != null) {
			ResolutionUtils.removeMemberFromGroup(unmanagedNode, nodeCellUnit);
		}

		// Remove node from its node group
		WasNodeGroup nodeGroup = WasValidationUtil.getWasNodeGroup(unmanagedNode);
		Unit nodeGroupUnit = ValidatorUtils.getUnit(nodeGroup);
		if (nodeGroupUnit != null) {
			ResolutionUtils.removeMemberFromGroup(unmanagedNode, nodeGroupUnit);
		}

		// Reap cell if it was hosted on node
		if (nodeCellUnit != null && ValidatorUtils.hosts(unmanagedNode, nodeCellUnit)) {
			ResolutionUtils.removeFromTopology(nodeCellUnit);
		}

		// Reap node group if it is empty
		if (nodeGroupUnit != null && nodeGroupUnit.getMemberLinks().size() == 0) {
			ResolutionUtils.removeFromTopology(nodeGroupUnit);
		}

		// Add node to dmgr cell
		ResolutionUtils.group(dmgrCellUnit, unmanagedNode);
		WasNode node = (WasNode) ValidatorUtils.getFirstCapability(unmanagedNode,
				WasPackage.Literals.WAS_NODE);
		if (node != null) {
			node.setIsManaged(true);
		}

		// Add node to first public node group (if only one exists)
		List<Unit> groupList = ValidatorUtils.discoverMembers(dmgrCellUnit,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());
		for (Unit cellNodeGroup : groupList) {
			if (cellNodeGroup.isPublic()) {
				ResolutionUtils.group(cellNodeGroup, unmanagedNode);
			}
		}
//		if (groupList.size() == 1) {
//			WasNodeGroupUnit cellNodeGroup = (WasNodeGroupUnit) groupList.get(0);
//			ResolutionUtils.group(cellNodeGroup, unmanagedNode);
//		}
		return Status.OK_STATUS;
	}

}
