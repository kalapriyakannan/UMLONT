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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.operation.DeleteModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;

/**
 * Resolution to delete any DMO
 */
public class DeleteDmoResolution extends DeployResolution {

	private final boolean processLinks;

	/**
	 * Construct a resolution to delete a DMO
	 * 
	 * @param context
	 *           the validation context
	 * @param generator
	 *           the resolution generator.
	 */
	public DeleteDmoResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description) {
		super(context, generator, description);
		processLinks = true;
	}

	/**
	 * Construct a resolution to delete a DMO
	 * 
	 * @param context
	 *           the validation context
	 * @param generator
	 *           the resolution generator.
	 */
	public DeleteDmoResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, boolean processLinks) {
		super(context, generator, description);
		this.processLinks = processLinks;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		DeployModelObject dmo = context.getDeployStatus().getDeployObject();
		// Use Dan's generic object deleter
		DeleteModelObjectOperation dmoo = new DeleteModelObjectOperation(dmo,
				"delete " + dmo, processLinks); //$NON-NLS-1$
		try {
			dmoo.execute(monitor, null);
		} catch (ExecutionException e) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, e.getMessage(), e);
		}

		return Status.OK_STATUS;
	}
}
