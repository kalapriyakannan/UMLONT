/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.locationbinding;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.InitializeModelOperation;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.CoreResourceImpl;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.deploy.internal.core.locationbinding.LocationBindingAdapter;
import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationBindingRoot;
import com.ibm.ccl.soa.deploy.location.LocationFactory;
import com.ibm.ccl.soa.deploy.location.LocationPackage;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Service APIs to assist with Location Binding.
 * 
 * <p>
 * When saving topologies that contain {@link FileArtifact}s, a *_rdm.tloc file is written as a
 * sibling to the .topology file. The .tloc file contains a {@link LocationBinding} element with a
 * {@link BindingEntry} for each FileArtifact.
 * 
 * <p>
 * This behavior can be turned off using the the Topology Editor Preferences Page, or by calling
 * {@link LocationBindingService#setLocationBindingUsage(boolean)}.
 * 
 * @since 2.0
 * @see CoreResourceImpl
 */
public class LocationBindingService {
	/**
	 * the location binding usage default value
	 */
	//public static final boolean LOCATION_BINDING_USAGE_DEFAULT = true;
	/**
	 * The singleton instance for the location binding service
	 */
	public final static LocationBindingService INSTANCE = new LocationBindingService();

	private final ListenerList listeners = new ListenerList();

	//private final boolean locationBindingUsage = LOCATION_BINDING_USAGE_DEFAULT;

	/**
	 * Use to return the location binding ID for resource management
	 * 
	 * @param topName
	 *           the name of the topology
	 * @return the ID of the location binding resource
	 */
	public String getLocBindingId(String topName) {
		return topName;
	}

	protected LocationBindingService() {
	}

	/**
	 * Resolve the binding entries from the existing resource, if already present
	 * 
	 * @param resolvedBindingEntries
	 *           the list to be used for populating existing entries
	 * @param artifact
	 *           the deploymodel object to be used to locate the resource for binding
	 */
	public void resolvedBindingEntries(final List<String> resolvedBindingEntries, Artifact artifact) {
		if (artifact.eResource() == null) {
			return;
		}
		ChangeScope<Artifact, DeploymentTopologyDomain> changeScope = ChangeScope
				.createChangeScopeForWrite(artifact);
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(), "resolveBindingEntry") { //$NON-NLS-1$
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				ChangeScope<Artifact, DeploymentTopologyDomain> scope = ChangeScope
						.findChangeScope(info);
				Artifact artifact = scope.getTarget();

				LocationBinding locBinding = getLocationBinding(scope, artifact);
				String locBindingContext = locBinding.getContext();
				String rootPrefix = ""; //$NON-NLS-1$
				if (locBindingContext != null
						&& locBindingContext.equals(IConstants.LocationBindingConstants.LOC_CTX_RELATIVE)) {
					IProject project = ProjectUtilities.getProject(artifact);
					if (project != null) {
						rootPrefix = project.getName() + "/"; //$NON-NLS-1$
						String rootName = getNamespaceRoot(artifact);
						if (rootName != null) {
							rootPrefix += rootName + "/"; //$NON-NLS-1$
						}
					}
				}
				String artifactPath = artifact.getFullPath();
				List<BindingEntry> bindingEntries = locBinding.getBindingEntry();
				for (Iterator<BindingEntry> it = bindingEntries.iterator(); it.hasNext();) {
					BindingEntry bindingEntry = it.next();
					String dmoPath = bindingEntry.getDmoPath();
					if (artifactPath.equals(dmoPath)) {
						resolvedBindingEntries.add(rootPrefix + bindingEntry.getLocation());
					}
				}
				return Status.OK_STATUS;
			}
		};
		try {

			changeScope.execute(op, ChangeScope.OPTION_DO_NOT_SAVE, new NullProgressMonitor());

		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} finally {
			changeScope.close(new NullProgressMonitor());
		}
	}

	private String getNamespaceRoot(Artifact artifact) {
		IFile topologyFile = WorkbenchResourceHelperBase.getIFile(artifact.eResource().getURI());
		if (topologyFile != null) {
			//strip the source folder if no create project
			INamespaceFragmentRoot root = NamespaceCore.getRoot(topologyFile.getParent());
			if (root != null) {
				return root.getName();
			}
		}
		return null;
	}

	/**
	 * get or create the location binding resource
	 * 
	 * @param changeScope
	 *           the changescope to be used for resource management
	 * @param dmo
	 *           the deploymodel object to be used to load the resource
	 * @return the instance of the location binding
	 * @throws ExecutionException
	 */
	protected LocationBinding getLocationBinding(
			ChangeScope<? extends DeployModelObject, DeploymentTopologyDomain> changeScope,
			final DeployModelObject dmo) throws ExecutionException {
		final String topQualifiedName = dmo.getTopology().getQualifiedName();
		final String topName = dmo.getTopology().getName();
		InitializeModelOperation<LocationBindingRoot> initOp = new InitializeModelOperation<LocationBindingRoot>(
				changeScope.getTransactionalEditingDomain(), NLS.bind(
						DeployCoreMessages.ChangeScope_Creating_Loc_Binding_0_, topQualifiedName)) {
			@Override
			protected IStatus initialize(ChangeScope<LocationBindingRoot, ?> scope) {
				LocationBindingRoot root = scope.getTarget();
				LocationBinding locationBinding = LocationFactory.eINSTANCE.createLocationBinding();
				root.setLocationBinding(locationBinding);
				locationBinding.setName(topName);
				locationBinding.setTopology(topQualifiedName);
				return Status.OK_STATUS;
			}
		};
		LocationBindingRoot root = changeScope.createModel(changeScope.getDomain().getLocationFile(),
				LocationPackage.eINSTANCE.getLocationBindingRoot(), initOp);

		// update the binding for the given location resource
		LocationBindingAdapter.update(dmo.eResource(), root.eResource());

		return root.getLocationBinding();
	}

	/**
	 * Save the location binding resource with the contents of the topology. This API traverses
	 * through the artifact list and saves the dmo path and the location for all the file URI's.
	 * 
	 * @param top
	 *           the topology to be used for the location binding
	 */
	/*
	 * public void saveLocationBinding(final LocationBinding locBinding){ String topQName =
	 * locBinding.getTopology(); final IFile topFile =
	 * NamespaceCore.resolveTopology(ProjectUtilities.getProject(locBinding),
	 * locBinding.getTopology()); final ChangeScope changeScope =
	 * ChangeScope.createChangeScope(topFile); AbstractEMFOperation op = new
	 * AbstractEMFOperation(changeScope.getTransactionalEditingDomain(), "saveLocationBinding"){
	 * //$NON-NLS-1$ @Override protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
	 * throws ExecutionException { Topology top = changeScope.openTopology(); //LocationBinding
	 * locBinding = getLocationBinding(changeScope, top); List unitList = top.getUnits(); List<BindingEntry>
	 * newBindingEntries = new ArrayList(); for (Iterator iterator = unitList.iterator();
	 * iterator.hasNext();) { Unit unit = (Unit) iterator.next(); List artifactList =
	 * unit.getArtifacts(); for (Iterator iterator2 = artifactList.iterator(); iterator2 .hasNext();) {
	 * Object dmo = iterator2.next(); if(dmo instanceof FileArtifact){ FileArtifact fileArtifact =
	 * (FileArtifact) dmo; List fileURIList = fileArtifact.getFileURIs(); for (Iterator iterator3 =
	 * fileURIList.iterator(); iterator3 .hasNext();) { String location = (String) iterator3.next();
	 * BindingEntry entry = LocationFactory.eINSTANCE.createBindingEntry();
	 * entry.setDmoPath(fileArtifact.getFullPath()); entry.setLocation(location);
	 * newBindingEntries.add(entry); } } } } List<BindingEntry> bindingEntries =
	 * locBinding.getBindingEntry(); bindingEntries.clear();
	 * bindingEntries.addAll(newBindingEntries); return Status.OK_STATUS; } }; try{ IStatus status =
	 * changeScope.execute(op, ChangeScope.OPTION_DO_NOT_SAVE, new NullProgressMonitor());
	 * if(!status.isOK()){ DeployCorePlugin.log(status); } }catch(Exception e){
	 * DeployCorePlugin.logError(0, e.getMessage(), e); }finally{ changeScope.close(new
	 * NullProgressMonitor()); } }
	 */

	/**
	 * Save the location binding resource with the contents of the topology. This API traverses
	 * through the artifact list and saves the dmo path and the location for all the file URI's.
	 * 
	 * @param top
	 *           the topology to be used for the location binding
	 */
	public void saveLocationBinding(final Topology top) {
		final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(top);
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(), "saveLocationBinding") { //$NON-NLS-1$
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				LocationBinding locBinding = getLocationBinding(changeScope, top);

				//				System.out.println("Saving \""+ locBinding.eResource().getURI() +"\""); //$NON-NLS-1$ //$NON-NLS-2$

				Resource locationResource = locBinding.eResource();
				if (locationResource.isModified()) {
					List unitList = top.getUnits();
					List<BindingEntry> newBindingEntries = new ArrayList();
					for (Iterator iterator = unitList.iterator(); iterator.hasNext();) {
						Unit unit = (Unit) iterator.next();
						List artifactList = unit.getArtifacts();
						for (Iterator iterator2 = artifactList.iterator(); iterator2.hasNext();) {
							Object dmo = iterator2.next();
							if (dmo instanceof FileArtifact) {
								FileArtifact fileArtifact = (FileArtifact) dmo;
								List fileURIList = fileArtifact.getFileURIs();
								for (Iterator iterator3 = fileURIList.iterator(); iterator3.hasNext();) {
									String location = (String) iterator3.next();
									BindingEntry entry = LocationFactory.eINSTANCE.createBindingEntry();
									entry.setDmoPath(fileArtifact.getFullPath());
									entry.setLocation(location);
									newBindingEntries.add(entry);
								}
							}
						}
					}
					List<BindingEntry> bindingEntries = locBinding.getBindingEntry();
					bindingEntries.clear();
					bindingEntries.addAll(newBindingEntries);

					// we force the save of the location binding resource always
					try {
						if (locationResource != null) {
							locationResource.save(Collections.emptyMap());
						}
					} catch (IOException e) {
						return DeployCorePlugin
								.createErrorStatus(
										0,
										NLS
												.bind(
														DeployCoreMessages.LocationBindingService_Could_not_save_location_binding_res_,
														locationResource.getURI()), e);
					}
				}

				return Status.OK_STATUS;
			}
		};
		try {
			// do not execute against the command stack.
			IStatus status = op.execute(new NullProgressMonitor(), changeScope);
			if (!status.isOK()) {
				DeployCorePlugin.log(status);
			}
		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} finally {
			changeScope.close(new NullProgressMonitor());
		}
	}

	/**
	 * Create the location binding resource for export
	 * 
	 * @param topology
	 *           the topology that is exported
	 * @return the location binding created
	 */
	public LocationBinding createLocationBindingForExport(Topology topology) {
		String locFileName = getLocBindingId(topology.getName())
				+ "." + IConstants.LOCBINDING_EXTENSION; //$NON-NLS-1$
		ResourceSet resourceSet = WorkbenchResourceHelperBase.getResourceSet(ProjectUtilities
				.getProject(topology));
		Resource resource = resourceSet.createResource(URI.createFileURI(locFileName));
		final LocationBindingRoot root = LocationFactory.eINSTANCE.createLocationBindingRoot();
		resource.getContents().add(root);
		LocationBinding source = LocationFactory.eINSTANCE.createLocationBinding();
		String topQualifiedName = topology.getQualifiedName();
		source.setName(topology.getName());
		source.setTopology(topQualifiedName);
		root.setLocationBinding(source);
		return source;
	}

	/**
	 * Add a binding entry to the location binding for the deployment object
	 * 
	 * @param locationBinding
	 *           the location binding to add to
	 * @param dmo
	 *           the deployment model object to get the full path for
	 * @param location
	 *           the location for the binding entry
	 */
	public void addBindingEntry(LocationBinding locationBinding, DeployModelObject dmo,
			String location) {
		BindingEntry entry = LocationFactory.eINSTANCE.createBindingEntry();
		entry.setDmoPath(dmo.getFullPath());
		entry.setLocation(location);
		locationBinding.getBindingEntry().add(entry);
	}

	/**
	 * Creates a new location binding resource for export and add entries for all the exported units
	 * artifacts in this topology.
	 * 
	 * @param topology
	 *           the topology to be exported
	 * @param exportedUnits
	 *           the units to be exported
	 * @param out
	 *           the stream for the lcoation binding resource
	 * @throws IOException
	 *            occurs for error in resource creation
	 */
	public void addExportedLocationBinding(Topology topology, List exportedUnits, OutputStream out)
			throws IOException {
		// TODO also add entries for all the artifacts on the capabilities
		// TODO also need to export the files associated with the capabilities????
		String locFileName = getLocBindingId(topology.getName())
				+ "." + IConstants.LOCBINDING_EXTENSION; //$NON-NLS-1$
		ResourceSet resourceSet = WorkbenchResourceHelperBase.getResourceSet(ProjectUtilities
				.getProject(topology));
		Resource resource = resourceSet.createResource(URI.createFileURI(locFileName));
		final LocationBindingRoot root = LocationFactory.eINSTANCE.createLocationBindingRoot();
		resource.getContents().add(root);
		LocationBinding source = LocationFactory.eINSTANCE.createLocationBinding();
		String topQualifiedName = topology.getQualifiedName();
		source.setName(topology.getName());
		source.setTopology(topQualifiedName);
		root.setLocationBinding(source);
		List<BindingEntry> newBindingEntries = source.getBindingEntry();
		for (Iterator iterator = exportedUnits.iterator(); iterator.hasNext();) {
			Unit unit = (Unit) iterator.next();
			List artifactList = unit.getArtifacts();
			for (Iterator iterator2 = artifactList.iterator(); iterator2.hasNext();) {
				Object dmo = iterator2.next();
				if (dmo instanceof FileArtifact) {
					FileArtifact fileArtifact = (FileArtifact) dmo;
					List fileURIList = fileArtifact.getFileURIs();
					for (Iterator iterator3 = fileURIList.iterator(); iterator3.hasNext();) {
						String location = (String) iterator3.next();
						BindingEntry entry = LocationFactory.eINSTANCE.createBindingEntry();
						entry.setDmoPath(fileArtifact.getFullPath());
						entry.setLocation(location);
						newBindingEntries.add(entry);
					}
				}
			}
		}
		root.eResource().save(out, null);
	}

	/**
	 * Bind to the given {@link Topology} to track modification events in case the artifact lists are
	 * accessed or modified.
	 * 
	 * @param topology
	 */
	public void install(final Resource resource) {

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(resource);
		if (domain != null) {
			AbstractEMFOperation op = new AbstractEMFOperation(domain, "Bind Resources") { //$NON-NLS-1$
				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {

					SafeRunner.run(new DeployCoreSafeRunnable() {

						@Override
						public void run() throws Exception {
							LocationBindingAdapter bindingAdapter = LocationBindingAdapter
									.install(resource);
							listeners.add(bindingAdapter);
						}

					});
					return Status.OK_STATUS;
				}
			};
			try {
				// do not execute against command stack
				IStatus status = op.execute(new NullProgressMonitor(), null);
				if (!status.isOK()) {
					DeployCorePlugin.log(status);
				}
			} catch (Exception e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
		} else {
			SafeRunner.run(new ISafeRunnable() {
				public void run() throws Exception {
					LocationBindingAdapter bindingAdapter = LocationBindingAdapter.install(resource);
					listeners.add(bindingAdapter);

				}

				public void handleException(Throwable exception) {
					DeployCorePlugin.logError(0, exception.getMessage(), exception);
				}
			});

		}
	}

	/**
	 * Bind to the given {@link Topology} to track modification events in case the artifact lists are
	 * accessed or modified.
	 * 
	 * @param topology
	 */
	public void uninstall(final Resource resource) {
		final ChangeScope<Topology, DeploymentTopologyDomain> changeScope = ChangeScope
				.createChangeScopeForWrite(WorkbenchResourceHelper.getFile(resource));
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(), "Bind Resources") { //$NON-NLS-1$
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				LocationBindingAdapter.uninstall(resource);

				return Status.OK_STATUS;
			}
		};
		try {
			// do not execute against command stack
			IStatus status = op.execute(new NullProgressMonitor(), changeScope);
			if (!status.isOK()) {
				DeployCorePlugin.log(status);
			}
		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} finally {
			changeScope.close(new NullProgressMonitor());
		}
	}

	public IFile resolveBindingFile(IFile topologyFile) {
		String topologyName = DeploymentTopologyDomain.getTopologyName(topologyFile);
		String locBindingId = getLocBindingId(topologyName);
		return topologyFile.getParent().getFile(
				new Path(locBindingId + IConstants.DOT_SEPARATOR + IConstants.LOCBINDING_EXTENSION));
	}

	private void fireNotification() {
		Object[] data = listeners.getListeners();
		for (int i = 0; i < data.length; i++) {
			LocationBindingAdapter adapter = (LocationBindingAdapter) data[i];
			adapter.onChange();
		}

	}

	/**
	 * Check if location binding is in use for the given topology. This method returns true if a
	 * location binding resource with the id in the domain exists.
	 * 
	 * @param topology
	 *           the input topology
	 * @return true if location binding is in use
	 */

	public boolean isLocationBindingUsage(Topology topology) {

		if (topology != null) {
			Resource resource = topology.eResource();
			if (resource != null) {
				return isLocationBindingUsage(resource);
			}
		}
		return false;
	}

	/**
	 * Check if location binding is in use for the given topology. This method returns true if a
	 * location binding resource with the id in the domain exists.
	 * 
	 * @param topologyResource
	 *           the input topology resource
	 * @return true if location binding is in use
	 */

	public boolean isLocationBindingUsage(Resource topologyResource) {

		if (topologyResource != null) {
			IFile file = WorkbenchResourceHelperBase.getIFile(topologyResource.getURI());
			if (file != null) {
				return isLocationBindingUsage(file);
			}
		}
		return false;
	}

	/**
	 * Check if location binding is in use for the given topology. This method returns true if a
	 * location binding resource with the id in the domain exists.
	 * 
	 * @param topologyFile
	 *           the input topology file
	 * @return true if location binding is in use
	 */

	public boolean isLocationBindingUsage(IFile topologyFile) {

		if (topologyFile != null) {
			IFile locationFile = resolveBindingFile(topologyFile);
			if (locationFile != null) {
				return locationFile.exists();
			}
		}
		return false;
	}

	/**
	 * This API is used to determine if location binding is in use.
	 * 
	 * @return true, if there is location binding usage
	 */
	/*
	 * public boolean isLocationBindingUsage() { return locationBindingUsage; }
	 */

	/**
	 * set the location binding usage
	 * 
	 * @param locbindingUsage
	 *           the location binding usage to set
	 */
	/*
	 * public void setLocationBindingUsage(boolean locbindingUsage) {
	 * 
	 * boolean oldValue = locationBindingUsage; locationBindingUsage = locbindingUsage; if (oldValue !=
	 * locationBindingUsage) { fireNotification(); } }
	 */
}
