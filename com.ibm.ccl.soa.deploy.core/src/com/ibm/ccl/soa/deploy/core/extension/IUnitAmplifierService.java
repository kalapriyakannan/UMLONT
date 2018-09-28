/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitAmplifier</b>
 * extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 */
public interface IUnitAmplifierService {

	/**
	 * Return an array of providers that can potentially discover {@link TopologyUnitStub}s for the
	 * given input element.
	 * 
	 * @param anInput
	 *           input enablement object
	 * @return An array of Amplifiers that can potentially provide {@link TopologyUnitStub}s for the
	 *         given input element.
	 */
	UnitAmplifier[] findEnabledTopologyUnitAmplifiersByInputOnly(Object anInput);

	/**
	 * Return an array of providers that can potentially discover {@link TopologyUnitStub}s for the
	 * given output element.
	 * 
	 * @param anOutput
	 *           output enablement object
	 * @return An array of Amplifiers that can potentially provide {@link TopologyUnitStub}s for the
	 *         given output element.
	 */
	UnitAmplifier[] findEnabledTopologyUnitAmplifiersByOutputOnly(Object anOutput);

	/**
	 * Return an array of providers that can potentially discover {@link TopologyUnitStub}s for the
	 * given input and output element.
	 * 
	 * @param anInput
	 *           input enablement object
	 * 
	 * @param anOutput
	 *           output enablement object
	 * 
	 * @return An array of Amplifiers that can potentially provide {@link TopologyUnitStub}s for the
	 *         given input and output element.
	 */

	UnitAmplifier[] findEnabledTopologyUnitAmplifiersByInputAndOutput(Object anInput, Object anOutput);

}
