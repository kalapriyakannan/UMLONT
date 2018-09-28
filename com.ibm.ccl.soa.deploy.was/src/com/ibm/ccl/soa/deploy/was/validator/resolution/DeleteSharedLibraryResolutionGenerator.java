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

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Delete a shared library.
 */
public class DeleteSharedLibraryResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		Unit sharedLibA = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CONFLICTING_SHARED_LIBRARY_A);
		Unit sharedLibB = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CONFLICTING_SHARED_LIBRARY_B);

		// sharedLibA is not null by presence of marker

		if (sharedLibA == sharedLibB || null == sharedLibB) {
			String message = DeployNLS.bind(WasDomainMessages.Resolution_delete_shared_library_0,
					new Object[] { sharedLibA.getCaptionProvider().title(sharedLibA) });
			if (checkSharedLibrary(sharedLibA)) {
				return new IDeployResolution[] { new DeleteSharedLibraryResolution(context, this,
						message, sharedLibA) };
			} else {
				return new IDeployResolution[0];
			}
		}

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		if (checkSharedLibrary(sharedLibA)) {
			String messageA = DeployNLS.bind(WasDomainMessages.Resolution_delete_shared_library_0,
					new Object[] { sharedLibA.getCaptionProvider().title(sharedLibA) });
			resolutions.add(new DeleteSharedLibraryResolution(context, this, messageA, sharedLibA));
		}

		if (checkSharedLibrary(sharedLibB)) {
			String messageB = DeployNLS.bind(WasDomainMessages.Resolution_delete_shared_library_0,
					new Object[] { sharedLibB.getCaptionProvider().title(sharedLibB) });
			resolutions.add(new DeleteSharedLibraryResolution(context, this, messageB, sharedLibB));
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();
		if (!IWASProblemType.CONFLICTING_SHARED_LIBARIES.equals(status.getProblemType())) {
			return false;
		}

		// if unit is installed; resolution will set the goal install state to installed > uninstalled
		// if the unit is not installed; it will be removed from the topology

		// need to check that we have permission to do these things
		Unit sharedLibA = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CONFLICTING_SHARED_LIBRARY_A);
		Unit sharedLibB = (Unit) status
				.getAttribute(IWasDeployStatusAttributeNames.CONFLICTING_SHARED_LIBRARY_B);
		if (checkSharedLibrary(sharedLibA)) {
			return true;
		}

		if (checkSharedLibrary(sharedLibB)) {
			return true;
		}

		return false;
	}

	private boolean checkSharedLibrary(Unit sharedLib) {
		if (null == sharedLib) {
			return false;
		}
		if (InstallState.INSTALLED_LITERAL.equals(sharedLib.getInitInstallState())) {
			// must be able to change values
			return DeployModelObjectUtil.isSettable(sharedLib,
					CorePackage.Literals.UNIT__GOAL_INSTALL_STATE);
		} else {
			// can remove units only if they are in the edit topology
			return sharedLib.getTopology() == sharedLib.getEditTopology();
		}

	}
}
