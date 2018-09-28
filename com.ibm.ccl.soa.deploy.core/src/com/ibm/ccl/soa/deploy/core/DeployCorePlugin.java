/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.osgi.framework.BundleContext;

import com.ibm.ccl.soa.deploy.core.constraint.provider.ConstraintEditPlugin;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;
import com.ibm.ccl.soa.deploy.core.provider.DeployCoreEditPlugin;
import com.ibm.ccl.soa.deploy.core.provider.DeployCoreEditPlugin.Implementation;
import com.ibm.ccl.soa.deploy.internal.core.DeployFileModificationApprover;
import com.ibm.ccl.soa.deploy.internal.core.DeployFileModificationApprover.DeployValidateEditHelper;
import com.ibm.ccl.soa.deploy.internal.core.index.ModelFileIndexer;
import com.ibm.ccl.soa.deploy.internal.core.namespace.index.TopologyNamespaceRootIndexer;

/**
 * This is the central singleton for the Appdeploy-base edit plugin. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public final class DeployCorePlugin extends Plugin {

	/**
	 * The unique identifier for the DeployCore plugin.
	 * <p>
	 * Value={@value}
	 */
	public final static String PLUGIN_ID = "com.ibm.ccl.soa.deploy.core"; //$NON-NLS-1$

	// The shared instance.
	private static DeployCorePlugin plugin;

	private final Object lock = new Object();
	private ModelFileIndexer indexer;

	private final Object rootLock = new Object();
	private TopologyNamespaceRootIndexer rootIndexer;

	private Implementation coreImpl;

	private com.ibm.ccl.soa.deploy.core.constraint.provider.ConstraintEditPlugin.Implementation constraintImpl;

	private DeployFileModificationApprover fileModificationApprover;

	/**
	 * Default constructor.
	 * 
	 */
	public DeployCorePlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);

		coreImpl = new DeployCoreEditPlugin.Implementation();
		coreImpl.start(context);

		fileModificationApprover = new DeployFileModificationApprover();
		OperationHistoryFactory.getOperationHistory().addOperationApprover(fileModificationApprover);
		constraintImpl = new ConstraintEditPlugin.Implementation();
		constraintImpl.start(context);

		// This has the effect of putting the model properties on the
		// GMF properties view.
// adapterFactory = createAdapterFactory();
// MSLAdapterFactoryManager.register(adapterFactory);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		coreImpl.stop(context);
		constraintImpl.stop(context);
		plugin = null;

		if (indexer != null) {
			indexer.dispose();
			indexer = null;
		}

		if (rootIndexer != null) {
			rootIndexer.dispose();
			rootIndexer = null;
		}

		OperationHistoryFactory.getOperationHistory().removeOperationApprover(
				fileModificationApprover);
	}

	/**
	 * Return the indexer which manages knowledge about the location of the model files throughout
	 * the workspace.
	 * 
	 * @return The indexer singleton which tracks available model files in the workspace.
	 */
	public IModelFileIndexer getIndexer() {
		synchronized (lock) {
			if (indexer == null) {
				indexer = new ModelFileIndexer();
				indexer.init();
			}
		}
		return indexer;
	}

	public ITopologyNamespaceRootIndexer getTopologyNamespaceRootIndexer() {
		synchronized (rootLock) {
			if (rootIndexer == null) {
				rootIndexer = new TopologyNamespaceRootIndexer();
			}
		}
		return rootIndexer;
	}

	/**
	 * @return The shared instance.
	 */
	public static DeployCorePlugin getDefault() {
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
		if (aStatus != null) {
			getDefault().getLog().log(aStatus);
		}
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
		String msg = aMessage == null ? "No message." : aMessage; //$NON-NLS-1$
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

	/**
	 * Return a subprogress monitor properly configured to show labels on the main monitor.
	 * 
	 * @param monitor
	 *           The parent monitor for which this child monitor will measure a subportion of the
	 *           overall task.
	 * @param ticks
	 *           The number of ticks from the parent monitor to be counted off by the returned child
	 *           monitor.
	 * @return a subprogress monitor properly configured to show labels on the main monitor.
	 */
	public static IProgressMonitor subprogress(IProgressMonitor monitor, int ticks) {
		return new SubProgressMonitor(monitor, ticks,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
	}

	public void setDeployValidateEditHelper(DeployValidateEditHelper helper) {
		fileModificationApprover.setHelper(helper);
	}

	public DeployValidateEditHelper getDeployValidateEditHelper() {
		return fileModificationApprover.getHelper();
	}
}
