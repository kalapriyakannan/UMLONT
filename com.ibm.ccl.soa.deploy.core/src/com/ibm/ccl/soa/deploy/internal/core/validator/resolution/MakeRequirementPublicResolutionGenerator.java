/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generator for resolutions to make requirement public.
 */
public class MakeRequirementPublicResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		DeployModelObject object = context.getDeployStatus().getDeployObject();

		String description = DeployNLS.bind(DeployCoreMessages.Resolution_Make_Requirement_Public,
				new Object[] { object.getDisplayName() });

		IDeployResolution resolution1 = new MakeObjectPublicResolution(context, this, description,
				object);

		IDeployResolution resolution2 = null;
		DeployModelObject parent = object.getParent();
		if (null != parent) {
			if (parent.getTopology() == object.getTopology()) {
				ConfigurationContract contract = object.getTopology().getConfigurationContract();
				if (null != contract) {
					if (!contract.isPublic(parent) && !contract.isPublicEditable(parent)) {
						resolution2 = new MakeObjectPublicResolution(context, this,
								DeployCoreMessages.Resolution_Make_Unit_Public, parent);
					}
				}
			}
		}
		if (resolution2 == null) {
			return new IDeployResolution[] { resolution1 };
		}
		return new IDeployResolution[] { resolution1, resolution2 };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED.equals(status.getProblemType())) {
			return false;
		}

		// this resolution works on units only
		DeployModelObject object = status.getDeployObject();
		if (!CorePackage.Literals.REQUIREMENT.isSuperTypeOf(object.getEObject().eClass())) {
			return false;
		}

		// make sure that the unit is in a topology and that the contract is present
		if (null == object.getTopology() || null == object.getTopology().getConfigurationContract()) {
			return false;
		}

		// cannot change contract if not in current edit topology
		if (object.getTopology() != object.getEditTopology()) {
			return false;
		}

		// if it is already public then nothing to do
		if (object.getTopology().getConfigurationContract().isPublic(object)
				|| object.getTopology().getConfigurationContract().isPublicEditable(object)) {
			return false;
		}

		return true;
	}

}
