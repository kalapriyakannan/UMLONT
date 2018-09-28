/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui;

import org.eclipse.jface.viewers.AbstractTreeViewer;

/**
 * Provides a utility class that follows a well defined lifecycle for managing model refreshes for
 * content providers.
 * 
 * 
 * First, fetch the refresh manager for a particular viewer:
 * 
 * <code>
 * 
 * private ModelFilesRefreshManager manager;
 * 
 * ...
 * 
 * ModelFilesRefreshManager manager = ModelFilesRefreshManager.createRefreshManager(viewer);
 * </code>
 * 
 * If your viewer reference changes in ITreeContentProvider.inputChanged(), be sure to dispose the
 * existing manager and create a new one:
 * 
 * 
 * <code>
 * public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
 *     
 *    Assert.isTrue(viewer instanceof AbstractTreeViewer);
 *    
 *    AbstractTreeViewer treeViewer = (AbstractTreeViewer) viewer;
 *    if(manager != null) { 
 *    	manager.dispose(); // dispose current manager
 *    }    
 *    manager = ModelFilesRefreshManager.createRefreshManager(treeViewer);
 * 
 * }
 * </code>
 * 
 * Also be sure to dispose the RefreshManager in your content provider's dispose method:
 * 
 * 
 * <code>
 * public void dispose() {
 *    ...
 *    manager.dispose(); // dispose current manager
 *    ...
 * }
 * </code>
 * 
 */
public class ModelFilesUpdateManager {

	// Schedule the job with a 100ms delay
	private static final int DELAY = 200;

	/**
	 * Create a job that will refresh objects from a thread safe queue for a particular viewer.
	 */
	private final UpdateJob updateJob;

	/**
	 * Create an update manager for the given viewer. Objects may be
	 * {@link #enqueue(Object) enqueued} for update in the viewer. Updates are delayed slightly to
	 * minimize potential viewer flickering, and all updates are safely run in the UI thread.
	 * 
	 * @param viewer
	 *           The viewer to configure the refresh manager with.
	 * @return The refresh manager for the viewer.
	 */
	public static ModelFilesUpdateManager create(AbstractTreeViewer viewer) {
		ModelFilesUpdateManager manager = new ModelFilesUpdateManager(viewer);
		return manager;
	}

	private ModelFilesUpdateManager(AbstractTreeViewer viewer) {
		updateJob = new UpdateJob(viewer, DELAY);
	}

	/**
	 * Enqueue the given object for refresh in the viewer.
	 * 
	 * @param updateable
	 *           The object that requires updating in the viewer.
	 */
	public void enqueue(Object updateable) {

		if (updateable != null) {
			updateJob.enqueue(updateable);
		}
	}

}
