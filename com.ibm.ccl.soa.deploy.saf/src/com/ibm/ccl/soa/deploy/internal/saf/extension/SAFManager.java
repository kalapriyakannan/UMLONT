/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.internal.saf.SAFPlugin;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.handler.IServiceDescriptor;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;
import com.ibm.ccl.soa.infrastructure.emf.RegistryReader;

/**
 * Parse the <b>com.ibm.ccl.soa.core.saf.handlers</b> extension point into structures that can be
 * more easily manipulated.
 */
public class SAFManager {

	private static final SAFManager instance = new SAFManager();

	private static final InterfaceHandlerDescriptor[] NO_ELEMENTS_INTERFACE_HANDLER_DESCRIPTOR = new InterfaceHandlerDescriptor[0];

	private final Set<InterfaceHandlerDescriptor> interfaceHandlerDescriptors = new HashSet<InterfaceHandlerDescriptor>();
	private final Set<InterfaceHandlerBindingDescriptor> bindingDescriptors = new HashSet<InterfaceHandlerBindingDescriptor>();
	private final Set<IServiceDescriptor> serviceDescriptors = new HashSet<IServiceDescriptor>();

	/**
	 * @return The singleton instance of the UnitDiscovererManager.
	 */
	public static SAFManager getInstance() {
		return instance;
	}

	private SAFManager() {
		new SAFRegistry().readRegistry();
		configureRelevantBindings();
	}

	private void configureRelevantBindings() {
		for (Iterator<InterfaceHandlerDescriptor> handlers = interfaceHandlerDescriptors.iterator(); handlers
				.hasNext();) {
			InterfaceHandlerDescriptor handler = handlers.next();
			for (Iterator<InterfaceHandlerBindingDescriptor> iterator = bindingDescriptors.iterator(); iterator
					.hasNext();) {
				InterfaceHandlerBindingDescriptor binding = iterator.next();
				if (binding.isInterfaceTypeBound(handler.getType())) {
					handler.getRelevantBindings().add(binding);
				}
			}
		}

	}

	/**
	 * Return the set of interface descriptors that define {@link AbstractInterfaceHandler}s.
	 * 
	 * @return The set of interface descriptors that define {@link AbstractInterfaceHandler}s
	 */
	public Iterator<InterfaceHandlerDescriptor> findAllInterfaceHandlerDescriptors() {
		return interfaceHandlerDescriptors.iterator();
	}

	/**
	 * Find the available interface handlers for the given object. The object represent an instance
	 * of some Service which may have an interface set on it.
	 * 
	 * @param obj
	 *           The object that should have interface contributed.
	 * @return The array of descriptors that define handlers which may contribute an interface to the
	 *         given object.
	 */
	public InterfaceHandlerDescriptor[] findInterfaceHandlersDescriptorForObject(Object obj) {
		Set<InterfaceHandlerDescriptor> foundDescriptors = new HashSet<InterfaceHandlerDescriptor>();

		// look for descriptors based on their enablement expressions
		InterfaceHandlerDescriptor handler = null;
		for (Iterator<InterfaceHandlerDescriptor> handlers = findAllInterfaceHandlerDescriptors(); handlers
				.hasNext();) {
			handler = handlers.next();
			if (handler.isEnabled(obj)) {
				foundDescriptors.add(handler);
			} else if (handler.isBound(obj)) {
				foundDescriptors.add(handler);
			}
		}

		if (foundDescriptors.isEmpty()) {
			return NO_ELEMENTS_INTERFACE_HANDLER_DESCRIPTOR;
		}

		return foundDescriptors.toArray(new InterfaceHandlerDescriptor[foundDescriptors.size()]);
	}

	/**
	 * Find the available interface handlers for the given Service type. A single Service Type may
	 * have multiple interface handlers, as well as an interface handler may support multiple Service
	 * Types.
	 * 
	 * @param eClass
	 *           The EClass of the Service type that desires an interface
	 * @return The array of descriptors that define handlers which may contribute an interface to the
	 *         given EClass.
	 */
	public InterfaceHandlerDescriptor[] findInterfaceDescriptorsForServiceType(EClass eClass) {
		return findInterfaceDescriptorsForServiceType(eClass.getInstanceClassName());
	}

	/**
	 * Find the available interface handlers for the given Service type. A single Service Type may
	 * have multiple interface handlers, as well as an interface handler may support multiple Service
	 * Types.
	 * 
	 * @param serviceType
	 *           The fully qualified Java class name of the Service type that desires an interface
	 * @return The array of descriptors that define handlers which may contribute an interface to the
	 *         given EClass.
	 */
	public InterfaceHandlerDescriptor[] findInterfaceDescriptorsForServiceType(String serviceType) {

		if (CorePackage.Literals.SERVICE.getInstanceClassName().equals(serviceType)) {
			return interfaceHandlerDescriptors
					.toArray(new InterfaceHandlerDescriptor[interfaceHandlerDescriptors.size()]);
		}

		Set<InterfaceHandlerDescriptor> foundDescriptors = new HashSet<InterfaceHandlerDescriptor>();

		InterfaceHandlerBindingDescriptor binding = null;
		InterfaceHandlerDescriptor handler = null;

		List<String> foundInterfaces = new ArrayList<String>();
		for (Iterator<InterfaceHandlerBindingDescriptor> bindings = bindingDescriptors.iterator(); bindings
				.hasNext();) {
			binding = bindings.next();
			if (binding.isServiceTypeBound(serviceType)) {
				foundInterfaces.addAll(binding.getInterfaces());
			}
		}

		for (Iterator<String> interfacesIter = foundInterfaces.iterator(); interfacesIter.hasNext();) {
			String interfaze = interfacesIter.next();
			for (Iterator<InterfaceHandlerDescriptor> descriptors = findAllInterfaceHandlerDescriptors(); descriptors
					.hasNext();) {
				handler = descriptors.next();
				if (handler.isSupportedInterface(interfaze)) {
					foundDescriptors.add(handler);
				}
			}
		}

		if (foundDescriptors.isEmpty()) {
			return NO_ELEMENTS_INTERFACE_HANDLER_DESCRIPTOR;
		}

		return foundDescriptors.toArray(new InterfaceHandlerDescriptor[foundDescriptors.size()]);
	}

	/**
	 * Find the available interface handlers for the given object. The object represent an instance
	 * of some Service which may have an interface set on it.
	 * 
	 * @param interfaze
	 *           The Interface object that needs to be manipulated.
	 * @return The array of descriptors that define handlers which may contribute an interface to the
	 *         given object.
	 */
	public InterfaceHandlerDescriptor findInterfaceDescriptorForInterface(Interface interfaze) {

		InterfaceHandlerDescriptor descriptor = null;
		for (Iterator<InterfaceHandlerDescriptor> descriptors = findAllInterfaceHandlerDescriptors(); descriptors
				.hasNext();) {
			descriptor = descriptors.next();
			if (descriptor.isSupportedInterface(interfaze)) {
				return descriptor;
			}
		}

		return null;
	}

	/**
	 * Provide a list of the available Service Descriptors for use in selecting a Service to create
	 * or work with.
	 * 
	 * @return The set of available Service Descriptors.
	 */
	public Set<IServiceDescriptor> getServiceDescriptors() {
		return Collections.unmodifiableSet(serviceDescriptors);
	}

	private void addInterfaceHandlerDescriptor(InterfaceHandlerDescriptor descriptor) {
		Assert.isNotNull(descriptor);
		interfaceHandlerDescriptors.add(descriptor);
	}

	private void addBindingDescriptor(InterfaceHandlerBindingDescriptor descriptor) {
		Assert.isNotNull(descriptor);
		bindingDescriptors.add(descriptor);
	}

	private void addServiceDescriptor(ServiceDescriptor descriptor) {
		Assert.isNotNull(descriptor);
		serviceDescriptors.add(descriptor);
	}

	/**
	 * Does the low level work of parsing the Eclipse registry.
	 * 
	 * @since 1.0
	 * 
	 */
	private class SAFRegistry extends RegistryReader implements ISAFExtensionConstants {

		private SAFRegistry() {
			super(Platform.getExtensionRegistry(), SAFPlugin.PLUGIN_ID, HANDLERS_EXT_POINT_ID);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_INTERFACE_HANDLER.equals(element.getName())) {
				addInterfaceHandlerDescriptor(new InterfaceHandlerDescriptor(element));
				return true;
			} else if (TAG_HANDLER_BINDING.equals(element.getName())) {
				addBindingDescriptor(new InterfaceHandlerBindingDescriptor(element));
				return true;
			} else if (TAG_SERVICE.equals(element.getName())) {
				addServiceDescriptor(new ServiceDescriptor(element));
				return true;
			}
			return false;
		}

	}

}
