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

import com.ibm.ccl.soa.deploy.internal.saf.ui.extension.ISAFUIExtensionConstants;
import com.ibm.ccl.soa.deploy.internal.saf.ui.extension.UIHandlerService;

/**
 * Creates implementations of {@link IUIHandlerService}
 * 
 */
public class SAFUIServiceFactory {

	/**
	 * 
	 * @return An implementation of {@link IUIHandlerService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUIHandlerService createInterfaceUIHandlerService() {
		return new UIHandlerService(ISAFUIExtensionConstants.TAG_INTERFACE_UIHANDLER);
	}

	/**
	 * 
	 * @return An implementation of {@link IUIHandlerService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUIHandlerService createArtifactUIHandlerService() {
		return new UIHandlerService(ISAFUIExtensionConstants.TAG_ARTIFACT_UIHANDLER);
	}
}
