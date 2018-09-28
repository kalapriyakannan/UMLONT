/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;

/**
 * Static utility methods for use by the matcher.
 */
public class MatcherUtils {

	/**
	 * Recursively retrieve all of the configuration units hosted by a unit. This includes those
	 * hosted by hosted configuration units.
	 * 
	 * @param unit
	 *           host
	 * @return list of configuration units
	 */
	public static List getHostedConfigurationUnits(Unit unit) {
		List configUnits = new ArrayList();
//		
//		for (Iterator hostingLinks = unit.getHostingLinks().iterator(); hostingLinks
//				.hasNext();) {
//			HostingLink link = (HostingLink) hostingLinks.next();
//			Unit hostee = link.getTarget();		
		List hostedByUnitUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(unit, unit
				.getTopology());
		for (Iterator iter = hostedByUnitUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor hostedUnitDescriptor = (UnitDescriptor) iter.next();
			Unit hostee = hostedUnitDescriptor.getUnitValue();
			if (hostee == null) {
				continue;
			}

			if (hostee.isConfigurationUnit()) {
				configUnits.add(hostee);
				List children = getHostedConfigurationUnits(hostee);
				configUnits.addAll(children);
			}
		}

		return configUnits;
	}

	/**
	 * Recursively retrieve all of the configuration units that can be hosted by a unit.
	 * 
	 * @param unit
	 *           host
	 * @return list of possible configuration units
	 */
	public static List getPossibleConfigurationUnits(Unit unit) {
		List configUnits = new ArrayList();

		// TODO implement
		return configUnits;
	}

	/**
	 * Convert list of link descriptors in to an array
	 * 
	 * @param collection
	 * @return array created from collection of link descriptors
	 */
	public static LinkDescriptor[] asArray(Collection collection) {
		LinkDescriptor[] array = new LinkDescriptor[collection.size()];
		int index = 0;
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			array[index++] = (LinkDescriptor) iter.next();
		}
		return array;
	}
}
