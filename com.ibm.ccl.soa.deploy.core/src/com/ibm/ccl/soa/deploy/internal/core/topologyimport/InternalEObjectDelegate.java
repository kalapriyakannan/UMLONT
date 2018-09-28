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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;

/**
 * A delegate for the EObject.class type.
 * 
 * @since 1.0
 * 
 */
public class InternalEObjectDelegate extends TypeDelegate {

	/** The {@link InternalEObject#eProxyURI()} method. */
	private static final Method EPROXYURI;

	/** The {@link InternalEObject#eInternalResource()} method. */
	private static final Method EINTERNAL_RESOURCE;

	/** The {@link InternalEObject#eDirectResource()} method. */
	private static final Method EDIRECT_RESOURCE;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	protected static final String EMF_FRAGMENT_SEPARATOR = "#"; //$NON-NLS-1$

	static {
		Method method = null;

		try {
			method = InternalEObject.class.getMethod("eProxyURI", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EPROXYURI = method;

		try {
			method = InternalEObject.class.getMethod("eInternalResource", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EINTERNAL_RESOURCE = method;

		try {
			method = InternalEObject.class.getMethod("eDirectResource", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EDIRECT_RESOURCE = method;

	}

	static {
		staticHandlers.put(EPROXYURI, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				URI proxyURI = null;
				if (config.getSource().getEObject().eIsProxy()) {
					if (config.getEditTopology() != null) {
						Resource container = config.getEditTopology().eResource();
						if (container != null) {
							proxyURI = container.getURI();
						}
					} else {
						proxyURI = URI.createURI(EMF_FRAGMENT_SEPARATOR);
					}
					proxyURI = proxyURI.appendFragment(InternalScopeService.PROXY
							+ IConstants.PATH_SEPARATOR + config.getFullyQualifiedPath());
				}
				return proxyURI;

			}
		});

		staticHandlers.put(EINTERNAL_RESOURCE, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return config.getEditTopology() != null ? config.getEditTopology().eResource() : null;

			}
		});

		staticHandlers.put(EDIRECT_RESOURCE, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return config.getEditTopology() != null ? config.getEditTopology().eResource() : null;

			}
		});

	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public InternalEObjectDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public InternalEObjectDelegate(Map methodHandlers) {
		super(methodHandlers);
	}

}