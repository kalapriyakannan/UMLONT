/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Domain specific matcher for the Virtualization package.
 */
public class VirtualizationDomainMatcher extends CoreDomainMatcher {

	/**
	 * Constructor
	 */
	public VirtualizationDomainMatcher() {
		super(new DefaultLinkMatcherFactory() {
			@Override
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				LinkMatcher matcher = super.getLinkMatcher(linkType);
				// make any domain specific modifications to matcher here
				return matcher;
			}
		});
	}
}
