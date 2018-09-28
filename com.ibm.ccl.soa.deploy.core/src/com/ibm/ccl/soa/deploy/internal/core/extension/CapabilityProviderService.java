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

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;

/**
 * Provides a concrete implementation of ICapabilityProviderService.
 * 
 * @since 1.0
 * 
 */
public class CapabilityProviderService implements ICapabilityProviderService {

	private static final CapabilityProvider[] NO_PROVIDERS = new CapabilityProvider[0];

	private final Map providers = new HashMap();

	public CapabilityProvider[] findEnabledCapabilityProvidersByInputOnly(Object anInput) {

		CapabilityProviderDescriptor[] descriptors = DomainManager.getInstance()
				.findEnabledCapabilityProvidersByInputOnly(anInput);

		if (descriptors.length == 0) {
			return NO_PROVIDERS;
		}

		CapabilityProvider[] providers = new CapabilityProvider[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getProvider(descriptors[i]);
		}
		return providers;

	}

	public CapabilityProvider[] findEnabledCapabilityProvidersByOutputOnly(Object anOutput) {
		CapabilityProviderDescriptor[] descriptors = DomainManager.getInstance()
				.findEnabledCapabilityProvidersByOutputOnly(anOutput);

		if (descriptors.length == 0) {
			return NO_PROVIDERS;
		}

		CapabilityProvider[] providers = new CapabilityProvider[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getProvider(descriptors[i]);
		}
		return providers;
	}

	public CapabilityProvider[] findEnabledCapabilityProvidersByInputAndOutput(Object anInput,
			Object anOutput) {
		CapabilityProviderDescriptor[] descriptors = DomainManager.getInstance()
				.findEnabledCapabilityProvidersByInputAndOutput(anInput, anOutput);

		if (descriptors.length == 0) {
			return NO_PROVIDERS;
		}

		CapabilityProvider[] providers = new CapabilityProvider[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			providers[i] = getProvider(descriptors[i]);
		}
		return providers;
	}

	private CapabilityProvider getProvider(CapabilityProviderDescriptor aDescriptor) {
		CapabilityProvider provider = (CapabilityProvider) providers.get(aDescriptor);
		if (provider != null) {
			return provider;
		}
		synchronized (providers) {
			provider = (CapabilityProvider) providers.get(aDescriptor);
			if (provider == null) {
				providers.put(aDescriptor, provider = aDescriptor.createCapabilityProvider());
			}
		}
		return provider;

	}

}
