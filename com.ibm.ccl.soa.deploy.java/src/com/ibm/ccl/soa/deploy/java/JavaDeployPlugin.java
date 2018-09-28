/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Java deploy domain plugin.
 */
public final class JavaDeployPlugin extends Plugin {
	/** Unique plug-in identifier. */
	public final static String PLUGIN_ID = "com.ibm.ccl.soa.deploy.java"; //$NON-NLS-1$

	// The shared instance.
	private static JavaDeployPlugin plugin;

	/**
	 * Default constructor.
	 */
	public JavaDeployPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * @return the shared instance.
	 */
	public static JavaDeployPlugin getDefault() {
		return plugin;
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

	/**
	 * Log an error using the plugin id of the DeployCorePlugin
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void log(int severity, int aCode, String aMessage, Throwable anException) {
		log(createStatus(severity, aCode, aMessage, anException));
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
	 * Create a status using the DeployCorePlugin's id.
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createStatus(int severity, int aCode, String aMessage,
			Throwable anException) {
		String msg = aMessage == null ? "" : aMessage; //$NON-NLS-1$
		return new Status(severity, PLUGIN_ID, aCode, msg, anException);
	}

	/**
	 * Create a status with the severity set to {@link IStatus#ERROR}.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createErrorStatus(int aCode, String aMessage, Throwable anException) {
		return createStatus(IStatus.ERROR, aCode, aMessage, anException);
	}

}
