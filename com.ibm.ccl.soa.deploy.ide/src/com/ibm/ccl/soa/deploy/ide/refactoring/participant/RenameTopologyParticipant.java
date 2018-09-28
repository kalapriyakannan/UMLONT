package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameEMFResourceChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameTopologyChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramElementsChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateTopologyImportsChange;
import com.ibm.ccl.soa.deploy.index.search.Query;

public class RenameTopologyParticipant extends RenameParticipant {

	private RenameTopologyDescriptor dataModel;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws OperationCanceledException {
		monitor.beginTask(Messages.RenameTopologyProcessor_Check_final_conditions_, 1);
		RefactoringStatus status = new RefactoringStatus();

		try {

			status = RefactoringStatus.create(dataModel.validate());

			if (status.isOK()) {
				List<IEditorPart> editors = RefactoringUtils.findDirtyEditors(ResourcesPlugin
						.getWorkspace().getRoot().getFile(new Path(dataModel.getTopology())));
				for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
							Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, iter.next()
									.getTitle())));
				}
			}

		} finally {
			monitor.done();
		}

		return status;
	}

	@Override
	public String getName() {
		return Messages.RenameTopologyProcessor_Rename_Topolog_;
	}

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
					RenameTopologyDescriptor descriptor = RenameTopologyDescriptor.createModel();
					descriptor.setName(file.getParent().getFullPath().append(
							super.getArguments().getNewName()).toString());
					descriptor.setTopology(file.getFullPath().toString());
					dataModel = descriptor;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		pm.beginTask("", 1); //$NON-NLS-1$

		CoreCompositeChange changes = new CoreCompositeChange(
				Messages.RenameTopologyProcessor_Rename_Topology_Change_);

		try {

			IFile topology = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(dataModel.getTopology()));
			Topology aTopology = dataModel.getTopology(topology);

			RenameTopologyChange renameTopology = RenameTopologyChange.createModel();
			renameTopology.setSource(topology.getFullPath());
			renameTopology.setDestination(new Path(dataModel.getName()));

			changes.add(renameTopology);

			// find all imports of this model in other topology models
			Collection<IFile> importingModels = Query.findImportingTopologyReferences(aTopology, null,
					true, false, true, false, pm);
			for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
				IFile resource = iter.next();

				UpdateTopologyImportsChange updateImports = UpdateTopologyImportsChange.createModel();
				updateImports.setModel(resource.getFullPath());
				updateImports.setSource(aTopology.getQualifiedName());
				updateImports.setDestination(renameTopology.getNewQualifiedName());

				changes.add(updateImports);
			}

			// find all diagrams associated with this topology
			Collection<IFile> diagrams = Query.findReferencingDiagramResources(aTopology, null, true,
					false, true, false, pm);
			for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {
				IFile resource = iter.next();

				UpdateDiagramElementsChange updateElements = UpdateDiagramElementsChange.createModel();
				updateElements.setDiagram(resource.getFullPath());
				updateElements.setSource(topology.getFullPath());
				updateElements.setDestination(new Path(dataModel.getName()));

				changes.add(updateElements);
			}

			// find all diagrams associated with topology models that import this topology
			for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
				IFile resource = iter.next();
				Collection<IFile> theDiagrams = Query.findReferencingDiagramResources(dataModel
						.getTopology(resource), null, true, false, true, false, pm);
				for (Iterator<IFile> anIter = theDiagrams.iterator(); anIter.hasNext();) {
					IFile aResource = anIter.next();

					UpdateDiagramImportsChange updateImports = UpdateDiagramImportsChange.createModel();
					updateImports.setDiagram(aResource.getFullPath());
					updateImports.setModel(resource.getFullPath());
					updateImports.setSource(aTopology.getQualifiedName());
					updateImports.setDestination(renameTopology.getNewQualifiedName());

					changes.add(updateImports);
				}
			}

			// find the "default" diagram for this topology and rename it so that it matches the renamed topology
			IPath defaultDiagram = topology.getFullPath().removeFileExtension().addFileExtension(
					IConstants.TOPOLOGYV_EXTENSION);
			IFile diagram = ResourcesPlugin.getWorkspace().getRoot().getFile(defaultDiagram);
			if (diagram.exists()) {
				IPath newDiagramPath = new Path(dataModel.getName()).removeFileExtension()
						.addFileExtension(IConstants.TOPOLOGYV_EXTENSION);
				RenameEMFResourceChange renameResource = RenameEMFResourceChange.createModel();
				renameResource.setSource(diagram.getFullPath());
				renameResource.setDestination(newDiagramPath);

				changes.add(renameResource);
			}

		} finally {
			pm.done();
		}

		return changes;
	}

	public RenameTopologyDescriptor getDataModel() {
		return dataModel;
	}
}
