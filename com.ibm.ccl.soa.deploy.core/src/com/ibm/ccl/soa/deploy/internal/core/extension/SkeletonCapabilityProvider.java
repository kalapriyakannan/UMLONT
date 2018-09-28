/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;

/**
 * Provides a default implementation of {@link CapabilityProvider} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.domains</b>.
 * 
 * @since 1.0
 * @see CapabilityProvider
 * 
 */
public class SkeletonCapabilityProvider extends CapabilityProvider {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonCapabilityProvider INSTANCE = new SkeletonCapabilityProvider();

	private SkeletonCapabilityProvider() {
	}

	public Object[] resolveCapabilities(Object inputObject) {
		return NO_CAPS;
	}

	public Object[] resolveRequirements(Object inputObject) {
		return NO_REQS;
	}

}
