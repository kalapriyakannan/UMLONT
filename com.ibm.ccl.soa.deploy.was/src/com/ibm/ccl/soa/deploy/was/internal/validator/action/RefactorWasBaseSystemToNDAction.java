/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

public class RefactorWasBaseSystemToNDAction extends DeployResolution {

	WasCellUnit _cell;
	WasNodeUnit _node;
	WasSystemUnit _wasSystem;

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
	public RefactorWasBaseSystemToNDAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_cell = (WasCellUnit) parameters.get(0);
		_node = (WasNodeUnit) parameters.get(1);
		_wasSystem = (WasSystemUnit) parameters.get(2);

	}

	public IStatus resolve(IProgressMonitor monitor) {

		Topology topo = _cell.getEditTopology();
		WasNodeUnit dmgrNode = null;
		WasDeploymentManagerUnit dmgr = null;

		//change wasSystem from base to nd
		WasSystem wasSystemCap = (WasSystem) ValidatorUtils.getCapability(_wasSystem,
				WasPackage.Literals.WAS_SYSTEM);
		wasSystemCap.setWasEdition(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);

		//if cell is not distributed change it to distributed
		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(_cell, WasPackage.Literals.WAS_CELL);
		if (!cellCap.isIsDistributed()) {
			cellCap.setIsDistributed(true);
			//set node to be managed
			WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(_node,
					WasPackage.Literals.WAS_NODE);
			nodeCap.setIsManaged(true);
		}

		//unhost cell from node
		ResolutionUtils.unhost(_node, _cell);

		//add Dmgr and DmgrUnit dependent on the WasSystem
		String wasVersion = cellCap.getWasVersion();
		if (wasVersion.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
//		if (wasVersion.endsWith("6.0")) { //$NON-NLS-1$
			String dmgrNodeTemplateId = _cell.isConceptual() ? IWasTemplateConstants.WAS_6_DMGR_NODE_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_6_DMGR_NODE_UNIT;
			String dmgrTemplateId = _cell.isConceptual() ? IWasTemplateConstants.WAS_6_DMGR_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_6_DMGR_UNIT;
			dmgrNode = (WasNodeUnit) ResolutionUtils.addFromTemplate(dmgrNodeTemplateId, topo);
			dmgr = (WasDeploymentManagerUnit) ResolutionUtils.addFromTemplate(dmgrTemplateId, topo);
			List<Unit> member = ValidatorUtils.getMembers(_cell);
			for (Iterator<Unit> iterator = member.iterator(); iterator.hasNext();) {
				Unit currentMember = iterator.next();
				if (currentMember instanceof WasNodeGroupUnit) {
					ResolutionUtils.group(currentMember, dmgrNode);
					break;
				}
			}
		} else {
			String dmgrNodeTemplateId = _cell.isConceptual() ? IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT;
			String dmgrTemplateId = _cell.isConceptual() ? IWasTemplateConstants.WAS_5_DMGR_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_5_DMGR_UNIT;
			dmgrNode = (WasNodeUnit) ResolutionUtils.addFromTemplate(dmgrNodeTemplateId, topo);
			dmgr = (WasDeploymentManagerUnit) ResolutionUtils.addFromTemplate(dmgrTemplateId, topo);
		}

		//add dmgr to cell
		ResolutionUtils.group(_cell, dmgrNode);

		//host dmgr on dmgrNode
		ResolutionUtils.host(dmgrNode, dmgr);

		//host cell on Dmgr
		ResolutionUtils.host(dmgrNode, _cell);

		//host dmgr on wasSystem
		ResolutionUtils.host(_wasSystem, dmgrNode);

		return Status.OK_STATUS;
	}
}
