/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.handler;

import java.net.URL;

/**
 * This class provides common convenient methods for handler implementations.
 */
public abstract class AbstractHandler {

	private String name = null;
	private String description = null;
	private URL smallIcon = null;
	private URL largeIcon = null;

	/**
	 * @param aName
	 * @param aDescription
	 * @param aSmallIcon
	 * @param aLargeIcon
	 */
	final public void initialize(String aName, String aDescription, URL aSmallIcon, URL aLargeIcon) {
		name = aName;
		description = aDescription;
		smallIcon = aSmallIcon;
		largeIcon = aLargeIcon;
	}

	/**
	 * Returns a name for the component, reference, service, or interface kind. This string is
	 * intended to be suitable for display to an end user.
	 * 
	 * @return the name of the implementation kind of a component, or the binding kind of an external
	 *         service or entry point, or the interface kind of an SCA interface.
	 */
	final public String getName() {
		return name;
	}

	/**
	 * Returns text that describes the component, reference, service, or interface kind. This string
	 * is intended to be suitable for display to an end user.
	 * 
	 * @return the description for the implementation kind of a component, or the binding kind of an
	 *         external service or entry point, or the interface kind of an SCA interface
	 */
	final public String getDescription() {
		return description;
	}

	/**
	 * Returns the URL for the small icon resource thet represents the corresponding component,
	 * service, reference, or interface kind. The image is intended to be suitable for display to an
	 * end user.
	 * 
	 * @return URL for icon resource
	 */
	final public URL getSmallIcon() {
		return smallIcon;
	}

	/**
	 * Returns the URL for the large icon resource thet represents the corresponding component,
	 * service, reference, or interface kind. The image is intended to be suitable for display to an
	 * end user.
	 * 
	 * @return URL for icon resource
	 */
	final public URL getLargeIcon() {
		return largeIcon;
	}

	/**
	 * @param object
	 * @return a string that combines all property values for this object
	 */
	abstract public String getPropertyLabel(Object object);
}
