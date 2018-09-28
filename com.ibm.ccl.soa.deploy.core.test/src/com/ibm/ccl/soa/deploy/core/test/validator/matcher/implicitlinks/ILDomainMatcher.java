/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.matcher.implicitlinks;

import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Third party domain matcher for Core.
 */
public class ILDomainMatcher extends CoreDomainMatcher {

	/**
	 * Constructor
	 */
	public ILDomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				AbstractLinkDescriptorFactory linkDescriptorFactory = new ILLinkDescriptorFactory();
				LinkMatcher matcher = super.getLinkMatcher(linkType, linkDescriptorFactory);
				if (LinkType.HOSTING.equals(linkType)) {
					matcher.setLinkDescriptorFactory(linkDescriptorFactory);
				} else {
					// nothing special
				}
				return matcher;
			}
		});
	}
}
