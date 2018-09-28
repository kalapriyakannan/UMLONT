/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Caching service for expensive computations involved in pattern matching and realization.
 * 
 * May be turned on/off May be flushed (Flush is of all caches in the class) Timeout before
 * auto-flush adjustable. (Timeout is since last use of any cache in the class). Default timeout is
 * infinite.
 */
public class RealizationPatternCacheService {

	/** singleton instance of this service */
	public static final RealizationPatternCacheService INSTANCE = new RealizationPatternCacheService();

	private long _maxCacheAgeMilliseconds = Integer.MAX_VALUE;
	private long realizationPatternCacheLastUsedTime = 0;
	private long realizationNavigationCacheLastUsedTime = 0;

	/**
	 * Realization pattern cache lock count (access synchronized on
	 * {@link #realizationPatternCachingLock}).
	 */
	private int realizationPatternCachingLockCount = 0;
	private final Object realizationPatternCachingLock = new Object();
	/**
	 * Realization navigation cache lock count (access synchronized on
	 * {@link #realizationNavigationCachingLock}).
	 */
	private int realizationNavigationCachingLockCount = 0;
	private final Object realizationNavigationCachingLock = new Object();

	private final Map<Unit, Set<Unit>> immediateConnectedSetCache = Collections
			.synchronizedMap(new HashMap<Unit, Set<Unit>>());
	private final Map<Unit, Set<Unit>> immediateConceptualConnectedSetCache = Collections
			.synchronizedMap(new HashMap<Unit, Set<Unit>>());
	private final Map<Unit, Set<Unit>> immediateStackPlusGroupsSetCache = Collections
			.synchronizedMap(new HashMap<Unit, Set<Unit>>());
	private final Map<Unit, Set<Unit>> immediateStrictStackSetCache = Collections
			.synchronizedMap(new HashMap<Unit, Set<Unit>>());
	private final Map<Unit, List<Map<Unit, Unit>>> realizationMapsConnectedSetCache = Collections
			.synchronizedMap(new HashMap<Unit, List<Map<Unit, Unit>>>());

	private final Map<Unit, UnitDescriptor> unitToUnitDescriptorCache = Collections
			.synchronizedMap(new HashMap<Unit, UnitDescriptor>());

	private final Map<Unit, Unit> getHostCache = Collections
			.synchronizedMap(new HashMap<Unit, Unit>());
	private final Map<Unit, List<Unit>> getHostedCache = Collections
			.synchronizedMap(new HashMap<Unit, List<Unit>>());
	private final Map<Unit, List<Unit>> getGroupsCache = Collections
			.synchronizedMap(new HashMap<Unit, List<Unit>>());
	private final Map<Unit, List<Unit>> getMembersCache = Collections
			.synchronizedMap(new HashMap<Unit, List<Unit>>());
	private final Map<Requirement, Capability> getDependencyLinkTargetCache = Collections
			.synchronizedMap(new HashMap<Requirement, Capability>());
	private final Map<Capability, List<Requirement>> getDependencyLinkSourcesCache = Collections
			.synchronizedMap(new HashMap<Capability, List<Requirement>>());
	private final Map<GetPossibleLinksQuery, LinkDescriptor[]> getPossibleLinksCache = Collections
			.synchronizedMap(new HashMap<GetPossibleLinksQuery, LinkDescriptor[]>());

	private final Map<Unit, Unit> getImmediateHostCache = Collections
			.synchronizedMap(new HashMap<Unit, Unit>());
	private final Map<Unit, List<Unit>> getAllHostsCache = Collections
			.synchronizedMap(new HashMap<Unit, List<Unit>>());

	private AutoRealizationBookKeeping arbk = new AutoRealizationBookKeeping();
	private AutoRealizationControl arc = new AutoRealizationControl();

	/**
	 * Clear contents of default discovery cache TODO maps must be cleared on all topology changes,
	 * but sets only if navigability changes, e.g. on link changes or unit additions/deletions.
	 */
	public void flushRealizationPatternCache() {
		//		System.out.println("Flushing realization pattern cache"); //$NON-NLS-1$
		immediateConnectedSetCache.clear();
		immediateConceptualConnectedSetCache.clear();
		immediateStackPlusGroupsSetCache.clear();
		immediateStrictStackSetCache.clear();
		realizationMapsConnectedSetCache.clear();
	}

	/**
	 * Clear contents of default discovery cache TODO maps must be cleared on all topology changes,
	 * but sets only if navigability changes, e.g. on link changes or unit additions/deletions.
	 */
	public void flushRealizationNavigationCache() {
		//		System.out.println("Flushing realization navigation cache"); //$NON-NLS-1$
		unitToUnitDescriptorCache.clear();
		getHostCache.clear();
		getHostedCache.clear();
		getGroupsCache.clear();
		getMembersCache.clear();
		getDependencyLinkTargetCache.clear();
		getDependencyLinkSourcesCache.clear();
		getPossibleLinksCache.clear();
		getImmediateHostCache.clear();
		getAllHostsCache.clear();
	}

	/**
	 * Privatise constructor for service.
	 */
	private RealizationPatternCacheService() {

	}

	/**
	 * Use create if and only if a private instance of caches is needed. Otherwise use the singleton
	 * instance
	 * 
	 * @param arc
	 *           instance of autorealization control class. (new default instance used if null)
	 * @param arbk
	 *           instance of autorealization book keeping class. (new default instance used if null)
	 * @return instance of RealizationPatternCacheService with parameter control and bookkeeping
	 *         instances.
	 */
	public RealizationPatternCacheService create(AutoRealizationControl arc,
			AutoRealizationBookKeeping arbk) {
		RealizationPatternCacheService rpcs = new RealizationPatternCacheService();
		if (arc != null) {
			rpcs.arc = arc;
		}
		if (arbk != null) {
			rpcs.arbk = arbk;
		}
		return rpcs;
	}

	private void ageCheckRealizationPatternCache() {
		long currentTime = System.currentTimeMillis();
		if (currentTime - realizationPatternCacheLastUsedTime > _maxCacheAgeMilliseconds) {
			synchronized (realizationPatternCachingLock) {
				flushRealizationPatternCache();
			}
		}
		realizationPatternCacheLastUsedTime = System.currentTimeMillis();
	}

	private void ageCheckRealizationNavigationCache() {
		long currentTime = System.currentTimeMillis();
		if (currentTime - realizationNavigationCacheLastUsedTime > _maxCacheAgeMilliseconds) {
			synchronized (realizationNavigationCachingLock) {
				flushRealizationNavigationCache();
			}
		}
		realizationNavigationCacheLastUsedTime = System.currentTimeMillis();
	}

	/**
	 * Starts realization pattern caching if not already enabled.
	 * <p>
	 * Caching must be stopped (unlocked) using {@link #leaveRealizationPatternCache()}
	 * <p>
	 * <em>Thread-safe method</a>.
	 */
	public void enterRealizationPatternCache() {
		synchronized (realizationPatternCachingLock) {
			realizationPatternCachingLockCount++;
		}
	}

	/**
	 * Stops realization pattern caching once all "enter"s have been matched.
	 * <p>
	 * When the last "enter" is matched, the cache is flushed.
	 * <p>
	 * <em>Thread-safe method</a>.
	 * 
	 * @see #enterRealizationPatternCache()
	 */
	public void leaveRealizationPatternCache() {
		synchronized (realizationPatternCachingLock) {
			if (realizationPatternCachingLockCount == 0) {
				flushRealizationPatternCache();
			} else {
				realizationPatternCachingLockCount--;
				if (realizationPatternCachingLockCount == 0) {
					flushRealizationPatternCache();
				}
			}
		}
	}

	/**
	 * Starts discovery result caching if not already enabled.
	 * <p>
	 * Caching must be stopped (unlocked) using {@link #leaveRealizationNavigationCache()}
	 * <p>
	 * <em>Thread-safe method</a>.
	 */
	public void enterRealizationNavigationCache() {
		synchronized (realizationNavigationCachingLock) {
			realizationNavigationCachingLockCount++;
		}
	}

	/**
	 * Stops realization navigation caching once all "enter"s have been matched.
	 * <p>
	 * When the last "enter" is matched, the cache is flushed.
	 * <p>
	 * <em>Thread-safe method</a>.
	 * 
	 * @see #enterRealizationNavigationCache()
	 */
	public void leaveRealizationNavigationCache() {
		synchronized (realizationNavigationCachingLock) {
			if (realizationNavigationCachingLockCount == 0) {
				flushRealizationNavigationCache();
			} else {
				realizationNavigationCachingLockCount--;
				if (realizationNavigationCachingLockCount == 0) {
					flushRealizationNavigationCache();
				}
			}
		}
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil#getImmediateConnectedSet
	 *      Cached computation of a set of Units which are all units connected to parameter unit via
	 *      any link type except realization links, recursively. TODO unbacked version
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @return Set of Units in connected pattern
	 */
	public Set<Unit> getImmediateConnectedSet(Unit u) {
		if (!isRealizationPatternCachingEnabled()) {
			return RealizationPatternUtil.getImmediateConnectedSet(u, arc
					.isFollowStructuralConstraintLinks(), this);
		}
		ageCheckRealizationPatternCache();
		synchronized (realizationPatternCachingLock) {
			if (immediateConnectedSetCache.get(u) == null) {
				Set<Unit> ics = RealizationPatternUtil.getImmediateConnectedSet(u, arc
						.isFollowStructuralConstraintLinks(), this);
				for (Iterator<Unit> icsIter = ics.iterator(); icsIter.hasNext();) {
					Unit icsu = icsIter.next();
					immediateConnectedSetCache.put(icsu, ics);
				}
				//			System.out.println("getImmediateConnectedSet cache miss - " + u.titleWithContext() + "(" + u + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getImmediateConnectedSet cache hit - " + u.titleWithContext() + "(" + u + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return immediateConnectedSetCache.get(u);
		}
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil#getImmediateConnectedSet(Unit,
	 *      boolean ) Cached computation of a set of Units which are all units connected to parameter
	 *      unit via any link type except realization links, recursively. TODO unbacked version
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @return Set of Units in connected conceptual pattern
	 */
	public Set<Unit> getImmediateConceptualConnectedSet(Unit u) {
		if (!isRealizationPatternCachingEnabled()) {
			return RealizationPatternUtil.getImmediateConceptualConnectedSet(u, arc
					.isFollowStructuralConstraintLinks(), this);
		}
		ageCheckRealizationPatternCache();
		synchronized (realizationPatternCachingLock) {
			if (immediateConceptualConnectedSetCache.get(u) == null) {
				Set<Unit> iccs = RealizationPatternUtil.getImmediateConceptualConnectedSet(u, arc
						.isFollowStructuralConstraintLinks(), this);
				for (Iterator<Unit> iccsIter = iccs.iterator(); iccsIter.hasNext();) {
					Unit iccsu = iccsIter.next();
					immediateConceptualConnectedSetCache.put(iccsu, iccs);
				}
				//			System.out.println("getImmediateConceptualConnectedSet cache miss - " + u.titleWithContext() + "(" + u + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getImmediateConceptualConnectedSet cache hit - " + u.titleWithContext() + "(" + u + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return immediateConceptualConnectedSetCache.get(u);
		}
	}

	/**
	 * @see ConnectedSetRealizationMapper#realizationMapsConnectedSet(Unit, Topology,
	 *      DeployValidatorService, IProgressMonitor)
	 * 
	 * Cached computation of a realization mapping of a connected set of conceptual units against a
	 * target topology, starting at unit startU
	 * @param startU
	 * @param top
	 * @param dvs
	 * @param monitor
	 *           if not null, then method makes cancellation checks during computation
	 * 
	 * @return Map of Units to realize and their realizations
	 */
	public List<Map<Unit, Unit>> realizationMapsConnectedSet(Unit startU, Topology top,
			DeployValidatorService dvs, IProgressMonitor monitor) {
		if (!isRealizationPatternCachingEnabled()) {
			arbk.clear();
			return ConnectedSetRealizationMapper.realizationMapsConnectedSet(startU, top, this, arbk,
					arc, dvs, monitor);
		}
		ageCheckRealizationPatternCache();
		synchronized (realizationPatternCachingLock) {
			if (realizationMapsConnectedSetCache.get(startU) == null) {
//				Set<Unit> icSet = getImmediateConnectedSet(startU);
				Set<Unit> iccSet = getImmediateConceptualConnectedSet(startU);
				arbk.clear();
				List<Map<Unit, Unit>> rmcs = ConnectedSetRealizationMapper.realizationMapsConnectedSet(
						startU, top, this, arbk, arc, dvs, monitor);
				for (Iterator<Unit> icsIter = iccSet.iterator(); icsIter.hasNext();) {
					Unit icsu = icsIter.next();
					realizationMapsConnectedSetCache.put(icsu, rmcs);
				}
				//			System.out.println("realizationMapsConnectedSet cache miss - " + startU.titleWithContext() + "(" + startU.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("realizationMapsConnectedSet cache hit - " + startU.titleWithContext() + "(" + startU.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return realizationMapsConnectedSetCache.get(startU);
		}
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil#getImmediateStackPlusGroupsSet
	 *      Cached computation of a set of Units which are (a) The parameter unit and all units in
	 *      its immediate hosting stack including the bottom of the hosting stack, plus (b) The units
	 *      hosted, recursively, by the units in (a) (c) The containing groups (1 level only) of the
	 *      units in (a) and (b)
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param top
	 * @return Set of Units in pattern
	 */
	public Set<Unit> getImmediateStackPlusGroupsSet(Unit u, Topology top) {
		if (!isRealizationPatternCachingEnabled()) {
			return RealizationPatternUtil.getImmediateStackPlusGroupsSet(u, top);
		}
		ageCheckRealizationPatternCache();
		synchronized (realizationPatternCachingLock) {
			if (immediateStackPlusGroupsSetCache.get(u) == null) {
				Set<Unit> ispgs = RealizationPatternUtil.getImmediateStackPlusGroupsSet(u, top);
				for (Iterator<Unit> ispgsIter = ispgs.iterator(); ispgsIter.hasNext();) {
					Unit ispgu = ispgsIter.next();
					immediateStackPlusGroupsSetCache.put(ispgu, ispgs);
				}
				//			System.out.println("getImmediateStackPlusGroupsSet cache miss - " + u.titleWithContext() + "(" + u.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getImmediateStackPlusGroupsSet cache hit - " + u.titleWithContext() + "(" + u.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return immediateStackPlusGroupsSetCache.get(u);
		}
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil#getImmediateStrictStackSet
	 *      Cached computation of a set of Units which are the parameter unit and all units in its
	 *      immediate hosting stack including the bottom of the hosting stack.
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @return Set of Units in hosting stack pattern
	 */
	public Set<Unit> getImmediateStrictStackSet(Unit u) {
		if (!isRealizationPatternCachingEnabled()) {
			return RealizationPatternUtil.getImmediateStrictStackSet(u);
		}
		ageCheckRealizationPatternCache();
		synchronized (realizationPatternCachingLock) {
			if (immediateStrictStackSetCache.get(u) == null) {
				Set<Unit> isss = RealizationPatternUtil.getImmediateStrictStackSet(u);
				for (Iterator<Unit> isssIter = isss.iterator(); isssIter.hasNext();) {
					Unit issu = isssIter.next();
					immediateStrictStackSetCache.put(issu, isss);
				}
				//			System.out.println("getImmediateStrictStackSet cache miss - " + u.titleWithContext() + "(" + u.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getImmediateStrictStackSet cache hit - " + u.titleWithContext() + "(" + u.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return immediateStrictStackSetCache.get(u);
		}
	}

	/**
	 * @return Returns the true if realization pattern caching is enabled.
	 */
	public boolean isRealizationPatternCachingEnabled() {
		return realizationPatternCachingLockCount > 0;
	}

	/**
	 * @return Returns the _maxCacheAgeMilliseconds.
	 */
	public long getMaxCacheAgeMilliseconds() {
		return _maxCacheAgeMilliseconds;
	}

	/**
	 * @param maxCacheAgeMilliseconds
	 *           The maxCacheAgeMilliseconds to set.
	 */
	public void setMaxCacheAgeMilliseconds(long maxCacheAgeMilliseconds) {
		_maxCacheAgeMilliseconds = maxCacheAgeMilliseconds;
	}

	//-------------------------------------------------------------------
	// Locally-used navigation methods, specialized for realization navigation
	// These methods use could use discovery if passed a concrete unit or dmo attached to a concrete unit
	// // These methods save the UnitDescriptor to Unit mapping, for reuse at resolution time,
	// // if a UnitDescriptor is found as an intermediate step.
	//
	// Currently the discovery usage is commented out, due to unresolved bugs.

	private Unit rpGetHost(Unit hosted, Topology top) {
		Unit host;
		if (hosted.isConceptual()) {
			host = ValidatorUtils.getHost(hosted);
		} else {
			host = ValidatorUtils.getHost(hosted);
			//			UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findHostUD(hosted, top);
			//			if (ud == null) {
			//				return null;
			//			}
			//			host = ud.getUnitValue();
			//			if (host != null) {
			//				unitToUnitDescriptorCache.put(host, ud);
			//			}
		}
		return host;
	}

	/**
	 * Return most realized host of unit. Returns result from cache if previously computed.
	 * 
	 * @param hosted
	 *           unit to find host of
	 * @param top
	 *           if discovery is supported, topology to do discovery over, usually edit topology
	 * @return Hosted's host
	 */
	public Unit getMostRealizedHost(Unit hosted, Topology top) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetHost(hosted, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			Unit host = getHostCache.get(hosted);
			if (host == null && !getHostCache.keySet().contains(hosted)) {
				host = rpGetHost(hosted, top);
				getHostCache.put(hosted, host);
				//						System.out.println("getHost cache miss - " + hosted.titleWithContext() + "(" + hosted.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getHost cache hit - " + hosted.titleWithContext() + "(" + hosted.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return host;
		}
	}

	/**
	 * Return host of unit. Returns result from cache if previously computed. Returns either
	 * immediate host or most realized host depending on parameter.
	 * 
	 * @param hosted
	 *           unit to find host of
	 * @param top
	 *           topology to do discover over, usually edit topology
	 * @param immediate
	 * 
	 * @return Hosted's host
	 */
	public Unit getHost(Unit hosted, Topology top, boolean immediate) {
		if (immediate) {
			return ValidatorUtils.getImmediateHost(hosted);
		} else {
			return getMostRealizedHost(hosted, top);
		}
	}

	private static List<Unit> rpGetHosted(Unit u, Topology top) {
		List<Unit> hosted;
		if (u.isConceptual()) {
			hosted = ValidatorUtils.getHosted(u);
		} else {
			hosted = ValidatorUtils.getHosted(u);
			//			List<UnitDescriptor> hostedByHostUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(u, top);
			//			ArrayList<Unit> retList = new ArrayList<Unit>(hostedByHostUnitDescriptors.size());
			//			for (Iterator<UnitDescriptor> iter = hostedByHostUnitDescriptors.iterator(); iter.hasNext();) {
			//				UnitDescriptor hosteeUD = iter.next();
			//				if (hosteeUD == null) {
			//					continue;
			//				}
			//				Unit hostee = hosteeUD.getUnitValue();
			//				if (hostee != null) {
			//					RealizationPatternCacheService.INSTANCE.unitToUnitDescriptorCache.put(hostee, hosteeUD);
			//					retList.add(hostee);
			//				}
			//			}
			//			hosted = retList;
		}
		return hosted;
	}

	/**
	 * Return most realized hostees of unit. Returns result from cache if previously computed.
	 * 
	 * @param host
	 *           unit to find hostees of
	 * @param top
	 *           if discovery is supported, topology to do discover over, usually edit topology
	 * @return Host's hostees
	 */
	public List<Unit> getMostRealizedHosted(Unit host, Topology top) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetHosted(host, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			List<Unit> hosted = getHostedCache.get(host);
			if (hosted == null) {
				hosted = rpGetHosted(host, top);
				getHostedCache.put(host, hosted);
				//			System.out.println("getHosted cache miss - " + host.titleWithContext() + "(" + host.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getHosted cache hit - " + host.titleWithContext() + "(" + host.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return hosted;
		}
	}

	/**
	 * Return hostees of unit. Returns result from cache if previously computed.
	 * 
	 * @param host
	 *           unit to find hostees of
	 * @param top
	 *           if discovery is supported, topology to do discover over, usually edit topology
	 * @param immediate
	 *           immediate hosted or most realized hosted?
	 * @return Host's hostees
	 */
	public List<Unit> getHosted(Unit host, Topology top, boolean immediate) {
		if (immediate) {
//			return ValidatorUtils.getImmediateHosted(host); SLOW!
			return new ArrayList(top.getRelationships().getHosted(host));
		} else {
			return getMostRealizedHosted(host, top);
		}
	}

	private static List<Unit> rpGetGroups(Unit member, Topology top) {
		List<Unit> groups;
		if (member.isConceptual()) {
			groups = ValidatorUtils.getGroups(member);
		} else {
			groups = ValidatorUtils.getGroups(member);
			//			List allGroups = TopologyDiscovererService.INSTANCE.getGroups(member, null, top);
			//			ArrayList<Unit> workingGroups = new ArrayList();
			//			for (Iterator iter = allGroups.iterator(); iter.hasNext();) {
			//				UnitDescriptor groupUD = (UnitDescriptor) iter.next();
			//				if (groupUD == null) {
			//					continue;
			//				}
			//				Unit group = groupUD.getUnitValue();
			//				RealizationPatternCacheService.INSTANCE.unitToUnitDescriptorCache.put(group, groupUD);
			//				workingGroups.add(group);
			//			}
			//			groups = workingGroups;
		}
		return groups;
	}

	/**
	 * Return groups containing unit. Returns result from cache if previously computed.
	 * 
	 * @param member
	 *           unit to find groups for
	 * @param top
	 *           If discovery is supported, topology to do discover over, usually edit topology
	 * @return groups containing member unit
	 */
	public List<Unit> getMostRealizedGroups(Unit member, Topology top) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetGroups(member, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			List<Unit> groups = getGroupsCache.get(member);
			if (groups == null) {
				groups = rpGetGroups(member, top);
				getGroupsCache.put(member, groups);
				//			System.out.println("getGroups cache miss - " + member.titleWithContext() + "(" + member.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getGroups cache hit - " + member.titleWithContext() + "(" + member.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return groups;
		}
	}

	/**
	 * Return groups containing unit. Returns result from cache if previously computed.
	 * 
	 * @param member
	 *           unit to find groups for
	 * @param top
	 *           If discoveyr is supported, topology to do discover over, usually edit topology
	 * @param immediate
	 *           immediate groups or most realized?
	 * @return groups containing member unit
	 */
	public List<Unit> getGroups(Unit member, Topology top, boolean immediate) {
		if (immediate) {
			return ValidatorUtils.getImmediateGroups(member);
		} else {
			return getMostRealizedGroups(member, top);
		}
	}

	private static List<Unit> rpGetMembers(Unit group, Topology top) {
		List<Unit> members;
		if (group.isConceptual()) {
			members = ValidatorUtils.getMembers(group);
		} else {
			members = ValidatorUtils.getMembers(group);
			//			ArrayList<Unit> retList = new ArrayList();
			//			List<UnitDescriptor> memberUnitDescriptors = TopologyDiscovererService.INSTANCE.getMembers(group, null, top);
			//			for (Iterator<UnitDescriptor> iter = memberUnitDescriptors.iterator(); iter.hasNext();) {
			//				UnitDescriptor memberUD = iter.next();
			//				if (memberUD == null) {
			//					continue; 
			//				}
			//				Unit member = memberUD.getUnitValue();
			//				if (member != null) {
			//					RealizationPatternCacheService.INSTANCE.unitToUnitDescriptorCache.put(group, memberUD);
			//					retList.add(member);
			//				}
			//			}
			//			members = retList;
		}
		return members;
	}

	/**
	 * Return members of group. Returns result from cache if previously computed.
	 * 
	 * @param group
	 *           unit to find members of
	 * @param top
	 *           if discovery is supported, topology to do discover over, usually edit topology
	 * @return members of group
	 */
	public List<Unit> getMostRealizedMembers(Unit group, Topology top) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetMembers(group, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			List<Unit> members = getMembersCache.get(group);
			if (members == null) {
				members = rpGetMembers(group, top);
				getMembersCache.put(group, members);
				//			System.out.println("getMembers cache miss - " + group.titleWithContext() + "(" + group.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getMembers cache hit - " + group.titleWithContext() + "(" + group.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return members;
		}
	}

	/**
	 * Return members of group. Returns result from cache if previously computed.
	 * 
	 * @param group
	 *           unit to find members of
	 * @param top
	 *           If discovery is supported, topology to do discover over, usually edit topology
	 * @param immediate
	 *           immediate or most realized?
	 * @return members of group
	 */
	public List<Unit> getMembers(Unit group, Topology top, boolean immediate) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetMembers(group, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			List<Unit> members = getMembersCache.get(group);
			if (members == null) {
				members = rpGetMembers(group, top);
				getMembersCache.put(group, members);
				//			System.out.println("getMembers cache miss - " + group.titleWithContext() + "(" + group.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getMembers cache hit - " + group.titleWithContext() + "(" + group.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return members;
		}
	}

	private static Capability rpGetDependencyLinkTarget(Requirement req, Topology top) {
		Capability dlTarget;
		if (ValidatorUtils.getUnit(req) != null && ValidatorUtils.getUnit(req).isConceptual()) {
			dlTarget = ValidatorUtils.getDependencyLinkTarget(req);
		} else {
			dlTarget = ValidatorUtils.getDependencyLinkTarget(req);
			//			Unit unit = ValidatorUtils.getUnit(req);
			//			if (unit == null) {
			//				return null;
			//			}
			//			UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findTarget(unit,	req, top);
			//			if (ud == null) {
			//				return null;
			//			}
			//			Unit targetUnit = ud.getUnitValue();
			//			if (targetUnit == null) {
			//				return null;
			//			}
			//			if (req.getDmoEType() == null) {
			//				if (targetUnit.getCapabilities().size() > 0) {
			//					dlTarget = (Capability) targetUnit.getCapabilities().get(0);
			//				} else {
			//					return null;
			//				}
			//			}
			//			dlTarget = ValidatorUtils.getFirstCapability(targetUnit, req.getDmoEType());
			//			RealizationPatternCacheService.INSTANCE.unitToUnitDescriptorCache.put(targetUnit, ud);
		}
		return dlTarget;
	}

	/**
	 * Return target capability of dependency link. Returns result from cache if previously computed.
	 * 
	 * @param req
	 *           requirement to find target for
	 * @param top
	 *           If discovery is supported, topology to do discover over, usually edit topology
	 * @return capability that is target of dependency link, or null
	 */
	public Capability getMostRealizedDependencyLinkTarget(Requirement req, Topology top) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetDependencyLinkTarget(req, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			Capability capTarget = getDependencyLinkTargetCache.get(req);
			if (capTarget == null && !getDependencyLinkTargetCache.keySet().contains(req)) {
				capTarget = rpGetDependencyLinkTarget(req, top);
				getDependencyLinkTargetCache.put(req, capTarget);
				//			System.out.println("getDependencyLinkTarget cache miss - " + req.getDisplayName() + "(" + req.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getDependencyLinkTarget cache hit - " + req.getDisplayName() + "(" + req.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return capTarget;
		}
	}

	/**
	 * Return target capability of dependency link. Returns result from cache if previously computed.
	 * 
	 * @param req
	 *           requirement to find target for
	 * @param top
	 *           If discovery is supported, topology to do discover over, usually edit topology
	 * @param immediate
	 *           immediate or most realized?
	 * @return capability that is target of dependency link, or null
	 */
	public Capability getDependencyLinkTarget(Requirement req, Topology top, boolean immediate) {
		if (immediate) {
			return ValidatorUtils.getImmediateDependencyLinkTarget(req);
		} else {
			return getMostRealizedDependencyLinkTarget(req, top);
		}
	}

	private static List<Requirement> rpGetDependencyLinkSources(Capability cap, Topology top) {
		List<Requirement> dlSources;
		if (ValidatorUtils.getUnit(cap) != null && ValidatorUtils.getUnit(cap).isConceptual()) {
			dlSources = ValidatorUtils.getDependencyLinkSources(cap);
		} else {
			dlSources = ValidatorUtils.getDependencyLinkSources(cap);
			//			if (cap == null) {
			//				return DeployCollections.EMPTY_REQUIREMENT_LIST;
			//			}
			//			Unit unit = ValidatorUtils.getUnit(cap);
			//			if (unit == null) {
			//				return DeployCollections.EMPTY_REQUIREMENT_LIST;
			//			}
			//			List<UnitDescriptor> udList = TopologyDiscovererService.INSTANCE.findSources(unit, cap,	top);
			//			if (udList.size() == 0) {
			//				return DeployCollections.EMPTY_REQUIREMENT_LIST;
			//			}
			//			List<Requirement> reqList = new ArrayList<Requirement>(udList.size());
			//			for (int i = 0; i < udList.size(); i++) {
			//				UnitDescriptor ud = udList.get(i);
			//				if (ud == null) {
			//					continue;
			//				}
			//				Unit sourceUnit = ud.getUnitValue();
			//				if (sourceUnit != null) {
			//					Requirement req = ValidatorUtils.getFirstRequirement(sourceUnit, cap.eClass());
			//					if (req != null) {
			//						RealizationPatternCacheService.INSTANCE.unitToUnitDescriptorCache.put(sourceUnit, ud);
			//						reqList.add(req);
			//					}
			//				}
			//			}
			//			dlSources = reqList;			
		}
		return dlSources;
	}

	/**
	 * Return requirements which target capability with a dependency link. Returns result from cache
	 * if previously computed.
	 * 
	 * @param cap
	 *           capability to find sources for
	 * @param top
	 *           If discovery is supported, topology to do discover over, usually edit topology
	 * @return list of requirements that target capability with a dependency link
	 */
	public List<Requirement> getMostRealizedDependencyLinkSources(Capability cap, Topology top) {
		if (!isRealizationNavigationCachingEnabled()) {
			return rpGetDependencyLinkSources(cap, top);
		}
		ageCheckRealizationNavigationCache();
		synchronized (realizationNavigationCachingLock) {
			List<Requirement> reqSources = getDependencyLinkSourcesCache.get(cap);
			if (reqSources == null) {
				reqSources = rpGetDependencyLinkSources(cap, top);
				getDependencyLinkSourcesCache.put(cap, reqSources);
				//			System.out.println("getDependencyLinkSources cache miss - " + cap.getDisplayName() + "(" + cap.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getDependencyLinkSources cache hit - " + cap.getDisplayName() + "(" + cap.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return reqSources;
		}
	}

	/**
	 * Return requirements which target capability with a dependency link. Returns result from cache
	 * if previously computed.
	 * 
	 * @param cap
	 *           capability to find sources for
	 * @param top
	 *           If discovery is supported, topology to do discover over, usually edit topology
	 * @param immediate
	 *           immediate or most realized
	 * @return list of requirements that target capability with a dependency link
	 */
	public List<Requirement> getDependencyLinkSources(Capability cap, Topology top, boolean immediate) {
		if (immediate) {
			return ValidatorUtils.getImmediateDependencyLinkSources(cap);
		} else {
			return getMostRealizedDependencyLinkSources(cap, top);
		}
	}

	/**
	 * If unit was obtained through a unit descriptor using one of the navigation methods in this
	 * class, return unit descriptor, else return null. If the unit is already in the topology or the
	 * unit is conceptual, this method will probably return null.
	 * 
	 * @param u
	 *           unit to get unit descriptor for
	 * @return unit descriptor, else return null
	 */
	public UnitDescriptor rpGetUnitDescriptor(Unit u) {
		return unitToUnitDescriptorCache.get(u);
	}

	/**
	 * Cached version of the basic get possible links query.
	 * 
	 * @param source
	 *           source unit for candidate link
	 * @param target
	 *           target unit for candidate link
	 * @param linkTypes
	 *           array of link types to use for query, e.g. { LinkType.REALIZATION }
	 * @param dvs
	 *           deploy validator service to use for query
	 * @return Link descriptor array
	 */
	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes,
			DeployValidatorService dvs) {
		if (!isRealizationNavigationCachingEnabled()) {
			return dvs.getPossibleLinks(source, target, linkTypes);
		}
		ageCheckRealizationNavigationCache();
		GetPossibleLinksQuery gplq = new GetPossibleLinksQuery(source, target, linkTypes, dvs);
		synchronized (realizationNavigationCachingLock) {
			LinkDescriptor[] linkDescriptors = getPossibleLinksCache.get(gplq);
			if (linkDescriptors == null) {
				linkDescriptors = dvs.getPossibleLinks(source, target, linkTypes);
				assert linkDescriptors != null;
				getPossibleLinksCache.put(gplq, linkDescriptors);
				//			System.out.println("getPossibleLinks cache miss - " + gplq.toString() + "(" + gplq.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				//			System.out.println("getPossibleLinks cache hit - " + gplq.toString() + "(" + gplq.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$			
			}
			return linkDescriptors;
		}
	}

	private class GetPossibleLinksQuery {
		private final Unit _source;
		private final Unit _target;
		private final LinkType[] _linkTypes;
		private final DeployValidatorService _dvs;

		GetPossibleLinksQuery(Unit source, Unit target, LinkType[] linkTypes,
				DeployValidatorService dvs) {
			_source = source;
			_target = target;
			_linkTypes = linkTypes;
			_dvs = dvs;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (_dvs == null ? 0 : _dvs.hashCode());
			result = prime * result + Arrays.hashCode(_linkTypes);
			result = prime * result + (_source == null ? 0 : _source.hashCode());
			result = prime * result + (_target == null ? 0 : _target.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final GetPossibleLinksQuery other = (GetPossibleLinksQuery) obj;
			if (_dvs == null) {
				if (other._dvs != null) {
					return false;
				}
			} else if (!_dvs.equals(other._dvs)) {
				return false;
			}
			if (!Arrays.equals(_linkTypes, other._linkTypes)) {
				return false;
			}
			if (_source == null) {
				if (other._source != null) {
					return false;
				}
			} else if (!_source.equals(other._source)) {
				return false;
			}
			if (_target == null) {
				if (other._target != null) {
					return false;
				}
			} else if (!_target.equals(other._target)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			String linkTypesString = ""; //$NON-NLS-1$
			for (int i = 0; i < _linkTypes.length; ++i) {
				if (i != 0) {
					linkTypesString += " "; //$NON-NLS-1$
				}
				linkTypesString += _linkTypes[i].getDescription();
			}
			return _source.getCaptionProvider().titleWithContext(_source)
					+ " --> " + _target.getCaptionProvider().titleWithContext(_target) + "(" + _linkTypes[0].getDescription() + ")"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		}
	}

	/**
	 * @return Returns true if realizationNavigationCaching is enabled.
	 */
	public boolean isRealizationNavigationCachingEnabled() {
		return realizationNavigationCachingLockCount > 0;
	}

	/**
	 * @return Returns the arbk.
	 */
	public AutoRealizationBookKeeping getArbk() {
		return arbk;
	}
}
