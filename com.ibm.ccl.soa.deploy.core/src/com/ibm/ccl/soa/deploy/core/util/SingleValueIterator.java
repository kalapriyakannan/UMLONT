/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over a single value.
 */
public final class SingleValueIterator implements Iterator {

	/** The value (null if returned). */
	private Object value;

	/**
	 * Construct an iterator over a single value.
	 * 
	 * @param value
	 *           the non-null value returned.
	 */
	public SingleValueIterator(Object value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return value != null;
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		if (value == null) {
			throw new NoSuchElementException();
		}
		Object temp = value;
		value = null;
		return temp;
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
