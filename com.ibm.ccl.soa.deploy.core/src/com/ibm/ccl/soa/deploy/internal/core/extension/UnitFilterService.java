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

import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.extension.IUnitFilterService;

/**
 * Provides a concrete implementation of IUnitFilterService.
 * 
 * @since 1.0
 * 
 */
public class UnitFilterService implements IUnitFilterService {

	private static final UnitFilter[] NO_FILTERS = new UnitFilter[0];

	private final Map filters = new HashMap();

	public UnitFilter[] findEnabledTopologyUnitFiltersByInputOnly(Object anInput) {

		UnitFilterDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitFiltersByInputOnly(anInput);

		if (descriptors.length == 0)
			return NO_FILTERS;

		UnitFilter[] filters = new UnitFilter[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			filters[i] = getFilter(descriptors[i]);
		}
		return filters;

	}

	/**
	 * @param anOutput
	 * @return UnitFilter
	 */
	public UnitFilter[] findEnabledTopologyUnitFiltersByOutputOnly(Object anOutput) {
		UnitFilterDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitFiltersByOutputOnly(anOutput);

		if (descriptors.length == 0)
			return NO_FILTERS;

		UnitFilter[] providers = new UnitFilter[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getFilter(descriptors[i]);
		}
		return providers;
	}

	/**
	 * @param anInput
	 * @param anOutput
	 * @return UnitFilter
	 */
	public UnitFilter[] findEnabledTopologyUnitFiltersByInputAndOutput(Object anInput,
			Object anOutput) {
		UnitFilterDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitFiltersByInputAndOutput(anInput, anOutput);

		if (descriptors.length == 0)
			return NO_FILTERS;

		UnitFilter[] providers = new UnitFilter[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getFilter(descriptors[i]);
		}
		return providers;
	}

	private UnitFilter getFilter(UnitFilterDescriptor aDescriptor) {
		UnitFilter filter = (UnitFilter) filters.get(aDescriptor);
		if (filter != null)
			return filter;
		synchronized (filters) {
			filter = (UnitFilter) filters.get(aDescriptor);
			if (filter == null)
				filters.put(aDescriptor, filter = aDescriptor.createUnitFilter());
		}
		return filter;

	}

}
