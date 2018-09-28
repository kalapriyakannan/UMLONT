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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Sets the install state of a unit and all its hosted configuration units to INSTALLED (recursive).
 */
public class SetUnitAndConfigurationInstalledResolution extends DeployResolution {

	protected boolean setAllHosted;

	/**
	 * Resolution setting a unit to the install state.
	 * 
	 * @param context
	 * @param generator
	 */
	public SetUnitAndConfigurationInstalledResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, DeployNLS.bind(
				DeployCoreMessages.Resolution_set_unit_0_and_all_configuration_units_to_installed,
				context.getDeployStatus().getDeployObject()));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		if (!(context.getDeployStatus().getDeployObject() instanceof Unit)) {
			return Status.CANCEL_STATUS;
		}
		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		setInstallStateRecursive(unit, InstallState.INSTALLED_LITERAL, new HashSet());

		return Status.OK_STATUS;
	}

	/**
	 * Recursively set the install state on all hosted units.
	 * 
	 * @param unit
	 *           a unit.
	 * @param state
	 *           the value for the install state.
	 * @param visitSet
	 *           the set of units that has been visited (to prevent infinite loops.)
	 */
	protected static void setInstallStateRecursive(Unit unit, InstallState state, Set<Unit> visitSet) {
		if (visitSet.contains(unit)) {
			return;
		}
		if (unit.getInitInstallState() != InstallState.INSTALLED_LITERAL) {
			unit.setInitInstallState(InstallState.INSTALLED_LITERAL);
		}
		visitSet.add(unit);
		for (Iterator<Unit> iter = ValidatorUtils.getAllHosts(unit).iterator(); iter.hasNext();) {
			Unit child = iter.next();
			if (child != null && child.isConfigurationUnit()) {
				setInstallStateRecursive(child, state, visitSet);
			}
		}
	}
}
