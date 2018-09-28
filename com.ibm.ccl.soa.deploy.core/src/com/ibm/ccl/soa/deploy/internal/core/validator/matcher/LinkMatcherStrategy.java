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
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;

/**
 * Default strategy class for determining matcher behavior for a particular link type. A link
 * strategy allows one to modify the definition of "source" and "target".
 */
public class LinkMatcherStrategy {

	/**
	 * Matcher to use for direct unit to unit matching
	 */
	private final LinkMatcher matcher;

	/**
	 * Constructor for link strategy.
	 * 
	 * @param matcher
	 *           a simple link matcher used by the strategy to determine unit to unit matching.
	 */
	public LinkMatcherStrategy(LinkMatcher matcher) {
		this.matcher = matcher;
	}

	/**
	 * Retrieve simple link matcher used by strategy to determine unit to unit matching.
	 * 
	 * @return the link matcher
	 */
	public LinkMatcher getMatcher() {
		return matcher;
	}

	/**
	 * Determine whether or not a {@link Unit} can be the source of a link.
	 * 
	 * @param unit
	 *           the unit to test
	 * @return status OK if the unit can be the source of a link
	 */
	public IStatus canBeLinkSource(Unit unit) {
		return canBeLinkSource(unit, 0);
	}

	/**
	 * Determine whether or not a {@link Unit}, {@link Requirement} pair can be the source of a
	 * link.
	 * 
	 * @param unit
	 *           the unit to test
	 * @param requirement
	 *           the requirement to test; can be null
	 * @return status OK if the unit can be the source of a link
	 */
	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		return canBeLinkSource(unit, requirement, 0);
	}

	/**
	 * Determine if a {@link Unit} can be a link source. The source may be a member or hosted
	 * configuration unit to a given depth. Unless overridden, only a depth of 0 will be considered.
	 * 
	 * @param unit
	 *           unit to test as source
	 * @param depth
	 *           depth to search
	 * @return OK status if the unit can be a link source
	 */
	public IStatus canBeLinkSource(Unit unit, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canBeLinkSource(unit);
	}

	/**
	 * Determine if a {@link Unit}, {@link Requirement} can be a link source. The source may be a
	 * member or hosted configuration unit to a given depth. Unless overridden, only a depth of 0
	 * will be considered.
	 * 
	 * @param unit
	 *           unit to test as source
	 * @param requirement
	 *           requirement of source unit to test
	 * @param depth
	 *           depth to search
	 * @return OK status if the unit can be a link source
	 */
	public IStatus canBeLinkSource(Unit unit, Requirement requirement, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canBeLinkSource(unit, requirement);
	}

	/**
	 * Determine if a {@link Unit} can be a link target.
	 * 
	 * @param unit
	 *           the unit to test
	 * @return status OK if the unit can be the target of a link
	 */
	public IStatus canBeLinkTarget(Unit unit) {
		return canBeLinkTarget(unit, 0);
	}

	/**
	 * Determine if a {@link Unit}, {@link Capability} pair can be a link target.
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @param capability
	 *           the capability to be tested; can be null
	 * @return status OK if can be a link target
	 */
	public IStatus canBeLinkTarget(Unit unit, Capability capability) {
		return canBeLinkTarget(unit, capability, 0);
	}

	/**
	 * Determine if a {@link Unit} can be a link target. The target may be a member or hosted
	 * configuration unit to a given depth. Unless overridden, only a depth of 0 will be considered.
	 * 
	 * @param unit
	 *           unit to test as target
	 * @param depth
	 *           depth to search
	 * @return OK status if the unit can be a link target
	 */
	public IStatus canBeLinkTarget(Unit unit, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canBeLinkTarget(unit);
	}

	/**
	 * Determine if a {@link Unit}, {@link Capability} can be a link target. The target may be a
	 * member or hosted configuration unit to a given depth. Unless overridden, only a depth of 0
	 * will be considered.
	 * 
	 * @param unit
	 *           unit to test as target
	 * @param capability
	 *           capability of target unit to test
	 * @param depth
	 *           depth to search
	 * @return OK status if the unit can be a link endpoint
	 */
	public IStatus canBeLinkTarget(Unit unit, Capability capability, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canBeLinkTarget(unit, capability);
	}

	/**
	 * Determine if a unit can be the endpoint (source or target) or a link.
	 * 
	 * @param unit
	 *           the unit to test
	 * @return status OK if the unit can be a link target
	 */
	public IStatus canBeLinkEndpoint(Unit unit) {
		return canBeLinkEndpoint(unit, 0);
	}

	/**
	 * Determine if a \<unit, requirement\> or \<unit, capability\> pair can be a link endpoint
	 * (source or target).
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @param reqCap
	 *           the requirement or capability to be tested
	 * @return status OK if can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap) {
		return canBeLinkEndpoint(unit, reqCap, 0);
	}

	/**
	 * Determine if a {@link Unit} can be a link endpoint (either source or target) where the target
	 * may be a member or hosted configuration unit to a given depth. Unless overridden, a depth of 0
	 * will be used.
	 * 
	 * @param unit
	 *           the unit
	 * @param depth
	 *           the target search depth
	 * @return status OK if unit can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canBeLinkEndpoint(unit);
	}

	/**
	 * Determine if a {@link Unit}, {@link Requirement} or {@link Unit}, {@link Capability} pair
	 * can be a link endpoint (either source or target) where the target may be a member or hosted
	 * configuration unit to a given depth. Unless overridden, a depth of 0 will be used.
	 * 
	 * @param unit
	 *           the unit
	 * @param reqCap
	 *           the requirement or capability; if a capability is non-null a depth of 0 is assumed
	 * @param depth
	 *           the target search depth
	 * @return status OK if unit can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canBeLinkEndpoint(unit, reqCap);
	}

	/**
	 * Determine if a link can be created between and a source and target unit.
	 * 
	 * @param source
	 *           the suggested source unit
	 * @param target
	 *           the suggested target unit
	 * @return status OK if link creation is possible.
	 */
	public IStatus canCreateLink(Unit source, Unit target) {
		return canCreateLink(source, target, 0);
	}

	/**
	 * Determine if a link can be directly created between and source unit and a target unit.
	 * 
	 * @param source
	 *           the source unit to be tested
	 * @param sourceReq
	 *           the source requirement to be tested
	 * @param target
	 *           the target unit to be tested
	 * @param targetCap
	 *           the target capability to be tested
	 * @return status OK if can create a link
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceReq, Unit target,
			Capability targetCap) {
		return canCreateLink(source, sourceReq, target, targetCap, 0);
	}

	/**
	 * Determine if a link can be implemented between source and target units where the target may be
	 * a member or hosted configuration to a given depth. Unless overridden, this depth is 0.
	 * 
	 * @param source
	 *           the source unit
	 * @param target
	 *           the target unit
	 * @param depth
	 *           the depth (default is 0)
	 * @return OK status if a link can be created
	 */
	public IStatus canCreateLink(Unit source, Unit target, int depth) {
		return canCreateLink(source, null, target, null, depth);
	}

	/**
	 * Determine if a link can be implemented between source and target units where the target may be
	 * a member or hosted configuration to a given depth. Unless overridden, this depth is 0.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceReq
	 *           the source requirement
	 * @param target
	 *           the target unit
	 * @param targetCap
	 *           the target capability unit
	 * @param depth
	 *           the depth (default is 0)
	 * @return OK status if a link can be created
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceReq, Unit target,
			Capability targetCap, int depth) {
		if (null == matcher) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return matcher.canCreateLink(source, sourceReq, target, targetCap);
	}

	/**
	 * Get Array of descriptors describing possible links that can be established between two units.
	 * The descriptor identifies the source unit/requirement and target unit/capability of the link.
	 * The source/target need not be the source/target parameters to this method since we might
	 * identify hosted ConfigurationUnits or group member Units as the ultimate source.
	 * 
	 * @param source
	 *           suggested source
	 * @param target
	 *           suggesedt target
	 * @return array (LinkDescriptor) of possible links between the source and target
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target) {
		return getPossibleLinks(source, target, 0);
	}

	/**
	 * Get a list of {@link LinkDescriptor} describing possible links that can be established between
	 * two units.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement to be tested
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability to be tested
	 * @return a set of possible link descriptors
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		return getPossibleLinks(source, sourceRequirement, target, targetCapability);

	}

	/**
	 * Get a list of {@link LinkDescriptor} describing possible links that can be established between
	 * two units where the units considered for the target may be member or hosted configuration
	 * units to a given depth.
	 * 
	 * @param source
	 *           the source unit
	 * @param target
	 *           the target unit
	 * @param depth
	 *           depth of search for target (default is 0)
	 * @return a list of {@link LinkDescriptor}
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, int depth) {
		if (null == matcher) {
			return new LinkDescriptor[0];
		}

		Set possibleLinks = matcher.getPossibleLinks(source, target);
		// Set possibleLinks = getPossibleLinksInternal(source, target);
		return MatcherUtils.asArray(possibleLinks);
	}

	/**
	 * Get a list of {@link LinkDescriptor} describing possible links that can be established between
	 * two units where the units considered for the target may be member or hosted configuration
	 * units to a given depth.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement
	 * @param target
	 *           the target capability; a non-null capability implies depth is 0
	 * @param targetCapability
	 *           the target unit
	 * @param depth
	 *           depth of search for target (default is 0)
	 * @return a list of {@link LinkDescriptor}
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, int depth) {
		if (null == matcher) {
			return new LinkDescriptor[0];
		}

		Set possibleLinks = matcher.getPossibleLinks(source, sourceRequirement, target,
				targetCapability);
		return MatcherUtils.asArray(possibleLinks);
	}

	protected Unit[] getConfigUnits(Unit unit) {
		if (unit == null) {
			return new Unit[0];
		}

		ArrayList resultList = new ArrayList();

		for (Iterator it = unit.getHostingLinks().iterator(); it.hasNext();) {
			HostingLink link = (HostingLink) it.next();
			Unit target = link.getTarget();
			if (null == target) {
				continue;
			}
			if (target.isConfigurationUnit()) {
				resultList.add(target);
			}
		}

		Unit[] result = new Unit[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = (Unit) resultList.get(i);
		}

		return result;
	}

	protected Unit[] getMembers(Unit unit) {
		if (unit == null) {
			return new Unit[0];
		}

		ArrayList resultList = new ArrayList();

		for (Iterator it = unit.getMemberLinks().iterator(); it.hasNext();) {
			MemberLink link = (MemberLink) it.next();
			Unit target = link.getTarget();
			if (null == target) {
				continue;
			}
			resultList.add(target);
		}

		Unit[] result = new Unit[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = (Unit) resultList.get(i);
		}

		return result;
	}

	protected LinkDescriptor[] descriptorsAsList(Set set, Unit logicalSource, Unit logicalTarget) {
		LinkDescriptor[] resultSet = new LinkDescriptor[set.size()];
		int i = 0;
		for (Iterator it = set.iterator(); it.hasNext();) {
			LinkDescriptor descriptor = (LinkDescriptor) it.next();
//			descriptor.setLogicalSource(logicalSource);
//			descriptor.setLogicalTarget(logicalTarget);
			resultSet[i++] = descriptor;
		}
		return resultSet;
	}

}
