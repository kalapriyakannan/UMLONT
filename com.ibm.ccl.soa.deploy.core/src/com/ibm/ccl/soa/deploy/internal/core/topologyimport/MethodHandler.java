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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Handle the implementation of a Proxy method. A handler *must* be stateless.
 * 
 * @since 1.0
 * 
 */
public abstract class MethodHandler {

	protected static final String GET = "get"; //$NON-NLS-1$
	protected static final String IS = "is"; //$NON-NLS-1$
	protected static final String SET = "set"; //$NON-NLS-1$

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
	public Object handle(final IProxyConfiguration config, final Object proxy, final Method method,
			Object[] args) throws Throwable {
		// intercept for configuration of requested field
		InstanceConfiguration delegateConfig = config.getImported().getInstanceConfiguration();
		if (delegateConfig != null) {
			String methodName = method.getName();
			String fieldName = null;
			if (methodName.startsWith(GET) && (args == null || args.length == 0)) {
				fieldName = methodName.substring(GET.length());

				Object value = getConfiguredValue(config, delegateConfig, fieldName);
				if (value != null) {
					return value;
				}
			} else if (methodName.startsWith(IS) && (args == null || args.length == 0)) {
				fieldName = methodName.substring(IS.length());

				Object value = getConfiguredValue(config, delegateConfig, fieldName);
				if (value != null) {
					return value;
				}
			} else if (methodName.startsWith(SET)) {
				if (args.length == 1) {

					fieldName = methodName.substring(SET.length());
					setConfiguredValue(config, delegateConfig, fieldName, proxy, args[0]);

				} else {
					DeployCorePlugin.logError(0,
							"Set method configurations for multiple arguments not yet supported: " + proxy //$NON-NLS-1$
									+ "\n" + method.getName() + " arg len: " + args.length, null); //$NON-NLS-1$//$NON-NLS-2$
				}
				return null;
			}
		}

		// no configuration; delegate to the source
		Object result;
		try {
			result = method.invoke(config.getSource(), args);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		}

		// proxify results
		return config.getService().proxify(result, config.getImported());
	}

	// check configured values

	protected boolean hasConfiguredValue(final IProxyConfiguration proxyConfiguration,
			InstanceConfiguration instanceConfiguration, String fieldName) {
		if (Character.isUpperCase(fieldName.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(fieldName.charAt(0)))
					.append(fieldName.substring(1)).toString();
			fieldName = converted.toString();
		}
		Object value = proxyConfiguration.getService().retrieveResult(proxyConfiguration.getSource(),
				fieldName);
		if (value == IProxyCacheService.NO_RESULT) {
			value = instanceConfiguration
					.getConfiguredValue(proxyConfiguration.getSource(), fieldName);
			proxyConfiguration.getService().storeResult(proxyConfiguration.getSource(), fieldName,
					value);
		}
		return value != null;
	}

	protected Object getConfiguredValue(final IProxyConfiguration proxyConfiguration,
			InstanceConfiguration instanceConfiguration, String fieldName) {
		if (Character.isUpperCase(fieldName.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(fieldName.charAt(0)))
					.append(fieldName.substring(1)).toString();
			fieldName = converted.toString();
		}
		Object value = proxyConfiguration.getService().retrieveResult(proxyConfiguration.getSource(),
				fieldName);
		if (value == IProxyCacheService.NO_RESULT) {
			value = instanceConfiguration
					.getConfiguredValue(proxyConfiguration.getSource(), fieldName);
			proxyConfiguration.getService().storeResult(proxyConfiguration.getSource(), fieldName,
					value);
		}
		return value;
	}

	protected void setConfiguredValue(final IProxyConfiguration proxyConfiguration,
			InstanceConfiguration instanceConfiguration, String fieldName, final Object proxy,
			Object newValue) {
		if (Character.isUpperCase(fieldName.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(fieldName.charAt(0)))
					.append(fieldName.substring(1)).toString();
			fieldName = converted.toString();
		}

		if (hasConfiguredValue(proxyConfiguration, instanceConfiguration, fieldName)
				|| instanceConfiguration.isPublicEditable(proxyConfiguration.getSource(), fieldName)) {

			Object oldValue = instanceConfiguration.getConfiguredValue(proxyConfiguration.getSource(),
					fieldName);
			if (oldValue == null) {
				oldValue = getValue(proxyConfiguration.getSource(), fieldName);
			}

			ProxyCacheService service = proxyConfiguration.getService();
			service.storeResult(proxyConfiguration.getSource(), fieldName,
					IProxyCacheService.NO_RESULT);

			instanceConfiguration.configure(proxyConfiguration.getSource(), fieldName, newValue);

			EClass eClass = proxyConfiguration.getSource().getEObject().eClass();

			EStructuralFeature feature = eClass.getEStructuralFeature(fieldName);
			// MDE 
			// sending this attribute causes EContentAdapter to see the 
			// notification as updating an object as a Reference that 
			// it wants to adapt (or remove itself from)
			// See Jazz 6396
//			if (feature == null) {
//				feature = CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA;
//			}
			fireSetNotification(proxy, feature, oldValue, newValue);
		} else {
			throwInvalidSet(proxyConfiguration, fieldName);
		}
	}

	protected void clearConfiguredValue(final IProxyConfiguration proxyConfiguration,
			InstanceConfiguration instanceConfiguration, String fieldName, final Object proxy) {
		if (Character.isUpperCase(fieldName.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(fieldName.charAt(0)))
					.append(fieldName.substring(1)).toString();
			fieldName = converted.toString();
		}

		if (hasConfiguredValue(proxyConfiguration, instanceConfiguration, fieldName)) {

			Object oldValue = instanceConfiguration.getConfiguredValue(proxyConfiguration.getSource(),
					fieldName);

			ProxyCacheService service = proxyConfiguration.getService();
			service.clearResult(proxyConfiguration.getSource(), fieldName);

			instanceConfiguration.deconfigure(proxyConfiguration.getSource(), fieldName);

			EClass eClass = proxyConfiguration.getSource().getEObject().eClass();

			EStructuralFeature feature = eClass.getEStructuralFeature(fieldName);

			// MDE 
			// sending this attribute causes EContentAdapter to see the 
			// notification as updating an object as a Reference that 
			// it wants to adapt (or remove itself from)
			// See Jazz 6396
//			if (feature == null) {
//				feature = CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA;
//			}
			fireSetNotification(proxy, feature, oldValue, null);
		} else {
			throwInvalidSet(proxyConfiguration, fieldName);
		}
	}

	protected final void throwInvalidSet(final IProxyConfiguration proxyConfiguration,
			String fieldName) {
		DeployCorePlugin.log(IStatus.WARNING, 0, NLS.bind(
				DeployCoreMessages.MethodHandler_Cannot_modify_a_non_editable_field_, new Object[] {
						fieldName, proxyConfiguration.getSource().getFullPath() }), null);
	}

	protected void fireSetNotification(final Object proxy, final EStructuralFeature feature,
			Object oldValue, Object newValue) {
		((EObject) proxy).eNotify(new NotificationImpl(Notification.SET, oldValue, newValue) {

			@Override
			public Object getFeature() {
				return feature;
			}

			public Object getNotifier() {
				return proxy;
			}
		});
	}

	/**
	 * Return the {@link EDataType} associated with the given field on the given source object.
	 * 
	 * @param source
	 *           The model object
	 * @param field
	 *           The string name of the field (e.g. {@link ExtendedAttribute#getName()} or
	 *           {@link ENamedElement#getName() EstructuralFeature.getName()}).
	 * @return The {@link EDataType} associated with the given field on the given source object.
	 */
	public static EDataType getType(DeployModelObject source, String field) {
		EDataType extendedType = null;
		EClass eClass = source.eClass();
		EStructuralFeature feature = eClass.getEStructuralFeature(field);
		if (feature != null && feature.getEType() instanceof EDataType) {
			extendedType = (EDataType) feature.getEType();
		} else {
			ExtendedAttribute extendedFeature = source.getExtendedAttribute(field);
			if (extendedFeature != null) {
				extendedType = extendedFeature.getInstanceType() != null ? extendedFeature
						.getInstanceType() : EcorePackage.Literals.ESTRING;
			}
		}
		return extendedType;
	}

	/**
	 * Return the value associated with the given field on the given source object.
	 * 
	 * @param source
	 *           The model object
	 * @param field
	 *           The string name of the field (e.g. {@link ExtendedAttribute#getName()} or
	 *           {@link ENamedElement#getName() EstructuralFeature.getName()}).
	 * @return The value associated with the given field on the given source object.
	 */
	public static Object getValue(DeployModelObject source, String field) {

		EClass eClass = source.eClass();
		EStructuralFeature feature = eClass.getEStructuralFeature(field);
		if (feature != null) {
			return source.eGet(feature);
		} else {
			ExtendedAttribute extendedFeature = source.getExtendedAttribute(field);
			if (extendedFeature != null) {
				return extendedFeature.getValue();
			}
		}
		return null;
	}
}
