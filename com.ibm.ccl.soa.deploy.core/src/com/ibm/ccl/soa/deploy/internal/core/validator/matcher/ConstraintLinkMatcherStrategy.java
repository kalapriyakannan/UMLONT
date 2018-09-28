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
 * Strategy class for determining matcher behavior of logical links.
 */
public class ConstraintLinkMatcherStrategy extends LinkMatcherStrategy {

	protected static DeployValidatorService dvs = DeployValidatorService
			.getOrCreateValidatorService("com.ibm.ccl.soa.deploy.internal.core.validator.matcher.ConstraintLinkMatcherStrategy"); //$NON-NLS-1$

	/**
	 * Constructor for strategy.
	 * 
	 * @param matcher
	 *           the link matcher to use
	 */
	public ConstraintLinkMatcherStrategy(LinkMatcher matcher) {
		super(matcher);
	}

	//
	// similar to HostingLinkMatcherStrategy
	//

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
			return dvs.canBeLinkSource(unit, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		return canBeLinkSource(unit, depth, 0, new HashSet<Unit>());
	}

	// actual implementation
	protected IStatus canBeLinkSource(Unit unit, int depth, int currentDepth, Set<Unit> alreadySeen) {

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(unit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(unit);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = dvs.canBeLinkSource(unit, null, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
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

	//
	// From DependencyLinkMatcherStrategy
	//

	// default case is to check only locally
	public IStatus canBeLinkTarget(Unit target, Capability targetCap, int depth) {
		if (null == getMatcher()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return getMatcher().canBeLinkTarget(target, targetCap);
		}
		if (depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return dvs.canBeLinkTarget(target, targetCap, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != targetCap) {
			return getMatcher().canBeLinkTarget(target, targetCap);
		}

		return canBeLinkTarget(target, depth, 0, new HashSet<Unit>());
	}

	// actual implementation
	protected IStatus canBeLinkTarget(Unit target, int depth, int currentDepth, Set<Unit> alreadySeen) {

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		if (alreadySeen.contains(target)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(target);

		if (currentDepth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = dvs.canBeLinkTarget(target, null, LinkType.CONSTRAINT_SET,
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

		// 10/27/2006 added null, depth as parameters
		status = canBeLinkSource(unit, null, depth);
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
			// 10/27/2006 added depth as parameter
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
			return dvs.canCreateLink(source, sourceReq, target, targetCap, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != targetCap || depth == DeployValidatorService.MATCHER_DEPTH_NONE) {
			return getMatcher().canCreateLink(source, sourceReq, target, targetCap);
		}

		IStatus status = canCreateConstraintLink(source, target, depth, 0,
				new HashSet<SourceTargetPair>());
		return status;

	}

	protected IStatus canCreateConstraintLink(Unit source, Unit target, int depth, int currentDepth,
			Set<SourceTargetPair> alreadySeen) {

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		SourceTargetPair st = new SourceTargetPair(source, target);
		if (alreadySeen.contains(st)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		alreadySeen.add(st);

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (currentDepth <= depth) {
			IStatus status = dvs.canCreateLink(source, null, target, null, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
			if (status.isOK()) {
				return status;
			}

			Unit[] configUnits = getConfigUnits(target);
			for (int i = 0; i < configUnits.length; i++) {
				status = canCreateConstraintLink(source, configUnits[i], depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] members = getMembers(target);
			for (int i = 0; i < members.length; i++) {
				status = canCreateConstraintLink(source, members[i], depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] sourceConfigUnits = getConfigUnits(source);
			for (int i = 0; i < sourceConfigUnits.length; i++) {
				status = canCreateConstraintLink(sourceConfigUnits[i], target, depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

			Unit[] sourceMembers = getMembers(source);
			for (int i = 0; i < sourceMembers.length; i++) {
				status = canCreateConstraintLink(sourceMembers[i], target, depth, currentDepth + 1,
						alreadySeen);
				if (status.isOK()) {
					return status;
				}
			}

		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
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
			return dvs.getPossibleLinks(source, sourceReq, target, targetCap, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION);
		}
		if (null != targetCap) {
			return descriptorsAsList(getMatcher().getPossibleLinks(source, sourceReq, target,
					targetCap), source, target);
		}
		Set<LinkDescriptor> all = getPossibleConstraintLinks(source, target, depth, 0,
				new HashSet<SourceTargetPair>());

		return descriptorsAsList(all, source, target);
	}

	protected Set<LinkDescriptor> getPossibleConstraintLinks(Unit source, Unit target, int depth,
			int currentDepth, Set<SourceTargetPair> alreadySeen) {

		Set<LinkDescriptor> linkSet = new HashSet<LinkDescriptor>();

		// prevent infinite recursion when loops hosting/membership creates loops in topology
		SourceTargetPair stp = new SourceTargetPair(source, target);
		if (alreadySeen.contains(stp)) {
			return linkSet;
		}

		alreadySeen.add(stp);

		if (depth == DeployValidatorService.MATCHER_STOP_RECURSION) {
			return linkSet;
		}

		if (currentDepth <= depth) {
			linkSet.addAll(Arrays.asList(dvs.getPossibleLinks(source, target, LinkType.CONSTRAINT_SET,
					DeployValidatorService.MATCHER_STOP_RECURSION)));

			Unit[] targetConfigUnits = getConfigUnits(target);
			for (int i = 0; i < targetConfigUnits.length; i++) {
				Set<LinkDescriptor> possibleToConfig = getPossibleConstraintLinks(source,
						targetConfigUnits[i], depth, currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToConfig);
			}

			Unit[] targetMembers = getMembers(target);
			for (int i = 0; i < targetMembers.length; i++) {
				Set<LinkDescriptor> possibleToMember = getPossibleConstraintLinks(source,
						targetMembers[i], depth, currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToMember);
			}

			Unit[] sourceConfigUnits = getConfigUnits(source);
			for (int i = 0; i < sourceConfigUnits.length; i++) {
				Set<LinkDescriptor> possibleToConfig = getPossibleConstraintLinks(sourceConfigUnits[i],
						target, depth, currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToConfig);
			}

			Unit[] sourceMembers = getMembers(source);
			for (int i = 0; i < sourceMembers.length; i++) {
				Set<LinkDescriptor> possibleToMember = getPossibleConstraintLinks(sourceMembers[i],
						target, depth, currentDepth + 1, alreadySeen);
				linkSet.addAll(possibleToMember);
			}
		}

		return linkSet;
	}

	private class SourceTargetPair {
		private final Unit _source;
		private final Unit _target;

		public SourceTargetPair(Unit source, Unit target) {
			_source = source;
			_target = target;
		}

		public Unit getSource() {
			return _source;
		}

		public Unit getTarget() {
			return _target;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (_source == null ? 0 : _source.hashCode());
			result = prime * result + (_target == null ? 0 : _target.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final SourceTargetPair other = (SourceTargetPair) obj;
			if (_source == null) {
				if (other._source != null) {
					return false;
				}
			} else if (!_source.equals(other._source)) {
				return false;
			}
			if (_target == null) {
				if (other._target != null) {
					return false;
				}
			} else if (!_target.equals(other._target)) {
				return false;
			}
			return true;
		}

	}
}
