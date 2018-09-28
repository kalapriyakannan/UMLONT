/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 * @author nmakin
 * 
 */
public class DiscoverAndAddService {
	/**
	 * get the singleton instance to this service
	 */
	public static DiscoverAndAddService INSTANCE = new DiscoverAndAddService();
	protected DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

	/**
	 * Discover the hosts descriptors for the units in the list
	 * 
	 * @param hosteeUnitList
	 *           list of units that need to be hosted
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
	public Map discoverHostUnitDescriptors(List hosteeUnitList) {
		Map possibleHostDescrs = new HashMap();
		for (Iterator iter = hosteeUnitList.iterator(); iter.hasNext();) {
			Unit hosteeUnit = (Unit) iter.next();
			List hostDescList = discoverHostUnitDescriptors(hosteeUnit);
			if (hostDescList != null && !hostDescList.isEmpty()) {
				possibleHostDescrs.put(hosteeUnit, hostDescList);
			}
		}
		return possibleHostDescrs;
	}

	/**
	 * Discover the dependency descriptors for the units in the list
	 * 
	 * @param dependentUnitList
	 *           list of units that need to be used for finding dependency
	 * @return Map a map of dependent unit to a map of it's requirement to possible dependency
	 *         descriptors
	 */
	public Map<Unit, Map<Requirement, List<LinkDescriptor>>> discoverDependencyUnitDescriptors(
			List<Unit> dependentUnitList) {
		Map<Unit, Map<Requirement, List<LinkDescriptor>>> possibleDependencyDescrs = new HashMap<Unit, Map<Requirement, List<LinkDescriptor>>>();
		for (Unit dependentUnit : dependentUnitList) {
			Map<Requirement, List<LinkDescriptor>> dependencyRequirementToTargetDescMap = discoverDependencyUnitDescriptors(dependentUnit);
			if (dependencyRequirementToTargetDescMap != null
					&& !dependencyRequirementToTargetDescMap.isEmpty()) {
				possibleDependencyDescrs.put(dependentUnit, dependencyRequirementToTargetDescMap);
			}
		}
		return possibleDependencyDescrs;
	}

	/**
	 * Discover the hosts descriptors for the units in the list
	 * 
	 * @param hosteeUnits
	 *           array of units that need to be hosted
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
	public Map discoverHostUnitDescriptors(Object[] hosteeUnits) {
		return discoverHostUnitDescriptors(Arrays.asList(hosteeUnits));
	}

	/**
	 * Discover the hosts descriptors for the units topology
	 * 
	 * @param topology
	 *           a topology
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
	public Map discoverHostUnitDescriptors(Topology topology) {
		Map possibleHostDescrs = new HashMap();
		for (Iterator iter = topology.getUnits().iterator(); iter.hasNext();) {
			Unit hosteeUnit = (Unit) iter.next();
			List hostDescList = discoverHostUnitDescriptors(hosteeUnit);
			if (hostDescList != null && !hostDescList.isEmpty()) {
				possibleHostDescrs.put(hosteeUnit, hostDescList);
			}
		}
		return possibleHostDescrs;
	}

	/**
	 * Discover the dependency descriptors for the units in topology
	 * 
	 * @param topology
	 *           a topology
	 * @return Map a map of dependent unit to a map of it's requirement to possible dependency
	 *         descriptors
	 */
	@SuppressWarnings("unchecked")
	public Map<Unit, Map<Requirement, List<LinkDescriptor>>> discoverDependencyUnitDescriptors(
			Topology topology) {
		Map<Unit, Map<Requirement, List<LinkDescriptor>>> possibleDependencyDescrs = new HashMap<Unit, Map<Requirement, List<LinkDescriptor>>>();
		List<Unit> units = topology.getUnits();
		for (Unit dependentUnit : units) {
			Map<Requirement, List<LinkDescriptor>> dependencyRequirementToTargetDescMap = discoverDependencyUnitDescriptors(dependentUnit);
			if (dependencyRequirementToTargetDescMap != null
					&& !dependencyRequirementToTargetDescMap.isEmpty()) {
				possibleDependencyDescrs.put(dependentUnit, dependencyRequirementToTargetDescMap);
			}
		}
		return possibleDependencyDescrs;
	}

	/**
	 * Discover the dependency descriptors for the dependent unit. All the requirements of the unit
	 * will be searched individually and matching targets will be found.
	 * 
	 * @param dependent
	 *           a unit that need to be used for finding dependency
	 * @return Map possible dependency descriptors for the unit requirements
	 */
//	@SuppressWarnings("unchecked")
//	public Map<Requirement, List<LinkDescriptor>> discoverDependencyUnitDescriptors(Unit dependent) {
//		Topology topology = dependent.getTopology();
//		List<Requirement> requirements = dependent.getDependencyOrAnyRequirements();
//		Map<Requirement, List<LinkDescriptor>> requirementToTargetDescMap = new HashMap<Requirement, List<LinkDescriptor>>();
//		for (Requirement requirement : requirements) {
//			discoverDependencyUnitDescriptors(requirement, topology, dependent,
//					requirementToTargetDescMap);
//		}
//		return requirementToTargetDescMap;
//	}
//
	@SuppressWarnings("unchecked")
	public Map<Requirement, List<LinkDescriptor>> discoverDependencyUnitDescriptors(Unit dependent) {
		Map<Requirement, List<LinkDescriptor>> requirementToTargetDescMap = new HashMap<Requirement, List<LinkDescriptor>>();
		// MK 02-29-2008: defect 5549:
		// must discover possible links recusively including member units and hosted configuration units
		return discoverDependencyUnitDescriptors(dependent, requirementToTargetDescMap);
	}

	private Map<Requirement, List<LinkDescriptor>> discoverDependencyUnitDescriptors(Unit dependent,
			Map<Requirement, List<LinkDescriptor>> requirementToTargetDescMap) {
		Topology topology = dependent.getTopology();

		// check local requirements
		// check requirements on member units
		// check requirements on hosted configuration units

		// check local requirements
		List<Requirement> requirements = dependent.getDependencyOrAnyRequirements();
//		Map<Requirement, List<LinkDescriptor>> requirementToTargetDescMap = new HashMap<Requirement, List<LinkDescriptor>>();
		for (Requirement requirement : requirements) {
			discoverDependencyUnitDescriptors(requirement, topology, dependent,
					requirementToTargetDescMap);
		}

		// check requirements on member units
		List<Unit> members = ValidatorUtils.discoverMembers(dependent, null);
		for (Unit member : members) {
			discoverDependencyUnitDescriptors(member, requirementToTargetDescMap);
		}

		// check hosted configuration units
		List<Unit> hostedUnits = ValidatorUtils.discoverHosted(dependent, null);
		for (Unit hosted : hostedUnits) {
			discoverDependencyUnitDescriptors(hosted, requirementToTargetDescMap);
		}

		return requirementToTargetDescMap;
	}

	/**
	 * 
	 * @param requirement
	 * @return A Map containing the passed {@link Requirement} as key and a {@link List} of
	 *         {@link LinkDescriptor}s.
	 */
	public Map<Requirement, List<LinkDescriptor>> discoverDependencyUnitDescriptors(
			Requirement requirement) {
		if (requirement.getLinkType() != RequirementLinkTypes.DEPENDENCY_LITERAL) {
			return null;
		}
		Topology topology = requirement.getTopology();
		DeployModelObject dmo = requirement.getParent();
		Unit unit = null;
		if (dmo instanceof Unit) {
			unit = (Unit) dmo;
		} else {
			return null;
		}

		Map<Requirement, List<LinkDescriptor>> requirementToTargetDescMap = new HashMap<Requirement, List<LinkDescriptor>>();
		discoverDependencyUnitDescriptors(requirement, topology, unit, requirementToTargetDescMap);
		return requirementToTargetDescMap;
	}

	private void discoverDependencyUnitDescriptors(Requirement requirement, Topology topology,
			Unit unit, Map<Requirement, List<LinkDescriptor>> requirementToTargetDescMap) {

		if (!(requirement.getLinkType().getValue() == RequirementLinkTypes.DEPENDENCY)) {
			return;
		}
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(unit,
				requirement, topology);
		if (TopologyDiscovererService.INSTANCE.canDiscover(filter)) {
			List<UnitDescriptor> targetUnitDescs = TopologyDiscovererService.INSTANCE.findAll(filter);

			List<LinkDescriptor> allDescriptors = new ArrayList<LinkDescriptor>();
			for (UnitDescriptor unitDescriptor : targetUnitDescs) {
				Unit targetUnit = unitDescriptor.getUnitValue();
				LinkDescriptor[] descriptors = dvs.getPossibleLinks(unit, requirement, targetUnit,
						null, LinkType.DEPENDENCY_SET);
				if (descriptors != null) {
					for (int i = 0; i < descriptors.length; i++) {
						allDescriptors.add(descriptors[i]);
					}
				}
			}
			if (!allDescriptors.isEmpty()) {
				requirementToTargetDescMap.put(requirement, allDescriptors);
			}

		}
	}

	public Set<LinkDescriptor> discoverLogicalLinks(Unit source) {
		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();
		Topology top = source.getEditTopology();
		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
		for (Iterator<Unit> units = top.findAllUnits(); units.hasNext();) {
			Unit u = units.next();
			LinkDescriptor[] desc = dvs.getPossibleLinks(source, u, LinkType.CONSTRAINT_SET);
			for (int i = 0; i < desc.length; i++) {
				possibleLinks.add(desc[i]);
			}
		}
		return possibleLinks;
	}

	/**
	 * Discover the hosts descriptors for the hostee unit
	 * 
	 * @param hostee
	 *           a unit that need to be hosted
	 * @return List possible host descriptors
	 */
	public List discoverHostUnitDescriptors(Unit hostee) {
		List<UnitDescriptor> hostUDList = new ArrayList<UnitDescriptor>();
		Topology topology = hostee.getTopology();
		if (null == hostUDList) {
			hostUDList = new ArrayList<UnitDescriptor>();
		}

		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(hostee,
				topology);
		if (TopologyDiscovererService.INSTANCE.canDiscover(filter)) {
			hostUDList.addAll(TopologyDiscovererService.INSTANCE.findAll(filter));
		}

		return hostUDList;
	}

	/**
	 * Discover the member descriptors for the contained member unit
	 * 
	 * @param containedMember
	 *           a Unit that may be contained
	 * @return List possible container descriptors
	 */
	public List discoverContainerUnitDescriptors(Unit containedMember) {
		Topology topology = containedMember.getTopology();
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(
				containedMember, null, topology);
		if (TopologyDiscovererService.INSTANCE.canDiscover(filter)) {
			return TopologyDiscovererService.INSTANCE.findAll(filter);
		}
		return new ArrayList(0);
	}

	/**
	 * Create the hosting link and Add the discovered unit to the topology If the unit already exist
	 * in the topology, do not add it to the topology and return.
	 * 
	 * @param hostee
	 *           the unit to be hosted
	 * @param hostDesc
	 *           the unit descriptor for the host
	 * @return Unit the unit that was added
	 */
	// MK 4/23/2007 1 current reference found
	//    changed getTopology() to getEditTopology()
	public Unit addAndHostDiscoveredUnitToTopology(Unit hostee, UnitDescriptor hostDesc) {
		//find existing in topology
		Unit hoster = null;
		if (!hostDesc.isExistingUnit()) {
			hoster = hostDesc.getUnitValueAndAddToTopology(hostee.getEditTopology());
			ResolutionUtils.makeNameUnique(hoster, hostee.getEditTopology());
			ResolutionUtils.hosts(null, hoster, hostee);
		} else {
			ResolutionUtils.hosts(null, hostDesc.getUnitValue(), hostee);
		}
		return hoster;
	}

	/**
	 * Create the member link and Add the discovered unit to the topology If the unit already exist
	 * in the topology, do not add it to the topology and return.
	 * 
	 * @param member
	 *           the unit to be hosted
	 * @param containerDesc
	 *           the unit descriptor for the container
	 * @return Unit the unit that was added
	 */
	// MK 4/23/2007 found 1 current reference
	//    changed getTopolgy() to getEditTopology()
	public Unit addAndContainDiscoveredUnitToTopology(Unit member, UnitDescriptor containerDesc) {
		//find existing in topology
		Unit container = null;
		if (!containerDesc.isExistingUnit()) {
			container = containerDesc.getUnitValue();
			ResolutionUtils.makeNameUnique(container, member.getEditTopology());
			member.getEditTopology().getUnits().add(container);
			ResolutionUtils.addMember(null, container, member);
		} else {
			ResolutionUtils.addMember(null, containerDesc.getUnitValue(), member);
		}
		return container;
	}

	/**
	 * Create the dependency link and Add the discovered target unit to the topology If the unit
	 * already exist in the topology, do not add it to the topology and return.
	 * 
	 * @param dependent
	 *           the source unit
	 * @param dependency
	 *           the target unit descriptor
	 * @return Unit the target unit
	 */
	// MK 4/23/2007 no references to this method found
	public Unit addDiscoveredUnitAndDependenyLinkToTopology(Unit dependent,
			UnitDescriptor dependencyDesc) {
		//find existing in topology
		Unit dependency = null;
		if (!dependencyDesc.isExistingUnit()) {
			dependency = dependencyDesc.getUnitValue();
			ResolutionUtils.makeNameUnique(dependency, dependent.getTopology());
			dependent.getEditTopology().getUnits().add(dependency);
			LinkType[] linkTypes = new LinkType[] { LinkType.DEPENDENCY };
			LinkDescriptor[] linkDescrs = dvs.getPossibleLinks(dependent, dependency, linkTypes);
			for (int i = 0; i < linkDescrs.length; i++) {
				linkDescrs[i].create();
			}
		} else {
			LinkType[] linkTypes = new LinkType[] { LinkType.DEPENDENCY };
			LinkDescriptor[] linkDescrs = dvs.getPossibleLinks(dependent, dependency, linkTypes);
			for (int i = 0; i < linkDescrs.length; i++) {
				linkDescrs[i].create();
			}
		}
		return dependency;
	}

	/**
	 * Create the dependency link and Add the discovered target unit to the topology If the unit
	 * already exist in the topology, do not add it to the topology, create the link and return.
	 * 
	 * @param requirement
	 *           the source requirement
	 * @param capability
	 *           the target capability
	 * @return Unit the target unit
	 */
	// MK 4/23/2007 one current reference found
	//    changed getTopology() to getEditTopology() 
	public Unit addTargetUnitAndDependenyLinkToTopology(Requirement requirement,
			Capability capability) {
		Unit sourceUnit = ValidatorUtils.getOwningUnit(requirement);
		Unit targetUnit = ValidatorUtils.getOwningUnit(capability);
		if (targetUnit.getEditTopology() != sourceUnit.getEditTopology()) {
			ResolutionUtils.makeNameUnique(targetUnit, sourceUnit.getTopology());
			sourceUnit.getEditTopology().getUnits().add(targetUnit);
		}
		LinkFactory.createDependencyLink(sourceUnit, requirement, targetUnit, capability);
		return targetUnit;
	}

	/**
	 * Create the dependency link and Add the discovered target unit to the topology If the unit
	 * already exist in the topology, do not add it to the topology, create the link and return.
	 * 
	 * @param requirement
	 *           the source requirement
	 * @param capability
	 *           the target capability
	 * @return Unit the target unit
	 */
	// MK 4/23/2007 no references to this method found
	public Unit addDependencyForTargetUnitToTopology(Requirement requirement, Capability capability) {
		Unit sourceUnit = ValidatorUtils.getOwningUnit(requirement);
		Unit targetUnit = ValidatorUtils.getOwningUnit(capability);
		LinkFactory.createDependencyLink(sourceUnit, requirement, targetUnit, capability);
		return targetUnit;
	}

	/**
	 * Create the dependency link between the units
	 * 
	 * @param dependent
	 *           the source unit for dependency link
	 * @param dependencyDesc
	 *           the unit descriptor for the target of the dependency link
	 * @return Unit the target unit
	 */
	// MK 4/23/2007 no references to this method found
	public Unit addDependencyForDiscoveredUnitToTopology(Unit dependent,
			UnitDescriptor dependencyDesc) {
		Unit dependencyUnit = dependencyDesc.getUnitValue();
		LinkType[] linkTypes = new LinkType[] { LinkType.DEPENDENCY };
		LinkDescriptor[] linkDescrs = dvs.getPossibleLinks(dependent, dependencyUnit, linkTypes);
		for (int i = 0; i < linkDescrs.length; i++) {
			linkDescrs[i].create();
		}
		return dependencyUnit;
	}

	/**
	 * Discover the hosts for the units in the list, add the host units to topology and then create
	 * hosting link. This method adds the first host unit that is available in the possible hosts
	 * list for a hostee unit.
	 * 
	 * @param hosteeUnitList
	 *           list of units that need to be hosted
	 * @return List new host units
	 */
	// MK 4/23/2007 no references to this method found
	public List discoverAndAddHostUnits(List hosteeUnitList) {
		List addedUnits = new ArrayList();
		for (Iterator iter = hosteeUnitList.iterator(); iter.hasNext();) {
			Unit hosteeUnit = (Unit) iter.next();
			Unit hostUnit = discoverAndAddHostUnit(hosteeUnit);
			if (hostUnit != null) {
				addedUnits.add(hostUnit);
			}
		}
		return addedUnits;
	}

	/**
	 * Discover the host for the unit, add the host unit to topology and then create hosting link.
	 * This method adds the first host unit that is available in the possible hosts list for a hostee
	 * unit.
	 * 
	 * @param hosteeUnit
	 *           a hostee unit
	 * @return Unit new host unit
	 */
	public Unit discoverAndAddHostUnit(Unit hosteeUnit) {
		Unit hostUnit = null;
		Topology topology = hosteeUnit.getTopology();
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(hosteeUnit,
				topology);
		if (TopologyDiscovererService.INSTANCE.canDiscover(filter)) {
			List discoveredUnitDescs = TopologyDiscovererService.INSTANCE.findAll(filter);
			if (discoveredUnitDescs != null && discoveredUnitDescs.size() > 0) {
				hostUnit = addAndHostDiscoveredUnitToTopology(hosteeUnit,
						(UnitDescriptor) discoveredUnitDescs.get(0));
			}
		}
		return hostUnit;
	}
}
