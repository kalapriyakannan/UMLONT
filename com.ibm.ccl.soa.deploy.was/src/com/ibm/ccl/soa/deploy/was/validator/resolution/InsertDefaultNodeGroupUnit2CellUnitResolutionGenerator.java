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
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * create a default NodeGroupUnit, and add it as a member of the given CellUnit
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class InsertDefaultNodeGroupUnit2CellUnitResolutionGenerator extends
		DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		WasCellUnit cellUnit = (WasCellUnit) status.getDeployObject();
		if (cellUnit == null) {
			return new IDeployResolution[0];
		}

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		List<Unit> nodeGroups = ValidatorUtils.discoverMembers(cellUnit,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());
		for (Unit ng : nodeGroups) {
			if (DeployModelObjectUtil.isSettable(ng,
					WasPackage.Literals.WAS_NODE_GROUP__IS_DEFAULT_TYPE)) {
				resolutions.add(new RefactorNodeGroupIntoDefaultNodeGroupCellUnitResolution(context,
						this, cellUnit, (WasNodeGroupUnit) ng));
			}
		}

		List requireNodeUnitL = ValidatorUtils.getRequirements(cellUnit, WasPackage.eINSTANCE
				.getWasNodeGroupUnit());
		if (requireNodeUnitL == null) {
			return new IDeployResolution[0];
		}

		if (cellUnit.isPublic()) {
			resolutions.add(new CreateDefaultNodeGroupUnitIntoCellUnitResolution(context, this,
					cellUnit));
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);

	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		// verify problem type
		if (!IWASProblemType.MISSING_DEFAULT_WAS_NODEGROUP_UNIT_IN_WAS_6_CELL_UNIT.equals(status
				.getProblemType())) {
			return false;
		}

		// verify inputs
		DeployModelObject obj = status.getDeployObject();
		if (!WasPackage.Literals.WAS_CELL_UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		// check that the resolution(s) will have the permissions to do what they want to do
		// resolutions may be created to refactor one of the exiting node groups into the default node group
		// (RefactorNodeGroupIntoDefaultNodeGroupCellUnitResolution)
		//    (a) set isDefaultType attribute on node group
		// and to create a new default node group (CreateDefaultNodeGroupUnitIntoCellUnitResolution)
		//    (a) create node group
		//    (b) create member link from cell to new node group

		// conditions for any one resolution should trigger return from method w/ value 'true'

		// RefactorNodeGroupIntoDefaultNodeGroupCellUnitResolution
		//    (a) set isDefaultType attribute on node group
		List<Unit> nodeGroups = ValidatorUtils.discoverMembers((Unit) obj,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());
		for (Unit ng : nodeGroups) {
			if (DeployModelObjectUtil.isSettable(ng,
					WasPackage.Literals.WAS_NODE_GROUP__IS_DEFAULT_TYPE)) {
				return true;
			}
		}

		// CreateDefaultNodeGroupUnitIntoCellUnitResolution
		//    (a) create node group
		// can always create new node group in edit topology
		//    (b) create member link from cell to new node group
		// cell must be public
		if (obj.isPublic()) {
			return true;
		}

		return false;
	}
}
