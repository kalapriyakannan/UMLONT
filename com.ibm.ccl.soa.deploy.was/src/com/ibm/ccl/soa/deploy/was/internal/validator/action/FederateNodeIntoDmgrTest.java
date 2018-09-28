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

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test for action to federate a {@link WasNodeUnit} into a distributed
 * {@link WasCellUnit}. See {@link FederateNodeIntoDmgrAction}.
 * <p>
 * The preconditions tested for are:
 * <ul>
 * <li>(A) the parameters are defined and of the correct types</li>
 * <li>(B) first node is stand alone</li>
 * <li>(C) second node is a deployment manager node</li>
 * <li>(D) check that first node isn't already managed by a deployment manager</li>
 * <li>(E) WAS version is defined on node (& dmgr node) and is less than that of the dmgr node</li>
 * <li>(F) deployment manager node is hosted on a ND system (if hosted)
 * <li>(G) permissions exist to make the desired changes</li>
 * </ul>
 */
// check that dmgrNode is contained in a cell
public class FederateNodeIntoDmgrTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	private static final int NUMBER_EXPECTED_PARAMETERS = 2;
	private static final int NODE_UNIT_PARAMETER_INDEX = 0;
	private static final int DMGR_NODE_UNIT_PARAMETER_INDEX = 1;

//	private final WasNodeToWasNodeFederateMatcher _federateNodeMatcher = new WasNodeToWasNodeFederateMatcher();

	/**
	 * Constructor
	 */
	public FederateNodeIntoDmgrTest() {
		super(IWasValidatorID.WAS_FEDERATE_NODE_TEST_001, new UnitSignature(new EClass[] {
				WasPackage.Literals.WAS_NODE_UNIT, WasPackage.Literals.WAS_NODE_UNIT }));
	}

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
		if (!WasPackage.Literals.WAS_NODE_UNIT
				.isSuperTypeOf(signature.get(NODE_UNIT_PARAMETER_INDEX))) {
			return false;
		}
		if (!WasPackage.Literals.WAS_NODE_UNIT.isSuperTypeOf(signature
				.get(DMGR_NODE_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		return true;
	}

	@Override
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter) {

		// (A) the parameters are defined and of the correct types
		if (!appliesTo(parameters)) {
			return;
		}

		// extract parameters
		WasNodeUnit unmanagedNode = (WasNodeUnit) parameters.get(NODE_UNIT_PARAMETER_INDEX);
		WasNodeUnit dmgrNode = (WasNodeUnit) parameters.get(DMGR_NODE_UNIT_PARAMETER_INDEX);

		//  (B) first node is default profile alone</li>
		if (!WasValidationUtil.attributeValueEquals(unmanagedNode,
				WasPackage.Literals.WAS_NODE__PROFILE_TYPE, WasPackage.Literals.WAS_NODE,
				WasProfileTypeEnum.DEFAULT_LITERAL, false)) {
			return;
		}

		//  (C) second node is a deployment manager node</li>
		if (!WasValidationUtil.attributeValueEquals(dmgrNode,
				WasPackage.Literals.WAS_NODE__PROFILE_TYPE, WasPackage.Literals.WAS_NODE,
				WasProfileTypeEnum.DMGR_LITERAL, false)) {
			return;
		}

		// check that dmgrNode is contained in a cell
		if (WasValidationUtil.getWasCell(dmgrNode) == null) {
			return;
		}

		// check that unmanagedNode isn't already managed by a dmgr
		if (!WasValidationUtil.attributeValueEquals(unmanagedNode,
				WasPackage.Literals.WAS_NODE__IS_MANAGED, WasPackage.Literals.WAS_NODE, Boolean.FALSE,
				false)) {
			return;
		}

		//    (D) WAS version is defined on node (& dmgr node) and is less than that of the dmgr node
		WasNode unmanagedNodeCap = (WasNode) ValidatorUtils.getCapabilities(unmanagedNode,
				WasPackage.Literals.WAS_NODE).get(0);
		String unmanagedVersion = unmanagedNodeCap.getWasVersion();
		if (null == unmanagedVersion) {
			return;
		}
		WasNode dmgrNodeCap = (WasNode) ValidatorUtils.getCapabilities(dmgrNode,
				WasPackage.Literals.WAS_NODE).get(0);
		if (null == dmgrNodeCap) {
			return;
		}
		String dmgrVersion = dmgrNodeCap.getWasVersion();
		if (null == dmgrVersion) {
			return;
		}
		if (dmgrVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			if (!unmanagedVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				return;
			}
		}

		// If unmanaged node's cell is proxied, node can't be removed from its cell. 
		// Invalid test if link was created in edit topology. 
//		if (ValidatorUtils.isProxy(WasValidationUtil.getWasCell(dmgrNode))) {
//			return;
//		}

		// This tests that the isManaged boolean can be set on the unmanaged node.
		if (unmanagedNodeCap != null
				&& !DeployModelObjectUtil.isSettable(unmanagedNodeCap, WasPackage.eINSTANCE
						.getWasNode_IsManaged())) {
			return;
		}

		// (F) deployment manager node is hosted on a ND system (if hosted)
		Unit system = ValidatorUtils.discoverHost(dmgrNode, WasPackage.Literals.WAS_SYSTEM_UNIT,
				context.getProgressMonitor());
		if (null != system) {
			if (!WasValidationUtil.attributeValueEquals(system,
					WasPackage.Literals.WAS_SYSTEM__WAS_EDITION, WasPackage.Literals.WAS_SYSTEM,
					WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL, false)) {
				return;
			}
		}

		// (G) permissions exist to make the desired changes</li>
		//    (a) remove unmanaged node from its cell
		//    (b) remove unmanaged node from its node groups
		//    (c) delete cell if it was hosted on the node
		//    (d) delete node group if is empty
		//    (e) add node to dmgr cell
		//    (f) add node to (first) node group if one exists

		Topology editTopology = unmanagedNode.getEditTopology();

		//    (a) remove unmanaged node from its cell
		// Can only do so if the cell is in the current edit topology
		Unit unmanagedCell = ValidatorUtils.discoverGroupByUnitType(unmanagedNode,
				WasPackage.Literals.WAS_CELL_UNIT, context.getProgressMonitor());
		if (null != unmanagedCell && unmanagedCell.getTopology() != editTopology) {
			return;
		}

		//    (b) remove unmanaged node from its node groups
		// Can only do so if the node groups are in the current edit topology
		List<Unit> nodeGroups = ValidatorUtils.discoverGroupsByUnitType(unmanagedNode,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, unmanagedNode.getEditTopology(), context
						.getProgressMonitor());
		for (Unit ng : nodeGroups) {
			if (ng.getTopology() != editTopology) {
				return;
			}
		}

		//    (c) delete cell if it was hosted on the node
		// Can only do so if the cell is in the current edit topology
		// Already checked by (a) above

		//    (d) delete node group if is empty
		// Can only do so if the node group is in the current edit topology
		// Already checked by (b) above

		//    (e) add node to dmgr cell
		// dmgr cell (if it exists) must be public
		Unit dmgrCell = ValidatorUtils.discoverGroupByUnitType(dmgrNode,
				WasPackage.Literals.WAS_CELL_UNIT, context.getProgressMonitor());
		if (null != dmgrCell && !dmgrCell.isPublic()) {
			return;
		}

		//    (f) add node to (first) node group if one exists
		// There is a node group that is public
		List<Unit> dmgrNodeGroups = ValidatorUtils.discoverGroupsByUnitType(unmanagedNode,
				WasPackage.Literals.WAS_NODE_GROUP_UNIT, unmanagedNode.getEditTopology(), context
						.getProgressMonitor());
		boolean foundPublicGroup = dmgrNodeGroups.size() == 0;
		for (Unit ng : dmgrNodeGroups) {
			if (ng.isPublic()) {
				foundPublicGroup = true;
			}
		}
		if (!foundPublicGroup) {
			return;
		}

		// the preconditions hold; we create an INFO status to trigger the action
		reporter.addStatus(WasValidationUtil.createActionPreconditionValid(getId(),
				WasDomainMessages.Action_Federate_Node_To_Cell_0, new Object[] { dmgrNode
						.getCaptionProvider().title(dmgrNode) }, unmanagedNode, parameters));
//		}
	}

}
