/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider.discovery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Base code for a Discoverer for a topology.
 */
public class TopologyTopologyDiscoverer extends TopologyDiscoverer {

	/** deploy validator service for checking if can do match */
	protected DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

	/** topology this discoverer searches */
	protected Topology topology;

	private UnitProvider provider = null;

	/*
	 * references removed when getDescriptor modified private Map unitToDescriptorMap = new
	 * HashMap();
	 */

	/**
	 * Set the provider.
	 * 
	 * @param provider
	 *           the provider
	 */
	public void setProvider(UnitProvider provider) {
		this.provider = provider;
	}

	/**
	 * Return the provider
	 * 
	 * @return the provider
	 */
	public UnitProvider getProvider() {
		return provider;
	}

	/**
	 * Retrieve the topology searched by this discoverer.
	 * 
	 * @return the topology
	 */
	public Topology getTopology() {
		return topology;
	}

	/**
	 * Identify the topology searched by this discoverer.
	 * 
	 * @param topology
	 *           the topology
	 */
	public void setTopology(Topology topology) {
		if (topology != null) {
			topology = topology.getEditTopology();
		}
		this.topology = topology;
	}

	public boolean canDiscover(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		if (null == getTopology()) {
			return false;
		}
		if (null == filter.getUnit()) {
			return true;
		}
		Topology editTopology = filter.getUnit().getEditTopology();
		if (null == editTopology) {
			return true;
		}

		return getTopology().equals(editTopology);
	}

	public List findAll(DiscoveryFilter filter) {
		ArrayList results = new ArrayList();

		// check that filter is not null
		if (null == filter) {
			return results;
		}

		// check if topology is valid
		if (getTopology() == null) {
			return results;
		}

		// try special casing to find if we are trying to traverse existing
		// links
		if (DiscoveryFilterFactory.isFindHostFilter(filter)) {
			return getHost(filter);
		}

		if (DiscoveryFilterFactory.isFindHostedFilter(filter)) {
			return getHosted(filter);
		}

		if (DiscoveryFilterFactory.isFindPossibleHostsFilter(filter)) {
			return getPossibleHosts(filter);
		}

		if (DiscoveryFilterFactory.isFindPossibleHostedFilter(filter)) {
			return getPossibleHosted(filter);
		}

		if (DiscoveryFilterFactory.isFollowDependencyFilter(filter)) {
			return traverseDependencyLink(filter);
		}

		// check for bad filter
		if (filter.isDirectDependency() != null && Boolean.TRUE.equals(filter.isDirectDependency())) {
			return results;
		}

		if (DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter)) {
			return getPossibleTargets(filter);
		}

		if (DiscoveryFilterFactory.isFindPossibleSourcesFilter(filter)) {
			return getPossibleSources(filter);
		}

		if (DiscoveryFilterFactory.isFindMembersFilter(filter)) {
			return getMembers(filter);
		}

		if (DiscoveryFilterFactory.isFindGroupsFilter(filter)) {
			return getGroups(filter);
		}

		// check for bad filter
		if (filter.isExistingMemberLink() != null
				&& Boolean.TRUE.equals(filter.isExistingMemberLink())) {
			return results;
		}

		if (DiscoveryFilterFactory.isFindPossibleMembersFilter(filter)) {
			return findPossibleMembers(filter);
		}

		if (DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter)) {
			return findPossibleGroups(filter);
		}

		placeHostsInSearchTopology(filter);

		// otherwise we want to search things we can link to
		for (Iterator candidates = getTopology().findAllUnits(); candidates.hasNext();) {
			Unit candidate = (Unit) candidates.next();
			// System.out.println ("candidate = " + candidate.getName());
			// //$NON-NLS-1$

			// initInstallState
			if (!satisfiesInitialState(candidate, filter.getInitInstallState())) {
				continue;
			}

			// unitTypes
			Class[] validUnitTypes = filter.getUnitTypes();
			// only check if there are unit types specified; otherwise anything
			// is ok
			if (validUnitTypes.length != 0) {
				if (!satisfiesUnitType(candidate, validUnitTypes)) {
					continue;
				}
			}

			// requirements
			List requirements = filter.getRequirements();
			if (requirements.size() != 0) {
				// implies unit is not null
				if (!requirementsAreSatisfied(candidate, requirements, filter.getUnit())) {
					continue;
				}
			}

			// capabilities
			List capabilities = filter.getCapabilities();
			// System.out.println ("candidate = " + candidate.getName());
			// //$NON-NLS-1$
			if (capabilities.size() != 0) {
				if (!doCapabilitiesMatch(candidate, capabilities)) {
					continue;
				}
			}

			// hosts
			List acceptableHosts = filter.getHosts();
			if (acceptableHosts.size() != 0) {
				if (!isHostedBy(candidate, acceptableHosts, filter.isDirectHosting())) {
					continue;
				}
			}

			// check if unit is in the current topology (and return it if so)
			if (isAddTopologyToScope(filter)) {
				Unit candidateInCurrentTopology = TopologyUtil.getUnitInTopology(candidate, filter
						.getTopology());
				if (null != candidateInCurrentTopology) {
					candidate = candidateInCurrentTopology;
				}
			}

			results.add(getDescriptor(candidate, filter.getTopology()));
		}
		return results;
	}

	public boolean isDiscoveredUnitSame(Unit unit1, Unit unit2) {
		// if units are in the same topology can do simple compare
		if (unit1.getEditTopology() == unit2.getEditTopology() && unit1 != null) {
			return unit1 == unit2;
		}

		if (topology == null) {
			return false;
		}

		// Otherwise, need to get units in the same topology
		Unit copyUnit1 = TopologyUtil.getUnitInTopology(unit1, topology);
		Unit copyUnit2 = TopologyUtil.getUnitInTopology(unit2, topology);
		// if either result is null then we don't know where the unit came from
		// and we can't compare it to anything
		return copyUnit1 != null && copyUnit2 != null && copyUnit1 == copyUnit2;
	}

	protected boolean satisfiesInitialState(Unit candidate, List acceptableInitInstallStates) {
		if (null == candidate) {
			return false;
		}
		if (null == acceptableInitInstallStates) {
			return false;
		}
		return acceptableInitInstallStates.contains(candidate.getInitInstallState());
	}

	protected boolean satisfiesUnitType(Unit candidate, Class[] acceptableUnitTypes) {
		if (candidate == null) {
			return false;
		}
		if (acceptableUnitTypes.length == 0) {
			return true;
		}

		Class candidateClass = candidate.getClass();
		boolean typeMatch = false;
		for (int i = 0; i < acceptableUnitTypes.length; i++) {
			if (isSuperTypeOf(acceptableUnitTypes[i], candidateClass)) {
				typeMatch = true;
				break;
			}
		}
		return typeMatch;
	}

	/**
	 * Determine if class1 is a superclass of class2
	 * 
	 * @param class1
	 * @param class2
	 * @return true if class one is a super class of class 2
	 */
	protected boolean isSuperTypeOf(Class class1, Class class2) {
		Class superType = class2.getSuperclass();
		while (superType != null) {
			if (superType.equals(class1)) {
				return true;
			}
			superType = superType.getSuperclass();
		}
		Class[] interfaces = class2.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			if (interfaces[i].equals(class1)) {
				return true;
			}
			if (isSuperTypeOf(class1, interfaces[i])) {
				return true;
			}
		}
		return false;
	}

	protected boolean requirementsAreSatisfied(Unit candidate, List requirements, Unit startingUnit) {
		if (candidate == null) {
			return false;
		}
		if (requirements.size() == 0) {
			return true;
		}

		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

		Unit sourceUnit = null;
		boolean satisfiable = false;
		for (Iterator rIt = requirements.iterator(); rIt.hasNext();) {
			Requirement requirement = (Requirement) rIt.next();
			if (null == requirement) {
				// error; ignore this requirement
				continue;
			}
			if (startingUnit == null) {
				sourceUnit = ValidatorUtils.getOwningUnit(requirement);
			} else {
				sourceUnit = startingUnit;
			}
			RequirementLinkTypes reqLinkType = requirement.getLinkType();

			// check for dependency link
			if (reqLinkType.equals(RequirementLinkTypes.DEPENDENCY_LITERAL)
					|| reqLinkType.equals(RequirementLinkTypes.ANY_LITERAL)) {
				if (alreadyDependencyLinked(sourceUnit, requirement, candidate, null)
						|| dvs.canCreateLink(sourceUnit, requirement, candidate, null,
								new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT }).isOK()) {
					satisfiable = true;
					break;
				}
			}

			// check for hosting link
			if (reqLinkType.equals(RequirementLinkTypes.HOSTING_LITERAL)
					|| reqLinkType.equals(RequirementLinkTypes.ANY_LITERAL)) {
				if (alreadyHostingLinked(candidate, sourceUnit)
						|| dvs.canCreateLink(candidate, sourceUnit,
								new LinkType[] { LinkType.HOSTING, LinkType.CONSTRAINT }).isOK()) {
					satisfiable = true;
					break;
				}
			}

			// check for member link
			if (reqLinkType.equals(RequirementLinkTypes.MEMBER_LITERAL)
					|| reqLinkType.equals(RequirementLinkTypes.ANY_LITERAL)) {
				if (alreadyMemberLinked(sourceUnit, candidate)
						|| dvs.canCreateLink(sourceUnit, candidate,
								new LinkType[] { LinkType.MEMBER, LinkType.CONSTRAINT }).isOK()) {
					satisfiable = true;
					break;
				}
			}
		}
		return satisfiable;
	}

	protected boolean doCapabilitiesMatch(Unit candidate, List requiredCapabilities) {
		// ensure that each capability in requiredCapabilities is present on the
		// candidate
		for (Iterator rcIt = requiredCapabilities.iterator(); rcIt.hasNext();) {
			Capability requiredCapability = (Capability) rcIt.next();
			boolean matchFound = false;
			for (Iterator cIt = candidate.getCapabilities().iterator(); cIt.hasNext();) {
				Capability cap = (Capability) cIt.next();
				// TODO equals is the wrong check
				if (isSameCapability(requiredCapability, cap)) {
					// if (cap.equals(requiredCapability)) {
					matchFound = true;
					break;
				}
			}
			if (!matchFound) {
				return false;
			}
		}
		return true;
	}

	private boolean isSameCapability(Capability cap1, Capability cap2) {
		if (!cap1.getEObject().eClass().isInstance(cap2)) {
			return false;
		}

		// ignore annotations

		// compare attributes
		// for (Iterator amdIt = cap1.getAttributeMetaData().iterator();
		// amdIt.hasNext();) {
		// AttributeMetaData amd = (AttributeMetaData) amdIt.next();
		// System.out.println ("has attribute: " + amd.getAttributeName());
		// //$NON-NLS-1$
		// }
		return true;
	}

	protected boolean isHostedBy(Unit hostee, List acceptableHostList, Boolean directHosting) {
		boolean direct = directHosting != null;
		if (direct) {
			direct = directHosting.booleanValue();
		}

		if (acceptableHostList.size() == 0) {
			return true;
		}

		// MK 11/08/2006 added this to ensure host is in the search topology
		acceptableHostList = convertToTopology(acceptableHostList, this.getTopology());

		Unit currentHost = ValidatorUtils.getHost(hostee);

		if (direct) {
			return null != currentHost && acceptableHostList.contains(currentHost);
		}

		// otherwise look for eventual hosting
		while (null != currentHost) {
			if (acceptableHostList.contains(currentHost)) {
				return true;
			}
			currentHost = ValidatorUtils.getHost(currentHost);
		}
		return false;
	}

	// protected boolean isDiscoverHostedBy (Unit hostee, List acceptableHostList,
	// Boolean directHosting, Topology t) {
	// return isHostedBy (hostee, convertToTopology(acceptableHostList,
	// this.getTopology()), directHosting);
	// }
	//
	/**
	 * Retrieve the hosts of the unit in the unit field of a DiscoveryFilter. It is expected that the
	 * directHosting field is set to true and that the requirements, capabilities, hosts and unit
	 * types fields are all empty.
	 * 
	 * @param filter
	 *           a "find host" discovery filter
	 * @return List of unit descriptors that identifies the hosts of the unit
	 * @see UnitDescriptor
	 */
	protected List getHost(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindHostFilter(filter)) {
			return result;
		}

		Unit startingUnit = filter.getUnit();
		if (null == startingUnit) {
			return result;
		}

		Topology searchTopology = this.getTopology();
		if (startingUnit.getEditTopology() != searchTopology) {
			// we can get host only if in the same topology; if they don't match
			// we look
			// for the startingUnit in the topology this discoverer knows about
			startingUnit = TopologyUtil.getUnitInTopology(startingUnit, searchTopology);
		}

		if (null == startingUnit) {
			return result;
		}

		// get all hosts
		List<Unit> hosts = ValidatorUtils.getAllHosts(startingUnit);
		for (Unit host : hosts) {
			if (host != null) {
				// check if unit is in the current topology (and return it if so)
				if (isAddTopologyToScope(filter) && host.getEditTopology() != filter.getTopology()) {
					Unit hostInCurrentTopology = TopologyUtil.getUnitInTopology(host, filter
							.getTopology());
					if (null != hostInCurrentTopology) {
						host = hostInCurrentTopology;
					}
				}
				result.add(getDescriptor(host, filter.getTopology()));
			}
		}

		return result;
	}

	// MK new implementation of getHost()
	protected List findHost(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindHostFilter(filter)) {
			return result;
		}

		Unit hostee = filter.getUnit();

		Topology searchTopology = this.getTopology();
		Unit hosteeInSearchTopology = TopologyUtil.getUnitInTopology(hostee, searchTopology);

		Unit host = ValidatorUtils.getHost(hosteeInSearchTopology);

		if (null == host) {
			// we need to look for a containing group with a host
			// return the containing group
			DiscoveryFilter groupsFilter = DiscoveryFilterFactory.createFindGroupsFilter(hostee, null,
					filter.getTopology());
			List gUD = getMembers(groupsFilter);
			for (Iterator gIt = gUD.iterator(); gIt.hasNext();) {
				UnitDescriptor groupUD = (UnitDescriptor) gIt.next();
				Unit group = groupUD.getUnitValue();
				if (null != ValidatorUtils.getHost(group)) {
					// this is it
					host = group;
					break;
				}
			}
		}

		result.add(getDescriptor(host, filter.getTopology()));

		return result;
	}

	protected List getHosted(DiscoveryFilter filter) {
		List result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindHostedFilter(filter)) {
			return result;
		}

		List hosts = filter.getHosts();

		// determine if we need to include the current topology
		boolean searchCurrentTopology = isSearchCurrentTopology(filter);

		// get the hosted things
		// get results in the current topology
		for (Iterator hIt = hosts.iterator(); hIt.hasNext();) {
			Unit host = (Unit) hIt.next();

			// get the unit in the search topology
			Topology searchTopology = this.getTopology();
			Unit hostInTopology = TopologyUtil.getUnitInTopology(host, searchTopology);

			// get results
			List resultsInCurrentTopology = new ArrayList();
			if (searchCurrentTopology) {
				resultsInCurrentTopology = getHosted(host, filter);
			}
			List resultsInSearchTopology = new ArrayList();
			if (hostInTopology != null) {
				resultsInSearchTopology = getHosted(hostInTopology, filter);
			}

			// need to avoid duplicated results
			result = cleanDuplicate(resultsInCurrentTopology, resultsInSearchTopology, searchTopology);
		}

		return result;
	}

	private List getHosted(Unit host, DiscoveryFilter filter) {
		ArrayList result = new ArrayList();
		List hostedUnits = ValidatorUtils.getHosted(host);
		for (Iterator iter = hostedUnits.iterator(); iter.hasNext();) {
			Unit hostee = (Unit) iter.next();
			if (hostee == null) {
				continue;
			}
			if (!satisfiesUnitType(hostee, filter.getUnitTypes())) {
				continue;
			}
			if (!requirementsAreSatisfied(hostee, filter.getRequirements(), null)) {
				continue;
			}
			result.add(getDescriptor(hostee, filter.getTopology()));
		}

		return result;
	}

	protected List getPossibleHosts(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindPossibleHostsFilter(filter)) {
			return result;
		}

		Unit hostee = filter.getUnit();

		if (null != ValidatorUtils.getImmediateHost(hostee)) {
			return result;
		}

		// check each unit as a possible host
		for (Iterator uIt = this.getTopology().findAllUnits(); uIt.hasNext();) {
			Unit candidateHost = (Unit) uIt.next();
			if (candidateHost == null) {
				continue;
			}

			// check if can be a host
			if (!dvs.canCreateLink(candidateHost, hostee, new LinkType[] { LinkType.HOSTING }).isOK()) {
				continue;
			}

			// check other things
			if (!satisfiesInitialState(candidateHost, filter.getInitInstallState())) {
				continue;
			}
			if (!satisfiesUnitType(candidateHost, filter.getUnitTypes())) {
				continue;
			}
			// 11/20/2006 added this one as well
			if (!isHostedBy(candidateHost, filter.getHosts(), filter.isDirectHosting())) {
				return result;
			}

			result.add(getDescriptor(candidateHost, filter.getTopology()));
		}

		return result;
	}

	protected List getPossibleHosted(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindPossibleHostedFilter(filter)) {
			return result;
		}

		Unit host = (Unit) filter.getHosts().get(0);

		// check each unit as a possible hostee
		for (Iterator uIt = this.getTopology().findAllUnits(); uIt.hasNext();) {
			Unit candidateHostee = (Unit) uIt.next();
			if (candidateHostee == null) {
				continue;
			}

			// ignore any that are already hosted somewhere
			if (null != ValidatorUtils.getImmediateHost(candidateHostee)) {
				continue;
			}

			// check if can be a can host hostee on host
			if (!dvs.canCreateLink(host, candidateHostee, new LinkType[] { LinkType.HOSTING }).isOK()) {
				continue;
			}

			// check other things
			if (!satisfiesInitialState(candidateHostee, filter.getInitInstallState())) {
				continue;
			}
			if (!satisfiesUnitType(candidateHostee, filter.getUnitTypes())) {
				continue;
			}

			result.add(getDescriptor(candidateHostee, filter.getTopology()));
		}

		return result;
	}

	protected List traverseDependencyLink(DiscoveryFilter filter) {
		List result = new ArrayList();

		if (!isFollowDependency(filter)) {
			return result;
		}

		placeHostsInSearchTopology(filter);
		// // if necessary, modify hosts in filter to ensure they are in this (search)
		// topology
		// if (filter.getTopology() != this.getTopology()) {
		// List hostsInSearchTopology = new ArrayList();
		// for (Iterator hIt = filter.getHosts().iterator(); hIt.hasNext();) {
		// Unit h = (Unit) hIt.next();
		// hostsInSearchTopology.add(TopologyUtil.getUnitInTopology (h,
		// this.getTopology()));
		// }
		// filter.setHosts(hostsInSearchTopology);
		// }

		result = findTarget(filter);
		if (result.size() == 0) {
			result = findSources(filter);
		}

		return result;

	}

	protected boolean isFollowDependency(DiscoveryFilter filter) {
		Boolean followDep = filter.isDirectDependency();
		boolean followDependency = followDep != null;
		if (followDependency) {
			followDependency = followDep.booleanValue();
		}
		return followDependency;
	}

	protected boolean isAddTopologyToScope(DiscoveryFilter filter) {
		Boolean addTop = filter.isAddTopologyToScope();
		boolean addTopology = addTop != null;
		if (addTopology) {
			addTopology = addTop.booleanValue();
		}
		return addTopology;
	}

	protected void placeHostsInSearchTopology(DiscoveryFilter filter) {
		// if necessary, modify hosts in filter to ensure they are in this
		// (search) topology
		if (filter.getTopology() != this.getTopology()) {
			filter.setHosts(convertToTopology(filter.getHosts(), this.getTopology()));
			// List hostsInSearchTopology = new ArrayList();
			// for (Iterator hIt = filter.getHosts().iterator(); hIt.hasNext();) {
			// Unit h = (Unit) hIt.next();
			// hostsInSearchTopology.add(TopologyUtil.getUnitInTopology (h,
			// this.getTopology()));
			// }
			// filter.setHosts(hostsInSearchTopology);
		}
	}

	protected List convertToTopology(List units, Topology topology) {
		List converted = new ArrayList();
		for (Iterator uIt = units.iterator(); uIt.hasNext();) {
			Unit unit = (Unit) uIt.next();
			converted.add(convertToTopology(unit, topology));
		}
		return converted;
	}

	protected Unit convertToTopology(Unit unit, Topology topology) {
		return TopologyUtil.getUnitInTopology(unit, topology);
	}

	protected List findTarget(DiscoveryFilter filter) {
		List result = new ArrayList();

		if (!isFollowDependency(filter)) {
			return result;
		}

		Unit startingUnit = filter.getUnit();
		List requirements = filter.getRequirements();

		if (requirements.size() == 1 && null != startingUnit) {
			Requirement requirement = (Requirement) requirements.get(0);
			if (null == requirement) {
				// invalid filter
				return result;
			}
			if (requirement.getLinkType().equals(RequirementLinkTypes.DEPENDENCY_LITERAL)
					|| requirement.getLinkType().equals(RequirementLinkTypes.ANY_LITERAL)) {
				if (!startingUnit.getRequirements().contains(requirement)) {
					// requirement isn't related to startingUnit
					return result;
				}

				// make sure we start in the right search topology
				Topology searchTopology = this.getTopology();
				if (startingUnit.getEditTopology() != searchTopology) {
					startingUnit = TopologyUtil.getUnitInTopology(startingUnit, searchTopology);
					if (null == startingUnit) {
						return result;
					}
					// need to set requirement to the copy in search topology
					requirement = lookupRequirement(startingUnit, requirement.getName());
					assert null != requirement;
				}
				List capList = ValidatorUtils.getDependencyLinkTargets(requirement);
				if (capList.size() != 1) {
					return result;
				}
				Capability targetCap = (Capability) capList.iterator().next();
				if (null == targetCap) {
					return result;
				}
				Unit target = ValidatorUtils.getOwningUnit(targetCap);

				if (target == null) {
					return result;
				}
				// Test case with unhosted target capability in
				// DeployCoreMarkerValidatorTest
				// triggers this assert.
				// assert target != null;

				// MK 11/20/2006 added 3 checks
				// check other things; the filter may be looking for more than
				// just the target
				if (!satisfiesInitialState(target, filter.getInitInstallState())) {
					return result;
				}
				if (!satisfiesUnitType(target, filter.getUnitTypes())) {
					return result;
				}
				if (!isHostedBy(target, filter.getHosts(), filter.isDirectHosting())) {
					return result;
				}

				// check if unit is in the current topology (and return it if
				// so)
				if (isAddTopologyToScope(filter)) {
					Unit targetInCurrentTopology = TopologyUtil.getUnitInTopology(target, filter
							.getTopology());
					if (null != targetInCurrentTopology) {
						target = targetInCurrentTopology;
					}
				}

				result.add(getDescriptor(target, filter.getTopology()));
			}
		}

		return result;
	}

	protected List findSources(DiscoveryFilter filter) {
		List result = new ArrayList();

		if (!isFollowDependency(filter)) {
			return result;
		}

		Unit targetInCurrentTopology = filter.getUnit();
		List capabilities = filter.getCapabilities();

		if (capabilities.size() == 1 && null != targetInCurrentTopology) {
			Capability capability = (Capability) capabilities.get(0);
			if (null == capability) {
				// invalid filter
				return result;
			}
			if (capability.getLinkType().equals(CapabilityLinkTypes.DEPENDENCY_LITERAL)
					|| capability.getLinkType().equals(CapabilityLinkTypes.ANY_LITERAL)) {
				// assert capability.getLinkType().equals(
				// CapabilityLinkTypes.DEPENDENCY_LITERAL)
				// || capability.getLinkType().equals(
				// CapabilityLinkTypes.ANY_LITERAL);
				if (!targetInCurrentTopology.getCapabilities().contains(capability)) {
					// requirement isn't related to startingUnit
					return result;
				}

				// get the unit in the search topology
				Topology searchTopology = this.getTopology();
				Unit targetInSearchTopology = TopologyUtil.getUnitInTopology(targetInCurrentTopology,
						searchTopology);

				boolean searchInCurrentTopology = isSearchCurrentTopology(filter);

				// get results in current topology and in search topology
				List resultsInCurrentTopology = new ArrayList();
				if (searchInCurrentTopology) {
					resultsInCurrentTopology = getSources(targetInCurrentTopology, capability, filter);
				}

				List resultsInSearchTopology = new ArrayList();
				if (targetInSearchTopology != null) {
					// get capability in search environment too
					capability = lookupCapability(targetInSearchTopology, capability.getName());
					resultsInSearchTopology = getSources(targetInSearchTopology, capability, filter);
				}

				result = cleanDuplicate(resultsInCurrentTopology, resultsInSearchTopology,
						searchTopology);
			}
		}
		return result;
	}

	protected List getPossibleTargets(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter)) {
			return result;
		}

		// filter.setInitInstallState(InstallState.VALUES);
		// filter.setUnit(source);
		// filter.setRequirements(Arrays.asList(new Requirement[] { sourceRequirement
		// }));

		Unit source = filter.getUnit();
		Requirement sourceRequirement = (Requirement) filter.getRequirements().get(0);

		// check each unit as a possible target
		for (Iterator uIt = this.getTopology().findAllUnits(); uIt.hasNext();) {
			Unit candidateTarget = (Unit) uIt.next();
			if (candidateTarget == null) {
				continue;
			}

			// check if can be a can host hostee on host
			if (!dvs.canCreateLink(source, sourceRequirement, candidateTarget, null,
					LinkType.DEPENDENCY_SET).isOK()) {
				continue;
			}

			// check other things
			if (!satisfiesInitialState(candidateTarget, filter.getInitInstallState())) {
				continue;
			}
			if (!satisfiesUnitType(candidateTarget, filter.getUnitTypes())) {
				continue;
			}
			if (!isHostedBy(candidateTarget, filter.getHosts(), filter.isDirectHosting())) {
				continue;
			}

			result.add(getDescriptor(candidateTarget, filter.getTopology()));
		}

		return result;
	}

	private List getSources(Unit targetUnit, Capability targetCapability, DiscoveryFilter filter) {
		List sourceList = ValidatorUtils.getDependencyLinkSources(targetCapability);
		if (sourceList.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		List result = new ArrayList(sourceList.size());
		for (Iterator iter = sourceList.iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			Unit unit = ValidatorUtils.getUnit(req);
			// check other things
			if (!satisfiesUnitType(unit, filter.getUnitTypes())) {
				continue;
			}
			if (!isHostedBy(unit, filter.getHosts(), filter.isDirectHosting())) {
				continue;
			}
			result.add(getDescriptor(unit, filter.getTopology()));
		}
		return result;
	}

	protected List getPossibleSources(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindPossibleSourcesFilter(filter)) {
			return result;
		}

		Unit target = filter.getUnit();
		Capability targetCapability = (Capability) filter.getCapabilities().get(0);

		// check each unit as a possible source
		for (Iterator uIt = this.getTopology().findAllUnits(); uIt.hasNext();) {
			Unit candidateSource = (Unit) uIt.next();
			if (candidateSource == null) {
				continue;
			}

			// check if can be a can host hostee on host
			if (!dvs.canCreateLink(candidateSource, null, target, targetCapability,
					LinkType.DEPENDENCY_SET).isOK()) {
				continue;
			}

			// check other things
			if (!satisfiesInitialState(candidateSource, filter.getInitInstallState())) {
				continue;
			}
			if (!satisfiesUnitType(candidateSource, filter.getUnitTypes())) {
				continue;
			}
			if (!isHostedBy(candidateSource, filter.getHosts(), filter.isDirectHosting())) {
				continue;
			}

			result.add(getDescriptor(candidateSource, filter.getTopology()));
		}

		return result;
	}

	protected boolean alreadyDependencyLinked(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		DependencyLink link = sourceRequirement.getLink();
		if (null == link) {
			return false;
		}

		// a link already exists; is to to target?
		Capability tCap = link.getTarget();
		if (null == tCap) {
			return false;
		}

		return target == ValidatorUtils.getOwningUnit(tCap);
	}

	protected boolean alreadyHostingLinked(Unit host, Unit hostee) {
		Unit currentHost = ValidatorUtils.getHost(hostee);
		return host == currentHost;
	}

	protected boolean alreadyMemberLinked(Unit group, Unit member) {
		Topology editTopology = member.getEditTopology();
		if (editTopology != null) {
			Unit[] groups = editTopology.findMemberOf(member);
			for (int i = 0; i < groups.length; i++) {
				if (groups[i] == group) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isSearchCurrentTopology(DiscoveryFilter filter) {
		boolean searchCurrentTopology = false;
		Boolean searchCurrentTopologyB = filter.isAddTopologyToScope();
		if (null != searchCurrentTopologyB) {
			searchCurrentTopology = searchCurrentTopologyB.booleanValue();
		}

		return searchCurrentTopology;
	}

	private List<UnitDescriptor> removeNullEntries(List<UnitDescriptor> udList) {
		List<UnitDescriptor> result = new ArrayList<UnitDescriptor>();
		for (UnitDescriptor ud : udList) {
			if (null != ud) {
				result.add(ud);
			}
		}
		return result;
	}

	private List cleanDuplicate(List resultsInCurrentTopology, List resultsInSearchTopology,
			Topology searchTopology) {
		List result = new ArrayList();

		// remove null entries; there seem to be some.
		resultsInCurrentTopology = removeNullEntries(resultsInCurrentTopology);
		// remove results from resultsInSearchTopology that are in
		// resultsInCurrentTopology
		for (Iterator rcIt = resultsInCurrentTopology.iterator(); rcIt.hasNext();) {
			UnitDescriptor ud = (UnitDescriptor) rcIt.next();
			Unit rc = ud.getUnitValue();
			Unit rs = TopologyUtil.getUnitInTopology(rc, searchTopology);
			if (rs != null) {
				for (int i = 0; i < resultsInSearchTopology.size(); i++) {
					UnitDescriptor rsD = (UnitDescriptor) resultsInSearchTopology.get(i);
					if (rs == rsD.getUnitValue()) {
						resultsInSearchTopology.remove(i);
						break;
					}
				}
			}
		}

		result = concatenate(result, resultsInCurrentTopology);
		result = concatenate(result, resultsInSearchTopology);

		return result;
	}

	private List concatenate(List aList, List bList) {
		for (Iterator oIt = bList.iterator(); oIt.hasNext();) {
			aList.add(oIt.next());
		}
		return aList;
	}

	/**
	 * Find a requirement with a given name in a unit.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param reqName
	 *           the requirement name
	 * @return the requirement from the searched unit
	 */
	// TODO this was copied from ResolutionUtils; should refactor
	private static Requirement lookupRequirement(Unit unit, String reqName) {
		for (Iterator it = unit.getRequirements().iterator(); it.hasNext();) {
			Requirement req = (Requirement) it.next();
			if (req.getName().equals(reqName)) {
				return req;
			}
		}

		return null;
	}

	/**
	 * Find a capability with a given name in a unit.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param capName
	 *           the capability name
	 * @return the capability
	 */
	// TODO this was copied from ResolutionUtils; should refactor
	private static Capability lookupCapability(Unit unit, String capName) {
		for (Iterator it = unit.getCapabilities().iterator(); it.hasNext();) {
			Capability cap = (Capability) it.next();
			if (cap.getName().equals(capName)) {
				return cap;
			}
		}

		return null;
	}

	protected List getMembers(DiscoveryFilter filter) {
		List result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindMembersFilter(filter)) {
			return result;
		}

		// make sure everything references the search topology
		placeHostsInSearchTopology(filter);

		Unit groupInCurrentTopology = filter.getUnit();

		// determine if we need to include the current topology
		boolean searchCurrentTopology = isSearchCurrentTopology(filter);

		// get the members
		// get results in the current topology

		// get the unit in the search topology
		Unit groupInSearchTopology = TopologyUtil.getUnitInTopology(groupInCurrentTopology, this
				.getTopology());

		// get results
		List resultsInCurrentTopology = new ArrayList();
		if (searchCurrentTopology) {
			resultsInCurrentTopology = getMembers(groupInCurrentTopology, filter);
		}
		List resultsInSearchTopology = new ArrayList();
		if (groupInSearchTopology != null) {
			resultsInSearchTopology = getMembers(groupInSearchTopology, filter);
		}

		// need to avoid duplicated results
		result = cleanDuplicate(resultsInCurrentTopology, resultsInSearchTopology, this.getTopology());

		return result;
	}

	private List getMembers(Unit group, DiscoveryFilter filter) {
		ArrayList result = new ArrayList();
		List members = ValidatorUtils.getMembers(group);
		for (Iterator iter = members.iterator(); iter.hasNext();) {
			Unit member = (Unit) iter.next();
			if (!satisfiesUnitType(member, filter.getUnitTypes())) {
				continue;
			}
			if (!isHostedBy(member, filter.getHosts(), filter.isDirectHosting())) {
				continue;
			}
			if (filter.getRequirements().size() != 0
					&& !ValidatorUtils.areOutRequirementsSatisfied(group, member, filter
							.getRequirements())) {
				// if (!requirementsAreSatisfied(member, filter.getRequirements(),
				// null)) {
				continue;
			}
			// check other things
			result.add(getDescriptor(member, filter.getTopology()));
		}

		return result;
	}

	protected List getGroups(DiscoveryFilter filter) {
		List result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindGroupsFilter(filter)) {
			return result;
		}

		Unit member = filter.getUnit();
		// get the unit in the search topology
		Unit memberInSearchTopology = TopologyUtil.getUnitInTopology(member, this.getTopology());

		List groups = ValidatorUtils.getGroups(memberInSearchTopology);
		for (Iterator iter = groups.iterator(); iter.hasNext();) {
			Unit group = (Unit) iter.next();
			if (null == group) {
				continue;
			}

			if (!satisfiesUnitType(group, filter.getUnitTypes())) {
				continue;
			}

			if (!isHostedBy(group, filter.getHosts(), filter.isDirectHosting())) {
				continue;
			}

			// if there are member requirements, check that they are satisfied
			// by this group
			if (filter.getRequirements().size() != 0) {
				if (!ValidatorUtils.areInRequirementsSatisfied(group, member, filter.getRequirements())) {
					continue;
				}
			}

			result.add(getDescriptor(group, filter.getTopology()));
		}

		return result;
	}

	protected List findPossibleMembers(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindPossibleMembersFilter(filter)) {
			return result;
		}

		// make sure everything references the search topology
		placeHostsInSearchTopology(filter);

		Unit groupInCurrentTopology = filter.getUnit();

		// assume that current search is done by call to
		// CurrentTopologyDiscoverer
		// determine if we need to include the current topology

		// get the members
		// get results in the current topology

		// get the unit in the search topology
		Unit groupInSearchTopology = TopologyUtil.getUnitInTopology(groupInCurrentTopology, this
				.getTopology());

		// get results
		List resultsInSearchTopology = new ArrayList();
		if (groupInSearchTopology != null) {
			resultsInSearchTopology = getPossibleMembers(groupInSearchTopology, filter);
		}

		return resultsInSearchTopology;
	}

	private List getPossibleMembers(Unit group, DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		Topology editTopology = group.getEditTopology();
		if (editTopology == null) {
			return result;
		}
		for (Iterator uIt = editTopology.findAllUnits(); uIt.hasNext();) {
			Unit candidate = (Unit) uIt.next();
			if (candidate == null) {
				continue;
			}

			// check if can be a member of the group
			if (!dvs.canCreateLink(group, candidate, new LinkType[] { LinkType.MEMBER }).isOK()) {
				continue;
			}

			// check other things
			if (!satisfiesInitialState(candidate, filter.getInitInstallState())) {
				continue;
			}
			if (!satisfiesUnitType(candidate, filter.getUnitTypes())) {
				continue;
			}
			if (!isHostedBy(candidate, filter.getHosts(), filter.isDirectHosting())) {
				continue;
				// if (!requirementsAreSatisfied(candidate, filter.getRequirements(),
				// null)) {
				// continue;
				// }
			}

			result.add(getDescriptor(candidate, filter.getTopology()));
		}

		return result;
	}

	protected List findPossibleGroups(DiscoveryFilter filter) {
		ArrayList result = new ArrayList();

		if (!DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter)) {
			return result;
		}

		Unit member = filter.getUnit();

		Topology editTopology = member.getEditTopology();
		if (editTopology == null) {
			return result;
		}
		for (Iterator uIt = editTopology.findAllUnits(); uIt.hasNext();) {
			Unit candidateGroup = (Unit) uIt.next();
			if (candidateGroup == null) {
				continue;
			}

			// check if member can be in group candidateGroup
			if (!dvs.canCreateLink(candidateGroup, member, new LinkType[] { LinkType.MEMBER }).isOK()) {
				continue;
			}

			// check other things
			if (!satisfiesUnitType(candidateGroup, filter.getUnitTypes())) {
				continue;
			}
			if (!isHostedBy(candidateGroup, filter.getHosts(), filter.isDirectHosting())) {
				continue;
			}

			result.add(getDescriptor(candidateGroup, filter.getTopology()));
		}

		return result;
	}

	private UnitDescriptor getDescriptor(Unit unit, Topology topology) {
		// UnitDescriptor ud = (UnitDescriptor) unitToDescriptorMap.get(unit);
		// if (null == ud) {
		// ud = new TopologyUnitDescriptor(unit, topology, provider);
		// unitToDescriptorMap.put(unit, ud);
		// }
		// return ud;
		// MK 7/19/2007 cf. defect 2640, we allow a non null unit descriptor to contain a null unit
//		return new TopologyUnitDescriptor(unit, topology, provider);
		UnitDescriptor ud = new TopologyUnitDescriptor(unit, topology, provider);
		return ud.getUnitValue() == null ? null : ud;
	}

}
