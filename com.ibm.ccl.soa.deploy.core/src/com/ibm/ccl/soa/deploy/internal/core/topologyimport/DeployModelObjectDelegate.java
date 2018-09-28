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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * A delegate for the DeployModelObject.class type.
 * 
 * @since 1.0
 * 
 */
public class DeployModelObjectDelegate extends TypeDelegate {

	protected static final String CONSTRAINTS = "constraints"; //$NON-NLS-1$

	/** The {@link DeployModelObject#addStatus(IStatus)} method. */
	private static final Method ADD_STATUS;

	/** The {@link DeployModelObject#clearStatus()} method. */
	private static final Method CLEAR_STATUS;

	/** The {@link DeployModelObject#getContainedModelObjects()} method. */
	private static final Method GET_CONTAINED_MODEL_OBJECTS;

	/** The {@link DeployModelObject#getEObject()} method. */
	private static final Method GET_EOBJECT;

	/** The {@link DeployModelObject#getFullPath()} method. */
	private static final Method GET_FULL_PATH;

	/** The {@link DeployModelObject#getName()} method. */
	private static final Method GET_NAME;

	/** The {@link DeployModelObject#setName(String)} method. */
	private static final Method SET_NAME;

	/** The {@link DeployModelObject#getStatus()} method. */
	private static final Method GET_STATUS;

	/** The {@link DeployModelObject#getEditTopology()} method. */
	private static final Method GET_EDIT_TOPOLOGY;

	/** The {@link DeployModelObject#Constraints()} method. */
	private static final Method GET_CONSTRAINTS;

	/** The {@link DeployModelObject#isVisible()} method. */
	private static final Method IS_VISIBLE;

	/** The {@link DeployModelObject#isvPublic()} method. */
	private static final Method IS_PUBLIC;

	/** The {@link DeployModelObject#isPublicEditable()} method. */
	private static final Method IS_PUBLIC_EDITABLE;

	/** The {@link DeployModelObject#isPublicEditable(String)} method. */
	private static final Method IS_PUBLIC_EDITABLE_PROPERTY;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;
		try {
			method = DeployModelObject.class.getMethod("getStatus", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_STATUS = method;

		try {
			method = DeployModelObject.class.getMethod("addStatus", new Class[] { IStatus.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		ADD_STATUS = method;

		try {
			method = DeployModelObject.class.getMethod("clearStatus", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		CLEAR_STATUS = method;

		try {
			method = DeployModelObject.class.getMethod("getEObject", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_EOBJECT = method;

		try {
			method = DeployModelObject.class.getMethod("getContainedModelObjects", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_CONTAINED_MODEL_OBJECTS = method;

		try {
			method = DeployModelObject.class.getMethod("getFullPath", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_FULL_PATH = method;

		try {
			method = DeployModelObject.class.getMethod("getName", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_NAME = method;

		try {
			method = DeployModelObject.class.getMethod("getEditTopology", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_EDIT_TOPOLOGY = method;

		try {
			method = DeployModelObject.class.getMethod("getConstraints", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_CONSTRAINTS = method;

		try {
			method = DeployModelObject.class.getMethod("isVisible", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		IS_VISIBLE = method;

		try {
			method = DeployModelObject.class.getMethod("isPublic", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		IS_PUBLIC = method;

		try {
			method = DeployModelObject.class.getMethod("isPublicEditable", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		IS_PUBLIC_EDITABLE = method;

		try {
			method = DeployModelObject.class.getMethod(
					"isPublicEditable", new Class[] { String.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		IS_PUBLIC_EDITABLE_PROPERTY = method;

		try {
			method = DeployModelObject.class.getMethod("setName", new Class[] { String.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		SET_NAME = method;
	}

	static {

		if (GET_STATUS != null) {
			staticHandlers.put(GET_STATUS, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					return config.getStatus();
				}
			});
		}

		if (ADD_STATUS != null) {
			staticHandlers.put(ADD_STATUS, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					IStatus newStatus = (IStatus) args[0];
					return config.addStatus((InternalEObject) proxy, newStatus);
				}
			});
		}

		if (CLEAR_STATUS != null) {
			staticHandlers.put(CLEAR_STATUS, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					config.clearStatus((InternalEObject) proxy, true);
					return null;
				}
			});
		}

		if (GET_EOBJECT != null) {
			staticHandlers.put(GET_EOBJECT, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws IllegalArgumentException, IllegalAccessException,
						InvocationTargetException {
					DeployModelObject object = (DeployModelObject) method.invoke(config.getSource(),
							args);
					if (object != null) {
						return config.getService().findProxy(object, config.getImported());
					}
					return object;
				}
			});
		}

		if (GET_CONTAINED_MODEL_OBJECTS != null) {
			staticHandlers.put(GET_CONTAINED_MODEL_OBJECTS, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws IllegalArgumentException, IllegalAccessException,
						InvocationTargetException {
					List sourceList = (List) method.invoke(config.getSource(), args);
					List delegateList = new ProxyList(config.getService(), config.getImported(),
							sourceList);
					return delegateList;
				}
			});
		}

		if (GET_FULL_PATH != null) {
			staticHandlers.put(GET_FULL_PATH, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					return config.getFullyQualifiedPath();
				}
			});
		}

		if (GET_NAME != null) {
			staticHandlers.put(GET_NAME, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					return config.getSource().getName();
				}
			});
		}

		if (GET_EDIT_TOPOLOGY != null) {
			staticHandlers.put(GET_EDIT_TOPOLOGY, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					return config.getService().getScopeService().getManagingTopology();
				}
			});
		}

		if (GET_CONSTRAINTS != null) {
			staticHandlers.put(GET_CONSTRAINTS, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {

					Object value = config.getService().retrieveResult(config.getSource(), CONSTRAINTS);
					if (value == IProxyCacheService.NO_RESULT) {
						List sourceList = (List) method.invoke(config.getSource(), args);
						List delegateList = new ProxyList(config.getService(), config.getImported(),
								sourceList);

						InstanceConfiguration instanceConfiguration = config.getImported()
								.getInstanceConfiguration();
						if (instanceConfiguration != null) {
							if (config.getSource().getName() != null) {

								Map<EStructuralFeature, EStructuralFeature> echoedFeatures = new HashMap<EStructuralFeature, EStructuralFeature>(
										2);
								echoedFeatures.put(CorePackage.Literals.AUGMENTATION__ADDITIONS,
										CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP);
								echoedFeatures.put(CorePackage.Literals.AUGMENTATION__ADDITIONS,
										CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS);
								echoedFeatures.put(CorePackage.Literals.DEPLOY_CORE_ROOT__CONSTRAINT,
										CorePackage.Literals.DEPLOY_CORE_ROOT__CONSTRAINT);

								value = new DynamicReassociationList(instanceConfiguration, config
										.getSource(), CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS,
										delegateList, new AugmentationFeatureMapStrategy(
												instanceConfiguration, config.getSource(),
												CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS, true));
							}
						}
						config.getService().storeResult(config.getSource(), CONSTRAINTS, value);
					}
					return value;

				}
			});
		}

		if (IS_VISIBLE != null) {
			staticHandlers.put(IS_VISIBLE, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					InstanceConfiguration delegateConfig = config.getImported()
							.getInstanceConfiguration();
					if (delegateConfig != null) {
						return delegateConfig.isVisible(config.getSource());
					}
					return false;
				}
			});
		}

		if (IS_VISIBLE != null) {
			staticHandlers.put(IS_VISIBLE, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					InstanceConfiguration delegateConfig = config.getImported()
							.getInstanceConfiguration();
					if (delegateConfig != null) {
						return delegateConfig.isVisible(config.getSource());
					}
					return false;
				}
			});
		}

		if (IS_PUBLIC != null) {
			staticHandlers.put(IS_PUBLIC, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					InstanceConfiguration delegateConfig = config.getImported()
							.getInstanceConfiguration();
					if (delegateConfig != null) {
						return delegateConfig.isPublic(config.getSource());
					}
					return false;
				}
			});
		}

		if (IS_PUBLIC_EDITABLE != null) {
			staticHandlers.put(IS_PUBLIC_EDITABLE, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					InstanceConfiguration delegateConfig = config.getImported()
							.getInstanceConfiguration();
					if (delegateConfig != null) {
						return delegateConfig.isPublicEditable(config.getSource());
					}
					return false;
				}
			});
		}

		if (IS_PUBLIC_EDITABLE_PROPERTY != null) {
			staticHandlers.put(IS_PUBLIC_EDITABLE_PROPERTY, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) throws Throwable {
					InstanceConfiguration delegateConfig = config.getImported()
							.getInstanceConfiguration();
					if (delegateConfig != null && args.length > 0 && args[0] instanceof String) {
						return delegateConfig.isPublicEditable(config.getSource(), (String) args[0]);
					}
					return false;
				}
			});
		}

		if (SET_NAME != null) {
			staticHandlers.put(SET_NAME, new MethodHandler() {
				public Object handle(IProxyConfiguration config, Object proxy, Method method,
						Object[] args) {
					final String msg = "Invalid attempt to set the name of an imported object."; //$NON-NLS-1$ 
					DeployCorePlugin.logError(0, msg, new IllegalAccessException(msg));
					return null;
				}
			});
		}

	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public DeployModelObjectDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public DeployModelObjectDelegate(Map<Method, MethodHandler> methodHandlers) {
		super(methodHandlers);
	}

	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		return super.handle(config, proxy, method, args);
	}

}