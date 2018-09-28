/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;

/**
 * Matching logic for hosting links.
 */
public class NegativeHostingLinkMatcher extends LinkMatcher {

	public Set<LinkDescriptor> getPossibleLinks(Unit host, Unit hostee) {
		return new HashSet<LinkDescriptor>();
	}

	public IStatus canBeLinkSource(Unit unit) {
		return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
	}

	public IStatus canBeLinkTarget(Unit unit) {
		return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
	}

	public IStatus canCreateLink(Unit host, Unit hostee) {
		return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
	}

}
