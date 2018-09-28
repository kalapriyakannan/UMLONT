/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides a standard base class for extenders of the <b>com.ibm.ccl.soa.deploy.core.domains</b>
 * extension point who provide a <b>&lt;validator /&gt;</b> element.
 * <p>
 * This class is typically extended by a matcher that wants to replace the core matcher completely
 * without any reference to the core matching rules. If one wants the core matching rules, one would
 * extends {@link CoreDomainMatcher} instead.
 * 
 * @see CoreDomainMatcher
 */
public abstract class DomainMatcher {

	/**
	 * Returns true if unit can be a link source for any one of the specified link types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if unit can be a link source
	 */
	public abstract IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes);

	/**
	 * Determines if a unit, requirement pair can be a link source for any one of the specified link
	 * types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param requirment
	 *           the source requirement to consider; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @return status OK if unit, requirement pair can be a link source
	 */
	public abstract IStatus canBeLinkSource(Unit unit, Requirement requirment, LinkType[] linkTypes);

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
	public abstract IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes, int depth);

	/**
	 * Determines if a unit, requirement pair can be a link source for any one of the specified link
	 * types.
	 * 
	 * @param unit
	 *           unit to be tested
	 * @param requirment
	 *           the source requirement to consider; may be null
	 * @param linkTypes
	 *           list of link types to test
	 * @param depth
	 *           membership/hosted configuration unit depth to which to search
	 * @return status OK if unit, requirement pair can be a link source
	 */
	public abstract IStatus canBeLinkSource(Unit unit, Requirement requirment, LinkType[] linkTypes,
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
	public abstract IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes);

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
	public abstract IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes);

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
	public abstract IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes, int depth);

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
	public abstract IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes,
			int depth);

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
	public abstract IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes);

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
	public abstract IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap,
			LinkType[] linkTypes);

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
	public abstract IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes, int depth);

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
	public abstract IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap,
			LinkType[] linkTypes, int depth);

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
	public abstract IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes);

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
	public abstract IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
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
	public abstract IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes, int depth);

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
	public abstract IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
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
	public abstract LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes);

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
	public abstract LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
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
	public abstract LinkDescriptor[] getPossibleLinks(Unit source, Unit target,
			LinkType[] linkTypes, int depth);

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
	public abstract LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes, int depth);
}
