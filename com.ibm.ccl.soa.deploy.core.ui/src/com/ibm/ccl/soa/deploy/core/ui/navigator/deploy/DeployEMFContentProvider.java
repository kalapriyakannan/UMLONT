/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.SaveablesProvider;
import org.eclipse.wst.common.internal.emfworkbench.integration.DynamicAdapterFactory;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ModelFilesRefreshManager;
import com.ibm.ccl.soa.deploy.core.ui.resources.ProjectDeployDomain;
import com.ibm.ccl.soa.deploy.core.ui.savables.ArtifactListener;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveablesProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.AdaptabilityUtility;
import com.ibm.ccl.soa.deploy.index.search.Query;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * @since 1.0
 * 
 */
public class DeployEMFContentProvider implements ITreeContentProvider, IAdaptable {
	private static final Class<SaveablesProvider> SAVEABLES_PROVIDER_CLASS = SaveablesProvider.class;
	protected static final Object[] NO_CHILDREN = new Object[0];
	protected static final String[] NO_PROPERTIES = new String[0];
	private AdapterFactoryContentProvider delegateContentProvider;

	private ArtifactListener listener = null;

	private TopologySaveablesProvider provider;

	private String viewerId = null;
	private AbstractTreeViewer viewer;

	private final Map<IFile, Collection<TopologyDiagramNode>> diagramsCache = new WeakHashMap<IFile, Collection<TopologyDiagramNode>>();

	private final Collection<TransactionalEditingDomain> domains = new HashSet<TransactionalEditingDomain>();
	private final Collection<IFile> models = new HashSet<IFile>();

	private final Object lock = new Object();

	private ModelFilesRefreshManager refreshManager;

	private ResourceSetListener topologyListener;

	/**
	 * 
	 */
	public DeployEMFContentProvider() {
		provider = new TopologySaveablesProvider();

	}

	/*
	 * public DeployEMFContentProvider(String aViewerId) { this(); updateContentProviders(aViewerId);
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object anInputElement) {
		return getChildren(anInputElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object aParentElement) {

		Object[] children = NO_CHILDREN;

		//Add configuration units as children of their host
		if (aParentElement instanceof Unit) {
			Collection c = ((Unit) aParentElement).getEditTopology().getRelationships().getHosted(
					((Unit) aParentElement));
			List<Object> kids = new ArrayList<Object>();
			for (Object o : c) {
				if (o instanceof Unit && ((Unit) o).isConfigurationUnit()) {
					kids.add(o);
				}
			}
			children = !kids.isEmpty() ? kids.toArray() : NO_CHILDREN;

			//Add DMOs as children of the topology
		} else if (aParentElement instanceof IFile) {

			IFile modelFile = (IFile) aParentElement;
			if (isTopologyFile((IFile) aParentElement)) {

				//@jazz 306:  exception in console when opening closing project
				if (((IFile) aParentElement).isAccessible()) {

					TopologySaveable saveable = safeGetSaveable(aParentElement);
					List<Object> nodes = new ArrayList<Object>();

					// If the model *is being* loaded just return the place holder 			
					if (LoadingModelNode.isBeingLoaded(modelFile)) {

						nodes.add(LoadingModelNode.createPlaceHolder(modelFile));
						collectModelChildren(saveable, modelFile, nodes);
						children = nodes.toArray(new Object[nodes.size()]);

						// If the model has been loaded, just return it  
					} else if (saveable != null && saveable.isOpen()) {
						/* model already loaded, just return the model */

						LoadingModelNode placeHolder = LoadingModelNode.createPlaceHolder(modelFile);
						nodes.add(placeHolder);

						/* we need to load the model, possible long running operation */
						if (LoadingModelNode.canBeginLoading(modelFile)) {
							new LoadModelJob(viewer, placeHolder, modelFile).schedule();
						}

						// LOADING_EXAMPLE Otherwise return a place holder node and start loading job
						Collection<TopologyDiagramNode> diagrams = diagramsCache.get(modelFile);
						if (diagrams != null && diagrams.size() > 0) {
							nodes.addAll(diagrams);
						} else {
							nodes.add(placeHolder);
						}

						collectModelChildren(saveable, modelFile, nodes);
						children = nodes.toArray(new Object[nodes.size()]);
					}
				}
			}
			return children;
		} else {
			children = delegateContentProvider.getChildren(aParentElement);
		}
		return children != null ? children : NO_CHILDREN;
	}

	public Object getParent(Object object) {
		Object parent = delegateContentProvider.getParent(object);

		if (parent == null && object instanceof EObject) {
			parent = AdaptabilityUtility.getAdapter(object, IFile.class);
		}
		if (parent == null && object instanceof TopologyDiagramNode) {
			parent = ((TopologyDiagramNode) object).getTopologyFile();
		}
		return parent;
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		if (listener != null) {
			TopologyArtifactsMonitor.INSTANCE.removeListener(listener);
			listener = null;
		}
		if (refreshManager != null) {
			refreshManager.dispose();
		}
		provider.dispose();
		delegateContentProvider.dispose();
	}

	/*
	 * @see ITreeContentProvider#hasChildren(Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof Unit) {
			return hasConfigChildren(((Unit) element).getEditTopology().getRelationships(),
					(Unit) element);
		}
		if (element instanceof IFile && isTopologyFile((IFile) element)) {

			if (LoadingModelNode.isBeingLoaded((IFile) element)) {
				return true;
			}

			TopologySaveable saveable = safeGetSaveable(element);

			if (saveable == null || !saveable.isOpen()) {
				return false;
			}

			Collection<TopologyDiagramNode> collection = diagramsCache.get(element);
			if (collection == null || collection.size() > 0) {
				return true;
			}

			Resource resource = saveable.getScribbler().getResource((IFile) element,
					IEditModelScribbler.OPTION_NONE);
			if (null != resource && resource.getContents().size() > 0
					&& resource.getContents().get(0) instanceof DeployCoreRoot) {
				DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
				Topology topology = root.getTopology();
				if (topology != null) {
					Object[] children = delegateContentProvider.getChildren(topology);
					return children != null ? children.length > 0 : false;
				}
				return false;
			}
		}

		return delegateContentProvider.hasChildren(element);

	}

	private TopologySaveable safeGetSaveable(Object element) {
		synchronized (lock) {
			if (provider == null || provider.isDisposed()) {
				provider = new TopologySaveablesProvider();
				provider.setRefreshManager(ModelFilesRefreshManager.create(viewer));
			}
		}
		return (TopologySaveable) provider.getSaveable(element);
	}

	private boolean hasConfigChildren(IRelationshipChecker relationships, Unit unit) {
		if (unit != null) {

			// make sure it hasn't been deleted.
			if (unit.getEditTopology() != null) {

				Collection c = relationships.getHosted(unit);
				for (Object o : c) {
					if (o instanceof Unit && ((Unit) o).isConfigurationUnit()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isTopologyFile(IFile file) {
		return file.getName().endsWith(ProjectDeployDomain.TOPOLOGY_EXTENSION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer aViewer, Object anOldInput, Object aNewInput) {
		String newViewerId = null;

		if (aViewer instanceof AbstractTreeViewer) {
			viewer = (AbstractTreeViewer) aViewer;

			if (aViewer instanceof CommonViewer) {
				newViewerId = ((CommonViewer) aViewer).getNavigatorContentService().getViewerId();
			}

			if (newViewerId != null && (viewerId == null || !viewerId.equals(newViewerId))) {
				updateContentProviders(newViewerId);
			}

			delegateContentProvider.inputChanged(aViewer, anOldInput, aNewInput);

			Assert.isTrue(aViewer instanceof AbstractTreeViewer);

			if (refreshManager != null) {
				refreshManager.dispose();
			}
			refreshManager = ModelFilesRefreshManager.create(viewer);
			provider.setRefreshManager(ModelFilesRefreshManager.create(viewer));

			if (aViewer != null) {
				if (listener == null) {
					listener = createArtifactListener();
					TopologyArtifactsMonitor.INSTANCE.addListener(listener);
				}
			} else {
				if (listener != null) {
					TopologyArtifactsMonitor.INSTANCE.removeListener(listener);
					listener = null;
				}
			}
		}
	}

	private ArtifactListener createArtifactListener() {
		return new ArtifactListener() {

			@Override
			public void onModelOpened(IFile model) {

				Saveable saveable = provider.getSaveable(model);
				if (saveable != null && saveable instanceof TopologySaveable) {

					if (!models.contains(model)) {
						Topology topology = ((TopologySaveable) saveable).getTopology();
						if (topology != null) {
							TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(topology);
							if (!domains.contains(domain)) {
								domain.addResourceSetListener(getTopologyListener());
								domains.add(domain);
							}
						}
						models.add(model);
					}
				}
			}

			@Override
			public void onModelClosed(IFile model) {

				models.remove(model);
				if (models.size() == 0) {
					for (TransactionalEditingDomain domain : domains) {
						domain.removeResourceSetListener(getTopologyListener());
					}
				}
			}
		};
	}

	private ResourceSetListener getTopologyListener() {
		if (topologyListener == null) {
			topologyListener = createEventListener();
		}
		return topologyListener;
	}

	/**
	 * Override if necessary to create a custom event listener. The default implementation will call
	 * {@link #refresh()}.
	 * 
	 * @return The event listener that will update the UI as changes occur to the model.
	 */
	protected ResourceSetListener createEventListener() {
		return new DemultiplexingListener(NotificationFilter.createEventTypeFilter(Notification.SET)) {

			protected void handleNotification(TransactionalEditingDomain domain,
					final Notification notification) {

				if (!viewer.getControl().isDisposed()) {

					if (notification.getEventType() == Notification.SET) {
						if (notification.getNotifier() instanceof DeployModelObject) {
							if (refreshManager != null) {
								refreshManager.enqueue(notification.getNotifier());
							}
						}
					}
				}
			}
		};
	}

	/**
	 * @param viewerId2
	 */
	private void updateContentProviders(String aViewerId) {
		/* Dispose of the existing content providers */
		if (delegateContentProvider != null) {
			delegateContentProvider.dispose();
		}

		/* Create new content providers using the new viewer id */
		DynamicAdapterFactory adapterFactory = new DynamicAdapterFactory(aViewerId);
		delegateContentProvider = new AdapterFactoryContentProvider(adapterFactory) {
			public void notifyChanged(Notification notification) {
				// swallow events to avoid gratuitous refresh events from EMF
				Object target = null;
				if (notification instanceof ViewerNotification) {
					ViewerNotification vn = (ViewerNotification) notification;
					if (vn.getElement() instanceof Topology) {
						target = AdaptabilityUtility.getAdapter(vn.getElement(), IFile.class);
					} else if (vn.getElement() instanceof Resource) {
						target = AdaptabilityUtility.getAdapter(vn.getElement(), IFile.class);
					} else {
						target = vn.getElement();
					}
				}
				if (target != null && provider.getRefreshManager() != null) {
					provider.getRefreshManager().enqueue(target);
				}

			}
		};

		/* Remember the viewer id */
		viewerId = aViewerId;
	}

	/**
	 * @return Returns the viewer ID of the associate viewer
	 */
	public String getViewerId() {
		return viewerId;
	}

	private void collectDiagramNodes(final IFile modelFile, final List<TopologyDiagramNode> children) {
		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				TopologySaveable saveable = (TopologySaveable) provider.getSaveable(modelFile);
				if (null != saveable && saveable.isOpen()) {
					Resource resource = saveable.getScribbler().getResource(modelFile,
							IEditModelScribbler.OPTION_NONE);
					if (null != resource && resource.getContents().size() > 0
							&& resource.getContents().get(0) instanceof DeployCoreRoot) {
						DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
						Topology topology = root.getTopology();
						if (null != topology) {
							//Add our Diagram files as children of the model
							Collection<IFile> c = Query.findReferencingDiagramResources(topology, null,
									true, false, true, false, new NullProgressMonitor());
							for (Iterator<IFile> iter = c.iterator(); iter.hasNext();) {
								//Check for the same topology and remove it-- also need to change the names
								IFile file = iter.next();
								if (IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
									children.add(new TopologyDiagramNode(file, saveable));
								}
							}
						}
					}
				}
			}

			public void handleException(Throwable ex) {
				DeployCoreUIPlugin.logError(0, ex.toString(), ex);
			}
		});
	}

	private void collectModelChildren(final TopologySaveable saveable, final IFile modelFile,
			final List<Object> children) {
		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				if (null != saveable && saveable.isOpen()) {
					Topology topology = saveable.getTopology();
					if (topology != null) {
						IRelationshipChecker relationships = topology.getRelationships();
						if (null != topology) {
							//Add the other children
							for (Object obj : delegateContentProvider.getChildren(topology)) {
								if (obj instanceof Unit) {
									Unit unit = (Unit) obj;
									// Filter config units
									// If the unit is not a config unit or is an unhosted config unit add it
									if (!unit.isConfigurationUnit() || relationships.getHost(unit).isEmpty()) {
										children.add(unit);
									} else { // Add config units who host other config units, add it
										if (hasConfigChildren(relationships, unit)) {
											children.add(unit);
										}
									}
								} else {
									children.add(obj);
								}
							}
						}
					}
				}
			}

			public void handleException(Throwable ex) {
				DeployCoreUIPlugin.logError(0, ex.toString(), ex);
			}
		});
	}

	// LOADING_EXAMPLE LoadModelJob handles work of loading the model in a background thread
	public class LoadModelJob extends Job {

		private final LoadingModelNode placeHolder;
		private final AbstractTreeViewer viewer;
		private final IFile modelFile;

		public LoadModelJob(AbstractTreeViewer viewer, LoadingModelNode placeHolder, IFile modelFile) {
			super(placeHolder.getText());
			this.viewer = viewer;
			this.placeHolder = placeHolder;
			this.modelFile = modelFile;
			setRule(modelFile);

			Job.getJobManager().cancel(modelFile);
		}

		@Override
		public boolean belongsTo(Object family) {
			return family.equals(modelFile);
		}

		protected IStatus run(IProgressMonitor monitor) {
			LoadingModelUIAnimationJob updateUIJob = new LoadingModelUIAnimationJob(viewer,
					placeHolder);
			updateUIJob.schedule();

			List<TopologyDiagramNode> children = new ArrayList<TopologyDiagramNode>();
			Collection<TopologyDiagramNode> cached = diagramsCache.get(modelFile);
			Collection<TopologyDiagramNode> defunct = null;
			try {
				// LOADING_EXAMPLE Load the model in the background after starting the animation job

				TopologySaveable saveable = safeGetSaveable(modelFile);

				if (saveable != null && saveable.isOpen()) {
					collectDiagramNodes(modelFile, children);
					if (cached != null) {
						// compare children; if unchanged, don't add
						if (cached.size() == children.size() && cached.containsAll(children)) {
//							children.clear();
						} else {
							// update the cache with new values
							diagramsCache.put(modelFile, children);

							defunct = new ArrayList<TopologyDiagramNode>(cached);
							defunct.removeAll(children);
						}
					} else {
						// first cached values
						diagramsCache.put(modelFile, children);
					}

//					collectModelChildren(saveable, modelFile, children);
				} else {
					//Clear the cache since there are no saveables.
					if (cached != null) {
						diagramsCache.remove(modelFile);
					}
				}

			} finally {
				/* dispose of the place holder, causes the termination of the animation job */
				placeHolder.dispose();
				Job clear = new ClearPlaceHolderJob(viewer, placeHolder, modelFile,
						!children.isEmpty() ? children.toArray() : NO_CHILDREN, defunct != null ? defunct
								.toArray() : NO_CHILDREN);
				clear.setPriority(SHORT);
				clear.setRule(modelFile);
				clear.schedule();
			}

			return Status.OK_STATUS;
		}

	}

	public Object getAdapter(Class adapter) {
		if (adapter == SAVEABLES_PROVIDER_CLASS) {
			synchronized (lock) {
				if (provider == null || provider.isDisposed()) {
					provider = new TopologySaveablesProvider();
					provider.setRefreshManager(ModelFilesRefreshManager.create(viewer));
				}
				return provider;

			}
		}
		return null;
	}

}
