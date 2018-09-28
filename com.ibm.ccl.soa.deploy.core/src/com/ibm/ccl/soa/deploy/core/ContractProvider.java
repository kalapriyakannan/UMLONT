/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderDescriptor;

/**
 * Provides an instance of a subtype of {@link ConfigurationContract} for a given {@link Topology}.
 * 
 * @since 1.0
 * 
 */
public abstract class ContractProvider {

	private ContractProviderDescriptor descriptor;

	/**
	 * Create an instance of a subtype of {@link ConfigurationContract} for the given
	 * {@link Topology}. <b>Before returning</b>, this method should set the new Contract on the
	 * given Topology.
	 * 
	 * @param topology
	 *           The Topology being configured
	 */
	public abstract void installContract(Topology topology);

	protected final ContractProviderDescriptor getDescriptor() {
		return descriptor;
	}

	public final void setDescriptor(ContractProviderDescriptor descriptor) {
		this.descriptor = descriptor;
	}

}
