/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generates resolutions for {@link ICoreProblemType.UNIT_NOT_HOSTED}.
 */
public class DeployUnitNotHostedResolutionGenerator extends DeployResolutionGenerator {

	/** Priority of the resolution to set the install state. */
	public static final int SET_INSTALLED_STATE_PRIORITY = -1000;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		IDeployStatus status = context.getDeployStatus();
		Unit unit = (Unit) status.getDeployObject();

		String description = DeployNLS.bind(
				DeployCoreMessages.Resolution_set_unit_0_init_install_state_to_installed, unit);
		DeploySetAttributeResolution resolution2 = new DeploySetAttributeResolution(context, this,
				CorePackage.eINSTANCE.getUnit_InitInstallState().getName(),
				InstallState.INSTALLED_LITERAL, description);
		resolution2.setPriority(SET_INSTALLED_STATE_PRIORITY);
		return new IDeployResolution[] { resolution2 };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (!ICoreProblemType.UNIT_NOT_HOSTED.equals(status.getProblemType())) {
			return false;
		}
		if (!(status.getDeployObject() instanceof Unit)) {
			return false;
		}
		Unit unit = (Unit) status.getDeployObject();
		if (unit == null) {
			return false;
		}
		if (unit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			return false;
		}
		if (!DeployModelObjectUtil.isMutable(unit, CorePackage.eINSTANCE.getUnit_InitInstallState())) {
			return false;
		}
		return true;
	}
}
