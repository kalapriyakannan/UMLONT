package com.ibm.ccl.soa.deploy.net;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class NetPlugin extends Plugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "com.ibm.ccl.soa.deploy.net"; //$NON-NLS-1$

	// The shared instance
	private static NetPlugin plugin;
	
	/**
	 * The constructor
	 */
	public NetPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static NetPlugin getDefault() {
		return plugin;
	}
	
	/**
	 * Log an error using the plugin id of the DeployCorePlugin.
	 * 
	 * @param aCode
	 *            A message code for the created status
	 * @param aMessage
	 *            A message describing the error
	 * @param anException
	 *            An exception that was thrown, if any.
	 */
	public static void logError(int aCode, String aMessage,
			Throwable anException) {
		getDefault().getLog().log(
				createErrorStatus(aCode, aMessage, anException));
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin
	 * 
	 * @param severity
	 *            The severity of message (see {@link IStatus}).
	 * @param aCode
	 *            A message code for the created status
	 * @param aMessage
	 *            A message describing the error
	 * @param anException
	 *            An exception that was thrown, if any.
	 */
	public static void log(int severity, int aCode, String aMessage,
			Throwable anException) {
		log(createStatus(severity, aCode, aMessage, anException));
	}

	/**
	 * Log an exception.
	 * 
	 * @param severity
	 *            the log status severity.
	 * @param e
	 *            the logged exception.
	 */
	public static void log(int severity, Throwable e) {
		if (e != null) {
			String message;
			if (e.getLocalizedMessage() != null) {
				message = e.getLocalizedMessage();
			} else {
				message = e.getClass().getName();
			}
			log(createStatus(IStatus.ERROR, 0, message, e));
		}
	}

	/**
	 * Publish the status to the log.
	 * 
	 * @param aStatus
	 *            The status to publish to the log.
	 */
	public static void log(IStatus aStatus) {
		if (aStatus != null) {
			getDefault().getLog().log(aStatus);
		}
	}

	/**
	 * Create a status using the DeployCorePlugin's id.
	 * 
	 * @param severity
	 *            The severity of message (see {@link IStatus}).
	 * @param aCode
	 *            A message code for the created status
	 * @param aMessage
	 *            A message describing the error
	 * @param anException
	 *            An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createStatus(int severity, int aCode,
			String aMessage, Throwable anException) {
		String msg = aMessage == null ? "No message." : aMessage; //$NON-NLS-1$
		return new Status(severity, PLUGIN_ID, aCode, msg, anException);
	}

	/**
	 * Create a status with the severity set to {@link IStatus#ERROR}.
	 * 
	 * @param aCode
	 *            A message code for the created status
	 * @param aMessage
	 *            A message describing the error
	 * @param anException
	 *            An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createErrorStatus(int aCode, String aMessage,
			Throwable anException) {
		return createStatus(IStatus.ERROR, aCode, aMessage, anException);
	}

	/**
	 * Return a subprogress monitor properly configured to show labels on the
	 * main monitor.
	 * 
	 * @param monitor
	 *            The parent monitor for which this child monitor will measure a
	 *            subportion of the overall task.
	 * @param ticks
	 *            The number of ticks from the parent monitor to be counted off
	 *            by the returned child monitor.
	 * @return a subprogress monitor properly configured to show labels on the
	 *         main monitor.
	 */
	public static IProgressMonitor subprogress(IProgressMonitor monitor,
			int ticks) {
		return new SubProgressMonitor(monitor, ticks,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
	}

}
