/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.internal.saf.SAFPlugin;

/**
 * Provide a wrapper around the <tt>handlerBinding</tt> of the
 * <b>com.ibm.ccl.soa.deploy.saf.handlers</b> extension point.
 * 
 */
public class InterfaceHandlerBindingDescriptor implements ISAFExtensionConstants {

	private final Set<String> interfaces = new HashSet<String>(4);
	private final Set<String> serviceTypes = new HashSet<String>(4);
	private final IConfigurationElement element;

	/**
	 * 
	 * @param anElement
	 *           The configuration element to wrap.
	 */
	public InterfaceHandlerBindingDescriptor(IConfigurationElement anElement) {
		Assert.isNotNull(anElement);
		Assert.isTrue(TAG_HANDLER_BINDING.equals(anElement.getName()));
		element = anElement;
		init();
	}

	private IConfigurationElement getElement() {
		return element;
	}

	private void init() {

		IConfigurationElement[] intfs = getElement().getChildren(TAG_INTERFACE);
		if (intfs.length > 0) {
			for (int i = 0; i < intfs.length; i++) {
				interfaces.add(intfs[i].getAttribute(ATTR_TYPE));
			}
		} else {
			SAFPlugin.logError(0, "The " + getElement().getDeclaringExtension().getUniqueIdentifier() //$NON-NLS-1$
					+ " extension defined by " + getElement().getNamespaceIdentifier() //$NON-NLS-1$
					+ " does not contain any interfaces in one of its bindings.", null); //$NON-NLS-1$
		}

		IConfigurationElement[] svcs = getElement().getChildren(TAG_SERVICE_TYPE);
		if (svcs.length > 0) {
			for (int i = 0; i < svcs.length; i++) {
				serviceTypes.add(svcs[i].getAttribute(ATTR_TYPE));
			}
		} else {
			SAFPlugin.logError(0, "The " + getElement().getDeclaringExtension().getUniqueIdentifier() //$NON-NLS-1$
					+ " extension defined by " + getElement().getNamespaceIdentifier() //$NON-NLS-1$
					+ " does not contain any services in one of its bindings.", null); //$NON-NLS-1$
		}

	}

	/**
	 * Return true if the current binding knows about the given service or false otherwise.
	 * 
	 * @param serviceType
	 *           The fully qualified class name of a Service type (e.g. "org.acme.AcmeService")
	 * @return True if the current binding knows about the given service or false otherwise.
	 */
	public boolean isServiceTypeBound(String serviceType) {
		if (serviceTypes.contains(serviceType)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if the current binding knows about the given interface or false otherwise.
	 * 
	 * @param interfaceType
	 *           The fully qualified class name of a Interface type (e.g. "org.acme.AcmeInterface")
	 * @return True if the current binding knows about the given interface or false otherwise.
	 */
	public boolean isInterfaceTypeBound(String interfaceType) {
		if (interfaces.contains(interfaceType)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if the current binding knows about the given service and interface or false
	 * otherwise.
	 * 
	 * @param serviceType
	 *           The fully qualified class name of a Service type (e.g. "org.acme.AcmeService")
	 * @param interfaze
	 *           The fully qualified class name of an Interface type (e.g. "org.acme.Interface");
	 * @return True if the current binding knows about the given service and interface or false
	 *         otherwise.
	 */
	public boolean isBound(String serviceType, String interfaze) {
		if (serviceTypes.contains(serviceType)) {
			return interfaces.contains(interfaze);
		}
		return false;
	}

	/**
	 * Return the set of interfaces that this binding knows about.
	 * 
	 * @return The set of interfaces that this binding knows about.
	 */
	public Set<String> getInterfaces() {
		return Collections.unmodifiableSet(interfaces);
	}

	/**
	 * Return the set of known service types for this descriptor. A "serviceType" is a fully
	 * qualified class name of the Service class.
	 * 
	 * @return The set of known service types for this descriptor.
	 */
	public Set<String> getServiceTypes() {
		return Collections.unmodifiableSet(serviceTypes);
	}

	/**
	 * Return true if the current binding knows about the given service and interface or false
	 * otherwise.
	 * 
	 * @param service
	 *           The EClass of a Service type
	 * @param interfaze
	 *           The specific Interface
	 * @return True if the current binding knows about the given service and interface or false
	 *         otherwise.
	 */
	public boolean isBound(EClass service, Interface interfaze) {
		if (serviceTypes.contains(service.getInstanceClassName())) {
			EClass interfazeClass = interfaze.eClass();
			return interfaces.contains(interfazeClass.getInstanceClassName());
		}
		return false;
	}
}
