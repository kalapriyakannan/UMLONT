/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Common interface between domain validators and the validator service.
 * <p>
 * This interface is not intended to be implemented or extended. Domain validators should extend the
 * {@link DomainValidator} abstract class.
 */
public interface IDomainValidatorService {

	/**
	 * Validates the topology using all the applicable domain validators.
	 * <p>
	 * Topology validation issues are reported using
	 * {@link IDeployReporter#addStatus(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)}.
	 * 
	 * @param context
	 *           the domain validation context (used to extract the topology).
	 * @param reporter
	 *           used to create deploy markers.
	 * 
	 * @return the status of the validation process itself, not related to the status of the topology
	 *         itself.
	 */
	public IStatus validate(IDeployValidationContext context, IDeployReporter reporter);

	/**
	 * Returns a list of domain matchers defined for the domain identified by the namespace.
	 * 
	 * @param namespace
	 *           a namespace URI that is used to describe a domain.
	 * 
	 * @return an immutable list of domain matchers for the namespace domain(never null).
	 */
	public List<DomainMatcher> getDomainMatchers(String namespace);

	/**
	 * Returns the domain matchers associated with the domain of a unit.
	 * 
	 * @param unit
	 *           a deploy unit whose type belongs to a specific domain.
	 * @return an immutable list of domain matchers for the unit's domain (never null).
	 */
	public List<DomainMatcher> getDomainMatchers(Unit unit);

	/**
	 * Returns true if unit can be a link source for any one of the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if unit can be a link source
	 */
	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes);

	/**
	 * Determines if a unit, requirement pair can be a link source for any one of the specified link
	 * types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param requirement
	 *           the source requirement to consider; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if unit, requirement pair can be a link source
	 */
	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes);

	/**
	 * Returns true if unit can be a link source for any one of the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if unit can be a link source
	 */
	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes, int depth);

	/**
	 * Determines if a unit, requirement pair can be a link source for any one of the specified link
	 * types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param requirement
	 *           the source requirement to consider; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if unit, requirement pair can be a link source
	 */
	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes,
			int depth);

	/**
	 * Determines if a unit can the the target of a link for any one of the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if unit can be a link target
	 */
	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes);

	/**
	 * Determines if a unit, capability pair can the the target of a link for any one of the
	 * specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param capability
	 *           the target capability to consider; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if unit, capability pair can be a link target
	 */
	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes);

	/**
	 * Determines if a unit can the the target of a link for any one of the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if unit can be a link target
	 */
	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes, int depth);

	/**
	 * Determines if a unit, capability pair can the the target of a link for any one of the
	 * specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param capability
	 *           the target capability to consider; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if unit, capability pair can be a link target
	 */
	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes, int depth);

	/**
	 * Determines if a unit can be the source or target of a link for any of the specified link
	 * types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK is a unit can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes);

	/**
	 * Determines if a unit, requirement/capability can be the source or target of a link for any of
	 * the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param reqCap
	 *           the requirement/capability to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK is a unit, requirement/capability can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes);

	/**
	 * Determines if a unit can be the source or target of a link for any of the specified link
	 * types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK is a unit can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes, int depth);

	/**
	 * Determines if a unit, requirement/capability can be the source or target of a link for any of
	 * the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param reqCap
	 *           the requirement/capability to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK is a unit, requirement/capability can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes,
			int depth);

	/**
	 * Determines if a link (of any of the specified types) can be created between two units.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param target
	 *           the target endpoint of the link
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if a link of one of the specified types can be created
	 */
	public IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes);

	/**
	 * Determines if a link (of any of the specified types) can be created between two units.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param sourceRequirement
	 *           a source requirement to consider as the link source; may be null
	 * @param target
	 *           the target endpoint of the link
	 * @param targetCapability
	 *           a target capability to consider as the link target; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if a link of one of the specified types can be created
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, LinkType[] linkTypes);

	/**
	 * Determines if a link (of any of the specified types) can be created between two units.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param target
	 *           the target endpoint of the link
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if a link of one of the specified types can be created
	 */
	public IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes, int depth);

	/**
	 * Determines if a link (of any of the specified types) can be created between two units.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param sourceRequirement
	 *           a source requirement to consider as the link source; may be null
	 * @param target
	 *           the target endpoint of the link
	 * @param targetCapability
	 *           a target capability to consider as the link target; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if a link of one of the specified types can be created
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, LinkType[] linkTypes, int depth);

	/**
	 * Identifies and describes the links of the specified types that can be created.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param target
	 *           the target endpoint of the link
	 * @param linkTypes
	 *           list of link types to test
	 * @return list of link descriptors for links that can be created
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes);

	/**
	 * Identifies and describes the links of the specified types that can be created.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param sourceRequirement
	 *           a source requirement to consider as the link source; may be null
	 * @param target
	 *           the target endpoint of the link
	 * @param targetCapability
	 *           a target capability to consider as the link target; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @return list of link descriptors for links that can be created
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes);

	/**
	 * Identifies and describes the links of the specified types that can be created.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param target
	 *           the target endpoint of the link
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return list of link descriptors for links that can be created
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes,
			int depth);

	/**
	 * Identifies and describes the links of the specified types that can be created.
	 * 
	 * @param source
	 *           the source endpoint of the link
	 * @param sourceRequirement
	 *           a source requirement to consider as the link source; may be null
	 * @param target
	 *           the target endpoint of the link
	 * @param targetCapability
	 *           a target capability to consider as the link target; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return list of link descriptors for links that can be created
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes, int depth);
}
