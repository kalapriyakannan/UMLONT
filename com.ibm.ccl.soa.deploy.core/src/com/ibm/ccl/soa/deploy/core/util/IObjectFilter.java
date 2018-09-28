/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

/**
 * Implemented by objects which decide whether to accept or reject an object.
 * 
 * @param <T>
 *           the type of the objects accepted by the filter.
 * 
 * @see FilterIterator
 */
public interface IObjectFilter<T> {

	/**
	 * Returns true if the value should be accepted, false if it should be rejected.
	 * 
	 * @param value
	 *           a value to be tested for acceptance.
	 * @return true if the value should be accepted, false if rejected.
	 */
	boolean accept(T value);
}
