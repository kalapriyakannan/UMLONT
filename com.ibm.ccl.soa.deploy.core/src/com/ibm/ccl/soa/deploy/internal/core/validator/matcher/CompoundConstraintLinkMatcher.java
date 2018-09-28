/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;

/**
 * LinkMatcher that triggers the execution of operations on all Constraint Link Matchers that are
 * registered through the 'constraints' extension point.
 * 
 */
public class CompoundConstraintLinkMatcher extends ConstraintLinkMatcher {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canBeLinkSource(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canBeLinkSource(Unit unit) {
		return canBeLinkSource(unit, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canBeLinkSource(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Requirement)
	 */
	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {

		// MK 4/19/2007 this is the wrong place for this it should be in
		// com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher
//		if (unit.isConceptual()) {
//			if (!unit.getDependencyOrAnyCapabilities().isEmpty()) {
//				List capabilites = unit.getCapabilities(CapabilityLinkTypeFilter.DEPENDENCY_FILTER, null);
//				if (capabilites.isEmpty() || isCommunicationCapabilites(capabilites)) {
//					return DeployMatcherStatus.MATCH_FOUND;
//				}
//			} else {
//				return DeployMatcherStatus.MATCH_FOUND;
//			}
//
//		}
//		LogicalLinkDescriptor[] descriptors = LogicalLinkManager.getInstance()
//				.getLogicalLinkDescriptors();

		// try all constraint link matchers
		List<LinkMatcher> constraintLM = ConstraintService.INSTANCE.getAllConstraintLinkMatchers();
		for (LinkMatcher lm : constraintLM) {
			IStatus status = lm.canBeLinkSource(unit, requirement);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	// MK 4/19/2007 this is the wrong place for this it should be in
	// com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher
//	private boolean isCommunicationCapabilites(List capabilites) {
//		for (Iterator iter = capabilites.iterator(); iter.hasNext();) {
//			Capability element = (Capability) iter.next();
//			if (!(element instanceof CommunicationCapability))
//				return false;
//		}
//		return true;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canBeLinkTarget(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canBeLinkTarget(Unit unit) {
		return canBeLinkTarget(unit, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canBeLinkTarget(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public IStatus canBeLinkTarget(Unit unit, Capability capability) {
		// try all constraint link matchers
		List<LinkMatcher> constraintLM = ConstraintService.INSTANCE.getAllConstraintLinkMatchers();
		for (LinkMatcher lm : constraintLM) {
			IStatus status = lm.canBeLinkTarget(unit, capability);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canCreateLink(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canCreateLink(Unit source, Unit target) {
		return canCreateLink(source, null, target, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canCreateLink(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {

		// MK 4/19/2007 this is the wrong place for this it should be in
		// com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher
//		if (source.isConceptual() && target.isConceptual())
//			return DeployMatcherStatus.MATCH_FOUND;

		// try all constraint link matchers
		List<LinkMatcher> constraintLM = ConstraintService.INSTANCE.getAllConstraintLinkMatchers();
		for (LinkMatcher lm : constraintLM) {
			IStatus status = lm.canCreateLink(source, sourceRequirement, target, targetCapability);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#getPossibleLinks(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Set getPossibleLinks(Unit source, Unit target) {
		return getPossibleLinks(source, null, target, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#getPossibleLinks(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public Set getPossibleLinks(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		Set allLinks = new HashSet();

		// try all logical link matchers
		List<LinkMatcher> constraintLM = ConstraintService.INSTANCE.getAllConstraintLinkMatchers();
		for (LinkMatcher lm : constraintLM) {
			Set links = lm.getPossibleLinks(source, sourceRequirement, target, targetCapability);
			for (Iterator lIt = links.iterator(); lIt.hasNext();) {
				boolean alreadyPresent = false;
				LinkDescriptor ld = (LinkDescriptor) lIt.next();
				for (Iterator alIt = allLinks.iterator(); alIt.hasNext();) {
					if (ld.equals(alIt.next())) {
						alreadyPresent = true;
						break;
					}
				}
				if (!alreadyPresent) {
					allLinks.add(ld);
				}
			}
		}

		return allLinks;
	}

}
