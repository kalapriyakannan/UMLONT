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
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test for action to refactor a WAS base system into a ND system. See
 * {@link RefactorWasBaseSystemToNDAction}.
 * <p>
 * The preconditions tested for are:
 * <ul>
 * <li>(A) the parameters are defined and of the correct types</li>
 * <li>(B) the system is a base system</li>
 * <li>(C) the node is hosted on the system</li>
 * <li>(D) the cell is hosted on the node</li>
 * <li>(E) if the node is in a node group, it is in only 1 and that nodegroup is in the cell</li>
 * <li>(F) permissions exist to make the desired changes</li>
 * </ul>
 */
public class RefactorWasBaseSystemToNDActionTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	private static final int NUMBER_EXPECTED_PARAMETERS = 3;
	private static final int CELL_UNIT_PARAMETER_INDEX = 0;
	private static final int NODE_UNIT_PARAMETER_INDEX = 1;
	private static final int SYSTEM_UNIT_PARAMETER_INDEX = 2;

	/**
	 * Constructor
	 */
	public RefactorWasBaseSystemToNDActionTest() {
		super(IWasValidatorID.WAS_REFACTOR_WAS_BASE_SYSTEM_TO_ND, new UnitSignature(new EClass[] {
				WasPackage.Literals.WAS_CELL_UNIT, WasPackage.Literals.WAS_NODE_UNIT,
				WasPackage.Literals.WAS_SYSTEM_UNIT }));
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
		if (!WasPackage.Literals.WAS_CELL_UNIT
				.isSuperTypeOf(signature.get(CELL_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		if (!WasPackage.Literals.WAS_NODE_UNIT
				.isSuperTypeOf(signature.get(NODE_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		if (!WasPackage.Literals.WAS_SYSTEM_UNIT.isSuperTypeOf(signature
				.get(SYSTEM_UNIT_PARAMETER_INDEX))) {
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

		WasCellUnit cell = (WasCellUnit) parameters.get(CELL_UNIT_PARAMETER_INDEX);
		WasNodeUnit node = (WasNodeUnit) parameters.get(NODE_UNIT_PARAMETER_INDEX);
		WasSystemUnit wasSystem = (WasSystemUnit) parameters.get(SYSTEM_UNIT_PARAMETER_INDEX);

		//    (B) the system is a base system
		WasEditionEnum edition = (WasEditionEnum) CapabilityUtil.getAttributeFromUnitCapability(
				wasSystem, WasPackage.Literals.WAS_SYSTEM__WAS_EDITION, WasPackage.Literals.WAS_SYSTEM);
		if (null == edition) {
			return;
		}
		if (!WasEditionEnum.BASE_LITERAL.equals(edition)) {
			return;
		}

		//    (C) the node is hosted on the system
		if (ValidatorUtils.getHost(node) == null || !ValidatorUtils.getHost(node).equals(wasSystem)) {
			return;
		}

		//    (D) the cell is hosted on the node
		if (!node.equals(ValidatorUtils.getHost(cell))) {
			return;
		}

		//    (E) if the node is in a node group, it is in only 1 and that nodegroup is in the cell
		//if cellVerion is 6 check if it containes 1(!) node group that contains the node
		//if more than one we don't know which one to use
		String cellVersion = (String) CapabilityUtil.getAttributeFromUnitCapability(cell,
				WasPackage.Literals.WAS_CELL__WAS_VERSION, WasPackage.Literals.WAS_CELL);
		if (null == cellVersion) {
			return;
		}

		if (cellVersion.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			List<Unit> nodegroups = ValidatorUtils.discoverGroupsByUnitType(node,
					WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getTopology(), context
							.getProgressMonitor());
			int ngSize = nodegroups.size();
			// will only suggest something if there is exactly 1 node group
			if (ngSize < 1 || ngSize > 1) {
				return;
			}
			List<Unit> cells = ValidatorUtils.discoverGroupsByUnitType(nodegroups.get(0),
					WasPackage.Literals.WAS_CELL_UNIT, context.getTopology(), context
							.getProgressMonitor());
			if (cells.size() > 1) {
				return;
			}
			if (cells.size() == 1) {
				if (cells.get(0) != cell) {
					return;
				}
			}
		}

		//    (F) permissions exist to make the desired changes
		//   (a) edit wasEdition on wasSystemCap
		//   (b) set isDistributed on wasCellCap if not already
		//   (c) set isManaged to be true if setting isDistributed
		//   (d) unhost cell from node
		//   (e) create new dmgr and new dmgrNode - always valid to do
		//   (f) add new dmgrNode to node group of cell (WAS version 6.* only)
		//   (g) add new dmgrNode to cell
		//   (h) host new dmgr on new dmgrNode - always valid to do
		//   (i) host cell on new dmgrNode
		//   (j) host new dmgrNode on wasSystem

		//   (a) edit wasEdition on wasSystemCap
		InstallState wasSystemInstallState = wasSystem.getInitInstallState();
		if (!wasSystemInstallState.equals(InstallState.NOT_INSTALLED_LITERAL)
				&& !wasSystemInstallState.equals(InstallState.UNKNOWN_LITERAL)) {
			return;
		}
		WasSystem wasSystemCap = (WasSystem) ValidatorUtils.getCapability(wasSystem,
				WasPackage.Literals.WAS_SYSTEM);
//		if (wasSystemCap.getTopology() != wasSystemCap.getEditTopology()) {
//			if (!wasSystemCap.getTopology().getConfigurationContract().isPublicEditable(wasSystemCap,
//					WasPackage.Literals.WAS_SYSTEM__WAS_EDITION.getName())) {
//				return;
//			}
//		}
		if (!wasSystemCap.isPublicEditable(WasPackage.Literals.WAS_SYSTEM__WAS_EDITION.getName())) {
			return;
		}
		if (!DeployModelObjectUtil.isSettable(wasSystemCap,
				WasPackage.Literals.WAS_SYSTEM__WAS_EDITION.getName())) {
			return;
		}

		//   (b) set isDistributed on wasCellCap if not already
		//	if (!cellCap.isIsDistributed() && !cellCap.isMutable()) {
		//		return;
		//	}
		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cell, WasPackage.Literals.WAS_CELL);
		if (!cellCap.isIsDistributed()) {
			InstallState wasCellInstallState = cell.getInitInstallState();
			if (!wasCellInstallState.equals(InstallState.NOT_INSTALLED_LITERAL)
					&& !wasCellInstallState.equals(InstallState.UNKNOWN_LITERAL)) {
				return;
			}
//			if (cellCap.getTopology() != cellCap.getEditTopology()) {
//				if (!cellCap.getTopology().getConfigurationContract().isPublicEditable(cellCap,
//						WasPackage.Literals.WAS_CELL__IS_DISTRIBUTED.getName())) {
//					return;
//				}
//			}
			if (!cellCap.isPublicEditable(WasPackage.Literals.WAS_CELL__IS_DISTRIBUTED.getName())) {
				return;
			}
			if (!DeployModelObjectUtil.isMutable(cellCap, WasPackage.Literals.WAS_CELL__IS_DISTRIBUTED
					.getName())) {
				return;
			}

			//   (c) set isManaged to be true if setting isDistributed
			InstallState wasNodeInstallState = node.getInitInstallState();
			if (!wasNodeInstallState.equals(InstallState.NOT_INSTALLED_LITERAL)
					&& !wasNodeInstallState.equals(InstallState.UNKNOWN_LITERAL)) {
				return;
			}
			WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(node,
					WasPackage.Literals.WAS_NODE);
			if (null == nodeCap) {
				return;
			}
//			if (nodeCap.getTopology() != nodeCap.getEditTopology()) {
//				if (!nodeCap.getTopology().getConfigurationContract().isPublicEditable(nodeCap,
//						WasPackage.Literals.WAS_NODE__IS_MANAGED.getName())) {
//					return;
//				}
//			}
			if (!nodeCap.isPublicEditable(WasPackage.Literals.WAS_NODE__IS_MANAGED.getName())) {
				return;
			}
			if (!DeployModelObjectUtil.isMutable(nodeCap, WasPackage.Literals.WAS_NODE__IS_MANAGED
					.getName())) {
				return;
			}
		}

		//   (d) unhost cell from node
		// if cell and node are in import topology this is not possible
		if (cell.getTopology() != cell.getEditTopology() && node.getTopology() == cell.getTopology()) {
			return;
		}

		//   (e) create new dmgr and new dmgrNode - always valid to do

		//   (f) add new dmgrNode to node group of cell (WAS version 6.* only)
		String wasVersion = cellCap.getWasVersion();
		if (null == wasVersion) {
			return;
		}
		if (wasVersion.endsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			List<Unit> members = ValidatorUtils.getMembers(cell);
			for (Unit currentMember : members) {
//			for (Iterator<Unit> iterator = members.iterator(); iterator.hasNext();) {
//				Unit currentMember = iterator.next();
				if (currentMember instanceof WasNodeGroupUnit) {
//					if (currentMember.getTopology() != currentMember.getEditTopology()
//							&& !currentMember.getTopology().getConfigurationContract().isPublic(
//									currentMember)) {
//						return;
//					}
					if (!currentMember.isPublic()) {
						return;
					}
				}
			}
		}

		//   (g) add new dmgrNode to cell
		if (!cell.isPublic()) {
			return;
		}

		//   (h) host new dmgr on new dmgrNode - always valid to do

		//   (i) host cell on new dmgrNode - determined by test for item (i)

		//   (j) host new dmgrNode on wasSystem
		if (!wasSystem.isPublic()) {
			return;
		}

		// the preconditions hold; we create an INFO status to trigger the action
		reporter.addStatus(WasValidationUtil.createActionPreconditionValid(getId(),
				WasDomainMessages.Action_Refactor_Was_Base_System_To_ND_0, new Object[] { wasSystem },
				cell, parameters));
	}
}
