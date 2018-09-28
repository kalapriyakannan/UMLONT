/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.extension;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.handler.IInterfaceDescriptor;
import com.ibm.ccl.soa.deploy.saf.handler.IServiceDescriptor;

/**
 * @since 7.0
 * 
 */
public interface IInterfaceHandlerService {

	/**
	 * Return an array of all known Service types.
	 * 
	 * @return An array of all known Service types.
	 */
	IServiceDescriptor[] findAvailableServices();

	/**
	 * Returns an array of interface descriptors that understand how to contribute an interface for
	 * the given type.
	 * 
	 * @param descriptor
	 *           The descriptor of the Service.
	 * 
	 * @return An array of interface handlers that understand how to contribute an interface for the
	 *         given type.
	 */
	IInterfaceDescriptor[] findInterfaceDescriptorsForService(IServiceDescriptor descriptor);

	/**
	 * Returns an array of interface descriptors that understand how to contribute an interface for
	 * the given type.
	 * 
	 * @param eClass
	 *           The EMF Model type of the Service.
	 * 
	 * @return An array of interface handlers that understand how to contribute an interface for the
	 *         given type.
	 */
	IInterfaceDescriptor[] findInterfaceDescriptorsForService(EClass eClass);

	/**
	 * Return the {@link AbstractInterfaceHandler} for the given descriptor. <b>WARNING: This method
	 * may cause plugin loading</b>
	 * 
	 * @param descriptor
	 *           The descriptor acts as a key to find the desired instance of
	 *           {@link AbstractInterfaceHandler}
	 * @return The handler which will know how to work with the interface described by the given
	 *         descriptor.
	 */
	AbstractInterfaceHandler getInterfaceHandler(IInterfaceDescriptor descriptor);

	/**
	 * Returns an array of interface handlers that understand how to contribute an interface for the
	 * given type.
	 * 
	 * @param eClass
	 *           The EMF Model type of the Service.
	 * 
	 * @return An array of interface handlers that understand how to contribute an interface for the
	 *         given type.
	 */
	AbstractInterfaceHandler[] findInterfaceHandlersForService(EClass eClass);

	/**
	 * Returns the {@link AbstractInterfaceHandler} for the kind of the specified interface or
	 * returns <code>null</code> if the interface has no kind. The handler provides information
	 * about the interface kind that could be presented to an end user. If no interface handler
	 * supports the interface kind, <code>null</code> is returned.
	 * 
	 * @param interfaze
	 *           the interface whose handler is returned
	 * @return the handler for the specified interface
	 */
	AbstractInterfaceHandler findInterfaceHandlerForInterface(Interface interfaze);

	/**
	 * Returns an array of {@link AbstractInterfaceHandler} for the object specified. Think of this
	 * as a bottom-up approach. It returns an array of {@link AbstractInterfaceHandler} which can
	 * create an Interface starting from the object passed.
	 * 
	 * The enablement expression specified during the extension definition should match the object
	 * specified. The handler returned provides information about the implementation kind that could
	 * be presented to an end user.
	 * 
	 * If no interface handler supports the object passed, <code>null</code> is returned.
	 * 
	 * @param forObject
	 *           the object from which an Interface can get created (bottom-up approach)
	 * @return the handler for the specified object
	 */
	AbstractInterfaceHandler[] findInterfaceHandlersForObject(Object forObject);
}
