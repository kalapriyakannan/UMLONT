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

/**
 * Strategy class for determining matcher behavior of member links.
 */
public class MemberLinkMatcherStrategy extends LinkMatcherStrategy {

	/**
	 * Constructor for strategy.
	 * 
	 * @param matcher
	 *           the link matcher to use
	 */
	public MemberLinkMatcherStrategy(LinkMatcher matcher) {
		super(matcher);
	}

}
