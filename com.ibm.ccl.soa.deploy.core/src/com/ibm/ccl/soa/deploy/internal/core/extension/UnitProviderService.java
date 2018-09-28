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

import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;

/**
 * Provides a concrete implementation of IUnitProviderService.
 * 
 * @since 1.0
 * 
 */
public class UnitProviderService implements IUnitProviderService {

	private static final UnitProvider[] NO_PROVIDERS = new UnitProvider[0];

	private final Map providers = new HashMap();

	public UnitProvider[] findEnabledProvidersByInputOnly(Object anInput) {
		return findEnabledProvidersByInputOnly(anInput, null);
	}

	public UnitProvider[] findEnabledProvidersByOutputOnly(Object anOutput) {
		return findEnabledProvidersByOutputOnly(anOutput, null);
	}

	public UnitProvider[] findEnabledProvidersByInputAndOutput(Object anInput, Object anOutput) {
		return findEnabledProvidersByInputAndOutput(anInput, anOutput, null);
	}

	public UnitProvider[] findEnabledProvidersByInputOnly(Object anInput, String decoratorSemantic) {

		UnitProviderDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitProvidersByInputOnly(anInput, decoratorSemantic);

		if (descriptors.length == 0) {
			return NO_PROVIDERS;
		}

		UnitProvider[] providers = new UnitProvider[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getProvider(descriptors[i]);
		}
		return providers;

	}

	public UnitProvider[] findEnabledProvidersByOutputOnly(Object anOutput, String decoratorSemantic) {
		UnitProviderDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitProvidersByOutputOnly(anOutput, decoratorSemantic);

		if (descriptors.length == 0) {
			return NO_PROVIDERS;
		}

		UnitProvider[] providers = new UnitProvider[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getProvider(descriptors[i]);
		}
		return providers;
	}

	public UnitProvider[] findEnabledProvidersByInputAndOutput(Object anInput, Object anOutput,
			String decoratorSemantic) {
		UnitProviderDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitProvidersByInputAndOutput(anInput, anOutput, decoratorSemantic);

		if (descriptors.length == 0) {
			return NO_PROVIDERS;
		}

		UnitProvider[] providers = new UnitProvider[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getProvider(descriptors[i]);
		}
		return providers;
	}

	private UnitProvider getProvider(UnitProviderDescriptor aDescriptor) {
		UnitProvider provider = (UnitProvider) providers.get(aDescriptor);
		if (provider != null) {
			return provider;
		}
		synchronized (providers) {
			provider = (UnitProvider) providers.get(aDescriptor);
			if (provider == null) {
				providers.put(aDescriptor, provider = aDescriptor.createUnitProvider());
			}
		}
		return provider;

	}

}
