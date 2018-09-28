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
import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;

/**
 * A delegate for the DeployModelObject.class type.
 * 
 * @since 1.0
 * 
 */
public class ExtendedAttributeDelegate extends TypeDelegate {

	/** The {@link ExtendedAttribute#setValue(Object)} method. */
	private static final Method SET_VALUE;

	/** The {@link ExtendedAttribute#getValue()} method. */
	private static final Method GET_VALUE;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;
		try {
			method = ExtendedAttribute.class.getMethod("setValue", new Class[] { Object.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		SET_VALUE = method;

		try {
			method = ExtendedAttribute.class.getMethod("getValue", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_VALUE = method;

	}

	static {

		if (SET_VALUE != null) {
			staticHandlers.put(SET_VALUE, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					Import imported = config.getImported();
					if (imported != null) {
						InstanceConfiguration instanceConfiguration = imported.getInstanceConfiguration();
						DeployModelObject source = config.getSource();
						if (source != null) {
							ExtendedAttribute attribute = ((ExtendedAttributeConfiguration) config)
									.getAttribute();
							instanceConfiguration.configure(source, attribute.getName(), args[0]);
						}
					}
					return null;
				}
			});
		}

		if (GET_VALUE != null) {
			staticHandlers.put(GET_VALUE, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					Import imported = config.getImported();
					if (imported != null) {
						InstanceConfiguration instanceConfiguration = imported.getInstanceConfiguration();
						DeployModelObject source = config.getSource();
						if (source != null) {
							ExtendedAttribute attribute = ((ExtendedAttributeConfiguration) config)
									.getAttribute();
							Object result = instanceConfiguration.getConfiguredValue(source, attribute
									.getName());
							if (result == null) {
								return method.invoke(attribute, args);
							}
							return result;

						}
					}
					return null;
				}
			});
		}

	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public ExtendedAttributeDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public ExtendedAttributeDelegate(Map<Method, MethodHandler> methodHandlers) {
		super(methodHandlers);
	}

	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		MethodHandler handler = staticHandlers.get(method);
		if (handler != null) {
			return handler.handle(config, proxy, method, args);
		}
		return null;
	}

}