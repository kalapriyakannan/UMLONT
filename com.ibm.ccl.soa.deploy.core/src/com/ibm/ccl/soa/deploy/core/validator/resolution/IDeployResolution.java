/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Interface implemented by resolvers to SOA deploy status.
 * <p>
 * Not intended to be directly implemented. Extend {@link DeployResolution}.
 * 
 * @see IDeployStatus
 */
public interface IDeployResolution extends Comparable {

	/**
	 * Returns the identifier of the resolution.
	 * 
	 * @return the resolution identifier.
	 */
	public String getResolutionID();

	/**
	 * @return a description of the resolution.
	 */
	public String getDescription();

	/**
	 * @return the priority of the resolution.
	 */
	public int getPriority();

	/**
	 * @return true if the resolution requires user input through a visual interaction dialog.
	 */
	public boolean requiresUserInput();

	/**
	 * Returns the status that will be resolved.
	 * <p>
	 * Convenience method, equivalent to {@link #getDeployResolutionContext()} and
	 * {@link IDeployResolutionContext#getDeployStatus()}.
	 * 
	 * @return the deploy status that will be resolved.
	 */
	public IDeployStatus getDeployStatus();

	/**
	 * @return the context of the deploy resolution.
	 */
	public IDeployResolutionContext getDeployResolutionContext();

	/**
	 * @return the resolution generator that created this resolution (may be null).
	 */
	public IDeployResolutionGenerator getResolutionGenerator();

	/**
	 * Resolve the deploy status associated with this resolution.
	 * 
	 * @param monitor
	 *           resolution progress monitor.
	 * @return the status of the resolution execution.
	 */
	public IStatus resolve(IProgressMonitor monitor);
}
