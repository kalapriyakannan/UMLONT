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

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

public abstract class InterimProxyFeatureMapBase2 extends ProxyWrapper {

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
	public InterimProxyFeatureMapBase2(IProxyCacheService cache, Import importDcl) {
		super(cache, importDcl);
	}

	/*
	 * @see org.eclipse.emf.common.util.EList#move(int, java.lang.Object)
	 */
	public void move(int newPosition, Object object) {
		unsupported();
	}

	/*
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Object arg0) {
		unsupported();
		return false;
	}

	/*
	 * @see java.util.List#add(int, E)
	 */
	public void add(int arg0, Object arg1) {
		unsupported();
	}

	/*
	 * @see java.util.List#set(int, E)
	 */
	public Object set(int arg0, Object arg1) {
		unsupported();
		return null;
	}
}
