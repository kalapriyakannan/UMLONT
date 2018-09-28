/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the LDAP edit plugin.
 * 
 * @author Ed Snible <snible@us.ibm.com>
 */
public final class LdapDeployPlugin extends Plugin {

	/**
	 * The unique identifier for the LdapDeploy plugin.
	 * 
	 * <p>
	 * Value={@value}
	 * </p>
	 */
	public final static String PLUGIN_ID = "com.ibm.ccl.soa.deploy.ldap"; //$NON-NLS-1$

	//The shared instance.
	private static LdapDeployPlugin plugin;

	/**
	 * Default constructor.
	 */
	public LdapDeployPlugin() {
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static LdapDeployPlugin getDefault() {
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
	 * @param exception
	 *           An exception that was thrown, if any.
	 */
	public static void log(int severity, int aCode, String aMessage, Throwable exception) {
		log(createStatus(severity, aCode, aMessage, exception));
	}

	/**
	 * Publish the status to the log.
	 * 
	 * @param aStatus
	 *           The status to publish to the log.
	 */
	public static void log(IStatus aStatus) {
		if (aStatus != null) {
			getDefault().getLog().log(aStatus);
		}
	}

	/**
	 * Create a status using the LdapDeployPlugin's id.
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param exception
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createStatus(int severity, int aCode, String aMessage, Throwable exception) {
		String msg = aMessage == null ? "No message." : aMessage; //$NON-NLS-1$
		return new Status(severity, PLUGIN_ID, aCode, msg, exception);
	}

	/**
	 * Create a status with the severity set to {@link IStatus#ERROR}.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param exception
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createErrorStatus(int aCode, String aMessage, Throwable exception) {
		return createStatus(IStatus.ERROR, aCode, aMessage, exception);
	}
}
