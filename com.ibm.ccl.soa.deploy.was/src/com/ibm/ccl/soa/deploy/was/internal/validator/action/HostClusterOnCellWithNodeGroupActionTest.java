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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test to determine if a {@link WebsphereAppServerUnit} can be used as a template to
 * create a {@link WasClusterUnit}. See {@link HostClusterOnCellWithNodeGroupAction}.
 * <p>
 * The preconditions tested for are:
 * <ul>
 * <li>(A) the parameters are defined and of the correct types</li>
 * <li>(B) cluster is not already hosted in a cell</li>
 * <li>(C) if cluster is already associated with a nodegroup then it is the nodegroup passed as a
 * parameter</li>
 * <li>(D) if server in cell, the cell is distributed</li>
 * <li>(D) the node group is in the specified cell (if in a cell)</li>
 * <li>(E) permissions exist to make the desired changes</li>
 * </ul>
 */
public class HostClusterOnCellWithNodeGroupActionTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	private static final int NUMBER_EXPECTED_PARAMETERS = 3;
	private static final int CLUSTER_UNIT_PARAMETER_INDEX = 0;
	private static final int CELL_UNIT_PARAMETER_INDEX = 1;
	private static final int NODEGROUP_UNIT_PARAMETER_INDEX = 2;

	/**
	 * Constructor
	 */
	public HostClusterOnCellWithNodeGroupActionTest() {
		super(IWasValidatorID.WAS_HOST_CLUSTER_ON_CELL_WITH_NODE_GROUP, new UnitSignature(
				new EClass[] { WasPackage.Literals.WAS_CLUSTER_UNIT, WasPackage.Literals.WAS_CELL_UNIT,
						WasPackage.Literals.WAS_NODE_GROUP_UNIT }));
	}

	@Override
	public boolean appliesTo(ISignature signature) {
		// check number of parameters
		if (NUMBER_EXPECTED_PARAMETERS != signature.getNumberParameters()) {
			return false;
		}

		// check that parameters are not null
		for (int i = 0; i < NUMBER_EXPECTED_PARAMETERS; i++) {
			if (null == signature.get(i)) {
				return false;
			}
		}

		// check types of parameters
		if (!WasPackage.Literals.WAS_CLUSTER_UNIT.isSuperTypeOf(signature
				.get(CLUSTER_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		if (!WasPackage.Literals.WAS_CELL_UNIT
				.isSuperTypeOf(signature.get(CELL_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		if (!WasPackage.Literals.WAS_NODE_GROUP_UNIT.isSuperTypeOf(signature
				.get(NODEGROUP_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		return true;
	}

	@Override
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter) {

		//   (A) the parameters are defined and of the correct types
		if (!appliesTo(parameters)) {
			return;
		}

		// extract parameters
		WasClusterUnit cluster = (WasClusterUnit) parameters.get(CLUSTER_UNIT_PARAMETER_INDEX);
		WasCellUnit cell = (WasCellUnit) parameters.get(CELL_UNIT_PARAMETER_INDEX);
		WasNodeGroupUnit nodeGroup = (WasNodeGroupUnit) parameters
				.get(NODEGROUP_UNIT_PARAMETER_INDEX);

		//    (B) cluster is not already hosted in a cell
		Unit clusterHost = ValidatorUtils.discoverHost(cluster, context.getProgressMonitor());
		if (null != clusterHost) {
			// cluster already hosted
			return;
		}

		//   (C) if cluster is already associated with a nodegroup then it is the nodegroup passed as a parameter
		Requirement wasNodeReq = ValidatorUtils.getFirstRequirement(cluster,
				WasPackage.Literals.WAS_NODE_GROUP);
		if (null == wasNodeReq) {
			// invalid cluster; expected node group requirement for dependency link
			return;
		}
		Unit nodeGroupTarget = ValidatorUtils.discoverDependencyLinkTargetUnit(wasNodeReq, cluster
				.getEditTopology(), context.getProgressMonitor());
		if (null != nodeGroupTarget) {
			// associated node group is already identified but host is not
			// then nodeGroup must be nodeGroupTarget
			// and cell must match the cell in which the node group is a member
			//     --> this is checked below for all cases
			if (nodeGroup != nodeGroupTarget) {
				return;
			}
		}

		// (D) the node group is in the specified cell (if in a cell)
		boolean nodeGroupIsContainedInCell = false;
		List<Unit> groups = ValidatorUtils.getGroups(nodeGroup);
		for (Iterator<Unit> iterator = groups.iterator(); iterator.hasNext()
				&& !nodeGroupIsContainedInCell;) {
			if (iterator.next().equals(cell)) {
				nodeGroupIsContainedInCell = true;
			}
		}

		// (E) permissions exist to make the desired changes
		//   (a) host cluster on cell
		//   (b) create dependency link from cluster to node group

		//   (a) host cluster on cell
		if (!cell.isPublic()) {
			return;
		}
		//   (b) create dependency link from cluster to node group
		if (!cluster.isPublic()) {
			return;
		}

		if (nodeGroupIsContainedInCell) {

			// the preconditions hold; we create an INFO status to trigger the action
			reporter.addStatus(WasValidationUtil.createActionPreconditionValid(IStatus.OK, getId(),
					WasDomainMessages.Action_Host_Cluster_On_Cell_With_Node_Group_0, new Object[] {
							cell.getCaptionProvider().title(cell),
							nodeGroup.getCaptionProvider().title(nodeGroup) }, cluster, parameters));
		}
	}
}
