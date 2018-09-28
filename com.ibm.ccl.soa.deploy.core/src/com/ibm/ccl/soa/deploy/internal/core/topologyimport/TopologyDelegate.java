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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * A proxy delegate for the {@link Topology} class.
 */
public class TopologyDelegate extends TypeDelegate {

	/**
	 * Proxy list handler for {@link Topology} objects which delegates to their configuration
	 * topology.
	 */
	private static final MethodHandler TOPOLOGY_HANDLER = new MethodHandler() {
		public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
				throws Throwable {
			EList sourceList = (EList) method.invoke(config.getSource(), args);

			return new ProxyEList(config.getService(), config.getImported(), sourceList);
		}
	};

	/**
	 * A handler that delegates the method to the edit topology.
	 */
	public static final MethodHandler EDIT_TOPOLOGY_HANDLER = new MethodHandler() {
		public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
				throws Throwable {
			Topology editTopology = config.getEditTopology();
			if (editTopology != null) {
				return method.invoke(editTopology, args);
			}
			return null;
		}
	};

	/** The {@link Topology#getUnits()} method. */
	private static final Method GET_UNITS;

	/** The {@link Topology#getHostingLinks()} method. */
	private static final Method GET_HOSTING_LINKS;

	/** The {@link Topology#getMemberLinks()} method. */
	private static final Method GET_MEMBER_LINKS;

	/** The {@link Topology#getUnitLinks()} method. */
	private static final Method GET_UNIT_LINKS;

	/** The {@link Topology#getConstraintLinks()} method. */
	private static final Method GET_CONSTRAINT_LINKS;

	/** The {@link Topology#getDependencyLinks()} method. */
	private static final Method GET_DEPENDENCY_LINKS;

	/** The {@link Topology#getRealizationLinks()} method. */
	private static final Method GET_REALIZATION_LINKS;

	/** The {@link Topology#findHosts(Unit)} method. */
	private static final Method FIND_HOSTS;

	/** The {@link Topology#findMemberOf(Unit)} method. */
	private static final Method FIND_MEMBER_OF;

	/** The {@link Topology#findDependentRequirements(Capability)} method. */
	private static final Method FIND_DEPENDENT_REQUIREMENTS;

	private static final Map staticHandlers = new HashMap();

	static {
		Method method = null;

		try {
			method = Topology.class.getMethod("getUnits", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_UNITS = method;

		try {
			method = Topology.class.getMethod("getHostingLinks", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_HOSTING_LINKS = method;

		try {
			method = Topology.class.getMethod("getMemberLinks", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_MEMBER_LINKS = method;

		try {
			method = Topology.class.getMethod("getUnitLinks", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_UNIT_LINKS = method;

		try {
			method = Topology.class.getMethod("getConstraintLinks", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_CONSTRAINT_LINKS = method;

		try {
			method = Topology.class.getMethod("getDependencyLinks", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_DEPENDENCY_LINKS = method;

		try {
			method = Topology.class.getMethod("getRealizationLinks", null); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_REALIZATION_LINKS = method;

		try {
			method = Topology.class.getMethod("findHosts", new Class[] { Unit.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		FIND_HOSTS = method;

		try {
			method = Topology.class.getMethod("findMemberOf", new Class[] { Unit.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		FIND_MEMBER_OF = method;

		try {
			method = Topology.class.getMethod(
					"findDependentRequirements", new Class[] { Capability.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		FIND_DEPENDENT_REQUIREMENTS = method;
	}

	static {
		staticHandlers.put(GET_UNITS, TOPOLOGY_HANDLER);
		staticHandlers.put(GET_HOSTING_LINKS, TOPOLOGY_HANDLER);
		staticHandlers.put(GET_MEMBER_LINKS, TOPOLOGY_HANDLER);
		staticHandlers.put(GET_UNIT_LINKS, TOPOLOGY_HANDLER);
		staticHandlers.put(GET_CONSTRAINT_LINKS, TOPOLOGY_HANDLER);
		staticHandlers.put(GET_DEPENDENCY_LINKS, TOPOLOGY_HANDLER);
		staticHandlers.put(GET_REALIZATION_LINKS, TOPOLOGY_HANDLER);
		staticHandlers.put(FIND_HOSTS, EDIT_TOPOLOGY_HANDLER);
		staticHandlers.put(FIND_MEMBER_OF, EDIT_TOPOLOGY_HANDLER);
		staticHandlers.put(FIND_DEPENDENT_REQUIREMENTS, EDIT_TOPOLOGY_HANDLER);
	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public TopologyDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public TopologyDelegate(Map methodHandlers) {
		super(methodHandlers);
	}

	/**
	 * Intercepts findAll* methods.
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.TypeDelegate#handle(IProxyConfiguration,
	 *      java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		if (Iterator.class.equals(method.getReturnType()) && method.getName().startsWith("findAll") //$NON-NLS-1$
				&& method.getParameterTypes().length == 0) {
			Topology editTopology = config.getEditTopology();
			if (editTopology != null) {
				return method.invoke(editTopology, args);
			}
		}
		return super.handle(config, proxy, method, args);
	}
}
