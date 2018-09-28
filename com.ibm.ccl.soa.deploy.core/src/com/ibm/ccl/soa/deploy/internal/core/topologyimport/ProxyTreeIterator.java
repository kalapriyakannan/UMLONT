/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import org.eclipse.emf.common.util.TreeIterator;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps an {@link TreeIterator} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyTreeIterator extends ProxyIterator implements TreeIterator {

	/**
	 * Construct a proxifying wrapper over an iterator.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param iterator
	 *           the wrapped tree iterator.
	 */
	public ProxyTreeIterator(IProxyCacheService cache, Import importDcl, TreeIterator iterator) {
		super(cache, importDcl, iterator);
	}

	/**
	 * @return the iterator cast as a tree iterator.
	 */
	public TreeIterator treeIterator() {
		return (TreeIterator) iterator;
	}

	/*
	 * @see org.eclipse.emf.common.util.TreeIterator#prune()
	 */
	public void prune() {
		treeIterator().prune();
	}
}
