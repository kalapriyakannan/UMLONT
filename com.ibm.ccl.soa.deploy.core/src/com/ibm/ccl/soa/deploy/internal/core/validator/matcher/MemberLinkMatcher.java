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
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;

/**
 * Matching logic for unit collection links. Only considers whether or not a collection link can be
 * established between a source unit and a target unit.
 */
public class MemberLinkMatcher extends LinkMatcher {

	/**
	 * Determine whether or not a Unit can be the source of a unit collection link. A Unit can be the
	 * source if it has a Requirement with link type RequirementLinkTypes.MEMBER_LITERAL.
	 * 
	 * @param unit
	 *           the unit to test
	 * @return status OK if the unit can be source of a unit collection link
	 * @see RequirementLinkTypes#MEMBER_LITERAL
	 */
	public IStatus canBeLinkSource(Unit unit) {
		if (MultiplicityChecker.canBeLinkSource(unit)) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit) {
		return DeployMatcherStatus.MATCH_FOUND;
	}

	public IStatus canCreateLink(Unit source, Unit target) {
		if (null == source || null == target) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// cannot add a member to itself
		if (source == target) {
			return DeployMatcherStatus.CANNOT_CREATE_LINK_TO_SELF;
		}

		if (!source.isPublic()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (!target.isPublic()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// if a link already exists then cannot add another
		for (Iterator mlIt = source.getMemberLinks().iterator(); mlIt.hasNext();) {
			MemberLink link = (MemberLink) mlIt.next();
			if (link.getTarget() == target) {
				return DeployMatcherStatus.LINK_ALREADY_PRESENT;
			}
		}

		// MK 11/3/2006 changed false to true
		if (MultiplicityChecker.newMemberLinkOK(source, target, true)) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;

	}

	public Set getPossibleLinks(Unit source, Unit target) {
		HashSet set = new HashSet();
		if (canCreateLink(source, target).isOK()) {
			set.add(getLinkDescriptorFactory().createLinkDescriptor(LinkType.MEMBER, source, target));
		}
		return set;
	}

}
