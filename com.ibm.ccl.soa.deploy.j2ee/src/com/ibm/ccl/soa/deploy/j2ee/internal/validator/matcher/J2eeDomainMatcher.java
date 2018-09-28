/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Domain specific matcher for J2EE.
 */
public class J2eeDomainMatcher extends CoreDomainMatcher {

	/**
	 * Constructor
	 */
	public J2eeDomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				LinkMatcher matcher = super.getLinkMatcher(linkType);
				if (LinkType.DEPENDENCY.equals(linkType)) {
					matcher.registerMatchFilter(new J2eeDependencyLinkMatcherFilter());
					matcher.registerAdditionalMatcher(new DatasourceDependencyMatcher());
				} else if (LinkType.HOSTING.equals(linkType)) {
					return new J2eeHostingLinkMatcher();
				} else {
					// do nothing special
				}
				return matcher;
			}
		});
	}
}
