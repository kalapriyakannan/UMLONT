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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;

/**
 * Default negative matching logic for realization links, always returning failure
 */
public class NegativeRealizationLinkMatcher extends LinkMatcher {

	public IStatus canBeLinkSource(Unit unit) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit unit1, Unit unit2) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public Set<LinkDescriptor> getPossibleLinks(Unit source, Unit target) {
		return new HashSet<LinkDescriptor>();
	}

	public Set<LinkDescriptor> getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		return new HashSet<LinkDescriptor>();
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit, Capability targetCapability) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

}
