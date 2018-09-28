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
import com.ibm.ccl.soa.deploy.core.UnitProvider;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitProvider</b>
 * extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 */
public interface IUnitProviderService {

	/**
	 * Return an array of providers that can potentially provide {@link TopologyUnitStub}s for the
	 * given input element.
	 * 
	 * @param anInput
	 *           An element selected by the framework or the user (via the navigator view for
	 *           instance).
	 * @return An array of providers that can potentially provide {@link TopologyUnitStub}s for the
	 *         given input element.
	 */
	UnitProvider[] findEnabledProvidersByInputOnly(Object anInput);

	/**
	 * Determine the set of unit providers that can potentially provide units of the given type.
	 * 
	 * <mde> This signature may require a little more consideration. </mde>
	 * 
	 * @param anOutput
	 *           An object representing the desired type (such as an Application unit or a Server
	 *           unit).
	 * @return The set of unit providers that can potentially provide units of the given type.
	 */
	UnitProvider[] findEnabledProvidersByOutputOnly(Object anOutput);

	/**
	 * Determine the set of unit providers that can potentially provide Objects of the given type and
	 * consume objects of a specific type.
	 * 
	 * <mde> This signature may require a little more consideration. </mde>
	 * 
	 * @param anInput
	 *           An object representing the desired input type.
	 * @param anOutput
	 *           An object representing the desired type (such as an Application unit or a Server
	 *           unit).
	 * @return The set of unit providers that can potentially provide units of the given type.
	 */
	UnitProvider[] findEnabledProvidersByInputAndOutput(Object anInput, Object anOutput);

	/**
	 * Return an array of providers that can potentially provide {@link TopologyUnitStub}s for the
	 * given input element.
	 * 
	 * @param anInput
	 *           An element selected by the framework or the user (via the navigator view for
	 *           instance).
	 * @param decoratorSemantic
	 *           the decorator semantic to be used to restrict the result
	 * @return An array of providers that can potentially provide {@link TopologyUnitStub}s for the
	 *         given input element.
	 */
	UnitProvider[] findEnabledProvidersByInputOnly(Object anInput, String decoratorSemantic);

	/**
	 * Determine the set of unit providers that can potentially provide units of the given type.
	 * 
	 * <mde> This signature may require a little more consideration. </mde>
	 * 
	 * @param anOutput
	 *           An object representing the desired type (such as an Application unit or a Server
	 *           unit).
	 * @param decoratorSemantic
	 *           the decorator semantic to be used to restrict the result
	 * @return The set of unit providers that can potentially provide units of the given type.
	 */
	UnitProvider[] findEnabledProvidersByOutputOnly(Object anOutput, String decoratorSemantic);

	/**
	 * Determine the set of unit providers that can potentially provide Objects of the given type and
	 * consume objects of a specific type.
	 * 
	 * <mde> This signature may require a little more consideration. </mde>
	 * 
	 * @param anInput
	 *           An object representing the desired input type.
	 * @param anOutput
	 *           An object representing the desired type (such as an Application unit or a Server
	 *           unit).
	 * @param decoratorSemantic
	 *           the decorator semantic to be used to restrict the result
	 * @return The set of unit providers that can potentially provide units of the given type.
	 */
	UnitProvider[] findEnabledProvidersByInputAndOutput(Object anInput, Object anOutput,
			String decoratorSemantic);

}
