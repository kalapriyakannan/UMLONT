/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkMatcherStrategyFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.NegativeDomainMatcher;

/**
 * Pattern for an "additive" domain matcher that adds single rules at a time.
 */
public class AdditiveDomainManager extends NegativeDomainMatcher {

	/**
	 * Constructor
	 */
	//TODO add other link types to this domain matcher pattern
	public AdditiveDomainManager() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				if (LinkType.DEPENDENCY.equals(linkType)) {
					AdditiveDependencyLinkMatcher dependencyMatcher = new AdditiveDependencyLinkMatcher();
					// classes that extend this Domain Manager would add matchers
					// dependencyMatcher.addMatcher (...);
					return dependencyMatcher;
				} else if (LinkType.HOSTING.equals(linkType)) {
					AdditiveHostingLinkMatcher hostingMatcher = new AdditiveHostingLinkMatcher();
					// classes that extend this Domain Manager would add matchers
					// hostingMatcher.addMatcher (...);
					return hostingMatcher;
				} else {
					return super.getLinkMatcher(linkType);
				}
			}
		});
//		super();
//		AdditiveDependencyLinkMatcher dependencyMatcher = new AdditiveDependencyLinkMatcher();
//		// classes that extend this Domain Manager would add matchers
//		// dependencyMatcher.addMatcher (...);
//
//		AdditiveHostingLinkMatcher hostingMatcher = new AdditiveHostingLinkMatcher();
//		// classes that extend this Domain Manager would add matchers
//		// hostingMatcher.addMatcher (...);
//
//		// now define the strategy and set it
//		LinkMatcherStrategy dependencyLinkMatcherStrategy = new DependencyLinkMatcherStrategy(
//				dependencyMatcher);
//		setLinkMatcherStrategy(LinkType.DEPENDENCY, dependencyLinkMatcherStrategy);
//
//		LinkMatcherStrategy hostingLinkMatcherStrategy = new HostingLinkMatcherStrategy(
//				hostingMatcher);
//		setLinkMatcherStrategy(LinkType.HOSTING, hostingLinkMatcherStrategy);
	}

	public AdditiveDomainManager(LinkMatcherFactory matcherFactory) {
		super(matcherFactory);
	}

	public AdditiveDomainManager(LinkMatcherStrategyFactory strategyFactory,
			LinkMatcherFactory matcherFactory) {
		super(strategyFactory, matcherFactory);
	}
}
