package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * <p>
 * Implementation of Saveable that represents a topology artifact. This implementation allows for
 * all related topology artifacts to be saved and closed as a single unit of work. This is
 * accomplished by using the IEditModelScribbler that is passed in during construction. All files
 * passed in during construction are loaded through the passed in scribbler essentially binding them
 * together. A call to the doSave() method on this class will call the save() method on the passed
 * in scribbler. A call to the close() method on this class will result in a call to the close()
 * mehtod on the passed in scribbler.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class TopologySaveable extends Saveable {

	private final Object lock = new Object();
	private boolean closed = false;
	private IEditModelScribbler scribbler;
	private IResource openedOn;
	private final List<IFile> previousModels = new ArrayList<IFile>();

	/**
	 * <p>
	 * Creates an instance of TopologySaveable.
	 * </p>
	 * 
	 * @param openedOn
	 *           Distinguishes the IFile artifact that this topology saveable was opened for.
	 * @param artifacts
	 *           The associated topology artifacts that should be bound to this savable.
	 * @param scribbler
	 *           The IEditModelScribbler that will be used to bind these artifacts.
	 */
	public TopologySaveable(IResource[] artifacts) {
		this(Arrays.asList(artifacts));
	}

	/**
	 * <p>
	 * Creates an instance of TopologySaveable.
	 * </p>
	 * 
	 * @param openedOn
	 *           Distinguishes the IFile artifact that this topology saveable was opened for.
	 * @param artifacts
	 *           The associated topology artifacts that should be bound to this savable.
	 * @param scribbler
	 *           The IEditModelScribbler that will be used to bind these artifacts.
	 */
	public TopologySaveable(List<IResource> artifacts) {

		assert artifacts != null;
		assert artifacts.size() > 0;

		try {
			scribbler = IEditModelFactory.eINSTANCE.createScribblerForWrite(artifacts.get(0)
					.getProject(), new TopologySaveableDomain(artifacts));
		} catch (EditModelException ex) {
			DeployCoreUIPlugin.logError(0, ex.toString(), ex);
			closed = true;
		}

		IFile model = null;
		Resource loadedResource = null;
		for (Iterator<IResource> iter = artifacts.iterator(); iter.hasNext() && null == model;) {
			IResource resource = iter.next();
			if (resource.getType() == IResource.FILE) {

				// pre-load the resource so it's not loaded, unloaded, and re-loaded
				if (IConstants.TOPOLOGYV_EXTENSION.equals(resource.getFileExtension())) {
					loadedResource = getScribbler().getResource((IFile) resource);
					model = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(loadedResource);
				} else if (IConstants.TOPOLOGY_EXTENSION.equals(resource.getFileExtension())) {
					model = (IFile) resource;
				}
			}
		}

		if (null != model) {
			openedOn = model;
		} else {
			openedOn = artifacts.get(0);
		}
	}

	public IResource getOpenedOn() {
		return openedOn;
	}

	public void setOpenedOn(IResource openedOn) {
		if (this.openedOn != null && this.openedOn.getType() == IResource.FILE) {
			previousModels.add((IFile) this.openedOn);
			this.openedOn = openedOn;
		} else if (this.openedOn == null) {
			this.openedOn = openedOn;
		}
	}

	public void addPreviousModel(IFile model) {
		if (!previousModels.contains(model)) {
			previousModels.add(model);
		}
	}

	/**
	 * <p>
	 * Adds a artifact to this saveable.
	 * </p>
	 * 
	 * @param artifact
	 *           the artifact to be added.
	 */
	public void addArtifact(IFile artifact) {
		bindToScribbler(artifact, scribbler);
	}

	public void removeArtifact(IFile artifact) {
		unbindFromScribbler(artifact, scribbler);
	}

	/**
	 * <p>
	 * Returns a list of all artifacts that are bound to this saveable.
	 * </p>
	 * 
	 * @return a List of IFile handles representing the artifacts bound to this saveable.
	 */
	public List<IFile> getArtifacts() {

		List<IFile> artifacts = new ArrayList<IFile>();

//		if (!isOpen()) {
//			return artifacts;
//		}

		TopologySaveableDomain domain = (TopologySaveableDomain) scribbler.getScribblerDomain();
		IResource[] resources = domain.getResources();
		for (int i = 0; i < resources.length; i++) {
			IResource resource = resources[i];
			if (resource.getType() == IResource.FILE) {
				if (!artifacts.contains(resource)) {
					artifacts.add((IFile) resource);
				}
			}
		}

		return artifacts;
	}

	/**
	 * <p>
	 * Returns a list of all model artifacts bound to this saveable.
	 * </p>
	 * 
	 * @return a List of IFile handles representing the model artifacts bound to this saveable.
	 */
	public List<IFile> getModelArtifacts() {

		List<IFile> models = new ArrayList<IFile>();
		List<IFile> artifacts = getArtifacts();
		for (Iterator<IFile> iter = artifacts.iterator(); iter.hasNext();) {
			IFile artifact = iter.next();
			if (IConstants.TOPOLOGY_EXTENSION.equals(artifact.getFileExtension())) {
				if (!models.contains(artifact)) {
					models.add(artifact);
				}
			}
		}

		return models;
	}

	/**
	 * <p>
	 * Returns a list of all diagram artifacts bound to this saveable.
	 * </p>
	 * 
	 * @return a List of IFile handles representing the diagram artifacts bound to this saveable.
	 */
	public List<IFile> getDiagramArtifacts() {

		List<IFile> diagrams = new ArrayList<IFile>();
		List<IFile> artifacts = getArtifacts();
		for (Iterator<IFile> iter = artifacts.iterator(); iter.hasNext();) {
			IFile artifact = iter.next();
			if (IConstants.TOPOLOGYV_EXTENSION.equals(artifact.getFileExtension())) {
				if (!diagrams.contains(artifact)) {
					diagrams.add(artifact);
				}
			}
		}

		return diagrams;
	}

	/**
	 * <p>
	 * Returns the IEditModelScribbler that was passed in during the construction of this saveable.
	 * </p>
	 * 
	 * @return an IEditModelScribbler that was passed in during the construction of this saveable.
	 */
	public IEditModelScribbler getScribbler() {
		return scribbler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor aMonitor) throws CoreException {
		IProgressMonitor monitor = new SubProgressMonitor(
				aMonitor == null ? new NullProgressMonitor() : aMonitor, 2);
		monitor.beginTask(NLS.bind(Messages.TopologySaveable_Saving_changes_to_the_0_model_,
				getName()), 2);

		final IStatus[] result = new IStatus[1];

		try {
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

				public void run(IProgressMonitor monitor) throws CoreException {
					IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE
							.getContext(getArtifacts().get(0).getProject());
					ResourceSet resourceSet = context.getResourceSet();
					TransactionalEditingDomain txdomain = TransactionalEditingDomain.Factory.INSTANCE
							.getEditingDomain(resourceSet);

					if (txdomain == null) {
						txdomain = TransactionalEditingDomain.Factory.INSTANCE
								.createEditingDomain(resourceSet);
					}

					IUndoableOperation operation = new AbstractEMFOperation(txdomain, NLS.bind(
							Messages.TopologySaveable_Save_Changes_to_0_Model_, getName())) {

						@Override
						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {

							try {
								scribbler.save(true, monitor);
							} catch (EditModelException ex) {
								throw new ExecutionException(ex.getMessage(), ex);
							} catch (IllegalStateException ex) {
								throw new ExecutionException(ex.getMessage(), ex);
							} finally {
								monitor.worked(1);
							}

							return Status.OK_STATUS;
						}

					};

					try {
						// changed rule from PlatformUI.getWorkbench()
						result[0] = operation.execute(monitor, ResourcesPlugin.getWorkspace().getRoot());
						if (result[0].isOK()) {
							// if save was sucessfull we need to announce the succuessful save to the artifact monitor
							Resource[] resources = scribbler.getSortedResources();
							for (int i = 0; i < resources.length; i++) {
								final Resource resource = resources[i];
								SafeRunner.run(new ISafeRunnable() {
									public void run() throws Exception {
										TopologyArtifactsMonitor.INSTANCE.resourceSaved(resource);
									}

									public void handleException(Throwable ex) {
										DeployCoreUIPlugin.logError(0, ex.toString(), ex);
									}
								});
							}
						} else {
							ErrorDialog.openError((Shell) PlatformUI.getWorkbench()
									.getAdapter(Shell.class), Messages.TopologySaveable_Error_Occurre_, NLS
									.bind(Messages.TopologySaveable_Unable_to_execute_operation_0_,
											operation.getLabel()), result[0]);
							throw new CoreException(new Status(IStatus.ERROR,
									DeployCoreUIPlugin.PLUGIN_ID, result[0].getMessage(), result[0]
											.getException()));
						}

					} catch (Exception ex) {
						throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
								ex.toString(), ex));
					}
				}

			}, monitor);

		} finally {
			monitor.worked(1);
		}
	}

	/**
	 * <p>
	 * Closes this saveable by calling the IEditModelScribbler's close method. If the scribbler is
	 * dirty and the force parameter is set to false the user will be prompted to save changes before
	 * closing.
	 * </p>
	 * 
	 * 
	 * @param force
	 *           boolean indicating if the user should be prompted to save changes if any of the
	 *           artifacts are dirty.
	 * @param aMonitor
	 *           an IProgressMonitor used to show progress to the user.
	 * @return boolean idicating if the close occurred.
	 * @throws CoreException
	 */
	public boolean close(final boolean force, IProgressMonitor aMonitor) throws CoreException {
		return close(force, false, aMonitor);
	}

	/**
	 * <p>
	 * Closes this saveable by calling the IEditModelScribbler's close method. If the scribbler is
	 * dirty and the force parameter is set to false the user will be prompted to save changes before
	 * closing.
	 * </p>
	 * 
	 * 
	 * @param force
	 *           boolean indicating if the user should be prompted to save changes if any of the
	 *           artifacts are dirty.
	 * @param aMonitor
	 *           an IProgressMonitor used to show progress to the user.
	 * @return boolean idicating if the close occurred.
	 * @throws CoreException
	 */
	public boolean close(final boolean force, boolean allowReadOnlyUnload, IProgressMonitor aMonitor)
			throws CoreException {

		if (isOpen()) {
			List<Resource> resources = new ArrayList<Resource>();

			synchronized (lock) {

				IProgressMonitor monitor = new SubProgressMonitor(
						aMonitor == null ? new NullProgressMonitor() : aMonitor, 2);
				monitor.beginTask(NLS.bind(Messages.TopologySaveable_Closing_0_Model_, getName()), 2);

				try {

					IStatus status = Status.OK_STATUS;

					try {
						int returnCode = 1;
						Display display = Display.getCurrent() != null ? Display.getCurrent() : Display
								.getDefault();
						if (display != null && scribbler.isDirty() && force) {
							monitor.setTaskName(Messages.TopologyArtifactsMonitor_Closing_model_);
							MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell(),
									Messages.TopologySaveable_Unsaved_Change_, null, NLS.bind(
											Messages.TopologySaveable_Would_you_like_to_save_your_changes_,
											TopologySaveable.this.getName()), MessageDialog.QUESTION,
									new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL,
											IDialogConstants.CANCEL_LABEL }, 0);
							returnCode = dialog.open();
						}

						switch (returnCode)
						{
						case 0: // YES_LABEL from index passed into message dialog above
							scribbler
									.setUserInterfaceController(new AutoResponseHumanInteractionController(
											true));
							doSave(monitor);
							if (monitor.isCanceled()) {
								status = Status.CANCEL_STATUS;
							}
							break;

						case 1: // NO_LABEL from index passed into message dialog above
							scribbler
									.setUserInterfaceController(new AutoResponseHumanInteractionController(
											false));
							break;

						case 2: // CANCEL_LABEL from index passed into message dialog above
							status = Status.CANCEL_STATUS;
							break;

						}
					} catch (IllegalStateException ex) {
						DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
						status = Status.CANCEL_STATUS;
					} catch (CoreException ex) {
						DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
						status = ex.getStatus();
					} finally {
						monitor.worked(1);
					}

					if (!status.isOK()) {
						if (status.getSeverity() == IStatus.ERROR) {
							ErrorDialog.openError((Shell) PlatformUI.getWorkbench(),
									Messages.TopologySaveable_Error_Occurre_, NLS.bind(
											Messages.TopologySaveable_Unable_to_execute_operation_0_, NLS
													.bind(Messages.TopologySaveable_Close_0_Model_, getName())),
									status);
						}
						return false;
					}

					resources = new ArrayList<Resource>();
					resources.addAll(Arrays.asList(scribbler.getSortedResources()));

					if (status != Status.CANCEL_STATUS) {
						if (!scribbler.isClosed()) {
							scribbler.close(allowReadOnlyUnload, monitor);
						}
						closed = true;
					}

				} catch (Exception ex) {
					DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
					if (isOpen()) {
						return false;
					}
				} finally {
					monitor.worked(1);
				}

			}

			if (closed && force) {
				for (Iterator<Resource> iter = resources.iterator(); iter.hasNext();) {
					final Resource resource = iter.next();
					SafeRunner.run(new ISafeRunnable() {
						public void run() throws Exception {
							TopologyArtifactsMonitor.INSTANCE.resourceUnloaded(resource);
						}

						public void handleException(Throwable ex) {
							DeployCoreUIPlugin.logError(0, ex.toString(), ex);
						}
					});
				}
			}
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		List<IFile> models = getModelArtifacts();
		if (models != null && models.size() > 0) {
			return models.get(0).getName();
		} else {
			List<IFile> diagrams = getDiagramArtifacts();
			if (diagrams != null && diagrams.size() > 0) {
				return diagrams.get(0).getName();
			} else {
				return getArtifacts().get(0).getName();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getToolTipText() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {

		if (!isOpen()) {
			return false;
		}

		return scribbler.isDirty();
	}

	/**
	 * <p>
	 * Determines the dirty state of the passed in IFile. If this saveable has been previously closed
	 * this method will always return false.
	 * </p>
	 * 
	 * @param file
	 * @return
	 */
	public boolean isDirty(IFile file) {
		if (!isOpen()) {
			return false;
		}

		if (getArtifacts().contains(file)) {
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
			if (file.getProject().isAccessible() && file.exists()) {
				Resource[] resources = scribbler.getSortedResources();
				for (int r = 0; r < resources.length; r++) {
					Resource resource = resources[r];
					if (uri.equals(resource.getURI())) {
						if (resource.isModified()) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	/**
	 * <p>
	 * Reports the open/closed state for this saveable. Once the close() method has been called and
	 * returns true, this saveable will be unable to be saved or closed again.
	 * </p>
	 * 
	 * @return
	 */
	public boolean isOpen() {
		synchronized (lock) {
			if (closed) {
				return false;
			}
		}

		return true;
	}

	public boolean isManaged(IFile file) {

		for (Iterator<IFile> iter = getArtifacts().iterator(); iter.hasNext();) {
			IFile artifact = iter.next();
			if (artifact.getFullPath().equals(file.getFullPath())) {
				return true;
			}
		}

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
		List<Resource> resources = Arrays.asList(scribbler.getSortedResources());
		for (Iterator<Resource> iter = resources.iterator(); iter.hasNext();) {
			Resource resource = iter.next();
			if (uri.equals(resource.getURI())) {
				return true;
			}
		}

		return false;
	}

	protected void bindToScribbler(IFile file, IEditModelScribbler scribbler) {
		if (!isOpen()) {
			return;
		}

		if (null != scribbler && !scribbler.isClosed() && file.getProject().isAccessible()
				&& file.isAccessible()) {
			TopologySaveableDomain domain = (TopologySaveableDomain) scribbler.getScribblerDomain();
			domain.addResource(file);
			scribbler.getResource(file, IEditModelScribbler.OPTION_NONE);
		}
	}

	protected void unbindFromScribbler(IFile file, IEditModelScribbler scribbler) {
		if (!isOpen()) {
			return;
		}

		if (null != scribbler && !scribbler.isClosed()) {
			TopologySaveableDomain domain = (TopologySaveableDomain) scribbler.getScribblerDomain();
			domain.removeResource(file);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime * (openedOn == null ? 0 : openedOn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TopologySaveable other = (TopologySaveable) obj;
		if (openedOn == null) {
			if (other.openedOn != null) {
				return false;
			}
		} else if (!openedOn.equals(other.openedOn)) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "[Name: " + getName() + "]" + System.getProperty("line.separator") + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"[isDirty: " //$NON-NLS-1$
				+ this.isDirty() + "]" + System.getProperty("line.separator") + //$NON-NLS-1$ //$NON-NLS-2$
				"[isOpen: " + this.isOpen() + "]" + System.getProperty("line.separator") + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"[openedOn: " + openedOn + "]" + System.getProperty("line.separator") + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"[previousModels: " + previousModels + "]" + System.getProperty("line.separator") + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"[models: " //$NON-NLS-1$
				+ getModelArtifacts() + "]" + System.getProperty("line.separator") + //$NON-NLS-1$ //$NON-NLS-2$
				"[diagrams: " + getDiagramArtifacts() //$NON-NLS-1$
				+ "]" + System.getProperty("line.separator"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Return the Topology associated with this saveable model.
	 * 
	 * @return The Topology associated with this saveable model.
	 */
	public Topology getTopology() {

		if (isOpen()) {
			List<IFile> modelArtifacts = getModelArtifacts();
			if (modelArtifacts.size() > 0) {
				Resource resource = getScribbler().getResource(modelArtifacts.get(0),
						IEditModelScribbler.OPTION_NONE);
				if (null != resource && resource.getContents().size() > 0
						&& resource.getContents().get(0) instanceof DeployCoreRoot) {
					DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
					return root.getTopology();
				}
			}
		}
		return null;
	}

}
