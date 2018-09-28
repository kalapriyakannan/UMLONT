/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

/**
 * A generic object adaptation interfac.
 */
public interface IObjectAdapter {

	/**
	 * Adapts an object.
	 * 
	 * @param object
	 *           the object to be adapted.
	 * @return the adapted object, or null if the value cannot be adapted.
	 */
	public Object adapt(Object object);
}
