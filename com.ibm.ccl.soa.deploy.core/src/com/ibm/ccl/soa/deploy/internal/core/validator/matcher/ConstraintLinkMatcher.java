/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Matching logic for logical links. Only considers whether or not a logical link can be established
 * between a source unit (or a requirment of that unit) and a target unit (or a capability of that
 * target).
 */
public class ConstraintLinkMatcher extends LinkMatcher {

	public IStatus canBeLinkSource(Unit unit) {
		if (null == unit) {
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		// MK 4/19/2007 moved from
		// com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkMatcher
		if (unit.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(unit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_FOUND;
			// what is the point of this code?
//			if (!unit.getDependencyOrAnyCapabilities().isEmpty()) {
//				List capabilites = unit.getCapabilities(CapabilityLinkTypeFilter.DEPENDENCY_FILTER, null);
//				if (capabilites.isEmpty() || isCommunicationCapabilites(capabilites)) {
//					return DeployMatcherStatus.MATCH_FOUND;
//				}
//			} else {
//				return DeployMatcherStatus.MATCH_FOUND;
//			}
		}

		// in core domain there are no logical links
		return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
	}

	public IStatus canBeLinkTarget(Unit unit) {

		// MK 4/19/2007: WorkItem 1039
		// I believe this code is left over from M3
		// if (unit.isConceptual())
		// 	return DeployMatcherStatus.MATCH_FOUND;
		if (null == unit) {
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		// in core domain there are no logical links
		return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
	}

	public IStatus canCreateLink(Unit unit1, Unit unit2) {
		assert null != unit1;
		assert null != unit2;

		return canCreateLink(unit1, null, unit2, null);
	}

	public Set getPossibleLinks(Unit source, Unit target) {
		return getPossibleLinks(source, null, target, null);
	}

	public Set getPossibleLinks(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		assert null != source;
		assert null != target;

		Set linkSet = new HashSet();
		// a unit cannot provide itself with something it needs
		if (source.equals(target)) {
			return linkSet;
		}

		LinkDescriptor[] links = getPossibleLogicalLinksInternalMain(source, sourceRequirement,
				target, targetCapability);
		for (int i = 0; i < links.length; i++) {
			linkSet.add(links[i]);
		}
		return linkSet;
	}

	/**
	 * Retrieve the possible logical links between a source and a target.
	 * 
	 * @param sourceUnit
	 *           source unit
	 * @param sourceRequirement
	 *           source requirement; may be null
	 * @param targetUnit
	 *           target unit
	 * @param targetCapability
	 *           target capability; may be null
	 * @return Array (LinkDescriptor) of possible links
	 */
	private LinkDescriptor[] getPossibleLogicalLinksInternalMain(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetUnit;

		if (null != sourceRequirement) {
			// sanity check
			if (!sourceUnit.getRequirements().contains(sourceRequirement)) {
				return new LinkDescriptor[0];
			}
			if (null != targetCapability) {
				return getPossibleLogicalLinksInternal(sourceUnit, sourceRequirement, targetUnit,
						targetCapability);
			}
			return getPossibleLogicalLinksInternal(sourceUnit, sourceRequirement, targetUnit);
		}

		// we know that sourceRequirement is null
		if (null != targetCapability) {
			if (!targetUnit.getCapabilities().contains(targetCapability)) {
				return new LinkDescriptor[0];
			}
			return getPossibleLogicalLinksInternal(sourceUnit, targetUnit, targetCapability);
		}
		return getPossibleLogicalLinksInternal(sourceUnit, targetUnit);
	}

	/**
	 * Retrieve the possible link between a source requirement and a target capability if one exists.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceRequirment
	 *           source requirement
	 * @param targetCapability
	 *           source capability
	 * @return list (size at most 1) of possible links
	 */
	private LinkDescriptor[] getPossibleLogicalLinksInternal(Unit sourceUnit,
			Requirement sourceRequirment, Unit targetUnit, Capability targetCapability) {
		assert null != sourceRequirment;
		assert null != targetCapability;

		// check that can create link
		IStatus canCreateStatus = canCreateLogicalLinkInternal(sourceRequirment, targetCapability);
		if (!canCreateStatus.isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create a link
		LinkDescriptor result[] = new LinkDescriptor[1];
		int createStatusCode = canCreateStatus.getCode();

		if (0 == createStatusCode) {
			result[0] = getLinkDescriptorFactory().createLinkDescriptor(LinkType.CONSTRAINT,
					sourceUnit, sourceRequirment, targetUnit, targetCapability);
		} else {
			result[0] = getLinkDescriptorFactory().createLinkDescriptor(LinkType.CONSTRAINT,
					sourceUnit, sourceRequirment, targetUnit, targetCapability, createStatusCode);
		}
		return result;
	}

	/**
	 * Retrieve the possible logical links that can be created between a source unit and a target
	 * capability; that is, between any of the source units requirements and the target capability.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceUnit
	 *           source unit
	 * @param targetCapability
	 *           target capability
	 * @return list of possible logical links
	 */
	private LinkDescriptor[] getPossibleLogicalLinksInternal(Unit sourceUnit, Unit targetUnit,
			Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetCapability;

		// check that can create link
		IStatus canCreateStatus = canCreateLogicalLinkInternal(sourceUnit, targetCapability);
		if (!canCreateStatus.isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create at least one link
		ArrayList sldSet = new ArrayList();

		for (Iterator iter = sourceUnit.getRequirements().iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			LinkDescriptor[] links = getPossibleLogicalLinksInternal(sourceUnit, sourceRequirement,
					targetUnit, targetCapability);
			if (0 != links.length) {
				sldSet.add(links[0]);
			}
		}

		return MatcherUtils.asArray(sldSet);
	}

	/**
	 * Retrieve the possible logical links that can be created between a source requirement and a
	 * target unit; that is, with any of the targetUnit's capabilities.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceRequirement
	 *           source requirement
	 * @param targetUnit
	 *           target unit
	 * @return list of possible logical links
	 */
	private LinkDescriptor[] getPossibleLogicalLinksInternal(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit) {
		assert null != sourceRequirement;
		assert null != targetUnit;

		// check that can create link
		if (!canCreateLogicalLinkInternal(sourceRequirement, targetUnit).isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create at least one link
		ArrayList sldSet = new ArrayList();

		for (Iterator iter = targetUnit.getCapabilities().iterator(); iter.hasNext();) {
			Capability targetCapability = (Capability) iter.next();
			LinkDescriptor[] links = getPossibleLogicalLinksInternal(sourceUnit, sourceRequirement,
					targetUnit, targetCapability);
			if (0 != links.length) {
				sldSet.add(links[0]);
			}
		}

		return MatcherUtils.asArray(sldSet);
	}

	/**
	 * Retrieve the possible logical links that can be created between a source unit and a target
	 * unit; that is, between any of the source units requirements and any of the targetUnit's
	 * capabilities.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceUnit
	 *           source unit
	 * @param targetUnit
	 *           target unit
	 * @return list of possible logical links
	 */
	private LinkDescriptor[] getPossibleLogicalLinksInternal(Unit sourceUnit, Unit targetUnit) {
		assert null != sourceUnit;
		assert null != targetUnit;

		// check that can create link
		if (!canCreateLogicalLinkInternal(sourceUnit, targetUnit).isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create at least one link
		ArrayList sldSet = new ArrayList();

		for (Iterator iter = sourceUnit.getRequirements().iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			LinkDescriptor[] links = getPossibleLogicalLinksInternal(sourceUnit, sourceRequirement,
					targetUnit);
			for (int i = 0; i < links.length; i++) {
				sldSet.add(links[i]);
			}
		}

		return MatcherUtils.asArray(sldSet);
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		if (null == unit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// MK 4/19/2007 moved from
		// com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkMatcher
		if (unit.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(unit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_FOUND;
			// what is the point of this code?
//			if (!unit.getDependencyOrAnyCapabilities().isEmpty()) {
//				List capabilites = unit.getCapabilities(CapabilityLinkTypeFilter.DEPENDENCY_FILTER, null);
//				if (capabilites.isEmpty() || isCommunicationCapabilites(capabilites)) {
//					return DeployMatcherStatus.MATCH_FOUND;
//				}
//			} else {
//				return DeployMatcherStatus.MATCH_FOUND;
//			}
		}

		// if we are given the requirement we check that it is not satisfied
		if (null != requirement) {
			// in core domain there are no logical links
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		// we check all requirements if requirement was null
		return canBeLinkSource(unit);
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability) {
		if (null == unit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (null != capability) {
			// in core domain there are no logical links
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		// check all capabilities if capability was null
		return canBeLinkTarget(unit);
	}

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		if (null == source) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (null == target) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// a unit cannot provide itself with something it needs
		if (source.equals(target)) {
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		// support creation of logical communication link between conceptual nodes 
		if (source.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(source.getEObject().eClass())
				&& target.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(target.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		return canCreateLogicalLinkInternal(source, sourceRequirement, target, targetCapability);
	}

	private IStatus canCreateLogicalLinkInternal(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		if (null == source) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (null == target) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (null != sourceRequirement) {
			if (!source.getRequirements().contains(sourceRequirement)) {
				return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
			}
			if (null != targetCapability) {
				return canCreateLogicalLinkInternal(sourceRequirement, targetCapability);
			}
			return canCreateLogicalLinkInternal(sourceRequirement, target);
		}

		// we know that sourceRequirement is null
		if (null != targetCapability) {
			if (target.getCapabilities().contains(targetCapability)) {
				return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
			}
			return canCreateLogicalLinkInternal(source, targetCapability);
		}
		return canCreateLogicalLinkInternal(source, target);
	}

	private IStatus canCreateLogicalLinkInternal(Requirement sourceRequirement,
			Capability targetCapability) {
		if (null != sourceRequirement.getLink()) {
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		// in core domain there are no logical links
		return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
	}

	private IStatus canCreateLogicalLinkInternal(Requirement sourceRequirement, Unit targetUnit) {
		assert null != sourceRequirement;
		assert null != targetUnit;

		// not strictly needed; may short cut loop
		if (null != sourceRequirement.getLink()) {
			return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
		}

		for (Iterator iter = targetUnit.getCapabilities().iterator(); iter.hasNext();) {
			Capability targetCapability = (Capability) iter.next();
			IStatus status = canCreateLogicalLinkInternal(sourceRequirement, targetCapability);
			if (status.isOK()) {
				return status;
			}
		}

		return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
	}

	private IStatus canCreateLogicalLinkInternal(Unit sourceUnit, Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetCapability;

		for (Iterator iter = sourceUnit.getRequirements().iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			IStatus status = canCreateLogicalLinkInternal(sourceRequirement, targetCapability);
			if (status.isOK()) {
				return status;
			}
		}

		return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
	}

	private IStatus canCreateLogicalLinkInternal(Unit sourceUnit, Unit targetUnit) {
		assert null != sourceUnit;
		assert null != targetUnit;

		for (Iterator iter = sourceUnit.getRequirements().iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			IStatus status = canCreateLogicalLinkInternal(sourceRequirement, targetUnit);
			if (status.isOK()) {
				return status;
			}
		}

		return DeployMatcherStatus.LOGICAL_LINK_NOT_POSSIBLE;
	}

}
