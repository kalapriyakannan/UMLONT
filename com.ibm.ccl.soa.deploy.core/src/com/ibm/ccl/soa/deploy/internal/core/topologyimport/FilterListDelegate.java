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
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeAdapter;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeAdapter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeFilter;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

public class FilterListDelegate extends TypeDelegate {

	/*
	 * getHostingOrAnyRequirements() getDependencyOrAnyRequirements() getOnlyAnyRequirements()
	 * getOnlyHostingRequirements() getOnlyDependencyRequirements() getOnlyMemberRequirements()
	 * 
	 * getOnlyHostingCapabilities() getOnlyDependencyCapabilities() getHostingOrAnyCapabilities()
	 * getDependencyOrAnyCapabilities() getOnlyAnyCapabilities()
	 */

	/** The {@link Unit#getHostingOrAnyRequirements()} method. */
	private static final Method getHostingOrAnyRequirements;

	/** The {@link Unit#getDependencyOrAnyRequirements()} method. */
	private static final Method getDependencyOrAnyRequirements;

	/** The {@link Unit#getOnlyAnyRequirements()} method. */
	private static final Method getOnlyAnyRequirements;

	/** The {@link Unit#getOnlyHostingRequirements()} method. */
	private static final Method getOnlyHostingRequirements;

	/** The {@link Unit#getOnlyDependencyRequirements()} method. */
	private static final Method getOnlyDependencyRequirements;

	/** The {@link Unit#getOnlyMemberRequirements()} method. */
	private static final Method getOnlyMemberRequirements;

	/** The {@link Unit#getOnlyHostingCapabilities()} method. */
	private static final Method getOnlyHostingCapabilities;

	/** The {@link Unit#getOnlyDependencyCapabilities()} method. */
	private static final Method getOnlyDependencyCapabilities;

	/** The {@link Unit#getHostingOrAnyCapabilities()} method. */
	private static final Method getHostingOrAnyCapabilities;

	/** The {@link Unit#getDependencyOrAnyCapabilities()} method. */
	private static final Method getDependencyOrAnyCapabilities;

	/** The {@link Unit#getOnlyAnyCapabilities()} method. */
	private static final Method getOnlyAnyCapabilities;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;

		try {
			method = Unit.class.getMethod("getHostingOrAnyRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getHostingOrAnyRequirements = method;

		try {
			method = Unit.class.getMethod("getDependencyOrAnyRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getDependencyOrAnyRequirements = method;

		try {
			method = Unit.class.getMethod("getOnlyAnyRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyAnyRequirements = method;

		try {
			method = Unit.class.getMethod("getOnlyHostingRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyHostingRequirements = method;

		try {
			method = Unit.class.getMethod("getOnlyDependencyRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyDependencyRequirements = method;

		try {
			method = Unit.class.getMethod("getOnlyMemberRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyMemberRequirements = method;

		try {
			method = Unit.class.getMethod("getOnlyHostingCapabilities", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyHostingCapabilities = method;

		try {
			method = Unit.class.getMethod("getOnlyDependencyCapabilities", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyDependencyCapabilities = method;

		try {
			method = Unit.class.getMethod("getHostingOrAnyCapabilities", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getHostingOrAnyCapabilities = method;

		try {
			method = Unit.class.getMethod("getDependencyOrAnyCapabilities", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getDependencyOrAnyCapabilities = method;

		try {
			method = Unit.class.getMethod("getOnlyAnyCapabilities", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		getOnlyAnyCapabilities = method;

	}

	static {
		staticHandlers.put(getHostingOrAnyRequirements, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredRequirementsList(config, proxy, getHostingOrAnyRequirements,
						RequirementLinkTypeFilter.ANY_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER);
			}
		});

		staticHandlers.put(getDependencyOrAnyRequirements, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredRequirementsList(config, proxy, getDependencyOrAnyRequirements,
						RequirementLinkTypeFilter.DEPENDENCY_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyAnyRequirements, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredRequirementsList(config, proxy, getOnlyAnyRequirements,
						RequirementLinkTypeFilter.ANY_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyHostingRequirements, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredRequirementsList(config, proxy, getOnlyHostingRequirements,
						RequirementLinkTypeFilter.HOSTING_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyDependencyRequirements, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredRequirementsList(config, proxy, getOnlyDependencyRequirements,
						RequirementLinkTypeFilter.DEPENDENCY_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_DEPENDENCY_LINK_TYPE_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyMemberRequirements, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredRequirementsList(config, proxy, getOnlyMemberRequirements,
						RequirementLinkTypeFilter.MEMBER_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_MEMBER_LINK_TYPE_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyHostingCapabilities, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredCapabilitiesList(config, proxy, getOnlyHostingCapabilities,
						RequirementLinkTypeFilter.HOSTING_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyDependencyCapabilities, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredCapabilitiesList(config, proxy, getOnlyDependencyCapabilities,
						RequirementLinkTypeFilter.DEPENDENCY_FILTER,
						RequirementLinkTypeAdapter.SET_REQUIREMENT_DEPENDENCY_LINK_TYPE_ADAPTER);
			}
		});

		staticHandlers.put(getHostingOrAnyCapabilities, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredCapabilitiesList(config, proxy, getHostingOrAnyCapabilities,
						CapabilityLinkTypeFilter.ANY_OR_HOSTING_FILTER,
						CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_ANY_IF_NON_HOSTING_ADAPTER);
			}
		});

		staticHandlers.put(getDependencyOrAnyCapabilities, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredCapabilitiesList(config, proxy, getDependencyOrAnyCapabilities,
						CapabilityLinkTypeFilter.ANY_OR_DEPENDENCY_FILTER,
						CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_ANY_IF_NON_DEPENDENCY_ADAPTER);
			}
		});

		staticHandlers.put(getOnlyAnyCapabilities, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				return getFilteredCapabilitiesList(config, proxy, getOnlyAnyCapabilities,
						CapabilityLinkTypeFilter.ANY_FILTER,
						CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_ANY_ADAPTER);
			}
		});

	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public FilterListDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public FilterListDelegate(Map<Method, MethodHandler> methodHandlers) {
		super(methodHandlers);
	}

	private static Object getFilteredRequirementsList(IProxyConfiguration config, Object proxy,
			Method target, IObjectFilter filter, IObjectAdapter adapter) {
		Object value = config.getService().retrieveResult(config.getSource(), target.getName());
		if (value == IProxyCacheService.NO_RESULT) {
			value = ((Unit) proxy).getRequirements(filter, adapter);
			config.getService().storeResult(config.getSource(), target.getName(), value);
		}
		return value;
	}

	private static Object getFilteredCapabilitiesList(IProxyConfiguration config, Object proxy,
			Method target, IObjectFilter filter, IObjectAdapter adapter) {
		Object value = config.getService().retrieveResult(config.getSource(), target.getName());
		if (value == IProxyCacheService.NO_RESULT) {
			value = ((Unit) proxy).getCapabilities(filter, adapter);
			config.getService().storeResult(config.getSource(), target.getName(), value);
		}
		return value;
	}

}
