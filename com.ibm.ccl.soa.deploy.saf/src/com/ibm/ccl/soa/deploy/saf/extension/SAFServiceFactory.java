/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.extension;

import com.ibm.ccl.soa.deploy.internal.saf.extension.InterfaceHandlerService;

/**
 * Creates implementations of {@link IBindingHandlerService}, {@link IInterfaceHandlerService},
 * {@link IImplementationHandlerService}.
 * 
 */
public class SAFServiceFactory {

	/**
	 * 
	 * @return An implementation of {@link IInterfaceHandlerService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IInterfaceHandlerService createInterfaceHandlerService() {
		return new InterfaceHandlerService();
	}

}
