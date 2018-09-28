/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolution to uninstall a unit.
 */
public class UninstallUnitResolution extends DeployResolution {

	protected boolean recursive;

	/**
	 * Construct a resolution to uninstall a unit.
	 * 
	 * @param context
	 *           the validation context
	 * @param generator
	 *           the resolution generator.
	 * @param recursive
	 *           true if the hosted units should be set to be uninstalled recursively.
	 */
	public UninstallUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, boolean recursive) {
		super(context, generator);
		this.recursive = recursive;
		if (recursive) {
			setDescription(DeployCoreMessages.Resolution_uninstall_unit_and_all_hosted_units);
		} else {
			setDescription(DeployCoreMessages.Resolution_uninstall_unit);
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		if (recursive) {
			for (Unit hosted : ResolutionUtils.addAllHostedUnits(unit)) {
				hosted.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);
			}
		}
		unit.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return Status.OK_STATUS;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof UninstallUnitResolution)) {
			return false;
		}
		UninstallUnitResolution peer = (UninstallUnitResolution) obj;
		return ((peer.recursive == recursive) && (peer.getDeployStatus().getDeployObject() == getDeployStatus()
				.getDeployObject()));
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return ICoreProblemType.UNIT_HOST_TO_BE_UNINSTALLED.hashCode()
				^ getDeployStatus().getDeployObject().hashCode();
	}
}
