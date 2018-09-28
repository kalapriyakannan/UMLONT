/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Domain matcher that always returns {@DeployMatcherStatus.MATCH_NOT_FOUND}.
 */
public class NegativeDomainMatcher extends CoreDomainMatcher {

//	private LinkMatcherStrategy dependencyLinkMatcherStrategy = new DependencyLinkMatcherStrategy(
//			new NegativeDependencyLinkMatcher());
//
//	private LinkMatcherStrategy hostingLinkMatcherStrategy = new HostingLinkMatcherStrategy(
//			new NegativeHostingLinkMatcher());
//
//	private LinkMatcherStrategy logicalLinkMatcherStrategy = new LogicalLinkMatcherStrategy(
//			new NegativeLogicalLinkMatcher());
//
//	private LinkMatcherStrategy memberLinkMatcherStrategy = new MemberLinkMatcherStrategy(
//			new NegativeMemberLinkMatcher());
//
//	private LinkMatcherStrategy realizationLinkMatcherStrategy = new RealizationLinkMatcherStrategy(
//			new NegativeRealizationLinkMatcher());
//
	/**
	 * Constructor.
	 */
	public NegativeDomainMatcher() {
		super(new LinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				if (LinkType.DEPENDENCY.equals(linkType)) {
					return new NegativeDependencyLinkMatcher();
				} else if (LinkType.HOSTING.equals(linkType)) {
					return new NegativeHostingLinkMatcher();
				} else if (LinkType.CONSTRAINT.equals(linkType)) {
					return new NegativeConstraintLinkMatcher();
				} else if (LinkType.MEMBER.equals(linkType)) {
					return new NegativeMemberLinkMatcher();
				} else if (LinkType.REALIZATION.equals(linkType)) {
					return new NegativeRealizationLinkMatcher();
				}
				return null;
			}

			public LinkMatcher getLinkMatcher(LinkType linkType,
					AbstractLinkDescriptorFactory descriptorFactory) {
				return getLinkMatcher(linkType);
			}
		});
//		setLinkMatcherStrategy(LinkType.DEPENDENCY, dependencyLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.HOSTING, hostingLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.LOGICAL, logicalLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.MEMBER, memberLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.REALIZATION, realizationLinkMatcherStrategy);
	}

	/**
	 * Constructor to create a domain matcher using a new matcher factory. This allows one to replace
	 * the default matching logic completely.
	 * 
	 * @param matcherFactory
	 */
	public NegativeDomainMatcher(LinkMatcherFactory matcherFactory) {
		super(matcherFactory);
	}

	/**
	 * Constructor to create a domain matcher that uses a new matching strategy and new link type
	 * matchers.
	 * 
	 * @param strategyFactory
	 * @param matcherFactory
	 */
	public NegativeDomainMatcher(LinkMatcherStrategyFactory strategyFactory,
			LinkMatcherFactory matcherFactory) {
		super(strategyFactory, matcherFactory);
	}
}
