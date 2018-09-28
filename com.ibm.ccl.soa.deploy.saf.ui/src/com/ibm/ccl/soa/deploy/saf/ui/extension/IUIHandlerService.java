/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.saf.ui.extension;

import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;
import com.ibm.ccl.soa.deploy.saf.ui.handler.IUIHandlerDescriptor;

/**
 * Interface for a service that understands the <code>com.ibm.ccl.soa.core.saf.ui.uihandlers</code>
 * extension point.
 * 
 * @see IInterfaceUIHandler
 */
public interface IUIHandlerService {

	/**
	 * Returns the {@link AbstractInterfaceUIHandler} for the interface kind of the specified
	 * interface or returns <code>null</code> if the interface has no kind. The handler provides
	 * information about the interface kind that could be presented to an end user. If no interface
	 * UI handler supports the interface kind, <code>null</code> is returned.
	 * 
	 * @param substitutableKind
	 *           the interface kind whose handler is returned
	 * @return the UI handler for the specified interface
	 */
	public AbstractUIHandler findSubstitutableUIHandlerForKind(String substitutableKind);

	/**
	 * Returns the {@link AbstractInterfaceUIHandler} for the kind of the specified interface or
	 * returns <code>null</code> if the interface has no kind. The handler provides information
	 * about the interface kind that could be presented to an end user. If no interface handler
	 * supports the interface kind, <code>null</code> is returned.
	 * 
	 * @param substitutable
	 *           the interface whose handler is returned
	 * @return the UI handler for the specified interface
	 */
	public AbstractUIHandler findUIHandlerForSubstitutable(Substitutable substitutable);

	/**
	 * Return descriptors for the relevant type of UI Handler.
	 * 
	 * @return descriptors for the relevant type of UI Handler.
	 */
	public IUIHandlerDescriptor[] findAllUIHandlerDescriptors();

	/**
	 * Return descriptors for the relevant type of UI Handler for the given kind.
	 * 
	 * @return descriptors for the relevant type of UI Handler for the given kind.
	 */
	public IUIHandlerDescriptor findAllUIHandlerDescriptors(String kind);

}
