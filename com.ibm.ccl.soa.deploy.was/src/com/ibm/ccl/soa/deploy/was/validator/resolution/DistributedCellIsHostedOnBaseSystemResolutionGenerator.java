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

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

// TODO split into 2 resolution generators to make this logic simpler
public class DistributedCellIsHostedOnBaseSystemResolutionGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		WasCellUnit wasCell = (WasCellUnit) status.getDeployObject();

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		// create frist resolution to unhost the cell from the Base System
		// need to check if can actually implement the resolution first
		if (checkUnhostDistributedCellFromBaseSystemResolution(wasCell)) {
			String message1 = DeployNLS.bind(
					WasDomainMessages.Resolution_unhost_distributed_was_cell_from_base_system,
					new Object[] { wasCell.getCaptionProvider().title(wasCell) });

			resolutions.add(new UnhostDistributedCellFromBaseSystemResolution(context, this, message1,
					wasCell));
		}

		// create second resolution to change cell from distributed to non-distributed
		// need to check if can set it
		if (checkDistributedCellIsHostedOnBaseSystemResolution(wasCell)) {
			String message2 = DeployNLS.bind(WasDomainMessages.Resolution_undistribute_was_cell_0,
					new Object[] { wasCell.getCaptionProvider().title(wasCell) });

			resolutions.add(new DistributedCellIsHostedOnBaseSystemResolution(context, this, message2,
					wasCell));
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		if (!IWASProblemType.DISTRIBUTED_WAS_CELL_UNIT_HOSTED_ON_BASE_SYSTEM.equals(status
				.getProblemType())) {
			return false;
		}

		if (!WasPackage.Literals.WAS_CELL_UNIT.isSuperTypeOf(status.getDeployObject().getEObject()
				.eClass())) {
			return false;
		}

		WasCellUnit cellUnit = (WasCellUnit) status.getDeployObject();

		// can't make either change if the unit is installed
		if (InstallState.INSTALLED_LITERAL.equals(cellUnit.getInitInstallState())) {
			return false;
		}

		// there are two resolutions offered that:
		//  a) unhost the cell from the hosting node (UnhostDistributedCellFromBaseSystemResolution)
		//  b) make the cell be non-distributed (DistributedCellIsHostedOnBaseSystemResolution)
		// the conditions for either need to hold before we can allow it

		// UnhostDistributedCellFromBaseSystemResolution
		if (checkUnhostDistributedCellFromBaseSystemResolution(cellUnit)) {
			return true;
		}

		// DistributedCellIsHostedOnBaseSystemResolution
		if (checkDistributedCellIsHostedOnBaseSystemResolution(cellUnit)) {
			return true;
		}

		return false;
	}

	private boolean checkUnhostDistributedCellFromBaseSystemResolution(WasCellUnit cellUnit) {
		Unit host = ValidatorUtils.getHost(cellUnit);
		if (null == host) {
			return false;
		}

		// hosting link must be in edit topology
		List<HostingLink> hLinks = host.getHostingLinks();
		for (HostingLink link : hLinks) {
			if (link.getTarget() == cellUnit) {
				if (link.getTopology() == link.getEditTopology()) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	private boolean checkDistributedCellIsHostedOnBaseSystemResolution(WasCellUnit cellUnit) {
		return DeployModelObjectUtil.isSettable(cellUnit,
				WasPackage.Literals.WAS_CELL__IS_DISTRIBUTED);
	}
}
