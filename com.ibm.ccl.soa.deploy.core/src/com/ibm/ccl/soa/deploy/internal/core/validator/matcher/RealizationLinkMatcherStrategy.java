/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;

/**
 * Strategy class for determining matcher behavior of realization links.
 */
public class RealizationLinkMatcherStrategy extends LinkMatcherStrategy {

	/**
	 * Constructor for strategy.
	 * 
	 * @param matcher
	 *           the link matcher to use
	 */
	public RealizationLinkMatcherStrategy(LinkMatcher matcher) {
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
		assert depth == DeployValidatorService.MATCHER_DEPTH_NONE
				|| depth == DeployValidatorService.MATCHER_DEPTH_ALL;
		return getMatcher().canBeLinkSource(unit);
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

		assert depth == DeployValidatorService.MATCHER_DEPTH_NONE
				|| depth == DeployValidatorService.MATCHER_DEPTH_ALL;
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
		assert depth == DeployValidatorService.MATCHER_DEPTH_NONE
				|| depth == DeployValidatorService.MATCHER_DEPTH_ALL;
		return getMatcher().canCreateLink(source, target);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceReq, Unit target,
			Capability targetCap, int depth) {
		if (null == getMatcher()) {
			return new LinkDescriptor[0];
		}

		if (null != targetCap || null != sourceReq) {
			return new LinkDescriptor[0];
		}
		assert depth == DeployValidatorService.MATCHER_DEPTH_NONE
				|| depth == DeployValidatorService.MATCHER_DEPTH_ALL;
		return descriptorsAsList(getMatcher().getPossibleLinks(source, target), source, target);
	}

}
