/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Provides a default implementation of {@link DomainValidator} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.domains</b>.
 * 
 * @since 1.0
 * @see DomainValidator
 * 
 */
public class SkeletonDomainMatcher extends DomainMatcher {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonDomainMatcher INSTANCE = new SkeletonDomainMatcher();

	private SkeletonDomainMatcher() {
	}

	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes, int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes,
			int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes, int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes, int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes, int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes,
			int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit unit1, Unit unit2, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit unit1, Requirement requirement, Unit unit2,
			Capability capability, LinkType[] linkTypes) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit unit1, Unit unit2, LinkType[] linkTypes, int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit unit1, Requirement requirement, Unit unit2,
			Capability capability, LinkType[] linkTypes, int depth) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public LinkDescriptor[] getPossibleLinks(Unit unit1, Unit unit2, LinkType[] linkTypes) {
		return new LinkDescriptor[0];
	}

	public LinkDescriptor[] getPossibleLinks(Unit unit1, Requirement requirement, Unit unit2,
			Capability capability, LinkType[] linkTypes) {
		return new LinkDescriptor[0];
	}

	public LinkDescriptor[] getPossibleLinks(Unit unit1, Unit unit2, LinkType[] linkTypes, int depth) {
		return new LinkDescriptor[0];
	}

	public LinkDescriptor[] getPossibleLinks(Unit unit1, Requirement requirement, Unit unit2,
			Capability capability, LinkType[] linkTypes, int depth) {
		return new LinkDescriptor[0];
	}

}
