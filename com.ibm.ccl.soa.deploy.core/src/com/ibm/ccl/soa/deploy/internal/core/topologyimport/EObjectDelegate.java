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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;

/**
 * A delegate for the EObject.class type.
 * 
 * @since 1.0
 * 
 */
public class EObjectDelegate extends TypeDelegate {

	/** The {@link EObject#eContainer()} method. */
	private static final Method ECONTAINER;

	/** The {@link EObject#eContents()} method. */
	private static final Method ECONTENTS;

	/** The {@link EObject#eResource()} method. */
	private static final Method ERESOURCE;

	/** The {@link EObject#eGet(EStructuralFeature)} method. */
	private static final Method EGET;

	/** The {@link EObject#eIsSet(EStructuralFeature)} method. */
	private static final Method EISSET;

	/** The {@link EObject#eSet(EStructuralFeature, Object)} method. */
	private static final Method ESET;

	/** The {@link EObject#eUnset(EStructuralFeature)} method. */
	private static final Method EUNSET;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	protected static final String EMF_FRAGMENT_SEPARATOR = "#"; //$NON-NLS-1$

	static {
		Method method = null;

		try {
			method = EObject.class.getMethod("eContents", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		ECONTENTS = method;

		try {
			method = EObject.class.getMethod("eContainer", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		ECONTAINER = method;

		try {
			method = EObject.class.getMethod("eResource", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		ERESOURCE = method;

		try {
			method = EObject.class.getMethod("eGet", new Class[] { EStructuralFeature.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EGET = method;

		try {
			method = EObject.class.getMethod("eIsSet", new Class[] { EStructuralFeature.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EISSET = method;

		try {
			method = EObject.class.getMethod(
					"eSet", new Class[] { EStructuralFeature.class, Object.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		ESET = method;

		try {
			method = EObject.class.getMethod("eUnset", new Class[] { EStructuralFeature.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		EUNSET = method;

	}

	static {
		staticHandlers.put(ECONTENTS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				List sourceList = (List) method.invoke(config.getSource(), args);
				List delegateList = new BasicEList();
				for (Iterator iter = sourceList.iterator(); iter.hasNext();) {
					Object object = iter.next();
					if (object instanceof DeployModelObject) {
						DeployModelObject imported = config.getService().findProxy(
								(DeployModelObject) object, config.getImported());
						if (imported != null) {
							delegateList.add(imported);
						}
					} else {
						delegateList.add(object);
					}
				}
				// TODO return Collections.unmodifiableList(delegateList);
				return delegateList;
			}
		});
		staticHandlers.put(ECONTAINER, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object container = method.invoke(config.getSource(), args);
				if (container instanceof DeployModelObject) {
					return config.getService().findProxy((DeployModelObject) container,
							config.getImported());
				}
				return container;

			}
		});
		staticHandlers.put(ERESOURCE, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				if (config.getEditTopology() != null) {
					return config.getEditTopology().eResource();
				}
				return null;
			}
		});
		staticHandlers.put(EGET, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {

				EStructuralFeature feature = (EStructuralFeature) args[0];
				InstanceConfiguration delegateConfig = config.getImported().getInstanceConfiguration();
				if (delegateConfig != null) {
					Object value = delegateConfig.getConfiguredValue(config.getSource(), feature
							.getName());
					if (value != null) {
						return value;
					}
				}
				Object result = method.invoke(config.getSource(), args);
				if (config.getImported() != null) {
					return config.getService().proxify(result, config.getImported());
				}
				return result;
			}
		});
		staticHandlers.put(EISSET, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {

				InstanceConfiguration instanceConfiguration = config.getImported()
						.getInstanceConfiguration();
				if (instanceConfiguration != null) {
					EStructuralFeature feature = (EStructuralFeature) args[0];
					if (hasConfiguredValue(config, instanceConfiguration, feature.getName())) {
						return Boolean.TRUE;
					}
				}
				return method.invoke(config.getSource(), args);
			}
		});
		staticHandlers.put(ESET, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {

				InstanceConfiguration instanceConfiguration = config.getImported()
						.getInstanceConfiguration();
				if (instanceConfiguration != null) {

					EStructuralFeature feature = (EStructuralFeature) args[0];
					Object value = args[1];

					if (instanceConfiguration.isPublicEditable(config.getSource(), feature.getName())
							|| hasConfiguredValue(config, instanceConfiguration, feature.getName())) {

						if (feature.isMany()) {
							Object configuredValue = getConfiguredValue(config, instanceConfiguration,
									feature.getName());
							if (configuredValue instanceof Collection && value instanceof Collection) {
								((Collection) configuredValue).clear();
								((Collection) configuredValue).addAll((Collection) value);
							} else {
								throw new IllegalArgumentException("Cannot set " + feature.getName() //$NON-NLS-1$
										+ " on object " + config.getFullyQualifiedPath() + " with values: " //$NON-NLS-1$ //$NON-NLS-2$
										+ value);
							}
						} else {
							setConfiguredValue(config, instanceConfiguration, feature.getName(), proxy,
									value);
						}
					} else {
						throwInvalidSet(config, feature.getName());
					}

					return null; // void method
				}
				throw new IllegalArgumentException(
						"Cannot set fields on objects which do not have an InstanceConfiguration!"); //$NON-NLS-1$

			}
		});
		staticHandlers.put(EUNSET, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {

				InstanceConfiguration instanceConfiguration = config.getImported()
						.getInstanceConfiguration();
				if (instanceConfiguration != null) {

					EStructuralFeature feature = (EStructuralFeature) args[0];

					if (hasConfiguredValue(config, instanceConfiguration, feature.getName())) {
						clearConfiguredValue(config, instanceConfiguration, feature.getName(), proxy);
					} else {
						throwInvalidSet(config, feature.getName());
					}
				}
				return null; // void method
			}
		});

	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public EObjectDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public EObjectDelegate(Map methodHandlers) {
		super(methodHandlers);
	}

}