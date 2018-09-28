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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.InternalEObject;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * A delegate for the Notifier.class type.
 * 
 * @since 1.0
 * 
 */
public class NotifierDelegate extends TypeDelegate {

	/** The {@link Notifier#eNotify(org.eclipse.emf.common.notify.Notification)} */
	private static final Method ENOTIFY;

	/** The {@link Notifier#eAdapters()} */
	private static final Method EADAPTERS;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;

		try {
			method = InternalEObject.class.getMethod("eNotify", new Class[] { Notification.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		ENOTIFY = method;

		try {
			method = InternalEObject.class.getMethod("eAdapters", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EADAPTERS = method;
	}

	static {
		staticHandlers.put(ENOTIFY, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				config.eNotify((Notification) args[0]);
				return null;
			}
		});

		staticHandlers.put(EADAPTERS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return config.eAdapters();
			}
		});
	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public NotifierDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public NotifierDelegate(Map methodHandlers) {
		super(methodHandlers);
	}

}
