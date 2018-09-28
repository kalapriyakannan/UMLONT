/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generator for resolutions to make units public.
 */
public class MakeUnitPublicResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		String description = DeployCoreMessages.Resolution_Make_Unit_Public;

		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		return new IDeployResolution[] { new MakeObjectPublicResolution(context, this, description,
				unit) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!ICoreProblemType.UNIT_NOT_HOSTED.equals(status.getProblemType())) {
			return false;
		}

		// this resolution works on units only
		DeployModelObject object = status.getDeployObject();
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(object.getEObject().eClass())) {
			return false;
		}
		Unit unit = (Unit) object;

		// make sure that the unit is in a topology and that the contract is present
		if (null == unit.getTopology() || null == unit.getTopology().getConfigurationContract()) {
			return false;
		}

		// cannot change contract if not in current edit topology
		if (unit.getTopology() != unit.getEditTopology()) {
			return false;
		}

		// if it is already public then nothing to do
		if (unit.getTopology().getConfigurationContract().isPublic(unit)
				|| unit.getTopology().getConfigurationContract().isPublicEditable(unit)) {
			return false;
		}

		return true;
	}

}
