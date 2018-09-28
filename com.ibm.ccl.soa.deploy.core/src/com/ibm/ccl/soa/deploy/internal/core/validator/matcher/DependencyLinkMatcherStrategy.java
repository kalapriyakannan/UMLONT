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
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Strategy class for determining matcher behavior of dependency links.
 */
public class DependencyLinkMatcherStrategy extends LinkMatcherStrategy {

	protected static DeployValidatorService dvs = DeployValidatorService
			.getOrCreateValidatorService("com.ibm.ccl.soa.deploy.internal.core.validator.matcher.DependencyLinkMatcherStrategy"); //$NON-NLS-1$

	/**
	 * Constructor for strategy.
	 * 
	 * @param matcher
	 *           the link matcher to use
	 */
	public DependencyLinkMatcherStrategy(LinkMatcher matcher) {
		super(matcher);
	}

	// default case is to check only locally
	public IStatus canBeLinkSource(Unit source, Requirement sourceReq, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return getMatcher().canBeLinkSource(source, sourceReq);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.canBeLinkSource(source, sourceReq, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != sourceReq) {
			return getMatcher().canBeLinkSource(source, sourceReq);
		}

		return canBeLinkSource(source, depth, 0, new HashSet());
	}

	// actual implementation

	protected IStatus canBeLinkSource(Unit source, int depth, int currentDepth, Set alreadySeen) {

		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(source)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(source);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = dvs.canBeLinkSource(source, null, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
			if (status.isOK()) {
				return status;
			}

			Unit[] configUnits = getConfigUnits(source);
			for (int i = 0; i < configUnits.length; i++) {
				status = canBeLinkSource(configUnits[i], depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(source);
			for (int i = 0; i < members.length; i++) {
				status = canBeLinkSource(members[i], depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	// default case is to check only locally
	public IStatus canBeLinkTarget(Unit target, Capability targetCap, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.canBeLinkTarget(target, targetCap, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != targetCap || depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return getMatcher().canBeLinkTarget(target, targetCap);
		}
		return canBeLinkTarget(target, depth, 0, new HashSet());
	}

	// actual implementation

	protected IStatus canBeLinkTarget(Unit target, int depth, int currentDepth, Set alreadySeen) {

		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(target)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(target);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = dvs.canBeLinkTarget(target, null, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
			if (status.isOK()) {
				return status;
			}

			Unit[] configUnits = getConfigUnits(target);
			for (int i = 0; i < configUnits.length; i++) {
				status = canBeLinkTarget(configUnits[i], depth, currentDepth + 1, alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(target);
			for (int i = 0; i < members.length; i++) {
				status = canBeLinkTarget(members[i], depth, currentDepth + 1, alreadySeen);
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

		IStatus status = canBeLinkTarget(unit, null, depth);
		if (status.isOK()) {
			return status;
		}

		status = canBeLinkSource(unit);
		return status;
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (null == reqCap) {
			return canBeLinkEndpoint(unit, depth);
		}

		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(reqCap.getEObject().eClass())) {
			IStatus status = canBeLinkSource(unit, (Requirement) reqCap);
			return status;
		}

		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(reqCap.getEObject().eClass())) {
			IStatus status = canBeLinkTarget(unit, (Capability) reqCap, depth);
			return status;
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	// default case is to consider local nodes only
	public IStatus canCreateLink(Unit source, Requirement sourceReq, Unit target,
			Capability targetCap, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return getMatcher().canCreateLink(source, sourceReq, target, targetCap);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.canCreateLink(source, sourceReq, target, targetCap, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != sourceReq) {
			return getMatcher().canCreateLink(source, sourceReq, target, targetCap);
		}

		IStatus status = canCreateLink(source, sourceReq, target, depth, 0, new HashSet());
		if (status.isOK()) {
			return status;
		}

		if (null != sourceReq) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		status = canCreateLinkForMembers(source, target, depth, 0, new HashSet());
		return status;
	}

	private IStatus canCreateLinkForMembers(Unit source, Unit target, int depth, int currentDepth,
			HashSet alreadySeen) {
		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(source)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(source);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = dvs.canCreateLink(source, target, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
			if (status.isOK()) {
				return status;
			}

			Unit[] configUnits = getConfigUnits(source);
			for (int i = 0; i < configUnits.length; i++) {
				status = canCreateLinkForMembers(configUnits[i], target, depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(source);
			for (int i = 0; i < members.length; i++) {
				status = canCreateLinkForMembers(members[i], target, depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	// actual implementation
	protected IStatus canCreateLink(Unit source, Requirement sourceReq, Unit target, int depth,
			int currentDepth, Set alreadySeen) {

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(target)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(target);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus retValStatus = DeployMatcherStatus.MATCH_NOT_FOUND;
		if (currentDepth <= depth) {
			IStatus status = dvs.canCreateLink(source, sourceReq, target, null,
					LinkType.DEPENDENCY_SET, DeployValidatorService.MATCHER_STOP_RECURSION);
			if (status.isOK()) {
				return status;
			}

			Unit[] configUnits = getConfigUnits(target);
			for (int i = 0; i < configUnits.length; i++) {
				status = canCreateLink(source, sourceReq, configUnits[i], depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(target);
			for (int i = 0; i < members.length; i++) {
				status = canCreateLink(source, sourceReq, members[i], depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			if (!(status.equals(DeployMatcherStatus.MATCH_NOT_FOUND) || status
					.equals(DeployMatcherStatus.DEPENDENCY_LINK_NOT_POSSIBLE))
					&& retValStatus.equals(DeployMatcherStatus.MATCH_NOT_FOUND)) {
//				System.out.println ("   Setting retValStatus to: " + status);  //$NON-NLS-1$
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

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return descriptorsAsList(getMatcher().getPossibleLinks(source, sourceReq, target,
					targetCap), source, target);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.getPossibleLinks(source, sourceReq, target, targetCap, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != targetCap) {
			return descriptorsAsList(getMatcher().getPossibleLinks(source, sourceReq, target,
					targetCap), source, target);
		}

		Set all = getPossibleLinks(source, sourceReq, target, depth, 0, new HashSet());

		if (null == sourceReq) {
			all.addAll(getMemberPossibleLinks(source, target, depth, 0, new HashSet()));
		}

		return descriptorsAsList(all, source, target);
	}

	// actual implementation
	protected Set getPossibleLinks(Unit source, Requirement sourceReq, Unit target, int depth,
			int currentDepth, Set alreadySeen) {

		Set linkSet = new HashSet();

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(target)) {
			return linkSet;
		}

		alreadySeen.add(target);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return linkSet;
		}

		if (currentDepth <= depth) {
			linkSet.addAll(Arrays.asList(dvs.getPossibleLinks(source, sourceReq, target, null,
					LinkType.DEPENDENCY_SET, DeployValidatorService.MATCHER_STOP_RECURSION)));

			Unit[] configUnits = getConfigUnits(target);
			for (int i = 0; i < configUnits.length; i++) {
				Set possibleToConfig = getPossibleLinks(source, sourceReq, configUnits[i], depth,
						currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToConfig);
			}

			Unit[] members = getMembers(target);
			for (int i = 0; i < members.length; i++) {
				Set possibleToMember = getPossibleLinks(source, sourceReq, members[i], depth,
						currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToMember);
			}
		}

		return linkSet;
	}

	// actual implementation
	protected Set getMemberPossibleLinks(Unit source, Unit target, int depth, int currentDepth,
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
			linkSet.addAll(Arrays.asList(dvs.getPossibleLinks(source, target, LinkType.DEPENDENCY_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION)));

			Unit[] configUnits = getConfigUnits(source);
			for (int i = 0; i < configUnits.length; i++) {
				Set possibleToConfig = getMemberPossibleLinks(configUnits[i], target, depth,
						currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToConfig);
			}

			Unit[] members = getMembers(source);
			for (int i = 0; i < members.length; i++) {
				Set possibleToMember = getMemberPossibleLinks(members[i], target, depth,
						currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToMember);
			}
		}

		return linkSet;
	}

}
