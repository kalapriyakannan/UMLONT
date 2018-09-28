/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test to determine if we can create a new {@link WebsphereAppServerUnit} (on a
 * particular {@link WasNodeUnit} in a {@link WasClusterUnit}. See
 * {@link CreateNewServerInClusterAction}.
 * <p>
 * The preconditions tested for are:
 * <ul>
 * <li>(A) the parameters are defined and of the correct types</li>
 * <li>(B) the node is not a deployment manager node</li>
 * <li>(C) the node is hosted on an ND system (if hosted on any system)</li>
 * <li>(D) WAS version is defined on node/cluster and is less than that of the cluster</li>
 * <li>(E) the cluster and node are not on/in different cells (will work if no cell is defined or
 * if only one is defined)</li>
 * <li>(F) the nodegroup associated with the cluster/of which node is a member is the same node
 * group (will work if there is no node group</li>
 * <li>(G) permissions exist to make the desired changes</li>
 * </ul>
 */
public class CreateNewServerInClusterActionTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	private static final int NUMBER_EXPECTED_PARAMETERS = 2;
	private static final int CLUSTER_UNIT_PARAMETER_INDEX = 0;
	private static final int NODE_UNIT_PARAMETER_INDEX = 1;

	/**
	 * Constructor
	 */
	public CreateNewServerInClusterActionTest() {
		super(IWasValidatorID.WAS_CREATE_NEW_SERVER_IN_CLUSTER, new UnitSignature(new EClass[] {
				WasPackage.Literals.WAS_CLUSTER_UNIT, WasPackage.Literals.WAS_NODE_UNIT }));
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

		if (!WasPackage.Literals.WAS_NODE_UNIT
				.isSuperTypeOf(signature.get(NODE_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		return true;
	}

	@Override
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter) {

		//    (A) the parameters are defined and of the correct types
		if (!appliesTo(parameters)) {
			return;
		}

		// extract parameters
		WasClusterUnit cluster = (WasClusterUnit) parameters.get(CLUSTER_UNIT_PARAMETER_INDEX);
		WasNodeUnit node = (WasNodeUnit) parameters.get(NODE_UNIT_PARAMETER_INDEX);
		IProgressMonitor monitor = context.getProgressMonitor();

		//    (B) the node is not a deployment manager node
		if (WasValidationUtil.attributeValueEquals(node, WasPackage.Literals.WAS_NODE__PROFILE_TYPE,
				WasPackage.Literals.WAS_NODE, WasProfileTypeEnum.DMGR_LITERAL, false)) {
			return;
		}

		//    (C) the node is hosted on an ND system (if hosted on any system)
		WasSystem nodeSystem = (WasSystem) ValidatorUtils.discoverHostCapability(node,
				WasPackage.Literals.WAS_SYSTEM, monitor);
		if (null != nodeSystem) {
			if (null != nodeSystem.getWasEdition()) {
				if (!WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL.equals(nodeSystem.getWasEdition())) {
					return;
				}
			}
		}

		//    (D) WAS version is defined on node/cluster and is less than that of the cluster
		String nodeVersion = (String) CapabilityUtil.getAttributeFromUnitCapability(node,
				WasPackage.Literals.WAS_NODE__WAS_VERSION, WasPackage.Literals.WAS_NODE);
		if (null == nodeVersion) {
			return;
		}

		String clusterVersion = (String) CapabilityUtil.getAttributeFromUnitCapability(cluster,
				WasPackage.Literals.WAS_CLUSTER__WAS_VERSION, WasPackage.Literals.WAS_CLUSTER);
		if (null == clusterVersion) {
			return;
		}

		if (clusterVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			if (!nodeVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				return;
			}
		}

		//    (E) the cluster and node are not on/in different cells (will work if no cell is defined or if only one is defined)
		Unit hostCell = ValidatorUtils.discoverHost(cluster, monitor);
		boolean foundCommonCell = false;
		List<Unit> groupCells = ValidatorUtils.discoverGroupsByUnitType(node,
				WasPackage.Literals.WAS_CELL_UNIT, context.getTopology(), monitor);
		for (Unit groupCell : groupCells) {
			if (hostCell == groupCell) {
				foundCommonCell = true;
				break;
			}
		}
		// continue if one cell is not found or if both are the same; ie, we don't insist that the cell be preexisting
		if (null != hostCell && groupCells.size() != 0 && !foundCommonCell) {
			return;
		}

		//    (F) the nodegroup associated with the cluster/of which node is a member is the same node group (will work if there is no node group
		List<Requirement> groupReqs = ValidatorUtils.getRequirements(cluster,
				WasPackage.Literals.WAS_NODE_GROUP);
		if (1 != groupReqs.size()) {
			return;
		}
		Unit clusterGroup = ValidatorUtils
				.discoverDependencyLinkTargetUnit(groupReqs.get(0), monitor);
		boolean foundCommonGroup = false;
		List<Unit> nodeGroups = ValidatorUtils.discoverGroupsByUnitType(node,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getTopology(), monitor);
		for (Unit nodeGroup : nodeGroups) {
//		for (int i = 0; i < nodeGroups.size(); i++) {
			if (clusterGroup == nodeGroup) {
				foundCommonGroup = true;
				break;
			}
		}
		// continue if one cell is not found or if both are the same; ie, we don't insist that the cell be preexisting
		if (null != clusterGroup && nodeGroups.size() != 0 && !foundCommonGroup) {
			return;
		}

		//    (G) permissions exist to make the desired changes
		//    (a) create new server unit from templates
		//    (b) host the server on the node
		//    (c) make the server a member of the cluster

		//    (a) create new server unit from templates
		// can always create a new server using templates

		//    (b) host the server on the node
		if (!node.isPublic()) {
			return;
		}

		//    (c) make the server a member of the cluster
		if (!cluster.isPublic()) {
			return;
		}

		// the preconditions hold; we create an INFO status to trigger the action
		reporter.addStatus(WasValidationUtil.createActionPreconditionValid(getId(),
				WasDomainMessages.Action_Create_New_Cluster_Member_On_Node_0, new Object[] { node
						.getCaptionProvider().title(node) }, cluster, parameters));
	}
}
