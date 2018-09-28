/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.handler.IInterfaceDescriptor;
import com.ibm.ccl.soa.deploy.saf.handler.IServiceDescriptor;

/**
 * Provides a concrete implementation of IInterfaceHandlerService.
 */
public class InterfaceHandlerService implements IInterfaceHandlerService {

	private static final AbstractInterfaceHandler[] NO_ELEMENTS_INTERFACE_HANDLER = new AbstractInterfaceHandler[0];

	private final Map<IInterfaceDescriptor, AbstractInterfaceHandler> interfaceHandlers = new HashMap<IInterfaceDescriptor, AbstractInterfaceHandler>();

	private AbstractInterfaceHandler[] createHandlers(InterfaceHandlerDescriptor[] descriptors) {

		if (descriptors == null || descriptors.length == 0) {
			return NO_ELEMENTS_INTERFACE_HANDLER;
		}
		AbstractInterfaceHandler[] handlers = new AbstractInterfaceHandler[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			handlers[i] = getInterfaceHandler(descriptors[i]);
		}

		return handlers;
	}

	/**
	 * @param interfaze
	 * @return handler
	 */
	public AbstractInterfaceHandler findInterfaceHandlerForInterface(Interface interfaze) {
		InterfaceHandlerDescriptor descriptor = SAFManager.getInstance()
				.findInterfaceDescriptorForInterface(interfaze);
		return getInterfaceHandler(descriptor);

	}

	public AbstractInterfaceHandler[] findInterfaceHandlersForObject(Object forObject) {
		InterfaceHandlerDescriptor[] descriptors = SAFManager.getInstance()
				.findInterfaceHandlersDescriptorForObject(forObject);

		return createHandlers(descriptors);
	}

	public AbstractInterfaceHandler[] findInterfaceHandlersForService(EClass eClass) {
		InterfaceHandlerDescriptor[] descriptors = SAFManager.getInstance()
				.findInterfaceDescriptorsForServiceType(eClass);

		return createHandlers(descriptors);
	}

	public AbstractInterfaceHandler getInterfaceHandler(IInterfaceDescriptor aDescriptor) {
		AbstractInterfaceHandler handler = null;
		synchronized (interfaceHandlers) {
			handler = interfaceHandlers.get(aDescriptor);
			if (handler == null) {
				interfaceHandlers.put(aDescriptor, handler = aDescriptor.createInterfaceHandler());
			}
		}
		return handler;
	}

	public IServiceDescriptor[] findAvailableServices() {
		Set<IServiceDescriptor> descriptors = SAFManager.getInstance().getServiceDescriptors();
		return descriptors.toArray(new IServiceDescriptor[descriptors.size()]);
	}

	public IInterfaceDescriptor[] findInterfaceDescriptorsForService(EClass eClass) {
		return SAFManager.getInstance().findInterfaceDescriptorsForServiceType(eClass);
	}

	public IInterfaceDescriptor[] findInterfaceDescriptorsForService(IServiceDescriptor descriptor) {
		return SAFManager.getInstance().findInterfaceDescriptorsForServiceType(
				descriptor.getServiceType());
	}

}
