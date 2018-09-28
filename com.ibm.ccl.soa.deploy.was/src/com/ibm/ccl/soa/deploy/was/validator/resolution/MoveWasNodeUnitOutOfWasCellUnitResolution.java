/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Remove the memberLink between wasCell and wasNode, if there are also memberLinks between wasNode
 * and wasNodeGroup in this wasCell, also remove them.
 * 
 * realize this resolution
 * 
 * @since 3.2
 * 
 */
public class MoveWasNodeUnitOutOfWasCellUnitResolution extends DeployResolution {
	private WasNodeUnit _nodeUnit = null;
	private WasCellUnit _cellUnit = null;
	private WasCell _cellCap = null;

	public MoveWasNodeUnitOutOfWasCellUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, WasNodeUnit nodeUnit) {
		super(context, generator);
		_nodeUnit = nodeUnit;
		_cellCap = WasUtil.getWasCellCap(nodeUnit, nodeUnit.getEditTopology());
		_cellUnit = (WasCellUnit) _cellCap.getParent();
		Object[] params = { _nodeUnit, _cellUnit };

		setDescription(DeployNLS.bind(
				WasDomainMessages.Resolution_move_Was_Node_Unit_0_Out_of_Cell_1, params));
	}

	public IStatus resolve(IProgressMonitor monitor) {
		Iterator memberLinkIt = _cellUnit.getMemberLinks().iterator();
		while (memberLinkIt.hasNext()) {
			MemberLink link = (MemberLink) memberLinkIt.next();
			if (link.getTarget().equals(_nodeUnit)) {
				_cellUnit.getMemberLinks().remove(link);
				//if there is a link between node and nodeGroup, remove it
				List reqL = _nodeUnit.getRequirements();
				for (int i = 0; i < reqL.size(); i++) {
					if (((Requirement) reqL.get(i)).getDmoEType().equals(
							WasPackage.eINSTANCE.getWasNodeGroupUnit())) {
						List nodegroupUnitList = TopologyDiscovererService.INSTANCE.getGroups(_nodeUnit,
								(Requirement) reqL.get(i), _nodeUnit.getTopology());
						if (nodegroupUnitList != null) {
							if (nodegroupUnitList.size() > 0) {
								Iterator ngUnitIt = nodegroupUnitList.iterator();
								while (ngUnitIt.hasNext()) {
									WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) ((UnitDescriptor) ngUnitIt
											.next()).getUnitValue();
									WasCell ngCellCap = WasUtil.getWasCellCap(nodeGroupUnit, _nodeUnit
											.getTopology());
									if (ngCellCap.equals(_cellCap)) {
										//remove the member link between nodegroup and node
										Iterator ngMLIt = nodeGroupUnit.getMemberLinks().iterator();
										while (ngMLIt.hasNext()) {
											MemberLink ngML = (MemberLink) ngMLIt.next();
											if (link.getTarget().equals(_nodeUnit)) {
												nodeGroupUnit.getMemberLinks().remove(ngML);
											}
										}
									}
								}
							}
						}
					}
				}

				return Status.OK_STATUS;
			}
		}
		return context.getDeployStatus();
	}
}
