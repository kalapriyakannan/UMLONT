/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitFilter;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitFilter</b>
 * extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 */
public interface IUnitFilterService {
	/**
	 * Return an array of providers that can potentially discover {@link TopologyUnitStub}s for the
	 * given input element.
	 * 
	 * @param anInput
	 *           input enablement object
	 * @return An array of filters that can potentially provide {@link TopologyUnitStub}s for the
	 *         given input element.
	 */
	UnitFilter[] findEnabledTopologyUnitFiltersByInputOnly(Object anInput);

	/**
	 * Return an array of providers that can potentially discover {@link TopologyUnitStub}s for the
	 * given output element.
	 * 
	 * @param anOutput
	 *           output enablement object
	 * @return An array of filters that can potentially provide {@link TopologyUnitStub}s for the
	 *         given output element.
	 */
	UnitFilter[] findEnabledTopologyUnitFiltersByOutputOnly(Object anOutput);

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
	 * @return An array of filters that can potentially provide {@link TopologyUnitStub}s for the
	 *         given input and output element.
	 */

	UnitFilter[] findEnabledTopologyUnitFiltersByInputAndOutput(Object anInput, Object anOutput);

}
