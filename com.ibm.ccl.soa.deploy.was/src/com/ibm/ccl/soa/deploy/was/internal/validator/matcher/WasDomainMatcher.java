/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Domain matcher for Websphere.
 */
public class WasDomainMatcher extends CoreDomainMatcher {

//	private final LinkMatcherStrategy hostingLinkMatcherStrategy = new HostingLinkMatcherStrategy(
//			new WasHostingLinkMatcher());
//	private final LinkMatcherStrategy dependencyLinkMatcherStrategy = new DependencyLinkMatcherStrategy(
//			new WasDependencyLinkMatcher());
//	private final LinkMatcherStrategy memberLinkMatcherStrategy = new MemberLinkMatcherStrategy(
//			new WasMemberLinkMatcher());
//
	/**
	 * Constructor
	 */
	public WasDomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				AbstractLinkDescriptorFactory linkDescriptorFactory = new WasLinkDescriptorFactory();
				LinkMatcher matcher = super.getLinkMatcher(linkType, linkDescriptorFactory);
				if (LinkType.DEPENDENCY.equals(linkType)) {
					matcher.setLinkDescriptorFactory(linkDescriptorFactory);
					matcher.registerMatchFilter(new WasDependencyLinkMatcherFilter());
//					return new WasDependencyLinkMatcherFilter();
				} else if (LinkType.HOSTING.equals(linkType)) {
					matcher.setLinkDescriptorFactory(linkDescriptorFactory);
					matcher.registerMatchFilter(new WasHostingLinkMatcherFilter());
//					return new WasHostingLinkMatcher();
				} else if (LinkType.MEMBER.equals(linkType)) {
					matcher.setLinkDescriptorFactory(linkDescriptorFactory);
					matcher.registerMatchFilter(new WasMemberLinkMatcherFilter());
//					return new WasMemberLinkMatcher();
				} else {
					// nothing special
				}
				return matcher;
			}
		});
//		super();
//		setLinkMatcherStrategy(LinkType.HOSTING, hostingLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.DEPENDENCY, dependencyLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.MEMBER, memberLinkMatcherStrategy);
	}
}
