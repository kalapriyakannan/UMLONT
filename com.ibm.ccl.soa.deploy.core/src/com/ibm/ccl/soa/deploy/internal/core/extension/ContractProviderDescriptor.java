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

import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IdentityContractProvider;

/**
 * 
 * Provides a handle to an extension which knows about a particular kind of contract.
 * 
 * @since 1.0
 * 
 */
public class ContractProviderDescriptor {

	private static final ContractProvider SKELETON = new IdentityContractProvider();

	private final Class<? extends ContractProvider> factory;

	private final String displayName;

	protected ContractProviderDescriptor(String displayName,
			Class<? extends ContractProvider> providerClass) {
		this.displayName = displayName;
		factory = providerClass;
	}

	/**
	 * Create an instance of the correct provider. This method will *not* cache the result of the
	 * call.
	 * 
	 * @return An instance of the correct ContractProvider of one that will configure the Topology
	 *         for an {@link IdentityContract}.
	 */
	public ContractProvider createProvider() {
		try {
			if (factory != null) {
				return factory.newInstance();
			}
		} catch (IllegalAccessException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (InstantiationException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}

		return SKELETON;
	}

	/**
	 * @return The contract provider for this descriptor.
	 */
	public Class<? extends ContractProvider> getFactory() {
		return factory;
	}

	public String getDisplayName() {
		return displayName;
	}
}
