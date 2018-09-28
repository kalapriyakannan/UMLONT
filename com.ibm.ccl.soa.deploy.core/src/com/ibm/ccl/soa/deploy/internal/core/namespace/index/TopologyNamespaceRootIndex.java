/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.namespace.index;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndex;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.EventQueueJob;
import com.ibm.ccl.soa.deploy.internal.core.IWorkspaceAssistant;
import com.ibm.ccl.soa.deploy.internal.core.namespace.NamespaceFragmentRoot;

/**
 * Tracks the existance of topology roots within a given project.
 * 
 * NOTE - acquiring locks within the class must obey the following order:
 * 
 * (a) Obtain the Workspace Modify Operation Rule (via Workspace.run(IWorkspaceRunnable) (if needed)
 * (b) Obtain the object monitor for the "lock" field of TopologyNamespaceRootIndex
 * 
 * Any modification of the workspace that also must acuquire the "lock" object can cause a deadlock
 * issue if the the locks are not acuquired in the above order.
 * 
 * @since 1.0
 * 
 */
public class TopologyNamespaceRootIndex extends AbstractModelIndexListener implements
		ITopologyNamespaceRootIndex {

	private static final String SETTINGS_FOLDER_NAME = ".settings"; //$NON-NLS-1$

	private static final String PERSISTED_ROOT_PROP_PREFIX = "root.path."; //$NON-NLS-1$

	private static final String PERSISTED_ROOT_INDEX = SETTINGS_FOLDER_NAME
			+ System.getProperty("file.separator") + "com.ibm.ccl.soa.deploy.namespace.prefs"; //$NON-NLS-1$ //$NON-NLS-2$ 

	private static final String TOPOLOGY_EXT = "topology"; //$NON-NLS-1$

	private static final IContainer[] EMPTY_CONTAINER = new IContainer[0];

	private final Object lock = new Object();

	private final Set rootNamespaces = new HashSet();

	private final IProject project;

	private ROTopologyModelManager modelManager = null;

	private EventQueueJob updateBootstrapJob = null;

	private static final long DELAY = 200;

	TopologyNamespaceRootIndex(IProject theProject) {
		project = theProject;
		updateBootstrapJob = new EventQueueJob(
				DeployCoreMessages.TopologyNamespaceRootIndex_Writing_topology_namespace_root_ind_,
				project.getParent());
	}

	void init(final IProgressMonitor monitor) {

		synchronized (lock) {
			if (project.isAccessible()) {
				IContainer[] roots = bootstrap(project, monitor);
				rootNamespaces.addAll(Arrays.asList(roots));
				IModelFileIndexer indexer = DeployCorePlugin.getDefault().getIndexer();
				IModelFileIndex index = indexer.getModelIndex(project, monitor);
				modelsAdded(index.getModelFiles());
				indexer.addModelListener(this);
			}
		}
	}

	public void dispose() {
		DeployCorePlugin plugin = DeployCorePlugin.getDefault();
		if (plugin != null) {

			IModelFileIndexer indexer = plugin.getIndexer();
			if (indexer != null) {
				indexer.removeModelListener(this);
			}
		}
	}

	public INamespaceFragmentRoot addTopologyRootNamespace(IContainer container) {

		synchronized (lock) {

			boolean found = false;
			for (Iterator iter = rootNamespaces.iterator(); iter.hasNext() && !found;) {
				IContainer root = (IContainer) iter.next();
				if (root.equals(container)) {
					found = true;
				}
			}

			if (!found && container.getType() != IResource.PROJECT) {
				rootNamespaces.add(container);
				updateBootstrapJob.enqueue(new SaveBootstrapAssistant(project,
						(IContainer[]) rootNamespaces.toArray(new IContainer[rootNamespaces.size()]),
						project.getFile(PERSISTED_ROOT_INDEX)));
				updateBootstrapJob.schedule(DELAY);
			}
		}

		if (container.getType() == IResource.PROJECT) {
			throw new UnsupportedOperationException(
					"Project root folders cannot be used as toplogy namespace root folders."); //$NON-NLS-1$
		}

		return new NamespaceFragmentRoot(container);
	}

	public void removeRootNamespace(IContainer folder) {

		synchronized (lock) {
			for (Iterator iter = rootNamespaces.iterator(); iter.hasNext();) {
				IContainer root = (IContainer) iter.next();
				if (root.equals(folder)) {
					rootNamespaces.remove(root);
					updateBootstrapJob.enqueue(new SaveBootstrapAssistant(project,
							(IContainer[]) rootNamespaces.toArray(new IContainer[rootNamespaces.size()]),
							project.getFile(PERSISTED_ROOT_INDEX)));
					updateBootstrapJob.schedule(DELAY);
				}
			}
		}
	}

	public INamespaceFragmentRoot createTopologyRootNamespace(IContainer container,
			IProgressMonitor monitor) throws CoreException {

		// make sure cotainer is not null
		if (container == null) {
			return null;
		}

		// make sure container is not already defined as a root
		INamespaceFragmentRoot root = addTopologyRootNamespace(container);
		if (root != null) {
			return root;
		}

		// make sure container is contained within this index's project
		if (!container.getProject().equals(project)) {
			return null;
		}

		// make sure container is not a descendent of an already existing root
		root = getRoot(container);
		if (root != null) {
			return root;
		}

		// what kind of container is this
		switch (container.getType())
		{

		case IResource.FOLDER:
			root = addTopologyRootNamespace(container);
			break;

		case IResource.PROJECT:
			throw new UnsupportedOperationException(
					"Project root folders cannot be used as toplogy namespace root folders."); //$NON-NLS-1$
		}

		return root;
	}

	public IProject getProject() {
		return project;
	}

	public INamespaceFragmentRoot[] getRootNamespaces() {
		INamespaceFragmentRoot[] roots = null;

		synchronized (lock) {
			int i = 0;
			roots = new INamespaceFragmentRoot[rootNamespaces.size()];
			for (Iterator iter = rootNamespaces.iterator(); iter.hasNext(); i++) {
				roots[i] = new NamespaceFragmentRoot((IContainer) iter.next());
			}
		}

		return roots;
	}

	/**
	 * Returns the root for the passed in folder if it is a descendent of an existing root folder.
	 * Will return null if no root exists in the folder's path to the top level project.
	 * 
	 * @param container
	 * @return
	 */
	public INamespaceFragmentRoot getRoot(IContainer container) {
		IContainer foundMatch = null;
		int foundSegmentCount = 0;
		for (Iterator iter = rootNamespaces.iterator(); iter.hasNext();) {
			IContainer root = (IContainer) iter.next();
			IPath rootPath = root.getProjectRelativePath();
			if (rootPath.isPrefixOf(container.getProjectRelativePath())) {
				if (foundMatch == null) {
					//We found our first possible match.
					foundMatch = root;
					foundSegmentCount = rootPath.segmentCount();
				} else {
					//A possible match was already found.  Check if this
					//is a better match.
					if (rootPath.segmentCount() > foundSegmentCount) {
						//Better match.
						foundMatch = root;
						foundSegmentCount = rootPath.segmentCount();
					}
				}
			}
		}
		if (foundMatch != null) {
			return new NamespaceFragmentRoot(foundMatch);
		}
		return null;
	}

	private IContainer getRoot(IFile file) {
		if (file == null || !file.getFileExtension().equalsIgnoreCase(TOPOLOGY_EXT)) {
			return null;
		}

		try {
			Topology topology = getModel(file);
			if (topology != null) {
				String namespace = topology.getNamespace();

				// if namespace is null then use the file's parent as the source folder
				if (namespace == null || namespace.equalsIgnoreCase(new String())) {
					IContainer container = file.getParent();
					IProject project = file.getProject();

					// do not support project root as topology source folders
					if (container.equals(project)) {
						return null;
					}

					return container;
				}

				String[] names = TopologyNamespaceUtil.getSimpleNames(namespace);
				String[] path = file.getParent().getProjectRelativePath().segments();

				if (names.length > path.length) {
					return null;
				}

				int nameIndex = names.length - 1;
				int pathIndex = path.length - 1;
				while (nameIndex > -1 && names[nameIndex].equalsIgnoreCase(path[pathIndex])) {
					nameIndex--;
					pathIndex--;
				}

				// if this condition is true then the namespace path 
				// and the file path did not match
				if (nameIndex > -1) {
					return null;
				}

				String rootPath = new String();
				for (int i = 0; i < pathIndex + 1; i++) {
					rootPath += IPath.SEPARATOR + path[i];
				}

				// currently do not support project root as a namespace fragment root
				if (rootPath.trim().equalsIgnoreCase(new String())) {
					return null;
				}

				IContainer container = project.getFolder(rootPath);
				if (container != null && container.exists()) {
					return container;
				}
			}

			return null;
		} finally {
			disposeModelManager();
		}
	}

	public void modelsAdded(IFile[] modelFiles) {
		if (null == modelFiles) {
			return;
		}

		ArrayList files = new ArrayList(Arrays.asList(modelFiles));
		synchronized (lock) {
			for (Iterator iter = files.iterator(); iter.hasNext();) {
				IFile file = (IFile) iter.next();
				if (null != file && file.getProject().equals(project)
						&& file.getType() == IResource.FILE
						&& file.getFileExtension().equalsIgnoreCase(TOPOLOGY_EXT)) {

					// if the topology file is not contained in an existing 
					// namespace root folder
					if (getRoot(file.getParent()) == null) {

						// try to figure out what should be the root folder for
						// this topology by looking at its namespace value
						IContainer newRoot = getRoot(file);

						// if newRoot is null then it probably means that the topology
						// was not contained in a namespace root folder and was probably
						// created in the project root ( which we will not support 
						// providing namespace content for )
						if (newRoot != null && newRoot.exists()) {
							addTopologyRootNamespace(newRoot);
						}
					}
				}
			}
		}
	}

	public void modelsRemoved(IFile[] modelFiles) {
	}

	/**
	 * Reads the contents of the .topologyroots properties file into a <code>Properties</code>
	 * object and returns the <code>IContainer</code>s that are defined within the properties
	 * file. If an exception occurs while reading the file an empty <code>IContainer[]</code> array
	 * will be returned.
	 * 
	 * @param project
	 *           the project to load the persisted roots for
	 * @param monitor
	 *           a progress monitor that tracks the percentage complete for this operation.
	 * @return a <code>IContainer[]</code> array created from the .topologyroots property file or
	 *         an empty <code>IContainer[]</code> array if no .topologyroots file was found or an
	 *         exception occured while attempting to read it.
	 */
	protected IContainer[] bootstrap(IProject project, IProgressMonitor monitor) {
		ArrayList roots = new ArrayList();

		try {
			if (!project.isAccessible()) {
				return EMPTY_CONTAINER;
			}

			// get handle to persisted root properties file
			IFile file = project.getFile(PERSISTED_ROOT_INDEX);

			// use old file location
			if (!file.exists()) {
				file = project.getFile(".topologyroots"); //$NON-NLS-1$
			}

			if (!file.exists()) {
				return EMPTY_CONTAINER;
			}

			// create new properties object from located root properties file
			Properties props = new Properties();
			props.load(file.getContents());

			// iterate through properties found in properties file
			for (int i = 0; i < props.size(); i++) {

				// if props contains the key we're looking for
				if (props.containsKey(PERSISTED_ROOT_PROP_PREFIX + i)) {

					// retreive path stored in props with this key
					String path = props.getProperty(PERSISTED_ROOT_PROP_PREFIX + i);

					// make sure path string is valid
					if (path.equalsIgnoreCase("")) { //$NON-NLS-1$
						roots.add(project);
						continue;
					}

					// retrieve handle to folder at path
					IContainer folder = project.getFolder(new Path(TopologyNamespaceUtil.concatWith(
							TopologyNamespaceUtil.getSimpleNames(path), IPath.SEPARATOR)));

					roots.add(folder);
				}
			}

		} catch (IOException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		// return empty properties object if file does not exist or exception was caught
		return (IContainer[]) roots.toArray(new IContainer[roots.size()]);
	}

	/**
	 * Saves the given <code>IContainer[]</code> array as a <code>Properties</code> file out to
	 * disk under the given project with the name .topologyroots.
	 * 
	 * @param project
	 *           the project to store the .topologyroots file under.
	 * @param roots
	 *           an <code>IContainer[]</code> array to store in the .topologyroots file.
	 * @param monitor
	 *           a progress monitor that tracks the percentage complete for this operation.
	 * @throws CoreException
	 *            thrown if there is a problem writing the property file to disk.
	 */
	protected void saveBootstrap(final IProject project, final IContainer[] roots,
			IProgressMonitor monitor) throws CoreException {
		if (project.isAccessible()) {
			updateBootstrapJob.enqueue(new SaveBootstrapAssistant(project, roots, project
					.getFile(PERSISTED_ROOT_INDEX)));
			updateBootstrapJob.schedule(DELAY);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex#resolveExistingRoot(org.eclipse.core.resources.IContainer)
	 */
	public INamespaceFragmentRoot resolveExistingRoot(IContainer container) {
		if (hasExistingRoot(container)) {
			return new NamespaceFragmentRoot(container);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex#hasExistingRoot(org.eclipse.core.resources.IContainer)
	 */
	public boolean hasExistingRoot(IContainer container) {
		for (Iterator iter = rootNamespaces.iterator(); iter.hasNext();) {
			IContainer root = (IContainer) iter.next();
			if (root.equals(container)) {
				return true;
			}
		}
		return false;
	}

	private Topology getModel(IFile file) {
		return getModelManager().openModel(file, new ROTopologyModelManager.Listener() {
			public void onUnload(IFile unloadedResource) {
			}
		});
	}

	private ROTopologyModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = ROTopologyModelManager.create();
		}
		return modelManager;
	}

	private void disposeModelManager() {
		if (modelManager != null) {
			modelManager.dispose();
			modelManager = null;
		}
	}

	private class SaveBootstrapAssistant implements IWorkspaceAssistant {

		private final IProject aProject;
		private final IContainer[] daRoots;
		private final IFile index;

		/**
		 * Create an assistant to handle the work of updating the topology roots file based on
		 * topology file additions or removals from the workspace.
		 * 
		 * @param diagramFilesToDelete
		 *           The array of files to delete
		 */
		public SaveBootstrapAssistant(IProject project, IContainer[] roots, IFile index) {
			aProject = project;
			daRoots = roots;
			this.index = index;
		}

		public ISchedulingRule getSchedulingRule() {
			return index;
		}

		public void run(IProgressMonitor monitor) throws CoreException {

			monitor.beginTask(
					DeployCoreMessages.TopologyNamespaceRootIndex_Writing_topology_namespace_root_ind_,
					1);
			try {
				synchronized (lock) {
					if (!aProject.isAccessible() || daRoots.length == 0) {
						return;
					}

					// get handle to persisted root properties file
					IFile file = project.getFile(PERSISTED_ROOT_INDEX);

					StringBuffer buf = new StringBuffer();

					for (int i = 0; i < daRoots.length; i++) {
						buf.append(PERSISTED_ROOT_PROP_PREFIX);
						buf.append(i);
						buf.append('=');
						buf.append(TopologyNamespaceUtil.concatWith(daRoots[i].getProjectRelativePath()
								.segments(), '.'));
						buf.append(System.getProperty("line.separator")); //$NON-NLS-1$
					}

					// create new InputStream from StringWriter with contents of properties object
					StringBufferInputStream contentInputStream = new StringBufferInputStream(buf
							.toString());

					// check if .settings folder exists, and create it if it does not
					IFolder settingsFolder = project.getFolder(SETTINGS_FOLDER_NAME);
					if (!settingsFolder.exists()) {
						settingsFolder.create(true, true, monitor == null ? new NullProgressMonitor()
								: monitor);
					}

					// check if properties file exists
					if (!file.exists()) {
						// create and populate file if it does not exist
						file.create(contentInputStream, true, new NullProgressMonitor());
						return;
					}

					// overwrite contents of file if exists with contents of properties object
					file.setContents(contentInputStream, true, true,
							monitor == null ? new NullProgressMonitor() : monitor);
				}
			} finally {
				monitor.done();
			}
		}
	};
}
