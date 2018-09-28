/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui;

import java.text.MessageFormat;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.extension.SAFUIServiceFactory;

/**
 * The main plug-in class to be used on the desktop.
 */
public class SAFUIPlugin extends AbstractUIPlugin {
	public final static String PLUGIN_ID = "com.ibm.ccl.soa.deploy.saf.ui"; //$NON-NLS-1$

	//The shared instance.
	private static SAFUIPlugin plugin;

	/**
	 * The constructor.
	 */
	public SAFUIPlugin() {
		plugin = this;
	}

	/**
	 * Instance of the BindingHandlerService
	 */
	private static IUIHandlerService interfaceUIHandlerService = SAFUIServiceFactory
			.createInterfaceUIHandlerService();

	/**
	 * @return Returns the singleton instance of the UnitProviderService
	 */
	public IUIHandlerService getInterfaceUIHandlerService() {
		return interfaceUIHandlerService;
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static SAFUIPlugin getDefault() {
		return plugin;
	}

	public static String internalReportConfigurationError(String msgTemplate, Object[] values) {
		// Report an error from the internal plugin.properties file.
		String error = MessageFormat.format(msgTemplate, values);
		logError(0, error, new Exception());
		return error;
	}

	/**
	 * @return eclipse log
	 */
	public static ILog getLogger() {
		return SAFUIPlugin.getDefault().getLog();
	}

	/**
	 * @param msgSource
	 * @param methodName
	 * @param level
	 * @param message
	 */
	public static void log(Object msgSource, String methodName, int level, String message) {
		if (message == null) {
			message = ""; //$NON-NLS-1$
		}

		SAFUIPlugin.getLogger().log(new Status(level, PLUGIN_ID, IStatus.OK, message, null));
	}

	/**
	 * @param msgSource
	 * @param methodName
	 * @param level
	 * @param exc
	 */
	public static void log(Object msgSource, String methodName, int level, Throwable exc) {
		SAFUIPlugin.getLogger().log(new Status(level, PLUGIN_ID, IStatus.OK, "", exc)); //$NON-NLS-1$
	}

	/**
	 * @param msgSource
	 * @param methodName
	 * @param level
	 * @param message
	 * @param exc
	 */
	public static void log(Object msgSource, String methodName, int level, String message,
			Throwable exc) {
		if (message == null) {
			message = ""; //$NON-NLS-1$
		}
		SAFUIPlugin.getLogger().log(new Status(level, PLUGIN_ID, IStatus.OK, message, exc));
	}

	public static void log(Object msgSource, String methodName, IStatus status) {
		SAFUIPlugin.getLogger().log(status);
	}

	/**
	 * Publish the status to the log.
	 * 
	 * @param aStatus
	 *           The status to publish to the log.
	 */
	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void logError(int aCode, String aMessage, Throwable anException) {
		getDefault().getLog().log(createErrorStatus(aCode, aMessage, anException));
	}

	public static IStatus createStatus(int severity, int aCode, String aMessage, Throwable exception) {
		return new Status(severity, PLUGIN_ID, aCode, aMessage, exception);
	}

	public static IStatus createErrorStatus(int aCode, String aMessage, Throwable exception) {
		return createStatus(IStatus.ERROR, aCode, aMessage, exception);
	}

	public static IStatus createErrorStatus(String aMessage, Throwable exception) {
		return createStatus(IStatus.ERROR, 0, aMessage, exception);
	}
}
