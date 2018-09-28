/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit;

/**
 * Resolution to remove a shared library definition from a topology.
 */
public class DeleteSharedLibraryResolution extends DeployResolution {

	private WasSharedLibraryEntryUnit _sharedLib;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param appModule
	 *           the application (or module) accessing the shared library
	 * @param wasHost
	 *           where the shared library should be hosted
	 * @param jarModule
	 *           the target utility jar
	 */
	public DeleteSharedLibraryResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Unit sharedLib) {
		super(context, generator, message);
		_sharedLib = (WasSharedLibraryEntryUnit) sharedLib;

	}

	/*
	 * Plan removal of shared library from topology. If it is "installed" then mark it to be deleted.
	 * Otherwise it can be deleted directly. <p> This resolution should only be called if the shared
	 * library can be deleted from the topology (ie, it is in the current edit topology or, if in an
	 * imported topology the contract allows for its deletion.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		// get shared library causing the problem
		if (InstallState.INSTALLED_LITERAL.equals(_sharedLib.getInitInstallState())) {
			// mark as to be deleted
		} else {
			ResolutionUtils.removeFromTopology(_sharedLib);
		}

		return Status.OK_STATUS;
	}

}
