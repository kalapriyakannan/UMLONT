/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Default {@link LinkMatcherStrategyFactory} that returns default matcher strategies.
 */
public class DefaultLinkMatcherStrategyFactory extends LinkMatcherStrategyFactory {

	@Override
	public LinkMatcherStrategy getLinkMatcherStrategy(LinkType linkType, LinkMatcher matcher) {
		if (LinkType.DEPENDENCY.equals(linkType)) {
			return new DependencyLinkMatcherStrategy(matcher);
		} else if (LinkType.HOSTING.equals(linkType)) {
			return new HostingLinkMatcherStrategy(matcher);
		} else if (LinkType.CONSTRAINT.equals(linkType)) {
			return new ConstraintLinkMatcherStrategy(matcher);
		} else if (LinkType.MEMBER.equals(linkType)) {
			return new MemberLinkMatcherStrategy(matcher);
		} else if (LinkType.REALIZATION.equals(linkType)) {
			return new RealizationLinkMatcherStrategy(matcher);
		}
		return null;
	}
}
