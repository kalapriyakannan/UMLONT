/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps a {@link Collection} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyCollection extends ProxyWrapper implements Collection {

	/** The wrapped list. */
	protected final Collection collection;

	/** An empty object array. */
	public final static Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * Construct a proxifying wrapper over a {@link Collection}.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param c
	 *           the wrapped collection.
	 */
	public ProxyCollection(IProxyCacheService cache, Import importDcl, Collection c) {
		super(cache, importDcl);
		assert c != null;
		collection = c;
	}

	/*
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Object arg0) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection arg0) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		unsupported();
	}

	/*
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return collection.contains(deproxify(o));
	}

	/*
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection arg) {
		for (Iterator iter = arg.iterator(); iter.hasNext();) {
			if (!contains(iter.next())) {
				return false;
			}
		}
		return true;
	}

	/*
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	/*
	 * @see java.util.Collection#iterator()
	 */
	public Iterator iterator() {
		if (collection.size() == 0) {
			return ProxyIterator.EMPTY_ITERATOR;
		}
		return new ProxyIterator(cache, importDcl, collection.iterator());
	}

	/*
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection arg0) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection arg0) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.Collection#size()
	 */
	public int size() {
		return collection.size();
	}

	/*
	 * @see java.util.Collection#toArray()
	 */
	public Object[] toArray() {
		if (collection.size() == 0) {
			return EMPTY_ARRAY;
		}
		Object[] array = new Object[collection.size()];
		int i = 0;
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			array[i++] = proxify(iter.next());
		}
		return array;
	}

	/*
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 */
	public Object[] toArray(Object[] arg) {
		if (arg == null) {
			return toArray();
		}
		Object[] result;
		if (collection.size() > arg.length) {
			result = (Object[]) Array
					.newInstance(arg.getClass().getComponentType(), collection.size());
		} else {
			result = arg;
		}
		int i = 0;
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			result[i++] = proxify(iter.next());
		}
		if (result.length > i + 1) {
			result[i] = null;
		}
		return result;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyWrapper#getProxyWrapperSourceObject()
	 */
	public Object getProxyWrapperSourceObject() {
		return collection;
	}
}
