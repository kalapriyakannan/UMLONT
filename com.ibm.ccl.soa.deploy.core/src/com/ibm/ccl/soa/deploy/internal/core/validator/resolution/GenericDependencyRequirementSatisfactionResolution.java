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

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
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
public class GenericDependencyRequirementSatisfactionResolution extends DeployResolution {

	private final LinkDescriptor linkDescriptor;
	private final UnitDescriptor candidateUnitUD;

	/**
	 * Construct a resolution create a dependendency link to a selected unit. (Properly a capability
	 * on the unit, described in the linkDescriptor)
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param candidateUnitUD
	 *           The unit descriptor for the candidate target unit that the resolution would create a
	 *           dependency link to
	 * @param linkDescriptor
	 *           the descriptor for the link to be created if resolution is triggered
	 */
	public GenericDependencyRequirementSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, UnitDescriptor candidateUnitUD,
			LinkDescriptor linkDescriptor) {
		this(context, generator, candidateUnitUD, linkDescriptor, null);
	}

	/**
	 * Construct a resolution create a dependendency link to a selected unit. (Properly a capability
	 * on the unit, described in the linkDescriptor)
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param candidateUnitUD
	 *           The unit descriptor for the candidate target unit that the resolution would create a
	 *           dependency link to
	 * @param linkDescriptor
	 *           the descriptor for the link to be created if resolution is triggered
	 * @param description
	 *           the description of the resoluton.
	 */
	public GenericDependencyRequirementSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, UnitDescriptor candidateUnitUD,
			LinkDescriptor linkDescriptor, String description) {
		super(context, generator);
		assert linkDescriptor != null;
		assert candidateUnitUD != null;
		this.candidateUnitUD = candidateUnitUD;
		this.linkDescriptor = linkDescriptor;
		//		Unit candidateUnit = candidateUnitUD.getUnitValue();
		if (description == null) {
			//			this.description = NLS.bind(
			//					DeployCoreMessages.Resolution_create_dependency_link_to_0,
			//					candidateUnit.getDisplayName()); 
			this.description = DeployNLS.bind(
					DeployCoreMessages.Resolution_create_dependency_link_from_0_to_1, new Object[] {
							linkDescriptor.getSource().getDisplayName(),
							linkDescriptor.getTargetUnit().getCaptionProvider().titleWithContext(
									linkDescriptor.getTargetUnit()) });
			//							linkDescriptor.getTargetUnit().getDisplayName(),
			//							linkDescriptor.getTarget().getDisplayName() });
		} else {
			this.description = description;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		Topology editTop = linkDescriptor.getSourceUnit().getEditTopology();
		Unit candidateUnit = candidateUnitUD.getUnitValueAndAddToTopology(editTop);
		// TODO get all matching candidates caps, then compare each with target cap.
		//		Capability candidateCap = ValidatorUtils.getCapability(candidateUnit, linkDescriptor.getTarget().eClass());

		//		LinkDescriptor newLinkDescriptor = new LinkDescriptor(LinkType.DEPENDENCY, 
		//				linkDescriptor.getSourceUnit(), (Requirement) linkDescriptor.getSource(), 
		//				candidateUnit, candidateCap);		

		Unit tmpUnit = candidateUnit;
		while (tmpUnit.isConfigurationUnit()) {
			UnitDescriptor tmpUD = TopologyDiscovererService.INSTANCE.findHostUD(tmpUnit, editTop);
			if (tmpUD == null) {
				break;
			}
			tmpUnit = tmpUD.getUnitValueAndAddToTopology(editTop);
		}
		linkDescriptor.create();

		return Status.OK_STATUS;
	}
}
