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
 * Factory to create {@link LinkMatcherStrategy}
 */
public abstract class LinkMatcherStrategyFactory {

	/**
	 * Get a {@link LinkMatcherStrategy} for a given {@link LinkType}.
	 * 
	 * @param linkType
	 *           the link type for which a strategy should be created
	 * @param matcher
	 *           the matcher that the strategy should use
	 * @return strategy
	 */
	public abstract LinkMatcherStrategy getLinkMatcherStrategy(LinkType linkType, LinkMatcher matcher);

}
