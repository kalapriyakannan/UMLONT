/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.Collections;
import java.util.ListIterator;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps a {@link ListIterator} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyListIterator extends ProxyIterator implements ListIterator {

	/** An empty iterator. */
	public final static ListIterator EMPTY_LIST_ITERATOR = Collections.EMPTY_LIST.listIterator();

	/**
	 * Construct a proxifying wrapper over an iterator.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param iterator
	 *           the wrapped list iterator.
	 */
	public ProxyListIterator(IProxyCacheService cache, Import importDcl, ListIterator iterator) {
		super(cache, importDcl, iterator);
	}

	/**
	 * @return the iterator cast as a list iterator.
	 */
	protected final ListIterator listIterator() {
		return (ListIterator) iterator;
	}

	/*
	 * @see java.util.ListIterator#add(E)
	 */
	public void add(Object arg0) {
		unsupported();
	}

	/*
	 * @see java.util.ListIterator#hasPrevious()
	 */
	public boolean hasPrevious() {
		return listIterator().hasPrevious();
	}

	/*
	 * @see java.util.ListIterator#nextIndex()
	 */
	public int nextIndex() {
		return listIterator().nextIndex();
	}

	/*
	 * @see java.util.ListIterator#previous()
	 */
	public Object previous() {
		return proxify(listIterator().previous());
	}

	/*
	 * @see java.util.ListIterator#previousIndex()
	 */
	public int previousIndex() {
		return listIterator().previousIndex();
	}

	/*
	 * @see java.util.ListIterator#set(E)
	 */
	public void set(Object arg0) {
		unsupported();
	}
}
