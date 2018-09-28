package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndex;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.infrastructure.emf.EditModelEvent;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModel;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelListener;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 1.0
 * 
 * <p>
 * This class follows the singleton pattern and is first instantiated during the startup of the
 * DeployCoreUIPlugin.
 * </p>
 * <p>
 * The TopologyArtifactsMonitor attempts to normalize the events comming out of the workspace that
 * pertain to Zephyr models and/or diagrams. The class listens to several notification mechanisms in
 * an attempt to make the implementation of classes that must be knowledgeable of model or diagram
 * events much easier. Classes that need to be aware of these events can simply implement the
 * ArtifactListener interface and register themselves as a listener with this class to be notified
 * when these model/diagram event occur. This class does not attempt to aggregate events in anyway,
 * so implementers of the ArtifactListener interface need to be aware that the same ArtifactEvent
 * could possibly be fired more than once since this class is listening to multiple event generators
 * and only normalizes those events, it will be notified of the same event from multiple sources and
 * will therefore notify it's listeners multiple times for the same event.
 * </p>
 */
public class TopologyArtifactsMonitor implements IEditModelListener, IResourceChangeListener {

	private static final boolean DEBUG_RAW_EVENTS = DeployCoreUIPlugin.getDefault().isDebugging()
			&& Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DeployCoreUIPlugin.PLUGIN_ID + "/debug/rawevents")); //$NON-NLS-1$

	private static final boolean DEBUG_NORMALIZED_EVENTS = DeployCoreUIPlugin.getDefault()
			.isDebugging()
			&& Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DeployCoreUIPlugin.PLUGIN_ID + "/debug/normalizedevents")); //$NON-NLS-1$

	/**
	 * <p>
	 * Singleton variable used to track the single instance of this class within a single VM
	 * </p>
	 */
	public final static TopologyArtifactsMonitor INSTANCE = new TopologyArtifactsMonitor();

	private final Object listenerLock = new Object();
	private final ListenerList listeners = new ListenerList();
	protected final Map<String, IEditModelScribbler> readOnlyScribblers = Collections
			.synchronizedMap(new HashMap<String, IEditModelScribbler>());
	private final Map<IFile, List<IFile>> modelToDiagramIndex = Collections
			.synchronizedMap(new HashMap<IFile, List<IFile>>());
	private final ModelIndexListener modelIndexListener;
	private final EditModelListener editModelListener;
	private final PostCommitEventListener postCommitListener;

	private TopologyArtifactsMonitor() {
		modelIndexListener = new ModelIndexListener(this);
		editModelListener = new EditModelListener(this);
		postCommitListener = new PostCommitEventListener(this);
		setupListeners();
	}

	private void setupListeners() {

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].isAccessible()) {
				addEditModelListener(projects[i]);
				addPostCommitListener(projects[i]);
			}
		}

		addModelIndexListener();
		addResourceChangeListener();
	}

	private void teardownListeners() {

		removeModelIndexListener();
		removeResourceChangeListener();

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {

			if (projects[i].isAccessible()) {
				final IProject project = projects[i];
				SafeRunner.run(new ISafeRunnable() {
					public void run() throws Exception {
						Job job = new Job(
								"remove topology artifacts edit model listener from the project '" + project.getName() + "' ...") { //$NON-NLS-1$ //$NON-NLS-2$
							@Override
							protected IStatus run(IProgressMonitor monitor) {
								removeEditModelListener(project);
								return Status.OK_STATUS;
							}

							@Override
							public boolean shouldRun() {
								if (null != project && project.isAccessible()) {
									return true;
								}

								return true;
							}
						};
						job.setRule(project);
						job.setPriority(Job.SHORT);
						job.setSystem(true);
						job.schedule(Job.SHORT);
					}

					public void handleException(Throwable ex) {
						logError(ex);
					}
				});
				SafeRunner.run(new ISafeRunnable() {
					public void run() throws Exception {
						Job job = new Job(
								"remove topology artifacts post-commit transactional domain listener from the project '" + project.getName() + "' ...") { //$NON-NLS-1$ //$NON-NLS-2$
							@Override
							protected IStatus run(IProgressMonitor monitor) {
								removePostCommitListener(project);
								return Status.OK_STATUS;
							}

							@Override
							public boolean shouldRun() {
								if (null != project && project.isAccessible()) {
									return true;
								}

								return true;
							}
						};
						job.setRule(project);
						job.setPriority(Job.SHORT);
						job.setSystem(true);
						job.schedule(Job.SHORT);
					}

					public void handleException(Throwable ex) {
						logError(ex);
					}
				});
			}
		}
	}

	private void addEditModelListener(final IProject project) {

		SafeRunner.run(new ISafeRunnable() {

			public void run() throws Exception {
				TopologyArtifactsDomain domain = new TopologyArtifactsDomain(project);
				if (!readOnlyScribblers.containsKey(domain.getEditModelLabel())) {
					IEditModelScribbler scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(
							project, domain);
					readOnlyScribblers.put(domain.getEditModelLabel(), scribbler);
				}
				IEditModel editModel = IEditModelFactory.eINSTANCE.getEditModel(project, domain
						.getEditModelLabel());
				editModel.addListener(editModelListener);
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void removeEditModelListener(final IProject project) {

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				TopologyArtifactsDomain domain = new TopologyArtifactsDomain(project);
				DeployCorePlugin plugin = DeployCorePlugin.getDefault();
				if (plugin != null) {
					IModelFileIndexer indexer = plugin.getIndexer();
					if (indexer != null) {
						IModelFileIndex index = indexer.getModelIndex(project, new NullProgressMonitor());
						if (index != null) {
							IFile[] modelFiles = index.getModelFiles();
							if (modelFiles != null) {
								for (int j = 0; j < modelFiles.length; j++) {
									notifyListenersOfArtifactEvent(new ArtifactEvent(
											ArtifactEvent.MODEL_REMOVED, new IFile[] { modelFiles[j] }));
								}
							}
						}
					}
				}

				try {
					IEditModel editModel = IEditModelFactory.eINSTANCE.getEditModel(project, domain
							.getEditModelLabel());
					if (editModel != null) {
						editModel.removeListener(editModelListener);
					}
				} catch (IllegalStateException ex) {
					logError(ex);
				}

				try {
					IEditModelScribbler scribbler = readOnlyScribblers
							.remove(domain.getEditModelLabel());
					if (scribbler != null && !scribbler.isClosed()) {
						scribbler.close(new NullProgressMonitor());
					}
				} catch (EditModelException ex) {
					logError(ex);
				}
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void addPostCommitListener(final IProject project) {

		SafeRunner.run(new ISafeRunnable() {

			public void run() throws Exception {
				IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE
						.getContext(project);
				TransactionalEditingDomain editingDomain = context.getEditingDomain();
				editingDomain.addResourceSetListener(postCommitListener);
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void removePostCommitListener(final IProject project) {

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				if (project != null && project.isAccessible()) {
					IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE
							.getContext(project);
					if (context != null) {
						TransactionalEditingDomain editingDomain = context.getEditingDomain();
						if (editingDomain != null) {
							editingDomain.removeResourceSetListener(postCommitListener);
						}
					}
				}
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void addModelIndexListener() {

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				DeployCorePlugin plugin = DeployCorePlugin.getDefault();
				if (plugin != null) {
					IModelFileIndexer indexer = plugin.getIndexer();
					if (indexer != null) {
						indexer.addModelListener(modelIndexListener);
					}
				}
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void removeModelIndexListener() {

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				DeployCorePlugin plugin = DeployCorePlugin.getDefault();
				if (plugin != null) {
					IModelFileIndexer indexer = plugin.getIndexer();
					if (indexer != null) {
						indexer.removeModelListener(modelIndexListener);
					}
				}
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void addResourceChangeListener() {

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				if (null != workspace) {
					workspace.addResourceChangeListener(TopologyArtifactsMonitor.this,
							IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.POST_CHANGE);
				}
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	private void removeResourceChangeListener() {

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				if (workspace != null) {
					workspace.removeResourceChangeListener(TopologyArtifactsMonitor.this);
				}
			}

			public void handleException(Throwable ex) {
				logError(ex);
			}
		});
	}

	////////  below methods manage this class' listeners and handle notification of events  ////////

	/**
	 * <p>
	 * Adds a new listener to the list of listeners registered with this class. Attempts to add a
	 * previously registered listener will simply do nothing.
	 * </p>
	 * 
	 * @param modelListener
	 *           Listener to be registered.
	 */
	public void addListener(ArtifactListener modelListener) {
		Assert.isNotNull(modelListener);
		synchronized (listenerLock) {
			listeners.add(modelListener);
		}
	}

	/**
	 * <p>
	 * Removes the modelListener from the list of registered listeners with this class. If the
	 * modelListener was not previously registered as a listener this method will do nothing.
	 * </p>
	 * 
	 * @param modelListener
	 *           Listener to be removed from the list of registered listeners.
	 */
	public void removeListener(ArtifactListener modelListener) {
		Assert.isNotNull(modelListener);
		synchronized (listenerLock) {
			listeners.remove(modelListener);
		}
	}

	private void notifyListenersOfArtifactEvent(final ArtifactEvent event) {
		synchronized (listenerLock) {
			final Object[] notificationList = listeners.getListeners();
			for (int i = 0; i < notificationList.length; i++) {
				SafeRunner
						.run(new ArtifactEventNotifier((ArtifactListener) notificationList[i], event));
			}
		}
	}

	////////  below methods are utiltiy methods provided by this class  ////////

	/**
	 * <p>
	 * Attempts to determine the dirty state of the model without loading the underlying resource. If
	 * the underlying resource was not previously loaded this mehtod will always return false.
	 * </p>
	 * 
	 * @param model
	 *           An IFile handle for a resource within the workspace.
	 * @return True if the model is dirty or false if it is not or if the model's resource has not
	 *         been loaded yet.
	 */
	public boolean isArtifactDirty(IFile model) {
		Resource resource = getResource(model);
		if (resource != null) {
			return resource.isModified();
		}
		return false;
	}

	public Resource getReadOnlyResource(IFile model, boolean forceLoad) {
		if (null != model && model.isAccessible()) {

			IEditModelScribbler scribbler = readOnlyScribblers.get(TopologyArtifactsDomain
					.generateEditModelLable(model.getProject()));

			if (null != scribbler && !scribbler.isClosed() && model.getProject().isAccessible()
					&& model.isAccessible()) {
				Resource resource = scribbler.getResource(model,
						forceLoad ? IEditModelScribbler.OPTION_LOAD_RESOURCE
								: IEditModelScribbler.OPTION_NONE);
				return resource;
			}

		}
		return null;
	}

	private Resource getResource(IFile model) {
		return getReadOnlyResource(model, true);
	}

	private static IFile getFile(Resource resource) {
		URI uri = resource.getURI();
		IPath path = new Path(uri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file;
	}

	/**
	 * <p>
	 * If the file is an instance of a Diagram then this method will return the model file associated
	 * with this diagram. If this is a model file then this method will simply return the same file.
	 * If the file's resource has not been previously loaded or there is not a model associated with
	 * the diagram, then this method will return null.
	 * </p>
	 * 
	 * @param file
	 *           A diagram or model file
	 * @return an IFile handle to the model file associated with the diagram file passed in or null
	 *         if the diagram file passed in has not been previously loaded or there is no model file
	 *         associated with the passed in diagram.
	 */
	public IFile getAssociatedModelFile(IFile file) {
		return getAssociatedModelFile(file, false);
	}

	/**
	 * <p>
	 * If the file is an instance of a Diagram then this method will return the model file associated
	 * with this diagram. If this is a model file then this method will simply return the same file.
	 * If there is not a model associated with the diagram then this method will return null. If the
	 * diagram has not been previously loaded and the force parameter equals true then this method
	 * will force the load of the diagram's resource.
	 * </p>
	 * 
	 * @param file
	 *           A diagram or model file
	 * @param force
	 *           boolean indicating if the diagram file should be forcibly loaded if it has not yet
	 *           been loaded.
	 * @return an IFile handle to the model file associated with the diagram file passed in or null
	 *         if the diagram file passed in has not been previously loaded and the force parameter
	 *         was false, or the diagram file is not associated with a model file.
	 */
	public IFile getAssociatedModelFile(Resource resource) {

		if (resource != null && ((Resource.Internal) resource).isLoaded()
				&& !((Resource.Internal) resource).isLoading() && resource.getContents().size() > 0) {
			Diagram diagram = (Diagram) resource.getContents().get(0);

			// we use eGet(.., don't resolve) to avoid loading the model just to find out who it is
			EObject element = (EObject) diagram
					.eGet(NotationPackage.Literals.VIEW__ELEMENT, false /* resolve */);
			if (element instanceof Topology) {
				Topology topology = (Topology) element;
				if (topology.eIsProxy()) {
					URI uri = EcoreUtil.getURI(topology);
					return ResourcesPlugin.getWorkspace().getRoot().getFile(
							new Path(uri.toPlatformString(true)));
				}
				return getFile(topology.eResource());
			}
		}
		return null;
	}

	/**
	 * <p>
	 * If the file is an instance of a Diagram then this method will return the model file associated
	 * with this diagram. If this is a model file then this method will simply return the same file.
	 * If there is not a model associated with the diagram then this method will return null. If the
	 * diagram has not been previously loaded and the force parameter equals true then this method
	 * will force the load of the diagram's resource.
	 * </p>
	 * 
	 * @param file
	 *           A diagram or model file
	 * @param force
	 *           boolean indicating if the diagram file should be forcibly loaded if it has not yet
	 *           been loaded.
	 * @return an IFile handle to the model file associated with the diagram file passed in or null
	 *         if the diagram file passed in has not been previously loaded and the force parameter
	 *         was false, or the diagram file is not associated with a model file.
	 */
	public IFile getAssociatedModelFile(IFile file, boolean force) {
		if (file == null) {
			return null;
		}
		if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
			return file;
		}

		for (Iterator<Map.Entry<IFile, List<IFile>>> iter = modelToDiagramIndex.entrySet().iterator(); iter
				.hasNext();) {
			Map.Entry<IFile, List<IFile>> entry = iter.next();
			if (entry.getValue().contains(file)) {
				return entry.getKey();
			}
		}

		IFile modelFile = null;
		Resource resource = getReadOnlyResource(file, force);
		try {
			modelFile = getAssociatedModelFile(resource);
		} finally {
			if (resource != null && resource.isLoaded()) {
				release(resource);
			}
		}

		return modelFile;
	}

	private void release(Resource resource) {
		IFile file = WorkbenchResourceHelper.getFile(resource);
		if (file != null) {
			IEditModelScribbler scribbler = readOnlyScribblers.get(TopologyArtifactsDomain
					.generateEditModelLable(file.getProject()));
			scribbler.releaseResource(resource);
		}
	}

	/**
	 * <p>
	 * This class attempts to track associations from models to their diagrams at runtime. Since the
	 * model to diagram associations are not stored with the model this class attempts to index those
	 * associations when it is made aware of them through the events that this class listens to. This
	 * method will return those associations that are known at runtime at the point in time that this
	 * method is called. This may not include all of the possible associated diagrams for a
	 * particular model file.
	 * </p>
	 * 
	 * @param model
	 *           the model for which you would like to receive it's associated diagrams of
	 * @return a List<IFile> of IFile handles to the known ( point-in-time ) diagrams associated
	 *         with the passed in model.
	 */
	public List<IFile> getAssociatedDiagramFiles(IFile model) {
		return getModelToDiagramAssociations(model);
	}

	private void indexModelToDiagramAssociation(IFile model, IFile diagram) {
		List<IFile> diagrams = modelToDiagramIndex.get(model);
		if (diagrams == null) {
			diagrams = Collections.synchronizedList(new ArrayList<IFile>());
			modelToDiagramIndex.put(model, diagrams);
		}
		if (!diagrams.contains(diagram)) {
			diagrams.add(diagram);
		}
	}

	private List<IFile> getModelToDiagramAssociations(IFile model) {
		List<IFile> diagrams = modelToDiagramIndex.get(model);
		if (diagrams == null) {
			diagrams = Collections.synchronizedList(new ArrayList<IFile>());
		}

		IFile defaultDiagram = ResourcesPlugin.getWorkspace().getRoot().getFile(
				model.getFullPath().removeFileExtension().addFileExtension(
						IConstants.TOPOLOGYV_EXTENSION));
		if (!diagrams.contains(defaultDiagram)) {
			diagrams.add(defaultDiagram);
		}
		return diagrams;
	}

	private void reassociateModelToDiagramIndex(IFile oldModel, IFile newModel) {
		List<IFile> diagrams = modelToDiagramIndex.get(oldModel);
		if (diagrams != null) {
			modelToDiagramIndex.remove(oldModel);
			modelToDiagramIndex.put(newModel, diagrams);
		}
	}

	private void reassociateDiagramToModelIndex(IFile oldDiagram, IFile newDiagram) {
		Set<IFile> models = modelToDiagramIndex.keySet();
		for (Iterator<IFile> iter = models.iterator(); iter.hasNext();) {
			List<IFile> diagrams = modelToDiagramIndex.get(iter.next());
			for (int i = 0; i < diagrams.size(); i++) {
				IFile diagram = diagrams.get(i);
				if (diagram.equals(oldDiagram)) {
					diagrams.remove(i);
					diagrams.add(newDiagram);
					break;
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void resourceChanged(IResourceChangeEvent event) {

		switch (event.getType())
		{
		case IResourceChangeEvent.PRE_CLOSE:
			IResource resource = event.getResource();
			if (IResource.PROJECT == resource.getType()) {
				IProject project = (IProject) resource;
				IModelFileIndex index = DeployCorePlugin.getDefault().getIndexer().getModelIndex(
						project, new NullProgressMonitor());
				IFile[] models = index.getModelFiles();
				removeEditModelListener(project);
				removePostCommitListener(project);
				if (index != null && models.length > 0) {
					notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_PRE_REMOVE,
							models));
				}
			}
			break;

		case IResourceChangeEvent.POST_CHANGE:
			final IResourceDelta workspaceDelta = event.getDelta();

			try {

				workspaceDelta.accept(new IResourceDeltaVisitor() {

					public boolean visit(IResourceDelta delta) throws CoreException {
						IResource resource = delta.getResource();
						switch (resource.getType())
						{
						case IResource.ROOT:
						case IResource.PROJECT:
						case IResource.FOLDER:
							IResourceDelta[] deltas = delta.getAffectedChildren(IResourceDelta.CHANGED
									| IResourceDelta.ADDED | IResourceDelta.REMOVED);

							if (deltas.length > 0 || (delta.getKind() & IResourceDelta.REMOVED) > 0) {
								if (resource.getType() == IResource.FOLDER) {
									if ((delta.getKind() & IResourceDelta.REMOVED) > 0) {
										INamespaceFragmentRoot root = NamespaceCore
												.getRoot((IContainer) resource);
										if (null != root) {
											namespaceRemoved((IContainer) resource);
										}
									}
								}
							}

							if (deltas.length == 0) {
								return false;
							}
							break;

						case IResource.FILE:
							IFile file = (IFile) resource;
							switch (delta.getKind())
							{
							case IResourceDelta.ADDED:
								if ((delta.getFlags() & IResourceDelta.MOVED_FROM) > 0) {
									String fileExtension = file.getFileExtension();
									if (IConstants.TOPOLOGY_EXTENSION.equals(fileExtension)) {
										//topology file moved
										IFile oldModel = ResourcesPlugin.getWorkspace().getRoot().getFile(
												delta.getMovedFromPath());

										resourceMoved(URI.createPlatformResourceURI(oldModel.getFullPath()
												.toString()), URI.createPlatformResourceURI(file.getFullPath()
												.toString()));
									} else if (IConstants.TOPOLOGYV_EXTENSION.equals(fileExtension)) {
										//topologyv file moved
										IFile oldDiagram = ResourcesPlugin.getWorkspace().getRoot().getFile(
												delta.getMovedFromPath());

										IFile model = TopologyArtifactsMonitor.this.getAssociatedModelFile(
												file, true);

										IResourceDelta modelDelta = null;

										if (null != model) {
											modelDelta = workspaceDelta.findMember(model.getFullPath());
										}

										if (modelDelta == null) {

											// topology model was not moved
											resourceMoved(URI.createPlatformResourceURI(oldDiagram
													.getFullPath().toString()), URI
													.createPlatformResourceURI(file.getFullPath().toString()));

										} else if ((modelDelta.getFlags() & IResourceDelta.MOVED_FROM) > 0) {

											// found new location of topology model
											resourceMoved(URI.createPlatformResourceURI(modelDelta
													.getMovedFromPath().toString()), URI
													.createPlatformResourceURI(model.getFullPath().toString()));

										} else if ((modelDelta.getFlags() & IResourceDelta.MOVED_TO) > 0) {

											// found old location of topology model
											resourceMoved(URI.createPlatformResourceURI(model.getFullPath()
													.toString()), URI.createPlatformResourceURI(modelDelta
													.getMovedToPath().toString()));
										}
									}
								}
								break;

							case IResourceDelta.CHANGED:
								resourceFileChanged(file);
								break;
							case IResourceDelta.REMOVED:
								resourceUnloaded(file);
								break;
							}
						}
						// Recurse
						return true;
					}
				});
			} catch (CoreException ex) {
				logError(ex);
			}
			break;
		}
	}

	public void resourceChanged(Resource resource) {

		List<IFile> events = new ArrayList<IFile>();

		if (null != resource && !((Resource.Internal) resource).isLoading()
				&& ((Resource.Internal) resource).isLoaded()) {

			if (IConstants.TOPOLOGY_EXTENSION.equals(resource.getURI().fileExtension())) {

				IFile model = getFile(resource);
				if (null != model && !events.contains(model)) {
					addModelFileToIndex(model);
					notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_CHANGED,
							new IFile[] { model }));

					// track notifications so we don't send them more than once per event
					events.add(model);
				}
			} else if (IConstants.TOPOLOGYV_EXTENSION.equals(resource.getURI().fileExtension())) {
				IFile diagram = getFile(resource);
				IFile model = getAssociatedModelFile(diagram);

				if (null != diagram && !events.contains(diagram)) {
					if (null != model) {
						indexModelToDiagramAssociation(model, diagram);
						addModelFileToIndex(model);
					}

					notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.DIAGRAM_CHANGED,
							new IFile[] { diagram }));

					// track notifications so we don't send them more than once per event
					events.add(diagram);
				}
			}
		}
	}

	public void resourceLoaded(Resource resource) {

		List<IFile> events = new ArrayList<IFile>();

		if (null != resource
				&& IConstants.TOPOLOGY_EXTENSION.equals(resource.getURI().fileExtension())) {
			IFile model = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(resource.getURI().toPlatformString(true)));

			if (null != model && !events.contains(model)) {
				addModelFileToIndex(model);
				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_OPENED,
						new IFile[] { model }));

				// track notifications so we don't send them more than once per event
				events.add(model);
			}
		} else if (null != resource
				&& IConstants.TOPOLOGYV_EXTENSION.equals(resource.getURI().fileExtension())) {
			IFile model = getAssociatedModelFile(resource);
			IFile diagram = getFile(resource);

			if (null != diagram && !events.contains(diagram)) {
				if (null != model) {
					indexModelToDiagramAssociation(model, diagram);
					addModelFileToIndex(model);
//					notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_OPENED,
//							new IFile[] { model }));
				}

				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.DIAGRAM_OPENED,
						new IFile[] { diagram }));

				// track notifications so we don't send them more than once per event
				events.add(diagram);
			}
		}
	}

	public void resourceUnloaded(Resource resource) {
		resourceUnloaded(getFile(resource));
	}

	protected void resourceFileChanged(Resource resource) {
		resourceFileChanged(getFile(resource));
	}

	public void resourceUnloaded(IFile resource) {
		List<IFile> events = new ArrayList<IFile>();

		if (null != resource && IConstants.TOPOLOGY_EXTENSION.equals(resource.getFileExtension())) {

			IFile model = resource;

			if (null != model && !events.contains(model)) {
				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_CLOSED,
						new IFile[] { model }));

				List<IFile> diagrams = getAssociatedDiagramFiles(model);
				for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {

					IFile diagram = iter.next();
					if (!events.contains(diagram)) {
						notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.DIAGRAM_CLOSED,
								new IFile[] { diagram, model }));

						// track notifications so we don't send them more than once per event
						events.add(diagram);
					}
				}

				// track notifications so we don't send them more than once per event
				events.add(model);
			}
		} else if (null != resource
				&& IConstants.TOPOLOGYV_EXTENSION.equals(resource.getFileExtension())) {
			IFile model = getAssociatedModelFile(resource);
			IFile diagram = resource;

			if (!events.contains(diagram)) {
				if (null != model) {
					indexModelToDiagramAssociation(model, diagram);
					addModelFileToIndex(model);
				}

				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.DIAGRAM_CLOSED,
						new IFile[] { diagram }));

				// track notifications so we don't send them more than once per event
				events.add(diagram);
			}
		}
	}

	/**
	 * The underlying file contents have been updated outside of the tool.
	 * 
	 * @param resource
	 */
	public void resourceFileChanged(IFile resource) {
		List<IFile> events = new ArrayList<IFile>();

		if (null != resource && IConstants.TOPOLOGY_EXTENSION.equals(resource.getFileExtension())) {

			IFile model = resource;

			if (null != model && !events.contains(model)) {
				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_FILE_CHANGED,
						new IFile[] { model }));

				// track notifications so we don't send them more than once per event
				events.add(model);
			}
		} else if (null != resource
				&& IConstants.TOPOLOGYV_EXTENSION.equals(resource.getFileExtension())) {
			IFile model = getAssociatedModelFile(resource);
			IFile diagram = resource;

			if (!events.contains(diagram)) {
				if (null != model) {
					indexModelToDiagramAssociation(model, diagram);
					addModelFileToIndex(model);
				}

				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.DIAGRAM_FILE_CHANGED,
						new IFile[] { diagram }));

				// track notifications so we don't send them more than once per event
				events.add(diagram);
			}
		}
	}

	public void resourceSaved(Resource resource) {

		List<IFile> events = new ArrayList<IFile>();

		if (null != resource
				&& IConstants.TOPOLOGY_EXTENSION.equals(resource.getURI().fileExtension())) {

			IFile model = getFile(resource);

			if (null != model && !events.contains(model)) {
				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.MODEL_SAVED,
						new IFile[] { model }));

				// track notifications so we don't send them more than once per event
				events.add(model);
			}
		} else if (null != resource
				&& IConstants.TOPOLOGYV_EXTENSION.equals(resource.getURI().fileExtension())) {
			IFile diagram = getFile(resource);
			IFile model = getAssociatedModelFile(getFile(resource));

			if (!events.contains(diagram)) {

				if (null != model) {
					indexModelToDiagramAssociation(model, diagram);
					addModelFileToIndex(model);
				}

				notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.DIAGRAM_SAVED,
						new IFile[] { diagram }));

				// track notifications so we don't send them more than once per event
				events.add(diagram);
			}
		}
	}

	public void resourceMoved(URI oldUri, URI newUri) {

		IFile oldFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(oldUri.toPlatformString(true)));
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(newUri.toPlatformString(true)));

		Map<IFile, IFile> movedMap = new HashMap<IFile, IFile>();
		movedMap.put(newFile, oldFile);

		if (IConstants.TOPOLOGY_EXTENSION.equals(oldFile.getFileExtension())) {
			if (IConstants.TOPOLOGY_EXTENSION.equals(newFile.getFileExtension())) {

				reassociateModelToDiagramIndex(oldFile, newFile);
				notifyListenersOfArtifactEvent(new ArtifactMovedEvent(ArtifactEvent.MODEL_MOVED,
						movedMap));
			} else {
				// I don't know what this means
				// * renamed model file to use some other extension *
			}
		} else if (IConstants.TOPOLOGYV_EXTENSION.equals(oldFile.getFileExtension())) {
			if (IConstants.TOPOLOGYV_EXTENSION.equals(newFile.getFileExtension())) {

				reassociateDiagramToModelIndex(oldFile, newFile);
				notifyListenersOfArtifactEvent(new ArtifactMovedEvent(ArtifactEvent.DIAGRAM_MOVED,
						movedMap));
			} else {
				// I don't know what this means
				// * renamed diagram file to use some other extension *
			}
		}
	}

	public void namespaceRemoved(IContainer namespace) {
		notifyListenersOfArtifactEvent(new ArtifactEvent(ArtifactEvent.NAMESPACE_REMOVED,
				new IResource[] { namespace }));
	}

	private void addModelFileToIndex(IFile model) {
		DeployCorePlugin plugin = DeployCorePlugin.getDefault();
		if (null != plugin) {
			IModelFileIndexer indexer = plugin.getIndexer();
			if (null != indexer) {
				IProject project = model.getProject();
				if (null != project && project.isAccessible()) {
					IModelFileIndex index = indexer.getModelIndex(project, new NullProgressMonitor());
					if (null != index) {
						index.addModelFile(model);
					}
				}
			}
		}
	}

	private void logError(Throwable ex) {
		DeployCoreUIPlugin plugin = DeployCoreUIPlugin.getDefault();
		if (null != plugin) {
			ILog log = plugin.getLog();
			if (null != log) {
				log.log(DeployCoreUIPlugin.createErrorStatus(0, ex.getMessage(), ex));
			}
		}
	}

	public void editModelChanged(IEditModel notifyingEditModel, EditModelEvent anEvent) {
		editModelListener.editModelChanged(notifyingEditModel, anEvent);
	}

	public void dispose() {
		teardownListeners();
	}

	private static class ModelIndexListener extends AbstractModelIndexListener {

		private final WeakReference<TopologyArtifactsMonitor> reference;

		public ModelIndexListener(TopologyArtifactsMonitor monitor) {
			reference = new WeakReference(monitor);
		}

		@Override
		public void projectsClosed(IProject[] projects) {
			projectsRemoved(projects);
		}

		@Override
		public void projectsOpened(IProject[] projects) {
			projectsAdded(projects);
		}

		@Override
		public void projectsAdded(IProject[] projects) {

			TopologyArtifactsMonitor monitor = reference.get();
			if (monitor != null) {
				for (int i = 0; i < projects.length; i++) {
					if (projects[i].isAccessible()) {
						monitor.addEditModelListener(projects[i]);
						monitor.addPostCommitListener(projects[i]);
					}
				}
			}
		}

		@Override
		public void projectsRemoved(IProject[] projects) {

			TopologyArtifactsMonitor monitor = reference.get();
			if (monitor != null) {
				for (int i = 0; i < projects.length; i++) {

					if (projects[i].isAccessible()) {
						monitor.removeEditModelListener(projects[i]);
						monitor.removePostCommitListener(projects[i]);
					}
				}
			}
		}
	}

	private static class EditModelListener implements IEditModelListener {

		private final WeakReference<TopologyArtifactsMonitor> reference;

		@SuppressWarnings("unchecked")
		public EditModelListener(TopologyArtifactsMonitor monitor) {
			reference = new WeakReference(monitor);
		}

		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		public void editModelChanged(IEditModel notifyingEditModel, EditModelEvent anEvent) {

			final TopologyArtifactsMonitor monitor = reference.get();
			if (monitor == null) {
				return;
			}

			final List<URI> events = new ArrayList<URI>();
			List<Resource> changes = anEvent.getChangedResources();

			switch (anEvent.getEventCode())
			{
			case EditModelEvent.DIRTY:
				for (Iterator iter = changes.iterator(); iter.hasNext();) {
					final Resource resource = (Resource) iter.next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							if (!events.contains(resource.getURI())) {
								monitor.resourceChanged(resource);

								// track change events so that we don't send them out more than once
								events.add(resource.getURI());
							}
						}

						public void handleException(Throwable ex) {
							TopologyArtifactsMonitor monitor = reference.get();
							if (null != monitor) {
								monitor.logError(ex);
							}
						}
					});
				}
				break;
			}
		}
	}

	private static class PostCommitEventListener extends ResourceSetListenerImpl {

		private final class ModelEventComparator implements Comparator {
			public int compare(Object a, Object b) {

				// we want the order of our events to follow the same
				// scheme as the Integer values of our event types
				//       0  Moves 
				//       1  Loads
				//       2  Changes
				//       3  Saves
				//       4  Unloads
				//
				// If we find two events with the same priority
				// ( event type integer value ) then we need to
				// order them as follows
				//       0  events on model resources
				//       1  events on diagram resources
				//
				Map<Integer, Object> A = (Map<Integer, Object>) a;
				Map<Integer, Object> B = (Map<Integer, Object>) b;

				int aPriority = A.keySet().iterator().next().intValue();
				int bPriority = B.keySet().iterator().next().intValue();

				if (aPriority == bPriority) {
					Object aObject = A.values().iterator().next();
					Object bObject = B.values().iterator().next();

					switch (aPriority)
					{
					case 1: // RESOURCE_LOADED
					case 2: // RESOURCE_CHANGED
					case 3: // RESOURCE_SAVED
					case 4: // RESOURCE_UNLOADED
						Resource aResource = (Resource) aObject;
						Resource bResource = (Resource) bObject;

						if (!aResource.getURI().fileExtension()
								.equals(bResource.getURI().fileExtension())) {
							if (IConstants.TOPOLOGY_EXTENSION.equals(aResource.getURI().fileExtension())) {
								return 1;
							} else {
								return -1;
							}
						}
						break;

					case 0: // RESOURCE_MOVED
						URI aNewUri = (URI) A.get(RESOURCE_MOVED_ARGS_NEW_URI);
						URI bNewUri = (URI) B.get(RESOURCE_MOVED_ARGS_NEW_URI);

						if (!aNewUri.fileExtension().equals(bNewUri.fileExtension())) {
							if (IConstants.TOPOLOGY_EXTENSION.equals(aNewUri.fileExtension())) {
								return 1;
							} else {
								return -1;
							}
						}
						break;
					}
				}

				return aPriority < bPriority ? -1 : aPriority == bPriority ? 0 : 1;
			}
		}

		private final WeakReference<TopologyArtifactsMonitor> reference;

		private static final Integer RESOURCE_MOVED = Integer.valueOf(0);
		private static final Integer RESOURCE_LOADED = Integer.valueOf(1);
		private static final Integer RESOURCE_CHANGED = Integer.valueOf(2);
		private static final Integer RESOURCE_SAVED = Integer.valueOf(3);
		private static final Integer RESOURCE_UNLOADED = Integer.valueOf(4);

		private static final Integer RESOURCE_MOVED_ARGS_OLD_URI = Integer.valueOf(100);
		private static final Integer RESOURCE_MOVED_ARGS_NEW_URI = Integer.valueOf(101);

		@SuppressWarnings("unchecked")
		public PostCommitEventListener(TopologyArtifactsMonitor monitor) {
			super(NotificationFilter.ANY);
			reference = new WeakReference(monitor);
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			final TopologyArtifactsMonitor monitor = reference.get();
			if (null == monitor) {
				return;
			}

			final Map<URI, List<Map<Integer, Object>>> events = new HashMap<URI, List<Map<Integer, Object>>>();

			for (Notification notification : event.getNotifications()) {
				Object notifier = notification.getNotifier();
				if (notifier instanceof Resource) {
					if (notification.getEventType() == Notification.SET) {
						Resource resource = (Resource) notifier;
						EObject root = ResourceUtil.getFirstRoot(resource);
						int featureID = notification.getFeatureID(Resource.class);
						if (featureID == Resource.RESOURCE__IS_MODIFIED
								&& notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
							handleIsModified(events, notification, resource, root);
						} else if (featureID == Resource.RESOURCE__URI) {
							handleResourceURI(events, notification, resource);
						} else if (featureID == Resource.RESOURCE__IS_LOADED) {
							handleIsLoaded(events, notification, resource);
						}
					}
				} else if (notifier instanceof ResourceSet) {

					int featureID = notification.getFeatureID(ResourceSet.class);
					if (featureID == ResourceSet.RESOURCE_SET__RESOURCES) {
						switch (notification.getEventType())
						{
						case Notification.REMOVE:
							handleResourceRemoved(events, notification, (Resource) notification
									.getOldValue());
							break;
						case Notification.REMOVE_MANY:
							for (Resource removed : (List<Resource>) notification.getOldValue()) {
								handleResourceRemoved(events, notification, removed);
							}
							break;
						}
					}

				}

			}

			List<Map<Integer, Object>> saves = new ArrayList<Map<Integer, Object>>();
			List<Map<Integer, Object>> moves = new ArrayList<Map<Integer, Object>>();
			List<Map<Integer, Object>> changes = new ArrayList<Map<Integer, Object>>();
			List<Map<Integer, Object>> loads = new ArrayList<Map<Integer, Object>>();
			List<Map<Integer, Object>> unloads = new ArrayList<Map<Integer, Object>>();
			normalizeOrderingAndOccurrences(events, saves, moves, changes, loads, unloads);

			removeNegatingEvents(saves, moves, changes, loads, unloads);

			List sorted = new ArrayList<Map<Integer, Object>>();
			sorted.addAll(saves);
			sorted.addAll(moves);
			sorted.addAll(changes);
			sorted.addAll(loads);
			sorted.addAll(unloads);

			Collections.sort(sorted, new ModelEventComparator());

			notifyListeners(monitor, sorted);
		}

		private void notifyListeners(final TopologyArtifactsMonitor monitor, List sorted) {
			for (Iterator<Map<Integer, Object>> iter = sorted.iterator(); iter.hasNext();) {
				Map<Integer, Object> anEvent = iter.next();
				switch (anEvent.keySet().iterator().next().intValue())
				{
				case 0: // RESOURCE_MOVED
					final URI oldUri = (URI) anEvent.get(RESOURCE_MOVED_ARGS_OLD_URI);
					final URI newUri = (URI) anEvent.get(RESOURCE_MOVED_ARGS_NEW_URI);
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							monitor.resourceMoved(oldUri, newUri);
						}

						public void handleException(Throwable ex) {
							monitor.logError(ex);
						}
					});
					break;

				case 1: // RESOURCE_LOADED
					final Resource loadedResource = (Resource) anEvent.values().iterator().next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							monitor.resourceLoaded(loadedResource);
						}

						public void handleException(Throwable ex) {
							monitor.logError(ex);
						}
					});
					break;

				case 2: // RESOURCE_CHANGED
					final Resource changedResource = (Resource) anEvent.values().iterator().next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							monitor.resourceChanged(changedResource);
						}

						public void handleException(Throwable ex) {
							monitor.logError(ex);
						}
					});
					break;

				case 3: // RESOURCE_SAVED
					final Resource savedResource = (Resource) anEvent.values().iterator().next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							monitor.resourceSaved(savedResource);
						}

						public void handleException(Throwable ex) {
							monitor.logError(ex);
						}
					});
					break;

				case 4: // RESOURCE_UNLOADED
					final Resource unloadedResource = (Resource) anEvent.values().iterator().next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							monitor.resourceUnloaded(unloadedResource);
						}

						public void handleException(Throwable ex) {
							monitor.logError(ex);
						}
					});
					break;

				}
			}
		}

		private void removeNegatingEvents(List<Map<Integer, Object>> saves,
				List<Map<Integer, Object>> moves, List<Map<Integer, Object>> changes,
				List<Map<Integer, Object>> loads, List<Map<Integer, Object>> unloads) {
			for (Iterator<Map<Integer, Object>> movesIter = moves.iterator(); movesIter.hasNext();) {
				Map<Integer, Object> move = movesIter.next();
				URI oldUri = (URI) move.get(RESOURCE_MOVED_ARGS_OLD_URI);
				URI newUri = (URI) move.get(RESOURCE_MOVED_ARGS_NEW_URI);

				// remove load events for uri's found in a move event
				for (Iterator<Map<Integer, Object>> loadsIter = loads.iterator(); loadsIter.hasNext();) {
					Map<Integer, Object> load = loadsIter.next();
					URI uri = ((Resource) load.values().iterator().next()).getURI();
					if (oldUri.equals(uri) || newUri.equals(uri)) {
						loadsIter.remove();
					}
				}

				// remove unload events for uri's found in a move event
				for (Iterator<Map<Integer, Object>> unloadsIter = unloads.iterator(); unloadsIter
						.hasNext();) {
					Map<Integer, Object> unload = unloadsIter.next();
					URI uri = ((Resource) unload.values().iterator().next()).getURI();
					if (oldUri.equals(uri) || newUri.equals(uri)) {
						unloadsIter.remove();
					}
				}

				// remove change events for uri's that match a move event's oldUri
				for (Iterator<Map<Integer, Object>> changesIter = changes.iterator(); changesIter
						.hasNext();) {
					Map<Integer, Object> change = changesIter.next();
					URI uri = ((Resource) change.values().iterator().next()).getURI();
					if (oldUri.equals(uri)) {
						changesIter.remove();
					}
				}

				// remove save events for uri's that match a move event's oldUri
				for (Iterator<Map<Integer, Object>> savesIter = saves.iterator(); savesIter.hasNext();) {
					Map<Integer, Object> save = savesIter.next();
					URI uri = ((Resource) save.values().iterator().next()).getURI();
					if (oldUri.equals(uri)) {
						savesIter.remove();
					}
				}
			}
		}

		private void normalizeOrderingAndOccurrences(
				final Map<URI, List<Map<Integer, Object>>> events, List<Map<Integer, Object>> saves,
				List<Map<Integer, Object>> moves, List<Map<Integer, Object>> changes,
				List<Map<Integer, Object>> loads, List<Map<Integer, Object>> unloads) {
			for (Iterator<URI> iter = events.keySet().iterator(); iter.hasNext();) {
				URI uri = iter.next();
				List<Map<Integer, Object>> instances = events.get(uri);
				int loaded = 0;
				int unloaded = 0;
				Map<Integer, Object> last = null;
				Map<Integer, Object> save = null;
				Map<Integer, Object> move = null;
				Map<Integer, Object> change = null;
				for (Iterator<Map<Integer, Object>> instanceIter = instances.iterator(); instanceIter
						.hasNext();) {
					Map<Integer, Object> instance = instanceIter.next();
					switch (instance.keySet().iterator().next().intValue())
					{
					case 1: // RESOURCE_LOADED
						loaded++;
						last = instance;
						break;

					case 4: // RESOURCE_UNLOADED
						unloaded++;
						last = instance;
						break;

					case 3: // RESOURCE_SAVED
						save = instance;
						break;

					case 0: // RESOURCE_MOVED
						move = instance;
						break;

					case 2: // RESOURCE_CHANGED
						change = instance;
						break;
					}
				}

				if (loaded != unloaded) {
					if (last.keySet().iterator().next().intValue() == 0) {
						loads.add(last);
					} else {
						unloads.add(last);
					}
				}

				if (null != save) {
					saves.add(save);
				}

				if (null != move) {
					moves.add(move);
				}

				if (null != change) {
					changes.add(change);
				}
			}
		}

		private void handleResourceRemoved(final Map<URI, List<Map<Integer, Object>>> events,
				Notification notification, Resource resource) {

			List instances = events.get(resource.getURI());
			if (null == instances) {
				instances = new ArrayList<Map<Integer, Object>>();
				events.put(resource.getURI(), instances);
			}

			HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
			instance.put(RESOURCE_UNLOADED, resource);
			instances.add(instance);

		}

		private void handleIsLoaded(final Map<URI, List<Map<Integer, Object>>> events,
				Notification notification, Resource resource) {
			if (resource != null) {
				boolean isLoaded = notification.getNewBooleanValue();
				boolean wasLoaded = notification.getOldBooleanValue();
				if (isLoaded && !wasLoaded) {
					List instances = events.get(resource.getURI());
					if (null == instances) {
						instances = new ArrayList<Map<Integer, Object>>();
						events.put(resource.getURI(), instances);
					}

					HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
					instance.put(RESOURCE_LOADED, resource);
					instances.add(instance);
				} else if (!isLoaded && wasLoaded) {
					List instances = events.get(resource.getURI());
					if (null == instances) {
						instances = new ArrayList<Map<Integer, Object>>();
						events.put(resource.getURI(), instances);
					}

					HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
					instance.put(RESOURCE_UNLOADED, resource);
					instances.add(instance);
				}
			}
		}

		private void handleResourceURI(final Map<URI, List<Map<Integer, Object>>> events,
				Notification notification, Resource resource) {
			URI newUri = URI.createURI(notification.getNewStringValue());
			if (null != notification.getOldStringValue()
					&& !notification.getOldStringValue().trim().equals(new String())) {
				URI oldUri = URI.createURI(notification.getOldStringValue());
				if (!newUri.equals(oldUri)) {
					List instances = events.get(resource.getURI());
					if (null == instances) {
						instances = new ArrayList<Map<Integer, Object>>();
						events.put(resource.getURI(), instances);
					}

					HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
					instance.put(RESOURCE_MOVED, resource);
					instance.put(RESOURCE_MOVED_ARGS_OLD_URI, oldUri);
					instance.put(RESOURCE_MOVED_ARGS_NEW_URI, newUri);
					instances.add(instance);
				}
				ResourceSet rset = null;
				if ((rset = resource.getResourceSet()) != null) {
					if (rset instanceof ResourceSetImpl) {
						((ResourceSetImpl) rset).getURIResourceMap().remove(oldUri);
						((ResourceSetImpl) rset).getURIResourceMap().put(newUri, resource);
					}
				}
			}

			List instances = events.get(resource.getURI());
			if (null == instances) {
				instances = new ArrayList<Map<Integer, Object>>();
				events.put(resource.getURI(), instances);
			}

			HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
			instance.put(RESOURCE_SAVED, resource);
			instances.add(instance);
		}

		private void handleIsModified(final Map<URI, List<Map<Integer, Object>>> events,
				Notification notification, Resource resource, EObject root) {
			if (resource != null && root != null && root.eResource() != null
					&& root.eResource().equals(resource) && resource.isLoaded() && notification.wasSet()) {

				if (notification.getNewBooleanValue()) {
					List instances = events.get(resource.getURI());
					if (null == instances) {
						instances = new ArrayList<Map<Integer, Object>>();
						events.put(resource.getURI(), instances);
					}

					HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
					instance.put(RESOURCE_CHANGED, resource);
					instances.add(instance);
				} else {
					List instances = events.get(resource.getURI());
					if (null == instances) {
						instances = new ArrayList<Map<Integer, Object>>();
						events.put(resource.getURI(), instances);
					}

					HashMap<Integer, Object> instance = new HashMap<Integer, Object>();
					instance.put(RESOURCE_SAVED, resource);
					instances.add(instance);
				}
			}
		}

		/**
		 * I want only post-commit events, not pre-commit events.
		 */
		@Override
		public boolean isPostcommitOnly() {
			return true;
		}

	}
}
