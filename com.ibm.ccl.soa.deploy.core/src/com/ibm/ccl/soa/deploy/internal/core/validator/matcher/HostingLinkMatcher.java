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
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Matching logic for hosting links.
 */
public class HostingLinkMatcher extends LinkMatcher {

	public Set<LinkDescriptor> getPossibleLinks(Unit host, Unit hostee) {
		HashSet<LinkDescriptor> links = new HashSet<LinkDescriptor>();
		IStatus status = canCreateLink(host, hostee);
		if (status.isOK()) {
			links.add(getLinkDescriptorFactory().createLinkDescriptor(LinkType.HOSTING, host, hostee,
					status.getCode()));
		}

		return links;
	}

	public IStatus canBeLinkSource(Unit unit) {
		if (null == unit) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}

		// cannot host a private unit in an import topology
		if (unit.getTopology() != unit.getEditTopology()) {
			if (!unit.getTopology().getConfigurationContract().isPublic(unit)) {
				return DeployMatcherStatus.PRIVATE_UNIT_CANNOT_BE_HOST;
			}
		}

		int hostingSize = getOnlyHostingCapabilites(unit).size();
		if (hostingSize == 0 && unit.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(unit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// we consume at least one capability that is not satisfied
		return booleanToStatus(0 < getHostingCapabilities(unit).size());
	}

	public IStatus canBeLinkTarget(Unit unit) {

		// cannot host a private unit in an imported topology
		if (unit.getTopology() != unit.getEditTopology()) {
			if (!unit.getTopology().getConfigurationContract().isPublic(unit)) {
				return DeployMatcherStatus.PRIVATE_UNIT_CANNOT_BE_HOSTED;
			}
		}

		// MK 6/18/2007 Defect 1876; do not consider init install state in decisions
//		if (InstallState.INSTALLED_LITERAL.equals(unit.getInitInstallState())) {
//			// MK 6/15/2007 added check to address defect 2110
//			if (!unit.isConceptual()) {
//				return DeployMatcherStatus.INSTALLED_UNIT_CANNOT_BE_HOSTED;
//			}
//		}

		// added for M3 to support hosting of software components (without a
		// source or hosting requirements) to conceptual nodes
		// re-evaluate post M3
		if (unit instanceof SoftwareComponent) {
			List requirements = unit.getOnlyHostingRequirements();
			int requirmentSize = 0;
			if (requirements != null) {
				requirmentSize = requirements.size();
				// BA 2007/03/01 getHost() to getImmediateHost()
				if (requirmentSize == 0 && null == ValidatorUtils.getImmediateHost(unit)) {
					return DeployMatcherStatus.MATCH_FOUND;
				}
			}

		}

		// prevent hosting of conceptual nodes
		if (unit.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(unit.getEObject().eClass())) {
			// MK 6/19/2007 Defect 2093: allow conceptual nodes to host conceptual nodes
			// return booleanToStatus(false);
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// we consume a hosting requirement AND we are not currently hosted
		// BA 2007/03/01 getHost() to getImmediateHost()
		return booleanToStatus(getHostingRequirements(unit).size() > 0
				&& (null == ValidatorUtils.getImmediateHost(unit) || unit.isConceptual()));
		// Removed in V8M5 to allow multiple hosting for conceptual Units
		// && null == ValidatorUtils.getImmediateHost(unit));
	}

	public IStatus canCreateLink(Unit host, Unit hostee) {
		assert null != host;
		assert null != hostee;

		// MK 6/18/2007 Defect 1876; do not consider init install state in decisions
//		// a unit that has initial install state == installed is already hosted
//		if (InstallState.INSTALLED_LITERAL.equals(hostee.getInitInstallState())) {
//			// MK 6/15/2007 added check to address defect 2110
//			if (!hostee.isConceptual()) {
//				return DeployMatcherStatus.INSTALLED_UNIT_CANNOT_BE_HOSTED;
//			}
//		}

		// a unit cannot host itself
		if (host.equals(hostee)) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}

		// if host/hostee from imported topology must be public
		if (host.getTopology() != host.getEditTopology()) {
			if (!host.getTopology().getConfigurationContract().isPublic(host)) {
				return DeployMatcherStatus.PRIVATE_UNIT_CANNOT_BE_HOST;
			}
		}
		if (hostee.getTopology() != hostee.getEditTopology()) {
			if (!hostee.getTopology().getConfigurationContract().isPublic(hostee)) {
				return DeployMatcherStatus.PRIVATE_UNIT_CANNOT_BE_HOSTED;
			}
		}

		if (host.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(host.getEObject().eClass())) {
			int size = getHostingCapabilities(host).size();
			if (size == 0) {
				return DeployMatcherStatus.MATCH_FOUND;
			}
		}

		// MDE 2008/01/03 allow if the hostee is conceptual regardless 
		// of its hosting requirements or other known hosts
		// MK 2008/1/10 but limit this to only conceptual units with no hosting requirements
		// otherwise can host any conceptual unit anywhere
		if (hostee.isConceptual()) {
			if (0 == getHostingRequirements(hostee).size()) {
				return DeployMatcherStatus.MATCH_FOUND;
			}
		}

		// check if the host has any UnitFilters associated with it and if it does
		// make sure that the hostee is allowed by at least one of those filters
		// M4 allow all by default unless UnitFilter.getAllowableUnitHostingTypes()
		// returns something other than null.
		boolean hosteeAllowed = true;
		//5600: No longer use UnitFilter for matching logic.  Use LinkMatchFilter.
//		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager.getInstance()
//				.findEnabledTopologyUnitFiltersByInputOnly(host);
//		for (int i = 0; enabledFilters != null && i < enabledFilters.length; i++) {
//			UnitFilter filter = enabledFilters[i].createUnitFilter();
//			List unitTypes = filter.getAllowableUnitHostingTypes(host);
//			if (unitTypes != null) {
//				hosteeAllowed = false;
//				for (int j = 0; !hosteeAllowed && j < unitTypes.size(); j++) {
//					EClass type = (EClass) unitTypes.get(j);
//					if (type != null && type.isSuperTypeOf(hostee.eClass())) {
//						hosteeAllowed = true;
//					}
//				}
//				if (hosteeAllowed) {
//					break;
//				}
//			}
//		}

		// if hosteeAllowed is false then we should not allow hosting
		if (!hosteeAllowed) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}

		List hostingRequirements = getHostingRequirements(hostee);

		// if hostee already hosted somewhere then return false
		// we need only look in the current topology since we know that the
		// hostee's initial install state is not "installed". This means that if
		// there is a hosting link it must be in the current topology.
		// BA 2007/03/01 getHost() to getImmediateHost()
		if (null != ValidatorUtils.getImmediateHost(hostee)) {
			if (!hostee.isConceptual()) {
				return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
			}
		}

		// MK: 2/19/2007
		// replaced the loop below with reference to newly defined method hostingRequirementsSatisfied
		// common code with realization link matching
//		if (hostingRequirementsSatisfied(hostingRequirements, host)) {
//			return DeployMatcherStatus.MATCH_FOUND;
//		}
//		
//		return DeployMatcherStatus.MATCH_NOT_FOUND;

		// this is a shortcut check; matchedAtLeastOne boolean would do this as
		// well
		// it is needed to hand
		// requirment.getUse().equals(RequirementUsage.PROHIBITED_LITERAL)
		// if hostee has no hosting requirements then return false
		if (0 == hostingRequirements.size()) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}
		// for each hosting requirement see that is matched by a provided
		// capability
		boolean matchedAtLeastOne = false;
		int[] matchWeight = new int[] { 100 };
		for (Iterator requirements = hostingRequirements.iterator(); requirements.hasNext();) {
			Requirement requirement = (Requirement) requirements.next();

			EClass requirementType = requirement.getDmoEType();
			if (null == requirementType) {
				// Bugzilla 11435: default to CAPABILITY instead of error
				requirementType = CorePackage.Literals.CAPABILITY;
				// return DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE;
			}

			if (RequirementUsage.PROHIBITED_LITERAL.equals(requirement.getUse())) {
				continue;
			}

			boolean foundMatch = false;
			for (Iterator capabilities = getHostingCapabilities(host).iterator(); capabilities
					.hasNext();) {
				Capability capability = (Capability) capabilities.next();

				// the following replaces the commented code below

				// AT 4/10/07 relaxed rules for hosting on conceptual units
				if (requirementType.isSuperTypeOf(capability.getEObject().eClass())
						|| host.isConceptual()
						&& capability.getEObject().eClass().isSuperTypeOf(requirementType)) {
					//	if (requirementType.isSuperTypeOf(capability.getEObject().eClass())) {
					if (!DeployModelObjectUtil.isSettable(capability)
							&& !DeployModelObjectUtil.isConceptual(capability)) {
						// if not mutable andn is not conceptual, then capability value fixed; we have to fully validate it
						if (RequirementUtil.validate(requirement, evalContext(capability)).isOK()) {
							foundMatch = true;
							matchedAtLeastOne = true;
							break;
						}
					} else {
						// if the referenced attributes are immutable we may still have a match
						List<RequirementExpression> exprs = requirement.getExpressions();
						boolean reMatch = true;
						for (int i = 0; i < exprs.size(); i++) {
							RequirementExpression expr = exprs.get(i);
							if (!DeployModelObjectUtil.isSettable(capability, expr.getAttributeName())) {
								IStatus status = RequirementUtil.validateRequirementExpression(expr,
										evalContext(capability));
								if (!status.isOK()) {
									reMatch = false;
									break;
								}
							}
						}

						if (reMatch) {
							// now check the constraints
							IStatus cStatus = ConstraintUtil
									.validateForMatchChildConstraintsOnRequirement(requirement, capability,
											matchWeight);
							if (cStatus.isOK()) {
								foundMatch = true;
								matchedAtLeastOne = true;
								break;
							}
						}
					}
				}
			}

			// TP - 04/09/07 M5
			// if no capability can be found whose dmoType matches the dmoType of the requirement
			// and the requirement's use property is not set to OPTIONAL then hosting is not possible
			if (!foundMatch && RequirementUsage.OPTIONAL != requirement.getUse().getValue()) {
				return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
			}
		}

		if (!matchedAtLeastOne) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}

		//MK 2/25/2007 this code should have been removed to correct problems introduced in 1.23
//		// if host has additional member units then all hosting requirements
//		// of the host's members must also be satisfied in order to create
//		// a link
//		if( !allHostingRequirementsSatisfied( hostee, host ) ) {
//			return DeployMatcherStatus.MATCH_NOT_FOUND;
//		}
//		
//		
//		// if hostee is a member of another unit ( or ancestor there of )
//		// that is already hosted then a hosting link directly on the
//		// proposed hostee is invalid
//		if( ValidatorUtils.isHosted( hostee ) ) {
//			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
//		}
//
		// found that all hostee hosting requirements were unlinked and
		// that each had a corresponding capability in the proposed host
//		if (matchWeight == null) {
//			return DeployMatcherStatus.MATCH_FOUND;
//		}
		return new Status(IStatus.OK, DeployCorePlugin.PLUGIN_ID, matchWeight[0],
				DeployCoreMessages.DeployMatcherStatus_Match_found_, null);
//		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if a list of hosting requirements is satisfied by a candidate host unit.
	 * 
	 * @param hostingRequirements
	 *           list of hosting requirements
	 * @param candidateHost
	 *           candidate host {@link Unit}
	 * @return true if the candidate host unit satisfies all of the hosting reqiurements; false
	 *         otherwise. If the list is null or empty, false is returned (the source does not need
	 *         to be hosted).
	 */
	public static boolean hostingRequirementsSatisfied(List hostingRequirements, Unit candidateHost) {
		if (null == hostingRequirements || null == candidateHost) {
			return false;
		}

		// if hostee has no hosting requirements then return false
		if (0 == hostingRequirements.size()) {
			return false;
		}

		// for each hosting requirement see that is matched by a provided
		// capability
		boolean matchedAtLeastOne = false;
		for (Iterator requirements = hostingRequirements.iterator(); requirements.hasNext();) {
			Requirement requirement = (Requirement) requirements.next();

			// ignore prohibited requirements
			if (RequirementUsage.PROHIBITED_LITERAL.equals(requirement.getUse())) {
				continue;
			}

			if (!hostingRequirementSatisifed(requirement, candidateHost)) {
				return false;
			}
			matchedAtLeastOne = true;
		}

		if (!matchedAtLeastOne) {
			return false;
		}

		return true;
	}

	/**
	 * Determine if a list of hosting requirements is satisfied by a candidate host unit.
	 * 
	 * @param hostingRequirements
	 *           list of hosting requirements
	 * @param candidateHost
	 *           candidate host {@link Unit}
	 * @return List of unsatisfied hosting requirements. List is emtpy if the candidate host unit
	 *         satisfies all of the hosting requirements.
	 */
	public static List unsatisfiedHostingRequirements(List hostingRequirements, Unit candidateHost) {
		ArrayList<Requirement> unsatisfiedRequirements = new ArrayList<Requirement>();
		if (null == hostingRequirements || null == candidateHost) {
			return unsatisfiedRequirements;
		}

		// if hostee has no hosting requirements then return false
		if (0 == hostingRequirements.size()) {
			return unsatisfiedRequirements;
		}

		// for each hosting requirement see that is matched by a provided
		// capability
		for (Iterator requirements = hostingRequirements.iterator(); requirements.hasNext();) {
			Requirement requirement = (Requirement) requirements.next();

			// ignore prohibited requirements
			if (RequirementUsage.PROHIBITED_LITERAL.equals(requirement.getUse())) {
				continue;
			}

			if (!hostingRequirementSatisifed(requirement, candidateHost)) {
				unsatisfiedRequirements.add(requirement);
			}
		}

		return unsatisfiedRequirements;
	}

	/**
	 * Determine if a list of hosting requirements is satisfied by a candidate host unit.
	 * 
	 * @param requirement
	 *           hosting requirement
	 * @param candidateHost
	 *           candidate host {@link Unit}
	 * @return true if the candidate host unit satisfies the hosting reqiurement; false otherwise. If
	 *         the requirement is null, false is returned (the source does not need to be hosted).
	 */
//	private static boolean hostingRequirementSatisifed (Requirement requirement, Unit candidateHost) {
//		if (null == requirement) {
//			return false;
//		}
//		
//		// requirements of the wrong type result in failure
//		if (!RequirementLinkTypes.HOSTING_LITERAL.equals(requirement.getLinkType())) {
//			return false;
//		}
//		
//		// prohibited requirements are satisfied
//		if (RequirementUsage.PROHIBITED_LITERAL.equals(requirement.getUse())) {
//			return true;
//		}
//
//		EClass requirementType = requirement.getDmoEType();
//		if (null == requirementType) {
//			// Bugzilla 11435: default to CAPABILITY instead of error
//			requirementType = CorePackage.Literals.CAPABILITY;
//			// return false;
//		}
//		
//		for (Iterator capabilities = getHostingCapabilities(candidateHost).iterator(); capabilities.hasNext();) {
//			Capability capability = (Capability) capabilities.next();
//
//			if (requirementType.isSuperTypeOf(capability.getEObject().eClass())) {
//				if (!capability.isMutable()) {
//					// if not mutable then capability value fixed; we
//					// compare to it
//					IStatus status = RequirementUtil.validate(requirement, evalContext(capability));
//					if (status.isOK()) {
//						return true;
//					}
//				} else {
//					return true;
//				}
//			}
//		}
//		
//		// we didn't find a suitable capability
//		return false;
//	}
	private static boolean hostingRequirementSatisifed(Requirement requirement, Unit candidateHost) {
		if (null == requirement) {
			return false;
		}

		// requirements of the wrong type result in failure
		if (!RequirementLinkTypes.HOSTING_LITERAL.equals(requirement.getLinkType())) {
			return false;
		}

		// prohibited requirements are satisfied
		if (RequirementUsage.PROHIBITED_LITERAL.equals(requirement.getUse())) {
			return true;
		}

		EClass requirementType = requirement.getDmoEType();
		if (null == requirementType) {
			// Bugzilla 11435: default to CAPABILITY instead of error
			requirementType = CorePackage.Literals.CAPABILITY;
			// return false;
		}

		for (Iterator capabilities = getHostingCapabilities(candidateHost).iterator(); capabilities
				.hasNext();) {
			Capability capability = (Capability) capabilities.next();

			// AT 4/10/07 relaxed rules for hosting on conceptual units
			if (requirementType.isSuperTypeOf(capability.getEObject().eClass())
					|| candidateHost.isConceptual()
					&& capability.getEObject().eClass().isSuperTypeOf(requirementType)) {
//			if (requirementType.isSuperTypeOf(capability.getEObject().eClass())) {
				if (!DeployModelObjectUtil.isSettable(capability)) {
					// if not mutable then capability value fixed; we
					// compare to it
					IStatus status = RequirementUtil.validate(requirement, evalContext(capability));
					if (status.isOK()) {
						return true;
					}
				} else {
					// if the referenced attributes are immutable we may still have a match
					List<RequirementExpression> exprs = requirement.getExpressions();
					for (int i = 0; i < exprs.size(); i++) {
						RequirementExpression expr = exprs.get(i);
						if (!DeployModelObjectUtil.isSettable(capability, expr.getAttributeName())) {
							IStatus status = RequirementUtil.validateRequirementExpression(expr,
									evalContext(capability));
							if (!status.isOK()) {
								return false;
							}
						}
					}

					// otherwise the target can be changed to enable the match
					return true;
				}
			}
		}

		// if optional requirement allow it
		if (RequirementUsage.OPTIONAL_LITERAL.equals(requirement.getUse())) {
			return true;
		}

		// we didn't find a suitable capability
		return false;
	}

	/**
	 * Determine if all of the hosting requirements of the hostee are satisfied by the host and
	 * recursivly check if all requirements of the hostee's members are satisfied by the host as
	 * well.
	 * 
	 * @param hostee
	 *           the unit that would be hosted by the host unit
	 * @param host
	 *           the unit that would host the hostee unit
	 * @return true if all hosting requirements of the hostee and all of it's members ( recursivly )
	 *         are statisfied by the host.
	 */
	protected boolean allHostingRequirementsSatisfied(Unit hostee, Unit host) {

		if (!hostingRequirementsSatisfied(getHostingRequirements(hostee), host)) {
			return false;
		}

		boolean hostingReqsSatisfied = true;
		List members = ValidatorUtils.getMembers(hostee);
		for (Iterator iter = members.iterator(); iter.hasNext() && hostingReqsSatisfied;) {
			Unit member = (Unit) iter.next();
			if (member != null) {
				hostingReqsSatisfied = allHostingRequirementsSatisfied(member, host);
			}
		}
		return true;
	}

	/**
	 * Return all of the hosting requirements of a unit. This includes those that are those with
	 * linkType HOSTING and those with linkType ALL
	 * 
	 * @param unit
	 *           the unit to search
	 * @return list of requirements
	 */
	private static List getHostingRequirements(Unit unit) {
		return unit.getHostingOrAnyRequirements();
	}

	/**
	 * Return all of the hosting capabilities of a unit. This includes those that are those with
	 * linkType HOSTING and those with linkType ALL
	 * 
	 * @param unit
	 *           the unit to search
	 * @return list of capabilities
	 */
	private static List getHostingCapabilities(Unit unit) {
		return unit.getHostingOrAnyCapabilities();
	}

	private List getOnlyHostingCapabilites(Unit unit) {
		return unit.getOnlyHostingCapabilities();
	}
}
