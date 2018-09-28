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

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A delegate for the Requirement.class type.
 * 
 * @since 1.0
 * 
 */
public class RequirementDelegate extends TypeDelegate {

	private static final EStructuralFeature DMOTYPE_FEATURE = CorePackage.eINSTANCE
			.getRequirement_DmoType();

	/** The {@link Requirement#getLink()} method. */
	private static final Method GET_LINK;

	/** The {@link Requirement#setLink(DependencyLink)} method. */
	private static final Method SET_LINK;

	/** The {@link Requirement#getDmoEType()} method. */
	private static final Method GET_DMOETYPE;

	/** The {@link Requirement#setDmoEType(org.eclipse.emf.ecore.EClass)} method. */
	private static final Method SET_DMOETYPE;

	private static final Map<Method, MethodHandler> staticHandlers = new HashMap<Method, MethodHandler>();

	static {
		Method method = null;

		try {
			method = Requirement.class.getMethod("getLink", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_LINK = method;

		try {
			method = Requirement.class.getMethod("setLink", new Class[] { DependencyLink.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		SET_LINK = method;

		try {
			method = Requirement.class.getMethod("getDmoEType", NO_PARAMETERS); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		GET_DMOETYPE = method;

		try {
			method = Requirement.class.getMethod("setDmoEType", new Class[] { EClass.class }); //$NON-NLS-1$
		} catch (NoSuchMethodException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		SET_DMOETYPE = method;

	}

	static {
		staticHandlers.put(GET_LINK, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Topology edited = config.getEditTopology();

				Object result = method.invoke(config.getSource(), args);
				if (result == null && edited != null) {
					result = edited.getDependencyLink(config.getFullyQualifiedPath());
				}
				return result != null ? config.getService().findProxy((DeployModelObject) result,
						config.getImported()) : null;
			}
		});
		staticHandlers.put(SET_LINK, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				Topology edited = config.getEditTopology();

				DependencyLink existing = config.getEditTopology().getDependencyLink(
						config.getFullyQualifiedPath());
				if (existing != null) {
					edited.getDependencyLinks().remove(existing);
					existing.setSource(null);
				}
				DependencyLink link = (DependencyLink) args[0];

				// look up the proxy for this handler
				link.setSource((Requirement) proxy);
				edited.getDependencyLinks().add(link);
				return null;
			}
		});
		staticHandlers.put(GET_DMOETYPE, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {
				InstanceConfiguration delegateConfig = config.getImported().getInstanceConfiguration();
				if (delegateConfig != null) {
					Object configuredValue = getConfiguredValue(config, delegateConfig, DMOTYPE_FEATURE
							.getName());
					if (configuredValue != null) {
						return deserializeCapabilityType(configuredValue);
					}
				}
				QName dmoType = (QName) config.getSource().eGet(DMOTYPE_FEATURE);
				if (dmoType != null) {
					return deserializeCapabilityType(dmoType);
				}
				return null;

			}
		});
		staticHandlers.put(SET_DMOETYPE, new MethodHandler() {
			public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
					throws Throwable {

				InstanceConfiguration delegateConfig = config.getImported().getInstanceConfiguration();
				if (delegateConfig != null) {
					EClass eClass = (EClass) args[0];

					EPackage epkg = eClass.getEPackage();
					QName newValue = (QName) XMLTypeUtil.createQName(epkg.getNsURI(),
							ExtendedMetaData.INSTANCE.getName(eClass), epkg.getNsPrefix());

					setConfiguredValue(config, delegateConfig, DMOTYPE_FEATURE.getName(), proxy,
							newValue);

				}
				return null; // Do NOT call super
			}
		});
	}

	/**
	 * Create a delegate using the standard delegates.
	 */
	public RequirementDelegate() {
		super(staticHandlers);
	}

	/**
	 * Create a delegate using the given <Method, MethodHandler> map.
	 * 
	 * @param methodHandlers
	 *           Map of <java.lang.reflect.Method, MethodHandler>-pairs.
	 */
	public RequirementDelegate(Map methodHandlers) {
		super(methodHandlers);
	}

	/**
	 * Deserializes the capability type QName.
	 * 
	 * @param obj
	 *           a serialized capability type QName.
	 * @return the deserialized EClass.
	 * 
	 */
	protected static EClass deserializeCapabilityType(Object obj) {
		assert obj != null;

		QName qName = (QName) obj;
		if (qName.getNamespaceURI() != null && qName.getNamespaceURI().length() > 0) {
			String packageURI = qName.getNamespaceURI();
			if (packageURI == null) {
				throw new RuntimeException(NLS.bind(DeployCoreMessages.Cannot_resolve_namespace_0,
						qName.getNamespaceURI()));
			}
			EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(packageURI);
			if (pkg == null) {
				throw new RuntimeException(NLS.bind(DeployCoreMessages.Cannot_resolve_namespace_0,
						packageURI));
			}
			return (EClass) pkg.getEClassifier(qName.getLocalPart());
		}
		return (EClass) CorePackage.eINSTANCE.getEClassifier(qName.getLocalPart());
	}
}