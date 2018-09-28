/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Deletes a hosting link.
 */
public class DeleteHostingLinkResolution extends DeployResolution {

	protected final HostingLink link;

	protected final Unit container;

	public DeleteHostingLinkResolution(IDeployResolutionContext context, HostingLink link,
			Unit container, IDeployResolutionGenerator generator) {
		super(context, generator, DeployNLS.bind(DeployCoreMessages.Resolution_unhost_0_from_1,
				new Object[] { link.getTarget(), link.getSource() }));
		this.link = link;
		this.container = container;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		container.getHostingLinks().remove(link);
		link.setTarget(null);
		return Status.OK_STATUS;
	}
}
