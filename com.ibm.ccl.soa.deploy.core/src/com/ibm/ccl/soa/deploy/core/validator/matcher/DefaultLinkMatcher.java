/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * Matching logic for a particular type of link.
 */
public class DefaultLinkMatcher extends LinkMatcher {

	/**
	 * Constructor
	 * 
	 * @param type
	 *           the {@link LinkType} this matcher works for.
	 */
	public DefaultLinkMatcher(LinkType type) {
		super();
		this.setLinkType(type);
	}

	/**
	 * Constructor
	 * 
	 * @param type
	 *           the {@link LinkType} this matcher works for.
	 * @param factory
	 *           factory to create {@link LinkDescriptor} elements
	 */
	public DefaultLinkMatcher(LinkType type, LinkDescriptorFactory factory) {
		super();
		this.setLinkType(type);
		this.setLinkDescriptorFactory(factory);
	}

	/**
	 * Determine if a unit can, itself, be a link source.
	 * 
	 * @param source
	 *           the unit to be tested
	 * @return status OK if can be a link source
	 */
//	public abstract IStatus canBeLinkSource(Unit source);
	public IStatus canBeLinkSource(Unit source) {
		IStatus resultStatus = null;
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			resultStatus = additionalMatchers.next().canBeLinkSource(source);
			if (resultStatus.isOK()) {
				break;
			}
		}

		if (null == resultStatus) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (resultStatus.isOK()) {
			for (Iterator<LinkMatchFilter> matchFilters = getMatchFilters(); matchFilters.hasNext();) {
				IStatus filterStatus = matchFilters.next().canBeLinkSource(source);
				if (!filterStatus.isOK()) {
					return filterStatus;
				}
			}
		}

		return resultStatus;
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
		if (null == sourceRequirement) {
			return canBeLinkSource(source);
		}

		// default behavior is to disallow such matches
		IStatus resultStatus = null;
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			resultStatus = additionalMatchers.next().canBeLinkSource(source);
			if (resultStatus.isOK()) {
				break;
			}
		}

		if (null == resultStatus) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (resultStatus.isOK()) {
			for (Iterator<LinkMatchFilter> matchFilters = getMatchFilters(); matchFilters.hasNext();) {
				IStatus filterStatus = matchFilters.next().canBeLinkSource(source);
				if (!filterStatus.isOK()) {
					return filterStatus;
				}
			}
		}

		return resultStatus;
//		return DeployMatcherStatus.MATCH_NOT_FOUND;
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
		IStatus resultStatus = null;
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			resultStatus = additionalMatchers.next().canBeLinkTarget(target);
			if (resultStatus.isOK()) {
				break;
			}
		}

		if (null == resultStatus) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (resultStatus.isOK()) {
			for (Iterator<LinkMatchFilter> matchFilters = getMatchFilters(); matchFilters.hasNext();) {
				IStatus filterStatus = matchFilters.next().canBeLinkTarget(target);
				if (!filterStatus.isOK()) {
					return filterStatus;
				}
			}
		}

		return resultStatus;
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
		if (null == targetCapability) {
			return canBeLinkTarget(target);
		}

		// default behavior is to disallow such matches
		IStatus resultStatus = null;
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			resultStatus = additionalMatchers.next().canBeLinkTarget(target, targetCapability);
			if (resultStatus.isOK()) {
				break;
			}
		}

		if (null == resultStatus) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (resultStatus.isOK()) {
			for (Iterator<LinkMatchFilter> matchFilters = getMatchFilters(); matchFilters.hasNext();) {
				IStatus filterStatus = matchFilters.next().canBeLinkTarget(target, targetCapability);
				if (!filterStatus.isOK()) {
					return filterStatus;
				}
			}
		}

		return resultStatus;
//		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Determine if a unit can, itself, be a link endpoint (source or target).
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @return status OK if can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit) {
		if (null == unit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus status = canBeLinkTarget(unit);
		if (status.isOK()) {
			return status;
		}

		status = canBeLinkSource(unit);
		return status;
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
		if (null == reqCap) {
			return canBeLinkEndpoint(unit);
		}

		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(reqCap.getEObject().eClass())) {
			IStatus status = canBeLinkSource(unit, (Requirement) reqCap);
			return status;
		}

		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(reqCap.getEObject().eClass())) {
			IStatus status = canBeLinkTarget(unit, (Capability) reqCap);
			return status;
		}

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
		IStatus resultStatus = null;
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			resultStatus = additionalMatchers.next().canCreateLink(source, target);
			if (resultStatus.isOK()) {
				break;
			}
		}

		if (null == resultStatus) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (resultStatus.isOK()) {
			for (Iterator<LinkMatchFilter> matchFilters = getMatchFilters(); matchFilters.hasNext();) {
				IStatus filterStatus = matchFilters.next().canCreateLink(source, target);
				if (!filterStatus.isOK()) {
					return filterStatus;
				}
			}
		}

		return resultStatus;
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
		if (null == sourceRequirement && null == targetCapability) {
			return canCreateLink(source, target);
		}

		// default behavior is to disallow such matches
		IStatus resultStatus = null;
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			resultStatus = additionalMatchers.next().canCreateLink(source, sourceRequirement, target,
					targetCapability);
			if (resultStatus.isOK()) {
				break;
			}
		}

		if (null == resultStatus) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (resultStatus.isOK()) {
			for (Iterator<LinkMatchFilter> matchFilters = getMatchFilters(); matchFilters.hasNext();) {
				IStatus filterStatus = matchFilters.next().canCreateLink(source, sourceRequirement,
						target, targetCapability);
				if (!filterStatus.isOK()) {
					return filterStatus;
				}
			}
		}

		return resultStatus;
//		return DeployMatcherStatus.MATCH_NOT_FOUND;
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
		Set<LinkDescriptor> resultSet = new HashSet<LinkDescriptor>();
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			Set<LinkDescriptor> possibleLinks = additionalMatchers.next().getPossibleLinks(source,
					target);
			if (null != resultSet) {
				resultSet.addAll(possibleLinks);
			}
		}

		if (null == resultSet || 0 == resultSet.size()) {
			return new HashSet<LinkDescriptor>();
		}

		// filtering doesn't make sense; this should have been done by the canCreateLink

		return resultSet;
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
		if (null == sourceRequirement && null == targetCapability) {
			return getPossibleLinks(source, target);
		}

		// default behavior is to disallow such matches
		Set<LinkDescriptor> resultSet = new HashSet<LinkDescriptor>();
		for (Iterator<LinkMatcher> additionalMatchers = getAdditionalMatchers(); additionalMatchers
				.hasNext();) {
			Set<LinkDescriptor> possibleLinks = additionalMatchers.next().getPossibleLinks(source,
					sourceRequirement, target, targetCapability);
			if (null != resultSet) {
				resultSet.addAll(possibleLinks);
			}
		}

		if (null == resultSet || 0 == resultSet.size()) {
			return new HashSet<LinkDescriptor>();
		}

		// filtering doesn't make sense; this should have been done by the canCreateLink

		return resultSet;
//		return new HashSet<LinkDescriptor>();
	}

}
