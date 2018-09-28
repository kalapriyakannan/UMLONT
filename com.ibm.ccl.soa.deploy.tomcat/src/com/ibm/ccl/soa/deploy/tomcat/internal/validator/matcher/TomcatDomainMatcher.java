/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Domain specific matcher for Tomcat.
 */
public class TomcatDomainMatcher extends CoreDomainMatcher {

//	private LinkMatcherStrategy hostingLinkMatcherStrategy = new HostingLinkMatcherStrategy(
//			new TomcatHostingLinkMatcher());
//
	/**
	 * Constructor
	 */
	public TomcatDomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				LinkMatcher matcher = super.getLinkMatcher(linkType);
				// domain specific changes to matcher here
				return matcher;
			}
		});
//		super();
//		setLinkMatcherStrategy(LinkType.HOSTING, hostingLinkMatcherStrategy);
	}
}
