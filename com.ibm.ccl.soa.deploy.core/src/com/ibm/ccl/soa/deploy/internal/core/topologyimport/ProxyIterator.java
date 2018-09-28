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
import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps an {@link Iterator} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyIterator extends ProxyWrapper implements Iterator {

	/** The wrapped iterator. */
	protected final Iterator iterator;

	/** An empty iterator. */
	public final static Iterator EMPTY_ITERATOR = Collections.EMPTY_LIST.iterator();

	/**
	 * Construct a proxifying wrapper over an iterator.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param iterator
	 *           the wrapped iterator.
	 */
	public ProxyIterator(IProxyCacheService cache, Import importDcl, Iterator iterator) {
		super(cache, importDcl);
		assert iterator != null;
		this.iterator = iterator;
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return iterator.hasNext();
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		return proxify(iterator.next());
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		unsupported();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyWrapper#getProxyWrapperSourceObject()
	 */
	public Object getProxyWrapperSourceObject() {
		return iterator;
	}
}
