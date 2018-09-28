/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.validator.resolution.Messages;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.IAutoRealizationValidators;
import com.ibm.ccl.soa.deploy.internal.core.validator.IDeployStatusWithDataObject;

/**
 * Creates a resolution that pops up a {@link MultiRealizationPopupDialog} to handle
 * {@link ICoreProblemType#CONCEPTUAL_UNIT_NOT_REALIZED}.
 * 
 * @since 7.0
 * @author Ed Snible
 */
public class RealizationAssistantResolutionGenerator extends DeployResolutionGenerator {

	/**
	 * If <code>true</code> this UI displays configuration units.
	 */
	static protected final boolean allowConfigUnits = true;

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status.getDeployObject() instanceof Unit)) {
			return false;
		}

		if (!allowConfigUnits && ((Unit) status.getDeployObject()).isConfigurationUnit()) {
			return false;
		}

		if (!ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
			return false;
		}

		if (!IDeployCoreValidators.CONCEPTUAL_UNIT_001.equals(status.getValidatorID())) {
			return false;
		}

		// Although the wizard maps the whole topology it excludes source Units that have
		// no matches.  It would be confusing to bring up the wizard for a Unit that isn't
		// offered in the wizard
		if (noRealizationsFromContextUnit(context.getDeployStatus().getDeployObject().getStatus())) {
			return false;
		}

		// At this point we know the problem.  We don't know if there are any valid solutions, but
		// this 'generator' generates a UI, not an actual solution, so that's OK.
		return true;
	}

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		return new IDeployResolution[] { new DeployResolution(context, this,
				Messages.MultiRealizationWizardResolutionGenerator_Open_Realization_Assistant_) {

			public IStatus resolve(IProgressMonitor monitor) {
				return RealizationAssistantResolutionGenerator.resolve(context, monitor);
			}
		} };
	}

	@SuppressWarnings("unchecked")
	private boolean noRealizationsFromContextUnit(IStatus deployStatus) {
		IDeployStatusWithDataObject linkStatus = getLinkStatus(deployStatus);
		if (linkStatus == null) {
			return true;
		}

		Object obj = linkStatus.getDataObject();
		if (obj instanceof Map) {
			Map<Unit, LinkDescriptor> candidateToLD = (Map<Unit, LinkDescriptor>) obj;
			if (hasRealization(candidateToLD)) {
				return false;
			}
		}

		return true;
	}

	private boolean hasRealization(Map<Unit, LinkDescriptor> descrs) {
		return descrs.size() > 0;
	}

	private IDeployStatusWithDataObject getLinkStatus(IStatus deployStatus) {
		for (Iterator<IDeployStatus> deployStatusIterator = new DeployStatusIterator(deployStatus); deployStatusIterator
				.hasNext();) {

			IDeployStatus workingStatus = deployStatusIterator.next();
			if (realizationAvailable(workingStatus)) {
				return (IDeployStatusWithDataObject) workingStatus;
			}
		}

		return null;
	}

	private boolean realizationAvailable(IDeployStatus status) {
		if (!ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
			return false;
		}

		if (!IAutoRealizationValidators.CONCEPTUAL_UNIT_SINGLE_UNIT_REALIZATION_AVAILABLE
				.equals(status.getValidatorID())) {
			return false;
		}

		if (!(status instanceof IDeployStatusWithDataObject)) {
			return false;
		}

		if (!(((IDeployStatusWithDataObject) status).getDataObject() instanceof Map)) {
			return false;
		}
		return true;
	}

	protected static IStatus resolve(IDeployResolutionContext context, IProgressMonitor monitor) {
//		MultiRealizationPopupDialog popup = new MultiRealizationPopupDialog(Display.getCurrent()
//				.getShells()[0], context.getTopology(), context.getDeployStatus().getDeployObject());
		MultiRealizationPopupDialog popup = new MultiRealizationPopupDialog(new Shell(), context
				.getTopology(), context.getDeployStatus().getDeployObject());
		popup.open();

		// Return OK; the popup should not block the resolution thread.
		return Status.OK_STATUS;
	}

}
