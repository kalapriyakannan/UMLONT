/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndex;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer;

/**
 * Provides a simple in memory index of all .topology files.
 */
public class ModelFileIndexer implements IModelFileIndexer {

	/**
	 * The topology file extension ({@value #DEPLOYMENT_TOPOLOGY_EXT}).
	 */
	public static final String DEPLOYMENT_TOPOLOGY_EXT = "topology"; //$NON-NLS-1$ 

	public static final String DEPLOYMENT_TOPOLOGYV_EXT = "topologyv"; //$NON-NLS-1$

	private static final IProject[] NO_PROJECTS = new IProject[0];

	private static final IFile[] NO_FILES = new IFile[0];

	private static final Set<String> interestingExtensions = new HashSet<String>();

	static {
		interestingExtensions.add(DEPLOYMENT_TOPOLOGY_EXT);
		interestingExtensions.add(DEPLOYMENT_TOPOLOGYV_EXT);
	}

	private final Map<IProject, ModelFileIndex> indices = new HashMap<IProject, ModelFileIndex>();

	private final Object lock = new Object();

	private final IndexHelper indexHelper = new IndexHelper();

	private final ListenerList listeners = new ListenerList();

	/**
	 * Create an instance of the indexer. Must call {@link #init()} in order to updates to the
	 * workspace.
	 * 
	 */
	public ModelFileIndexer() {

	}

	/**
	 * Configure the indexer
	 * 
	 */
	public void init() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(indexHelper,
				IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * Dipose of any resources held by the indexer and remove any listeners
	 * 
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(indexHelper);

		listeners.clear();
		indices.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer#getModelIndex(org.eclipse.core.resources.IProject,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IModelFileIndex getModelIndex(IProject project, IProgressMonitor monitor) {
		ModelFileIndex index = null;
		synchronized (lock) {
			index = indices.get(project);
			if (index == null) {
				indices.put(project, (index = new ModelFileIndex(project)));
				index.init(monitor);
			}
		}
		return index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer#addModelListener(com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener)
	 */
	public void addModelListener(AbstractModelIndexListener listener) {
		if (listener != null) {
			listeners.add(listener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer#removeModelListener(com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener)
	 */
	public void removeModelListener(AbstractModelIndexListener listener) {
		if (listener != null) {
			listeners.remove(listener);
		}
	}

	/* package */void notifyListenersOfFileChanges(IFile[] addedFiles, IFile[] removedFiles,
			IFile[][] renamedFiles) {

		if (addedFiles.length == 0 && removedFiles.length == 0) {
			return;
		}

		Object[] indexListeners = listeners.getListeners();
		AbstractModelIndexListener indexListener = null;
		NotifyListenersRunner filesAddedRunner = new NotifyOfFilesAddedRunner(addedFiles);
		NotifyListenersRunner filesRemovedRunner = new NotifyOfFilesRemovedRunner(removedFiles);
		NotifyListenersRunner filesRenamedRunner = new NotifyOfFilesRenamedRunner(renamedFiles[0],
				renamedFiles[1]);
		for (int i = 0; i < indexListeners.length; i++) {
			indexListener = (AbstractModelIndexListener) indexListeners[i];

			if (addedFiles.length > 0) {
				filesAddedRunner.setListener(indexListener);
				SafeRunner.run(filesAddedRunner);
			}

			if (removedFiles.length > 0) {
				filesRemovedRunner.setListener(indexListener);
				SafeRunner.run(filesRemovedRunner);
			}

			if (renamedFiles[0].length > 0) {
				filesRenamedRunner.setListener(indexListener);
				SafeRunner.run(filesRenamedRunner);
			}
		}
	}

	/* package */void notifyListenersOfProjectOpenChanges(IProject[] openedProjects,
			IProject[] closedProjects) {

		if (openedProjects.length == 0 && closedProjects.length == 0) {
			return;
		}

		Object[] indexListeners = listeners.getListeners();
		AbstractModelIndexListener indexListener = null;
		NotifyListenersRunner projectsOpenedRunner = new NotifyOfProjectsOpenedRunner(openedProjects);
		NotifyListenersRunner projectsClosedRunner = new NotifyOfProjectsClosedRunner(closedProjects);
		for (int i = 0; i < indexListeners.length; i++) {
			indexListener = (AbstractModelIndexListener) indexListeners[i];

			if (openedProjects.length > 0) {
				projectsOpenedRunner.setListener(indexListener);
				SafeRunner.run(projectsOpenedRunner);
			}

			if (closedProjects.length > 0) {
				projectsClosedRunner.setListener(indexListener);
				SafeRunner.run(projectsClosedRunner);
			}
		}
	}

	/* package */void notifyListenersOfProjectChanges(IProject[] newProjects,
			IProject[] deletedProjects) {

		if (newProjects.length == 0 && deletedProjects.length == 0) {
			return;
		}

		Object[] indexListeners = listeners.getListeners();
		AbstractModelIndexListener indexListener = null;
		NotifyListenersRunner projectsAddedRunner = new NotifyOfProjectsAddedRunner(newProjects);
		NotifyListenersRunner projectsRemovedRunner = new NotifyOfProjectsRemovedRunner(
				deletedProjects);
		for (int i = 0; i < indexListeners.length; i++) {
			indexListener = (AbstractModelIndexListener) indexListeners[i];

			if (newProjects.length > 0) {
				projectsAddedRunner.setListener(indexListener);
				SafeRunner.run(projectsAddedRunner);
			}

			if (deletedProjects.length > 0) {
				projectsRemovedRunner.setListener(indexListener);
				SafeRunner.run(projectsRemovedRunner);
			}
		}
	}

	private class IndexHelper implements IResourceChangeListener, IResourceDeltaVisitor {

		private final Set<IFile> addedFiles = new HashSet<IFile>();
		private final Set<IFile> removedFiles = new HashSet<IFile>();
		private final Map<IFile, IFile> renamedFiles = new LinkedHashMap<IFile, IFile>();

		private final Set<IProject> openedProjects = new HashSet<IProject>();
		private final Set<IProject> closedProjects = new HashSet<IProject>();

		private final Set<IProject> addedProjects = new HashSet<IProject>();
		private final Set<IProject> removedProjects = new HashSet<IProject>();

		public void resourceChanged(IResourceChangeEvent event) {
			if (IResourceChangeEvent.POST_CHANGE == event.getType()) {
				try {
					event.getDelta().accept(this);
				} catch (CoreException e) {
					DeployCorePlugin.logError(0, e.getMessage(), e);
				}

				try {

					IFile[] added = NO_FILES;

					if (addedFiles.size() > 0) {
						added = addedFiles.toArray(new IFile[addedFiles.size()]);
					}

					IFile[] removed = NO_FILES;
					if (removedFiles.size() > 0) {
						removed = removedFiles.toArray(new IFile[removedFiles.size()]);
					}

					IFile[][] renamed = new IFile[2][renamedFiles.size()];
					if (renamedFiles.size() > 0) {
						renamed[0] = renamedFiles.keySet().toArray(new IFile[renamedFiles.size()]);
						renamed[1] = renamedFiles.values().toArray(new IFile[renamedFiles.size()]);
					}

					notifyListenersOfFileChanges(added, removed, renamed);

					IProject[] opened = NO_PROJECTS;
					if (openedProjects.size() > 0) {
						opened = openedProjects.toArray(new IProject[openedProjects.size()]);
					}

					IProject[] closed = NO_PROJECTS;
					if (closedProjects.size() > 0) {
						closed = closedProjects.toArray(new IProject[closedProjects.size()]);
					}

					notifyListenersOfProjectOpenChanges(opened, closed);

					IProject[] newProjects = NO_PROJECTS;
					if (addedProjects.size() > 0) {
						newProjects = addedProjects.toArray(new IProject[addedProjects.size()]);
					}

					IProject[] deletedProjects = NO_PROJECTS;
					if (removedProjects.size() > 0) {
						deletedProjects = removedProjects.toArray(new IProject[removedProjects.size()]);
					}

					notifyListenersOfProjectChanges(newProjects, deletedProjects);

				} finally {
					addedFiles.clear();
					removedFiles.clear();
					renamedFiles.clear();

					openedProjects.clear();
					closedProjects.clear();

					addedProjects.clear();
					removedProjects.clear();
				}

			}
		}

		public boolean visit(IResourceDelta delta) {
			IResource resource = delta.getResource();
			switch (resource.getType())
			{
			case IResource.ROOT: {
				return true;
			}
			case IResource.PROJECT: {

				IProject project = (IProject) resource;
				if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {

					if (!project.isOpen()) {
						synchronized (lock) {
							indices.remove(project);
						}
						closedProjects.add(project);
					} else {
						openedProjects.add(project);
					}
				}

				switch (delta.getKind())
				{
				case IResourceDelta.ADDED: {
					addedProjects.add(project);
					break;
				}
				case IResourceDelta.REMOVED: {
					removedProjects.add(project);
					break;
				}
				}

				/* If not an open/close, traverse into the project only if it's indexed */
				synchronized (lock) {
					return indices.containsKey(resource);
				}
			}
			case IResource.FOLDER: {
				return true;
			}
			case IResource.FILE: {

				IFile file = (IFile) resource;
				switch (delta.getKind())
				{
				case IResourceDelta.ADDED: {
					if (interestingExtensions.contains(resource.getFileExtension())) {
						IModelFileIndex index = null;
						synchronized (lock) {
							index = indices.get(resource.getProject());
						}
						if (index != null) {
							index.addModelFile((IFile) resource);
						}

						addedFiles.add(file);

						if (delta.getMovedFromPath() != null) {

							IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
							IFile movedFrom = root.getFile(delta.getMovedFromPath());
							renamedFiles.put(movedFrom, file);
						}
					}
					break;
				}
				case IResourceDelta.REMOVED: {
					if (interestingExtensions.contains(resource.getFileExtension())) {
						IModelFileIndex index = null;
						synchronized (lock) {
							index = indices.get(resource.getProject());
						}
						if (index != null) {
							index.removeModelFile(file);
						}

						// really deleted, not moved.
						if (delta.getMovedToPath() == null) {
							removedFiles.add(file);
						}
					}
					break;
				}
				}

				return false;
			}
			}
			return false;
		}
	}

	/**
	 * A SafeRunner protects the current running process from the given client code segment.
	 * 
	 * Clients must configure the listener before submitting an instance of any subtype to
	 * {@link SafeRunner#run(ISafeRunnable)}.
	 */
	private abstract class NotifyListenersRunner implements ISafeRunnable {

		private AbstractModelIndexListener listener;

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 */
		public NotifyListenersRunner() {

		}

		/**
		 * Return the current listener to notify.
		 * 
		 * @return The current listener to notify
		 */
		public AbstractModelIndexListener getListener() {
			return listener;
		}

		/**
		 * Configure the next listener to notify.
		 * 
		 * @param newListener
		 *           The listener to notify on the next execution of this runner.
		 */
		public void setListener(AbstractModelIndexListener newListener) {
			listener = newListener;
		}

		public void handleException(Throwable ex) {
			DeployCorePlugin.logError(0, ex.getMessage(), ex);
		}
	}

	/**
	 * A SafeRunner protects the current running process from the given client code segment.
	 * 
	 * Clients must configure the listener before submitting an instance of any subtype to
	 * {@link SafeRunner#run(ISafeRunnable)}.
	 */
	private abstract class NotifyFilesListenersRunner extends NotifyListenersRunner {

		private final IFile[] modelFiles;

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 */
		public NotifyFilesListenersRunner() {
			modelFiles = NO_FILES;
		}

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param files
		 *           The set of files to pass to the listener.
		 */
		public NotifyFilesListenersRunner(IFile[] files) {
			modelFiles = files;
		}

		/**
		 * 
		 * @return The set of model files to send to the listener.
		 */
		protected final IFile[] getModelFiles() {
			return modelFiles;
		}

	}

	/**
	 * A SafeRunner protects the current running process from the given client code segment.
	 * 
	 * Clients must configure the listener before submitting an instance of any subtype to
	 * {@link SafeRunner#run(ISafeRunnable)}.
	 */
	private abstract class NotifyProjectsListenersRunner extends NotifyListenersRunner {

		private final IProject[] modelProjects;

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 */
		public NotifyProjectsListenersRunner() {
			modelProjects = NO_PROJECTS;
		}

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param files
		 *           The set of files to pass to the listener.
		 */
		public NotifyProjectsListenersRunner(IProject[] files) {
			modelProjects = files;
		}

		/**
		 * 
		 * @return The set of model files to send to the listener.
		 */
		protected final IProject[] getProjects() {
			return modelProjects;
		}

	}

	/**
	 * Safely notifies a given listener with the set of files for file additions.
	 */
	private class NotifyOfFilesAddedRunner extends NotifyFilesListenersRunner {

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param files
		 *           The set of files to pass to the listener.
		 */
		public NotifyOfFilesAddedRunner(IFile[] files) {
			/*
			 * faster than a speeding model change notification, able to leap tall heap stacks in a
			 * single function jump, it's super(files)!
			 */
			super(files);
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().modelsAdded(getModelFiles());
			}
		}
	}

	/**
	 * Safely notifies a given listener with the set of files for model file additions.
	 */
	private class NotifyOfFilesRemovedRunner extends NotifyFilesListenersRunner {

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param files
		 *           The set of files to pass to the listener.
		 */
		public NotifyOfFilesRemovedRunner(IFile[] files) {
			/*
			 * faster than a speeding model change notification, able to leap tall heap stacks in a
			 * single function jump, it's super(files)!
			 */
			super(files);
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().modelsRemoved(getModelFiles());
			}
		}
	}

	/**
	 * Safely notifies a given listener with the set of files for model file additions.
	 */
	private class NotifyOfFilesRenamedRunner extends NotifyFilesListenersRunner {

		private final IFile[] renamedFiles;

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param originalModelFiles
		 *           The set of original files to pass to the listener.
		 * @param renamedModelFiles
		 *           The set of renamed files to pass to the listener.
		 */
		public NotifyOfFilesRenamedRunner(IFile[] originalModelFiles, IFile[] renamedModelFiles) {
			/*
			 * faster than a speeding model change notification, able to leap tall heap stacks in a
			 * single function jump, it's super(files)!
			 */
			super(originalModelFiles);
			renamedFiles = renamedModelFiles;
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().modelsRenamed(getModelFiles(), renamedFiles);
			}
		}
	}

	/**
	 * Safely notifies a given listener with the set of files for file additions.
	 */
	private class NotifyOfProjectsOpenedRunner extends NotifyProjectsListenersRunner {

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param projects
		 *           The set of projects to pass to the listener.
		 */
		public NotifyOfProjectsOpenedRunner(IProject[] projects) {
			super(projects);
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().projectsOpened(getProjects());
			}
		}
	}

	/**
	 * Safely notifies a given listener with the set of files for file additions.
	 */
	private class NotifyOfProjectsClosedRunner extends NotifyProjectsListenersRunner {

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param projects
		 *           The set of projects to pass to the listener.
		 */
		public NotifyOfProjectsClosedRunner(IProject[] projects) {
			super(projects);
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().projectsClosed(getProjects());
			}
		}
	}

	/**
	 * Safely notifies a given listener with the set of files for file additions.
	 */
	private class NotifyOfProjectsAddedRunner extends NotifyProjectsListenersRunner {

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param projects
		 *           The set of files to pass to the listener.
		 */
		public NotifyOfProjectsAddedRunner(IProject[] projects) {
			super(projects);
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().projectsAdded(getProjects());
			}
		}
	}

	/**
	 * Safely notifies a given listener with the set of files for model file additions.
	 */
	private class NotifyOfProjectsRemovedRunner extends NotifyProjectsListenersRunner {

		/**
		 * Create a notification runner for the set of given files.
		 * 
		 * @param projects
		 *           The set of files to pass to the listener.
		 */
		public NotifyOfProjectsRemovedRunner(IProject[] projects) {
			super(projects);
		}

		public void run() throws Exception {
			if (getListener() != null) {
				getListener().projectsRemoved(getProjects());
			}
		}
	}

}
