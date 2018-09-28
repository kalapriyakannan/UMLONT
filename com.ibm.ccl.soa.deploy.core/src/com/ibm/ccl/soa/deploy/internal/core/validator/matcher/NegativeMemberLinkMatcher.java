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
 * Matching logic for unit collection links. Only considers whether or not a collection link can be
 * established between a source unit and a target unit. Always returns no possible matches.
 */
public class NegativeMemberLinkMatcher extends LinkMatcher {

	public IStatus canBeLinkSource(Unit unit) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit source, Unit target) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public Set<LinkDescriptor> getPossibleLinks(Unit source, Unit target) {
		return new HashSet<LinkDescriptor>();
	}

}
