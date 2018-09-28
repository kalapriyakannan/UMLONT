/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

/**
 * Factory to create {@link LinkMatcher}s.
 */
public abstract class LinkMatcherFactory {

	/**
	 * Get a {@link LinkMatcher} for a given {@link LinkType}.
	 * 
	 * @param linkType
	 *           the link type for which a matcher should be created
	 * @return strategy
	 */
	public abstract LinkMatcher getLinkMatcher(LinkType linkType);

	/**
	 * Get a {@link LinkMatcher} for a given {@link LinkType}.
	 * 
	 * @param linkType
	 *           the link type for which a matcher should be created
	 * @param descriptorFactory
	 *           the link descriptor factory that shoul be used to create {@link LinkDescriptor}
	 * @return strategy
	 */
	public abstract LinkMatcher getLinkMatcher(LinkType linkType,
			AbstractLinkDescriptorFactory descriptorFactory);
}
