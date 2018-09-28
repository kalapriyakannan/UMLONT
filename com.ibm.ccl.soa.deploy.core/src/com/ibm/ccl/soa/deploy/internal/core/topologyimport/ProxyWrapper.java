/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Abstract supertype of proxifying wrappers around objects.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public abstract class ProxyWrapper {

	/** The proxy cache. */
	protected final IProxyCacheService cache;

	/** The import declaration. */
	protected final Import importDcl;

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
	protected ProxyWrapper(IProxyCacheService cache, Import importDcl) {
		assert cache != null;
		assert importDcl != null;
		this.cache = cache;
		this.importDcl = importDcl;
	}

	/**
	 * Proxifies the value parameter.
	 * 
	 * @param value
	 *           the value to be proxified.
	 * @return the proxified value.
	 */
	protected Object proxify(Object value) {
		if (value == null) {
			return null;
		}
		return cache.proxify(value, importDcl);
	}

	/**
	 * Given a proxified value, returns its source object.
	 * 
	 * @param value
	 *           a potentially proxied value.
	 * @return if value has been proxified, then the source value, else the value itself.
	 */
	protected Object deproxify(Object value) {
		if (value == null) {
			return null;
		}
		if (!Proxy.isProxyClass(value.getClass())) {
			return value;
		}
		InvocationHandler handler = Proxy.getInvocationHandler(value);
		if (handler instanceof IProxyConfiguration) {
			return ((IProxyConfiguration) handler).getSource();
		}
		// Not our proxy!
		return value;
	}

	/**
	 * Throws an {@link UnsupportedOperationException} with the appropriate message.
	 */
	protected void unsupported() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				DeployCoreMessages.Imported_topology_collection_immutable);
	}

	/**
	 * Returns the source object being wrapped.
	 * 
	 * @return the source object.
	 */
	public abstract Object getProxyWrapperSourceObject();
}
