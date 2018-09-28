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

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;

/**
 * A type delegate maintains information about delegating method handlers.
 * 
 * @since 1.0
 * @see DelegateSwitch
 */
public class TypeDelegate extends MethodHandler {

	/** The {@link List} class */
	protected static final Object LIST_CLASS = List.class;
	protected static final Class<?>[] NO_PARAMETERS = new Class[0];

	private final Map<Method, MethodHandler> handlers;

	/**
	 * Create a Type delegate.
	 * 
	 */
	public TypeDelegate() {
		handlers = Collections.emptyMap();
	}

	/**
	 * Create a Type delegate using the map of <java.lang.reflect.Method, MethodHandler> pairs.
	 * 
	 * @param methodHandlers
	 *           map of <java.lang.reflect.Method, MethodHandler> pairs.
	 */
	public TypeDelegate(Map<Method, MethodHandler> methodHandlers) {
		Assert.isNotNull(methodHandlers);
		handlers = methodHandlers;
	}

	/**
	 * Intercept the given method for the proxy and handle the execution appropriately.
	 * 
	 * @param config
	 *           A stateful configuration object that knows about the source object that is being
	 *           proxied as well as other augmented state.
	 * @param proxy
	 *           The proxy that received the method call originally.
	 * @param method
	 *           The method that was invoked on the proxy.
	 * @param args
	 *           The arguments that were passed into the method
	 * @return The object result from the invoked method or some other intercepted value (potentially
	 *         proxified results).
	 * @throws Throwable
	 *            If an error is encoutered during the execution of the method.
	 */
	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		MethodHandler handler = handlers.get(method);
		if (handler != null) {
			return handler.handle(config, proxy, method, args);
		}
		return super.handle(config, proxy, method, args);
	}

	protected boolean handles(Method method) {
		return handlers.keySet().contains(method);
	}

}
