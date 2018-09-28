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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A generic resolution for satisfying a realization requirement
 */
public class GenericRealizationSatisfactionResolution extends DeployResolution {

	private final LinkDescriptor linkDescriptor;

// 	private final Unit candidateUnit;	

	/**
	 * Construct a resolution create a realization link to a selected unit.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param linkDescriptor
	 *           the descriptor for the link to be created if resolution is triggered
	 * @param candidateUnit
	 *           unit for the target of the link
	 */
	public GenericRealizationSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor/*
	 * , Unit
	 * candidateUnit
	 */) {
		this(context, generator, linkDescriptor, /* candidateUnit, */null);
	}

	/**
	 * Construct a resolution create a realization link to a selected unit.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param linkDescriptor
	 *           the descriptor for the link to be created if resolution is triggered
	 * @param description
	 *           the description of the resolution.
	 */
	public GenericRealizationSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor, /* Unit candidateUnit, */
			String description) {
		super(context, generator);
		assert linkDescriptor != null;
		assert linkDescriptor.getTargetUnit() != null;
		this.linkDescriptor = linkDescriptor;
//		this.candidateUnit = candidateUnit;

		if (description == null) {
			if (this.linkDescriptor.getType().equals(LinkType.REALIZATION)) {
				this.description = NLS.bind(DeployCoreMessages.Resolution_realize_0_by_1,
						this.linkDescriptor.getSourceUnit().getDisplayName(), this.linkDescriptor
								.getTargetUnit().getDisplayName());
			}
		} else {
			this.description = description;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		LinkDescriptor newLinkDescriptor = new LinkDescriptor(linkDescriptor.getType(),
				linkDescriptor.getSourceUnit(), linkDescriptor.getTargetUnit());
		newLinkDescriptor.create();
		return Status.OK_STATUS;
	}
}
