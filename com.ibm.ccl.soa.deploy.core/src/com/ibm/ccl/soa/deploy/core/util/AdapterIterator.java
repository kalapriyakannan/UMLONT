/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator which adapts the results of another iterator.
 * <p>
 * Null values returned by {@link IObjectAdapter#adapt(Object)} are not iterated over.
 * 
 * @see IObjectAdapter
 * 
 * @version $Revision: 1.3 $ ; $Date: 2007/07/19 18:21:16 $
 * @author Alexander V. Konstantinou (avk@us.ibm.com)
 */
public final class AdapterIterator implements Iterator {

	/** The wrapped iterator. */
	private final Iterator iterator;

	/** Adapter used to filter & adapt wrapped iterator elements. */
	private final IObjectAdapter adapter;

	/** Cached next value. */
	private Object nextValue = null;

	/**
	 * True if the nextValue has been set (needed since null can be a valid next value).
	 */
	private boolean isNextSet = false;

	/**
	 * Construct an iterator which filters the values returned by the collection iterator.
	 * <p>
	 * Filters null values.
	 * 
	 * @param collection
	 *           a collection whose elements will be iterated.
	 * @param adapter
	 *           used to adapt the values returned <code>collection</code> iterator.
	 */
	public AdapterIterator(Collection collection, IObjectAdapter adapter) {
		this(collection.iterator(), adapter);
	}

	/**
	 * Construct an iterator which filters the values returned by another iterator.
	 * <p>
	 * Filters null values.
	 * 
	 * @param iter
	 *           the iterator whose values will be adapted & filtered.
	 * @param adapter
	 *           used to adapt the values returned <code>iter</code> argument.
	 */
	public AdapterIterator(Iterator iter, IObjectAdapter adapter) {
		assert iter != null;
		assert adapter != null;
		this.iterator = iter;
		this.adapter = adapter;
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (isNextSet) {
			return true;
		}

		while (iterator.hasNext()) {
			nextValue = adapter.adapt(iterator.next());
			if (nextValue != null) {
				isNextSet = true;
				return true;
			}
		}
		return false;
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		if (hasNext()) {
			isNextSet = false;
			return nextValue;
		}
		throw new NoSuchElementException();
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
