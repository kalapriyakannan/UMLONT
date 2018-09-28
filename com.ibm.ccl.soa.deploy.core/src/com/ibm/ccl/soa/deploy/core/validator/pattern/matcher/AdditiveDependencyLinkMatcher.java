/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;

/**
 * Dependency link matcher that is composed of individual rules for matching; typically defined by
 * endpoint matching.
 */
public class AdditiveDependencyLinkMatcher extends LinkMatcher {

	protected List<LinkMatcher> dependencyLinkMatchers = new ArrayList<LinkMatcher>();

	/**
	 * Adds a local dependency matcher.
	 * 
	 * @param matcher
	 *           the matcher
	 */
	public void addMatcher(LinkMatcher matcher) {
		dependencyLinkMatchers.add(matcher);
	}

	@Override
	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			IStatus status = dependencyLinkMatchers.get(i).canBeLinkSource(unit, requirement);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public IStatus canBeLinkSource(Unit unit) {
		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			IStatus status = dependencyLinkMatchers.get(i).canBeLinkSource(unit);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public IStatus canBeLinkTarget(Unit target) {
		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			IStatus status = dependencyLinkMatchers.get(i).canBeLinkTarget(target);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			IStatus status = dependencyLinkMatchers.get(i).canCreateLink(source, sourceRequirement,
					target, targetCapability);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public IStatus canCreateLink(Unit unit1, Unit unit2) {
		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			IStatus status = dependencyLinkMatchers.get(i).canCreateLink(unit1, unit2);
			if (status.isOK()) {
				return status;
			}
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public Set<LinkDescriptor> getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();

		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			Set<LinkDescriptor> pL = dependencyLinkMatchers.get(i).getPossibleLinks(source,
					sourceRequirement, target, targetCapability);
			possibleLinks.addAll(pL);
		}

		return possibleLinks;
	}

	@Override
	public Set<LinkDescriptor> getPossibleLinks(Unit source, Unit target) {
		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();

		for (int i = 0; i < dependencyLinkMatchers.size(); i++) {
			Set<LinkDescriptor> pL = dependencyLinkMatchers.get(i).getPossibleLinks(source, target);
			possibleLinks.addAll(pL);
		}

		return possibleLinks;
	}

}
