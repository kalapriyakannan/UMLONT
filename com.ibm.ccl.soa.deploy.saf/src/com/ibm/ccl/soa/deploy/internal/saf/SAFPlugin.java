/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import com.ibm.ccl.soa.deploy.internal.saf.extension.ISAFExtensionConstants;

/**
 * the main plugin class to be used in the desktop
 */
public class SAFPlugin extends Plugin {
//	Plugin ID (value must match that used in plugin.xml).
	public static final String PLUGIN_ID = "com.ibm.ccl.soa.deploy.saf"; //$NON-NLS-1$

	//the shared instance
	private static SAFPlugin plugin;

	/**
	 * the constructor.
	 */
	public SAFPlugin() {
		plugin = this;
	}

	/**
	 * This method is called when the plug-in is activated.
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped.
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * @return the shared instance
	 */
	public static SAFPlugin getDefault() {
		return plugin;
	}

	/**
	 * @return the plugin's resource bundle
	 */
	public ResourceBundle getResourceBundle() {
		try {
			return Platform.getResourceBundle(getBundle());
		} catch (MissingResourceException e) {
			return null;
		}
	}

	/**
	 * Returns the list of extensions that extend the "handlers" extension point of this plug-in.
	 * 
	 * @return an array of matching extensions
	 */
	public IExtension[] getHandlerContributions() {

		// Note: The identifier below must match the extension point ID in plugin.xml.

		IExtension[] extensions = null;

		// Note: The identifier below must match the plug-in ID in plugin.xml.
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID,
				ISAFExtensionConstants.HANDLERS_EXT_POINT_ID);
		if (extensionPoint != null) {
			extensions = extensionPoint.getExtensions();
		}//if

		return extensions;
	}//getComponentImplementationHandlerExtensions()

	/**
	 * Returns the list of extensions that extend the "context" extension point of this plugin.
	 * 
	 * @return An array of matching extensions
	 */
	public IExtension[] getContextContibutions() {

		// Note: The identifier below must match the extension point ID in plugin.xml.

		IExtension[] extensions = null;

		// Note: The identifier below must match the plug-in ID in plugin.xml.
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID,
				ISAFExtensionConstants.CONTEXT_EXT_POINT_ID);
		if (extensionPoint != null) {
			extensions = extensionPoint.getExtensions();
		}//if

		return extensions;
	}//getContextContibutions()

	/**
	 * Returns the list of extensions that extend the "contextExtension" extension point of this
	 * plugin.
	 * 
	 * @return An array of matching extensions
	 */
	public IExtension[] getContextExtensionContibutions() {

		// Note: The identifier below must match the extension point ID in plugin.xml.

		IExtension[] extensions = null;

		// Note: The identifier below must match the plug-in ID in plugin.xml.
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID,
				ISAFExtensionConstants.CONTEXTEXTENSION_EXT_POINT_ID);
		if (extensionPoint != null) {
			extensions = extensionPoint.getExtensions();
		}//if

		return extensions;
	}//getContextExtensionContibutions()

	/**
	 * @return eclipse log
	 */
	public static ILog getLogger() {
		return SAFPlugin.getDefault().getLog();
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

		SAFPlugin.getLogger().log(new Status(level, PLUGIN_ID, IStatus.OK, message, null));
	}

	/**
	 * @param msgSource
	 * @param methodName
	 * @param level
	 * @param exc
	 */
	public static void log(Object msgSource, String methodName, int level, Throwable exc) {
		SAFPlugin.getLogger().log(new Status(level, PLUGIN_ID, IStatus.OK, "", exc)); //$NON-NLS-1$
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
		SAFPlugin.getLogger().log(new Status(level, PLUGIN_ID, IStatus.OK, message, exc));
	}

	public static void log(Object msgSource, String methodName, IStatus status) {
		SAFPlugin.getLogger().log(status);
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
