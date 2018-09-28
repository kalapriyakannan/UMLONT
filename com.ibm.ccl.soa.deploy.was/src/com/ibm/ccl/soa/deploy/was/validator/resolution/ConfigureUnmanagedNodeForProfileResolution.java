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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * @since 3.2
 * 
 */
public class ConfigureUnmanagedNodeForProfileResolution extends DeployResolution {

	/**
	 * UNIMPLEMENTED
	 * 
	 * @param context
	 * @param generator
	 */
	public ConfigureUnmanagedNodeForProfileResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		description = WasDomainMessages.Resolution_assign_to_profile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
