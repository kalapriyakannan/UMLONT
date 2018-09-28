/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;

/**
 * Provides the interface for the model-level topology caching that can utilized by topology
 * publishers.
 * 
 * @since 1.0
 * 
 */
public class TopologyCache {

	private final Map hostToHostedCache = new HashMap();
	private final Map statusToUnitCache = new HashMap();

	/**
	 * Add the specified host and hosted units to the map. Can be overridden by clients if additional
	 * logic is needed.
	 * 
	 * @param hostUnit –
	 *           the host unit
	 * @param hostedUnit –
	 *           the unit to be hosted on the host unit
	 */
	public void addHostedUnit(Unit hostUnit, Unit hostedUnit) {
		List hostedUnits = (List) hostToHostedCache.get(hostUnit);
		if (hostedUnits == null)
			hostedUnits = new ArrayList();
		hostedUnits.add(hostedUnit);
		hostToHostedCache.put(hostUnit, hostedUnits);
	}

	public void addHostedUnit(Unit hostUnit, List hostedUnits) {
		hostToHostedCache.put(hostUnit, hostedUnits);
	}

	/**
	 * Returns the list of hosted units for the specified host unit
	 * 
	 * @param hostUnit
	 *           the host unit for which to return hosted units
	 * @return the list of hosted units for this host unit, null if none exist
	 */
	public List getHostedUnits(Unit hostUnit) {
		return (List) hostToHostedCache.get(hostUnit);
	}

	/**
	 * Returns true if this host unit is hosting other units for publishing
	 * 
	 * @param hostUnit
	 *           the hostUnit
	 * @return true if the unit hosts other units, false if not
	 */
	public boolean isHosting(Unit hostUnit) {
		List hosted = getHostedUnits(hostUnit);
		if ((hosted != null) && !hosted.isEmpty())
			return true;

		return false;
	}

	/**
	 * Adds a unit-status mapping
	 * 
	 * @param status
	 *           the status
	 * @param unit
	 *           the unit
	 */
	public void addUnitStatus(IDeployPublishStatus status, Unit unit) {
		List statuses = (List) statusToUnitCache.get(unit);
		if (statuses == null)
			statuses = new ArrayList();
		statuses.add(status);
		statusToUnitCache.put(unit, statuses);
	}

	/**
	 * Returns an iterator for the units in the unit-status cache
	 * 
	 * @return an iterator to the units in the unit-status cache
	 */
	public Iterator getUnitsForStatus() {
		return statusToUnitCache.keySet().iterator();
	}

	/**
	 * Returns the an interator for the units in the unit-status cache
	 * 
	 * @param unit
	 *           the unit
	 * @return a list of status in the cache for the specified unit
	 */
	public List getStatusForUnit(Unit unit) {
		return (List) statusToUnitCache.get(unit);
	}

}
