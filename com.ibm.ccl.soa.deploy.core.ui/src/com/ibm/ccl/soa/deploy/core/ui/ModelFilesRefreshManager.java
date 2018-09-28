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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.AbstractTreeViewer;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;

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
public class ModelFilesRefreshManager {

	// Schedule the job with a 100ms delay
	private static final int DELAY = 200;

	private final AbstractModelIndexListener fileListener = new AbstractModelIndexListener() {

		public void modelsAdded(IFile[] modelFiles) {

			for (int i = 0; i < modelFiles.length; i++) {
				if (modelFiles[i].getParent() != null) {
					refreshJob.enqueue(modelFiles[i].getParent());
				}
			}
		}

		public void projectsClosed(IProject[] projects) {
			for (int i = 0; i < projects.length; i++) {
				refreshJob.enqueue(projects[i]);
			}

		}

		public void projectsOpened(IProject[] projects) {
			for (int i = 0; i < projects.length; i++) {
				refreshJob.enqueue(projects[i]);
			}
		}

	};

	private final ROTopologyModelManager.Listener modelListener = new ROTopologyModelManager.Listener() {
		public void onUnload(IFile unloadedResource) {
			if (unloadedResource.getProject().isAccessible()) {
				refreshJob.enqueue(unloadedResource);
			}
		}
	};

	/**
	 * Create a job that will refresh objects from a thread safe queue for a particular viewer.
	 */
	private final RefreshJob refreshJob;

	private ROTopologyModelManager modelManager = null;

	/**
	 * Create a refresh manager for the given viewer. Objects may be
	 * {@link #enqueue(Object) enqueued} for update in the viewer. Updates are delayed slightly to
	 * minimize potential viewer flickering, and all updates are safely run in the UI thread.
	 * 
	 * @param viewer
	 *           The viewer to configure the refresh manager with.
	 * @return The refresh manager for the viewer.
	 */
	public static ModelFilesRefreshManager create(AbstractTreeViewer viewer) {
		ModelFilesRefreshManager manager = new ModelFilesRefreshManager(viewer);
		return manager;
	}

	private ModelFilesRefreshManager(AbstractTreeViewer viewer) {
		refreshJob = new RefreshJob(viewer, DELAY);
		DeployCorePlugin.getDefault().getIndexer().addModelListener(fileListener);
	}

	/**
	 * Returns the Topology contained by the file, or null.
	 * 
	 * Models accessed through this method will automatically be refreshed in the viewer on unloads.
	 * The refresh semantics assume the model is rendered as a child of the IFile that contains it.
	 * 
	 * @param file
	 *           A file that ends in *.topology and contains a Topology model object.
	 * @return The Topology model object contained by the file or <b>null</b> if the file does not
	 *         contain a model or if the model cannot be properly read.
	 */
	public Topology getModel(IFile file) {
		return getModelManager().openModel(file, modelListener);
	}

	private ROTopologyModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = ROTopologyModelManager.create();
		}
		return modelManager;
	}

	/**
	 * Enqueue the given object for refresh in the viewer.
	 * 
	 * @param refreshable
	 *           The object that requires refreshing in the viewer.
	 */
	public void enqueue(Object refreshable) {

		if (refreshable != null) {
			refreshJob.enqueue(refreshable);
		}
	}

	/**
	 * Dispose of any allocated resources and remove the refresh manager as a listener to any other
	 * notification systems.
	 * 
	 */
	public void dispose() {
		DeployCorePlugin.getDefault().getIndexer().removeModelListener(fileListener);
	}

}
