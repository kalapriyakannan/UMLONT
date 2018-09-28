/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * Return appropriate capabilites and requirements for a given input object.
 * 
 * <p>
 * Please refer to the extension point documentation for
 * <b>com.ibm.ccl.soa.deploy.core.domains/capabilityProvider</b> for more information.
 * </p>
 * 
 * 
 * @since 1.0
 * 
 */
public abstract class CapabilityProvider extends ChangeProvider {

	/**
	 * An empty array of objects to return instead of <b>null</b>.
	 */
	public static final Object[] NO_OBJS = new Object[0];

	/**
	 * An empty array of capabilities to return instead of <b>null</b>.
	 */
	public static final Object[] NO_CAPS = new Capability[0];

	/**
	 * An empty array of requirements to return instead of <b>null</b>.
	 */
	public static final Object[] NO_REQS = new Requirement[0];

	/**
	 * Given an input object (from a view or otherwise indicated by the user), return an array of
	 * requirements that should be introduced.
	 * 
	 * @param anObject
	 *           An element that matches the enablement specified by the extension corresponding to
	 *           this provider.
	 * @return An array of requirements By default this method returns an empty {@link Requirement}
	 *         array.
	 */
	public Object[] resolveRequirements(Object anObject) {
		return NO_REQS;
	}

	/**
	 * <p>
	 * Given an input object (from a view or otherwise indicated by the user), return an array of
	 * requirements that should be introduced.
	 * </p>
	 * 
	 * <p>
	 * Clients can override this method if they require information form aUnit. The client should NOT
	 * update or change aUnit in any way. This method will invoke
	 * {@link CapabilityProvider#resolveRequirements(Object)} by default.
	 * </p>
	 * 
	 * @param anObject
	 *           An element that matches the enablement specified by the extension corresponding to
	 *           this provider.
	 * @param aUnit
	 *           The {@link Unit} that the requirements will be added.
	 * @return An array of requirements By default this method returns an empty {@link Requirement}
	 *         array.
	 */
	public Object[] resolveRequirements(Object anObject, Unit aUnit) {
		return resolveRequirements(anObject);
	}

	/**
	 * Given an input object (from a view or otherwise indicated by the user), return an array of
	 * capabilities that should be introduced.
	 * 
	 * @param anObject
	 *           An element that matches the enablement specified by the extension corresponding to
	 *           this provider.
	 * @return An array of capabilites By default this method returns an empty {@link Capability}
	 *         array.
	 */
	public Object[] resolveCapabilities(Object anObject) {
		return NO_CAPS;
	}

	/**
	 * <p>
	 * Given an input object (from a view or otherwise indicated by the user), return an array of
	 * capabilities that should be introduced.
	 * </p>
	 * 
	 * <p>
	 * Clients can override this method if they require information form aUnit. The client should NOT
	 * update or change aUnit in any way. This method will invoke
	 * {@link CapabilityProvider#resolveCapabilities(Object)} by default.
	 * </p>
	 * 
	 * 
	 * @param anObject
	 *           An element that matches the enablement specified by the extension corresponding to
	 *           this provider.
	 * @param aUnit
	 *           The {@link Unit} that the capabilities will be added.
	 * @return An array of capabilites
	 */
	public Object[] resolveCapabilities(Object anObject, Unit aUnit) {
		return resolveCapabilities(anObject);
	}

}
