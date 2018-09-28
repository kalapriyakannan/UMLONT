/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

import org.eclipse.core.runtime.ISafeRunnable;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * A common base type for any {@link ISafeRunnable} instances in the Deploy Core plugin. Implements
 * the default logging behavior for any code run from the Deploy Core Plugin.
 * 
 * @since 1.0
 * 
 */
public abstract class DeployCoreSafeRunnable implements ISafeRunnable {

	public void handleException(Throwable exception) {
		logException(exception.getMessage(), exception);
	}

	protected void logException(String message, Throwable exception) {
		String msg = message == null ? exception.getMessage() : message;
		DeployCorePlugin.logError(0, msg, exception);
	}

	public abstract void run() throws Exception;

}
