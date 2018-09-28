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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

public abstract class InterimProxyFeatureMapBase extends InterimProxyFeatureMapBase2 implements
		FeatureMap {

	/**
	 * A shared unmodifiable empty list.
	 */
	public static final List EMPTY_LIST = Collections.EMPTY_LIST;

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
	public InterimProxyFeatureMapBase(IProxyCacheService cache, Import importDcl, Collection c) {
		super(cache, importDcl);
		assert c != null;
		collection = c;
	}

	/**
	 * @return the collection cast as an {@link EList}.
	 */
	protected final EList elist() {
		return (EList) collection;
	}

	/*
	 * @see org.eclipse.emf.common.util.EList#move(int, java.lang.Object)
	 */
	public void move(int newPosition, FeatureMap.Entry object) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.common.util.EList#move(int, int)
	 */
	public FeatureMap.Entry move(int newPosition, int oldPosition) {
		unsupported();
		return null;
	}

	/*
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(FeatureMap.Entry arg0) {
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
			result[i++] = iter.next();
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

	/**
	 * @return the source collection cast as a list.
	 */
	protected final List list() {
		return (List) collection;
	}

	/*
	 * @see java.util.List#add(int, E)
	 */
	public void add(int arg0, FeatureMap.Entry arg1) {
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
	public FeatureMap.Entry get(int index) {
		return (FeatureMap.Entry) proxify(list().get(index));
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
	public FeatureMap.Entry remove(int index) {
		unsupported();
		return null;
	}

	/*
	 * @see java.util.List#set(int, E)
	 */
	public FeatureMap.Entry set(int arg0, FeatureMap.Entry arg1) {
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
