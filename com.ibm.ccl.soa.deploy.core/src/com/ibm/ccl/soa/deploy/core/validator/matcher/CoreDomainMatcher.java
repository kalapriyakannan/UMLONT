/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.DefaultLinkMatcherStrategyFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkMatcherStrategy;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkMatcherStrategyFactory;

/**
 * Implements matching for the core domain types.
 * <p>
 * This class is typically extended by a matcher that wants to replace the core matcher by relaxing
 * or strengthening the core matching rules. To relax the rules, one would typically add additional
 * matchers to allow additional matches. To stengthen matching, one would typically introduce
 * filters to eliminate some matches.
 * 
 * @see LinkMatcher#registerAdditionalMatcher(LinkMatcher)
 * @see LinkMatcher#registerMatchFilter(LinkMatchFilter)
 */
public class CoreDomainMatcher extends DomainMatcher {

	/**
	 * Map of matching strategies.
	 */
	private final HashMap<LinkType, LinkMatcherStrategy> matcherStrategies = new HashMap<LinkType, LinkMatcherStrategy>();

	private LinkMatcherFactory linkMatcherFactory = new DefaultLinkMatcherFactory();
	private LinkMatcherStrategyFactory linkMatcherStrategyFactory = new DefaultLinkMatcherStrategyFactory();

	/**
	 * Construct a new core domain matcher.
	 */
	public CoreDomainMatcher() {
//		setLinkMatcherStrategy(LinkType.DEPENDENCY, new DependencyLinkMatcherStrategy(
//				new DependencyLinkMatcher()));
//		setLinkMatcherStrategy(LinkType.HOSTING, new HostingLinkMatcherStrategy(
//				new HostingLinkMatcher()));
//		setLinkMatcherStrategy(LinkType.LOGICAL, new LogicalLinkMatcherStrategy(
//				new LogicalLinkMatcher()));
//		setLinkMatcherStrategy(LinkType.MEMBER,
//				new MemberLinkMatcherStrategy(new MemberLinkMatcher()));
//		setLinkMatcherStrategy(LinkType.REALIZATION, new RealizationLinkMatcherStrategy(
//				new RealizationLinkMatcher()));
		initializeStrategies();
	}

	/**
	 * Constructor to create a domain matcher using a new matcher factory. This allows one to replace
	 * the default matching logic completely.
	 * 
	 * @param matcherFactory
	 */
	public CoreDomainMatcher(LinkMatcherFactory matcherFactory) {
		linkMatcherFactory = matcherFactory;
		initializeStrategies();
	}

	/**
	 * Constructor to create a domain matcher that uses a new matching strategy and new link type
	 * matchers.
	 * 
	 * @param strategyFactory
	 * @param matcherFactory
	 */
	public CoreDomainMatcher(LinkMatcherStrategyFactory strategyFactory,
			LinkMatcherFactory matcherFactory) {
		linkMatcherStrategyFactory = strategyFactory;
		linkMatcherFactory = matcherFactory;
		initializeStrategies();
	}

	private void initializeStrategies() {
		setLinkMatcherStrategy(LinkType.DEPENDENCY);
		setLinkMatcherStrategy(LinkType.HOSTING);
		setLinkMatcherStrategy(LinkType.CONSTRAINT);
		setLinkMatcherStrategy(LinkType.MEMBER);
		setLinkMatcherStrategy(LinkType.REALIZATION);
	}

	/**
	 * Override default link matcher strategy. Would be used, for exam[ple by a domain matcher
	 * extension.
	 * 
	 * @param type
	 *           link type to associate strategy with
	 */
	private void setLinkMatcherStrategy(LinkType type) {
		LinkMatcher matcher = linkMatcherFactory.getLinkMatcher(type);
		LinkMatcherStrategy strategy = linkMatcherStrategyFactory.getLinkMatcherStrategy(type,
				matcher);
		matcherStrategies.put(type, strategy);
	}

//	/**
//	 * Override default link matcher strategy. Would be used, for exam[ple by a domain matcher
//	 * extension.
//	 * 
//	 * @param type
//	 *           link type to associate strategy with
//	 * @param strategy
//	 *           the strategy
//	 * @deprecated {@use CoreDomainMatcher#setLinkMatcherStrategy(LinkType)}
//	 */
//	protected void setLinkMatcherStrategy(LinkType type, LinkMatcherStrategy strategy) {
//		matcherStrategies.put(type, strategy);
//	}
//
	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes) {
		return canBeLinkSource(unit, null, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes) {
		return canBeLinkSource(unit, requirement, linkTypes,
				DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes, int depth) {
		return canBeLinkSource(unit, null, linkTypes, depth);
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes,
			int depth) {
		if (null == unit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus status;
		for (int i = 0; i < LinkType.ALL_LINK_TYPES.length; i++) {
			if (LinkType.ALL_LINK_TYPES[i].memberOf(linkTypes)) {
				LinkMatcherStrategy strategy = matcherStrategies.get(LinkType.ALL_LINK_TYPES[i]);
				if (null == strategy) {
					continue;
				}
				status = strategy.canBeLinkSource(unit, requirement, depth);
				if (status.isOK()) {
					return status;
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes) {
		return canBeLinkTarget(unit, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes) {
		return canBeLinkTarget(unit, capability, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes, int depth) {
		return canBeLinkTarget(unit, null, linkTypes, depth);
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes, int depth) {
		if (null == unit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus status;
		for (int i = 0; i < LinkType.ALL_LINK_TYPES.length; i++) {
			if (LinkType.ALL_LINK_TYPES[i].memberOf(linkTypes)) {
				LinkMatcherStrategy strategy = matcherStrategies.get(LinkType.ALL_LINK_TYPES[i]);
				if (null == strategy) {
					continue;
				}

				status = strategy.canBeLinkTarget(unit, capability, depth);
				if (status.isOK()) {
					return status;
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes) {
		return canBeLinkEndpoint(unit, null, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes) {
		return canBeLinkEndpoint(unit, reqCap, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes, int depth) {
		return canBeLinkEndpoint(unit, null, linkTypes, depth);
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes,
			int depth) {
		if (null == unit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus status;
		for (int i = 0; i < LinkType.ALL_LINK_TYPES.length; i++) {
			if (LinkType.ALL_LINK_TYPES[i].memberOf(linkTypes)) {
				LinkMatcherStrategy strategy = matcherStrategies.get(LinkType.ALL_LINK_TYPES[i]);
				if (null == strategy) {
					continue;
				}
				status = strategy.canBeLinkEndpoint(unit, reqCap, depth);
				if (status.isOK()) {
					return status;
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes) {
		return canCreateLink(source, null, target, null, linkTypes,
				DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, LinkType[] linkTypes) {
		return canCreateLink(source, sourceRequirement, target, targetCapability, linkTypes,
				DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes, int depth) {
		return canCreateLink(source, null, target, null, linkTypes, depth);
	}

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, LinkType[] linkTypes, int depth) {
		if (null == source || null == target) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus currStatus = DeployMatcherStatus.MATCH_NOT_FOUND;
		IStatus retValStatus = DeployMatcherStatus.MATCH_NOT_FOUND;
		for (int i = 0; i < LinkType.ALL_LINK_TYPES.length; i++) {
			if (LinkType.ALL_LINK_TYPES[i].memberOf(linkTypes)) {
				LinkMatcherStrategy strategy = matcherStrategies.get(LinkType.ALL_LINK_TYPES[i]);
				if (null == strategy) {
					continue;
				}
				currStatus = strategy.canCreateLink(source, sourceRequirement, target,
						targetCapability, depth);
				if (currStatus.isOK()) {
					return currStatus;
				}
				// If a status not in DeployCore is found, return the first such found
//			    if (retValStatus.getPlugin().equals(DeployCorePlugin.PLUGIN_ID)) {
				// If non-MATCH_NOT_FOUND failure status has not already been saved, 
				// save current status if it is not a MATCH_NOT_FOUND status
				if (retValStatus.equals(DeployMatcherStatus.MATCH_NOT_FOUND)
						&& !currStatus.equals(DeployMatcherStatus.MATCH_NOT_FOUND)) {
					retValStatus = currStatus;
				}
			}
		}
		// Return last status from strategy loop check
		return retValStatus;
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes) {
		return getPossibleLinks(source, null, target, null, linkTypes,
				DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes) {
		return getPossibleLinks(source, sourceRequirement, target, targetCapability, linkTypes,
				DeployValidatorService.MATCHER_DEPTH_NONE);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes,
			int depth) {
		return getPossibleLinks(source, null, target, null, linkTypes, depth);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes, int depth) {
		if (null == source || null == target) {
			return new LinkDescriptor[0];
		}

		// get the possible links from the strategies
		ArrayList<LinkDescriptor[]> links = new ArrayList<LinkDescriptor[]>();
		for (int i = 0; i < LinkType.ALL_LINK_TYPES.length; i++) {
			if (LinkType.ALL_LINK_TYPES[i].memberOf(linkTypes)) {
				LinkMatcherStrategy strategy = matcherStrategies.get(LinkType.ALL_LINK_TYPES[i]);
				if (null == strategy) {
					continue;
				}
				LinkDescriptor[] desc = strategy.getPossibleLinks(source, sourceRequirement, target,
						targetCapability, depth);
				if (0 < desc.length) {
					links.add(desc);
				}
			}
		}

		// determine how large the resulting list will be
		int combinedSize = 0;
		for (int i = 0; i < links.size(); i++) {
			combinedSize += (links.get(i)).length;
		}

		// combine link descriptors
		int cumLength = 0;
		LinkDescriptor[] combinedLinks = new LinkDescriptor[combinedSize];
		for (int i = 0; i < links.size(); i++) {
			int newLength = (links.get(i)).length;
			System.arraycopy(links.get(i), 0, combinedLinks, cumLength, newLength);
			cumLength += newLength;
		}

		return combinedLinks;
	}

}
