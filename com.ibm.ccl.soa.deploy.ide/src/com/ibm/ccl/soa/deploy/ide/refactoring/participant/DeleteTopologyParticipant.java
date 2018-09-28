package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteDiagramChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteDiagramImportChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteImportChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteTopologyChange;
import com.ibm.ccl.soa.deploy.index.search.Query;

public class DeleteTopologyParticipant extends DeleteParticipant {

	private DeleteTopologyDescriptor dataModel;

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
		return Messages.DeleteTopologyParticipant_Delete_Topolog_;
	}

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
					DeleteTopologyDescriptor descriptor = DeleteTopologyDescriptor.createModel();
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
				Messages.DeleteTopologyParticipant_Delete_Topology_Change_);

		try {

			IFile topology = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(dataModel.getTopology()));
			Topology aTopology = dataModel.getTopology(topology);

			if (null == aTopology) {
				// invalid topology cannot determine dependencies on this topology from other topologies
				// no changes will be applied by this participant specific to deployment topologies
				return null;
			}

			// find all imports of this model in other topology models and create change objects
			// to delete them from the topology models
			Collection<IFile> importingModels = Query.findImportingTopologyReferences(aTopology, null,
					true, false, true, false, pm);
			for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
				IFile resource = iter.next();

				DeleteImportChange deleteImport = DeleteImportChange.createModel();
				deleteImport.setTopology(resource);
				deleteImport.setImportedTopology(topology);

				changes.add(deleteImport);
			}

			// find all diagrams associated with this topology and create change objects to
			// delete them from the workspace
			Collection<IFile> diagrams = Query.findReferencingDiagramResources(aTopology, null, true,
					false, true, false, pm);
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
						null, true, false, true, false, pm);
				for (Iterator<IFile> anIter = theDiagrams.iterator(); anIter.hasNext();) {
					IFile diagram = anIter.next();

					DeleteDiagramImportChange deleteImport = DeleteDiagramImportChange.createModel();
					deleteImport.setDiagram(diagram);
					deleteImport.setImportedTopology(topology);

					changes.add(deleteImport);
				}
			}

			DeleteTopologyChange deleteTopology = DeleteTopologyChange.createModel();
			deleteTopology.setTopology(topology.getFullPath());

			changes.add(deleteTopology);

		} finally {
			if (dataModel != null) {
				dataModel.dispose();
			}
			pm.done();
		}

		return changes;
	}

	public DeleteTopologyDescriptor getDataModel() {
		return dataModel;
	}
}
