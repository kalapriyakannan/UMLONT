/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * Matching logic for a particular type of link.
 */
public class LinkMatcher {

	private final List<LinkMatchFilter> matchFilters = new ArrayList<LinkMatchFilter>();
	private final List<LinkMatcher> additionalMatchers = new ArrayList<LinkMatcher>();
	private AbstractLinkDescriptorFactory descriptorFactory = new LinkDescriptorFactory();
	private LinkType linkType = null;

	/**
	 * Determine if a unit can, itself, be a link source.
	 * 
	 * @param source
	 *           the unit to be tested
	 * @return status OK if can be a link source
	 */
//	public abstract IStatus canBeLinkSource(Unit source);
	public IStatus canBeLinkSource(Unit source) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a \<unit, requirement\> pair can be a link source.
	 * 
	 * @param source
	 *           the unit to be tested
	 * @param sourceRequirement
	 *           the requirement to be tested; can be null
	 * @return status OK if can be a link source
	 */
	public IStatus canBeLinkSource(Unit source, Requirement sourceRequirement) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a unit can, itself, be a link target.
	 * 
	 * @param target
	 *           the unit to be tested
	 * @return status OK if can be a link target
	 */
//	public abstract IStatus canBeLinkTarget(Unit target);
	public IStatus canBeLinkTarget(Unit target) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a \<unit, capability\> pair can be a link target.
	 * 
	 * @param target
	 *           the unit to be tested
	 * @param targetCapability
	 *           the capability to be tested; can be null
	 * @return status OK if can be a link target
	 */
	public IStatus canBeLinkTarget(Unit target, Capability targetCapability) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a unit can, itself, be a link endpoint (source or target).
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @return status OK if can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a \<unit, requirement\> or \<unit, capability\> pair can be a link endpoint
	 * (source or target).
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @param reqCap
	 *           the requirement or capability to be tested
	 * @return status OK if can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a link can be directly created between and source unit and a target unit.
	 * 
	 * @param source
	 *           the source unit to be tested
	 * @param target
	 *           the target unit to be tested
	 * @return status OK if can create a link
	 */
//	public abstract IStatus canCreateLink(Unit source, Unit target);
	public IStatus canCreateLink(Unit source, Unit target) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a link can be directly created between and source unit and a target unit.
	 * 
	 * @param source
	 *           the source unit to be tested
	 * @param sourceRequirement
	 *           the source requirement to be tested
	 * @param target
	 *           the target unit to be tested
	 * @param targetCapability
	 *           the target capability to be tested
	 * @return status OK if can create a link
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Get a set of descriptors describing possible dependency links that can be established between
	 * two units.
	 * 
	 * @param source
	 *           the source unit
	 * @param target
	 *           the target unit
	 * @return a set of possible link descriptors
	 */
//	public abstract Set<LinkDescriptor> getPossibleLinks(Unit source, Unit target);
	public Set<LinkDescriptor> getPossibleLinks(Unit source, Unit target) {
		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();

		if (getLinkType() == null) {
			return possibleLinks;
		}

		if (canCreateLink(source, target).isOK()) {
			possibleLinks.add(descriptorFactory.createLinkDescriptor(getLinkType(), source, target));
		}

		return possibleLinks;
	}

	/**
	 * Get a set of descriptors describing possible dependency links that can be established between
	 * two units.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement to be tested
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability to be tested
	 * @return a set of possible link descriptors
	 */
	public Set<LinkDescriptor> getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();

		if (getLinkType() == null) {
			return possibleLinks;
		}

		if (canCreateLink(source, sourceRequirement, target, targetCapability).isOK()) {
			possibleLinks.add(descriptorFactory.createLinkDescriptor(getLinkType(), source,
					sourceRequirement, target, targetCapability));
		}

		return possibleLinks;
	}

	/**
	 * Add a filter class that refuses matches
	 * 
	 * @param filter
	 */
	public final void registerMatchFilter(LinkMatchFilter filter) {
		if (null == filter) {
			return;
		}
		matchFilters.add(filter);
	}

	/**
	 * Get the additional link matchers to be tested.
	 * 
	 * @return {@link Iterator} of link matchers
	 */
	public final Iterator<LinkMatchFilter> getMatchFilters() {
		return matchFilters.iterator();
	}

	/**
	 * Adds an additional matcher to cover cases not already covered by the matcher.
	 * 
	 * @param matcher
	 *           the matcher
	 */
	public final void registerAdditionalMatcher(LinkMatcher matcher) {
		if (null == matcher) {
			return;
		}
		additionalMatchers.add(matcher);
	}

	/**
	 * Get the additional link matchers to be tested.
	 * 
	 * @return {@link Iterator} of link matchers
	 */
	public final Iterator<LinkMatcher> getAdditionalMatchers() {
		return additionalMatchers.iterator();
	}

	/**
	 * Set the factory that should be used to create {@link LinkDescriptor}
	 * 
	 * @param factory
	 *           the {@link LinkDescriptorFactory}
	 */
	public final void setLinkDescriptorFactory(AbstractLinkDescriptorFactory factory) {
		descriptorFactory = factory;
	}

	/**
	 * Get the {@link LinkDescriptor}
	 * 
	 * @return the link descriptor
	 */
	public final AbstractLinkDescriptorFactory getLinkDescriptorFactory() {
		return descriptorFactory;
	}

	/**
	 * Set the link type this matcher works for
	 * 
	 * @param type
	 *           the link type
	 */
	protected final void setLinkType(LinkType type) {
		linkType = type;
	}

	/**
	 * Get the {@link LinkType} this matcher works for
	 * 
	 * @return the link type
	 */
	public final LinkType getLinkType() {
		return linkType;
	}

	// Utility Methods used by matchers
	protected final IStatus booleanToStatus(boolean result) {
		return result ? DeployMatcherStatus.MATCH_FOUND : DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	protected final static ReqEvaluationContext evalContext(Capability cap) {
		return new ReqEvaluationContext(cap);
	}

}
