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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.matcher.WasLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * generate default Node for an empty StandAlone Cell if the Cell is version 6, if there are no
 * default NodeGroup too, generate a default NodeGroup, add the generated default Node to it
 * 
 * generate a default server1 for the Node
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class InsertNodeIntoCellGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		WasCellUnit cellUnit = (WasCellUnit) status.getDeployObject();
		if (cellUnit == null) {
			return new IDeployResolution[0];
		}

		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cellUnit, WasPackage.eINSTANCE
				.getWasCell());
		if (cellCap == null) {
			return new IDeployResolution[0];
		}

		List requireNodeUnitL = ValidatorUtils.getRequirements(cellUnit, WasPackage.eINSTANCE
				.getWasNodeUnit());
		if (requireNodeUnitL == null) {
			return new IDeployResolution[0];
		}

		String validatorID = status.getValidatorID();
		if (IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_001
				.equals(validatorID)) {
			Unit host = ValidatorUtils.getHost(cellUnit);
			if (host != null) {
				assert host instanceof WasNodeUnit;
				WasNodeUnit nodeUnit = (WasNodeUnit) host;
				return nodeUnit.isPublic() ? new IDeployResolution[] { new AddMemberUnitIntoGroupUnitResolution(
						context, this, nodeUnit, cellUnit) }
						: new IDeployResolution[0];
			}
			return new IDeployResolution[] { new CreateDefaultNodeUnitIntoStandAloneCellUnitResolution(
					context, this, cellUnit) };
		} else if (IWasValidatorID.VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_001
				.equals(validatorID)) {
			return new IDeployResolution[] { new CreateDmgrNodeUnitIntoDistributedCellUnitResolution(
					context, this, cellUnit) };
		}

		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		// check problem type
		String problemType = status.getProblemType();
		if (!IWASProblemType.MISSING_DEFAULT_TYPE_WAS_NODE_UNIT_IN_WAS_STANDALONE_CELL
				.equals(problemType)
				&& !IWASProblemType.MISSING_WAS_DMGR_NODE_UNIT_IN_WAS_DISTIRBUTED_CELL
						.equals(problemType)) {
			return false;
		}

		// check input values (expect cell unit)
		DeployModelObject obj = status.getDeployObject();
		if (!WasPackage.Literals.WAS_CELL_UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		// check that there is at least one resolution that will have the necessary 
		// permissions to make the changes that are desired
		// there are three possible resolutions:

		// AddMemberUnitIntoGroupUnitResolution
		//    (a) add a node into the cell 
		// CreateDefaultNodeUnitIntoStandAloneCellUnitResolution
		//    (a) create a default node
		//    (b) make node member of cell 
		//    (c) create default server hosted on node
		// CreateDmgrNodeUnitIntoDistributedCellUnitResolution
		//    (a) create a dmgr node
		//    (b) make node member of cell
		//    (c) create dmgr hosted on node

		// Interestingly, in all cases, the only possible problem is to make the node a member of the cell
		// checking that cell is public is all that is required
		// getResolutions will need to make additional checks (for AddMemberUnitIntoGroupUnitResolution)
		if (obj.isPublic()) {
			return true;
		}

		return false;
	}

	private static class CreateDmgrNodeUnitIntoDistributedCellUnitResolution extends
			DeployResolution {
		private final WasCellUnit _cellUnit;

		public CreateDmgrNodeUnitIntoDistributedCellUnitResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasCellUnit cellUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_create_Dmgr_Was_Node_Unit_for_Distributed_CellUnit_0,
					cellUnit));
			_cellUnit = cellUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			WasCell cellCap = (WasCell) ValidatorUtils.getCapability(_cellUnit, WasPackage.eINSTANCE
					.getWasCell());
			if (cellCap == null) {
				return Status.CANCEL_STATUS;
			}
			Topology top = _cellUnit.getEditTopology();

			String dmgrNodeTemplate = null;
			String dmgrTemplate = null;
			String cellVersion = cellCap.getWasVersion();
			if (cellVersion != null) {
				if (WasUtil.compare2VersionString(cellVersion, WasUtil.WAS_6_MAIN_VERSION) >= 0) {
					dmgrNodeTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_6_DMGR_NODE_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_DMGR_NODE_UNIT;
					dmgrTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_6_DMGR_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_DMGR_UNIT;
				} else if (WasUtil.compare2VersionString(cellVersion, WasUtil.WAS_5_MAIN_VERSION) < 0) {
					return Status.CANCEL_STATUS;
				} else {
					dmgrNodeTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT;
					dmgrTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_5_DMGR_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_DMGR_UNIT;
				}
			}

			WasNodeUnit dmgrNodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(dmgrNodeTemplate,
					top);
			if (null == dmgrNodeUnit) {
				return Status.CANCEL_STATUS;
			}
			dmgrNodeUnit
					.setDescription(WasDomainMessages.Resolution_create_deployment_manager_node_description);
			WasDeploymentManagerUnit dmgrUnit = (WasDeploymentManagerUnit) ResolutionUtils
					.addFromTemplate(dmgrTemplate, top);
			if (null == dmgrUnit) {
				return Status.CANCEL_STATUS;
			}
			dmgrUnit
					.setDescription(WasDomainMessages.Resolution_create_deployment_manager_description);
			LinkFactory.createHostingLink(dmgrNodeUnit, dmgrUnit, new WasLinkDescriptorFactory());

			LinkFactory.createMemberLink(_cellUnit, dmgrNodeUnit);

			return Status.OK_STATUS;
		}

	}

	private static class CreateDefaultNodeUnitIntoStandAloneCellUnitResolution extends
			DeployResolution {
		private final WasCellUnit _cellUnit;

		public CreateDefaultNodeUnitIntoStandAloneCellUnitResolution(
				IDeployResolutionContext context, IDeployResolutionGenerator generator,
				WasCellUnit cellUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_create_Default_Was_Node_Unit_for_StandAlone_CellUnit_0,
					cellUnit.getName()));
			_cellUnit = cellUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			WasCell cellCap = (WasCell) ValidatorUtils.getCapability(_cellUnit, WasPackage.eINSTANCE
					.getWasCell());
			if (cellCap == null) {
				return null;
			}
			Topology top = _cellUnit.getEditTopology();

			String cellVersion = cellCap.getWasVersion();
			String nodeTemplate = null;
			String serverTemplate = null;
			if (cellVersion != null) {
				if (WasUtil.compare2VersionString(cellVersion, WasUtil.WAS_6_MAIN_VERSION) >= 0) {
					nodeTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_6_NODE_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_NODE_UNIT;
					serverTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT;
				} else if (WasUtil.compare2VersionString(cellVersion, WasUtil.WAS_5_MAIN_VERSION) < 0) {
					return Status.CANCEL_STATUS;
				} else {
					nodeTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_5_NODE_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_NODE_UNIT;
					serverTemplate = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT;
				}
			}

			WasNodeUnit defaultNodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(nodeTemplate,
					top);
			if (null == defaultNodeUnit) {
				return Status.CANCEL_STATUS;
			}
			defaultNodeUnit.setDescription(WasDomainMessages.Resolution_create_node_description);

			WebsphereAppServerUnit defaultServerUnit = (WebsphereAppServerUnit) ResolutionUtils
					.addFromTemplate(serverTemplate, top);
			if (null == defaultServerUnit) {
				return Status.CANCEL_STATUS;
			}
			defaultServerUnit.setDescription(WasDomainMessages.Resolution_create_server_description);
			WasServer serverCap = (WasServer) ValidatorUtils.getFirstCapability(defaultServerUnit,
					WasPackage.Literals.WAS_SERVER);
			if (serverCap != null) {
				serverCap.setWasVersion(cellVersion);
			}

			LinkFactory.createHostingLink(defaultNodeUnit, defaultServerUnit,
					new WasLinkDescriptorFactory());

			LinkFactory.createMemberLink(_cellUnit, defaultNodeUnit);

			return Status.OK_STATUS;
		}

	}

}
