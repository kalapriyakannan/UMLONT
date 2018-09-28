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
 * Provides a wrapper for elements from the extensions in <b>com.ibm.ccl.soa.deploy.saf</b> plugin.
 * 
 */
public interface ICommonDescriptor {

	/**
	 * @return The value of the name attribute from the extension. (Already externalized and ready
	 *         for display).
	 */
	String getName();

	/**
	 * Provides access to the configuration element for subclasses.
	 * 
	 * @return the configuration element used to construct this descriptor.
	 */
	URL getLargeIcon();

	/**
	 * Provides access to the configuration element for subclasses.
	 * 
	 * @return the configuration element used to construct this descriptor.
	 */
	URL getSmallIcon();

	/**
	 * Provides access to the configuration element for subclasses.
	 * 
	 * @return the configuration element used to construct this descriptor.
	 */
	String getDescription();

}