/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.ConstraintLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.DependencyLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.HostingLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.MemberLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationLinkMatcher;

/**
 * Default (core) matchers for various link types.
 */
public class DefaultLinkMatcherFactory extends LinkMatcherFactory {

	private final static LinkDescriptorFactory defaultDescriptorFactory = new LinkDescriptorFactory();

	@Override
	public LinkMatcher getLinkMatcher(LinkType linkType) {
		return getLinkMatcher(linkType, defaultDescriptorFactory);
	}

	@Override
	public LinkMatcher getLinkMatcher(LinkType linkType,
			AbstractLinkDescriptorFactory linkDescriptorFactory) {
		LinkMatcher matcher = new DefaultLinkMatcher(linkType);
		switch (linkType.getValue())
		{
		case LinkType.DEPENDENCY_VALUE:
			LinkMatcher dependencyMatcher = new DependencyLinkMatcher();
			dependencyMatcher.setLinkDescriptorFactory(linkDescriptorFactory);
			matcher.registerAdditionalMatcher(dependencyMatcher);
			break;
		case LinkType.HOSTING_VALUE:
			LinkMatcher hostingMatcher = new HostingLinkMatcher();
			hostingMatcher.setLinkDescriptorFactory(linkDescriptorFactory);
			matcher.registerAdditionalMatcher(hostingMatcher);
			break;
		case LinkType.CONSTRAINT_VALUE:
			LinkMatcher logicalMatcher = new ConstraintLinkMatcher();
			logicalMatcher.setLinkDescriptorFactory(linkDescriptorFactory);
			matcher.registerAdditionalMatcher(logicalMatcher);
			break;
		case LinkType.MEMBER_VALUE:
			LinkMatcher memberMatcher = new MemberLinkMatcher();
			memberMatcher.setLinkDescriptorFactory(linkDescriptorFactory);
			matcher.registerAdditionalMatcher(memberMatcher);
			break;
		case LinkType.REALIZATION_VALUE:
			LinkMatcher realizationMatcher = new RealizationLinkMatcher();
			realizationMatcher.setLinkDescriptorFactory(linkDescriptorFactory);
			matcher.registerAdditionalMatcher(realizationMatcher);
			break;
		default:
			return null;
		}
		return matcher;
	}

}
