/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.handler;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.internal.saf.extension.InterfaceHandlerDescriptor;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;

/**
 * This class is to be extended by all interface handler contributions.
 */
public abstract class AbstractInterfaceHandler extends AbstractHandler {

	private InterfaceHandlerDescriptor descriptor;

	/**
	 * Store the descriptor for this handler. The descriptor parses and interprets information from
	 * the extension that defined this handler.
	 * 
	 * @param config
	 *           The descriptor for this handler.
	 */
	public final void setDescriptor(InterfaceHandlerDescriptor config) {
		descriptor = config;
	}

	/**
	 * Returnthe descriptor for this handler. The descriptor parses and interprets information from
	 * the extension that defined this handler.
	 * 
	 * @return The descriptor for this handler.
	 */
	public final InterfaceHandlerDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * Queries if an <code>Interface</code> of the kind supported by this handler can be created
	 * for the specified interface object. If this method returns <code>true</code>, the handler's
	 * {@link #createInterfaceFor(Object interfaceObj)} method may be called to create an
	 * <code>Interface</code> for the interface object.
	 * <p>
	 * This method should be quick to execute as it may be called to populate a context menu or a
	 * user dialog. When interfaceObj is a container, a quick check should be performed to verify
	 * that an SCA Interface can be created from one of the objects contained by interfaceObj
	 * (container). For example, if interfaceObj is a file, perhaps the file extension can be checked
	 * rather than opening the file to inspect its contents. If this method returns <code>true</code>
	 * for an invalid container, the {@link #createInterfaceFor(Object interfaceObj) } can throw an
	 * {@link InvalidOperationException} to let the caller know that an Interface could not be
	 * created from it.
	 * 
	 * @param interfaceObj
	 *           an object representing the interface
	 * @return <code>true</code> if the handler can create an Interface from the specified object;
	 *         <code>false</code> otherwise
	 */
	public final boolean canCreateInterfaceFor(Object interfaceObj) {
		return getDescriptor() != null ? getDescriptor().isEnabled(interfaceObj)
				|| getDescriptor().isBound(interfaceObj) : false;
	}

	/**
	 * Creates an Interface from the given interface object.
	 * <p>
	 * The interface object can be an object supported by the
	 * {@link #canCreateInterfaceFor(Object interfaceObject) } or returned by the
	 * {@link IInterfaceUIHandler#getInterfaceObjects(IResource) } method.
	 * 
	 * @param interfaceObj
	 *           the object representing the interface
	 * @return the new SCA Interface
	 * @exception SAFException
	 *               An unexpected exception occurred.
	 * @exception InvalidOperationException
	 *               An interface cannot be created from the given interface object.
	 */
	public abstract Interface createInterfaceFor(Object interfaceObj) throws SAFException,
			InvalidOperationException;

	/**
	 * Creates an Interface from the given service type object.
	 * 
	 * @param serviceType
	 *           The EClass of the service that will contain the resultant interface.
	 * @return the new SCA Interface
	 * @exception SAFException
	 *               An unexpected exception occurred.
	 * @exception InvalidOperationException
	 *               An interface cannot be created from the given interface object.
	 */
	public abstract Interface createInterfaceForService(EClass serviceType) throws SAFException,
			InvalidOperationException;

	public String getPropertyLabel(Object object) {
		return object instanceof Interface ? getInterfacePropertyLabel((Interface) object) : ""; //$NON-NLS-1$
	}

	/**
	 * Creates a string that combines all property values for an interface for use in a property
	 * sheet.
	 * 
	 * @param interfaze
	 * 
	 * @return a string that combines all property values for this interface
	 */
	public String getInterfacePropertyLabel(Interface interfaze) {
		return null;
	}

}
