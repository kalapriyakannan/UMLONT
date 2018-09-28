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
 * An iterator which filters the results of another iterator.
 * 
 * @param <E>
 *           the element types returned by the wrapped iterator.
 * @param <FE>
 *           the element types returned by the filter (a subtype of <E>)
 * 
 * @see IObjectFilter
 * 
 * @version $Revision: 1.5 $ ; $Date: 2007/07/19 18:21:16 $
 * @author Alexander V. Konstantinou (avk@us.ibm.com)
 */
public final class FilterIterator<E, FE> implements Iterator<FE> {

	/** The wrapped iterator. */
	private final Iterator<E> iterator;

	/** Filter used to accept/reject wrapped iterator elements. */
	private final IObjectFilter filter;

	/** Cached next value. */
	private FE nextValue = null;

	/**
	 * True if the nextValue has been set (needed since null can be a valid next value).
	 */
	private boolean isNextSet = false;

	/**
	 * Construct an iterator which filters the values returned by the collection iterator.
	 * 
	 * @param c
	 *           a collection whose elements will be iterated.
	 * @param filter
	 *           used to decide which values returned by the <code>iter</code> parameter should be
	 *           used.
	 */
	public FilterIterator(Collection<E> c, IObjectFilter filter) {
		this(c.iterator(), filter);
	}

	/**
	 * Construct an iterator which filters the values returned by another iterator.
	 * 
	 * @param iter
	 *           the iterator whose values will be filtered.
	 * @param filter
	 *           used to decide which values returned by the <code>iter</code> parameter should be
	 *           used.
	 */
	public FilterIterator(Iterator<E> iter, IObjectFilter filter) {
		assert iter != null;
		assert filter != null;
		this.iterator = iter;
		this.filter = filter;
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (isNextSet) {
			return true;
		}

		while (iterator.hasNext()) {
			Object nextValueCandidate = iterator.next();
			if (filter.accept(nextValueCandidate)) {
				nextValue = (FE) nextValueCandidate;
				isNextSet = true;
				return true;
			}
		}
		return false;
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public FE next() {
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
		iterator.remove();
	}
}
