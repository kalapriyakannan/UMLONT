/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;

/**
 * Adapts the values returned by another iterator.
 */
public final class AdapterIterator implements Iterator {

	private final Iterator iter;

	private final IObjectAdapter adapter;

	/**
	 * Adapts the results of the iterator argument.
	 * 
	 * @param iter
	 *           the source values.
	 * @param adapter
	 *           used to create adapted values.
	 */
	public AdapterIterator(Iterator iter, IObjectAdapter adapter) {
		assert iter != null;
		assert adapter != null;
		this.iter = iter;
		this.adapter = adapter;
	}

	public boolean hasNext() {
		return iter.hasNext();
	}

	public Object next() {
		return adapter.adapt(iter.next());
	}

	public void remove() {
		iter.remove();
	}
}
