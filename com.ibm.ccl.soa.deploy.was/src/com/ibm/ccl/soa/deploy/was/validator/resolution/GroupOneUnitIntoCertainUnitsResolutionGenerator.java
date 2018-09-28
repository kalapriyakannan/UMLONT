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

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class GroupOneUnitIntoCertainUnitsResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();
		Topology top = dmo.getTopology();
		if (top == null) {
			return new IDeployResolution[0];
		}

		String problemType = status.getProblemType();
		String validatorID = status.getValidatorID();

		if (IWASProblemType.UNSATISFIED_GROUPING_REQUEST_FOR_MEMBERUNIT.equals(problemType)
				&& IWasValidatorID.VALIDAT_WAS_NODE_IN_NODEGROUP_MEMBER_LINK.equals(validatorID)
				&& dmo instanceof WasNodeUnit) {
			// TODO: remove use of bindings for passing parameters; use attributes on DeployStatus
			Object[] statusBindings = context.getDeployStatus().getBindings();
			if (statusBindings[0] == null || !(statusBindings[0] instanceof WasCellUnit)) {
				return new IDeployResolution[0];
			}

			WasNodeUnit nodeUnit = (WasNodeUnit) dmo;
			WasCellUnit cellUnit = (WasCellUnit) statusBindings[0];

			List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
			List<Unit> nodeGroupList = ValidatorUtils.discoverMembers(cellUnit,
					WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());
			for (Unit nodeGroupUnit : nodeGroupList) {
				// only create resolutions where nodegroup is public
				if (nodeGroupUnit.isPublic()) {
					resolutions.add(new AddMemberUnitIntoGroupUnitResolution(context, this, nodeUnit,
							nodeGroupUnit));
				}
				return resolutions.toArray(new IDeployResolution[resolutions.size()]);
			}
		} else if (IWASProblemType.WAS_CLUSTER_NODE_UNIT_NOT_IN_DEPENDING_NODEGROUP
				.equals(problemType)
				&& dmo instanceof WasNodeUnit) {
			Object[] statusBindings = context.getDeployStatus().getBindings();
			if (statusBindings[0] == null || !(statusBindings[0] instanceof WasNodeGroupUnit)) {
				return new IDeployResolution[0];
			}

			WasNodeUnit nodeUnit = (WasNodeUnit) dmo;
			WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) statusBindings[0];

			return new IDeployResolution[] { new AddMemberUnitIntoGroupUnitResolution(context, this,
					nodeUnit, nodeGroupUnit) };
		}

		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		String validatorID = status.getValidatorID();
		String problemType = status.getProblemType();
		if (!(IWASProblemType.WAS_CLUSTER_NODE_UNIT_NOT_IN_DEPENDING_NODEGROUP.equals(problemType) || IWASProblemType.UNSATISFIED_GROUPING_REQUEST_FOR_MEMBERUNIT
				.equals(problemType))) {
			return false;
		}
		DeployModelObject obj = status.getDeployObject();
		if (null == obj
				|| !WasPackage.Literals.WAS_NODE_UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		// TODO: remove use of bindings for passing parameters; use attributes on DeployStatus
		Object[] statusBindings = status.getBindings();
		if (statusBindings.length == 0 || statusBindings[0] == null) {
			return false;
		}

		// check that resolution can do what it needs to do:
		// (a) create member link between node and group
		// node and group need to be public
		// node
		if (!obj.isPublic()) {
			return false;
		}

		// nodegroups: case 1
		if (IWASProblemType.UNSATISFIED_GROUPING_REQUEST_FOR_MEMBERUNIT.equals(context
				.getDeployStatus().getProblemType())
				&& IWasValidatorID.VALIDAT_WAS_NODE_IN_NODEGROUP_MEMBER_LINK.equals(validatorID)) {
			if (!(statusBindings[0] instanceof WasCellUnit)) {
				return false;
			}
			WasCellUnit cellUnit = (WasCellUnit) statusBindings[0];
			// if at least one of the node groups in the cell is public
			List<Unit> nodeGroups = ValidatorUtils.discoverMembers(cellUnit,
					WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());
			for (Unit ng : nodeGroups) {
				if (ng.isPublic()) {
					return true;
				}
			}
			return false;
		}

		// node group: case 2
		if (IWASProblemType.WAS_CLUSTER_NODE_UNIT_NOT_IN_DEPENDING_NODEGROUP.equals(problemType)) {
			if (!(statusBindings[0] instanceof WasNodeGroupUnit)) {
				return false;
			}
			return ((WasNodeGroupUnit) statusBindings[0]).isPublic();
		}

		return false;
	}
}
