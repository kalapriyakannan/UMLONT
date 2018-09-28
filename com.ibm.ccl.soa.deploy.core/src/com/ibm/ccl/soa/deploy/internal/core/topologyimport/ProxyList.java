/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps a {@link List} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyList extends ProxyCollection implements List {

	/**
	 * A shared unmodifiable empty list.
	 */
	public static final List EMPTY_LIST = Collections.EMPTY_LIST;

	/**
	 * Construct a proxifying wrapper over a {@link List}.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param list
	 *           the wrapped list.
	 */
	public ProxyList(IProxyCacheService cache, Import importDcl, List list) {
		super(cache, importDcl, list);
	}

	/**
	 * @return the source collection cast as a list.
	 */
	protected final List list() {
		return (List) collection;
	}

	/*
	 * @see java.util.List#add(int, E)
	 */
	public void add(int arg0, Object arg1) {
		unsupported();
	}

	/*
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int arg0, Collection arg1) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.List#get(int)
	 */
	public Object get(int index) {
		return proxify(list().get(index));
	}

	/*
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return list().indexOf(deproxify(o));
	}

	/*
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return list().lastIndexOf(deproxify(o));
	}

	/*
	 * @see java.util.List#listIterator()
	 */
	public ListIterator listIterator() {
		if (collection.size() == 0) {
			return ProxyListIterator.EMPTY_LIST_ITERATOR;
		}
		return new ProxyListIterator(cache, importDcl, list().listIterator());
	}

	/*
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator listIterator(int index) {
		return new ProxyListIterator(cache, importDcl, list().listIterator(index));
	}

	/*
	 * @see java.util.List#remove(int)
	 */
	public Object remove(int index) {
		unsupported();
		return null;
	}

	/*
	 * @see java.util.List#set(int, E)
	 */
	public Object set(int arg0, Object arg1) {
		unsupported();
		return null;
	}

	/*
	 * @see java.util.List#subList(int, int)
	 */
	public List subList(int fromIndex, int toIndex) {
		return new ProxyList(cache, importDcl, subList(fromIndex, toIndex));
	}
}
