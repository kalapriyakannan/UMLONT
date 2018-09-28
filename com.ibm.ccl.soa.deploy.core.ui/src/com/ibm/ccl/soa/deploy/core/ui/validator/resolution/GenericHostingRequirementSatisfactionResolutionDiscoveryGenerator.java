/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.actions.DiscoverLinksAction;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Generates hosting requirement satisfaction resolutions on a unit with an unsatisfied hosting
 * requirement
 * 
 * @author barnold
 */
public class GenericHostingRequirementSatisfactionResolutionDiscoveryGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		Unit unit = null;
		if (status.getDeployObject() instanceof Unit) {
			unit = (Unit) status.getDeployObject();
		}

		if (!ICoreProblemType.UNIT_NOT_HOSTED.equals(status.getProblemType())) {
			return false;
		}
		// Same rules as set-to-installed resolution.
		if (ICoreProblemType.UNIT_NOT_HOSTED.equals(status.getProblemType()) && unit != null
				&& (unit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL))) {
			return false;
		}
		return true;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}
		IDeployStatus status = context.getDeployStatus();
		Unit srcUnit = (Unit) status.getDeployObject();
		return new IDeployResolution[] { new HostingDiscoveryWizardResolution(context, this, srcUnit,
				Messages.GenericDiscoverPossibleHosts) };
	}

	private static class HostingDiscoveryWizardResolution extends DeployResolution {

		private Unit _srcUnit;

		protected HostingDiscoveryWizardResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit srcUnit, String description) {
			super(context, generator, description);
			setRequiresUserInput(true);
			_srcUnit = srcUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			IStructuredSelection selection = new StructuredSelection(_srcUnit);
			DiscoverLinksAction dhla = new DiscoverLinksAction(selection);
			dhla.run();
			return Status.OK_STATUS;
		}
	}
}
