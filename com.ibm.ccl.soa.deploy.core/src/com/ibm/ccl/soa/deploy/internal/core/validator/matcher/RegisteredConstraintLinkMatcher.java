/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Identifies whether or not a constraint link can be established between two Deploy Model Objects.
 * 
 */
public class RegisteredConstraintLinkMatcher extends NegativeDomainMatcher {

//	private LinkMatcherStrategy logicalLinkMatcherStrategy = new LogicalLinkMatcherStrategy(
//			new LogicalLinkMatcher());
//
	/**
	 * Constructor for LinkMatcher. Provides a new LogicalLinkMatcherStrategy.
	 */
	public RegisteredConstraintLinkMatcher() {
		super(new DefaultLinkMatcherFactory() {
			public LinkMatcher getLinkMatcher(LinkType linkType) {
				if (LinkType.CONSTRAINT.equals(linkType)) {
					return new CompoundConstraintLinkMatcher();
				} else {
					return null;
				}
			}
		});
//		super();
//		setLinkMatcherStrategy(LinkType.LOGICAL, logicalLinkMatcherStrategy);
	}
}
