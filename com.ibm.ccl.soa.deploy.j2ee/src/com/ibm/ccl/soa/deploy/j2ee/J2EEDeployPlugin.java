/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import com.ibm.ccl.soa.deploy.j2ee.provider.J2eeEditPlugin;
import com.ibm.ccl.soa.deploy.j2ee.provider.J2eeEditPlugin.Implementation;

/**
 * Main plugin class for J2EE Deploy.
 */
public final class J2EEDeployPlugin extends Plugin {
	public final static String pluginID = "com.ibm.ccl.soa.deploy.j2ee"; //$NON-NLS-1$

	//	The shared instance.
	private static J2EEDeployPlugin plugin;

	private Implementation implementation;

	/**
	 * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public J2EEDeployPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		implementation = new J2eeEditPlugin.Implementation();
		implementation.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
		implementation.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static J2EEDeployPlugin getDefault() {
		return plugin;
	}

	public static void logError(int aCode, String aMessage, Throwable anException) {
		getDefault().getLog().log(createErrorStatus(aCode, aMessage, anException));
	}

	public static void log(int severity, int aCode, String aMessage, Throwable exception) {
		log(createStatus(severity, aCode, aMessage, exception));
	}

	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	/**
	 * Create a new IStatus with a severity using the J2EEPlugin ID. aCode is just an internal code.
	 */
	public static IStatus createStatus(int severity, int aCode, String aMessage, Throwable exception) {
		return new Status(severity, pluginID, aCode, aMessage, exception);
	}

	/**
	 * If this is called from an operation, in response to some other exception that was caught, then
	 * the client code should throw {@link com.ibm.etools.wft.util.WFTWrappedException}; otherwise
	 * this can still be used to signal some other error condition within the operation, or to throw
	 * a core exception in a context other than executing an operation
	 * 
	 * Create a new IStatus of type ERROR using the J2EEPlugin ID. aCode is just an internal code.
	 */
	public static IStatus createErrorStatus(int aCode, String aMessage, Throwable exception) {
		return createStatus(IStatus.ERROR, aCode, aMessage, exception);
	}
}
