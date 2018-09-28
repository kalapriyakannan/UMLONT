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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Resolution generator and resolutions for adding a WAS member ({@link WasNodeGroupUnit} or
 * {@link WasNodeUnit}) to a required group ({@link WasCellUnit} or {@link WasNodeGroupUnit})
 * when not already in one.
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class GenerateGroupUnitFromTemplateResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();
		Topology top = dmo.getEditTopology();
		if (top == null) {
			return new DeployResolution[0];
		}

		Unit memberUnit = (Unit) dmo.getParent().getParent();

		if (memberUnit instanceof WasNodeGroupUnit) {
			return new IDeployResolution[] {
					new CreateCellUnitFromTemplateforNGUnitResolution(context, this,
							(WasNodeGroupUnit) memberUnit, true, top),
					new CreateCellUnitFromTemplateforNGUnitResolution(context, this,
							(WasNodeGroupUnit) memberUnit, false, top) };
			// MK 8/23/2007: server is not a member of node
//		} else if (memberUnit instanceof WebsphereAppServerUnit) {
//			return new DeployResolution[] { new CreateCustomNodeUnitFromTemplateforServerUnitResolution(
//					context, this, (WebsphereAppServerUnit) memberUnit) };
		} else if (memberUnit instanceof WasNodeUnit) {
			WasNodeUnit nodeUnit = (WasNodeUnit) memberUnit;
			WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit,
					WasPackage.Literals.WAS_NODE);
			Constraint c = (Constraint) dmo;
			Requirement req = (Requirement) c.getParent();
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
//			RequirementExpression re = (RequirementExpression) dmo;
//			Requirement req = (Requirement) re.getParent();
			WasSystem wasSystem = (WasSystem) ValidatorUtils.getHostCapability(nodeUnit,
					WasPackage.Literals.WAS_SYSTEM);
			boolean isBaseSystem = wasSystem == null ? false
					: wasSystem.getWasEdition() == WasEditionEnum.BASE_LITERAL;
			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasCellUnit())) {
				// Problem: WAS node is not a member of a WAS cell

				// Web nodes cannot create new cells
				if (nodeCap.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
					return new DeployResolution[] { new AddWasNodeToSystemCellResolution(context, this,
							nodeUnit) };
				}

				// Base nodes can only belong to a local standalone cell
				if (isBaseSystem) {
					return new DeployResolution[] { new CreateCellUnitFromTemplateforNodeUnitResolution(
							context, this, nodeUnit, false) };
				}

				// Find all existing distributed cells in the topology
				List<Unit> candiCellUnit = new ArrayList<Unit>();
				for (Iterator<Unit> iter = ValidatorUtils.findAllInstances(top,
						WasPackage.Literals.WAS_CELL_UNIT); iter.hasNext();) {
					Unit candidateCellUnit = iter.next();
					if (candidateCellUnit instanceof WasCellUnit
							&& isCandidateGroupCellUnit4NodeUnit(nodeUnit,
									(WasCellUnit) candidateCellUnit, top)) {
						candiCellUnit.add(candidateCellUnit);
					}
				}

				List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
				if (nodeCap != null
						&& WasProfileTypeEnum.DEFAULT_LITERAL.equals(nodeCap.getProfileType())) {
					resolutions.add(new CreateCellUnitFromTemplateforNodeUnitResolution(context, this,
							nodeUnit, false));
				}

				resolutions.add(new CreateCellUnitFromTemplateforNodeUnitResolution(context, this,
						nodeUnit, true));
				for (Unit cellUnit : candiCellUnit) {
					if (cellUnit.isPublic()) {
						resolutions.add(new AddMemberUnitIntoGroupUnitResolution(context, this,
								memberUnit, cellUnit));
					}
				}
				return resolutions.toArray(new IDeployResolution[resolutions.size()]);
			} else if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasNodeGroupUnit())) {
				// Problem: was node was not member of node group
				List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
				WasCellUnit cellUnit = (WasCellUnit) ValidatorUtils.discoverGroupByUnitType(nodeUnit,
						WasPackage.Literals.WAS_CELL_UNIT, context.getProgressMonitor());
				if (null != cellUnit) {
					List<Unit> nodeGroups = ValidatorUtils.discoverMembers(cellUnit,
							WasPackage.Literals.WAS_NODE_GROUP_UNIT, context.getProgressMonitor());
					for (Unit nodeGroupUnit : nodeGroups) {
						if (nodeGroupUnit.isPublic()) {
							resolutions.add(new AddMemberUnitIntoGroupUnitResolution(context, this,
									nodeUnit, nodeGroupUnit));
						}
					}
				}
				resolutions.add(new CreateNodeGroupUnitFromTemplateforNodeUnitResolution(context, this,
						nodeUnit, top));

				return resolutions.toArray(new IDeployResolution[resolutions.size()]);
			}
		}

		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();

		// verify problem type (cf. plugin.xml)
		if (!ICoreProblemType.GROUP_IN_CARDINALITY_INVALID.equals(status.getProblemType())) {
			return false;
		}

		// check parameters
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
		if (dmo == null || !(dmo instanceof GroupCardinalityConstraint)) {
//		if (dmo == null || !(dmo instanceof RequirementExpression)) {
			return false;
		}

// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
		GroupCardinalityConstraint gcc = (GroupCardinalityConstraint) dmo;
//		RequirementExpression re = (RequirementExpression) dmo;
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
		if (gcc.getMinValue() == null || gcc.getMaxValue() == null) {
//		if (re.getValue() == null) {
			return false;
		}

// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
		Requirement req = (Requirement) gcc.getParent();
//		Requirement req = (Requirement) re.getParent();
		Unit target = (Unit) req.getParent();
		Topology top = gcc.getEditTopology();
//		Topology top = re.getEditTopology();
		if (top == null) {
			return false;
		}

		if (target instanceof WasNodeGroupUnit) {
			assert req.getDmoEType().equals(WasPackage.eINSTANCE.getWasCellUnit());
			if (WasUtil.getWasCellCap((WasNodeGroupUnit) target, top) == null) {
				// check that at least one resolution will have permissions needed to complete:
				// (a) create cell from template; can always add to edit topology
				// (b) make node group member of new cell; node group must be public
				return target.isPublic();
			}
			// MK: 8/23/2007: server not member of a group; has no membership requirements
//		} else if (target instanceof WebsphereAppServerUnit) {
//			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
//				if (WasUtil.getWasNodeCap((WebsphereAppServerUnit) target, top) == null) {
//					return true;
//				}
//			}
		} else if (target instanceof WasNodeUnit) {
			// re may be for cell or for node group
			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasCellUnit())
					&& WasUtil.getWasCellCap((WasNodeUnit) target, top) == null) {
				// check that at least one resolution will have permissions needed to complete:
				// AddWasNodeToSystemCellResolution (nodeCap.getProfileType() == WasProfileTypeEnum.NONE_LITERAL)
				//   (a) add node as member of existing cell
				//   (b) set node attribute 'profileName'
				//   (c) set node attribute 'profileLocation'
				// CreateCellUnitFromTemplateforNodeUnitResolution
				//   (a) create new cell unit; can always do in edit topology
				//   (b) add node as member of new cell unit; node must be public
				//   (c) set node attriube 'isManaged'
				// AddMemberUnitIntoGroupUnitResolution
				//   (a) add node as member of existing cell; node and cell must be public

				// AddWasNodeToSystemCellResolution is called exclusively when node profile type is NONE; check all conditions
				// otherwise all others can be called; for them check common conditions; getResolution must check specific conditions
				WasNode nodeCap = (WasNode) ValidatorUtils.getFirstCapability(target,
						WasPackage.Literals.WAS_NODE);
				if (null == nodeCap) {
					return false;
				}
				if (WasProfileTypeEnum.NONE_LITERAL.equals(nodeCap.getProfileType())) {
					if (!DeployModelObjectUtil.isSettable(nodeCap,
							WasPackage.Literals.WAS_NODE__PROFILE_NAME)) {
						return false;
					}
					if (!DeployModelObjectUtil.isSettable(nodeCap,
							WasPackage.Literals.WAS_NODE__PROFILE_LOCATION)) {
						return false;
					}
				}
				return target.isPublic();
			}

			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasNodeGroupUnit())
					&& WasUtil.getWasNodeGroupCap((WasNodeUnit) target, top) == null) {
				// check that at least one resolution will have permissions needed to complete:
				// AddMemberUnitIntoGroupUnitResolution
				//   (a) create member link between node and node group in same cell as node (node and node group public)
				// CreateNodeGroupUnitFromTemplateforNodeUnitResolution
				//   (a) create node group (can in edit topology)
				//   (b) create member link between node and new node group (node public)
				// check common conditions that must hold; getResolution must check specific conditions
				return target.isPublic();
			}
		}

		return false;
	}

	private static boolean isCandidateGroupCellUnit4NodeUnit(WasNodeUnit nodeUnit,
			WasCellUnit cellUnit, Topology top) {
		if (nodeUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			return false;
		}

		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cellUnit,
				WasPackage.Literals.WAS_CELL);
		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit,
				WasPackage.Literals.WAS_NODE);

		if (cellUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			if (cellCap == null) {
				return false;
			}
			if (cellCap.isIsDistributed() == false) {
				return false;
			}
			if (nodeCap == null) {
				return true;
			}
			if (nodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
				return false;
			}
			return true;
		}

		if (cellCap == null) {
			return true;
		}
		List nodesInCell = WasUtil.getWasNodeCapsFromCellUnit(cellUnit, top);
		if (nodeCap == null && (nodesInCell == null || nodesInCell.size() < 1)) {
			return true;
		}
		if (nodeCap == null && cellCap.isIsDistributed() == true) {
			return true;
		}
		if (nodeCap == null) {
			return false;
		}
		if (cellCap.isIsDistributed() == false && nodesInCell.size() > 0) {
			return false;
		}
		String nodeVersion = nodeCap.getWasVersion();
		String cellVersion = cellCap.getWasVersion();
		if (nodeVersion == null || nodeVersion.length() <= 0 || cellVersion == null
				|| cellVersion.length() <= 0) {
			return true;
		}
		if (WasUtil.compare2VersionString(nodeVersion, cellVersion) >= 0) {
			return true;
		}

		return false;
	}

	private static class CreateNodeGroupUnitFromTemplateforNodeUnitResolution extends
			DeployResolution {
		private final WasNodeUnit _nodeUnit;
		private final Topology _top;

		public CreateNodeGroupUnitFromTemplateforNodeUnitResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasNodeUnit nodeUnit, Topology top) {
			super(context, generator, WasDomainMessages.Resolution_create_required_node_group);
			_nodeUnit = nodeUnit;
			_top = top;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			String ngTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT;
			WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) ResolutionUtils.addFromTemplate(
					ngTemplate, _top);
			if (nodeGroupUnit == null) {
				return Status.CANCEL_STATUS;
			}

			LinkFactory.createMemberLink(nodeGroupUnit, _nodeUnit);

			// if node is in a cell, add the new node group to the cell
			WasCellUnit cellUnit = (WasCellUnit) ValidatorUtils.discoverGroupByUnitType(_nodeUnit,
					WasPackage.Literals.WAS_CELL_UNIT, monitor);
			if (cellUnit != null && cellUnit.isPublic()) {
				LinkFactory.createMemberLink(cellUnit, nodeGroupUnit);
			}
			return Status.OK_STATUS;
		}
	}

	private static class CreateCellUnitFromTemplateforNodeUnitResolution extends DeployResolution {
		private final WasNodeUnit _nodeUnit;
		private final boolean _distributed;

		public CreateCellUnitFromTemplateforNodeUnitResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasNodeUnit nodeUnit, boolean distributed) {
			super(context, generator,
					distributed ? WasDomainMessages.Resolution_create_required_distributed_cell
							: WasDomainMessages.Resolution_create_required_standalone_cell);
			_nodeUnit = nodeUnit;
			_distributed = distributed;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(_nodeUnit,
					WasPackage.Literals.WAS_NODE);
			assert nodeCap != null;
			String cellTemplate = null;
			if (nodeCap.getWasVersion().startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				if (_distributed) {
					cellTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_5_DISTRIBUTED_CELL_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_DISTRIBUTED_CELL_UNIT;
				} else {
					cellTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_5_STANDALONE_CELL_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_STANDALONE_CELL_UNIT;
				}
			} else {
				if (_distributed) {
					cellTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_6_DISTRIBUTED_CELL_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_DISTRIBUTED_CELL_UNIT;
				} else {
					cellTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT;
				}
			}
			WasCellUnit cellUnit = (WasCellUnit) ResolutionUtils.addFromTemplate(cellTemplate, nodeCap
					.getTopology());
			if (cellUnit == null) {
				return Status.CANCEL_STATUS;
			}

			LinkFactory.createMemberLink(cellUnit, _nodeUnit);

			if (!nodeCap.isIsManaged()) {
				nodeCap.setIsManaged(true);
			}
			return Status.OK_STATUS;

		}

	}

	private static class CreateCellUnitFromTemplateforNGUnitResolution extends DeployResolution {
		private final WasNodeGroupUnit _ngUnit;
		private final boolean _distributed;
		private final Topology _top;

		public CreateCellUnitFromTemplateforNGUnitResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasNodeGroupUnit ngUnit, boolean distributed,
				Topology top) {
			super(context, generator,
					distributed ? WasDomainMessages.Resolution_create_required_distributed_cell
							: WasDomainMessages.Resolution_create_required_standalone_cell);
			_ngUnit = ngUnit;
			_distributed = distributed;
			_top = top;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			String cellTemplate = null;
			if (_distributed) {
				cellTemplate = _ngUnit.isConceptual() ? IWasTemplateConstants.WAS_6_DISTRIBUTED_CELL_UNIT_CONCEPTUAL
						: IWasTemplateConstants.WAS_6_DISTRIBUTED_CELL_UNIT;
			} else {
				cellTemplate = _ngUnit.isConceptual() ? IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT_CONCEPTUAL
						: IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT;
			}
			WasCellUnit cellUnit = (WasCellUnit) ResolutionUtils.addFromTemplate(cellTemplate, _top);
			if (cellUnit == null) {
				return Status.CANCEL_STATUS;
			}
//			WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cellUnit,
//					WasPackage.Literals.WAS_CELL);
//			assert cellCap != null;

			LinkFactory.createMemberLink(cellUnit, _ngUnit);

			return Status.OK_STATUS;
		}

	}

}
