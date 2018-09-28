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
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A generic resolution for satisfying a dependency requirement
 * 
 * @author barnold
 */
public class GenericLogicalLinkCreationResolution extends DeployResolution {

	private final LinkDescriptor linkDescriptor;
	private Unit targetUnit;

	/**
	 * Construct a resolution create a dependendency link to a selected unit. (Properly a capability
	 * on the unit, described in the linkDescriptor)
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param linkDescriptor
	 *           the descriptor for the link to be created if resolution is triggered
	 * @param sourceUnit
	 *           the source for the logical link
	 */
	public GenericLogicalLinkCreationResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor, Unit sourceUnit) {
		this(context, generator, linkDescriptor, sourceUnit, null);
	}

	/**
	 * Construct a resolution create a dependendency link to a selected unit. (Properly a capability
	 * on the unit, described in the linkDescriptor)
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param linkDescriptor
	 *           the descriptor for the link to be created if resolution is triggered
	 * @param targetUnit
	 *           the destination for the logical link
	 * @param description
	 *           the description of the resoluton.
	 */
	public GenericLogicalLinkCreationResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor, Unit targetUnit,
			String description) {
		super(context, generator);
		assert linkDescriptor != null;
		assert targetUnit != null;
		this.linkDescriptor = linkDescriptor;
		this.targetUnit = targetUnit;
		if (description == null) {
			this.description = NLS.bind(DeployCoreMessages.Resolution_create_logical_link_to_0,
					this.targetUnit);
		} else {
			this.description = description;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		linkDescriptor.create();
		return Status.OK_STATUS;
	}
}
