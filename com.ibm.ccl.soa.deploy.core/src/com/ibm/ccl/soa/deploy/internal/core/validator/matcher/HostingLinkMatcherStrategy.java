/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Strategy class for determining matcher behavior of hosting links.
 */
public class HostingLinkMatcherStrategy extends LinkMatcherStrategy {

	protected static DeployValidatorService dvs = DeployValidatorService
			.getOrCreateValidatorService("com.ibm.ccl.soa.deploy.internal.core.validator.matcher.HostingLinkMatcherStrategy"); //$NON-NLS-1$

	/**
	 * Constructor for strategy.
	 * 
	 * @param matcher
	 *           the link matcher to use
	 */
	public HostingLinkMatcherStrategy(LinkMatcher matcher) {
		super(matcher);
	}

	// default case is to check only locally
	public IStatus canBeLinkSource(Unit unit, Requirement req, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (null != req) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return getMatcher().canBeLinkSource(unit);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.canBeLinkSource(unit, LinkType.HOSTING_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		return canBeLinkSource(unit, depth, 0, new HashSet());
	}

	// actual implementation
	protected IStatus canBeLinkSource(Unit unit, int depth, int currentDepth, Set alreadySeen) {

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(unit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(unit);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = getMatcher().canBeLinkSource(unit, null);
			if (status.isOK()) {
				return status;
			}

			Unit[] configUnits = getConfigUnits(unit);
			for (int i = 0; i < configUnits.length; i++) {
				status = canBeLinkSource(configUnits[i], depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(unit);
			for (int i = 0; i < members.length; i++) {
				status = canBeLinkSource(members[i], depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus status = canBeLinkSource(unit, null, depth);
		if (status.isOK()) {
			return status;
		}

		status = canBeLinkTarget(unit);
		return status;
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (null != reqCap) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		return canBeLinkEndpoint(unit, depth);
	}

	// default case is to consider local nodes only
	public IStatus canCreateLink(Unit source, Requirement sourceReq, Unit target,
			Capability targetCap, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (null != targetCap || null != sourceReq) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return getMatcher().canCreateLink(source, target);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.canCreateLink(source, target, LinkType.HOSTING_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		return canCreateLink(source, target, depth, 0, new HashSet());
	}

	// actual implementation
	protected IStatus canCreateLink(Unit source, Unit target, int depth, int currentDepth,
			Set alreadySeen) {

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(source)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(source);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus retValStatus = DeployMatcherStatus.MATCH_NOT_FOUND;
		if (currentDepth <= depth) {
			IStatus status = getMatcher().canCreateLink(source, target);
			if (status.isOK()) {
				return status;
			} else {
				//5600: ensure underlying status is propagated higher.
				retValStatus = status;
			}

			Unit[] configUnits = getConfigUnits(source);
			for (int i = 0; i < configUnits.length; i++) {
				status = canCreateLink(configUnits[i], target, depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(source);
			for (int i = 0; i < members.length; i++) {
				status = canCreateLink(members[i], target, depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}
			if (!status.equals(DeployMatcherStatus.MATCH_NOT_FOUND)
					&& retValStatus.equals(DeployMatcherStatus.MATCH_NOT_FOUND)) {
//					System.out.println ("   Setting retValStatus to: " + status);  //$NON-NLS-1$
				retValStatus = status;
			}
		}

		return retValStatus;
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceReq, Unit target,
			Capability targetCap, int depth) {
		if (null == getMatcher()) {
			return new LinkDescriptor[0];
		}

		if (null != targetCap || null != sourceReq) {
			return new LinkDescriptor[0];
		}

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return descriptorsAsList(getMatcher().getPossibleLinks(source, target), source, target);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.getPossibleLinks(source, target, LinkType.HOSTING_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		return descriptorsAsList(getPossibleLinks(source, target, depth, 0, new HashSet()), source,
				target);
	}

	// actual implementation
	protected Set getPossibleLinks(Unit source, Unit target, int depth, int currentDepth,
			Set alreadySeen) {

		Set linkSet = new HashSet();

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(source)) {
			return linkSet;
		}

		alreadySeen.add(source);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return linkSet;
		}

		if (currentDepth <= depth) {
//			linkSet.addAll(getMatcher().getPossibleLinks(source, target));
			linkSet.addAll(Arrays.asList(dvs.getPossibleLinks(source, target, LinkType.HOSTING_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION)));

			Unit[] configUnits = getConfigUnits(source);
			for (int i = 0; i < configUnits.length; i++) {
				Set possibleToConfig = getPossibleLinks(configUnits[i], target, depth,
						currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToConfig);
			}

			Unit[] members = getMembers(source);
			for (int i = 0; i < members.length; i++) {
				Set possibleToMember = getPossibleLinks(members[i], target, depth, currentDepth + 1,
						alreadySeen);
				linkSet.addAll(possibleToMember);
			}
		}

		return linkSet;
	}

}
