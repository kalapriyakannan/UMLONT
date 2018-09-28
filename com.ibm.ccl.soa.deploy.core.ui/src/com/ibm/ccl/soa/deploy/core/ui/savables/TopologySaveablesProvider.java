package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.model.AdaptableList;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchPartLabelProvider;
import org.eclipse.ui.navigator.SaveablesProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ModelFilesRefreshManager;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;

/**
 * <p>
 * Implementation of DiagramSaveablesProvider for the Zephyr components that are contributed to the
 * common navigator. This class provides the saveables for Zephyr artifacts ( *.topology and
 * *.topologyv ). This implementation registers itself as an ArtifactListener with the
 * TopologyArtifactsMonitor to manage it's internal list of TopologySaveables.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class TopologySaveablesProvider extends SaveablesProvider {

	protected final TopologyArtifactsMonitor monitor;
	protected ModelFilesRefreshManager refreshManager;
	protected final Store saveables;
	protected ArtifactListener listener;
	private static final int DELAY = 100;
	private boolean initialized = false;
	private boolean disposed = false;
	private final Object lock = new Object();

	private abstract class SafeUIJob extends UIJob {

		public SafeUIJob(String name) {
			super(name);
			setSystem(true);
		}

		@Override
		public boolean shouldRun() {
			if (PlatformUI.getWorkbench().isClosing() || isDisposed()) {
				return false;
			}
			synchronized (lock) {
				return initialized && !disposed;
			}
		}

	}

	/**
	 * <p>
	 * Creates a new instance of TopologySaveablesProvider, and registers itself as an
	 * ArtifactListener with the TopologyArtifactsMonitor.
	 * </p>
	 * 
	 */
	public TopologySaveablesProvider() {
		saveables = new Store(TopologySaveablesProvider.this);
		listener = new SaveablesArtifactListener(this);
		monitor = TopologyArtifactsMonitor.INSTANCE;
		monitor.addListener(listener);
	}

	@Override
	protected void doInit() {
		super.doInit();
		initialized = true;
		CheckForPreviouslyOpenedEditorsJob job = new CheckForPreviouslyOpenedEditorsJob(listener);
		job.schedule(Job.SHORT);
	}

	/**
	 * <p>
	 * Sets the instance of ModelFilesRefreshManager to be used by this class when it receives
	 * notification of updates to topology artifacts.
	 * </p>
	 * 
	 * @param refresher
	 *           an instance of ModelFilesRefreshManager
	 */
	public void setRefreshManager(ModelFilesRefreshManager refresher) {
		refreshManager = refresher;
	}

	/**
	 * Return the current Refresh Manager.
	 * 
	 * @return
	 */
	public ModelFilesRefreshManager getRefreshManager() {
		return refreshManager;
	}

	protected static class SaveablesArtifactListener extends ArtifactListener {

		private final WeakReference<TopologySaveablesProvider> reference;

		public SaveablesArtifactListener(TopologySaveablesProvider provider) {
			reference = new WeakReference(provider);
		}

		private TopologySaveablesProvider getProvider() {
			return reference.get();
		}

		/**
		 * {@inheritDoc}
		 */
		public void onModelChanged(final IFile model) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			TopologySaveable saveable = provider.saveables.locateSaveable(new IFile[] { model }, true);
			if (null != saveable) {
				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
				if (model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onModelClosed(IFile model) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			TopologySaveable saveable = provider.saveables
					.locateSaveable(new IFile[] { model }, false);

			List<IFile> diagrams = new ArrayList<IFile>();
			if (null != saveable) {
				diagrams = saveable.getDiagramArtifacts();
			}

			provider.saveables.removeSaveable(new IFile[] { model }, true);

			if (null != saveable) {
				provider.fireSaveablesClosedInUIJob(new Saveable[] { saveable });
			}
			if (model.getProject().isAccessible() && provider.initialized) {
				provider.enqueue(model);

				// refresh all diagrams associated with this model's saveable
				for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {
					provider.enqueue(iter.next());
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onModelOpened(IFile model) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			TopologySaveable saveable = provider.saveables.locateSaveable(new IFile[] { model }, true);
			if (null != saveable) {
				if (model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onModelSaved(IFile model) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			TopologySaveable saveable = provider.saveables.locateSaveable(new IFile[] { model }, true);
			if (null != saveable) {
				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
				if (model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onModelsAboutToBeRemoved(List<IFile> models) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			List<TopologySaveable> affected = new ArrayList<TopologySaveable>();
			for (Iterator<IFile> iter = models.iterator(); iter.hasNext();) {
				TopologySaveable saveable = provider.saveables.locateSaveable(
						new IFile[] { iter.next() }, false);
				if (saveable != null && !affected.contains(saveable)) {
					affected.add(saveable);
				}
			}

			if (affected.size() > 0) {
				provider.fireSaveablesClosing(affected.toArray(new Saveable[affected.size()]), false);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onModelRemoved(IFile model) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			TopologySaveable saveable = provider.saveables
					.locateSaveable(new IFile[] { model }, false);
			provider.saveables.removeSaveable(new IFile[] { model }, true);
			if (null != saveable) {
				provider.fireSaveablesClosedInUIJob(new Saveable[] { saveable });
			}
		}

		@Override
		public void onModelMoved(IFile oldModelLocation, IFile newModelLocation) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			boolean previouslyOpened = false;
			TopologySaveable saveable = provider.saveables.locateSaveable(new IFile[] {
					oldModelLocation, newModelLocation }, false);
			if (saveable != null) {

				onModelClosed(oldModelLocation);
				previouslyOpened = true;
//				saveable.removeArtifact(oldModelLocation);
//				saveable.addArtifact(newModelLocation);
//
//				if (saveable.getOpenedOn().equals(oldModelLocation)) {
//					saveable.setOpenedOn(newModelLocation);
//				}
//
//				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
//
//				if (newModelLocation.getProject().isAccessible()) {
//					provider.enqueue(newModelLocation);
//				}
			}

			onModelOpened(newModelLocation);
			if (previouslyOpened) {
				saveable = provider.saveables.locateSaveable(new IFile[] { newModelLocation }, false);
				saveable.addPreviousModel(oldModelLocation);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onDiagramChanged(IFile diagram) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			IFile model = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagram, true);
			TopologySaveable saveable = provider.saveables.locateSaveable(
					new IFile[] { model, diagram }, true);
			if (null != saveable) {
				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
				if (diagram.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(diagram);
				}
				if (model != null && model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onDiagramSaved(IFile diagram) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			IFile model = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagram);
			TopologySaveable saveable = provider.saveables.locateSaveable(
					new IFile[] { model, diagram }, true);
			if (null != saveable) {
				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
				if (diagram.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(diagram);
				}
				if (model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onDiagramClosed(IFile diagram) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			IFile model = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagram);

			IFile[] searchSet = null;
			if (model != null) {
				searchSet = new IFile[] { model, diagram };
			} else {
				searchSet = new IFile[] { diagram };
			}
			TopologySaveable saveable = provider.saveables.locateSaveable(searchSet, false);

			if (null != saveable) {
//				provider.saveables.removeSaveable(searchSet);
				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
			}

			if (model != null && model.getProject().isAccessible() && provider.initialized) {
				provider.enqueue(model);
			}

			if (diagram.getProject().isAccessible() && provider.initialized) {
				provider.enqueue(diagram);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onDiagramOpened(IFile diagram) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			IFile model = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagram, true);
			if (null != model) {
				TopologySaveable saveable = provider.saveables.locateSaveable(new IFile[] { model,
						diagram }, true);

				if (model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}

				if (null != saveable && diagram.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(diagram);
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void onDiagramRemoved(IFile diagram) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			IFile model = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagram);
			TopologySaveable saveable = provider.saveables.locateSaveable(
					new IFile[] { model, diagram }, false);
			if (null != saveable && !saveable.isDirty()) {
//				provider.saveables.removeSaveable(new IFile[] { model, diagram });
				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
				if (model.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(model);
				}
			}
		}

		@Override
		public void onDiagramMoved(IFile oldDiagramLocation, IFile newDiagramLocation) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			IFile oldModel = TopologyArtifactsMonitor.INSTANCE
					.getAssociatedModelFile(oldDiagramLocation);
			IFile newModel = TopologyArtifactsMonitor.INSTANCE
					.getAssociatedModelFile(newDiagramLocation);

			TopologySaveable saveable = provider.saveables.locateSaveable(new IFile[] { oldModel,
					newModel, oldDiagramLocation, newDiagramLocation }, false);
			if (saveable != null) {
				saveable.removeArtifact(oldDiagramLocation);
				saveable.addArtifact(newDiagramLocation);

				provider.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });

				if (newModel.getProject().isAccessible() && provider.initialized) {
					provider.enqueue(newModel);
				}

				if (newDiagramLocation.getProject().isAccessible()) {
					provider.enqueue(newDiagramLocation);
				}
			}
		}

		@Override
		public void onNamespaceRemoved(IContainer container) {
			TopologySaveablesProvider provider = getProvider();
			if (null == provider) {
				return;
			}

			INamespaceFragmentRoot root = NamespaceCore.getRoot(container);
			if (null != root) {
				provider.enqueue(root);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Saveable saveable) {
		if (saveable instanceof TopologySaveable) {
			TopologySaveable saveableTopology = (TopologySaveable) saveable;
			ArrayList artifacts = new ArrayList(saveableTopology.getArtifacts());
			return artifacts.toArray(new Object[artifacts.size()]);
		}

		return new Object[0];
	}

	public void enqueue(Object model) {
		if (refreshManager != null) {
			refreshManager.enqueue(model);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public Saveable getSaveable(Object element) {

		TopologySaveable saveable = null;
		if (element != null && element instanceof IFile) {
			IFile file = (IFile) element;
			if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
				saveable = saveables.locateSaveable(new IFile[] { file }, false);
			} else if (IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
				IFile model = monitor.getAssociatedModelFile(file, false);
				if (model != null) {
					saveable = saveables.locateSaveable(new IFile[] { file, model }, false);
					if (saveable != null && !saveable.getArtifacts().contains(file)) {
						saveable.addArtifact(file);
					}
				}
			}
		}

		return saveable == null ? saveable : saveable.isOpen() ? saveable : null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Saveable[] getSaveables() {
		List<TopologySaveable> list = saveables.getSaveables();
		return list.toArray(new Saveable[list.size()]);
	}

	protected void fireSaveablesOpenedInUIJob(final Saveable[] saveables) {
		if (!initialized) {
			return;
		}

		UIJob job = new SafeUIJob(getClass().getSimpleName() + ".fireSaveablesOpened") { //$NON-NLS-1$
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {

				synchronized (lock) {

					if (shouldRun()) {
						fireSaveablesOpened(saveables);
					}
				}
				return Status.OK_STATUS;
			}

		};
		job.schedule(DELAY);
	}

	protected void fireSaveablesDirtyChangedInUIJob(final Saveable[] saveables) {
		if (!initialized) {
			return;
		}

		UIJob job = new SafeUIJob(getClass().getSimpleName() + ".fireSaveablesDirtyChanged") { //$NON-NLS-1$
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {

				synchronized (lock) {

					if (shouldRun()) {
						fireSaveablesDirtyChanged(saveables);
					}
				}
				return Status.OK_STATUS;
			}

		};
		job.schedule(DELAY);
	}

	protected void fireSaveablesClosedInUIJob(final Saveable[] saveables) {
		if (!initialized) {
			return;
		}

		UIJob job = new SafeUIJob(getClass().getSimpleName() + ".fireSaveablesClosed") { //$NON-NLS-1$
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				synchronized (lock) {

					if (shouldRun()) {
						fireSaveablesClosed(saveables);
					}
				}
				return Status.OK_STATUS;
			}

		};
		job.schedule(DELAY);
	}

	protected void fireSaveablesClosingInUIJob(final Saveable[] saveables) {
		if (!initialized) {
			return;
		}

		UIJob job = new SafeUIJob(getClass().getSimpleName() + ".fireSaveablesClosed") { //$NON-NLS-1$
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				synchronized (lock) {

					if (shouldRun()) {
						boolean vetoed = fireSaveablesClosing(saveables, false);
						if (vetoed) {

						}
					}
				}
				return Status.OK_STATUS;
			}

		};
		job.schedule();
	}

	protected void saveDirtySaveables(final List<TopologySaveable> saveables) {

		UIJob job = new SafeUIJob(getClass().getSimpleName() + ".saveDirtySaveables") { //$NON-NLS-1$
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {

				synchronized (lock) {

					if (shouldRun()) {
						AdaptableList input = new AdaptableList(saveables);
						ListSelectionDialog dlg = new ListSelectionDialog(Display.getCurrent()
								.getActiveShell(), input, new WorkbenchContentProvider(),
								new WorkbenchPartLabelProvider(),
								IDEWorkbenchMessages.EditorManager_saveResourcesMessage);

						dlg.setInitialSelections(saveables.toArray(new Object[saveables.size()]));
						dlg.setTitle(IDEWorkbenchMessages.EditorManager_saveResourcesTitle);
						int result = dlg.open();

						if (result == IDialogConstants.CANCEL_ID) {
							return Status.CANCEL_STATUS;
						}
						Arrays.asList(dlg.getResult());
					}
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	@Override
	public void dispose() {

		synchronized (lock) {
			if (!disposed) {
				disposed = true;
				initialized = false;
				monitor.removeListener(listener);
				listener = null;
				if (saveables != null) {
					saveables.dispose();
				}
				super.dispose();
			}

		}
	}

	/**
	 * <p>
	 * Internal class to TopologySaveablesProvider which holds the references to TopologySaveables
	 * managed by the TopologySaveablesProvider.
	 * </p>
	 * 
	 * @author Tim Pouyer <tpouyer@us.ibm.com>
	 * @since 7.0
	 * 
	 */
	public static class Store {

		/* Use an internal object monitor to prevent deadlocks on the InternalState monitor */
		private final Object lock = new Object();

		private final List<TopologySaveable> saveables = Collections
				.synchronizedList(new ArrayList<TopologySaveable>());

		private final WeakReference reference;

		/**
		 * <p>
		 * Creates a new instance of Store.
		 * </p>
		 * 
		 * @param monitor
		 *           an instance of TopologySaveablesProvider
		 */
		public Store(TopologySaveablesProvider monitor) {
			reference = new WeakReference(monitor);
		}

		private TopologySaveable createSaveable(List<IFile> artifacts) {

			if (artifacts == null) {
				artifacts = new ArrayList<IFile>();
			}

			TopologySaveable saveable = new TopologySaveable(Arrays.asList(artifacts
					.toArray(new IResource[artifacts.size()])));

			return saveable;
		}

		private boolean removeSaveable(final IFile[] artifacts, final boolean allowReadOnlyUnload) {
			synchronized (lock) {
				final TopologySaveable saveable = locateSaveable(artifacts, false);
				if (null != saveable) {

					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {

							if (saveable.isDirty()) {
								DeployCoreUIPlugin.logError(0, "Closing dirty saveable " + saveable, null); //$NON-NLS-1$
							}

							if (saveable.close(false, allowReadOnlyUnload, new NullProgressMonitor())) {
								saveables.remove(saveable);
							} else {
								throw new CoreException(new Status(IStatus.ERROR,
										"Failed to close saveable " + saveable, null)); //$NON-NLS-1$
							}
						}

						public void handleException(Throwable ex) {
							DeployCoreUIPlugin.logError(0, ex.toString(), ex);
						}
					});

					return locateSaveable(artifacts, false) == null ? true : false;
				}
			}

			return false;
		}

		/**
		 * <p>
		 * Attempts to locate a saveable for the passed in key. If one does not already exist and the
		 * toCreate flag is set to true, a new instance of TopologySaveable will be created and stored
		 * under the passed in key.
		 * </p>
		 * 
		 * @param key
		 *           the key to look for the TopologySaveable instance under or create one for.
		 * @param artifacts
		 *           a array of IFiles representing the artifacts associated with the
		 *           TopologySaveable, files in this array are added to the TopologySaveable if they
		 *           are not already associated with the saveable, or in the case that a new
		 *           TopologySaveable is created these files will be automatcally associated with the
		 *           new TopologySaveable.
		 * @param toCreate
		 *           boolean flag indicating if a new instance of a TopologySaveable should be created
		 *           if one does not already exist for the passed in key
		 * @return An instance of TopologySaveable or null if one was not found under the given key
		 *         and the toCreate flag was set to false.
		 */
		public TopologySaveable locateSaveable(IFile[] artifacts, boolean toCreate) {
			ArrayList<IFile> artifactList = new ArrayList<IFile>(Arrays.asList(artifacts));
			for (Iterator<IFile> iter = artifactList.iterator(); iter.hasNext();) {
				if (iter.next() == null) {
					iter.remove();
				}
			}
			return locateSaveable(artifactList, toCreate);
		}

		/**
		 * <p>
		 * Attempts to locate a saveable for the passed in key. If one does not already exist and the
		 * toCreate flag is set to true, a new instance of TopologySaveable will be created and stored
		 * under the passed in key.
		 * </p>
		 * 
		 * @param key
		 *           the key to look for the TopologySaveable instance under or create one for.
		 * @param artifacts
		 *           a list of IFiles representing the artifacts associated with the TopologySaveable,
		 *           files in this list are added to the TopologySaveable if they are not already
		 *           associated with the saveable, or in the case that a new TopologySaveable is
		 *           created these files will be automatcally associated with the new
		 *           TopologySaveable.
		 * @param toCreate
		 *           boolean flag indicating if a new instance of a TopologySaveable should be created
		 *           if one does not already exist for the passed in key
		 * @return An instance of TopologySaveable or null if one was not found under the given key
		 *         and the toCreate flag was set to false.
		 */
		public TopologySaveable locateSaveable(List<IFile> artifacts, boolean toCreate) {

			boolean created = false;
			boolean artifactsAdded = false;
			TopologySaveable saveable = null;
			synchronized (lock) {

				// look for saveable by contained artifacts
				for (Iterator<IFile> iter = artifacts.iterator(); iter.hasNext();) {
					IFile artifact = iter.next();
					if (null != artifact) {
						saveable = findSaveable(artifact);
						if (null != saveable) {
							break;
						}
					}
				}

				if (saveable == null && toCreate || saveable != null && !saveable.isOpen() && toCreate) {
					saveables.add(saveable = createSaveable(artifacts));
					created = true;
				}

				// add artifacts to be managed to saveable ( only if saveable exists and is open && toCreate is true )
				if (artifacts != null && artifacts.size() > 0 && saveable != null && saveable.isOpen()
						&& toCreate) {
					for (Iterator<IFile> iter = artifacts.iterator(); iter.hasNext();) {
						IFile artifact = iter.next();
						if (null != artifact && !saveable.isManaged(artifact)
								&& artifact.getProject().isAccessible() && artifact.isAccessible()) {
							saveable.addArtifact(artifact);
							artifactsAdded = true;
						}
					}
				}

			}

			if (created) {
				((TopologySaveablesProvider) reference.get())
						.fireSaveablesOpenedInUIJob(new Saveable[] { saveable });
			}

			if (artifactsAdded && !created) {
				((TopologySaveablesProvider) reference.get())
						.fireSaveablesDirtyChangedInUIJob(new Saveable[] { saveable });
			}

			return saveable;
		}

		/**
		 * <p>
		 * Returns a list of TopologySaveables that are contained in this Store.
		 * </p>
		 * 
		 * @return a List of TopologySaveables
		 */
		private List<TopologySaveable> getSaveables() {
			List<TopologySaveable> list = new ArrayList<TopologySaveable>();
			synchronized (lock) {
				list.addAll(saveables);
			}

			return list;
		}

		/**
		 * <p>
		 * Returns a list of TopologySaveables that are contained in this Store that contain files
		 * that are a part of the passed in IProject.
		 * </p>
		 * 
		 * @param project
		 *           the project to look for files associated with TopologySaveables contained within
		 *           this Store.
		 * @return a List of TopologySaveables.
		 */
		private List<TopologySaveable> getSaveables(IProject project) {
			List<TopologySaveable> list = new ArrayList<TopologySaveable>();
			synchronized (lock) {
				for (Iterator<TopologySaveable> iter = saveables.iterator(); iter.hasNext();) {
					boolean foundMatch = false;
					TopologySaveable saveable = iter.next();
					Resource[] resources = saveable.getScribbler().getSortedResources();
					for (int i = 0; i < resources.length; i++) {
						Resource resource = resources[i];
						IPath path = new Path(resource.getURI().toPlatformString(true));
						if (project.getFullPath().matchingFirstSegments(path) > 0) {
							list.add(saveable);
							foundMatch = true;
							break;
						}
					}

					if (!foundMatch) {
						for (int i = 0; i < saveable.getArtifacts().size(); i++) {
							IFile artifact = saveable.getArtifacts().get(i);
							if (project.equals(artifact.getProject())) {
								list.add(saveable);
								break;
							}
						}
					}
				}
			}

			return list;
		}

		private TopologySaveable findSaveable(IFile file) {

			// look for saveable that has a loaded resource with the same uri as the file
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
			for (Iterator<TopologySaveable> iter = saveables.iterator(); iter.hasNext();) {
				TopologySaveable saveable = iter.next();
				if (saveable.isOpen()) {
					Resource[] resources = saveable.getScribbler().getSortedResources();
					for (int i = 0; i < resources.length; i++) {
						Resource resource = resources[i];
						if (uri.equals(resource.getURI())) {
							return saveable;
						}
					}
				}
			}

			// look for a saveable that declares the file as contained in it's domain descriptor
			for (Iterator<TopologySaveable> iter = saveables.iterator(); iter.hasNext();) {
				TopologySaveable saveable = iter.next();
				if (saveable.isManaged(file)) {
					return saveable;
				}
			}

			return null;
		}

		private boolean isValid() {
			if (reference.get() == null) {
				return false;
			}
			return true;
		}

		private void dispose() {
			synchronized (lock) {

				List<TopologySaveable> copy = new ArrayList<TopologySaveable>();
				copy.addAll(saveables);
				for (Iterator<TopologySaveable> iter = copy.iterator(); iter.hasNext();) {

					final TopologySaveable saveable = iter.next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							if (saveable.isOpen()) {
								saveable.close(false, new NullProgressMonitor());
							}
						}

						public void handleException(Throwable ex) {
							DeployCoreUIPlugin.logError(0, ex.toString(), ex);
						}
					});

					iter.remove();
				}

			}
		}
	}

	public boolean isDisposed() {
		synchronized (lock) {
			return disposed;
		}
	}

	/**
	 * <p>
	 * This class attempts to locate previously opened deploy core editors so that TopologySaveables
	 * can be created for them. This is necessary b/c some editors might have been opened before this
	 * class could register as a listener with the TopologyArtifactsMonitor and would therefore not
	 * have received notification of the load events on the model and diagram files used by those
	 * editors. This class has been implemented as a Job so that it's execution can be delayed to
	 * allow the workbench to finish opening before making any calls to locate the possibly open
	 * deploy core editors.
	 * </p>
	 */
	public class CheckForPreviouslyOpenedEditorsJob extends Job {

		protected final TopologyArtifactsMonitor monitor;
		private final ArtifactListener listener;

		public CheckForPreviouslyOpenedEditorsJob(ArtifactListener listener) {
			super("Check for previously opened editors"); //$NON-NLS-1$
			monitor = TopologyArtifactsMonitor.INSTANCE;
			this.listener = listener;
			setRule(ResourcesPlugin.getWorkspace().getRoot());
		}

		@Override
		public boolean belongsTo(Object family) {
			return family.equals(ResourcesPlugin.getWorkspace().getRoot());
		}

		protected IStatus run(IProgressMonitor pm) {
			IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
			for (int w = 0; w < windows.length; w++) {
				IWorkbenchWindow window = windows[w];
				IWorkbenchPage[] pages = window.getPages();
				for (int p = 0; p < pages.length; p++) {
					IWorkbenchPage page = pages[p];
					IEditorReference[] references = page.findEditors(null, DeployCoreUIPlugin.EDITOR_ID,
							IWorkbenchPage.MATCH_ID);
					for (int r = 0; r < references.length; r++) {
						IEditorReference reference = references[r];
						IEditorPart part = reference.getEditor(false);
						if (part instanceof DeployCoreEditor) {
							DeployCoreEditor editor = (DeployCoreEditor) part;
							IEditorInput input = editor.getEditorInput();
							if (input instanceof FileEditorInput) {
								FileEditorInput fileInput = (FileEditorInput) input;
								IFile file = fileInput.getFile();
								IFile model = monitor.getAssociatedModelFile(file);
								if (model != null) {
									listener.onModelOpened(model);
									List<IFile> diagrams = monitor.getAssociatedDiagramFiles(model);
									for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {
										listener.onDiagramOpened(iter.next());
									}
								}
							}
						}
					}
				}
			}

			return Status.OK_STATUS;
		}
	}
}
