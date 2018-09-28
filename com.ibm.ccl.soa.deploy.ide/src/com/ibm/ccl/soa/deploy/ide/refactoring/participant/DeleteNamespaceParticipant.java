package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteDiagramChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteDiagramImportChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteImportChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteTopologyChange;
import com.ibm.ccl.soa.deploy.index.search.Query;

public class DeleteNamespaceParticipant extends DeleteParticipant {

	private DeleteNamespaceDescriptor dataModel;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws OperationCanceledException {
		monitor.beginTask(Messages.RenameTopologyProcessor_Check_final_conditions_, 1);
		RefactoringStatus status = new RefactoringStatus();

		try {

			status = RefactoringStatus.create(dataModel.validate());

			if (status.isOK()) {
				INamespaceFragment namespace = NamespaceCore.findNamespace(dataModel
						.getNamespaceContainer().getProject(), dataModel.getNamespaceContainer());
				List<IEditorPart> editors = RefactoringUtils.findDirtyEditors(namespace, true);
				for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
					IEditorPart editor = iter.next();
					if (editor.isDirty()) {
						status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
								Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, editor
										.getTitle())));
					}
				}
			}

			if (status.isOK()) {
				INamespaceFragment namespace = NamespaceCore.findNamespace(dataModel
						.getNamespaceContainer().getProject(), dataModel.getNamespaceContainer());
				if (namespace.containsSubNamespaces()) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.WARNING, NLS.bind(
							Messages.DeleteNamespaceParticipant_The_namespace_0_contains_sub_, namespace
									.getQualifiedName())));
				}
			}

		} catch (CoreException ex) {
			status.addEntry(new RefactoringStatusEntry(RefactoringStatus.FATAL, ex.getMessage()));
		} finally {
			monitor.done();
		}

		return status;
	}

	@Override
	public String getName() {
		return Messages.DeleteNamespaceParticipant_Delete_Namespac_;
	}

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FOLDER) {
				IFolder folder = (IFolder) resource;
				INamespaceFragmentRoot root = NamespaceCore.getRoot(folder);
				if (null != root) {
					String[] namespaceSegments = TopologyNamespaceUtil.getNamespacePath(root
							.getCorrespondingResource().getFullPath().segments(), folder.getFullPath()
							.segments());
					String namespacePath = TopologyNamespaceUtil.concatWith(namespaceSegments,
							IConstants.DOT_SEPARATOR);
					INamespaceFragment namespace = root.getNamespaceFragment(namespacePath);
					if (null != namespace && namespace.exists()) {
						DeleteNamespaceDescriptor descriptor = DeleteNamespaceDescriptor.createModel();
						descriptor
								.setSourcePath(root.getCorrespondingResource().getFullPath().toString());
						descriptor.setNamespacePath(namespacePath);
						dataModel = descriptor;
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public Change createChange(IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		monitor.beginTask("", 1); //$NON-NLS-1$

		CoreCompositeChange changes = new CoreCompositeChange(
				Messages.DeleteNamespaceParticipant_Delete_Namespace_Change_);

		try {

			INamespaceFragment namespace = NamespaceCore.findNamespace(dataModel.getSourceContainer()
					.getProject(), dataModel.getNamespacePath());
			IContainer container = namespace.getRoot().getCorrespondingResource(namespace);

			final List<IFile> topologies = new ArrayList();
			container.accept(new IResourceVisitor() {

				public boolean visit(IResource resource) /* throws CoreException */{
					switch (resource.getType())
					{
					case IResource.FILE:
						if (IConstants.TOPOLOGY_EXTENSION.equals(resource.getFileExtension())) {
							if (!topologies.contains(resource)) {
								topologies.add((IFile) resource);
							}
						}
					}

					// Recurse
					return true;
				}
			}, IResource.DEPTH_INFINITE, IResource.FILE);

			for (Iterator<IFile> iter = topologies.iterator(); iter.hasNext();) {
				createDeleteTopologyChanges(changes, iter.next(), monitor);
			}

		} finally {
			monitor.done();
		}

		return changes.getChildren().length == 0 ? new NullChange(
				Messages.DeleteNamespaceParticipant_Delete_Namespace_Change_) : changes;
	}

	public void createDeleteTopologyChanges(CoreCompositeChange changes, IFile topology,
			IProgressMonitor monitor) throws CoreException {

		INamespaceFragment namespace = NamespaceCore.findNamespace(dataModel.getSourceContainer()
				.getProject(), dataModel.getNamespacePath());
		IContainer container = namespace.getRoot().getCorrespondingResource(namespace);
		Topology aTopology = dataModel.getTopology(topology);

		if (null == aTopology) {
			// invalid topology cannot determine dependencies on this topology from other topologies
			// no changes will be applied by this participant specific to deployment topologies
			return;
		}

		// find all imports of this model in other topology models and create change objects
		// to delete them from the topology models
		Collection<IFile> importingModels = Query.findImportingTopologyReferences(aTopology, null,
				true, false, true, false, monitor);
		for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
			IFile resource = iter.next();

			IPath path = resource.getProjectRelativePath();
			// only create delete import changes for models that are not going to be deleted by this change
			if (path.matchingFirstSegments(container.getProjectRelativePath()) != container
					.getProjectRelativePath().segmentCount()) {

				DeleteImportChange deleteImport = DeleteImportChange.createModel();
				deleteImport.setTopology(resource);
				deleteImport.setImportedTopology(topology);

				changes.add(deleteImport);
			}
		}

		// find all diagrams associated with this topology and create change objects to
		// delete them from the workspace
		Collection<IFile> diagrams = Query.findReferencingDiagramResources(aTopology, null, true,
				false, true, false, monitor);
		for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {
			IFile resource = iter.next();

			DeleteDiagramChange deleteDiagram = DeleteDiagramChange.createModel();
			deleteDiagram.setDiagram(resource.getFullPath());

			changes.add(deleteDiagram);
		}

		// find all diagrams associated with topology models that import this topology
		// and create change objects to delete any views that utilize the imported topology
		for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
			Topology importingModel = dataModel.getTopology(iter.next());
			Collection<IFile> theDiagrams = Query.findReferencingDiagramResources(importingModel,
					null, true, false, true, false, monitor);
			for (Iterator<IFile> anIter = theDiagrams.iterator(); anIter.hasNext();) {
				IFile diagram = anIter.next();

				IPath path = diagram.getProjectRelativePath();
				// only create delete diagram import changes for diagrams that are not going to be deleted by this change
				if (path.matchingFirstSegments(container.getProjectRelativePath()) != container
						.getProjectRelativePath().segmentCount()) {

					DeleteDiagramImportChange deleteImport = DeleteDiagramImportChange.createModel();
					deleteImport.setDiagram(diagram);
					deleteImport.setImportedTopology(topology);

					changes.add(deleteImport);
				}
			}
		}

		DeleteTopologyChange deleteTopology = DeleteTopologyChange.createModel();
		deleteTopology.setTopology(topology.getFullPath());

		changes.add(deleteTopology);
	}

	public DeleteNamespaceDescriptor getDataModel() {
		return dataModel;
	}
}
