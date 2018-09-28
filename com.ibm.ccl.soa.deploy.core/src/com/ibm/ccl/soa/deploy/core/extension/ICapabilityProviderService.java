/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.domains/capabilityProvider</b>
 * extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 */
public interface ICapabilityProviderService {

	/**
	 * Return an array of providers that can potentially capability provider {@link TopologyUnitStub}s
	 * for the given input element.
	 * 
	 * @param anInput
	 *           input enablement object
	 * @return An array of capability providerss that can potentially provide
	 *         {@link TopologyUnitStub}s for the given input element.
	 */
	CapabilityProvider[] findEnabledCapabilityProvidersByInputOnly(Object anInput);

	/**
	 * Return an array of providers that can potentially capability provider {@link TopologyUnitStub}s
	 * for the given output element.
	 * 
	 * @param anOutput
	 *           output enablement object
	 * @return An array of capability providerss that can potentially provide
	 *         {@link TopologyUnitStub}s for the given output element.
	 */
	CapabilityProvider[] findEnabledCapabilityProvidersByOutputOnly(Object anOutput);

	/**
	 * Return an array of providers that can potentially capability provider {@link TopologyUnitStub}s
	 * for the given input and output element.
	 * 
	 * @param anInput
	 *           input enablement object
	 * 
	 * @param anOutput
	 *           output enablement object
	 * 
	 * @return An array of capability providerss that can potentially provide
	 *         {@link TopologyUnitStub}s for the given input and output element.
	 */

	CapabilityProvider[] findEnabledCapabilityProvidersByInputAndOutput(Object anInput,
			Object anOutput);

}
