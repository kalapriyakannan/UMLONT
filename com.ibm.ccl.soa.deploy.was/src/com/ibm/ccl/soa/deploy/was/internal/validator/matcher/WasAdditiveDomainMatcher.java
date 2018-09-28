/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.AdditiveDependencyLinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.AdditiveDomainManager;

/**
 * "Additive" domain matcher for Websphere.
 */
public class WasAdditiveDomainMatcher extends AdditiveDomainManager {

	/**
	 * Constructor
	 */
	public WasAdditiveDomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				if (LinkType.DEPENDENCY.equals(linkType)) {
					AdditiveDependencyLinkMatcher matcher = new AdditiveDependencyLinkMatcher();
					matcher.addMatcher(new SharedLibraryJarMatcher());
					return matcher;
				} else {
					return null;
				}
			}
		});
//		super();
//		
//		AdditiveDependencyLinkMatcher matcher = new AdditiveDependencyLinkMatcher();
//		matcher.addMatcher(new SharedLibraryJarMatcher());
//		LinkMatcherStrategy dependencyLinkMatcherStrategy = new DependencyLinkMatcherStrategy (matcher);
//		setLinkMatcherStrategy(LinkType.DEPENDENCY, dependencyLinkMatcherStrategy);
	}

}
