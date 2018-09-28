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
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyDiscovererDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;

/**
 * Service that manages queries to all of the TopologyDiscoverers and ensures that results are
 * unique.
 */
public class TopologyDiscovererService {

	/** singleton instance of this service */
	public static final TopologyDiscovererService INSTANCE = new TopologyDiscovererService();

	protected final TopologyDiscoverer[] discoverers;

	protected final TopologyDiscovererDescriptor[] discDesc;

	/** Discovery cache mapping filters to discovery results. */
	private final Map<DiscoveryFilter, List<UnitDescriptor>> defaultDiscoveryCache = Collections
			.synchronizedMap(new HashMap<DiscoveryFilter, List<UnitDescriptor>>());

	/** Discovery cache lock count (access synchronized on {@link #defaultDiscoveryCache}). */
	private int defaultDiscoveryCacheLockCount = 0;

	/**
	 * Constructor for service.
	 */
	private TopologyDiscovererService() {
		Topology t = null;
		discDesc = TopologyManager.INSTANCE.findAvailableDiscoverers(t);
		discoverers = new TopologyDiscoverer[discDesc.length + 1];
		discoverers[0] = new CurrentTopologyDiscoverer();
		for (int i = 0; i < discDesc.length; i++) {
			discoverers[i + 1] = discDesc[i].createTopologyDiscoverer();
		}
	}

	/**
	 * Returns a description of the topology discoverer.
	 * 
	 * @param index
	 *           the index of the discoverer in the <code>discoverers</code> array.
	 * @return the description of the discoverer, or null if not found.
	 */
	protected final String getDiscovererDescription(int index) {
		if (index < 0) {
			return null;
		}
		if (index == 0) {
			return CurrentTopologyDiscoverer.class.getName();
		}
		index--;
		if (index >= discDesc.length) {
			return null;
		}

		if (discDesc[index] == null) {
			return null;
		}

		String discovererDescription = discDesc[index].getDescription();
		if (discovererDescription != null) {
			return discovererDescription;
		}
		return discDesc[index].getName();
	}

	/**
	 * Retrieve array of all of the discoverers.
	 * 
	 * @return array of discoverers
	 */
	public final TopologyDiscoverer[] getDiscoverers() {
		return discoverers;
	}

	/**
	 * Determines whether or not there is at least one discoverer that can handle the query defined
	 * by the filter.
	 * 
	 * @param filter
	 *           the input filter instance that has the filter crtiteria.
	 * @return true, if the one discoverer can fulfill the criteria.
	 * 
	 */
	public boolean canDiscover(DiscoveryFilter filter) {
		if (null == filter) {
			return false;
		}

		for (int i = 0; i < discoverers.length; i++) {
			TopologyDiscoverer discoverer = discoverers[i];
			if (filter.getProgressMonitor().isCanceled()) {
				return false;
			}
			if (discoverer.canDiscover(filter)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns a list of the unit decriptors based on the discovery criteria from all of the known
	 * discoverers.
	 * 
	 * @param filter
	 *           the input filter instance that has the filter crtiteria.
	 * @return the list of UnitDescriptor based on the matching criteria.
	 */
	public List<UnitDescriptor> findAll(DiscoveryFilter filter) {
		if (null == filter) {
			return new ArrayList<UnitDescriptor>();
		}

		synchronized (defaultDiscoveryCache) {
			if (isDefaultDiscoveryCachingEnabled() && defaultDiscoveryCache.containsKey(filter)) {
				List<UnitDescriptor> results = defaultDiscoveryCache.get(filter);
//				System.out.println("Discovery returning cached result (" + filterTypeString(filter) + ")"); //$NON-NLS-1$ //$NON-NLS-2$
				return results;
			}
		}

		List<UnitDescriptor>[] results = new List[discoverers.length];

		// get all results
		for (int i = 0; i < discoverers.length; i++) {
			TopologyDiscoverer discoverer = discoverers[i];
			if (filter.getProgressMonitor().isCanceled()) {
				return Collections.emptyList();
			}
//			System.out.println("Discovery starting using " + discoverers[i].getClass() +  " (" + filterTypeString(filter) + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			try {
				results[i] = discoverer.findAll(filter);
			} catch (ConcurrentModificationException e) {
				// ignore concurrent change to topology
			} catch (RuntimeException e) {
				if (filter.getProgressMonitor() == null || !filter.getProgressMonitor().isCanceled()) {
					String message = DeployNLS.bind(DeployCoreMessages.Topology_discoverer_0_error_1,
							new Object[] { getDiscovererDescription(i), e });
					DeployCorePlugin.log(IStatus.ERROR, 0, message, e);
				}
			}
			if (results[i] != null && results[i].size() > 0) {
				// Note - this shortcut presumes a single host
				if (DiscoveryFilterFactory.isFindHostFilter(filter)) {
					break;
				}
				// Note - this shortcut presumes single dependency link target
				// per requirement
				if (DiscoveryFilterFactory.isFollowDependencyFilter(filter)) {
					break;
				}
			}
		}
		List<UnitDescriptor> filteredResults = filterOutDuplicates(results);
		synchronized (defaultDiscoveryCache) {
			if (isDefaultDiscoveryCachingEnabled() && !filter.getProgressMonitor().isCanceled()) {
				defaultDiscoveryCache.put(filter, filteredResults);
			}
		}
		return filteredResults;
	}

	/**
	 * Returns a list of the unit decriptors based on the discovery criteria from all of the known
	 * discoverers. The reusults must match all filters provided.
	 * 
	 * @param filters
	 *           the input filters that has the filter crtiteria.
	 * @return the list of UnitDescriptor based on the matching criteria for all filters.
	 */
	public List<UnitDescriptor> findAll(DiscoveryFilter[] filters) {
		List<UnitDescriptor> result = new ArrayList<UnitDescriptor>();
		for (int i = 0; i < filters.length; i++) {
			List<UnitDescriptor> newResults = findAll(filters[i]);
			if (i == 0) {
				result = newResults;
			} else {
				result = filterOutDuplicates(result, newResults);
			}
		}
		return result;
	}

	/**
	 * @param results
	 *           array of List of {@link UnitDescriptor}
	 * @return List of {@link UnitDescriptor}
	 */
	public static List<UnitDescriptor> filterOutDuplicates(List<UnitDescriptor>[] results) {
		// prepare list of the final, collaged results
		List<UnitDescriptor> finalResults = new ArrayList<UnitDescriptor>();

		// filter results as copy to make sure they are unique
		for (int i = 0; i < results.length; i++) {
			List<UnitDescriptor> resultList = results[i];
			if (resultList == null) {
				continue;
			}
			for (int j = 0; j < resultList.size(); j++) {
				UnitDescriptor ud = resultList.get(j);
				if (null == ud) {
					continue;
				}
				// is it the same as any other unit descriptor?
				boolean newUD = true;
				for (int k = 0; k < finalResults.size(); k++) {
					// FIXME: this is the wrong way to compare units since the unit has a different topology
					// need to look for unit in the new topology but this doesn't work either since it might not 
					// should only need to compare ud that are on the current topology
					if (ud.getUnitValue().equals(finalResults.get(k).getUnitValue())) {
						// if (ud.equals(finalResults.get(k))) {
						newUD = false;
						break;
					}
				}
				if (newUD) {
					finalResults.add(ud);
				}
			}
		}

		return finalResults;
	}

	protected List<UnitDescriptor> filterOutDuplicates(List<UnitDescriptor> list1,
			List<UnitDescriptor> list2) {
		List<UnitDescriptor> result = new ArrayList<UnitDescriptor>();
		for (Iterator<UnitDescriptor> l1 = list1.iterator(); l1.hasNext();) {
			UnitDescriptor u1 = l1.next();
			for (Iterator<UnitDescriptor> l2 = list2.iterator(); l2.hasNext();) {
				UnitDescriptor u2 = l2.next();
				if (u1 == u2) {
					result.add(u1);
				}
			}
		}
		return result;
	}

	//
	// Some methods to help navigate in a model.
	//

	/**
	 * Discovers all hosts of the unit.
	 * 
	 * @param hosted
	 *           the hosted unit.
	 * @param topology
	 *           the topology which should be queried for hosts (in addition to the topology
	 *           discoverers).
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return List<UnitDescriptor> a list of unit descriptors.
	 */
	public List<UnitDescriptor> findAllHosts(Unit hosted, Topology topology, IProgressMonitor monitor) {
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostFilter(hosted, topology,
				monitor);
		return findAll(filter);
	}

	/**
	 * @deprecated use {@link #findAllHosts(Unit, Topology, IProgressMonitor)}
	 */
	public List<UnitDescriptor> findAllHosts(Unit hosted, Topology topology) {
		return findAllHosts(hosted, topology, null);
	}

	/**
	 * Return the unit descriptor of the unit that hosts another.
	 * 
	 * @param hosted
	 *           the hosted unit
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the host descriptor
	 */
	public UnitDescriptor findHostUD(Unit hosted, Topology topology, IProgressMonitor monitor) {
		List<UnitDescriptor> hosts = findAllHosts(hosted, topology, monitor);
		if (hosts.size() > 1) {
			// FIXME
			// throw new RuntimeException ();  //TODO add NLS message
			return null;
		} else if (hosts.size() == 1) {
			if (hosts.get(0) == null) {
				return null;
			}
			return hosts.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @deprecated use {@link #findHostUD(Unit, Topology, IProgressMonitor)}
	 */
	public UnitDescriptor findHostUD(Unit hosted, Topology topology) {
		return findHostUD(hosted, topology, null);
	}

	//
	// Some methods to help navigate in a model.
	//

	/**
	 * Return the unit that hosts another.
	 * 
	 * @param hosted
	 *           the hosted unit
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the host
	 */
	public Unit findHost(Unit hosted, Topology topology, IProgressMonitor monitor) {
		UnitDescriptor hostUD = findHostUD(hosted, topology, monitor);
		if (hostUD != null) {
			return hostUD.getUnitValue();
		}
		return null;
	}

	/**
	 * @deprecated use {@link #findHost(Unit, Topology, IProgressMonitor)}.
	 */
	public Unit findHost(Unit hosted, Topology topology) {
		return findHost(hosted, topology, null);
	}

	/**
	 * Retrieve a host of a particular type from the hosting stack of a unit.
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param type
	 *           the type of the hoster in the hosting stack
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the hoster or null if none of the specified type can be found
	 */
	public Unit findHost(Unit unit, EClass type, Topology topology, IProgressMonitor monitor) {
		Unit u = unit;
		while (null != u && !type.isSuperTypeOf(u.getEObject().eClass())) {
			u = findHost(u, topology, monitor);
			if (u == null) {
				break;
			}
		}
		return u;
	}

	/**
	 * @deprecated use {@link #findHost(Unit, EClass, Topology, IProgressMonitor)}.
	 */
	public Unit findHost(Unit unit, EClass type, Topology topology) {
		return findHost(unit, type, topology, null);
	}

	/**
	 * Retrieve a host of a particular type from the hosting stack of a unit.
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param type
	 *           the type of the hoster in the hosting stack
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the unit descriptor of the hoster or null if none of the specified type can be found
	 */
	public UnitDescriptor findHostUD(Unit unit, EClass type, Topology topology,
			IProgressMonitor monitor) {
		Unit u = unit;
		UnitDescriptor ud = null;
		while (null != u && !type.isSuperTypeOf(u.getEObject().eClass())) {
			ud = findHostUD(u, topology, monitor);
			if (ud == null) {
				break;
			}
			u = ud.getUnitValue();
			if (u == null) {
				break;
			}
		}
		return ud;
	}

	/**
	 * @deprecated use {@link #findHostUD(Unit, EClass, Topology, IProgressMonitor)}
	 */
	public UnitDescriptor findHostUD(Unit unit, EClass type, Topology topology) {
		return findHostUD(unit, type, topology, null);
	}

	/**
	 * List(UnitDescriptor) of units hosted by a given unit.
	 * 
	 * @param host
	 *           the host
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return list of descriptors of hosted units
	 */
	public List<UnitDescriptor> findHosted(Unit host, Topology topology, IProgressMonitor monitor) {
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(host, topology,
				monitor);
		return findAll(filter);
	}

	/**
	 * @deprecated use {@link #findHosted(Unit, Topology, IProgressMonitor)}.
	 */
	public List<UnitDescriptor> findHosted(Unit host, Topology topology) {
		return findHosted(host, topology, null);
	}

	/**
	 * Retrieve list of descriptors of units at the source end of a dependency link.
	 * 
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return List(UnitDescriptor) of source units
	 */
	public List<UnitDescriptor> findSources(Unit target, Capability targetCapability,
			Topology topology, IProgressMonitor monitor) {
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindSourcesFilter(target,
				targetCapability, topology, monitor);

		return findAll(filter);
	}

	/**
	 * @deprecated use {@link #findSources(Unit, Capability, Topology, IProgressMonitor)}.
	 */
	public List<UnitDescriptor> findSources(Unit target, Capability targetCapability,
			Topology topology) {
		return findSources(target, targetCapability, topology, null);
	}

	/**
	 * Retrieve the unit descriptor of a unit at the target end of a dependency link.
	 * 
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return descriptor of target unit
	 */
	public UnitDescriptor findTarget(Unit source, Requirement sourceRequirement, Topology topology,
			IProgressMonitor monitor) {
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindTargetFilter(source,
				sourceRequirement, topology, monitor);

		List targets = findAll(filter);
		if (targets.size() > 1) {
			// throw new RuntimeException ();  //TODO add NLS message
			return null;
		} else if (targets.size() == 1) {
			return (UnitDescriptor) targets.get(0);
		} else {
			return null;
		}
	}

	/**
	 * @deprecated use {@link #findTarget(Unit, Requirement, Topology)}.
	 */
	public UnitDescriptor findTarget(Unit source, Requirement sourceRequirement, Topology topology) {
		return findTarget(source, sourceRequirement, topology, null);
	}

	/**
	 * Find a target unit given a source and the requirement type (but not the requirement). Also
	 * validates that the return type is of an expected type.
	 * 
	 * @param sourceUnit
	 *           the source unit
	 * @param reqType
	 *           the source requirement type
	 * @param targetType
	 *           the target unit type
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return target unit
	 */
	public Unit findTarget(Unit sourceUnit, EClass reqType, EClass targetType, Topology topology,
			IProgressMonitor monitor) {
		Unit targetUnit = findTarget(sourceUnit, reqType, topology, monitor);
		if (targetType == null) {
			return targetUnit;
		}
		return getVerifiedUnitType(targetUnit, targetType);
	}

	/**
	 * @deprecated use {@link #findTarget(Unit, EClass, EClass, Topology, IProgressMonitor)}
	 */
	public Unit findTarget(Unit sourceUnit, EClass reqType, EClass targetType, Topology topology) {
		return findTarget(sourceUnit, reqType, targetType, topology, null);
	}

	/**
	 * Find a target unit given a source and the requirement type.
	 * 
	 * @param sourceUnit
	 *           the source unit
	 * @param reqType
	 *           the source requirement type
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return target unit
	 */
	public Unit findTarget(Unit sourceUnit, EClass reqType, Topology topology,
			IProgressMonitor monitor) {
		if (null == sourceUnit) {
			return null;
		}
		if (null == reqType) {
			return null;
		}
		Requirement sourceRequirement = ValidatorUtils.getFirstRequirement(sourceUnit, reqType);
		UnitDescriptor targetDescriptor = findTarget(sourceUnit, sourceRequirement, topology, monitor);
		if (targetDescriptor == null) {
			return null;
		}
		Unit targetUnit = targetDescriptor.getUnitValue();
		return targetUnit;
	}

	/**
	 * @deprecated use {@link #findTarget(Unit, EClass, Topology, IProgressMonitor)}.
	 */
	public Unit findTarget(Unit sourceUnit, EClass reqType, Topology topology) {
		return findTarget(sourceUnit, reqType, topology, null);
	}

	/**
	 * Retrieve list of members of a group Unit.
	 * 
	 * @param group
	 *           the unit group
	 * @param outReq
	 *           membership requirement
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return List(UnitDescriptor) of members
	 */
	public List<UnitDescriptor> getMembers(Unit group, Requirement outReq, Topology topology,
			IProgressMonitor monitor) {
		if (null == group) {
			return null;
		}
		//if (null == outReq) return null;
		if (null == topology) {
			return null;
		}

		DiscoveryFilter filter = DiscoveryFilterFactory.createFindMembersFilter(group, outReq,
				topology, monitor);

		return findAll(filter);
	}

	/**
	 * @deprecated use {@link #getMembers(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public List<UnitDescriptor> getMembers(Unit group, Requirement outReq, Topology topology) {
		return getMembers(group, outReq, topology, null);
	}

	/**
	 * Retrieve list (of 1) of groups a unit belongs to
	 * 
	 * @param member
	 *           the unit member
	 * @param inReq
	 *           membership conditions
	 * @param topology
	 *           the search topology
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return List(UnitDescriptor) of groups
	 */
	public List<UnitDescriptor> getGroups(Unit member, Requirement inReq, Topology topology,
			IProgressMonitor monitor) {
		if (null == member) {
			return new ArrayList<UnitDescriptor>(0);
		}
		// if (null == inReq) return null;
		if (null == topology) {
			return new ArrayList<UnitDescriptor>(0);
		}

		DiscoveryFilter filter = DiscoveryFilterFactory.createFindGroupsFilter(member, inReq,
				topology, monitor);

		return findAll(filter);
	}

	/**
	 * @deprecated use {@link #getGroups(Unit, Requirement, Topology, IProgressMonitor)}.
	 */
	public List<UnitDescriptor> getGroups(Unit member, Requirement inReq, Topology topology) {
		return getGroups(member, inReq, topology, null);
	}

	/**
	 * Verify the type of a unit matches an expected type. If it does, return the type; if not return
	 * null.
	 * 
	 * @param unit
	 *           the unit to check
	 * @param expectedType
	 *           the expected type of the unit
	 * @return the unit if it matches the expected type; null otherwise.
	 */
	private static Unit getVerifiedUnitType(Unit unit, EClass expectedType) {
		if (null == expectedType) {
			return unit;
		}

		if (null == unit) {
			return null;
		}
		if (expectedType.isSuperTypeOf(unit.getEObject().eClass())) {
			return unit;
		}
		return null;
	}

	/**
	 * Clear contents of default discovery cache
	 */
	public final void flushDefaultDiscoveryCache() {
		defaultDiscoveryCache.clear();
	}

	/**
	 * @return true if default discovery caching is enabled, false otherwise.
	 */
	public final boolean isDefaultDiscoveryCachingEnabled() {
		// MK 05-28-2008: disabled caching.  cf. defect 6328.  
		// Caching should be done by individual discoverers 
		return false;
		// return defaultDiscoveryCacheLockCount > 0;
	}

	/**
	 * Starts discovery result caching if not already enabled.
	 * <p>
	 * Caching must be stopped (unlocked) using {@link #leaveDefaultDiscoveryCache()}
	 * <p>
	 * <em>Thread-safe method</a>.
	 */
	public void enterDefaultDiscoveryCache() {
		synchronized (defaultDiscoveryCache) {
			defaultDiscoveryCacheLockCount++;
		}
	}

	/**
	 * Stops discovery result caching once all "enter"s have been matched.
	 * <p>
	 * When the last "enter" is matched, the cache is flushed.
	 * <p>
	 * <em>Thread-safe method</a>.
	 * 
	 * @see #enterDefaultDiscoveryCache()
	 */
	public void leaveDefaultDiscoveryCache() {
		synchronized (defaultDiscoveryCache) {
			if (defaultDiscoveryCacheLockCount == 0) {
				// Error (unmatched unlock)
			} else {
				defaultDiscoveryCacheLockCount--;
				if (defaultDiscoveryCacheLockCount == 0) {
					flushDefaultDiscoveryCache();
				}
			}
		}
	}

//	private String filterTypeString(DiscoveryFilter filter) {
//		String filterType = "unknown"; //$NON-NLS-1$
//		if (DiscoveryFilterFactory.isFindHostedFilter(filter)) {
//			filterType = "findHostedFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindHostFilter(filter)) {
//			filterType = "findHostFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFollowDependencyFilter(filter)) {
//			filterType = "followDependencyFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindGroupsFilter(filter)) {
//			filterType = "findGroupsFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindMembersFilter(filter)) {
//			filterType = "findMembersFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter)) {
//			filterType = "findPossibleGroupsFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindPossibleHostedFilter(filter)) {
//			filterType = "findPossibleHostedFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindPossibleMembersFilter(filter)) {
//			filterType = "findPossibleMembersFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindPossibleSourcesFilter(filter)) {
//			filterType = "findPossibleSourcesFilter"; //$NON-NLS-1$
//		} else if (DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter)) {
//			filterType = "findPossibleTargetsFilter"; //$NON-NLS-1$
//		}
//		return filterType;
//	}

	/**
	 * Determine if two units are the same unit.
	 * 
	 * @param unit1
	 *           the first unit
	 * @param unit2
	 *           the second unit
	 * @return true if the units are the same unit
	 */
	public final boolean isSameUnit(Unit unit1, Unit unit2) {
		// get all results
		for (int i = 0; i < discoverers.length; i++) {
			TopologyDiscoverer discoverer = discoverers[i];
			if (discoverer.isDiscoveredUnitSame(unit1, unit2)) {
				return true;
			}
		}
		return unit1 == unit2;
	}

}
