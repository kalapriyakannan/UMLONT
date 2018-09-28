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
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Delete a Deployment Manager unit
 */
public class InvalidNumberOfDeploymentManagerUnitsResolutionGenerator extends
		DeployResolutionGenerator {

	private WasNodeUnit _dmgrNode;
	IDeployStatus _status;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {

		_status = context.getDeployStatus();
		_dmgrNode = (WasNodeUnit) _status.getDeployObject();

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();

		List<Unit> dmgrs = ValidatorUtils.getHosted(_dmgrNode,
				WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_UNIT);

		for (Unit curDmgrUnit : dmgrs) {
			if (WasResolutionUtils.canRemoveHostingLink(_dmgrNode, curDmgrUnit)) {
				String message = DeployNLS.bind(
						WasDomainMessages.Resolution_Invalid_Number_Of_Dmgr_Unit, new Object[] {
								_dmgrNode.getCaptionProvider().title(_dmgrNode),
								curDmgrUnit.getCaptionProvider().title(curDmgrUnit) });
				resolutions.add(new InvalidNumberOfDeploymentManagerUnitsResolution(context, this,
						message, _dmgrNode, curDmgrUnit));
			}
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

		// verify problem type
		if (!IWASProblemType.INVALID_NUMBER_DEPLOYMENTMANAGERUNIT_ON_DMGR.equals(status
				.getProblemType())) {
			return false;
		}

		// verify parameters
		DeployModelObject obj = status.getDeployObject();
		if (!WasPackage.Literals.WAS_NODE_UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}
		WasNodeUnit node = (WasNodeUnit) obj;

		// verify that the node hosts at least 2 deployment manager units
		List<Unit> dmgrs = ValidatorUtils.getHosted(node,
				WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_UNIT);
		if (dmgrs.size() < 2) {
			return false;
		}

		// check that the resolution will have the permissions needed to complete its tasks:
		// (a) remove hosting link between node and deployment manager unit
		// hosting link must be in the edit topology
		// must find for at least one of the deployment managers
		for (Unit dmgr : dmgrs) {
			if (WasResolutionUtils.canRemoveHostingLink(node, dmgr)) {
				return true;
			}
		}

		return false;
	}

}
