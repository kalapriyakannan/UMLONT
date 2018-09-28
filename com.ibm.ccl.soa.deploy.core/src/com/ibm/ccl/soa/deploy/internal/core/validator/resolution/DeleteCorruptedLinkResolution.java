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
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.operation.DeleteModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolution to delete a link with an invalid target.
 */
public class DeleteCorruptedLinkResolution extends DeployResolution {

	/**
	 * Construct a resolution to delete a link with an invalid target.
	 * 
	 * @param context
	 *           the validation context
	 * @param generator
	 *           the resolution generator.
	 */
	public DeleteCorruptedLinkResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);

		setDescription(DeployCoreMessages.Resolution_delete_link);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		DeployLink link = (DeployLink) context.getDeployStatus().getDeployObject();
		// Use Dan's generic object deleter
		DeleteModelObjectOperation dmoo = new DeleteModelObjectOperation(link, "delete " + link); //$NON-NLS-1$
		try {
			dmoo.execute(monitor, null);
		} catch (ExecutionException e) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, e.getMessage(), e);
		}

		return Status.OK_STATUS;
	}
}
