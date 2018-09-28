/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Matching logic for dependency links. Only considers whether or not a dependency link can be
 * established between a source unit (or a requirment of that unit) and a target unit (or a
 * capability of that target).
 */
public class DependencyLinkMatcher extends LinkMatcher {

	public IStatus canBeLinkSource(Unit unit) {
		if (null == unit) {
			return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		}

		// a unit that has initial install state == installed is already hosted
		if (InstallState.INSTALLED_LITERAL.equals(unit.getInitInstallState())) {
			return DeployMatcherStatus.CANNOT_ADD_DEPENDENCIES_TO_INSTALLED_UNIT;
		}

		// we have at least one requirement that is not satisfied
		for (Iterator iter = getDependencyRequirements(unit).iterator(); iter.hasNext();) {
			Requirement requirement = (Requirement) iter.next();
			if (requirement.getLink() == null) {
				return DeployMatcherStatus.MATCH_FOUND;
			}
		}
		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	public IStatus canBeLinkTarget(Unit unit) {
		assert null != unit;

		return booleanToStatus(0 < getDependencyCapabilities(unit).size());
	}

	public IStatus canCreateLink(Unit unit1, Unit unit2) {
		assert null != unit1;
		assert null != unit2;

		return canCreateLink(unit1, null, unit2, null);
	}

	public Set getPossibleLinks(Unit source, Unit target) {
		return getPossibleLinks(source, null, target, null);
	}

	public Set<LinkDescriptor> getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		assert null != source;
		assert null != target;

		Set<LinkDescriptor> linkSet = new HashSet<LinkDescriptor>();

		// MK 10/2/2006 removed to allow a unit to satisify its own requirement
		// motivated by need for an EJbModule's ejb-ref to be satisfied by the
		// EjbModule itself
		// a unit cannot provide itself with something it needs
		// if (source.equals(target)) {
		// return linkSet;
		// }

		LinkDescriptor[] links = getPossibleDependencyLinksInternalMain(source, sourceRequirement,
				target, targetCapability);
		for (int i = 0; i < links.length; i++) {
			// System.out.println (links[i]);
			linkSet.add(links[i]);
		}
		return linkSet;
	}

	/**
	 * Retrieve the possible dependency links between a source and a target.
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
	private LinkDescriptor[] getPossibleDependencyLinksInternalMain(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetUnit;

		if (null != sourceRequirement) {
			// sanity check
			if (!getDependencyRequirements(sourceUnit).contains(sourceRequirement)) {
				if (!isNonHostingRequirment(sourceUnit, sourceRequirement)) {
					return new LinkDescriptor[0];
				}

				/*
				 * if (!getDependencyRequirements(sourceUnit).contains( sourceRequirement)) { return new
				 * LinkDescriptor[0];
				 */}
			if (null != targetCapability) {
				return getPossibleDependencyLinksInternal(sourceUnit, sourceRequirement, targetUnit,
						targetCapability);
			}
			return getPossibleDependencyLinksInternal(sourceUnit, sourceRequirement, targetUnit);
		}

		// we know that sourceRequirement is null
		if (null != targetCapability) {
			if (!getDependencyCapabilities(targetUnit).contains(targetCapability)) {
				return new LinkDescriptor[0];
			}
			return getPossibleDependencyLinksInternal(sourceUnit, targetUnit, targetCapability);
		}
		return getPossibleDependencyLinksInternal(sourceUnit, targetUnit);
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
	private LinkDescriptor[] getPossibleDependencyLinksInternal(Unit sourceUnit,
			Requirement sourceRequirment, Unit targetUnit, Capability targetCapability) {
		assert null != sourceRequirment;
		assert null != targetCapability;

		// check that can create link
		IStatus canCreateStatus = canCreateDependencyLinkInternal(sourceRequirment, targetCapability);
		if (!canCreateStatus.isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create a link
		LinkDescriptor result[] = new LinkDescriptor[1];
		int statusCode = canCreateStatus.getCode();
		if (0 == statusCode) {
			result[0] = getLinkDescriptorFactory().createLinkDescriptor(LinkType.DEPENDENCY,
					sourceUnit, sourceRequirment, targetUnit, targetCapability);
		} else {
			result[0] = getLinkDescriptorFactory().createLinkDescriptor(LinkType.DEPENDENCY,
					sourceUnit, sourceRequirment, targetUnit, targetCapability, statusCode);
		}
		return result;
	}

	/**
	 * Retrieve the possible dependency links that can be created between a source unit and a target
	 * capability; that is, between any of the source units requirements and the target capability.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceUnit
	 *           source unit
	 * @param targetCapability
	 *           target capability
	 * @return list of possible dependency links
	 */
	private LinkDescriptor[] getPossibleDependencyLinksInternal(Unit sourceUnit, Unit targetUnit,
			Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetCapability;

		// check that can create link
		if (!canCreateDependencyLinkInternal(sourceUnit, targetCapability).isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create at least one link
		ArrayList<LinkDescriptor> sldSet = new ArrayList<LinkDescriptor>();

		for (Iterator iter = getDependencyRequirements(sourceUnit).iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			LinkDescriptor[] links = getPossibleDependencyLinksInternal(sourceUnit, sourceRequirement,
					targetUnit, targetCapability);
			if (0 != links.length) {
				sldSet.add(links[0]);
			}
		}

		return MatcherUtils.asArray(sldSet);
	}

	/**
	 * Retrieve the possible dependency links that can be created between a source requirement and a
	 * target unit; that is, with any of the targetUnit's capabilities.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceRequirement
	 *           source requirement
	 * @param targetUnit
	 *           target unit
	 * @return list of possible dependency links
	 */
	private LinkDescriptor[] getPossibleDependencyLinksInternal(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit) {
		assert null != sourceRequirement;
		assert null != targetUnit;

		// check that can create link
		if (!canCreateDependencyLinkInternal(sourceRequirement, targetUnit).isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create at least one link
		ArrayList<LinkDescriptor> sldSet = new ArrayList<LinkDescriptor>();

		for (Iterator iter = getDependencyCapabilities(targetUnit).iterator(); iter.hasNext();) {
			Capability targetCapability = (Capability) iter.next();
			LinkDescriptor[] links = getPossibleDependencyLinksInternal(sourceUnit, sourceRequirement,
					targetUnit, targetCapability);
			if (0 != links.length) {
				sldSet.add(links[0]);
			}
		}

		return MatcherUtils.asArray(sldSet);
	}

	/**
	 * Retrieve the possible dependency links that can be created between a source unit and a target
	 * unit; that is, between any of the source units requirements and any of the targetUnit's
	 * capabilities.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceUnit
	 *           source unit
	 * @param targetUnit
	 *           target unit
	 * @return list of possible dependency links
	 */
	private LinkDescriptor[] getPossibleDependencyLinksInternal(Unit sourceUnit, Unit targetUnit) {
		assert null != sourceUnit;
		assert null != targetUnit;

		// check that can create link
		if (!canCreateDependencyLinkInternal(sourceUnit, targetUnit).isOK()) {
			return new LinkDescriptor[0];
		}

		// we can create at least one link
		ArrayList<LinkDescriptor> sldSet = new ArrayList<LinkDescriptor>();

		for (Iterator iter = getDependencyRequirements(sourceUnit).iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			LinkDescriptor[] links = getPossibleDependencyLinksInternal(sourceUnit, sourceRequirement,
					targetUnit);
			for (int i = 0; i < links.length; i++) {
				sldSet.add(links[i]);
			}
		}

		return MatcherUtils.asArray(sldSet);
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		// MK 12/19/2006 removed assert
		// assert null != unit;
		if (null == unit) {
			return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		}

		// if we are given the requirement we check that it is not satisfied
		if (null != requirement) {
			// complain if the unit is not in the unit
			if (!getDependencyRequirements(unit).contains(requirement)) {
				if (!isNonHostingRequirment(unit, requirement)) {
					// // MK 4/11/2006 we have a problem if the requirement was
					// created from a capability
					// // in this case the requirement is new and won't be in
					// the list. We need to compare
					// // the values instead. Eventually, this code should be
					// removed.
					// // TODO remove this code when migration to
					// capabilities/requirements complete
					return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
				}

				return booleanToStatus(requirement.getLink() == null);
			}
		}
		// we check the unit (ie, look at all requirements) if requirement was
		// null
		return canBeLinkSource(unit);
	}

	public IStatus canBeLinkTarget(Unit unit, Capability targetCapability) {
		assert null != unit;

		assert null == targetCapability || getDependencyCapabilities(unit).contains(targetCapability);

		if (null != targetCapability) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// check all
		return canBeLinkTarget(unit);
	}

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		assert null != source;
		assert null != target;

		// a unit that has initial install state == installed is already hosted
		if (InstallState.INSTALLED_LITERAL.equals(source.getInitInstallState())) {
			return DeployMatcherStatus.INSTALLED_UNIT_CANNOT_BE_SOURCE;
		}

		// MK 9/25/2006 we do want to allow this after all
		// (for ejb requirements on ejb module)
		// // a unit cannot provide itself with something it needs
		// if (source.equals(target)) {
		// return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		// }

		return canCreateDependencyLinkInternal(source, sourceRequirement, target, targetCapability);
	}

	private IStatus canCreateDependencyLinkInternal(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		assert null != source;
		assert null != target;

		if (null != sourceRequirement) {
			if (!getDependencyRequirements(source).contains(sourceRequirement)) {
				if (!isNonHostingRequirment(source, sourceRequirement)) {
					return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
				}
			}
			if (null != targetCapability) {
				return canCreateDependencyLinkInternal(sourceRequirement, targetCapability);
			}
			return canCreateDependencyLinkInternal(sourceRequirement, target);
		}

		// we know that sourceRequirement is null
		if (null != targetCapability) {
			// 8/22/2006 added !
			if (!getDependencyCapabilities(target).contains(targetCapability)) {
				return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
			}
			return canCreateDependencyLinkInternal(source, targetCapability);
		}
		return canCreateDependencyLinkInternal(source, target);
	}

	private IStatus canCreateDependencyLinkInternal(Requirement sourceRequirement,
			Capability targetCapability) {
		if (null != sourceRequirement.getLink()) {
			return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		}

		if (!sourceRequirement.isPublic()) {
			return DeployMatcherStatus.PRIVATE_REQUIREMENT_CANNOT_BE_LINK_SOURCE;
		}
		if (!targetCapability.isPublic()) {
			return DeployMatcherStatus.PRIVATE_CAPABILITY_CANNOT_BE_LINK_TARGET;
		}

		EClass requirementType = sourceRequirement.getDmoEType();
		if (null == requirementType) {
			// Bugzilla 11435: default to CAPABILITY instead of error
			requirementType = CorePackage.Literals.CAPABILITY;
			// return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		}

		if (RequirementUsage.PROHIBITED_LITERAL.equals(sourceRequirement.getUse())) {
			return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		}

		boolean capIsConceptual = ValidatorUtils.getUnit(targetCapability).isConceptual();

		// AT 4/10/07 relaxed matching rules for dependency links
		if (requirementType.isSuperTypeOf(targetCapability.getEObject().eClass()) || capIsConceptual
				&& targetCapability.getEObject().eClass().isSuperTypeOf(requirementType)) {
//		if (requirementType.isSuperTypeOf(targetCapability.getEObject().eClass())) {

			if (!DeployModelObjectUtil.isSettable(targetCapability) && !capIsConceptual) {
				// if capability is not mutable and is not conceptual then we must fully validate it 
				if (RequirementUtil.validate(sourceRequirement, evalContext(targetCapability)).isOK()) {
					return DeployMatcherStatus.createDependencyMatchFound(100);
				} else {
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				}
			}

			// MK 2/20/2007 evaluate all the requirement expressions to get a percentage satisified
			List reqExpressions = sourceRequirement.getExpressions();
			int numExpressionsSatisfied = 0;
			ReqEvaluationContext reqEvalContext = evalContext(targetCapability);
			for (int i = 0; i < reqExpressions.size(); i++) {
				RequirementExpression expression = (RequirementExpression) reqExpressions.get(i);
				String attrName = expression.getAttributeName();
				if (RequirementUtil.validateRequirementExpression(expression, reqEvalContext).isOK()) {
					numExpressionsSatisfied++;
					continue;
				}

				// validation failed; if attribute is immutable we must fail
				if (!DeployModelObjectUtil.isSettable(targetCapability, attrName)) {
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				}
			}
			int reMatchWeight = (int) Math.round(50.0 * (1.0 + (numExpressionsSatisfied + 1.0)
					/ (1.0 + reqExpressions.size())));

			// make constraint match weight 100% by default
			int[] constraintMatchWeight = new int[1];
			constraintMatchWeight[0] = 100;
			IStatus cStatus = ConstraintUtil.validateForMatchChildConstraintsOnRequirement(
					sourceRequirement, targetCapability, constraintMatchWeight);
			if (!cStatus.isOK()) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}

			// MK 2/20/2007 if we have a Reference we should do more work.
			int referenceInterfaceMatch = 100;
			if (sourceRequirement instanceof Reference) {
				IStatus result = RequirementUtil.validateReferenceExtensions(
						(Reference) sourceRequirement, reqEvalContext);
				if (!result.isOK()) {
					if (!DeployModelObjectUtil.isSettable(sourceRequirement)
							&& !DeployModelObjectUtil.isSettable(targetCapability)) {
						return DeployMatcherStatus.MATCH_NOT_FOUND;
					} else {
						// indicate that it's not a 100% match: just make it 75...
						referenceInterfaceMatch = 75;
					}
				}
			}

			return DeployMatcherStatus.createDependencyMatchFound(Math.min(Math.min(reMatchWeight,
					constraintMatchWeight[0]), referenceInterfaceMatch));
		}
		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	private IStatus canCreateDependencyLinkInternal(Requirement sourceRequirement, Unit targetUnit) {
		assert null != sourceRequirement;
		assert null != targetUnit;

		// not strictly needed; may short cut loop
		if (null != sourceRequirement.getLink()) {
			return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
		}

		for (Iterator iter = getDependencyCapabilities(targetUnit).iterator(); iter.hasNext();) {
			Capability targetCapability = (Capability) iter.next();
			IStatus status = canCreateDependencyLinkInternal(sourceRequirement, targetCapability);
			if (status.isOK()) {
				return status;
			}
		}

		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	private IStatus canCreateDependencyLinkInternal(Unit sourceUnit, Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetCapability;

		for (Iterator iter = getDependencyRequirements(sourceUnit).iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			IStatus status = canCreateDependencyLinkInternal(sourceRequirement, targetCapability);
			if (status.isOK()) {
				return status;
			}
		}

		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	private IStatus canCreateDependencyLinkInternal(Unit sourceUnit, Unit targetUnit) {
		assert null != sourceUnit;
		assert null != targetUnit;

		for (Iterator iter = getDependencyRequirements(sourceUnit).iterator(); iter.hasNext();) {
			Requirement sourceRequirement = (Requirement) iter.next();
			IStatus status = canCreateDependencyLinkInternal(sourceRequirement, targetUnit);
			if (status.isOK()) {
				return status;
			}
		}

		return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
	}

	private boolean isNonHostingRequirment(Unit unit, Requirement requirement) {
		// MK 4/11/2006 we have a problem if the requirement was created from a
		// capability
		// in this case the requirement is new and won't be in the list. We need
		// to compare
		// the values instead. Eventually, this code should be removed.
		// TODO remove this code when migration to capabilities/requirements
		// complete
		for (Iterator requirements = getDependencyRequirements(unit).iterator(); requirements
				.hasNext();) {
			Requirement req = (Requirement) requirements.next();
			if (null == requirement.getDmoEType()) {
				return false;
			}
			if (requirement.getDescription() == null && req.getDescription() == null
					|| requirement.getDescription().equals(req.getDescription())
					&& requirement.getDisplayName() == null && req.getDisplayName() == null
					|| requirement.getDisplayName().equals(req.getDisplayName())
					&& requirement.isMutable() == req.isMutable() && requirement.getName() == null
					&& req.getName() == null || requirement.getName().equals(req.getName())
					&& requirement.getDmoEType().isSuperTypeOf(req.getEObject().eClass())
					&& requirement.getDmoEType().isSuperTypeOf(req.getEObject().eClass())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return all of the dependency requirments of a unit. This includes those that are those with
	 * linkType DEPENDENCY and those with linkType ALL
	 * 
	 * @param unit
	 *           the unit to search
	 * @return list of requirements
	 */
	private static List getDependencyRequirements(Unit unit) {
		return unit.getDependencyOrAnyRequirements();
	}

	/**
	 * Return all of the dependency capabilities of a unit. This includes those that are those with
	 * linkType DEPENDENCY and those with linkType ALL
	 * 
	 * @param unit
	 *           the unit to search
	 * @return list of capabilities
	 */
	private static List getDependencyCapabilities(Unit unit) {
		return unit.getDependencyOrAnyCapabilities();
	}
}
