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
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A generic resolution for satisfying a dependency requirement
 * 
 * @author barnold
 */
public class GenericHostingRequirementSatisfactionResolution extends DeployResolution {

	private LinkDescriptor linkDescriptor;
//  private final UnitDescriptor candidateUnitUD;
	private final Unit candidateUnit;

//	/**
//	 * Construct a resolution create a dependendency link to a selected unit.
//	 * (Properly a capability on the unit, described in the linkDescriptor)
//	 * 
//	 * @param context
//	 *            the context of the resolution.
//	 * @param generator
//	 *            the generator creating this status.
//	 * @param linkDescriptor 
//	 *            the descriptor for the link to be created if resolution is triggered
//	 * @param candidateUnitUD 
//	 *            unit descriptor for the target of the link
//	 */
//	public GenericHostingRequirementSatisfactionResolution(IDeployResolutionContext context,
//			IDeployResolutionGenerator generator,LinkDescriptor linkDescriptor, UnitDescriptor candidateUnitUD) {
//		this(context, generator, linkDescriptor, candidateUnitUD, null);
//	}
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
	 * @param candidateUnit
	 *           unit for the target of the link
	 */
	public GenericHostingRequirementSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor, Unit candidateUnit) {
		this(context, generator, linkDescriptor, candidateUnit, null);
	}

//	/**
//	 * Construct a resolution create a dependendency link to a selected unit.
//	 * (Properly a capability on the unit, described in the linkDescriptor)
//	 * 
//	 * @param context
//	 *            the context of the resolution.
//	 * @param generator
//	 *            the generator creating this status.
//	 * @param linkDescriptor 
//	 *            the descriptor for the link to be created if resolution is triggered
//	 * @param candidateUnitUD 
//	 *            unit descriptor for the target of the link
//	 * @param description
//	 *            the description of the resoluton.
//	 */
//	public GenericHostingRequirementSatisfactionResolution(IDeployResolutionContext context,
//			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor, UnitDescriptor candidateUnitUD, String description) {
//		super(context, generator);
//		assert linkDescriptor != null;
//		assert linkDescriptor.getTargetUnit() != null;
//		this.linkDescriptor = linkDescriptor;
//		this.candidateUnitUD = candidateUnitUD;
//		if (description == null) {
//			this.description = NLS.bind(
//					DeployCoreMessages.Resolution_host_0_on_1,
//					this.linkDescriptor.getSourceUnit().getDisplayName(),
//					this.linkDescriptor.getTargetUnit().getDisplayName()); 
//		} else {
//			this.description = description;
//		}
//	}
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
	 * @param candidateUnit
	 *           unit for the target of the link
	 * @param description
	 *           the description of the resoluton.
	 */
	public GenericHostingRequirementSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, LinkDescriptor linkDescriptor, Unit candidateUnit,
			String description) {
		super(context, generator);
		assert linkDescriptor != null;
		assert linkDescriptor.getTargetUnit() != null;
		this.linkDescriptor = linkDescriptor;
		this.candidateUnit = candidateUnit;

		if (description == null) {
			if (this.linkDescriptor.getType().equals(LinkType.HOSTING)) {
				this.description = NLS.bind(DeployCoreMessages.Resolution_host_0_on_1,
						this.linkDescriptor.getSourceUnit().getDisplayName(), this.linkDescriptor
								.getTargetUnit().getDisplayName());
			} else if (this.linkDescriptor.getType().equals(LinkType.CONSTRAINT)) {
				this.description = NLS.bind(DeployCoreMessages.Resolution_create_logical_link_to_0,
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
		linkDescriptor.create();
		return Status.OK_STATUS;
	}
}
