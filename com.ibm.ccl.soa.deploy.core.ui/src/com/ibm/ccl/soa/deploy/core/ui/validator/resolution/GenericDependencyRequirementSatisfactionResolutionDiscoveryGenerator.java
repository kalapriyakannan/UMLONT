/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.actions.DiscoverLinksAction;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
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
// MK - 03/01/2008: defect 5549:
// while fixing defect observed that the generic "Discover Links" resolution
// returns links for all requirements in a unit; not just the one associated with
// the marker that was selected.  This is because the requirement is ignored.  Added
// the requirement as a parameter to the resolution and to the discover wizard
// subsequently called.
public class GenericDependencyRequirementSatisfactionResolutionDiscoveryGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		if (!ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED.equals(status.getProblemType())) {
			return false;
		}

		if (!(status.getDeployObject() instanceof Requirement)) {
			return false;
		}
		Requirement req = (Requirement) status.getDeployObject();
		Unit srcUnit = (Unit) req.getParent();
		if (srcUnit != null && srcUnit.getInitInstallState() != InstallState.INSTALLED_LITERAL
				&& srcUnit.getTopology() != null
				// MK: 03-01-2008 - defect 5549
				// Observed that the resolution wasn't getting added as often as expected;  
				// The cause was an incorrect test for host; older version doesn't work with imports
				&& null == ValidatorUtils.discoverHost(srcUnit, context.getProgressMonitor())) {
			// There is also an unsatisfied hosting requirement. The resolution
			// for that will work.
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
		Requirement req = (Requirement) status.getDeployObject();
		Unit srcUnit = (Unit) req.getParent();
		return new IDeployResolution[] { new DependencyDiscoveryWizardResolution(context, this,
				srcUnit, req, Messages.GenericDiscoverPossibleHosts) };
	}

	private static class DependencyDiscoveryWizardResolution extends DeployResolution {

		private final Unit _srcUnit;
		private final Requirement _srcReq;

		protected DependencyDiscoveryWizardResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit srcUnit, Requirement srcReq,
				String description) {
			super(context, generator, description);
			setRequiresUserInput(true);
			_srcUnit = srcUnit;
			_srcReq = srcReq;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			IStructuredSelection selection = new StructuredSelection(new UnitRequirement(_srcUnit,
					_srcReq));
			DiscoverLinksAction dhla = new DiscoverLinksAction(selection);
			dhla.run();
			return Status.OK_STATUS;
		}
	}
}
