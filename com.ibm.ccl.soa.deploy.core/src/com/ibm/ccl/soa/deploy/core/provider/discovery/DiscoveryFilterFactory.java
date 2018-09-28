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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;

/**
 * Static helper methods for creating discovery filters.
 */
public class DiscoveryFilterFactory {

	/**
	 * Create an empty filter with default values for all fields.
	 * 
	 * @param topology
	 *           the current topology
	 * @return default filter; null if the topology is empty
	 */
	public static DiscoveryFilter createEmptyFilter(Topology topology) {
		// validate input
		if (null == topology) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = new DiscoveryFilter();
		filter.setAddTopologyToScope(Boolean.TRUE);
		filter.setCapabilities(new ArrayList());
		filter.setFollowDependency(Boolean.FALSE);
		filter.setDirectHosting(Boolean.FALSE);
		filter.setUseExistingMemberLink(Boolean.FALSE);
		filter.setMembership(Boolean.FALSE);
		filter.setHosts(new ArrayList());
		filter.setInitInstallState(new ArrayList());
		filter.setRequirements(new ArrayList());
		filter.setTopology(topology);
		filter.setUnit(null);
		filter.setUnitTypes(new Class[] {});

		return filter;
	}

	/**
	 * Create a filter to find the host of a unit.
	 * 
	 * @param hosted
	 *           the unit (hostee)
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if inputs are invalid
	 */
	public static DiscoveryFilter createFindHostFilter(Unit hosted, Topology topology,
			IProgressMonitor monitor) {
		// validate input
		if (null == hosted || null == topology) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = createEmptyFilter(topology);
		filter.setDirectHosting(Boolean.TRUE);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(hosted);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindHostFilter(Unit, Topology, IProgressMonitor)}
	 */
	public static DiscoveryFilter createFindHostFilter(Unit hosted, Topology topology) {
		return createFindHostFilter(hosted, topology, null);
	}

	/**
	 * Determine if a filter is for finding the host of a unit. It is expected that the directHosting
	 * field is set to true and that the requirements, capabilities, hosts and unit types fields are
	 * all empty.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the host of a unit.
	 */
	public static boolean isFindHostFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		Unit startingUnit = filter.getUnit();
		if (null == startingUnit) {
			return false;
		}

		Boolean directHosting = filter.isDirectHosting();
		boolean directH = directHosting != null;
		if (directH) {
			directH = directHosting.booleanValue();
		}

		if (!directH) {
			return false;
		}

		// check that all other filter elements are blank
		if (filter.getRequirements().size() != 0) {
			return false;
		}
		if (filter.getCapabilities().size() != 0) {
			return false;
		}
		if (filter.getHosts().size() != 0) {
			return false;
		}
		if (filter.getUnitTypes().length != 0) {
			return false;
		}

		return true;
	}

	/**
	 * Create a filter to find the units hosted on a unit.
	 * 
	 * @param host
	 *           the host
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the inputs are invalid
	 */
	public static DiscoveryFilter createFindHostedFilter(Unit host, Topology topology,
			IProgressMonitor monitor) {
		// validate input
		if (null == host || null == topology) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setHosts(Arrays.asList(new Unit[] { host }));
		filter.setDirectHosting(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindHostedFilter(Unit, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindHostedFilter(Unit host, Topology topology) {
		return createFindHostedFilter(host, topology, null);
	}

	/**
	 * Determine if a filter is for finding the hostees of a unit. It is expected that the
	 * directHosting field is set to true and the followDependency field is set to false.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindHostedFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		if (filter.getHosts().size() == 0) {
			return false;
		}

		Boolean directHosting = filter.isDirectHosting();
		boolean directH = directHosting != null;
		if (directH) {
			directH = directHosting.booleanValue();
		}

		Boolean followDependency = filter.isDirectDependency();
		boolean followD = followDependency != null;
		if (followD) {
			followD = followDependency.booleanValue();
		}

		if (!directH || followD) {
			return false;
		}

		if (filter.getCapabilities().size() != 0) {
//			|| (filter.getRequirements().size() != 0)) {
			return false;
		}

		List requirements = filter.getRequirements();
		if (requirements.size() != 0) {
			for (int i = 0; i < requirements.size(); i++) {
				Requirement req = (Requirement) requirements.get(i);
				//MK 11/08/2006 added the "!"
				if (!RequirementLinkTypes.HOSTING_LITERAL.equals(req.getLinkType())) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Create a filter to find possible hosts of a unit.
	 * 
	 * @param hosted
	 *           the unit (hostee)
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if inputs are invalid
	 */
	public static DiscoveryFilter createFindPossibleHostsFilter(Unit hosted, Topology topology,
			IProgressMonitor monitor) {
		// validate input
		if (null == hosted || null == topology) {
			return null;
		}
		if (hosted.getHostingOrAnyRequirements().size() == 0) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = createEmptyFilter(topology);
		filter.setDirectHosting(Boolean.TRUE);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setRequirements(hosted.getHostingOrAnyRequirements());
		filter.setUnit(hosted);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindPossibleHostsFilter(Unit, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindPossibleHostsFilter(Unit hosted, Topology topology) {
		return createFindPossibleHostsFilter(hosted, topology, null);
	}

	/**
	 * Determine if a filter is for finding possible hosts of a unit. It is expected that the
	 * directHosting field is set to true and that the requirements are the hosting requirements of
	 * the unit.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the host of a unit.
	 */
	public static boolean isFindPossibleHostsFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		Unit startingUnit = filter.getUnit();
		if (null == startingUnit) {
			return false;
		}
		List requirements = filter.getRequirements();
		if (null == requirements || 0 == requirements.size()) {
			return false;
		}
		List hosteeHostingRequirements = startingUnit.getHostingOrAnyRequirements();
		for (Iterator iter = requirements.iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if (!hosteeHostingRequirements.contains(req)) {
				return false;
			}
		}

		Boolean directHosting = filter.isDirectHosting();
		boolean directH = directHosting != null;
		if (directH) {
			directH = directHosting.booleanValue();
		}

		if (!directH) {
			return false;
		}

		// check that all other filter elements are blank
		if (filter.getCapabilities().size() != 0) {
			return false;
		}
		if (filter.getHosts().size() != 0) {
			return false;
		}

		return true;
	}

	/**
	 * Create a filter to find possible hostees of a unit.
	 * 
	 * @param host
	 *           the host unit
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if inputs are invalid
	 */
	public static DiscoveryFilter createFindPossibleHostedFilter(Unit host, Topology topology,
			IProgressMonitor monitor) {
		// validate input
		if (null == host || null == topology) {
			return null;
		}
		if (host.getHostingOrAnyCapabilities().size() == 0) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = createEmptyFilter(topology);
		filter.setDirectHosting(Boolean.TRUE);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setHosts(Arrays.asList(new Unit[] { host }));
		filter.setCapabilities(host.getHostingOrAnyCapabilities());
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindPossibleHostedFilter(Unit, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindPossibleHostedFilter(Unit host, Topology topology) {
		return createFindPossibleHostedFilter(host, topology, null);
	}

	/**
	 * Determine if a filter is for finding possible hosts of a unit. It is expected that the
	 * directHosting field is set to true and that the requirements are the hosting requirements of
	 * the unit.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the host of a unit.
	 */
	public static boolean isFindPossibleHostedFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		if (filter.getHosts().size() != 1) {
			return false;
		}

		Boolean directHosting = filter.isDirectHosting();
		boolean directH = directHosting != null;
		if (directH) {
			directH = directHosting.booleanValue();
		}

		Boolean followDependency = filter.isDirectDependency();
		boolean followD = followDependency != null;
		if (followD) {
			followD = followDependency.booleanValue();
		}

		if (!directH || followD) {
			return false;
		}

		// we need to have at least one capability to host something
		if (filter.getCapabilities().size() == 0) {
			return false;
		}

		// there can not be requirements to satisfy (the host would depend on the hostee!)
		if (filter.getRequirements().size() != 0) {
			return false;
		}

		if (filter.getUnit() != null && filter.getUnit() != (Unit) filter.getHosts().get(0)) {
			return false;
		}

		return true;
	}

	/**
	 * Create a filter to find the sources (units) of a given unit, capability pair.
	 * 
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the inputs are invalid
	 */
	public static DiscoveryFilter createFindSourcesFilter(Unit target, Capability targetCapability,
			Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == target || null == topology || null == targetCapability) {
			return null;
		}
		if (!(CapabilityLinkTypes.DEPENDENCY_LITERAL.equals(targetCapability.getLinkType()) || CapabilityLinkTypes.ANY_LITERAL
				.equals(targetCapability.getLinkType()))) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(target);
		filter.setCapabilities(Arrays.asList(new Capability[] { targetCapability }));
		filter.setFollowDependency(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindSourcesFilter(Unit, Capability, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindSourcesFilter(Unit target, Capability targetCapability,
			Topology topology) {
		return createFindSourcesFilter(target, targetCapability, topology, null);
	}

	/**
	 * Create a filter to find the target (unit) of a given unit, requirement pair.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the input is invalid
	 */
	public static DiscoveryFilter createFindTargetFilter(Unit source, Requirement sourceRequirement,
			Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == source || null == topology || null == sourceRequirement) {
			return null;
		}
		if (!RequirementLinkTypes.DEPENDENCY_LITERAL.equals(sourceRequirement.getLinkType())) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(source);
		filter.setRequirements(Arrays.asList(new Requirement[] { sourceRequirement }));
		filter.setFollowDependency(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindTargetFilter(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindTargetFilter(Unit source, Requirement sourceRequirement,
			Topology topology) {
		return createFindTargetFilter(source, sourceRequirement, topology, null);
	}

	/**
	 * Determine if a filter is for following a dependency link (either from source to target or from
	 * target to sources). It is expected that the followDependency field is set to true.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFollowDependencyFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		Boolean followDep = filter.isDirectDependency();
		boolean followDependency = followDep != null;
		if (followDependency) {
			followDependency = followDep.booleanValue();
		}
		return followDependency;
	}

	/**
	 * Create a filter to find the possible target (units) of a given unit, requirement pair.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the input is invalid
	 */
	public static DiscoveryFilter createFindPossibleTargetsFilter(Unit source,
			Requirement sourceRequirement, Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == source || null == topology || null == sourceRequirement) {
			return null;
		}
		if (!RequirementLinkTypes.DEPENDENCY_LITERAL.equals(sourceRequirement.getLinkType())) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(source);
		filter.setRequirements(Arrays.asList(new Requirement[] { sourceRequirement }));
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use
	 *             {@link #createFindPossibleTargetsFilter(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindPossibleTargetsFilter(Unit source,
			Requirement sourceRequirement, Topology topology) {
		return createFindPossibleTargetsFilter(source, sourceRequirement, topology, null);
	}

	/**
	 * Create a filter to find the possible target (units) of a given unit that match all the
	 * requirements.
	 * 
	 * @param source
	 *           the source unit
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the input is invalid
	 */
	public static DiscoveryFilter createFindPossibleTargetsFilter(Unit source, Topology topology,
			IProgressMonitor monitor) {
		// validate input
		if (null == source || null == topology) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(source);
		filter.setRequirements(source.getDependencyOrAnyRequirements());
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindPossibleTargetsFilter(Unit, Topology, IProgressMonitor)}
	 */
	public static DiscoveryFilter createFindPossibleTargetsFilter(Unit source, Topology topology) {
		return createFindPossibleTargetsFilter(source, topology, null);
	}

	/**
	 * Determine if a filter is for finding possible targets of a dependency requirement.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindPossibleTargetsFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}

		// not a followDependency
		Boolean followDep = filter.isDirectDependency();
		boolean followDependency = followDep != null;
		if (followDependency) {
			followDependency = followDep.booleanValue();
		}
		if (followDependency) {
			return false;
		}

		// not a follow member link; this is frivolous; we ignore it anyway
		Boolean existingMemberLink = filter.isExistingMemberLink();
		boolean followMemberLink = existingMemberLink != null;
		if (followMemberLink) {
			followMemberLink = existingMemberLink.booleanValue();
		}
		if (followMemberLink) {
			return false;
		}

		Boolean membership = filter.isMembership();
		boolean isMemberSearch = membership != null;
		if (isMemberSearch) {
			isMemberSearch = membership.booleanValue();
		}
		if (isMemberSearch) {
			return false;
		}

		if (filter.getUnit() == null) {
			return false;
		}

		// there is one requirement
		List requirements = filter.getRequirements();
		if (requirements == null) {
			return false;
		}
		if (requirements.size() != 1) {
			return false;
		}

		// requirement is a dependency requirement
		if (!filter.getUnit().getDependencyOrAnyRequirements().contains(requirements.get(0))) {
			return false;
		}

		return true;
	}

	/**
	 * Create a filter to find the possible source (units) of a given unit, capability pair.
	 * 
	 * @param source
	 *           the source unit
	 * @param targetCapability
	 *           the source capability
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the input is invalid
	 */
	public static DiscoveryFilter createFindPossibleSourcesFilter(Unit source,
			Capability targetCapability, Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == source || null == topology || null == targetCapability) {
			return null;
		}
		if (!CapabilityLinkTypes.DEPENDENCY_LITERAL.equals(targetCapability.getLinkType())) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(source);
		filter.setCapabilities(Arrays.asList(new Capability[] { targetCapability }));
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use
	 *             {@link #createFindPossibleSourcesFilter(Unit, Capability, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindPossibleSourcesFilter(Unit source,
			Capability targetCapability, Topology topology) {
		return createFindPossibleSourcesFilter(source, targetCapability, topology, null);
	}

	/**
	 * Determine if a filter is for finding possible sources of a dependency requirement.
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindPossibleSourcesFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}

		// not a followDependency
		Boolean followDep = filter.isDirectDependency();
		boolean followDependency = followDep != null;
		if (followDependency) {
			followDependency = followDep.booleanValue();
		}
		if (followDependency) {
			return false;
		}

		// not a follow member link; this is frivolous; we ignore it anyway
		Boolean existingMemberLink = filter.isExistingMemberLink();
		boolean followMemberLink = existingMemberLink != null;
		if (followMemberLink) {
			followMemberLink = existingMemberLink.booleanValue();
		}
		if (followMemberLink) {
			return false;
		}

		Boolean membership = filter.isMembership();
		boolean isMemberSearch = membership != null;
		if (isMemberSearch) {
			isMemberSearch = membership.booleanValue();
		}
		if (isMemberSearch) {
			return false;
		}

		if (filter.getUnit() == null) {
			return false;
		}

		// there is one capability
		List capabilities = filter.getCapabilities();
		if (capabilities == null) {
			return false;
		}
		if (capabilities.size() != 1) {
			return false;
		}

		// capability is a dependency (or any) requirement
		if (!filter.getUnit().getDependencyOrAnyCapabilities().contains(capabilities.get(0))) {
			return false;
		}

		return true;
	}

	/**
	 * Create a filter to find the members (unit) of a given unit, requirement pair.
	 * 
	 * @param unit
	 *           the source unit
	 * @param outMemberReq
	 *           the member requirement defining the group to be searched
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if input is invalid
	 */
	public static DiscoveryFilter createFindMembersFilter(Unit unit, Requirement outMemberReq,
			Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == unit) {
			return null;
		}
		if (null == topology) {
			return null;
		}
		if (outMemberReq != null) {
			// if we have non-null Requirement, is should be a Member Requirement,
			// child constraints should indicate constraints on Members (and not on Groups) 
			// and unrelated child constraints are allowed
			if (!RequirementLinkTypes.MEMBER_LITERAL.equals(outMemberReq.getLinkType())) {
				return null;
			}
			for (Iterator innerIter = outMemberReq.getConstraints().iterator(); innerIter.hasNext();) {
				Constraint cnstr = (Constraint) innerIter.next();
				if (cnstr instanceof MemberCardinalityConstraint) {
					continue;
				}
				if (cnstr instanceof GroupCardinalityConstraint) {
					return null;
				}
				if (cnstr instanceof RequirementExpression) {
					RequirementExpression re = (RequirementExpression) cnstr;
					if (!OutCardinality.INTERPRETER_ID.equals(re.getInterpreter())) {
						return null;
					}
				}
			}
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(unit);
		if (outMemberReq != null) {
			filter.setRequirements(Arrays.asList(new Requirement[] { outMemberReq }));
		} else {
			// add the most generic Requirement for members to the Requirement list on the filter
			Requirement req = CoreFactory.eINSTANCE.createRequirement();
			req.setName("req"); //$NON-NLS-1$
			req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			MemberCardinalityConstraint mcc = ConstraintFactory.eINSTANCE
					.createMemberCardinalityConstraint();
			req.getConstraints().add(mcc);
			filter.setRequirements(Arrays.asList(new Requirement[] { req }));
		}
		filter.setUseExistingMemberLink(Boolean.TRUE);
		filter.setMembership(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use
	 *             {@link #createFindMembersFilter(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindMembersFilter(Unit unit, Requirement outMemberReq,
			Topology topology) {
		return createFindMembersFilter(unit, outMemberReq, topology, null);
	}

	/**
	 * Determine if a filter is for following existing member links (from a group to member
	 * elements).It is expected that:
	 * <ul>
	 * <li>useExistingMember == true</li>
	 * <li>unit is not null</li>
	 * <li>requirements is non-empty</li>
	 * <li>the interpreters on the requirements is OutCardinality</li>
	 * </ul>
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindMembersFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		Boolean existingMember = filter.isExistingMemberLink();
		boolean useExistingMember = existingMember != null;
		if (useExistingMember) {
			useExistingMember = existingMember.booleanValue();
		}
		if (useExistingMember && null != filter.getUnit() && filter.getRequirements().size() != 0
				&& areGroupRequirements(filter.getRequirements())) {
			return true;
		}
		return false;
	}

	/**
	 * Create a filter to find the group of a given unit, capability pair.
	 * 
	 * @param unit
	 *           the member unit
	 * @param inMemberReq
	 *           the member requirement defining the "in" membership requirement may be null
	 *           (indicating that it can be a member of any group)
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the input is invalid
	 */
	public static DiscoveryFilter createFindGroupsFilter(Unit unit, Requirement inMemberReq,
			Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == unit) {
			return null;
		}
		if (null == topology) {
			return null;
		}
		if (inMemberReq != null) {
			// if we have non-null Requirement, is should be a Member Requirement,
			// it should have at least one child constraint, and child constraints
			// should indicate constraints on Groups (and not on Members) and unrelated child
			// constraints are allowed
			if (!RequirementLinkTypes.MEMBER_LITERAL.equals(inMemberReq.getLinkType())) {
				return null;
			}
			if (inMemberReq.getConstraints().size() == 0) {
				return null;
			}
			for (Iterator innerIter = inMemberReq.getConstraints().iterator(); innerIter.hasNext();) {
				Constraint cnstr = (Constraint) innerIter.next();
				if (cnstr instanceof GroupCardinalityConstraint) {
					continue;
				}
				if (cnstr instanceof MemberCardinalityConstraint) {
					return null;
				}
				if (cnstr instanceof RequirementExpression) {
					RequirementExpression re = (RequirementExpression) cnstr;
					if (!InCardinality.INTERPRETER_ID.equals(re.getInterpreter())) {
						return null;
					}
				}
			}
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(unit);
		if (inMemberReq != null) {
			filter.setRequirements(Arrays.asList(new Requirement[] { inMemberReq }));
		} else {
			filter.setRequirements(new ArrayList());
		}
		filter.setUseExistingMemberLink(Boolean.TRUE);
		filter.setMembership(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use {@link #createFindGroupsFilter(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindGroupsFilter(Unit unit, Requirement inMemberReq,
			Topology topology) {
		return createFindGroupsFilter(unit, inMemberReq, topology, null);
	}

	/**
	 * Determine if a filter is for following existing member links (from a member to group
	 * elements).It is expected that:
	 * <ul>
	 * <li>useExistingMember == true</li>
	 * <li>unit is not null</li>
	 * <li>requirements is non-empty</li>
	 * <li>the interpreter on the requirements is InCardinality</li>
	 * </ul>
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindGroupsFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		Boolean existingMember = filter.isExistingMemberLink();
		boolean useExistingMember = existingMember != null;
		if (useExistingMember) {
			useExistingMember = existingMember.booleanValue();
		}
		if (useExistingMember && null != filter.getUnit()
		// && (filter.getRequirements().size() != 0)
				&& areMemberRequirements(filter.getRequirements())) {
			return true;
		}
		return false;
	}

	/**
	 * Create a filter to find possible members of a given unit, requirement pair.
	 * 
	 * @param unit
	 *           the group unit
	 * @param outMemberReq
	 *           the member requirement defining the possible group members to be found
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter; null if the input is invalid
	 */
	public static DiscoveryFilter createFindPossibleMembersFilter(Unit unit,
			Requirement outMemberReq, Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == unit) {
			return null;
		}
		if (null == topology) {
			return null;
		}
		if (outMemberReq == null) {
			return null;
		}
		if (!RequirementLinkTypes.MEMBER_LITERAL.equals(outMemberReq.getLinkType())) {
			return null;
		}
		if (!isGroupRequirement(outMemberReq)) {
			return null;
		}

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(unit);
		filter.setRequirements(Arrays.asList(new Requirement[] { outMemberReq }));
		filter.setMembership(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use
	 *             {@link #createFindPossibleMembersFilter(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindPossibleMembersFilter(Unit unit,
			Requirement outMemberReq, Topology topology) {
		return createFindPossibleMembersFilter(unit, outMemberReq, topology, null);
	}

	/**
	 * Determine if a filter is for finding possible group members. It is expected that:
	 * <ul>
	 * <li>useExistingMember == false</li>
	 * <li>unit is not null</li>
	 * <li>requirements is non-empty</li>
	 * <li>the interpreter on the requirements is OutCardinality</li>
	 * </ul>
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindPossibleMembersFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		if (null == filter.getUnit()) {
			return false;
		}
		Boolean existingMember = filter.isExistingMemberLink();
		boolean useExistingMember = existingMember != null;
		if (useExistingMember) {
			useExistingMember = existingMember.booleanValue();
		}
		Boolean membership = filter.isMembership();
		boolean isMemberSearch = membership != null;
		if (isMemberSearch) {
			isMemberSearch = membership.booleanValue();
		}

		if (isMemberSearch && !useExistingMember && filter.getRequirements().size() != 0
				&& areGroupRequirements(filter.getRequirements())) {
			return true;
		}
		return false;
	}

	/**
	 * Create a filter to find possible groups a given unit (member), capability pair.
	 * 
	 * @param unit
	 *           the member unit
	 * @param inMemberReq
	 *           the member requirement defining the possible group membership
	 * @param topology
	 *           the current topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the filter
	 */
	public static DiscoveryFilter createFindPossibleGroupsFilter(Unit unit, Requirement inMemberReq,
			Topology topology, IProgressMonitor monitor) {
		// validate input
		if (null == unit) {
			return null;
		}
		if (null == topology) {
			return null;
		}
		if (inMemberReq != null) {
			if (!RequirementLinkTypes.MEMBER_LITERAL.equals(inMemberReq.getLinkType())) {
				return null;
			}
			if (!isMemberRequirement(inMemberReq)) {
				return null;
			}
		}
//		if ((inMemberReq != null) 
//				&& !RequirementLinkTypes.MEMBER_LITERAL.equals(inMemberReq
//						.getLinkType()))
//			return null;

		// create the filter
		DiscoveryFilter filter = DiscoveryFilterFactory.createEmptyFilter(topology);
		filter.setInitInstallState(InstallState.VALUES);
		filter.setUnit(unit);
		if (inMemberReq != null) {
			filter.setRequirements(Arrays.asList(new Requirement[] { inMemberReq }));
		} else {
			filter.setRequirements(new ArrayList());
		}
		filter.setMembership(Boolean.TRUE);
		filter.setProgressMonitor(monitor);

		return filter;
	}

	/**
	 * @deprecated use
	 *             {@link #createFindPossibleGroupsFilter(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public static DiscoveryFilter createFindPossibleGroupsFilter(Unit unit, Requirement inMemberReq,
			Topology topology) {
		return createFindPossibleGroupsFilter(unit, inMemberReq, topology, null);
	}

	/**
	 * Determine if a filter is for finding possible groups to which a unit may be added).It is
	 * expected that:
	 * <ul>
	 * <li>useExistingMember == false</li>
	 * <li>unit is not null</li>
	 * <li>requirements is non-empty</li>
	 * <li>the interpreter on the requirements is InCardinality</li>
	 * </ul>
	 * 
	 * @param filter
	 *           the filter
	 * @return true if the filter is for finding the hostees of a unit.
	 */
	public static boolean isFindPossibleGroupsFilter(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}
		if (null == filter.getUnit()) {
			return false;
		}

		Boolean existingMember = filter.isExistingMemberLink();
		boolean useExistingMember = existingMember != null;
		if (useExistingMember) {
			useExistingMember = existingMember.booleanValue();
		}
		Boolean membership = filter.isMembership();
		boolean isMemberSearch = membership != null;
		if (isMemberSearch) {
			isMemberSearch = membership.booleanValue();
		}

		if (isMemberSearch && !useExistingMember && areMemberRequirements(filter.getRequirements())) {
			return true;
		}
		return false;
	}

	/**
	 * @param requirements
	 *           Requirement list
	 * @return true if at least one Requirement is for a Member (that is, on a (potential) Group
	 *         Unit, hence the name of the method).
	 */
	private static boolean areGroupRequirements(List requirements) {
		for (Iterator iter = requirements.iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if (isGroupRequirement(req)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param req
	 *           Requirement
	 * @return true if the Requirement is for a Member (that is, on a (potential) Group Unit, hence
	 *         the name of the method).
	 */
	private static boolean isGroupRequirement(Requirement req) {
		if (null == req) {
			// error, ignore this requirement
			return false;
		}
		if (!RequirementLinkTypes.MEMBER_LITERAL.equals(req.getLinkType())) {
			return false;
		}
		List constraintList = req.getConstraints();
		if (constraintList.size() == 0) {
			return true;
		}
		for (Iterator innerIter = constraintList.iterator(); innerIter.hasNext();) {
			Constraint cnstr = (Constraint) innerIter.next();
			if (cnstr instanceof MemberCardinalityConstraint) {
				return true;
			}
			if (cnstr instanceof RequirementExpression) {
				RequirementExpression re = (RequirementExpression) cnstr;
				if (re.getInterpreter().equals(OutCardinality.INTERPRETER_ID)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @param requirements
	 *           Requirement list
	 * @return true if at least one Requirement is for a Group (that is, on a (potential) Member
	 *         Unit, hence the name of the method).
	 */
	private static boolean areMemberRequirements(List requirements) {
		// If a Unit has no Requirement with linkType=member it is assumed that
		// it has InCardinality 0..n for all groups. In other words any Unit
		// that claims it can group that Unit can indeed do it legally.
		if (requirements.size() == 0) {
			return true;
		}

		for (Iterator iter = requirements.iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if (isMemberRequirement(req)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param req
	 *           Requirement to test
	 * @return true if the Requirement is for a Group (that is, on a (potential) Member Unit, hence
	 *         the name of the method).
	 */
	private static boolean isMemberRequirement(Requirement req) {
		if (null == req) {
			// error; ignore this requirement
			return false;
		}
		if (!RequirementLinkTypes.MEMBER_LITERAL.equals(req.getLinkType())) {
			return false;
		}
		List cnstrList = req.getConstraints();
		if (cnstrList.size() == 0) {
			return false;
		}
		for (Iterator innerIter = cnstrList.iterator(); innerIter.hasNext();) {
			Constraint cnstr = (Constraint) innerIter.next();

			if (cnstr instanceof GroupCardinalityConstraint) {
				return true;
			}
			if (cnstr instanceof RequirementExpression) {
				RequirementExpression re = (RequirementExpression) cnstr;
				if (InCardinality.INTERPRETER_ID.equals(re.getInterpreter())) {
					return true;
				}
			}
		}
		return false;
	}
}
