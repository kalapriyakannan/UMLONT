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
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * A delegate for the Object.class type.
 * 
 * @since 1.0
 * 
 */
public class ObjectDelegate extends TypeDelegate {

	private static final String HASH_CODE_FEATURE = "hashCode"; //$NON-NLS-1$
	/** The {@link Object#equals(Object)} method. */
	private static final Method EQUALS;
	/** The {@link Object#hashCode()} method. */
	private static final Method HASH_CODE;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;

		try {
			method = Object.class.getMethod("equals", new Class[] { Object.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EQUALS = method;
		try {
			method = Object.class.getMethod(HASH_CODE_FEATURE, NO_PARAMETERS);
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		HASH_CODE = method;

	}

	static {
		staticHandlers.put(EQUALS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				if (args[0] == null) {
					return Boolean.FALSE;
				}
				if (proxy == args[0]) {
					return Boolean.TRUE;
				}
				if (Proxy.isProxyClass(args[0].getClass())) {
					InvocationHandler handler = Proxy.getInvocationHandler(args[0]);
					if (handler instanceof IProxyConfiguration) {
						IProxyConfiguration oConfig = (IProxyConfiguration) handler;
						if (config.getFullyQualifiedPath().equals(oConfig.getFullyQualifiedPath())) {
//							resolve(config, oConfig);
							return Boolean.TRUE;
						} else {
							return Boolean.FALSE;
						}
					}
				}
				return method.invoke(config.getSource(), args);
			}

		});
		staticHandlers.put(HASH_CODE, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				DeployModelObject source = config.getSource();
				Object result = config.getService().retrieveResult(source, HASH_CODE_FEATURE);
				Integer hashCode = null;
				if (result != IProxyCacheService.NO_RESULT) {
					hashCode = (Integer) result;
				}
				// calculate and cache the result 
				if (hashCode == null) {
					String uid = config.getFullyQualifiedPath();
					hashCode = new Integer(uid.hashCode());
					config.getService().storeResult(source, HASH_CODE_FEATURE, hashCode);
				}
				// if we couldn't initialize it, we'll default to the source's hashCode
				if (hashCode == null) {
					return method.invoke(config.getSource(), args);
				}
				return hashCode.intValue();
			}

		});
	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public ObjectDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public ObjectDelegate(Map methodHandlers) {
		super(methodHandlers);
	}

	private static void resolve(ProxyConfiguration config, ProxyConfiguration oConfig) {
		if (config.getSource().eIsProxy() && !oConfig.getSource().eIsProxy()) {
			config.setSource(oConfig.getSource());
		} else if (oConfig.getSource().eIsProxy() && !config.getSource().eIsProxy()) {
			oConfig.setSource(config.getSource());
		}
	}
}