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

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.UnitAmplifier;
import com.ibm.ccl.soa.deploy.core.extension.IUnitAmplifierService;

/**
 * Provides a concrete implementation of IUnitDiscovererService.
 * 
 * @since 1.0
 * 
 */
public class UnitAmplifierService implements IUnitAmplifierService {

	private static final UnitAmplifier[] NO_AMPLIFIERS = new UnitAmplifier[0];

	private final Map amplifiers = new HashMap();

	public UnitAmplifier[] findEnabledTopologyUnitAmplifiersByInputOnly(Object anInput) {

		UnitAmplifierDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitAmplifiersByInputOnly(anInput);

		if (descriptors.length == 0) {
			return NO_AMPLIFIERS;
		}

		UnitAmplifier[] amplifiers = new UnitAmplifier[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			amplifiers[i] = getAmplifier(descriptors[i]);
		}
		return amplifiers;

	}

	/**
	 * @param anOutput
	 * @return UnitAmplifier
	 */
	public UnitAmplifier[] findEnabledTopologyUnitAmplifiersByOutputOnly(Object anOutput) {
		UnitAmplifierDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitAmplifiersByOutputOnly(anOutput);

		if (descriptors.length == 0) {
			return NO_AMPLIFIERS;
		}

		UnitAmplifier[] providers = new UnitAmplifier[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getAmplifier(descriptors[i]);
		}
		return providers;
	}

	/**
	 * @param anInput
	 * @param anOutput
	 * @return UnitAmplifier
	 */
	public UnitAmplifier[] findEnabledTopologyUnitAmplifiersByInputAndOutput(Object anInput,
			Object anOutput) {
		UnitAmplifierDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitAmplifiersByInputAndOutput(anInput, anOutput);

		if (descriptors.length == 0) {
			return NO_AMPLIFIERS;
		}

		UnitAmplifier[] providers = new UnitAmplifier[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getAmplifier(descriptors[i]);
		}
		return providers;
	}

	private UnitAmplifier getAmplifier(UnitAmplifierDescriptor aDescriptor) {
		UnitAmplifier amplifier = (UnitAmplifier) amplifiers.get(aDescriptor);
		if (amplifier != null) {
			return amplifier;
		}
		synchronized (amplifiers) {
			amplifier = (UnitAmplifier) amplifiers.get(aDescriptor);
			if (amplifier == null) {
				amplifiers.put(aDescriptor, amplifier = aDescriptor.createUnitAmplifier());
			}
		}
		return amplifier;

	}

}
