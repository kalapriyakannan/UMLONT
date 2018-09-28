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
import java.util.List;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides the interface for the model-level topology caching that can utilized by topology
 * publishers. This extends the base TopologyCache by adding support for the separate caching of
 * ConfigurationUnits
 * 
 * @since 1.0
 * 
 */
public class ApplicationTopologyCache extends TopologyCache {
	private final Map hostToHostedConfigCache = new HashMap();

	/**
	 * Override method from parent to defer caching of the unit to the appropriate cache handler. A
	 * separate cache list is maintained for ConfigurationUnits
	 * 
	 * @param hostUnit
	 * @param hostedUnit
	 */
	public void addHostedUnit(Unit hostUnit, Unit hostedUnit) {
		if (hostedUnit.isConfigurationUnit())
			addHostedConfigUnit(hostUnit, hostedUnit);
		else
			super.addHostedUnit(hostUnit, hostedUnit);
	}

	/**
	 * Adds the specified hostUnit and hostedConfigUnit to the map. A separate map is maintained for
	 * for ConfigurationUnits
	 * 
	 * @param hostUnit
	 * @param hostedConfigUnit
	 */
	public void addHostedConfigUnit(Unit hostUnit, Unit hostedConfigUnit) {
		List hostedConfigs = (List) hostToHostedConfigCache.get(hostUnit);
		if (hostedConfigs == null)
			hostedConfigs = new ArrayList();
		hostedConfigs.add(hostedConfigUnit);
		hostToHostedConfigCache.put(hostUnit, hostedConfigs);
	}

	/**
	 * Return the list of hosted configuration units for the specified host unit
	 * 
	 * @param hostUnit
	 *           the host unit
	 * @return the list of hosted configuration units for this host unit, null if none exist
	 */
	public List getHostedConfigUnitsForHostUnit(Unit hostUnit) {
		return (List) hostToHostedConfigCache.get(hostUnit);
	}

	/**
	 * Returns a list of all units hosted on this host unit
	 * 
	 * @param hostUnit
	 *           the host unit
	 * @return a list of all units hosted on this host unit, configuration and base units. Null, if
	 *         none exist.
	 */
	public List getAllHostedUnits(Unit hostUnit) {
		List allUnits = new ArrayList();

		List units = getHostedUnits(hostUnit);
		List configs = getHostedConfigUnitsForHostUnit(hostUnit);
		if (units != null)
			allUnits.addAll(units);
		if (configs != null)
			allUnits.addAll(configs);

		return allUnits;

	}

	/**
	 * Returns true if this host unit is hosting other units for publishing Override this from
	 * topology cache so we check all units
	 * 
	 * @param hostUnit
	 *           the hostUnit
	 * @return true if the unit hosts other units, false if not
	 */
	public boolean isHosting(Unit hostUnit) {
		List hosted = getAllHostedUnits(hostUnit);
		if ((hosted != null) && !hosted.isEmpty())
			return true;

		return false;
	}

}
