/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.core.extension.IUnitDiscovererService;

/**
 * Provides a concrete implementation of IUnitDiscovererService.
 * 
 * @since 1.0
 * 
 */
public class UnitDiscovererService implements IUnitDiscovererService {

	private static final UnitDiscoverer[] NO_DISCOVERERS = new UnitDiscoverer[0];

	private final Map discoverers = new HashMap();

	public UnitDiscoverer[] findEnabledTopologyUnitDiscoverersByInputOnly(Object anInput) {

		UnitDiscovererDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitDiscoverersByInputOnly(anInput);

		if (descriptors.length == 0)
			return NO_DISCOVERERS;

		UnitDiscoverer[] discoverers = new UnitDiscoverer[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			discoverers[i] = getDiscoverer(descriptors[i]);
		}
		return discoverers;

	}

	/**
	 * @param anOutput
	 * @return UnitDiscoverer
	 */
	public UnitDiscoverer[] findEnabledTopologyUnitDiscoverersByOutputOnly(Object anOutput) {
		UnitDiscovererDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitDiscoverersByOutputOnly(anOutput);

		if (descriptors.length == 0)
			return NO_DISCOVERERS;

		UnitDiscoverer[] providers = new UnitDiscoverer[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getDiscoverer(descriptors[i]);
		}
		return providers;
	}

	/**
	 * @param anInput
	 * @param anOutput
	 * @return UnitDiscoverer
	 */
	public UnitDiscoverer[] findEnabledTopologyUnitDiscoverersByInputAndOutput(Object anInput,
			Object anOutput) {
		UnitDiscovererDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitDiscoverersByInputAndOutput(anInput, anOutput);

		if (descriptors.length == 0)
			return NO_DISCOVERERS;

		UnitDiscoverer[] providers = new UnitDiscoverer[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getDiscoverer(descriptors[i]);
		}
		return providers;
	}

	private UnitDiscoverer getDiscoverer(UnitDiscovererDescriptor aDescriptor) {
		UnitDiscoverer discoverer = (UnitDiscoverer) discoverers.get(aDescriptor);
		if (discoverer != null)
			return discoverer;
		synchronized (discoverers) {
			discoverer = (UnitDiscoverer) discoverers.get(aDescriptor);
			if (discoverer == null)
				discoverers.put(aDescriptor, discoverer = aDescriptor.createUnitDiscoverer());
		}
		return discoverer;

	}

}
