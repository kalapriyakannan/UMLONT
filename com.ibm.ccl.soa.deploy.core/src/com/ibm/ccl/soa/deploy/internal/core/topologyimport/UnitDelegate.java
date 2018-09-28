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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.FilterList;
import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * A delegate for the Unit.class type.
 * 
 * @since 1.0
 * 
 */
public class UnitDelegate extends TypeDelegate {

	private static final String REALIZATION_LINKS = "realizationLinks"; //$NON-NLS-1$

	private static final String HOSTING_LINKS = "hostingLinks"; //$NON-NLS-1$

	private static final String MEMBER_LINKS = "memberLinks"; //$NON-NLS-1$

	private static final String UNIT_LINKS = "unitLinks"; //$NON-NLS-1$

	private static final String CONSTRAINT_LINKS = "constraintLinks"; //$NON-NLS-1$

	protected static final String CAPABILITIES = "capabilities"; //$NON-NLS-1$

	protected static final String REQUIREMENTS = "requirements"; //$NON-NLS-1$

	/** The {@link Unit#getRealizationLinks()} method. */
	private static final Method GET_REALIZATION_LINKS;

	/** The {@link Unit#getHostingLinks()} method. */
	private static final Method GET_HOSTING_LINKS;

	/** The {@link Unit#getMemberLinks()} method. */
	private static final Method GET_MEMBER_LINKS;

	/** The {@link Unit#getUnitLinks()} method. */
	private static final Method GET_UNIT_LINKS;

	/** The {@link Unit#getConstraintLinks()} method. */
	private static final Method GET_CONSTRAINT_LINKS;

	/** The {@link Unit#getCapabilities()} method. */
	private static final Method GET_CAPABILITIES;

	/** The {@link Unit#getRequirements()} method. */
	private static final Method GET_REQUIREMENTS;

	/**
	 * The
	 * {@link Unit#getCapabilities(IObjectFilter, com.ibm.ccl.soa.deploy.core.util.IObjectAdapter)}
	 * method.
	 */
	private static final Method GET_FILTERED_CAPABILITIES;

	/**
	 * The
	 * {@link Unit#getRequirements(IObjectFilter, com.ibm.ccl.soa.deploy.core.util.IObjectAdapter)}
	 * method.
	 */
	private static final Method GET_FILTERED_REQUIREMENTS;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;

		try {
			method = Unit.class.getMethod("getRealizationLinks", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_REALIZATION_LINKS = method;

		try {
			method = Unit.class.getMethod("getHostingLinks", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_HOSTING_LINKS = method;

		try {
			method = Unit.class.getMethod("getMemberLinks", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_MEMBER_LINKS = method;

		try {
			method = Unit.class.getMethod("getUnitLinks", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_UNIT_LINKS = method;

		try {
			method = Unit.class.getMethod("getConstraintLinks", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_CONSTRAINT_LINKS = method;

		try {
			method = Unit.class.getMethod("getCapabilities", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_CAPABILITIES = method;

		try {
			method = Unit.class.getMethod("getRequirements", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_REQUIREMENTS = method;

		try {
			method = Unit.class.getMethod(
					"getCapabilities", new Class[] { IObjectFilter.class, IObjectAdapter.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_FILTERED_CAPABILITIES = method;

		try {
			method = Unit.class.getMethod(
					"getRequirements", new Class[] { IObjectFilter.class, IObjectAdapter.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_FILTERED_REQUIREMENTS = method;
	}

	static {
		staticHandlers.put(GET_REALIZATION_LINKS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {

				Object value = config.getService()
						.retrieveResult(config.getSource(), REALIZATION_LINKS);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createRealizationLinkDelegateList(config, proxy, method, args);
					config.getService().storeResult(config.getSource(), REALIZATION_LINKS, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_HOSTING_LINKS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object value = config.getService().retrieveResult(config.getSource(), HOSTING_LINKS);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createUnitLinkDelegateList(config, method, args, (EList) config
							.getEditTopology().getHostingLinks(), CorePackage.eINSTANCE
							.getDeployCoreRoot_LinkHosting());
					config.getService().storeResult(config.getSource(), HOSTING_LINKS, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_MEMBER_LINKS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object value = config.getService().retrieveResult(config.getSource(), MEMBER_LINKS);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createUnitLinkDelegateList(config, method, args, (EList) config
							.getEditTopology().getMemberLinks(), CorePackage.eINSTANCE
							.getDeployCoreRoot_LinkMember());
					config.getService().storeResult(config.getSource(), MEMBER_LINKS, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_UNIT_LINKS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object value = config.getService().retrieveResult(config.getSource(), UNIT_LINKS);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createUnitLinkDelegateList(config, method, args, (EList) config
							.getEditTopology().getUnitLinks(), CorePackage.eINSTANCE
							.getDeployCoreRoot_LinkUnit());
					config.getService().storeResult(config.getSource(), UNIT_LINKS, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_CONSTRAINT_LINKS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object value = config.getService().retrieveResult(config.getSource(), CONSTRAINT_LINKS);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createConstraintLinkDelegateList(config, proxy, method, args);
					config.getService().storeResult(config.getSource(), CONSTRAINT_LINKS, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_CAPABILITIES, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object value = config.getService().retrieveResult(config.getSource(), CAPABILITIES);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createCapabilitiesDelegateList(config, method, args);
					config.getService().storeResult(config.getSource(), CAPABILITIES, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_REQUIREMENTS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Object value = config.getService().retrieveResult(config.getSource(), REQUIREMENTS);
				if (value == IProxyCacheService.NO_RESULT) {
					value = createRequirementsDelegateList(config, method, args);
					config.getService().storeResult(config.getSource(), REQUIREMENTS, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_FILTERED_CAPABILITIES, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				IObjectFilter filter = (IObjectFilter) args[0];
				IObjectAdapter adapter = (IObjectAdapter) args[1];
				String featureKey = filter.toString() + adapter.toString() + CAPABILITIES;
				Object value = config.getService().retrieveResult(config.getSource(), featureKey);
				if (value == IProxyCacheService.NO_RESULT) {
					value = new FilterList((EList) ((Unit) proxy).getCapabilities(), filter, adapter);
					config.getService().storeResult(config.getSource(), featureKey, value);
				}
				return value;
			}
		});
		staticHandlers.put(GET_FILTERED_REQUIREMENTS, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				IObjectFilter filter = (IObjectFilter) args[0];
				IObjectAdapter adapter = (IObjectAdapter) args[1];
				String featureKey = filter.toString() + adapter.toString() + REQUIREMENTS;
				Object value = config.getService().retrieveResult(config.getSource(), featureKey);
				if (value == IProxyCacheService.NO_RESULT) {
					value = new FilterList((EList) ((Unit) proxy).getRequirements(), filter, adapter);
					config.getService().storeResult(config.getSource(), featureKey, value);
				}
				return value;
			}
		});

	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public UnitDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public UnitDelegate(Map<Method, MethodHandler> methodHandlers) {
		super(methodHandlers);
	}

	@Override
	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		// check for the cases where the import has gone null or been removed
		// See @jazz 1871 for an example of when this happens
		if (config.getImported() == null || config.getImported().eIsProxy()) {
			return method.invoke(config.getSource(), args);
		}
		return super.handle(config, proxy, method, args);
	}

	/**
	 * 
	 * @param config
	 *           The container for augmented state managed for the given proxy.
	 * @param method
	 *           The reflected method that was invoked on the proxy.
	 * @param args
	 *           The list of arguments supplied to the method.
	 * @param editableList
	 *           An editable list from some containing object that can accept modifications.
	 * @param feature
	 *           The abstract structural feature managed by the returned list. Used for
	 *           {@link FeatureAwareList feature lists}.
	 * @return A smart list that can modify the corresponding list from a given container and make
	 *         notifications about those changes in order to update the UI.
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static List createUnitLinkDelegateList(IProxyConfiguration config, Method method,
			Object[] args, EList editableList, EStructuralFeature feature)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		EList sourceList = buildSourceList(config, method, args, feature);
		List delegateList = new ProxyEList(config.getService(), config.getImported(), sourceList);
		return new UnitLinkAwareList((Unit) config.getService().findProxy(config.getSource(),
				config.getImported()), config.getImported(), feature, editableList, delegateList);
	}

	private static EList buildSourceList(IProxyConfiguration config, Method method, Object[] args,
			EStructuralFeature feature) throws IllegalAccessException, InvocationTargetException {
		EList sourceList = (EList) method.invoke(config.getSource(), args);

		InternalInstanceConfiguration editConfig = (InternalInstanceConfiguration) config
				.getImported().getInstanceConfiguration();
		EList result = editConfig.buildConfiguredList(config.getService().getScopeService(), config
				.getImported(), config, feature, sourceList);
		return result;
	}

	private static List createRealizationLinkDelegateList(IProxyConfiguration config, Object proxy,
			Method method, Object[] args) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		final Unit sourceUnit;
		if (proxy instanceof DeployModelObject) {
			sourceUnit = ValidatorUtils.getUnit((DeployModelObject) proxy);
		} else {
			sourceUnit = null;
		}
		final IObjectFilter sourceFilter = new IObjectFilter() {
			public boolean accept(Object value) {
				if (!(value instanceof RealizationLink)) {
					return false;
				}
				RealizationLink link = (RealizationLink) value;
				Unit linkSourceUnit = ValidatorUtils.getUnit(link.getSource());
				if (sourceUnit != null && linkSourceUnit != null) {
					return sourceUnit.equals(linkSourceUnit);
				}
				return true;
			}
		};
		EList editableList = new FilterList((EList) config.getEditTopology().getRealizationLinks(),
				sourceFilter);
		List sourceList = buildSourceList(config, method, args,
				CorePackage.Literals.UNIT__REALIZATION_LINKS);
		List delegateList = new ProxyList(config.getService(), config.getImported(), sourceList);
		return new DMOLinkAwareList(config.getService().findProxy(config.getSource(),
				config.getImported()), editableList, delegateList);
	}

	private static List createConstraintLinkDelegateList(IProxyConfiguration config, Object proxy,
			Method method, Object[] args) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		final Unit sourceUnit;
		if (proxy instanceof DeployModelObject) {
			sourceUnit = ValidatorUtils.getUnit((DeployModelObject) proxy);
		} else {
			sourceUnit = null;
		}
		final IObjectFilter sourceFilter = new IObjectFilter() {
			public boolean accept(Object value) {
				if (!(value instanceof ConstraintLink)) {
					return false;
				}
				ConstraintLink link = (ConstraintLink) value;
				Unit linkSourceUnit = ValidatorUtils.getUnit(link.getSource());
				if (sourceUnit != null && linkSourceUnit != null) {
					return sourceUnit.equals(linkSourceUnit);
				}
				return true;
			}
		};
		EList editableList = new FilterList((EList) config.getEditTopology().getConstraintLinks(),
				sourceFilter);
		EList sourceList = buildSourceList(config, method, args,
				CorePackage.Literals.UNIT__CONSTRAINT_LINKS);
		List delegateList = new ProxyEList(config.getService(), config.getImported(), sourceList);
		// Note: logical links don't have implied source behavior
		return new ReassociationList(config.getEditTopology(),
				CorePackage.Literals.TOPOLOGY__CONSTRAINT_LINKS,
				CorePackage.Literals.UNIT__CONSTRAINT_LINKS, config.getSource(), config.getImported()
						.getInstanceConfiguration(), editableList, delegateList);
	}

	private static List createCapabilitiesDelegateList(IProxyConfiguration config, Method method,
			Object[] args) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		List sourceList = buildSourceList(config, method, args,
				CorePackage.Literals.UNIT__CAPABILITIES);
		List delegateList = new ProxyList(config.getService(), config.getImported(), sourceList);
		InstanceConfiguration instanceConfiguration = config.getImported().getInstanceConfiguration();
		if (instanceConfiguration != null
				&& instanceConfiguration.isPublicEditable(config.getSource())) {
			Map<EStructuralFeature, EStructuralFeature> echoedFeatures = new HashMap<EStructuralFeature, EStructuralFeature>(
					2);
			echoedFeatures.put(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
					CorePackage.Literals.UNIT__CAPABILITY_GROUP);
			echoedFeatures.put(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES,
					CorePackage.Literals.UNIT__CAPABILITIES);
			echoedFeatures.put(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY,
					CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY);

			return new DynamicReassociationList(instanceConfiguration, config.getSource(),
					CorePackage.Literals.UNIT__CAPABILITIES, delegateList,
					new ConfiguredCapabilityFeatureMapStrategy(instanceConfiguration,
							config.getSource(),
							CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
							echoedFeatures));
		}
		return delegateList;
	}

	private static List createRequirementsDelegateList(IProxyConfiguration config, Method method,
			Object[] args) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		List sourceList = buildSourceList(config, method, args,
				CorePackage.Literals.UNIT__REQUIREMENTS);
		List delegateList = new ProxyList(config.getService(), config.getImported(), sourceList);

		InstanceConfiguration instanceConfiguration = config.getImported().getInstanceConfiguration();
		if (instanceConfiguration != null) {
			if (config.getSource().getName() != null
					&& instanceConfiguration.isPublic(config.getSource())) {
				Map<EStructuralFeature, EStructuralFeature> echoedFeatures = new HashMap<EStructuralFeature, EStructuralFeature>(
						2);
				echoedFeatures.put(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP,
						CorePackage.Literals.UNIT__REQUIREMENT_GROUP);
				echoedFeatures.put(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS,
						CorePackage.Literals.UNIT__REQUIREMENTS);
				echoedFeatures.put(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT,
						CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT);

				return new DynamicReassociationList(instanceConfiguration, config.getSource(),
						CorePackage.Literals.UNIT__REQUIREMENTS, delegateList,
						new ConfiguredRequirementFeatureMapStrategy(instanceConfiguration, config
								.getSource(),
								CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP,
								echoedFeatures));
			}
		}
		return delegateList;
	}
}
