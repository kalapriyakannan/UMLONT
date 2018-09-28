/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.impl.TopologyPath;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.internal.core.InternalDeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.InternalTopology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.EditModelScribblerListener;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.internal.emf.LoadingAdapter;

/**
 * Provides a resolution layer for imported Topologies.
 * 
 */
public class ScopeService extends AdapterImpl implements InternalScopeService {
	private Resource resource;
	private IEditModelScribbler scribbler;
	private DeploymentTopologyDomain domain;
	private IProxyCacheService cacheService;

	private final ListenerList listeners = new ListenerList();
	private final ResourceListener resourceMonitor = new ResourceListener();
	private final LoadingAdapter.Listener contextListener = new LoadingAdapter.Listener() {
		public void resourceIsLoadedChanged(Resource aResource, boolean wasLoaded, boolean isLoaded) {
			if (aResource == resource && resource != null && isLoaded && cacheService != null) {
				// update the Topology in the cache server to respond to events.
				((ProxyCacheService) cacheService).setTopology(getManagingTopology());
			}
		}
	};

	private class NotifierJob extends Job {

		private final int DELAY = 50; // ms

		private final ListenerList resources = new ListenerList() {
			@Override
			public synchronized Object[] getListeners() {
				Object[] l = super.getListeners();
				clear();
				return l;
			}
		};

		public NotifierJob() {
			super("Updating imported Topologies..."); //$NON-NLS-1$
		}

		public void enqueue(Resource resource) {
			resources.add(resource);
			schedule(DELAY);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			Object[] notifiers = listeners.getListeners();

			Object[] notifiedResources = resources.getListeners();
			for (int i = 0; i < notifiers.length; i++) {
				InternalScopeService.Listener listener = (InternalScopeService.Listener) notifiers[i];

				for (int j = 0; j < notifiedResources.length; j++) {

					Resource res = (Resource) notifiedResources[j];
					if (res.getContents().size() > 0) {
						Object contents = res.getContents().get(0);
						if (contents instanceof DeployCoreRoot) {
							DeployCoreRoot root = (DeployCoreRoot) contents;
							Topology topology = root.getTopology();
							if (topology != null) {
								listener.onReload(topology.getNamespace(), topology.getName());
							}
						}
					} else {
						IFile topologyFile = WorkbenchResourceHelper.getFile(res);
						if (topologyFile != null) {
							String topologyName = topologyFile.getName();
							if (topologyFile.getFileExtension() != null
									&& topologyFile.getFileExtension().length() > 0) {
								topologyName = topologyFile.getName().substring(0,
										topologyName.length() - topologyFile.getFileExtension().length() - 1); // the -1 is due to the file separator
							}

							String topologyNamespace = IConstants.EMPTY_STRING;
							INamespaceElement namespace = NamespaceCore.create(topologyFile.getParent());
							if (namespace != null) {
								topologyNamespace = namespace.getQualifiedName();
							}

							listener.onReload(topologyNamespace, topologyName);
						}

					}
				}
			}
			return Status.OK_STATUS;
		}

	};

	private final NotifierJob notifierJob = new NotifierJob();

	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);
		if (newTarget == null) {
			try {
				setContext(null);
			} catch (EditModelException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}

		} else if (newTarget instanceof Resource) {
			try {
				setContext((Resource) newTarget);
			} catch (EditModelException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
		}
	}

	public boolean isAdapterForType(Object type) {
		return type == IScopeService.ADAPTER_TYPE;
	}

	/**
	 * @param newContext
	 *           The context of the Scope Service determines what editable Topology is the starting
	 *           point for resolutions.
	 * @throws EditModelException
	 */
	public void setContext(Resource newContext) throws EditModelException {
		if (resource != newContext) {

			if (resource != null) {
				// remove the existing listener, if any
				LoadingAdapter loadingAdapter = LoadingAdapter.findAdapter(resource);
				loadingAdapter.removeListener(contextListener);
			}

			if (newContext != null) {
				LoadingAdapter loadingAdapter = LoadingAdapter.findAdapter(newContext);
				loadingAdapter.addListener(contextListener);
			}

			if (resource != null) {
				dispose();
			}

			resource = newContext;
			IFile sourceFile = WorkbenchResourceHelper.getFile(resource);
			if (sourceFile != null) {
				domain = new DeploymentTopologyDomain(sourceFile) {
					/*
					 * Need to return false to avoid refernce counting the containing resources.
					 * 
					 * @see com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain#isContained(com.ibm.
					 *      ccl.soa.infrastructure.emf.IResourceDescriptor)
					 */
					@Override
					public boolean isContained(IResourceDescriptor resourceDescriptor) {
						if (resourceDescriptor != null && resourceDescriptor.getLocalPath() != null) {
							return IConstants.TOPOLOGY_EXTENSION.equals(resourceDescriptor.getLocalPath()
									.getFileExtension());
						}
						return false;
					}

					/*
					 * Need to return false to avoid refernce counting the containing resources.
					 * 
					 * @see com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain#isContained(org.eclipse
					 *      .emf.ecore.resource.Resource)
					 */
					@Override
					public boolean isContained(Resource aResource) {
						return IConstants.TOPOLOGY_EXTENSION.equals(aResource.getURI().fileExtension());
					}
				};

				scribbler = domain.createScribblerForRead();
				scribbler.addListener(resourceMonitor);
				cacheService = ProxyCacheService.create(this);
				((ProxyCacheService) cacheService).setTopology(getManagingTopology());
			}
		}
	}

	/**
	 * Dispose of any acquired resources and remove any active listeners.
	 */
	public void dispose() {
		// no progress monitor is available in dispose()
		try {
			if (scribbler != null) {
				scribbler.removeListener(resourceMonitor);
				if (!scribbler.isClosed()) {
					scribbler.close(new NullProgressMonitor());
				}
			}
		} catch (EditModelException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		if (cacheService != null) {
			cacheService.dispose();
			cacheService = null;
		}
		scribbler = null;
		domain = null;

	}

	public Topology resolve(Import imported) {
		return resolve(imported.getNamespace(), imported.getPattern());
	}

	public Topology resolve(final String namespace, final String name) {

		return internalResolve(namespace, name);
	}

	private Topology internalResolve(String namespace, String name) {

		IFile topologyFile = NamespaceCore.resolveTopology(domain.getProject(), namespace, name);
		if (topologyFile != null && topologyFile.exists() && scribbler != null) {
			Resource topologyResource = scribbler.getResource(topologyFile.getFullPath(),
					IEditModelScribbler.OPTION_LOAD_AS_ISOLATED
							| IEditModelScribbler.OPTION_LOAD_RESOURCE);

			return getTopology(topologyResource);

		} else {
			//NM: Commenting this out. We can have a template import unit, which does not have any namespace or pattern defined
			//DeployCorePlugin.logError(0, NLS.bind(DeployCoreMessages.ScopeService_Cannot_resolve_topology_0_1_, new Object[]{namespace, name}), null);
		}
		return null;
	}

	private Topology getTopology(Resource topologyResource) {
		if (topologyResource != null && topologyResource.getContents().size() > 0) {
			DeployCoreRoot root = (DeployCoreRoot) topologyResource.getContents().get(0);
			return root.getTopology();
		}
		return null;
	}

	public IProxyCacheService getCacheService() {
		return cacheService;
	}

	/**
	 * Resolve the EObject in the Isolated Resource Set.
	 * 
	 * @param eObj
	 *           An eproxy
	 * @return The resolved object or null.
	 * 
	 */
	public EObject resolve(EObject eObj) {
		return EcoreUtil.resolve(eObj, getContext());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService#resolve(java.lang
	 *      .String)
	 */
	public DeployModelObject resolve(String path) {
		return resolve(path, true);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService#resolve(java.lang
	 *      .String)
	 */
	public DeployModelObject resolve(String path, boolean proxify) {
		if (path == null) {
			return null;
		}
		Topology context = getContext();
		if (context == null) {
			// Cannot resolve without context
			return null;
		}

		// Format:
		// { { namespace + '.' } + topology-name + ':' } + #getFullPath()
		// Example:
		// com.foo.namespace.TopologynName:/path/to/element

		// Check for topology namespace and name separator
		int contextIndx = path.indexOf(IConstants.TOPOLOGY_SEPARATOR);
		if (contextIndx == -1) {
			// Path relative to context topology
			return context.resolve(path);
		} else if (contextIndx == 0) {
			// Treat as local context
			if (path.length() == 1) {
				return context;
			}
			return context.resolve(path.substring(1));
		}

		TopologyPath resolvedPath = new TopologyPath(path);

		// Check if namespace and name point to current context
		if (resolvedPath.getTopologyName().equals(context.getName())
				&& namespaceMatches(resolvedPath.getNamespace(), context)) {
			// resolve locally
			return context.resolve(resolvedPath.getRelativePath());
		}

		//
		// Resolve through import
		//
		Import importDcl = context.getImport(resolvedPath.getNamespace(), resolvedPath
				.getTopologyName());
		if (importDcl == null) {
			if (context instanceof InternalTopology) {
				InternalTopology internalContext = (InternalTopology) context;
				List<Import> relatedImports = internalContext.findRelatedImport(this, path,
						new ArrayList<String>());
				if (relatedImports.size() > 0) {
					importDcl = relatedImports.get(0); // the first import is the source up the tree
				}
			}
			if (importDcl == null) {
				return null;
			}
		}

		Topology referencedTopology = resolve(resolvedPath.getNamespace(), resolvedPath
				.getTopologyName());
		if (referencedTopology == null) {
			// Bad import (could not be resolved)
			return null;
		}

		DeployModelObject referenced = ((InternalDeployModelObject) referencedTopology).resolve(
				resolvedPath.getRelativePath(), this);
		if (referenced == null) {
			// Bad relative path
			return null;
		}

		if (proxify) {
			return cacheService.findProxy(referenced, importDcl);
		}
		return referenced;
	}

	private boolean namespaceMatches(String namespace, Topology top) {
		if (namespace == null || namespace.equals(INamespaceElement.DEFAULT_NAMESPACE)) {
			return top.getNamespace() == null
					|| top.getNamespace().equals(INamespaceElement.DEFAULT_NAMESPACE);
		}
		return namespace.equals(top.getNamespace());
	}

	private Topology getContext() {
		if (resource != null) {
			if (resource.getContents().size() > 0) {
				DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
				if (root != null) {
					return root.getTopology();
				}
			}
		}
		return null;
	}

	public EObject eGetFromURI(String ecoreURI) {

		int indexOf = -1;
		if ((indexOf = ecoreURI.indexOf(PROXY)) > -1) {
			String path = ecoreURI
					.substring(indexOf + PROXY.length() + 1 /* 1 for the forward slash */);
			return resolve(path);
		} else if (ecoreURI.indexOf(IConstants.TOPOLOGY_SEPARATOR) > -1) {
			return resolve(ecoreURI);
		}
		return null;
	}

	public String eGetURIFragment(EObject dmo) {

		if (Proxy.isProxyClass(dmo.getClass())) {
			if (dmo instanceof DeployModelObject) {
				return PROXY + IPath.SEPARATOR + ((DeployModelObject) dmo).getFullPath();
			}
		}
		return null;
	}

	public Topology getManagingTopology() {
		return getContext();
	}

	public void listen(Listener listener) {
		listeners.add(listener);
	}

	public void remove(Listener listener) {
		listeners.remove(listener);
	}

	protected class ResourceListener extends EditModelScribblerListener {

		public void resourcesLoaded(IEditModelScribbler source, Resource[] resources) {
//			Object[] notifiers = listeners.getListeners();
//
//			for (int i = 0; i < notifiers.length; i++) {
//				InternalScopeService.Listener listener = (InternalScopeService.Listener) notifiers[i];
//
//				for (int j = 0; j < resources.length; j++) {
//
//					if (resources[0].getContents().size() > 0) {
//						Object contents = resources[0].getContents().get(0);
//						if (contents instanceof DeployCoreRoot) {
//							DeployCoreRoot root = (DeployCoreRoot) contents;
//							Topology topology = root.getTopology();
//							if (topology != null) {
//								listener.onReload(topology, topology.getNamespace(), topology.getName());
//							}
//						}
//					}
//				}
//			}

		}

		@Override
		public void resourcesUnloaded(IEditModelScribbler source, Resource[] resources) {
			for (Resource resource : resources) {
				notifierJob.enqueue(resource);
			}
		}

	}

}
