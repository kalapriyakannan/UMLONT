/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.index;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.index.IndexMessages;
import com.ibm.ccl.soa.deploy.internal.core.index.ModelFileIndex;
import com.ibm.ccl.soa.deploy.internal.core.index.ModelFileIndexer;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.EditModelScribblerListener;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * A Read-Only Topology model manager. Clients are required to {@link #dispose()} of a model manager
 * when done with it. Model managers may <b>ABSOLUTELY NEVER</b> be used as singletons.
 * 
 * Clients that want a manifest of all models in a project should use the indexer.
 * 
 * @see DeployCoreUIPlugin#getIndexer()
 * @see ModelFileIndexer#getModelIndex(IProject)
 * @see ModelFileIndex#getModelFiles()
 * 
 */
public class ROTopologyModelManager {

	protected static final String NAMESPACE = "modelmanager.readonly."; //$NON-NLS-1$

	protected static final IResourceDescriptor[] NO_DESCRIPTORS = new IResourceDescriptor[0];

	private final Object lock = new Object();

	private final InternalState internalState = new InternalState(this);

	private final Map notificationMap /* <IFile, ListenerList<ROTopologyModelManager.Listener> */= new HashMap();

	/**
	 * Provides a callback mechanism for the ROTopologyModelManager to notify the client that a
	 * previously requested model object was unloaded. No guarantees are made about when this method
	 * may be called. The client may have lost interest in the particular file in the notification.
	 */
	public static interface Listener {

		/**
		 * Handle the unload reaction for the given file.
		 * 
		 * @param unloadedResource
		 *           An file representation of an EMF resource that has recently been unloaded.
		 */
		public void onUnload(IFile unloadedResource);
	}

	/**
	 * Create an instance of a Read-only Topology Model Manager.
	 * 
	 * Clients must {@link #dispose()} of this instance when done with it.
	 * 
	 * @return A read-only Topology Model Manager.
	 */
	public static ROTopologyModelManager create() {
		// leave room for instance tracking and disposal
		return new ROTopologyModelManager();
	}

	private ROTopologyModelManager() {
	}

	/**
	 * Clients are <b>absolutely, positively, no-opporunity-otherwise</b> REQUIRED to dispose of
	 * model managers when complete. Model managers may <b>ABSOLUTELY NEVER</b> be used as
	 * singletons.
	 * 
	 */
	public void dispose() {
		internalState.dispose();
	}

	/**
	 * Open a Topology model contained in the given IFile for read-only purposes. Returns <b>null</b>
	 * when the file does not contain a Topology or when a problem occurs while trying to read the
	 * Topology.
	 * 
	 * @param topologyFile
	 *           The topology file to open
	 * @param unloadReaction
	 *           A non-null reaction listener to detect when a particular file has been unloaded.
	 * @return A read-only model object for representing the underlying model in the topology file.
	 * @see Listener
	 */
	public Topology openModel(IFile topologyFile, Listener unloadReaction) {
		return openModel(topologyFile, unloadReaction, true);
	}

	public void closeModel(IFile topologyFile) {

		if (topologyFile.isAccessible()) {
			if (IConstants.TOPOLOGY_EXTENSION.equals(topologyFile.getFileExtension())) {

				unbindListener(topologyFile);

				IEditModelScribbler scribbler = internalState.findScribbler(topologyFile.getProject(),
						false /* create */);

				if (scribbler != null) {
					Resource resource = scribbler.getResource(topologyFile.getFullPath(),
							IEditModelScribbler.OPTION_NONE);
					if (resource != null) {
						scribbler.releaseResource(resource);
					}
				}
			}
		}
	}

	/**
	 * Open a Topology model contained in the given IFile for read-only purposes. Returns <b>null</b>
	 * when the file does not contain a Topology or when a problem occurs while trying to read the
	 * Topology.
	 * 
	 * @param topologyFile
	 *           The topology file to open
	 * @param unloadReaction
	 *           A non-null reaction listener to detect when a particular file has been unloaded.
	 * @param forceLoad
	 *           If True, the model will be loaded; otherwise if not already loaded, null will be
	 *           returned.
	 * @return A read-only model object for representing the underlying model in the topology file.
	 * @see Listener
	 */
	public Topology openModel(IFile topologyFile, Listener unloadReaction, boolean forceLoad) {

		if (topologyFile.isAccessible()) {
			if (IConstants.TOPOLOGY_EXTENSION.equals(topologyFile.getFileExtension())) {

				bindListener(topologyFile, unloadReaction);

				IEditModelScribbler scribbler = internalState.findScribbler(topologyFile.getProject(),
						forceLoad /* create */);
				int options = forceLoad ? IEditModelScribbler.OPTION_LOAD_RESOURCE
						: IEditModelScribbler.OPTION_NONE;
				if (scribbler != null) {
					Resource resource = scribbler.getResource(topologyFile.getFullPath(), options);
					if (resource != null && resource.getContents().size() > 0) {
						Object root = resource.getContents().get(0);
						if (root instanceof DeployCoreRoot) {
							DeployCoreRoot deployRoot = (DeployCoreRoot) root;
							return deployRoot.getTopology();
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * Bind a listener for the given topology file.
	 * 
	 * @param topologyFile
	 *           A topology file whose model was recently loaded.
	 * @param unloadReaction
	 *           A listener that will be notified when the given file is unloaded.
	 */
	private void bindListener(IFile topologyFile, ROTopologyModelManager.Listener unloadReaction) {
		Assert.isNotNull(unloadReaction);
		synchronized (lock) {
			ListenerList listeners = (ListenerList) notificationMap.get(topologyFile);
			if (listeners == null) {
				notificationMap.put(topologyFile, listeners = new ListenerList());
			}
			listeners.add(unloadReaction);
		}
	}

	/**
	 * Unbind a listener for the given topology file.
	 * 
	 * @param topologyFile
	 *           A topology file whose model was recently loaded.
	 */
	private void unbindListener(IFile topologyFile) {
		synchronized (lock) {
			notificationMap.remove(topologyFile);
		}
	}

	/**
	 * Notify listeners that the given topology file was unloaded.
	 * 
	 * @param topologyFile
	 *           The topology file for which a model was unloaded.
	 */
	private void notifyListeners(final IFile topologyFile) {
		ListenerList listeners = null;
		synchronized (lock) {
			listeners = (ListenerList) notificationMap.get(topologyFile);
		}
		if (null != listeners && listeners.size() > 0) {
			final Object[] notificationList = listeners.getListeners();
			for (int i = 0; i < notificationList.length; i++) {
				SafeRunner.run(new ModelUnloadedNotifier(
						(ROTopologyModelManager.Listener) notificationList[i], topologyFile));
			}
		}
	}

	/**
	 * Safely notify a given listener that a model file has been unloaded.
	 */
	public static class ModelUnloadedNotifier implements ISafeRunnable {

		private final Listener listener;
		private final IFile modelFile;

		/**
		 * Create a safe runner to notify the listener of the given file.
		 * 
		 * @param l
		 *           A listener to notify of a file unload event
		 * @param f
		 *           The file that was affected
		 */
		public ModelUnloadedNotifier(Listener l, IFile f) {
			listener = l;
			modelFile = f;
		}

		public void run() throws Exception {
			listener.onUnload(modelFile);
		}

		public void handleException(Throwable exception) {
			DeployCorePlugin.logError(0, exception.getMessage(), exception);
		}
	}

	/**
	 * Keep the internal state separate from the outer type so that we can track when a client has
	 * ceased to use the enclosing type without formally calling
	 * {@link ROTopologyModelManager#dispose()}.
	 */
	public static class InternalState extends AbstractModelIndexListener {

		/* Use an internal object monitor to prevent deadlocks on the InternalState monitor */
		private final Object lock = new Object();

		private boolean disposed = false;

		private final Map/* <IProject, IEditModelScribbler> */scribblerMap = new HashMap();

		private final WeakReference reference;

		private final EditModelScribblerListener scribblerListener = new EditModelScribblerListener() {

			public void resourcesUnloaded(IEditModelScribbler source, Resource[] resources) {

				ROTopologyModelManager manager = (ROTopologyModelManager) reference.get();
				if (manager != null) {
					IFile modelFile = null;
					for (int i = 0; i < resources.length; i++) {
						modelFile = WorkbenchResourceHelper.getFile(resources[i]);
						manager.notifyListeners(modelFile);
					}
				}
			}

		};

		/**
		 * Create an internal state representation for the given manager. The manager will be kept in
		 * a WeakReference, so that the creation of internal state doesn't prevent the reclamation of
		 * the manager object, if not properly disposed by a client.
		 * 
		 * @param manager
		 */
		public InternalState(ROTopologyModelManager manager) {
			reference = new WeakReference(manager);
			DeployCorePlugin.getDefault().getIndexer().addModelListener(this);
		}

		/**
		 * Located and (possibly) create a general-purpose scribbler for the given project.
		 * 
		 * @param key
		 *           The project to open the scribbler for.
		 * @param toCreate
		 *           True indicates the scribbler should be created; false may cause the method to
		 *           return null.
		 * @return A scribbler for the given project or null if toCreate is false.
		 */
		public IEditModelScribbler findScribbler(IProject key, boolean toCreate) {

			IEditModelScribbler scribbler = null;
			synchronized (lock) {

				scribbler = (IEditModelScribbler) scribblerMap.get(key);

				if (scribbler == null && toCreate && !disposed) {
					scribblerMap.put(key, scribbler = createScribbler(key));
				}

			}
			return scribbler;

		}

		/**
		 * Removes any listeners registered by this type along with cleaning up any allocated
		 * resources that must be destroyed.
		 * 
		 */
		public void dispose() {

			// cleanup the straggling listener
			DeployCorePlugin.getDefault().getIndexer().removeModelListener(this);

			IEditModelScribbler scribbler = null;
			synchronized (lock) {

				for (Iterator iter = scribblerMap.entrySet().iterator(); iter.hasNext();) {
					Map.Entry entry = (Map.Entry) iter.next();
					try {
						scribbler = (IEditModelScribbler) entry.getValue();
						scribbler.close(new NullProgressMonitor());
						iter.remove();
					} catch (EditModelException e) {
						DeployCorePlugin.logError(0, e.getMessage(), e);
					}

				}

				disposed = true;
			}

		}

		private IEditModelScribbler createScribbler(final IProject key) {

			IEditModelScribbler scribbler = null;
			try {
				scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(key,
						new DefaultScribblerDomain() {

							public String getEditModelLabel() {
								return NAMESPACE + key.getName();
							}

							public IResourceDescriptor[] getResourceDescriptors() {
								return NO_DESCRIPTORS;
							}

						});
				scribbler.addListener(scribblerListener);
			} catch (EditModelException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
			return scribbler;
		}

		public void projectsClosed(final IProject[] projects) {
			handleDisposal(projects);
		}

		public void projectsRemoved(final IProject[] projects) {
			handleDisposal(projects);
		}

		/**
		 * @param projects
		 *           A set of projects that has either been closed or removed.
		 */
		private void handleDisposal(final IProject[] projects) {
			if (isValid()) {

				/*
				 * don't want to pop UI because this is called from the resources change notification
				 * thread
				 */
				IProgressMonitor monitor = new NullProgressMonitor();

				ROTopologyModelManager manager = (ROTopologyModelManager) reference.get();

				if (manager != null) {
					IEditModelScribbler scribbler = null;
					monitor.beginTask(IndexMessages.ROTopologyModelManager_Closing_managed_resource_,
							projects.length);
					for (int i = 0; i < projects.length; i++) {
						try {
							synchronized (lock) {

								scribbler = (IEditModelScribbler) scribblerMap.remove(projects[i]);

								if (scribbler != null) {
									scribbler.close(monitor);
								}
							}

						} catch (EditModelException e) {
							DeployCorePlugin.logError(0, e.getMessage(), e);
						}
					}
				}
			} else {
				dispose();
			}
		}

		private boolean isValid() {
			if (reference.get() == null) {
				return false;
			}
			return true;
		}

	}

	/* package */InternalState getInternalState() {
		return internalState;
	}

}
