/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Domain specific matcher for DB2.
 */
public class DB2DomainMatcher extends CoreDomainMatcher {

//	private LinkMatcherStrategy hostingLinkMatcherStrategy = new HostingLinkMatcherStrategy(
//			new DB2HostingLinkMatcher());
//	private LinkMatcherStrategy dependencyLinkMatcherStrategy = new DependencyLinkMatcherStrategy(
//			new DB2DependencyLinkMatcher());
//
	/**
	 * Constructor
	 */
	public DB2DomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			@Override
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				LinkMatcher matcher = super.getLinkMatcher(linkType);
				if (LinkType.DEPENDENCY.equals(linkType)) {
					matcher.registerMatchFilter(new DB2DependencyLinkFilter());
//					return new DB2DependencyLinkMatcher();
				} else if (LinkType.HOSTING.equals(linkType)) {
					matcher.registerAdditionalMatcher(new AdditionalDB2HostingLinkMatcher());
//					return new DB2HostingLinkMatcher();
				} else {
					// do nothing special
				}
				return matcher;
			}
		});
//		super();
//		setLinkMatcherStrategy(LinkType.HOSTING, hostingLinkMatcherStrategy);
//		setLinkMatcherStrategy(LinkType.DEPENDENCY, dependencyLinkMatcherStrategy);
	}
}
