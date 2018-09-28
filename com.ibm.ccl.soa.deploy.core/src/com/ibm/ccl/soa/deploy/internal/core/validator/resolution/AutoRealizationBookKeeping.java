/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * @since 7.0
 * 
 */
public class AutoRealizationBookKeeping {
	/**
	 * 
	 */
	public long startTime;
	/**
	 * 
	 */
	public int unmatchedConfigUnitMax;
	/**
	 * 
	 */
	public int unmatchedConfigUnitCount;
	/**
	 * 
	 */
	public int visitedUnitsCount;

	/**
	 * 
	 */
	public Set<Map<Unit, Unit>> resultMaps;

	private List<DeployLink> intraPatternStructuralConstraintLinks;

	private List<DeployLink> intraPatternStructuralConstraintLinksNotFollowed;

	/**
	 * Reset all counters and data structures
	 */
	public void clear() {
		startTime = System.currentTimeMillis();
		unmatchedConfigUnitCount = 0;
		unmatchedConfigUnitMax = 0;
		visitedUnitsCount = 0;
		resultMaps = new LinkedHashSet<Map<Unit, Unit>>();
		intraPatternStructuralConstraintLinks = Collections.emptyList();
		intraPatternStructuralConstraintLinksNotFollowed = Collections.emptyList();
	}

	/**
	 * 
	 */
	public AutoRealizationBookKeeping() {
		super();
		clear();
	}

	/**
	 * @return
	 */
	public List<DeployLink> getIntraPatternStructuralConstraintLinks() {
		return intraPatternStructuralConstraintLinks;
	}

	/**
	 * @param intraPatternStructuralConstraintLinks
	 */
	public void setIntraPatternStructuralConstraintLinks(
			List<DeployLink> intraPatternStructuralConstraintLinks) {
		this.intraPatternStructuralConstraintLinks = intraPatternStructuralConstraintLinks;
	}

	private int maxUnitsMapped() {
		return maxUnitsMapped(resultMaps);
	}

	private int maxUnitsMapTargets() {
		return maxUnitsMapTargets(resultMaps);
	}

	private int maxUnitsMapped(Collection<Map<Unit, Unit>> maps) {
		int max = 0;
		for (Map<Unit, Unit> resultMap : maps) {
			if (resultMap.keySet().size() > max) {
				max = resultMap.keySet().size();
			}
		}
		return max;
	}

	private int maxUnitsMapTargets(Collection<Map<Unit, Unit>> maps) {
		int max = 0;
		for (Map<Unit, Unit> map : maps) {
			Set<Unit> s = new LinkedHashSet<Unit>(map.values());
			if (s.size() > max) {
				max = s.size();
			}
		}
		return max;
	}

	/**
	 * @param workingResultMaps
	 */
	public Set<Map<Unit, Unit>> searchGC(Collection<Map<Unit, Unit>> workingResultMaps) {
		// System.out
		// .println("ConnectedSetRealizationMapper result count pre-filtering: " + resultMaps.size()); //$NON-NLS-1$
		// Pass 1. Filter out already realized units
		Set<Map<Unit, Unit>> newResultMaps = new LinkedHashSet<Map<Unit, Unit>>();
		for (Map<Unit, Unit> resultMap : workingResultMaps) {
			newResultMaps.add(ConnectedSetRealizationMapper.filterOutAlreadyRealized(resultMap));
		}
		// System.out
		// .println("ConnectedSetRealizationMapper result count post-filtering already realized: " + resultMaps.size()); //$NON-NLS-1$

		// Pass 2. Filter to only maximum keyset size
		int maxUnitsMapped = maxUnitsMapped(newResultMaps);
		List<Map<Unit, Unit>> mapRemoveList = new LinkedList<Map<Unit, Unit>>();
		for (Map<Unit, Unit> resultMap : newResultMaps) {
			if (resultMap.keySet().size() < maxUnitsMapped) {
				mapRemoveList.add(resultMap);
			}
		}
		newResultMaps.removeAll(mapRemoveList);
		// System.out
		// .println("ConnectedSetRealizationMapper result count post-filtering to max keyset: " + resultMaps.size()); //$NON-NLS-1$

		// Pass 3. Filter to only maximum unique values
		int maxUnitsMapTargets = maxUnitsMapTargets(newResultMaps);
		mapRemoveList.clear();
		for (Map<Unit, Unit> resultMap : newResultMaps) {
			Set<Unit> s = new LinkedHashSet<Unit>(resultMap.values());
			if (s.size() < maxUnitsMapTargets) {
				mapRemoveList.add(resultMap);
			}
		}
		newResultMaps.removeAll(mapRemoveList);
		// System.out
		// .println("ConnectedSetRealizationMapper result count post-filtering to max unique values: " + resultMaps.size()); //$NON-NLS-1$
		return newResultMaps;
	}

	private void searchGC() {
		resultMaps = searchGC(resultMaps);
	}

	/**
	 * 
	 */
	public void postSearchBookKeeping() {
//		System.out
//		.println("ConnectedSetRealizationMapper result count pre-filtering: " + resultMaps.size()); //$NON-NLS-1$
//		int i = 0;
//		System.out.println("ConnectedSetRealizationMapper results pre-filtering:"); //$NON-NLS-1$
//		for (Map<Unit, Unit> resultMap : resultMaps) {
//			System.out.println("Keyset[" + i + "] size = " + resultMap.keySet().size()); //$NON-NLS-1$ //$NON-NLS-2$
//			ConnectedSetRealizationMapper.dumpUnitRealizationMap(resultMap, "map # " + i); //$NON-NLS-1$
//			++i;
//		}

		searchGC();
//		System.out.println("ConnectedSetRealizationMapper results post-basic-filtering:"); //$NON-NLS-1$
//		for (Map<Unit, Unit> resultMap : resultMaps) {
//			System.out.println("Keyset[" + i + "] size = " + resultMap.keySet().size()); //$NON-NLS-1$ //$NON-NLS-2$
//			ConnectedSetRealizationMapper.dumpUnitRealizationMap(resultMap, "map # " + i); //$NON-NLS-1$
//			++i;
//		}

//		i = 0;
//		System.out.println("ConnectedSetRealizationMapper results:"); //$NON-NLS-1$
//		for (Map<Unit, Unit> resultMap : resultMaps) {
//			System.out.println("Keyset[" + i + "] size = " + resultMap.keySet().size()); //$NON-NLS-1$ //$NON-NLS-2$
//			ConnectedSetRealizationMapper.dumpUnitRealizationMap(resultMap, "map # " + i); //$NON-NLS-1$
//			++i;
//		}
	}

	/**
	 * @param m
	 * @param additions
	 */
	public void addResultMap(Map<Unit, Unit> m, Map<Unit, Unit> additions) {
		Map<Unit, Unit> resultMap = new HashMap<Unit, Unit>(m);
		resultMap.putAll(additions);
		resultMaps.add(resultMap);
//		System.out.println("new rmap size = " + resultMap.size() + ", maxUM = " + maxUnitsMapped()); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @return Returns the intraPatternStructuralConstraintLinksNotFollowed.
	 */
	public List<DeployLink> getIntraPatternStructuralConstraintLinksNotFollowed() {
		return intraPatternStructuralConstraintLinksNotFollowed;
	}

	/**
	 * @param intraPatternStructuralConstraintLinksNotFollowed
	 *           The intraPatternStructuralConstraintLinksNotFollowed to set.
	 */
	public void setIntraPatternStructuralConstraintLinksNotFollowed(
			List<DeployLink> intraPatternStructuralConstraintLinksNotFollowed) {
		this.intraPatternStructuralConstraintLinksNotFollowed = intraPatternStructuralConstraintLinksNotFollowed;
	}
}
